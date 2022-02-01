package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.qqsettingme.ICardCatcher;
import com.tencent.mobileqq.activity.qqsettingme.IQQSettingMeProcessor;
import com.tencent.mobileqq.activity.qqsettingme.ISuperMemberDataCatcher;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeItemData;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.mobileqq.activity.qqsettingme.api.IAvatarLayoutApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IFaceDrawableApi;
import com.tencent.mobileqq.activity.qqsettingme.api.ILoveZoneRedTouchApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IQVipMedalViewApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeUtilApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeAvatarRedTouchBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeAvatarViewBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDailyBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDocumentBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeFileBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeKingCardBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeLevelAndMedalBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeMiniGameBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeNicknameBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMePrettyNumBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeProfileBubbleBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeRichStatusBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSettingBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeShoppingBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSignatureBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSuperMemberPayButtonBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeWeatherBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Title;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigBean;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.FixedBounceScrollView;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.BitmapUtil;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.redInfo.RedInfo;

public class QQSettingMe
  implements View.OnClickListener, View.OnTouchListener
{
  public static int a;
  private static final HashMap<String, QQSettingMeBizBean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private static volatile boolean jdField_b_of_type_Boolean;
  private long jdField_a_of_type_Long;
  public final View a;
  public ViewGroup a;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private final QQSettingMeViewModel jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel;
  private final QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private final FixedBounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView;
  private final RedDotTextView jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public volatile boolean a;
  private int jdField_b_of_type_Int;
  public final View b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private final int jdField_c_of_type_Int;
  private final View jdField_c_of_type_AndroidViewView;
  private final ImageView jdField_c_of_type_AndroidWidgetImageView;
  private final LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private final TextView jdField_c_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private boolean jdField_c_of_type_Boolean;
  private final View jdField_d_of_type_AndroidViewView;
  private final ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_d_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private boolean jdField_d_of_type_Boolean;
  private final View jdField_e_of_type_AndroidViewView;
  private final ImageView jdField_e_of_type_AndroidWidgetImageView;
  private final TextView jdField_e_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private boolean jdField_e_of_type_Boolean = false;
  private final View jdField_f_of_type_AndroidViewView;
  private final ImageView jdField_f_of_type_AndroidWidgetImageView;
  private final TextView jdField_f_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_f_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private final View jdField_g_of_type_AndroidViewView;
  private final ImageView jdField_g_of_type_AndroidWidgetImageView;
  private final TextView jdField_g_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_g_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private final View jdField_h_of_type_AndroidViewView;
  private final ImageView jdField_h_of_type_AndroidWidgetImageView;
  private final TextView jdField_h_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_h_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private final View jdField_i_of_type_AndroidViewView;
  private final TextView jdField_i_of_type_AndroidWidgetTextView;
  private final RedTouch jdField_i_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private final View jdField_j_of_type_AndroidViewView;
  private final TextView jdField_j_of_type_AndroidWidgetTextView;
  private final View jdField_k_of_type_AndroidViewView;
  private final TextView jdField_k_of_type_AndroidWidgetTextView;
  private View l;
  private View m;
  private final View n;
  private final View o;
  private final View p;
  
  @TargetApi(11)
  public QQSettingMe(QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->QQSettingMe construct!");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    paramViewGroup = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel = ((QQSettingMeViewModel)ViewModelProviderHelper.a(paramViewGroup, QQSettingMeViewModel.a).get(QQSettingMeViewModel.class));
    paramViewGroup.getLifecycle().addObserver(new QQSettingMe.1(this));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365960);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_AndroidViewView.setContentDescription(HardCodeUtil.a(2131710708));
    }
    this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365958);
    this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365957);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131365956));
    ((IAvatarLayoutApi)QRoute.api(IAvatarLayoutApi.class)).putAvatar(this.jdField_e_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetImageView, false);
    paramViewGroup = paramAppRuntime.getCurrentAccountUin();
    Object localObject;
    if ((paramViewGroup != null) && (paramViewGroup.length() != 0))
    {
      localObject = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getBitmapFromCache(paramAppRuntime, paramViewGroup, 0, true);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840321);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840321);
    }
    this.jdField_f_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365975);
    this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramQBaseActivity, this.jdField_f_of_type_AndroidViewView).b(8388661).a();
    this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramQBaseActivity, this.jdField_d_of_type_AndroidViewView).b(8388661).a();
    o();
    this.jdField_d_of_type_AndroidViewView.setVisibility(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getStrokeVisible(paramViewGroup, paramAppRuntime));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365967));
    if (QQTheme.a()) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
    }
    this.jdField_c_of_type_AndroidViewView.findViewById(2131365965).setOnClickListener(this);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298519);
    this.jdField_b_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(45.0F));
    this.jdField_c_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i1 - ScreenUtil.dip2px(20.0F));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365964));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365968));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365976));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365977));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365969);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramQBaseActivity, this.jdField_i_of_type_AndroidViewView).b(8388661).a(12).e(1).d(1).a();
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365970));
    this.jdField_d_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramQBaseActivity, this.jdField_b_of_type_AndroidWidgetTextView).b(8388661).a(12).e(0).d(1).a();
    this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365966);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365962);
    this.jdField_h_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131365963);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365949));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365948));
    if (ImmersiveUtils.isSupporImmersive() == 0)
    {
      paramViewGroup = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramViewGroup.topMargin = (ScreenUtil.dip2px(35.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext()));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramViewGroup);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
    this.jdField_h_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365947)).b(8388661).a();
    this.jdField_j_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365973);
    this.jdField_f_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_j_of_type_AndroidViewView).c(10).b(8388627).a();
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_j_of_type_AndroidViewView.setOnTouchListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365911));
    paramViewGroup = (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365910);
    if (ImmersiveUtils.isSupporImmersive() == 0)
    {
      localObject = (ViewGroup.MarginLayoutParams)paramViewGroup.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (ScreenUtil.dip2px(29.0F) - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext()));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Change backWrapper topMargin=");
        localStringBuilder.append(((ViewGroup.MarginLayoutParams)localObject).topMargin);
        QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
      }
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365939));
    this.jdField_g_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(paramQBaseActivity, this.jdField_f_of_type_AndroidWidgetImageView).b(8388661).a(20).e(1).d(1).a();
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView = ((FixedBounceScrollView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365926));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setDamping(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setBounceDelay(600L);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.setmCustomTopFadingEdgeScale(0.675F);
    paramViewGroup = ((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).getCurrentThemeInfo();
    paramQBaseActivity = paramViewGroup.getString("themeId");
    boolean bool;
    if ((!TextUtils.isEmpty(paramQBaseActivity)) && (!"1000".equals(paramQBaseActivity)) && (!"1103".equals(paramQBaseActivity))) {
      bool = false;
    } else {
      bool = true;
    }
    this.jdField_d_of_type_Boolean = bool;
    if (this.jdField_d_of_type_Boolean) {
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166488);
    } else {
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166489);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "QQSettingMe_init, color=", Integer.valueOf(i1), ",themeId = ", paramQBaseActivity, ", enginePath=", paramViewGroup.getString("themePath") });
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.findViewById(2131365924));
    paramViewGroup = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), ScreenUtil.dip2px(14.0F), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getPaddingBottom());
    this.jdField_k_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365925);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
    if ((!TextUtils.isEmpty(paramQBaseActivity)) && (!"1000".equals(paramQBaseActivity))) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
    } else {
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    }
    this.n = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365941);
    this.n.setOnClickListener(this);
    this.n.setOnTouchListener(this);
    AccessibilityUtil.a(this.n, HardCodeUtil.a(2131710702), Button.class.getName());
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365944));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365942));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView = ((RedDotTextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365943));
    this.jdField_i_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView).a();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365928);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(this);
    AccessibilityUtil.a(this.jdField_b_of_type_AndroidViewView, HardCodeUtil.a(2131710685), Button.class.getName());
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365930));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365929));
    this.o = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365952);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365953));
    this.o.setOnClickListener(this);
    this.o.setOnTouchListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365980));
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnTouchListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365981));
    this.p = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365982);
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365983));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365984));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365979));
    if (!SimpleUIUtil.a())
    {
      this.jdField_h_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_i_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      this.jdField_j_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    }
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsDefault(paramAppRuntime, false, null))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(-6709582);
    }
    else
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getColor(2131166488));
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getColor(2131166488));
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getColor(2131166488));
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130846269);
      this.jdField_h_of_type_AndroidWidgetImageView.setImageResource(2130846244);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(i1);
    }
    j();
  }
  
  private int a(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    float f2 = ((Resources)localObject).getDimension(2131298516);
    float f3 = ((Resources)localObject).getDimension(2131298500) + ((Resources)localObject).getDimension(2131298504) + ((Resources)localObject).getDimension(2131298508) + ((Resources)localObject).getDimension(2131298511) + ((Resources)localObject).getDimension(2131298519);
    float f1 = f3;
    if (paramQQSettingMeLevelAndMedalBean.g) {
      f1 = f3 + Utils.a(42.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()) + ((Resources)localObject).getDimension(2131298518);
    }
    f3 = localDisplayMetrics.widthPixels - f1 - paramQQSettingMeLevelAndMedalBean.jdField_c_of_type_Int;
    f1 = f2;
    if (f2 <= 1.0F) {
      f1 = 1.0F;
    }
    int i1 = (int)Math.floor(f3 / f1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resizeQQLevelIconSize width=");
      ((StringBuilder)localObject).append(localDisplayMetrics.widthPixels);
      ((StringBuilder)localObject).append(",iconSize=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(",vipSize=");
      ((StringBuilder)localObject).append(paramQQSettingMeLevelAndMedalBean.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append(",space=");
      ((StringBuilder)localObject).append(f3);
      ((StringBuilder)localObject).append(",maxIconSize=");
      ((StringBuilder)localObject).append(i1);
      QLog.i("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  public static View a(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.a() != null)) {
      return localQQSettingMeBizBean.a().a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getItemView, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  public static QQSettingMeBizBean a(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.a() != null)) {
      return localQQSettingMeBizBean;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getBizBean, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  private RedTouchTextView a(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.a() != null)) {
      return localQQSettingMeBizBean.a().a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getItemRedText, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  public static RedTouch a(String paramString)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((localQQSettingMeBizBean != null) && (localQQSettingMeBizBean.a() != null)) {
      return localQQSettingMeBizBean.a().a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "getItemRedTouch, bizId:", paramString, ", return null" });
    }
    return null;
  }
  
  private void a(URLImageView paramURLImageView, QQSettingMeBizBean paramQQSettingMeBizBean)
  {
    if (this.jdField_d_of_type_Boolean) {
      paramQQSettingMeBizBean = paramQQSettingMeBizBean.c();
    } else {
      paramQQSettingMeBizBean = paramQQSettingMeBizBean.d();
    }
    a(paramURLImageView, paramQQSettingMeBizBean);
  }
  
  private void a(URLImageView paramURLImageView, String paramString)
  {
    if (!URLUtil.a(paramString)) {
      try
      {
        paramURLImageView.setImageResource(Integer.parseInt(paramString));
        return;
      }
      catch (Exception paramURLImageView)
      {
        QLog.e("QQSettingRedesign", 1, new Object[] { "setURLDrawableForMenu, ", paramString, ", ", paramURLImageView });
        return;
      }
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mRequestWidth = paramURLImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramURLImageView.getWidth();
    paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  public static void a(String paramString, int paramInt)
  {
    jdField_b_of_type_JavaUtilHashMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void a(String paramString, boolean paramBoolean1, long paramLong, boolean paramBoolean2, int paramInt)
  {
    if (SimpleUIUtil.a())
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      return;
    }
    boolean bool = this.jdField_e_of_type_Boolean;
    int i1 = 0;
    if ((!bool) && (!paramBoolean1) && (paramBoolean2))
    {
      ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setPlayAnimatinDelay(this.jdField_a_of_type_MqqAppAppRuntime);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setDrawable(this.jdField_a_of_type_MqqAppAppRuntime, paramLong, this.jdField_a_of_type_ComTencentImageURLImageView, paramString, paramInt);
      QLog.d("drawer_report", 1, "Avatar pendant exposure");
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "AvatarPendant", "choutishow", 0, 0, "", "", "", "");
      paramInt = 1;
    }
    else
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramInt = i1;
    }
    if ((paramInt != 0) && (this.jdField_e_of_type_Boolean)) {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8006728", "0X8006728", 0, 0, "", "", "", "");
    }
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private boolean a(QQSettingMeBizBean paramQQSettingMeBizBean)
  {
    boolean bool2 = true;
    if (paramQQSettingMeBizBean == null) {
      return true;
    }
    int i1;
    if ((!SimpleUIUtil.a()) && (!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && (!paramQQSettingMeBizBean.a())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((SimpleUIUtil.a()) && (!paramQQSettingMeBizBean.b())) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    int i3;
    if ((((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && (!paramQQSettingMeBizBean.c())) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    boolean bool1 = bool2;
    if (i1 == 0)
    {
      bool1 = bool2;
      if (i2 == 0)
      {
        bool1 = bool2;
        if (i3 == 0) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private void b(QQSettingMeSuperMemberPayButtonBean paramQQSettingMeSuperMemberPayButtonBean)
  {
    if ((!TextUtils.isEmpty(paramQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg.iconText)) && (!TextUtils.isEmpty(paramQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg.iconUrl)))
    {
      TextView localTextView = (TextView)a("d_vip_identity").findViewById(2131365920);
      localTextView.setOnClickListener(paramQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_AndroidViewView$OnClickListener);
      QQSettingMe.8 local8 = new QQSettingMe.8(this, paramQQSettingMeSuperMemberPayButtonBean, localTextView);
      try
      {
        paramQQSettingMeSuperMemberPayButtonBean = new URL(paramQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg.iconUrl);
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("key_density", 320);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mExtraInfo = localObject;
        localObject = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        paramQQSettingMeSuperMemberPayButtonBean = URLDrawable.getDrawable(paramQQSettingMeSuperMemberPayButtonBean, localURLDrawableOptions);
        localTextView.setBackgroundDrawable(paramQQSettingMeSuperMemberPayButtonBean);
        if (paramQQSettingMeSuperMemberPayButtonBean.getStatus() == 1)
        {
          local8.onLoadSuccessed(paramQQSettingMeSuperMemberPayButtonBean);
          return;
        }
        localTextView.setText("");
        paramQQSettingMeSuperMemberPayButtonBean.setURLDrawableListener(local8);
        if (paramQQSettingMeSuperMemberPayButtonBean.getStatus() == 2)
        {
          paramQQSettingMeSuperMemberPayButtonBean.restartDownload();
          return;
        }
      }
      catch (MalformedURLException paramQQSettingMeSuperMemberPayButtonBean)
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler showPayButton: ", paramQQSettingMeSuperMemberPayButtonBean);
      }
      return;
    }
    QLog.e("QQSettingRedesign", 1, "showPayButton: iconText or iconUrl is empty");
  }
  
  private void b(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = a(paramString);
    paramString = a(paramString);
    if (localRedTouch != null)
    {
      if (paramString == null) {
        return;
      }
      if (paramAppInfo == null)
      {
        localRedTouch.a((BusinessInfoCheckUpdate.AppInfo)null);
        paramString.setAppInfo(null);
        return;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo1 = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo1.set(paramAppInfo);
      BusinessInfoCheckUpdate.AppInfo localAppInfo2 = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo2.set(paramAppInfo);
      if ((localAppInfo2.iNewFlag.get() != 0) && (localAppInfo2.red_display_info.get() != null) && (localAppInfo2.red_display_info.red_type_info.get() != null))
      {
        Object localObject = new ArrayList(localAppInfo2.red_display_info.red_type_info.get());
        int i1 = ((ArrayList)localObject).size() - 1;
        int i3;
        for (int i2 = 0; i1 >= 0; i2 = i3)
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((ArrayList)localObject).get(i1);
          int i4 = localRedTypeInfo.red_type.get();
          if (i4 == 0) {
            ((ArrayList)localObject).remove(i1);
          }
          for (;;)
          {
            i3 = 1;
            break;
            if ((i4 == 3) && (RedTouchTextView.a(localRedTypeInfo, localAppInfo2)))
            {
              RedTouchTextView.setImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
            }
            else
            {
              i3 = i2;
              if (i4 != 15) {
                break;
              }
              i3 = i2;
              if (!RedTouchTextView.b(localRedTypeInfo, localAppInfo2)) {
                break;
              }
              RedTouchTextView.setDiffImageRedNotShowRedPoint(localRedTypeInfo, paramAppInfo);
            }
          }
          i1 -= 1;
        }
        if (((ArrayList)localObject).size() < 2) {
          ((ArrayList)localObject).clear();
        }
        localAppInfo2.red_display_info.red_type_info.set((List)localObject);
        paramAppInfo = new ArrayList();
        if (i2 != 0)
        {
          localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
          paramAppInfo.add(localObject);
        }
        localAppInfo1.red_display_info.red_type_info.set(paramAppInfo);
        localRedTouch.a(localAppInfo1);
        paramString.setAppInfo(localAppInfo2);
        return;
      }
      localRedTouch.a(localAppInfo1);
      paramString.setAppInfo(localAppInfo2);
    }
  }
  
  private void c(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateMyVipInfo svip= ");
      ((StringBuilder)localObject1).append(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(",vip=");
      ((StringBuilder)localObject1).append(paramQQSettingMeLevelAndMedalBean.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject1).append(",vipLevel=");
      ((StringBuilder)localObject1).append(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_Int);
      QLog.i("QQSettingRedesign", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = a("d_vip_identity");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131365921);
    Object localObject3 = (URLImageView)((View)localObject1).findViewById(2131365917);
    if (!paramQQSettingMeLevelAndMedalBean.jdField_e_of_type_Boolean)
    {
      ((TextView)localObject2).setText(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_JavaLangString);
      a((URLImageView)localObject3, (QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get("d_vip_identity"));
    }
    boolean bool = TextUtils.isEmpty(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_JavaLangString);
    int i1 = 0;
    if (!bool) {
      try
      {
        localObject2 = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences("vipTitleSpFile", 0).edit();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("vipTitleSpKey_");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(LocaleManager.a());
        ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_JavaLangString).commit();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("vipText = ");
          ((StringBuilder)localObject2).append(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_JavaLangString);
          QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject2).toString());
        }
      }
      catch (Exception localException)
      {
        QLog.e("QQSettingRedesign", 1, "updateMyVipInfo, exception e = ", localException);
      }
    }
    if (a(a("d_vip_identity"))) {
      i1 = 8;
    }
    ((View)localObject1).setVisibility(i1);
    if (AppSetting.jdField_d_of_type_Boolean) {
      AccessibilityUtil.a((View)localObject1, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_JavaLangString, Button.class.getName());
    }
  }
  
  private void e(String paramString)
  {
    Object localObject1;
    if (this.jdField_b_of_type_AndroidViewViewGroup == null)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.removeView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      Object localObject2 = new ViewGroup.MarginLayoutParams(-1, -2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject2);
      localFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject1);
      localObject2 = new FrameLayout(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      localFrameLayout.addView((View)localObject2, new ViewGroup.MarginLayoutParams((ViewGroup.MarginLayoutParams)localObject1));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localObject2);
      VideoReport.traversePage(this.jdField_a_of_type_ComTencentMobileqqWidgetFixedBounceScrollView);
    }
    if (this.jdField_d_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_AndroidViewViewGroup.getContext());
      ((TextView)localObject1).setText(paramString);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(1, 12.0F);
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setBackgroundResource(2130844704);
      paramString = new FrameLayout.LayoutParams(-2, -2);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1, paramString);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void f(String paramString)
  {
    if (!AppSetting.jdField_d_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null)
    {
      localStringBuilder.append("地点：");
      localStringBuilder.append(this.jdField_k_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append("，天气：");
      int i1 = -1;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case 49594: 
        if (paramString.equals("208")) {
          i1 = 7;
        }
        break;
      case 49593: 
        if (paramString.equals("207")) {
          i1 = 6;
        }
        break;
      case 49592: 
        if (paramString.equals("206")) {
          i1 = 5;
        }
        break;
      case 49591: 
        if (paramString.equals("205")) {
          i1 = 4;
        }
        break;
      case 49590: 
        if (paramString.equals("204")) {
          i1 = 3;
        }
        break;
      case 49589: 
        if (paramString.equals("203")) {
          i1 = 2;
        }
        break;
      case 49588: 
        if (paramString.equals("202")) {
          i1 = 1;
        }
        break;
      case 49587: 
        if (paramString.equals("201")) {
          i1 = 0;
        }
        break;
      }
      switch (i1)
      {
      default: 
        localStringBuilder.append("未知");
        break;
      case 7: 
        localStringBuilder.append("霾");
        break;
      case 6: 
        localStringBuilder.append("沙尘");
        break;
      case 5: 
        localStringBuilder.append("雾");
        break;
      case 4: 
        localStringBuilder.append("雪");
        break;
      case 3: 
        localStringBuilder.append("雨");
        break;
      case 2: 
        localStringBuilder.append("阴");
        break;
      case 1: 
        localStringBuilder.append("多云");
        break;
      case 0: 
        localStringBuilder.append("晴");
      }
      localStringBuilder.append("，温度：");
      localStringBuilder.append(this.jdField_h_of_type_AndroidWidgetTextView.getText());
      localStringBuilder.append("摄氏度");
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setContentDescription(localStringBuilder.toString());
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1 = (Integer)jdField_b_of_type_JavaUtilHashMap.get("d_profile_bubble");
    if (localObject1 != null)
    {
      this.l = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(((Integer)localObject1).intValue(), this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      this.l.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.l);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.i();
    int i1;
    if (this.jdField_d_of_type_Boolean) {
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166488);
    } else {
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166489);
    }
    int i4 = ScreenUtil.dip2px(2.0F);
    jdField_a_of_type_JavaUtilHashMap.clear();
    Object localObject3 = (QQSettingMeMenuConfigBean)QConfigManager.a().a(743);
    Object localObject2 = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getPlateColor("A3");
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QQTheme.a()) {
        i2 = 1996488704;
      } else {
        i2 = 0;
      }
      localObject1 = Integer.valueOf(i2);
    }
    QQSettingMeBizBean[] arrayOfQQSettingMeBizBean = ((QQSettingMeMenuConfigBean)localObject3).a();
    int i5 = arrayOfQQSettingMeBizBean.length;
    int i2 = 0;
    while (i2 < i5)
    {
      QQSettingMeBizBean localQQSettingMeBizBean = arrayOfQQSettingMeBizBean[i2];
      QQSettingMeItemData localQQSettingMeItemData = new QQSettingMeItemData();
      if (jdField_b_of_type_JavaUtilHashMap.get(localQQSettingMeBizBean.a()) != null)
      {
        localObject2 = jdField_b_of_type_JavaUtilHashMap;
        localObject3 = localQQSettingMeBizBean.a();
      }
      else
      {
        localObject2 = jdField_b_of_type_JavaUtilHashMap;
        localObject3 = "d_common";
      }
      localObject2 = (Integer)((HashMap)localObject2).get(localObject3);
      if (localObject2 != null)
      {
        localObject3 = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).inflate(((Integer)localObject2).intValue(), this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        ((View)localObject3).setFocusable(true);
        ((View)localObject3).setOnClickListener(new QQSettingMe.MenuWrapClickListener(localQQSettingMeBizBean.a(), localQQSettingMeBizBean.a(), this, null));
        URLImageView localURLImageView = (URLImageView)((View)localObject3).findViewById(2131365917);
        localURLImageView.setColorFilter(((Integer)localObject1).intValue());
        a(localURLImageView, localQQSettingMeBizBean);
        RedTouchTextView localRedTouchTextView = (RedTouchTextView)((View)localObject3).findViewById(2131365921);
        if (LocaleManager.b()) {
          localObject2 = localQQSettingMeBizBean.a().jdField_b_of_type_JavaLangString;
        } else {
          localObject2 = localQQSettingMeBizBean.a().jdField_a_of_type_JavaLangString;
        }
        localRedTouchTextView.setText((CharSequence)localObject2);
        if (!this.jdField_d_of_type_Boolean) {
          localRedTouchTextView.setTextColor(i1);
        }
        if ((SimpleUIUtil.a()) && ("2920".equals(QQTheme.a()))) {
          localRedTouchTextView.setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166487));
        }
        localObject2 = (TextView)((View)localObject3).findViewById(2131365920);
        ((IThemeLabelTextViewApi)QRoute.api(IThemeLabelTextViewApi.class)).setSupportMaskView((View)localObject2, true);
        ((TextView)localObject2).setVisibility(0);
        if (LocaleManager.b()) {
          localObject2 = localQQSettingMeBizBean.a().jdField_b_of_type_JavaLangString;
        } else {
          localObject2 = localQQSettingMeBizBean.a().jdField_a_of_type_JavaLangString;
        }
        AccessibilityUtil.a((View)localObject3, (CharSequence)localObject2, Button.class.getName());
        localURLImageView.setPadding(i4, i4, i4, i4);
        localObject2 = (LinearLayout.LayoutParams)localURLImageView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).leftMargin -= i4;
        localObject2 = (LinearLayout.LayoutParams)localRedTouchTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).leftMargin -= i4;
        int i3;
        if (a(localQQSettingMeBizBean)) {
          i3 = 8;
        } else {
          i3 = 0;
        }
        ((View)localObject3).setVisibility(i3);
        localQQSettingMeItemData.a((View)localObject3);
        localQQSettingMeItemData.a(new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localURLImageView).b(8388661).a());
        localQQSettingMeItemData.a(localRedTouchTextView);
        localQQSettingMeBizBean.a(localQQSettingMeItemData);
        jdField_a_of_type_JavaUtilHashMap.put(localQQSettingMeBizBean.a(), localQQSettingMeBizBean);
        this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a(localQQSettingMeBizBean.a());
      }
      i2 += 1;
    }
    localObject1 = a("d_lovespace");
    if (localObject1 != null) {
      this.m = ((View)localObject1).findViewById(2131365918);
    }
    localObject1 = this.m;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a();
  }
  
  private void k()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)localIterator.next();
      if (!TextUtils.isEmpty(localQQSettingMeBizBean.b()))
      {
        VideoReport.setElementId(a(localQQSettingMeBizBean.a()), localQQSettingMeBizBean.b());
        VideoReport.setElementClickPolicy(a(localQQSettingMeBizBean.a()), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(a(localQQSettingMeBizBean.a()), ExposurePolicy.REPORT_FIRST);
        VideoReport.setElementDynamicParams(a(localQQSettingMeBizBean.a()), new QQSettingMe.2(this, localQQSettingMeBizBean));
      }
    }
    VideoReport.setElementId(this.jdField_c_of_type_AndroidWidgetLinearLayout, "em_drawer_weather");
    VideoReport.setElementClickPolicy(this.jdField_c_of_type_AndroidWidgetLinearLayout, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.jdField_c_of_type_AndroidWidgetLinearLayout, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementId(this.o, "em_drawer_talent");
    VideoReport.setElementClickPolicy(this.o, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.o, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementId(this.jdField_a_of_type_AndroidWidgetLinearLayout, "em_drawer_sign_up");
    VideoReport.setElementClickPolicy(this.jdField_a_of_type_AndroidWidgetLinearLayout, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.jdField_a_of_type_AndroidWidgetLinearLayout, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementId(this.jdField_a_of_type_AndroidViewView, "em_drawer_energy_sign");
    VideoReport.setElementClickPolicy(this.jdField_a_of_type_AndroidViewView, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.jdField_a_of_type_AndroidViewView, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementId(this.jdField_b_of_type_AndroidWidgetTextView, "em_drawer_qqlevel_sign");
    VideoReport.setElementClickPolicy(this.jdField_b_of_type_AndroidWidgetTextView, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.jdField_b_of_type_AndroidWidgetTextView, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementDynamicParams(this.jdField_b_of_type_AndroidWidgetTextView, new QQSettingMe.3(this));
    VideoReport.setElementId(this.jdField_i_of_type_AndroidViewView, "em_drawer_member_sign");
    VideoReport.setElementClickPolicy(this.jdField_i_of_type_AndroidViewView, ClickPolicy.REPORT_NONE);
    VideoReport.setElementExposePolicy(this.jdField_i_of_type_AndroidViewView, ExposurePolicy.REPORT_FIRST);
    VideoReport.setElementDynamicParams(this.jdField_i_of_type_AndroidViewView, new QQSettingMe.4(this));
  }
  
  private void l()
  {
    Object localObject = a("d_vip_identity");
    if (localObject == null) {
      return;
    }
    localObject = (TextView)((View)localObject).findViewById(2131365920);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setBackgroundDrawable(null);
  }
  
  private void m()
  {
    int i3 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298519);
    int i2 = this.jdField_c_of_type_AndroidWidgetImageView.getVisibility();
    int i1 = 0;
    if (i2 == 0) {
      i1 = 0 + ScreenUtil.dip2px(53.0F);
    }
    i2 = i1;
    if (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      i2 = i1 + ScreenUtil.dip2px(35.0F);
    }
    i1 = i2;
    if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      i1 = i2 + ScreenUtil.dip2px(17.0F);
    }
    this.jdField_b_of_type_Int = (ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - i3 - ScreenUtil.dip2px(45.0F) - i1);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_b_of_type_Int);
  }
  
  private void n()
  {
    int i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDimension(2131296925);
    Object localObject = new int[2];
    this.jdField_g_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
    int i2 = this.n.getWidth();
    int i3 = this.jdField_g_of_type_AndroidWidgetImageView.getWidth();
    if ((i2 != 0) && (i3 != 0))
    {
      i1 -= (i2 - i3) / 2;
    }
    else
    {
      i1 = (int)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDimension(2131296930);
      QLog.e("QQSettingRedesign", 1, "setBottomBtnMarginLeft, but getWidth return 0");
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365912).getLayoutParams();
    if ((i1 > 0) && ((localObject instanceof RelativeLayout.LayoutParams)))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = i1;
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365912).setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBottomBtnMarginLeft, diffMargin = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void o()
  {
    if (SimpleUIUtil.a())
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch;
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(4);
    this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch;
  }
  
  public QQSettingMeViewModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel;
  }
  
  public AppRuntime a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public void a()
  {
    if ((!QQSettingMeMenuConfigBean.jdField_a_of_type_Boolean) && (((QQSettingMeMenuConfigBean)QConfigManager.a().a(743)).a())) {
      j();
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQSettingRedesign", 2, "-->onResume!");
    }
    g();
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "init: false");
      }
      n();
      VideoReport.addToDetectionWhitelist(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.b();
    jdField_b_of_type_Boolean = true;
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewViewGroup, "pg_drawer");
    HashMap localHashMap = new HashMap();
    localHashMap.put("dt_appkey", "0S200MNJT807V3GE");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewViewGroup, new PageParams(localHashMap));
    k();
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources();
    Drawable localDrawable = null;
    if (paramInt == 1)
    {
      if (this.jdField_d_of_type_Boolean) {
        localDrawable = ((Resources)localObject).getDrawable(2130846245);
      } else {
        localDrawable = ((Resources)localObject).getDrawable(2130846244);
      }
      localObject = ((Resources)localObject).getString(2131699251);
    }
    else if (paramInt == 2)
    {
      if (this.jdField_d_of_type_Boolean) {
        localDrawable = ((Resources)localObject).getDrawable(2130846245);
      } else {
        localDrawable = ((Resources)localObject).getDrawable(2130846244);
      }
      localObject = ((Resources)localObject).getString(2131699251);
    }
    else
    {
      localObject = null;
    }
    if (localDrawable != null) {
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    if (localObject != null)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.e();
  }
  
  public void a(QQSettingMeAvatarRedTouchBean paramQQSettingMeAvatarRedTouchBean)
  {
    try
    {
      if (paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    boolean bool = this.jdField_e_of_type_Boolean;
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, new Object[] { "updateHeadIcon, old:", Boolean.valueOf(bool), " new:", Boolean.valueOf(this.jdField_e_of_type_Boolean), ",profileRedTypeInfo = ", paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$RedTypeInfo, ",profileAppinfo = ", paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo });
    }
    if (bool != this.jdField_e_of_type_Boolean) {
      a(paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_JavaLangString, paramQQSettingMeAvatarRedTouchBean.jdField_b_of_type_Boolean, paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_Long, paramQQSettingMeAvatarRedTouchBean.jdField_c_of_type_Boolean, paramQQSettingMeAvatarRedTouchBean.jdField_a_of_type_Int);
    }
  }
  
  public void a(QQSettingMeAvatarViewBean paramQQSettingMeAvatarViewBean)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin();
    ((IAvatarLayoutApi)QRoute.api(IAvatarLayoutApi.class)).setFaceDrawable(this.jdField_e_of_type_AndroidViewView, (AppInterface)this.jdField_a_of_type_MqqAppAppRuntime, paramQQSettingMeAvatarViewBean.jdField_a_of_type_AndroidGraphicsDrawableDrawable, str, true, true);
    this.jdField_d_of_type_AndroidViewView.setVisibility(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getStrokeVisible(str, this.jdField_a_of_type_MqqAppAppRuntime));
    a(paramQQSettingMeAvatarViewBean.jdField_a_of_type_JavaLangString, paramQQSettingMeAvatarViewBean.jdField_a_of_type_Boolean, paramQQSettingMeAvatarViewBean.jdField_a_of_type_Long, paramQQSettingMeAvatarViewBean.jdField_b_of_type_Boolean, paramQQSettingMeAvatarViewBean.jdField_a_of_type_Int);
    if (QLog.isDevelopLevel())
    {
      paramQQSettingMeAvatarViewBean = new StringBuilder();
      paramQQSettingMeAvatarViewBean.append("updateFace, ");
      paramQQSettingMeAvatarViewBean.append(str);
      QLog.i("QQSettingRedesign", 4, paramQQSettingMeAvatarViewBean.toString());
    }
  }
  
  public void a(QQSettingMeDailyBean paramQQSettingMeDailyBean)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298519);
    int i2 = ScreenUtil.SCREEN_WIDTH;
    int i3 = ScreenUtil.dip2px(65.0F);
    int i4 = ScreenUtil.dip2px(15.0F);
    int i5 = this.jdField_f_of_type_AndroidWidgetImageView.getWidth();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130846274);
    URLImageView localURLImageView = (URLImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365946);
    Object localObject1 = localDrawable;
    if (!QQTheme.f())
    {
      Object localObject3;
      if ((!TextUtils.isEmpty(paramQQSettingMeDailyBean.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramQQSettingMeDailyBean.jdField_b_of_type_JavaLangString)))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = 56;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = 56;
        localObject3 = ((ICardCatcher)this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip")).a();
        if ((localObject3 != null) && ((((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).checkUsePersonalCard(this.jdField_a_of_type_MqqAppAppRuntime, (Card)localObject3)) || (!((Card)localObject3).isNoCover()))) {
          localObject3 = URLDrawable.getDrawable(paramQQSettingMeDailyBean.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        } else {
          localObject3 = URLDrawable.getDrawable(paramQQSettingMeDailyBean.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        }
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("use custom icon=");
          ((StringBuilder)localObject1).append(paramQQSettingMeDailyBean.jdField_a_of_type_JavaLangString);
          QLog.i("DailySignIn", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject3;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "use default icon");
        }
        localObject3 = (IThemeUtilApi)QRoute.api(IThemeUtilApi.class);
        AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
        Object localObject4 = null;
        localObject1 = localDrawable;
        if (((IThemeUtilApi)localObject3).isNowThemeIsDefault(localAppRuntime, true, null))
        {
          try
          {
            localObject3 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources(), 2130846274);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localObject3 = localObject4;
            if (QLog.isColorLevel())
            {
              QLog.d("QQSettingRedesign", 2, localOutOfMemoryError, new Object[0]);
              localObject3 = localObject4;
            }
          }
          localObject2 = localDrawable;
          if (localObject3 != null) {
            localObject2 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources(), BitmapUtil.a((Bitmap)localObject3));
          }
        }
      }
    }
    localURLImageView.setImageDrawable((Drawable)localObject2);
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setMaxWidth(i2 - i1 - i3 - (i4 + i5));
      this.jdField_c_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramQQSettingMeDailyBean.c);
    }
    else
    {
      QLog.e("QQSettingRedesign", 1, "mSignInWord===null");
    }
    this.jdField_h_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
  }
  
  public void a(QQSettingMeDocumentBean paramQQSettingMeDocumentBean)
  {
    View localView = a("d_tencent_document");
    if (localView == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeDocumentBean.jdField_a_of_type_Boolean) && (!a(a("d_tencent_document")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    if (!paramQQSettingMeDocumentBean.jdField_a_of_type_Boolean) {
      return;
    }
    TextView localTextView = (TextView)localView.findViewById(2131365921);
    if (!TextUtils.isEmpty(paramQQSettingMeDocumentBean.jdField_b_of_type_JavaLangString)) {
      localTextView.setText(paramQQSettingMeDocumentBean.jdField_b_of_type_JavaLangString);
    }
    if ((!TextUtils.isEmpty(paramQQSettingMeDocumentBean.jdField_a_of_type_JavaLangString)) && (QQTheme.e())) {
      try
      {
        a((URLImageView)localView.findViewById(2131365917), paramQQSettingMeDocumentBean.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramQQSettingMeDocumentBean)
      {
        QLog.e("QQSettingRedesign", 1, "set tencent_doc URL Drawable failed ", paramQQSettingMeDocumentBean);
      }
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800887D", "0X800887D", 0, 0, "", "", "", "");
  }
  
  public void a(QQSettingMeDynamicItemBean paramQQSettingMeDynamicItemBean)
  {
    QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get(paramQQSettingMeDynamicItemBean.jdField_a_of_type_JavaLangString);
    if (localQQSettingMeBizBean == null) {
      return;
    }
    View localView = localQQSettingMeBizBean.a();
    if (localView == null) {
      return;
    }
    TextView localTextView = (TextView)localView.findViewById(2131365921);
    if (!TextUtils.isEmpty(paramQQSettingMeDynamicItemBean.jdField_a_of_type_ComTencentMobileqqTextQQText))
    {
      localTextView.setText(paramQQSettingMeDynamicItemBean.jdField_a_of_type_ComTencentMobileqqTextQQText);
    }
    else
    {
      if (LocaleManager.b()) {
        localObject = localQQSettingMeBizBean.a().jdField_b_of_type_JavaLangString;
      } else {
        localObject = localQQSettingMeBizBean.a().jdField_a_of_type_JavaLangString;
      }
      localTextView.setText((CharSequence)localObject);
    }
    AccessibilityUtil.a(localView, localTextView.getText(), Button.class.getName());
    Object localObject = (URLImageView)localView.findViewById(2131365917);
    if (paramQQSettingMeDynamicItemBean.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      a((URLImageView)localObject, localQQSettingMeBizBean);
      return;
    }
    if (!QQTheme.f()) {
      if (paramQQSettingMeDynamicItemBean.jdField_a_of_type_ComTencentImageURLDrawable != null)
      {
        ((URLImageView)localObject).setImageDrawable(paramQQSettingMeDynamicItemBean.jdField_a_of_type_ComTencentImageURLDrawable);
        if (QQTheme.a()) {
          ((URLImageView)localObject).setColorFilter(1996488704);
        }
      }
      else
      {
        if (this.jdField_d_of_type_Boolean) {
          paramQQSettingMeDynamicItemBean = localQQSettingMeBizBean.c();
        } else {
          paramQQSettingMeDynamicItemBean = localQQSettingMeBizBean.d();
        }
        ((URLImageView)localObject).setImageResource(Integer.parseInt(paramQQSettingMeDynamicItemBean));
      }
    }
    ((URLImageView)localObject).setColorFilter(0);
  }
  
  public void a(QQSettingMeFileBean paramQQSettingMeFileBean)
  {
    if (a("d_document") == null) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i2 = 0;
    if (bool) {
      QLog.i("QQSettingRedesign", 2, String.format(Locale.CHINA, "updateFace2FaceGuide switch_hasShowed = %d_%b", new Object[] { Integer.valueOf(paramQQSettingMeFileBean.jdField_a_of_type_Int), Boolean.valueOf(paramQQSettingMeFileBean.jdField_a_of_type_Boolean) }));
    }
    int i1 = i2;
    if (paramQQSettingMeFileBean.jdField_a_of_type_Int == 1)
    {
      i1 = i2;
      if (!paramQQSettingMeFileBean.jdField_a_of_type_Boolean) {
        i1 = 1;
      }
    }
    TextView localTextView;
    if (i1 == 0)
    {
      localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        localTextView.setVisibility(8);
        return;
      }
    }
    if (i1 != 0)
    {
      localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
        return;
      }
      e(paramQQSettingMeFileBean.jdField_a_of_type_JavaLangString);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new QQSettingMe.6(this), 50L);
    }
  }
  
  public void a(QQSettingMeKingCardBean paramQQSettingMeKingCardBean)
  {
    View localView = a("d_vip_card");
    if (localView == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeKingCardBean.jdField_a_of_type_Boolean) && (!a(a("d_vip_card")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
    if (!paramQQSettingMeKingCardBean.jdField_a_of_type_Boolean) {
      return;
    }
    if (!LocaleManager.a()) {
      return;
    }
    if (!paramQQSettingMeKingCardBean.jdField_b_of_type_Boolean)
    {
      TextView localTextView = (TextView)localView.findViewById(2131365921);
      localTextView.setText(paramQQSettingMeKingCardBean.jdField_a_of_type_JavaLangString);
      localTextView.setContentDescription(paramQQSettingMeKingCardBean.jdField_a_of_type_JavaLangString);
      a((URLImageView)localView.findViewById(2131365917), (QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get("d_vip_card"));
    }
    AccessibilityUtil.a(localView, paramQQSettingMeKingCardBean.jdField_a_of_type_JavaLangString, Button.class.getName());
  }
  
  public void a(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    for (;;)
    {
      try
      {
        if ((paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null) && (this.jdField_d_of_type_AndroidWidgetImageView != null))
        {
          localObject1 = new SpannableStringBuilder();
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources();
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          if (((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).isBigVipClub(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateVipType)) {
            ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setVipExtIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_d_of_type_AndroidWidgetImageView, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateExtId);
          }
          if ((!paramQQSettingMeLevelAndMedalBean.jdField_d_of_type_Boolean) && (paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_Long == ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getQQBigMemberId()) && (paramQQSettingMeLevelAndMedalBean.jdField_c_of_type_Boolean) && (paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_Short >> 8 == 3)) {
            ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setVipExtIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_d_of_type_AndroidWidgetImageView, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.nameplateExtId);
          }
          if ((paramQQSettingMeLevelAndMedalBean.jdField_b_of_type_JavaLangString != null) && (paramQQSettingMeLevelAndMedalBean.jdField_b_of_type_Int != 0))
          {
            ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setVipCardDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources(), this.jdField_c_of_type_AndroidWidgetImageView, paramQQSettingMeLevelAndMedalBean.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(paramQQSettingMeLevelAndMedalBean.jdField_b_of_type_Int));
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131716291));
            this.jdField_c_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
            this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).headVipReport(this.jdField_a_of_type_MqqAppAppRuntime, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.uin));
          }
          else
          {
            this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(null);
          }
          m();
          if (paramQQSettingMeLevelAndMedalBean.f) {
            ((SpannableStringBuilder)localObject1).append(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).addNamePlateOfKing(this.jdField_b_of_type_AndroidWidgetTextView, (Resources)localObject2, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingGameId, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDan, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.namePlateOfKingDanDisplatSwitch));
          }
          if ((paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataMedalList != null) && (paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataMedalList.infoList.size() > 0))
          {
            ((IQVipMedalViewApi)QRoute.api(IQVipMedalViewApi.class)).setData(this.jdField_i_of_type_AndroidViewView, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataMedalList);
            this.jdField_i_of_type_AndroidViewView.setVisibility(0);
            this.jdField_g_of_type_AndroidViewView.setVisibility(0);
            this.jdField_h_of_type_AndroidViewView.setVisibility(0);
            if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsDefault(this.jdField_a_of_type_MqqAppAppRuntime, true, null)) {
              this.jdField_g_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#7bffffff"));
            } else {
              this.jdField_g_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getColor(2131166492));
            }
          }
          else
          {
            this.jdField_i_of_type_AndroidViewView.setVisibility(8);
            this.jdField_g_of_type_AndroidViewView.setVisibility(8);
            this.jdField_h_of_type_AndroidViewView.setVisibility(8);
          }
          ((SpannableStringBuilder)localObject1).append(((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).parseQQLevel((Resources)localObject2, paramQQSettingMeLevelAndMedalBean.jdField_d_of_type_Int, paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel, a(paramQQSettingMeLevelAndMedalBean)));
          ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setTextForAnimation(this.jdField_b_of_type_AndroidWidgetTextView, (SpannableStringBuilder)localObject1, TextView.BufferType.SPANNABLE);
          localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("等级：");
          ((StringBuilder)localObject2).append(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
          ((TextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
          c(paramQQSettingMeLevelAndMedalBean);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            localObject2 = new StringBuilder(this.jdField_a_of_type_AndroidWidgetTextView.getText());
            if (paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_Boolean)
            {
              localObject1 = "你是尊贵的超级会员";
            }
            else
            {
              if (!paramQQSettingMeLevelAndMedalBean.jdField_b_of_type_Boolean) {
                break label748;
              }
              localObject1 = "你是尊贵的会员";
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            if (paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel > 0)
            {
              ((StringBuilder)localObject2).append(" 等级");
              ((StringBuilder)localObject2).append(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel);
            }
            this.jdField_c_of_type_AndroidViewView.setContentDescription(((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "updateQQLevelVipView card == null");
          }
          return;
        }
      }
      catch (Throwable paramQQSettingMeLevelAndMedalBean)
      {
        paramQQSettingMeLevelAndMedalBean.printStackTrace();
      }
      return;
      label748:
      Object localObject1 = "";
    }
  }
  
  public void a(QQSettingMeMiniGameBean paramQQSettingMeMiniGameBean)
  {
    Object localObject = a("d_minigame");
    if (localObject == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeMiniGameBean.jdField_a_of_type_Int == 0) && (!a(a("d_minigame")))) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
    URLImageView localURLImageView = (URLImageView)((View)localObject).findViewById(2131365917);
    localObject = (TextView)((View)localObject).findViewById(2131365921);
    try
    {
      if ((!TextUtils.isEmpty(paramQQSettingMeMiniGameBean.jdField_a_of_type_JavaLangString)) && (QQTheme.e())) {
        a(localURLImageView, paramQQSettingMeMiniGameBean.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramQQSettingMeMiniGameBean.jdField_b_of_type_JavaLangString))
      {
        ((TextView)localObject).setText(paramQQSettingMeMiniGameBean.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    catch (Exception paramQQSettingMeMiniGameBean)
    {
      QLog.e("QQSettingRedesign", 1, "set URL Drawable failed ", paramQQSettingMeMiniGameBean);
    }
  }
  
  public void a(QQSettingMeNicknameBean paramQQSettingMeNicknameBean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()))
    {
      ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).setImageDrawableForDynamic(this.jdField_a_of_type_AndroidWidgetImageView, paramQQSettingMeNicknameBean.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_avatar").g();
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getTop() > this.jdField_f_of_type_AndroidWidgetImageView.getBottom()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_b_of_type_Int - this.jdField_f_of_type_AndroidWidgetImageView.getWidth());
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_b_of_type_Int);
    }
    if (!Utils.a(paramQQSettingMeNicknameBean.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQSettingMeNicknameBean.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from updateAccountInfo");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip").g();
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
    }
  }
  
  public void a(QQSettingMePrettyNumBean paramQQSettingMePrettyNumBean)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (!paramQQSettingMePrettyNumBean.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramQQSettingMePrettyNumBean.jdField_a_of_type_MQQLhLogoResources == null) {
      return;
    }
    if (paramQQSettingMePrettyNumBean.jdField_a_of_type_ComTencentImageURLDrawable == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramQQSettingMePrettyNumBean.jdField_a_of_type_ComTencentImageURLDrawable);
    if (paramQQSettingMePrettyNumBean.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setColorFilter(0);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new QQSettingMe.9(this));
    m();
  }
  
  public void a(QQSettingMeProfileBubbleBean paramQQSettingMeProfileBubbleBean)
  {
    if ((paramQQSettingMeProfileBubbleBean.jdField_a_of_type_Boolean) && (paramQQSettingMeProfileBubbleBean.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null))
    {
      QLog.d("QQSettingRedesign", 1, new Object[] { "updateProfileBubbleMsgView ", Integer.valueOf(paramQQSettingMeProfileBubbleBean.jdField_a_of_type_Int) });
      long l1;
      if (paramQQSettingMeProfileBubbleBean.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.has()) {
        l1 = paramQQSettingMeProfileBubbleBean.jdField_a_of_type_TencentImOidbRedInfo$RedInfo.uint64_from_uin.get();
      } else {
        l1 = 0L;
      }
      View localView1 = this.l.findViewById(2131365936);
      ImageView localImageView = (ImageView)this.l.findViewById(2131365934);
      TextView localTextView = (TextView)this.l.findViewById(2131365935);
      View localView2 = this.l.findViewById(2131365933);
      if (QQTheme.a()) {
        localView1.setBackgroundResource(2130846248);
      } else {
        localView1.setBackgroundResource(2130846247);
      }
      if (l1 == 111L)
      {
        localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130845916));
      }
      else
      {
        Drawable localDrawable = paramQQSettingMeProfileBubbleBean.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        Object localObject = (IFaceDrawableApi)QRoute.api(IFaceDrawableApi.class);
        AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l1);
        localStringBuilder.append("");
        localDrawable = ((IFaceDrawableApi)localObject).getFaceDrawable(localAppInterface, localStringBuilder.toString(), localDrawable, localDrawable);
        localObject = localImageView.getDrawable();
        ((IFaceDrawableApi)QRoute.api(IFaceDrawableApi.class)).cancelFaceDrawable(localDrawable, (Drawable)localObject);
        localImageView.setImageDrawable(localDrawable);
      }
      paramQQSettingMeProfileBubbleBean = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(2131699233, new Object[] { Integer.valueOf(paramQQSettingMeProfileBubbleBean.jdField_a_of_type_Int) });
      if (!paramQQSettingMeProfileBubbleBean.equalsIgnoreCase(localTextView.getText().toString())) {
        localTextView.setText(paramQQSettingMeProfileBubbleBean);
      }
      localView1.setContentDescription(paramQQSettingMeProfileBubbleBean);
      localView1.setOnTouchListener(new QQSettingMe.7(this, localImageView, localTextView, localView2));
      localView1.setOnClickListener(this);
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
    ((ImageView)this.l.findViewById(2131365934)).setImageDrawable(null);
  }
  
  @TargetApi(9)
  public void a(QQSettingMeRichStatusBean paramQQSettingMeRichStatusBean)
  {
    ImageView localImageView1 = (ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131365971);
    TextView localTextView = (TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131365972);
    ImageView localImageView2 = (ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131365959);
    localImageView2.setColorFilter(localTextView.getCurrentTextColor());
    localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    localTextView.setMaxWidth(this.jdField_c_of_type_Int);
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("qqsettingme_signature");
    localStringBuilder1.append(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    SharedPreferences.Editor localEditor = ((BaseApplication)localObject1).getSharedPreferences(localStringBuilder1.toString(), 0).edit();
    StringBuilder localStringBuilder2 = new StringBuilder(100);
    if ((paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (!TextUtils.isEmpty(paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText)))
    {
      localImageView1.setImageBitmap(paramQQSettingMeRichStatusBean.jdField_a_of_type_AndroidGraphicsBitmap);
      localImageView1.setVisibility(0);
      localStringBuilder2.append(paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText);
      if (!TextUtils.isEmpty(paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText)) {
        localStringBuilder2.append(paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText);
      }
      localStringBuilder2.append(' ');
      localEditor.putInt("actionId", paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId);
      localEditor.putString("actionText", paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText);
      localEditor.putString("dataText", paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText);
    }
    else
    {
      localImageView1.setBackgroundResource(0);
      localImageView1.setPadding(0, 0, 0, 0);
      localImageView1.setImageResource(2130846252);
      localImageView1.setVisibility(8);
    }
    if (paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      boolean bool = paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.hasTopic();
      Object localObject2 = null;
      localStringBuilder1 = null;
      if (bool)
      {
        if (paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.shouldShowAtHead())
        {
          localObject1 = paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicToPlainText();
          localStringBuilder2.append((String)localObject1);
          localEditor.putString("topics", (String)localObject1);
          localObject1 = localStringBuilder1;
          if (paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText != null)
          {
            localObject1 = localStringBuilder1;
            if (paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.size() > 0) {
              localObject1 = (String)paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.get(0);
            }
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localStringBuilder2.append((String)localObject1);
          }
          localEditor.putString("plainText", (String)localObject1);
        }
        if (paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.shouldShowMixing())
        {
          paramQQSettingMeRichStatusBean = paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText();
          localStringBuilder2.append(paramQQSettingMeRichStatusBean);
          localEditor.putString("plainMixTopic", paramQQSettingMeRichStatusBean);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText != null)
        {
          localObject1 = localObject2;
          if (paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.size() > 0) {
            localObject1 = (String)paramQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.get(0);
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localStringBuilder2.append((String)localObject1);
        }
        localEditor.putString("plainText", (String)localObject1);
      }
    }
    localEditor.apply();
    paramQQSettingMeRichStatusBean = localStringBuilder2.toString();
    if (TextUtils.isEmpty(paramQQSettingMeRichStatusBean))
    {
      localTextView.setText(2131699221);
      localImageView2.setVisibility(0);
    }
    else
    {
      localImageView2.setVisibility(0);
      if (DeviceInfoUtil.b())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramQQSettingMeRichStatusBean);
        ((StringBuilder)localObject1).append(" ");
        localTextView.setText(new QQText(((StringBuilder)localObject1).toString(), 1, 16));
      }
      else
      {
        localTextView.setText(new QQText(paramQQSettingMeRichStatusBean, 1, 16));
      }
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject1 = this.jdField_j_of_type_AndroidViewView;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("个性签名");
      localStringBuilder1.append(paramQQSettingMeRichStatusBean);
      ((View)localObject1).setContentDescription(localStringBuilder1.toString());
    }
    if (SimpleUIUtil.a()) {
      localImageView1.setVisibility(8);
    }
  }
  
  public void a(QQSettingMeSettingBean paramQQSettingMeSettingBean)
  {
    boolean bool2 = paramQQSettingMeSettingBean.jdField_a_of_type_Boolean;
    RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
    if (localRedDotTextView != null) {
      localRedDotTextView.a(paramQQSettingMeSettingBean.jdField_a_of_type_Boolean);
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (paramQQSettingMeSettingBean.jdField_b_of_type_Boolean)
      {
        bool2 = true;
        localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetRedDotTextView;
        bool1 = bool2;
        if (localRedDotTextView != null)
        {
          localRedDotTextView.a(true);
          bool1 = bool2;
        }
      }
    }
    if (!bool1) {
      this.jdField_i_of_type_ComTencentMobileqqTianshuUiRedTouch.c(paramQQSettingMeSettingBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    }
  }
  
  public void a(QQSettingMeShoppingBean paramQQSettingMeShoppingBean)
  {
    Object localObject1 = a("d_qq_shopping");
    if (localObject1 == null) {
      return;
    }
    int i1;
    if ((paramQQSettingMeShoppingBean.jdField_a_of_type_Boolean) && (!a(a("d_qq_shopping")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject1).setVisibility(i1);
    if (!paramQQSettingMeShoppingBean.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131365921);
    if (!TextUtils.isEmpty(paramQQSettingMeShoppingBean.jdField_a_of_type_JavaLangString)) {
      ((TextView)localObject2).setText(paramQQSettingMeShoppingBean.jdField_a_of_type_JavaLangString);
    }
    localObject1 = (URLImageView)((View)localObject1).findViewById(2131365917);
    if (!TextUtils.isEmpty(paramQQSettingMeShoppingBean.jdField_b_of_type_JavaLangString))
    {
      localObject2 = ((IVasApngUtilApi)QRoute.api(IVasApngUtilApi.class)).getApngURLDrawable(paramQQSettingMeShoppingBean.jdField_b_of_type_JavaLangString, new ColorDrawable(0), null, null);
      if (localObject2 != null) {
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateShoppingItemView:");
      ((StringBuilder)localObject1).append(paramQQSettingMeShoppingBean.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("  ");
      ((StringBuilder)localObject1).append(paramQQSettingMeShoppingBean.jdField_b_of_type_JavaLangString);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(QQSettingMeSignatureBean paramQQSettingMeSignatureBean)
  {
    ImageView localImageView = (ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131365971);
    Object localObject1 = (TextView)this.jdField_j_of_type_AndroidViewView.findViewById(2131365972);
    Object localObject2 = (ImageView)this.jdField_j_of_type_AndroidViewView.findViewById(2131365959);
    ((ImageView)localObject2).setColorFilter(((TextView)localObject1).getCurrentTextColor());
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    ((TextView)localObject1).setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    ((TextView)localObject1).setMaxWidth(this.jdField_c_of_type_Int);
    if (QLog.isColorLevel())
    {
      String str1 = paramQQSettingMeSignatureBean.jdField_a_of_type_JavaLangString;
      int i1 = paramQQSettingMeSignatureBean.jdField_a_of_type_Int;
      String str2 = paramQQSettingMeSignatureBean.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" plainText = ");
      localStringBuilder2.append(paramQQSettingMeSignatureBean.d);
      QLog.d("QQSettingRedesign", 2, new Object[] { "preLoadSignature, actionText = ", str1, " actionId = ", Integer.valueOf(i1), " dataText = ", str2, localStringBuilder2.toString() });
    }
    if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.jdField_a_of_type_JavaLangString))
    {
      localImageView.setImageBitmap(paramQQSettingMeSignatureBean.jdField_a_of_type_AndroidGraphicsBitmap);
      localImageView.setVisibility(0);
      localStringBuilder1.append(paramQQSettingMeSignatureBean.jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.jdField_b_of_type_JavaLangString)) {
        localStringBuilder1.append(paramQQSettingMeSignatureBean.jdField_b_of_type_JavaLangString);
      }
      localStringBuilder1.append(' ');
    }
    else
    {
      localImageView.setBackgroundResource(0);
      localImageView.setPadding(0, 0, 0, 0);
      localImageView.setImageResource(2130846252);
      localImageView.setVisibility(8);
    }
    if (TextUtils.isEmpty(paramQQSettingMeSignatureBean.e))
    {
      if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.c)) {
        localStringBuilder1.append(paramQQSettingMeSignatureBean.c);
      }
      if (!TextUtils.isEmpty(paramQQSettingMeSignatureBean.d)) {
        localStringBuilder1.append(paramQQSettingMeSignatureBean.d);
      }
    }
    else
    {
      localStringBuilder1.append(paramQQSettingMeSignatureBean.e);
    }
    paramQQSettingMeSignatureBean = localStringBuilder1.toString();
    if (TextUtils.isEmpty(paramQQSettingMeSignatureBean))
    {
      ((TextView)localObject1).setText(2131699221);
      ((ImageView)localObject2).setVisibility(0);
    }
    else
    {
      ((ImageView)localObject2).setVisibility(0);
      if (DeviceInfoUtil.b()) {
        ((TextView)localObject1).setText(String.format("%s ", new Object[] { paramQQSettingMeSignatureBean }));
      } else {
        ((TextView)localObject1).setText(paramQQSettingMeSignatureBean);
      }
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject1 = this.jdField_j_of_type_AndroidViewView;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("个性签名");
      ((StringBuilder)localObject2).append(paramQQSettingMeSignatureBean);
      ((View)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
    if (SimpleUIUtil.a()) {
      localImageView.setVisibility(8);
    }
  }
  
  public void a(QQSettingMeSuperMemberPayButtonBean paramQQSettingMeSuperMemberPayButtonBean)
  {
    try
    {
      if (paramQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_Boolean) {
        b(paramQQSettingMeSuperMemberPayButtonBean);
      } else {
        l();
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
      localAppInfo.set(paramQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      if ((paramQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_Boolean) && (RedTouchTextView.a(localAppInfo) != null))
      {
        paramQQSettingMeSuperMemberPayButtonBean = new ArrayList();
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        localRedTypeInfo.red_type.set(0);
        paramQQSettingMeSuperMemberPayButtonBean.add(localRedTypeInfo);
        localAppInfo.red_display_info.red_type_info.set(paramQQSettingMeSuperMemberPayButtonBean);
      }
      b("d_vip_identity", localAppInfo);
      return;
    }
    catch (Exception paramQQSettingMeSuperMemberPayButtonBean)
    {
      QLog.e("QQSettingRedesign", 1, "updateSuperMemberItemView: ", paramQQSettingMeSuperMemberPayButtonBean);
    }
  }
  
  public void a(QQSettingMeWeatherBean paramQQSettingMeWeatherBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "updateWeatherView cur_temp:", paramQQSettingMeWeatherBean.jdField_a_of_type_JavaLangString, ",cur_areainfo", paramQQSettingMeWeatherBean.jdField_b_of_type_JavaLangString, ",cur_adcode:", Integer.valueOf(paramQQSettingMeWeatherBean.jdField_a_of_type_Int), ",o_wea_code", paramQQSettingMeWeatherBean.c, ",show_flag:", Boolean.valueOf(paramQQSettingMeWeatherBean.jdField_a_of_type_Boolean) });
    }
    if (!paramQQSettingMeWeatherBean.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(false);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    if ((!TextUtils.isEmpty(paramQQSettingMeWeatherBean.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramQQSettingMeWeatherBean.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setClickable(true);
      this.jdField_h_of_type_AndroidWidgetTextView.setText(paramQQSettingMeWeatherBean.jdField_a_of_type_JavaLangString);
      localObject = paramQQSettingMeWeatherBean.jdField_b_of_type_JavaLangString.split("-");
      localTextView = this.jdField_k_of_type_AndroidWidgetTextView;
      if (localObject.length == 2) {
        localObject = localObject[1];
      } else {
        localObject = localObject[0];
      }
      localTextView.setText((CharSequence)localObject);
    }
    try
    {
      localObject = URLEncoder.encode(paramQQSettingMeWeatherBean.jdField_b_of_type_JavaLangString, "utf-8");
    }
    catch (Exception localException)
    {
      label232:
      StringBuilder localStringBuilder;
      break label232;
    }
    Object localObject = paramQQSettingMeWeatherBean.jdField_b_of_type_JavaLangString;
    TextView localTextView = this.jdField_k_of_type_AndroidWidgetTextView;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("&city=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("&adcode=");
    localStringBuilder.append(paramQQSettingMeWeatherBean.jdField_a_of_type_Int);
    localTextView.setTag(localStringBuilder.toString());
    this.jdField_j_of_type_AndroidWidgetTextView.setText("o");
    d(paramQQSettingMeWeatherBean.jdField_a_of_type_JavaLangString);
    f(paramQQSettingMeWeatherBean.c);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null) {
      this.jdField_g_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramAppInfo);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      return;
    }
    boolean bool2 = this.jdField_c_of_type_Boolean;
    boolean bool1 = false;
    if (bool2)
    {
      if ((SimpleUIUtil.a()) && (!QQTheme.a()) && (ImmersiveUtils.isSupporImmersive() != 0))
      {
        paramBoolean = QQTheme.a();
        if ((!QQTheme.d(paramBoolean)) || (QQTheme.b(paramBoolean))) {
          bool1 = true;
        }
        ImmersiveUtils.setStatusTextColor(bool1, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
        return;
      }
      ImmersiveUtils.adjustThemeStatusBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
      return;
    }
    Card localCard = ((ICardCatcher)this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip")).a();
    Boolean localBoolean = paramBoolean;
    if (paramBoolean == null)
    {
      localBoolean = paramBoolean;
      if (localCard != null)
      {
        if ((!((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).checkUsePersonalCard(this.jdField_a_of_type_MqqAppAppRuntime, localCard)) && (localCard.isNoCover())) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        localBoolean = Boolean.valueOf(bool1);
      }
    }
    if ((localBoolean != null) && (QQTheme.e()))
    {
      ImmersiveUtils.setStatusTextColor(localBoolean.booleanValue() ^ true, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
      return;
    }
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsNight(this.jdField_a_of_type_MqqAppAppRuntime, true, null))
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
      return;
    }
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isGoldenTheme())
    {
      ImmersiveUtils.setStatusTextColor(false, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
      return;
    }
    ImmersiveUtils.setStatusTextColor(((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isDartStatusBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131166489), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
  }
  
  public void a(String paramString)
  {
    View localView = a("d_lovespace");
    if (localView != null)
    {
      boolean bool = "0".equals(paramString);
      int i2 = 0;
      int i1;
      if ((!bool) && (!a(a("d_lovespace")))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      localView.setVisibility(i1);
    }
  }
  
  public void a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (jdField_a_of_type_JavaUtilHashMap.get(paramString) != null)
    {
      if (((QQSettingMeBizBean)jdField_a_of_type_JavaUtilHashMap.get(paramString)).a().getVisibility() != 0) {
        return;
      }
      if (paramString.equals("d_lovespace")) {
        ((ILoveZoneRedTouchApi)QRoute.api(ILoveZoneRedTouchApi.class)).setRedData(this.m, paramAppInfo);
      }
      try
      {
        if (("d_qq_shopping".equals(paramString)) && (a(paramString) != null)) {
          a(paramString).setIsNeedRedImageAutoFix(true);
        }
        b(paramString, paramAppInfo);
        return;
      }
      catch (Exception paramAppInfo)
      {
        QLog.e("QQSettingRedesign", 1, new Object[] { "updateDrawerRedTouch error: ", paramString, ", ", paramAppInfo });
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->fillData, isInit:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a(paramAppRuntime);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new QQSettingMe.5(this, paramBoolean));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "-->onPause!");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.c();
    jdField_b_of_type_Boolean = false;
    VideoReport.pageLogicDestroy(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void b(int paramInt)
  {
    if (!(this.jdField_h_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable))
    {
      if (this.jdField_d_of_type_Boolean) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130846242);
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130846243);
      }
      this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      if ((localObject instanceof Animatable)) {
        ((Animatable)localObject).start();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("%");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NIGHTMODE_ACTION_DOWNLOADING: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQSettingRedesign", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(QQSettingMeLevelAndMedalBean paramQQSettingMeLevelAndMedalBean)
  {
    if ((paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) && (this.jdField_g_of_type_AndroidWidgetTextView != null))
    {
      String str;
      if (paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.allowPeopleSee)
      {
        if (paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays < 10000L) {
          str = String.format(HardCodeUtil.a(2131699249), new Object[] { Long.valueOf(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
        } else {
          str = "9999+";
        }
        paramQQSettingMeLevelAndMedalBean = String.format(HardCodeUtil.a(2131699291), new Object[] { Long.valueOf(paramQQSettingMeLevelAndMedalBean.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        str = HardCodeUtil.a(2131699290);
        paramQQSettingMeLevelAndMedalBean = HardCodeUtil.a(2131699250);
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText(str);
      AccessibilityUtil.a(this.o, paramQQSettingMeLevelAndMedalBean, Button.class.getName());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateTalent error");
    }
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    try
    {
      this.jdField_f_of_type_ComTencentMobileqqTianshuUiRedTouch.a(paramAppInfo);
      return;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateVipText sp vipText = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a("d_vip_identity");
    if (!TextUtils.isEmpty(paramString))
    {
      if (localObject == null) {
        return;
      }
      localObject = (TextView)((View)localObject).findViewById(2131365921);
      if (localObject != null) {
        ((TextView)localObject).setText(paramString);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    View localView = a("d_smallworld");
    if (localView == null) {
      return;
    }
    int i1;
    if ((paramBoolean) && (!a(a("d_smallworld")))) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localView.setVisibility(i1);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "-->onDestroy!");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.d();
  }
  
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = this.jdField_d_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localRedTouch != null) {
      localRedTouch.a(paramAppInfo);
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  @RequiresApi(api=23)
  public void d()
  {
    o();
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "ThemeDebugKeyLog:onPostThemeChanged, refresh pendant after theme changed.");
    }
    Object localObject1 = ((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).getCurrentThemeInfo();
    Object localObject2 = ((Bundle)localObject1).getString("themeId");
    boolean bool;
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"1000".equals(localObject2)) && (!"1103".equals(localObject2))) {
      bool = false;
    } else {
      bool = true;
    }
    this.jdField_d_of_type_Boolean = bool;
    a(null);
    int i1;
    if (this.jdField_d_of_type_Boolean)
    {
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166488);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130846265);
      this.jdField_h_of_type_AndroidWidgetImageView.setImageResource(2130846245);
    }
    else
    {
      i1 = this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166489);
      this.jdField_g_of_type_AndroidWidgetImageView.setImageResource(2130846269);
      this.jdField_h_of_type_AndroidWidgetImageView.setImageResource(2130846244);
    }
    Object localObject3 = ((ICardCatcher)this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip")).a();
    if ((localObject3 != null) && ((((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).checkUsePersonalCard(this.jdField_a_of_type_MqqAppAppRuntime, (Card)localObject3)) || (!((Card)localObject3).isNoCover()))) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "onPostThemeChanged, color=", Integer.valueOf(i1), ",themeid = ", localObject2, ", enginePath=", ((Bundle)localObject1).getString("themePath") });
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(i1);
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(i1);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i1);
    if (((IThemeUtilApi)QRoute.api(IThemeUtilApi.class)).isNowThemeIsDefault(this.jdField_a_of_type_MqqAppAppRuntime, true, null))
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-6709582);
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(-6709582);
    }
    else
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(i1);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!"1000".equals(localObject2))) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(8);
    } else {
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(i1);
    localObject2 = ((IQQSettingMeApi)QRoute.api(IQQSettingMeApi.class)).getPlateColor("A3");
    localObject1 = localObject2;
    int i2;
    if (localObject2 == null)
    {
      if (QQTheme.a()) {
        i2 = 1996488704;
      } else {
        i2 = 0;
      }
      localObject1 = Integer.valueOf(i2);
    }
    localObject2 = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (QQSettingMeBizBean)((Iterator)localObject2).next();
      if (((QQSettingMeBizBean)localObject3).a() != null)
      {
        Object localObject4 = ((QQSettingMeBizBean)localObject3).a();
        if (a((QQSettingMeBizBean)localObject3)) {
          i2 = 8;
        } else {
          i2 = 0;
        }
        ((View)localObject4).setVisibility(i2);
        localObject4 = (URLImageView)((QQSettingMeBizBean)localObject3).a().findViewById(2131365917);
        a((URLImageView)localObject4, (QQSettingMeBizBean)localObject3);
        ((URLImageView)localObject4).setColorFilter(((Integer)localObject1).intValue());
        localObject3 = (TextView)((QQSettingMeBizBean)localObject3).a().findViewById(2131365921);
        if (!this.jdField_d_of_type_Boolean) {
          ((TextView)localObject3).setTextColor(i1);
        } else {
          ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166487));
        }
        if ((SimpleUIUtil.a()) && ("2920".equals(QQTheme.a()))) {
          ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166487));
        }
      }
    }
    if (QQTheme.a()) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(1996488704);
    } else {
      this.jdField_a_of_type_ComTencentImageURLImageView.setColorFilter(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.f();
  }
  
  public void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localRedTouch != null) {
      localRedTouch.a(paramAppInfo);
    }
  }
  
  public void d(String paramString)
  {
    if ((this.jdField_h_of_type_AndroidWidgetTextView != null) && (this.jdField_k_of_type_AndroidWidgetTextView != null) && (this.jdField_i_of_type_AndroidWidgetTextView != null) && (this.jdField_j_of_type_AndroidWidgetTextView != null) && (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) && (this.p != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      int i1;
      if (paramString.charAt(0) == '-')
      {
        paramString = paramString.substring(1);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setText("-");
        this.jdField_i_of_type_AndroidWidgetTextView.measure(0, 0);
        i1 = this.jdField_i_of_type_AndroidWidgetTextView.getMeasuredWidth();
        this.jdField_h_of_type_AndroidWidgetTextView.setText(paramString);
      }
      else
      {
        i1 = 0;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_k_of_type_AndroidWidgetTextView.measure(0, 0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.measure(0, 0);
      this.jdField_j_of_type_AndroidWidgetTextView.measure(0, 0);
      int i4 = this.jdField_h_of_type_AndroidWidgetTextView.getMeasuredWidth();
      int i3 = this.jdField_c_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
      int i2 = (i3 - i4 - i1 - this.jdField_j_of_type_AndroidWidgetTextView.getMeasuredWidth()) / 2;
      i4 /= 2;
      i3 /= 2;
      paramString = (LinearLayout.LayoutParams)this.p.getLayoutParams();
      paramString.leftMargin = (i3 - (i2 + i1 + i4));
      this.p.setLayoutParams(paramString);
    }
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.h();
    Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getVisibility() == 0))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      localStringBuilder.append("qqsettingme_f2f_guide");
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putBoolean("qqsettingme_f2f_guide_flag", true).apply();
    }
    a(null);
  }
  
  public void f()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.g();
    a(null);
  }
  
  public void g()
  {
    QQSettingMeSuperMemberPayButtonBean localQQSettingMeSuperMemberPayButtonBean = ((ISuperMemberDataCatcher)this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_vip_identity")).a();
    if ((!TextUtils.isEmpty(localQQSettingMeSuperMemberPayButtonBean.jdField_b_of_type_JavaLangString)) && (!localQQSettingMeSuperMemberPayButtonBean.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin())))
    {
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler payRuleUin changed");
      l();
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_c_of_type_AndroidWidgetLinearLayout;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
    localObject = this.jdField_k_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
  }
  
  public void i()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      QQSettingMeBizBean localQQSettingMeBizBean = (QQSettingMeBizBean)localIterator.next();
      localQQSettingMeBizBean.a().d();
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localQQSettingMeBizBean.a().a();
      if ((localAppInfo != null) && (localAppInfo.exposure_max.get() <= 0))
      {
        localAppInfo.iNewFlag.set(0);
        localQQSettingMeBizBean.a().setAppInfo(localAppInfo);
      }
    }
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    if ((paramView != null) && (this.jdField_a_of_type_Boolean)) {
      if ((this.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L))
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      else
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        int i4 = paramView.getId();
        if (i4 == 2131365911)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_common").onClick(paramView);
        }
        else
        {
          int i1 = 1;
          int i2 = 1;
          int i3 = 1;
          boolean bool = true;
          Object localObject;
          if ((i4 != 2131365949) && (i4 != 2131365913))
          {
            if (i4 == 2131365965)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_nickname").onClick(paramView);
            }
            else if (i4 == 2131365960)
            {
              paramView.setTag(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c()));
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_avatar").onClick(paramView);
            }
            else if (i4 == 2131365939)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_qrcode").onClick(paramView);
            }
            else if (i4 == 2131365941)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_setting").onClick(paramView);
            }
            else if (i4 == 2131365928)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_night_mode").onClick(paramView);
            }
            else if (i4 == 2131365952)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(0));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131365980)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_weather").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(0));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131365973)
            {
              localObject = this.jdField_j_of_type_AndroidViewView;
              if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null))
              {
                localObject = (TextView)((View)localObject).findViewById(2131365972);
                if ((localObject == null) || (((TextView)localObject).getText() == null)) {
                  bool = false;
                }
                paramView.setTag(Boolean.valueOf(bool));
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_signature").onClick(paramView);
            }
            else if (i4 == 2131365969)
            {
              localObject = this.jdField_e_of_type_ComTencentMobileqqTianshuUiRedTouch;
              if ((localObject == null) || (!((RedTouch)localObject).c())) {
                i1 = 0;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i1));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131365970)
            {
              localObject = this.jdField_d_of_type_ComTencentMobileqqTianshuUiRedTouch;
              if ((localObject != null) && (((RedTouch)localObject).c())) {
                i1 = i2;
              } else {
                i1 = 0;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i1));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131365966)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip").onClick(paramView);
              VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(0));
              VideoReport.reportEvent("clck", paramView, null);
            }
            else if (i4 == 2131365936)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_profile_bubble").onClick(paramView);
            }
            else if (i4 == 2131365977)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_head_vip").onClick(paramView);
            }
          }
          else
          {
            localObject = this.jdField_h_of_type_ComTencentMobileqqTianshuUiRedTouch;
            if ((localObject != null) && (((RedTouch)localObject).c())) {
              i1 = i3;
            } else {
              i1 = 0;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a("d_daily").onClick(paramView);
            VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i1));
            VideoReport.reportEvent("clck", paramView, null);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView == null) {
      return false;
    }
    int i1 = paramView.getId();
    if ((i1 == 2131365949) || (i1 == 2131365911) || (i1 == 2131365939) || (i1 == 2131365960) || (i1 == 2131365941) || (i1 == 2131365928) || (i1 == 2131365952) || (i1 == 2131365980) || (i1 == 2131365973)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeQQSettingMeViewModel.a(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe
 * JD-Core Version:    0.7.0.1
 */