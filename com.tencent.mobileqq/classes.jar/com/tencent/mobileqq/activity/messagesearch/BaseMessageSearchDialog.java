package com.tencent.mobileqq.activity.messagesearch;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class BaseMessageSearchDialog
  extends ReportDialog
  implements Handler.Callback
{
  protected MqqWeakReferenceHandler a;
  public XListView b;
  protected Context c;
  EditText d;
  boolean e = false;
  QQAppInterface f;
  SessionInfo g;
  QQProgressDialog h;
  BubblePopupWindow i;
  MessageItem j;
  protected int k = 0;
  protected MessageRecord l = null;
  private Runnable m = new BaseMessageSearchDialog.2(this);
  
  public BaseMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, 16973834);
    this.c = paramContext;
    this.f = paramQQAppInterface;
    this.g = paramSessionInfo;
    this.a = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(2);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2131625298);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    g();
  }
  
  private void g()
  {
    Object localObject = this.c;
    if (((localObject instanceof Activity)) && (((Context)localObject).getResources().getConfiguration().orientation == 1))
    {
      localObject = (Activity)this.c;
      View localView = findViewById(2131437674);
      if (LiuHaiUtils.c((Activity)localObject))
      {
        localView.post(new BaseMessageSearchDialog.1(this, localView, (Activity)localObject));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseMessageSearchDialog", 2, "has no Notch, setPaddingTop 0");
      }
      localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
      ThreadManager.getUIHandler().postDelayed(this.m, 500L);
    }
  }
  
  protected void a() {}
  
  protected void a(int paramInt)
  {
    if (this.h == null)
    {
      Context localContext = this.c;
      this.h = new QQProgressDialog(localContext, localContext.getResources().getDimensionPixelSize(2131299920));
    }
    this.h.setCancelable(false);
    this.h.setCanceledOnTouchOutside(false);
    this.h.c(paramInt);
    this.h.show();
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected void b()
  {
    QQProgressDialog localQQProgressDialog = this.h;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.h.dismiss();
    }
  }
  
  public int c()
  {
    return this.k;
  }
  
  protected void d()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.a.sendEmptyMessageDelayed(1, 0L);
    }
  }
  
  public void dismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.m);
    super.dismiss();
  }
  
  protected void e()
  {
    if (isShowing())
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.d.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l1, l1, 1, 0.0F, 0.0F, 0);
      this.d.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */