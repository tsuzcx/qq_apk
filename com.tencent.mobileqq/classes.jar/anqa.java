import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavImageData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class anqa
  extends anpn
{
  QQAppInterface b = null;
  
  public anqa(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.image2", paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public int a()
  {
    return 10047;
  }
  
  public Class<? extends XmlData> a()
  {
    return QavImageData.class;
  }
  
  public String a()
  {
    return "qavDownloadImageDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavImageHandler", 2, "download success: " + paramString);
    }
    try
    {
      bbdx.a(paramString, mrs.b(), false);
      super.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QavImageData localQavImageData = (QavImageData)a();
    if ((localQavImageData != null) && (!localQavImageData.autoDownload))
    {
      localQavImageData.autoDownload = true;
      anpb.a(localQavImageData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean h()
  {
    return ((QavImageData)a()).autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anqa
 * JD-Core Version:    0.7.0.1
 */