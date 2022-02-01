import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class awdk
  implements asyb
{
  awdk(awdi paramawdi, asya paramasya) {}
  
  public void a()
  {
    Message localMessage = awdi.a(this.jdField_a_of_type_Awdi).obtainMessage(1);
    awde localawde = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Asya.a());
    if (localawde != null)
    {
      localawde.jdField_a_of_type_Int = 0;
      localMessage.obj = localawde;
      awdi.a(this.jdField_a_of_type_Awdi).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    awde localawde = this.jdField_a_of_type_Awdi.a(this.jdField_a_of_type_Asya.a());
    if (localawde != null)
    {
      localawde.jdField_a_of_type_Int = -1;
      localawde.b = paramInt;
      localawde.jdField_a_of_type_JavaLangString = paramString;
      awdi.a(this.jdField_a_of_type_Awdi, localawde);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdk
 * JD-Core Version:    0.7.0.1
 */