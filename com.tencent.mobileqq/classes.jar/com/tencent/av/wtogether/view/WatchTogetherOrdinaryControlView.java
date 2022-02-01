package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.wtogether.WTogetherMng;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.av.wtogether.callback.WatchTogetherUIProxy;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTogetherRoom;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class WatchTogetherOrdinaryControlView
  extends FrameLayout
  implements WatchTogetherUIProxy
{
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new WatchTogetherOrdinaryControlView.2(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WatchTogetherMediaPlayerProxy jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WatchTogetherOrdinaryControlView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 2;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 12000;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public WatchTogetherOrdinaryControlView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WatchTogetherOrdinaryControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WatchTogetherOrdinaryControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    b();
    f();
    g();
  }
  
  private void a(long paramLong)
  {
    paramLong /= 1000L;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("/" + String.format("%02d:%02d", new Object[] { Integer.valueOf((int)paramLong / 60), Integer.valueOf((int)paramLong % 60) }));
    }
  }
  
  private boolean a()
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo == null) {
      return false;
    }
    return localSessionInfo.B();
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131559922, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377322);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380651));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380652));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369668));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370686);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369864));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380517));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380566));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381393));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380700));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380699));
  }
  
  private void b(int paramInt)
  {
    k();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.e()))
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a());
      }
      if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) || (!this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.f())) {
        break label132;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165512);
      c(false);
      d(false);
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break;
      label132:
      if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (!this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.f())) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int i = 8;
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.g()))
    {
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    int i = paramInt / 1000 / 60;
    paramInt /= 1000;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt % 60) }));
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt1;
      return;
      n();
      continue;
      b(paramInt2);
      continue;
      o();
      continue;
      p();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      VideoController.a().a.a(new Object[] { Integer.valueOf(10006), Boolean.valueOf(paramBoolean) });
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      localSessionInfo = SessionMgr.a().a();
    } while (localSessionInfo == null);
    localSessionInfo.c(paramBoolean);
  }
  
  private void f()
  {
    setOnTouchListener(new WatchTogetherOrdinaryControlView.3(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherOrdinaryControlView.4(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherOrdinaryControlView.5(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherOrdinaryControlView.6(this));
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void h()
  {
    q();
    if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) {}
    for (;;)
    {
      return;
      WTFileInfo localWTFileInfo = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
      if (localWTFileInfo != null)
      {
        Object localObject = SessionMgr.a().a();
        if (localObject != null)
        {
          localObject = ((WTogetherMng)VideoController.a().a.a(15)).b((SessionInfo)localObject);
          if (localObject == null) {}
          for (localObject = null; localObject != null; localObject = ((WatchTogetherInfo)localObject).a)
          {
            Activity localActivity = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
            String str1 = SessionMgr.a().a().d;
            String str2 = VideoController.a().a.getCurrentAccountUin();
            StringBuilder localStringBuilder = new StringBuilder(100);
            localStringBuilder.append("roomid=").append(((WTogetherRoom)localObject).b).append("|");
            localStringBuilder.append("file_id=").append(localWTFileInfo.c).append("|");
            localStringBuilder.append("file_uuid=").append(localWTFileInfo.b);
            WTogetherUtil.a(localActivity, str1, str2, localStringBuilder.toString());
            return;
          }
        }
      }
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 2)) {
      c(0, 2);
    }
    for (;;)
    {
      j();
      return;
      if (this.jdField_a_of_type_Int == 0) {
        c(1, 2);
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_c_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    b(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    b(false);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void m()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if ((localAVActivity == null) || (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null)) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      localAVActivity.setRequestedOrientation(0);
      QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(true);
      return;
      localAVActivity.setRequestedOrientation(1);
      QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
    }
  }
  
  private void n()
  {
    l();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166940);
    c(true);
    d(true);
  }
  
  private void o()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131695992);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    l();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    b(true);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166940);
    c(false);
    d(false);
  }
  
  private void p()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131695993);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166940);
    l();
    c(false);
    d(false);
  }
  
  private void q()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).a.D(-1L);
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a());
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherOrdinaryControlView.8(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherOrdinaryControlView.10(this, paramInt1, paramInt2));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherOrdinaryControlView.7(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherOrdinaryControlView.9(this));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherOrdinaryControlView.11(this));
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setOrientationParams(paramConfiguration.orientation);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.b(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void setImmersiveStatus(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.c())) {}
    while ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.d())) {
      return;
    }
    if (paramBoolean)
    {
      c(0, 2);
      return;
    }
    c(1, 2);
  }
  
  public void setOrientationParams(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    label98:
    boolean bool;
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(25);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(this.jdField_c_of_type_AndroidWidgetImageView.getVisibility());
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842496);
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.height = -1;
      this.jdField_b_of_type_Boolean = true;
      setLayoutParams(localMarginLayoutParams);
      j();
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) || (!this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.c())) {
        break label180;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label185;
      }
      bool = false;
    }
    for (;;)
    {
      c(bool);
      return;
      if (paramInt != 1) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(12);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842490);
      localMarginLayoutParams.topMargin = (AIOUtils.a(64.0F, getResources()) + WTogetherUtil.a(getContext()));
      localMarginLayoutParams.height = WTogetherUtil.a();
      this.jdField_b_of_type_Boolean = false;
      break;
      label180:
      paramInt = 0;
      break label98;
      label185:
      if (this.jdField_a_of_type_Int == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void setWatchTogetherMediaPlayerProxy(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy = paramWatchTogetherMediaPlayerProxy;
  }
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.c())) {
        c(3, 2);
      }
      for (;;)
      {
        j();
        setOrientationParams(1);
        setVisibility(0);
        return;
        if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.d())) {
          c(4, 2);
        } else if (!a()) {
          c(1, 2);
        } else {
          c(0, 2);
        }
      }
    }
    c(0, 2);
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView
 * JD-Core Version:    0.7.0.1
 */