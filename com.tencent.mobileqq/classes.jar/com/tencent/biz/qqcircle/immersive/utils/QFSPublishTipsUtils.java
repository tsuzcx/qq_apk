package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

public class QFSPublishTipsUtils
{
  private static final int a = ViewUtils.a(160.0F);
  private static final int b = ViewUtils.a(42.0F);
  private static final int c = ViewUtils.a(8.0F);
  private static final int d = ViewUtils.a(8.0F);
  private PopupWindow e;
  private QFSPublishTipsUtils.PublishTipRunnableImpl f;
  private QFSPublishTipsUtils.PublishTipDismissRunnableImpl g;
  
  private void a()
  {
    if (this.f != null) {
      RFThreadManager.getUIHandler().removeCallbacks(this.f);
    }
    if (this.g != null) {
      RFThreadManager.getUIHandler().removeCallbacks(this.g);
    }
  }
  
  private void b(Context paramContext)
  {
    PopupWindow localPopupWindow = this.e;
    if (localPopupWindow == null)
    {
      QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleDismiss] publish tip pop should not be null.");
      return;
    }
    if (!localPopupWindow.isShowing())
    {
      QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleDismiss] publish tip pop not is showing state.");
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handleDismiss] context should not is activity...");
      return;
    }
    paramContext = (Activity)paramContext;
    if ((paramContext != null) && (!paramContext.isFinishing())) {
      this.e.dismiss();
    }
  }
  
  private void b(View paramView)
  {
    if (paramView == null)
    {
      QLog.d("QCBT-QFSPublishTipsUtils", 1, "[handlePublishGuide] anchor view should not be null.");
      return;
    }
    Object localObject = paramView.getContext();
    int j = b;
    int i = a;
    if (this.e == null)
    {
      localObject = LayoutInflater.from((Context)localObject).inflate(2131627165, null);
      this.e = new PopupWindow((View)localObject, i, j);
      this.e.setOutsideTouchable(false);
      ((View)localObject).setOnClickListener(new QFSPublishTipsUtils.1(this));
    }
    j = paramView.getWidth();
    int k = paramView.getHeight();
    localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int m = localObject[0];
    int n = localObject[1];
    int i1 = c;
    this.e.showAtLocation(paramView, 0, m - i + j, n + k + i1);
    this.g = new QFSPublishTipsUtils.PublishTipDismissRunnableImpl(this, paramView);
    RFThreadManager.getUIHandler().postDelayed(this.g, 3000L);
  }
  
  public void a(Context paramContext)
  {
    if (this.f != null) {
      RFThreadManager.getUIHandler().removeCallbacks(this.f);
    }
    b(paramContext);
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      QLog.d("QCBT-QFSPublishTipsUtils", 1, "[showPublishGuideTips] anchor view should not be null.");
      return;
    }
    a();
    this.f = new QFSPublishTipsUtils.PublishTipRunnableImpl(this, paramView);
    RFThreadManager.getUIHandler().postDelayed(this.f, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.utils.QFSPublishTipsUtils
 * JD-Core Version:    0.7.0.1
 */