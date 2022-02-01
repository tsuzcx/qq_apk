import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class befd
  implements View.OnClickListener
{
  public befd(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void onClick(View paramView)
  {
    beer localbeer = (beer)paramView.getTag();
    if (localbeer.jdField_a_of_type_Int == beep.b)
    {
      becr.a(this.a.app, "0X8009938");
      becr.a(this.a.app, this.a, 2, "group_online_doc_more_temp", this.a.a, GroupTeamWorkListActivity.a(this.a), this.a.app.getLongAccountUin());
      bdla.b(this.a.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = aufd.a(this.a.app, this.a.a, this.a.app.getLongAccountUin());
      if (!TextUtils.isEmpty(str))
      {
        QQToast.a(this.a, str, 0).a();
      }
      else
      {
        becr.a(this.a.app, "0X8009937");
        becr.a(this.a.app, this.a, "group_online_doc_temp", GroupTeamWorkListActivity.a(this.a), localbeer.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupPadTemplateInfo);
        bdla.b(this.a.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.a(this.a), "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befd
 * JD-Core Version:    0.7.0.1
 */