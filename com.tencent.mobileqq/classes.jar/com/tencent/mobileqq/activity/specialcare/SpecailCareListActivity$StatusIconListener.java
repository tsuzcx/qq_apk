package com.tencent.mobileqq.activity.specialcare;

import android.graphics.Bitmap;
import com.tencent.mobileqq.richstatus.IIconListener;

class SpecailCareListActivity$StatusIconListener
  implements IIconListener
{
  private SpecailCareListActivity$StatusIconListener(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 200))
    {
      if (this.b.d != 0)
      {
        this.b.b = true;
        return;
      }
      this.b.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.StatusIconListener
 * JD-Core Version:    0.7.0.1
 */