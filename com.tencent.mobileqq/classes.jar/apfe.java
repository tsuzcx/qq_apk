import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class apfe
{
  apfe(apfd paramapfd) {}
  
  @QQPermissionDenied(1819)
  public void denied()
  {
    QLog.e("CameraHelper", 1, "checkPermission user denied");
    apfd.a(this.a);
    apfd.a(this.a, false, 1830003);
  }
  
  @QQPermissionGrant(1819)
  public void grant()
  {
    QLog.d("CameraHelper", 1, "checkPermission user grant");
    apfd.a(this.a);
    apfd.a(this.a, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfe
 * JD-Core Version:    0.7.0.1
 */