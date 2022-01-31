import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class asbr
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  asbr(asbq paramasbq) {}
  
  public void onGlobalLayout()
  {
    if (asbq.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        asbq.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((asbq.a(this.a) != null) && (this.a.a != null))
      {
        if (asbq.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        asbq.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (asbq.a(this.a).getHeight() >= bdoo.a(asbq.a(this.a) + 2))
      {
        this.a.a.setMaxHeight(bdoo.a(450.0F));
        this.a.a.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      asbq.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbr
 * JD-Core Version:    0.7.0.1
 */