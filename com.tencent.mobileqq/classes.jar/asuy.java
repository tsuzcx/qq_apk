import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class asuy
  implements apso
{
  asuy(asuw paramasuw, apsn paramapsn) {}
  
  public void a()
  {
    Message localMessage = asuw.a(this.jdField_a_of_type_Asuw).obtainMessage(1);
    asus localasus = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Apsn.a());
    if (localasus != null)
    {
      localasus.jdField_a_of_type_Int = 0;
      localMessage.obj = localasus;
      asuw.a(this.jdField_a_of_type_Asuw).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    asus localasus = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Apsn.a());
    if (localasus != null)
    {
      localasus.jdField_a_of_type_Int = -1;
      localasus.b = paramInt;
      localasus.jdField_a_of_type_JavaLangString = paramString;
      asuw.a(this.jdField_a_of_type_Asuw, localasus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuy
 * JD-Core Version:    0.7.0.1
 */