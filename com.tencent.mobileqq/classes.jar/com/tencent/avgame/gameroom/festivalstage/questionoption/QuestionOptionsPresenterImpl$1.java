package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class QuestionOptionsPresenterImpl$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QuestionOptionsPresenterImpl$1(QuestionOptionsPresenterImpl paramQuestionOptionsPresenterImpl, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    QuestionOptionsPresenterImpl.a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsPresenterImpl).a(QuestionOptionsPresenterImpl.b(), QuestionOptionsPresenterImpl.a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsPresenterImpl), this.jdField_a_of_type_Boolean, true);
    QuestionOptionsPresenterImpl.a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsPresenterImpl).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsPresenterImpl.1
 * JD-Core Version:    0.7.0.1
 */