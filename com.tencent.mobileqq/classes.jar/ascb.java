import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class ascb
{
  ascb(asca paramasca, boolean paramBoolean) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelper", 1, "checkPermission user denied");
    asca.a(this.jdField_a_of_type_Asca);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Asca.onGetError(1830001);
      return;
    }
    asca.a(this.jdField_a_of_type_Asca, false, 1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelper", 1, "checkPermission user grant");
    asca.a(this.jdField_a_of_type_Asca);
    if (this.jdField_a_of_type_Boolean)
    {
      asca.b(this.jdField_a_of_type_Asca);
      return;
    }
    asca.a(this.jdField_a_of_type_Asca, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascb
 * JD-Core Version:    0.7.0.1
 */