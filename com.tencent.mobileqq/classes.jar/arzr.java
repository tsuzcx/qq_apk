import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class arzr
{
  arzr(arzq paramarzq, boolean paramBoolean) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelper", 1, "checkPermission user denied");
    arzq.a(this.jdField_a_of_type_Arzq);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Arzq.onGetError(1830001);
      return;
    }
    arzq.a(this.jdField_a_of_type_Arzq, false, 1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelper", 1, "checkPermission user grant");
    arzq.a(this.jdField_a_of_type_Arzq);
    if (this.jdField_a_of_type_Boolean)
    {
      arzq.b(this.jdField_a_of_type_Arzq);
      return;
    }
    arzq.a(this.jdField_a_of_type_Arzq, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzr
 * JD-Core Version:    0.7.0.1
 */