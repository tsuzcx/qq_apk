import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;

class aqea
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aqea(aqdz paramaqdz) {}
  
  public void onGlobalLayout()
  {
    if (aqdz.a(this.a) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        aqdz.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      if ((aqdz.a(this.a) != null) && (this.a.a != null))
      {
        if (aqdz.a(this.a).getLineCount() <= 1) {
          break label144;
        }
        aqdz.a(this.a).setGravity(19);
      }
    }
    for (;;)
    {
      if (aqdz.a(this.a).getHeight() >= bbll.a(aqdz.a(this.a) + 2))
      {
        this.a.a.setMaxHeight(bbll.a(450.0F));
        this.a.a.requestLayout();
        if (QLog.isColorLevel()) {
          QLog.d("ForwardPreviewTextController", 2, " reset height ");
        }
      }
      return;
      label144:
      aqdz.a(this.a).setGravity(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqea
 * JD-Core Version:    0.7.0.1
 */