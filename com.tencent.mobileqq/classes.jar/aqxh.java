import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler.1;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aqxh
  extends aqxl
{
  public aqxh(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.appleemoji", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10001;
  }
  
  public Class<? extends XmlData> a()
  {
    return AppleEmojiData.class;
  }
  
  public String a()
  {
    return "AppleMojiHandler";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess:" + paramString);
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    ThreadManager.excute(new AppleEmojiHandler.1(this, localFile, paramString), 64, null, true);
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
 * Qualified Name:     aqxh
 * JD-Core Version:    0.7.0.1
 */