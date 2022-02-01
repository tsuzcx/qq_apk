import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class atnu
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  atnu(atnt paramatnt) {}
  
  public void onGlobalLayout()
  {
    if (atnt.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        atnt.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((atnt.a(this.a) != null) && (this.a.a != null))
      {
        if (atnt.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        atnt.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (atnt.a(this.a).getHeight() >= ViewUtils.dip2px(atnt.a(this.a) + 2))
      {
        this.a.a.setMaxHeight(ViewUtils.dip2px(450.0F));
        this.a.a.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      atnt.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnu
 * JD-Core Version:    0.7.0.1
 */