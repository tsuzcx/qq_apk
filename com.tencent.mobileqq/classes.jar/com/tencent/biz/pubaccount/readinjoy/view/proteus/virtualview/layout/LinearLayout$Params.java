package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;

public class LinearLayout$Params
  extends Layout.Params
{
  public int mLayoutGravity;
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = super.setAttribute(paramInt, paramString);
    if (bool) {
      return bool;
    }
    if (paramInt != 33)
    {
      if (paramInt == 34) {
        this.mLayoutGravity = 4;
      }
    }
    else {
      this.mLayoutGravity = 32;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout.Params
 * JD-Core Version:    0.7.0.1
 */