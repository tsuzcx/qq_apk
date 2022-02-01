package com.tencent.comic.ui;

import android.view.View;
import com.tencent.comic.utils.SimpleBiMap;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class QQComicTabBarView$7$1
  implements Runnable
{
  QQComicTabBarView$7$1(QQComicTabBarView.7 param7, ArrayList paramArrayList, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start show red touch");
    }
    Object localObject2 = null;
    int i = this.d.this$0.getSelectedTabIndex();
    Object localObject1 = localObject2;
    if (i >= 0)
    {
      localObject1 = localObject2;
      if (i < QQComicTabBarView.d(this.d.this$0))
      {
        localObject3 = QQComicTabBarView.a(this.d.this$0, i).getTag(-3);
        localObject1 = localObject2;
        if ((localObject3 instanceof QQComicTabBarView.ViewHolder)) {
          localObject1 = ((QQComicTabBarView.ViewHolder)localObject3).d;
        }
      }
    }
    Object localObject3 = this.a.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      if (this.b) {
        localObject2 = (RedTouchUI)this.d.this$0.e.get(str);
      } else {
        localObject2 = (RedTouchUI)this.d.this$0.e.get(this.d.this$0.f.a(str));
      }
      if ((localObject2 != null) && (!localObject2.equals(localObject1)))
      {
        this.d.this$0.a((RedTouchUI)localObject2, (RedAppInfo)this.c.get(str), false);
      }
      else if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cannot find red touch on path: ");
        ((StringBuilder)localObject2).append(str);
        QLog.d("WebViewTabBarView", 2, ((StringBuilder)localObject2).toString());
      }
    }
    this.d.this$0.b();
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "end show red touch");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTabBarView.7.1
 * JD-Core Version:    0.7.0.1
 */