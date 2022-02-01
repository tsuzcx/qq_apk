package com.tencent.ilinkservice;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.tdi.b.b;
import com.tencent.ilink.tdi.b.b.a;
import com.tencent.ilink.tdi.b.d;
import com.tencent.ilink.tdi.b.d.a;
import com.tencent.ilink.tdi.b.r;
import com.tencent.ilink.tdi.b.r.a;
import com.tencent.luggage.wxa.aq.a.a;
import com.tencent.luggage.wxa.aq.a.a.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

final class IlinkServiceImpl
{
  private static final String TAG = "IlinkServiceImpl";
  private static AtomicInteger m_local_taskid_ = new AtomicInteger(0);
  private IIlinkServiceCallback m_callback_ = new IlinkServiceImpl.1(this);
  private Context m_context_ = null;
  private Intent m_current_bind_intent_ = new Intent();
  private Vector<x> m_device_interfaces_ = new Vector();
  private ConcurrentHashMap<Integer, String> m_device_local_msgid_ = new ConcurrentHashMap();
  private byte[] m_device_profile_;
  private String m_device_token_ = "";
  private u m_ilink_service_;
  private ConcurrentHashMap<String, ab> m_imsession_map_ = new ConcurrentHashMap();
  private byte[] m_init_parameter_;
  private boolean m_isbound = false;
  private ConcurrentHashMap<Integer, Integer> m_local_svr_taskid_ = new ConcurrentHashMap();
  private String m_process_name_;
  private String m_self_package_name_;
  private Vector<ac> m_service_callbacks_ = new Vector();
  private String m_service_cookie_;
  private ServiceConnection m_serviceconn_ = new IlinkServiceImpl.2(this);
  private ConcurrentHashMap<String, ap> m_tdisession_map_ = new ConcurrentHashMap();
  
  private IlinkServiceImpl()
  {
    af.a().a("IlinkServiceImpl", "Create IlinkServiceImpl", new Object[0]);
  }
  
  private static String GeneralCookie(String paramString)
  {
    double d1 = new Random().nextDouble();
    double d2 = Math.pow(10.0D, 10.0D);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((d1 + 1.0D) * d2);
    ((StringBuilder)localObject1).append(paramString);
    paramString = ((StringBuilder)localObject1).toString();
    for (;;)
    {
      int i;
      try
      {
        localObject1 = MessageDigest.getInstance("SHA-256");
        ((MessageDigest)localObject1).update(paramString.getBytes());
        localObject1 = ((MessageDigest)localObject1).digest();
        localObject2 = new StringBuilder();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          int k = localObject1[i] & 0xFF;
          if (Integer.toHexString(k).length() == 1)
          {
            ((StringBuilder)localObject2).append("0");
            ((StringBuilder)localObject2).append(Integer.toHexString(k));
          }
          else
          {
            ((StringBuilder)localObject2).append(Integer.toHexString(k));
          }
        }
        else
        {
          localObject1 = ((StringBuilder)localObject2).toString();
          return localObject1;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        Object localObject2 = af.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("no such algorithm:");
        localStringBuilder.append(localNoSuchAlgorithmException.toString());
        ((af)localObject2).d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
        localNoSuchAlgorithmException.printStackTrace();
        return paramString;
      }
      i += 1;
    }
  }
  
  public static IlinkServiceImpl getInstance()
  {
    return IlinkServiceImpl.a.a();
  }
  
