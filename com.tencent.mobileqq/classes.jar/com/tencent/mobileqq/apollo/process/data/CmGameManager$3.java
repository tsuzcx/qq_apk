package com.tencent.mobileqq.apollo.process.data;

import ajco;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class CmGameManager$3
  implements Runnable
{
  public CmGameManager$3(ajco paramajco) {}
  
  public void run()
  {
    ajco.a(this.this$0).getApp().getSharedPreferences("apollo_sp" + ajco.a(this.this$0).getCurrentAccountUin(), 4).edit().putInt("sp_key_exit_game_guide_count", this.this$0.a).apply();
    ajco.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameManager.3
 * JD-Core Version:    0.7.0.1
 */