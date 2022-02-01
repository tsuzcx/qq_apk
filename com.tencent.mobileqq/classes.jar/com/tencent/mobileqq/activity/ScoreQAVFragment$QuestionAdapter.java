package com.tencent.mobileqq.activity;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

class ScoreQAVFragment$QuestionAdapter
  extends RecyclerView.Adapter<ScoreQAVFragment.QuestionAdapter.MyViewHolder>
{
  ScoreQAVFragment.OnItemClickListener jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener;
  
  ScoreQAVFragment$QuestionAdapter(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public ScoreQAVFragment.QuestionAdapter.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ScoreQAVFragment.QuestionAdapter.MyViewHolder(this, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()).inflate(2131559884, paramViewGroup, false), this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener);
  }
  
  public void a(ScoreQAVFragment.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void a(ScoreQAVFragment.QuestionAdapter.MyViewHolder paramMyViewHolder, int paramInt)
  {
    paramMyViewHolder.a.setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.get(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.a(paramInt)) {
      paramMyViewHolder.a.setSelected(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramMyViewHolder, paramInt, getItemId(paramInt));
      return;
      paramMyViewHolder.a.setSelected(false);
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityScoreQAVFragment.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.QuestionAdapter
 * JD-Core Version:    0.7.0.1
 */