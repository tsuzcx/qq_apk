import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;

public class avxm
  implements View.OnTouchListener
{
  public avxm(ScanOcrActivity paramScanOcrActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (paramView == ScanOcrActivity.a(this.a))
      {
        paramView.setAlpha(0.7F);
      }
      else
      {
        paramView.setAlpha(0.5F);
        continue;
        paramView.setAlpha(1.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avxm
 * JD-Core Version:    0.7.0.1
 */