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
import android.view.ViewGroup.LayoutParams;
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
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
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
import uso;
import uuq;
import uur;
import uut;
import uuu;
import uuv;
import uuw;
import uux;
import uuz;
import uva;
import uvb;
import uvc;
import uvd;
import uve;

public class GivingHeartItemBuilder
  extends BaseBubbleBuilder
  implements SixCombolEffectView.ISixAnimationListener
{
  private static Map jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  protected static final Handler b;
  private static Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  public static volatile boolean c;
  private static int d;
  private static int e;
  private LruCache jdField_a_of_type_AndroidUtilLruCache;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new uve(this, null);
  public DiniFlyAnimationView a;
  public ViewAnimation a;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new uuv(this);
  public VasQuickUpdateManager.CallBacker a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private float jdField_b_of_type_Float = 1.0F;
  public int b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GivingHeartItemBuilder.QuickBackClickListener(this);
  public QQAppInterface b;
  private VasQuickUpdateManager.CallBacker jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker;
  public int c;
  private Map c;
  
  static
  {
    jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public GivingHeartItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new GivingHeartItemBuilder.VasPokeCallback(this);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 1;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramContext);
    b(paramContext);
  }
  
  private int a(GivingHeartItemBuilder.Holder paramHolder)
  {
    switch (((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).interactType)
    {
    default: 
      return ScreenUtil.a(paramHolder.jdField_a_of_type_Float * 100.0F);
    case 0: 
    case 1: 
      if (paramHolder.jdField_a_of_type_Float == 2.0F) {
        return ScreenUtil.a(150.0F * paramHolder.jdField_a_of_type_Float);
      }
      return ScreenUtil.a(paramHolder.jdField_a_of_type_Float * 100.0F);
    case 2: 
      return ScreenUtil.a(280.0F * paramHolder.jdField_a_of_type_Float);
    case 3: 
      return ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    case 4: 
      return ScreenUtil.a(paramHolder.jdField_a_of_type_Float * 100.0F);
    case 6: 
      return 0;
    }
    return ScreenUtil.a(230.0F * paramHolder.jdField_a_of_type_Float);
  }
  
  private AnimationSet a(boolean paramBoolean)
  {
    int k = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    long l = 350L;
    int[] arrayOfInt2 = new int[4];
    int[] tmp25_23 = arrayOfInt2;
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
    int[] arrayOfInt1;
    if (paramBoolean)
    {
      i = AIOUtils.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      if (!paramBoolean) {
        break label202;
      }
      arrayOfInt1 = new int[4];
      arrayOfInt1[0] = (-i);
      arrayOfInt1[1] = i;
      arrayOfInt1[2] = (-j);
      arrayOfInt1[3] = j;
      label111:
      j = arrayOfInt2.length;
      i = k;
      label118:
      if (i >= j) {
        break label464;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt2[i];
      i += 1;
      break label118;
      i = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break;
      label202:
      arrayOfInt1 = new int[4];
      arrayOfInt1[0] = i;
      arrayOfInt1[1] = (-i);
      arrayOfInt1[2] = j;
      arrayOfInt1[3] = (-j);
      break label111;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
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
    label464:
    return localAnimationSet;
  }
  
  private String a(int paramInt)
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
      this.jdField_a_of_type_AndroidUtilLruCache = new uuq(this, d);
    }
    this.jdField_a_of_type_AndroidUtilLruCache.put(Long.valueOf(paramLong), paramMessageForPoke);
  }
  
  @TargetApi(17)
  private void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeItemBuilder", 2, "startPokeWindowAnim " + paramBoolean1);
    }
    this.jdField_a_of_type_JavaLangRunnable = new uur(this, paramActivity, paramBoolean2, paramBoolean1);
    jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void a(Context paramContext)
  {
    if (d == 0) {
      d = (paramContext.getResources().getDisplayMetrics().heightPixels - ScreenUtil.a(50.0F) * 2) / ScreenUtil.a(90.0F);
    }
    if (d <= 0) {
      d = 10;
    }
  }
  
  private void a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int n = 8;
    int i1 = 4;
    paramCustomFrameAnimationDrawable.h();
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
  
  private void a(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    Object localObject1 = (RelativeLayout.LayoutParams)((ViewGroup)paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getParent()).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    Object localObject2 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    Object localObject3 = (RelativeLayout.LayoutParams)paramHolder.c.getLayoutParams();
    Object localObject4 = (RelativeLayout.LayoutParams)paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramHolder.jdField_b_of_type_AndroidViewView.getLayoutParams();
    paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramHolder.c.setVisibility(8);
    paramHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
    int i;
    label415:
    label480:
    int j;
    switch (paramMessageForPoke.strength)
    {
    default: 
      paramHolder.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
      f();
      if (126 != paramMessageForPoke.interactType) {
        break label1328;
      }
      localLayoutParams1.height = ScreenUtil.a(70.0F);
      localLayoutParams1.topMargin = ScreenUtil.a(10.0F);
      localLayoutParams1.bottomMargin = ScreenUtil.a(10.0F);
      ((RelativeLayout.LayoutParams)localObject2).width = ScreenUtil.a(70.0F);
      ((RelativeLayout.LayoutParams)localObject2).height = ScreenUtil.a(70.0F);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((RelativeLayout.LayoutParams)localObject1).height = ScreenUtil.a(90.0F);
      localLayoutParams2.leftMargin = 0;
      localLayoutParams2.rightMargin = 0;
      localLayoutParams2.width = ScreenUtil.a(90.0F);
      localLayoutParams2.height = ScreenUtil.a(90.0F);
      if ((this.jdField_c_of_type_JavaUtilMap != null) && (!this.jdField_c_of_type_JavaUtilMap.isEmpty()) && (this.jdField_c_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramMessageForPoke.subId))))
      {
        i = ((Integer)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramMessageForPoke.subId))).intValue();
        if ((4 == i) || (5 == i))
        {
          localObject1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837715);
          localObject4 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837716);
          localObject1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
          paramHolder.c.setImageDrawable((Drawable)localObject1);
        }
      }
      else
      {
        if (!paramMessageForPoke.isSend()) {
          break label992;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = ScreenUtil.a(20.0F);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ScreenUtil.a(10.0F);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
        localObject2 = new File(PokeItemHelper.e + paramMessageForPoke.subId + "/pressed.png");
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844062);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = new ColorDrawable();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
        localObject2 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        localObject3 = new File(PokeItemHelper.e + paramMessageForPoke.subId + "/normal.png");
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject1);
        localObject1 = URLDrawable.getDrawable((File)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject2);
        ((StateListDrawable)localObject3).addState(new int[] { 16842908 }, (Drawable)localObject1);
        ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new uvc(this, (StateListDrawable)localObject3));
        if ((((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 3)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        if (PokeItemHelper.a("bubble", paramMessageForPoke.subId)) {
          break label1098;
        }
        i = 1;
        label774:
        if (PokeItemHelper.a("/normal.png", paramMessageForPoke.subId)) {
          break label1103;
        }
        j = 1;
        label790:
        if ((i == 0) || (j == 0)) {
          break label1265;
        }
        if (!PokeItemHelper.a.contains(Integer.valueOf(paramMessageForPoke.subId))) {
          break label1120;
        }
        if ((!PokeItemHelper.c.contains(Integer.valueOf(paramMessageForPoke.subId))) && (!PokeItemHelper.d.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
          break label1109;
        }
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable((Drawable)localObject1);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams2);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(localLayoutParams1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new uvd(this, paramHolder, paramMessageForPoke));
      return;
      this.jdField_b_of_type_Float = 1.0F;
      break;
      this.jdField_b_of_type_Float = 1.3F;
      break;
      this.jdField_b_of_type_Float = 1.6F;
      break;
      this.jdField_b_of_type_Float = 2.0F;
      break;
      localObject1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837713);
      localObject4 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837714);
      localObject1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
      break label415;
      label992:
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(-1.0F);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(-1.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ScreenUtil.a(20.0F);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ScreenUtil.a(10.0F);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + ScreenUtil.a(10.0F) - ScreenUtil.a(6.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ScreenUtil.a(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.a(34.0F)));
      break label480;
      label1098:
      i = 0;
      break label774;
      label1103:
      j = 0;
      break label790;
      label1109:
      paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      label1120:
      PokeItemHelper.a.add(Integer.valueOf(paramMessageForPoke.subId));
      PokeItemHelper.c.add(Integer.valueOf(paramMessageForPoke.subId));
      PokeItemHelper.d.add(Integer.valueOf(paramMessageForPoke.subId));
      paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localObject2 = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
      ((VasQuickUpdateManager)localObject2).a(21L, "poke.item.effect." + paramMessageForPoke.subId, "getbubbleview");
      ((VasQuickUpdateManager)localObject2).a(21L, "poke.item.res." + paramMessageForPoke.subId, "getbubbleview");
      ((VasQuickUpdateManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      continue;
      label1265:
      if ((i != 0) || (j != 0)) {
        if ((PokeItemHelper.c.contains(Integer.valueOf(paramMessageForPoke.subId))) || (PokeItemHelper.d.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
          paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        } else {
          paramHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    label1328:
    localLayoutParams1.height = ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    localLayoutParams1.width = a(paramHolder);
    localLayoutParams1.topMargin = ScreenUtil.a(0.0F);
    localLayoutParams1.bottomMargin = ScreenUtil.a(0.0F);
    ((RelativeLayout.LayoutParams)localObject4).height = ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    localLayoutParams2.width = ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    localLayoutParams2.height = ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    localLayoutParams3.width = ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    localLayoutParams3.height = ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).width = ScreenUtil.a(80.0F * paramHolder.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).height = ScreenUtil.a(70.0F * paramHolder.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ScreenUtil.a(10.0F * paramHolder.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ScreenUtil.a(10.0F * paramHolder.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject1).height = ScreenUtil.a(90.0F * paramHolder.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramHolder.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
    localObject1 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837713);
    localObject4 = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130837714);
    localObject1 = BitmapUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
    paramHolder.c.setImageDrawable((Drawable)localObject1);
    if (paramMessageForPoke.isSendFromLocal())
    {
      localLayoutParams2.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558600);
      localLayoutParams2.leftMargin = 0;
    }
    for (;;)
    {
      localObject1 = PokeItemHelper.a(paramMessageForPoke.interactType, paramMessageForPoke.isSend(), this.jdField_a_of_type_AndroidContentContext.getResources());
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a(paramMessageForPoke, paramHolder.jdField_a_of_type_Float);
      break;
      if ((paramHolder.jdField_b_of_type_Int == e) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C)))
      {
        paramHolder.c.setVisibility(0);
        if (!paramMessageForPoke.hasQuickBackShowed)
        {
          paramMessageForPoke.hasQuickBackShowed = true;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8008912", "0X8008912", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        localLayoutParams2.leftMargin = ScreenUtil.a(10.0F * paramHolder.jdField_a_of_type_Float);
        localLayoutParams2.rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
        switch (paramMessageForPoke.strength)
        {
        default: 
          break;
        case 0: 
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ScreenUtil.a(6.0F));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ScreenUtil.a(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.a(34.0F)));
          break;
          paramHolder.c.setVisibility(8);
        }
      }
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ScreenUtil.a(6.0F) - ScreenUtil.a(10.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ScreenUtil.a(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.a(35.0F)));
      continue;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ScreenUtil.a(6.0F) - ScreenUtil.a(20.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ScreenUtil.a(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.a(36.0F)));
      continue;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - ScreenUtil.a(6.0F) - ScreenUtil.a(40.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(ScreenUtil.a(80.0F) * paramHolder.jdField_a_of_type_Float - ScreenUtil.a(38.0F)));
    }
  }
  
  private AnimationSet b(boolean paramBoolean)
  {
    AnimationSet localAnimationSet = a(paramBoolean);
    long l = 1270L;
    int[] arrayOfInt2 = new int[6];
    int[] tmp20_18 = arrayOfInt2;
    tmp20_18[0] = 510;
    int[] tmp26_20 = tmp20_18;
    tmp26_20[1] = 120;
    int[] tmp31_26 = tmp26_20;
    tmp31_26[2] = 120;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[3] = 120;
    int[] tmp41_36 = tmp36_31;
    tmp41_36[4] = 120;
    int[] tmp46_41 = tmp41_36;
    tmp46_41[5] = 120;
    tmp46_41;
    int[] arrayOfInt1;
    int i;
    if (paramBoolean)
    {
      arrayOfInt1 = new int[7];
      int[] tmp64_62 = arrayOfInt1;
      tmp64_62[0] = -160;
      int[] tmp70_64 = tmp64_62;
      tmp70_64[1] = -10;
      int[] tmp75_70 = tmp70_64;
      tmp75_70[2] = 'ð';
      int[] tmp81_75 = tmp75_70;
      tmp81_75[3] = -120;
      int[] tmp86_81 = tmp81_75;
      tmp86_81[4] = 70;
      int[] tmp91_86 = tmp86_81;
      tmp91_86[5] = -50;
      int[] tmp96_91 = tmp91_86;
      tmp96_91[6] = 30;
      tmp96_91;
      int j = arrayOfInt2.length;
      i = 0;
      label109:
      if (i >= j) {
        break label443;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt2[i];
      i += 1;
      break label109;
      arrayOfInt1 = new int[7];
      int[] tmp169_167 = arrayOfInt1;
      tmp169_167[0] = ' ';
      int[] tmp175_169 = tmp169_167;
      tmp175_169[1] = 10;
      int[] tmp180_175 = tmp175_169;
      tmp180_175[2] = -240;
      int[] tmp186_180 = tmp180_175;
      tmp186_180[3] = 120;
      int[] tmp191_186 = tmp186_180;
      tmp191_186[4] = -70;
      int[] tmp196_191 = tmp191_186;
      tmp196_191[5] = 50;
      int[] tmp201_196 = tmp196_191;
      tmp201_196[6] = -30;
      tmp201_196;
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
    label443:
    return localAnimationSet;
  }
  
  private static CustomFrameAnimationDrawable b(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int k = 5;
    paramCustomFrameAnimationDrawable.h();
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
  
  private String b(ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = "戳一戳";; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
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
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new uuw(this));
    paramContext = new RelativeLayout.LayoutParams(1, 1);
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131363473);
    if (localViewGroup != null) {
      localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation = new ViewAnimation(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new uux(this);
    e();
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    }
  }
  
  private void b(GivingHeartItemBuilder.Holder paramHolder, MessageForPoke paramMessageForPoke)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    UnlimitedBladeWorks localUnlimitedBladeWorks;
    if ((paramMessageForPoke.isPlayed) && (!paramMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))))
    {
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if ((paramHolder.jdField_b_of_type_Int == e) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C)))
      {
        paramHolder.c.setVisibility(0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
        if (paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a())
        {
          localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
          if (paramMessageForPoke.isSend()) {
            break label186;
          }
          label142:
          localUnlimitedBladeWorks.setParams(bool1);
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("fangdazhao", 2, "[showed]");
        }
      }
    }
    label186:
    label218:
    do
    {
      return;
      paramHolder.c.setVisibility(8);
      break;
      bool1 = false;
      break label142;
      if (PokeBigResHandler.jdField_a_of_type_Boolean)
      {
        localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        if (!paramMessageForPoke.isSend())
        {
          bool1 = true;
          localUnlimitedBladeWorks.a(localContext, bool1, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface), paramHolder.jdField_a_of_type_Float);
        }
      }
      else
      {
        if (!paramMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean) {
          break label401;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramHolder.c.setVisibility(8);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        if (paramMessageForPoke.isSend()) {
          break label391;
        }
        bool1 = true;
        localUnlimitedBladeWorks.setMirror(bool1);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new uut(this, paramHolder, paramMessageForPoke));
        localUnlimitedBladeWorks = paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        if (paramMessageForPoke.isSend()) {
          break label396;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        localUnlimitedBladeWorks.a(paramMessageForPoke, bool1, paramHolder.jdField_a_of_type_Float);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("fangdazhao", 2, "[resume]");
        return;
        bool1 = false;
        break label218;
        bool1 = false;
        break label319;
      }
      if (paramMessageForPoke.mUnlimitedState.jdField_b_of_type_Boolean)
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((paramHolder.jdField_b_of_type_Int == e) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C))) {
          paramHolder.c.setVisibility(0);
        }
        for (;;)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          if (!paramMessageForPoke.isPlayed) {
            paramMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.remove(Long.valueOf(paramMessageForPoke.uniseq));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("fangdazhao", 2, "[show end]");
          return;
          paramHolder.c.setVisibility(8);
        }
      }
    } while (AIOUtils.k);
    label319:
    AIOUtils.jdField_a_of_type_Int += 1;
    label391:
    label396:
    label401:
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramHolder.c.setVisibility(8);
    paramHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new uuu(this, paramHolder, paramMessageForPoke));
    if (QLog.isColorLevel()) {
      QLog.i("fangdazhao", 2, "[start]");
    }
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
    a(paramMessageForPoke.uniseq, paramMessageForPoke);
  }
  
  private String c(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = "戳一戳";; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
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
  
  private void e()
  {
    if ((this.jdField_c_of_type_JavaUtilMap == null) || (this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker == null)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new uuz(this));
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
          e = i;
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
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
      paramViewHolder.setId(2131362822);
      paramView = new RelativeLayout((Context)localObject1);
      Object localObject4 = new DiniFlyAnimationView((Context)localObject1);
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)localObject4);
      paramView.addView((View)localObject4);
      paramViewHolder.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      Object localObject3 = new ImageView((Context)localObject1);
      ((ImageView)localObject3).setId(2131362451);
      paramView = ImageUtil.a(((Context)localObject1).getResources(), 2130837713);
      Object localObject2 = ImageUtil.a(((Context)localObject1).getResources(), 2130837714);
      ((ImageView)localObject3).setImageDrawable(BitmapUtil.a(((Context)localObject1).getResources(), paramView, (Bitmap)localObject2));
      localHolder.c = ((ImageView)localObject3);
      paramViewHolder.addView((View)localObject3);
      UnlimitedBladeWorks localUnlimitedBladeWorks = new UnlimitedBladeWorks((Context)localObject1);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks = localUnlimitedBladeWorks;
      paramViewHolder.addView(localUnlimitedBladeWorks);
      RelativeLayout localRelativeLayout = new RelativeLayout((Context)localObject1);
      localRelativeLayout.setId(2131362450);
      ImageView localImageView = new ImageView((Context)localObject1);
      localHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      localRelativeLayout.addView(localImageView);
      localObject2 = new ProgressBar((Context)localObject1, null, 0);
      ((ProgressBar)localObject2).setIndeterminate(true);
      ((ProgressBar)localObject2).setIndeterminateDrawable(((Context)localObject1).getResources().getDrawable(2130838596));
      localHolder.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
      localRelativeLayout.addView((View)localObject2);
      paramView = new ImageView((Context)localObject1);
      paramView.setId(2131362361);
      paramView.setImageResource(2130844063);
      localHolder.jdField_b_of_type_AndroidWidgetImageView = paramView;
      localRelativeLayout.addView(paramView);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      paramViewHolder.addView(localRelativeLayout);
      View localView = new View((Context)localObject1);
      paramViewHolder.addView(localView);
      localHolder.jdField_b_of_type_AndroidViewView = localView;
      localObject4 = (RelativeLayout.LayoutParams)((DiniFlyAnimationView)localObject4).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = ScreenUtil.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12, -1);
      localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = ScreenUtil.a(40.0F);
      ((RelativeLayout.LayoutParams)localObject4).width = ScreenUtil.a(40.0F);
      ((ImageView)localObject3).setPadding(ScreenUtil.a(6.0F), ScreenUtil.a(6.0F), ScreenUtil.a(6.0F), ScreenUtil.a(6.0F));
      localObject3 = (RelativeLayout.LayoutParams)localUnlimitedBladeWorks.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = -1;
      ((RelativeLayout.LayoutParams)localObject3).height = ScreenUtil.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = ScreenUtil.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).height = ScreenUtil.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131558600);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131558600);
      ((RelativeLayout.LayoutParams)localObject3).height = ScreenUtil.a(70.0F);
      ((RelativeLayout.LayoutParams)localObject3).width = ScreenUtil.a(80.0F);
      localObject1 = (RelativeLayout.LayoutParams)((ProgressBar)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(23.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(23.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ScreenUtil.a(10.0F);
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.width = ((int)(23.0F * this.jdField_a_of_type_Float));
      paramView.height = ((int)(23.0F * this.jdField_a_of_type_Float));
      paramView.addRule(12, -1);
      paramView.addRule(11, -1);
      paramView.bottomMargin = ScreenUtil.a(10.0F);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "[getBubbleView]set Holder's contentView");
    }
    paramViewHolder.setTag(localHolder);
    a(localHolder, paramBaseChatItemLayout);
    localHolder.c.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localHolder.c.setContentDescription(c(paramChatMessage));
    if (jdField_b_of_type_Boolean)
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
  
  protected String a(ChatMessage paramChatMessage)
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
      localMessageForPoke.mUnlimitedState.jdField_b_of_type_Boolean = true;
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
      localMessageForPoke.mUnlimitedState.jdField_b_of_type_Boolean = true;
    }
    jdField_b_of_type_JavaUtilMap.clear();
    if ((PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (HapticManager.a())) {
      HapticManager.a().b();
    }
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
    localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(183);
    ((VasQuickUpdateManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    ((VasQuickUpdateManager)localObject).b(this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    }
    AIOUtils.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131375336: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.c(paramChatMessage);
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
      if ((paramHolder.jdField_b_of_type_Int != e) || (paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C))) {
        break label96;
      }
      paramHolder.c.setVisibility(0);
    }
    for (;;)
    {
      paramHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (!((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isPlayed) {
        ((MessageForPoke)paramHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
      label96:
      paramHolder.c.setVisibility(8);
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
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
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(localMessageForPoke.uniseq))) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.remove(Long.valueOf(localMessageForPoke.uniseq));
      }
    }
    if (126 == localMessageForPoke.interactType)
    {
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if ((!localMessageForPoke.isSend()) && (localHolder.jdField_b_of_type_Int == e) && (localMessageForPoke.isPlayed) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C))) {
        localHolder.c.setVisibility(0);
      }
      if ((!localMessageForPoke.isPlayed) && (!localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
      {
        if (SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).jdField_c_of_type_Int != 1) {
          break label337;
        }
        paramInt1 = 0;
        if (paramInt1 != 0)
        {
          SpriteCommFunc.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "vas_poke", true);
          if (QLog.isColorLevel()) {
            QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in play.");
          }
        }
        PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localHolder, localMessageForPoke.subId, "bubble");
      }
    }
    label337:
    label370:
    do
    {
      Object localObject;
      do
      {
        return;
        paramInt1 = 1;
        break;
        if (localMessageForPoke.isSend())
        {
          jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
          localObject = (RelativeLayout.LayoutParams)paramViewHolder.a.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (localMessageForPoke.interactType != 6) {
            break label582;
          }
          if (!localMessageForPoke.isSend()) {
            break label567;
          }
          paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
        }
        for (;;)
        {
          paramViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if ((PokeBigResHandler.jdField_a_of_type_Boolean) && (!(paramContext instanceof ChatHistoryForC2C))) {
            break label599;
          }
          localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
          localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
          localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          paramChatMessage = (PokeBigResHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(117);
          if ((paramChatMessage != null) && (!PokeBigResHandler.a())) {
            paramChatMessage.a(true);
          }
          if (!localMessageForPoke.isSend()) {
            break;
          }
          localMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          jdField_b_of_type_JavaUtilMap.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
          break label370;
          paramBaseChatItemLayout.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, 0, 0);
          continue;
          paramBaseChatItemLayout.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "Strength holder = " + localHolder.jdField_a_of_type_Float);
        }
        if ((localMessageForPoke.interactType != 5) || (localHolder.jdField_a_of_type_Float != 2.0F)) {
          break label1007;
        }
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
        if (localMessageForPoke.isPlayed) {
          break label872;
        }
        paramChatMessage = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131363473)).a();
        if (SixCombolEffectView.jdField_a_of_type_Int != 0) {
          break label786;
        }
      } while (AIOUtils.k);
      localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localHolder.c.setVisibility(8);
      localHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramChatMessage.setListener(this);
      AIOUtils.jdField_a_of_type_Int += 1;
      paramChatMessage.a(localHolder);
      return;
      paramChatMessage = paramChatMessage.a();
      if (localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage)
      {
        switch (SixCombolEffectView.jdField_a_of_type_Int)
        {
        default: 
          a(localHolder);
          return;
        }
        localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localHolder.c.setVisibility(8);
        localHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      a(localHolder);
      return;
      if (SixCombolEffectView.jdField_a_of_type_Int > 0)
      {
        paramChatMessage = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131363473)).a().a();
        if ((paramChatMessage != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage))
        {
          switch (SixCombolEffectView.jdField_a_of_type_Int)
          {
          default: 
            a(localHolder);
            return;
          }
          localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localHolder.c.setVisibility(8);
          localHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        a(localHolder);
        return;
      }
      a(localHolder);
      return;
      if (localMessageForPoke.interactType == 6)
      {
        b(localHolder, localMessageForPoke);
        return;
      }
      if ((localMessageForPoke.isPlayed) && (!localMessageForPoke.mFrameState.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(localMessageForPoke.uniseq))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "[status]has already played");
        }
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((localHolder.jdField_b_of_type_Int == e) && (!localMessageForPoke.isSend()) && (localMessageForPoke.interactType != 126) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C))) {
          localHolder.c.setVisibility(0);
        }
        for (;;)
        {
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          return;
          localHolder.c.setVisibility(8);
        }
      }
      paramInt1 = 0;
      paramViewHolder = a(localMessageForPoke.interactType);
      switch (localMessageForPoke.interactType)
      {
      default: 
        paramContext = PokeItemAnimationManager.jdField_a_of_type_JavaLangString + "/chuo_icon/chuo_icon_";
        if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {
          if (localHolder.jdField_a_of_type_Float == 2.0F)
          {
            paramContext = new BitmapFactory.Options();
            paramContext.inSampleSize = 1;
            paramContext.inMutable = true;
          }
        }
        break;
      }
      for (;;)
      {
        try
        {
          paramContext = ImageUtil.a(PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_" + "01.png", paramContext);
          paramContext = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramContext, PokeItemAnimationManager.a().jdField_a_of_type_MqqOsMqqHandler, localMessageForPoke.mFrameState, paramViewHolder, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
          a(paramContext);
          paramContext.a(1);
          if (!paramChatMessage.isSend())
          {
            if (localMessageForPoke.interactType == 5) {
              break label2324;
            }
            paramContext.b();
          }
          paramContext.g();
          if (!localMessageForPoke.mFrameState.jdField_a_of_type_Boolean) {
            break label2332;
          }
          localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
          localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localHolder.c.setVisibility(8);
          localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramContext);
          paramContext.a(new uva(this, localHolder, localMessageForPoke));
          paramContext.d();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GivingHeart", 2, "[status]playing");
          return;
          paramContext = PokeBigResHandler.c + "/chuo_motion/chuo_motion_";
          paramInt1 = 35;
          break label1283;
          paramContext = PokeBigResHandler.c + "/bixin_motion/bixin_motion_";
          paramInt1 = 67;
          break label1283;
          paramContext = PokeBigResHandler.c + "/zan_motion/zan_motion_";
          paramInt1 = 20;
          break label1283;
          paramContext = PokeBigResHandler.c + "/xinsui_motion/xinsui_motion_";
          paramInt1 = 50;
          break label1283;
          if (localMessageForPoke.isSend())
          {
            paramContext = PokeBigResHandler.c + "/666send_motion/666send_motion_";
            paramInt1 = 57;
            break label1283;
          }
          paramContext = PokeBigResHandler.c + "/666receive_motion/666receive_motion_";
          continue;
          paramContext = PokeItemAnimationManager.jdField_a_of_type_JavaLangString + "/dazhao_icon/dazhao_icon_";
        }
        catch (OutOfMemoryError paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, paramContext.toString());
          }
          paramContext = null;
          continue;
        }
        paramContext = ImageUtil.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838528);
        paramContext = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramContext, PokeItemAnimationManager.a().jdField_a_of_type_MqqOsMqqHandler, localMessageForPoke.mFrameState, paramViewHolder, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
        b(paramContext);
        continue;
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        ((BitmapFactory.Options)localObject).inMutable = true;
        try
        {
          paramBaseChatItemLayout = ImageUtil.a(paramContext + "01.png", (BitmapFactory.Options)localObject);
          paramBaseChatItemLayout = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBaseChatItemLayout, PokeItemAnimationManager.a().jdField_a_of_type_MqqOsMqqHandler, localMessageForPoke.mFrameState, paramViewHolder, PokeItemHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
          paramBaseChatItemLayout.h();
          paramInt2 = 40;
          if (localMessageForPoke.interactType == 2) {
            paramInt2 = 30;
          }
          if ((localMessageForPoke.interactType == 4) && (localHolder.jdField_a_of_type_Float == 2.0F))
          {
            i = 0;
            for (;;)
            {
              if (i >= 20) {
                break label2097;
              }
              if (i + 1 >= 10) {
                break;
              }
              paramBaseChatItemLayout.a(i, paramInt2, paramContext + "0" + (i + 1) + ".png");
              i += 1;
            }
          }
        }
        catch (OutOfMemoryError paramBaseChatItemLayout)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, paramBaseChatItemLayout.toString());
            }
            paramBaseChatItemLayout = null;
            continue;
            paramBaseChatItemLayout.a(i, paramInt2, paramContext + (i + 1) + ".png");
          }
          int i = 20;
          while (i < paramInt1)
          {
            paramBaseChatItemLayout.a(i, paramInt2, paramContext + 21 + ".png");
            i += 1;
            continue;
            i = 0;
            if (i < paramInt1)
            {
              if (i + 1 < 10) {
                paramBaseChatItemLayout.a(i, paramInt2, paramContext + "0" + (i + 1) + ".png");
              }
              for (;;)
              {
                i += 1;
                break;
                paramBaseChatItemLayout.a(i, paramInt2, paramContext + (i + 1) + ".png");
              }
            }
          }
          paramContext = paramBaseChatItemLayout;
        }
        if (localMessageForPoke.mFrameState.jdField_a_of_type_Boolean)
        {
          try
          {
            paramContext = ImageUtil.a(paramBaseChatItemLayout.a(localMessageForPoke.mFrameState.jdField_a_of_type_Int).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
            paramBaseChatItemLayout.a(paramContext);
            paramContext = paramBaseChatItemLayout;
          }
          catch (OutOfMemoryError paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GivingHeart", 2, paramContext.toString());
              }
              paramContext = null;
            }
          }
          paramContext.a(2);
        }
      }
      if (localMessageForPoke.mFrameState.c)
      {
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((localHolder.jdField_b_of_type_Int == e) && (!localMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryForC2C))) {
          localHolder.c.setVisibility(0);
        }
        for (;;)
        {
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, "[status]played");
          }
          if (!localMessageForPoke.isPlayed) {
            localMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(localMessageForPoke.uniseq))) {
            break;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.remove(Long.valueOf(localMessageForPoke.uniseq));
          return;
          localHolder.c.setVisibility(8);
        }
      }
    } while (AIOUtils.k);
    label567:
    label582:
    label599:
    label872:
    label1007:
    AIOUtils.jdField_a_of_type_Int += 1;
    label786:
    label2097:
    localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    label1283:
    label2324:
    label2332:
    localHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    localHolder.c.setVisibility(8);
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    paramContext.a(new uvb(this, localHolder, localMessageForPoke));
    localHolder.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramContext);
    paramContext.c();
    a(localMessageForPoke.uniseq, localMessageForPoke);
    label2670:
    boolean bool2;
    if (localHolder.jdField_a_of_type_Float == 2.0F)
    {
      if (localMessageForPoke.interactType == 2)
      {
        PokeItemAnimationManager.a().a(1);
        PokeItemAnimationManager.a().a(2, 1500L, localMessageForPoke.isSend());
      }
    }
    else if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType == 0))
    {
      paramContext = (Activity)this.jdField_a_of_type_AndroidContentContext;
      bool2 = paramChatMessage.isSend();
      if (localHolder.jdField_a_of_type_Float != 2.0F) {
        break label2835;
      }
    }
    label2835:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramContext, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[status]start to play duobleHit:" + localMessageForPoke.doubleHitState + " type:" + localMessageForPoke.msgtype);
      return;
      if (localMessageForPoke.interactType == 3)
      {
        PokeItemAnimationManager.a().a(4);
        PokeItemAnimationManager.a().a(5, 700L);
        break label2670;
      }
      if (localMessageForPoke.interactType != 4) {
        break label2670;
      }
      PokeItemAnimationManager.a().a(13);
      PokeItemAnimationManager.a().a(14, 800L);
      break label2670;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = new QQCustomMenu();
    ChatActivityFacade.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder
 * JD-Core Version:    0.7.0.1
 */