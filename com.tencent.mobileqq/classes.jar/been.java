import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class been
  implements View.OnClickListener
{
  public been(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    beeb localbeeb = (beeb)paramView.getTag();
    if (localbeeb.jdField_a_of_type_Int == bedz.b)
    {
      becb.a(this.a.app, "0X8009938");
      becb.a(this.a.app, this.a, 2, "group_online_doc_more_temp", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      bdll.b(this.a.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = auoo.a(this.a.app, this.a.a, this.a.app.getLongAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        QQToast.a(this.a, str, 0).a();
      }
      else
      {
        becb.a(this.a.app, "0X8009937");
        becb.a(this.a.app, this.a, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.a), localbeeb.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo);
        bdll.b(this.a.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     been
 * JD-Core Version:    0.7.0.1
 */