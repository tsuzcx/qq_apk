package com.tencent.av.smallscreen;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.wtogether.SmallScreenDavWTObserver;
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695865);
    }
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i == 5)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ac)
      {
        s();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.f())
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().ac)
      {
        s();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j())
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (j > 18)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().ac) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ad))
      {
        s();
        return;
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ac)
    {
      s();
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<<setInvitingState(), resId =");
      localStringBuilder.append(paramInt);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController.a().k == 1011) && (paramInt != 2131695865) && (paramInt != 2131720213)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramInt > 0)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteReached remotePhoneState = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Int);
      localStringBuilder.append(" # remoteTerminal = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().n);
      localStringBuilder.append(" # phoneOnLine = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().p);
      localStringBuilder.append(" # pcOnLine = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().o);
      localStringBuilder.append(" # subState = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long);
      localStringBuilder.append(" # isPeerNetworkWell = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Boolean);
      QLog.d("SmallScreenDoubleVideoControlUI", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (!this.jdField_a_of_type_ComTencentAvVideoController.a().Y))
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().k == 1011) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString.contains(paramString1)) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Int >= 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        if (TextUtils.isEmpty(paramString2))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695981);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onPeerSwitchTerminal, bStartSwitch : ");
      paramString.append(paramBoolean);
      QLog.d("SmallScreenDoubleVideoControlUI", 2, paramString.toString());
    }
    paramString = DoodleLogic.a();
    if (paramBoolean)
    {
      paramString.b = false;
      paramString.jdField_e_of_type_Int = 0;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WL_DEBUG onPeerSwitchTerminal mPeerVersion = ");
        localStringBuilder.append(paramString.jdField_e_of_type_Int);
        localStringBuilder.append(", mIsPeerSupport = ");
        localStringBuilder.append(paramString.b);
        QLog.e("SmallScreenDoubleVideoControlUI", 2, localStringBuilder.toString());
      }
      SmallScreenUtils.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.c();
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver == null)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver = new SmallScreenDavWTObserver(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.addObserver(this.jdField_a_of_type_ComTencentAvWtogetherSmallScreenDavWTObserver);
    }
    if (localSessionInfo.i())
    {
      if (localSessionInfo.H) {
        i = 2131695503;
      } else {
        i = 2131720285;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
      return;
    }
    paramBoolean = localSessionInfo.f();
    int i = 2131695981;
    int j;
    if (paramBoolean)
    {
      paramBoolean = localSessionInfo.Y;
      j = 2131695865;
      if (paramBoolean) {
        i = 2131695865;
      }
      if (localSessionInfo.k == 1011) {
        i = j;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i);
      return;
    }
    if (localSessionInfo.h())
    {
      if ((localSessionInfo.d == 0) && (localSessionInfo.jdField_e_of_type_Boolean))
      {
        j = i;
        if (localSessionInfo.jdField_e_of_type_Int == 1) {
          break label193;
        }
        if (localSessionInfo.jdField_e_of_type_Int == 2)
        {
          j = i;
          break label193;
        }
      }
      j = 2131695697;
      label193:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(j);
      return;
    }
    if ((localSessionInfo.m()) || (localSessionInfo.n()))
    {
      if (localSessionInfo.k == 1011) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695879);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenDoubleVideoControlUI.1(this, l), 150L);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
      if (paramBoolean2)
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
          this.jdField_a_of_type_ComTencentAvVideoController.a(true, str);
        }
      }
      else if (!this.jdField_a_of_type_ComTencentAvVideoController.a().g) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(false, str);
      }
    }
  }
  
  public void b()
  {
    super.b();
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>>onStart(), ts=");
      localStringBuilder.append(l1);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().f()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_q_of_type_Int >= 0) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().k == 1011) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695865);
      } else {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131695981);
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<<onStart(), ts=");
      localStringBuilder.append(l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNotRecvAudioData bNotRecv = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("SmallScreenDoubleVideoControlUI", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
      s();
    }
  }
  
  public void c()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if (i != 5)
    {
      if (i == 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.f())
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
          return;
        }
        if ((j > 18) && (this.jdField_a_of_type_ComTencentAvVideoController.a().ac))
        {
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          s();
        }
      }
    }
  }
  
  public void d()
  {
    String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentAvVideoController.b(str);
    int j = this.jdField_a_of_type_ComTencentAvVideoController.c(str);
    if ((i != 5) && (i != 0))
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.f())
      {
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
          s();
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
          return;
        }
        if (j > 18)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().ad)
          {
            if (this.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
            }
            if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
              s();
            }
          }
        }
        else
        {
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          }
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
            s();
          }
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L) {
        s();
      }
    }
  }
  
  public void e()
  {
    super.e();
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>>onResume(), ts=");
      localStringBuilder.append(System.currentTimeMillis());
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a().j()) && (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long != 1L)) {
      s();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<<onResume(), ts=");
      localStringBuilder.append(l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, localStringBuilder.toString());
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI
 * JD-Core Version:    0.7.0.1
 */