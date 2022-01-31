package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import zec;
import zek;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  zec jdField_a_of_type_Zec;
  private zek jdField_a_of_type_Zek;
  
  private zek a(int paramInt)
  {
    if ((this.jdField_a_of_type_Zec != null) && (paramInt == this.jdField_a_of_type_Zec.b())) {
      return this.jdField_a_of_type_Zek;
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
  
  public zec a()
  {
    return this.jdField_a_of_type_Zec;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    zek localzek = a(paramInt1);
    if (localzek != null) {
      localzek.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    zek localzek = a(paramInt);
    if (localzek != null) {
      localzek.c();
    }
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void a(zec paramzec)
  {
    this.jdField_a_of_type_Zec = paramzec;
  }
  
  public void a(zek paramzek)
  {
    this.jdField_a_of_type_Zek = paramzek;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    zek localzek = a(paramInt1);
    if ((localzek != null) && (localzek.a())) {
      localzek.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Zec == null) {
      return 0;
    }
    return this.jdField_a_of_type_Zec.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Zec == null) {
      return null;
    }
    return this.jdField_a_of_type_Zec.a(paramInt);
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