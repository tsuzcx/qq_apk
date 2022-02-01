package com.tencent.av.wtogether.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;

class WatchTogetherAdminControlView$7
  implements View.OnClickListener
{
  WatchTogetherAdminControlView$7(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    int m = 2;
    int n = 0;
    WatchTogetherAdminControlView.a(paramView, 0, 2);
    WatchTogetherAdminControlView.c(this.a);
    paramView = SessionMgr.a().a();
    WTogetherMng localWTogetherMng = (WTogetherMng)VideoController.a().a.a(16);
    if (localWTogetherMng.a(paramView)) {
      localWTogetherMng.d(paramView);
    }
    int i;
    if ((paramView.j) && (paramView.k)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((!paramView.j) && (!paramView.k)) {
      j = 0;
    } else {
      j = 1;
    }
    if (i != 0) {
      i = 1;
    } else if (j != 0) {
      i = 2;
    } else {
      i = 3;
    }
    if ((WatchTogetherAdminControlView.a(this.a) != null) && (WatchTogetherAdminControlView.a(this.a).c())) {
      j = 1;
    } else {
      j = 0;
    }
    int k = n;
    if (WatchTogetherAdminControlView.a(this.a) != null)
    {
      k = n;
      if (WatchTogetherAdminControlView.a(this.a).d()) {
        k = 1;
      }
    }
    if (j != 0)
    {
      j = 1;
    }
    else
    {
      j = m;
      if (k != 0) {
        j = 3;
      }
    }
    AVUtil.a("0X800B631", i, 0, String.valueOf(j), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.7
 * JD-Core Version:    0.7.0.1
 */