package com.tencent.av.wtogether.view;

import android.content.res.Resources;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.wtogether.util.WTogetherUtil;

class WatchTogetherAdminControlView$25
  implements Runnable
{
  WatchTogetherAdminControlView$25(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void run()
  {
    WatchTogetherAdminControlView.a(this.this$0, 4, 2);
    AVActivity localAVActivity = (AVActivity)this.this$0.getContext();
    if (localAVActivity.s() >= 4) {
      return;
    }
    WTogetherUtil.a(localAVActivity, localAVActivity.getResources().getString(2131893771));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.25
 * JD-Core Version:    0.7.0.1
 */