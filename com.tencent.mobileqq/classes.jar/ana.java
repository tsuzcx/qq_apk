import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.qq.im.poi.LbsPackListAdapter;
import com.qq.im.poi.LbsPackListAdapter.LbsPackItemCallback;
import java.util.List;

public class ana
  implements Animation.AnimationListener
{
  public ana(LbsPackListAdapter paramLbsPackListAdapter, View paramView1, int paramInt, View paramView2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a(this.jdField_a_of_type_AndroidViewView, -1, this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (this.b != null)
      {
        this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a(this.b, 1, this.jdField_a_of_type_Int);
        return;
      }
      this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a.remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.notifyDataSetChanged();
    } while (LbsPackListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter) == null);
    LbsPackListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter).a(this.jdField_a_of_type_Int);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ana
 * JD-Core Version:    0.7.0.1
 */