package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.CircleGuideView;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class ConfessChatPie$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ConfessChatPie$2(ConfessChatPie paramConfessChatPie, View paramView1, View paramView2) {}
  
  public void onGlobalLayout()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((View)localObject1).getParent() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.c.c, 2, "show holmes guide!");
      }
      int j = ImmersiveUtils.getStatusBarHeight(this.c.e);
      int i;
      if (this.c.ah.a == 1034)
      {
        localObject1 = (CircleGuideView)this.a.findViewById(2131430723);
        float f1 = this.b.getX();
        float f2 = this.b.getWidth() / 2;
        float f3 = j;
        float f4 = this.b.getY();
        float f5 = this.b.getHeight() / 2;
        i = 24;
        if (Build.VERSION.SDK_INT <= 18) {
          i = 20;
        }
        ((CircleGuideView)localObject1).setCircle(f1 + f2, f3 + f4 + f5, AIOUtils.b(i, ConfessChatPie.b(this.c).getResources()));
        localObject1 = this.c.e.getResources().getString(2131888009);
      }
      else
      {
        localObject1 = this.a.findViewById(2131440730);
        localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = (this.b.getLeft() + ConfessChatPie.c(this.c).getLeft());
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (this.b.getTop() + j + ConfessChatPie.c(this.c).getTop());
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = this.c.e.getResources().getString(2131888008);
      }
      this.a.findViewById(2131435073).setPadding(0, j, 0, 0);
      Object localObject2 = (ImageView)this.a.findViewById(2131435076);
      ConfessConfig localConfessConfig = ((ConfessManager)this.c.d.getManager(QQManagerFactory.CONFESS_MANAGER)).d();
      if (localConfessConfig == null) {
        i = 5;
      } else {
        i = localConfessConfig.E;
      }
      ((ImageView)localObject2).setImageResource(ConfessChatPie.a(this.c, i));
      ((ImageView)this.a.findViewById(2131435075)).setContentDescription(String.format((String)localObject1, new Object[] { Integer.valueOf(i) }));
      localObject1 = this.c;
      ((ConfessChatPie)localObject1).bm = new PopupWindow(((ConfessChatPie)localObject1).e);
      this.c.bm.setWindowLayoutMode(-1, -1);
      this.c.bm.setFocusable(true);
      this.c.bm.setBackgroundDrawable(new ColorDrawable(0));
      this.c.bm.setContentView(this.a);
      this.c.bm.setClippingEnabled(false);
      this.c.bm.showAtLocation(new View(this.c.e), 0, 0, 0);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.c.ba.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.2
 * JD-Core Version:    0.7.0.1
 */