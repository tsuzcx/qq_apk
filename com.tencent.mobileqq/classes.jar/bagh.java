import android.app.Dialog;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class bagh
  implements View.OnFocusChangeListener
{
  public bagh(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      badt.a(this.a.app, "0X800993D");
      paramView.clearFocus();
      if (this.a.jdField_a_of_type_AndroidAppDialog == null) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_AndroidAppDialog = new bahd(this.a, GroupTeamWorkListActivity.a(this.a), this.a.app, this.a.jdField_a_of_type_Long);
    this.a.jdField_a_of_type_AndroidAppDialog.setTitle(alpo.a(2131705771));
    this.a.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.a.jdField_a_of_type_AndroidAppDialog.show();
    this.a.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new bagi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagh
 * JD-Core Version:    0.7.0.1
 */