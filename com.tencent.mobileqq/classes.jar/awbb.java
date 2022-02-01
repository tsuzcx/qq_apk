import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class awbb
{
  awbb(away paramaway, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_Away.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    LbsManagerService.startLocation(new awbc(this, "webview"));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_Away.TAG, 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbb
 * JD-Core Version:    0.7.0.1
 */