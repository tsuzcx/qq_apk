package com.tencent.biz.qqcircle.manager;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;

class QcircleRewardAdManager$3
  implements Runnable
{
  QcircleRewardAdManager$3(QcircleRewardAdManager paramQcircleRewardAdManager, Context paramContext, String paramString) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((localObject instanceof Activity)) && (((Activity)localObject).isFinishing())) {
      return;
    }
    localObject = QCircleCustomDialog.a(this.a);
    ((QCircleCustomDialog)localObject).a(this.b);
    ((QCircleCustomDialog)localObject).b(this.a.getResources().getString(2131892267), new QcircleRewardAdManager.3.1(this));
    ((QCircleCustomDialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QcircleRewardAdManager.3
 * JD-Core Version:    0.7.0.1
 */