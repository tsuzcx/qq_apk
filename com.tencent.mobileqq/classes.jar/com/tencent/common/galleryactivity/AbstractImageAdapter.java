package com.tencent.common.galleryactivity;

import aagc;
import aagk;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  aagc jdField_a_of_type_Aagc;
  private aagk jdField_a_of_type_Aagk;
  
  private aagk a(int paramInt)
  {
    if ((this.jdField_a_of_type_Aagc != null) && (paramInt == this.jdField_a_of_type_Aagc.b())) {
      return this.jdField_a_of_type_Aagk;
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
  
  public aagc a()
  {
    return this.jdField_a_of_type_Aagc;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aagk localaagk = a(paramInt1);
    if (localaagk != null) {
      localaagk.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    aagk localaagk = a(paramInt);
    if (localaagk != null) {
      localaagk.c();
    }
  }
  
  public void a(aagc paramaagc)
  {
    this.jdField_a_of_type_Aagc = paramaagc;
  }
  
  public void a(aagk paramaagk)
  {
    this.jdField_a_of_type_Aagk = paramaagk;
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void b(int paramInt1, int paramInt2)
  {
    aagk localaagk = a(paramInt1);
    if ((localaagk != null) && (localaagk.a())) {
      localaagk.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Aagc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Aagc.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Aagc == null) {
      return null;
    }
    return this.jdField_a_of_type_Aagc.a(paramInt);
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