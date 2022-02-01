package com.tencent.ilinkservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.google.protobuf.InvalidProtocolBufferException;
import com.ilink.interfaces.Profile;
import com.tencent.ilink.tdi.b.s;
import com.tencent.ilink.tdi.b.s.a;
import com.tencent.ilink.tdi.b.z;
import com.tencent.ilink.tdi.y;
import com.tencent.luggage.wxa.aq.a.b;
import com.tencent.luggage.wxa.aq.a.b.a;
import com.tencent.mars.ilink.comm.NetStatusUtil;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.mars.ilink.xlog.Log;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class IlinkService
  extends Service
  implements IlinkServiceTdiCallback.a, aa.a, z.a
{
  private static final int INVOKE_DEVICECALLBACK_TASK = 3;
  private static final int INVOKE_LOCAL_TASK = 4;
  private static final int INVOKE_TDICALLBACK_TASK = 2;
  private static final String TAG = "IlinkService";
  private static final int TEST_TIMER_TASK = 1;
  public static final int m_service_version_ = 33554959;
  private IBinder mBinder = new IlinkService.2(this);
  private IlinkService.d mServiceHandler;
  private Looper mServiceLooper;
  private ConcurrentHashMap<String, Vector<String>> m_appid_clonecaller_map_ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> m_appid_cloneticket_map_ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, IlinkService.f> m_appid_tdisession_map_ = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> m_caller_cookie_map_ = new ConcurrentHashMap();
  private String m_file_dir_;
  private aa m_ilink_im_manager_ = null;
  private ag.f m_ilink_init_param_ = null;
  private z m_ilink_manager_ = null;
  private boolean m_login_running = true;
  private boolean m_login_state_ = false;
  private byte[] m_profile_;
  private final IlinkService.b m_remote_callback_list_ = new IlinkService.b(this, null);
  private IlinkService m_service_obj_ = this;
  private HandlerThread m_task_thread_;
  private b.s m_tdi_init_param_;
  private ConcurrentHashMap<Integer, String> m_tdi_taskid_caller_map_ = new ConcurrentHashMap();
  private int m_test_count_ = 0;
  TimerTask m_testtask = new IlinkService.1(this);
  private Timer m_timer = new Timer();
  private String m_token_;
  
  private static String GeneralCookie(String paramString)
  {
    double d1 = new Random().nextDouble();
    double d2 = Math.pow(10.0D, 10.0D);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append((d1 + 1.0D) * d2);
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    for (;;)
    {
      int i;
      try
      {
        localObject = MessageDigest.getInstance("SHA-256");
        ((MessageDigest)localObject).update(paramString.getBytes());
        localObject = ((MessageDigest)localObject).digest();
        localStringBuilder = new StringBuilder();
        int j = localObject.length;
        i = 0;
        if (i < j)
        {
          int k = localObject[i] & 0xFF;
          if (Integer.toHexString(k).length() == 1)
          {
            localStringBuilder.append("0");
            localStringBuilder.append(Integer.toHexString(k));
          }
          else
          {
            localStringBuilder.append(Integer.toHexString(k));
          }
        }
        else
        {
          localObject = localStringBuilder.toString();
          return localObject;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("no such algorithm:");
        localStringBuilder.append(localNoSuchAlgorithmException.toString());
        Log.e("IlinkService", localStringBuilder.toString());
        localNoSuchAlgorithmException.printStackTrace();
        return paramString;
      }
      i += 1;
    }
  }
  
  private boolean isAppIdBelongToCaller(String paramString1, String paramString2)
  {
    if (this.m_appid_tdisession_map_.containsKey(paramString1))
    {
      if (((IlinkService.f)this.m_appid_tdisession_map_.get(paramString1)).a.equals(paramString2)) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" not belong to caller:");
      localStringBuilder.append(paramString2);
      Log.e("IlinkService", localStringBuilder.toString());
      return false;
    }
    Log.e("IlinkService", "appid not exit");
    return false;
  }
  
  private boolean isCallerLegal(String paramString1, String paramString2)
  {
    return (this.m_caller_cookie_map_.containsKey(paramString1)) && (((String)this.m_caller_cookie_map_.get(paramString1)).equals(paramString2));
  }
  
  public void OnLocalRequestUploadLogfiles(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnLocalRequestUploadLogfiles:");
    ((StringBuilder)localObject).append(paramString);
    Log.d("IlinkService", ((StringBuilder)localObject).toString());
    if (this.m_appid_tdisession_map_.containsKey(paramString))
    {
      try
      {
        paramString = ((IlinkService.f)this.m_appid_tdisession_map_.get(paramString)).c.c();
        paramArrayOfByte = ag.c.a(paramArrayOfByte);
        int i = NetStatusUtil.getNetWorkType(getApplicationContext());
        if ((paramArrayOfByte.i() == 0) && (i != -1) && (i != 1) && (i != 9))
        {
          paramString = new StringBuilder();
          paramString.append("OnLocalRequestUploadLogfiles nettype not match:");
          paramString.append(i);
          Log.d("IlinkService", paramString.toString());
          return;
        }
        if ((!paramArrayOfByte.m()) || (paramArrayOfByte.s() == 0)) {
          return;
        }
        localObject = a.b.w();
        ((a.b.a)localObject).a(paramArrayOfByte.g());
        ((a.b.a)localObject).a(paramArrayOfByte.r());
        ((a.b.a)localObject).a(paramArrayOfByte.m());
        ((a.b.a)localObject).b(paramArrayOfByte.o());
        ((a.b.a)localObject).c(paramArrayOfByte.q());
        ((a.b.a)localObject).a(paramString.g());
        ((a.b.a)localObject).d(paramString.i());
        this.m_ilink_manager_.f(((a.b.a)localObject).c().toByteArray());
        return;
      }
      catch (InvalidProtocolBufferException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("UploadLogfiles tdi session map not contain appid:");
      paramArrayOfByte.append(paramString);
      Log.e("IlinkService", paramArrayOfByte.toString());
    }
  }
  
  public void addDeviceCallbackTask(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    Message localMessage = this.mServiceHandler.obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new IlinkService.a(this, paramString1, paramString2, paramArrayOfClass, paramVarArgs);
    this.mServiceHandler.sendMessage(localMessage);
  }
  
  public void addImCallbackTask(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    Message localMessage = this.mServiceHandler.obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new IlinkService.a(this, paramString1, paramString2, paramArrayOfClass, paramVarArgs);
    this.mServiceHandler.sendMessage(localMessage);
  }
  
  public void addLocalTask(Object paramObject, Class paramClass, String paramString, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    Message localMessage = this.mServiceHandler.obtainMessage();
    localMessage.what = 4;
    localMessage.obj = new IlinkService.c(this, paramObject, paramClass, paramString, paramArrayOfClass, paramVarArgs);
    this.mServiceHandler.sendMessage(localMessage);
  }
  
  public void addServiceCallbackTask(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs)
  {
    if (paramString2.equals("OnRequestUploadLogfiles"))
    {
      localObject1 = this.m_service_obj_;
      Object localObject2 = paramVarArgs[1];
      addLocalTask(localObject1, IlinkService.class, "OnLocalRequestUploadLogfiles", new Class[] { String.class, [B.class }, new Object[] { paramString1, localObject2 });
    }
    Object localObject1 = this.mServiceHandler.obtainMessage();
    ((Message)localObject1).what = 2;
    ((Message)localObject1).obj = new IlinkService.e(this, paramString1, paramString2, paramArrayOfClass, paramVarArgs);
    this.mServiceHandler.sendMessage((Message)localObject1);
  }
  
  public String getCallerByTaskid(int paramInt)
  {
    if (this.m_tdi_taskid_caller_map_.containsKey(new Integer(paramInt))) {
      return (String)this.m_tdi_taskid_caller_map_.get(new Integer(paramInt));
    }
    return "";
  }
  
  public Vector<String> getCloneCallers(String paramString)
  {
    return (Vector)this.m_appid_clonecaller_map_.get(paramString);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Object localObject = paramIntent.getByteArrayExtra("initpara");
    if (localObject == null)
    {
      Log.e("IlinkService", "initpara should not be null just restart");
      Process.killProcess(Process.myPid());
    }
    try
    {
      this.m_ilink_init_param_ = ag.f.a((byte[])localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getExternalFilesDir(null));
      ((StringBuilder)localObject).append("/ilinkservice");
      this.m_file_dir_ = ((StringBuilder)localObject).toString();
      localObject = new File(this.m_file_dir_);
      if (!((File)localObject).exists())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("try to create dir:");
        localStringBuilder.append(this.m_file_dir_);
        Log.d("IlinkService", localStringBuilder.toString());
        ((File)localObject).mkdirs();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dir exit:");
        ((StringBuilder)localObject).append(this.m_file_dir_);
        Log.d("IlinkService", ((StringBuilder)localObject).toString());
      }
      if (this.m_ilink_init_param_.u() == 0)
      {
        this.m_login_running = true;
        this.m_ilink_manager_.a(this.m_file_dir_, this.m_ilink_init_param_, getPackageName());
      }
      else
      {
        this.m_ilink_manager_.b(this.m_file_dir_, this.m_ilink_init_param_, getPackageName());
        this.m_tdi_init_param_ = b.s.q().a(this.m_file_dir_).a(this.m_ilink_init_param_.c()).c();
      }
      this.m_ilink_im_manager_ = new aa(this.m_file_dir_, this);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBind by:");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("caller"));
      Log.d("IlinkService", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init para len:");
      ((StringBuilder)localObject).append(paramIntent.getByteArrayExtra("initpara").length);
      Log.d("IlinkService", ((StringBuilder)localObject).toString());
      Log.i("IlinkService", "Ilink service version:33554959, git revision:edc6d5d");
    }
    catch (InvalidProtocolBufferException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    return this.mBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    ad.b().a("c++_shared");
    ad.b().a("linkid");
    ad.b().a("owl");
    ad.b().a("ilink_xlog");
    ad.b().a("ilink_network");
    ad.b().a("private_protobuf");
    ad.b().a("ilink_tdi");
    ad.b().a("ilink_dev");
    ad.b().a("ilink_im");
    Log.d("IlinkService", "Finish load library!");
    this.m_task_thread_ = new HandlerThread("ServiceThread", 10);
    this.m_task_thread_.start();
    this.mServiceLooper = this.m_task_thread_.getLooper();
    PlatformComm.init(getApplicationContext(), new Handler(this.mServiceLooper));
    this.m_ilink_manager_ = new z(this);
    this.mServiceHandler = new IlinkService.d(this, this.mServiceLooper);
    this.m_timer.schedule(this.m_testtask, 5000L, 30000L);
  }
  
  public void onDestroy()
  {
    Log.i("IlinkService", "onDestroy");
    this.m_appid_cloneticket_map_.clear();
    this.m_appid_clonecaller_map_.clear();
    this.m_tdi_taskid_caller_map_.clear();
    this.m_caller_cookie_map_.clear();
    this.m_remote_callback_list_.kill();
    synchronized (this.m_appid_tdisession_map_)
    {
      Enumeration localEnumeration = this.m_appid_tdisession_map_.elements();
      while (localEnumeration.hasMoreElements()) {
        y.a(((IlinkService.f)localEnumeration.nextElement()).c);
      }
      this.m_appid_tdisession_map_.clear();
      this.m_timer.cancel();
      this.m_task_thread_.getLooper().quit();
      try
      {
        this.m_task_thread_.join();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        Log.e("IlinkService", "thread join failed!");
      }
      this.m_task_thread_ = null;
      Log.i("IlinkService", "going to stop im manager");
      this.m_ilink_im_manager_.a();
      this.m_ilink_im_manager_ = null;
      Log.i("IlinkService", "going to stop ilink manager");
      this.m_ilink_manager_.l();
      if (this.m_ilink_init_param_.u() == 0) {
        this.m_ilink_manager_.f();
      } else {
        this.m_ilink_manager_.g();
      }
      this.m_ilink_manager_ = null;
      Process.killProcess(Process.myPid());
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void onLocalLoginComplete(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      localObject = new Profile();
      ((Profile)localObject).setIlinkid(this.m_ilink_manager_.i());
      this.m_profile_ = ((Profile)localObject).serialize();
      this.m_token_ = this.m_ilink_manager_.j();
      this.m_tdi_init_param_ = b.s.q().a(this.m_file_dir_).a(this.m_ilink_init_param_.c()).b(this.m_ilink_init_param_.e()).c(this.m_ilink_manager_.i()).d(this.m_token_).c();
      this.m_login_state_ = true;
      this.m_login_running = false;
      localObject = this.m_appid_tdisession_map_.elements();
      while (((Enumeration)localObject).hasMoreElements()) {
        ((IlinkService.f)((Enumeration)localObject).nextElement()).c.d(this.m_token_.getBytes());
      }
    }
    this.m_profile_ = new byte[0];
    this.m_token_ = "";
    this.m_login_state_ = false;
    this.m_login_running = false;
    Object localObject = Integer.TYPE;
    Class localClass = Integer.TYPE;
    byte[] arrayOfByte = this.m_profile_;
    String str = this.m_token_;
    addDeviceCallbackTask("", "onNewLoginComplete", new Class[] { localObject, localClass, [B.class, String.class }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), arrayOfByte, str });
  }
  
  public void onLoginComplete(int paramInt1, int paramInt2)
  {
    Class localClass1 = Integer.TYPE;
    Class localClass2 = Integer.TYPE;
    addLocalTask(this.m_service_obj_, IlinkService.class, "onLocalLoginComplete", new Class[] { localClass1, localClass2 }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onRebind(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRebind by:");
    localStringBuilder.append(paramIntent.getStringExtra("caller"));
    Log.d("IlinkService", localStringBuilder.toString());
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUnbind by:");
    localStringBuilder.append(paramIntent.getStringExtra("caller"));
    Log.d("IlinkService", localStringBuilder.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkService
 * JD-Core Version:    0.7.0.1
 */