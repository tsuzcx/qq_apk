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
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
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
  private static Map<Long, MessageForPoke> jdField_a_of_type_JavaUtilMap;
  protected static final Handler b;
  private static Map<Long, MessageForPoke> jdField_b_of_type_JavaUtilMap;
  private static int e;
  private static int f = 0;
  public static volatile boolean f;
  private LruCache<Long, MessageForPoke> jdField_a_of_type_AndroidUtilLruCache = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GivingHeartItemBuilder.PokeClickListener(this, null);
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver = new GivingHeartItemBuilder.2(this);
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  ViewAnimation jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation;
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new GivingHeartItemBuilder.VasPokeCallback(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private float jdField_b_of_type_Float = 1.0F;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GivingHeartItemBuilder.QuickBackClickListener(this);
  QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  private CallBacker jdField_b_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker;
  int jdField_c_of_type_Int = -1;
  private Map<Integer, Integer> jdField_c_of_type_JavaUtilMap;
  int d = 1;
  
  static
  {
    jdField_e_of_type_Int = 0;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
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
    Object localObject2 = new File(PokeItemHelper.e + paramMessageForPoke.subId + "/pressed.png");
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847769);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable();
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    localObject2 = URLDrawable.getDrawable((File)localObject2, localURLDrawableOptions);
    if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
      ((URLDrawable)localObject2).restartDownload();
    }
    paramMessageForPoke = new File(PokeItemHelper.e + paramMessageForPoke.subId + "/normal.png");
    localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
    paramMessageForPoke = URLDrawable.getDrawable(paramMessageForPoke, localURLDrawableOptions);
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
    long l = 350L;
    int[] arrayOfInt = new int[4];
    int[] tmp25_23 = arrayOfInt;
    tmp25_23[0] = '';
    int[] tmp31_25 = tmp25_23;
    tmp31_25[1] = '';
    int[] tmp37_31 = tmp31_25;
    tmp37_31[2] = '';
    int[] tmp43_37 = tmp37_31;
    tmp43_37[3] = '';
    tmp43_37;
    int i;
    int j;
    if (paramBoolean)
    {
      i = AIOUtils.a(22.0F, paramContext.getResources());
      j = AIOUtils.a(30.0F, paramContext.getResources());
      if (!paramBoolean) {
        break label184;
      }
      paramContext = new int[4];
      paramContext[0] = (-i);
      paramContext[1] = i;
      paramContext[2] = (-j);
      paramContext[3] = j;
      label100:
      j = arrayOfInt.length;
      i = k;
      label107:
      if (i >= j) {
        break label437;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt[i];
      i += 1;
      break label107;
      i = AIOUtils.a(15.0F, paramContext.getResources());
      j = AIOUtils.a(20.0F, paramContext.getResources());
      break;
      label184:
      paramContext = new int[4];
      paramContext[0] = i;
      paramContext[1] = (-i);
      paramContext[2] = j;
      paramContext[3] = (-j);
      break label100;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      l += 80L;
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
    }
    label437:
    return localAnimationSet;
  }
  
  private AnimationSet a(boolean paramBoolean)
  {
    AnimationSet localAnimationSet = a(this.jdField_a_of_type_AndroidContentContext, paramBoolean);
    long l = 1270L;
    int[] arrayOfInt2 = new int[6];
    int[] tmp23_21 = arrayOfInt2;
    tmp23_21[0] = 510;
    int[] tmp29_23 = tmp23_21;
    tmp29_23[1] = 120;
    int[] tmp34_29 = tmp29_23;
    tmp34_29[2] = 120;
    int[] tmp39_34 = tmp34_29;
    tmp39_34[3] = 120;
    int[] tmp44_39 = tmp39_34;
    tmp44_39[4] = 120;
    int[] tmp49_44 = tmp44_39;
    tmp49_44[5] = 120;
    tmp49_44;
    int[] arrayOfInt1;
    int i;
    if (paramBoolean)
    {
      arrayOfInt1 = new int[7];
      int[] tmp67_65 = arrayOfInt1;
      tmp67_65[0] = -160;
      int[] tmp73_67 = tmp67_65;
      tmp73_67[1] = -10;
      int[] tmp78_73 = tmp73_67;
      tmp78_73[2] = 'ð';
      int[] tmp84_78 = tmp78_73;
      tmp84_78[3] = -120;
      int[] tmp89_84 = tmp84_78;
      tmp89_84[4] = 70;
      int[] tmp94_89 = tmp89_84;
      tmp94_89[5] = -50;
      int[] tmp99_94 = tmp94_89;
      tmp99_94[6] = 30;
      tmp99_94;
      int j = arrayOfInt2.length;
      i = 0;
      label112:
      if (i >= j) {
        break label447;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt2[i];
      i += 1;
      break label112;
      arrayOfInt1 = new int[7];
      int[] tmp173_171 = arrayOfInt1;
      tmp173_171[0] = ' ';
      int[] tmp179_173 = tmp173_171;
      tmp179_173[1] = 10;
      int[] tmp184_179 = tmp179_173;
      tmp184_179[2] = -240;
      int[] tmp190_184 = tmp184_179;
      tmp190_184[3] = 120;
      int[] tmp195_190 = tmp190_184;
      tmp195_190[4] = -70;
      int[] tmp200_195 = tmp195_190;
      tmp200_195[5] = 50;
      int[] tmp205_200 = tmp200_195;
      tmp205_200[6] = -30;
      tmp205_200;
      break;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      l += 80L;
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
    }
    label447:
    return localAnimationSet;
  }
  
  private static CustomFrameAnimationDrawable a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int k = 5;
    paramCustomFrameAnimationDrawable.i();
    paramCustomFrameAnimationDrawable.a(0, 340, 2130838528);
    int i = 0;
    while (i < 6)
    {
      paramCustomFrameAnimationDrawable.a(i, 40, 2130838528 + i);
      i += 1;
    }
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
        paramHolder = ImageUtil.a(PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_" + "01.png", paramHolder);
        paramHolder = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramHolder, PokeItemAnimationManager.a().a(), paramMessageForPoke.mFrameState, paramString, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
        a(paramHolder);
        return paramHolder;
      }
      catch (OutOfMemoryError paramHolder)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, paramHolder.toString());
          }
          paramHolder = null;
        }
      }
    }
    paramHolder = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838528);
    paramHolder = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramHolder, PokeItemAnimationManager.a().a(), paramMessageForPoke.mFrameState, paramString, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
    a(paramHolder);
    return paramHolder;
  }
  
  @NotNull
  private CustomFrameAnimationDrawable a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, String paramString1, String paramString2, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 1;
    localOptions.inMutable = true;
    try
    {
      Bitmap localBitmap = ImageUtil.a(paramString2 + "01.png", localOptions);
      paramString1 = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, PokeItemAnimationManager.a().a(), paramMessageForPoke.mFrameState, paramString1, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
      paramString1.i();
      i = 40;
      if (paramMessageForPoke.interactType == 2) {
        i = 30;
      }
      if ((paramMessageForPoke.interactType == 4) && (paramHolder.jdField_a_of_type_Float == 2.0F))
      {
        j = 0;
        for (;;)
        {
          if (j >= 20) {
            break label256;
          }
          if (j + 1 >= 10) {
            break;
          }
          paramString1.a(j, i, paramString2 + "0" + (j + 1) + ".png");
          j += 1;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      int i;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, localOutOfMemoryError.toString());
        }
        Object localObject = null;
        continue;
        paramString1.a(j, i, paramString2 + (j + 1) + ".png");
      }
      label256:
      int j = 20;
      while (j < paramInt)
      {
        paramString1.a(j, i, paramString2 + 21 + ".png");
        j += 1;
        continue;
        j = 0;
        if (j < paramInt)
        {
          if (j + 1 < 10) {
            paramString1.a(j, i, paramString2 + "0" + (j + 1) + ".png");
          }
          for (;;)
          {
            j += 1;
            break;
            paramString1.a(j, i, paramString2 + (j + 1) + ".png");
          }
        }
      }
      if (!paramMessageForPoke.mFrameState.jdField_a_of_type_Boolean) {
        break label462;
      }
    }
    paramHolder = null;
    try
    {
      paramMessageForPoke = paramString1.a(paramMessageForPoke.mFrameState.jdField_a_of_type_Int);
      if (paramMessageForPoke != null) {
        paramHolder = ImageUtil.a(paramMessageForPoke.jdField_a_of_type_JavaLangString, localOptions);
      }
    }
    catch (OutOfMemoryError paramHolder)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, paramHolder, new Object[0]);
        }
        paramHolder = null;
      }
    }
    catch (NullPointerException paramHolder)
    {
      for (;;)
      {
        label462:
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, paramHolder, new Object[0]);
        }
        paramHolder = null;
      }
    }
    paramString1.a(paramHolder);
    return paramString1;
  }
  
  static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "chat_item_for_qqpokenew";
    case 2: 
      return "chat_item_for_qqbixin_light";
    case 3: 
      return "chat_item_for_qqlikenew";
    case 4: 
      return "chat_item_for_qqheartbroken";
    }
    return "chat_item_for_qq666";
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
    if (QLog.isColorLevel()) {
      QLog.d("PokeItemBuilder", 2, "startPokeWindowAnim " + paramBoolean1);
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
    if (paramMessageForPoke.interactType == 6) {
      if (paramMessageForPoke.isSend()) {
        paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.v, BaseChatItemLayout.u, 0);
      }
    }
    for (;;)
    {
      paramViewHolder.a.setLayoutParams(localLayoutParams);
      return;
      paramBaseChatItemLayout.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, 0, 0);
      continue;
      paramBaseChatItemLayout.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, 0);
    }
  }
  
  private void a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int n = 8;
    int i1 = 4;
    paramCustomFrameAnimationDrawable.i();
    String str = PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_";
    paramCustomFrameAnimationDrawable.a(0, 340, str + "01.png");
    int j = 0;
    int i = 0;
    while (j < 5)
    {
      paramCustomFrameAnimationDrawable.a(i, 45, str + "0" + (j + 1) + ".png");
      j += 1;
      i += 1;
    }
    j = 4;
    while (j > 0)
    {
      paramCustomFrameAnimationDrawable.a(i, 30, str + "0" + (j + 1) + ".png");
      j -= 1;
      i += 1;
    }
    j = 0;
    int m;
    for (;;)
    {
      k = i1;
      m = i;
      if (j >= 5) {
        break;
      }
      paramCustomFrameAnimationDrawable.a(i, 45, str + "0" + (j + 1) + ".png");
      j += 1;
      i += 1;
    }
    while (k > 0)
    {
      paramCustomFrameAnimationDrawable.a(m, 30, str + "0" + (k + 1) + ".png");
      k -= 1;
      m += 1;
    }
    paramCustomFrameAnimationDrawable.a(m, 240, str + "01.png");
    j = m + 1;
    int k = 0;
    for (;;)
    {
      m = n;
      i = j;
      if (k >= 8) {
        break;
      }
      paramCustomFrameAnimationDrawable.a(j, 30, str + "0" + (k + 1) + ".png");
      k += 1;
      j += 1;
    }
    while (m < 10)
    {
      paramCustomFrameAnimationDrawable.a(i, 150, str + "0" + (m + 1) + ".png");
      m += 1;
      i += 1;
    }
    j = 9;
    if (j >= 0)
    {
      if (j % 2 != 0) {
        break label573;
      }
      k = i + 1;
      paramCustomFrameAnimationDrawable.a(i, 40, str + "0" + (j + 1) + ".png");
      i = k;
    }
    label573:
    for (;;)
    {
      j -= 1;
      break;
      paramCustomFrameAnimationDrawable.a(i, 330, str + "01.png");
      return;
    }
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, SixCombolEffectView paramSixCombolEffectView)
  {
    paramSixCombolEffectView = paramSixCombolEffectView.a();
    if ((paramSixCombolEffectView != null) && (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramSixCombolEffectView))
    {
      switch (SixCombolEffectView.jdField_a_of_type_Int)
      {
      default: 
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
    }
    for (;;)
    {
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
      return;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
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
    switch (paramMessageForPoke.strength)
    {
    default: 
      return;
    case 0: 
      paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F));
      paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(34.0F)));
      return;
    case 1: 
      paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F) - ScreenUtil.dip2px(10.0F));
      paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(35.0F)));
      return;
    case 2: 
      paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F) - ScreenUtil.dip2px(20.0F));
      paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(36.0F)));
      return;
    }
    paramLayoutParams3.leftMargin = (paramLayoutParams2.width + paramLayoutParams1.leftMargin - ScreenUtil.dip2px(6.0F) - ScreenUtil.dip2px(40.0F));
    paramLayoutParams3.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(38.0F)));
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
    int i;
    label298:
    label324:
    int j;
    if ((this.jdField_c_of_type_JavaUtilMap != null) && (!this.jdField_c_of_type_JavaUtilMap.isEmpty()) && (this.jdField_c_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramMessageForPoke.subId))))
    {
      i = ((Integer)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramMessageForPoke.subId))).intValue();
      if ((4 == i) || (5 == i))
      {
        paramLayoutParams1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838344);
        paramLayoutParams2 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838345);
        paramLayoutParams1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramLayoutParams1, paramLayoutParams2);
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramLayoutParams1);
      }
    }
    else
    {
      if (!paramMessageForPoke.isSend()) {
        break label410;
      }
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
      paramLayoutParams4.leftMargin = ScreenUtil.dip2px(20.0F);
      paramLayoutParams4.rightMargin = 0;
      paramLayoutParams4.topMargin = ScreenUtil.dip2px(10.0F);
      paramLayoutParams4.bottomMargin = 0;
      paramLayoutParams1 = a(paramMessageForPoke, paramHolder.jdField_a_of_type_AndroidWidgetImageView);
      if (PokeItemHelper.a("bubble", paramMessageForPoke.subId)) {
        break label516;
      }
      i = 1;
      if (PokeItemHelper.a("/normal.png", paramMessageForPoke.subId)) {
        break label522;
      }
      j = 1;
      label339:
      if ((i == 0) || (j == 0)) {
        break label528;
      }
      d(paramHolder, paramMessageForPoke);
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramLayoutParams1);
      return;
      paramLayoutParams1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838342);
      paramLayoutParams2 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838343);
      paramLayoutParams1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramLayoutParams1, paramLayoutParams2);
      break;
      label410:
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(-1.0F);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(-1.0F);
      paramLayoutParams4.rightMargin = ScreenUtil.dip2px(20.0F);
      paramLayoutParams4.leftMargin = 0;
      paramLayoutParams4.topMargin = ScreenUtil.dip2px(10.0F);
      paramLayoutParams4.bottomMargin = 0;
      paramLayoutParams5.leftMargin = (paramLayoutParams4.width + ScreenUtil.dip2px(10.0F) - ScreenUtil.dip2px(6.0F));
      paramLayoutParams5.topMargin = ((int)(ScreenUtil.dip2px(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.dip2px(34.0F)));
      break label298;
      label516:
      i = 0;
      break label324;
      label522:
      j = 0;
      break label339;
      label528:
      if ((i != 0) || (j != 0)) {
        if ((PokeItemHelper.c.contains(Integer.valueOf(paramMessageForPoke.subId))) || (PokeItemHelper.d.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        } else {
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
  }
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, RelativeLayout.LayoutParams paramLayoutParams3, RelativeLayout.LayoutParams paramLayoutParams4, RelativeLayout.LayoutParams paramLayoutParams5, RelativeLayout.LayoutParams paramLayoutParams6, RelativeLayout.LayoutParams paramLayoutParams7)
  {
    paramLayoutParams1.height = ScreenUtil.dip2px(90.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams1.width = a(paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getContext(), paramHolder);
    paramLayoutParams1.topMargin = ScreenUtil.dip2px(0.0F);
    paramLayoutParams1.bottomMargin = ScreenUtil.dip2px(0.0F);
    paramLayoutParams6.height = ScreenUtil.dip2px(90.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams3.width = ScreenUtil.dip2px(90.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams3.height = ScreenUtil.dip2px(90.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams7.width = ScreenUtil.dip2px(90.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams7.height = ScreenUtil.dip2px(90.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams4.width = ScreenUtil.dip2px(80.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams4.height = ScreenUtil.dip2px(70.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams4.topMargin = ScreenUtil.dip2px(10.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams4.bottomMargin = ScreenUtil.dip2px(10.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams2.height = ScreenUtil.dip2px(90.0F * paramHolder.jdField_a_of_type_Float);
    paramLayoutParams4.leftMargin = 0;
    paramLayoutParams4.rightMargin = 0;
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
    paramLayoutParams1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838342);
    paramLayoutParams2 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838343);
    paramLayoutParams1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramLayoutParams1, paramLayoutParams2);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramLayoutParams1);
    if (paramMessageForPoke.isSendFromLocal())
    {
      paramLayoutParams3.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296402);
      paramLayoutParams3.leftMargin = 0;
      paramLayoutParams1 = PokeItemHelper.a(paramMessageForPoke.interactType, paramMessageForPoke.isSend(), this.jdField_a_of_type_AndroidContentContext.getResources());
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramLayoutParams1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a(paramMessageForPoke, paramHolder.jdField_a_of_type_Float);
      return;
    }
    if ((paramHolder.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke)))
    {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!paramMessageForPoke.hasQuickBackShowed)
      {
        paramMessageForPoke.hasQuickBackShowed = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8008912", "0X8008912", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      paramLayoutParams3.leftMargin = ScreenUtil.dip2px(10.0F * paramHolder.jdField_a_of_type_Float);
      paramLayoutParams3.rightMargin = 0;
      paramLayoutParams5.rightMargin = 0;
      a(paramHolder, paramMessageForPoke, paramLayoutParams3, paramLayoutParams4, paramLayoutParams5);
      break;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
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
    if ((paramMessageForPoke.isPlayed) && (!paramMessageForPoke.mFrameState.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq)))) {
      b(paramHolder, paramMessageForPoke);
    }
    Object localObject;
    label187:
    label196:
    do
    {
      return;
      localObject = a(paramMessageForPoke.interactType);
      GivingHeartItemBuilder.FileNumEntity localFileNumEntity = a(paramMessageForPoke);
      String str = localFileNumEntity.jdField_a_of_type_JavaLangString;
      int i = localFileNumEntity.jdField_a_of_type_Int;
      if ((paramMessageForPoke.interactType == 1) || (paramMessageForPoke.interactType <= 0) || (paramMessageForPoke.interactType > 6))
      {
        localObject = a(paramHolder, paramMessageForPoke, (String)localObject);
        ((CustomFrameAnimationDrawable)localObject).a(1);
        if (!paramChatMessage.isSend())
        {
          if (paramMessageForPoke.interactType == 5) {
            break label187;
          }
          ((CustomFrameAnimationDrawable)localObject).b();
        }
      }
      for (;;)
      {
        ((CustomFrameAnimationDrawable)localObject).h();
        if (!paramMessageForPoke.mFrameState.jdField_a_of_type_Boolean) {
          break label196;
        }
        a(paramHolder, paramMessageForPoke, (CustomFrameAnimationDrawable)localObject);
        return;
        localObject = a(paramHolder, paramMessageForPoke, (String)localObject, str, i);
        break;
        ((CustomFrameAnimationDrawable)localObject).a(2);
      }
      if (paramMessageForPoke.mFrameState.c)
      {
        a(paramHolder, paramMessageForPoke);
        return;
      }
    } while (AIOUtils.l);
    a(paramChatMessage, paramHolder, paramMessageForPoke, (CustomFrameAnimationDrawable)localObject);
  }
  
  private void a(ChatMessage paramChatMessage, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    boolean bool1 = true;
    AIOUtils.jdField_a_of_type_Int += 1;
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    paramCustomFrameAnimationDrawable.a(new GivingHeartItemBuilder.6(this, paramHolder, paramMessageForPoke));
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramCustomFrameAnimationDrawable);
    paramCustomFrameAnimationDrawable.c();
    a(paramMessageForPoke.uniseq, paramMessageForPoke);
    boolean bool2;
    if (paramHolder.jdField_a_of_type_Float == 2.0F)
    {
      if (paramMessageForPoke.interactType == 2)
      {
        PokeItemAnimationManager.a().a(1);
        PokeItemAnimationManager.a().a(2, 1500L, paramMessageForPoke.isSend());
      }
    }
    else if ((paramMessageForPoke.interactType == 1) || (paramMessageForPoke.interactType == 0))
    {
      paramCustomFrameAnimationDrawable = (Activity)this.jdField_a_of_type_AndroidContentContext;
      bool2 = paramChatMessage.isSend();
      if (paramHolder.jdField_a_of_type_Float != 2.0F) {
        break label286;
      }
    }
    for (;;)
    {
      a(paramCustomFrameAnimationDrawable, bool2, bool1);
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[status]start to play duobleHit:" + paramMessageForPoke.doubleHitState + " type:" + paramMessageForPoke.msgtype);
      }
      return;
      if (paramMessageForPoke.interactType == 3)
      {
        PokeItemAnimationManager.a().a(4);
        PokeItemAnimationManager.a().a(5, 700L);
        break;
      }
      if (paramMessageForPoke.interactType != 4) {
        break;
      }
      PokeItemAnimationManager.a().a(13);
      PokeItemAnimationManager.a().a(14, 800L);
      break;
      label286:
      bool1 = false;
    }
  }
  
  private boolean a(Context paramContext, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    boolean bool = false;
    if ((!PokeBigResHandler.jdField_a_of_type_Boolean) || ((paramContext instanceof ChatHistoryActivity)))
    {
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
      bool = true;
    }
    return bool;
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
      }
      for (;;)
      {
        return true;
        b(paramHolder);
      }
    }
    return false;
  }
  
  @Deprecated
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPoke)) {
      return (((MessageForPoke)paramMessageRecord).flag & 0x1) == 1;
    }
    return false;
  }
  
  private String b(ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = HardCodeUtil.a(2131705295);; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
      try
      {
        Integer.parseInt(paramChatMessage);
        return paramChatMessage;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return paramChatMessage;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new GivingHeartItemBuilder.3(this));
    paramContext = new RelativeLayout.LayoutParams(1, 1);
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362327);
    if (localViewGroup != null) {
      localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation = new ViewAnimation(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new GivingHeartItemBuilder.4(this);
    e();
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
    }
  }
  
  private void b(GivingHeartItemBuilder.Holder paramHolder)
  {
    if (SixCombolEffectView.jdField_a_of_type_Int > 0)
    {
      a(paramHolder, ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362327)).a());
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
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      return;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private boolean b(Context paramContext, GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    int i = 0;
    if (126 == paramMessageForPoke.interactType)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if ((!paramMessageForPoke.isSend()) && (paramHolder.jdField_b_of_type_Int == f) && (paramMessageForPoke.isPlayed) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke))) {
        paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((!paramMessageForPoke.isPlayed) && (!paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
        if (!((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getSpriteContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
          break label210;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "vas_poke", true);
          if (QLog.isColorLevel()) {
            QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in play.");
          }
        }
        PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramHolder, paramMessageForPoke.subId, "bubble");
        return true;
        label210:
        i = 1;
      }
    }
    return false;
  }
  
  private String c(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = HardCodeUtil.a(2131705294);; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
      try
      {
        Integer.parseInt(paramChatMessage);
        localStringBuilder.append("回复" + paramChatMessage + "动作");
        return localStringBuilder.toString();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localStringBuilder.append("回复" + paramChatMessage + "动作");
      }
    }
    return localStringBuilder.toString();
  }
  
  private void c(GivingHeartItemBuilder.Holder paramHolder)
  {
    SixCombolEffectView localSixCombolEffectView = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362327)).a();
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
      return;
    }
    a(paramHolder, localSixCombolEffectView);
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
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams3);
      a(paramHolder, paramMessageForPoke, localLayoutParams1);
      return;
      a(paramHolder, paramMessageForPoke, localLayoutParams1, localLayoutParams2, localLayoutParams3, localLayoutParams4, localLayoutParams5, localLayoutParams6, localLayoutParams7);
    }
  }
  
  private void d(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if (PokeItemHelper.a.contains(Integer.valueOf(paramMessageForPoke.subId)))
    {
      if ((PokeItemHelper.c.contains(Integer.valueOf(paramMessageForPoke.subId))) || (PokeItemHelper.d.contains(Integer.valueOf(paramMessageForPoke.subId))))
      {
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        return;
      }
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    PokeItemHelper.a.add(Integer.valueOf(paramMessageForPoke.subId));
    PokeItemHelper.c.add(Integer.valueOf(paramMessageForPoke.subId));
    PokeItemHelper.d.add(Integer.valueOf(paramMessageForPoke.subId));
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramHolder = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    paramHolder.downloadItem(21L, "poke.item.effect." + paramMessageForPoke.subId, "getbubbleview");
    paramHolder.downloadItem(21L, "poke.item.res." + paramMessageForPoke.subId, "getbubbleview");
    paramHolder.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
  }
  
  private void e()
  {
    if ((this.jdField_c_of_type_JavaUtilMap == null) || (this.jdField_b_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker == null)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new GivingHeartItemBuilder.5(this));
  }
  
  private void e(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    if ((paramMessageForPoke.isPlayed) && (!paramMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq)))) {
      i(paramHolder, paramMessageForPoke);
    }
    label110:
    do
    {
      return;
      UnlimitedBladeWorks localUnlimitedBladeWorks;
      Context localContext;
      if (PokeBigResHandler.jdField_a_of_type_Boolean)
      {
        localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        localContext = this.jdField_a_of_type_AndroidContentContext;
        if (paramMessageForPoke.isSend()) {
          break label110;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localUnlimitedBladeWorks.a(localContext, bool, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface), paramHolder.jdField_a_of_type_Float);
        if (!paramMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean) {
          break;
        }
        h(paramHolder, paramMessageForPoke);
        return;
      }
      if (paramMessageForPoke.mUnlimitedState.b)
      {
        g(paramHolder, paramMessageForPoke);
        return;
      }
    } while (AIOUtils.l);
    f(paramHolder, paramMessageForPoke);
  }
  
  private void f()
  {
    List localList;
    int i;
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) && ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof ChatAdapter1)))
    {
      localList = ((ChatAdapter1)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a();
      if (localList != null) {
        i = localList.size() - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i);
        if (((localChatMessage instanceof MessageForPoke)) && (!localChatMessage.isSend())) {
          f = i;
        }
      }
      else
      {
        return;
      }
      i -= 1;
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
    }
    for (;;)
    {
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
      return;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  private void h(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    boolean bool2 = true;
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    UnlimitedBladeWorks localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
    if (!paramMessageForPoke.isSend())
    {
      bool1 = true;
      localUnlimitedBladeWorks.setMirror(bool1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new GivingHeartItemBuilder.12(this, paramHolder, paramMessageForPoke));
      localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
      if (paramMessageForPoke.isSend()) {
        break label147;
      }
    }
    label147:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localUnlimitedBladeWorks.a(paramMessageForPoke, bool1, paramHolder.jdField_a_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.d("fangdazhao", 2, "[resume]");
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void i(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    boolean bool = false;
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((paramHolder.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!a(paramMessageForPoke))) {
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a())
      {
        UnlimitedBladeWorks localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        if (!paramMessageForPoke.isSend()) {
          bool = true;
        }
        localUnlimitedBladeWorks.setParams(bool);
      }
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("fangdazhao", 2, "[showed]");
      }
      return;
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  float a(MessageForPoke paramMessageForPoke)
  {
    switch (paramMessageForPoke.strength)
    {
    default: 
      return 1.0F;
    case 1: 
      return 1.3F;
    case 2: 
      return 1.6F;
    }
    return 2.0F;
  }
  
  int a(Context paramContext, GivingHeartItemBuilder.Holder paramHolder)
  {
    int i = ((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).interactType;
    paramContext = paramContext.getResources();
    switch (i)
    {
    default: 
      return AIOUtils.a(paramHolder.jdField_a_of_type_Float * 100.0F, paramContext);
    case 0: 
    case 1: 
      if (paramHolder.jdField_a_of_type_Float == 2.0F) {
        return AIOUtils.a(150.0F * paramHolder.jdField_a_of_type_Float, paramContext);
      }
      return AIOUtils.a(paramHolder.jdField_a_of_type_Float * 100.0F, paramContext);
    case 2: 
      return AIOUtils.a(280.0F * paramHolder.jdField_a_of_type_Float, paramContext);
    case 3: 
      return AIOUtils.a(90.0F * paramHolder.jdField_a_of_type_Float, paramContext);
    case 4: 
      return AIOUtils.a(paramHolder.jdField_a_of_type_Float * 100.0F, paramContext);
    case 6: 
      return 0;
    }
    return AIOUtils.a(230.0F * paramHolder.jdField_a_of_type_Float, paramContext);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject1 = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForPoke)paramChatMessage;
    GivingHeartItemBuilder.Holder localHolder = (GivingHeartItemBuilder.Holder)paramViewHolder;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.interactType + " strength: " + paramBaseChatItemLayout.strength);
    }
    paramViewHolder = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[getBubbleView]:content is null");
      }
      paramViewHolder = new RelativeLayout((Context)localObject1);
      paramViewHolder.setId(2131377356);
      paramView = new RelativeLayout((Context)localObject1);
      Object localObject4 = new DiniFlyAnimationView((Context)localObject1);
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)localObject4);
      paramView.addView((View)localObject4);
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      Object localObject3 = new ImageView((Context)localObject1);
      ((ImageView)localObject3).setId(2131375235);
      paramView = ImageUtil.a(((Context)localObject1).getResources(), 2130838342);
      Object localObject2 = ImageUtil.a(((Context)localObject1).getResources(), 2130838343);
      ((ImageView)localObject3).setImageDrawable(BitmapUtil.a(((Context)localObject1).getResources(), paramView, (Bitmap)localObject2));
      localHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramViewHolder.addView((View)localObject3);
      UnlimitedBladeWorks localUnlimitedBladeWorks = new UnlimitedBladeWorks((Context)localObject1);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks = localUnlimitedBladeWorks;
      paramViewHolder.addView(localUnlimitedBladeWorks);
      RelativeLayout localRelativeLayout = new RelativeLayout((Context)localObject1);
      localRelativeLayout.setId(2131373352);
      ImageView localImageView = new ImageView((Context)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      localRelativeLayout.addView(localImageView);
      localObject2 = new ProgressBar((Context)localObject1, null, 0);
      ((ProgressBar)localObject2).setIndeterminate(true);
      ((ProgressBar)localObject2).setIndeterminateDrawable(((Context)localObject1).getResources().getDrawable(2130839549));
      localHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
      localRelativeLayout.addView((View)localObject2);
      paramView = new ImageView((Context)localObject1);
      paramView.setId(2131378891);
      paramView.setImageResource(2130847770);
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
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296402);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296402);
      ((RelativeLayout.LayoutParams)localObject3).height = ScreenUtil.dip2px(70.0F);
      ((RelativeLayout.LayoutParams)localObject3).width = ScreenUtil.dip2px(80.0F);
      localObject1 = (RelativeLayout.LayoutParams)((ProgressBar)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(23.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(23.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ScreenUtil.dip2px(10.0F);
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.width = ((int)(23.0F * this.jdField_a_of_type_Float));
      paramView.height = ((int)(23.0F * this.jdField_a_of_type_Float));
      paramView.addRule(12, -1);
      paramView.addRule(11, -1);
      paramView.bottomMargin = ScreenUtil.dip2px(10.0F);
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
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new GivingHeartItemBuilder.Holder(this);
  }
  
  GivingHeartItemBuilder.FileNumEntity a(MessageForPoke paramMessageForPoke)
  {
    int i = 0;
    switch (paramMessageForPoke.interactType)
    {
    default: 
      paramMessageForPoke = PokeItemAnimationManager.jdField_a_of_type_JavaLangString + "/chuo_icon/chuo_icon_";
    }
    for (;;)
    {
      return new GivingHeartItemBuilder.FileNumEntity(paramMessageForPoke, i);
      paramMessageForPoke = PokeBigResHandler.c + "/chuo_motion/chuo_motion_";
      i = 35;
      continue;
      paramMessageForPoke = PokeBigResHandler.c + "/bixin_motion/bixin_motion_";
      i = 67;
      continue;
      paramMessageForPoke = PokeBigResHandler.c + "/zan_motion/zan_motion_";
      i = 20;
      continue;
      paramMessageForPoke = PokeBigResHandler.c + "/xinsui_motion/xinsui_motion_";
      i = 50;
      continue;
      if (paramMessageForPoke.isSend()) {}
      for (paramMessageForPoke = PokeBigResHandler.c + "/666send_motion/666send_motion_";; paramMessageForPoke = PokeBigResHandler.c + "/666receive_motion/666receive_motion_")
      {
        i = 57;
        break;
      }
      paramMessageForPoke = PokeItemAnimationManager.jdField_a_of_type_JavaLangString + "/dazhao_icon/dazhao_icon_";
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(TimeFormatterUtils.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    Object localObject = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1);
    try
    {
      Integer.parseInt((String)localObject);
      String str = "";
      localObject = ((String)localObject).toCharArray();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        char c1 = localObject[i];
        str = str + c1 + " ";
        i += 1;
      }
      if (!paramChatMessage.isSend()) {
        break label289;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramChatMessage.isSend()) {
        localStringBuilder.append("我向" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发出动作" + (String)localObject);
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发来动作" + (String)localObject);
      }
    }
    localStringBuilder.append("我向" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发出动作" + localNumberFormatException);
    for (;;)
    {
      return localStringBuilder.toString();
      label289:
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发来动作" + localNumberFormatException);
    }
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
      localMessageForPoke.mFrameState.jdField_a_of_type_Boolean = false;
      localMessageForPoke.mFrameState.c = true;
      localMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean = false;
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
      localMessageForPoke.mFrameState.jdField_a_of_type_Boolean = false;
      localMessageForPoke.mFrameState.c = true;
      localMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean = false;
      localMessageForPoke.mUnlimitedState.b = true;
    }
    jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_AndroidUtilLruCache != null)
    {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
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
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
    }
    AIOUtils.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
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
      if ((paramHolder.jdField_b_of_type_Int != f) || (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) || (a(paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        break label106;
      }
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if (!((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isPlayed) {
        ((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
      label106:
      paramHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    GivingHeartItemBuilder.Holder localHolder = (GivingHeartItemBuilder.Holder)paramViewHolder;
    MessageForPoke localMessageForPoke = (MessageForPoke)paramChatMessage;
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "====> item num:" + paramInt1 + "  send:" + paramChatMessage.isSend());
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
    }
    for (;;)
    {
      a(paramBaseChatItemLayout, paramViewHolder, localMessageForPoke);
      if (a(paramContext, localHolder, localMessageForPoke)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "Strength holder = " + localHolder.jdField_a_of_type_Float);
      }
      if (a(localHolder, localMessageForPoke)) {
        break;
      }
      if (localMessageForPoke.interactType != 6) {
        break label269;
      }
      e(localHolder, localMessageForPoke);
      return;
      jdField_b_of_type_JavaUtilMap.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
    }
    label269:
    a(paramChatMessage, localHolder, localMessageForPoke);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPoke)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder
 * JD-Core Version:    0.7.0.1
 */