package com.tencent.avgame.gameroom.stage.guessstar;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.UiUtils;
import com.tencent.qphone.base.util.QLog;

class BaseGuessStarStageView$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseGuessStarStageView$4(BaseGuessStarStageView paramBaseGuessStarStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
    if (QLog.isColorLevel())
    {
      QLog.d("BaseGuessStarStageView", 2, "showTopicTips tip = " + this.jdField_a_of_type_JavaLangString);
      QLog.d("BaseGuessStarStageView", 2, "showTopicTips tipWidth  = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth());
      QLog.d("BaseGuessStarStageView", 2, "showTopicTips caluWidth  = " + i);
    }
    ViewGroup.LayoutParams localLayoutParams;
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (UiUtils.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView) <= 1) {
        break label284;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().b());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 130 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuessStarStageView", 2, "showTopicTips 130 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
      }
    }
    label284:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a());
      localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
      localLayoutParams.height = (localLayoutParams.width * 110 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    } while (!QLog.isColorLevel());
    QLog.d("BaseGuessStarStageView", 2, "showTopicTips 110 w = " + localLayoutParams.width + ", h = " + localLayoutParams.height);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView.4
 * JD-Core Version:    0.7.0.1
 */