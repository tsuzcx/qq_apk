package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import xgm;
import xgu;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  xgm jdField_a_of_type_Xgm;
  private xgu jdField_a_of_type_Xgu;
  
  private xgu a(int paramInt)
  {
    if ((this.jdField_a_of_type_Xgm != null) && (paramInt == this.jdField_a_of_type_Xgm.b())) {
      return this.jdField_a_of_type_Xgu;
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
  
  public xgm a()
  {
    return this.jdField_a_of_type_Xgm;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    xgu localxgu = a(paramInt1);
    if (localxgu != null) {
      localxgu.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    xgu localxgu = a(paramInt);
    if (localxgu != null) {
      localxgu.c();
    }
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void a(xgm paramxgm)
  {
    this.jdField_a_of_type_Xgm = paramxgm;
  }
  
  public void a(xgu paramxgu)
  {
    this.jdField_a_of_type_Xgu = paramxgu;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    xgu localxgu = a(paramInt1);
    if ((localxgu != null) && (localxgu.a())) {
      localxgu.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Xgm == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xgm.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Xgm == null) {
      return null;
    }
    return this.jdField_a_of_type_Xgm.a(paramInt);
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