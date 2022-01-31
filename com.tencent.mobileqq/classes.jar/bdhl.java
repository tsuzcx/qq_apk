import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.thread.AsyncTask;

public class bdhl
  extends Handler
{
  public bdhl(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bdhj localbdhj = (bdhj)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localbdhj.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask, localbdhj.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localbdhj.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask.a(localbdhj.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdhl
 * JD-Core Version:    0.7.0.1
 */