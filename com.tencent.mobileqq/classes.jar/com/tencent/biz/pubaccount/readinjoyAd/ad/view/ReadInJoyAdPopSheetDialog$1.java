package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

class ReadInJoyAdPopSheetDialog$1
  implements View.OnSystemUiVisibilityChangeListener
{
  ReadInJoyAdPopSheetDialog$1(ReadInJoyAdPopSheetDialog paramReadInJoyAdPopSheetDialog) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramInt = 4866;
    } else {
      paramInt = 771;
    }
    this.a.getWindow().getDecorView().setSystemUiVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.1
 * JD-Core Version:    0.7.0.1
 */