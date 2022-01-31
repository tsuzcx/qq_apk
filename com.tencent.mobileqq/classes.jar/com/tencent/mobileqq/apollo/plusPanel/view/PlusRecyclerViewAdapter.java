package com.tencent.mobileqq.apollo.plusPanel.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.plusPanel.AppItemHandler;
import com.tencent.mobileqq.apollo.plusPanel.data.PlusViewHolder;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.widget.PopupMenuDialog;
import java.util.List;
import ywg;

public class PlusRecyclerViewAdapter
  extends RecyclerView.Adapter
{
  public Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ywg(this);
  private PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private List jdField_a_of_type_JavaUtilList;
  
  public PlusRecyclerViewAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PlusViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = (ApolloManager)CmGameUtil.a().getManager(152);
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968695, paramViewGroup, false);
    localObject = new PlusViewHolder(paramViewGroup);
    paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return localObject;
  }
  
  public void a(PlusViewHolder paramPlusViewHolder, int paramInt)
  {
    paramPlusViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((AppItemHandler)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a());
    paramPlusViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(((AppItemHandler)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a());
    paramPlusViewHolder.a((AppItemHandler)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(PopupMenuDialog paramPopupMenuDialog)
  {
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = paramPopupMenuDialog;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.plusPanel.view.PlusRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */