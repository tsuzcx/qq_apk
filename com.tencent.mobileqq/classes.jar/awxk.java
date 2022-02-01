import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class awxk
  implements attw
{
  awxk(awxi paramawxi, attv paramattv) {}
  
  public void a()
  {
    Message localMessage = awxi.a(this.jdField_a_of_type_Awxi).obtainMessage(1);
    awxe localawxe = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Attv.a());
    if (localawxe != null)
    {
      localawxe.jdField_a_of_type_Int = 0;
      localMessage.obj = localawxe;
      awxi.a(this.jdField_a_of_type_Awxi).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    awxe localawxe = this.jdField_a_of_type_Awxi.a(this.jdField_a_of_type_Attv.a());
    if (localawxe != null)
    {
      localawxe.jdField_a_of_type_Int = -1;
      localawxe.b = paramInt;
      localawxe.jdField_a_of_type_JavaLangString = paramString;
      awxi.a(this.jdField_a_of_type_Awxi, localawxe);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxk
 * JD-Core Version:    0.7.0.1
 */