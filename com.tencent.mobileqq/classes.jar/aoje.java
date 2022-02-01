import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aoje
  extends HttpEngineTask
{
  aoje(aojb paramaojb, QQAppInterface paramQQAppInterface, String paramString, HttpEngineTask.IHttpEngineTask paramIHttpEngineTask, HttpNetReq paramHttpNetReq, aojh paramaojh, aojg paramaojg)
  {
    super(paramQQAppInterface, paramString, paramIHttpEngineTask, paramHttpNetReq);
  }
  
  public void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (aojb.a(this.jdField_a_of_type_Aojb))
    {
      aojg localaojg = (aojg)aojb.a(this.jdField_a_of_type_Aojb).get(this.jdField_a_of_type_Aojh.b);
      if (localaojg != null) {
        localaojg.b();
      }
      super.realCancel();
      return;
    }
  }
  
  public void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (aojb.a(this.jdField_a_of_type_Aojb))
    {
      aojg localaojg = (aojg)aojb.a(this.jdField_a_of_type_Aojb).get(this.jdField_a_of_type_Aojh.b);
      if (localaojg != null) {
        this.jdField_a_of_type_Aojg.a();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoje
 * JD-Core Version:    0.7.0.1
 */