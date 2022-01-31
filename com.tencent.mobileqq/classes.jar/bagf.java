import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.widget.QQToast;

public class bagf
  implements View.OnClickListener
{
  public bagf(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (baft)paramView.getTag();
    if (paramView.jdField_a_of_type_Int == bafr.b)
    {
      badt.a(this.a.app, "0X8009938");
      badt.a(this.a.app, this.a, 2, "group_online_doc_more_temp", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      azmj.b(this.a.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
      return;
    }
    String str = aroo.a(this.a.app, this.a.a, this.a.app.getLongAccountUin());
    if (!TextUtils.isEmpty(str))
    {
      QQToast.a(this.a, str, 0).a();
      return;
    }
    badt.a(this.a.app, "0X8009937");
    badt.a(this.a.app, this.a, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.a), paramView.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo);
    azmj.b(this.a.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagf
 * JD-Core Version:    0.7.0.1
 */