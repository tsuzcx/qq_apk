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
import android.view.ViewGroup.LayoutParams;
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
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/");
      int i = (int)paramLong;
      localStringBuilder.append(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
      localTextView.setText(localStringBuilder.toString());
    }
  }
  
  private boolean a()
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo == null) {
      return false;
    }
    return localSessionInfo.ax;
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131559792, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376775);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379930));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379931));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369367));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370327);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369550));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379814));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379850));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380651));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379972));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379971));
  }
  
  private void b(int paramInt)
  {
    k();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.e())) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if (localWatchTogetherMediaPlayerProxy != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localWatchTogetherMediaPlayerProxy.a());
    }
    localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.f()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    else
    {
      localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
      if ((localWatchTogetherMediaPlayerProxy != null) && (!localWatchTogetherMediaPlayerProxy.f())) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165488);
    c(false);
    d(false);
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    int i = 8;
    if ((localObject != null) && (((WatchTogetherMediaPlayerProxy)localObject).g()))
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        i = 0;
      }
      ((ImageView)localObject).setVisibility(i);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    paramInt /= 1000;
    int i = paramInt / 60;
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt % 60) }));
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 == 4) {
            p();
          }
        }
        else {
          o();
        }
      }
      else {
        b(paramInt2);
      }
    }
    else {
      n();
    }
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      VideoController.a().a.a(new Object[] { Integer.valueOf(10006), Boolean.valueOf(paramBoolean) });
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo == null) {
      return;
    }
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
    Object localObject = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if (localObject == null) {
      return;
    }
    WTFileInfo localWTFileInfo = ((WatchTogetherMediaPlayerProxy)localObject).a();
    if (localWTFileInfo == null) {
      return;
    }
    localObject = SessionMgr.a().a();
    if (localObject == null) {
      return;
    }
    localObject = ((WTogetherMng)VideoController.a().a.a(16)).b((SessionInfo)localObject);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WatchTogetherInfo)localObject).a;
    }
    if (localObject == null) {
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    String str1 = SessionMgr.a().a().c;
    String str2 = VideoController.a().a.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("roomid=");
    localStringBuilder.append(((WTogetherRoom)localObject).b);
    localStringBuilder.append("|");
    localStringBuilder.append("file_id=");
    localStringBuilder.append(localWTFileInfo.c);
    localStringBuilder.append("|");
    localStringBuilder.append("file_uuid=");
    localStringBuilder.append(localWTFileInfo.b);
    WTogetherUtil.a(localActivity, str1, str2, localStringBuilder.toString());
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 2)) {
      c(0, 2);
    } else if (this.jdField_a_of_type_Int == 0) {
      c(1, 2);
    }
    j();
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
    if (localAVActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) {
        return;
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        localAVActivity.setRequestedOrientation(0);
        QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
      }
      else
      {
        localAVActivity.setRequestedOrientation(1);
        QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
      }
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(true);
    }
  }
  
  private void n()
  {
    l();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166959);
    c(true);
    d(true);
  }
  
  private void o()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131696007);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    l();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    b(true);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166959);
    c(false);
    d(false);
  }
  
  private void p()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131696008);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166959);
    l();
    c(false);
    d(false);
  }
  
  private void q()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).a.C(-1L);
    }
  }
  
  private void r()
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if (localWatchTogetherMediaPlayerProxy != null)
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText(localWatchTogetherMediaPlayerProxy.a());
      }
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
  
  protected void onDetachedFromWindow()
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
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.c())) {
      return;
    }
    localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.d())) {
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
    Object localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
    boolean bool = false;
    if (paramInt == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(25);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(this.jdField_c_of_type_AndroidWidgetImageView.getVisibility());
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842395);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject).height = -1;
      this.jdField_b_of_type_Boolean = true;
    }
    else if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(12);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842389);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (AIOUtils.b(64.0F, getResources()) + WTogetherUtil.a(getContext()));
      ((ViewGroup.MarginLayoutParams)localObject).height = WTogetherUtil.a();
      this.jdField_b_of_type_Boolean = false;
    }
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    j();
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
      if ((localObject != null) && (((WatchTogetherMediaPlayerProxy)localObject).c()))
      {
        paramInt = 1;
        break label174;
      }
    }
    paramInt = 0;
    label174:
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == 0)) {
      bool = true;
    }
    c(bool);
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
      WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
      if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.c()))
      {
        c(3, 2);
      }
      else
      {
        localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
        if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.d())) {
          c(4, 2);
        } else if (!a()) {
          c(1, 2);
        } else {
          c(0, 2);
        }
      }
      j();
      setOrientationParams(1);
      setVisibility(0);
      return;
    }
    c(0, 2);
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView
 * JD-Core Version:    0.7.0.1
 */