import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class bleb
  extends bhhe
{
  private bleb(bldz parambldz) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if ((parambhhf.a() == 3) && (parambhhf.jdField_a_of_type_Int == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IlivePluginDownloadManager", 2, "onDone , url = " + parambhhf.c + " isSuccess = " + bool + " errorCode = " + parambhhf.jdField_a_of_type_Int + " httpCode = " + parambhhf.f + " errMsg = " + parambhhf.b);
      }
      bldz.a(this.a).remove(parambhhf);
      bldz.a(this.a);
      if (!bool) {
        break;
      }
      bldz.b(this.a);
      return;
    }
    bldz.a(this.a, parambhhf);
  }
  
  public void onProgress(bhhf parambhhf)
  {
    super.onProgress(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.e("IlivePluginDownloadManager", 2, "onProgress ,  percent = " + parambhhf.jdField_a_of_type_Float + " url = " + parambhhf.c + " runTime = " + BaseApplicationImpl.getApplication().getRuntime().getClass());
    }
    if (bldz.a(this.a) != null) {
      bldz.a(this.a).onProgress(parambhhf.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bleb
 * JD-Core Version:    0.7.0.1
 */