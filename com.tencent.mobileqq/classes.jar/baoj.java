import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.OldHttpEngine;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class baoj
  extends AbsPreDownloadTask
{
  baoj(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  public void realCancel()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "ctrl realCancel");
  }
  
  public void realStart()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "downloadPicAGifAVideoRes adid" + this.jdField_a_of_type_JavaLangString);
    baol.a(this.b + ".splashtemp");
    Object localObject = new HashMap();
    ((HashMap)localObject).put("qbossSplashresAppid", this.jdField_a_of_type_JavaLangString);
    baoi.a("qbossSplashrequest", (HashMap)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("QSplash@QbossSplashDownloadManager", 2, "qboss_ad_res_png realStart, key  " + this.jdField_a_of_type_JavaLangString + "_" + this.b);
    }
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new baok(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b + ".splashtemp", this.c, this.d);
    ((HttpNetReq)localObject).mReqUrl = this.d;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = (this.b + ".splashtemp");
    ((OldHttpEngine)this.app.getNetEngine(0)).sendReq((NetReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoj
 * JD-Core Version:    0.7.0.1
 */