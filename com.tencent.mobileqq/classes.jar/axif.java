import android.app.Dialog;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class axif
  implements View.OnFocusChangeListener
{
  public axif(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      axfs.a(this.a.app, "0X800993D");
      paramView.clearFocus();
      if (this.a.jdField_a_of_type_AndroidAppDialog == null) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_AndroidAppDialog = new axjb(this.a, GroupTeamWorkListActivity.a(this.a), this.a.app, this.a.jdField_a_of_type_Long);
    this.a.jdField_a_of_type_AndroidAppDialog.setTitle(ajjy.a(2131639603));
    this.a.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
    this.a.jdField_a_of_type_AndroidAppDialog.show();
    this.a.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new axig(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axif
 * JD-Core Version:    0.7.0.1
 */