package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;

class AVGameLobbyOnClickListenerFactory$2
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$2(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {
      return;
    }
    paramInt = ((AVGameLobbyFixedContentInfo)paramIBaseData).f();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        this.a.a.a(1);
        return;
      }
      this.a.a.b();
      return;
    }
    this.a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.2
 * JD-Core Version:    0.7.0.1
 */