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
    if (TextUtils.isEmpty(GameResultFragment.a(this.jdField_a_of_type_ComTencentAvgameGameresultGameResultFragment$3.a)))
    {
      GameRecordInfo localGameRecordInfo = GameEngine.a().a().a();
      GameResultFragment.a(this.jdField_a_of_type_ComTencentAvgameGameresultGameResultFragment$3.a, localGameRecordInfo.photoFilePath);
    }
    if (GameResultFragment.a(this.jdField_a_of_type_ComTencentAvgameGameresultGameResultFragment$3.a).a(this.jdField_a_of_type_JavaLangString))
    {
      GameResultFragment.a(this.jdField_a_of_type_ComTencentAvgameGameresultGameResultFragment$3.a).setVisibility(0);
      GameResultFragment.a(this.jdField_a_of_type_ComTencentAvgameGameresultGameResultFragment$3.a).a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.3.1
 * JD-Core Version:    0.7.0.1
 */