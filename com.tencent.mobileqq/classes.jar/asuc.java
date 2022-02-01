import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onGlobalLayout"}, k=3, mv={1, 1, 16})
final class asuc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  asuc(LinearLayout paramLinearLayout) {}
  
  public final void onGlobalLayout()
  {
    Object localObject = new int[2];
    this.a.getLocationOnScreen((int[])localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CompletePersonalDataDialog", 2, "onGlobalLayout x = " + localObject[0] + ",y = " + localObject[1]);
    }
    int i = ViewUtils.dpToPx(120.0F);
    if (localObject[1] < i)
    {
      int j = ViewUtils.getScreenHeight();
      localObject = this.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (j - i);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuc
 * JD-Core Version:    0.7.0.1
 */