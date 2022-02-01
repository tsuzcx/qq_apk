package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QuestionOptionsView$1
  implements AdapterView.OnItemClickListener
{
  QuestionOptionsView$1(QuestionOptionsView paramQuestionOptionsView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QuestionOptionsView.a(this.a).a(paramInt)) {
      QuestionOptionsView.a(this.a, paramInt);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView.1
 * JD-Core Version:    0.7.0.1
 */