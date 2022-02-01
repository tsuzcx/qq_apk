package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.common.config.LocalConfig;
import com.tencent.biz.qqcircle.widgets.QCircleBubblePopupView;

class QCircleLbsPart$3
  implements Runnable
{
  QCircleLbsPart$3(QCircleLbsPart paramQCircleLbsPart) {}
  
  public void run()
  {
    if ((this.this$0.c() != null) && (this.this$0.c().isFinishing())) {
      return;
    }
    QCircleLbsPart.e(this.this$0).a(this.this$0.c().getResources().getString(2131895779));
    QCircleLbsPart.e(this.this$0).b(5);
    QCircleLbsPart.e(this.this$0).setWidth(-2);
    QCircleLbsPart.e(this.this$0).setHeight(-2);
    QCircleLbsPart.e(this.this$0).a(QCircleLbsPart.f(this.this$0), 1, 0, 0, 0);
    this.this$0.G().postDelayed(QCircleLbsPart.g(this.this$0), 4000L);
    LocalConfig.a("key_sp_bubble_view_show", false, LoginData.a().b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart.3
 * JD-Core Version:    0.7.0.1
 */