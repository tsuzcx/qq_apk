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
import uyk;
import uyl;

public abstract class RDBaseListLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uyk jdField_a_of_type_Uyk;
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
  
  private uyl a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (Object localObject = paramView;; localObject = (View)localObject)
    {
      localObject = ((View)localObject).getTag();
      if ((localObject != null) && ((localObject instanceof uyl))) {
        return (uyl)localObject;
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
      ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).setAdapter(this.jdField_a_of_type_Uyk);
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
    ((ListView)this.jdField_a_of_type_AndroidViewView).setAdapter(this.jdField_a_of_type_Uyk);
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
  
  public Object a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public abstract Object a(int paramInt, Object paramObject);
  
  public abstract void a();
  
  public abstract void a(int paramInt, Object paramObject);
  
  public abstract void a(int paramInt, @NonNull Object paramObject1, @NonNull Object paramObject2);
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    if ((!paramBoolean) && (this.jdField_a_of_type_Int >= 0))
    {
      ((RDBaseItemData)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a(false);
      this.jdField_a_of_type_Int = -1;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((RDBaseItemData)localObject).a(true);
    ((RDBaseItemData)localObject).a(true);
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
        ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).a(paramInt, 0, 1);
      }
    }
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
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
    this.jdField_a_of_type_Uyk = new uyk(this, null);
    this.jdField_a_of_type_Uyk.a();
    a(this.b);
    boolean bool = a();
    if (bool) {
      this.jdField_a_of_type_Uyk.notifyDataSetChanged();
    }
    return bool;
  }
  
  public void b()
  {
    a();
    if (this.jdField_a_of_type_Uyk != null) {
      this.jdField_a_of_type_Uyk.b();
    }
  }
  
  public void b(Object paramObject, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (!paramObject.equals(localObject)) {
          break label150;
        }
        if ((!paramBoolean) && (this.jdField_a_of_type_Int >= 0))
        {
          ((RDBaseItemData)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a(false);
          this.jdField_a_of_type_Int = -1;
        }
        ((RDBaseItemData)localObject).a(true);
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
          ((HorizontalListView)this.jdField_a_of_type_AndroidViewView).a(i, 0, 1);
        }
      }
      label150:
      i += 1;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Uyk != null) {
      this.jdField_a_of_type_Uyk.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
 * JD-Core Version:    0.7.0.1
 */