package com.tencent.mobileqq.activity;

import android.graphics.drawable.Animatable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class SimpleUIChoiceView$ColorListAdapter
  extends RecyclerView.Adapter<SimpleUIChoiceView.ColorHolder>
{
  private int jdField_a_of_type_Int;
  List<SimpleUIChoiceView.ColorItemInfo> jdField_a_of_type_JavaUtilList;
  
  public SimpleUIChoiceView$ColorListAdapter(List<SimpleUIChoiceView.ColorItemInfo> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_Int = SimpleUIUtil.f();
  }
  
  private void a(int paramInt)
  {
    SimpleUIChoiceView.ColorItemInfo localColorItemInfo = a(paramInt);
    if (localColorItemInfo != null) {
      if (localColorItemInfo.jdField_a_of_type_Boolean) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      if (a(localColorItemInfo, paramInt, bool)) {
        SimpleUIChoiceView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView).c(localColorItemInfo.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  public SimpleUIChoiceView.ColorHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = SimpleUIChoiceView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView).getLayoutInflater().inflate(2131563020, paramViewGroup, false);
    return new SimpleUIChoiceView.ColorHolder(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView, paramViewGroup);
  }
  
  public SimpleUIChoiceView.ColorItemInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (SimpleUIChoiceView.ColorItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(SimpleUIChoiceView.ColorHolder paramColorHolder, int paramInt)
  {
    SimpleUIChoiceView.ColorItemInfo localColorItemInfo = a(paramInt);
    if (localColorItemInfo == null)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramColorHolder, paramInt, getItemId(paramInt));
      return;
    }
    if (localColorItemInfo.jdField_a_of_type_Boolean)
    {
      paramColorHolder.b.setVisibility(0);
      ViewCompat.setAccessibilityDelegate(paramColorHolder.jdField_a_of_type_ComTencentImageURLImageView, new SimpleUIChoiceView.ColorListAdapter.1(this));
      label54:
      SimpleUIChoiceView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView, paramColorHolder.jdField_a_of_type_ComTencentImageURLImageView, localColorItemInfo);
      if (!localColorItemInfo.b) {
        break label158;
      }
      paramColorHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((Animatable)paramColorHolder.jdField_a_of_type_AndroidViewView.getBackground()).start();
    }
    for (;;)
    {
      paramColorHolder.itemView.setContentDescription(SimpleUIChoiceView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView)[paramInt]);
      paramColorHolder.itemView.setOnClickListener(new SimpleUIChoiceView.ColorListAdapter.3(this, paramInt));
      break;
      paramColorHolder.b.setVisibility(8);
      ViewCompat.setAccessibilityDelegate(paramColorHolder.jdField_a_of_type_ComTencentImageURLImageView, new SimpleUIChoiceView.ColorListAdapter.2(this));
      break label54;
      label158:
      paramColorHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((Animatable)paramColorHolder.jdField_a_of_type_AndroidViewView.getBackground()).stop();
    }
  }
  
  public void a(List<SimpleUIChoiceView.ColorItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public boolean a(SimpleUIChoiceView.ColorItemInfo paramColorItemInfo, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      notifyItemChanged(paramInt);
      return false;
    }
    paramColorItemInfo.jdField_a_of_type_Boolean = paramBoolean;
    if (paramColorItemInfo.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Int >= 0) {
        break label46;
      }
    }
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = paramInt)
    {
      notifyItemChanged(paramInt);
      return true;
      label46:
      paramColorItemInfo = a(this.jdField_a_of_type_Int);
      if (paramColorItemInfo != null)
      {
        paramColorItemInfo.jdField_a_of_type_Boolean = false;
        paramColorItemInfo.b = false;
        notifyItemChanged(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorListAdapter
 * JD-Core Version:    0.7.0.1
 */