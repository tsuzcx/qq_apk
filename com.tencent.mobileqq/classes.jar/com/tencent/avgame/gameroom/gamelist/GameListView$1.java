package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.content.res.Resources;
import bcef;
import bfur;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mzl;
import naf;
import ndc;
import ndd;
import nde;
import ndl;

public class GameListView$1
  implements Runnable
{
  GameListView$1(GameListView paramGameListView) {}
  
  public void run()
  {
    if (((this.this$0.getContext() instanceof Activity)) && (((Activity)this.this$0.getContext()).isFinishing())) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((mzl.a().a().a() != 0) || (!mzl.a().e()));
      i = mzl.a().a();
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "match delay check.  currentPlayNum:" + i + " preNum:" + GameListView.a(this.this$0));
      }
      if (i == 1)
      {
        this.this$0.a.d();
        bfur.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131690344), this.this$0.getResources().getString(2131690348), this.this$0.getResources().getString(2131690343), new ndc(this), new ndd(this)).show();
        bcef.b(null, "dc00898", "", "", "0X800B499", "0X800B499", 0, 0, "", "", "", "");
        return;
      }
    } while (i > GameListView.a(this.this$0));
    this.this$0.a.d();
    bfur.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131690345), this.this$0.getResources().getString(2131690397), null, null, new nde(this)).show();
    bcef.b(null, "dc00898", "", "", "0X800B49C", "0X800B49C", mzl.a().a().a().players.size(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.1
 * JD-Core Version:    0.7.0.1
 */