package com.tencent.av.wtogether.view;

import android.content.res.Resources;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.wtogether.util.WTogetherUtil;

class WatchTogetherAdminControlView$23
  implements Runnable
{
  WatchTogetherAdminControlView$23(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void run()
  {
    WatchTogetherAdminControlView.a(this.this$0, 4, 2);
    AVActivity localAVActivity = (AVActivity)this.this$0.getContext();
    if (localAVActivity.b() >= 4) {
      return;
    }
    WTogetherUtil.a(localAVActivity, localAVActivity.getResources().getString(2131696009));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.23
 * JD-Core Version:    0.7.0.1
 */