import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class babs
  implements Manager
{
  public babs(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, babo parambabo)
  {
    bmwk localbmwk = new bmwk();
    if (parambabo != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), parambabo, null, null, localbmwk, localbmwk);
      return;
    }
    parambabo = new babt(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), parambabo, null, null, localbmwk, localbmwk);
  }
  
  public void a(QQAppInterface paramQQAppInterface, babo parambabo)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, parambabo);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, babp parambabp, babo parambabo)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, parambabo);
    }
    parambabp.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babs
 * JD-Core Version:    0.7.0.1
 */