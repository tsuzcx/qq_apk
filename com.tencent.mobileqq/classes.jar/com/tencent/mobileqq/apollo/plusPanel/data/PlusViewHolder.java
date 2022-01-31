package com.tencent.mobileqq.apollo.plusPanel.data;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.plusPanel.AppItemHandler;

public class PlusViewHolder
  extends RecyclerView.ViewHolder
{
  public ImageView a;
  public TextView a;
  public AppItemHandler a;
  
  public PlusViewHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363250));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363249));
  }
  
  public void a(AppItemHandler paramAppItemHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloPlusPanelAppItemHandler = paramAppItemHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.plusPanel.data.PlusViewHolder
 * JD-Core Version:    0.7.0.1
 */