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
    Object localObject1 = this.jdField_a_of_type_AndroidViewView;
    if ((localObject1 != null) && (((View)localObject1).getParent() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.b, 2, "show holmes guide!");
      }
      int j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidContentContext);
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1034)
      {
        localObject1 = (CircleGuideView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364637);
        float f1 = this.b.getX();
        float f2 = this.b.getWidth() / 2;
        float f3 = j;
        float f4 = this.b.getY();
        float f5 = this.b.getHeight() / 2;
        i = 24;
        if (Build.VERSION.SDK_INT <= 18) {
          i = 20;
        }
        ((CircleGuideView)localObject1).setCircle(f1 + f2, f3 + f4 + f5, AIOUtils.b(i, ConfessChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie).getResources()));
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691063);
      }
      else
      {
        localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131373126);
        localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = (this.b.getLeft() + ConfessChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie).getLeft());
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = (this.b.getTop() + j + ConfessChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie).getTop());
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691062);
      }
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368208).setPadding(0, j, 0, 0);
      Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368211);
      ConfessConfig localConfessConfig = ((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
      if (localConfessConfig == null) {
        i = 5;
      } else {
        i = localConfessConfig.k;
      }
      ((ImageView)localObject2).setImageResource(ConfessChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie, i));
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368210)).setContentDescription(String.format((String)localObject1, new Object[] { Integer.valueOf(i) }));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie;
      ((ConfessChatPie)localObject1).jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(((ConfessChatPie)localObject1).jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildConfessChatPie.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.2
 * JD-Core Version:    0.7.0.1
 */