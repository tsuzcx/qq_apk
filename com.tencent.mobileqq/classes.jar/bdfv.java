import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.together.ui.TogetherPanelTouchController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class bdfv
  extends PopupWindow
  implements View.OnClickListener, besr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bdfx(this);
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public FrameLayout a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  bddc jdField_a_of_type_Bddc = new bdfw(this);
  bddq jdField_a_of_type_Bddq;
  public bdfy a;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  RoundRectUrlImageView jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  TogetherPanelTouchController jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController;
  ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  
  public bdfv(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
  }
  
  @RequiresApi(api=17)
  public static int a(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getResources();
      Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 15)
      {
        localObject = new DisplayMetrics();
        localDisplay.getMetrics(localDisplayMetrics);
        localDisplay.getRealMetrics((DisplayMetrics)localObject);
        if (localDisplayMetrics.heightPixels != ((DisplayMetrics)localObject).heightPixels) {
          return a(paramContext.getResources());
        }
      }
      else
      {
        int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
        if ((i > 0) && (((Resources)localObject).getBoolean(i)))
        {
          i = a((Resources)localObject);
          return i;
        }
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("TogetherPopupDialog", 1, paramContext, new Object[0]);
    }
    return 0;
  }
  
  private static int a(Resources paramResources)
  {
    int i = paramResources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  private View a(bdfv parambdfv, Activity paramActivity, int paramInt1, int paramInt2)
  {
    View localView = parambdfv.getContentView();
    localView.findViewById(2131379019).setOnClickListener(this);
    localView.findViewById(2131379019).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719017));
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131372227);
    Object localObject1 = (DiniFlyAnimationView)localView.findViewById(2131376835);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131364609));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    Object localObject2;
    if (this.jdField_a_of_type_Bddq == null)
    {
      localObject2 = new bddp();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo != null)) {
        ((bddp)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
      }
      this.jdField_a_of_type_Bddq = new bddq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (bddp)localObject2, this.jdField_a_of_type_AndroidWidgetFrameLayout, localRelativeLayout, (DiniFlyAnimationView)localObject1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)localView.findViewById(2131363317));
    localObject1 = bdct.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a();
    if (localObject1 != null)
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = URLDrawable.getDrawable(((bdda)localObject1).c, (URLDrawable.URLDrawableOptions)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(ViewUtils.dpToPx(16.0F));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable((Drawable)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setEnableEffect(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setTag(localObject1);
      if (AppSetting.c) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131694735));
      }
      bdct.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentUin(), 101, ((bdda)localObject1).jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get() + "");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131378896));
    this.jdField_a_of_type_Bdfy = new bdfy(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidWidgetLinearLayout);
    localObject1 = (aqdf)apub.a().a(553);
    if ((localObject1 != null) && (((aqdf)localObject1).a.size() > 0)) {
      this.jdField_a_of_type_Bdfy.a(((aqdf)localObject1).a);
    }
    for (;;)
    {
      localObject1 = (RelativeLayout)localView.findViewById(2131370052);
      paramInt2 = ViewUtils.dpToPx(10.0F);
      int i = a(paramActivity);
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)localView.findViewById(2131365100));
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController = ((TogetherPanelTouchController)localView.findViewById(2131365073));
      b(i + paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setMode(paramInt1);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setDisableMinScrollY(true);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setHeadView(localRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setAtPanelTouchListener(parambdfv);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.bringToFront();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.addObserver(this.jdField_a_of_type_Bddc);
      return localView;
      this.jdField_a_of_type_Bdfy.a(bddb.a());
    }
  }
  
  public static bdfv a(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = LayoutInflater.from(paramBaseActivity).inflate(2131561286, null);
    paramTroopChatPie = new bdfv(paramTroopChatPie, paramBaseActivity, localView, paramInt1, paramInt2);
    paramTroopChatPie.a(paramTroopChatPie, paramBaseActivity, 1, paramInt3);
    localView.findViewById(2131370052).setBackgroundColor(localView.getResources().getColor(2131166984));
    paramTroopChatPie.setFocusable(false);
    localView.setOnClickListener(paramTroopChatPie);
    ((RelativeLayout)localView.findViewById(2131372227)).setOnClickListener(paramTroopChatPie);
    paramTroopChatPie.setInputMethodMode(1);
    paramTroopChatPie.setSoftInputMode(16);
    paramTroopChatPie.setClippingEnabled(false);
    paramTroopChatPie.setOutsideTouchable(true);
    if (AppSetting.c) {
      a(paramTroopChatPie);
    }
    return paramTroopChatPie;
  }
  
  public static void a(PopupWindow paramPopupWindow)
  {
    int i = 0;
    Method[] arrayOfMethod = PopupWindow.class.getMethods();
    int j = arrayOfMethod.length;
    for (;;)
    {
      Method localMethod;
      if (i < j)
      {
        localMethod = arrayOfMethod[i];
        if (!localMethod.getName().equals("setTouchModal")) {}
      }
      else
      {
        try
        {
          localMethod.invoke(paramPopupWindow, new Object[] { Boolean.valueOf(false) });
          return;
        }
        catch (Exception paramPopupWindow)
        {
          paramPopupWindow.printStackTrace();
          return;
        }
      }
      i += 1;
    }
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()))) {
        paramHashMap.put("A8", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin());
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin)));
    paramHashMap.put("qq_group_num", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin);
  }
  
  private void b(int paramInt)
  {
    int i = this.jdField_a_of_type_Bdfy.a();
    int j = (i % 2 + i / 2) * 70;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.getVisibility() == 0) {}
    int k;
    int n;
    for (i = 150;; i = 0)
    {
      k = UIUtils.getScreenHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      int m = ViewUtils.dpToPx(i + j);
      n = ViewUtils.dpToPx(304) + paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("TogetherPopupDialog", 2, "togetherHeightDp = " + j + ",bannerLayoutHeightDp = " + i + ", screenHeight = " + k + ", scrollViewHeight = " + m + ",otherViewHeight" + n + ",bottomHeight = " + paramInt);
      }
      if (k - n <= m) {
        break;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams();
      localLayoutParams.height = -2;
      localLayoutParams.bottomMargin = paramInt;
      this.jdField_a_of_type_ComTencentWidgetScrollView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setControlLitTongue(false);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetScrollView.getLayoutParams();
    localLayoutParams.height = (k - n);
    localLayoutParams.bottomMargin = paramInt;
    this.jdField_a_of_type_ComTencentWidgetScrollView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.setControlLitTongue(true);
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  void a(String paramString)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin());
    if (localTroopInfo == null) {}
    Bundle localBundle;
    do
    {
      return;
      bdct localbdct = (bdct)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(339);
      localBundle = bddg.a(true, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin(), 0);
      if (!localbdct.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, localTroopInfo.troopuin, 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
    return;
    bddg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, paramString, null, localBundle, 1);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.scrollTo(0, 0);
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130771997);
      }
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiTogetherPanelTouchController.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    } while (this.jdField_a_of_type_Bdfy == null);
    this.jdField_a_of_type_Bdfy.c();
  }
  
  public void c()
  {
    HashMap localHashMap;
    if (this.jdField_a_of_type_Bddq != null)
    {
      localHashMap = new HashMap();
      if (!this.jdField_a_of_type_Bddq.b()) {
        break label49;
      }
      localHashMap.put("op_via", "2");
    }
    for (;;)
    {
      a(localHashMap);
      bddt.a("click#aio_icon", localHashMap);
      return;
      label49:
      localHashMap.put("op_via", "1");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bddq != null)
    {
      this.jdField_a_of_type_Bddq.b();
      this.jdField_a_of_type_Bddq = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app != null) && (this.jdField_a_of_type_Bddc != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.removeObserver(this.jdField_a_of_type_Bddc);
      this.jdField_a_of_type_Bddc = null;
    }
    if (this.jdField_a_of_type_Bdfy != null)
    {
      this.jdField_a_of_type_Bdfy.d();
      this.jdField_a_of_type_Bdfy = null;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    if (this.jdField_a_of_type_Bdfy != null) {
      this.jdField_a_of_type_Bdfy.b();
    }
  }
  
  void e()
  {
    auzn.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin(), 0);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, "", "" + TroopUtils.convSfToReportParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin)), "");
    HashMap localHashMap = new HashMap();
    localHashMap.put("op_via", "4");
    a(localHashMap);
    bddt.a("click#aio_front_panel", localHashMap);
  }
  
  void f()
  {
    Object localObject = (aqde)apub.a().a(535);
    if ((localObject == null) || (((aqde)localObject).a == null)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131692889, 0).a();
    }
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin());
    } while (localTroopInfo == null);
    bdct localbdct = (bdct)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(339);
    boolean bool = localbdct.a(2, 1, localTroopInfo.uin);
    Bundle localBundle = bddg.a(true, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin(), 0);
    switch (((aqde)localObject).a.a())
    {
    default: 
      if (localbdct.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, localTroopInfo.troopuin, 0)) {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
        }
      }
      break;
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, "", "" + TroopUtils.convSfToReportParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin)), "");
      localObject = new HashMap();
      ((HashMap)localObject).put("op_via", "5");
      a((HashMap)localObject);
      bddt.a("click#aio_front_panel", (HashMap)localObject);
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131692889, 0).a();
      continue;
      if (!localTroopInfo.isAdmin())
      {
        if (bool) {
          localbdct.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        } else {
          localbdct.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        }
      }
      else if (bool)
      {
        localbdct.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
      }
      else
      {
        localbdct.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        continue;
        bddg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, ((aqde)localObject).a.b(), ((aqde)localObject).a.a(), ((aqde)localObject).a.b(), localBundle, 1);
      }
    }
  }
  
  void g()
  {
    new Bundle();
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin());
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = (bdct)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(339);
    boolean bool = ((bdct)localObject1).a(4, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin());
    localObject2 = bddg.a(bool, ((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), ((TroopInfo)localObject2).isAdmin(), ((TroopInfo)localObject2).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin(), 0);
    if (bool) {
      ((bdct)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin(), 1, 4, 0, (Bundle)localObject2);
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_sing", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, "", "" + TroopUtils.convSfToReportParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin)), "");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("op_via", "6");
      a((HashMap)localObject1);
      bddt.a("click#aio_front_panel", (HashMap)localObject1);
      return;
      ((bdct)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin(), 1, 4, 0, (Bundle)localObject2);
    }
  }
  
  void h()
  {
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin();
        String str = URLEncoder.encode("pages/index/index?mode=qun&gid=" + (String)localObject, "UTF-8");
        str = "https://m.q.qq.com/a/p/1108291530?via=2010_1&referer=2010&s=" + str;
        str = "mqqapi://microapp/open?url=" + URLEncoder.encode(str, "UTF-8");
        if (QLog.isColorLevel()) {
          QLog.d("TogetherPopupDialog", 2, "handleMiniAIOEntry : " + str);
        }
        localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).b((String)localObject);
        if (localTroopInfo != null) {
          continue;
        }
        bool = false;
        localObject = new EntryModel(1, Long.parseLong((String)localObject), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendNick, bool);
        MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 2010, (EntryModel)localObject, null);
      }
      catch (Exception localException)
      {
        Object localObject;
        TroopInfo localTroopInfo;
        boolean bool;
        QLog.e("TogetherPopupDialog", 1, localException, new Object[0]);
        continue;
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_play", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, "", "" + TroopUtils.convSfToReportParam(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin)), "");
      localObject = new HashMap();
      ((HashMap)localObject).put("op_via", "8");
      a((HashMap)localObject);
      bddt.a("click#aio_front_panel", (HashMap)localObject);
      return;
      bool = localTroopInfo.isAdmin();
    }
  }
  
  void i()
  {
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AVGameRoomCenterFragment.class);
    HashMap localHashMap = new HashMap();
    localHashMap.put("op_via", "7");
    a(localHashMap);
    bddt.a("click#aio_front_panel", localHashMap);
  }
  
  public void onClick(View paramView)
  {
    bdda localbdda;
    Object localObject;
    if (paramView.getId() == 2131363317)
    {
      localbdda = (bdda)paramView.getTag();
      if (localbdda != null)
      {
        if (("1".equals(localbdda.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbdda.b)))
        {
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserDelegationActivity.class);
          ((Intent)localObject).putExtra("url", localbdda.b);
          ((Intent)localObject).putExtra("fromOneCLickCLose", true);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
        }
      }
      else
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("op_via", "3");
        a((HashMap)localObject);
        bddt.a("click#aio_front_panel", (HashMap)localObject);
        bdct.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentUin(), 102, localbdda.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get() + "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (("2".equals(localbdda.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localbdda.b)))
      {
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setData(Uri.parse(localbdda.b));
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
        break;
      }
      if ((!"3".equals(localbdda.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localbdda.b))) {
        break;
      }
      a(localbdda.b);
      break;
      if (paramView.getId() == 2131379019) {
        dismiss();
      } else if (paramView.getId() != 2131364609) {
        dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfv
 * JD-Core Version:    0.7.0.1
 */