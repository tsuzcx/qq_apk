package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BitmapUtil;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class GivingHeartItemBuilder
  extends BaseBubbleBuilder
  implements SixCombolEffectView.ISixAnimationListener
{
  private static Map<Long, MessageForPoke> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  protected static final Handler b;
  private static Map<Long, MessageForPoke> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static int e;
  private static int f = 0;
  public static volatile boolean f;
  int jdField_a_of_type_Int = -1;
  private LruCache<Long, MessageForPoke> jdField_a_of_type_AndroidUtilLruCache = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GivingHeartItemBuilder.PokeClickListener(this, null);
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver = new GivingHeartItemBuilder.2(this);
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  ViewAnimation jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new GivingHeartItemBuilder.VasPokeCallback(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private float jdField_b_of_type_Float = 1.0F;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GivingHeartItemBuilder.QuickBackClickListener(this);
  QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private CallBacker jdField_b_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker;
  private Map<Integer, Integer> c;
  int d = 1;
  
  static
  {
    jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public GivingHeartItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramContext);
    b(paramContext);
  }
  
  private Drawable a(MessageForPoke paramMessageForPoke, ImageView paramImageView)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PokeItemHelper.e);
    ((StringBuilder)localObject1).append(paramMessageForPoke.subId);
    ((StringBuilder)localObject1).append("/pressed.png");
    Object localObject2 = new File(((StringBuilder)localObject1).toString());
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847636);
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = new ColorDrawable();
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
    localObject2 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
    if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
      ((URLDrawable)localObject2).restartDownload();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(PokeItemHelper.e);
    ((StringBuilder)localObject3).append(paramMessageForPoke.subId);
    ((StringBuilder)localObject3).append("/normal.png");
    paramMessageForPoke = new File(((StringBuilder)localObject3).toString());
    localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
    paramMessageForPoke = URLDrawable.getDrawable(paramMessageForPoke, (URLDrawable.URLDrawableOptions)localObject3);
    localObject1 = new StateListDrawable();
    ((StateListDrawable)localObject1).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject2);
    ((StateListDrawable)localObject1).addState(new int[] { 16842908 }, paramMessageForPoke);
    ((StateListDrawable)localObject1).addState(new int[0], paramMessageForPoke);
    paramMessageForPoke.setURLDrawableListener(new GivingHeartItemBuilder.9(this, (StateListDrawable)localObject1));
    if ((paramMessageForPoke.getStatus() == 2) || (paramMessageForPoke.getStatus() == 3)) {
      paramMessageForPoke.restartDownload();
    }
    paramImageView.setImageDrawable((Drawable)localObject1);
    return paramMessageForPoke;
  }
  
  public static AnimationSet a(Context paramContext, boolean paramBoolean)
  {
    int k = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    int[] arrayOfInt = new int[4];
    int[] tmp20_18 = arrayOfInt;
    tmp20_18[0] = '';
    int[] tmp26_20 = tmp20_18;
    tmp26_20[1] = '';
    int[] tmp32_26 = tmp26_20;
    tmp32_26[2] = '';
    int[] tmp38_32 = tmp32_26;
    tmp38_32[3] = '';
    tmp38_32;
    if (paramBoolean)
    {
      i = AIOUtils.b(22.0F, paramContext.getResources());
      j = AIOUtils.b(30.0F, paramContext.getResources());
    }
    else
    {
      i = AIOUtils.b(15.0F, paramContext.getResources());
      j = AIOUtils.b(20.0F, paramContext.getResources());
    }
    if (paramBoolean)
    {
      paramContext = new int[4];
      paramContext[0] = (-i);
      paramContext[1] = i;
      paramContext[2] = (-j);
      paramContext[3] = j;
    }
    else
    {
      paramContext = new int[4];
      paramContext[0] = i;
      paramContext[1] = (-i);
      paramContext[2] = j;
      paramContext[3] = (-j);
    }
    int j = arrayOfInt.length;
    long l = 350L;
    int i = k;
    while (i < j)
    {
      TranslateAnimation localTranslateAnimation;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
              localTranslateAnimation.setDuration(arrayOfInt[i]);
              localTranslateAnimation.setStartOffset(l);
              localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
              localAnimationSet.addAnimation(localTranslateAnimation);
            }
          }
          else
          {
            localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
            localTranslateAnimation.setDuration(arrayOfInt[i]);
            l += 80L;
            localTranslateAnimation.setStartOffset(l);
            localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
            localAnimationSet.addAnimation(localTranslateAnimation);
          }
        }
        else
        {
          localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
          localTranslateAnimation.setDuration(arrayOfInt[i]);
          localTranslateAnimation.setStartOffset(l);
          localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
          localAnimationSet.addAnimation(localTranslateAnimation);
        }
      }
      else
      {
        localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
        localTranslateAnimation.setDuration(arrayOfInt[i]);
        localTranslateAnimation.setStartOffset(l);
        localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
        localAnimationSet.addAnimation(localTranslateAnimation);
      }
      l += arrayOfInt[i];
      i += 1;
    }
    return localAnimationSet;
  }
  
  private AnimationSet a(boolean paramBoolean)
  {
    AnimationSet localAnimationSet = a(this.jdField_a_of_type_AndroidContentContext, paramBoolean);
    int[] arrayOfInt2 = new int[6];
    int[] tmp18_16 = arrayOfInt2;
    tmp18_16[0] = 510;
    int[] tmp24_18 = tmp18_16;
    tmp24_18[1] = 120;
    int[] tmp29_24 = tmp24_18;
    tmp29_24[2] = 120;
    int[] tmp34_29 = tmp29_24;
    tmp34_29[3] = 120;
    int[] tmp39_34 = tmp34_29;
    tmp39_34[4] = 120;
    int[] tmp44_39 = tmp39_34;
    tmp44_39[5] = 120;
    tmp44_39;
    int[] arrayOfInt1;
    if (paramBoolean)
    {
      arrayOfInt1 = new int[7];
      int[] tmp62_60 = arrayOfInt1;
      tmp62_60[0] = -160;
      int[] tmp68_62 = tmp62_60;
      tmp68_62[1] = -10;
      int[] tmp73_68 = tmp68_62;
      tmp73_68[2] = 'ð';
      int[] tmp79_73 = tmp73_68;
      tmp79_73[3] = -120;
      int[] tmp84_79 = tmp79_73;
      tmp84_79[4] = 70;
      int[] tmp89_84 = tmp84_79;
      tmp89_84[5] = -50;
      int[] tmp94_89 = tmp89_84;
      tmp94_89[6] = 30;
      tmp94_89;
    }
    else
    {
      arrayOfInt1 = new int[7];
      int[] tmp112_110 = arrayOfInt1;
      tmp112_110[0] = ' ';
      int[] tmp118_112 = tmp112_110;
      tmp118_112[1] = 10;
      int[] tmp123_118 = tmp118_112;
      tmp123_118[2] = -240;
      int[] tmp129_123 = tmp123_118;
      tmp129_123[3] = 120;
      int[] tmp134_129 = tmp129_123;
      tmp134_129[4] = -70;
      int[] tmp139_134 = tmp134_129;
      tmp139_134[5] = 50;
      int[] tmp144_139 = tmp139_134;
      tmp144_139[6] = -30;
      tmp144_139;
    }
    int j = arrayOfInt2.length;
    int i = 0;
    long l = 1270L;
    while (i < j)
    {
      TranslateAnimation localTranslateAnimation;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
              localTranslateAnimation.setDuration(arrayOfInt2[i]);
              localTranslateAnimation.setStartOffset(l);
              localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
              localAnimationSet.addAnimation(localTranslateAnimation);
            }
          }
          else
          {
            localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
            localTranslateAnimation.setDuration(arrayOfInt2[i]);
            l += 80L;
            localTranslateAnimation.setStartOffset(l);
            localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
            localAnimationSet.addAnimation(localTranslateAnimation);
          }
        }
        else
        {
          localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
          localTranslateAnimation.setDuration(arrayOfInt2[i]);
          localTranslateAnimation.setStartOffset(l);
          localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
          localAnimationSet.addAnimation(localTranslateAnimation);
        }
      }
      else
      {
        localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
        localTranslateAnimation.setDuration(arrayOfInt2[i]);
        localTranslateAnimation.setStartOffset(l);
        localTranslateAnimation.setInterpolator(new LinearInterpolator());
        localAnimationSet.addAnimation(localTranslateAnimation);
      }
      l += arrayOfInt2[i];
      i += 1;
    }
    return localAnimationSet;
  }
  
  private static CustomFrameAnimationDrawable a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    paramCustomFrameAnimationDrawable.i();
    paramCustomFrameAnimationDrawable.a(0, 340, 2130838528);
    int i = 0;
    while (i < 6)
    {
      paramCustomFrameAnimationDrawable.a(i, 40, 2130838528 + i);
      i += 1;
    }
    int k = 5;
    i = 5;
    while (i > 0)
    {
      paramCustomFrameAnimationDrawable.a(i, 30, 2130838528 + i);
      i -= 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 6) {
        break;
      }
      paramCustomFrameAnimationDrawable.a(i, 40, 2130838528 + i);
      i += 1;
    }
    while (j > 0)
    {
      paramCustomFrameAnimationDrawable.a(j, 30, 2130838528 + j);
      j -= 1;
    }
    paramCustomFrameAnimationDrawable.a(0, 160, 2130838528);
    return paramCustomFrameAnimationDrawable;
  }
  
  @NotNull
  private CustomFrameAnimationDrawable a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, String paramString)
  {
    if (paramHolder.jdField_a_of_type_Float == 2.0F)
    {
      paramHolder = new BitmapFactory.Options();
      paramHolder.inSampleSize = 1;
      paramHolder.inMutable = true;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(PokeBigResHandler.b);
        localStringBuilder.append("/chuo_caidan/chuo_caidan_");
        localStringBuilder.append("01.png");
        paramHolder = ImageUtil.a(localStringBuilder.toString(), paramHolder);
      }
      catch (OutOfMemoryError paramHolder)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, paramHolder.toString());
        }
        paramHolder = null;
      }
      paramHolder = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramHolder, PokeItemAnimationManager.a().a(), paramMessageForPoke.mFrameState, paramString, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
      a(paramHolder);
      return paramHolder;
    }
    paramHolder = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838528);
    paramHolder = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramHolder, PokeItemAnimationManager.a().a(), paramMessageForPoke.mFrameState, paramString, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
    a(paramHolder);
    return paramHolder;
  }
  
  @NotNull
  private CustomFrameAnimationDrawable a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, String paramString1, String paramString2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a18 = a13\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return null;
            }
            return "chat_item_for_qq666";
          }
          return "chat_item_for_qqheartbroken";
        }
        return "chat_item_for_qqlikenew";
      }
      return "chat_item_for_qqbixin_light";
    }
    return "chat_item_for_qqpokenew";
  }
  
  private void a(long paramLong, MessageForPoke paramMessageForPoke)
  {
    if (this.jdField_a_of_type_AndroidUtilLruCache == null) {
      this.jdField_a_of_type_AndroidUtilLruCache = new GivingHeartItemBuilder.1(this, jdField_e_of_type_Int);
    }
    this.jdField_a_of_type_AndroidUtilLruCache.put(Long.valueOf(paramLong), paramMessageForPoke);
  }
  
  @TargetApi(17)
  private void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPokeWindowAnim ");
      localStringBuilder.append(paramBoolean1);
      QLog.d("PokeItemBuilder", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangRunnable = new GivingHeartItemBuilder.10(this, paramActivity, paramBoolean2, paramBoolean1);
    jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void a(Context paramContext)
  {
    if (jdField_e_of_type_Int == 0) {
      jdField_e_of_type_Int = (paramContext.getResources().getDisplayMetrics().heightPixels - ScreenUtil.dip2px(50.0F) * 2) / ScreenUtil.dip2px(90.0F);
    }
    if (jdField_e_of_type_Int <= 0) {
      jdField_e_of_type_Int = 10;
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, MessageForPoke paramMessageForPoke)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.a.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localLayoutParams.leftMargin = 0;
    localLayoutParams.rightMargin = 0;
    if (paramMessageForPoke.interactType == 6)
    {
      if (paramMessageForPoke.isSend()) {
        paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.v, BaseChatItemLayout.u, 0);
      } else {
        paramBaseChatItemLayout.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, 0, 0);
      }
    }
    else {
      paramBaseChatItemLayout.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, 0);
    }
    paramViewHolder.a.setLayoutParams(localLayoutParams);
  }
  
  private void a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    paramCustomFrameAnimationDrawable.i();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PokeBigResHandler.b);
    ((StringBuilder)localObject1).append("/chuo_caidan/chuo_caidan_");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("01.png");
    localObject2 = ((StringBuilder)localObject2).toString();
    int n = 0;
    paramCustomFrameAnimationDrawable.a(0, 340, (String)localObject2);
    int j = 0;
    int i = 0;
    while (j < 5)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0");
      j += 1;
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(".png");
      paramCustomFrameAnimationDrawable.a(i, 45, ((StringBuilder)localObject2).toString());
      i += 1;
    }
    int i1 = 4;
    j = 4;
    while (j > 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(j + 1);
      ((StringBuilder)localObject2).append(".png");
      paramCustomFrameAnimationDrawable.a(i, 30, ((StringBuilder)localObject2).toString());
      j -= 1;
      i += 1;
    }
    int k = 0;
    int m;
    for (;;)
    {
      m = i1;
      j = i;
      if (k >= 5) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0");
      k += 1;
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(".png");
      paramCustomFrameAnimationDrawable.a(i, 45, ((StringBuilder)localObject2).toString());
      i += 1;
    }
    while (m > 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append(m + 1);
      ((StringBuilder)localObject2).append(".png");
      paramCustomFrameAnimationDrawable.a(j, 30, ((StringBuilder)localObject2).toString());
      m -= 1;
      j += 1;
    }
    i = j + 1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("01.png");
    paramCustomFrameAnimationDrawable.a(j, 240, ((StringBuilder)localObject2).toString());
    k = n;
    j = i;
    for (;;)
    {
      m = 8;
      i = j;
      if (k >= 8) {
        break;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0");
      k += 1;
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(".png");
      paramCustomFrameAnimationDrawable.a(j, 30, ((StringBuilder)localObject2).toString());
      j += 1;
    }
    while (m < 10)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0");
      m += 1;
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(".png");
      paramCustomFrameAnimationDrawable.a(i, 150, ((StringBuilder)localObject2).toString());
      i += 1;
    }
    j = 9;
    while (j >= 0)
    {
      k = i;
      if (j % 2 == 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("0");
        ((StringBuilder)localObject2).append(j + 1);
        ((StringBuilder)localObject2).append(".png");
        paramCustomFrameAnimationDrawable.a(i, 40, ((StringBuilder)localObject2).toString());
        k = i + 1;
      }
      j -= 1;
      i = k;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("01.png");
    paramCustomFrameAnimationDrawable.a(i, 330, ((StringBuilder)localObject2).toString());
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, SixCombolEffectView paramSixCombolEffectView)
  {
    paramSixCombolEffectView = paramSixCombolEffectView.a();
    if ((paramSixCombolEffectView != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramSixCombolEffectView))
    {
      int i = SixCombolEffectView.jdField_a_of_type_Int;
      if ((i != 1) && (i != 2) && (i != 3))
      {
        a(paramHolder);
        return;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    a(paramHolder);
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((paramHolder.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke))) {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "[status]played");
    }
    if (!paramMessageForPoke.isPlayed) {
      paramMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.remove(Long.valueOf(paramMessageForPoke.uniseq));
    }
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(paramLayoutParams);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new GivingHeartItemBuilder.8(this, paramHolder, paramMessageForPoke));
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, RelativeLayout.LayoutParams paramLayoutParams3)
  {
    int i = paramMessageForPoke.strength;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F) - ScreenUtil.dip2px(40.0F));
          paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(38.0F)));
          return;
        }
        paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F) - ScreenUtil.dip2px(20.0F));
        paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(36.0F)));
        return;
      }
      paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F) - ScreenUtil.dip2px(10.0F));
      paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(35.0F)));
      return;
    }
    paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F));
    paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(34.0F)));
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, RelativeLayout.LayoutParams paramLayoutParams3, RelativeLayout.LayoutParams paramLayoutParams4, RelativeLayout.LayoutParams paramLayoutParams5)
  {
    paramLayoutParams1.height = ScreenUtil.dip2px(70.0F);
    paramLayoutParams1.topMargin = ScreenUtil.dip2px(10.0F);
    paramLayoutParams1.bottomMargin = ScreenUtil.dip2px(10.0F);
    paramLayoutParams4.width = ScreenUtil.dip2px(70.0F);
    paramLayoutParams4.height = ScreenUtil.dip2px(70.0F);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramLayoutParams2.height = ScreenUtil.dip2px(90.0F);
    paramLayoutParams3.leftMargin = 0;
    paramLayoutParams3.rightMargin = 0;
    paramLayoutParams3.width = ScreenUtil.dip2px(90.0F);
    paramLayoutParams3.height = ScreenUtil.dip2px(90.0F);
    paramLayoutParams1 = this.c;
    if ((paramLayoutParams1 != null) && (!paramLayoutParams1.isEmpty()) && (this.c.containsKey(Integer.valueOf(paramMessageForPoke.subId))))
    {
      int i = ((Integer)this.c.get(Integer.valueOf(paramMessageForPoke.subId))).intValue();
      if ((4 != i) && (5 != i))
      {
        paramLayoutParams1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838171);
        paramLayoutParams2 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838172);
        paramLayoutParams1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramLayoutParams1, paramLayoutParams2);
      }
      else
      {
        paramLayoutParams1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838173);
        paramLayoutParams2 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838174);
        paramLayoutParams1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramLayoutParams1, paramLayoutParams2);
      }
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramLayoutParams1);
    }
    if (paramMessageForPoke.isSend())
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
      paramLayoutParams4.leftMargin = ScreenUtil.dip2px(20.0F);
      paramLayoutParams4.rightMargin = 0;
      paramLayoutParams4.topMargin = ScreenUtil.dip2px(10.0F);
      paramLayoutParams4.bottomMargin = 0;
    }
    else
    {
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(-1.0F);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(-1.0F);
      paramLayoutParams4.rightMargin = ScreenUtil.dip2px(20.0F);
      paramLayoutParams4.leftMargin = 0;
      paramLayoutParams4.topMargin = ScreenUtil.dip2px(10.0F);
      paramLayoutParams4.bottomMargin = 0;
      paramLayoutParams5.leftMargin = (paramLayoutParams4.width + ScreenUtil.dip2px(10.0F) - ScreenUtil.dip2px(6.0F));
      paramLayoutParams5.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(34.0F)));
    }
    paramLayoutParams1 = a(paramMessageForPoke, paramHolder.jdField_a_of_type_AndroidWidgetImageView);
    boolean bool1 = PokeItemHelper.a("bubble", paramMessageForPoke.subId) ^ true;
    boolean bool2 = PokeItemHelper.a("/normal.png", paramMessageForPoke.subId) ^ true;
    if ((bool1) && (bool2)) {
      d(paramHolder, paramMessageForPoke);
    } else if ((bool1) || (bool2)) {
      if ((!PokeItemHelper.c.contains(Integer.valueOf(paramMessageForPoke.subId))) && (!PokeItemHelper.d.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramLayoutParams1);
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, RelativeLayout.LayoutParams paramLayoutParams3, RelativeLayout.LayoutParams paramLayoutParams4, RelativeLayout.LayoutParams paramLayoutParams5, RelativeLayout.LayoutParams paramLayoutParams6, RelativeLayout.LayoutParams paramLayoutParams7)
  {
    paramLayoutParams1.height = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 90.0F);
    paramLayoutParams1.width = a(paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), paramHolder);
    paramLayoutParams1.topMargin = ScreenUtil.dip2px(0.0F);
    paramLayoutParams1.bottomMargin = ScreenUtil.dip2px(0.0F);
    paramLayoutParams6.height = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 90.0F);
    paramLayoutParams3.width = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 90.0F);
    paramLayoutParams3.height = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 90.0F);
    paramLayoutParams7.width = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 90.0F);
    paramLayoutParams7.height = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 90.0F);
    paramLayoutParams4.width = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 80.0F);
    paramLayoutParams4.height = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 70.0F);
    paramLayoutParams4.topMargin = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 10.0F);
    paramLayoutParams4.bottomMargin = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 10.0F);
    paramLayoutParams2.height = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 90.0F);
    paramLayoutParams4.leftMargin = 0;
    paramLayoutParams4.rightMargin = 0;
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
    paramLayoutParams1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838171);
    paramLayoutParams2 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838172);
    paramLayoutParams1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramLayoutParams1, paramLayoutParams2);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramLayoutParams1);
    if (paramMessageForPoke.isSendFromLocal())
    {
      paramLayoutParams3.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296381);
      paramLayoutParams3.leftMargin = 0;
    }
    else
    {
      if ((paramHolder.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke)))
      {
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        if (!paramMessageForPoke.hasQuickBackShowed)
        {
          paramMessageForPoke.hasQuickBackShowed = true;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8008912", "0X8008912", 0, 0, "", "", "", "");
        }
      }
      else
      {
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramLayoutParams3.leftMargin = ScreenUtil.dip2px(paramHolder.jdField_a_of_type_Float * 10.0F);
      paramLayoutParams3.rightMargin = 0;
      paramLayoutParams5.rightMargin = 0;
      a(paramHolder, paramMessageForPoke, paramLayoutParams3, paramLayoutParams4, paramLayoutParams5);
    }
    paramLayoutParams1 = PokeItemHelper.a(paramMessageForPoke.interactType, paramMessageForPoke.isSend(), this.jdField_a_of_type_AndroidContentContext.getResources());
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramLayoutParams1);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a(paramMessageForPoke, paramHolder.jdField_a_of_type_Float);
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramCustomFrameAnimationDrawable);
    paramCustomFrameAnimationDrawable.a(new GivingHeartItemBuilder.7(this, paramHolder, paramMessageForPoke));
    paramCustomFrameAnimationDrawable.d();
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "[status]playing");
    }
  }
  
  private void a(ChatMessage paramChatMessage, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    if ((paramMessageForPoke.isPlayed) && (!paramMessageForPoke.mFrameState.a) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))))
    {
      b(paramHolder, paramMessageForPoke);
      return;
    }
    Object localObject = a(paramMessageForPoke.interactType);
    GivingHeartItemBuilder.FileNumEntity localFileNumEntity = a(paramMessageForPoke);
    String str = localFileNumEntity.jdField_a_of_type_JavaLangString;
    int i = localFileNumEntity.jdField_a_of_type_Int;
    if ((paramMessageForPoke.interactType != 1) && (paramMessageForPoke.interactType > 0) && (paramMessageForPoke.interactType <= 6)) {
      localObject = a(paramHolder, paramMessageForPoke, (String)localObject, str, i);
    } else {
      localObject = a(paramHolder, paramMessageForPoke, (String)localObject);
    }
    ((CustomFrameAnimationDrawable)localObject).a(1);
    if (!paramChatMessage.isSend()) {
      if (paramMessageForPoke.interactType != 5) {
        ((CustomFrameAnimationDrawable)localObject).b();
      } else {
        ((CustomFrameAnimationDrawable)localObject).a(2);
      }
    }
    ((CustomFrameAnimationDrawable)localObject).h();
    if (paramMessageForPoke.mFrameState.a)
    {
      a(paramHolder, paramMessageForPoke, (CustomFrameAnimationDrawable)localObject);
      return;
    }
    if (paramMessageForPoke.mFrameState.c)
    {
      a(paramHolder, paramMessageForPoke);
      return;
    }
    if (!AIOUtils.l) {
      a(paramChatMessage, paramHolder, paramMessageForPoke, (CustomFrameAnimationDrawable)localObject);
    }
  }
  
  private void a(ChatMessage paramChatMessage, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int i = AIOUtils.jdField_a_of_type_Int;
    boolean bool1 = true;
    AIOUtils.jdField_a_of_type_Int = i + 1;
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    paramCustomFrameAnimationDrawable.a(new GivingHeartItemBuilder.6(this, paramHolder, paramMessageForPoke));
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramCustomFrameAnimationDrawable);
    paramCustomFrameAnimationDrawable.c();
    a(paramMessageForPoke.uniseq, paramMessageForPoke);
    if (paramHolder.jdField_a_of_type_Float == 2.0F) {
      if (paramMessageForPoke.interactType == 2)
      {
        PokeItemAnimationManager.a().a(1);
        PokeItemAnimationManager.a().a(2, 1500L, paramMessageForPoke.isSend());
      }
      else if (paramMessageForPoke.interactType == 3)
      {
        PokeItemAnimationManager.a().a(4);
        PokeItemAnimationManager.a().a(5, 700L);
      }
      else if (paramMessageForPoke.interactType == 4)
      {
        PokeItemAnimationManager.a().a(13);
        PokeItemAnimationManager.a().a(14, 800L);
      }
    }
    if ((paramMessageForPoke.interactType == 1) || (paramMessageForPoke.interactType == 0))
    {
      paramCustomFrameAnimationDrawable = (Activity)this.jdField_a_of_type_AndroidContentContext;
      boolean bool2 = paramChatMessage.isSend();
      if (paramHolder.jdField_a_of_type_Float != 2.0F) {
        bool1 = false;
      }
      a(paramCustomFrameAnimationDrawable, bool2, bool1);
    }
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("[status]start to play duobleHit:");
      paramChatMessage.append(paramMessageForPoke.doubleHitState);
      paramChatMessage.append(" type:");
      paramChatMessage.append(paramMessageForPoke.msgtype);
      QLog.d("GivingHeart", 2, paramChatMessage.toString());
    }
  }
  
  private boolean a(Context paramContext, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((PokeBigResHandler.a) && (!(paramContext instanceof ChatHistoryActivity))) {
      return false;
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    paramContext = (PokeBigResHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.POKE_BIG_RES_HANDLER);
    if (paramContext != null) {
      paramContext.a(true);
    }
    if (paramMessageForPoke.isSend()) {
      paramMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return true;
  }
  
  private boolean a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((paramMessageForPoke.interactType == 5) && (paramHolder.jdField_a_of_type_Float == 2.0F))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if (!paramMessageForPoke.isPlayed) {
        c(paramHolder);
      } else {
        b(paramHolder);
      }
      return true;
    }
    return false;
  }
  
  @Deprecated
  public static boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool3 = paramMessageRecord instanceof MessageForPoke;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if ((((MessageForPoke)paramMessageRecord).flag & 0x1) == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String b(ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(paramChatMessage.msg)) {
      paramChatMessage = HardCodeUtil.a(2131705369);
    } else {
      paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1);
    }
    try
    {
      Integer.parseInt(paramChatMessage);
      return paramChatMessage;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return paramChatMessage;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new GivingHeartItemBuilder.3(this));
    paramContext = new RelativeLayout.LayoutParams(1, 1);
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288);
    if (localViewGroup != null) {
      localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation = new ViewAnimation(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.c = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new GivingHeartItemBuilder.4(this);
    e();
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
    }
  }
  
  private void b(GivingHeartItemBuilder.Holder paramHolder)
  {
    if (SixCombolEffectView.jdField_a_of_type_Int > 0)
    {
      a(paramHolder, ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288)).a());
      return;
    }
    a(paramHolder);
  }
  
  private void b(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "[status]has already played");
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((paramHolder.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (paramMessageForPoke.interactType != 126) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke))) {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
  }
  
  private boolean b(Context paramContext, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    int i = paramMessageForPoke.interactType;
    boolean bool1 = false;
    if (126 == i)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if ((!paramMessageForPoke.isSend()) && (paramHolder.jdField_b_of_type_Int == f) && (paramMessageForPoke.isPlayed) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke))) {
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      boolean bool3 = paramMessageForPoke.isPlayed;
      boolean bool2 = true;
      bool1 = bool2;
      if (!bool3)
      {
        bool1 = bool2;
        if (!paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())
        {
          if ((((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a() ^ true))
          {
            ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "vas_poke", true);
            if (QLog.isColorLevel()) {
              QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in play.");
            }
          }
          PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramHolder, paramMessageForPoke.subId, "bubble");
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  private String c(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (TextUtils.isEmpty(paramChatMessage.msg)) {
      paramChatMessage = HardCodeUtil.a(2131705368);
    } else {
      paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1);
    }
    try
    {
      Integer.parseInt(paramChatMessage);
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("回复");
      localStringBuilder2.append(paramChatMessage);
      localStringBuilder2.append("动作");
      localStringBuilder1.append(localStringBuilder2.toString());
      return localStringBuilder1.toString();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder2;
      label95:
      break label95;
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("回复");
    localStringBuilder2.append(paramChatMessage);
    localStringBuilder2.append("动作");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
  
  private void c(GivingHeartItemBuilder.Holder paramHolder)
  {
    SixCombolEffectView localSixCombolEffectView = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288)).a();
    if (SixCombolEffectView.jdField_a_of_type_Int == 0)
    {
      if (!AIOUtils.l)
      {
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localSixCombolEffectView.setListener(this);
        AIOUtils.jdField_a_of_type_Int += 1;
        localSixCombolEffectView.a(paramHolder, PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
    }
    else {
      a(paramHolder, localSixCombolEffectView);
    }
  }
  
  private void c(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)((ViewGroup)paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getParent()).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams4 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams5 = (RelativeLayout.LayoutParams)paramHolder.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams6 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams7 = (RelativeLayout.LayoutParams)paramHolder.jdField_c_of_type_AndroidViewView.getLayoutParams();
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_Float = a(paramMessageForPoke);
    paramHolder.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
    f();
    if (126 == paramMessageForPoke.interactType) {
      a(paramHolder, paramMessageForPoke, localLayoutParams1, localLayoutParams2, localLayoutParams3, localLayoutParams4, localLayoutParams5);
    } else {
      a(paramHolder, paramMessageForPoke, localLayoutParams1, localLayoutParams2, localLayoutParams3, localLayoutParams4, localLayoutParams5, localLayoutParams6, localLayoutParams7);
    }
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams3);
    a(paramHolder, paramMessageForPoke, localLayoutParams1);
  }
  
  private void d(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if (PokeItemHelper.a.contains(Integer.valueOf(paramMessageForPoke.subId)))
    {
      if ((!PokeItemHelper.c.contains(Integer.valueOf(paramMessageForPoke.subId))) && (!PokeItemHelper.d.contains(Integer.valueOf(paramMessageForPoke.subId))))
      {
        paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    PokeItemHelper.a.add(Integer.valueOf(paramMessageForPoke.subId));
    PokeItemHelper.c.add(Integer.valueOf(paramMessageForPoke.subId));
    PokeItemHelper.d.add(Integer.valueOf(paramMessageForPoke.subId));
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramHolder = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("poke.item.effect.");
    localStringBuilder.append(paramMessageForPoke.subId);
    paramHolder.downloadItem(21L, localStringBuilder.toString(), "getbubbleview");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("poke.item.res.");
    localStringBuilder.append(paramMessageForPoke.subId);
    paramHolder.downloadItem(21L, localStringBuilder.toString(), "getbubbleview");
    paramHolder.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
  }
  
  private void e()
  {
    if (this.c != null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker == null) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new GivingHeartItemBuilder.5(this));
    }
  }
  
  private void e(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((paramMessageForPoke.isPlayed) && (!paramMessageForPoke.mUnlimitedState.a) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))))
    {
      i(paramHolder, paramMessageForPoke);
      return;
    }
    if (PokeBigResHandler.a) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPoke.isSend() ^ true, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface), paramHolder.jdField_a_of_type_Float);
    }
    if (paramMessageForPoke.mUnlimitedState.a)
    {
      h(paramHolder, paramMessageForPoke);
      return;
    }
    if (paramMessageForPoke.mUnlimitedState.b)
    {
      g(paramHolder, paramMessageForPoke);
      return;
    }
    if (!AIOUtils.l) {
      f(paramHolder, paramMessageForPoke);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) && ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof ChatAdapter1)))
    {
      List localList = ((ChatAdapter1)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a();
      if (localList != null)
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          ChatMessage localChatMessage = (ChatMessage)localList.get(i);
          if (((localChatMessage instanceof MessageForPoke)) && (!localChatMessage.isSend()))
          {
            f = i;
            return;
          }
          i -= 1;
        }
      }
    }
  }
  
  private void f(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    AIOUtils.jdField_a_of_type_Int += 1;
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new GivingHeartItemBuilder.11(this, paramHolder, paramMessageForPoke));
    if (QLog.isColorLevel()) {
      QLog.i("fangdazhao", 2, "[start]");
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
    a(paramMessageForPoke.uniseq, paramMessageForPoke);
  }
  
  private void g(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((paramHolder.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke))) {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    if (!paramMessageForPoke.isPlayed) {
      paramMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.remove(Long.valueOf(paramMessageForPoke.uniseq));
    }
    if (QLog.isColorLevel()) {
      QLog.d("fangdazhao", 2, "[show end]");
    }
  }
  
  private void h(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setMirror(paramMessageForPoke.isSend() ^ true);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new GivingHeartItemBuilder.12(this, paramHolder, paramMessageForPoke));
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a(paramMessageForPoke, paramMessageForPoke.isSend() ^ true, paramHolder.jdField_a_of_type_Float);
    if (QLog.isColorLevel()) {
      QLog.d("fangdazhao", 2, "[resume]");
    }
  }
  
  private void i(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((paramHolder.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke))) {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a()) {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setParams(paramMessageForPoke.isSend() ^ true);
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("fangdazhao", 2, "[showed]");
    }
  }
  
  float a(MessageForPoke paramMessageForPoke)
  {
    int i = paramMessageForPoke.strength;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return 1.0F;
        }
        return 2.0F;
      }
      return 1.6F;
    }
    return 1.3F;
  }
  
  int a(Context paramContext, GivingHeartItemBuilder.Holder paramHolder)
  {
    int i = ((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).interactType;
    paramContext = paramContext.getResources();
    switch (i)
    {
    default: 
      return AIOUtils.b(paramHolder.jdField_a_of_type_Float * 100.0F, paramContext);
    case 6: 
      return 0;
    case 5: 
      return AIOUtils.b(paramHolder.jdField_a_of_type_Float * 230.0F, paramContext);
    case 4: 
      return AIOUtils.b(paramHolder.jdField_a_of_type_Float * 100.0F, paramContext);
    case 3: 
      return AIOUtils.b(paramHolder.jdField_a_of_type_Float * 90.0F, paramContext);
    case 2: 
      return AIOUtils.b(paramHolder.jdField_a_of_type_Float * 280.0F, paramContext);
    }
    float f1;
    if (paramHolder.jdField_a_of_type_Float == 2.0F) {
      f1 = paramHolder.jdField_a_of_type_Float * 150.0F;
    } else {
      f1 = paramHolder.jdField_a_of_type_Float * 100.0F;
    }
    return AIOUtils.b(f1, paramContext);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForPoke)paramChatMessage;
    GivingHeartItemBuilder.Holder localHolder = (GivingHeartItemBuilder.Holder)paramViewHolder;
    if (QLog.isColorLevel())
    {
      paramViewHolder = new StringBuilder();
      paramViewHolder.append("type: ");
      paramViewHolder.append(paramBaseChatItemLayout.interactType);
      paramViewHolder.append(" strength: ");
      paramViewHolder.append(paramBaseChatItemLayout.strength);
      QLog.d("PokeMsg", 2, paramViewHolder.toString());
    }
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[getBubbleView]:content is null");
      }
      paramViewHolder = new RelativeLayout((Context)localObject1);
      paramViewHolder.setId(2131376809);
      paramView = new RelativeLayout((Context)localObject1);
      Object localObject4 = new DiniFlyAnimationView((Context)localObject1);
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)localObject4);
      paramView.addView((View)localObject4);
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      Object localObject3 = new ImageView((Context)localObject1);
      ((ImageView)localObject3).setId(2131374750);
      paramView = ImageUtil.a(((Context)localObject1).getResources(), 2130838171);
      Object localObject2 = ImageUtil.a(((Context)localObject1).getResources(), 2130838172);
      ((ImageView)localObject3).setImageDrawable(BitmapUtil.a(((Context)localObject1).getResources(), paramView, (Bitmap)localObject2));
      localHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramViewHolder.addView((View)localObject3);
      UnlimitedBladeWorks localUnlimitedBladeWorks = new UnlimitedBladeWorks((Context)localObject1);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks = localUnlimitedBladeWorks;
      paramViewHolder.addView(localUnlimitedBladeWorks);
      RelativeLayout localRelativeLayout = new RelativeLayout((Context)localObject1);
      localRelativeLayout.setId(2131372929);
      ImageView localImageView = new ImageView((Context)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      localRelativeLayout.addView(localImageView);
      localObject2 = new ProgressBar((Context)localObject1, null, 0);
      ((ProgressBar)localObject2).setIndeterminate(true);
      ((ProgressBar)localObject2).setIndeterminateDrawable(((Context)localObject1).getResources().getDrawable(2130839406));
      localHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
      localRelativeLayout.addView((View)localObject2);
      paramView = new ImageView((Context)localObject1);
      paramView.setId(2131378280);
      paramView.setImageResource(2130847637);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = paramView;
      localRelativeLayout.addView(paramView);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      paramViewHolder.addView(localRelativeLayout);
      View localView = new View((Context)localObject1);
      paramViewHolder.addView(localView);
      localHolder.jdField_c_of_type_AndroidViewView = localView;
      localObject4 = (RelativeLayout.LayoutParams)((DiniFlyAnimationView)localObject4).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = ScreenUtil.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12, -1);
      localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = ScreenUtil.dip2px(40.0F);
      ((RelativeLayout.LayoutParams)localObject4).width = ScreenUtil.dip2px(40.0F);
      ((ImageView)localObject3).setPadding(ScreenUtil.dip2px(6.0F), ScreenUtil.dip2px(6.0F), ScreenUtil.dip2px(6.0F), ScreenUtil.dip2px(6.0F));
      localObject3 = (RelativeLayout.LayoutParams)localUnlimitedBladeWorks.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = -1;
      ((RelativeLayout.LayoutParams)localObject3).height = ScreenUtil.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = ScreenUtil.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).height = ScreenUtil.dip2px(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296381);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296381);
      ((RelativeLayout.LayoutParams)localObject3).height = ScreenUtil.dip2px(70.0F);
      ((RelativeLayout.LayoutParams)localObject3).width = ScreenUtil.dip2px(80.0F);
      localObject1 = (RelativeLayout.LayoutParams)((ProgressBar)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Float * 23.0F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(this.jdField_a_of_type_Float * 23.0F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ScreenUtil.dip2px(10.0F);
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.width = ((int)(this.jdField_a_of_type_Float * 23.0F));
      paramView.height = ((int)(this.jdField_a_of_type_Float * 23.0F));
      paramView.addRule(12, -1);
      paramView.addRule(11, -1);
      paramView.bottomMargin = ScreenUtil.dip2px(10.0F);
    }
    else
    {
      paramViewHolder = paramView;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "[getBubbleView]set Holder's contentView");
    }
    paramViewHolder.setTag(localHolder);
    c(localHolder, paramBaseChatItemLayout);
    localHolder.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localHolder.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(c(paramChatMessage));
    if (jdField_e_of_type_Boolean)
    {
      if ((localHolder.jdField_b_of_type_JavaLangStringBuilder != null) && (localHolder.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        localHolder.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
      }
      paramViewHolder.setContentDescription(b(paramChatMessage));
    }
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new GivingHeartItemBuilder.Holder(this);
  }
  
  GivingHeartItemBuilder.FileNumEntity a(MessageForPoke paramMessageForPoke)
  {
    int j = paramMessageForPoke.interactType;
    int i = 0;
    switch (j)
    {
    default: 
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
      paramMessageForPoke.append("/chuo_icon/chuo_icon_");
      paramMessageForPoke = paramMessageForPoke.toString();
      break;
    case 6: 
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append(PokeItemAnimationManager.jdField_a_of_type_JavaLangString);
      paramMessageForPoke.append("/dazhao_icon/dazhao_icon_");
      paramMessageForPoke = paramMessageForPoke.toString();
      break;
    case 5: 
      if (paramMessageForPoke.isSend())
      {
        paramMessageForPoke = new StringBuilder();
        paramMessageForPoke.append(PokeBigResHandler.c);
        paramMessageForPoke.append("/666send_motion/666send_motion_");
        paramMessageForPoke = paramMessageForPoke.toString();
      }
      else
      {
        paramMessageForPoke = new StringBuilder();
        paramMessageForPoke.append(PokeBigResHandler.c);
        paramMessageForPoke.append("/666receive_motion/666receive_motion_");
        paramMessageForPoke = paramMessageForPoke.toString();
      }
      i = 57;
      break;
    case 4: 
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append(PokeBigResHandler.c);
      paramMessageForPoke.append("/xinsui_motion/xinsui_motion_");
      paramMessageForPoke = paramMessageForPoke.toString();
      i = 50;
      break;
    case 3: 
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append(PokeBigResHandler.c);
      paramMessageForPoke.append("/zan_motion/zan_motion_");
      paramMessageForPoke = paramMessageForPoke.toString();
      i = 20;
      break;
    case 2: 
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append(PokeBigResHandler.c);
      paramMessageForPoke.append("/bixin_motion/bixin_motion_");
      paramMessageForPoke = paramMessageForPoke.toString();
      i = 67;
      break;
    case 1: 
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append(PokeBigResHandler.c);
      paramMessageForPoke.append("/chuo_motion/chuo_motion_");
      paramMessageForPoke = paramMessageForPoke.toString();
      i = 35;
    }
    return new GivingHeartItemBuilder.FileNumEntity(paramMessageForPoke, i);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramChatMessage.time > 0L)
    {
      localStringBuilder1.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L));
      localStringBuilder1.append(" ");
    }
    String str = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1);
    try
    {
      Integer.parseInt(str);
      char[] arrayOfChar = str.toCharArray();
      int j = arrayOfChar.length;
      int i = 0;
      str = "";
      while (i < j)
      {
        char c1 = arrayOfChar[i];
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(str);
        localStringBuilder2.append(c1);
        localStringBuilder2.append(" ");
        str = localStringBuilder2.toString();
        i += 1;
      }
      if (paramChatMessage.isSend())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("我向");
        paramChatMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        paramChatMessage.append("发出动作");
        paramChatMessage.append(str);
        localStringBuilder1.append(paramChatMessage.toString());
      }
      else
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        paramChatMessage.append("发来动作");
        paramChatMessage.append(str);
        localStringBuilder1.append(paramChatMessage.toString());
      }
      return localStringBuilder1.toString();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label265:
      break label265;
    }
    if (paramChatMessage.isSend())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("我向");
      paramChatMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      paramChatMessage.append("发出动作");
      paramChatMessage.append(str);
      localStringBuilder1.append(paramChatMessage.toString());
    }
    else
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      paramChatMessage.append("发来动作");
      paramChatMessage.append(str);
      localStringBuilder1.append(paramChatMessage.toString());
    }
    return localStringBuilder1.toString();
  }
  
  public void a()
  {
    super.a();
    Object localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    MessageForPoke localMessageForPoke;
    while (((Iterator)localObject).hasNext())
    {
      localMessageForPoke = (MessageForPoke)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!localMessageForPoke.isPlayed) {
        localMessageForPoke.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localMessageForPoke.mFrameState.a = false;
      localMessageForPoke.mFrameState.c = true;
      localMessageForPoke.mUnlimitedState.a = false;
      localMessageForPoke.mUnlimitedState.b = true;
    }
    jdField_a_of_type_JavaUtilMap.clear();
    localObject = jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localMessageForPoke = (MessageForPoke)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!localMessageForPoke.isPlayed) {
        localMessageForPoke.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localMessageForPoke.mFrameState.a = false;
      localMessageForPoke.mFrameState.c = true;
      localMessageForPoke.mUnlimitedState.a = false;
      localMessageForPoke.mUnlimitedState.b = true;
    }
    jdField_b_of_type_JavaUtilMap.clear();
    localObject = this.jdField_a_of_type_AndroidUtilLruCache;
    if (localObject != null)
    {
      ((LruCache)localObject).evictAll();
      this.jdField_a_of_type_AndroidUtilLruCache = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "HIDE_PLACEHOLDER destroy");
    }
    PokeItemAnimationManager.a().a(20);
    PokeItemAnimationManager.a().a(21);
    localObject = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    ((IVasQuickUpdateService)localObject).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    ((IVasQuickUpdateService)localObject).removeCallBacker(this.jdField_b_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
    }
    AIOUtils.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(0, 0, 0, 0);
      return;
    }
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(GivingHeartItemBuilder.Holder paramHolder)
  {
    if (paramHolder != null)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if ((paramHolder.jdField_b_of_type_Int == f) && (!paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if (!((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isPlayed) {
        ((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    GivingHeartItemBuilder.Holder localHolder = (GivingHeartItemBuilder.Holder)paramViewHolder;
    MessageForPoke localMessageForPoke = (MessageForPoke)paramChatMessage;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("====> item num:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("  send:");
      localStringBuilder.append(paramChatMessage.isSend());
      QLog.d("GivingHeart", 2, localStringBuilder.toString());
    }
    if (AIOUtils.jdField_b_of_type_Int > 0)
    {
      localMessageForPoke.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMessageForPoke.mFrameState.c = true;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.remove(Long.valueOf(localMessageForPoke.uniseq));
    }
    if (b(paramContext, localHolder, localMessageForPoke)) {
      return;
    }
    if (localMessageForPoke.isSend()) {
      jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
    } else {
      jdField_b_of_type_JavaUtilMap.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
    }
    a(paramBaseChatItemLayout, paramViewHolder, localMessageForPoke);
    if (a(paramContext, localHolder, localMessageForPoke)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("Strength holder = ");
      paramContext.append(localHolder.jdField_a_of_type_Float);
      QLog.d("PokeMsg", 2, paramContext.toString());
    }
    if (a(localHolder, localMessageForPoke)) {
      return;
    }
    if (localMessageForPoke.interactType == 6)
    {
      e(localHolder, localMessageForPoke);
      return;
    }
    a(paramChatMessage, localHolder, localMessageForPoke);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPoke)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder
 * JD-Core Version:    0.7.0.1
 */