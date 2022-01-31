import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.qq.im.poi.LbsPackListAdapter;
import com.qq.im.poi.LbsPackListAdapter.LbsPackItemCallback;
import java.util.List;

public class amz
  implements Animation.AnimationListener
{
  public amz(LbsPackListAdapter paramLbsPackListAdapter, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.a.remove(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter.notifyDataSetChanged();
    if (LbsPackListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter) != null) {
      LbsPackListAdapter.a(this.jdField_a_of_type_ComQqImPoiLbsPackListAdapter).a(this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amz
 * JD-Core Version:    0.7.0.1
 */