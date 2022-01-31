package com.tencent.mobileqq.apollo.plusPanel.view;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.plusPanel.data.PlusOptViewHolder;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.List;

public class PlusOptRecyclerAdapter
  extends RecyclerView.Adapter
{
  public List a;
  
  public PlusOptViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public void a(PlusOptViewHolder paramPlusOptViewHolder, int paramInt)
  {
    paramPlusOptViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((PopupMenuDialog.MenuItem)this.a.get(paramInt)).a);
    paramPlusOptViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(((PopupMenuDialog.MenuItem)this.a.get(paramInt)).b);
    paramPlusOptViewHolder.jdField_a_of_type_ComTencentWidgetPopupMenuDialog$MenuItem = ((PopupMenuDialog.MenuItem)this.a.get(paramInt));
  }
  
  public void a(PlusOptViewHolder paramPlusOptViewHolder, int paramInt, List paramList)
  {
    super.onBindViewHolder(paramPlusOptViewHolder, paramInt, paramList);
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.plusPanel.view.PlusOptRecyclerAdapter
 * JD-Core Version:    0.7.0.1
 */