package com.tencent.mobileqq.activity.qcircle;

import android.content.res.Resources;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.event.QCircleRewardAdResultEvent;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class QCircleHippyFragment$3
  implements Runnable
{
  QCircleHippyFragment$3(QCircleHippyFragment paramQCircleHippyFragment, SimpleBaseEvent paramSimpleBaseEvent) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.this$0.getQBaseActivity(), 230);
    localQQCustomDialog.setContentView(2131624587);
    localQQCustomDialog.setTitle(((QCircleRewardAdResultEvent)this.a).mToast);
    localQQCustomDialog.setMessage(null);
    localQQCustomDialog.setPositiveButton(this.this$0.getQBaseActivity().getResources().getString(2131892267), new QCircleHippyFragment.3.1(this));
    localQQCustomDialog.setNegativeButton(null, null);
    localQQCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment.3
 * JD-Core Version:    0.7.0.1
 */