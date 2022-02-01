package com.tencent.av.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVActivity$20
  implements View.OnClickListener
{
  AVActivity$20(AVActivity paramAVActivity, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    TipsUtil.b(this.c.H, 1044);
    this.c.a(2, false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c.I.p(this.c.I.k().s));
    ((StringBuilder)localObject).append("");
    MagicDataReport.e(((StringBuilder)localObject).toString());
    if (AudioHelper.e())
    {
      localObject = this.c.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qav_double_screen_notify, click[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.a)) {
      new ControlUIObserver.RequestPlayMagicFace(this.b, this.a, false, 4).a(this.c.H);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.20
 * JD-Core Version:    0.7.0.1
 */