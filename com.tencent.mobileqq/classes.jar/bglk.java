import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.webviewwrapper.QzoneWebViewRuntime;

public class bglk
{
  private static bglk jdField_a_of_type_Bglk;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private QzoneWebViewRuntime jdField_a_of_type_CooperationQzoneWebviewwrapperQzoneWebViewRuntime;
  
  public static bglk a()
  {
    if (jdField_a_of_type_Bglk == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bglk == null) {
        jdField_a_of_type_Bglk = new bglk();
      }
      return jdField_a_of_type_Bglk;
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
 * Qualified Name:     bglk
 * JD-Core Version:    0.7.0.1
 */