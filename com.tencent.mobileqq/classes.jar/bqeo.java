import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1;

public class bqeo
  implements View.OnTouchListener
{
  public bqeo(EditVideoDTextFace.1 param1) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (1 == paramMotionEvent.getAction())
    {
      bqen.a(this.a.this$0);
      yup.a("video_edit_text", "clk_textWording", 0, 0, new String[] { this.a.this$0.a, "", "", "" });
    }
    this.a.this$0.d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqeo
 * JD-Core Version:    0.7.0.1
 */