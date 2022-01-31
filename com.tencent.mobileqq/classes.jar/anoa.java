import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class anoa
{
  anoa(annz paramannz) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelper", 1, "checkPermission user denied");
    annz.a(this.a);
    this.a.onGetError(1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelper", 1, "checkPermission user grant");
    annz.a(this.a);
    annz.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anoa
 * JD-Core Version:    0.7.0.1
 */