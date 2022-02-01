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
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if (localWatchTogetherMediaPlayerProxy != null)
    {
      TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localTextView != null) {
        localTextView.setText(localWatchTogetherMediaPlayerProxy.a());
      }
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
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null)
    {
      int i = (int)paramLong;
      localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
  }
  
  private boolean a()
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    return (localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.f());
  }
  
  private void b(float paramFloat)
  {
    Object localObject2 = String.format("%.1f", new Object[] { Float.valueOf(paramFloat) });
    Object localObject1 = localObject2;
    if (((String)localObject2).equalsIgnoreCase("1.3")) {
      localObject1 = "1.25";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("x");
    localObject1 = ((StringBuilder)localObject2).toString();
    this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165488);
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.b())) {
      b(this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a());
    } else if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131696010);
    }
    localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if (localWatchTogetherMediaPlayerProxy != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(localWatchTogetherMediaPlayerProxy.a());
    }
    localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.e())) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    } else {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    p();
    c(false);
    b(false);
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
    return localSessionInfo.ax;
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
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 == 4)
            {
              s();
              d(false);
            }
          }
          else
          {
            c(paramInt2);
            d(false);
          }
        }
        else
        {
          r();
          d(false);
        }
      }
      else
      {
        b(paramInt2);
        d(false);
      }
    }
    else
    {
      q();
      d(true);
    }
    this.jdField_e_of_type_Int = paramInt1;
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    int i = 8;
    if ((localObject != null) && (((WatchTogetherMediaPlayerProxy)localObject).g()))
    {
      localObject = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        i = 0;
      }
      ((ImageView)localObject).setVisibility(i);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean c()
  {
    WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
    return (localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.a());
  }
  
  private void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.b();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166959);
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
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (localSessionInfo == null) {
      return;
    }
    localSessionInfo.c(paramBoolean);
  }
  
  private void e(int paramInt)
  {
    paramInt /= 1000;
    int i = paramInt / 60;
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt % 60) }));
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
    LayoutInflater.from(getContext()).inflate(2131559791, this, true);
    i();
    k();
    j();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376775);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379972));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379930));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379931));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379850));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379971));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369367));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370233);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370327);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369552));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131369550));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379814));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377129));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377130);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379973));
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper = new WatchTogetherPlayRatioHelper(this.jdField_a_of_type_AndroidViewView.findViewById(2131370338));
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.a(this);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380683));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380586));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380737));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380651));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380735));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380504));
  }
  
  private void k()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    View localView = this.jdField_c_of_type_AndroidViewView;
    Integer localInteger = Integer.valueOf(0);
    localHashMap.put(localView, localInteger);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetImageView, localInteger);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetSeekBar, localInteger);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetImageView, localInteger);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_e_of_type_AndroidWidgetTextView, localInteger);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetTextView, localInteger);
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetTextView, localInteger);
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
    int i = this.jdField_e_of_type_Int;
    if (i == 0) {
      c(1, 2);
    } else if (i == 1) {
      c(0, 2);
    } else if (i == 2) {
      c(1, 2);
    }
    t();
  }
  
  private void n()
  {
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
    Activity localActivity = (Activity)getContext();
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
  
  private void o()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if (localAVActivity == null) {
      return;
    }
    VideoLayerUI localVideoLayerUI = localAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
    if (localVideoLayerUI == null) {
      return;
    }
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166959);
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
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165488);
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
    if (localAVActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) {
        return;
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        localAVActivity.setRequestedOrientation(0);
        QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
      }
      else
      {
        localAVActivity.setRequestedOrientation(1);
        QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
      }
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(true);
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void w()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).jdField_a_of_type_ComTencentAvUiVideoControlUI.C(-1L);
    }
  }
  
  private void x()
  {
    int i = getResources().getDimensionPixelOffset(2131298038);
    int j = getResources().getDimensionPixelOffset(2131298040);
    float f1 = this.jdField_b_of_type_Float;
    Drawable localDrawable1 = getResources().getDrawable(2130842396);
    Drawable localDrawable2 = getResources().getDrawable(2130842397);
    if (this.jdField_d_of_type_Boolean)
    {
      i = getResources().getDimensionPixelOffset(2131298037);
      j = getResources().getDimensionPixelOffset(2131298039);
      f1 = this.jdField_a_of_type_Float;
      localDrawable1 = getResources().getDrawable(2130842387);
      localDrawable2 = getResources().getDrawable(2130842388);
    }
    ((ViewGroup.MarginLayoutParams)this.jdField_f_of_type_AndroidWidgetTextView.getLayoutParams()).rightMargin = j;
    this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(f1);
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable1, null, null);
    this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(f1);
    this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable2, null, null);
    this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(i);
  }
  
  private void y()
  {
    int i = getResources().getDimensionPixelOffset(2131298034);
    int j = getResources().getDimensionPixelOffset(2131298034);
    if (this.jdField_d_of_type_Boolean)
    {
      i = getResources().getDimensionPixelOffset(2131298035);
      j = getResources().getDimensionPixelOffset(2131298036);
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setPadding(i, 0, i, 0);
    WTogetherUtil.a(this.jdField_a_of_type_AndroidWidgetSeekBar, i, i);
    WTogetherUtil.a(this.jdField_b_of_type_AndroidWidgetTextView, i, 0);
    WTogetherUtil.a(this.jdField_a_of_type_AndroidWidgetTextView, 0, i);
    WTogetherUtil.a(this.jdField_d_of_type_AndroidWidgetTextView, 0, j);
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy == null) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (c())
      {
        this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
        return;
      }
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.c();
    }
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
    if (!this.jdField_b_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setVisibility(0);
      }
      localObject = this.jdField_d_of_type_AndroidViewView;
      if ((localObject != null) && (((View)localObject).getVisibility() == 8)) {
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      localObject = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
      if (localObject != null)
      {
        ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
        int i;
        if (((WatchTogetherMediaPlayerProxy)localObject).a()) {
          i = 2130842391;
        } else {
          i = 2130842392;
        }
        localImageView.setImageResource(i);
      }
      this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper.b();
      this.jdField_b_of_type_Boolean = true;
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
  
  protected void onDetachedFromWindow()
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
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    boolean bool2 = false;
    if (paramInt == 2)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxEms(25);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(this.jdField_e_of_type_AndroidWidgetTextView.getVisibility());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842395);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842395);
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.height = -1;
      if (this.jdField_e_of_type_Int == 1) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_d_of_type_Boolean = true;
      AVUtil.a("0X800B636", 0, 0, "", "", "", "");
    }
    else if (paramInt == 1)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxEms(12);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842389);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842389);
      localMarginLayoutParams.topMargin = (AIOUtils.b(64.0F, getResources()) + WTogetherUtil.a(getContext()));
      localMarginLayoutParams.height = WTogetherUtil.a();
      if (this.jdField_e_of_type_Int == 1) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_d_of_type_Boolean = false;
    }
    x();
    y();
    t();
    if (this.jdField_d_of_type_Boolean)
    {
      WatchTogetherMediaPlayerProxy localWatchTogetherMediaPlayerProxy = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
      if ((localWatchTogetherMediaPlayerProxy != null) && (localWatchTogetherMediaPlayerProxy.c()))
      {
        i = 1;
        break label259;
      }
    }
    int i = 0;
    label259:
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
        } else if (!b()) {
          c(1, 2);
        } else {
          c(0, 2);
        }
      }
      t();
      setOrientationParams(1);
      setVisibility(0);
      return;
    }
    c(0, 2);
    setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView
 * JD-Core Version:    0.7.0.1
 */