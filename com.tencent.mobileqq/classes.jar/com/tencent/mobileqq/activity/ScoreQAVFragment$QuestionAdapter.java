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
  ScoreQAVFragment.OnItemClickListener a;
  
  ScoreQAVFragment$QuestionAdapter(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public ScoreQAVFragment.QuestionAdapter.MyViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new ScoreQAVFragment.QuestionAdapter.MyViewHolder(this, LayoutInflater.from(this.b.q.getApplication().getApplicationContext()).inflate(2131625801, paramViewGroup, false), this.a);
  }
  
  public void a(ScoreQAVFragment.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }
  
  public void a(ScoreQAVFragment.QuestionAdapter.MyViewHolder paramMyViewHolder, int paramInt)
  {
    paramMyViewHolder.a.setText((CharSequence)this.b.a.get(paramInt));
    if (this.b.b(paramInt)) {
      paramMyViewHolder.a.setSelected(true);
    } else {
      paramMyViewHolder.a.setSelected(false);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramMyViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return this.b.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ScoreQAVFragment.QuestionAdapter
 * JD-Core Version:    0.7.0.1
 */