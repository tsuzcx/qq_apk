package com.tencent.common.galleryactivity;

import aavo;
import aavw;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  aavo jdField_a_of_type_Aavo;
  private aavw jdField_a_of_type_Aavw;
  
  private aavw a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aavo != null) && (paramInt == this.jdField_a_of_type_Aavo.b())) {
      return this.jdField_a_of_type_Aavw;
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
  
  public aavo a()
  {
    return this.jdField_a_of_type_Aavo;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aavw localaavw = a(paramInt1);
    if (localaavw != null) {
      localaavw.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    aavw localaavw = a(paramInt);
    if (localaavw != null) {
      localaavw.c();
    }
  }
  
  public void a(aavo paramaavo)
  {
    this.jdField_a_of_type_Aavo = paramaavo;
  }
  
  public void a(aavw paramaavw)
  {
    this.jdField_a_of_type_Aavw = paramaavw;
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void b(int paramInt1, int paramInt2)
  {
    aavw localaavw = a(paramInt1);
    if ((localaavw != null) && (localaavw.a())) {
      localaavw.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Aavo == null) {
      return 0;
    }
    return this.jdField_a_of_type_Aavo.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Aavo == null) {
      return null;
    }
    return this.jdField_a_of_type_Aavo.a(paramInt);
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