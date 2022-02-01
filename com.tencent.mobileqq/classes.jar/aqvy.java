import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class aqvy
{
  aqvy(aqvx paramaqvx, boolean paramBoolean) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelper", 1, "checkPermission user denied");
    aqvx.a(this.jdField_a_of_type_Aqvx);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aqvx.onGetError(1830001);
      return;
    }
    aqvx.a(this.jdField_a_of_type_Aqvx, false, 1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelper", 1, "checkPermission user grant");
    aqvx.a(this.jdField_a_of_type_Aqvx);
    if (this.jdField_a_of_type_Boolean)
    {
      aqvx.b(this.jdField_a_of_type_Aqvx);
      return;
    }
    aqvx.a(this.jdField_a_of_type_Aqvx, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvy
 * JD-Core Version:    0.7.0.1
 */