package com.tencent.mobileqq.activity.contact.troop;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.ShowExternalTroopListAdapter;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

class ShowExternalTroopListActivity$1
  extends TroopShowExternalObserver
{
  ShowExternalTroopListActivity$1(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1)
  {
    this.a.b = false;
    if ((paramBoolean) && (paramList != null) && (paramList.size() != 0) && (paramInt == 0))
    {
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
      return;
    }
    paramList = this.a;
    paramList.jdField_a_of_type_Int = 0;
    if (paramList.jdField_a_of_type_ComTencentWidgetXListView.isOverscrollHeadVisiable())
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.a);
    }
    if (!this.a.jdField_a_of_type_Boolean)
    {
      paramList = new ArrayList();
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterShowExternalTroopListAdapter.a(paramList);
      paramInt = this.a.getTitleBarHeight();
      paramList = this.a;
      QQToast.a(paramList, 1, paramList.getString(2131696176), 0).b(paramInt);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.1
 * JD-Core Version:    0.7.0.1
 */