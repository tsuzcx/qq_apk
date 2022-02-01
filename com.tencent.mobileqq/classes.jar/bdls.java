import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdls
  implements View.OnClickListener
{
  public bdls(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    bdlg localbdlg = (bdlg)paramView.getTag();
    if (localbdlg.jdField_a_of_type_Int == bdle.b)
    {
      bdjg.a(this.a.app, "0X8009938");
      bdjg.a(this.a.app, this.a, 2, "group_online_doc_more_temp", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      bcst.b(this.a.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = atwt.a(this.a.app, this.a.a, this.a.app.getLongAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        QQToast.a(this.a, str, 0).a();
      }
      else
      {
        bdjg.a(this.a.app, "0X8009937");
        bdjg.a(this.a.app, this.a, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.a), localbdlg.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo);
        bcst.b(this.a.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdls
 * JD-Core Version:    0.7.0.1
 */