package com.tencent.av.smallscreen;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.wtogether.SmallScreenDavWTObserver;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenDoubleVideoControlUI
  extends SmallScreenVideoControlUI
{
  SmallScreenDavWTObserver jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new SmallScreenDoubleVideoControlUI.2(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public SmallScreenDoubleVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695851);
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i == 5)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao)
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.e())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao)
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().l())
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (j > 18)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ao) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ap))
      {
        t();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao)
    {
      t();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<setInvitingState(), resId =" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j == 1011) && (paramInt != 2131695851) && (paramInt != 2131720501) && (!this.jdField_a_of_type_ComTencentAvVideoController.f)) {}
    while ((this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt <= 0)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.removeObserver(this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver);
      this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver = null;
    }
    super.a(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onInviteReached remotePhoneState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().o + " # remoteTerminal = " + this.jdField_a_of_type_ComTencentAvVideoController.a().l + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().n + " # pcOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().m + " # subState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long + " # isPeerNetworkWell = " + this.jdField_a_of_type_ComTencentAvVideoController.a().r);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().h()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ak) || (this.jdField_a_of_type_ComTencentAvVideoController.a().j == 1011)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString.contains(paramString1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().o < 0) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695966);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onPeerSwitchTerminal, bStartSwitch : " + paramBoolean);
    }
    paramString = DoodleLogic.a();
    if (paramBoolean)
    {
      paramString.b = false;
      paramString.e = 0;
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenDoubleVideoControlUI", 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.e + ", mIsPeerSupport = " + paramString.b);
      }
      SmallScreenUtils.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 2131695966;
    int j = 2131695851;
    super.a(paramBoolean);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver = new SmallScreenDavWTObserver(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver);
    }
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenDoubleVideoControlUI", 1, "onCreate, matchStatus[" + localSessionInfo.a.b + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695850);
    }
    do
    {
      return;
      if ((localSessionInfo.a.b > 0) && (localSessionInfo.a.b != 5))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695860);
        return;
      }
    } while (localSessionInfo.l());
    if (localSessionInfo.k())
    {
      if (localSessionInfo.S) {}
      for (i = 2131695492;; i = 2131720570)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
        return;
      }
    }
    if (localSessionInfo.h())
    {
      if (localSessionInfo.ak) {
        i = 2131695851;
      }
      if (localSessionInfo.j != 1011) {
        break label374;
      }
      i = j;
    }
    label305:
    label374:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
      return;
      if (localSessionInfo.j())
      {
        if ((localSessionInfo.jdField_d_of_type_Int == 0) && (localSessionInfo.e))
        {
          j = i;
          if (localSessionInfo.f != 1) {
            if (localSessionInfo.f != 2) {
              break label305;
            }
          }
        }
        for (j = i;; j = 2131695683)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(j);
          return;
        }
      }
      if ((!localSessionInfo.o()) && (!localSessionInfo.p())) {
        break;
      }
      if (localSessionInfo.j == 1011) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695867);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenDoubleVideoControlUI.1(this, l), 150L);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if ((!paramBoolean1) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
      if (!paramBoolean2) {
        break label50;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
      }
    }
    label50:
    while (this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
  }
  
  public void b()
  {
    super.b();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onStart(), ts=" + l1);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().h()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().o >= 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j != 1011) {
        break label167;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695851);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onStart(), ts=" + l2);
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      return;
      label167:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695966);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    t();
  }
  
  public void c()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.e()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().l()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    t();
  }
  
  public void d()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L) {
        t();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_ComTencentAvVideoController.e()) {
                break;
              }
              if (this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
            t();
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().l());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().ap);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
      t();
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long == 1L);
    t();
  }
  
  public void e()
  {
    super.e();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onResume(), ts=" + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().l()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Long != 1L)) {
      t();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onResume(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI
 * JD-Core Version:    0.7.0.1
 */