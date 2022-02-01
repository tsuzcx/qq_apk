package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;

class ReadInJoyAdPopSheetDialog$6
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  ReadInJoyAdPopSheetDialog$6(ReadInJoyAdPopSheetDialog paramReadInJoyAdPopSheetDialog, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onSoftKeyboardClosed()
  {
    if (System.currentTimeMillis() - ReadInJoyAdPopSheetDialog.d(this.b) > 500L)
    {
      this.a.topMargin = AIOUtils.b(140.5F, ReadInJoyAdPopSheetDialog.b(this.b).getResources());
      ReadInJoyAdPopSheetDialog.e(this.b).setLayoutParams(this.a);
      ReadInJoyAdPopSheetDialog.b(this.b, System.currentTimeMillis());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (System.currentTimeMillis() - ReadInJoyAdPopSheetDialog.d(this.b) > 500L)
    {
      this.a.topMargin = AIOUtils.b(40.0F, ReadInJoyAdPopSheetDialog.b(this.b).getResources());
      ReadInJoyAdPopSheetDialog.e(this.b).setLayoutParams(this.a);
      ReadInJoyAdPopSheetDialog.b(this.b, System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.6
 * JD-Core Version:    0.7.0.1
 */