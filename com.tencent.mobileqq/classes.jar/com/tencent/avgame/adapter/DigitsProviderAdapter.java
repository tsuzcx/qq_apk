package com.tencent.avgame.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.tencent.avgame.data.DigitInfo;
import com.tencent.mobileqq.utils.ViewUtils;
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
    return new DigitsProviderAdapter.ViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558657, paramViewGroup, false));
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
    Object localObject;
    if ((paramInt != 3) && (paramInt != 6))
    {
      localObject = (RecyclerView.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      ((RecyclerView.LayoutParams)localObject).leftMargin = 0;
      paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else
    {
      localObject = (RecyclerView.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      ((RecyclerView.LayoutParams)localObject).leftMargin = ViewUtils.a(20.0F);
      paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((localDigitInfo != null) && (localDigitInfo.a()))
    {
      localObject = DigitsProviderAdapter.ViewHolder.a(paramViewHolder);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localDigitInfo.a());
      ((TextView)localObject).setText(localStringBuilder.toString());
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
      paramViewHolder.itemView.setTag(localDigitInfo);
      DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(4);
      return;
    }
    DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(8);
    DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setImageResource(2130845242);
    DigitsProviderAdapter.ViewHolder.a(paramViewHolder).setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.adapter.DigitsProviderAdapter
 * JD-Core Version:    0.7.0.1
 */