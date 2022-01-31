import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import mqq.manager.Manager;

public class auyq
  implements Manager
{
  public auyq(QQAppInterface paramQQAppInterface) {}
  
  private void b(QQAppInterface paramQQAppInterface, auym paramauym)
  {
    bhbo localbhbo = new bhbo();
    if (paramauym != null)
    {
      UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramauym, null, null, localbhbo, localbhbo);
      return;
    }
    paramauym = new auyr(this, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    UploadServiceBuilder.getInstance().init(paramQQAppInterface.getApp().getApplicationContext(), paramauym, null, null, localbhbo, localbhbo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, auym paramauym)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramauym);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, auyn paramauyn, auym paramauym)
  {
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      b(paramQQAppInterface, paramauym);
    }
    paramauyn.a();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyq
 * JD-Core Version:    0.7.0.1
 */