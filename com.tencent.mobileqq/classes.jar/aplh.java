import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegSoLoad;
import com.tencent.qphone.base.util.QLog;

public class aplh
  extends apld
{
  long a = 0L;
  QQAppInterface b = null;
  boolean d = true;
  
  public aplh(QQAppInterface paramQQAppInterface)
  {
    super(e(), paramQQAppInterface);
    this.b = paramQQAppInterface;
  }
  
  public static String e()
  {
    if ("armeabi-v7a".equalsIgnoreCase(Build.CPU_ABI)) {
      return "qq.android.pic.jpeg.so_v7_820";
    }
    return "qq.android.pic.jpeg.so_v5_820";
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
  
  public void a(XmlData paramXmlData)
  {
    if ((QLog.isColorLevel()) && (paramXmlData != null) && ((paramXmlData instanceof JpegSoData))) {
      QLog.d("QJpegSoDownloadHandler", 2, new Object[] { "doOnServerResp, xmlData=", paramXmlData });
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    String str2 = JpegSoLoad.getJpegSolibPath(BaseApplicationImpl.getContext());
    String str1 = str2 + JpegSoLoad.getLibActualName("jpegc_above820");
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QJpegSoDownloadHandler", 2, "download success: " + paramString + " ,so path:" + str1);
        }
        bdhb.a(paramString, str2, false);
        str2 = aygu.a(str1);
        Object localObject2 = a();
        if (!(localObject2 instanceof JpegSoData)) {
          break label335;
        }
        localObject2 = (JpegSoData)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess, soMD5:" + str2 + " soData.SO_MD5:" + ((JpegSoData)localObject2).SO_MD5);
        }
        if (!str2.equalsIgnoreCase(((JpegSoData)localObject2).SO_MD5)) {
          break label335;
        }
        JpegCompressor.jpegcompressLoadSo();
        bool = true;
        if (!bool)
        {
          bdhb.d(str1);
          bdhb.d(paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess,suc:" + bool);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QJpegSoDownloadHandler", 2, localException, new Object[0]);
        bdhb.d(str1);
        bdhb.d(paramString);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess,suc:" + false);
        continue;
      }
      finally
      {
        bdhb.d(str1);
        bdhb.d(paramString);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QJpegSoDownloadHandler", 2, "doOnDownloadSuccess,suc:" + false);
      }
      super.a(paramString);
      return;
      label335:
      boolean bool = false;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aplh
 * JD-Core Version:    0.7.0.1
 */