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
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenWatchTogether.b();
        return;
      }
      paramView = SessionMgr.a().a();
      VideoController localVideoController = VideoController.a();
      if (paramView.z == -1) {
        paramView.z = 0;
      }
      localVideoController.a(paramView.c, 237);
      localVideoController.b(237);
      localVideoController.b(paramView.c, paramView.z);
      paramView.a("onClick_quit", false);
      paramView.c("onClick_quit", 0);
      return;
    }
    paramView = SessionMgr.a().a();
    if (paramView.r()) {
      ((WTogetherMng)VideoController.a().a.a(16)).d(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenWatchTogether.2
 * JD-Core Version:    0.7.0.1
 */