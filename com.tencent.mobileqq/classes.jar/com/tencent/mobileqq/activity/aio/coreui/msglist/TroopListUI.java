package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.widget.ListView;

public class TroopListUI
  extends BaseTroopListUI
{
  public TroopListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void h()
  {
    ThreadManager.post(new TroopListUI.1(this), 5, null, true);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    ((TroopManager)this.a.a().getManager(QQManagerFactory.TROOP_MANAGER)).f(this.a.a().a);
    return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI
 * JD-Core Version:    0.7.0.1
 */