import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class atzi
  implements Manager
{
  public atzi(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, atze paramatze)
  {
    bfsq localbfsq = new bfsq();
    if (paramatze != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramatze, null, null, localbfsq, localbfsq);
      return;
    }
    paramatze = new atzj(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramatze, null, null, localbfsq, localbfsq);
  }
  
  public void a(QQAppInterface paramQQAppInterface, atze paramatze)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramatze);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, atzf paramatzf, atze paramatze)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramatze);
    }
    paramatzf.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzi
 * JD-Core Version:    0.7.0.1
 */