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
import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;
import joc;
import jod;

public class SmallScreenDoubleVideoControlUI
  extends SmallScreenVideoControlUI
{
  Runnable jdField_a_of_type_JavaLangRunnable = new jod(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public SmallScreenDoubleVideoControlUI(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, ControlUIObserver paramControlUIObserver)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramControlUIObserver);
  }
  
  public void a()
  {
    super.a();
    if (this.b != null) {
      this.b.setText(2131429403);
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i == 5)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao)
      {
        v();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao)
      {
        v();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().f())
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (j > 18)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ao) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ap))
      {
        v();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao)
    {
      v();
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
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011) && (paramInt != 2131429403) && (paramInt != 2131428688) && (!this.jdField_a_of_type_ComTencentAvVideoController.f)) {}
    while ((this.b == null) || (paramInt <= 0)) {
      return;
    }
    this.b.setText(paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onInviteReached remotePhoneState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().n + " # remoteTerminal = " + this.jdField_a_of_type_ComTencentAvVideoController.a().k + " # phoneOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Int + " # pcOnLine = " + this.jdField_a_of_type_ComTencentAvVideoController.a().l + " # subState = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long + " # isPeerNetworkWell = " + this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_m_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().c()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().ak) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i == 1011)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString.contains(paramString1)) || (this.jdField_a_of_type_ComTencentAvVideoController.a().n < 0) || (this.b == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.b.setText(2131429411);
      return;
    }
    this.b.setText(paramString2);
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
    paramString.b();
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 2131429403;
    super.a(paramBoolean);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "matchStatus = " + localSessionInfo.a.b);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
      this.b.setText(2131429425);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((localSessionInfo.a.b > 0) && (localSessionInfo.a.b != 5))
            {
              this.b.setText(2131429422);
              return;
            }
            if (!localSessionInfo.f()) {
              break label250;
            }
            if (!this.jdField_a_of_type_ComTencentAvVideoController.g()) {
              break;
            }
          } while ((!localSessionInfo.d) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
          if (localSessionInfo.R)
          {
            this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, true);
            return;
          }
          this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
          return;
        } while (this.jdField_a_of_type_ComTencentAvVideoController.a() < 2L);
        if (!localSessionInfo.d) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
      this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
      return;
    } while ((this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString) != 5) || (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null));
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(29, true);
    return;
    label250:
    int i;
    if (localSessionInfo.e())
    {
      if (localSessionInfo.Q) {}
      for (i = 2131428977;; i = 2131428834)
      {
        this.b.setText(i);
        return;
      }
    }
    if (localSessionInfo.c())
    {
      i = 2131429415;
      if (localSessionInfo.ak) {
        i = 2131429403;
      }
      if (localSessionInfo.i != 1011) {
        break label410;
      }
      i = j;
    }
    label410:
    for (;;)
    {
      this.b.setText(i);
      return;
      if (localSessionInfo.d())
      {
        this.b.setText(2131429020);
        return;
      }
      if ((!localSessionInfo.g()) && (!localSessionInfo.h())) {
        break;
      }
      if (localSessionInfo.i == 1011) {
        this.b.setText(2131429418);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new joc(this), 150L);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onPhoneCalling isSelf = " + paramBoolean1 + " # isCalling = " + paramBoolean2);
    }
    String str;
    if ((!paramBoolean1) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (!paramBoolean2) {
        break label115;
      }
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
      }
      if (this.jdField_a_of_type_ComTencentAvUtilsTipsManager != null) {
        this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, true);
      }
    }
    label115:
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      }
    } while (this.jdField_a_of_type_ComTencentAvUtilsTipsManager == null);
    this.jdField_a_of_type_ComTencentAvUtilsTipsManager.b(39, false);
  }
  
  public void b()
  {
    super.b();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onStart(), ts=" + l1);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().c()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().n >= 0) && (this.b != null))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().i != 1011) {
        break label167;
      }
      this.b.setText(2131429403);
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
      this.b.setText(2131429411);
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
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
    v();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.c();
  }
  
  public void d()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.jdField_a_of_type_ComTencentAvVideoController.b()) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (j <= 18) || (!this.jdField_a_of_type_ComTencentAvVideoController.a().ao)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    v();
  }
  
  public void e()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i == 5) || (i == 0))
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
        v();
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
              if (this.jdField_a_of_type_ComTencentAvVideoController.b()) {
                break;
              }
              if (this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
              }
            } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
            v();
            return;
          } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().f());
          if (j <= 18) {
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentAvVideoController.a().ap);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
      v();
      return;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    } while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long == 1L);
    v();
  }
  
  public void f()
  {
    super.f();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onResume(), ts=" + System.currentTimeMillis());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L)) {
      v();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onResume(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI
 * JD-Core Version:    0.7.0.1
 */