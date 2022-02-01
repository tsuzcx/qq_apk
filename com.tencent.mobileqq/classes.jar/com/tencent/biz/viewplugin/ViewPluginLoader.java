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
    paramString1 = new StringBuilder();
    paramString1.append(BaseApplicationImpl.getContext().getFilesDir());
    paramString1.append("/pluginopt/");
    paramString1.append(paramString2);
    paramString1.append("/opt");
    this.c = paramString1.toString();
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("viewplugin_sp", 0);
    jdField_a_of_type_JavaUtilHashMap.put(paramString2, this);
    paramString1 = new StringBuilder();
    paramString1.append(Environment.getExternalStorageDirectory().getPath());
    paramString1.append("/tencent/plugins/");
    this.f = paramString1.toString();
  }
  
  public DownloaderInterface a()
  {
    return ((DownloaderFactory)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
  }
  
  public void a()
  {
    Object localObject1 = (WerewolvesHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER);
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        ((WerewolvesHandler)localObject1).notifyUI(3, true, Integer.valueOf(4));
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("https://");
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject3).append("?_bid=");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      long l = System.currentTimeMillis();
      if ((!HtmlOffline.a(BaseApplicationImpl.getContext(), (String)localObject3, new ViewPluginLoader.2(this, l, (WerewolvesHandler)localObject1, localBaseApplication))) && (QLog.isColorLevel()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("plugin:");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(" transToLocalUrl: return false");
        QLog.i("ViewPluginLoader", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally {}
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    ViewPluginContext localViewPluginContext = this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext;
    if (localViewPluginContext != null)
    {
      this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(paramBaseActivity, 0, localViewPluginContext);
      return;
    }
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = new ViewPluginContext(paramBaseActivity, 0, this.e, this.jdField_a_of_type_JavaLangClassLoader);
  }
  
  public void a(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface)
  {
    int i = paramJSONObject.optInt("code");
    paramQQAppInterface = OfflineEnvHelper.b(this.jdField_a_of_type_JavaLangString);
    boolean bool2 = TextUtils.isEmpty(paramQQAppInterface);
    boolean bool1 = true;
    if (!bool2)
    {
      StringBuilder localStringBuilder;
      if (i == 4)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQAppInterface);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(".7z");
        paramQQAppInterface = localStringBuilder.toString();
        bool1 = true;
        break label195;
      }
      if ((i != 3) && (i != 2))
      {
        QLog.e("ViewPluginLoader", 1, "do not know what format, use default zip name!");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQAppInterface);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(".zip");
        paramQQAppInterface = localStringBuilder.toString();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQAppInterface);
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(".zip");
        paramQQAppInterface = localStringBuilder.toString();
        bool2 = false;
        break label206;
      }
    }
    else
    {
      paramQQAppInterface = null;
    }
    bool1 = false;
    label195:
    boolean bool3 = false;
    bool2 = bool1;
    bool1 = bool3;
    label206:
    ThreadManager.post(new ViewPluginLoader.5(this, paramJSONObject, paramQQAppInterface, new ViewPluginLoader.4(this, paramQQAppInterface, bool1, bool2)), 8, null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    b();
  }
  
  public boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      str = this.jdField_a_of_type_JavaLangString;
      boolean bool2 = TextUtils.isEmpty(str);
      bool1 = false;
      if (bool2) {
        return false;
      }
      bool2 = TextUtils.isEmpty(OfflineEnvHelper.b(str));
      if (bool2) {
        return false;
      }
      localObject2 = new File(paramString);
      if (!((File)localObject2).exists())
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("doUnzipZip: no zip ! : businessId:");
          paramString.append(str);
          QLog.i("ViewPluginLoader", 2, paramString.toString());
        }
        return false;
      }
      l = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((File)localObject2).getParent());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = BidDownloader.a(paramString);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fileFormat: ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(", path: ");
        localStringBuilder.append(paramString);
        QLog.i("ViewPluginLoader", 2, localStringBuilder.toString());
      }
      bool2 = TextUtils.isEmpty((CharSequence)localObject3);
      i = 1;
      if (!bool2)
      {
        if (((String)localObject3).equals("zip"))
        {
          i = ZipUtils.unZipFolder(paramString, (String)localObject1);
          break label715;
        }
        if (((String)localObject3).equals("7z"))
        {
          i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, (String)localObject1);
          break label715;
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("can not recognize download compress file format, ");
        ((StringBuilder)localObject3).append(paramString);
        QLog.w("ViewPluginLoader", 1, ((StringBuilder)localObject3).toString());
        if (paramBoolean1) {
          i = ZipUtils.unZipFolder(paramString, (String)localObject1);
        } else if (paramBoolean2) {
          i = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramString, (String)localObject1);
        }
      }
    }
    finally
    {
      label715:
      label718:
      for (;;)
      {
        String str;
        boolean bool1;
        Object localObject2;
        long l;
        Object localObject1;
        Object localObject3;
        StringBuilder localStringBuilder;
        int i;
        for (;;)
        {
          throw paramString;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("now delete original download offline zip, path: ");
      ((StringBuilder)localObject3).append(paramString);
      QLog.i("ViewPluginLoader", 2, ((StringBuilder)localObject3).toString());
    }
    Util.b(paramString);
    if (i > 0)
    {
      HtmlOffline.a(str, 13, 0L, i, "lixian_update", "0");
      paramBoolean1 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("ViewPluginLoader", 2, "unZipFolder fail!");
        paramBoolean1 = bool1;
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append(File.separator);
      paramString.append(str);
      paramString.append(".zip");
      paramString = paramString.toString();
      localObject3 = new File(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject2).getParent());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".zip");
      str = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("now move zip file to location: ");
        ((StringBuilder)localObject2).append(str);
        QLog.i("ViewPluginLoader", 2, ((StringBuilder)localObject2).toString());
      }
      paramBoolean1 = bool1;
      if (((File)localObject3).exists())
      {
        paramBoolean1 = ((File)localObject3).renameTo(new File(str));
        if (paramBoolean1) {
          break label718;
        }
        paramBoolean1 = FileUtils.moveFile(paramString, str);
      }
    }
    Util.a((String)localObject1);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("time of unzip zip：");
      paramString.append(System.currentTimeMillis() - l);
      paramString.append(", isSuccess: ");
      paramString.append(paramBoolean1);
      QLog.i("ViewPluginLoader", 2, paramString.toString());
    }
    return paramBoolean1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    HtmlOffline.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool;
    if ((localQQAppInterface != null) && (localQQAppInterface.getLongAccountUin() % 10L == 6L)) {
      bool = true;
    } else {
      bool = false;
    }
    HtmlOffline.jdField_a_of_type_Boolean = bool;
    Object localObject = HtmlOffline.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkOfflineAndLoad version = ");
      localStringBuilder.append((String)localObject);
      QLog.d("ViewPluginLoader", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(OfflineEnvHelper.a(this.jdField_a_of_type_JavaLangString));
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    if ((!new File(localStringBuilder.toString()).exists()) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!"0".equals(localObject)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(OfflineEnvHelper.a(this.jdField_a_of_type_JavaLangString));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      FileUtils.deleteDirectory(((StringBuilder)localObject).toString());
    }
    if (localQQAppInterface == null) {
      return;
    }
    HtmlOffline.a(this.jdField_a_of_type_JavaLangString, localQQAppInterface, new ViewPluginLoader.3(this, localQQAppInterface), false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizViewpluginViewPluginContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader
 * JD-Core Version:    0.7.0.1
 */