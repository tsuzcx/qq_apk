import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;

public class begl
  extends Handler
{
  public begl(ShareAppLogHelper paramShareAppLogHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (ShareAppLogHelper.a(this.a) == null);
        ShareAppLogHelper.a(this.a).a((String)paramMessage.obj);
        return;
      } while (ShareAppLogHelper.a(this.a) == null);
      ShareAppLogHelper.a(this.a).a(((Integer)paramMessage.obj).intValue());
      return;
    } while (ShareAppLogHelper.a(this.a) == null);
    ShareAppLogHelper.a(this.a).b(((Integer)paramMessage.obj).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begl
 * JD-Core Version:    0.7.0.1
 */