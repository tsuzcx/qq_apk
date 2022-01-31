package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import zir;
import ziz;

public abstract class AbstractImageAdapter
  extends BaseAdapter
{
  zir jdField_a_of_type_Zir;
  private ziz jdField_a_of_type_Ziz;
  
  private ziz a(int paramInt)
  {
    if ((this.jdField_a_of_type_Zir != null) && (paramInt == this.jdField_a_of_type_Zir.b())) {
      return this.jdField_a_of_type_Ziz;
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
  
  public zir a()
  {
    return this.jdField_a_of_type_Zir;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ziz localziz = a(paramInt1);
    if (localziz != null) {
      localziz.a(paramInt2);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ziz localziz = a(paramInt);
    if (localziz != null) {
      localziz.c();
    }
  }
  
  public abstract void a(View paramView, int paramInt);
  
  public void a(zir paramzir)
  {
    this.jdField_a_of_type_Zir = paramzir;
  }
  
  public void a(ziz paramziz)
  {
    this.jdField_a_of_type_Ziz = paramziz;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    ziz localziz = a(paramInt1);
    if ((localziz != null) && (localziz.a())) {
      localziz.a(paramInt2);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Zir == null) {
      return 0;
    }
    return this.jdField_a_of_type_Zir.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Zir == null) {
      return null;
    }
    return this.jdField_a_of_type_Zir.a(paramInt);
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