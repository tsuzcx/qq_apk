package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TipsManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kcz;
import kda;

public class VideoNetStateBar
{
  public int a;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  View jdField_a_of_type_AndroidViewView = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new kcz(this);
  public VideoAppInterface a;
  public Runnable a;
  String jdField_a_of_type_JavaLangString = null;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  String jdField_b_of_type_JavaLangString = null;
  WeakReference jdField_b_of_type_JavaLangRefWeakReference = null;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  WeakReference jdField_c_of_type_JavaLangRefWeakReference = null;
  boolean jdField_c_of_type_Boolean = false;
  boolean d;
  public boolean e = false;
  private boolean f;
  
  public VideoNetStateBar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "VideoNetStateBar");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramViewGroup);
    this.jdField_a_of_type_AndroidContentResResources = paramAVActivity.getResources();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onCreate");
    }
    l();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    b();
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        if (localSessionInfo.t)
        {
          localSessionInfo.t = false;
          if ((localSessionInfo.jdField_d_of_type_Int == 1) || (localSessionInfo.jdField_d_of_type_Int == 2) || (localSessionInfo.jdField_d_of_type_Int == 3) || (localSessionInfo.jdField_d_of_type_Int == 4))
          {
            this.jdField_b_of_type_Int = localSessionInfo.q;
            this.jdField_a_of_type_Int = localSessionInfo.r;
          }
        }
        this.jdField_b_of_type_Boolean = localSessionInfo.jdField_c_of_type_Boolean;
        this.jdField_c_of_type_Boolean = localSessionInfo.jdField_d_of_type_Boolean;
      }
    }
    m();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int j = 3;
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("VideoNetStateBar", 4, String.format("setNetLevel, emNetLevel[%s], selfNetLevel[%s], peerNetLevel[%s], strDetail[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    }
    if (paramInt2 == paramInt3) {
      paramInt2 = j;
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_Int == paramInt1) && (paramInt2 == this.jdField_a_of_type_Int))
      {
        paramInt3 = i;
        if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)) {}
      }
      else
      {
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_a_of_type_Int = paramInt2;
        this.jdField_a_of_type_JavaLangString = paramString;
        paramInt3 = 1;
      }
      if (paramInt3 != 0) {
        m();
      }
      return;
      if (paramInt2 > 0) {
        paramInt2 = 1;
      } else if (paramInt3 > 0) {
        paramInt2 = 2;
      } else {
        paramInt2 = 0;
      }
    }
  }
  
  public void a(TipsManager paramTipsManager)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramTipsManager);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      m();
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      bool1 = bool2;
      if (localSessionInfo != null)
      {
        if ((!this.jdField_c_of_type_Boolean) || ((localSessionInfo.jdField_d_of_type_Int != 1) && (localSessionInfo.jdField_d_of_type_Int != 2))) {
          break label76;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
        bool1 = true;
      }
    }
    label76:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.jdField_b_of_type_Boolean);
      if (localSessionInfo.jdField_d_of_type_Int == 3) {
        break;
      }
      bool1 = bool2;
    } while (localSessionInfo.jdField_d_of_type_Int != 4);
    ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
    return true;
  }
  
  void b()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365344));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365356));
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365349);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365350));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365351));
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      a();
    }
    m();
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        localSessionInfo.r = this.jdField_a_of_type_Int;
        localSessionInfo.q = this.jdField_b_of_type_Int;
        localSessionInfo.t = true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    }
    l();
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidContentResResources = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
    this.jdField_c_of_type_JavaLangRefWeakReference = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    do
    {
      return;
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    } while (localMarginLayoutParams == null);
    localMarginLayoutParams.topMargin = paramInt;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    m();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onStart");
    }
  }
  
  public void d(int paramInt)
  {
    if (!this.f) {
      break label7;
    }
    label7:
    label32:
    View localView;
    ViewGroup.LayoutParams localLayoutParams;
    label175:
    label177:
    label195:
    for (;;)
    {
      return;
      if ((paramInt != this.jdField_c_of_type_Int) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        Context localContext;
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
        {
          localContext = null;
          if (localContext == null) {
            break label175;
          }
          if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
            break label177;
          }
        }
        for (localView = null;; localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365911))
        {
          if (localView == null) {
            break label195;
          }
          localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          if (localLayoutParams == null) {
            break;
          }
          this.jdField_c_of_type_Int = paramInt;
          if ((this.jdField_c_of_type_Int != 90) && (this.jdField_c_of_type_Int != 270)) {
            break label212;
          }
          paramInt = localContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(15.0F, localContext.getResources());
          localLayoutParams.width = paramInt;
          localLayoutParams.height = paramInt;
          this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidViewView.setRotation(90.0F);
          if (this.jdField_c_of_type_Int != 270) {
            break label197;
          }
          localView.setScaleY(1.0F);
          localView.setScaleX(1.0F);
          return;
          localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          break label32;
          break label7;
        }
      }
    }
    label197:
    localView.setScaleY(-1.0F);
    localView.setScaleX(-1.0F);
    return;
    label212:
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setRotation(0.0F);
    if (this.jdField_c_of_type_Int == 0)
    {
      localView.setScaleY(1.0F);
      localView.setScaleX(1.0F);
      return;
    }
    localView.setScaleY(-1.0F);
    localView.setScaleX(-1.0F);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    m();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onResume");
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      View localView;
      if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)
      {
        localView = null;
        if (localView == null) {
          break label48;
        }
      }
      label48:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.f = paramBoolean;
        return;
        localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365911);
        break;
      }
    }
    this.f = false;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onPause");
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onStop");
    }
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDoubleConnected");
    }
    this.jdField_b_of_type_Int = 3;
    m();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onMultiConnected");
    }
    this.jdField_b_of_type_Int = 3;
    m();
    j();
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((localSessionInfo != null) && ((localSessionInfo.jdField_d_of_type_Int == 3) || (localSessionInfo.jdField_d_of_type_Int == 4))) {
        k();
      }
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new kda(this);
      }
    } while ((this.jdField_a_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.e = false;
  }
  
  void m()
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null)) {}
    label21:
    label452:
    label612:
    do
    {
      do
      {
        int i;
        do
        {
          break label21;
          do
          {
            return;
          } while (this.jdField_a_of_type_AndroidContentResResources == null);
          i = this.jdField_b_of_type_Int;
        } while (i == 0);
        int j = this.jdField_a_of_type_Int;
        String str;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          str = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (!this.jdField_d_of_type_Boolean) {
            break label452;
          }
          str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429430);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840285);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840285);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840286);
          this.jdField_b_of_type_JavaLangString = null;
          if ((!this.jdField_d_of_type_Boolean) && (i != 1)) {
            break label612;
          }
          TipsManager.a(101, str);
          if ((this.jdField_c_of_type_JavaLangRefWeakReference != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_b_of_type_JavaLangString == null) || (!this.jdField_b_of_type_JavaLangString.equals(str))))
          {
            this.jdField_b_of_type_JavaLangString = str;
            if ((((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a.getVisibility() != 0) || (((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).jdField_b_of_type_Int == 101)) {
              ((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a(101, str, false);
            }
          }
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label670;
          }
          if ((!this.jdField_d_of_type_Boolean) && (i != 1)) {
            break label653;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
          n();
          return;
          switch (i)
          {
          default: 
            if (j == 2) {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429427);
            }
            break;
          case 1: 
            if (j == 2)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429429);
              break;
            }
            if (j == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429426);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429423);
            break;
          case 2: 
            if (j == 2)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429428);
              break;
            }
            if (j == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429425);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429422);
            break;
            if (j == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429424);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131429421);
            break;
            switch (i)
            {
            default: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840281);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840281);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840282);
              break;
            case 1: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840279);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840279);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840280);
              break;
            case 2: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840283);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840283);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840284);
              break;
            case 3: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840281);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840281);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840282);
              break;
              if ((this.jdField_c_of_type_JavaLangRefWeakReference != null) && (this.jdField_c_of_type_JavaLangRefWeakReference.get() != null))
              {
                TipsManager.c(101);
                ((TipsManager)this.jdField_c_of_type_JavaLangRefWeakReference.get()).a(101);
              }
              break;
            }
            break;
          }
        }
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    label653:
    label670:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void n()
  {
    SessionInfo localSessionInfo;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (localSessionInfo != null)
      {
        if ((!localSessionInfo.G) && (localSessionInfo.jdField_d_of_type_Int != 1) && (localSessionInfo.jdField_d_of_type_Int != 2)) {
          break label69;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
      }
    }
    label69:
    while ((localSessionInfo.jdField_d_of_type_Int != 3) && (localSessionInfo.jdField_d_of_type_Int != 4)) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar
 * JD-Core Version:    0.7.0.1
 */