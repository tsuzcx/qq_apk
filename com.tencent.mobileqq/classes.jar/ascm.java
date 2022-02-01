import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavVideoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class ascm
  extends asbv
{
  public ascm(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.video", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10049;
  }
  
  public Class<? extends XmlData> a()
  {
    return QavVideoData.class;
  }
  
  public String a()
  {
    return "qavDownloadVideoDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavVideoDownloadHandler", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.uncompressZip(paramString, msw.c(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QavVideoData localQavVideoData = (QavVideoData)a();
    if ((localQavVideoData != null) && (!localQavVideoData.autoDownload))
    {
      localQavVideoData.autoDownload = true;
      asbl.a(localQavVideoData, new String[] { "autoDownload" });
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
    return ((QavVideoData)a()).autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascm
 * JD-Core Version:    0.7.0.1
 */