import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.qphone.base.util.QLog;

public class aspe
  implements View.OnClickListener
{
  public aspe(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onClick() called with: v = [" + paramView + "]");
    }
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aspe
 * JD-Core Version:    0.7.0.1
 */