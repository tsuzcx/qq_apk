import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class axqd
  implements aulr
{
  axqd(axqb paramaxqb, aulq paramaulq) {}
  
  public void a()
  {
    Message localMessage = axqb.a(this.jdField_a_of_type_Axqb).obtainMessage(1);
    axpx localaxpx = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Aulq.a());
    if (localaxpx != null)
    {
      localaxpx.jdField_a_of_type_Int = 0;
      localMessage.obj = localaxpx;
      axqb.a(this.jdField_a_of_type_Axqb).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    axpx localaxpx = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Aulq.a());
    if (localaxpx != null)
    {
      localaxpx.jdField_a_of_type_Int = -1;
      localaxpx.b = paramInt;
      localaxpx.jdField_a_of_type_JavaLangString = paramString;
      axqb.a(this.jdField_a_of_type_Axqb, localaxpx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqd
 * JD-Core Version:    0.7.0.1
 */