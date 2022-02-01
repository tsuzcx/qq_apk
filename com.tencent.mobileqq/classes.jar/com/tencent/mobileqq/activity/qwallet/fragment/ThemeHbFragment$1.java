package com.tencent.mobileqq.activity.qwallet.fragment;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

class ThemeHbFragment$1
  implements Runnable
{
  ThemeHbFragment$1(ThemeHbFragment paramThemeHbFragment) {}
  
  public void run()
  {
    ThemeHbFragment.a(this.this$0).startAnimation(ThemeHbFragment.a(this.this$0));
    ThemeHbFragment.a(this.this$0).setVisibility(0);
    this.this$0.mActivity.addHbUploadData("theme.pack.show");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment.1
 * JD-Core Version:    0.7.0.1
 */