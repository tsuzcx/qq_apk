package com.tencent.avgame.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameRoomFragment$19
  implements View.OnClickListener
{
  GameRoomFragment$19(GameRoomFragment paramGameRoomFragment) {}
  
  public void onClick(View paramView)
  {
    String str = String.format(this.a.getString(2131690384), new Object[] { this.a.b.getText().toString().replace("-", " ") });
    GameRoomFragment.a(this.a, str);
    this.a.a(2, this.a.getString(2131690385));
    if (this.a.a != null)
    {
      this.a.a.dismiss();
      this.a.a = null;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B020", "0X800B020", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment.19
 * JD-Core Version:    0.7.0.1
 */