package com.tencent.biz.pubaccount.readinjoy.skin;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import maj;
import mak;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoyRefreshManager
  implements Manager
{
  protected int a;
  public AppInterface a;
  protected DownloaderInterface a;
  protected String a;
  protected ArrayList a;
  public HashMap a;
  protected boolean a;
  
  public ReadInJoyRefreshManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)paramAppInterface.getManager(46)).a(1);
  }
  
  private void b(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Int != paramInt) || (!this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString;
      RefreshRes.a(this.jdField_a_of_type_JavaLangString);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((ReadInJoyRefreshManager.OnRefreshChangedListener)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).n();
        paramInt += 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public RefreshData a(Context paramContext)
  {
    RefreshData localRefreshData = null;
    paramContext = SharedPreUtils.s(paramContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext != null) {
          localRefreshData = new RefreshData(paramContext);
        }
        return localRefreshData;
      }
      catch (Exception paramContext)
      {
        paramContext = null;
        continue;
      }
      paramContext = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      b(paramInt, paramString);
      return;
    }
    ThreadManager.getUIHandler().post(new maj(this, paramInt, paramString));
  }
  
  public void a(ReadInJoyRefreshManager.OnRefreshChangedListener paramOnRefreshChangedListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOnRefreshChangedListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(RefreshData paramRefreshData)
  {
    return a(paramRefreshData, 0);
  }
  
  public boolean a(RefreshData paramRefreshData, int paramInt)
  {
    boolean bool = false;
    Object localObject = paramRefreshData.id;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRefreshManager", 2, "downloadRefreshRes: id = " + (String)localObject);
    }
    String str = RefreshRes.a((String)localObject);
    if (RefreshRes.a((String)localObject)) {
      bool = true;
    }
    while (this.jdField_a_of_type_JavaUtilHashMap.get("refresh_" + (String)localObject) != null) {
      return bool;
    }
    FileUtils.a(str);
    this.jdField_a_of_type_JavaUtilHashMap.put("refresh_" + (String)localObject, paramRefreshData.url);
    str = str + ".zip";
    File localFile = new File(str);
    Bundle localBundle = new Bundle();
    localBundle.putString("refreshId", (String)localObject);
    localObject = new DownloadTask(paramRefreshData.url, localFile);
    ((DownloadTask)localObject).b = paramInt;
    ((DownloadTask)localObject).d = 60L;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a((DownloadTask)localObject, new mak(this, str, paramRefreshData), localBundle);
    return false;
  }
  
  public void b(ReadInJoyRefreshManager.OnRefreshChangedListener paramOnRefreshChangedListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnRefreshChangedListener);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager
 * JD-Core Version:    0.7.0.1
 */