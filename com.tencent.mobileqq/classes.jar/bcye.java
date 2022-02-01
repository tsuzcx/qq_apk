import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcye
  implements View.OnClickListener
{
  public bcye(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    bcxs localbcxs = (bcxs)paramView.getTag();
    if (localbcxs.jdField_a_of_type_Int == bcxq.b)
    {
      bcvs.a(this.a.app, "0X8009938");
      bcvs.a(this.a.app, this.a, 2, "group_online_doc_more_temp", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      bcef.b(this.a.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ataw.a(this.a.app, this.a.a, this.a.app.getLongAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        QQToast.a(this.a, str, 0).a();
      }
      else
      {
        bcvs.a(this.a.app, "0X8009937");
        bcvs.a(this.a.app, this.a, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.a), localbcxs.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo);
        bcef.b(this.a.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcye
 * JD-Core Version:    0.7.0.1
 */