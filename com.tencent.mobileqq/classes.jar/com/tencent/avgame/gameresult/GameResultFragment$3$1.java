package com.tencent.avgame.gameresult;

import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.ui.AVGamePosterView;

class GameResultFragment$3$1
  implements Runnable
{
  GameResultFragment$3$1(GameResultFragment.3 param3, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(GameResultFragment.a(this.b.a)))
    {
      GameRecordInfo localGameRecordInfo = GameEngine.a().s().v();
      GameResultFragment.a(this.b.a, localGameRecordInfo.photoFilePath);
    }
    if (GameResultFragment.b(this.b.a).a(this.a))
    {
      GameResultFragment.b(this.b.a).setVisibility(0);
      GameResultFragment.b(this.b.a).b("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.3.1
 * JD-Core Version:    0.7.0.1
 */