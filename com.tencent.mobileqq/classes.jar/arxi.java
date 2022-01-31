import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class arxi
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  arxi(arxh paramarxh) {}
  
  public void onGlobalLayout()
  {
    if (arxh.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        arxh.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((arxh.a(this.a) != null) && (this.a.a != null))
      {
        if (arxh.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        arxh.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (arxh.a(this.a).getHeight() >= bdkf.a(arxh.a(this.a) + 2))
      {
        this.a.a.setMaxHeight(bdkf.a(450.0F));
        this.a.a.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      arxh.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxi
 * JD-Core Version:    0.7.0.1
 */