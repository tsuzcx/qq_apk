import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class avds
  extends ayxp
{
  avds(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
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
    avdu.a(this.b + ".splashtemp");
    Object localObject = new HashMap();
    ((HashMap)localObject).put("qbossSplashresAppid", this.jdField_a_of_type_JavaLangString);
    avdr.a("qbossSplashrequest", (HashMap)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("QSplash@QbossSplashDownloadManager", 2, "qboss_ad_res_png realStart, key  " + this.jdField_a_of_type_JavaLangString + "_" + this.b);
    }
    localObject = new ayrx();
    ((ayrx)localObject).jdField_a_of_type_Aysc = new avdt(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b + ".splashtemp", this.c, this.d);
    ((ayrx)localObject).jdField_a_of_type_JavaLangString = this.d;
    ((ayrx)localObject).jdField_a_of_type_Int = 0;
    ((ayrx)localObject).c = (this.b + ".splashtemp");
    ((aytb)this.app.getNetEngine(0)).a((aysy)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avds
 * JD-Core Version:    0.7.0.1
 */