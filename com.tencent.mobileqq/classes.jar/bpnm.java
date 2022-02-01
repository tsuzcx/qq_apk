import android.os.Handler;
import android.os.Message;
import android.widget.SeekBar;
import android.widget.TextView;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar;

public class bpnm
  extends Handler
{
  public bpnm(BeautyBar paramBeautyBar) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (BeautyBar.a(this.a) != null) {
        BeautyBar.a(this.a).startAnimation(BeautyBar.a(this.a));
      }
    } while (BeautyBar.a(this.a) == null);
    BeautyBar.a(this.a).startAnimation(BeautyBar.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnm
 * JD-Core Version:    0.7.0.1
 */