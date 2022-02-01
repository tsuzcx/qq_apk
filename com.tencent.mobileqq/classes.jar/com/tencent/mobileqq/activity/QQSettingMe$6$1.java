package com.tencent.mobileqq.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;

class QQSettingMe$6$1
  implements Runnable
{
  QQSettingMe$6$1(QQSettingMe.6 param6) {}
  
  public void run()
  {
    Rect localRect = new Rect();
    Object localObject = QQSettingMe.b("d_document");
    ((View)localObject).getHitRect(localRect);
    localObject = ((View)localObject).findViewById(2131432189);
    localRect.offset(((View)localObject).getLeft() + Utils.a(34.0F, this.a.this$0.d.getResources()), ((View)localObject).getTop() - Utils.a(18.0F, this.a.this$0.d.getResources()));
    localObject = (FrameLayout.LayoutParams)QQSettingMe.c(this.a.this$0).getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).leftMargin = localRect.left;
    ((FrameLayout.LayoutParams)localObject).topMargin = localRect.top;
    QQSettingMe.c(this.a.this$0).setLayoutParams((ViewGroup.LayoutParams)localObject);
    QQSettingMe.c(this.a.this$0).setPadding(Utils.a(6.0F, this.a.this$0.d.getResources()), Utils.a(4.0F, this.a.this$0.d.getResources()), Utils.a(6.0F, this.a.this$0.d.getResources()), Utils.a(8.0F, this.a.this$0.d.getResources()));
    QQSettingMe.c(this.a.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.6.1
 * JD-Core Version:    0.7.0.1
 */