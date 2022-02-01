package com.tencent.mobileqq.activity;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.FixedBounceScrollView;

class QQSettingMe$6
  implements Runnable
{
  QQSettingMe$6(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (!QQSettingMe.m()) {
      return;
    }
    Object localObject1 = new Rect();
    Object localObject2 = QQSettingMe.b("d_document");
    QQSettingMe.j(this.this$0).offsetDescendantRectToMyCoords((View)localObject2, (Rect)localObject1);
    localObject2 = new Rect();
    QQSettingMe.j(this.this$0).getDrawingRect((Rect)localObject2);
    boolean bool = ((Rect)localObject2).contains((Rect)localObject1);
    if (!bool) {
      QQSettingMe.j(this.this$0).scrollTo(QQSettingMe.j(this.this$0).getScrollX(), ((Rect)localObject1).top);
    }
    localObject1 = ThreadManagerV2.getUIHandlerV2();
    localObject2 = new QQSettingMe.6.1(this);
    long l;
    if (bool) {
      l = 0L;
    } else {
      l = 50L;
    }
    ((Handler)localObject1).postDelayed((Runnable)localObject2, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.6
 * JD-Core Version:    0.7.0.1
 */