import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.core.utils.thread.AsyncTask;

public class bglv
  extends Handler
{
  public bglv(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bglt localbglt = (bglt)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      AsyncTask.b(localbglt.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask, localbglt.jdField_a_of_type_ArrayOfJavaLangObject[0]);
      return;
    }
    localbglt.jdField_a_of_type_ComTencentQqminiSdkCoreUtilsThreadAsyncTask.a(localbglt.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglv
 * JD-Core Version:    0.7.0.1
 */