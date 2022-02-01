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
  protected int a;
  protected Context a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  MessageItem jdField_a_of_type_ComTencentMobileqqActivityMessagesearchMessageItem;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected MessageRecord a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected MqqWeakReferenceHandler a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public XListView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseMessageSearchDialog.2(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public BaseMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, 16973834);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(2);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2131559332);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    e();
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (((localObject instanceof Activity)) && (((Context)localObject).getResources().getConfiguration().orientation == 1))
    {
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      View localView = findViewById(2131370406);
      if (LiuHaiUtils.c((Activity)localObject))
      {
        localView.post(new BaseMessageSearchDialog.1(this, localView, (Activity)localObject));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseMessageSearchDialog", 2, "has no Notch, setPaddingTop 0");
      }
      localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void a() {}
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localContext, localContext.getResources().getDimensionPixelSize(2131299168));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  protected void c()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1, 0L);
    }
  }
  
  protected void d()
  {
    if (isShowing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
  }
  
  public void dismiss()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    super.dismiss();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */