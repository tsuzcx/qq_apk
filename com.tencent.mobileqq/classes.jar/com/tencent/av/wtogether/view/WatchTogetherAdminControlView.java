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
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import lbz;
import lfe;
import mrr;
import mxd;
import myj;
import mym;
import myw;
import myx;
import nad;
import nav;
import naw;
import nax;
import nay;
import naz;
import nba;
import nbb;
import nbc;
import nbd;
import nbe;
import nbf;
import nbg;
import nbm;
import nbn;

public class WatchTogetherAdminControlView
  extends FrameLayout
  implements mym, nbn
{
  private final int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new naz(this);
  private View jdField_a_of_type_AndroidViewView;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected ProgressBar a;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  protected TextView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WatchTogetherAdminControlView.1(this);
  private final HashMap<View, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private myj jdField_a_of_type_Myj;
  private nbm jdField_a_of_type_Nbm;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  protected ImageView b;
  protected TextView b;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  protected ImageView c;
  protected TextView c;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 3;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int = 4;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private final int jdField_f_of_type_Int = 1;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private final int jdField_g_of_type_Int = 2;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private final int h = 12000;
  private int i = 0;
  private int j = 2;
  
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
    h();
  }
  
  private void A()
  {
    int k = AIOUtils.dp2px(12.0F, getResources());
    int m = AIOUtils.dp2px(62.0F, getResources());
    Drawable localDrawable1 = getResources().getDrawable(2130842354);
    Drawable localDrawable2 = getResources().getDrawable(2130842355);
    if (this.jdField_d_of_type_Boolean)
    {
      k = AIOUtils.dp2px(16.0F, getResources());
      m = AIOUtils.dp2px(124.0F, getResources());
      localDrawable1 = getResources().getDrawable(2130842345);
      localDrawable2 = getResources().getDrawable(2130842346);
    }
    for (float f1 = 14.0F;; f1 = 12.0F)
    {
      ((ViewGroup.MarginLayoutParams)this.jdField_f_of_type_AndroidWidgetTextView.getLayoutParams()).rightMargin = m;
      this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(f1);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable1, null, null);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(k);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(f1);
      this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable2, null, null);
      this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(k);
      return;
    }
  }
  
  private void B()
  {
    int m = AIOUtils.dp2px(8.0F, getResources());
    int k = AIOUtils.dp2px(8.0F, getResources());
    if (this.jdField_d_of_type_Boolean)
    {
      m = AIOUtils.dp2px(12.0F, getResources());
      k = AIOUtils.dp2px(16.0F, getResources());
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setPadding(m, 0, m, 0);
    nad.a(this.jdField_a_of_type_AndroidWidgetSeekBar, m, m);
    nad.a(this.jdField_b_of_type_AndroidWidgetTextView, m, 0);
    nad.a(this.jdField_a_of_type_AndroidWidgetTextView, 0, m);
    nad.a(this.jdField_d_of_type_AndroidWidgetTextView, 0, k);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_Myj == null) {}
    while (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    if (c())
    {
      this.jdField_a_of_type_Myj.a();
      return;
    }
    this.jdField_a_of_type_Myj.c();
  }
  
  private void D()
  {
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_e_of_type_AndroidWidgetTextView != null)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Myj.a());
    }
  }
  
  private void E()
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
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean) {
      VideoController.a().a.a(new Object[] { Integer.valueOf(10006), Boolean.valueOf(paramBoolean) });
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.f());
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
    this.jdField_a_of_type_Nbm.b();
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165512);
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.b()))
    {
      b(this.jdField_a_of_type_Myj.a());
      if (this.jdField_a_of_type_Myj != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Myj.a());
      }
      if ((this.jdField_a_of_type_Myj == null) || (!this.jdField_a_of_type_Myj.e())) {
        break label182;
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    for (;;)
    {
      q();
      b(false);
      a(false);
      return;
      if (this.jdField_a_of_type_Myj == null) {
        break;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(2131695748);
      break;
      label182:
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int k = 8;
    if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.g()))
    {
      ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        k = 0;
      }
      localImageView.setVisibility(k);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private boolean b()
  {
    lfe locallfe = lbz.a().a();
    if (locallfe == null) {
      return false;
    }
    return locallfe.B();
  }
  
  private void c(int paramInt)
  {
    int k = paramInt / 1000 / 60;
    paramInt /= 1000;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt % 60) }));
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.i = paramInt1;
      return;
      r();
      c(true);
      continue;
      b(paramInt2);
      c(false);
      continue;
      s();
      c(false);
      continue;
      t();
      c(false);
      continue;
      u();
      c(false);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    lfe locallfe;
    do
    {
      return;
      locallfe = lbz.a().a();
    } while (locallfe == null);
    locallfe.c(paramBoolean);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.a());
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(paramInt2);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt1);
  }
  
  private void h()
  {
    i();
    m();
    x();
  }
  
  private void i()
  {
    LayoutInflater.from(getContext()).inflate(2131559845, this, true);
    j();
    l();
    k();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376914);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380257));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380210));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380211));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380127));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380256));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369410));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370311);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370412);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369594));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131369592));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380078));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377272));
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377273);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380259));
    this.jdField_a_of_type_Nbm = new nbm(this.jdField_a_of_type_AndroidViewView.findViewById(2131370423));
    this.jdField_a_of_type_Nbm.a(this);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380968));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380881));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381024));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380936));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381022));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380802));
  }
  
  private void l()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_c_of_type_AndroidViewView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetImageView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetSeekBar, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetImageView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_e_of_type_AndroidWidgetTextView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_AndroidWidgetTextView, Integer.valueOf(0));
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_b_of_type_AndroidWidgetTextView, Integer.valueOf(0));
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new nba(this));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new nbb(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new nbc(this));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new nbd(this));
    this.jdField_f_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(new nbe(this));
    this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new nbf(this));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(new nbg(this));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new nav(this));
    this.jdField_g_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(new naw(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new nax(this));
    int k = a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetTextView.setMinimumWidth(k);
    this.jdField_b_of_type_AndroidWidgetTextView.setMinimumWidth(k);
  }
  
  private void n()
  {
    if (this.i == 0) {
      c(this.i + 1, 2);
    }
    for (;;)
    {
      v();
      return;
      if (this.i == 1) {
        c(0, 2);
      } else if (this.i == 2) {
        c(1, 2);
      }
    }
  }
  
  private void o()
  {
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
            Activity localActivity = (Activity)getContext();
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
  
  private void p()
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
    int k = localVideoLayerUI.g();
    if ((localAVActivity.h == 0) && (k != 1))
    {
      localAVActivity.setRequestedOrientation(1);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(local13, 200L);
      return;
    }
    local13.run();
  }
  
  private void q()
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
  
  private void r()
  {
    a();
    this.jdField_a_of_type_Nbm.b();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166935);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    b(false);
    a(true);
  }
  
  private void s()
  {
    a();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131165512);
    this.jdField_a_of_type_Nbm.a();
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
    b(false);
    a(false);
  }
  
  private void t()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    y();
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    a(false);
  }
  
  private void u()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    b(false);
    a(false);
  }
  
  private void v()
  {
    QLog.d("WatchTogetherVideoPlayView", 1, "enter");
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 12000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void w()
  {
    AVActivity localAVActivity = (AVActivity)getContext();
    if ((localAVActivity == null) || (this.jdField_a_of_type_Myj == null)) {
      return;
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      localAVActivity.setRequestedOrientation(0);
      QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE]");
    }
    for (;;)
    {
      this.jdField_a_of_type_Myj.a(true);
      return;
      localAVActivity.setRequestedOrientation(1);
      QLog.d("WatchTogetherVideoPlayView", 1, "setRequestedOrientation, displayRotation[ActivityInfo.SCREEN_ORIENTATION_PORTRAIT]");
    }
  }
  
  private void x()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void y()
  {
    this.jdField_a_of_type_Nbm.b();
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166935);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    a();
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    b(false);
  }
  
  private void z()
  {
    if (getContext() != null) {
      ((AVActivity)getContext()).jdField_a_of_type_ComTencentAvUiVideoControlUI.D(-1L);
    }
  }
  
  public void a()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext()) {
        ((View)localIterator.next()).setVisibility(8);
      }
      this.jdField_a_of_type_Boolean = false;
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
    if (!this.jdField_a_of_type_Boolean)
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
      if (this.jdField_a_of_type_Myj != null)
      {
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!this.jdField_a_of_type_Myj.a()) {
          break label133;
        }
      }
    }
    label133:
    for (int k = 2130842349;; k = 2130842350)
    {
      ((ImageView)localObject).setImageResource(k);
      this.jdField_a_of_type_Nbm.b();
      this.jdField_a_of_type_Boolean = true;
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
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherAdminControlView.24(this));
  }
  
  public void g()
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
    boolean bool = false;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    int k;
    if (paramInt == 2)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxEms(25);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(this.jdField_e_of_type_AndroidWidgetTextView.getVisibility());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842353);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842353);
      localMarginLayoutParams.topMargin = 0;
      localMarginLayoutParams.height = -1;
      if (this.i == 1) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_d_of_type_Boolean = true;
      mrr.a("0X800B636", 0, 0, "", "", "", "");
      A();
      B();
      v();
      if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Myj == null) || (!this.jdField_a_of_type_Myj.c())) {
        break label275;
      }
      k = 1;
      label152:
      if (k == 0) {
        break label280;
      }
    }
    for (;;)
    {
      a(bool);
      setLayoutParams(localMarginLayoutParams);
      this.jdField_a_of_type_Nbm.a(paramInt);
      return;
      if (paramInt != 1) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setMaxEms(12);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842347);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130842347);
      localMarginLayoutParams.topMargin = (AIOUtils.dp2px(64.0F, getResources()) + nad.a(getContext()));
      localMarginLayoutParams.height = nad.a();
      if (this.i == 1) {
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_d_of_type_Boolean = false;
      break;
      label275:
      k = 0;
      break label152;
      label280:
      if (this.i == 0) {
        bool = true;
      }
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener == null)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new nay(this, paramOnSeekBarChangeListener));
  }
  
  public void setWatchTogetherMediaPlayerProxy(myj parammyj)
  {
    this.jdField_a_of_type_Myj = parammyj;
    this.jdField_a_of_type_Nbm.a(this.jdField_a_of_type_Myj);
  }
  
  public void setWatchTogetherParams(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_Boolean = paramBoolean2;
    if (paramBoolean1)
    {
      if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.c())) {
        c(3, 2);
      }
      for (;;)
      {
        v();
        setOrientationParams(1);
        setVisibility(0);
        return;
        if ((this.jdField_a_of_type_Myj != null) && (this.jdField_a_of_type_Myj.d())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherAdminControlView
 * JD-Core Version:    0.7.0.1
 */