import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class bmfe
  extends biht
{
  private bmfe(bmfc parambmfc) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if ((parambihu.a() == 3) && (parambihu.jdField_a_of_type_Int == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IlivePluginDownloadManager", 2, "onDone , url = " + parambihu.c + " isSuccess = " + bool + " errorCode = " + parambihu.jdField_a_of_type_Int + " httpCode = " + parambihu.f + " errMsg = " + parambihu.b);
      }
      bmfc.a(this.a).remove(parambihu);
      bmfc.a(this.a);
      if (!bool) {
        break;
      }
      bmfc.b(this.a);
      return;
    }
    bmfc.a(this.a, parambihu);
  }
  
  public void onProgress(bihu parambihu)
  {
    super.onProgress(parambihu);
    if (QLog.isColorLevel()) {
      QLog.e("IlivePluginDownloadManager", 2, "onProgress ,  percent = " + parambihu.jdField_a_of_type_Float + " url = " + parambihu.c + " runTime = " + BaseApplicationImpl.getApplication().getRuntime().getClass());
    }
    if (bmfc.a(this.a) != null) {
      bmfc.a(this.a).onProgress(parambihu.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfe
 * JD-Core Version:    0.7.0.1
 */