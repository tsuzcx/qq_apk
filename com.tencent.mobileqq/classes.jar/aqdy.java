import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class aqdy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aqdy(aqdx paramaqdx) {}
  
  public void onGlobalLayout()
  {
    if (aqdx.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        aqdx.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((aqdx.a(this.a) != null) && (this.a.a != null))
      {
        if (aqdx.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        aqdx.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (aqdx.a(this.a).getHeight() >= bbkx.a(aqdx.a(this.a) + 2))
      {
        this.a.a.setMaxHeight(bbkx.a(450.0F));
        this.a.a.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      aqdx.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdy
 * JD-Core Version:    0.7.0.1
 */