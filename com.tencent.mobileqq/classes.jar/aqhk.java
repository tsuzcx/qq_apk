import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.qphone.base.util.QLog;

public class aqhk
  implements View.OnClickListener
{
  public aqhk(DeleteFaceFragment paramDeleteFaceFragment) {}
  
  public void onClick(View paramView)
  {
    axqw.b(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    if ((DeleteFaceFragment.a(this.a) != null) && (DeleteFaceFragment.a(this.a).isShowing())) {
      DeleteFaceFragment.a(this.a).dismiss();
    }
    if (!bbev.d(this.a.getActivity()))
    {
      bcpw.a(this.a.getActivity(), this.a.getString(2131692321), 0).b(this.a.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeleteFaceFragment", 2, "user confirm delete");
    }
    this.a.a();
    axby.a(this.a.getActivity().app, new aqhl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhk
 * JD-Core Version:    0.7.0.1
 */