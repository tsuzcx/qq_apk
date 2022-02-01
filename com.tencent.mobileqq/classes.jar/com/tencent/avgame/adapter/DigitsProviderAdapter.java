package com.tencent.avgame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.avgame.data.DigitInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class DigitsProviderAdapter
  extends RecyclerView.Adapter<DigitsProviderAdapter.ViewHolder>
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  List<DigitInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public DigitsProviderAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public DigitsProviderAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new DigitsProviderAdapter.ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558758, paramViewGroup, false));
  }
  
  public DigitInfo a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (DigitInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(DigitsProviderAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    DigitInfo localDigitInfo = a(paramInt);
    RecyclerView.LayoutParams localLayoutParams;
    if ((paramInt == 3) || (paramInt == 6))
    {
      localLayoutParams = (RecyclerView.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      localLayoutParams.leftMargin = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramViewHolder.itemView.setLayoutParams(localLayoutParams);
      if ((localDigitInfo == null) || (!localDigitInfo.a())) {
        break label163;
      }
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setText("" + localDigitInfo.a());
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      paramViewHolder.itemView.setTag(localDigitInfo);
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(4);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      localLayoutParams = (RecyclerView.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      paramViewHolder.itemView.setLayoutParams(localLayoutParams);
      break;
      label163:
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setImageResource(2130845369);
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
    }
  }
  
  public void a(List<DigitInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.adapter.DigitsProviderAdapter
 * JD-Core Version:    0.7.0.1
 */