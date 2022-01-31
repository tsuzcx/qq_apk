import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class awqc
  implements Manager
{
  public awqc(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, awpy paramawpy)
  {
    bjcv localbjcv = new bjcv();
    if (paramawpy != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramawpy, null, null, localbjcv, localbjcv);
      return;
    }
    paramawpy = new awqd(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramawpy, null, null, localbjcv, localbjcv);
  }
  
  public void a(QQAppInterface paramQQAppInterface, awpy paramawpy)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramawpy);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, awpz paramawpz, awpy paramawpy)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramawpy);
    }
    paramawpz.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqc
 * JD-Core Version:    0.7.0.1
 */