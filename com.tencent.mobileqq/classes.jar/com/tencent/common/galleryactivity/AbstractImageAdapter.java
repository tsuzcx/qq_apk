package com.tencent.common.galleryactivity;

import abfp;
import abfx;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  abfp jdField_a_of_type_Abfp;
  private abfx jdField_a_of_type_Abfx;
  
  private abfx a(int paramInt)
  {
    if ((this.jdField_a_of_type_Abfp != null) && (paramInt == this.jdField_a_of_type_Abfp.b())) {
      return this.jdField_a_of_type_Abfx;
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
  
  public abfp a()
  {
    return this.jdField_a_of_type_Abfp;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    abfx localabfx = a(paramInt1);
    if (localabfx != null) {
      localabfx.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    abfx localabfx = a(paramInt);
    if (localabfx != null) {
      localabfx.c();
    }
  }
  
  public void a(abfp paramabfp)
  {
    this.jdField_a_of_type_Abfp = paramabfp;
  }
  
  public void a(abfx paramabfx)
  {
    this.jdField_a_of_type_Abfx = paramabfx;
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void b(int paramInt1, int paramInt2)
  {
    abfx localabfx = a(paramInt1);
    if ((localabfx != null) && (localabfx.a())) {
      localabfx.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Abfp == null) {
      return 0;
    }
    return this.jdField_a_of_type_Abfp.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Abfp == null) {
      return null;
    }
    return this.jdField_a_of_type_Abfp.a(paramInt);
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