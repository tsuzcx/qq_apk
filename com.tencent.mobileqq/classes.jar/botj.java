import android.os.Message;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class botj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  botj(botf parambotf) {}
  
  public void onGlobalLayout()
  {
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().removeGlobalOnLayoutListener(botf.a(this.a));
    this.a.jdField_a_of_type_Botw.a(Message.obtain(null, 16));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     botj
 * JD-Core Version:    0.7.0.1
 */