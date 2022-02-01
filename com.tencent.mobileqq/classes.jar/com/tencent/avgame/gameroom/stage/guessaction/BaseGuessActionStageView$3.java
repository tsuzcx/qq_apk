package com.tencent.avgame.gameroom.stage.guessaction;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.UiUtils;
import com.tencent.qphone.base.util.QLog;

class BaseGuessActionStageView$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseGuessActionStageView$3(BaseGuessActionStageView paramBaseGuessActionStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingLeft() - this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getPaddingRight();
    if (QLog.isColorLevel())
    {
      QLog.d("BaseGuessActionStageView", 2, "onUpdateCurTopic content = " + this.jdField_a_of_type_JavaLangString);
      QLog.d("BaseGuessActionStageView", 2, "onUpdateCurTopic contentWidth  = " + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth());
      QLog.d("BaseGuessActionStageView", 2, "onUpdateCurTopic caluWidth  = " + i);
    }
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (UiUtils.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView) > 1)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().b());
        localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
        localLayoutParams.height = (localLayoutParams.width * 130 / 478);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
    localLayoutParams.height = (localLayoutParams.width * 110 / 478);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.BaseGuessActionStageView.3
 * JD-Core Version:    0.7.0.1
 */