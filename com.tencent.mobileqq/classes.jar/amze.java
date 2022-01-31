import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegSoLoad;
import com.tencent.qphone.base.util.QLog;

public class amze
  extends amza
{
  long a = 0L;
  QQAppInterface b = null;
  boolean d = true;
  
  public amze(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.jpeg.so_above826", paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public int a()
  {
    return 10043;
  }
  
  public Class<? extends XmlData> a()
  {
    return JpegSoData.class;
  }
  
  public String a()
  {
    return "qjpegDownloadSoDuration";
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "download success: " + paramString);
      }
      bace.a(paramString, JpegSoLoad.getJpegSolibPath(BaseApplicationImpl.getContext()), false);
      JpegCompressor.jpegcompressLoadSo();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (a().loadState == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "is in downloading");
      }
      return;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amze
 * JD-Core Version:    0.7.0.1
 */