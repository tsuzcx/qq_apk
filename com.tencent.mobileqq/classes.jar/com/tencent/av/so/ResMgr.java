package com.tencent.av.so;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ResMgr
{
  private static volatile ResMgr d;
  private static final String[] e = { "libSDKCommon.so", "libVideoCtrl.so", "libqav_gaudio_engine.so", "libqav_graphics.so", "libqav_media_engine.so" };
  ArrayList<ResMgr.ResDownloadStateListener> a = new ArrayList();
  private ArrayList<ResInfo> b = new ArrayList();
  private final Object c = new Object();
  
  private ResMgr()
  {
    Object localObject = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ResMgr for ");
    localStringBuilder.append(((MobileQQ)localObject).getQQProcessName());
    QLog.i("AVResMgr", 1, localStringBuilder.toString());
    a((MobileQQ)localObject);
    this.b = b();
    if (this.b == null) {
      this.b = new ArrayList();
    }
    int i = 0;
    while (i < ResInfo.ALL_RES_ID_LIST.length)
    {
      if (this.b.size() > 0)
      {
        j = 0;
        while (j < this.b.size())
        {
          if (ResInfo.ALL_RES_ID_LIST[i].equalsIgnoreCase(((ResInfo)this.b.get(j)).resId))
          {
            j = 1;
            break label182;
          }
          j += 1;
        }
      }
      int j = 0;
      label182:
      if (j == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init. delete local old res. resId = ");
        ((StringBuilder)localObject).append(ResInfo.ALL_RES_ID_LIST[i]);
        QLog.i("AVResMgr", 1, ((StringBuilder)localObject).toString());
        b(b(ResInfo.ALL_RES_ID_LIST[i]), "");
      }
      i += 1;
    }
  }
  
  public static ResMgr a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new ResMgr();
        }
      }
      finally {}
    }
    return d;
  }
  
  public static String a(ResInfo paramResInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVSoUtils.b());
    localStringBuilder.append("qavRes");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramResInfo.resType);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramResInfo.resId);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramResInfo.resVersion);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramResInfo.resMd5);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getFileMD5String(paramString1)))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFileValid failed. check md5 failed. fileName = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", md5FromConfig = ");
        localStringBuilder.append(paramString2);
        QLog.e("AVResMgr", 1, localStringBuilder.toString());
        return false;
      }
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkFileValid failed. file is not exist. fileName = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", md5FromConfig = ");
    localStringBuilder.append(paramString2);
    QLog.e("AVResMgr", 1, localStringBuilder.toString());
    return false;
  }
  
  private boolean a(MobileQQ paramMobileQQ)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY");
    localIntentFilter.addAction("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
    return paramMobileQQ.registerReceiver(new ResMgr.1(this), localIntentFilter) != null;
  }
  
  public static String b(ResInfo paramResInfo)
  {
    if (paramResInfo == null)
    {
      QLog.e("AVResMgr", 1, "getResIdRootDir failed. resInfo == null.");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVSoUtils.b());
    localStringBuilder.append("qavRes");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramResInfo.resType);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramResInfo.resId);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AVResMgr", 1, "getResIdRootDir failed. resId is empty.");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVSoUtils.b());
    localStringBuilder.append("qavRes");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(ResInfo.getResType(paramString));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static ArrayList<ResInfo> b()
  {
    return h(QAVConfigUtils.a(287, QAVConfigUtils.b).getString("SP_KEY_CONFIG_367", ""));
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (paramString2.endsWith(File.separator)) {
        str = paramString2.substring(0, paramString2.length() - 1);
      }
    }
    return c(paramString1, str);
  }
  
  public static String c()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(BaseApplication.getContext().getFilesDir().getParent());
    ((StringBuilder)localObject1).append("/txlib/3ALicense/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("medialab_audio_3a_license.txt");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = QAVConfigUtils.a(287, QAVConfigUtils.b);
    Object localObject3 = ((SharedPreferences)localObject2).getString("audio3ALicenseFileMd5", "");
    if (a((String)localObject1, (String)localObject3))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAudio3ALicenseFilename successfully. licenseFullFilename = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", licenseFileMd5FromStorage = ");
      ((StringBuilder)localObject2).append((String)localObject3);
      QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    try
    {
      localObject3 = BaseApplication.getContext().getAssets().open("medialab_audio_3a_license.txt");
      FileOutputStream localFileOutputStream = new FileOutputStream((String)localObject1);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = ((InputStream)localObject3).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localFileOutputStream.flush();
      ((InputStream)localObject3).close();
      localFileOutputStream.close();
      localObject3 = ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getFileMD5String((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        QLog.e("AVResMgr", 1, "getAudio3ALicenseFilename failed. calc md5 failed.");
        return "";
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      ((SharedPreferences.Editor)localObject2).putString("audio3ALicenseFileMd5", (String)localObject3);
      ((SharedPreferences.Editor)localObject2).commit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAudio3ALicenseFilename successfully. licenseFullFilename = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", licenseFileMd5FromCalc = ");
      ((StringBuilder)localObject2).append((String)localObject3);
      QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAudio3ALicenseFilename failed. decompress failed. error msg = ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("AVResMgr", 1, ((StringBuilder)localObject2).toString());
    }
    return "";
  }
  
  private static boolean c(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("deleteDir. dir = ");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(", excludeSubDirOrFile = ");
    localStringBuilder1.append(paramString2);
    QLog.i("AVResMgr", 1, localStringBuilder1.toString());
    paramString1 = new File(paramString1).listFiles();
    int i = 0;
    if (paramString1 == null) {
      return false;
    }
    boolean bool = false;
    while (i < paramString1.length)
    {
      localStringBuilder1 = paramString1[i];
      StringBuilder localStringBuilder2;
      if (!localStringBuilder1.getAbsolutePath().equalsIgnoreCase(paramString2))
      {
        if (localStringBuilder1.isDirectory())
        {
          bool = c(localStringBuilder1.getAbsolutePath(), paramString2);
          if (bool)
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = ");
            localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
            QLog.i("AVResMgr", 1, localStringBuilder2.toString());
          }
          else
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("deleteDir. delete dir or file = ");
            localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
            QLog.i("AVResMgr", 1, localStringBuilder2.toString());
            localStringBuilder1.delete();
            break label302;
          }
        }
        else
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("deleteDir. delete dir or file = ");
          localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
          QLog.i("AVResMgr", 1, localStringBuilder2.toString());
          localStringBuilder1.delete();
          break label302;
        }
      }
      else
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("deleteDir. do not delete excludeSubDirOrFile. curSubDirOrFile  = ");
        localStringBuilder2.append(localStringBuilder1.getAbsolutePath());
        QLog.i("AVResMgr", 1, localStringBuilder2.toString());
      }
      bool = true;
      label302:
      i += 1;
    }
    return bool;
  }
  
  public static void d()
  {
    String str = a().d("AVAINSMediaLabGruModel");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AVResMgr", 1, "onDownloadAVAINSGruModelFinish failed. resDir is empty.");
      return;
    }
    Object localObject1 = (IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("gru_16k.bin");
    localObject1 = ((IExternalUtilsApi)localObject1).getFileMD5String(((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.e("AVResMgr", 1, "onDownloadAVAINSGruModelFinish failed. calc modelFileMd5 failed.");
      return;
    }
    localObject2 = QAVConfigUtils.a(287, QAVConfigUtils.b).edit();
    ((SharedPreferences.Editor)localObject2).putString("audioAINSGruModelFileMd5", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).putString("audioAINSGruModelDir", str);
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onDownloadAVAINSGruModelFinish. modelFileMd5 = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", resDir = ");
    ((StringBuilder)localObject2).append(str);
    QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
  }
  
  public static String e()
  {
    Object localObject2 = QAVConfigUtils.a(287, QAVConfigUtils.b);
    Object localObject1 = ((SharedPreferences)localObject2).getString("audioAINSGruModelFileMd5", "");
    localObject2 = ((SharedPreferences)localObject2).getString("audioAINSGruModelDir", "");
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("gru_16k.bin");
    localObject3 = ((StringBuilder)localObject3).toString();
    if (a((String)localObject3, (String)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAVAINSGruModelDir sucessfully. modelDir = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("AVResMgr", 1, ((StringBuilder)localObject1).toString());
      return localObject2;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getAVAINSGruModelDir failed. checkFileValid failed. modelFilename=");
    ((StringBuilder)localObject1).append((String)localObject3);
    QLog.e("AVResMgr", 1, ((StringBuilder)localObject1).toString());
    ThreadManager.getSubThreadHandler().post(new ResMgr.3());
    return "";
  }
  
  public static void e(String paramString)
  {
    QLog.i("AVResMgr", 1, "saveNewConfig.");
    SharedPreferences.Editor localEditor = QAVConfigUtils.a(287, QAVConfigUtils.b).edit();
    localEditor.putString("SP_KEY_CONFIG_367", paramString);
    localEditor.commit();
  }
  
  public static void f()
  {
    String str = a().d("AVTraeSo");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AVResMgr", 1, "onDownloadAVTraeSoFinish failed. resDir is empty.");
      return;
    }
    Object localObject1 = (IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("libtraeimp-qq.so");
    localObject1 = ((IExternalUtilsApi)localObject1).getFileMD5String(((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.e("AVResMgr", 1, "onDownloadAVTraeSoFinish failed. calc soFileMd5 failed.");
      return;
    }
    localObject2 = QAVConfigUtils.a(287, QAVConfigUtils.b).edit();
    ((SharedPreferences.Editor)localObject2).putString("AVTraeSoFileMd5", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).putString("AVTraeSoDir", str);
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onDownloadAVTraeSoFinish. soFileMd5 = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", resDir = ");
    ((StringBuilder)localObject2).append(str);
    QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
  }
  
  public static String g()
  {
    Object localObject2 = QAVConfigUtils.a(287, QAVConfigUtils.b);
    Object localObject1 = ((SharedPreferences)localObject2).getString("AVTraeSoFileMd5", "");
    localObject2 = ((SharedPreferences)localObject2).getString("AVTraeSoDir", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("libtraeimp-qq.so");
    if (a(localStringBuilder.toString(), (String)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAVTraeSoDir sucessfully. soDir = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("AVResMgr", 1, ((StringBuilder)localObject1).toString());
      return localObject2;
    }
    QLog.e("AVResMgr", 1, "getAVTraeSoDir failed. checkFileValid failed.");
    ThreadManager.getSubThreadHandler().post(new ResMgr.4());
    return "";
  }
  
  private static ArrayList<ResInfo> h(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getResInfoListFromConfig. config = ");
    localStringBuilder.append(paramString);
    QLog.i("AVResMgr", 1, localStringBuilder.toString());
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("AVResMgr", 1, "updateResInfoList failed. config is empty.");
        return new ArrayList();
      }
      paramString = ResInfo.parseConfig(new JSONObject(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateResInfoList failed. exception = ");
      localStringBuilder.append(paramString);
      QLog.e("AVResMgr", 1, localStringBuilder.toString());
    }
    return new ArrayList();
  }
  
  public static void h()
  {
    Object localObject1 = a().d("AVSDKSo");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.e("AVResMgr", 1, "onDownloadAVSDKSoFinish failed. resDir is empty.");
      return;
    }
    Object localObject2 = QAVConfigUtils.a(287, QAVConfigUtils.b).edit();
    int i = 0;
    while (i < e.length)
    {
      Object localObject3 = (IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(e[i]);
      localObject3 = ((IExternalUtilsApi)localObject3).getFileMD5String(localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onDownloadAVSDKSoFinish failed. calc soFileMd5 failed. so = ");
        ((StringBuilder)localObject1).append(e[i]);
        QLog.e("AVResMgr", 1, ((StringBuilder)localObject1).toString());
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e[i]);
      localStringBuilder.append("AVSoFileMd5");
      ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), (String)localObject3);
      i += 1;
    }
    ((SharedPreferences.Editor)localObject2).putString("AVSDKSoDir", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onDownloadAVSDKSoFinish. resDir = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
  }
  
  public static String i()
  {
    Object localObject2 = QAVConfigUtils.a(287, QAVConfigUtils.b);
    Object localObject1 = ((SharedPreferences)localObject2).getString("AVSDKSoDir", "");
    int i = 0;
    while (i < e.length)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(e[i]);
      ((StringBuilder)localObject3).append("AVSoFileMd5");
      localObject3 = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject3).toString(), "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(e[i]);
      if (!a(localStringBuilder.toString(), (String)localObject3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getAVSDKSoDir failed. checkFileValid failed. so = ");
        ((StringBuilder)localObject1).append(e[i]);
        QLog.e("AVResMgr", 1, ((StringBuilder)localObject1).toString());
        ThreadManager.getSubThreadHandler().post(new ResMgr.5());
        return "";
      }
      i += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getAVSDKSoDir sucessfully. soDir = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("AVResMgr", 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public boolean a(String paramString)
  {
    ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).notifyQQDownload(paramString);
    return true;
  }
  
  public String c(String paramString)
  {
    paramString = f(paramString);
    if (paramString == null)
    {
      QLog.e("AVResMgr", 1, "getResFullFileName failed. resInfo == null.");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramString));
    localStringBuilder.append(paramString.resFileName);
    return localStringBuilder.toString();
  }
  
  public String d(String paramString)
  {
    paramString = f(paramString);
    if (paramString == null)
    {
      QLog.e("AVResMgr", 1, "getResDirByResId failed. resInfo == null.");
      return "";
    }
    return a(paramString);
  }
  
  public ResInfo f(String paramString)
  {
    int i;
    label86:
    synchronized (this.c)
    {
      if (this.b == null)
      {
        return null;
        if (i < this.b.size())
        {
          if (!((ResInfo)this.b.get(i)).resId.equalsIgnoreCase(paramString)) {
            break label86;
          }
          paramString = (ResInfo)this.b.get(i);
          return paramString;
        }
        return null;
      }
    }
  }
  
  public boolean g(String paramString)
  {
    ResInfo localResInfo = f(paramString);
    if (localResInfo == null) {
      return false;
    }
    return a(c(paramString), localResInfo.resMd5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.so.ResMgr
 * JD-Core Version:    0.7.0.1
 */