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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTopicTips tip = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("BaseGuessStarStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTopicTips tipWidth  = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getWidth());
      QLog.d("BaseGuessStarStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showTopicTips caluWidth  = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("BaseGuessStarStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      StringBuilder localStringBuilder;
      if (UiUtils.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetTextView) > 1)
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().b());
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 130 / 478);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showTopicTips 130 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessStarStageView", 2, localStringBuilder.toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_ComTencentAvgameGameroomStageIGameStagePresenter.a().a());
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 110 / 478);
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showTopicTips 110 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessStarStageView", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView.4
 * JD-Core Version:    0.7.0.1
 */