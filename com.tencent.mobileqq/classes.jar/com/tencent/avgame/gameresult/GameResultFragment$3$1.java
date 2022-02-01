package com.tencent.avgame.gameresult;

import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.GameRecordInfo;
import com.tencent.avgame.ui.AVGamePosterView;
import myk;
import mze;
import nan;

public class GameResultFragment$3$1
  implements Runnable
{
  public GameResultFragment$3$1(nan paramnan, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(GameResultFragment.a(this.jdField_a_of_type_Nan.a)))
    {
      GameRecordInfo localGameRecordInfo = myk.a().a().a();
      GameResultFragment.a(this.jdField_a_of_type_Nan.a, localGameRecordInfo.photoFilePath);
    }
    if (GameResultFragment.a(this.jdField_a_of_type_Nan.a).a(this.jdField_a_of_type_JavaLangString))
    {
      GameResultFragment.a(this.jdField_a_of_type_Nan.a).setVisibility(0);
      GameResultFragment.a(this.jdField_a_of_type_Nan.a).a("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultFragment.3.1
 * JD-Core Version:    0.7.0.1
 */