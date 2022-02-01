package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;

class AVGameLobbyOnClickListenerFactory$6
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$6(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {
      return;
    }
    paramView = (AVGameLobbyRandomMatchContentInfo)paramIBaseData;
    this.a.a.b(paramView.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.6
 * JD-Core Version:    0.7.0.1
 */