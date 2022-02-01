package com.tencent.biz.pubaccount.readinjoy.pts.loader;

import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class PTSAppLoader
{
  private static volatile PTSAppLoader jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSAppLoader;
  private static String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public static PTSAppLoader a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSAppLoader == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSAppLoader == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSAppLoader = new PTSAppLoader();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyPtsLoaderPTSAppLoader;
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    ThreadManager.excute(new PTSAppLoader.2(this, paramString), 128, null, true);
  }
  
  private void b(String paramString)
  {
    int j = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    String str1 = a(paramString);
    boolean bool2 = FileUtils.a(str1);
    boolean bool3 = PTSOfflineUtil.a(str1, paramString);
    String str2 = str1 + "/" + "pts_app_config.json";
    boolean bool4 = PTSOfflineUtil.a(str2);
    boolean bool1;
    if ((bool2) && (bool3) && (bool4)) {
      bool1 = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      jdField_a_of_type_JavaLangString = PTSOfflineUtil.b(str2);
      Object localObject1 = str1 + File.separator + "pages";
      try
      {
        localObject1 = new File((String)localObject1);
        if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
        {
          localObject1 = ((File)localObject1).listFiles();
          int k = localObject1.length;
          i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            String str3 = localObject2.getName();
            if ((localObject2.isDirectory()) && (!TextUtils.isEmpty(str3))) {
              this.jdField_a_of_type_JavaUtilList.add(str3);
            }
            i += 1;
            continue;
            bool1 = false;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("PTSAppLoader", 1, "[checkPTSApp], e = " + localException);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[checkPTSApp], bid = ").append(paramString).append("\n").append(", appPath = ").append(str1).append("\n").append(", ptsAppVersion = ").append(jdField_a_of_type_JavaLangString).append("\n").append(", isAppExists = ").append(bool2).append("\n").append(", isAppValid = ").append(bool3).append("\n").append(", configPath = ").append(str2).append("\n").append(", isAppVersionValid = ").append(bool4).append("\n").append(", isAppOfflineDirValid = ").append(this.jdField_a_of_type_Boolean).append("\n").append(", appNameList = ");
        int i = j;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localStringBuilder.append("[").append(i).append("]: ").append((String)this.jdField_a_of_type_JavaUtilList.get(i)).append("\n");
          i += 1;
        }
        QLog.i("PTSAppLoader", 1, localStringBuilder.toString());
      }
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = OfflineEnvHelper.a(paramString) + paramString;
    QLog.i("PTSAppLoader", 1, "[getPTSAppDownloadPath], bid = " + paramString + ", path = " + str);
    return str;
  }
  
  public void a()
  {
    b();
    PTSAppLoader.1 local1 = new PTSAppLoader.1(this);
    ThreadManager.getSubThreadHandler().postDelayed(local1, 10000L);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilList.contains(paramString);
    QLog.i("PTSAppLoader", 1, "[isPTSAppReady], appName = " + paramString + ", isAppExists = " + bool + ", isAppOfflineDirValid = " + this.jdField_a_of_type_Boolean);
    return (this.jdField_a_of_type_Boolean) && (bool);
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      b("3978");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSAppLoader
 * JD-Core Version:    0.7.0.1
 */