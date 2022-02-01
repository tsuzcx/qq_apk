package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

public class DynamicAvatarDownloadManager
{
  private static File c;
  public long a;
  public int b;
  private ArrayList<WeakReference<DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback>> d = new ArrayList();
  private ConcurrentHashMap<String, NetReq> e = new ConcurrentHashMap();
  private AppInterface f;
  
  static
  {
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD);
    } else {
      localFile = BaseApplicationImpl.getApplication().getCacheDir();
    }
    c = new File(localFile, "_dynamic");
  }
  
  public DynamicAvatarDownloadManager(AppInterface paramAppInterface)
  {
    this.f = paramAppInterface;
    d();
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cache_");
    localStringBuilder.append(Utils.Crc64String(paramString));
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    return d(paramString).getAbsolutePath();
  }
  
  private boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    if (l1 - l2 <= 86400000L)
    {
      if (l1 - l2 < 0L) {
        return true;
      }
      Object localObject = this.f;
      if (localObject != null)
      {
        localObject = ((DynamicAvatarManager)((AppInterface)localObject).getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).b();
        if (this.b + 1 > ((DynamicAvatarConfig)localObject).k)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "isLoadCountSatisfy not satisfy.");
          }
          return false;
        }
      }
    }
    return true;
  }
  
  public static File d(String paramString)
  {
    paramString = b(paramString);
    return new File(c, paramString);
  }
  
  private void d()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_avatar", 4).getString("dynamic_load_count_one_day", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("#");
      if ((localObject != null) && (localObject.length == 2)) {
        try
        {
          this.a = Long.valueOf(localObject[0]).longValue();
          this.b = Integer.valueOf(localObject[1]).intValue();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void e()
  {
    this.b += 1;
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.a >= 86400000L)
    {
      this.a = System.currentTimeMillis();
      this.b = 0;
    }
    ThreadManager.executeOnFileThread(new DynamicAvatarDownloadManager.2(this, l));
  }
  
  public static boolean e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = d(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean f(String paramString)
  {
    if ((!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (!c())) {
      synchronized (this.d)
      {
        if (!this.d.isEmpty())
        {
          Iterator localIterator = this.d.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localWeakReference.get()).a(paramString, false, false);
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean g(String paramString)
  {
    ??? = d(paramString);
    if ((??? != null) && (((File)???).exists()) && (((File)???).isFile())) {
      synchronized (this.d)
      {
        if (!this.d.isEmpty())
        {
          Iterator localIterator = this.d.iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localWeakReference.get()).a(paramString, true, true);
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public final void a()
  {
    Object localObject = this.e.values();
    if (localObject != null)
    {
      if (((Collection)localObject).isEmpty()) {
        return;
      }
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NetReq localNetReq = (NetReq)((Iterator)localObject).next();
        if (localNetReq != null)
        {
          AppInterface localAppInterface = this.f;
          if (localAppInterface != null) {
            ((IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(localNetReq);
          }
        }
      }
      this.e.clear();
    }
  }
  
  public void a(DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback paramIDynamicAvatarDownloadCallback)
  {
    ArrayList localArrayList = this.d;
    int j = 0;
    try
    {
      Iterator localIterator = this.d.iterator();
      WeakReference localWeakReference;
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() == null) || (localWeakReference.get() != paramIDynamicAvatarDownloadCallback));
      int i = 1;
      if (i == 0) {
        this.d.add(new WeakReference(paramIDynamicAvatarDownloadCallback));
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIDynamicAvatarDownloadCallback;
    }
  }
  
  public final void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (this.e.containsKey(str))
        {
          NetReq localNetReq = (NetReq)this.e.get(str);
          if (localNetReq != null)
          {
            AppInterface localAppInterface = this.f;
            if (localAppInterface != null) {
              ((IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(localNetReq);
            }
          }
          this.e.remove(str);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (g(paramString)) {
      return true;
    }
    if (f(paramString)) {
      return false;
    }
    if (this.e.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("url:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" has contains");
        QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new DynamicAvatarDownloadManager.1(this);
    ((HttpNetReq)localObject).mReqUrl = paramString;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = d(paramString).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = 1;
    AppInterface localAppInterface = this.f;
    if (localAppInterface != null)
    {
      ((IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
      this.e.put(paramString, localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadDynamicAvatar, url: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", uin:");
      ((StringBuilder)localObject).append(this.f.getCurrentAccountUin());
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void b()
  {
    a();
    this.d.clear();
    this.f = null;
  }
  
  public void b(DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback paramIDynamicAvatarDownloadCallback)
  {
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() == paramIDynamicAvatarDownloadCallback)) {
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramIDynamicAvatarDownloadCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager
 * JD-Core Version:    0.7.0.1
 */