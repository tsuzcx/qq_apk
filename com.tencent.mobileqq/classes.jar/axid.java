import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;

public class axid
  implements View.OnClickListener
{
  public axid(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (axhr)paramView.getTag();
    if (paramView.jdField_a_of_type_Int == axhp.b)
    {
      axfs.a(this.a.app, "0X8009938");
      axfs.a(this.a.app, this.a, 2, "group_online_doc_more_temp", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      awqx.b(this.a.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
      return;
    }
    String str = apdq.a(this.a.app, this.a.a, this.a.app.getLongAccountUin());
    if (!TextUtils.isEmpty(str))
    {
      bbmy.a(this.a, str, 0).a();
      return;
    }
    axfs.a(this.a.app, "0X8009937");
    axfs.a(this.a.app, this.a, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.a), paramView.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo);
    awqx.b(this.a.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axid
 * JD-Core Version:    0.7.0.1
 */