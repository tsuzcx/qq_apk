package com.tencent.biz.qqcircle.publish.outbox;

import android.content.Intent;
import android.view.View;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.common.config.LocalConfig;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.OnButtonClickListener;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper.HostEnvironmentLifeCycle;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

class QCirclePublishQueuePart$3
  implements ActionSheet.OnButtonClickListener
{
  QCirclePublishQueuePart$3(QCirclePublishQueuePart paramQCirclePublishQueuePart, IQueueTask paramIQueueTask) {}
  
  public void a(View paramView, int paramInt)
  {
    if (this.b.a != null) {
      this.b.a.dismiss();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      bool = LocalConfig.b("sp_has_loginout", false, LoginData.a().b());
      if ((QCircleConfigHelper.aL()) && (!bool))
      {
        paramView = this.a;
        if ((paramView != null) && (paramView.o() == 1705))
        {
          HostUIHelper.openLoginOutEnvironment(new HostUIHelper.HostEnvironmentLifeCycle(), new Intent().putExtra("key_is_auto_close_host", true));
          return;
        }
        QCirclePublishQueuePart.e(this.b).d(this.a);
        return;
      }
      paramView = new StringBuilder();
      paramView.append("resumeTask... resultCode:");
      paramView.append(this.a.o());
      QLog.d("[QcirclePublish]QCirclePublishQueuePart", 1, paramView.toString());
      QCirclePublishQueuePart.e(this.b).d(this.a);
      return;
    }
    boolean bool = QCirclePublishQueuePart.a(this.b, this.a);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("removeTask:");
      paramView.append(bool);
      QLog.i("[QcirclePublish]QCirclePublishQueuePart", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart.3
 * JD-Core Version:    0.7.0.1
 */