import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.qphone.base.util.QLog;

public class apnw
  implements View.OnClickListener
{
  public apnw(DeleteFaceFragment paramDeleteFaceFragment) {}
  
  public void onClick(View paramView)
  {
    awqx.b(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    if ((DeleteFaceFragment.a(this.a) != null) && (DeleteFaceFragment.a(this.a).isShowing())) {
      DeleteFaceFragment.a(this.a).dismiss();
    }
    if (!badq.d(this.a.getActivity()))
    {
      bbmy.a(this.a.getActivity(), this.a.getString(2131626719), 0).b(this.a.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeleteFaceFragment", 2, "user confirm delete");
    }
    this.a.a();
    awcq.a(this.a.getActivity().app, new apnx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apnw
 * JD-Core Version:    0.7.0.1
 */