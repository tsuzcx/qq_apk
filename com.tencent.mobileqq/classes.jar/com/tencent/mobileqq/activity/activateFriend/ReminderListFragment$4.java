package com.tencent.mobileqq.activity.activateFriend;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;

class ReminderListFragment$4
  implements Runnable
{
  ReminderListFragment$4(ReminderListFragment paramReminderListFragment) {}
  
  public void run()
  {
    ReminderListFragment.c(this.this$0).setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ReminderListFragment.d(this.this$0).getHeight();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ReminderListFragment.d(this.this$0).getWidth();
    localObject = URLDrawable.getDrawable("https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png", (URLDrawable.URLDrawableOptions)localObject);
    if (localObject != null) {
      ReminderListFragment.d(this.this$0).setImageDrawable((Drawable)localObject);
    }
    ReminderListFragment.e(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment.4
 * JD-Core Version:    0.7.0.1
 */