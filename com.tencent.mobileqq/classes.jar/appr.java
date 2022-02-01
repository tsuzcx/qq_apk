import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class appr
  extends bezt
{
  appr(appo paramappo, QQAppInterface paramQQAppInterface, String paramString, bezu parambezu, beum parambeum, appu paramappu, appt paramappt)
  {
    super(paramQQAppInterface, paramString, parambezu, parambeum);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (appo.a(this.jdField_a_of_type_Appo))
    {
      appt localappt = (appt)appo.a(this.jdField_a_of_type_Appo).get(this.jdField_a_of_type_Appu.b);
      if (localappt != null) {
        localappt.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (appo.a(this.jdField_a_of_type_Appo))
    {
      appt localappt = (appt)appo.a(this.jdField_a_of_type_Appo).get(this.jdField_a_of_type_Appu.b);
      if (localappt != null) {
        this.jdField_a_of_type_Appt.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appr
 * JD-Core Version:    0.7.0.1
 */