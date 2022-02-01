package com.tencent.av.wtogether.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AVUtil;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class WatchTogetherAdminControlView
  extends FrameLayout
  implements WatchTogetherUIProxy, WatchTogetherPlayRatioHelper.OnSelectRatioClickListener
{
  private float jdField_a_of_type_Float = 14.0F;
  private int jdField_a_of_type_Int = 12000;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new WatchTogetherAdminControlView.2(this);
  private View jdField_a_of_type_AndroidViewView;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ProgressBar a;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  protected TextView a;
  private WatchTogetherMediaPlayerProxy jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
  private WatchTogetherPlayRatioHelper jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new WatchTogetherAdminControlView.1(this);
  private final HashMap<View, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 12.0F;
  private int jdField_b_of_type_Int = 200;
  private View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  protected TextView b;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 300;
  private View jdField_c_of_type_AndroidViewView;
  protected ImageView c;
  protected TextView c;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 2;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  
  public WatchTogetherAdminControlView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WatchTogetherAdminControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WatchTogetherAdminControlView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_e_of_type_AndroidWidgetTextView != null)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a());
    }
  }
  
  private void B()
  {
    if (!b())
    {
      c(1, 1);
      return;
    }
    c(0, 2);
  }
  
  private int a(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    return paramView.getMeasuredWidth();
  }
  
  private void a(long paramLong)
  {
    paramLong /= 1000L;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf((int)paramLong / 60), Integer.valueOf((int)paramLong % 60) }));
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.f());
  }
  
  private void b(float paramFloat)
  {
    String str2 = String.format("%.1f", new Object[] { Float.valueOf(paramFloat) });
    String str1 = str2;
    if (str2.equalsIgnoreCase("1.3")) {
      str1 = "1.25";
    }
    str1 = str1 + "x";
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
  }
  
  private void b(int paramInt)
  {
    b();
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.b();
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165512);
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.b()))
    {
      b(this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a());
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a());
      }
      if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) || (!this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.e())) {
        break label180;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    for (;;)
    {
      p();
      c(false);
      b(false);
      return;
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) {
        break;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131695995);
      break;
      label180:
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      VideoController.a().a.a(new Object[] { Integer.valueOf(10006), Boolean.valueOf(paramBoolean) });
    }
  }
  
  private boolean b()
  {
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo == null) {
      return false;
    }
    return localSessionInfo.B();
  }
  
  private void c(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    d(paramInt);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    b(false);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_e_of_type_Int = paramInt1;
      return;
      q();
      d(true);
      continue;
      b(paramInt2);
      d(false);
      continue;
      r();
      d(false);
      continue;
      c(paramInt2);
      d(false);
      continue;
      s();
      d(false);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = 8;
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.g()))
    {
      ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a());
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.b();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166940);
    if (paramInt != 3) {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    a();
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    c(false);
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(paramInt2);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt1);
  }
  
  private void d(boolean paramBoolean)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      localSessionInfo = SessionMgr.a().a();
    } while (localSessionInfo == null);
    localSessionInfo.c(paramBoolean);
  }
  
  private void e(int paramInt)
  {
    int i = paramInt / 1000 / 60;
    paramInt /= 1000;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt % 60) }));
    }
  }
  
  private void g()
  {
    h();
    l();
    v();
  }
  
  private void h()
  {
    LayoutInflater.from(getContext()).inflate(2131559921, this, true);
    i();
    k();
    j();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377322);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380700));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380651));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380652));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380566));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380699));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369668));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370580);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370686);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369866));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131369864));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380517));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377693));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377694);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380702));
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper = new WatchTogetherPlayRatioHelper(this.jdField_a_of_type_AndroidViewView.findViewById(2131370699));
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.a(this);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131381425));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381329));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381486));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381393));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381484));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381250));
  }
  
  private void k()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_c_of_type_AndroidViewView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetImageView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetSeekBar, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetImageView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_e_of_type_AndroidWidgetTextView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetTextView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetTextView, Integer.valueOf(0));
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new WatchTogetherAdminControlView.3(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherAdminControlView.4(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherAdminControlView.5(this));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new WatchTogetherAdminControlView.6(this));
    this.jdField_f_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(new WatchTogetherAdminControlView.7(this));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new WatchTogetherAdminControlView.8(this));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherAdminControlView.9(this));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherAdminControlView.10(this));
    this.jdField_g_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherAdminControlView.11(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new WatchTogetherAdminControlView.12(this));
    int i = a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetTextView.setMinimumWidth(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setMinimumWidth(i);
  }
  
  private void m()
  {
    if (this.jdField_e_of_type_Int == 0) {
      c(1, 2);
    }
    for (;;)
    {
      t();
      return;
      if (this.jdField_e_of_type_Int == 1) {
        c(0, 2);
      } else if (this.jdField_e_of_type_Int == 2) {
        c(1, 2);
      }
    }
  }
  
  private void n()
  {
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
            Activity localActivity = (Activity)getContext();
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
  
  private void o()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (localAVActivity == null) {}
    VideoLayerUI localVideoLayerUI;
    do
    {
      return;
      localVideoLayerUI = localAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    } while (localVideoLayerUI == null);
    WatchTogetherAdminControlView.13 local13 = new WatchTogetherAdminControlView.13(this);
    int i = localVideoLayerUI.g();
    if ((localAVActivity.h == 0) && (i != 1))
    {
      localAVActivity.setRequestedOrientation(1);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(local13, this.jdField_b_of_type_Int);
      return;
    }
    local13.run();
  }
  
  private void p()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void q()
  {
    a();
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.b();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166940);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    c(false);
    b(true);
  }
  
  private void r()
  {
    a();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165512);
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.a();
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    c(false);
    b(false);
  }
  
  private void s()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    c(false);
    b(false);
  }
  
  private void t()
  {
    QLog.d("WatchTogetherVideoPlayView", 1, "enter");
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void u()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if ((localAVActivity == null) || (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null)) {
      return;
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      localAVActivity.setRequestedOrientation(0);
      QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(true);
      return;
      localAVActivity.setRequestedOrientation(1);
      QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void w()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).jdField_a_of_type_ComTencentAvUiVideoControlUI.D(-1L);
    }
  }
  
  private void x()
  {
    int i = getResources().getDimensionPixelOffset(2131298044);
    int j = getResources().getDimensionPixelOffset(2131298046);
    float f1 = this.jdField_b_of_type_Float;
    Drawable localDrawable1 = getResources().getDrawable(2130842497);
    Drawable localDrawable2 = getResources().getDrawable(2130842498);
    if (this.jdField_d_of_type_Boolean)
    {
      i = getResources().getDimensionPixelOffset(2131298043);
      j = getResources().getDimensionPixelOffset(2131298045);
      f1 = this.jdField_a_of_type_Float;
      localDrawable1 = getResources().getDrawable(2130842488);
      localDrawable2 = getResources().getDrawable(2130842489);
    }
    for (;;)
    {
      ((ViewGroup.MarginLayoutParams)this.jdField_f_of_type_AndroidWidgetTextView.getLayoutParams()).rightMargin = j;
      this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(f1);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable1, null, null);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(f1);
      this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable2, null, null);
      this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
      return;
    }
  }
  
  private void y()
  {
    int j = getResources().getDimensionPixelOffset(2131298040);
    int i = getResources().getDimensionPixelOffset(2131298040);
    if (this.jdField_d_of_type_Boolean)
    {
      j = getResources().getDimensionPixelOffset(2131298041);
      i = getResources().getDimensionPixelOffset(2131298042);
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setPadding(j, 0, j, 0);
    WTogetherUtil.a(this.jdField_a_of_type_AndroidWidgetSeekBar, j, j);
    WTogetherUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, j, 0);
    WTogetherUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 0, j);
    WTogetherUtil.a(this.jdField_d_of_type_AndroidWidgetTextView, 0, i);
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) {}
    while (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (c())
    {
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
      return;
    }
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.c();
  }
  
  public void a()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setVisibility(8);
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.15(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.21(this, paramInt1, paramInt2));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.14(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.24(this, paramBoolean));
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.23(this));
    return false;
  }
  
  public boolean a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void b()
  {
    Object localObject;
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setVisibility(0);
      }
      if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 8)) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a()) {
          break label133;
        }
      }
    }
    label133:
    for (int i = 2130842492;; i = 2130842493)
    {
      ((ImageView)localObject).setImageResource(i);
      this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.b();
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.22(this, paramInt1, paramInt2));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.17(this));
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.18(this));
  }
  
  public void e() {}
  
  public void f()
  {
    c(1, 2);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    setOrientationParams(paramConfiguration.orientation);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.b(this);
    }
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
    boolean bool2 = false;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    if (paramInt == 2)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxEms(25);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(this.jdField_e_of_type_AndroidWidgetTextView.getVisibility());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842496);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842496);
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.height = -1;
      if (this.jdField_e_of_type_Int == 1) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_d_of_type_Boolean = true;
      AVUtil.a("0X800B636", 0, 0, "", "", "", "");
      x();
      y();
      t();
      if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) || (!this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.c())) {
        break label291;
      }
    }
    label291:
    for (int i = 1;; i = 0)
    {
      boolean bool1 = bool2;
      if (i == 0)
      {
        bool1 = bool2;
        if (this.jdField_e_of_type_Int == 0) {
          bool1 = true;
        }
      }
      b(bool1);
      setLayoutParams(localMarginLayoutParams);
      this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.a(paramInt);
      return;
      if (paramInt != 1) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxEms(12);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842490);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842490);
      localMarginLayoutParams.topMargin = (AIOUtils.a(64.0F, getResources()) + WTogetherUtil.a(getContext()));
      localMarginLayoutParams.height = WTogetherUtil.a();
      if (this.jdField_e_of_type_Int == 1) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_d_of_type_Boolean = false;
      break;
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new WatchTogetherAdminControlView.16(this, paramOnSeekBarChangeListener));
  }
  
  public void setWatchTogetherMediaPlayerProxy(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy = paramWatchTogetherMediaPlayerProxy;
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.a(this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy);
  }
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean2;
    if (paramBoolean1)
    {
      if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.c())) {
        c(3, 2);
      }
      for (;;)
      {
        t();
        setOrientationParams(1);
        setVisibility(0);
        return;
        if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.d())) {
          c(4, 2);
        } else if (!b()) {
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
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView
 * JD-Core Version:    0.7.0.1
 */