package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import yhc;
import ykq;
import zhe;
import zhf;
import zhg;
import zhh;
import zhi;

public class InnerListView
  extends LinearLayout
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List<yhc> jdField_a_of_type_JavaUtilList;
  private zhg jdField_a_of_type_Zhg;
  private zhh jdField_a_of_type_Zhh;
  private zhi jdField_a_of_type_Zhi;
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
    if (this.jdField_a_of_type_Zhi != null)
    {
      if ((this.jdField_a_of_type_Zhi.a() != null) && (!this.jdField_a_of_type_Zhi.a().isEmpty()))
      {
        int j = this.jdField_a_of_type_Zhi.a().size();
        if (j < getChildCount() - a()) {
          removeViews(j, getChildCount() - j - a());
        }
        int i = 0;
        if (i < j)
        {
          Object localObject;
          if (this.jdField_a_of_type_JavaUtilList.size() - 1 >= i) {
            localObject = (yhc)this.jdField_a_of_type_JavaUtilList.get(i);
          }
          for (;;)
          {
            this.jdField_a_of_type_Zhi.a(i, (yhc)localObject);
            localObject = ((yhc)localObject).a();
            if (((View)localObject).getParent() == null) {
              addView((View)localObject, getChildCount() - a());
            }
            ((View)localObject).setOnClickListener(new zhe(this, i));
            ((View)localObject).setOnLongClickListener(new zhf(this, i));
            i += 1;
            break;
            localObject = new yhc(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(this.jdField_a_of_type_Zhi.a(), this, false));
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
      yhc localyhc = new yhc(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt1, this, false));
      this.jdField_a_of_type_JavaUtilList.add(localyhc);
      i += 1;
    }
    ykq.e("DEBUG_TIME", "InnerListView initVHCaches:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void a(View paramView)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramView);
    addView(paramView);
  }
  
  public void setAdapter(zhi paramzhi)
  {
    this.jdField_a_of_type_Zhi = paramzhi;
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
  
  public void setOnItemClickListener(zhg paramzhg)
  {
    this.jdField_a_of_type_Zhg = paramzhg;
  }
  
  public void setOnItemLongClickListener(zhh paramzhh)
  {
    this.jdField_a_of_type_Zhh = paramzhh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.InnerListView
 * JD-Core Version:    0.7.0.1
 */