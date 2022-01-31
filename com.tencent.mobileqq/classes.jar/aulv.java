import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aulv
  implements arlq
{
  aulv(ault paramault, arlp paramarlp) {}
  
  public void a()
  {
    Message localMessage = ault.a(this.jdField_a_of_type_Ault).obtainMessage(1);
    aulp localaulp = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Arlp.a());
    if (localaulp != null)
    {
      localaulp.jdField_a_of_type_Int = 0;
      localMessage.obj = localaulp;
      ault.a(this.jdField_a_of_type_Ault).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    aulp localaulp = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Arlp.a());
    if (localaulp != null)
    {
      localaulp.jdField_a_of_type_Int = -1;
      localaulp.b = paramInt;
      localaulp.jdField_a_of_type_JavaLangString = paramString;
      ault.a(this.jdField_a_of_type_Ault, localaulp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulv
 * JD-Core Version:    0.7.0.1
 */