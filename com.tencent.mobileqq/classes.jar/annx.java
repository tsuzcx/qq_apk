import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class annx
{
  annx(annw paramannw) {}
  
  @QQPermissionDenied(1819)
  public void denied()
  {
    QLog.e("CameraHelper", 1, "checkPermission user denied");
    annw.a(this.a);
    annw.a(this.a, false, 1830003);
  }
  
  @QQPermissionGrant(1819)
  public void grant()
  {
    QLog.d("CameraHelper", 1, "checkPermission user grant");
    annw.a(this.a);
    annw.a(this.a, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     annx
 * JD-Core Version:    0.7.0.1
 */