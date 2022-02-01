import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.webviewwrapper.QzoneWebViewRuntime;

public class bnqc
{
  private static bnqc jdField_a_of_type_Bnqc;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private QzoneWebViewRuntime jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime;
  
  public static bnqc a()
  {
    if (jdField_a_of_type_Bnqc == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bnqc == null) {
        jdField_a_of_type_Bnqc = new bnqc();
      }
      return jdField_a_of_type_Bnqc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqc
 * JD-Core Version:    0.7.0.1
 */