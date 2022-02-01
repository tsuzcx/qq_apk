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

class MultiVideoCtrlLayerUIBase$9
  implements View.OnClickListener
{
  MultiVideoCtrlLayerUIBase$9(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onClick(View paramView)
  {
    if (this.a.h()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d(this.a.d, 1, "onClick R.id.qav_btn_accept_video");
      DataReport.b(NetworkUtil.h((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()), this.a.jdField_a_of_type_ComTencentAvVideoController.a().D);
      this.a.e();
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().as = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.9
 * JD-Core Version:    0.7.0.1
 */