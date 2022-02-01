package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class MultiMembersAudioUI$1
  implements View.OnClickListener
{
  MultiMembersAudioUI$1(MultiMembersAudioUI paramMultiMembersAudioUI) {}
  
  public void onClick(View paramView)
  {
    if (this.a.j != null)
    {
      MultiMembersUI.Holder localHolder = (MultiMembersUI.Holder)paramView.getTag();
      if (localHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiMembersAudioUI", 2, "onItemClick-->holder is null");
        }
      }
      else
      {
        int i;
        if (localHolder.n) {
          i = 7;
        } else {
          i = this.a.a(localHolder.a);
        }
        if ((this.a.k.size() > 8) && ((this.a.i == 1) || (this.a.i == 2))) {
          this.a.j.a(localHolder.a, localHolder.b, i, true);
        } else {
          this.a.j.a(localHolder.a, localHolder.b, i, false);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersAudioUI.1
 * JD-Core Version:    0.7.0.1
 */