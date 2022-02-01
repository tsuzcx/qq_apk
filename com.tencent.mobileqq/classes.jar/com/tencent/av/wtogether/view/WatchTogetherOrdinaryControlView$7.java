package com.tencent.av.wtogether.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import com.tencent.av.VideoController;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherOrdinaryControlView$7
  implements View.OnClickListener
{
  WatchTogetherOrdinaryControlView$7(WatchTogetherOrdinaryControlView paramWatchTogetherOrdinaryControlView) {}
  
  public void onClick(View paramView)
  {
    paramView = VideoController.f().aA();
    WatchTogetherOrdinaryControlView.a(this.a, paramView.D());
    paramView = new StringBuilder();
    paramView.append("mBtnVoice onClick CurrentVolume:");
    paramView.append(WatchTogetherOrdinaryControlView.l(this.a));
    QLog.d("WatchTogetherOrdinaryControlView", 1, paramView.toString());
    WatchTogetherOrdinaryControlView.m(this.a).setProgress(WatchTogetherOrdinaryControlView.l(this.a));
    WatchTogetherOrdinaryControlView.n(this.a);
    AVUtil.a("0X800BDAF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView.7
 * JD-Core Version:    0.7.0.1
 */