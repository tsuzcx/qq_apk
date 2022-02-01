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
    if ((this.mPropertyMask & paramInt) != 0)
    {
      ArrayList localArrayList = this.mNameValuesHolder;
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            return false;
          }
          if (((ViewPropertyAnimatorPreHC.NameValuesHolder)this.mNameValuesHolder.get(i)).mNameConstant == paramInt)
          {
            this.mNameValuesHolder.remove(i);
            this.mPropertyMask = ((paramInt ^ 0xFFFFFFFF) & this.mPropertyMask);
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorPreHC.PropertyBundle
 * JD-Core Version:    0.7.0.1
 */