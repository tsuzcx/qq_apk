import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class ausp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ausp(auso paramauso) {}
  
  public void onGlobalLayout()
  {
    if (auso.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        auso.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((auso.a(this.a) != null) && (this.a.a != null))
      {
        if (auso.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        auso.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (auso.a(this.a).getHeight() >= ViewUtils.dip2px(auso.a(this.a) + 2))
      {
        this.a.a.setMaxHeight(ViewUtils.dip2px(450.0F));
        this.a.a.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      auso.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausp
 * JD-Core Version:    0.7.0.1
 */