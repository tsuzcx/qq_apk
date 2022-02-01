package com.tencent.mobileqq.activity.contact.troop;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

class ShowExternalTroopListActivity$1
  extends TroopBusinessObserver
{
  ShowExternalTroopListActivity$1(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void onGetExtShowTroopList(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1)
  {
    this.a.b = false;
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0))
    {
      this.a.jdField_a_of_type_Int = 0;
      if (this.a.jdField_a_of_type_ComTencentWidgetXListView.isOverscrollHeadVisiable())
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
        ShowExternalTroopListActivity.a(this.a);
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        paramList = new ArrayList();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList);
        paramInt = this.a.getTitleBarHeight();
        QQToast.a(this.a, 1, this.a.getString(2131696159), 0).b(paramInt);
        return;
      }
      this.a.a();
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.isOverscrollHeadVisiable())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.a);
    }
    this.a.c.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter != null)
    {
      this.a.jdField_a_of_type_Int = paramList.size();
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList);
    }
    this.a.a(paramList1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.1
 * JD-Core Version:    0.7.0.1
 */