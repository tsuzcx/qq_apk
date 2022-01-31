import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.multicard.MultiCardFragment;
import com.tencent.qphone.base.util.QLog;

public class asrz
  implements View.OnClickListener
{
  public asrz(MultiCardFragment paramMultiCardFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardFragment", 2, "onClick() called with: v = [" + paramView + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrz
 * JD-Core Version:    0.7.0.1
 */