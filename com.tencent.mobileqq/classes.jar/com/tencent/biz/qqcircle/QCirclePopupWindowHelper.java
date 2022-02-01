package com.tencent.biz.qqcircle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubbleContextMenu;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow;
import com.tencent.biz.qqcircle.richframework.widget.menu.BubblePopupWindow.OnDismissListener;
import com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuItem;
import com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuLayout;
import com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuList;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.MenuContainerStyle;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCirclePushTipView;
import com.tencent.biz.qqcircle.widgets.menu.QCircleBubblePopupWindowStyle;
import com.tencent.biz.qqcircle.widgets.menu.QCircleDisableMenuItemStyle;
import com.tencent.biz.qqcircle.widgets.menu.QCircleMenuContainerStyle;
import com.tencent.biz.qqcircle.widgets.menu.QCircleMenuItemStyle;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

public class QCirclePopupWindowHelper
{
  private static volatile QCirclePopupWindowHelper a;
  private boolean b;
  private PopupWindow c;
  private BubblePopupWindow d;
  private CountDownTimer e;
  
  public static QCirclePopupWindowHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCirclePopupWindowHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private QQCustomMenuItem a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    new QQCustomMenuList();
    Object localObject = ContextCompat.getDrawable(QCircleApplication.APP, paramInt2);
    ((Drawable)localObject).setBounds(0, 0, ViewUtils.a(24.0F), ViewUtils.a(24.0F));
    localObject = new QQCustomMenuItem(paramInt1, paramString, (Drawable)localObject);
    if (paramBoolean) {
      paramString = new QCircleMenuItemStyle();
    } else {
      paramString = new QCircleDisableMenuItemStyle();
    }
    ((QQCustomMenuItem)localObject).a(paramString);
    return localObject;
  }
  
  public void a(Context paramContext, View paramView)
  {
    if (paramContext != null)
    {
      if (paramView == null) {
        return;
      }
      if (QCirclePluginConfig.a().n()) {
        RFThreadManager.getUIHandler().postDelayed(new QCirclePopupWindowHelper.1(this, paramContext, paramView), 1000L);
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      c();
      TextView localTextView = new TextView(paramContext);
      localTextView.setTextColor(paramContext.getResources().getColor(2131168464));
      localTextView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130845462));
      localTextView.setPadding(ViewUtils.a(12.0F), ViewUtils.a(8.0F), ViewUtils.a(12.0F), ViewUtils.a(8.0F));
      localTextView.setText(paramString);
      this.c = new PopupWindow(localTextView, -2, -2);
      this.c.setOutsideTouchable(true);
      this.c.setTouchable(true);
      this.c.showAtLocation(localTextView, 17, 0, 0);
      this.e = new QCirclePopupWindowHelper.2(this, 3000L, 3000L, paramContext);
      this.e.start();
      return;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("showRecommendAnimation error");
      paramString.append(paramContext.getMessage());
      QLog.e("QCirclePopupWindowHelper", 1, paramString.toString());
      paramContext.printStackTrace();
    }
  }
  
  public void a(View paramView, QCirclePopupWindowHelper.MenuClickListener paramMenuClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.d = new BubblePopupWindow(-2, -2);
    QQCustomMenuList localQQCustomMenuList = new QQCustomMenuList();
    localQQCustomMenuList.a(2131441751, HardCodeUtil.a(2131895784));
    paramMenuClickListener = new QCirclePopupWindowHelper.4(this, paramMenuClickListener);
    BubblePopupWindow localBubblePopupWindow = this.d;
    localBubblePopupWindow.a(BubbleContextMenu.a(localBubblePopupWindow, paramView.getContext(), localQQCustomMenuList, paramMenuClickListener));
    this.d.a(paramOnDismissListener);
    this.d.a(new ColorDrawable(0));
    this.d.b(true);
    this.d.a(true);
    this.d.b(paramView);
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, QCirclePopupWindowHelper.MenuClickListener paramMenuClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.d = new BubblePopupWindow(-2, -2);
    QQCustomMenuList localQQCustomMenuList = new QQCustomMenuList();
    if (QCirclePluginUtil.d(paramStFeed.poster.id.get())) {
      if (paramStComment.typeFlag.get() == 0) {
        localQQCustomMenuList.a(2131441758, HardCodeUtil.a(2131895788));
      } else if (paramStComment.typeFlag.get() == 1) {
        localQQCustomMenuList.a(2131441750, HardCodeUtil.a(2131895783));
      }
    }
    localQQCustomMenuList.a(2131441751, HardCodeUtil.a(2131895784));
    if ((!QCirclePluginUtil.d(paramStFeed.poster.id.get())) && (!QCirclePluginUtil.b((FeedCloudMeta.StUser)paramStComment.postUser.get()))) {
      localQQCustomMenuList.a(2131441757, HardCodeUtil.a(2131895786));
    } else {
      localQQCustomMenuList.a(2131441752, HardCodeUtil.a(2131895785));
    }
    paramStFeed = new QCirclePopupWindowHelper.5(this, paramMenuClickListener);
    paramStComment = this.d;
    paramStComment.a(BubbleContextMenu.a(paramStComment, paramView.getContext(), localQQCustomMenuList, paramStFeed));
    this.d.a(paramOnDismissListener);
    this.d.a(new ColorDrawable(0));
    this.d.b(true);
    this.d.a(true);
    this.d.b(paramView);
  }
  
  public void a(View paramView, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StReply paramStReply, QCirclePopupWindowHelper.MenuClickListener paramMenuClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.d = new BubblePopupWindow(-2, -2);
    QQCustomMenuList localQQCustomMenuList = new QQCustomMenuList();
    localQQCustomMenuList.a(2131441751, HardCodeUtil.a(2131895784));
    if ((!QCirclePluginUtil.d(paramStFeed.poster.id.get())) && (!QCirclePluginUtil.b((FeedCloudMeta.StUser)paramStReply.postUser.get()))) {
      localQQCustomMenuList.a(2131441757, HardCodeUtil.a(2131895786));
    } else {
      localQQCustomMenuList.a(2131441752, HardCodeUtil.a(2131895785));
    }
    paramStFeed = new QCirclePopupWindowHelper.6(this, paramMenuClickListener);
    paramStReply = this.d;
    paramStReply.a(BubbleContextMenu.a(paramStReply, paramView.getContext(), localQQCustomMenuList, paramStFeed));
    this.d.a(paramOnDismissListener);
    this.d.a(new ColorDrawable(0));
    this.d.b(true);
    this.d.a(true);
    this.d.b(paramView);
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public void a(@NonNull View paramView, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.d = new BubblePopupWindow(-2, -2);
    QQCustomMenuList localQQCustomMenuList = new QQCustomMenuList();
    if (paramBoolean1) {
      i = 2131441756;
    } else {
      i = 2131441754;
    }
    Object localObject = HardCodeUtil.a(2131895789);
    if (paramBoolean1) {
      j = 2130848858;
    } else {
      j = 2130848857;
    }
    localQQCustomMenuList.a(a(i, (String)localObject, j, paramBoolean1));
    if (paramBoolean2) {
      i = 2131441755;
    } else {
      i = 2131441753;
    }
    localObject = HardCodeUtil.a(2131895782);
    if (paramBoolean2) {
      j = 2130848856;
    } else {
      j = 2130848855;
    }
    localQQCustomMenuList.a(a(i, (String)localObject, j, paramBoolean2));
    localObject = new QQCustomMenuLayout(paramView.getContext());
    ((QQCustomMenuLayout)localObject).setGravity(17);
    ((QQCustomMenuLayout)localObject).setPadding(0, 0, 0, 0);
    ((QQCustomMenuLayout)localObject).setPopupWindow(this.d);
    ((QQCustomMenuLayout)localObject).setMenuList(localQQCustomMenuList);
    ((QQCustomMenuLayout)localObject).setMenuIconClickListener(paramOnClickListener);
    paramOnClickListener = new QCircleMenuContainerStyle();
    ((QQCustomMenuLayout)localObject).setMenuContainerStyle(paramOnClickListener);
    ((QQCustomMenuLayout)localObject).a();
    this.d.a((View)localObject);
    this.d.a(paramOnDismissListener);
    this.d.a(new ColorDrawable(0));
    this.d.b(true);
    this.d.a(true);
    this.d.a(new QCircleBubblePopupWindowStyle());
    int i = -ViewUtils.a(18.0F);
    int j = paramOnClickListener.b() / 2;
    this.d.a(paramView, i - j, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(Context paramContext, View paramView, String paramString)
  {
    if (paramContext != null)
    {
      if (paramView == null) {
        return false;
      }
      try
      {
        c();
        paramContext = new QCirclePushTipView(paramContext);
        paramContext.setText(paramString);
        paramContext.measure(0, 0);
        int i = paramContext.getMeasuredWidth();
        int j = paramContext.getMeasuredHeight();
        this.c = new PopupWindow(paramContext, -2, -2);
        this.c.setOutsideTouchable(true);
        this.c.setTouchable(true);
        paramContext = new int[2];
        paramView.getLocationOnScreen(paramContext);
        paramString = new StringBuilder();
        paramString.append("popupWidth");
        paramString.append(i);
        paramString.append(" popupHeight");
        paramString.append(j);
        QLog.i("QCirclePopupWindowHelper", 1, paramString.toString());
        paramString = new StringBuilder();
        paramString.append("location x:");
        paramString.append(paramContext[0]);
        paramString.append("    loacation y:");
        paramString.append(paramContext[1]);
        QLog.i("QCirclePopupWindowHelper", 1, paramString.toString());
        int k = paramView.getWidth() / 2;
        this.c.showAtLocation(paramView, 8388661, ViewUtils.a(10.0F), paramContext[1] - j);
        paramString = new StringBuilder();
        paramString.append("x:");
        paramString.append(paramContext[0] + paramView.getWidth() / 2 - i / 2);
        paramString.append("    y:");
        paramString.append(paramContext[1] - j);
        QLog.i("QCirclePopupWindowHelper", 1, paramString.toString());
        this.e = new QCirclePopupWindowHelper.3(this, 3000L, 3000L);
        this.e.start();
        return true;
      }
      catch (Exception paramContext)
      {
        paramView = new StringBuilder();
        paramView.append("showRecommendAnimation error");
        paramView.append(paramContext.getMessage());
        QLog.e("QCirclePopupWindowHelper", 1, paramView.toString());
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    QLog.d("QCirclePopupWindowHelper", 1, "release");
    Object localObject = this.e;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      this.e = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((PopupWindow)localObject).dismiss();
      this.c = null;
    }
    if (this.d != null) {
      this.d = null;
    }
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePopupWindowHelper
 * JD-Core Version:    0.7.0.1
 */