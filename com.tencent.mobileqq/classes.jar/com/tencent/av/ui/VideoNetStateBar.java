package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bdla;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lee;
import lfe;
import mbf;
import mmi;
import mqq.os.MqqHandler;

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
  lee jdField_a_of_type_Lee = new mmi(this);
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
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_Lee != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lee);
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallfe != null)
      {
        if (locallfe.w)
        {
          locallfe.w = false;
          if ((locallfe.d == 1) || (locallfe.d == 2) || (locallfe.d == 3) || (locallfe.d == 4))
          {
            this.jdField_b_of_type_Int = locallfe.r;
            this.jdField_a_of_type_Int = locallfe.s;
          }
        }
        this.jdField_b_of_type_Boolean = locallfe.g;
        this.jdField_c_of_type_Boolean = locallfe.h;
      }
    }
    b("onCreate");
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
        b("setNetLevel");
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
      b("setImmersiveFlag");
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    lfe locallfe;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      bool1 = bool2;
      if (locallfe != null)
      {
        if ((!this.jdField_c_of_type_Boolean) || ((locallfe.d != 1) && (locallfe.d != 2))) {
          break label76;
        }
        bdla.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
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
      if (locallfe.d == 3) {
        break;
      }
      bool1 = bool2;
    } while (locallfe.d != 4);
    bdla.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
    return true;
  }
  
  void b()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373660));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373661));
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373662);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373659));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365559));
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
  
  void b(String paramString)
  {
    int j = 1;
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView == null)) {
      break label23;
    }
    label23:
    label163:
    label180:
    label696:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidContentResResources != null)
      {
        int i = this.jdField_b_of_type_Int;
        if (i == 0) {
          break;
        }
        int k = this.jdField_a_of_type_Int;
        String str;
        boolean bool;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          str = this.jdField_a_of_type_JavaLangString;
          c(0);
          if (!this.d) {
            break label475;
          }
          str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695465);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842250);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842250);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842250);
          if (i != 1) {
            break label636;
          }
          bool = true;
          label120:
          this.jdField_b_of_type_JavaLangString = null;
          if ((!this.d) && (!bool)) {
            break label647;
          }
          i = j;
          if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 3000L)
          {
            if (!this.d) {
              break label642;
            }
            i = j;
          }
          if (i != 0) {
            mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3001, str);
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label679;
          }
          if ((!this.d) && (!bool)) {
            break label660;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
          m();
        }
        for (;;)
        {
          if (!QLog.isDevelopLevel()) {
            break label696;
          }
          QLog.i("VideoNetStateBar", 4, "refreshNetLevelTextAndIcon, from[" + paramString + "], noNet[" + this.d + "], bShowNetIcon[" + bool + "]");
          return;
          switch (i)
          {
          default: 
            if (k == 2) {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695468);
            }
            break;
          case 1: 
            if (k == 2)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695467);
              break;
            }
            if (k == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695470);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695463);
            break;
          case 2: 
            if (k == 2)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695469);
              break;
            }
            if (k == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695472);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695466);
            break;
            if (k == 1)
            {
              str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695471);
              break;
            }
            str = this.jdField_a_of_type_AndroidContentResResources.getString(2131695464);
            break;
            switch (i)
            {
            default: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842246);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842246);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842246);
              break;
            case 1: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842244);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842244);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842244);
              break;
            case 2: 
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842248);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842248);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842248);
              break;
            case 3: 
              label475:
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842246);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842246);
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842246);
              break;
              label636:
              bool = false;
              break label120;
              i = 0;
              break label163;
              mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3001);
              break label180;
              if (this.jdField_a_of_type_AndroidViewView != null)
              {
                this.jdField_a_of_type_AndroidViewView.setVisibility(8);
                continue;
                if (this.jdField_a_of_type_AndroidViewView != null) {
                  this.jdField_a_of_type_AndroidViewView.setVisibility(8);
                }
              }
              break;
            }
            break;
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      a();
    }
    b("setSelfCloseMICFlag");
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
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallfe != null)
      {
        locallfe.s = this.jdField_a_of_type_Int;
        locallfe.r = this.jdField_b_of_type_Int;
        locallfe.w = true;
      }
    }
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_Lee != null)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lee);
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
    this.jdField_a_of_type_Lee = null;
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
    b("setPeerCloseMICFlag");
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
    b("setNoNetworkFlag");
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
        for (localView = null;; localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373663))
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
          paramInt = localContext.getResources().getDisplayMetrics().widthPixels - localContext.getResources().getDimensionPixelSize(2131297840);
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
        localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373663);
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
    b("onDoubleConnected");
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "onMultiConnected");
    }
    this.jdField_b_of_type_Int = 3;
    b("onMultiConnected");
    j();
  }
  
  void j()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      lfe locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((locallfe != null) && ((locallfe.d == 3) || (locallfe.d == 4))) {
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
    } while ((this.jdField_a_of_type_JavaLangRunnable == null) || (this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentAvVideoController.a() == null));
    this.jdField_a_of_type_ComTencentAvVideoController.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvVideoController.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null)) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.e = false;
  }
  
  void m()
  {
    lfe locallfe;
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      locallfe = this.jdField_a_of_type_ComTencentAvVideoController.a();
      if (locallfe != null)
      {
        if ((!locallfe.J) && (locallfe.d != 1) && (locallfe.d != 2)) {
          break label69;
        }
        bdla.b(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
      }
    }
    label69:
    while ((locallfe.d != 3) && (locallfe.d != 4)) {
      return;
    }
    bdla.b(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar
 * JD-Core Version:    0.7.0.1
 */