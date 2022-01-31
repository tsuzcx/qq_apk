import android.os.Message;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

class bmlw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bmlw(bmlp parambmlp) {}
  
  public void onGlobalLayout()
  {
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getViewTreeObserver().removeGlobalOnLayoutListener(bmlp.a(this.a));
    this.a.jdField_a_of_type_Bmnj.a(Message.obtain(null, 20));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlw
 * JD-Core Version:    0.7.0.1
 */