import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class asfk
  implements View.OnClickListener
{
  public asfk(DeleteFaceFragment paramDeleteFaceFragment) {}
  
  public void onClick(View paramView)
  {
    azqs.b(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    if ((DeleteFaceFragment.a(this.a) != null) && (DeleteFaceFragment.a(this.a).isShowing())) {
      DeleteFaceFragment.a(this.a).dismiss();
    }
    if (!bdin.d(this.a.getActivity()))
    {
      QQToast.a(this.a.getActivity(), this.a.getString(2131692398), 0).b(this.a.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DeleteFaceFragment", 2, "user confirm delete");
    }
    this.a.a();
    azbn.a(this.a.getActivity().app, new asfl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfk
 * JD-Core Version:    0.7.0.1
 */