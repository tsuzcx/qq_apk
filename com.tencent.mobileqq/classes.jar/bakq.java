import android.app.Dialog;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class bakq
  implements View.OnFocusChangeListener
{
  public bakq(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      baic.a(this.a.app, "0X800993D");
      paramView.clearFocus();
      if (this.a.jdField_a_of_type_AndroidAppDialog == null) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_AndroidAppDialog = new balm(this.a, GroupTeamWorkListActivity.a(this.a), this.a.app, this.a.jdField_a_of_type_Long);
    this.a.jdField_a_of_type_AndroidAppDialog.setTitle(alud.a(2131705783));
    this.a.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.a.jdField_a_of_type_AndroidAppDialog.show();
    this.a.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new bakr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakq
 * JD-Core Version:    0.7.0.1
 */