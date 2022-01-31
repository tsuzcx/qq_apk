import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.webviewwrapper.QzoneWebViewRuntime;

public class bjwh
{
  private static bjwh jdField_a_of_type_Bjwh;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private QzoneWebViewRuntime jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime;
  
  public static bjwh a()
  {
    if (jdField_a_of_type_Bjwh == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bjwh == null) {
        jdField_a_of_type_Bjwh = new bjwh();
      }
      return jdField_a_of_type_Bjwh;
    }
  }
  
  public QzoneWebViewRuntime a()
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime == null)
      {
        QzoneWebViewRuntime localQzoneWebViewRuntime = new QzoneWebViewRuntime(BaseApplicationImpl.getApplication(), "qzonelive");
        localQzoneWebViewRuntime.onCreate(null);
        this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime = localQzoneWebViewRuntime;
      }
      return this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime;
    }
  }
  
  public void a(QzoneWebViewRuntime paramQzoneWebViewRuntime)
  {
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime = paramQzoneWebViewRuntime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjwh
 * JD-Core Version:    0.7.0.1
 */