package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.RecentGameTabData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnAddTabListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;

class GameMsgBoxFragment$7
  implements AbsSlidingIndicator.OnAddTabListener
{
  GameMsgBoxFragment$7(GameMsgBoxFragment paramGameMsgBoxFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt > 0)
    {
      VideoReport.setPageId(GameMsgBoxFragment.k(this.a), "pg_gb_message");
      VideoReport.setElementId(paramView, "em_gb_label");
      IGameMsgBoxManager localIGameMsgBoxManager = (IGameMsgBoxManager)GameMsgBoxFragment.d(this.a).getRuntimeService(IGameMsgBoxManager.class, "");
      try
      {
        VideoReport.setElementParam(paramView, "gameid", ((RecentGameTabData)localIGameMsgBoxManager.getTitles().get(paramInt - 1)).a.c);
        return;
      }
      catch (Exception paramView)
      {
        QLog.e("GameMsgBoxFragment", 1, paramView, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.7
 * JD-Core Version:    0.7.0.1
 */