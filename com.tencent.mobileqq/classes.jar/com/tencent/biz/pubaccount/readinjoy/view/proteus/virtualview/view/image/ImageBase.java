package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.util.SparseArray;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

public abstract class ImageBase
  extends ViewBase
{
  public static SparseArray a = new SparseArray();
  public String e;
  public int z = 6;
  
  static
  {
    a.put(0, ImageView.ScaleType.MATRIX);
    a.put(1, ImageView.ScaleType.FIT_XY);
    a.put(2, ImageView.ScaleType.FIT_START);
    a.put(3, ImageView.ScaleType.FIT_CENTER);
    a.put(4, ImageView.ScaleType.FIT_END);
    a.put(5, ImageView.ScaleType.CENTER);
    a.put(6, ImageView.ScaleType.CENTER_CROP);
    a.put(7, ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public ImageBase(VafContext paramVafContext)
  {
    super(paramVafContext);
  }
  
  public void a(String paramString) {}
  
  protected boolean a(int paramInt, String paramString)
  {
    boolean bool2 = super.a(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2) {}
    switch (paramInt)
    {
    default: 
      bool1 = false;
      return bool1;
    case 21: 
      this.e = paramString;
      return true;
    }
    this.e = paramString;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase
 * JD-Core Version:    0.7.0.1
 */