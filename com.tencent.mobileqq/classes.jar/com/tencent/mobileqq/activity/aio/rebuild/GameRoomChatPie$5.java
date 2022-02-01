package com.tencent.mobileqq.activity.aio.rebuild;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
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
    if (this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
      if (localObject != null)
      {
        HashMap localHashMap = ((WerewolvesPluginInterface)localObject).b();
        localObject = ((WerewolvesPluginInterface)localObject).a();
        if (paramView == this.a.jdField_l_of_type_AndroidWidgetImageView)
        {
          if (this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0)
          {
            if (localHashMap != null) {
              this.a.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
            this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
            this.a.jdField_l_of_type_AndroidWidgetTextView.setVisibility(4);
            GameRoomChatPie.a(this.a).a(25);
            if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) && (localObject != null)) {
              this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)((HashMap)localObject).get("quickWordBgColor")).intValue());
            }
          }
          else
          {
            if (localHashMap != null) {
              this.a.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap.get("textIcon"));
            }
            this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
            this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
            this.a.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
            this.a.aF();
          }
        }
        else if (paramView == this.a.m) {
          if (GameRoomChatPie.b(this.a).a() != 3)
          {
            this.a.a(Integer.valueOf(3));
            if (localHashMap != null) {
              this.a.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
            }
            this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
            this.a.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
            this.a.jdField_l_of_type_AndroidWidgetTextView.setVisibility(4);
          }
          else
          {
            this.a.aF();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.5
 * JD-Core Version:    0.7.0.1
 */