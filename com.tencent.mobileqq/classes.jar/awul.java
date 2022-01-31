import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class awul
  implements Manager
{
  public awul(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, awuh paramawuh)
  {
    bjhc localbjhc = new bjhc();
    if (paramawuh != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramawuh, null, null, localbjhc, localbjhc);
      return;
    }
    paramawuh = new awum(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramawuh, null, null, localbjhc, localbjhc);
  }
  
  public void a(QQAppInterface paramQQAppInterface, awuh paramawuh)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramawuh);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, awui paramawui, awuh paramawuh)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramawuh);
    }
    paramawui.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awul
 * JD-Core Version:    0.7.0.1
 */