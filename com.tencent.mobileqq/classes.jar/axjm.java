import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class axjm
  implements auci
{
  axjm(axjk paramaxjk, auch paramauch) {}
  
  public void a()
  {
    Message localMessage = axjk.a(this.jdField_a_of_type_Axjk).obtainMessage(1);
    axjg localaxjg = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Auch.a());
    if (localaxjg != null)
    {
      localaxjg.jdField_a_of_type_Int = 0;
      localMessage.obj = localaxjg;
      axjk.a(this.jdField_a_of_type_Axjk).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    axjg localaxjg = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Auch.a());
    if (localaxjg != null)
    {
      localaxjg.jdField_a_of_type_Int = -1;
      localaxjg.b = paramInt;
      localaxjg.jdField_a_of_type_JavaLangString = paramString;
      axjk.a(this.jdField_a_of_type_Axjk, localaxjg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjm
 * JD-Core Version:    0.7.0.1
 */