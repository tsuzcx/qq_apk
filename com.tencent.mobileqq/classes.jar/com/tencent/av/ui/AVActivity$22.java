package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVActivity$22
  implements View.OnClickListener
{
  AVActivity$22(AVActivity paramAVActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.isDestroyed())
    {
      Object localObject1 = this.a.I.k();
      if (!((SessionInfo)localObject1).af)
      {
        int i = ((SessionInfo)localObject1).g;
        long l = AudioHelper.c();
        String str = this.a.i;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onMsgClick, sessionType[");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("], state[");
        ((StringBuilder)localObject2).append(((SessionInfo)localObject1).i);
        ((StringBuilder)localObject2).append("], seq[");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("]");
        QLog.w(str, 1, ((StringBuilder)localObject2).toString());
        if ((i != 1) && (i != 2))
        {
          if ((i == 3) || (i == 4))
          {
            localObject1 = String.valueOf(((SessionInfo)localObject1).aN);
            str = this.a.H.a(this.a.e, (String)localObject1, null);
            localObject2 = this.a;
            ((AVActivity)localObject2).a(l, (String)localObject1, ((AVActivity)localObject2).e, str);
          }
        }
        else
        {
          if (((SessionInfo)localObject1).m()) {
            break label273;
          }
          localObject1 = this.a;
          ((AVActivity)localObject1).a(l, ((AVActivity)localObject1).j, this.a.e, this.a.r);
        }
        if (AVActivity.h(this.a) != null) {
          AVActivity.h(this.a).a();
        }
      }
    }
    label273:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.22
 * JD-Core Version:    0.7.0.1
 */