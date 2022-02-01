package com.tencent.biz.viewplugin;

import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.offline.util.OfflineDownloader;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class ViewPluginLoader
{
  public static final HashMap<String, ViewPluginLoader> a;
  int jdField_a_of_type_Int = 0;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  OfflineDownloader jdField_a_of_type_ComTencentBizCommonOfflineUtilOfflineDownloader = new OfflineDownloader();
  public ViewPluginContext a;
  public ClassLoader a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public volatile boolean a;
  public String b;
  boolean b;
  String c = null;
  String d;
  public String e;
  private String f;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ViewPluginLoader(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = (BaseApplicationImpl.getContext().getFilesDir() + "/pluginopt/" + paramString2 + "/opt");
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("viewplugin_sp", 0);
    jdField_a_of_type_JavaUtilHashMap.put(paramString2, this);
    this.f = (Environment.getExternalStorageDirectory().getPath() + "/tencent/plugins/");
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public void a()
  {
    WerewolvesHandler localWerewolvesHandler = (WerewolvesHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        localWerewolvesHandler.notifyUI(3, true, Integer.valueOf(4));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      String str = "https://" + this.jdField_b_of_type_JavaLangString + "?_bid=" + this.jdField_a_of_type_JavaLangString;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      long l = System.currentTimeMillis();
      if ((!HtmlOffline.a(BaseApplicationImpl.getContext(), str, new ViewPluginLoader.2(this, l, localWerewolvesHandler, localBaseApplication))) && (QLog.isColorLevel()))
      {
        QLog.i("ViewPluginLoader", 2, "plugin:" + this.jdField_b_of_type_JavaLangString + " transToLocalUrl: return false");
        return;
      }
    }
    finally {}
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    if (this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext != null)
    {
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(paramBaseActivity, 0, this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext);
      return;
    }
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(paramBaseActivity, 0, this.e, this.jdField_a_of_type_JavaLangClassLoader);
  }
  
  public void a(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    int i = paramJSONObject.optInt("code");
    paramQQAppInterface = OfflineEnvHelper.b(this.jdField_a_of_type_JavaLangString);
    boolean bool2;
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      if (i == 4)
      {
        paramQQAppInterface = paramQQAppInterface + this.jdField_a_of_type_JavaLangString + ".7z";
        bool2 = false;
      }
    }
    for (;;)
    {
      ThreadManager.post(new ViewPluginLoader.5(this, paramJSONObject, paramQQAppInterface, new ViewPluginLoader.4(this, paramQQAppInterface, bool2, bool1)), 8, null, false);
      return;
      if ((i == 3) || (i == 2))
      {
        paramQQAppInterface = paramQQAppInterface + this.jdField_a_of_type_JavaLangString + ".zip";
        bool2 = true;
        bool1 = false;
      }
      else
      {
        QLog.e("ViewPluginLoader", 1, "do not know what format, use default zip name!");
        paramQQAppInterface = paramQQAppInterface + this.jdField_a_of_type_JavaLangString + ".zip";
        bool2 = false;
        bool1 = false;
        continue;
        bool1 = false;
        bool2 = false;
        paramQQAppInterface = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    b();
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    for (;;)
    {
      String str2;
      File localFile;
      String str1;
      Object localObject;
      try
      {
        str2 = this.jdField_a_of_type_JavaLangString;
        boolean bool = TextUtils.isEmpty(str2);
        if (bool)
        {
          paramBoolean2 = false;
          return paramBoolean2;
        }
        if (TextUtils.isEmpty(OfflineEnvHelper.b(str2)))
        {
          paramBoolean2 = false;
          continue;
        }
        localFile = new File(paramString);
        if (!localFile.exists())
        {
          if (!QLog.isColorLevel()) {
            break label596;
          }
          QLog.i("ViewPluginLoader", 2, "doUnzipZip: no zip ! : businessId:" + str2);
          break label596;
        }
        long l = System.currentTimeMillis();
        str1 = localFile.getParent() + File.separator + str2;
        localObject = BidDownloader.a(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "fileFormat: " + (String)localObject + ", path: " + paramString);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label379;
        }
        if (((String)localObject).equals("zip"))
        {
          i = ZipUtils.unZipFolder(paramString, str1);
          if (QLog.isColorLevel()) {
            QLog.i("ViewPluginLoader", 2, "now delete original download offline zip, path: " + paramString);
          }
          Util.b(paramString);
          if (i <= 0) {
            break label441;
          }
          HtmlOffline.a(str2, 13, 0L, i, "lixian_update", "0");
          if (!QLog.isColorLevel()) {
            break label591;
          }
          QLog.i("ViewPluginLoader", 2, "unZipFolder fail!");
          paramBoolean1 = false;
          Util.a(str1);
          paramBoolean2 = paramBoolean1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ViewPluginLoader", 2, "time of unzip zip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + paramBoolean1);
          paramBoolean2 = paramBoolean1;
          continue;
        }
        if (!((String)localObject).equals("7z")) {
          continue;
        }
      }
      finally {}
      i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
      continue;
      label379:
      QLog.w("ViewPluginLoader", 1, "can not recognize download compress file format, " + paramString);
      if (paramBoolean1)
      {
        i = ZipUtils.unZipFolder(paramString, str1);
      }
      else if (paramBoolean2)
      {
        i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, str1);
        continue;
        label441:
        paramString = str1 + File.separator + str2 + ".zip";
        localObject = new File(paramString);
        str2 = localFile.getParent() + File.separator + str2 + ".zip";
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "now move zip file to location: " + str2);
        }
        if (((File)localObject).exists())
        {
          paramBoolean2 = ((File)localObject).renameTo(new File(str2));
          paramBoolean1 = paramBoolean2;
          if (!paramBoolean2) {
            paramBoolean1 = FileUtils.b(paramString, str2);
          }
        }
        else
        {
          label591:
          paramBoolean1 = false;
          continue;
          label596:
          paramBoolean2 = false;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    HtmlOffline.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (localQQAppInterface.getLongAccountUin() % 10L == 6L)) {}
    for (boolean bool = true;; bool = false)
    {
      HtmlOffline.jdField_a_of_type_Boolean = bool;
      String str = HtmlOffline.a(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ViewPluginLoader", 2, "checkOfflineAndLoad version = " + str);
      }
      if ((!new File(OfflineEnvHelper.a(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_JavaLangString + "/" + this.jdField_b_of_type_JavaLangString).exists()) && (!TextUtils.isEmpty(str)) && (!"0".equals(str))) {
        FileUtils.a(OfflineEnvHelper.a(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_JavaLangString);
      }
      if (localQQAppInterface != null) {
        break;
      }
      return;
    }
    HtmlOffline.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface, new ViewPluginLoader.3(this, localQQAppInterface), false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader
 * JD-Core Version:    0.7.0.1
 */