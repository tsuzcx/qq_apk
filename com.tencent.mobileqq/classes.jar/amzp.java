import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoDataBase;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class amzp
  extends amza
{
  public amzp(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
  }
  
  public int a()
  {
    return 10048;
  }
  
  public String a()
  {
    return "qavDownloadSoDuration";
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
    if ((paramXmlData == null) || (!(paramXmlData instanceof QavSoDataBase)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp ends. respData is not QavSoDataBase");
      }
      super.a(paramXmlData);
      return;
    }
    QavSoDataBase localQavSoDataBase = (QavSoDataBase)paramXmlData;
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "doOnServerResp url:" + paramXmlData.strResURL_big + ", md5:" + paramXmlData.MD5 + ", m_TcHevcDec =" + localQavSoDataBase.m_TcHevcDec + ", m_TcHevcDec2 = " + localQavSoDataBase.m_TcHevcDec2 + ", m_TcHevcEnc = " + localQavSoDataBase.m_TcHevcEnc);
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = a();
    String str2;
    Object localObject3;
    String str1;
    Object localObject2;
    if (localObject1 != null)
    {
      str2 = "QAVSOMD5__" + ((XmlData)localObject1).getSharedPreferencesName();
      localObject3 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
      str1 = ((SharedPreferences)localObject3).getString(str2, null);
      localObject2 = bcdu.a(paramString);
      if ((TextUtils.isEmpty(((XmlData)localObject1).MD5)) || (!((XmlData)localObject1).MD5.equalsIgnoreCase((String)localObject2)))
      {
        localObject3 = new StringBuilder().append("download success but check md5 failed. config zip file md5 = ");
        if (!TextUtils.isEmpty(((XmlData)localObject1).MD5)) {}
        for (localObject1 = ((XmlData)localObject1).MD5;; localObject1 = "null")
        {
          QLog.e("QavSoDownloadHandlerBase", 1, (String)localObject1 + ", realZipFileMd5 = " + (String)localObject2);
          paramString = new File(paramString);
          if (paramString.exists()) {
            paramString.delete();
          }
          return;
        }
      }
      QLog.d("QavSoDownloadHandlerBase", 1, "download success: " + paramString + "|" + str1 + "|" + ((XmlData)localObject1).MD5 + "|" + localObject1);
      if (((TextUtils.isEmpty(((XmlData)localObject1).MD5)) || (((XmlData)localObject1).MD5.equalsIgnoreCase(str1))) && (UpdateAvSo.a(this.a.getApp().getApplicationContext(), Boolean.valueOf(true)))) {}
    }
    try
    {
      bace.a(paramString, UpdateAvSo.a(), false);
      ((SharedPreferences)localObject3).edit().putString(str2, ((XmlData)localObject1).MD5).commit();
      if (!UpdateAvSo.a(true)) {
        QLog.e("QavSoDownloadHandlerBase", 1, "checkHevcSo failed. md5 error!");
      }
      for (;;)
      {
        super.a(paramString);
        return;
        localObject2 = new File(UpdateAvSo.a() + "/libTcHevcEnc.so");
        if (((File)localObject2).exists()) {
          break;
        }
        QLog.e("QavSoDownloadHandlerBase", 1, "libTcHevcEnc.so is not exist.");
        localObject2 = new File(UpdateAvSo.a() + "/libTcHevcDec.so");
        if (((File)localObject2).exists()) {
          break label569;
        }
        QLog.e("QavSoDownloadHandlerBase", 1, "libTcHevcDec.so is not exist.");
        localObject2 = new File(UpdateAvSo.a() + "/libTcHevcDec2.so");
        if (((File)localObject2).exists()) {
          break label596;
        }
        QLog.e("QavSoDownloadHandlerBase", 1, "libTcHevcDec2.so is not exist.");
        QLog.d("QavSoDownloadHandlerBase", 1, "uncompressZip success: " + paramString + "|" + str1 + "|" + ((XmlData)localObject1).MD5 + "|" + localObject1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.e("QavSoDownloadHandlerBase", 1, "uncompressZip qavso failed.");
        File localFile = new File(paramString);
        if (localFile.exists())
        {
          localFile.delete();
          continue;
          ((SharedPreferences)localObject3).edit().putLong("SP_QAV_HEVC_ENC_SO_FILE_SIZE", ((File)localObject2).length()).commit();
          continue;
          label569:
          ((SharedPreferences)localObject3).edit().putLong("SP_QAV_HEVC_DEC_SO_FILE_SIZE", ((File)localObject2).length()).commit();
          continue;
          label596:
          ((SharedPreferences)localObject3).edit().putLong("SP_QAV_HEVC_DEC2_SO_FILE_SIZE", ((File)localObject2).length()).commit();
        }
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amzp
 * JD-Core Version:    0.7.0.1
 */