  private static String getProcessName(Context paramContext)
  {
    int i = Process.myPid();
    Object localObject1 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject1 == null)
    {
      af.a().d("IlinkServiceImpl", "runningApps is null general one!", new Object[0]);
      return GeneralCookie(paramContext.getPackageName());
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
      if (((ActivityManager.RunningAppProcessInfo)localObject1).pid == i)
      {
        paramContext = af.a();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Process name is:");
        ((StringBuilder)localObject2).append(((ActivityManager.RunningAppProcessInfo)localObject1).processName);
        paramContext.a("IlinkServiceImpl", ((StringBuilder)localObject2).toString(), new Object[0]);
        return ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
      }
    }
    af.a().d("IlinkServiceImpl", "can not get process name general one!", new Object[0]);
    return GeneralCookie(paramContext.getPackageName());
  }
  
  public byte[] ReqCommFunctionWithResp(String paramString, byte[] paramArrayOfByte)
  {
    u localu = this.m_ilink_service_;
    if (localu == null) {
      return null;
    }
    try
    {
      paramString = localu.p(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void ReqCommFunctionWithTaskid(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (this.m_ilink_service_ == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new Integer(paramInt);
        boolean bool = this.m_local_svr_taskid_.containsKey(localObject1);
        if (!bool)
        {
          paramString = af.a();
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("app request not longer need localtaskid:");
          paramArrayOfByte.append(paramInt);
          paramString.a("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
          return;
        }
        Object localObject2 = this.m_ilink_service_.p(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
        i = paramString.hashCode();
        if (i != -1911188865)
        {
          if ((i != 686849420) || (!paramString.equals("getDeviceShadow"))) {
            break label515;
          }
          i = 0;
        }
        else
        {
          if (!paramString.equals("updateDeviceShadow")) {
            break label515;
          }
          i = 1;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            paramArrayOfByte = af.a();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("not supported function:");
            ((StringBuilder)localObject1).append(paramString);
            paramArrayOfByte.d("IlinkServiceImpl", ((StringBuilder)localObject1).toString(), new Object[0]);
            return;
          }
          i = a.q.a((byte[])localObject2).c();
          if (i == 0)
          {
            af.a().d("IlinkServiceImpl", "send updateDeviceShadow error try to invoke callback!", new Object[0]);
            localObject2 = a.p.a(paramArrayOfByte);
            paramString = Integer.TYPE;
            paramArrayOfByte = Integer.TYPE;
            localObject1 = v.a();
            localObject2 = this.m_imsession_map_.get(((a.p)localObject2).c());
            byte[] arrayOfByte = new byte[0];
            ((v)localObject1).a(localObject2, ab.class, "onUpdateDeviceShadow", new Class[] { paramString, paramArrayOfByte, [B.class }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(-1), arrayOfByte });
            return;
          }
          this.m_local_svr_taskid_.remove(localObject1);
          this.m_local_svr_taskid_.put(localObject1, new Integer(i));
          return;
        }
        i = a.c.a((byte[])localObject2).c();
        if (i == 0)
        {
          af.a().d("IlinkServiceImpl", "send getDeviceShadow error try to invoke callback!", new Object[0]);
          paramString = a.b.a(paramArrayOfByte);
          paramArrayOfByte = Integer.TYPE;
          localObject1 = Integer.TYPE;
          v.a().a(this.m_imsession_map_.get(paramString.c()), ab.class, "onGetDeviceShadow", new Class[] { paramArrayOfByte, localObject1, [B.class }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(-1), new byte[0] });
          return;
        }
        this.m_local_svr_taskid_.remove(localObject1);
        this.m_local_svr_taskid_.put(localObject1, new Integer(i));
        return;
      }
      catch (InvalidProtocolBufferException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label515:
      int i = -1;
    }
  }
  
  public void SetSmcUin(String paramString, int paramInt)
  {
    try
    {
      this.m_ilink_service_.c(this.m_process_name_, this.m_service_cookie_, paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void WriteKvData(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.k(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int addAppRequestTask()
  {
    int j = m_local_taskid_.incrementAndGet();
    int i = j;
    if (j == 0) {
      i = m_local_taskid_.incrementAndGet();
    }
    this.m_local_svr_taskid_.put(Integer.valueOf(i), Integer.valueOf(0));
    return i;
  }
  
  public int addDeviceMessageTask()
  {
    int j = m_local_taskid_.incrementAndGet();
    int i = j;
    if (j == 0) {
      i = m_local_taskid_.incrementAndGet();
    }
    return i;
  }
  
  public ab addImSession(String paramString)
  {
    if (this.m_imsession_map_.containsKey(paramString))
    {
      localObject = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Im session map already has session for appid:");
      localStringBuilder.append(paramString);
      ((af)localObject).d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      af.a().d("IlinkServiceImpl", "Maybe you forgot to call deleteImSession first?", new Object[0]);
      return (ab)this.m_imsession_map_.get(paramString);
    }
    Object localObject = new ab(paramString);
    this.m_imsession_map_.put(paramString, localObject);
    return localObject;
  }
  
  public ap addTdiSession(String paramString)
  {
    if (this.m_tdisession_map_.containsKey(paramString))
    {
      localObject = af.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tdi session map already has session for appid:");
      localStringBuilder.append(paramString);
      ((af)localObject).d("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      af.a().d("IlinkServiceImpl", "Maybe you forgot to call deleteTdiSession first?", new Object[0]);
      return (ap)this.m_tdisession_map_.get(paramString);
    }
    Object localObject = new ap(paramString, false);
    this.m_tdisession_map_.put(paramString, localObject);
    return localObject;
  }
  
  public void autoLogin()
  {
    try
    {
      this.m_ilink_service_.a(this.m_process_name_, this.m_service_cookie_);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void autoLogin(String paramString)
  {
    try
    {
      this.m_ilink_service_.h(this.m_process_name_, this.m_service_cookie_, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void cancel(String paramString, int paramInt)
  {
    try
    {
      this.m_ilink_service_.a(this.m_process_name_, this.m_service_cookie_, paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void cancelAppRequest(String paramString, int paramInt)
  {
    try
    {
      this.m_ilink_service_.b(this.m_process_name_, this.m_service_cookie_, paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void cancelOAuth(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Object localObject = new Integer(paramInt);
      boolean bool = this.m_local_svr_taskid_.containsKey(localObject);
      if (!bool)
      {
        paramString = af.a();
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("cancelOAuth not longer need localtaskid:");
        paramArrayOfByte.append(paramInt);
        paramString.a("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
        return;
      }
      int i = this.m_ilink_service_.n(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      if (i == 0)
      {
        af.a().d("IlinkServiceImpl", "cancelOAuth error try to invoke callback!", new Object[0]);
        paramArrayOfByte = Integer.TYPE;
        localObject = Integer.TYPE;
        v.a().a(this.m_tdisession_map_.get(paramString), ap.class, "onCancelOAuthComplete", new Class[] { paramArrayOfByte, localObject }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(-1) });
        return;
      }
      this.m_local_svr_taskid_.remove(localObject);
      this.m_local_svr_taskid_.put(localObject, new Integer(i));
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void cancelRequest(String paramString, int paramInt)
  {
    try
    {
      this.m_ilink_service_.d(this.m_process_name_, this.m_service_cookie_, paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void checkLoginQrCode(String paramString)
  {
    try
    {
      this.m_ilink_service_.f(this.m_process_name_, this.m_service_cookie_, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void cloneMultiProcessTdiSession(String paramString1, String paramString2)
  {
    try
    {
      this.m_ilink_service_.a(this.m_process_name_, this.m_service_cookie_, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public x createDeviceInterface()
  {
    synchronized (this.m_device_interfaces_)
    {
      x localx = new x();
      this.m_device_interfaces_.add(localx);
      return localx;
    }
  }
  
  public void createTdiSession(String paramString)
  {
    try
    {
      this.m_ilink_service_.b(this.m_process_name_, this.m_service_cookie_, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void destroyDeviceInterface(x paramx)
  {
    synchronized (this.m_device_interfaces_)
    {
      paramx.a();
      this.m_device_interfaces_.remove(paramx);
      return;
    }
  }
  
  public void destroyMultiProcessTdiSession(String paramString)
  {
    try
    {
      this.m_ilink_service_.j(this.m_process_name_, this.m_service_cookie_, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void destroyTdiSession(String paramString)
  {
    try
    {
      this.m_ilink_service_.c(this.m_process_name_, this.m_service_cookie_, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void faceExtVerify(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.c(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void faceLogin(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.d(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void faceRecognize(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.b(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void faceRecognizeConfig(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.g(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getAppPushToken(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Object localObject1 = new Integer(paramInt);
      boolean bool = this.m_local_svr_taskid_.containsKey(localObject1);
      if (!bool)
      {
        paramString = af.a();
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("getAppPushToken not longer need localtaskid:");
        paramArrayOfByte.append(paramInt);
        paramString.a("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
        return;
      }
      int i = this.m_ilink_service_.j(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      if (i == 0)
      {
        af.a().d("IlinkServiceImpl", "getAppPushToken error try to invoke callback!", new Object[0]);
        paramArrayOfByte = Integer.TYPE;
        localObject1 = Integer.TYPE;
        Object localObject2 = b.b.g().a(ByteString.copyFrom("".getBytes())).a(0).c();
        v localv = v.a();
        paramString = this.m_tdisession_map_.get(paramString);
        localObject2 = ((b.b)localObject2).toByteArray();
        localv.a(paramString, ap.class, "onGetAppPushTokenComplete", new Class[] { paramArrayOfByte, localObject1, [B.class }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(-1), localObject2 });
        return;
      }
      this.m_local_svr_taskid_.remove(localObject1);
      this.m_local_svr_taskid_.put(localObject1, new Integer(i));
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getLoginQrCode(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.i(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getOAuthCode(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Object localObject1 = new Integer(paramInt);
      boolean bool = this.m_local_svr_taskid_.containsKey(localObject1);
      if (!bool)
      {
        paramString = af.a();
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("getOAuthCode not longer need localtaskid:");
        paramArrayOfByte.append(paramInt);
        paramString.a("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
        return;
      }
      int i = this.m_ilink_service_.m(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      if (i == 0)
      {
        af.a().d("IlinkServiceImpl", "getOAuthCode error try to invoke callback!", new Object[0]);
        paramArrayOfByte = Integer.TYPE;
        localObject1 = Integer.TYPE;
        Object localObject2 = b.r.e().a(ByteString.copyFrom("".getBytes())).c();
        v localv = v.a();
        paramString = this.m_tdisession_map_.get(paramString);
        localObject2 = ((b.r)localObject2).toByteArray();
        localv.a(paramString, ap.class, "onGetOAuthCodeComplete", new Class[] { paramArrayOfByte, localObject1, [B.class }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(-1), localObject2 });
        return;
      }
      this.m_local_svr_taskid_.remove(localObject1);
      this.m_local_svr_taskid_.put(localObject1, new Integer(i));
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public byte[] getProfile()
  {
    byte[] arrayOfByte2 = this.m_device_profile_;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[0];
    }
    return arrayOfByte1;
  }
  
  public String getToken()
  {
    String str2 = this.m_device_token_;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public byte[] getUserInfo(String paramString)
  {
    u localu = this.m_ilink_service_;
    if (localu == null) {
      return null;
    }
    try
    {
      paramString = localu.g(this.m_process_name_, this.m_service_cookie_, paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void handleAnnounceResult(Intent paramIntent)
  {
    af.a().a("IlinkServiceImpl", "handleAnnounceResult do nothing in standalone module!", new Object[0]);
  }
  
  public void handleVoteResult(Intent paramIntent, Bundle paramBundle)
  {
    af.a().a("IlinkServiceImpl", "handleVoteResult do nothing in standalone module!", new Object[0]);
  }
  
  public boolean isAlreadyGetStrategy()
  {
    u localu = this.m_ilink_service_;
    if (localu == null) {
      return false;
    }
    try
    {
      boolean bool = localu.d(this.m_process_name_, this.m_service_cookie_);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
    return false;
  }
  
  public boolean isAppidImSessionExit(String paramString)
  {
    return this.m_imsession_map_.containsKey(paramString);
  }
  
  public boolean isAppidTdiSessionExit(String paramString)
  {
    return this.m_tdisession_map_.containsKey(paramString);
  }
  
  public boolean isDeviceLoginSuccess()
  {
    try
    {
      if (ag.f.a(this.m_init_parameter_).u() == 1) {
        return true;
      }
      boolean bool = this.m_device_token_.equals("");
      return bool ^ true;
    }
    catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
    {
      localInvalidProtocolBufferException.printStackTrace();
    }
    return false;
  }
  
  public boolean isImSessionValid(ab paramab)
  {
    return this.m_imsession_map_.containsValue(paramab);
  }
  
  public boolean isTdiSessionValid(ap paramap)
  {
    return this.m_tdisession_map_.containsValue(paramap);
  }
  
  public void logOut(String paramString)
  {
    try
    {
      this.m_ilink_service_.i(this.m_process_name_, this.m_service_cookie_, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void oauthLogin(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.l(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void qrCodeLogin(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.e(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void receiveAnnounceMsg(Intent paramIntent)
  {
    af.a().a("IlinkServiceImpl", "receiveAnnounceMsg do nothing in standalone module!", new Object[0]);
  }
  
  public void receiveAnswer(String paramString1, String paramString2, int paramInt)
  {
    af.a().a("IlinkServiceImpl", "receiveAnswer do nothing in standalone module!", new Object[0]);
  }
  
  public Bundle receiveVoteMsg(Intent paramIntent, Bundle paramBundle)
  {
    af.a().a("IlinkServiceImpl", "receiveVoteMsg do nothing in standalone module!", new Object[0]);
    return paramBundle;
  }
  
  public void registCallback(ac paramac)
  {
    synchronized (this.m_service_callbacks_)
    {
      this.m_service_callbacks_.add(paramac);
      return;
    }
  }
  
  public int removeAppRequestTask(int paramInt)
  {
    Integer localInteger1 = new Integer(paramInt);
    if (this.m_local_svr_taskid_.containsKey(localInteger1))
    {
      Integer localInteger2 = (Integer)this.m_local_svr_taskid_.get(localInteger1);
      this.m_local_svr_taskid_.remove(localInteger1);
      return localInteger2.intValue();
    }
    return 0;
  }
  
  public void removeImSession(String paramString)
  {
    if (this.m_imsession_map_.containsKey(paramString))
    {
      localaf = af.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Find Im session for appid:");
      localStringBuilder.append(paramString);
      localaf.a("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      ((ab)this.m_imsession_map_.get(paramString)).a();
      this.m_imsession_map_.remove(paramString);
      return;
    }
    af localaf = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("im obj not exit appid:");
    localStringBuilder.append(paramString);
    localaf.c("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
  }
  
  public void removeTdiSession(String paramString)
  {
    if (this.m_tdisession_map_.containsKey(paramString))
    {
      localaf = af.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Find Tdi session for appid:");
      localStringBuilder.append(paramString);
      localaf.a("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
      ((ap)this.m_tdisession_map_.get(paramString)).g();
      ((ap)this.m_tdisession_map_.get(paramString)).h();
      this.m_tdisession_map_.remove(paramString);
      return;
    }
    af localaf = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tdi obj not exit appid:");
    localStringBuilder.append(paramString);
    localaf.c("IlinkServiceImpl", localStringBuilder.toString(), new Object[0]);
  }
  
  public void requestMultiProcessCloneTicket(String paramString)
  {
    try
    {
      this.m_ilink_service_.a(this.m_process_name_, this.m_service_cookie_, paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void sendAppRequest(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      Object localObject1 = new Integer(paramInt);
      boolean bool = this.m_local_svr_taskid_.containsKey(localObject1);
      if (!bool)
      {
        paramString = af.a();
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("app request not longer need localtaskid:");
        paramArrayOfByte.append(paramInt);
        paramString.a("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
        return;
      }
      int i = this.m_ilink_service_.f(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      if (i == 0)
      {
        af.a().d("IlinkServiceImpl", "send app request error try to invoke callback!", new Object[0]);
        paramArrayOfByte = Integer.TYPE;
        localObject1 = Integer.TYPE;
        Object localObject2 = b.d.e().a(ByteString.copyFrom("".getBytes())).c();
        v localv = v.a();
        paramString = this.m_tdisession_map_.get(paramString);
        localObject2 = ((b.d)localObject2).toByteArray();
        localv.a(paramString, ap.class, "onReceiveAppResponse", new Class[] { paramArrayOfByte, localObject1, [B.class }, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(-1), localObject2 });
        return;
      }
      this.m_local_svr_taskid_.remove(localObject1);
      this.m_local_svr_taskid_.put(localObject1, new Integer(i));
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void sendIotMessage(String arg1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    try
    {
      paramString2 = this.m_ilink_service_.a(this.m_process_name_, this.m_service_cookie_, ???, paramString2, paramString3, paramString4);
      if (paramString2 == null)
      {
        af.a().d("IlinkServiceImpl", "sendIotMessage error try to invoke callback!", new Object[0]);
        synchronized (this.m_device_interfaces_)
        {
          paramString2 = Integer.TYPE;
          paramString3 = Integer.TYPE;
          int i = 0;
          while (i < this.m_device_interfaces_.size())
          {
            v.a().a(this.m_device_interfaces_.get(i), x.class, "onSendMsgResult", new Class[] { paramString2, paramString3 }, new Object[] { Integer.valueOf(-1), Integer.valueOf(paramInt) });
            i += 1;
          }
          return;
        }
      }
      synchronized (this.m_device_local_msgid_)
      {
        this.m_device_local_msgid_.put(Integer.valueOf(paramInt), paramString2);
        return;
      }
      return;
    }
    catch (RemoteException ???)
    {
      ???.printStackTrace();
    }
  }
  
  public void setConsoleLogOpen(boolean paramBoolean)
  {
    u localu = this.m_ilink_service_;
    if (localu == null) {
      return;
    }
    try
    {
      localu.a(this.m_process_name_, this.m_service_cookie_, paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void setLogLevel(int paramInt)
  {
    u localu = this.m_ilink_service_;
    if (localu == null) {
      return;
    }
    try
    {
      localu.a(this.m_process_name_, this.m_service_cookie_, paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void setProxyInfo(byte[] paramArrayOfByte)
  {
    try
    {
      this.m_ilink_service_.a(this.m_process_name_, this.m_service_cookie_, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public void start(Context paramContext, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.m_context_ != null)
      {
        af.a().a("IlinkServiceImpl", "Service already running!", new Object[0]);
        return;
      }
      this.m_context_ = paramContext;
      this.m_init_parameter_ = paramArrayOfByte;
      this.m_self_package_name_ = this.m_context_.getPackageName();
      this.m_process_name_ = getProcessName(this.m_context_);
      paramContext = af.a();
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("my process name is:");
      paramArrayOfByte.append(this.m_process_name_);
      paramContext.a("IlinkServiceImpl", paramArrayOfByte.toString(), new Object[0]);
      this.m_current_bind_intent_.setAction("com.tencent.ilinkservice.StartIlinkService");
      this.m_current_bind_intent_.setPackage(this.m_self_package_name_);
      this.m_current_bind_intent_.putExtra("caller", this.m_process_name_);
      this.m_current_bind_intent_.putExtra("initpara", this.m_init_parameter_);
      this.m_isbound = this.m_context_.bindService(this.m_current_bind_intent_, this.m_serviceconn_, 1);
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    if (this.m_context_ == null) {
      return;
    }
    u localu = this.m_ilink_service_;
    int i = 0;
    if (localu != null)
    {
      try
      {
        localu.a(this.m_process_name_, this.m_service_cookie_, this.m_callback_);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      if (this.m_isbound)
      {
        this.m_context_.unbindService(this.m_serviceconn_);
        this.m_isbound = false;
      }
    }
    v.a().a(false);
    v.a().c();
    this.m_ilink_service_ = null;
    this.m_service_callbacks_.clear();
    this.m_tdisession_map_.clear();
    this.m_imsession_map_.clear();
    this.m_local_svr_taskid_.clear();
    this.m_device_local_msgid_.clear();
    synchronized (this.m_device_interfaces_)
    {
      while (i < this.m_device_interfaces_.size())
      {
        ((x)this.m_device_interfaces_.get(i)).a();
        i += 1;
      }
      this.m_device_interfaces_.clear();
      this.m_device_profile_ = null;
      this.m_device_token_ = "";
      this.m_context_ = null;
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void unregistCallback(ac paramac)
  {
    synchronized (this.m_service_callbacks_)
    {
      this.m_service_callbacks_.remove(paramac);
      return;
    }
  }
  
  public void updateDeviceInfo(int paramInt1, String paramString, int paramInt2)
  {
    if (this.m_ilink_service_ == null) {
      return;
    }
    try
    {
      Object localObject = a.a.i();
      ((a.a.a)localObject).a(paramInt1);
      ((a.a.a)localObject).a(paramString);
      ((a.a.a)localObject).b(paramInt2);
      localObject = ((a.a.a)localObject).c().toByteArray();
      ag.f.a locala = ag.f.a(ag.f.a(this.m_init_parameter_));
      locala.a(paramInt1);
      if (paramString.length() != 0)
      {
        locala.b(paramString);
        locala.d(paramInt2);
      }
      this.m_init_parameter_ = locala.c().toByteArray();
      this.m_ilink_service_.b(this.m_process_name_, this.m_service_cookie_, (byte[])localObject);
      return;
    }
    catch (InvalidProtocolBufferException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void voidCommFunction(String paramString, byte[] paramArrayOfByte)
  {
    u localu = this.m_ilink_service_;
    if (localu == null) {
      return;
    }
    try
    {
      localu.o(this.m_process_name_, this.m_service_cookie_, paramString, paramArrayOfByte);
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void writeLogToService(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      this.m_ilink_service_.a(paramInt, paramString1, paramString2);
      return;
    }
    catch (RemoteException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkServiceImpl
 * JD-Core Version:    0.7.0.1
 */