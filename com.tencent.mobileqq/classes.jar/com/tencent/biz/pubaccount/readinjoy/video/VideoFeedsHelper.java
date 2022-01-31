package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import mbx;
import mby;
import mbz;
import mca;
import mcb;
import mcc;
import mcd;
import mce;
import mcf;
import mcg;
import mch;
import mci;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VideoFeedsHelper
{
  private static int jdField_a_of_type_Int;
  public static Dialog a;
  static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static DecimalFormat jdField_a_of_type_JavaTextDecimalFormat;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static DecimalFormat jdField_b_of_type_JavaTextDecimalFormat;
  private static boolean jdField_b_of_type_Boolean;
  
  public static int a(Activity paramActivity)
  {
    return (int)(a(paramActivity)[0] * 9.0F / 16.0F);
  }
  
  private static Drawable a(Context paramContext)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(AIOUtils.a(3.0F, paramContext.getResources()));
    localGradientDrawable.setColor(-1728053248);
    localGradientDrawable.setStroke(1, 0);
    return localGradientDrawable;
  }
  
  public static Long a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.busiType == 1)
    {
      if (TextUtils.isEmpty(paramBaseArticleInfo.mSubscribeID)) {}
      for (long l = 0L;; l = Long.valueOf(paramBaseArticleInfo.mSubscribeID).longValue()) {
        return Long.valueOf(l);
      }
    }
    if (paramBaseArticleInfo.busiType == 6)
    {
      if (ReadInJoyBaseAdapter.f((ArticleInfo)paramBaseArticleInfo)) {
        return Long.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      }
      return Long.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
    }
    return Long.valueOf(paramBaseArticleInfo.thirdUin);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    return "播放 " + e(paramInt);
  }
  
  public static String a(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 1000L / 60L), Long.valueOf(paramLong / 1000L % 60L) });
  }
  
  public static String a(View paramView)
  {
    if (paramView.getId() == -1) {
      return "no-id";
    }
    return paramView.getResources().getResourceName(paramView.getId());
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.busiType == 1) || (paramBaseArticleInfo.busiType == 6)) {
      return paramBaseArticleInfo.getSubscribeName();
    }
    return paramBaseArticleInfo.thirdUinName;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return MD5Utils.d(paramQQAppInterface.getCurrentAccountUin() + "_" + paramString + "_" + System.currentTimeMillis());
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Intent localIntent = new Intent(paramActivity, VideoFeedsPlayActivity.class);
    localIntent.putExtra("VIDEO_ARTICLE_ID", paramString1);
    localIntent.putExtra("VIDEO_ARTICLE_BUSITYPE", paramInt1);
    localIntent.putExtra("VIDEO_VID", paramString2);
    localIntent.putExtra("VIDEO_WIDTH", String.valueOf(paramInt2));
    localIntent.putExtra("VIDEO_HEIGHT", String.valueOf(paramInt3));
    localIntent.putExtra("VIDEO_TIME", String.valueOf(paramInt4));
    localIntent.putExtra("VIDEO_TITLE", paramString3);
    localIntent.putExtra("VIDEO_COVER", paramString4);
    localIntent.putExtra("VIDEO_H5_URL", paramString5);
    localIntent.putExtra("VIDEO_PUB_ACCOUNT_NAME", paramString6);
    localIntent.putExtra("VIDEO_PUB_ACCOUNT_UIN", paramString7);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034194, 2131034195);
  }
  
  public static void a(Context paramContext, TextView paramTextView)
  {
    int i = "流量不足？试试大王卡免流量播放".indexOf("大王卡");
    SpannableString localSpannableString = new SpannableString("流量不足？试试大王卡免流量播放");
    localSpannableString.setSpan(new mbz(paramContext), i, i + 3, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    if ((jdField_a_of_type_AndroidAppDialog != null) && (jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      jdField_a_of_type_AndroidAppDialog.dismiss();
      jdField_a_of_type_AndroidAppDialog = null;
      label25:
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      TextView localTextView = new TextView(paramContext);
      localTextView.setText(paramString);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setGravity(17);
      localTextView.setBackgroundDrawable(a(paramContext));
      int i = AIOUtils.a(16.0F, paramContext.getResources());
      localTextView.setPadding(i, 0, i, 0);
      paramString = new Dialog(paramContext, 2131624720);
      paramString.setContentView(localTextView, new ViewGroup.LayoutParams(-2, DisplayUtil.a(paramContext, 40.0F)));
      paramString.getWindow().setBackgroundDrawable(new ColorDrawable(0));
      paramString.setCanceledOnTouchOutside(false);
      paramContext = paramString.getWindow().getAttributes();
      paramContext.gravity = 49;
      paramContext.y = paramInt;
      paramString.getWindow().setFlags(16, 16);
      try
      {
        paramString.show();
        label186:
        jdField_a_of_type_AndroidAppDialog = paramString;
        jdField_a_of_type_AndroidOsHandler.postDelayed(new mby(), 1000L);
        return;
      }
      catch (Exception paramContext)
      {
        break label186;
      }
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public static void a(View paramView, int paramInt)
  {
    a(paramView, paramInt, 300);
  }
  
  @TargetApi(11)
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (!VersionUtils.e()) {
      b(paramView, paramInt1, paramInt2);
    }
    do
    {
      return;
      if (paramInt1 == 0)
      {
        paramView.setVisibility(0);
        localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
        localObjectAnimator.setDuration(paramInt2);
        localObjectAnimator.setInterpolator(new DecelerateInterpolator());
        localObjectAnimator.setRepeatCount(0);
        localObjectAnimator.start();
        paramView.setLayerType(2, null);
        localObjectAnimator.addListener(new mce(paramView));
        localObjectAnimator.start();
        return;
      }
    } while ((paramInt1 != 8) && (paramInt1 != 4));
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(paramInt2);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator());
    localObjectAnimator.setRepeatCount(0);
    localObjectAnimator.start();
    paramView.setLayerType(2, null);
    localObjectAnimator.addListener(new mcf(paramView));
    localObjectAnimator.start();
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.postDelayed(new mcd(paramView, paramInt1, paramInt2), paramInt3);
  }
  
  public static void a(ImageView paramImageView, int paramInt)
  {
    Drawable localDrawable = paramImageView.getDrawable();
    if (localDrawable != null) {
      if ((localDrawable instanceof URLDrawable))
      {
        ((URLDrawable)localDrawable).setURLDrawableListener(new mbx(paramInt));
        if (((URLDrawable)localDrawable).getCurrDrawable() != null) {
          ((URLDrawable)localDrawable).getCurrDrawable().mutate().setAlpha(paramInt);
        }
      }
    }
    while (paramImageView.getBackground() == null)
    {
      return;
      paramImageView.setAlpha(paramInt);
      return;
    }
    paramImageView.getBackground().mutate().setAlpha(paramInt);
  }
  
  public static void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView != null)
    {
      if (paramInt != 0) {
        break label16;
      }
      paramTextView.setText("赞");
    }
    label16:
    do
    {
      return;
      if (paramInt <= 999)
      {
        paramTextView.setText("" + paramInt);
        return;
      }
    } while (paramInt <= 999);
    paramTextView.setText("999+");
  }
  
  public static void a(TextView paramTextView, long paramLong)
  {
    if (paramLong >= 2147483647L) {}
    while (paramTextView == null) {
      return;
    }
    long l = paramLong / 1000L / 60L;
    paramLong = paramLong / 1000L % 60L;
    StringBuilder localStringBuilder = new StringBuilder();
    if (l < 10L)
    {
      localStringBuilder.append("0").append(l);
      localStringBuilder.append(":");
      if (paramLong >= 10L) {
        break label119;
      }
      localStringBuilder.append("0").append(paramLong);
    }
    for (;;)
    {
      paramTextView.post(new mci(paramTextView, localStringBuilder));
      return;
      localStringBuilder.append(l);
      break;
      label119:
      localStringBuilder.append(paramLong);
    }
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        ArticleInfo localArticleInfo = new ArticleInfo();
        localArticleInfo.innerUniqueID = paramVideoInfo.g;
        localArticleInfo.mTitle = paramVideoInfo.jdField_c_of_type_JavaLangString;
        localArticleInfo.mSubscribeName = paramVideoInfo.k;
        localArticleInfo.mSubscribeID = paramVideoInfo.j;
        localArticleInfo.mFirstPagePicUrl = paramVideoInfo.jdField_b_of_type_JavaLangString;
        localArticleInfo.mVideoDuration = paramVideoInfo.d;
        localArticleInfo.mVideoCoverUrl = paramVideoInfo.a();
        localArticleInfo.mVideoVid = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localArticleInfo.mFeedType = paramVideoInfo.jdField_f_of_type_Int;
        localArticleInfo.mFeedId = paramVideoInfo.jdField_c_of_type_Long;
        if (paramVideoInfo.jdField_b_of_type_Boolean)
        {
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = new SocializeFeedsInfo.UGCFeedsInfo();
          if (paramVideoInfo.j != null) {
            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long = Long.valueOf(paramVideoInfo.j).longValue();
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_f_of_type_Int;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b = new ArrayList();
          SocializeFeedsInfo.UGCVideoInfo localUGCVideoInfo = new SocializeFeedsInfo.UGCVideoInfo();
          localUGCVideoInfo.h = paramVideoInfo.jdField_f_of_type_JavaLangString;
          localUGCVideoInfo.e = paramVideoInfo.jdField_c_of_type_JavaLangString;
          localUGCVideoInfo.d = paramVideoInfo.jdField_b_of_type_JavaLangString;
          localUGCVideoInfo.jdField_a_of_type_Long = paramVideoInfo.d;
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.add(localUGCVideoInfo);
        }
        paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
      }
      if (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) {
        paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID = paramVideoInfo.g;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    ForwardUtils.a(paramQQAppInterface, null, paramQQAppInterface.getApplication().getApplicationContext(), localIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReadInJoyLogicEngine.a().a().a(paramQQAppInterface.getAccount(), paramString, true, new mca(paramString, paramBoolean));
      return;
    }
    PublicAccountUtil.a(paramQQAppInterface, paramQQAppInterface.getApp(), paramString, new mcb(paramBoolean), true, 17);
  }
  
  public static void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = "#00a5e0";
      }
      paramTextView.setText(paramString1);
      int i = Color.parseColor(str);
      paramString1 = new GradientDrawable();
      paramString1.setColor(i);
      paramString1.setCornerRadius(6);
      try
      {
        ApiCompatibilityUtils.a(paramTextView, paramString1);
        paramTextView.setVisibility(0);
        return;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("VideoFeedsHelper", 2, "setTagTextview: ", paramString2);
          }
          ApiCompatibilityUtils.a(paramTextView, paramString1);
        }
      }
    }
    paramTextView.setVisibility(8);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    if (ReadInJoyAtlasManager.a(paramActivity, true)) {
      DialogUtil.b(paramActivity, 230, paramActivity.getString(2131431777), paramActivity.getString(2131431778), 2131433015, 2131431779, new mcc(), null).setMessageCount(null).show();
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT <= 21) {}
    do
    {
      return false;
      if ((Build.VERSION.SDK_INT <= 21) || (Build.VERSION.SDK_INT > 23)) {
        break;
      }
    } while (DeviceInfoUtil.e() <= -2147483648L);
    return true;
    return true;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
      if (i == 0) {
        bool = false;
      }
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VideoFeedsHelper", 2, "initUI() Settings.System.ACCELEROMETER_ROTATION ERROR=" + paramContext.getMessage());
    }
    return bool;
    return true;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    while (paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536).size() <= 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(VideoInfo paramVideoInfo)
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_b_of_type_Boolean = ReadInJoyHelper.i(ReadInJoyUtils.a());
      jdField_a_of_type_Boolean = true;
    }
    return (jdField_b_of_type_Boolean) && ((!TextUtils.isEmpty(paramVideoInfo.g)) || (paramVideoInfo.jdField_a_of_type_Int == 6));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      boolean bool = ((PublicAccountDataManager)paramQQAppInterface.getManager(55)).a(Long.valueOf(paramLong));
      return bool;
    }
    catch (Exception paramQQAppInterface) {}
    return true;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, VideoInfo paramVideoInfo)
  {
    float f2 = ReadInJoyHelper.c(paramAppRuntime);
    int j = ReadInJoyHelper.J(paramAppRuntime);
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = 0.75F;
    }
    int i = j;
    if (j < 0) {
      i = 120;
    }
    return (paramVideoInfo.b() / paramVideoInfo.c() < f1) && (paramVideoInfo.a() < i);
  }
  
  @TargetApi(17)
  public static int[] a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "getScreenSize() ERROR activity == null");
      }
      return new int[] { 0, 0 };
    }
    Object localObject;
    Point localPoint;
    if ((jdField_a_of_type_Int == 0) && (jdField_b_of_type_Int == 0))
    {
      localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label248;
      }
      ((Display)localObject).getRealSize(localPoint);
      jdField_a_of_type_Int = localPoint.x;
      jdField_b_of_type_Int = localPoint.y;
    }
    for (;;)
    {
      int k = jdField_a_of_type_Int;
      int j = jdField_b_of_type_Int;
      int i = j;
      if (b())
      {
        i = j;
        if (b(paramActivity))
        {
          paramActivity = a(paramActivity);
          i = j;
          if (paramActivity != null)
          {
            i = j;
            if (paramActivity.length >= 2)
            {
              i = j;
              if (paramActivity[0] > 0)
              {
                i = j;
                if (paramActivity[1] > 0) {
                  i = jdField_b_of_type_Int - paramActivity[1];
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsHelper", 2, "getScreenSize() screenWidth=" + jdField_a_of_type_Int + ", screenHeight=" + jdField_b_of_type_Int + ", width=" + k + ", height=" + i);
      }
      return new int[] { k, i };
      label248:
      if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        jdField_a_of_type_Int = localPoint.x;
        jdField_b_of_type_Int = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        jdField_a_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
        jdField_b_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      }
    }
  }
  
  private static int[] a(Context paramContext)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getClassLoader();
        if (paramContext == null) {
          break label214;
        }
        paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
        if (paramContext == null) {
          break label214;
        }
        Method localMethod = paramContext.getMethod("getNotchSize", new Class[0]);
        if (localMethod == null) {
          break label214;
        }
        paramContext = (int[])localMethod.invoke(paramContext, new Object[0]);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsHelper", 2, "getNotchSizeInHW() ret=" + paramContext);
        }
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsHelper", 2, "getNotchSizeInHW() Exception=" + paramContext.getMessage());
      }
      finally
      {
        paramContext = arrayOfInt;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsHelper", 2, "getNotchSizeInHW() ret=" + arrayOfInt);
        return arrayOfInt;
      }
      return paramContext;
      label214:
      paramContext = arrayOfInt;
    }
  }
  
  public static Object[] a(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    int i = AIOUtils.a(75.0F, paramContext.getResources());
    int j = AIOUtils.a(6.0F, paramContext.getResources());
    paramContext = a(paramActivity);
    int m = paramContext[0];
    int k = paramContext[1];
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return new Object[] { Boolean.valueOf(false), Integer.valueOf(m) };
    }
    if (paramInt1 < paramInt2)
    {
      float f = paramInt2 / paramInt1;
      paramInt1 = (int)(m * f);
      if ((k - paramInt1) / 2.0F > i) {
        return new Object[] { Boolean.valueOf(false), Integer.valueOf(paramInt1) };
      }
      return new Object[] { Boolean.valueOf(true), Integer.valueOf(k - j) };
    }
    if (paramInt1 == paramInt2) {
      return new Object[] { Boolean.valueOf(false), Integer.valueOf(m) };
    }
    return new Object[] { Boolean.valueOf(false), Integer.valueOf((int)(paramInt2 / paramInt1 * m)) };
  }
  
  public static Object[] a(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = AIOUtils.a(paramContext.getResources().getDimension(2131559474) + 35.0F, paramContext.getResources());
    int j = AIOUtils.a(3.0F, paramContext.getResources());
    paramContext = a(paramActivity);
    int m = paramContext[0];
    int k = paramContext[1];
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      paramContext = new Object[3];
      paramContext[0] = Boolean.valueOf(false);
      paramContext[1] = Integer.valueOf(m);
      paramContext[2] = Boolean.valueOf(false);
    }
    for (;;)
    {
      return paramContext;
      boolean bool;
      if (paramInt1 < paramInt2)
      {
        paramInt1 = (int)(paramInt2 / paramInt1 * m);
        if ((k - paramInt1) / 2.0F > i)
        {
          paramContext = new Object[] { Boolean.valueOf(false), Integer.valueOf(paramInt1), Boolean.valueOf(false) };
          bool = false;
        }
      }
      while (paramBoolean)
      {
        return new Object[] { Boolean.valueOf(true), Integer.valueOf(k - j), Boolean.valueOf(bool) };
        paramContext = new Object[] { Boolean.valueOf(true), Integer.valueOf(k - j), Boolean.valueOf(true) };
        bool = true;
        continue;
        paramContext = new Object[3];
        paramContext[0] = Boolean.valueOf(false);
        paramContext[1] = Integer.valueOf((int)(paramInt2 / paramInt1 * m));
        paramContext[2] = Boolean.valueOf(false);
        bool = false;
      }
    }
  }
  
  public static int b(Activity paramActivity)
  {
    int i = a(paramActivity)[0];
    return a(paramActivity)[1] - a(paramActivity);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    return e(paramInt) + "次播放";
  }
  
  public static String b(long paramLong)
  {
    if (jdField_b_of_type_JavaTextDecimalFormat == null) {
      jdField_b_of_type_JavaTextDecimalFormat = new DecimalFormat("##0.0");
    }
    String str2 = jdField_b_of_type_JavaTextDecimalFormat.format((float)paramLong / 1048576.0F);
    String str1 = str2;
    if (str2.endsWith(".0"))
    {
      int i = str2.indexOf(".0");
      str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
    }
    return str1 + "M";
  }
  
  public static void b(View paramView, int paramInt)
  {
    b(paramView, paramInt, 300);
  }
  
  @TargetApi(11)
  public static void b(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = paramView.getVisibility();
        if (paramView.getTag(-1) != null) {
          i = ((Integer)paramView.getTag(-1)).intValue();
        }
        paramView.setTag(-1, Integer.valueOf(paramInt1));
      } while (i == paramInt1);
      if (paramInt1 == 0)
      {
        paramView.setVisibility(0);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(paramInt2);
        localAlphaAnimation.setFillAfter(true);
        localAlphaAnimation.setAnimationListener(new mcg());
        paramView.clearAnimation();
        paramView.startAnimation(localAlphaAnimation);
        return;
      }
    } while ((paramInt1 != 8) && (paramInt1 != 4));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt2);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new mch(paramView));
    paramView.clearAnimation();
    paramView.startAnimation(localAlphaAnimation);
  }
  
  private static boolean b()
  {
    return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private static boolean b(Context paramContext)
  {
    for (boolean bool1 = false;; bool1 = false)
    {
      try
      {
        paramContext = paramContext.getClassLoader();
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.loadClass("com.huawei.android.util.HwNotchSizeUtil");
        if (paramContext == null) {
          continue;
        }
        Method localMethod = paramContext.getMethod("hasNotchInScreen", new Class[0]);
        if (localMethod == null) {
          continue;
        }
        boolean bool2 = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsHelper", 2, "hasNotchInHW() ret=" + bool1);
        }
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("VideoFeedsHelper", 2, "hasNotchInHW() Exception=" + paramContext.getMessage());
      }
      finally
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("VideoFeedsHelper", 2, "hasNotchInHW() ret=" + false);
        return false;
      }
      return bool1;
    }
  }
  
  public static String c(int paramInt)
  {
    return e(paramInt);
  }
  
  public static String d(int paramInt)
  {
    if (paramInt > 999) {
      return "999+";
    }
    return Integer.toString(paramInt);
  }
  
  private static String e(int paramInt)
  {
    String str = "";
    if (jdField_a_of_type_JavaTextDecimalFormat == null) {
      jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("###.0");
    }
    if (paramInt >= 100000000) {
      str = jdField_a_of_type_JavaTextDecimalFormat.format(paramInt / 100000000.0D) + "亿";
    }
    do
    {
      return str;
      if (paramInt >= 10000) {
        return jdField_a_of_type_JavaTextDecimalFormat.format(paramInt / 10000.0D) + "万";
      }
    } while (paramInt <= 0);
    return paramInt + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper
 * JD-Core Version:    0.7.0.1
 */