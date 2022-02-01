package com.tencent.av.smallscreen;

import android.view.View;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SmallScreenWatchTogether$2
  implements ActionSheet.OnButtonClickListener
{
  SmallScreenWatchTogether$2(SmallScreenWatchTogether paramSmallScreenWatchTogether, boolean paramBoolean) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.a) {
      i = paramInt + 1;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.b.c();
        return;
      }
      paramView = SessionMgr.a().b();
      VideoController localVideoController = VideoController.f();
      if (paramView.ay == -1) {
        paramView.ay = 0;
      }
      localVideoController.a(paramView.s, 237);
      localVideoController.b(237);
      localVideoController.b(paramView.s, paramView.ay);
      paramView.a("onClick_quit", false);
      paramView.c("onClick_quit", 0);
      return;
    }
    paramView = SessionMgr.a().b();
    if (paramView.r()) {
      ((WTogetherMng)VideoController.f().e.c(17)).g(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenWatchTogether.2
 * JD-Core Version:    0.7.0.1
 */