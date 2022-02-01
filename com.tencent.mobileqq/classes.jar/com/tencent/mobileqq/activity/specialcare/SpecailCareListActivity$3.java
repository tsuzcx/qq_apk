package com.tencent.mobileqq.activity.specialcare;

import android.graphics.Bitmap;

class SpecailCareListActivity$3
  extends SpecailCareListActivity.StatusIconListener
{
  SpecailCareListActivity$3(SpecailCareListActivity paramSpecailCareListActivity)
  {
    super(paramSpecailCareListActivity, null);
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (this.a.E != 0)
    {
      this.a.y = true;
      return;
    }
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      this.a.o.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.3
 * JD-Core Version:    0.7.0.1
 */