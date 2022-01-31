package com.tencent.mobileqq.armap.wealthgod;

import abbt;
import abbu;
import abbv;
import abbw;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.ArMapUtil.CurfewResInfo;
import com.tencent.mobileqq.armap.SdCardImageAnimView;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodConfig;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ARMapSplashView
  extends FrameLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  private SdCardImageAnimView jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView;
  private ARMapConfig.WealthGodConfig jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig;
  private ARMapConfig jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig;
  public ARMapSplashBgView a;
  private ARMapSplashInfoView jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView;
  private ARMapSplashView.ARMapLoadingLaunchListener jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapLoadingLaunchListener;
  private ARMapSplashView.ARMapSplashListener jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener;
  private WealthGodInfo jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo;
  private StrokeTextView jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private int jdField_f_of_type_Int = 0;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private int jdField_g_of_type_Int = 0;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p = -1;
  
  public ARMapSplashView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ARMapSplashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARMapSplashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130970221, this, true);
    setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new abbw(this, Looper.getMainLooper(), this);
    j();
    g();
    h();
  }
  
  private int a(WealthGodInfo paramWealthGodInfo, boolean paramBoolean)
  {
    int i2 = 7;
    if (paramWealthGodInfo != null)
    {
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      ArMapUtil.CurfewResInfo localCurfewResInfo = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig);
      int i1;
      if (paramBoolean) {
        i1 = 3;
      }
      do
      {
        do
        {
          do
          {
            return i1;
            if ((localCurfewResInfo != null) && (localCurfewResInfo.jdField_a_of_type_Boolean)) {
              return 2;
            }
            if (l1 >= paramWealthGodInfo.jdField_c_of_type_Long) {
              break;
            }
            i1 = i2;
          } while (!ArMapUtil.a(l1, paramWealthGodInfo.jdField_c_of_type_Long));
          return 4;
          i1 = i2;
        } while (l1 >= paramWealthGodInfo.jdField_d_of_type_Long);
        if (a(paramWealthGodInfo) > 0L) {
          return 5;
        }
        i1 = i2;
      } while (paramWealthGodInfo.jdField_b_of_type_Long <= 0L);
      return 6;
    }
    return 1;
  }
  
  private long a(WealthGodInfo paramWealthGodInfo)
  {
    if (paramWealthGodInfo != null) {
      l1 = NetConnInfoCenter.getServerTime();
    }
    for (long l1 = paramWealthGodInfo.jdField_c_of_type_Long / 1000L + paramWealthGodInfo.jdField_b_of_type_Int - l1;; l1 = 0L) {
      return Math.max(0L, l1);
    }
  }
  
  private String a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig.curfewWarning.trim();
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "<font color=#000000>宵禁模式文案</font>";
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private String a(long paramLong)
  {
    Object localObject3 = null;
    Object localObject1 = new Date();
    ((Date)localObject1).setTime(paramLong);
    String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format((Date)localObject1);
    localObject1 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig != null) {}
    try
    {
      localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig.noBeginTips.trim(), new Object[] { str });
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = String.format("<font color=#000000>财神将在</font><font color=#ffa500>%s</font><font color=#000000>派红包</font>", new Object[] { str });
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    i();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapSplashView", 4, "adjustWealthGodSize width:" + paramInt1 + "  height:" + paramInt2);
    }
    FrameLayout.LayoutParams localLayoutParams;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f1 = paramInt2 * 1.0F / paramInt1 * 750.0F / 1334.0F;
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapSplashView", 4, "adjustWealthGodSize hwRatio=" + f1 + "  mLastHwRatio=" + this.jdField_a_of_type_Float);
      }
      if ((f1 > 0.0F) && (f1 < 1.0F) && (Math.abs(this.jdField_a_of_type_Float - f1) >= 0.1F))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("ARMapSplashView", 4, "adjustWealthGodSize real in");
        }
        this.jdField_a_of_type_Float = f1;
        paramInt1 = (int)(getResources().getDimensionPixelSize(2131560217) * f1);
        this.h = ((int)(getResources().getDimensionPixelSize(2131560219) * f1));
        this.i = ((int)(getResources().getDimensionPixelSize(2131560220) * f1));
        this.j = ((int)(getResources().getDimensionPixelSize(2131560221) * f1));
        this.k = ((int)(getResources().getDimensionPixelSize(2131560222) * f1));
        this.l = ((int)(getResources().getDimensionPixelSize(2131560223) * f1));
        this.m = ((int)(getResources().getDimensionPixelSize(2131560224) * f1));
        this.n = ((int)(getResources().getDimensionPixelSize(2131560225) * f1));
        this.o = ((int)(getResources().getDimensionPixelSize(2131560226) * f1));
        paramInt2 = (int)(f1 * getResources().getDimensionPixelSize(2131560227));
        if (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView != null)
        {
          localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.getLayoutParams();
          localLayoutParams.height = paramInt1;
          localLayoutParams.width = paramInt1;
          localLayoutParams.topMargin = 0;
          this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setLayoutParams(localLayoutParams);
          if (this.jdField_e_of_type_Int != 1) {
            break label443;
          }
          this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setPadding(this.l, this.m, this.n, this.o);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView != null)
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.getLayoutParams();
        localLayoutParams.topMargin = paramInt2;
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setLayoutParams(localLayoutParams);
      }
      return;
      label443:
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setPadding(this.h, this.i, this.j, this.k);
    }
  }
  
  private String b()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig.specialLoadingPageWording.trim();
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "<font color=#000000>特殊地区文案</font>";
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private String b(long paramLong)
  {
    Object localObject3 = null;
    Object localObject1 = new Date();
    ((Date)localObject1).setTime(1000L * paramLong);
    String str = new SimpleDateFormat("mm:ss", Locale.getDefault()).format((Date)localObject1);
    localObject1 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig != null) {}
    try
    {
      localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig.countdownTips.trim(), new Object[] { str });
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = String.format("<font color=#000000>财神即将派红包</font><br><font color=#000000>还需等待</font><font color=#ff0000>%s</font>", new Object[] { str });
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private String c()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig.processTips.trim();
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "<font color=#ff0000>财神正在派红包</font>";
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      if ((paramBoolean) && (this.jdField_b_of_type_Float >= 0.3F)) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
  }
  
  private String d()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig.endTips.trim();
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "<font color=#ff0000>四处走一走，<br>发现惊喜。</font>";
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, String.format("updateSplashMode mSplashMode=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
        return;
      }
    } while (this.jdField_b_of_type_Int != 0);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, String.format("updateLoadStatus mLoadStatus=%s mLoadFailType=%s", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int) }));
    }
    if (this.jdField_c_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(null);
    }
    do
    {
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131432052);
        return;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131432053);
        return;
      }
    } while (this.jdField_c_of_type_Int != 3);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131432054);
      return;
    case 1: 
    case 4: 
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131432055);
      p();
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131432056);
  }
  
  private void i()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, String.format("updateUIState mUIState=%s mIsSpecialArea=%s mWealthGodInfo=%s", new Object[] { Integer.valueOf(this.jdField_f_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo }));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    Object localObject1;
    int i5;
    int i4;
    int i3;
    int i2;
    int i1;
    int i7;
    int i8;
    int i6;
    boolean bool1;
    if ((this.jdField_f_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo == null))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(" ");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(" ");
      this.jdField_c_of_type_AndroidWidgetTextView.setText(" ");
      localObject1 = d();
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml((String)localObject1));
      i5 = 2130842261;
      i4 = 2131432050;
      i3 = 2131493738;
      i2 = 2130842252;
      i1 = 2;
      i7 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.getVisibility();
      i8 = this.jdField_b_of_type_AndroidViewView.getVisibility();
      i6 = i1;
      bool1 = bool2;
      if (this.jdField_f_of_type_Int != 2)
      {
        i6 = i1;
        bool1 = bool2;
        if (this.jdField_f_of_type_Int != 3)
        {
          i6 = i1;
          bool1 = bool2;
          if (this.jdField_g_of_type_Int == 1)
          {
            if (StringUtil.a(this.jdField_c_of_type_JavaLangString)) {
              break label1175;
            }
            this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
            this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
            label284:
            if (StringUtil.a(this.jdField_b_of_type_JavaLangString)) {
              break label1187;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            label313:
            if (StringUtil.a(this.jdField_a_of_type_JavaLangString)) {
              break label1198;
            }
            this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
            label342:
            this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
              break label1210;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        bool1 = true;
        i6 = 2;
        if (!bool1)
        {
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(i7);
          this.jdField_b_of_type_AndroidViewView.setVisibility(i8);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ARMapSplashView", 2, "mFromWeb=" + this.jdField_g_of_type_Int + " lbs=" + bool1 + " UI=" + this.jdField_f_of_type_Int + " Det=" + this.jdField_c_of_type_JavaLangString + " Nam=" + this.jdField_b_of_type_JavaLangString + " Loc=" + this.jdField_a_of_type_JavaLangString);
        }
        localObject1 = getResources().getDrawable(i5);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject1);
        localObject1 = getResources().getColorStateList(i3);
        this.jdField_a_of_type_AndroidWidgetButton.setText(i4);
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor((ColorStateList)localObject1);
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(i2);
        setWealthGodType(i6);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        Drawable localDrawable = getResources().getDrawable(2130903050);
        localObject1 = null;
        try
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.e)) {
            localObject1 = SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.e, 0);
          }
          Object localObject2 = localObject1;
          if (localObject1 == null)
          {
            i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131560189);
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i1;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i1;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
            localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
            localObject1 = ((URLDrawable)localObject2).getFileInLocal();
            if ((localObject1 == null) || (!((File)localObject1).exists())) {
              break label870;
            }
            this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.e = ((File)localObject1).getAbsolutePath();
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_JavaLangString);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_JavaLangString);
            this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_b_of_type_JavaLangString);
            if (this.jdField_f_of_type_Int != 2) {
              break label900;
            }
            localObject1 = a();
            this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml((String)localObject1));
            this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            i5 = 2130842261;
            i4 = 2131432050;
            i3 = 2131493738;
            i2 = 2130842252;
            i1 = 0;
            break;
            label870:
            ((URLDrawable)localObject2).setURLDrawableListener(new abbt(this));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localDrawable);
          }
          label900:
          if (this.jdField_f_of_type_Int == 3)
          {
            this.jdField_b_of_type_AndroidViewView.setVisibility(4);
            str = b();
            this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
            i5 = 2130842261;
            i4 = 2131432050;
            i3 = 2131493738;
            i2 = 2130842252;
            i1 = 2;
            break;
          }
          if (this.jdField_f_of_type_Int == 4)
          {
            str = a(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long);
            this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
            if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_a_of_type_Int == 0) {
              this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
            }
            i5 = 2130842261;
            i4 = 2131432050;
            i3 = 2131493738;
            i2 = 2130842252;
            i1 = 2;
            break;
          }
          if (this.jdField_f_of_type_Int == 5)
          {
            str = b(this.jdField_a_of_type_Long);
            this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
            i5 = 2130842262;
            i4 = 2131432051;
            i3 = 2131494117;
            i2 = 2130842256;
            i1 = 1;
            break;
          }
          if (this.jdField_f_of_type_Int == 6)
          {
            str = c();
            this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
            i5 = 2130842262;
            i4 = 2131432051;
            i3 = 2131494117;
            i2 = 2130842256;
            i1 = 1;
            break;
          }
          String str = d();
          this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
          i5 = 2130842261;
          i4 = 2131432050;
          i3 = 2131493738;
          i2 = 2130842252;
          i1 = 2;
        }
      }
      break;
      label1175:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      break label284;
      label1187:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break label313;
      label1198:
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      break label342;
      label1210:
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView = ((ARMapSplashBgView)findViewById(2131369697));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369700);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369702));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131369703);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369705));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369706));
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView = ((ARMapSplashInfoView)findViewById(2131369707));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369710));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131369711);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369712));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369713));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369714));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369709));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369708));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    setClickable(true);
    setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView = ((SdCardImageAnimView)findViewById(2131369698));
    this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.bringToFront();
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131369699));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(2131438777);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#0f5371"));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#ffffff"));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(2.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 18.0F);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131560228);
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      this.jdField_a_of_type_Int += ImmersiveUtils.a(getContext());
    }
    this.h = getResources().getDimensionPixelSize(2131560219);
    this.i = getResources().getDimensionPixelSize(2131560220);
    this.j = getResources().getDimensionPixelSize(2131560221);
    this.k = getResources().getDimensionPixelSize(2131560222);
    this.l = getResources().getDimensionPixelSize(2131560223);
    this.m = getResources().getDimensionPixelSize(2131560224);
    this.n = getResources().getDimensionPixelSize(2131560225);
    this.o = getResources().getDimensionPixelSize(2131560226);
  }
  
  private void k()
  {
    IntentFilter localIntentFilter;
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new abbv(this);
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.armap.ACTION_START_ARMAP_LOADING_COMPLETED");
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ARMapSplashView", 1, "registerBroadcastReceiver register receiver fail!");
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener.n();
    }
  }
  
  private void n()
  {
    this.jdField_b_of_type_Long -= 1L;
    String str;
    if (this.jdField_b_of_type_Long > 0L)
    {
      str = b(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener.a(this.jdField_b_of_type_Long);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      str = c();
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
      this.jdField_f_of_type_Int = 6;
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, "checkUIState");
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, this.jdField_a_of_type_Boolean) != this.jdField_f_of_type_Int)
    {
      setWealthGodInfo(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener.c(this.jdField_f_of_type_Int);
      }
    }
    long l2 = -1L;
    Object localObject = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig);
    if (localObject != null) {
      l2 = ((ArMapUtil.CurfewResInfo)localObject).jdField_a_of_type_Long;
    }
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    long l1;
    if (this.jdField_f_of_type_Int == 4)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long - l3;
      if (l2 >= 0L) {
        l1 = Math.min(l2, l1);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapSplashView", 2, String.format("checkUIState nextCheckDelay=%s", new Object[] { Long.valueOf(l1) }));
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if (l1 >= 0L) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, l1);
      }
      return;
      continue;
      if ((this.jdField_f_of_type_Int == 5) || (this.jdField_f_of_type_Int == 6))
      {
        l1 = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_Long - l3;
        if (l2 >= 0L) {
          l1 = Math.min(l2, l1);
        }
      }
      else
      {
        l1 = l2;
        if (this.jdField_f_of_type_Int == 7)
        {
          l1 = l2;
          if (l3 < this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long)
          {
            localObject = Calendar.getInstance();
            ((Calendar)localObject).setTimeInMillis(l3);
            ((Calendar)localObject).set(11, 23);
            ((Calendar)localObject).set(12, 59);
            ((Calendar)localObject).set(13, 59);
            ((Calendar)localObject).set(14, 999);
            l1 = ((Calendar)localObject).getTimeInMillis() - l3;
            if (l2 >= 0L) {
              l1 = Math.min(l2, l1);
            }
          }
        }
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130903050);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("QQ");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(" ");
    this.jdField_c_of_type_AndroidWidgetTextView.setText(" ");
    String str = d();
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  @TargetApi(11)
  public void a(ArMapInterface paramArMapInterface)
  {
    int i1 = 0;
    ArrayList localArrayList;
    if ((this.jdField_e_of_type_Int == 0) && (this.p != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.a();
      }
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      paramArMapInterface = ((ARMapManager)paramArMapInterface.getManager(209)).c();
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < 20)
      {
        if (new File(paramArMapInterface + "/sleep" + i1 + ".png").exists()) {
          localArrayList.add(paramArMapInterface + "/sleep" + i1 + ".png");
        }
        i1 += 1;
      }
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setAnimationData(localArrayList, true);
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setFPS(12);
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setDefaultImg();
      }
      this.p = 0;
      if (QLog.isDevelopLevel()) {
        QLog.i("ARMapSplashView", 4, "checkLoadAnimData WEALTH_GOD_TYPE_SLEEP dir=" + paramArMapInterface + " paths.size=" + localArrayList.size());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_e_of_type_Int != 1) || (this.p == 1)) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.a();
          }
          if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
          {
            this.jdField_c_of_type_Float = getResources().getDisplayMetrics().density;
            this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 9000 });
            this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
            this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
            this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
            this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(9000);
            this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new abbu(this));
          }
          paramArMapInterface = ((ARMapManager)paramArMapInterface.getManager(209)).c();
          localArrayList = new ArrayList();
          while (i1 < 15)
          {
            if (new File(paramArMapInterface + "/work" + i1 + ".png").exists()) {
              localArrayList.add(paramArMapInterface + "/work" + i1 + ".png");
            }
            i1 += 1;
          }
          if (localArrayList.size() > 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setAnimationData(localArrayList, true);
            this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setFPS(15);
            this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setDefaultImg();
          }
          this.p = 1;
        } while (!QLog.isDevelopLevel());
        QLog.i("ARMapSplashView", 4, "checkLoadAnimData WEALTH_GOD_TYPE_ACTIVITY dir=" + paramArMapInterface + " paths.size=" + localArrayList.size());
        return;
      } while ((this.jdField_e_of_type_Int != 2) || (this.p == 2));
      if (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.a();
      }
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      paramArMapInterface = ((ARMapManager)paramArMapInterface.getManager(209)).c();
      localArrayList = new ArrayList();
      i1 = 0;
      while (i1 < 15)
      {
        if (new File(paramArMapInterface + "/baoxiang" + i1 + ".png").exists()) {
          localArrayList.add(paramArMapInterface + "/baoxiang" + i1 + ".png");
        }
        i1 += 1;
      }
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setAnimationData(localArrayList, true);
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setFPS(15);
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setDefaultImg();
      }
      this.p = 2;
    } while (!QLog.isDevelopLevel());
    QLog.i("ARMapSplashView", 4, "checkLoadAnimData WEALTH_GOD_TYPE_NONE_ACTIVITY dir=" + paramArMapInterface + " paths.size=" + localArrayList.size());
  }
  
  public void a(ARMapSplashView.ARMapLoadingLaunchListener paramARMapLoadingLaunchListener)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapLoadingLaunchListener = paramARMapLoadingLaunchListener;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapLoadingLaunchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapLoadingLaunchListener.a();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = true;
    if ((this.jdField_b_of_type_Int == 1) && (paramBoolean)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      c(paramBoolean);
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
  
  @TargetApi(11)
  public void b(ArMapInterface paramArMapInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapSplashView", 4, "startRedPacketAnimation app:" + paramArMapInterface + " mStopStored:" + this.jdField_d_of_type_Boolean);
    }
    if (paramArMapInterface == null) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
      } while (this.jdField_d_of_type_Boolean);
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.a != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.a.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.a.c();
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.a.b();
      }
      a(paramArMapInterface);
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.a();
    } while ((this.jdField_e_of_type_Int != 1) || (this.jdField_a_of_type_AndroidAnimationValueAnimator == null));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  public void b(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ARMapSplashView", 4, "pauseRedPacketAnimation store:" + paramBoolean);
    }
    if (paramBoolean) {
      this.jdField_d_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.a != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.a.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.a.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.a();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = null;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    String str = b(this.jdField_b_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashInfoView.setText(Html.fromHtml(str));
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, "startCheckUIState");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 500L);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapSplashView", 2, "stopCheckUIState");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    k();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    m();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    l();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = paramInt4 - paramInt2;
    paramInt4 = this.jdField_a_of_type_AndroidViewView.getLeft();
    int i1 = this.jdField_a_of_type_AndroidViewView.getRight();
    int i2 = (int)(paramInt2 * 0.48F);
    int i3 = this.jdField_a_of_type_AndroidViewView.getHeight();
    this.jdField_a_of_type_AndroidViewView.layout(paramInt4, i2, i1, i3 + i2);
    paramInt4 = this.jdField_d_of_type_AndroidWidgetTextView.getLeft();
    i1 = this.jdField_d_of_type_AndroidWidgetTextView.getRight();
    i2 = (int)(paramInt2 * 0.65F);
    i3 = this.jdField_d_of_type_AndroidWidgetTextView.getHeight();
    this.jdField_d_of_type_AndroidWidgetTextView.layout(paramInt4, i2, i1, i3 + i2);
    a(paramInt3 - paramInt1, paramInt2);
  }
  
  public void setARMapConfig(ARMapConfig paramARMapConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig = paramARMapConfig;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig$WealthGodConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig;
    }
  }
  
  public void setCompanyToDefaultIcon()
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130903050);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void setLoadStatus(int paramInt)
  {
    setLoadStatus(paramInt, 0);
  }
  
  public void setLoadStatus(int paramInt1, int paramInt2)
  {
    if ((this.jdField_c_of_type_Int != paramInt1) || (this.jdField_d_of_type_Int != paramInt2))
    {
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt2;
      h();
    }
  }
  
  public void setLocationText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setNickName(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setProgress(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
  }
  
  public void setProgressMax(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(paramInt);
    }
  }
  
  public void setRedPackDetail(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setSplashListener(ARMapSplashView.ARMapSplashListener paramARMapSplashListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashView$ARMapSplashListener = paramARMapSplashListener;
  }
  
  public void setSplashMode(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      g();
      if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 2)) {
        break label50;
      }
    }
    label50:
    for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.setLoadDrawableAsync(this.jdField_b_of_type_Boolean);
      return;
    }
  }
  
  public void setWealthGodInfo(WealthGodInfo paramWealthGodInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo = paramWealthGodInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i1 = a(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo, this.jdField_a_of_type_Boolean);
    if (i1 == 5) {}
    for (this.jdField_a_of_type_Long = a(this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo);; this.jdField_a_of_type_Long = 0L)
    {
      a(i1);
      return;
    }
  }
  
  @TargetApi(11)
  public void setWealthGodOffset(float paramFloat)
  {
    paramFloat = Math.max(Math.min(paramFloat, 1.0F), 0.0F);
    if (paramFloat == this.jdField_b_of_type_Float) {}
    do
    {
      float f1;
      do
      {
        return;
        this.jdField_b_of_type_Float = paramFloat;
        f1 = this.jdField_a_of_type_Int * paramFloat * -1.0F;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView != null) {
          this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setTranslationY(f1);
        }
      } while (!this.jdField_c_of_type_Boolean);
      if (paramFloat > 0.3F)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.getVisibility() != 0) {
          this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTranslationY(f1);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.getVisibility() != 0);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
  }
  
  public void setWealthGodType(int paramInt)
  {
    int i1;
    String str;
    if (this.jdField_e_of_type_Int != paramInt)
    {
      i1 = 1;
      this.jdField_e_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapSplashBgView.setWealthGodType(this.jdField_e_of_type_Int);
      }
      if (this.jdField_e_of_type_Int != 0) {
        break label136;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setPadding(this.h, this.i, this.j, this.k);
      str = "KEY_SPLASH_BG_WEALTH_GOD_SLEEP";
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(2131438778);
    }
    for (;;)
    {
      if ((i1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface != null))
      {
        ArMapInterface localArMapInterface = this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
        b(false);
        b(localArMapInterface);
      }
      if (TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setBackgroundDrawable(null);
        return;
        i1 = 0;
        break;
        label136:
        if (this.jdField_e_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setPadding(this.l, this.m, this.n, this.o);
          str = "KEY_SPLASH_BG_WEALTH_GOD_WORK";
          this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(2131438777);
          continue;
        }
        if (this.jdField_e_of_type_Int != 2) {
          break label249;
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView.setPadding(this.h, this.i, this.j, this.k);
        str = "KEY_SPLASH_BG_WEALTH_GOD_BAOXIANG";
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(2131438778);
        continue;
      }
      SplashBitmapUtils.a(this.jdField_a_of_type_AndroidContentContext, str, this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView, this.jdField_b_of_type_Boolean);
      return;
      label249:
      str = null;
    }
  }
  
  public void setWebKey(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapSplashView
 * JD-Core Version:    0.7.0.1
 */