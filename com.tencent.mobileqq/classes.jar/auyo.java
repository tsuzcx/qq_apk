import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class auyo
  implements Manager
{
  public auyo(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, auyk paramauyk)
  {
    bhax localbhax = new bhax();
    if (paramauyk != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramauyk, null, null, localbhax, localbhax);
      return;
    }
    paramauyk = new auyp(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramauyk, null, null, localbhax, localbhax);
  }
  
  public void a(QQAppInterface paramQQAppInterface, auyk paramauyk)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramauyk);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, auyl paramauyl, auyk paramauyk)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramauyk);
    }
    paramauyl.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyo
 * JD-Core Version:    0.7.0.1
 */