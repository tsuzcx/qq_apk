package com.tencent.avgame.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameRoomFragment$20
  implements View.OnClickListener
{
  GameRoomFragment$20(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = String.format(this.a.getString(2131887218), new Object[] { this.a.m.getText().toString().replace("-", " ") });
    GameRoomFragment.b(this.a, (String)localObject);
    localObject = this.a;
    ((GameRoomFragment)localObject).a(2, ((GameRoomFragment)localObject).getString(2131887219));
    if (this.a.y != null)
    {
      this.a.y.dismiss();
      this.a.y = null;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B020", "0X800B020", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.20
 * JD-Core Version:    0.7.0.1
 */