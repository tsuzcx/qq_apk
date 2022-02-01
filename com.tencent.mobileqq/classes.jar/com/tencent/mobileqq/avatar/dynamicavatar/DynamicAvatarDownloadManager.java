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
  private static File jdField_a_of_type_JavaIoFile;
  public int a;
  public long a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArrayList<WeakReference<DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, NetReq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD);
    } else {
      localFile = BaseApplicationImpl.getApplication().getCacheDir();
    }
    jdField_a_of_type_JavaIoFile = new File(localFile, "_dynamic");
  }
  
  public DynamicAvatarDownloadManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    c();
  }
  
  public static File a(String paramString)
  {
    paramString = a(paramString);
    return new File(jdField_a_of_type_JavaIoFile, paramString);
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cache_");
    localStringBuilder.append(Utils.Crc64String(paramString));
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  private boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (l1 - l2 <= 86400000L)
    {
      if (l1 - l2 < 0L) {
        return true;
      }
      Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      if (localObject != null)
      {
        localObject = ((DynamicAvatarManager)((AppInterface)localObject).getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).a();
        if (this.jdField_a_of_type_Int + 1 > ((DynamicAvatarConfig)localObject).b)
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
  
  public static String b(String paramString)
  {
    return a(paramString).getAbsolutePath();
  }
  
  public static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      if ((paramString.exists()) && (paramString.isFile())) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_avatar", 4).getString("dynamic_load_count_one_day", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("#");
      if ((localObject != null) && (localObject.length == 2)) {
        try
        {
          this.jdField_a_of_type_Long = Long.valueOf(localObject[0]).longValue();
          this.jdField_a_of_type_Int = Integer.valueOf(localObject[1]).intValue();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private boolean c(String paramString)
  {
    if ((!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) && (!a())) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  private void d()
  {
    this.jdField_a_of_type_Int += 1;
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 86400000L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = 0;
    }
    ThreadManager.executeOnFileThread(new DynamicAvatarDownloadManager.2(this, l));
  }
  
  private boolean d(String paramString)
  {
    ??? = a(paramString);
    if ((??? != null) && (((File)???).exists()) && (((File)???).isFile())) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
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
          AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          if (localAppInterface != null) {
            ((IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(localNetReq);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void a(DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback paramIDynamicAvatarDownloadCallback)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int j = 0;
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
        this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramIDynamicAvatarDownloadCallback));
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
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
        {
          NetReq localNetReq = (NetReq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if (localNetReq != null)
          {
            AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
            if (localAppInterface != null) {
              ((IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(localNetReq);
            }
          }
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (d(paramString)) {
      return true;
    }
    if (c(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
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
    ((HttpNetReq)localObject).mOutPath = a(paramString).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = 1;
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localAppInterface != null)
    {
      ((IHttpEngineService)localAppInterface.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownloadDynamicAvatar, url: ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", uin:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void b(DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback paramIDynamicAvatarDownloadCallback)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager
 * JD-Core Version:    0.7.0.1
 */