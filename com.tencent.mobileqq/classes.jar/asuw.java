import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class asuw
  implements apsk
{
  asuw(asuu paramasuu, apsj paramapsj) {}
  
  public void a()
  {
    Message localMessage = asuu.a(this.jdField_a_of_type_Asuu).obtainMessage(1);
    asuq localasuq = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Apsj.a());
    if (localasuq != null)
    {
      localasuq.jdField_a_of_type_Int = 0;
      localMessage.obj = localasuq;
      asuu.a(this.jdField_a_of_type_Asuu).sendMessage(localMessage);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MultiRichMediaSaveManager", 2, "saveVideoFile fail, errorCode = " + paramInt + " ,errorMsg = " + paramString);
    }
    asuq localasuq = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Apsj.a());
    if (localasuq != null)
    {
      localasuq.jdField_a_of_type_Int = -1;
      localasuq.b = paramInt;
      localasuq.jdField_a_of_type_JavaLangString = paramString;
      asuu.a(this.jdField_a_of_type_Asuu, localasuq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuw
 * JD-Core Version:    0.7.0.1
 */