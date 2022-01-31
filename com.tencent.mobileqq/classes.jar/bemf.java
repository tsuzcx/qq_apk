import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.thread.AsyncTask;

public class bemf
  extends Handler
{
  public bemf(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bemd localbemd = (bemd)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localbemd.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask, localbemd.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localbemd.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask.a(localbemd.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemf
 * JD-Core Version:    0.7.0.1
 */