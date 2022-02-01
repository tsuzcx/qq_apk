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
  private List<QuestionClassInfoItem> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  
  public AVGameQuestionClassSelectDialog$AVGameQuestionClassViewAdapter(List<QuestionClassInfoItem> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public QuestionClassInfoItem a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return (QuestionClassInfoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.AVGameQuestionClassViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558692, paramViewGroup, false);
    paramInt = ViewUtils.b(104.0F);
    int i = ViewUtils.b(104.0F);
    int j = ViewUtils.b(5.0F);
    paramViewGroup.setLayoutParams(new RecyclerView.LayoutParams(paramInt, i));
    paramViewGroup.setPadding(j, j, j, j);
    return new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.AVGameQuestionClassViewHolder(this, paramViewGroup, (ImageView)paramViewGroup.findViewById(2131363197), (ImageView)paramViewGroup.findViewById(2131363198), (TextView)paramViewGroup.findViewById(2131363199));
  }
  
  public void a(AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.AVGameQuestionClassViewHolder paramAVGameQuestionClassViewHolder, int paramInt)
  {
    QuestionClassInfoItem localQuestionClassInfoItem = a(paramInt);
    if (localQuestionClassInfoItem != null)
    {
      paramAVGameQuestionClassViewHolder.jdField_a_of_type_ComTencentAvgameGamelogicDataQuestionClassInfoItem = localQuestionClassInfoItem;
      AVGameQuestionClassSelectDialog.a(localQuestionClassInfoItem.c, paramAVGameQuestionClassViewHolder.jdField_a_of_type_AndroidWidgetImageView);
      if ((localQuestionClassInfoItem.b != null) && (localQuestionClassInfoItem.b.length() > 0))
      {
        AVGameQuestionClassSelectDialog.a(localQuestionClassInfoItem.b, paramAVGameQuestionClassViewHolder.b);
      }
      else
      {
        paramAVGameQuestionClassViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localQuestionClassInfoItem.a);
        paramAVGameQuestionClassViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      paramAVGameQuestionClassViewHolder.itemView.setOnClickListener(new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.1(this, localQuestionClassInfoItem));
      paramAVGameQuestionClassViewHolder.itemView.setOnTouchListener(new AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter.2(this));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramAVGameQuestionClassViewHolder, paramInt, getItemId(paramInt));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameQuestionClassSelectDialog.AVGameQuestionClassViewAdapter
 * JD-Core Version:    0.7.0.1
 */