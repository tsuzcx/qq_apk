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
  protected boolean bA = true;
  WerewolvesHandler bB;
  WerewolvesPluginManager bC;
  QQProgressDialog bD;
  WereWolvesLoadingView bE;
  View bF;
  int bG;
  int bH;
  boolean bI = false;
  GameQuickWordsPanel bJ;
  WerewolvesObserver bK = new GameRoomChatPie.18(this);
  boolean bL = true;
  BroadcastReceiver bM = new GameRoomChatPie.23(this);
  BroadcastReceiver bN = new GameRoomChatPie.24(this);
  protected View br;
  protected ImageView bs;
  protected ImageView bt;
  protected TextView bu;
  protected TextView bv;
  protected RelativeLayout bw;
  protected LinearLayout bx;
  protected boolean by;
  protected boolean bz;
  private final int ct = Color.parseColor("#00000000");
  private View.OnClickListener cu = new GameRoomChatPie.5(this);
  
  public GameRoomChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  public void B()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(aX(), null);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.bC.c();
    boolean bool;
    if (localWerewolvesPluginInterface != null) {
      bool = localWerewolvesPluginInterface.e();
    } else {
      bool = false;
    }
    if (bool) {
      localActionSheet.addButton(HardCodeUtil.a(2131903051), 3);
    }
    if (bool) {
      localActionSheet.addButton(HardCodeUtil.a(2131903110));
    } else {
      localActionSheet.addButton(HardCodeUtil.a(2131903071), 3);
    }
    localActionSheet.addButton(HardCodeUtil.a(2131903117));
    localActionSheet.addCancelButton(HardCodeUtil.a(2131898212));
    localActionSheet.setOnButtonClickListener(new GameRoomChatPie.21(this, bool, localActionSheet));
    localActionSheet.show();
  }
  
  public void K()
  {
    WerewolvesPluginManager localWerewolvesPluginManager = this.bC;
    if (localWerewolvesPluginManager != null) {
      localWerewolvesPluginManager.a(this);
    }
    if ((!this.aY) && (this.bI))
    {
      super.K();
      this.bI = false;
      if (this.bz) {
        this.bB.a(this.bR, new GameRoomChatPie.6(this));
      }
      this.d.removeObserver(this.bK);
      ((View)this.ba.getParent()).setBackgroundColor(0);
      b(this.e.getResources().getColor(2131168092), true);
      try
      {
        if ((this.bD != null) && (this.bD.isShowing()))
        {
          this.bD.dismiss();
          this.bD = null;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      this.f.unregisterReceiver(this.bN);
      this.f.unregisterReceiver(this.bM);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.c, 2, "hasDestory = true return");
    }
  }
  
  public void P()
  {
    super.P();
    try
    {
      l = Long.parseLong(this.ah.b);
    }
    catch (Exception localException)
    {
      long l;
      label18:
      WerewolvesPluginInterface localWerewolvesPluginInterface;
      break label18;
    }
    l = 0L;
    localWerewolvesPluginInterface = this.bC.c();
    if ((localWerewolvesPluginInterface != null) && (HotChatManager.a)) {
      localWerewolvesPluginInterface.k();
    }
    HotChatManager.a = true;
    if (((this.bC.e()) || (!this.by)) && (!this.bz) && (this.bL))
    {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).showFloatView(1, null, l, this.ah.e);
      if ((localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.d())) {
        ReportController.b(this.d, "dc00899", "Grp_wolf", "", "in_game", "mini_ball", 0, 0, "", "", "", "");
      }
    }
    this.bL = true;
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInAIO(false);
  }
  
  protected void Q()
  {
    super.Q();
    if (this.Y.getVisibility() != 0) {
      this.Z.setVisibility(4);
    }
  }
  
  public void S()
  {
    super.S();
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInAIO(true);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInGameGift(false);
    if (!((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).isBinded()) {
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).bindService(this);
    }
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.bC.c();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.l();
    }
  }
  
  public boolean V()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.bC.c();
    if (localWerewolvesPluginInterface == null) {
      return super.V();
    }
    if (this.n.getCurrentPanel() != 0) {
      return super.V();
    }
    HotGiftPanelHelper localHotGiftPanelHelper = (HotGiftPanelHelper)q(136);
    if ((localHotGiftPanelHelper.g != null) && (localHotGiftPanelHelper.g.b()))
    {
      localHotGiftPanelHelper.e();
      return true;
    }
    if (!this.bC.e())
    {
      this.by = true;
      this.bz = true;
      return super.V();
    }
    if ((localWerewolvesPluginInterface.d()) && (localWerewolvesPluginInterface.e()))
    {
      this.by = true;
      return super.V();
    }
    if ((localWerewolvesPluginInterface.d()) && (!localWerewolvesPluginInterface.e()))
    {
      DialogUtil.a(this.e, 230, null, HardCodeUtil.a(2131903088), HardCodeUtil.a(2131903113), HardCodeUtil.a(2131903098), new GameRoomChatPie.7(this), new GameRoomChatPie.8(this)).show();
      return true;
    }
    DialogUtil.a(this.e, 230, null, HardCodeUtil.a(2131903121), HardCodeUtil.a(2131903078), HardCodeUtil.a(2131903060), new GameRoomChatPie.9(this, localWerewolvesPluginInterface), new GameRoomChatPie.10(this)).show();
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject = this.bC.c();
    if (localObject != null)
    {
      localObject = ((WerewolvesPluginInterface)localObject).j();
      if (localObject == null)
      {
        QLog.e(this.c, 1, "onPanelChanged: drawables == null");
        return;
      }
      if (this.n.getCurrentPanel() == 3)
      {
        this.bt.setImageDrawable((Drawable)((HashMap)localObject).get("emojIconOn"));
        return;
      }
      this.bt.setImageDrawable((Drawable)((HashMap)localObject).get("emojIcon"));
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2000) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.bz = paramIntent.getExtras().getBoolean("isNeedFinish");
      if (this.bz) {
        ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).reset(this.e);
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    long l = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.d.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(0L))).longValue();
    if (paramList.size() != 0)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
        if (localChatMessage.time < l) {
          paramList.remove(i);
        } else if ((((localChatMessage instanceof MessageForGrayTips)) || ((localChatMessage instanceof MessageForNewGrayTips))) && (!(localChatMessage instanceof MessageForTroopGift))) {
          paramList.remove(i);
        }
        i -= 1;
      }
    }
    super.a(paramList, paramCharSequence, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramCharSequence = (ChatMessage)paramList.next();
      if ((this.bB.e != null) && (this.bB.e.equals(paramCharSequence.senderuin))) {
        paramCharSequence.isFlowMessage = false;
      }
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    Object localObject = this.f.getIntent().getStringExtra("uin");
    this.bB = ((WerewolvesHandler)this.d.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER));
    this.bC = this.bB.a((String)localObject);
    super.a(paramBoolean);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = this.f;
      if (!Settings.canDrawOverlays((Context)localObject))
      {
        i = 0;
        ((Context)localObject).startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
        break label90;
      }
    }
    int i = 1;
    label90:
    if (i == 0)
    {
      f(1);
      return true;
    }
    this.ah.b = this.f.getIntent().getStringExtra("uin");
    this.bI = true;
    this.d.addObserver(this.bK);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).reset(this.e);
    localObject = new IntentFilter("tencent.av.v2q.StartVideoChat");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.werewoves.plugin");
    try
    {
      this.f.registerReceiver(this.bM, localIntentFilter);
      this.f.registerReceiver(this.bN, (IntentFilter)localObject);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void aQ()
  {
    super.aQ();
    Object localObject = this.bC.c();
    if (localObject == null) {
      return;
    }
    localObject = ((WerewolvesPluginInterface)localObject).j();
    if ((this.Y.getVisibility() == 0) && (localObject != null))
    {
      this.Y.setVisibility(4);
      this.bs.setImageDrawable((Drawable)((HashMap)localObject).get("textIcon"));
      this.Y.setVisibility(4);
      this.Z.setVisibility(4);
      this.bu.setVisibility(0);
    }
  }
  
  public View b(int paramInt)
  {
    View localView = super.b(paramInt);
    if ((localView == null) && (paramInt == 25))
    {
      this.bJ = ((GameQuickWordsPanel)View.inflate(aX(), 2131624098, null));
      this.bJ.a(this.d, this.ah, this);
      return this.bJ;
    }
    return localView;
  }
  
  protected void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.Z.setVisibility(4);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bn = paramBoolean1;
    this.bB.g = paramBoolean1;
    b(0, true);
    aX().setImmersiveStatus(0);
    Object localObject1 = this.bC.c();
    if (localObject1 == null) {
      return;
    }
    HashMap localHashMap2 = ((WerewolvesPluginInterface)localObject1).j();
    HashMap localHashMap1 = ((WerewolvesPluginInterface)localObject1).i();
    if (localHashMap2 != null)
    {
      if (localHashMap1 == null) {
        return;
      }
      this.p.setBackgroundColor(0);
      this.aM.setVisibility(8);
      this.aM.setScaleX(0.0F);
      Object localObject2 = (Drawable)localHashMap2.get("aioBg");
      View localView = (View)this.ba.getParent();
      this.ba.setBackgroundColor(0);
      localView.setBackgroundDrawable((Drawable)localObject2);
      b(0, true);
      this.bu.setBackgroundDrawable((Drawable)localHashMap2.get("inputBg"));
      this.bu.setTextColor(((Integer)localHashMap1.get("pressTipsColor")).intValue());
      this.Z.setBackgroundDrawable((Drawable)localHashMap2.get("sendBtnBg"));
      this.Z.setTextColor(((Integer)localHashMap1.get("sendBtnColor")).intValue());
      if (this.n.getCurrentPanel() == 3) {
        this.bt.setImageDrawable((Drawable)localHashMap2.get("emojIconOn"));
      } else {
        this.bt.setImageDrawable((Drawable)localHashMap2.get("emojIcon"));
      }
      this.bx.setBackgroundColor(((Integer)localHashMap1.get("bottomBarColor")).intValue());
      localObject2 = this.bJ;
      if (localObject2 != null) {
        ((GameQuickWordsPanel)localObject2).setBackgroundColor(((Integer)localHashMap1.get("quickWordBgColor")).intValue());
      }
      if (this.Y.getVisibility() != 0) {
        this.bs.setImageDrawable((Drawable)localHashMap2.get("textIcon"));
      } else {
        this.bs.setImageDrawable((Drawable)localHashMap2.get("audioIcon"));
      }
      this.Y.setBackgroundResource(2130840084);
      localObject2 = this.bJ;
      if (localObject2 != null) {
        ((GameQuickWordsPanel)localObject2).a();
      }
      this.C.setTextColor(((Integer)localHashMap1.get("titleColor")).intValue());
      this.I.setVisibility(8);
      this.s.setTextColor(((Integer)localHashMap1.get("leftTextColor")).intValue());
      this.s.setBackgroundDrawable((Drawable)localHashMap2.get("backIcon"));
      this.u.setImageDrawable((Drawable)localHashMap2.get("rightMenu"));
      if (paramBoolean1)
      {
        this.U.setAlpha(0.2F);
        this.U.setEnabled(false);
      }
      else
      {
        this.U.setAlpha(1.0F);
        this.U.setEnabled(true);
      }
      if (paramBoolean1)
      {
        this.bw.setVisibility(0);
        if ((paramBoolean2) && (!((WerewolvesPluginInterface)localObject1).e()))
        {
          this.bv.setVisibility(0);
          this.bv.setBackgroundColor(((Integer)localHashMap1.get("wolfBtnBg")).intValue());
          this.bH = ((Integer)localHashMap1.get("wolfBtnTextPress")).intValue();
          this.bG = ((Integer)localHashMap1.get("wolfBtnText")).intValue();
          this.bv.setTextColor(this.bG);
        }
        else
        {
          this.bv.setVisibility(8);
        }
      }
      else
      {
        this.bw.setVisibility(8);
      }
      localObject1 = this.bF;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(((Integer)localHashMap1.get("bottomBarMask")).intValue());
      }
    }
  }
  
  protected View bH()
  {
    GameView localGameView = new GameView(this.e, this);
    localGameView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    this.br = localGameView;
    return localGameView;
  }
  
  public HashMap<String, Integer> bI()
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.bC.c();
    if (localWerewolvesPluginInterface == null) {
      return new HashMap();
    }
    return localWerewolvesPluginInterface.i();
  }
  
  public void bJ()
  {
    if (!this.bz) {
      if (bE()) {
        return;
      }
    }
    try
    {
      long l = Long.parseLong(this.ah.b);
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).enterRoom(l, this.ah.e);
      return;
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.c, 2, "the sessionInfo.curFriendUin is null");
    }
  }
  
  public void bK() {}
  
  public void bL()
  {
    this.bE = new WereWolvesLoadingView(aX());
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#323e6f"));
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", (URLDrawable.URLDrawableOptions)localObject);
    this.bE.setBackgroundDrawable((Drawable)localObject);
    if (aX().getIntent().getBooleanExtra("isNeedShowLoading", true))
    {
      this.o.addView(this.bE, -1, -1);
      this.bE.b();
    }
    if (this.bC.b())
    {
      bM();
      return;
    }
    ThreadManager.post(new GameRoomChatPie.15(this), 8, null, true);
  }
  
  public void bM()
  {
    ThreadManager.post(new GameRoomChatPie.16(this), 8, null, true);
  }
  
  public void bN()
  {
    Intent localIntent = new Intent(aX(), QQBrowserActivity.class);
    this.bL = false;
    localIntent.putExtra("url", "https://nearby.qq.com/werewolf/game-rules.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0");
    HotChatManager.a = false;
    aX().startActivity(localIntent);
  }
  
  public void bO()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(aX(), null);
    localActionSheet.setMainTitle(HardCodeUtil.a(2131903081));
    localActionSheet.addButton(HardCodeUtil.a(2131903070), 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new GameRoomChatPie.22(this, localActionSheet));
    localActionSheet.show();
  }
  
  public void bP()
  {
    Object localObject = this.bC.c();
    if (localObject == null) {
      return;
    }
    localObject = ((WerewolvesPluginInterface)localObject).j();
    this.bs.setImageDrawable((Drawable)((HashMap)localObject).get("audioIcon"));
    this.Y.setVisibility(0);
    this.Z.setVisibility(0);
    this.bu.setVisibility(4);
  }
  
  public void bQ()
  {
    Object localObject1 = this.d.getHotChatMng(true).c(this.ah.b);
    Object localObject2 = this.bC.c();
    if (localObject2 == null) {
      return;
    }
    int i = ((WerewolvesPluginInterface)localObject2).o();
    int j = ((WerewolvesPluginInterface)localObject2).n();
    this.bB.a((HotChatInfo)localObject1, i, j, new GameRoomChatPie.25(this));
    localObject1 = this.d;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(i);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(j);
    ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "wolf", "die_newgame", 0, 0, (String)localObject2, localStringBuilder.toString(), "", "");
  }
  
  protected void bg() {}
  
  protected AIOContext d()
  {
    return new GameRoomContext();
  }
  
  public void e(String paramString)
  {
    this.bz = true;
    this.bA = false;
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.f, 230);
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setPositiveButton(2131892267, new GameRoomChatPie.19(this));
    localQQCustomDialog.setOnDismissListener(new GameRoomChatPie.20(this));
    if (QLog.isColorLevel())
    {
      paramString = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onKickOut! isStopped = ");
      localStringBuilder.append(this.cc);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    if (!this.cc)
    {
      localQQCustomDialog.show();
      return;
    }
    this.bA = true;
    f(1);
  }
  
  protected void f(Intent paramIntent)
  {
    this.s.setText(2131887440);
    this.s.setContentDescription(HardCodeUtil.a(2131901576));
    this.w.setVisibility(4);
    this.Q = false;
  }
  
  public void f(String paramString)
  {
    Intent localIntent = new Intent(this.e, HalfScreenBrowserActivity.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://nearby.qq.com/werewolf/gift.html");
    localStringBuilder.append("?_bid=2652&from=");
    localStringBuilder.append(this.d.getCurrentAccountUin());
    localStringBuilder.append("&gc=");
    localStringBuilder.append(this.ah.b);
    localStringBuilder.append("&toUin=");
    localStringBuilder.append(paramString);
    localIntent.putExtra("url", localStringBuilder.toString());
    if (!(this.e instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    this.e.startActivity(localIntent);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).setInGameGift(true);
  }
  
  public void f(boolean paramBoolean)
  {
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.bC.c();
    if (localWerewolvesPluginInterface == null)
    {
      super.f(paramBoolean);
      return;
    }
    if (!this.bC.e())
    {
      super.f(paramBoolean);
      this.by = true;
      this.bz = true;
      return;
    }
    if ((localWerewolvesPluginInterface.d()) && (localWerewolvesPluginInterface.e()))
    {
      super.f(paramBoolean);
      this.by = true;
      return;
    }
    if ((localWerewolvesPluginInterface.d()) && (!localWerewolvesPluginInterface.e()))
    {
      DialogUtil.a(this.e, 230, null, HardCodeUtil.a(2131903116), HardCodeUtil.a(2131903067), HardCodeUtil.a(2131903096), new GameRoomChatPie.11(this, paramBoolean), new GameRoomChatPie.12(this)).show();
      return;
    }
    DialogUtil.a(this.e, 230, null, HardCodeUtil.a(2131903093), HardCodeUtil.a(2131903054), HardCodeUtil.a(2131903104), new GameRoomChatPie.13(this, paramBoolean, localWerewolvesPluginInterface), new GameRoomChatPie.14(this)).show();
  }
  
  protected void h()
  {
    this.c = "Q.werewolf.GameRoomChatPie";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 60) {
      return true;
    }
    return super.handleMessage(paramMessage);
  }
  
  protected void i(int paramInt)
  {
    super.i(paramInt);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).onPhoneStateChange(paramInt);
    WerewolvesPluginInterface localWerewolvesPluginInterface = this.bC.c();
    if (localWerewolvesPluginInterface != null) {
      localWerewolvesPluginInterface.a(paramInt);
    }
  }
  
  protected void l()
  {
    super.l();
    Object localObject = ThemeUtil.getUserCurrentThemeId(this.d);
    int j = 0;
    if ((localObject != null) && (!((String)localObject).equals("1000"))) {
      i = 0;
    } else {
      i = 1;
    }
    b(-1, true);
    b(0, true);
    aX().setImmersiveStatus(0);
    localObject = (RelativeLayout.LayoutParams)this.U.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.e, 295.0F);
    this.U.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.W.setVisibility(8);
    localObject = (RelativeLayout.LayoutParams)this.X.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = DisplayUtil.a(this.e, 50.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.X.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.X.setGravity(16);
    this.bx = new LinearLayout(this.e);
    this.bx.setId(2131437237);
    this.bx.setOrientation(0);
    this.bx.setGravity(16);
    new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.e, 50.0F)).addRule(12);
    this.X.addView(this.bx, 0);
    this.X.setPadding(0, 0, 0, DisplayUtil.a(this.e, 0.0F));
    this.bx.setClickable(true);
    if (i != 0)
    {
      this.X.setBackgroundColor(-1);
      this.Y.setBackgroundResource(2130838070);
    }
    this.Y.setVisibility(4);
    localObject = (FrameLayout.LayoutParams)this.Y.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).gravity = 16;
    ((FrameLayout.LayoutParams)localObject).topMargin = 0;
    this.Y.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.Z.setVisibility(4);
    localObject = (LinearLayout.LayoutParams)this.Z.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).topMargin = 0;
    this.Z.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if ((this.Z.getParent() instanceof LinearLayout))
    {
      localObject = (LinearLayout)this.Z.getParent();
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    }
    int k = DisplayUtil.a(this.e, 5.0F);
    this.bs = new ImageView(this.e);
    this.bs.setPadding(k, k, k, k);
    this.bs.setOnClickListener(this.cu);
    this.bx.addView(this.bs, new ViewGroup.LayoutParams(-2, -2));
    this.bt = new ImageView(this.e);
    this.bt.setImageResource(2130838114);
    this.bt.setPadding(0, k, 0, k);
    this.bt.setOnClickListener(this.cu);
    this.bx.addView(this.bt, new ViewGroup.LayoutParams(-2, -2));
    this.bu = new TextView(this.e);
    this.bu.setGravity(17);
    if (i != 0) {
      this.bu.setTextColor(Color.parseColor("#a1a2a3"));
    } else {
      this.bu.setTextColor(this.e.getResources().getColor(2131168141));
    }
    this.bu.setBackgroundResource(2130851969);
    this.bu.setTextSize(16.0F);
    this.bu.setText(HardCodeUtil.a(2131903115));
    this.bu.setMinHeight(DisplayUtil.a(this.e, 35.0F));
    this.bu.setEnabled(false);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(this.e, 86.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.a(this.e, 10.0F);
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = DisplayUtil.a(this.e, 7.0F);
    this.o.addView(this.bu, (ViewGroup.LayoutParams)localObject);
    this.bu.setOnTouchListener(new GameRoomChatPie.1(this));
    this.bw = new RelativeLayout(this.e);
    this.bw.setOnTouchListener(new GameRoomChatPie.2(this));
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.e, 295.0F);
    this.bw.setBackgroundColor(this.ct);
    this.bw.setVisibility(8);
    this.o.addView(this.bw, (ViewGroup.LayoutParams)localObject);
    this.bv = new TextView(this.e);
    this.bv.setGravity(17);
    this.bv.setTextSize(18.0F);
    this.bv.setText(HardCodeUtil.a(2131903129));
    this.bv.setEnabled(true);
    this.bv.setVisibility(0);
    localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.e, 50.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.bv.setOnTouchListener(new GameRoomChatPie.3(this));
    this.bw.addView(this.bv, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.e, 245.0F));
    ((RelativeLayout.LayoutParams)localObject).topMargin = DisplayUtil.a(this.e, 50.0F);
    int i = j;
    while (i < this.o.getChildCount())
    {
      if (this.o.getChildAt(i) == this.X) {
        break label1051;
      }
      i += 1;
    }
    i = -1;
    label1051:
    if (i >= 0) {
      this.o.addView(bH(), i, (ViewGroup.LayoutParams)localObject);
    } else {
      this.o.addView(bH(), (ViewGroup.LayoutParams)localObject);
    }
    this.I.setVisibility(8);
    bL();
  }
  
  public void onNetMobile2None()
  {
    super.onNetMobile2None();
    QQToast.makeText(this.e, 1, 2131892105, 0).show();
  }
  
  public void onNetWifi2None()
  {
    super.onNetWifi2None();
    QQToast.makeText(this.e, 1, 2131892105, 0).show();
  }
  
  public void p(boolean paramBoolean)
  {
    this.bu.setEnabled(paramBoolean);
    Object localObject;
    if (!paramBoolean)
    {
      aQ();
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).stopSpeak();
      this.bu.setEnabled(false);
      this.bs.setEnabled(false);
      this.bt.setEnabled(false);
      this.Y.setEnabled(false);
      WerewolvesPluginInterface localWerewolvesPluginInterface = this.bC.c();
      localObject = this.bF;
      if (localObject == null)
      {
        this.bF = new View(this.e);
        if (this.X.getMeasuredWidth() != 0) {
          localObject = new RelativeLayout.LayoutParams(this.X.getMeasuredWidth(), this.X.getMeasuredHeight());
        } else {
          localObject = new RelativeLayout.LayoutParams(-1, DisplayUtil.a(this.e, 50.0F));
        }
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.o.addView(this.bF, (ViewGroup.LayoutParams)localObject);
        this.bF.setBackgroundColor(Color.parseColor("#77FFFFFF"));
        if (localWerewolvesPluginInterface != null)
        {
          localObject = localWerewolvesPluginInterface.i();
          this.bF.setBackgroundColor(((Integer)((HashMap)localObject).get("bottomBarMask")).intValue());
        }
      }
      else
      {
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = this.X.getMeasuredWidth();
        ((RelativeLayout.LayoutParams)localObject).height = this.X.getMeasuredHeight();
        this.bF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.bF.setVisibility(0);
      if ((localWerewolvesPluginInterface != null) && (localWerewolvesPluginInterface.e())) {
        this.bu.setText(HardCodeUtil.a(2131903112));
      } else {
        this.bu.setText(HardCodeUtil.a(2131903069));
      }
      if (!this.bn) {
        this.bw.setVisibility(8);
      }
    }
    else
    {
      this.bu.setText(HardCodeUtil.a(2131903089));
      this.bu.setEnabled(true);
      this.bs.setEnabled(true);
      this.bt.setEnabled(true);
      this.Y.setEnabled(true);
      localObject = this.bF;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  protected void u()
  {
    this.I.setVisibility(8);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageForGrayTips)) && (!(paramObject instanceof MessageForTroopGift))) {
      return;
    }
    super.update(paramObservable, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie
 * JD-Core Version:    0.7.0.1
 */