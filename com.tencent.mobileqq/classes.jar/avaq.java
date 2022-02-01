import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class avaq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  avaq(avap paramavap) {}
  
  public void onGlobalLayout()
  {
    if (avap.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        avap.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((avap.a(this.a) != null) && (this.a.a != null))
      {
        if (avap.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        avap.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (avap.a(this.a).getHeight() >= bhtq.a(avap.a(this.a) + 2))
      {
        this.a.a.setMaxHeight(bhtq.a(450.0F));
        this.a.a.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      avap.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avaq
 * JD-Core Version:    0.7.0.1
 */