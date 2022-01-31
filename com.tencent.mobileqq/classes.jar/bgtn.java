import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.qqmini.sdk.core.widget.media.danmu.BarrageView;

public class bgtn
  extends bgtp
{
  public bgtn(BarrageView paramBarrageView, View paramView, int paramInt)
  {
    super(paramBarrageView, paramView, null);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    super.onAnimationEnd(paramAnimation);
    BarrageView.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaDanmuBarrageView).remove(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtn
 * JD-Core Version:    0.7.0.1
 */