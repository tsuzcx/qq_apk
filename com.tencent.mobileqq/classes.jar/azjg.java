import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class azjg
  implements Manager
{
  public azjg(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, azjc paramazjc)
  {
    blvi localblvi = new blvi();
    if (paramazjc != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramazjc, null, null, localblvi, localblvi);
      return;
    }
    paramazjc = new azjh(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramazjc, null, null, localblvi, localblvi);
  }
  
  public void a(QQAppInterface paramQQAppInterface, azjc paramazjc)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramazjc);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, azjd paramazjd, azjc paramazjc)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramazjc);
    }
    paramazjd.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjg
 * JD-Core Version:    0.7.0.1
 */