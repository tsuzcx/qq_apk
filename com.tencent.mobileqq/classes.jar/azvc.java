import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.UploadEnv;
import mqq.manager.Manager;

public class azvc
  implements Manager
{
  public azvc(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, azuy paramazuy)
  {
    UploadEnv localUploadEnv = new UploadEnv();
    if (paramazuy != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramazuy, null, null, localUploadEnv, localUploadEnv);
      return;
    }
    paramazuy = new azvd(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramazuy, null, null, localUploadEnv, localUploadEnv);
  }
  
  public void a(QQAppInterface paramQQAppInterface, azuy paramazuy)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramazuy);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, azuz paramazuz, azuy paramazuy)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramazuy);
    }
    paramazuz.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvc
 * JD-Core Version:    0.7.0.1
 */