import android.app.Activity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;

public class aqvk
  extends GestureDetector.SimpleOnGestureListener
{
  public aqvk(SwipePostTableLayout paramSwipePostTableLayout) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = 0;
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    ColorNote localColorNote;
    if ((SwipePostTableLayout.a(this.a) != null) && (SwipePostTableLayout.a(this.a).getColorNote() != null)) {
      localColorNote = SwipePostTableLayout.a(this.a).getColorNote();
    }
    for (boolean bool = SwipePostTableLayout.a(this.a).a(localColorNote.getServiceType(), localColorNote.getSubType());; bool = false)
    {
      float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      float f2 = paramMotionEvent1.getY();
      float f3 = paramMotionEvent2.getY();
      if ((f1 == 0.0F) || (!this.a.jdField_a_of_type_Boolean) || (paramFloat1 < 200.0F)) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      f2 = Math.abs((f2 - f3) / f1);
      if ((SwipePostTableLayout.a(this.a) == null) || (SwipePostTableLayout.a(this.a).a())) {
        i = 1;
      }
      if ((f1 < 0.0F) && (f2 < 0.5F))
      {
        if (!bool) {
          break label276;
        }
        if (i == 0) {
          break label254;
        }
        this.a.jdField_a_of_type_Aqvg.sendEmptyMessage(1);
        this.a.postInvalidate();
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Aqvj != null) {
          this.a.jdField_a_of_type_Aqvj.a();
        }
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label254:
        SwipePostTableLayout.a(this.a, true);
        SwipePostTableLayout.a(this.a).a();
        break;
        label276:
        if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          this.a.c = true;
          if (i != 0)
          {
            this.a.d();
          }
          else
          {
            SwipePostTableLayout.b(this.a, true);
            SwipePostTableLayout.a(this.a).a();
          }
        }
        else if (i != 0)
        {
          this.a.d();
        }
        else
        {
          SwipePostTableLayout.b(this.a, true);
          SwipePostTableLayout.a(this.a).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvk
 * JD-Core Version:    0.7.0.1
 */