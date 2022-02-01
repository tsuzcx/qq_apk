package com.tencent.av.wtogether.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import com.tencent.av.VideoController;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherAdminControlView$13
  implements View.OnClickListener
{
  WatchTogetherAdminControlView$13(WatchTogetherAdminControlView paramWatchTogetherAdminControlView) {}
  
  public void onClick(View paramView)
  {
    paramView = VideoController.f().aA();
    WatchTogetherAdminControlView.a(this.a, paramView.D());
    paramView = new StringBuilder();
    paramView.append("mBtnVoice onClick CurrentVolume:");
    paramView.append(WatchTogetherAdminControlView.o(this.a));
    QLog.d("WatchTogetherVideoPlayView", 1, paramView.toString());
    WatchTogetherAdminControlView.p(this.a).setProgress(WatchTogetherAdminControlView.o(this.a));
    WatchTogetherAdminControlView.q(this.a);
    AVUtil.a("0X800BDAF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView.13
 * JD-Core Version:    0.7.0.1
 */