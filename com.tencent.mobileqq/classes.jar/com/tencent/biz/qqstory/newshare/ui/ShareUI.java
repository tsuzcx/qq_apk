package com.tencent.biz.qqstory.newshare.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class ShareUI
{
  private static Long h = Long.valueOf(0L);
  public QQProgressDialog a;
  public String b;
  public boolean c = true;
  public List<int[]> d;
  public WeakReference<Activity> e;
  public boolean f = true;
  private OnShareUIListener g;
  
  public ShareUI(Activity paramActivity)
  {
    this.e = new WeakReference(paramActivity);
  }
  
  public static boolean h()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - h.longValue();
    if ((l2 > 0L) && (l2 < 800L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("time:");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mLastClickTIme:");
        localStringBuilder.append(h);
        localStringBuilder.append(", timeDiff:");
        localStringBuilder.append(l2);
        QLog.i("isFastDoubleClick", 2, localStringBuilder.toString());
      }
      return true;
    }
    h = Long.valueOf(l1);
    return false;
  }
  
  protected abstract void a();
  
  public void a(OnShareUIListener paramOnShareUIListener)
  {
    this.g = paramOnShareUIListener;
  }
  
  public abstract int b(int paramInt);
  
  public void b()
  {
    if (!this.f) {
      return;
    }
    if (this.a == null)
    {
      Activity localActivity = g();
      if (localActivity == null) {
        return;
      }
      int i = localActivity.getResources().getDimensionPixelSize(2131299920);
      this.a = new QQProgressDialog(localActivity);
      this.a.a(HardCodeUtil.a(2131911388));
      this.a.b(i);
    }
    if (!this.a.isShowing()) {
      this.a.show();
    }
  }
  
  public void c()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  protected void c(int paramInt)
  {
    if (h()) {
      return;
    }
    b();
    this.g.b(b(paramInt));
  }
  
  public void d()
  {
    a();
    OnShareUIListener localOnShareUIListener = this.g;
    if (localOnShareUIListener != null) {
      localOnShareUIListener.c();
    }
  }
  
  protected void e()
  {
    OnShareUIListener localOnShareUIListener = this.g;
    if (localOnShareUIListener != null) {
      localOnShareUIListener.d();
    }
  }
  
  protected void f()
  {
    OnShareUIListener localOnShareUIListener = this.g;
    if (localOnShareUIListener != null) {
      localOnShareUIListener.e();
    }
  }
  
  public Activity g()
  {
    return (Activity)this.e.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ShareUI
 * JD-Core Version:    0.7.0.1
 */