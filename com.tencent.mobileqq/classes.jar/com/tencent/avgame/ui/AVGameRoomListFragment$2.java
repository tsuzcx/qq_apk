package com.tencent.avgame.ui;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameRoomListFragment$2
  implements View.OnClickListener
{
  AVGameRoomListFragment$2(AVGameRoomListFragment paramAVGameRoomListFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.a.a != null)
    {
      localObject = this.a.a;
      ReportController.b(null, "dc00898", "", "", "0X800B01D", "0X800B01D", 0, 0, "", "", (String)localObject, "");
      if (!AvGameEntranceUtil.a(this.a.getActivity(), this.a.a)) {
        break label75;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = "";
      break;
      label75:
      localObject = (AvGameManager)this.a.getActivity().app.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (localObject != null) {
        ((AvGameManager)localObject).a(this.a.getActivity(), 6, this.a.a, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.2
 * JD-Core Version:    0.7.0.1
 */