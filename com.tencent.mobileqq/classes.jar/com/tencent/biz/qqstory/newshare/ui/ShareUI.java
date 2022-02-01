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
  private static Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private OnShareUIListener jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener;
  public QQProgressDialog a;
  public String a;
  public WeakReference<Activity> a;
  public List<int[]> a;
  public boolean a;
  public boolean b = true;
  
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("time:");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mLastClickTIme:");
        localStringBuilder.append(jdField_a_of_type_JavaLangLong);
        localStringBuilder.append(", timeDiff:");
        localStringBuilder.append(l2);
        QLog.i("isFastDoubleClick", 2, localStringBuilder.toString());
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
  
  protected void a(int paramInt)
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
    if (!this.b) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Activity localActivity = a();
      if (localActivity == null) {
        return;
      }
      int i = localActivity.getResources().getDimensionPixelSize(2131299168);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131713848));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(i);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void c()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void d()
  {
    a();
    OnShareUIListener localOnShareUIListener = this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener;
    if (localOnShareUIListener != null) {
      localOnShareUIListener.a();
    }
  }
  
  protected void e()
  {
    OnShareUIListener localOnShareUIListener = this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener;
    if (localOnShareUIListener != null) {
      localOnShareUIListener.b();
    }
  }
  
  protected void f()
  {
    OnShareUIListener localOnShareUIListener = this.jdField_a_of_type_ComTencentBizQqstoryNewshareUiOnShareUIListener;
    if (localOnShareUIListener != null) {
      localOnShareUIListener.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.ui.ShareUI
 * JD-Core Version:    0.7.0.1
 */