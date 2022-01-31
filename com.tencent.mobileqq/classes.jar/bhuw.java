import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.webviewwrapper.QzoneWebViewRuntime;

public class bhuw
{
  private static bhuw jdField_a_of_type_Bhuw;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private QzoneWebViewRuntime jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime;
  
  public static bhuw a()
  {
    if (jdField_a_of_type_Bhuw == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bhuw == null) {
        jdField_a_of_type_Bhuw = new bhuw();
      }
      return jdField_a_of_type_Bhuw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuw
 * JD-Core Version:    0.7.0.1
 */