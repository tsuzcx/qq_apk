import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class amxk
{
  amxk(amxj paramamxj) {}
  
  @QQPermissionDenied(1819)
  public void denied()
  {
    QLog.e("CameraHelper", 1, "checkPermission user denied");
    amxj.a(this.a);
    amxj.a(this.a, false, 1830003);
  }
  
  @QQPermissionGrant(1819)
  public void grant()
  {
    QLog.d("CameraHelper", 1, "checkPermission user grant");
    amxj.a(this.a);
    amxj.a(this.a, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amxk
 * JD-Core Version:    0.7.0.1
 */