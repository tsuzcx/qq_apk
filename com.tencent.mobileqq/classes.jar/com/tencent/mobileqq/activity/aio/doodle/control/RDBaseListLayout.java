package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;

public abstract class RDBaseListLayout<TItemData, TItemViewHolder>
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private RDBaseListLayout<TItemData, TItemViewHolder>.RDBaseListAdapter jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter;
  private ArrayList<TItemData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b = 0;
  
  public RDBaseListLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RDBaseListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RDBaseListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private RDBaseListLayout<TItemData, TItemViewHolder>.ViewTagData a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (Object localObject = paramView;; localObject = (View)localObject)
    {
      localObject = ((View)localObject).getTag();
      if ((localObject != null) && ((localObject instanceof RDBaseListLayout.ViewTagData))) {
        return (RDBaseListLayout.ViewTagData)localObject;
      }
      localObject = paramView.getParent();
      if (!(localObject instanceof View)) {
        break;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidViewView = new HorizontalListView(getContext());
      ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).setOverScrollMode(2);
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter);
      addView(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    ScrollView localScrollView = new ScrollView(getContext());
    localScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(localScrollView);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localScrollView.addView(localLinearLayout);
    localLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = new ListView(getContext());
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ((ListView)this.jdField_a_of_type_AndroidViewView).setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter);
    localLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(View paramView)
  {
    paramView = a(paramView);
    if (paramView != null) {
      return paramView.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public TItemData a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public abstract TItemViewHolder a(int paramInt, TItemData paramTItemData);
  
  public abstract void a();
  
  public abstract void a(int paramInt, TItemData paramTItemData);
  
  public abstract void a(int paramInt, @NonNull TItemData paramTItemData, @NonNull TItemViewHolder paramTItemViewHolder);
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        return;
      }
      if (!paramBoolean)
      {
        int i = this.jdField_a_of_type_Int;
        if (i >= 0)
        {
          ((RDBaseItemData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a(false);
          this.jdField_a_of_type_Int = -1;
        }
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject2 = (RDBaseItemData)localObject1;
      ((RDBaseItemData)localObject2).a(true);
      ((RDBaseItemData)localObject2).a(true);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if ((localObject2 instanceof ListView))
      {
        ((ListView)localObject2).setSelection(paramInt);
      }
      else if ((localObject2 instanceof HorizontalListView))
      {
        ((HorizontalListView)localObject2).setSelection(paramInt);
        ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).smoothScrollToPosition(paramInt, 0, 1);
      }
      a(paramInt, localObject1);
      this.jdField_a_of_type_Int = paramInt;
      c();
    }
  }
  
  public void a(TItemData paramTItemData, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTItemData);
    if (paramBoolean) {
      c();
    }
  }
  
  public void a(List<TItemData> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    if (paramBoolean) {
      c();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    if (paramBoolean) {
      c();
    }
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter = new RDBaseListLayout.RDBaseListAdapter(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter.a();
    a(this.b);
    boolean bool = a();
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter.notifyDataSetChanged();
    }
    return bool;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void b()
  {
    a();
    RDBaseListLayout.RDBaseListAdapter localRDBaseListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter;
    if (localRDBaseListAdapter != null) {
      localRDBaseListAdapter.b();
    }
  }
  
  public void b(TItemData paramTItemData, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramTItemData.equals(localObject))
      {
        if (!paramBoolean)
        {
          int j = this.jdField_a_of_type_Int;
          if (j >= 0)
          {
            ((RDBaseItemData)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a(false);
            this.jdField_a_of_type_Int = -1;
          }
        }
        ((RDBaseItemData)localObject).a(true);
        paramTItemData = this.jdField_a_of_type_AndroidViewView;
        if ((paramTItemData instanceof ListView))
        {
          ((ListView)paramTItemData).setSelection(i);
        }
        else if ((paramTItemData instanceof HorizontalListView))
        {
          ((HorizontalListView)paramTItemData).setSelection(i);
          ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).smoothScrollToPosition(i, 0, 1);
        }
        a(i, localObject);
        this.jdField_a_of_type_Int = i;
        c();
        return;
      }
      i += 1;
    }
  }
  
  public void c()
  {
    RDBaseListLayout.RDBaseListAdapter localRDBaseListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlRDBaseListLayout$RDBaseListAdapter;
    if (localRDBaseListAdapter != null) {
      localRDBaseListAdapter.notifyDataSetChanged();
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setOverScrollMode(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
 * JD-Core Version:    0.7.0.1
 */