import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.quickat.ui.AtPanelTouchController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.vip.pb.TianShuAccess.AdItem;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;

public class baqe
  extends PopupWindow
  implements View.OnClickListener, bchl
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new baqg(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  bapq jdField_a_of_type_Bapq = new baqf(this);
  baqh jdField_a_of_type_Baqh;
  RoundRectUrlImageView jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  AtPanelTouchController jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  public baqe(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, View paramView, int paramInt1, int paramInt2)
  {
    super(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
  }
  
  private int a(Resources paramResources)
  {
    int i = paramResources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (i > 0) {
      return paramResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  private View a(baqe parambaqe, Activity paramActivity, int paramInt)
  {
    View localView = parambaqe.getContentView();
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController = ((AtPanelTouchController)localView.findViewById(2131364771));
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setDisableMinScrollY(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setControlLitTongue(false);
    ((RelativeLayout)localView.findViewById(2131369562)).setPadding(0, 0, 0, bdoo.b(24.0F) + a(paramActivity));
    localView.findViewById(2131378231).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371572));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699954);
    if ((paramActivity instanceof BaseActivity))
    {
      if (ThemeUtil.isNowThemeIsNight(((BaseActivity)paramActivity).app, false, null)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364790));
      this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollMode(2);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setAtPanelTouchListener(parambaqe);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.setMode(paramInt);
      this.jdField_a_of_type_Baqh = new baqh(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Baqh);
      parambaqe = (aory)aoks.a().a(553);
      if ((parambaqe == null) || (parambaqe.a.size() <= 0)) {
        break label451;
      }
      this.jdField_a_of_type_Baqh.a(parambaqe.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView = ((RoundRectUrlImageView)localView.findViewById(2131363079));
      parambaqe = baph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a();
      if (parambaqe != null)
      {
        paramActivity = URLDrawable.URLDrawableOptions.obtain();
        paramActivity = URLDrawable.getDrawable(parambaqe.c, paramActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setAllRadius(bdoo.b(16.0F));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setImageDrawable(paramActivity);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setEnableEffect(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setTag(parambaqe);
        if (AppSetting.c) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRoundRectUrlImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695685));
        }
        baph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c(), 101, parambaqe.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get() + "");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.addObserver(this.jdField_a_of_type_Bapq);
      return localView;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramActivity.getResources().getColor(2131166885));
      break;
      label451:
      this.jdField_a_of_type_Baqh.a(bapp.a());
    }
  }
  
  public static baqe a(TroopChatPie paramTroopChatPie, BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    View localView = LayoutInflater.from(paramBaseActivity).inflate(2131561160, null);
    paramTroopChatPie = new baqe(paramTroopChatPie, paramBaseActivity, localView, paramInt1, paramInt2);
    paramTroopChatPie.a(paramTroopChatPie, paramBaseActivity, 1);
    localView.findViewById(2131369562).setBackgroundColor(localView.getResources().getColor(2131166878));
    paramTroopChatPie.setFocusable(false);
    localView.setOnClickListener(paramTroopChatPie);
    ((RelativeLayout)localView.findViewById(2131371573)).setOnClickListener(paramTroopChatPie);
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
  
  @RequiresApi(api=17)
  public int a(Context paramContext)
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
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.scrollTo(0, 0);
    if ((this.jdField_a_of_type_AndroidViewAnimationAnimation != null) && (!this.jdField_a_of_type_AndroidViewAnimationAnimation.hasEnded())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130771997);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAtPanelTouchController.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_a_of_type_Baqh.b();
  }
  
  public void a(int paramInt)
  {
    dismiss();
  }
  
  void a(String paramString)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a());
    if (localTroopInfo == null) {}
    Bundle localBundle;
    do
    {
      return;
      baph localbaph = (baph)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(339);
      localBundle = bapu.a(true, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(), 0);
      if (!localbaph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, localTroopInfo.troopuin, 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
    return;
    bapu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, paramString, null, localBundle, 1);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.removeObserver(this.jdField_a_of_type_Bapq);
    this.jdField_a_of_type_Baqh.c();
  }
  
  public void c() {}
  
  void d()
  {
    atmr.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(), 0);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "" + bcpx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), "");
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.jdField_a_of_type_Baqh.a();
  }
  
  void e()
  {
    aorx localaorx = (aorx)aoks.a().a(535);
    if ((localaorx == null) || (localaorx.a == null)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693338, 0).a();
    }
    TroopInfo localTroopInfo;
    do
    {
      return;
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a());
    } while (localTroopInfo == null);
    baph localbaph = (baph)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(339);
    boolean bool = localbaph.a(2, 1, localTroopInfo.uin);
    Bundle localBundle = bapu.a(true, localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), localTroopInfo.isAdmin(), localTroopInfo.troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(), 0);
    switch (localaorx.a.a())
    {
    default: 
      if (localbaph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, localTroopInfo.troopuin, 0)) {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherPopupDialog", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(0) });
        }
      }
      break;
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "" + bcpx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), "");
      return;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, 2131693338, 0).a();
      continue;
      if (!localTroopInfo.isAdmin())
      {
        if (bool) {
          localbaph.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        } else {
          localbaph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        }
      }
      else if (bool)
      {
        localbaph.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
      }
      else
      {
        localbaph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localTroopInfo.troopuin, 1, 2, 0, localBundle);
        continue;
        bapu.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, localaorx.a.b(), localaorx.a.a(), localaorx.a.b(), localBundle, 1);
      }
    }
  }
  
  void f()
  {
    new Bundle();
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a());
    if (localObject == null) {
      return;
    }
    baph localbaph = (baph)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(339);
    boolean bool = localbaph.a(4, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a());
    localObject = bapu.a(bool, ((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin()), ((TroopInfo)localObject).isAdmin(), ((TroopInfo)localObject).troopowneruin, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(), 0);
    if (bool) {
      localbaph.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(), 1, 4, 0, (Bundle)localObject);
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_sing", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "" + bcpx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), "");
      return;
      localbaph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(), 1, 4, 0, (Bundle)localObject);
    }
  }
  
  void g()
  {
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
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
        localObject = new EntryModel(1, Long.parseLong((String)localObject), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, bool);
        MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, str, 2010, (EntryModel)localObject, null);
      }
      catch (Exception localException)
      {
        TroopInfo localTroopInfo;
        boolean bool;
        QLog.e("TogetherPopupDialog", 1, localException, new Object[0]);
        continue;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "hi_tab", "clk_play", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "" + bcpx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)), "");
      return;
      bool = localTroopInfo.isAdmin();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363079)
    {
      paramView = (bapo)paramView.getTag();
      Intent localIntent;
      if (paramView != null)
      {
        if ((!"1".equals(paramView.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramView.b))) {
          break label143;
        }
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserDelegationActivity.class);
        localIntent.putExtra("url", paramView.b);
        localIntent.putExtra("fromOneCLickCLose", true);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
      }
      for (;;)
      {
        baph.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c(), 102, paramView.jdField_a_of_type_CooperationVipPbTianShuAccess$AdItem.iAdId.get() + "");
        return;
        label143:
        if (("2".equals(paramView.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramView.b)))
        {
          localIntent = new Intent("android.intent.action.VIEW");
          localIntent.setData(Uri.parse(paramView.b));
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
        }
        else if (("3".equals(paramView.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramView.b)))
        {
          a(paramView.b);
        }
      }
    }
    if (paramView.getId() == 2131378231)
    {
      dismiss();
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqe
 * JD-Core Version:    0.7.0.1
 */