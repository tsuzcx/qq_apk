package com.nineoldandroids.view;

import java.util.ArrayList;

class ViewPropertyAnimatorPreHC$PropertyBundle
{
  ArrayList<ViewPropertyAnimatorPreHC.NameValuesHolder> mNameValuesHolder;
  int mPropertyMask;
  
  ViewPropertyAnimatorPreHC$PropertyBundle(int paramInt, ArrayList<ViewPropertyAnimatorPreHC.NameValuesHolder> paramArrayList)
  {
    this.mPropertyMask = paramInt;
    this.mNameValuesHolder = paramArrayList;
  }
  
  boolean cancel(int paramInt)
  {
    int j;
    int i;
    if (((this.mPropertyMask & paramInt) != 0) && (this.mNameValuesHolder != null))
    {
      j = this.mNameValuesHolder.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return false;
      }
      if (((ViewPropertyAnimatorPreHC.NameValuesHolder)this.mNameValuesHolder.get(i)).mNameConstant == paramInt)
      {
        this.mNameValuesHolder.remove(i);
        this.mPropertyMask &= (paramInt ^ 0xFFFFFFFF);
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorPreHC.PropertyBundle
 * JD-Core Version:    0.7.0.1
 */