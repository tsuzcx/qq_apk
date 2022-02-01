import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.banner.QIMCaptureBannerConfig;
import dov.com.qq.im.capture.banner.QIMCaptureBannerConfig.BannerItem;
import dov.com.qq.im.capture.banner.QIMCaptureBannerManager.1;
import java.io.File;

public class bpmj
  extends bpli
{
  public static Object a;
  public static String a;
  public QIMCaptureBannerConfig a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaLangString = bpup.a().getAbsolutePath() + File.separator + "banner_config";
  }
  
  public bpmj()
  {
    c();
  }
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig != null)
    {
      if (!paramBoolean) {
        break label36;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig.update) {
        QIMCaptureBannerConfig.saveBannerConfig(a(), this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig, jdField_a_of_type_JavaLangString);
      }
    }
    return;
    label36:
    QIMCaptureBannerConfig.saveBannerConfig(a(), this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig, jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(QIMCaptureBannerConfig.BannerItem paramBannerItem)
  {
    if ((paramBannerItem == null) || (TextUtils.isEmpty(paramBannerItem.imgMd5))) {}
    File localFile;
    do
    {
      do
      {
        return false;
        localFile = new File(jdField_a_of_type_JavaLangString, paramBannerItem.imgMd5);
        if (localFile.exists()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QIMCaptureBannerManager", 2, "isBannerIconUsable|file is not exist -> " + paramBannerItem.imgUrl);
      return false;
      try
      {
        String str = bhmi.c(localFile.getPath());
        if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(paramBannerItem.imgMd5))) {
          break;
        }
        return true;
      }
      catch (UnsatisfiedLinkError paramBannerItem) {}
    } while (!QLog.isColorLevel());
    paramBannerItem.printStackTrace();
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("QIMCaptureBannerManager", 2, "isBannerIconUsable|fileMd5 error " + paramBannerItem.imgUrl);
    }
    localFile.delete();
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImCaptureBannerQIMCaptureBannerConfig = null;
  }
  
  public void c()
  {
    ThreadManager.post(new QIMCaptureBannerManager.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpmj
 * JD-Core Version:    0.7.0.1
 */