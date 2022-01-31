import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class auqe
  implements arpz
{
  auqe(auqc paramauqc, arpy paramarpy) {}
  
  public void a()
  {
    Message localMessage = auqc.a(this.jdField_a_of_type_Auqc).obtainMessage(1);
    aupy localaupy = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Arpy.a());
    if (localaupy != null)
    {
      localaupy.jdField_a_of_type_Int = 0;
      localMessage.obj = localaupy;
      auqc.a(this.jdField_a_of_type_Auqc).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    aupy localaupy = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Arpy.a());
    if (localaupy != null)
    {
      localaupy.jdField_a_of_type_Int = -1;
      localaupy.b = paramInt;
      localaupy.jdField_a_of_type_JavaLangString = paramString;
      auqc.a(this.jdField_a_of_type_Auqc, localaupy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auqe
 * JD-Core Version:    0.7.0.1
 */