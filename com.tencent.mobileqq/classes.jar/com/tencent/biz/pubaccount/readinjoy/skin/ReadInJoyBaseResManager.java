package com.tencent.biz.pubaccount.readinjoy.skin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mai;
import mqq.manager.Manager;

public abstract class ReadInJoyBaseResManager
  implements Manager
{
  public AppInterface a;
  protected EntityManager a;
  protected DownloaderInterface a;
  public ArrayList a;
  public HashMap a;
  
  public ReadInJoyBaseResManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramAppInterface.getManager(46)).a(1);
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public String a(String paramString)
  {
    String str2 = AppConstants.aK + ".readInjoy/resource/";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {
      str1 = str2 + paramString + "/";
    }
    return str1;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = str + paramString2 + "/";
    }
    return paramString1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramDownloadListener);
  }
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public void a(String paramString, DownloadTask paramDownloadTask) {}
  
  public void a(String[] paramArrayOfString) {}
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return a(paramString, paramBaseResData, 0);
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData, int paramInt)
  {
    boolean bool = false;
    Object localObject = paramBaseResData.id;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseResManager", 2, "downloadGuide: id = " + (String)localObject);
    }
    String str = a(paramString, (String)localObject);
    if (SceneBuilder.a(new File(str))) {
      bool = true;
    }
    while (this.jdField_a_of_type_JavaUtilHashMap.get(paramString + "_" + (String)localObject) != null) {
      return bool;
    }
    FileUtils.a(str);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString + "_" + (String)localObject, paramBaseResData.url);
    str = str + ".zip";
    File localFile = new File(str);
    Bundle localBundle = new Bundle();
    localBundle.putString("resId", (String)localObject);
    localBundle.putString("prefix", paramString);
    localObject = new DownloadTask(paramBaseResData.url, localFile);
    ((DownloadTask)localObject).b = paramInt;
    ((DownloadTask)localObject).d = 60L;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject, new mai(this, str, paramBaseResData, paramString), localBundle);
    return false;
  }
  
  public void b(DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramDownloadListener);
  }
  
  public abstract void b(String paramString, BaseResData paramBaseResData);
  
  public abstract boolean b(String paramString, BaseResData paramBaseResData);
  
  public abstract boolean c(String paramString, BaseResData paramBaseResData);
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyBaseResManager
 * JD-Core Version:    0.7.0.1
 */