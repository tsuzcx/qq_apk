import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.qphone.base.util.QLog;

public class aqhl
  implements View.OnClickListener
{
  public aqhl(DeleteFaceFragment paramDeleteFaceFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeleteFaceFragment", 2, "user cancel delete");
    }
    if ((DeleteFaceFragment.a(this.a) != null) && (DeleteFaceFragment.a(this.a).isShowing())) {
      DeleteFaceFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhl
 * JD-Core Version:    0.7.0.1
 */