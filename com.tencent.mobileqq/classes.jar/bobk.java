import android.os.Handler;
import android.os.Message;
import android.util.Log;
import dov.com.qq.im.aeeditor.lyric.widget.LyricViewScroll;

public class bobk
  extends Handler
{
  int jdField_a_of_type_Int;
  
  public bobk(LyricViewScroll paramLyricViewScroll) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int != this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.getScrollY()) {
          break;
        }
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        if (LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll) != null) {
          LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll).b(this.jdField_a_of_type_Int);
        }
        Log.d("LyricViewScroll", "fling stop");
        LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll, false);
        LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll).sendEmptyMessageDelayed(2, this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.jdField_b_of_type_Int);
        this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.jdField_b_of_type_Boolean = false;
      } while (LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll) == null);
      LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll).a();
      return;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.getScrollY();
      if (LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll) != null) {
        LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll).a(this.jdField_a_of_type_Int);
      }
      LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll).sendEmptyMessageDelayed(1, 100L);
      return;
      this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.jdField_b_of_type_Boolean = true;
    } while (LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll) == null);
    LyricViewScroll.a(this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobk
 * JD-Core Version:    0.7.0.1
 */