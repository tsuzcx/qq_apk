package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import vap;
import ved;
import wct;
import wcu;
import wcv;
import wcw;
import wcx;

public class InnerListView
  extends LinearLayout
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<vap> jdField_a_of_type_JavaUtilList;
  private wcv jdField_a_of_type_Wcv;
  private wcw jdField_a_of_type_Wcw;
  private wcx jdField_a_of_type_Wcx;
  private List<View> b;
  
  public InnerListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public InnerListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    if (this.b != null) {
      return this.b.size();
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Wcx != null)
    {
      if ((this.jdField_a_of_type_Wcx.a() != null) && (!this.jdField_a_of_type_Wcx.a().isEmpty()))
      {
        int j = this.jdField_a_of_type_Wcx.a().size();
        if (j < getChildCount() - a()) {
          removeViews(j, getChildCount() - j - a());
        }
        int i = 0;
        if (i < j)
        {
          Object localObject;
          if (this.jdField_a_of_type_JavaUtilList.size() - 1 >= i) {
            localObject = (vap)this.jdField_a_of_type_JavaUtilList.get(i);
          }
          for (;;)
          {
            this.jdField_a_of_type_Wcx.a(i, (vap)localObject);
            localObject = ((vap)localObject).a();
            if (((View)localObject).getParent() == null) {
              addView((View)localObject, getChildCount() - a());
            }
            ((View)localObject).setOnClickListener(new wct(this, i));
            ((View)localObject).setOnLongClickListener(new wcu(this, i));
            i += 1;
            break;
            localObject = new vap(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.jdField_a_of_type_Wcx.a(), this, false));
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
        }
      }
      else
      {
        removeViews(0, getChildCount() - a());
      }
      return;
    }
    removeViews(0, getChildCount() - a());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < paramInt2)
    {
      vap localvap = new vap(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt1, this, false));
      this.jdField_a_of_type_JavaUtilList.add(localvap);
      i += 1;
    }
    ved.e("DEBUG_TIME", "InnerListView initVHCaches:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void a(View paramView)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramView);
    addView(paramView);
  }
  
  public void setAdapter(wcx paramwcx)
  {
    this.jdField_a_of_type_Wcx = paramwcx;
    a();
  }
  
  public void setFooterView(int paramInt, View paramView)
  {
    if ((this.b == null) || (this.b.size() <= paramInt))
    {
      a(paramView);
      return;
    }
    this.b.set(paramInt, paramView);
    paramInt = getChildCount() - a() + paramInt;
    removeViewAt(paramInt);
    addView(paramView, paramInt);
  }
  
  public void setOnItemClickListener(wcv paramwcv)
  {
    this.jdField_a_of_type_Wcv = paramwcv;
  }
  
  public void setOnItemLongClickListener(wcw paramwcw)
  {
    this.jdField_a_of_type_Wcw = paramwcw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListView
 * JD-Core Version:    0.7.0.1
 */