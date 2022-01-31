import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class apfh
{
  apfh(apfg paramapfg) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelper", 1, "checkPermission user denied");
    apfg.a(this.a);
    this.a.onGetError(1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelper", 1, "checkPermission user grant");
    apfg.a(this.a);
    apfg.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfh
 * JD-Core Version:    0.7.0.1
 */