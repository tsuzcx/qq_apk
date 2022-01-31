package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import xpj;
import xpr;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  xpj jdField_a_of_type_Xpj;
  private xpr jdField_a_of_type_Xpr;
  
  private xpr a(int paramInt)
  {
    if ((this.jdField_a_of_type_Xpj != null) && (paramInt == this.jdField_a_of_type_Xpj.b())) {
      return this.jdField_a_of_type_Xpr;
    }
    return null;
  }
  
  public static void a(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      paramInt = 0;
      if (paramURLDrawable.isAnim()) {
        break;
      }
    }
    for (;;)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      if (bool) {
        paramView.setTag(2131296389, Integer.valueOf(paramInt));
      }
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      bool = false;
    }
  }
  
  public xpj a()
  {
    return this.jdField_a_of_type_Xpj;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    xpr localxpr = a(paramInt1);
    if (localxpr != null) {
      localxpr.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    xpr localxpr = a(paramInt);
    if (localxpr != null) {
      localxpr.c();
    }
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void a(xpj paramxpj)
  {
    this.jdField_a_of_type_Xpj = paramxpj;
  }
  
  public void a(xpr paramxpr)
  {
    this.jdField_a_of_type_Xpr = paramxpr;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    xpr localxpr = a(paramInt1);
    if ((localxpr != null) && (localxpr.a())) {
      localxpr.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Xpj == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xpj.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Xpj == null) {
      return null;
    }
    return this.jdField_a_of_type_Xpj.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageAdapter
 * JD-Core Version:    0.7.0.1
 */