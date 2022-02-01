import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class blun
  extends bhyn
{
  private blun(blul paramblul) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if ((parambhyo.a() == 3) && (parambhyo.jdField_a_of_type_Int == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IlivePluginDownloadManager", 2, "onDone , url = " + parambhyo.c + " isSuccess = " + bool + " errorCode = " + parambhyo.jdField_a_of_type_Int + " httpCode = " + parambhyo.f + " errMsg = " + parambhyo.b);
      }
      blul.a(this.a).remove(parambhyo);
      blul.a(this.a);
      if (!bool) {
        break;
      }
      blul.b(this.a);
      return;
    }
    blul.a(this.a, parambhyo);
  }
  
  public void onProgress(bhyo parambhyo)
  {
    super.onProgress(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.e("IlivePluginDownloadManager", 2, "onProgress ,  percent = " + parambhyo.jdField_a_of_type_Float + " url = " + parambhyo.c + " runTime = " + BaseApplicationImpl.getApplication().getRuntime().getClass());
    }
    if (blul.a(this.a) != null) {
      blul.a(this.a).onProgress(parambhyo.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blun
 * JD-Core Version:    0.7.0.1
 */