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
import android.widget.TextView;
import azqs;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lhe;
import lid;
import mdd;
import moc;

public class VideoNetStateBar
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  View jdField_a_of_type_AndroidViewView = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  lhe jdField_a_of_type_Lhe = new moc(this);
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  String jdField_b_of_type_JavaLangString = null;
  WeakReference<ViewGroup> jdField_b_of_type_JavaLangRefWeakReference = null;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = false;
  private boolean f;
  
  public VideoNetStateBar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup)
  {
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
    this.jdField_a_of_type_Long = -1L;
    b();
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_Lhe != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lhe);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallid != null)
      {
        if (locallid.w)
        {
          locallid.w = false;
          if ((locallid.d == 1) || (locallid.d == 2) || (locallid.d == 3) || (locallid.d == 4))
          {
            this.jdField_b_of_type_Int = locallid.q;
            this.jdField_a_of_type_Int = locallid.r;
          }
        }
        this.jdField_b_of_type_Boolean = locallid.g;
        this.jdField_c_of_type_Boolean = locallid.h;
      }
    }
    m();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
    lid locallid;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      bool1 = bool2;
      if (locallid != null)
      {
        if ((!this.jdField_c_of_type_Boolean) || ((locallid.d != 1) && (locallid.d != 2))) {
          break label76;
        }
        azqs.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
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
      if (locallid.d == 3) {
        break;
      }
      bool1 = bool2;
    } while (locallid.d != 4);
    azqs.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
    return true;
  }
  
  void b()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131372792));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131372793));
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131372794);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131372791));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365151));
      b(0);
      if (AudioHelper.a(0) == 1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-822034433);
      }
    }
  }
  
  void b(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
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
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallid != null)
      {
        locallid.r = this.jdField_a_of_type_Int;
        locallid.q = this.jdField_b_of_type_Int;
        locallid.w = true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_Lhe != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lhe);
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
    this.jdField_a_of_type_Lhe = null;
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    m();
  }
  
  public void d() {}
  
  public void d(int paramInt)
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
  
  public void d(boolean paramBoolean)
  {
    this.d = paramBoolean;
    m();
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    if (!this.f) {
      break label7;
    }
    label7:
    label32:
    View localView;
    ViewGroup.LayoutParams localLayoutParams;
    label176:
    label178:
    label196:
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
            break label176;
          }
          if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
            break label178;
          }
        }
        for (localView = null;; localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131372795))
        {
          if (localView == null) {
            break label196;
          }
          localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          if (localLayoutParams == null) {
            break;
          }
          this.jdField_c_of_type_Int = paramInt;
          if ((this.jdField_c_of_type_Int != 90) && (this.jdField_c_of_type_Int != 270)) {
            break label213;
          }
          paramInt = localContext.getResources().getDisplayMetrics().widthPixels - localContext.getResources().getDimensionPixelSize(2131297693);
          localLayoutParams.width = paramInt;
          localLayoutParams.height = paramInt;
          this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          this.jdField_a_of_type_AndroidViewView.setRotation(90.0F);
          if (this.jdField_c_of_type_Int != 270) {
            break label198;
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
    label198:
    localView.setScaleY(-1.0F);
    localView.setScaleX(-1.0F);
    return;
    label213:
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
        localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131372795);
        break;
      }
    }
    this.f = false;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onDoubleConnected");
    }
    this.jdField_b_of_type_Int = 3;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
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
      lid locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallid != null) && ((locallid.d == 3) || (locallid.d == 4))) {
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
        this.jdField_a_of_type_JavaLangRunnable = new VideoNetStateBar.GroupNetLevelRunnable(this);
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
    int k = 1;
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null)) {}
    label23:
    label122:
    do
    {
      do
      {
        int i;
        do
        {
          break label23;
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
          c(0);
          if (!this.d) {
            break label409;
          }
          str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696186);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841874);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841874);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841874);
          if (i != 1) {
            break label568;
          }
          i = 1;
          this.jdField_b_of_type_JavaLangString = null;
          if ((!this.d) && (i == 0)) {
            break label578;
          }
          j = k;
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 3000L)
          {
            if (!this.d) {
              break label573;
            }
            j = k;
          }
          if (j != 0) {
            mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3001, str);
          }
        }
        for (;;)
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label608;
          }
          if ((!this.d) && (i == 0)) {
            break label591;
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
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696189);
            }
            break;
          case 1: 
            if (j == 2)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696188);
              break;
            }
            if (j == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696191);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696184);
            break;
          case 2: 
            if (j == 2)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696190);
              break;
            }
            if (j == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696193);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696187);
            break;
            if (j == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696192);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131696185);
            break;
            switch (i)
            {
            default: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841870);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841870);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841870);
              break;
            case 1: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841868);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841868);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841868);
              break;
            case 2: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841872);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841872);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841872);
              break;
            case 3: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841870);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841870);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841870);
              break;
              i = 0;
              break label122;
              j = 0;
              break label164;
              mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3001);
            }
            break;
          }
        }
      } while (this.jdField_a_of_type_AndroidViewView == null);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    } while (this.jdField_a_of_type_AndroidViewView == null);
    label164:
    label568:
    label573:
    label578:
    label591:
    label608:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    label409:
  }
  
  void n()
  {
    lid locallid;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      locallid = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallid != null)
      {
        if ((!locallid.J) && (locallid.d != 1) && (locallid.d != 2)) {
          break label69;
        }
        azqs.b(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
      }
    }
    label69:
    while ((locallid.d != 3) && (locallid.d != 4)) {
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar
 * JD-Core Version:    0.7.0.1
 */