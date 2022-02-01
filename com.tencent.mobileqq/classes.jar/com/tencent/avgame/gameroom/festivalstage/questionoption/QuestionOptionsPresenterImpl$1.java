package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class QuestionOptionsPresenterImpl$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QuestionOptionsPresenterImpl$1(QuestionOptionsPresenterImpl paramQuestionOptionsPresenterImpl, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    QuestionOptionsPresenterImpl.b(this.b).a(QuestionOptionsPresenterImpl.c(), QuestionOptionsPresenterImpl.a(this.b), this.a, true);
    QuestionOptionsPresenterImpl.b(this.b).getViewTreeObserver().removeGlobalOnLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsPresenterImpl.1
 * JD-Core Version:    0.7.0.1
 */