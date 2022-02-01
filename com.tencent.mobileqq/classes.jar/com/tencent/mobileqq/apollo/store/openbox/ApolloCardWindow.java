package com.tencent.mobileqq.apollo.store.openbox;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.model.ApolloDrawableExtraInfo;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class ApolloCardWindow
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, BoxCardHandler.OnBoxCardHandlerListener, IApolloOpenBoxListener, MultilScreenlLayout.OnClickScrollLayoutListener
{
  static float jdField_a_of_type_Float;
  private static final String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131700536);
  static Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static boolean jdField_a_of_type_Boolean;
  static float jdField_b_of_type_Float;
  private static final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131700525);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ApolloBoxData jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
  private ApolloCardWindow.OnCloseCardWindowListener jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow$OnCloseCardWindowListener;
  private ApolloOpenBoxView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView;
  private BoxCardHandler jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler;
  private OpeningCardGroup jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new ApolloCardWindow.2(this);
  DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  Runnable jdField_a_of_type_JavaLangRunnable = new ApolloCardWindow.3(this);
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<ApolloCardLayout> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  ScaleAnimation jdField_b_of_type_AndroidViewAnimationScaleAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundRectLinearLayout jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private int jdField_h_of_type_Int;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private int j;
  private int k;
  
  public ApolloCardWindow(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    d();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = new DownloaderFactory(BaseApplicationImpl.getApplication().getRuntime()).a(3);
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 10, null, true);
  }
  
  public static void a()
  {
    jdField_a_of_type_Float = FontSettingManager.getFontLevel() / 16.0F;
    if (jdField_a_of_type_Float == 0.0F) {
      jdField_a_of_type_Float = 1.0F;
    }
    jdField_b_of_type_Float = DeviceInfoUtil.a() / jdField_a_of_type_Float;
    if (jdField_b_of_type_Float == 0.0F) {
      jdField_b_of_type_Float = DeviceInfoUtil.a();
    }
  }
  
  private void a(Message paramMessage)
  {
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)) && (!TextUtils.isEmpty((String)paramMessage.obj)))
    {
      paramMessage = URLDrawable.URLDrawableOptions.obtain();
      paramMessage.mLoadingDrawable = ImageUtil.e();
      paramMessage.mFailedDrawable = paramMessage.mLoadingDrawable;
      ApolloDrawableExtraInfo localApolloDrawableExtraInfo = new ApolloDrawableExtraInfo();
      localApolloDrawableExtraInfo.mDrawableType = ApolloConstant.jdField_g_of_type_Int;
      paramMessage.mExtraInfo = localApolloDrawableExtraInfo;
    }
  }
  
  private boolean a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
    if (localObject1 == null) {
      return true;
    }
    if (((ApolloBoxData)localObject1).jdField_a_of_type_JavaUtilList.size() > 2)
    {
      localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2);
      if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int > 0))
      {
        Object localObject2 = this.jdField_f_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("+");
        localStringBuilder.append(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int);
        ((TextView)localObject2).setText(localStringBuilder.toString());
        localObject2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_props_image.png", null, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
        int m = ApolloUtilImpl.dp2px(25.0F / jdField_a_of_type_Float, jdField_b_of_type_Float);
        ((URLDrawable)localObject2).setBounds(0, 0, m, m);
        this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
        a(ApolloUtilImpl.dp2px(125.0F, jdField_b_of_type_Float) + this.jdField_c_of_type_AndroidWidgetTextView.getWidth() + this.jdField_h_of_type_AndroidWidgetTextView.getWidth());
        this.jdField_i_of_type_AndroidWidgetTextView.setText(ApolloBoxData.a(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int));
        a(this.jdField_i_of_type_AndroidWidgetTextView, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int, 200, 650);
        if (this.jdField_i_of_type_AndroidWidgetImageView == null)
        {
          this.jdField_i_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_i_of_type_AndroidWidgetImageView.setId(2131374762);
          this.jdField_i_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          localObject1 = new RelativeLayout.LayoutParams(ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float), ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float));
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = (ApolloUtilImpl.dp2px(82.0F, jdField_b_of_type_Float) + this.jdField_c_of_type_AndroidWidgetTextView.getWidth() + this.jdField_h_of_type_AndroidWidgetTextView.getWidth());
          ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.getLayoutParams()).topMargin + ApolloUtilImpl.dp2px(7.5F, jdField_b_of_type_Float));
          super.addView(this.jdField_i_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
        }
        a(this.jdField_h_of_type_AndroidWidgetImageView, this.jdField_i_of_type_AndroidWidgetImageView, 650);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(269, 650L);
      }
    }
    this.jdField_i_of_type_AndroidWidgetImageView.setImageDrawable(null);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
    }
    return false;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    int n = 0;
    int m = 0;
    StringBuilder localStringBuilder;
    while (m <= 9)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apollo_card_gold_");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
      localStringBuilder.append((String)localObject);
      if (!new File(localStringBuilder.toString()).exists()) {
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable((String)localObject, null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl((String)localObject)).startDownload();
      }
      m += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_gold_add.png");
    if (!new File(((StringBuilder)localObject).toString()).exists()) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_gold_add.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_gold_add.png")).startDownload();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_gold_icon.png");
    m = n;
    if (!new File(((StringBuilder)localObject).toString()).exists())
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_gold_icon.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_gold_icon.png")).startDownload();
      m = n;
    }
    while (m <= 9)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apollo_card_crystal_");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
      localStringBuilder.append((String)localObject);
      if (!new File(localStringBuilder.toString()).exists()) {
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable((String)localObject, null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl((String)localObject)).startDownload();
      }
      m += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_crystal_add.png");
    if (!new File(((StringBuilder)localObject).toString()).exists()) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_crystal_add.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_crystal_add.png")).startDownload();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/");
    ((StringBuilder)localObject).append("apollo_card_crystal_image.png");
    if (!new File(((StringBuilder)localObject).toString()).exists()) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_crystal_image.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_card_crystal_image.png")).startDownload();
    }
  }
  
  private boolean b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
    if (localObject1 == null) {
      return true;
    }
    if (((ApolloBoxData)localObject1).jdField_a_of_type_JavaUtilList.size() == 1) {
      return false;
    }
    localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1);
    if (localObject1 != null)
    {
      if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int <= 0) {
        return false;
      }
      Object localObject2 = this.jdField_f_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = super.getResources().getDrawable(2130838416);
      localObject2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject2, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
      int m = ApolloUtilImpl.dp2px(25.0F / jdField_a_of_type_Float, jdField_b_of_type_Float);
      ((URLDrawable)localObject2).setBounds(0, 0, m, m);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
      a(this.jdField_c_of_type_AndroidWidgetTextView.getWidth() + this.jdField_f_of_type_AndroidWidgetImageView.getWidth() + ApolloUtilImpl.dp2px(28.0F, jdField_b_of_type_Float));
      this.jdField_h_of_type_AndroidWidgetTextView.setText(ApolloBoxData.b(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int));
      a(this.jdField_h_of_type_AndroidWidgetTextView, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int, 200, 650);
      if (this.jdField_g_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_g_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_g_of_type_AndroidWidgetImageView.setId(2131374762);
        this.jdField_g_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject1 = new RelativeLayout.LayoutParams(ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float), ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (ApolloUtilImpl.dp2px(47.0F, jdField_b_of_type_Float) + this.jdField_c_of_type_AndroidWidgetTextView.getWidth());
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.getLayoutParams()).topMargin + ApolloUtilImpl.dp2px(7.5F, jdField_b_of_type_Float));
        super.addView(this.jdField_g_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_g_of_type_AndroidWidgetImageView.setImageDrawable(null);
      a(this.jdField_f_of_type_AndroidWidgetImageView, this.jdField_g_of_type_AndroidWidgetImageView, 650);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(267, 650L);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
      }
    }
    return false;
  }
  
  private boolean c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
    if (localObject1 == null) {
      return true;
    }
    if (((ApolloBoxData)localObject1).jdField_a_of_type_JavaUtilList.size() == 0) {
      return false;
    }
    localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0);
    if (localObject1 != null)
    {
      if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int <= 0) {
        return false;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      Object localObject2 = this.jdField_f_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int);
      ((TextView)localObject2).setText(localStringBuilder.toString());
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = super.getResources().getDrawable(2130838415);
      localObject2 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject2, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
      int m = ApolloUtilImpl.dp2px(25.0F / jdField_a_of_type_Float, jdField_b_of_type_Float);
      ((URLDrawable)localObject2).setBounds(0, 0, (int)(m * 0.8F), m);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
      a(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(ApolloBoxData.c(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int));
      a(this.jdField_c_of_type_AndroidWidgetTextView, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_b_of_type_Int, 200, 650);
      if (this.jdField_c_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_c_of_type_AndroidWidgetImageView.setId(2131366022);
        this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localObject1 = new RelativeLayout.LayoutParams(ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float), ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float));
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ApolloUtilImpl.dp2px(12.0F, jdField_b_of_type_Float);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.getLayoutParams()).topMargin + ApolloUtilImpl.dp2px(7.5F, jdField_b_of_type_Float));
        super.addView(this.jdField_c_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_c_of_type_AndroidWidgetImageView, 650);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(266, 650L);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_ADD_CARD:");
      }
    }
    return false;
  }
  
  private void d()
  {
    setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()), 0, 0);
    this.jdField_i_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler = new BoxCardHandler(this);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    a();
    int n = (int)DeviceInfoUtil.i();
    int m = (int)DeviceInfoUtil.j() - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    super.setBackgroundColor(-671088640);
    float f1 = n;
    this.jdField_c_of_type_Int = ((int)(0.706F * f1));
    int i1 = (int)(0.04F * f1);
    this.jdField_d_of_type_Int = i1;
    int i2 = this.jdField_c_of_type_Int;
    this.jdField_e_of_type_Int = ((n - i2 - this.jdField_d_of_type_Int * 2) / 2);
    this.jdField_f_of_type_Int = (i2 * 760 / 530);
    float f2 = m;
    this.jdField_h_of_type_Int = ((int)(0.23F * f2));
    this.j = (n >> 1);
    this.k = ((int)(0.461F * f2));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = new RelativeLayout(getContext());
    super.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup = new OpeningCardGroup(this.jdField_a_of_type_AndroidContentContext, this);
    localObject2 = new RelativeLayout.LayoutParams(-1, this.jdField_f_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = this.jdField_h_of_type_Int;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup;
    i2 = this.jdField_c_of_type_Int;
    int i3 = this.jdField_f_of_type_Int;
    int i4 = this.jdField_d_of_type_Int;
    int i5 = this.jdField_e_of_type_Int;
    ((OpeningCardGroup)localObject3).setFrameWidth(i2, i3, 0, i4, i5, i5);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setClickLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851075);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    double d1 = n;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(d1 * 0.032D));
    d1 = m;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(d1 * 0.017D));
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(17.0F / jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690874);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    super.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = new RoundRectLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOrientation(0);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(17);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect(ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float), -1, true);
    localObject2 = new RelativeLayout.LayoutParams(-2, ApolloUtilImpl.dp2px(30.0F, jdField_b_of_type_Float));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(0.018F * f2));
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setPadding(0, 0, ApolloUtilImpl.dp2px(12.0F, jdField_b_of_type_Float), 0);
    super.addView(this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject2 = new LinearLayout.LayoutParams(ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float), ApolloUtilImpl.dp2px(17.0F, jdField_b_of_type_Float));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtilImpl.dp2px(12.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(12.0F / jdField_a_of_type_Float);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtilImpl.dp2px(3.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_c_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_f_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject2 = new LinearLayout.LayoutParams(ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float), ApolloUtilImpl.dp2px(17.0F, jdField_b_of_type_Float));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_f_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(12.0F / jdField_a_of_type_Float);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtilImpl.dp2px(3.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_h_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject2 = new LinearLayout.LayoutParams(ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float), ApolloUtilImpl.dp2px(17.0F, jdField_b_of_type_Float));
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtilImpl.dp2px(15.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_h_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_i_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_i_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(12.0F / jdField_a_of_type_Float);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtilImpl.dp2px(3.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_i_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextSize(14.0F / jdField_a_of_type_Float);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-34816);
    this.jdField_g_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700535));
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(0.029F * f1));
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(0.17F * f2));
    super.addView(this.jdField_g_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(17.0F / jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_e_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = ApolloUtilImpl.dp2px(25.0F, jdField_b_of_type_Float);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new LinearLayout.LayoutParams(-1, ApolloUtilImpl.dp2px(250.0F, jdField_b_of_type_Float) * 3 / 4);
    localObject3 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    URLDrawable localURLDrawable = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable("apollo_error.png", null, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloImageUrl("apollo_error.png"));
    localURLDrawable.setTargetDensity(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi / 2);
    ((URLImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER);
    ((URLImageView)localObject3).setImageDrawable(localURLDrawable);
    ((URLImageView)localObject3).setClickable(true);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ApolloUtilImpl.dp2px(66.0F, jdField_b_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ApolloUtilImpl.dp2px(129.0F, jdField_b_of_type_Float);
    super.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839404);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
    super.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_g_of_type_Int = ((int)(0.061F * f2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams((int)(0.936F * f1), this.jdField_g_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(0.027F * f1));
    super.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = new RoundRectLinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect((int)(f1 * 0.008F), -7707920, false);
    this.jdField_d_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130838420);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_d_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_d_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_d_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(18.0F / jdField_a_of_type_Float);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("送花给TA");
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtilImpl.dp2px(8.0F, jdField_b_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.jdField_d_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOnClickListener(this);
    localObject2 = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.jdField_e_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(18.0F);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(f2 * 0.2F));
    super.addView(this.jdField_e_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView = new ApolloOpenBoxView(this.jdField_a_of_type_AndroidContentContext, this);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView, (ViewGroup.LayoutParams)localObject2);
    this.jdField_f_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    m = 0;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ApolloUtilImpl.dp2px(217.0F, jdField_b_of_type_Float);
    this.jdField_f_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_f_of_type_AndroidWidgetTextView.setTextSize(30.0F / jdField_a_of_type_Float);
    this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(-1);
    ((RelativeLayout)localObject1).addView(this.jdField_f_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject2);
    while (m < 4)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ApolloCardLayout(this.jdField_a_of_type_AndroidContentContext));
      m += 1;
    }
    this.jdField_e_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundResource(2130838419);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = (n / 4);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = i1;
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
    super.addView(this.jdField_e_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    super.setOnClickListener(this);
  }
  
  private boolean d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
    if (localObject != null)
    {
      if (((ApolloBoxData)localObject).jdField_b_of_type_JavaUtilList == null) {
        return true;
      }
      int m = this.jdField_c_of_type_Int;
      int n = m / 2;
      int i1 = this.jdField_d_of_type_Int;
      int i2 = this.jdField_e_of_type_Int;
      int i3 = this.jdField_f_of_type_Int / 2;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(n + i1 + i2, m + i1, i3);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "MSG_CODE_CARD_TO_NORMAL");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
      if (localObject != null)
      {
        m = ((ApolloBoxData)localObject).jdField_a_of_type_JavaUtilList.size();
        n = 650;
        if (m > 0)
        {
          localObject = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0);
          if ((localObject != null) && (((ApolloBoxData.BoxCardListSummary)localObject).jdField_a_of_type_Boolean) && (((ApolloBoxData.BoxCardListSummary)localObject).jdField_c_of_type_Int > 0))
          {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(255, 500L);
            m = 650;
            break label177;
          }
        }
        m = 0;
        n = 0;
        label177:
        i1 = m;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 1)
        {
          localObject = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1);
          i1 = m;
          if (localObject != null)
          {
            i1 = m;
            if (((ApolloBoxData.BoxCardListSummary)localObject).jdField_a_of_type_Boolean)
            {
              i1 = m;
              if (((ApolloBoxData.BoxCardListSummary)localObject).jdField_c_of_type_Int > 0)
              {
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(265, n + 500);
                i1 = m + 150 + 500;
              }
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 2)
        {
          localObject = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2);
          if ((localObject != null) && (((ApolloBoxData.BoxCardListSummary)localObject).jdField_a_of_type_Boolean) && (((ApolloBoxData.BoxCardListSummary)localObject).jdField_c_of_type_Int > 0)) {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(268, i1 + 500);
          }
        }
      }
      return false;
    }
    return true;
  }
  
  private void e()
  {
    ImageView localImageView = this.jdField_i_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageResource(2130838418);
    }
  }
  
  private boolean e()
  {
    super.setVisibility(0);
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData == null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(4);
      return true;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    Object localObject1;
    int m;
    if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject1 = this.jdField_d_of_type_AndroidWidgetImageView;
        float f1;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Boolean) {
          f1 = 1.0F;
        } else {
          f1 = 0.5F;
        }
        ((ImageView)localObject1).setAlpha(f1);
      }
      localObject1 = this.jdField_d_of_type_AndroidWidgetTextView;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Boolean) {
        m = -1;
      } else {
        m = -2130706433;
      }
      ((TextView)localObject1).setTextColor(m);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ("drawer".equals(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_a_of_type_Int = 0;
    } else if ("friendcard".equals(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_a_of_type_Int = 1;
    } else {
      this.jdField_a_of_type_Int = 2;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Long != -501031L))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Int > 0)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaLangString)))
        {
          this.jdField_b_of_type_Int = 1;
          localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
          if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C2", this.jdField_a_of_type_Int, 0, new String[] { "", String.valueOf(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int), "" });
          }
          localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(7));
          if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C04", this.jdField_a_of_type_Int, 0, new String[] { "", String.valueOf(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int), "" });
          }
          localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(15));
          if ((localObject1 != null) && (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C06", this.jdField_a_of_type_Int, 0, new String[] { "", String.valueOf(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_c_of_type_Int), "" });
          }
          m = 0;
        }
        else
        {
          this.jdField_b_of_type_Int = 2;
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_c_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_c_of_type_JavaUtilList.isEmpty()))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_c_of_type_JavaUtilList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (ApolloBoxData.ApolloBoxDataItem)((Iterator)localObject1).next();
              ApolloBoxData.BoxCardListSummary localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(3));
              if ((localBoxCardListSummary != null) && (localBoxCardListSummary.jdField_c_of_type_Int > 0)) {
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.jdField_a_of_type_Int, 0, new String[] { String.valueOf(((ApolloBoxData.ApolloBoxDataItem)localObject2).jdField_a_of_type_Int), String.valueOf(0), String.valueOf(((ApolloBoxData.ApolloBoxDataItem)localObject2).jdField_a_of_type_Short) });
              }
              localObject2 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(7));
              if ((localObject2 != null) && (((ApolloBoxData.BoxCardListSummary)localObject2).jdField_c_of_type_Int > 0)) {
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.jdField_a_of_type_Int, 0, new String[] { "0", String.valueOf(0), "4" });
              }
              localObject2 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(15));
              if ((localObject2 != null) && (((ApolloBoxData.BoxCardListSummary)localObject2).jdField_c_of_type_Int > 0)) {
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.jdField_a_of_type_Int, 0, new String[] { "0", String.valueOf(0), "5" });
              }
            }
          }
          m = 1;
        }
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C1", this.jdField_a_of_type_Int, 0, new String[] { String.valueOf(m), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Int) });
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Long == -501030L)
      {
        this.jdField_b_of_type_Int = 3;
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C4", this.jdField_a_of_type_Int, 0, new String[] { "0", "0", "1" });
      }
      else
      {
        this.jdField_b_of_type_Int = 4;
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C5", this.jdField_a_of_type_Int, 0, new String[0]);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Int > 0)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaLangString))) {
          this.jdField_b_of_type_Int = 1;
        } else {
          this.jdField_b_of_type_Int = 2;
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Long == -501030L) {
        this.jdField_b_of_type_Int = 3;
      } else {
        this.jdField_b_of_type_Int = 4;
      }
      VipUtils.a(null, "cmshow", "Apollo", "openfloatagain", this.jdField_a_of_type_Int, 0, new String[] { String.valueOf(this.jdField_b_of_type_Int) });
    }
    m();
    return false;
  }
  
  private void f()
  {
    ImageView localImageView = this.jdField_g_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageResource(2130838418);
    }
  }
  
  private void g()
  {
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageResource(2130838418);
    }
  }
  
  private void h()
  {
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.5F);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-2130706433);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131700526), 0).a();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData != null)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = this.jdField_d_of_type_AndroidWidgetImageView;
        float f1;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Boolean) {
          f1 = 1.0F;
        } else {
          f1 = 0.5F;
        }
        ((ImageView)localObject).setAlpha(f1);
      }
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      int m;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Boolean) {
        m = -1;
      } else {
        m = -2130706433;
      }
      ((TextView)localObject).setTextColor(m);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131700531), 0).a();
    }
  }
  
  private void j()
  {
    super.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void k()
  {
    super.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
  }
  
  private void m()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
    if ((localObject1 != null) && (((ApolloBoxData)localObject1).jdField_b_of_type_JavaUtilList != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList.isEmpty()) {
        return;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_c_of_type_JavaLangString)) {
        localObject1 = "";
      } else {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_c_of_type_JavaLangString;
      }
      Object localObject2 = localObject1;
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
      {
        localObject2 = localObject1;
        if (this.jdField_d_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaLangString)) {
          localObject2 = HardCodeUtil.a(2131700532);
        }
      }
      Object localObject3;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() == 3)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString), null, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
            this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_Int == 7) {
            this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-31676);
          } else {
            this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          }
        }
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString), null, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
            this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_Int == 7) {
            this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-31676);
          } else {
            this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          }
        }
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString), null, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_Int == 7) {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-31676);
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() == 2)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString), null, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
            this.jdField_f_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_Int == 7) {
            this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-31676);
          } else {
            this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          }
        }
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString), null, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_Int == 7) {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-31676);
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject1 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0);
        if (localObject1 != null)
        {
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString))
          {
            localObject3 = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(Utils.Crc64String(((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString), null, ((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
          }
          if (((ApolloBoxData.BoxCardListSummary)localObject1).jdField_a_of_type_Int == 7) {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-31676);
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Int != -1) {
        super.setBackgroundColor(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Long == 0L) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Long != -501031L) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_Long != -501027L))
      {
        AbstractGifImage.pauseAll();
        localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131700529));
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131700530));
        ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(ApolloBoxData.c(((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_Int));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 1) {
          this.jdField_h_of_type_AndroidWidgetTextView.setText(ApolloBoxData.b(((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1)).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1)).jdField_c_of_type_Int));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 2) {
          this.jdField_i_of_type_AndroidWidgetTextView.setText(ApolloBoxData.a(((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2)).jdField_b_of_type_Int - ((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2)).jdField_c_of_type_Int));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501027L)) {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        localObject3 = new ArrayList();
        m = 0;
        while (m < this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList.size())
        {
          if (this.jdField_a_of_type_JavaUtilList.size() > m)
          {
            localObject1 = (ApolloCardLayout)this.jdField_a_of_type_JavaUtilList.get(m);
            ((ApolloCardLayout)localObject1).clearAnimation();
          }
          else
          {
            localObject1 = null;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new ApolloCardLayout(this.jdField_a_of_type_AndroidContentContext);
            this.jdField_a_of_type_JavaUtilList.add(localObject2);
          }
          ((List)localObject3).add(localObject2);
          localObject1 = (ApolloBoxData.ApolloBoxDataItem)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList.get(m);
          if ((localObject1 != null) && (((ApolloBoxData.ApolloBoxDataItem)localObject1).jdField_a_of_type_Short == 15)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C002", this.jdField_a_of_type_Int, 0, new String[0]);
          }
          m += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList, (List)localObject3, this.j, this.k - this.jdField_h_of_type_Int, super.getWidth(), super.getHeight());
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(256, 600);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
      int m = 0;
      while (m < this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > m)
        {
          localObject1 = (ApolloCardLayout)this.jdField_a_of_type_JavaUtilList.get(m);
          ((ApolloCardLayout)localObject1).clearAnimation();
        }
        else
        {
          localObject1 = null;
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ApolloCardLayout(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
        }
        localObject1 = new FrameLayout.LayoutParams(this.jdField_c_of_type_Int, this.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        m += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.jdField_c_of_type_Int, this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setCurrentFrame(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.requestLayout();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ApolloBoxData.c(((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_Int));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 1) {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(ApolloBoxData.b(((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1)).jdField_b_of_type_Int));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 2) {
        this.jdField_i_of_type_AndroidWidgetTextView.setText(ApolloBoxData.a(((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2)).jdField_b_of_type_Int));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501027L)) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  private void n()
  {
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localScaleAnimation1.setDuration(100L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 0.6666667F, 1.0F, 0.6666667F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation2.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setStartOffset(100L);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  Drawable a(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    paramString.setDensity(getContext().getResources().getDisplayMetrics().densityDpi);
    return new BitmapDrawable(getContext().getResources(), paramString);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(false);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(150L);
    }
    if (this.jdField_a_of_type_AndroidViewAnimationScaleAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(150L);
      this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    Object localObject = new QuadBezierAnimation(0, 0, 0, -ApolloUtilImpl.dp2px(144.0F, jdField_b_of_type_Float), -(ApolloUtilImpl.dp2px(195.0F, jdField_b_of_type_Float) - paramInt), -ApolloUtilImpl.dp2px(164.0F, jdField_b_of_type_Float));
    ((QuadBezierAnimation)localObject).setDuration(500L);
    ((QuadBezierAnimation)localObject).setStartOffset(250L);
    ((QuadBezierAnimation)localObject).setInterpolator(new AccelerateDecelerateInterpolator());
    if (this.jdField_b_of_type_AndroidViewAnimationScaleAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setStartOffset(250L);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject);
    if (this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
      this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setStartOffset(250L);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOpenStep drawStep:");
      localStringBuilder.append(paramInt1);
      QLog.d("[cmshow]ApolloCardWindow", 2, localStringBuilder.toString());
    }
    if (super.getVisibility() != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData == null) {
      return;
    }
    if (4 == paramInt1)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501027L)) {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else if (10 == paramInt1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.getVisibility() != 0)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_Long == -501027L) || (this.jdField_a_of_type_Long == -501027L)) {
          this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.jdField_c_of_type_Int, this.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setCurrentFrame(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(4);
      this.jdField_c_of_type_Boolean = true;
      AbstractGifImage.resumeAll();
    }
  }
  
  public void a(View paramView, String paramString1, String paramString2, AppInterface paramAppInterface, ApolloCardWindow.OnCloseCardWindowListener paramOnCloseCardWindowListener)
  {
    if ((paramView != null) && (paramAppInterface != null))
    {
      if (paramString1 == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow$OnCloseCardWindowListener = paramOnCloseCardWindowListener;
      super.setVisibility(4);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      this.jdField_f_of_type_JavaLangString = paramString2;
      this.jdField_c_of_type_JavaLangString = paramString1;
      this.jdField_d_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(4);
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(258);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(264);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(264, 1000L);
      }
      else
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(264);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(264);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(258, 500L);
      }
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Object localObject = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    long l = paramInt;
    ((ScaleAnimation)localObject).setStartOffset(l);
    if (paramImageView1 != null) {
      paramImageView1.startAnimation((Animation)localObject);
    }
    paramImageView1 = new AnimationSet(false);
    localObject = new ScaleAnimation(1.0F, 4.0F, 1.0F, 4.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    new AlphaAnimation(0.0F, 1.0F).setDuration(75L);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    paramImageView1.setStartOffset(l);
    paramImageView1.setFillAfter(true);
    if (paramImageView2 != null) {
      paramImageView2.startAnimation(paramImageView1);
    }
  }
  
  void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 <= paramInt1) {
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setObjectValues(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.addUpdateListener(new ApolloCardWindow.1(this, paramTextView));
    localValueAnimator.setStartDelay(paramInt4);
    localValueAnimator.start();
  }
  
  void a(File paramFile, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface == null) {
      return;
    }
    DownloadTask localDownloadTask = new DownloadTask(paramString, paramFile);
    localDownloadTask.p = true;
    localDownloadTask.j = false;
    localDownloadTask.n = true;
    localDownloadTask.s = false;
    localDownloadTask.q = true;
    localDownloadTask.r = true;
    localDownloadTask.jdField_b_of_type_Boolean = true;
    localDownloadTask.jdField_f_of_type_JavaLangString = "apollo_res";
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramFile.getPath());
    localBundle.putString("url", paramString);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.startDownload(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, null);
  }
  
  public void a(String paramString1, boolean paramBoolean, long paramLong, Object paramObject, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" retCode:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" data:");
      localStringBuilder.append(paramObject);
      QLog.d("[cmshow]ApolloCardWindow", 2, localStringBuilder.toString());
    }
    if (super.getVisibility() == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloCardWindow", 2, "onResult + super.getVisibility() not VISIBLE");
      }
      return;
    }
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (!this.jdField_c_of_type_JavaLangString.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("mBoxUin:");
        paramString1.append(this.jdField_c_of_type_JavaLangString);
        paramString1.append("notEqual uin:");
        paramString1.append(paramString2);
        paramString1.append(" return!");
        QLog.d("[cmshow]ApolloCardWindow", 2, paramString1.toString());
      }
      return;
    }
    if ("apollo_core.get_user_info_v2".equals(paramString1))
    {
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_JavaLangString.equals(paramString2)))
      {
        paramString1 = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(257);
        paramString1.obj = paramObject;
        paramString1.sendToTarget();
      }
    }
    else
    {
      if ("apollo_interact.thank_zan".equals(paramString1))
      {
        if ((paramLong == 0L) && (paramBoolean))
        {
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(262).sendToTarget();
          return;
        }
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(261).sendToTarget();
        return;
      }
      if ("apollo_interact.take_chips".equals(paramString1))
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(258);
        if ((paramObject instanceof ApolloBoxData)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData = ((ApolloBoxData)paramObject);
        }
        this.jdField_a_of_type_Long = paramLong;
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
        if ((paramString1 != null) && ((this.jdField_a_of_type_Long == -501030L) || (paramString1.jdField_b_of_type_Long == -501030L)))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList == null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList = new ArrayList();
          }
          paramString1 = new ApolloBoxData.ApolloBoxDataItem();
          paramString1.jdField_g_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_b_of_type_JavaUtilList.add(0, paramString1);
        }
        if (paramBoolean)
        {
          paramLong = this.jdField_a_of_type_Long;
          if ((paramLong != 0L) && (paramLong != -501030L) && (paramLong != -501027L) && (paramLong != -501040L) && (paramLong != -501031L))
          {
            if (paramLong == -501028L)
            {
              this.jdField_e_of_type_JavaLangString = jdField_b_of_type_JavaLangString;
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(259).sendToTarget();
              return;
            }
            this.jdField_e_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(259).sendToTarget();
            return;
          }
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(260).sendToTarget();
          return;
        }
        this.jdField_e_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(259).sendToTarget();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow$OnCloseCardWindowListener;
      if (localObject != null) {
        ((ApolloCardWindow.OnCloseCardWindowListener)localObject).a(this.jdField_c_of_type_JavaLangString);
      }
    }
    super.setVisibility(8);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(paramBoolean);
    Object localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).clearAnimation();
    }
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).clearAnimation();
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
    localObject = this.jdField_h_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).clearAnimation();
    }
    localObject = this.jdField_f_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.b();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler.a();
    }
  }
  
  void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
    Object localObject4;
    Object localObject5;
    File localFile;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView != null) && (!TextUtils.isEmpty(((ApolloBoxData)localObject1).jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_d_of_type_JavaLangString)))
    {
      localObject1 = MD5Utils.toMD5(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_d_of_type_JavaLangString);
      localObject4 = MD5Utils.toMD5(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_e_of_type_JavaLangString);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/");
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append(".cache");
      localObject5 = new File(((StringBuilder)localObject5).toString());
      ??? = new StringBuilder();
      ((StringBuilder)???).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/");
      ((StringBuilder)???).append((String)localObject4);
      ((StringBuilder)???).append(".cache");
      localFile = new File(((StringBuilder)???).toString());
      if ((!((File)localObject5).exists()) || (!localFile.exists())) {}
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        if (!jdField_a_of_type_JavaUtilMap.containsKey(localObject1)) {
          break label301;
        }
        localObject1 = (Drawable)jdField_a_of_type_JavaUtilMap.get(localObject1);
        if (!jdField_a_of_type_JavaUtilMap.containsKey(localObject4)) {
          break label306;
        }
        localObject4 = (Drawable)jdField_a_of_type_JavaUtilMap.get(localObject4);
        if ((localObject1 != null) && (localObject4 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setDrawables((Drawable)localObject1, (Drawable)localObject4, null);
        }
      }
      if (!((File)localObject5).exists()) {
        a((File)localObject5, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_d_of_type_JavaLangString);
      }
      if (!localFile.exists()) {
        a(localFile, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_e_of_type_JavaLangString);
      }
      return;
      label301:
      Object localObject3 = null;
      continue;
      label306:
      localObject4 = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    case 263: 
    default: 
      return false;
    case 269: 
      e();
      return false;
    case 268: 
      if (a()) {
        return false;
      }
      break;
    case 267: 
      f();
      return false;
    case 266: 
      g();
      return false;
    case 265: 
      if (b()) {
        return false;
      }
      break;
    case 264: 
      l();
      return false;
    case 262: 
      h();
      return false;
    case 261: 
      i();
      return false;
    case 260: 
      if (e()) {
        return false;
      }
      break;
    case 259: 
      k();
      return false;
    case 258: 
      j();
      return false;
    case 257: 
      a(paramMessage);
      return false;
    case 256: 
      if (d()) {
        return false;
      }
      break;
    case 255: 
      if (!c()) {
        break;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C8", this.jdField_a_of_type_Int, 0, new String[0]);
      a(false);
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramView != this.jdField_c_of_type_AndroidWidgetTextView) && (paramView != this.jdField_b_of_type_AndroidWidgetImageView))
    {
      if ((paramView != this.jdField_f_of_type_AndroidWidgetImageView) && (paramView != this.jdField_h_of_type_AndroidWidgetTextView))
      {
        if ((paramView != this.jdField_h_of_type_AndroidWidgetImageView) && (paramView != this.jdField_i_of_type_AndroidWidgetTextView))
        {
          if (paramView == this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout)
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
            if (paramView == null) {
              return;
            }
            if (!this.jdField_c_of_type_Boolean) {
              return;
            }
            int m;
            if ((paramView.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
            {
              if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
              {
                if (Build.VERSION.SDK_INT >= 11) {
                  this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.5F);
                }
                this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-2130706433);
                this.jdField_b_of_type_Boolean = true;
                this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxBoxCardHandler.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_c_of_type_Long, (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_f_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
                n();
              }
              else
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131700534), 0).a();
              }
              m = 1;
            }
            else
            {
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131700524), 0).a();
              m = 2;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 2) && (((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2)).jdField_c_of_type_Int > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", m, 0, new String[] { "3" });
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 1) && (((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1)).jdField_c_of_type_Int > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", m, 0, new String[] { "2" });
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 0) && (((ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_Int > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", m, 0, new String[] { "1" });
            }
          }
          else if ((this == paramView) && (this.jdField_c_of_type_Boolean) && (!this.jdField_e_of_type_Boolean))
          {
            VipUtils.a(null, "cmshow", "Apollo", "clickblackfloat", this.jdField_a_of_type_Int, 0, new String[0]);
            a(false);
          }
        }
        else
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData;
          if (paramView == null) {
            return;
          }
          if (paramView.jdField_a_of_type_JavaUtilList.size() > 2)
          {
            paramView = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(2);
            if (!TextUtils.isEmpty(paramView.jdField_b_of_type_JavaLangString))
            {
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
              VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, paramView.jdField_b_of_type_JavaLangString, -1L, (Intent)localObject1, false, -1);
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C001", this.jdField_a_of_type_Int, 0, new String[0]);
            }
          }
          a(false);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData == null) {
          return;
        }
        paramView = new StringBuilder();
        paramView.append(ApolloConstant.r);
        paramView.append("&adtag=floatlayer");
        localObject1 = paramView.toString();
        paramView = (View)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 1)
        {
          localObject2 = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(1);
          paramView = (View)localObject1;
          if (!TextUtils.isEmpty(((ApolloBoxData.BoxCardListSummary)localObject2).jdField_b_of_type_JavaLangString)) {
            paramView = ((ApolloBoxData.BoxCardListSummary)localObject2).jdField_b_of_type_JavaLangString;
          }
        }
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, paramView, -1L, (Intent)localObject1, false, -1);
        VipUtils.a(null, "cmshow", "Apollo", "0X80065C03", this.jdField_a_of_type_Int, 0, new String[0]);
        a(false);
      }
    }
    else
    {
      if (!this.jdField_c_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData == null) {
        return;
      }
      localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      paramView = new StringBuilder();
      paramView.append(ApolloConstant.s);
      paramView.append("&adtag=floatlayer");
      localObject1 = paramView.toString();
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        ApolloBoxData.BoxCardListSummary localBoxCardListSummary = (ApolloBoxData.BoxCardListSummary)this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloBoxData.jdField_a_of_type_JavaUtilList.get(0);
        paramView = (View)localObject1;
        if (!TextUtils.isEmpty(localBoxCardListSummary.jdField_b_of_type_JavaLangString)) {
          paramView = localBoxCardListSummary.jdField_b_of_type_JavaLangString;
        }
      }
      ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.a(this.jdField_a_of_type_AndroidContentContext, paramView, -1L, (Intent)localObject2, false, -1);
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C01", this.jdField_a_of_type_Int, 0, new String[0]);
      a(false);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (m != 0)
    {
      if (m != 1) {
        if (m != 2)
        {
          if (m != 3) {
            break label137;
          }
        }
        else
        {
          if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_d_of_type_Float - f2)) <= this.jdField_i_of_type_Int) {
            break label137;
          }
          this.jdField_e_of_type_Boolean = true;
          break label137;
        }
      }
      if (Math.hypot(Math.abs(this.jdField_c_of_type_Float - f1), Math.abs(this.jdField_d_of_type_Float - f2)) > this.jdField_i_of_type_Int) {
        this.jdField_e_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_c_of_type_Float = f1;
      this.jdField_d_of_type_Float = f2;
      this.jdField_e_of_type_Boolean = false;
    }
    label137:
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow
 * JD-Core Version:    0.7.0.1
 */