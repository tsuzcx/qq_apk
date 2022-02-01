import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class apcb
  extends beau
{
  apcb(apby paramapby, QQAppInterface paramQQAppInterface, String paramString, beav parambeav, bdvs parambdvs, apce paramapce, apcd paramapcd)
  {
    super(paramQQAppInterface, paramString, parambeav, parambdvs);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (apby.a(this.jdField_a_of_type_Apby))
    {
      apcd localapcd = (apcd)apby.a(this.jdField_a_of_type_Apby).get(this.jdField_a_of_type_Apce.b);
      if (localapcd != null) {
        localapcd.b();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (apby.a(this.jdField_a_of_type_Apby))
    {
      apcd localapcd = (apcd)apby.a(this.jdField_a_of_type_Apby).get(this.jdField_a_of_type_Apce.b);
      if (localapcd != null) {
        this.jdField_a_of_type_Apcd.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcb
 * JD-Core Version:    0.7.0.1
 */