import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class awvf
  extends bavo
{
  awvf(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "ctrl realCancel");
  }
  
  protected void realStart()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "downloadPicAGifAVideoRes adid" + this.jdField_a_of_type_JavaLangString);
    awvh.a(this.b + ".splashtemp");
    Object localObject = new HashMap();
    ((HashMap)localObject).put("qbossSplashresAppid", this.jdField_a_of_type_JavaLangString);
    awve.a("qbossSplashrequest", (HashMap)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("QSplash@QbossSplashDownloadManager", 2, "qboss_ad_res_png realStart, key  " + this.jdField_a_of_type_JavaLangString + "_" + this.b);
    }
    localObject = new baps();
    ((baps)localObject).jdField_a_of_type_Bapx = new awvg(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b + ".splashtemp", this.c, this.d);
    ((baps)localObject).jdField_a_of_type_JavaLangString = this.d;
    ((baps)localObject).jdField_a_of_type_Int = 0;
    ((baps)localObject).c = (this.b + ".splashtemp");
    ((baqy)this.app.getNetEngine(0)).a((baqv)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awvf
 * JD-Core Version:    0.7.0.1
 */