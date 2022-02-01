package com.tencent.av.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class MultiVideoCtrlLayerUIBase$10
  implements View.OnClickListener
{
  MultiVideoCtrlLayerUIBase$10(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.V())
    {
      QLog.d(this.a.X, 1, "onClick R.id.qav_btn_accept_video");
      DataReport.b(NetworkUtil.isWifiConnected((Context)this.a.ak.get()), this.a.am.k().o);
      this.a.K();
      this.a.am.k().bA = true;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.10
 * JD-Core Version:    0.7.0.1
 */