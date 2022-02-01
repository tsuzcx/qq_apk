import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class auvc
{
  auvc(auuz paramauuz, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_Auuz.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    LbsManagerService.startLocation(new auvd(this, "webview"));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_Auuz.TAG, 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvc
 * JD-Core Version:    0.7.0.1
 */