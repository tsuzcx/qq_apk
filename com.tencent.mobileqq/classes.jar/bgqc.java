import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.thread.AsyncTask;

public class bgqc
  extends Handler
{
  public bgqc(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bgqa localbgqa = (bgqa)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localbgqa.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask, localbgqa.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localbgqa.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask.a(localbgqa.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgqc
 * JD-Core Version:    0.7.0.1
 */