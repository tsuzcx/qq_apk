import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class arml
{
  arml(armk paramarmk, boolean paramBoolean) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelper", 1, "checkPermission user denied");
    armk.a(this.jdField_a_of_type_Armk);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Armk.onGetError(1830001);
      return;
    }
    armk.a(this.jdField_a_of_type_Armk, false, 1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelper", 1, "checkPermission user grant");
    armk.a(this.jdField_a_of_type_Armk);
    if (this.jdField_a_of_type_Boolean)
    {
      armk.b(this.jdField_a_of_type_Armk);
      return;
    }
    armk.a(this.jdField_a_of_type_Armk, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arml
 * JD-Core Version:    0.7.0.1
 */