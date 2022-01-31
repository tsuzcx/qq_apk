import android.os.Message;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class bjvj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bjvj(bjvc parambjvc) {}
  
  public void onGlobalLayout()
  {
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().removeGlobalOnLayoutListener(bjvc.a(this.a));
    this.a.jdField_a_of_type_Bjww.a(Message.obtain(null, 20));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjvj
 * JD-Core Version:    0.7.0.1
 */