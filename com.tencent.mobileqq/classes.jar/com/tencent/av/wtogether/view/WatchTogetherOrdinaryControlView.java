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
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import lbz;
import lfe;
import mxd;
import myj;
import mym;
import myw;
import myx;
import nad;
import nbh;
import nbi;
import nbj;
import nbk;
import nbl;

public class WatchTogetherOrdinaryControlView
  extends FrameLayout
  implements mym
{
  private final int jdField_a_of_type_Int = 12000;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new nbh(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WatchTogetherOrdinaryControlView.1(this);
  private myj jdField_a_of_type_Myj;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final int jdField_d_of_type_Int = 2;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private final int e = 3;
  private final int f = 1;
  private final int g = 2;
  private int h = 0;
  private int i = 2;
  
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
    g();
    h();
  }
  
  private void a(long paramLong)
  {
    paramLong /= 1000L;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("/" + String.format("%02d:%02d", new Object[] { Integer.valueOf((int)paramLong / 60), Integer.valueOf((int)paramLong % 60) }));
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 8;
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.g()))
    {
      ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        j = 0;
      }
      localImageView.setVisibility(j);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean a()
  {
    lfe locallfe = lbz.a().a();
    if (locallfe == null) {
      return false;
    }
    return locallfe.B();
  }
  
  private void b()
  {
    LayoutInflater.from(getContext()).inflate(2131559846, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376914);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380210));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380211));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369410));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370412);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369592));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380078));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380127));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380936));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380257));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380256));
  }
  
  private void b(int paramInt)
  {
    l();
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.e()))
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (this.jdField_a_of_type_Myj != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Myj.a());
      }
      if ((this.jdField_a_of_type_Myj == null) || (!this.jdField_a_of_type_Myj.f())) {
        break label132;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165512);
      b(false);
      c(false);
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      break;
      label132:
      if ((this.jdField_a_of_type_Myj != null) && (!this.jdField_a_of_type_Myj.f())) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      VideoController.a().a.a(new Object[] { Integer.valueOf(10006), Boolean.valueOf(paramBoolean) });
    }
  }
  
  private void c(int paramInt)
  {
    int j = paramInt / 1000 / 60;
    paramInt /= 1000;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt % 60) }));
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.h = paramInt1;
      return;
      o();
      continue;
      b(paramInt2);
      continue;
      p();
      continue;
      q();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    lfe locallfe;
    do
    {
      return;
      locallfe = lbz.a().a();
    } while (locallfe == null);
    locallfe.c(paramBoolean);
  }
  
  private void g()
  {
    setOnTouchListener(new nbi(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new nbj(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nbk(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new nbl(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void i()
  {
    r();
    if (this.jdField_a_of_type_Myj == null) {}
    for (;;)
    {
      return;
      WTFileInfo localWTFileInfo = this.jdField_a_of_type_Myj.a();
      if (localWTFileInfo != null)
      {
        Object localObject = lbz.a().a();
        if (localObject != null)
        {
          localObject = ((mxd)VideoController.a().a.a(15)).b((lfe)localObject);
          if (localObject == null) {}
          for (localObject = null; localObject != null; localObject = ((myx)localObject).a)
          {
            Activity localActivity = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
            String str1 = lbz.a().a().d;
            String str2 = VideoController.a().a.getCurrentAccountUin();
            StringBuilder localStringBuilder = new StringBuilder(100);
            localStringBuilder.append("roomid=").append(((myw)localObject).b).append("|");
            localStringBuilder.append("file_id=").append(localWTFileInfo.c).append("|");
            localStringBuilder.append("file_uuid=").append(localWTFileInfo.b);
            nad.a(localActivity, str1, str2, localStringBuilder.toString());
            return;
          }
        }
      }
    }
  }
  
  private void j()
  {
    if ((this.h == 1) && (this.i == 2)) {
      c(0, 2);
    }
    for (;;)
    {
      k();
      return;
      if (this.h == 0) {
        c(1, 2);
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 12000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a(true);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(false);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void n()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if ((localAVActivity == null) || (this.jdField_a_of_type_Myj == null)) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      localAVActivity.setRequestedOrientation(0);
      QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
    }
    for (;;)
    {
      this.jdField_a_of_type_Myj.a(true);
      return;
      localAVActivity.setRequestedOrientation(1);
      QLog.d("WatchTogetherOrdinaryControlView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
    }
  }
  
  private void o()
  {
    m();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166935);
    b(true);
    c(true);
  }
  
  private void p()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131695745);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    m();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a(true);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166935);
    b(false);
    c(false);
  }
  
  private void q()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(2131695746);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166935);
    m();
    b(false);
    c(false);
  }
  
  private void r()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).a.D(-1L);
    }
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Myj.a());
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
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherOrdinaryControlView.9(this));
  }
  
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
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.c())) {}
    while ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.d())) {
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
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842353);
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.height = -1;
      this.jdField_b_of_type_Boolean = true;
      setLayoutParams(localMarginLayoutParams);
      k();
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Myj == null) || (!this.jdField_a_of_type_Myj.c())) {
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
      b(bool);
      return;
      if (paramInt != 1) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(12);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842347);
      localMarginLayoutParams.topMargin = (AIOUtils.dp2px(64.0F, getResources()) + nad.a(getContext()));
      localMarginLayoutParams.height = nad.a();
      this.jdField_b_of_type_Boolean = false;
      break;
      label180:
      paramInt = 0;
      break label98;
      label185:
      if (this.h == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener) {}
  
  public void setWatchTogetherMediaPlayerProxy(myj parammyj)
  {
    this.jdField_a_of_type_Myj = parammyj;
  }
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.c())) {
        c(2, 2);
      }
      for (;;)
      {
        k();
        setOrientationParams(1);
        setVisibility(0);
        return;
        if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.d())) {
          c(3, 2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherOrdinaryControlView
 * JD-Core Version:    0.7.0.1
 */