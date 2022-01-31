package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import xpm;
import xpu;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  xpm jdField_a_of_type_Xpm;
  private xpu jdField_a_of_type_Xpu;
  
  private xpu a(int paramInt)
  {
    if ((this.jdField_a_of_type_Xpm != null) && (paramInt == this.jdField_a_of_type_Xpm.b())) {
      return this.jdField_a_of_type_Xpu;
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
  
  public xpm a()
  {
    return this.jdField_a_of_type_Xpm;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    xpu localxpu = a(paramInt1);
    if (localxpu != null) {
      localxpu.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    xpu localxpu = a(paramInt);
    if (localxpu != null) {
      localxpu.c();
    }
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void a(xpm paramxpm)
  {
    this.jdField_a_of_type_Xpm = paramxpm;
  }
  
  public void a(xpu paramxpu)
  {
    this.jdField_a_of_type_Xpu = paramxpu;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    xpu localxpu = a(paramInt1);
    if ((localxpu != null) && (localxpu.a())) {
      localxpu.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Xpm == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xpm.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Xpm == null) {
      return null;
    }
    return this.jdField_a_of_type_Xpm.a(paramInt);
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