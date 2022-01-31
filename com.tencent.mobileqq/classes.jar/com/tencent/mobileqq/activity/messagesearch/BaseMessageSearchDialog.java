package com.tencent.mobileqq.activity.messagesearch;

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
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView;

public class BaseMessageSearchDialog
  extends Dialog
  implements Handler.Callback
{
  public int a;
  public Context a;
  public EditText a;
  public SessionInfo a;
  public MessageItem a;
  public QQAppInterface a;
  public MessageRecord a;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected MqqWeakReferenceHandler a;
  public BubblePopupWindow a;
  public XListView a;
  boolean jdField_a_of_type_Boolean = false;
  
  public BaseMessageSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130969069);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public MessageRecord a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  protected void a() {}
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
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
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog
 * JD-Core Version:    0.7.0.1
 */