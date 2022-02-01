import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

class bkjb
  extends bgod
{
  private bkjb(bkiz parambkiz) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if ((parambgoe.a() == 3) && (parambgoe.jdField_a_of_type_Int == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IlivePluginDownloadManager", 2, "onDone , url = " + parambgoe.c + " isSuccess = " + bool + " errorCode = " + parambgoe.jdField_a_of_type_Int + " httpCode = " + parambgoe.f + " errMsg = " + parambgoe.b);
      }
      bkiz.a(this.a).remove(parambgoe);
      bkiz.a(this.a);
      if (!bool) {
        break;
      }
      bkiz.b(this.a);
      return;
    }
    bkiz.a(this.a, parambgoe);
  }
  
  public void onProgress(bgoe parambgoe)
  {
    super.onProgress(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.e("IlivePluginDownloadManager", 2, "onProgress ,  percent = " + parambgoe.jdField_a_of_type_Float + " url = " + parambgoe.c + " runTime = " + BaseApplicationImpl.getApplication().getRuntime().getClass());
    }
    if (bkiz.a(this.a) != null) {
      bkiz.a(this.a).onProgress(parambgoe.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjb
 * JD-Core Version:    0.7.0.1
 */