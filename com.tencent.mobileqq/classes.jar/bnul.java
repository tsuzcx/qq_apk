import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.qq.im.aeeditor.lyric.widget.LyricWithBuoyView;

public class bnul
  implements View.OnTouchListener
{
  float jdField_a_of_type_Float = 0.0F;
  float b = 0.0F;
  
  public bnul(LyricWithBuoyView paramLyricWithBuoyView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      for (;;)
      {
        return false;
        this.jdField_a_of_type_Float = paramMotionEvent.getRawX();
        this.b = paramMotionEvent.getRawY();
      }
    } while ((Math.abs(paramMotionEvent.getRawX() - this.jdField_a_of_type_Float) >= 10.0F) || (Math.abs(paramMotionEvent.getRawY() - this.b) >= 10.0F));
    if (LyricWithBuoyView.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView) != null) {
      LyricWithBuoyView.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricWithBuoyView).a();
    }
    for (;;)
    {
      return true;
      bnrh.a("LyricWithBuoyView", "onClick() mOnLyricWithBuoyViewOperationListener == null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnul
 * JD-Core Version:    0.7.0.1
 */