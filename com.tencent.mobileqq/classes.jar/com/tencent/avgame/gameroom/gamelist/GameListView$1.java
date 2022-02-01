package com.tencent.avgame.gameroom.gamelist;

import android.app.Activity;
import android.content.res.Resources;
import bdla;
import bhdj;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import nfc;
import nfv;
import nja;
import njb;
import njc;
import njj;

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
      } while ((nfc.a().a().a() != 0) || (!nfc.a().e()));
      i = nfc.a().a();
      if (QLog.isColorLevel()) {
        QLog.i("GameListView", 2, "match delay check.  currentPlayNum:" + i + " preNum:" + GameListView.a(this.this$0));
      }
      if (i == 1)
      {
        this.this$0.a.d();
        bhdj.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131690384), this.this$0.getResources().getString(2131690388), this.this$0.getResources().getString(2131690383), new nja(this), new njb(this)).show();
        bdla.b(null, "dc00898", "", "", "0X800B499", "0X800B499", 0, 0, "", "", "", "");
        return;
      }
    } while (i > GameListView.a(this.this$0));
    this.this$0.a.d();
    bhdj.a(this.this$0.getContext(), 230, null, this.this$0.getResources().getString(2131690385), this.this$0.getResources().getString(2131690469), null, null, new njc(this)).show();
    bdla.b(null, "dc00898", "", "", "0X800B49C", "0X800B49C", nfc.a().a().a().players.size(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListView.1
 * JD-Core Version:    0.7.0.1
 */