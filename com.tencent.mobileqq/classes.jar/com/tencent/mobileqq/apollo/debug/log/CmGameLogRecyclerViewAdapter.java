package com.tencent.mobileqq.apollo.debug.log;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class CmGameLogRecyclerViewAdapter
  extends RecyclerView.Adapter<CmGameLogRecyclerViewAdapter.CmGameLogViewHolder>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private List<CmGameLogData> jdField_a_of_type_JavaUtilList;
  
  public CmGameLogRecyclerViewAdapter(Context paramContext, List<CmGameLogData> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public CmGameLogRecyclerViewAdapter.CmGameLogViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 1)) {
      return new CmGameLogRecyclerViewAdapter.CmGameLogViewHolder(this, this.jdField_a_of_type_AndroidViewView);
    }
    return new CmGameLogRecyclerViewAdapter.CmGameLogViewHolder(this, LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558978, paramViewGroup, false));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(getItemCount() - 1);
  }
  
  public void a(CmGameLogRecyclerViewAdapter.CmGameLogViewHolder paramCmGameLogViewHolder, int paramInt)
  {
    if (getItemViewType(paramInt) == 0)
    {
      CmGameLogData localCmGameLogData = (CmGameLogData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramCmGameLogViewHolder.a.setText(localCmGameLogData.jdField_a_of_type_JavaLangString);
      paramCmGameLogViewHolder.a.setTextColor(Color.parseColor(com.tencent.mobileqq.apollo.debug.CmGameDebugManager.c[localCmGameLogData.jdField_a_of_type_Int]));
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramCmGameLogViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<CmGameLogData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == getItemCount() - 1)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.log.CmGameLogRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */