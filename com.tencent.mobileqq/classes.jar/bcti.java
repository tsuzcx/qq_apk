import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.tablequery.TableQueryViewer;

public class bcti
  implements View.OnTouchListener
{
  public bcti(TableQueryViewer paramTableQueryViewer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0) {
      TableQueryViewer.a(this.a, (int)paramMotionEvent.getY());
    }
    label171:
    do
    {
      return false;
      if (i == 2)
      {
        if ((TableQueryViewer.a(this.a)) || (Math.abs(paramMotionEvent.getY() - TableQueryViewer.a(this.a)) > com.tencent.mobileqq.util.DisplayUtil.dip2px(paramView, 10.0F)))
        {
          TableQueryViewer.a(this.a, true);
          paramMotionEvent = (WindowManager.LayoutParams)this.a.getLayoutParams();
          paramMotionEvent.y = (j - TableQueryViewer.a(this.a) - com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil.dip2px(paramView, 0.0F));
          i = TableQueryViewer.a(this.a).getDefaultDisplay().getHeight();
          if (paramMotionEvent.y >= 0) {
            break label171;
          }
          paramMotionEvent.y = 0;
        }
        for (;;)
        {
          TableQueryViewer.a(this.a).updateViewLayout(TableQueryViewer.a(this.a), paramMotionEvent);
          return true;
          if (paramMotionEvent.y > i - this.a.getHeight()) {
            paramMotionEvent.y = (i - this.a.getHeight());
          }
        }
      }
    } while ((i != 1) && (i != 3));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcti
 * JD-Core Version:    0.7.0.1
 */