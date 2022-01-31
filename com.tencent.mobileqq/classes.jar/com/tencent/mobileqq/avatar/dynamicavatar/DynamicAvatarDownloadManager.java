package com.tencent.mobileqq.avatar.dynamicavatar;

import abjb;
import abjc;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
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
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (File localFile = new File(AppConstants.aJ + "head/");; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "_dynamic");
      return;
    }
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
    return "cache_" + Utils.Crc64String(paramString) + ".mp4";
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if ((l - this.jdField_a_of_type_Long > 86400000L) || (l - this.jdField_a_of_type_Long < 0L)) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      DynamicAvatarConfig localDynamicAvatarConfig = ((DynamicAvatarManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(179)).a();
      if (this.jdField_a_of_type_Int + 1 > localDynamicAvatarConfig.b)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.dynamicAvatar", 2, "isLoadCountSatisfy not satisfy.");
        }
        return false;
      }
      return true;
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
      if ((localObject == null) || (localObject.length != 2)) {}
    }
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
  
  private void d()
  {
    this.jdField_a_of_type_Int += 1;
    long l = System.currentTimeMillis();
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 86400000L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int = 0;
    }
    ThreadManager.executeOnFileThread(new abjc(this, l));
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values();
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NetReq localNetReq = (NetReq)((Iterator)localObject).next();
      if ((localNetReq != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localNetReq);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback paramIDynamicAvatarDownloadCallback)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (localWeakReference.get() != paramIDynamicAvatarDownloadCallback)) {
            continue;
          }
          i = 1;
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramIDynamicAvatarDownloadCallback));
          }
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
        {
          NetReq localNetReq = (NetReq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
          if ((localNetReq != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).b(localNetReq);
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
    ??? = a(paramString);
    Iterator localIterator;
    WeakReference localWeakReference;
    if ((??? != null) && (((File)???).exists()) && (((File)???).isFile()))
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localWeakReference.get()).a(paramString, true, true);
            }
          }
        }
      }
      return true;
    }
    if ((!NetworkUtil.h(BaseApplicationImpl.getContext())) && (!a()))
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localWeakReference.get()).a(paramString, false, false);
            }
          }
        }
      }
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "url:" + paramString + " has contains");
      }
      return false;
    }
    ??? = new HttpNetReq();
    ((HttpNetReq)???).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new abjb(this);
    ((HttpNetReq)???).jdField_a_of_type_JavaLangString = paramString;
    ((HttpNetReq)???).jdField_a_of_type_Int = 0;
    ((HttpNetReq)???).jdField_c_of_type_JavaLangString = a(paramString).getPath();
    ((HttpNetReq)???).jdField_c_of_type_Int = 1;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getNetEngine(0).a((NetReq)???);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, ???);
      QLog.i("Q.dynamicAvatar", 2, "startDownloadDynamicAvatar, url: " + paramString + ", uin:" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager
 * JD-Core Version:    0.7.0.1
 */