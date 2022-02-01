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
    this.a.q = false;
    if ((paramBoolean) && (paramList != null) && (paramList.size() != 0) && (paramInt == 0))
    {
      if (this.a.c.isOverscrollHeadVisiable())
      {
        this.a.i.a(0);
        this.a.u.sendEmptyMessageDelayed(100, 800L);
        ShowExternalTroopListActivity.a(this.a);
      }
      this.a.g.setVisibility(0);
      if (this.a.d != null)
      {
        this.a.p = paramList.size();
        this.a.d.a(paramList);
      }
      this.a.a(paramList1, true);
      return;
    }
    paramList = this.a;
    paramList.p = 0;
    if (paramList.c.isOverscrollHeadVisiable())
    {
      this.a.u.sendEmptyMessageDelayed(100, 800L);
      ShowExternalTroopListActivity.a(this.a);
    }
    if (!this.a.l)
    {
      paramList = new ArrayList();
      this.a.d.a(paramList);
      paramInt = this.a.getTitleBarHeight();
      paramList = this.a;
      QQToast.makeText(paramList, 1, paramList.getString(2131893942), 0).show(paramInt);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.1
 * JD-Core Version:    0.7.0.1
 */