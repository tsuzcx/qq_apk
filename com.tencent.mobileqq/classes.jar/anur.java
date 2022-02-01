import android.os.Vibrator;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class anur
  implements View.OnLongClickListener
{
  public anur(FrameHelperActivity paramFrameHelperActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {
      return true;
    }
    if (!bdxj.c(this.a.getActivity().app, false)) {
      return true;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.b())) {
      return true;
    }
    if ((paramView == this.a.b) && (this.a.jdField_a_of_type_Ayzg != null) && (!this.a.jdField_a_of_type_Ayzg.isShowing()))
    {
      if ((this.a.getActivity().app != null) && (this.a.getActivity().app.getApp() != null))
      {
        paramView = (Vibrator)this.a.getActivity().app.getApp().getSystemService("vibrator");
        if (paramView != null) {
          paramView.vibrate(new long[] { 0L, 1L, 20L, 21L }, -1);
        }
      }
      this.a.jdField_a_of_type_Ayzg.show();
      bdla.b(this.a.getActivity().app, "dc00898", "", "", "0X800A999", "0X800A999", 1, 0, "", "", "", "");
      bdla.b(this.a.getActivity().app, "dc00898", "", "", "0X8009E84", "0X8009E84", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_Anvf != null) {
      this.a.jdField_a_of_type_Anvf.a();
    }
    this.a.p();
    bdla.b(this.a.getActivity().app, "CliOper", "", "", "0X80072D1", "0X80072D1", 0, 0, "", "", "", "");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anur
 * JD-Core Version:    0.7.0.1
 */