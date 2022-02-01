package com.tencent.avgame.ui;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.QuestionClassInfoItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class AVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter
  extends RecyclerView.Adapter<AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.AVGameQuestionClassViewHolder>
{
  private List<QuestionClassInfoItem> b = new ArrayList(0);
  
  public AVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter(List<QuestionClassInfoItem> paramList)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public QuestionClassInfoItem a(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return (QuestionClassInfoItem)this.b.get(paramInt);
    }
    return null;
  }
  
  public AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.AVGameQuestionClassViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624309, paramViewGroup, false);
    paramInt = ViewUtils.dpToPx(104.0F);
    int i = ViewUtils.dpToPx(104.0F);
    int j = ViewUtils.dpToPx(5.0F);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(paramInt, i));
    paramViewGroup.setPadding(j, j, j, j);
    return new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.AVGameQuestionClassViewHolder(this, paramViewGroup, (ImageView)paramViewGroup.findViewById(2131429071), (ImageView)paramViewGroup.findViewById(2131429072), (TextView)paramViewGroup.findViewById(2131429073));
  }
  
  public void a(AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.AVGameQuestionClassViewHolder paramAVGameQuestionClassViewHolder, int paramInt)
  {
    QuestionClassInfoItem localQuestionClassInfoItem = a(paramInt);
    if (localQuestionClassInfoItem != null)
    {
      paramAVGameQuestionClassViewHolder.d = localQuestionClassInfoItem;
      AVGameQuestionClassSelectDialog.a(localQuestionClassInfoItem.c, paramAVGameQuestionClassViewHolder.a);
      if ((localQuestionClassInfoItem.b != null) && (localQuestionClassInfoItem.b.length() > 0))
      {
        AVGameQuestionClassSelectDialog.a(localQuestionClassInfoItem.b, paramAVGameQuestionClassViewHolder.b);
      }
      else
      {
        paramAVGameQuestionClassViewHolder.c.setText(localQuestionClassInfoItem.a);
        paramAVGameQuestionClassViewHolder.c.setVisibility(0);
      }
      paramAVGameQuestionClassViewHolder.itemView.setOnClickListener(new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.1(this, localQuestionClassInfoItem));
      paramAVGameQuestionClassViewHolder.itemView.setOnTouchListener(new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.2(this));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramAVGameQuestionClassViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter
 * JD-Core Version:    0.7.0.1
 */