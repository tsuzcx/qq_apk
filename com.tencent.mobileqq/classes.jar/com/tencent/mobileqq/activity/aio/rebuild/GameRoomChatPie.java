package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.helper.HotGiftPanelHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.gamecenter.gameroom.GameQuickWordsPanel;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.nearby.gameroom.OnBindCallback;
import com.tencent.mobileqq.nearby.gift.INearbyGiftPanelDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.werewolves.GameView;
import com.tencent.mobileqq.werewolves.HalfScreenBrowserActivity;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesObserver;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;

public class GameRoomChatPie
  extends HotChatPie
  implements OnBindCallback
{
  protected boolean H;
  protected boolean I;
  protected boolean J = true;
  boolean K = false;
  boolean L = true;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new GameRoomChatPie.23(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GameRoomChatPie.5(this);
  protected LinearLayout a;
  GameQuickWordsPanel jdField_a_of_type_ComTencentMobileqqGamecenterGameroomGameQuickWordsPanel;
  WereWolvesLoadingView jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView;
  WerewolvesHandler jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler;
  WerewolvesObserver jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver = new GameRoomChatPie.18(this);
  WerewolvesPluginManager jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
  BroadcastReceiver b;
  protected RelativeLayout c;
  QQProgressDialog d;
  int g;
  protected View g;
  int jdField_h_of_type_Int;
  View jdField_h_of_type_AndroidViewView;
  protected TextView h;
  private final int i;
  protected TextView i;
  protected ImageView l;
  protected ImageView m;
  
  public GameRoomChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
    this.jdField_i_of_type_Int = Color.parseColor("#00000000");
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new GameRoomChatPie.24(this);
  }
  
  protected View a()
  {
    GameView localGameView = new GameView(this.jdField_a_of_type_AndroidContentContext, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.jdField_g_of_type_AndroidViewView = localGameView;
    return localGameView;
  }
  
  public View a(int paramInt)
  {
    View localView = super.a(paramInt);
    if ((localView == null) && (paramInt == 25))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterGameroomGameQuickWordsPanel = ((GameQuickWordsPanel)View.inflate(a(), 2131558544, null));
      this.jdField_a_of_type_ComTencentMobileqqGamecenterGameroomGameQuickWordsPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      return this.jdField_a_of_type_ComTencentMobileqqGamecenterGameroomGameQuickWordsPanel;
    }
    return localView;
  }
  
  protected AIOContext a()
  {
    return new GameRoomContext();
  }
  
  public HashMap<String, Integer> a()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {
      return new HashMap();
    }
    return localWerewolvesPluginInterface.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject != null)
    {
      localObject = ((WerewolvesPluginInterface)localObject).b();
      if (localObject == null)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "onPanelChanged: drawables == null");
        return;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
      {
        this.m.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
        return;
      }
      this.m.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.I = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.I) {
        ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).reset(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l1 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
    if (paramList.size() != 0)
    {
      int j = paramList.size() - 1;
      while (j >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(j);
        if (localChatMessage.time < l1) {
          paramList.remove(j);
        } else if ((((localChatMessage instanceof MessageForGrayTips)) || ((localChatMessage instanceof MessageForNewGrayTips))) && (!(localChatMessage instanceof MessageForTroopGift))) {
          paramList.remove(j);
        }
        j -= 1;
      }
    }
    super.a(paramList, paramCharSequence, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramCharSequence = (ChatMessage)paramList.next();
      if ((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.jdField_a_of_type_JavaLangString.equals(paramCharSequence.senderuin))) {
        paramCharSequence.isFlowMessage = false;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a((String)localObject);
    super.a(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      if (!Settings.canDrawOverlays((Context)localObject))
      {
        j = 0;
        ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
        break label90;
      }
    }
    int j = 1;
    label90:
    if (j == 0)
    {
      b(1);
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
    this.K = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).reset(this.jdField_a_of_type_AndroidContentContext);
    localObject = new IntentFilter("tencent.av.v2q.StartVideoChat");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.werewoves.plugin");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void aA()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject2 == null) {
      return;
    }
    int j = ((WerewolvesPluginInterface)localObject2).b();
    int k = ((WerewolvesPluginInterface)localObject2).a();
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a((HotChatInfo)localObject1, j, k, new GameRoomChatPie.25(this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(j);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(k);
    ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
  }
  
  public void ad()
  {
    super.ad();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject == null) {
      return;
    }
    localObject = ((WerewolvesPluginInterface)localObject).b();
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) && (localObject != null))
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      this.l.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  protected void aj() {}
  
  public void at()
  {
    if (!this.I) {
      if (t()) {
        return;
      }
    }
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).enterRoom(l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      return;
    }
    catch (Exception localException)
    {
      label48:
      break label48;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is null");
    }
  }
  
  public void au() {}
  
  public void av()
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = new WereWolvesLoadingView(a());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable((Drawable)localObject);
    if (a().getIntent().getBooleanExtra("isNeedShowLoading", true))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a())
    {
      aw();
      return;
    }
    ThreadManager.post(new GameRoomChatPie.15(this), 8, null, true);
  }
  
  public void aw()
  {
    ThreadManager.post(new GameRoomChatPie.16(this), 8, null, true);
  }
  
  public void ax()
  {
    Intent localIntent = new Intent(a(), QQBrowserActivity.class);
    this.L = false;
    localIntent.putExtra("url", "https://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.jdField_a_of_type_Boolean = false;
    a().startActivity(localIntent);
  }
  
  public void ay()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    localActionSheet.setMainTitle(HardCodeUtil.a(2131705195));
    localActionSheet.addButton(HardCodeUtil.a(2131705182), 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new GameRoomChatPie.22(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void az()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject == null) {
      return;
    }
    localObject = ((WerewolvesPluginInterface)localObject).b();
    this.l.setImageDrawable((Drawable)((HashMap)localObject).get("audioIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.G = paramBoolean1;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.jdField_a_of_type_Boolean = paramBoolean1;
    a(0, true);
    a().setImmersiveStatus(0);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject1 == null) {
      return;
    }
    HashMap localHashMap2 = ((WerewolvesPluginInterface)localObject1).b();
    HashMap localHashMap1 = ((WerewolvesPluginInterface)localObject1).a();
    if (localHashMap2 != null)
    {
      if (localHashMap1 == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(0);
      this.k.setVisibility(8);
      this.k.setScaleX(0.0F);
      Object localObject2 = (Drawable)localHashMap2.get("aioBg");
      View localView = (View)this.jdField_d_of_type_AndroidViewViewGroup.getParent();
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundColor(0);
      localView.setBackgroundDrawable((Drawable)localObject2);
      a(0, true);
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap2.get("inputBg"));
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap1.get("pressTipsColor")).intValue());
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable((Drawable)localHashMap2.get("sendBtnBg"));
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(((Integer)localHashMap1.get("sendBtnColor")).intValue());
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3) {
        this.m.setImageDrawable((Drawable)localHashMap2.get("emojIconOn"));
      } else {
        this.m.setImageDrawable((Drawable)localHashMap2.get("emojIcon"));
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(((Integer)localHashMap1.get("bottomBarColor")).intValue());
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqGamecenterGameroomGameQuickWordsPanel;
      if (localObject2 != null) {
        ((GameQuickWordsPanel)localObject2).setBackgroundColor(((Integer)localHashMap1.get("quickWordBgColor")).intValue());
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) {
        this.l.setImageDrawable((Drawable)localHashMap2.get("textIcon"));
      } else {
        this.l.setImageDrawable((Drawable)localHashMap2.get("audioIcon"));
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130839618);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqGamecenterGameroomGameQuickWordsPanel;
      if (localObject2 != null) {
        ((GameQuickWordsPanel)localObject2).a();
      }
      this.e.setTextColor(((Integer)localHashMap1.get("titleColor")).intValue());
      this.f.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap1.get("leftTextColor")).intValue());
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap2.get("backIcon"));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap2.get("rightMenu"));
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(0.2F);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(true);
      }
      if (paramBoolean1)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((paramBoolean2) && (!((WerewolvesPluginInterface)localObject1).c()))
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundColor(((Integer)localHashMap1.get("wolfBtnBg")).intValue());
          this.jdField_h_of_type_Int = ((Integer)localHashMap1.get("wolfBtnTextPress")).intValue();
          this.jdField_g_of_type_Int = ((Integer)localHashMap1.get("wolfBtnText")).intValue();
          this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_g_of_type_Int);
        }
        else
        {
          this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      localObject1 = this.jdField_h_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(((Integer)localHashMap1.get("bottomBarMask")).intValue());
      }
    }
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "Q.werewolf.GameRoomChatPie";
  }
  
  public void c(boolean paramBoolean)
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null)
    {
      super.c(paramBoolean);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b())
    {
      super.c(paramBoolean);
      this.H = true;
      this.I = true;
      return;
    }
    if ((localWerewolvesPluginInterface.b()) && (localWerewolvesPluginInterface.c()))
    {
      super.c(paramBoolean);
      this.H = true;
      return;
    }
    if ((localWerewolvesPluginInterface.b()) && (!localWerewolvesPluginInterface.c()))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705231), HardCodeUtil.a(2131705177), HardCodeUtil.a(2131705210), new GameRoomChatPie.11(this, paramBoolean), new GameRoomChatPie.12(this)).show();
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705207), HardCodeUtil.a(2131705164), HardCodeUtil.a(2131705218), new GameRoomChatPie.13(this, paramBoolean, localWerewolvesPluginInterface), new GameRoomChatPie.14(this)).show();
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).onPhoneStateChange(paramInt);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.a(paramInt);
    }
  }
  
  public void d(String paramString)
  {
    this.I = true;
    this.J = false;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230);
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setPositiveButton(2131694583, new GameRoomChatPie.19(this));
    localQQCustomDialog.setOnDismissListener(new GameRoomChatPie.20(this));
    if (QLog.isColorLevel())
    {
      paramString = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKickOut! isStopped = ");
      localStringBuilder.append(this.Q);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if (!this.Q)
    {
      localQQCustomDialog.show();
      return;
    }
    this.J = true;
    b(1);
  }
  
  public boolean d()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {
      return super.d();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      return super.d();
    }
    HotGiftPanelHelper localHotGiftPanelHelper = (HotGiftPanelHelper)a(136);
    if ((localHotGiftPanelHelper.a != null) && (localHotGiftPanelHelper.a.a()))
    {
      localHotGiftPanelHelper.b();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b())
    {
      this.H = true;
      this.I = true;
      return super.d();
    }
    if ((localWerewolvesPluginInterface.b()) && (localWerewolvesPluginInterface.c()))
    {
      this.H = true;
      return super.d();
    }
    if ((localWerewolvesPluginInterface.b()) && (!localWerewolvesPluginInterface.c()))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705202), HardCodeUtil.a(2131705228), HardCodeUtil.a(2131705212), new GameRoomChatPie.7(this), new GameRoomChatPie.8(this)).show();
      return true;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705236), HardCodeUtil.a(2131705192), HardCodeUtil.a(2131705170), new GameRoomChatPie.9(this, localWerewolvesPluginInterface), new GameRoomChatPie.10(this)).show();
    return true;
  }
  
  protected void e()
  {
    super.e();
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int k = 0;
    if ((localObject != null) && (!((String)localObject).equals("1000"))) {
      j = 0;
    } else {
      j = 1;
    }
    a(-1, true);
    a(0, true);
    a().setImmersiveStatus(0);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131370075);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
    new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F)).addRule(12);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 0.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    if (j != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(-1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130838028);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((this.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent() instanceof LinearLayout))
    {
      localObject = (LinearLayout)this.jdField_a_of_type_ComTencentWidgetPatchedButton.getParent();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    }
    int n = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    this.l = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.l.setPadding(n, n, n, n);
    this.l.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.l, new ViewGroup.LayoutParams(-2, -2));
    this.m = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.m.setImageResource(2130838071);
    this.m.setPadding(0, n, 0, n);
    this.m.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.m, new ViewGroup.LayoutParams(-2, -2));
    this.jdField_h_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_h_of_type_AndroidWidgetTextView.setGravity(17);
    if (j != 0) {
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a1a2a3"));
    } else {
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167158));
    }
    this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundResource(2130850178);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705230));
    this.jdField_h_of_type_AndroidWidgetTextView.setMinHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
    this.jdField_h_of_type_AndroidWidgetTextView.setEnabled(false);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 86.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    this.jdField_h_of_type_AndroidWidgetTextView.setOnTouchListener(new GameRoomChatPie.1(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new GameRoomChatPie.2(this));
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_i_of_type_Int);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_i_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_i_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(18.0F);
    this.jdField_i_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705244));
    this.jdField_i_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnTouchListener(new GameRoomChatPie.3(this));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_i_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 245.0F));
    ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    int j = k;
    while (j < this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount())
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(j) == this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout) {
        break label1051;
      }
      j += 1;
    }
    j = -1;
    label1051:
    if (j >= 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(a(), j, (ViewGroup.LayoutParams)localObject);
    } else {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(a(), (ViewGroup.LayoutParams)localObject);
    }
    this.f.setVisibility(8);
    av();
  }
  
  protected void e(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690529);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131705223));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html");
    localStringBuilder.append("?_bid=2652&from=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("&gc=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&toUin=");
    localStringBuilder.append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInGameGift(true);
  }
  
  protected void h()
  {
    this.f.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60) {
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void k()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    boolean bool;
    if (localWerewolvesPluginInterface != null) {
      bool = localWerewolvesPluginInterface.c();
    } else {
      bool = false;
    }
    if (bool) {
      localActionSheet.addButton(HardCodeUtil.a(2131705161), 3);
    }
    if (bool) {
      localActionSheet.addButton(HardCodeUtil.a(2131705225));
    } else {
      localActionSheet.addButton(HardCodeUtil.a(2131705183), 3);
    }
    localActionSheet.addButton(HardCodeUtil.a(2131705232));
    localActionSheet.addCancelButton(HardCodeUtil.a(2131705186));
    localActionSheet.setOnButtonClickListener(new GameRoomChatPie.21(this, bool, localActionSheet));
    localActionSheet.show();
  }
  
  public void m(boolean paramBoolean)
  {
    this.jdField_h_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      ad();
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).stopSpeak();
      this.jdField_h_of_type_AndroidWidgetTextView.setEnabled(false);
      this.l.setEnabled(false);
      this.m.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
      localObject = this.jdField_h_of_type_AndroidViewView;
      if (localObject == null)
      {
        this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth() != 0) {
          localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight());
        } else {
          localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        this.jdField_h_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#77FFFFFF"));
        if (localWerewolvesPluginInterface != null)
        {
          localObject = localWerewolvesPluginInterface.a();
          this.jdField_h_of_type_AndroidViewView.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
        }
      }
      else
      {
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth();
        ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight();
        this.jdField_h_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
      if ((localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.c())) {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705227));
      } else {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705180));
      }
      if (!this.G) {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    else
    {
      this.jdField_h_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705203));
      this.jdField_h_of_type_AndroidWidgetTextView.setEnabled(true);
      this.l.setEnabled(true);
      this.m.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      localObject = this.jdField_h_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694425, 0).a();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694425, 0).a();
  }
  
  public void p()
  {
    WerewolvesPluginManager localWerewolvesPluginManager = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
    if (localWerewolvesPluginManager != null) {
      localWerewolvesPluginManager.a(this);
    }
    if ((!this.B) && (this.K))
    {
      super.p();
      this.K = false;
      if (this.I) {
        this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new GameRoomChatPie.6(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
      ((View)this.jdField_d_of_type_AndroidViewViewGroup.getParent()).setBackgroundColor(0);
      a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167114), true);
      try
      {
        if ((this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
  
  public void v()
  {
    super.v();
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    catch (Exception localException)
    {
      long l1;
      label18:
      WerewolvesPluginInterface localWerewolvesPluginInterface;
      break label18;
    }
    l1 = 0L;
    localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if ((localWerewolvesPluginInterface != null) && (HotChatManager.jdField_a_of_type_Boolean)) {
      localWerewolvesPluginInterface.d();
    }
    HotChatManager.jdField_a_of_type_Boolean = true;
    if (((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b()) || (!this.H)) && (!this.I) && (this.L))
    {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).showFloatView(1, null, l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if ((localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.b())) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.L = true;
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInAIO(false);
  }
  
  protected void w()
  {
    super.w();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    }
  }
  
  public void y()
  {
    super.y();
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInAIO(true);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInGameGift(false);
    if (!((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).isBinded()) {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).bindService(this);
    }
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie
 * JD-Core Version:    0.7.0.1
 */