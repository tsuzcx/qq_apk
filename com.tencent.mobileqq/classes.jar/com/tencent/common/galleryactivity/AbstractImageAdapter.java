package com.tencent.common.galleryactivity;

import abjt;
import abkb;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  abjt jdField_a_of_type_Abjt;
  private abkb jdField_a_of_type_Abkb;
  
  private abkb a(int paramInt)
  {
    if ((this.jdField_a_of_type_Abjt != null) && (paramInt == this.jdField_a_of_type_Abjt.b())) {
      return this.jdField_a_of_type_Abkb;
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
  
  public abjt a()
  {
    return this.jdField_a_of_type_Abjt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    abkb localabkb = a(paramInt1);
    if (localabkb != null) {
      localabkb.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    abkb localabkb = a(paramInt);
    if (localabkb != null) {
      localabkb.c();
    }
  }
  
  public void a(abjt paramabjt)
  {
    this.jdField_a_of_type_Abjt = paramabjt;
  }
  
  public void a(abkb paramabkb)
  {
    this.jdField_a_of_type_Abkb = paramabkb;
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void b(int paramInt1, int paramInt2)
  {
    abkb localabkb = a(paramInt1);
    if ((localabkb != null) && (localabkb.a())) {
      localabkb.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Abjt == null) {
      return 0;
    }
    return this.jdField_a_of_type_Abjt.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Abjt == null) {
      return null;
    }
    return this.jdField_a_of_type_Abjt.a(paramInt);
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