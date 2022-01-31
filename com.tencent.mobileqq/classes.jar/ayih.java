import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ayih
  extends ayis
{
  public ayih(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupTeamWorkListActivity", 2, " onDeletePanInfo success: " + paramBoolean + " \nretCode: " + paramInt + " \nerrorMsg: " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, 5);
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131691520), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
      return;
    }
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131691513), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(2);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, List<GPadInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, " onGetPadTemplateList success: " + paramBoolean + " \nretCode: " + paramInt + " \nerrorMsg: " + paramString);
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, 2);
      if (GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity) != null) {
        GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, List<GPadInfo> paramList, int paramInt2, int paramInt3)
  {
    int i = 1;
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, " onGetPadList success: " + paramBoolean + " \nretCode: " + paramInt1 + " \nerrorMsg: " + paramString + "\n next =" + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.b = paramInt2;
    if (GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity))
    {
      if (paramBoolean)
      {
        paramInt2 = 1;
        paramString = this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a.obtainMessage(111, paramInt2, 0);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a.sendMessageDelayed(paramString, 500L);
        GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, false);
      }
    }
    else
    {
      if (GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity))
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(2);
        GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, false);
      }
      if (paramInt3 != 2) {
        break label211;
      }
      paramInt2 = 3;
    }
    for (;;)
    {
      if ((paramBoolean) && (paramInt1 == 0))
      {
        GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity, paramInt2);
        paramInt1 = j;
        if (paramInt1 != 0) {
          GroupTeamWorkListActivity.d(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(8);
        }
        return;
        paramInt2 = 2;
        break;
        label211:
        if (paramInt3 != 3) {
          break label398;
        }
        paramInt2 = 4;
        continue;
      }
      if (paramInt2 == 2)
      {
        if ((GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity) != null) && (GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).getCount() == 0))
        {
          GroupTeamWorkListActivity.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(8);
          if (GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).getVisibility() == 0) {
            GroupTeamWorkListActivity.b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(8);
          }
          GroupTeamWorkListActivity.c(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity).setVisibility(0);
        }
      }
      else
      {
        label300:
        if (paramInt2 != 4) {
          break label393;
        }
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131693974), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
      }
      label393:
      for (paramInt1 = i;; paramInt1 = 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.a(2);
        break;
        bcql.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.app.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getString(2131693974), 0).b(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupGroupTeamWorkListActivity.getTitleBarHeight());
        break label300;
      }
      label398:
      paramInt2 = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayih
 * JD-Core Version:    0.7.0.1
 */