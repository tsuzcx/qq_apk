package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.qphone.base.util.QLog;

class AVGameLobbyOnClickListenerFactory$4
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$4(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {
      return;
    }
    if (paramView.getId() == 2131429087)
    {
      this.a.a.c();
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "Create room button click");
      }
    }
    else if (paramView.getId() == 2131429099)
    {
      this.a.a.a(2);
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "Search room button click");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("AVGameLobbyOnClickListenerFactory", 2, "Create and search button click err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.4
 * JD-Core Version:    0.7.0.1
 */