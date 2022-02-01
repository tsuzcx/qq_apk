package com.tencent.mobileqq.activity.qcircle;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRewardAdResultEvent;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QCircleHippyFragment$3
  implements Runnable
{
  QCircleHippyFragment$3(QCircleHippyFragment paramQCircleHippyFragment, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.this$0.getActivity(), 230);
    localQQCustomDialog.setContentView(2131559060);
    localQQCustomDialog.setTitle(((QCircleRewardAdResultEvent)this.a).mToast);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(this.this$0.getActivity().getResources().getString(2131694615), new QCircleHippyFragment.3.1(this));
    localQQCustomDialog.setNegativeButton(null, null);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.3
 * JD-Core Version:    0.7.0.1
 */