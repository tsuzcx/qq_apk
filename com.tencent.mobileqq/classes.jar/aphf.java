import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.PttTransitonAnimData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aphf
  extends apgu
{
  public aphf(QQAppInterface paramQQAppInterface)
  {
    super("ptt.transition.anim.res.zip", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10094;
  }
  
  public Class<? extends XmlData> a()
  {
    return PttTransitonAnimData.class;
  }
  
  public String a()
  {
    return "PttTransitionAnimZip";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler onDownloadProgeress() curOffset=" + paramLong1 + " totalLen=" + paramLong2);
    }
    super.a(paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData)
  {
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof JpegSoData))) {
      QLog.d("EarlyDown", 2, new Object[] { "PttTransitionAnimHandler doOnServerResp, xmlData=", paramXmlData });
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, " PttTransitionAnimHandler download success: " + paramString);
    }
    try
    {
      String str = aetb.a;
      if ((str != null) && (!str.equals("")))
      {
        bdcs.a(str);
        if (new File(str).mkdir())
        {
          bdcs.a(paramString, str, false);
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, " PttTransitionAnimHandler uncompressZip success: " + paramString + " tempPath=" + str);
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "PttTransitionAnimHandler uncompressZip failed: " + localException.getMessage());
        }
      }
    }
    super.a(paramString);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler onDownloadBegin()");
    }
    super.b(paramXmlData);
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler isUserNeedDownload");
    }
    if ((PttTransitonAnimData)a() == null) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "PttTransitionAnimHandler isUserNeedDownload return " + true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphf
 * JD-Core Version:    0.7.0.1
 */