import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qzone.UploadEnv;
import mqq.manager.Manager;

public class ayqh
  implements Manager
{
  public ayqh(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, ayqd paramayqd)
  {
    UploadEnv localUploadEnv = new UploadEnv();
    if (paramayqd != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramayqd, null, null, localUploadEnv, localUploadEnv);
      return;
    }
    paramayqd = new ayqi(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramayqd, null, null, localUploadEnv, localUploadEnv);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ayqd paramayqd)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramayqd);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ayqe paramayqe, ayqd paramayqd)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramayqd);
    }
    paramayqe.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqh
 * JD-Core Version:    0.7.0.1
 */