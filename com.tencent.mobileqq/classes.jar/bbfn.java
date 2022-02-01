import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bbfn
  extends Handler
{
  public bbfn(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bbfr.a("CompoundProcessor", "handleMessage, msg.what = " + paramMessage.what + ",msg.arg1 = " + paramMessage.arg1);
    switch (paramMessage.what)
    {
    case 1: 
    default: 
      return;
    case 2: 
      i = paramMessage.arg1;
      paramMessage = paramMessage.getData();
      bbfr.a("CompoundProcessor", "ret is " + i + ",data is " + paramMessage);
      return;
    }
    int i = paramMessage.arg1;
    switch (paramMessage.arg1)
    {
    default: 
      return;
    }
    paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
    bbfr.a("CompoundProcessor", "ret is " + i + ",targetFile is " + paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfn
 * JD-Core Version:    0.7.0.1
 */