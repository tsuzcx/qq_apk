package com.tencent.av.ui.redbag;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import khm;
import khn;

public class OtherBtnController
  extends SubHandleBase
{
  public int a;
  public ControlUIObserver a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  
  OtherBtnController(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = null;
    this.jdField_a_of_type_Int = 2130840147;
  }
  
  static void a(AVActivity paramAVActivity, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = paramAVActivity.a;
      if (localObject != null)
      {
        localObject = ((VideoControlUI)localObject).a(QavPanel.e, paramInt1, bool);
        if (localObject == null) {
          break;
        }
        if ((paramInt2 != 0) && ((localObject instanceof TextView)))
        {
          AudioHelper.a(paramAVActivity.getResources(), (TextView)localObject, paramBoolean, paramInt2);
          ((View)localObject).invalidate();
        }
      }
      return;
    }
    QLog.w("OtherBtnController", 1, "setBtnStyle, viewType[" + paramInt1 + "], 为空");
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    QLog.w(this.i, 1, "setBtnsStyle, lightStyle[" + paramBoolean + "], avActivity[" + localAVActivity + "]");
    if (localAVActivity == null) {
      return;
    }
    a(localAVActivity, 2131365408, paramBoolean, this.jdField_a_of_type_Int);
    a(localAVActivity, 2131365396, paramBoolean, 2130840140);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(); localAVActivity == null; localAVActivity = null) {
      return false;
    }
    if (localAVActivity == a()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    boolean bool;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvUiControlUIObserver == null) {
        this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new khm(this);
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_JavaLangRunnable = null;
      }
      bool = a();
      QLog.w(this.i, 1, "hook, mHook[" + bool + "]");
      if (!bool) {
        this.jdField_a_of_type_Int = 2130840147;
      }
      a(false);
    } while (bool);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(a());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
  }
  
  void c()
  {
    if (a() == null) {}
    while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new khn(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.redbag.OtherBtnController
 * JD-Core Version:    0.7.0.1
 */