package com.tencent.biz.qqstory.newshare.ui;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class ShareUI
{
  private static Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private OnShareUIListener jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener;
  public QQProgressDialog a;
  public String a;
  public WeakReference a;
  public List a;
  public boolean a;
  
  public ShareUI(Activity paramActivity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - jdField_a_of_type_JavaLangLong.longValue();
    if ((l2 > 0L) && (l2 < 800L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("isFastDoubleClick", 2, "time:" + l1 + ", mLastClickTIme:" + jdField_a_of_type_JavaLangLong + ", timeDiff:" + l2);
      }
      return true;
    }
    jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
    return false;
  }
  
  public Activity a()
  {
    return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    if (a()) {
      return;
    }
    b();
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener.a(b(paramInt));
  }
  
  public void a(OnShareUIListener paramOnShareUIListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener = paramOnShareUIListener;
  }
  
  public abstract int b(int paramInt);
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      Activity localActivity;
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
          break;
        }
        localActivity = a();
      } while (localActivity == null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void d()
  {
    a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener.a();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener.b();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ShareUI
 * JD-Core Version:    0.7.0.1
 */