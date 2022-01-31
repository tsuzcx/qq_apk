import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.thread.AsyncTask;

public class belo
  extends Handler
{
  public belo(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    belm localbelm = (belm)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localbelm.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask, localbelm.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localbelm.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask.a(localbelm.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     belo
 * JD-Core Version:    0.7.0.1
 */