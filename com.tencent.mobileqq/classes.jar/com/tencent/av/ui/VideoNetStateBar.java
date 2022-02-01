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
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
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
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new VideoNetStateBar.1(this);
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  String jdField_a_of_type_JavaLangString = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  ImageView jdField_b_of_type_AndroidWidgetImageView = null;
  String jdField_b_of_type_JavaLangString = null;
  WeakReference<ViewGroup> jdField_b_of_type_JavaLangRefWeakReference = null;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  ImageView jdField_c_of_type_AndroidWidgetImageView = null;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = false;
  private boolean f = false;
  
  public VideoNetStateBar(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoNetStateBar", 2, "VideoNetStateBar");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramViewGroup);
    this.jdField_a_of_type_AndroidContentResResources = paramAVActivity.getResources();
    paramVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvVideoController = paramVideoAppInterface.a();
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
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      GAudioUIObserver localGAudioUIObserver = this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
      if (localGAudioUIObserver != null) {
        ((VideoAppInterface)localObject).a(localGAudioUIObserver);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).a();
      if (localObject != null)
      {
        if (((SessionInfo)localObject).v)
        {
          ((SessionInfo)localObject).v = false;
          if ((((SessionInfo)localObject).d == 1) || (((SessionInfo)localObject).d == 2) || (((SessionInfo)localObject).d == 3) || (((SessionInfo)localObject).d == 4))
          {
            this.jdField_b_of_type_Int = ((SessionInfo)localObject).t;
            this.jdField_a_of_type_Int = ((SessionInfo)localObject).u;
          }
        }
        this.jdField_b_of_type_Boolean = ((SessionInfo)localObject).g;
        this.jdField_c_of_type_Boolean = ((SessionInfo)localObject).h;
      }
    }
    b("onCreate");
  }
  
  public void a(int paramInt)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    boolean bool = QLog.isDevelopLevel();
    int j = 3;
    int i = 1;
    if (bool) {
      QLog.d("VideoNetStateBar", 4, String.format("setNetLevel, emNetLevel[%s], selfNetLevel[%s], peerNetLevel[%s], strDetail[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    }
    if (paramInt2 == paramInt3) {
      paramInt2 = j;
    } else if (paramInt2 > 0) {
      paramInt2 = 1;
    } else if (paramInt3 > 0) {
      paramInt2 = 2;
    } else {
      paramInt2 = 0;
    }
    if ((this.jdField_b_of_type_Int == paramInt1) && (paramInt2 == this.jdField_a_of_type_Int) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString)))
    {
      paramInt1 = 0;
    }
    else
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_JavaLangString = paramString;
      paramInt1 = i;
    }
    if (paramInt1 != 0) {
      b("setNetLevel");
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString);
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).a();
      if (localObject != null)
      {
        if ((this.jdField_c_of_type_Boolean) && ((((SessionInfo)localObject).d == 1) || (((SessionInfo)localObject).d == 2)))
        {
          ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
          return true;
        }
        if ((this.jdField_b_of_type_Boolean) && ((((SessionInfo)localObject).d == 3) || (((SessionInfo)localObject).d == 4)))
        {
          ReportController.b(null, "CliOper", "", "", "0X8005966", "0X8005966", 0, 0, "", "", "", "");
          return true;
        }
      }
    }
    return false;
  }
  
  void b()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373546));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373547));
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373548);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373545));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131365557));
      b(0);
      if (AudioHelper.a(0) == 1) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-822034433);
      }
    }
  }
  
  void b(int paramInt)
  {
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  void b(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      if (this.jdField_c_of_type_AndroidWidgetImageView == null) {
        return;
      }
      if (this.jdField_a_of_type_AndroidContentResResources == null) {
        return;
      }
      int i = this.jdField_b_of_type_Int;
      if (i == 0) {
        return;
      }
      int k = this.jdField_a_of_type_Int;
      boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
      int j = 1;
      Object localObject;
      if (!bool) {
        localObject = this.jdField_a_of_type_JavaLangString;
      } else if (i != 1)
      {
        if (i != 2)
        {
          if (k == 2) {
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695723);
          } else if (k == 1) {
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695726);
          } else {
            localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695719);
          }
        }
        else if (k == 2) {
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695724);
        } else if (k == 1) {
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695727);
        } else {
          localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695721);
        }
      }
      else if (k == 2) {
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695722);
      } else if (k == 1) {
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695725);
      } else {
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695718);
      }
      c(0);
      if (this.d)
      {
        localObject = this.jdField_a_of_type_AndroidContentResResources.getString(2131695720);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842291);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842291);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842291);
      }
      else if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842287);
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842287);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842287);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842287);
            this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842287);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842287);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842289);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842289);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842289);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842285);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842285);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842285);
      }
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_b_of_type_JavaLangString = null;
      if ((!this.d) && (!bool))
      {
        TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3001);
      }
      else
      {
        i = j;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 3000L) {
          if (this.d) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i != 0) {
          TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3001, (String)localObject);
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((!this.d) && (!bool))
        {
          localObject = this.jdField_a_of_type_AndroidViewView;
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_AndroidViewView;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          m();
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("refreshNetLevelTextAndIcon, from[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], noNet[");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append("], bShowNetIcon[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("]");
        QLog.i("VideoNetStateBar", 4, ((StringBuilder)localObject).toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).a();
      if (localObject != null)
      {
        ((SessionInfo)localObject).u = this.jdField_a_of_type_Int;
        ((SessionInfo)localObject).t = this.jdField_b_of_type_Int;
        ((SessionInfo)localObject).v = true;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localObject != null)
    {
      GAudioUIObserver localGAudioUIObserver = this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
      if (localGAudioUIObserver != null) {
        ((VideoAppInterface)localObject).b(localGAudioUIObserver);
      }
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
    this.jdField_b_of_type_JavaLangRefWeakReference = null;
  }
  
  void c(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
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
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
    if (localObject == null) {
      return;
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = paramInt;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
      return;
    }
    if (paramInt == this.jdField_c_of_type_Int) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    View localView = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Context)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) {
      localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373549);
    }
    if (localView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (localLayoutParams == null) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt;
    paramInt = this.jdField_c_of_type_Int;
    if ((paramInt != 90) && (paramInt != 270))
    {
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
      return;
    }
    paramInt = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - ((Context)localObject).getResources().getDimensionPixelSize(2131297901);
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setRotation(90.0F);
    if (this.jdField_c_of_type_Int == 270)
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
    boolean bool = false;
    if (paramBoolean)
    {
      View localView;
      if (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) {
        localView = null;
      } else {
        localView = ((ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get()).findViewById(2131373549);
      }
      paramBoolean = bool;
      if (localView != null) {
        paramBoolean = true;
      }
      this.f = paramBoolean;
      return;
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
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).a();
      if ((localObject != null) && ((((SessionInfo)localObject).d == 3) || (((SessionInfo)localObject).d == 4))) {
        k();
      }
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new VideoNetStateBar.GroupNetLevelRunnable(this);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      if ((localVideoController != null) && (localVideoController.a() != null))
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentAvVideoController.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      }
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      if ((localVideoController != null) && (localVideoController.a() != null)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.e = false;
  }
  
  void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject != null)
    {
      localObject = ((VideoController)localObject).a();
      if (localObject != null) {
        if ((!((SessionInfo)localObject).y) && (((SessionInfo)localObject).d != 1) && (((SessionInfo)localObject).d != 2))
        {
          if ((((SessionInfo)localObject).d == 3) || (((SessionInfo)localObject).d == 4)) {
            ReportController.b(null, "CliOper", "", "", "0X8005921", "0X8005921", 0, 0, "", "", "", "");
          }
        }
        else {
          ReportController.b(null, "CliOper", "", "", "0X8005922", "0X8005922", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoNetStateBar
 * JD-Core Version:    0.7.0.1
 */