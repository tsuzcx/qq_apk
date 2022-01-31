package com.tencent.mobileqq.activity.aio.doodle.control;

import acus;
import acuu;
import acuv;
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
  private RDBaseListLayout<TItemData, TItemViewHolder>.acuu jdField_a_of_type_Acuu;
  private View jdField_a_of_type_AndroidViewView;
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
  
  private RDBaseListLayout<TItemData, TItemViewHolder>.acuv a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (Object localObject = paramView;; localObject = (View)localObject)
    {
      localObject = ((View)localObject).getTag();
      if ((localObject != null) && ((localObject instanceof acuv))) {
        return (acuv)localObject;
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
      ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).setAdapter(this.jdField_a_of_type_Acuu);
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
    ((ListView)this.jdField_a_of_type_AndroidViewView).setAdapter(this.jdField_a_of_type_Acuu);
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public abstract TItemViewHolder a(int paramInt, TItemData paramTItemData);
  
  public abstract void a();
  
  public abstract void a(int paramInt, TItemData paramTItemData);
  
  public abstract void a(int paramInt, @NonNull TItemData paramTItemData, @NonNull TItemViewHolder paramTItemViewHolder);
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_Int >= 0))
    {
      ((acus)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a(false);
      this.jdField_a_of_type_Int = -1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((acus)localObject).a(true);
    ((acus)localObject).a(true);
    if ((this.jdField_a_of_type_AndroidViewView instanceof ListView)) {
      ((ListView)this.jdField_a_of_type_AndroidViewView).setSelection(paramInt);
    }
    for (;;)
    {
      a(paramInt, localObject);
      this.jdField_a_of_type_Int = paramInt;
      c();
      return;
      if ((this.jdField_a_of_type_AndroidViewView instanceof HorizontalListView))
      {
        ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).setSelection(paramInt);
        ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).smoothScrollToPosition(paramInt, 0, 1);
      }
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
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (paramBoolean) {
      c();
    }
  }
  
  public abstract boolean a();
  
  public boolean a(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_Acuu = new acuu(this, null);
    this.jdField_a_of_type_Acuu.a();
    a(this.b);
    boolean bool = a();
    if (bool) {
      this.jdField_a_of_type_Acuu.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Acuu != null) {
      this.jdField_a_of_type_Acuu.b();
    }
  }
  
  public void b(TItemData paramTItemData, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (!paramTItemData.equals(localObject)) {
          break label150;
        }
        if ((!paramBoolean) && (this.jdField_a_of_type_Int >= 0))
        {
          ((acus)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a(false);
          this.jdField_a_of_type_Int = -1;
        }
        ((acus)localObject).a(true);
        if (!(this.jdField_a_of_type_AndroidViewView instanceof ListView)) {
          break label113;
        }
        ((ListView)this.jdField_a_of_type_AndroidViewView).setSelection(i);
      }
      for (;;)
      {
        a(i, localObject);
        this.jdField_a_of_type_Int = i;
        c();
        return;
        label113:
        if ((this.jdField_a_of_type_AndroidViewView instanceof HorizontalListView))
        {
          ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).setSelection(i);
          ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).smoothScrollToPosition(i, 0, 1);
        }
      }
      label150:
      i += 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Acuu != null) {
      this.jdField_a_of_type_Acuu.notifyDataSetChanged();
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOverScrollMode(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
 * JD-Core Version:    0.7.0.1
 */