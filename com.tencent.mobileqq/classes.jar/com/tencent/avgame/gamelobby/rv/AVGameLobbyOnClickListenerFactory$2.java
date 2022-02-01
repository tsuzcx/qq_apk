package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;

class AVGameLobbyOnClickListenerFactory$2
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$2(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {
      return;
    }
    switch (((AVGameLobbyFixedContentInfo)paramIBaseData).f())
    {
    default: 
      return;
    case 1: 
      this.a.a.d();
      return;
    case 2: 
      this.a.a.c();
      return;
    }
    this.a.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.2
 * JD-Core Version:    0.7.0.1
 */