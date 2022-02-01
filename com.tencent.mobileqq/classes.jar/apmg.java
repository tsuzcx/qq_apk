import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class apmg
  extends HttpEngineTask
{
  apmg(apmd paramapmd, QQAppInterface paramQQAppInterface, String paramString, HttpEngineTask.IHttpEngineTask paramIHttpEngineTask, HttpNetReq paramHttpNetReq, apmj paramapmj, apmi paramapmi)
  {
    super(paramQQAppInterface, paramString, paramIHttpEngineTask, paramHttpNetReq);
  }
  
  public void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (apmd.a(this.jdField_a_of_type_Apmd))
    {
      apmi localapmi = (apmi)apmd.a(this.jdField_a_of_type_Apmd).get(this.jdField_a_of_type_Apmj.b);
      if (localapmi != null) {
        localapmi.b();
      }
      super.realCancel();
      return;
    }
  }
  
  public void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (apmd.a(this.jdField_a_of_type_Apmd))
    {
      apmi localapmi = (apmi)apmd.a(this.jdField_a_of_type_Apmd).get(this.jdField_a_of_type_Apmj.b);
      if (localapmi != null) {
        this.jdField_a_of_type_Apmi.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmg
 * JD-Core Version:    0.7.0.1
 */