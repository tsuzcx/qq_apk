package com.tencent.av.so;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ResMgr
{
  private static volatile ResMgr jdField_a_of_type_ComTencentAvSoResMgr;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  ArrayList<ResMgr.ResDownloadStateListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ArrayList<ResInfo> b;
  
  private ResMgr()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    QLog.i("AVResMgr", 1, "ResMgr for " + localBaseApplicationImpl.getQQProcessName());
    a(localBaseApplicationImpl);
    this.b = a();
    if (this.b == null) {
      this.b = new ArrayList();
    }
  }
  
  public static ResMgr a()
  {
    if (jdField_a_of_type_ComTencentAvSoResMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvSoResMgr == null) {
        jdField_a_of_type_ComTencentAvSoResMgr = new ResMgr();
      }
      return jdField_a_of_type_ComTencentAvSoResMgr;
    }
    finally {}
  }
  
  public static String a()
  {
    String str = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/" + "medialab_audio_3a_license.txt";
    Object localObject1 = EffectConfigBase.a(287, EffectConfigBase.c);
    Object localObject2 = ((SharedPreferences)localObject1).getString("audio3ALicenseFileMd5", "");
    if (a(str, (String)localObject2))
    {
      QLog.i("AVResMgr", 1, "getAudio3ALicenseFilename successfully. licenseFullFilename = " + str + ", licenseFileMd5FromStorage = " + (String)localObject2);
      return str;
    }
    FileOutputStream localFileOutputStream;
    try
    {
      localObject2 = BaseApplicationImpl.getContext().getAssets().open("medialab_audio_3a_license.txt");
      localFileOutputStream = new FileOutputStream(str);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = ((InputStream)localObject2).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localFileOutputStream.flush();
    }
    catch (Exception localException)
    {
      QLog.e("AVResMgr", 1, "getAudio3ALicenseFilename failed. decompress failed. error msg = " + localException.getMessage());
      return "";
    }
    ((InputStream)localObject2).close();
    localFileOutputStream.close();
    localObject2 = PortalUtils.a(localException);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.e("AVResMgr", 1, "getAudio3ALicenseFilename failed. calc md5 failed.");
      return "";
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    ((SharedPreferences.Editor)localObject1).putString("audio3ALicenseFileMd5", (String)localObject2);
    ((SharedPreferences.Editor)localObject1).commit();
    QLog.i("AVResMgr", 1, "getAudio3ALicenseFilename successfully. licenseFullFilename = " + localException + ", licenseFileMd5FromCalc = " + (String)localObject2);
    return localException;
  }
  
  public static String a(ResInfo paramResInfo)
  {
    return AVSoUtils.b() + "qavRes" + File.separator + paramResInfo.resType + File.separator + paramResInfo.resId + File.separator + paramResInfo.resVersion + File.separator + paramResInfo.resMd5 + File.separator;
  }
  
  public static ArrayList<ResInfo> a()
  {
    Object localObject = QAVConfig.b(367).a;
    QLog.i("AVResMgr", 1, "getResInfoListFromConfig. jsonContent = " + (String)localObject);
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("AVResMgr", 1, "updateResInfoList failed. jsonContent is empty.");
        return new ArrayList();
      }
      localObject = ResInfo.parseConfig(new JSONObject((String)localObject));
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("AVResMgr", 1, "updateResInfoList failed. exception = " + localException);
    }
    return new ArrayList();
  }
  
  public static void a()
  {
    String str1 = a().b("AVAINSMediaLabModel");
    String str2 = PortalUtils.a(str1 + "chimera_20ms_android_int8.bin");
    if (TextUtils.isEmpty(str2))
    {
      QLog.e("AVResMgr", 1, "onDownloadAudioAINSModelSuccess failed. calc modelFileMd5 failed.");
      return;
    }
    String str3 = PortalUtils.a(str1 + "chimera_20ms_android_table.json");
    if (TextUtils.isEmpty(str3))
    {
      QLog.e("AVResMgr", 1, "onDownloadAudioAINSModelSuccess failed. calc modelTableFileMd5 failed.");
      return;
    }
    String str4 = PortalUtils.a(str1 + "chimera_20ms.json");
    if (TextUtils.isEmpty(str4))
    {
      QLog.e("AVResMgr", 1, "onDownloadAudioAINSModelSuccess failed. calc modelBaseFileMd5 failed.");
      return;
    }
    SharedPreferences.Editor localEditor = EffectConfigBase.a(287, EffectConfigBase.c).edit();
    localEditor.putString("audioAINSModelFileMd5", str2);
    localEditor.putString("audioAINSModelTableFileMd5", str3);
    localEditor.putString("audioAINSModelBaseFileMd5", str4);
    localEditor.putString("audioAINSModelDir", str1);
    localEditor.commit();
    QLog.i("AVResMgr", 1, "onDownloadAudioAINSModelSuccess. modelFileMd5 = " + str2 + ", modelTableFileMd5 = " + str3 + ", modelBaseFileMd5 = " + str4 + ", modelDir = " + str1);
  }
  
  private boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ACTION_QAV_RES_DOWNLOAD_STATE_NOTIFY");
    localIntentFilter.addAction("ACTION_QAV_RES_NEW_CONFIG_NOTIFY");
    return paramBaseApplicationImpl.registerReceiver(new ResMgr.1(this), localIntentFilter) != null;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      if (!paramString2.equalsIgnoreCase(PortalUtils.a(paramString1)))
      {
        QLog.e("AVResMgr", 1, "checkFileValid failed. check md5 failed. fileName = " + paramString1 + ", md5FromConfig = " + paramString2);
        return false;
      }
      return true;
    }
    QLog.e("AVResMgr", 1, "checkFileValid failed. file is not exist. fileName = " + paramString1 + ", md5FromConfig = " + paramString2);
    return false;
  }
  
  public static String b()
  {
    if ((Build.MODEL.equalsIgnoreCase("PCEM00")) || (Build.MODEL.equalsIgnoreCase("PCAM10")) || (Build.MODEL.equalsIgnoreCase("PADM00")) || (Build.MODEL.equalsIgnoreCase("PADT00")) || (Build.MODEL.equalsIgnoreCase("PCAT10")) || (Build.MODEL.equalsIgnoreCase("V1821A"))) {
      return "";
    }
    Object localObject = EffectConfigBase.a(287, EffectConfigBase.c);
    String str1 = ((SharedPreferences)localObject).getString("audioAINSModelFileMd5", "");
    String str2 = ((SharedPreferences)localObject).getString("audioAINSModelTableFileMd5", "");
    String str3 = ((SharedPreferences)localObject).getString("audioAINSModelBaseFileMd5", "");
    localObject = ((SharedPreferences)localObject).getString("audioAINSModelDir", "");
    String str4 = (String)localObject + "chimera_20ms_android_int8.bin";
    String str5 = (String)localObject + "chimera_20ms_android_table.json";
    String str6 = (String)localObject + "chimera_20ms.json";
    if ((a(str4, str1)) && (a(str5, str2)) && (a(str6, str3)))
    {
      QLog.i("AVResMgr", 1, "getAudioAINSModelDir sucessfully. modelDir = " + (String)localObject);
      return localObject;
    }
    QLog.e("AVResMgr", 1, "getAudioAINSModelDir failed. checkFileValid failed.");
    ThreadManager.getSubThreadHandler().post(new ResMgr.2());
    return "";
  }
  
  public static String b(ResInfo paramResInfo)
  {
    if (paramResInfo == null)
    {
      QLog.e("AVResMgr", 1, "getResIdRootDir failed. resInfo == null.");
      return "";
    }
    return AVSoUtils.b() + "qavRes" + File.separator + paramResInfo.resType + File.separator + paramResInfo.resId + File.separator;
  }
  
  public ResInfo a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.b.size())
        {
          if (((ResInfo)this.b.get(i)).resId.equalsIgnoreCase(paramString))
          {
            paramString = (ResInfo)this.b.get(i);
            return paramString;
          }
        }
        else {
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null)
    {
      QLog.e("AVResMgr", 1, "getResFullFileName failed. resInfo == null.");
      return "";
    }
    return a(paramString) + paramString.resFileName;
  }
  
  public boolean a(String paramString)
  {
    BusinessCommonConfig.notifyQQDownload(3, paramString, 0);
    return true;
  }
  
  public String b(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null)
    {
      QLog.e("AVResMgr", 1, "getResDirByResId failed. resInfo == null.");
      return "";
    }
    return a(paramString);
  }
  
  public boolean b(String paramString)
  {
    ResInfo localResInfo = a(paramString);
    if (localResInfo == null) {
      return false;
    }
    return a(a(paramString), localResInfo.resMd5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.so.ResMgr
 * JD-Core Version:    0.7.0.1
 */