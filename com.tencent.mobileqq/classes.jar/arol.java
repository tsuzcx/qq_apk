import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QQDingdongSoundData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;

public class arol
  extends arnz
{
  public arol(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.dingdong.ring", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10050;
  }
  
  public Class<? extends XmlData> a()
  {
    return QQDingdongSoundData.class;
  }
  
  public String a()
  {
    return "dingdongDownloadAudioSoundDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDingdongSoundHandler", 2, "download success: " + paramString);
    }
    try
    {
      bgmg.a(paramString, mra.a(), false);
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
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)a();
    if ((localQQDingdongSoundData != null) && (!localQQDingdongSoundData.autoDownload))
    {
      localQQDingdongSoundData.autoDownload = true;
      arnn.a(localQQDingdongSoundData, new String[] { "autoDownload" });
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
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)a();
    if (localQQDingdongSoundData == null) {
      return super.h();
    }
    return localQQDingdongSoundData.autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arol
 * JD-Core Version:    0.7.0.1
 */