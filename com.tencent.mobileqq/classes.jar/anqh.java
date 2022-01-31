import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.WebpSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;

public class anqh
  extends anpn
{
  QQAppInterface b = null;
  
  public anqh(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.webp.so", paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public int a()
  {
    return 10056;
  }
  
  public Class<? extends XmlData> a()
  {
    return WebpSoData.class;
  }
  
  public String a()
  {
    return "QWebpSoDownloadDuration";
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWebpSoDownloadHandler", 2, "onDownload success: " + paramString);
      }
      String str = WebpSoLoader.a(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty(str)) {
        bbdx.a(paramString, str, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QWebpSoDownloadHandler", 2, localException.getMessage());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anqh
 * JD-Core Version:    0.7.0.1
 */