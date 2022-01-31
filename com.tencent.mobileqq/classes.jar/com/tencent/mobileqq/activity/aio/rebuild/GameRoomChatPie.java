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
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
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
import vto;
import vtp;
import vtq;
import vtr;
import vts;
import vtt;
import vtu;
import vtv;
import vtx;
import vty;
import vtz;
import vua;
import vub;
import vuc;
import vue;
import vuf;
import vug;
import vuh;
import vui;
import vuj;
import vuk;
import vul;

public class GameRoomChatPie
  extends HotChatPie
  implements GameRoomAVController.OnBindCallback
{
  public boolean V;
  public boolean W;
  public boolean X = true;
  boolean Y = false;
  boolean Z = true;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new vue(this);
  public GameQuickWordsPanel a;
  public GameRoomAVController a;
  public WereWolvesLoadingView a;
  WerewolvesHandler jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler;
  WerewolvesObserver jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver = new vtx(this);
  public WerewolvesPluginManager a;
  private View.OnClickListener b;
  protected LinearLayout d;
  public QQProgressDialog d;
  protected RelativeLayout e;
  public TextView j;
  public TextView k;
  public int m;
  public int n;
  public ImageView n;
  private final int o;
  public View o;
  public ImageView o;
  View p;
  
  public GameRoomChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_o_of_type_Int = Color.parseColor("#00000000");
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new vuh(this);
  }
  
  protected void E()
  {
    super.E();
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
      localWerewolvesPluginInterface.c();
    }
    HotChatManager.jdField_a_of_type_Boolean = true;
    if (((this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b()) || (!this.V)) && (!this.W) && (this.Z))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(1, null, l1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if ((localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.b())) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.Z = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.jdField_a_of_type_Boolean = false;
  }
  
  protected void G()
  {
    super.G();
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.d();
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.d = false;
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a()) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this);
    }
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.d();
    }
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel = ((GameQuickWordsPanel)View.inflate(a(), 2130968638, null));
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel;
      }
    }
    return localObject;
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a().a();
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(paramInt);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject != null)
    {
      localObject = ((WerewolvesPluginInterface)localObject).b();
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3) {
        this.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
      }
    }
    else
    {
      return;
    }
    this.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.W = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.W) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(List paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
    if (paramList.size() != 0)
    {
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage.time < l) {
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
  
  public boolean a()
  {
    return false;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController = GameRoomAVController.a();
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a((String)localObject);
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    this.Y = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(this.jdField_a_of_type_AndroidContentContext);
    localObject = new IntentFilter("tencent.av.v2q.StartVideoChat");
    try
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  protected void aK() {}
  
  public void ay()
  {
    super.ay();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((WerewolvesPluginInterface)localObject).b();
    } while ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() != 0) || (localObject == null));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_n_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(4);
    this.j.setVisibility(0);
  }
  
  public void bc()
  {
    if ((this.W) || (x())) {}
    do
    {
      return;
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.a(l, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("Q.werewolf.GameRoomChatPie", 2, "the sessionInfo.curFriendUin is null");
  }
  
  public void bd() {}
  
  public void be()
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = new WereWolvesLoadingView(a());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setBackgroundDrawable((Drawable)localObject);
    if (a().getIntent().getBooleanExtra("isNeedShowLoading", true))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView, -1, -1);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a())
    {
      bf();
      return;
    }
    ThreadManager.post(new vtu(this), 8, null, true);
  }
  
  public void bf()
  {
    ThreadManager.post(new vtv(this), 8, null, true);
  }
  
  public void bg()
  {
    Intent localIntent = new Intent(a(), QQBrowserActivity.class);
    this.Z = false;
    localIntent.putExtra("url", "http://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.jdField_a_of_type_Boolean = false;
    a().startActivity(localIntent);
  }
  
  public void bh()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    localActionSheet.a("退出后将不能重新进入该游戏房间");
    localActionSheet.a("退出游戏", 3);
    localActionSheet.c(2131433015);
    localActionSheet.a(new vuc(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void bi()
  {
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a().b();
    this.jdField_n_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap.get("audioIcon"));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.j.setVisibility(4);
  }
  
  public void bj()
  {
    HotChatInfo localHotChatInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {
      return;
    }
    int i = localWerewolvesPluginInterface.b();
    int i1 = localWerewolvesPluginInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(localHotChatInfo, i, i1, new vuf(this));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, "" + i, "" + i1, "", "");
  }
  
  protected View c()
  {
    GameView localGameView = new GameView(this.jdField_a_of_type_AndroidContentContext, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.jdField_o_of_type_AndroidViewView = localGameView;
    return localGameView;
  }
  
  protected void d()
  {
    int i1 = 0;
    super.d();
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
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setGravity(16);
      this.jdField_d_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setId(2131367842);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setGravity(16);
      new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F)).addRule(12);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_d_of_type_AndroidWidgetLinearLayout, 0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setPadding(0, 0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 0.0F));
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setClickable(true);
      if (i != 0)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130837622);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(4);
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
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
      int i2 = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      this.jdField_n_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_n_of_type_AndroidWidgetImageView.setPadding(i2, i2, i2, i2);
      this.jdField_n_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.addView(this.jdField_n_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.jdField_o_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_o_of_type_AndroidWidgetImageView.setImageResource(2130837645);
      this.jdField_o_of_type_AndroidWidgetImageView.setPadding(0, i2, 0, i2);
      this.jdField_o_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.addView(this.jdField_o_of_type_AndroidWidgetImageView, new ViewGroup.LayoutParams(-2, -2));
      this.j = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.j.setGravity(17);
      if (i == 0) {
        break label1039;
      }
      this.j.setTextColor(Color.parseColor("#a1a2a3"));
      label588:
      this.j.setBackgroundResource(2130845636);
      this.j.setTextSize(16.0F);
      this.j.setText("按住发言");
      this.j.setMinHeight(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 35.0F));
      this.j.setEnabled(false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 86.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.j, (ViewGroup.LayoutParams)localObject);
      this.j.setOnTouchListener(new vto(this));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new vtz(this));
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 295.0F);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_o_of_type_Int);
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      this.k = new TextView(this.jdField_a_of_type_AndroidContentContext);
      this.k.setGravity(17);
      this.k.setTextSize(18.0F);
      this.k.setText("按住私密发言");
      this.k.setEnabled(true);
      this.k.setVisibility(0);
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.k.setOnTouchListener(new vug(this));
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.addView(this.k, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 245.0F));
      ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
      i = i1;
      label976:
      if (i >= this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildCount()) {
        break label1085;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(i) != this.jdField_b_of_type_AndroidWidgetLinearLayout) {
        break label1062;
      }
    }
    for (;;)
    {
      if (i >= 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(c(), i, (ViewGroup.LayoutParams)localObject);
      }
      for (;;)
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        be();
        return;
        i = 0;
        break;
        label1039:
        this.j.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494282));
        break label588;
        label1062:
        i += 1;
        break label976;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(c(), (ViewGroup.LayoutParams)localObject);
      }
      label1085:
      i = -1;
    }
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.R = paramBoolean1;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.jdField_a_of_type_Boolean = paramBoolean1;
    a(0, true);
    a().setImmersiveStatus(0);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {}
    label649:
    label659:
    for (;;)
    {
      return;
      HashMap localHashMap1 = localWerewolvesPluginInterface.b();
      HashMap localHashMap2 = localWerewolvesPluginInterface.a();
      if ((localHashMap1 != null) && (localHashMap2 != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(0);
        this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_m_of_type_AndroidWidgetImageView.setScaleX(0.0F);
        Drawable localDrawable = (Drawable)localHashMap1.get("aioBg");
        View localView = (View)this.jdField_d_of_type_AndroidViewViewGroup.getParent();
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundColor(0);
        localView.setBackgroundDrawable(localDrawable);
        a(0, true);
        this.j.setBackgroundDrawable((Drawable)localHashMap1.get("inputBg"));
        this.j.setTextColor(((Integer)localHashMap2.get("pressTipsColor")).intValue());
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setBackgroundDrawable((Drawable)localHashMap1.get("sendBtnBg"));
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setTextColor(((Integer)localHashMap2.get("sendBtnColor")).intValue());
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
        {
          this.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIconOn"));
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setBackgroundColor(((Integer)localHashMap2.get("bottomBarColor")).intValue());
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.setBackgroundColor(((Integer)localHashMap2.get("quickWordBgColor")).intValue());
          }
          if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
            break label597;
          }
          this.jdField_n_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("textIcon"));
          label316:
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130838878);
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.a();
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("titleColor")).intValue());
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((Integer)localHashMap2.get("leftTextColor")).intValue());
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localHashMap1.get("backIcon"));
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("rightMenu"));
          if (!paramBoolean1) {
            break label618;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(0.2F);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(false);
          label449:
          if (!paramBoolean1) {
            break label649;
          }
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          if ((!paramBoolean2) || (localWerewolvesPluginInterface.c())) {
            break label637;
          }
          this.k.setVisibility(0);
          this.k.setBackgroundColor(((Integer)localHashMap2.get("wolfBtnBg")).intValue());
          this.jdField_n_of_type_Int = ((Integer)localHashMap2.get("wolfBtnTextPress")).intValue();
          this.jdField_m_of_type_Int = ((Integer)localHashMap2.get("wolfBtnText")).intValue();
          this.k.setTextColor(this.jdField_m_of_type_Int);
        }
        for (;;)
        {
          if (this.p == null) {
            break label659;
          }
          this.p.setBackgroundColor(((Integer)localHashMap2.get("bottomBarMask")).intValue());
          return;
          this.jdField_o_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("emojIcon"));
          break;
          label597:
          this.jdField_n_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localHashMap1.get("audioIcon"));
          break label316;
          label618:
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAlpha(1.0F);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setEnabled(true);
          break label449;
          label637:
          this.k.setVisibility(8);
          continue;
          this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
      }
    }
  }
  
  protected void e(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131432414);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回");
    this.c = false;
  }
  
  public void e(String paramString)
  {
    this.W = true;
    this.X = false;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230);
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setPositiveButton(2131433016, new vty(this));
    localQQCustomDialog.setOnDismissListener(new vua(this));
    if (QLog.isColorLevel()) {
      QLog.d("Q.werewolf.GameRoomChatPie", 2, "onKickOut! isStopped = " + this.ae);
    }
    if (!this.ae)
    {
      localQQCustomDialog.show();
      return;
    }
    this.X = true;
    b(1);
  }
  
  protected void e(boolean paramBoolean)
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
      this.V = true;
      this.W = true;
      return;
    }
    if ((localWerewolvesPluginInterface.b()) && (localWerewolvesPluginInterface.c()))
    {
      super.e(paramBoolean);
      this.V = true;
      return;
    }
    if ((localWerewolvesPluginInterface.b()) && (!localWerewolvesPluginInterface.c()))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, "你的发言和分析对于队友非常重要，请不要轻易离开房间", "留在房间", "暂时离开", new vtq(this, paramBoolean), new vtr(this)).show();
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, "你已经进入游戏，是否确定退出？", "否", "是", new vts(this, paramBoolean, localWerewolvesPluginInterface), new vtt(this)).show();
  }
  
  protected boolean e()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (localWerewolvesPluginInterface == null) {
      return super.e();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      return super.e();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyGiftNearbyGiftPanelDialog.a()))
    {
      aH();
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b())
    {
      this.V = true;
      this.W = true;
      return super.e();
    }
    if ((localWerewolvesPluginInterface.b()) && (localWerewolvesPluginInterface.c()))
    {
      this.V = true;
      return super.e();
    }
    if ((localWerewolvesPluginInterface.b()) && (!localWerewolvesPluginInterface.c()))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, "你的发言和分析对于队友非常重要，请不要轻易离开房间", "留在房间", "暂时离开", new vuj(this), new vuk(this)).show();
      return true;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, "你已经进入游戏，是否确定退出？", "否", "是", new vul(this, localWerewolvesPluginInterface), new vtp(this)).show();
    return true;
  }
  
  public void f(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html").append("?_bid=2652&from=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).append("&gc=").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).append("&toUin=").append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    GameRoomAVController.a().d = true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60) {
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void n()
  {
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void o(boolean paramBoolean)
  {
    this.j.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      ay();
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.c();
      this.j.setEnabled(false);
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_o_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
      if (this.p == null)
      {
        this.p = new View(this.jdField_a_of_type_AndroidContentContext);
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredWidth() != 0)
        {
          localObject = new RelativeLayout.LayoutParams(this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredWidth(), this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight());
          ((RelativeLayout.LayoutParams)localObject).addRule(12);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.p, (ViewGroup.LayoutParams)localObject);
          this.p.setBackgroundColor(Color.parseColor("#77FFFFFF"));
          if (localWerewolvesPluginInterface != null)
          {
            localObject = localWerewolvesPluginInterface.a();
            this.p.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
          }
          label177:
          this.p.setVisibility(0);
          if ((localWerewolvesPluginInterface == null) || (!localWerewolvesPluginInterface.c())) {
            break label289;
          }
          this.j.setText("已死亡");
          label206:
          if (!this.R) {
            this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
        }
      }
    }
    label289:
    do
    {
      return;
      localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      break;
      localObject = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
      ((RelativeLayout.LayoutParams)localObject).height = this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
      this.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break label177;
      this.j.setText("已禁麦");
      break label206;
      this.j.setText("按住发言");
      this.j.setEnabled(true);
      this.jdField_n_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_o_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    } while (this.p == null);
    this.p.setVisibility(8);
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131434843, 0).a();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131434843, 0).a();
  }
  
  public void s()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    boolean bool;
    if (localWerewolvesPluginInterface != null)
    {
      bool = localWerewolvesPluginInterface.c();
      if (bool) {
        localActionSheet.a("再来一局", 3);
      }
      if (!bool) {
        break label90;
      }
      localActionSheet.c("退出游戏");
    }
    for (;;)
    {
      localActionSheet.c("查看游戏规则");
      localActionSheet.d("取消");
      localActionSheet.a(new vub(this, bool, localActionSheet));
      localActionSheet.show();
      return;
      bool = false;
      break;
      label90:
      localActionSheet.a("退出游戏", 3);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
  
  protected void z()
  {
    if ((this.I) || (!this.Y))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.werewolf.GameRoomChatPie", 2, "hasDestory = true return");
      }
      return;
    }
    super.z();
    this.Y = false;
    if (this.W) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new vui(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesObserver);
    ((View)this.jdField_d_of_type_AndroidViewViewGroup.getParent()).setBackgroundColor(0);
    a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494254), true);
    try
    {
      if ((this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_d_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie
 * JD-Core Version:    0.7.0.1
 */