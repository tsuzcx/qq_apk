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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController;
import com.tencent.mobileqq.nearby.gameroom.GameRoomAVController.OnBindCallback;
import com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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

public class GameRoomChatPie
  extends HotChatPie
  implements GameRoomAVController.OnBindCallback
{
  protected boolean U;
  protected boolean V;
  protected boolean W = true;
  boolean X = false;
  boolean Y = true;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new GameRoomChatPie.23(this);
  GameQuickWordsPanel jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
  protected GameRoomAVController a;
  WereWolvesLoadingView jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView;
  WerewolvesHandler jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler;
  WerewolvesObserver jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver = new GameRoomChatPie.18(this);
  WerewolvesPluginManager jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new GameRoomChatPie.24(this);
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GameRoomChatPie.5(this);
  protected LinearLayout b;
  QQProgressDialog d;
  protected RelativeLayout e;
  int k;
  int l;
  protected ImageView l;
  protected TextView l;
  private final int m;
  protected View m;
  protected ImageView m;
  protected TextView m;
  View n;
  
  public GameRoomChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_m_of_type_Int = Color.parseColor("#00000000");
  }
  
  public void J()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a(this);
    }
    if ((this.I) || (!this.X))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hasDestory = true return");
      }
      return;
    }
    super.J();
    this.X = false;
    if (this.V) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new GameRoomChatPie.6(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
    ((View)this.jdField_d_of_type_AndroidViewViewGroup.getParent()).setBackgroundColor(0);
    a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167091), true);
    try
    {
      if ((this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void O()
  {
    super.O();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (Exception localException)
    {
      label19:
      WerewolvesPluginInterface localWerewolvesPluginInterface;
      break label19;
    }
    localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if ((localWerewolvesPluginInterface != null) && (HotChatManager.jdField_a_of_type_Boolean)) {
      localWerewolvesPluginInterface.d();
    }
    HotChatManager.jdField_a_of_type_Boolean = true;
    if (((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b()) || (!this.U)) && (!this.V) && (this.Y))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(1, null, l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if ((localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.b())) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.Y = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.jdField_a_of_type_Boolean = false;
  }
  
  public void P()
  {
    super.P();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    }
  }
  
  public void R()
  {
    super.R();
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.d();
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.jdField_d_of_type_Boolean = false;
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a()) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this);
    }
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.e();
    }
  }
  
  protected View a()
  {
    GameView localGameView = new GameView(this.jdField_a_of_type_AndroidContentContext, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.jdField_m_of_type_AndroidViewView = localGameView;
    return localGameView;
  }
  
  public View a(int paramInt)
  {
    View localView = super.a(paramInt);
    Object localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (paramInt == 25)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel = ((GameQuickWordsPanel)View.inflate(a(), 2131558645, null));
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
      }
    }
    return localObject;
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
      if (localObject == null) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "onPanelChanged: drawables == null");
      }
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
      return;
    }
    this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.V = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.V) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l1 = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
    if (paramList.size() != 0)
    {
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage.time < l1) {
          paramList.remove(i);
        }
        for (;;)
        {
          i -= 1;
          break;
          if ((((localChatMessage instanceof MessageForGrayTips)) || ((localChatMessage instanceof MessageForNewGrayTips))) && (!(localChatMessage instanceof MessageForTroopGift))) {
            paramList.remove(i);
          }
        }
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
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController = GameRoomAVController.a();
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a((String)localObject);
    super.a(paramBoolean);
    int i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      if (!Settings.canDrawOverlays((Context)localObject))
      {
        i = 0;
        ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        b(1);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
      this.X = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this.jdField_a_of_type_AndroidContentContext);
      localObject = new IntentFilter("tencent.av.v2q.StartVideoChat");
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.werewoves.plugin");
      try
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
      i = 1;
    }
  }
  
  public void aF()
  {
    super.aF();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((WerewolvesPluginInterface)localObject).b();
    } while ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) || (localObject == null));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void aP() {}
  
  public boolean b()
  {
    return false;
  }
  
  public void bn()
  {
    if ((this.V) || (E())) {}
    do
    {
      return;
      try
      {
        long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e(this.jdField_b_of_type_JavaLangString, 2, "the sessionInfo.curFriendUin is null");
  }
  
  public void bo() {}
  
  public void bp()
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
      bq();
      return;
    }
    ThreadManager.post(new GameRoomChatPie.15(this), 8, null, true);
  }
  
  public void bq()
  {
    ThreadManager.post(new GameRoomChatPie.16(this), 8, null, true);
  }
  
  public void br()
  {
    Intent localIntent = new Intent(a(), QQBrowserActivity.class);
    this.Y = false;
    localIntent.putExtra("url", "https://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.jdField_a_of_type_Boolean = false;
    a().startActivity(localIntent);
  }
  
  public void bs()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    localActionSheet.setMainTitle(HardCodeUtil.a(2131705118));
    localActionSheet.addButton(HardCodeUtil.a(2131705105), 3);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new GameRoomChatPie.22(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void bt()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject == null) {
      return;
    }
    localObject = ((WerewolvesPluginInterface)localObject).b();
    this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("audioIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void bu()
  {
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {
      return;
    }
    int i = localWerewolvesPluginInterface.b();
    int j = localWerewolvesPluginInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(localHotChatInfo, i, j, new GameRoomChatPie.25(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, "" + i, "" + j, "", "");
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "Q.werewolf.GameRoomChatPie";
  }
  
  public void e(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690601);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131705146));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void e(boolean paramBoolean)
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null)
    {
      super.e(paramBoolean);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b())
    {
      super.e(paramBoolean);
      this.U = true;
      this.V = true;
      return;
    }
    if ((localWerewolvesPluginInterface.b()) && (localWerewolvesPluginInterface.c()))
    {
      super.e(paramBoolean);
      this.U = true;
      return;
    }
    if ((localWerewolvesPluginInterface.b()) && (!localWerewolvesPluginInterface.c()))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705154), HardCodeUtil.a(2131705100), HardCodeUtil.a(2131705133), new GameRoomChatPie.11(this, paramBoolean), new GameRoomChatPie.12(this)).show();
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705130), HardCodeUtil.a(2131705087), HardCodeUtil.a(2131705141), new GameRoomChatPie.13(this, paramBoolean, localWerewolvesPluginInterface), new GameRoomChatPie.14(this)).show();
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.Q = paramBoolean1;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.jdField_a_of_type_Boolean = paramBoolean1;
    a(0, true);
    a().setImmersiveStatus(0);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {}
    label651:
    label661:
    for (;;)
    {
      return;
      HashMap localHashMap1 = localWerewolvesPluginInterface.b();
      HashMap localHashMap2 = localWerewolvesPluginInterface.a();
      if ((localHashMap1 != null) && (localHashMap2 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(0);
        this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_k_of_type_AndroidWidgetImageView.setScaleX(0.0F);
        Drawable localDrawable = (Drawable)localHashMap1.get("aioBg");
        View localView = (View)this.jdField_d_of_type_AndroidViewViewGroup.getParent();
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        localView.setBackgroundDrawable(localDrawable);
        a(0, true);
        this.jdField_l_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap1.get("inputBg"));
        this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("pressTipsColor")).intValue());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable((Drawable)localHashMap1.get("sendBtnBg"));
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(((Integer)localHashMap2.get("sendBtnColor")).intValue());
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
        {
          this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIconOn"));
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(((Integer)localHashMap2.get("bottomBarColor")).intValue());
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)localHashMap2.get("quickWordBgColor")).intValue());
          }
          if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
            break label599;
          }
          this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("textIcon"));
          label317:
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130839761);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a();
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("titleColor")).intValue());
          this.f.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("leftTextColor")).intValue());
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap1.get("backIcon"));
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("rightMenu"));
          if (!paramBoolean1) {
            break label620;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(0.2F);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(false);
          label450:
          if (!paramBoolean1) {
            break label651;
          }
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if ((!paramBoolean2) || (localWerewolvesPluginInterface.c())) {
            break label639;
          }
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_m_of_type_AndroidWidgetTextView.setBackgroundColor(((Integer)localHashMap2.get("wolfBtnBg")).intValue());
          this.jdField_l_of_type_Int = ((Integer)localHashMap2.get("wolfBtnTextPress")).intValue();
          this.jdField_k_of_type_Int = ((Integer)localHashMap2.get("wolfBtnText")).intValue();
          this.jdField_m_of_type_AndroidWidgetTextView.setTextColor(this.jdField_k_of_type_Int);
        }
        for (;;)
        {
          if (this.n == null) {
            break label661;
          }
          this.n.setBackgroundColor(((Integer)localHashMap2.get("bottomBarMask")).intValue());
          return;
          this.jdField_m_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIcon"));
          break;
          label599:
          this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
          break label317;
          label620:
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(1.0F);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(true);
          break label450;
          label639:
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    }
  }
  
  public void f(int paramInt)
  {
    super.f(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(paramInt);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.a(paramInt);
    }
  }
  
  public void g()
  {
    int j = 0;
    super.g();
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    if ((localObject == null) || (((String)localObject).equals("1000")))
    {
      i = 1;
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
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setId(2131370416);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(16);
      new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F)).addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setPadding(0, 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 0.0F));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(true);
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setBackgroundColor(-1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130838187);
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
      int i1 = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_l_of_type_AndroidWidgetImageView.setPadding(i1, i1, i1, i1);
      this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_l_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_m_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_m_of_type_AndroidWidgetImageView.setImageResource(2130838229);
      this.jdField_m_of_type_AndroidWidgetImageView.setPadding(0, i1, 0, i1);
      this.jdField_m_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_m_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_l_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_l_of_type_AndroidWidgetTextView.setGravity(17);
      if (i == 0) {
        break label1045;
      }
      this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a1a2a3"));
      label588:
      this.jdField_l_of_type_AndroidWidgetTextView.setBackgroundResource(2130850251);
      this.jdField_l_of_type_AndroidWidgetTextView.setTextSize(16.0F);
      this.jdField_l_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705153));
      this.jdField_l_of_type_AndroidWidgetTextView.setMinHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
      this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 86.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_l_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_l_of_type_AndroidWidgetTextView.setOnTouchListener(new GameRoomChatPie.1(this));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new GameRoomChatPie.2(this));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_m_of_type_Int);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_m_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_m_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_m_of_type_AndroidWidgetTextView.setTextSize(18.0F);
      this.jdField_m_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705167));
      this.jdField_m_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_m_of_type_AndroidWidgetTextView.setOnTouchListener(new GameRoomChatPie.3(this));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_m_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 245.0F));
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      i = j;
      label982:
      if (i >= this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount()) {
        break label1091;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i) != this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout) {
        break label1068;
      }
    }
    for (;;)
    {
      if (i >= 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(a(), i, (ViewGroup.LayoutParams)localObject);
      }
      for (;;)
      {
        this.f.setVisibility(8);
        bp();
        return;
        i = 0;
        break;
        label1045:
        this.jdField_l_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167133));
        break label588;
        label1068:
        i += 1;
        break label982;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(a(), (ViewGroup.LayoutParams)localObject);
      }
      label1091:
      i = -1;
    }
  }
  
  public boolean g()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {
      return super.g();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      return super.g();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a()))
    {
      aM();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b())
    {
      this.U = true;
      this.V = true;
      return super.g();
    }
    if ((localWerewolvesPluginInterface.b()) && (localWerewolvesPluginInterface.c()))
    {
      this.U = true;
      return super.g();
    }
    if ((localWerewolvesPluginInterface.b()) && (!localWerewolvesPluginInterface.c()))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705125), HardCodeUtil.a(2131705151), HardCodeUtil.a(2131705135), new GameRoomChatPie.7(this), new GameRoomChatPie.8(this)).show();
      return true;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, HardCodeUtil.a(2131705159), HardCodeUtil.a(2131705115), HardCodeUtil.a(2131705093), new GameRoomChatPie.9(this, localWerewolvesPluginInterface), new GameRoomChatPie.10(this)).show();
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60) {
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  public void i(String paramString)
  {
    this.V = true;
    this.W = false;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setPositiveButton(2131694615, new GameRoomChatPie.19(this));
    localQQCustomDialog.setOnDismissListener(new GameRoomChatPie.20(this));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onKickOut! isStopped = " + this.ad);
    }
    if (!this.ad)
    {
      localQQCustomDialog.show();
      return;
    }
    this.W = true;
    b(1);
  }
  
  public void j(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html").append("?_bid=2652&from=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&gc=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append("&toUin=").append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    GameRoomAVController.a().jdField_d_of_type_Boolean = true;
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694460, 0).a();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694460, 0).a();
  }
  
  public void t()
  {
    this.f.setVisibility(8);
  }
  
  public void t(boolean paramBoolean)
  {
    this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      aF();
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.c();
      this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_m_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
      if (this.n == null)
      {
        this.n = new View(this.jdField_a_of_type_AndroidContentContext);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth() != 0)
        {
          localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth(), this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight());
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.n, (ViewGroup.LayoutParams)localObject);
          this.n.setBackgroundColor(Color.parseColor("#77FFFFFF"));
          if (localWerewolvesPluginInterface != null)
          {
            localObject = localWerewolvesPluginInterface.a();
            this.n.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
          }
          label177:
          this.n.setVisibility(0);
          if ((localWerewolvesPluginInterface == null) || (!localWerewolvesPluginInterface.c())) {
            break label292;
          }
          this.jdField_l_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705150));
          label209:
          if (!this.Q) {
            this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
      }
    }
    label292:
    do
    {
      return;
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      break;
      localObject = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredWidth();
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getMeasuredHeight();
      this.n.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label177;
      this.jdField_l_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705103));
      break label209;
      this.jdField_l_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131705126));
      this.jdField_l_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_l_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_m_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    } while (this.n == null);
    this.n.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
  
  public void z()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    boolean bool;
    if (localWerewolvesPluginInterface != null)
    {
      bool = localWerewolvesPluginInterface.c();
      if (bool) {
        localActionSheet.addButton(HardCodeUtil.a(2131705084), 3);
      }
      if (!bool) {
        break label102;
      }
      localActionSheet.addButton(HardCodeUtil.a(2131705148));
    }
    for (;;)
    {
      localActionSheet.addButton(HardCodeUtil.a(2131705155));
      localActionSheet.addCancelButton(HardCodeUtil.a(2131705109));
      localActionSheet.setOnButtonClickListener(new GameRoomChatPie.21(this, bool, localActionSheet));
      localActionSheet.show();
      return;
      bool = false;
      break;
      label102:
      localActionSheet.addButton(HardCodeUtil.a(2131705106), 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie
 * JD-Core Version:    0.7.0.1
 */