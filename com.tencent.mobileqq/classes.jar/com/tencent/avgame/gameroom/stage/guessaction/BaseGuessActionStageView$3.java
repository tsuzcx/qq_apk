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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic content = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("BaseGuessActionStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic contentWidth  = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth());
      QLog.d("BaseGuessActionStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic caluWidth  = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("BaseGuessActionStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (UiUtils.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetTextView) > 1)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().b());
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 130 / 478);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a());
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
      ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 110 / 478);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.BaseGuessActionStageView.3
 * JD-Core Version:    0.7.0.1
 */