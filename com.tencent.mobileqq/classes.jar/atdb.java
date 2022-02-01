import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;

public class atdb
  extends Handler
{
  public atdb(FileAssistantActivity paramFileAssistantActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    FileAssistantActivity.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdb
 * JD-Core Version:    0.7.0.1
 */