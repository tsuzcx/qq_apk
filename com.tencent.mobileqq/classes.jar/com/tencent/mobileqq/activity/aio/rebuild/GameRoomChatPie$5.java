package com.tencent.mobileqq.activity.aio.rebuild;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.gamecenter.gameroom.GameQuickWordsPanel;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;

class GameRoomChatPie$5
  implements View.OnClickListener
{
  GameRoomChatPie$5(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void onClick(View paramView)
  {
    if (this.a.bC != null)
    {
      Object localObject = this.a.bC.c();
      if (localObject != null)
      {
        HashMap localHashMap = ((WerewolvesPluginInterface)localObject).j();
        localObject = ((WerewolvesPluginInterface)localObject).i();
        if (paramView == this.a.bs)
        {
          if (this.a.Y.getVisibility() != 0)
          {
            if (localHashMap != null) {
              this.a.bs.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.a.Y.setVisibility(0);
            this.a.Z.setVisibility(0);
            this.a.bu.setVisibility(4);
            GameRoomChatPie.a(this.a).a(25);
            if ((this.a.bJ != null) && (localObject != null)) {
              this.a.bJ.setBackgroundColor(((Integer)((HashMap)localObject).get("quickWordBgColor")).intValue());
            }
          }
          else
          {
            if (localHashMap != null) {
              this.a.bs.setImageDrawable((Drawable)localHashMap.get("textIcon"));
            }
            this.a.Y.setVisibility(4);
            this.a.Z.setVisibility(4);
            this.a.bu.setVisibility(0);
            this.a.aQ();
          }
        }
        else if (paramView == this.a.bt) {
          if (GameRoomChatPie.b(this.a).getCurrentPanel() != 3)
          {
            this.a.a(3);
            if (localHashMap != null) {
              this.a.bs.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.a.Y.setVisibility(0);
            this.a.Z.setVisibility(0);
            this.a.bu.setVisibility(4);
          }
          else
          {
            this.a.aQ();
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.5
 * JD-Core Version:    0.7.0.1
 */