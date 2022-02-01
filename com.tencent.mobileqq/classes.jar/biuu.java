import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.WorkSpaceView;

public class biuu
  extends Handler
{
  public biuu(WorkSpaceView paramWorkSpaceView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      int i = ((bdno)this.a.getChildAt(this.a.a).getTag()).a;
      if ((this.a.getChildCount() > 1) && (this.a.getWidth() > 0)) {
        this.a.a(this.a.a() + 1);
      }
      WorkSpaceView.a(this.a).sendEmptyMessageDelayed(0, i * 1000);
      continue;
      WorkSpaceView.a(this.a).removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biuu
 * JD-Core Version:    0.7.0.1
 */