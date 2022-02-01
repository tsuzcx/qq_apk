package com.tencent.mobileqq.activity;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ScoreQAVFragment$QuestionAdapter$MyViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  Button jdField_a_of_type_AndroidWidgetButton;
  ScoreQAVFragment.OnItemClickListener jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener;
  
  public ScoreQAVFragment$QuestionAdapter$MyViewHolder(ScoreQAVFragment.QuestionAdapter paramQuestionAdapter, View paramView, ScoreQAVFragment.OnItemClickListener paramOnItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131374736));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    ScoreQAVFragment.OnItemClickListener localOnItemClickListener = this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.a(paramView, getPosition());
    } else if (QLog.isColorLevel()) {
      QLog.d("ScoreActivity", 2, "mOnItemClickListener is null!");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.QuestionAdapter.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */