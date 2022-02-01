package com.tencent.mobileqq.apollo.profilecard;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoViewListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData.From;
import com.tencent.mobileqq.apollo.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.cmshow.brickengine.BKUtils;
import com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import mqq.app.AppRuntime;

public class FriendCardApolloViewController
  implements Handler.Callback
{
  private boolean A;
  private IApolloResManager B;
  public WeakReferenceHandler a;
  protected ApolloBoxEnterView b;
  protected FrameGifView c;
  protected int d;
  protected int[] e;
  protected float f;
  boolean g;
  public boolean h;
  public int i;
  public ApolloBaseInfo j;
  protected int k;
  private WeakReference<QBaseActivity> l;
  private WeakReference<View> m;
  private WeakReference<QQAppInterface> n;
  private ProfileCardInfo o;
  private IProfileConfig p;
  private FriendCardApolloViewController.RefreshApolloTask q;
  private ICMShowEngine r;
  private ICMShowView s;
  private String t = "";
  private FriendCardApolloViewController.ExploreInfoObserver u;
  private SpriteDrawerInfoManager v;
  private ApolloDrawerInfoViewListener w;
  private FriendCardApolloViewController.DrawerInfoCallback x;
  private boolean y = false;
  private boolean z = false;
  
  public FriendCardApolloViewController(QBaseActivity paramQBaseActivity, View paramView, ProfileCardInfo paramProfileCardInfo, IProfileConfig paramIProfileConfig)
  {
    this.l = new WeakReference(paramQBaseActivity);
    this.m = new WeakReference(paramView);
    this.n = new WeakReference((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.o = paramProfileCardInfo;
    this.p = paramIProfileConfig;
    this.a = new WeakReferenceHandler(paramQBaseActivity.getMainLooper(), this);
    this.q = new FriendCardApolloViewController.RefreshApolloTask(paramQBaseActivity, this, paramProfileCardInfo);
    this.B = ApolloResManagerFacade.a.a(Scene.FRIEND_CARD);
    if (paramView.getParent() != null) {
      paramQBaseActivity = paramView.getParent().getParent();
    } else {
      paramQBaseActivity = null;
    }
    if ((paramQBaseActivity != null) && ((paramQBaseActivity instanceof ViewGroup)))
    {
      paramView = Arrays.asList(new Scene[] { Scene.FRIEND_CARD, Scene.MEME_PLAYER });
      CEEngineHelper.a.a(paramView, (ViewGroup)paramQBaseActivity);
    }
  }
  
  private String a(ApolloManagerServiceImpl paramApolloManagerServiceImpl, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramApolloManagerServiceImpl.getLastTabUrl(2, paramApolloManagerServiceImpl.mLastShopTab);
    }
    return paramApolloManagerServiceImpl.getGuestUrl(paramString, this.y);
  }
  
  private String a(ProfileCardInfo paramProfileCardInfo)
  {
    String str1;
    if (paramProfileCardInfo.allInOne != null) {
      str1 = paramProfileCardInfo.allInOne.uin;
    } else {
      str1 = null;
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
    {
      str2 = str1;
      if (paramProfileCardInfo.card != null) {
        str2 = paramProfileCardInfo.card.uin;
      }
    }
    return str2;
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null))
    {
      if (paramProfileCardInfo.allInOne.pa == 0)
      {
        if (paramInt == 0) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
      }
      else if (paramInt == 0) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
    else {
      paramInt = 5;
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800999C", "0X800999C", paramInt, 0, "", "", "", "");
  }
  
  private void a(int paramInt, String paramString1, QQAppInterface paramQQAppInterface, ApolloManagerServiceImpl paramApolloManagerServiceImpl, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString1.contains("pet")))
    {
      boolean bool = paramString2.equals(paramQQAppInterface.getCurrentUin());
      paramQQAppInterface = paramApolloManagerServiceImpl.getPetId(paramString2);
      if (paramInt == 0) {
        paramString1 = "0";
      } else {
        paramString1 = "1";
      }
      VipUtils.a(null, "cmshow", "Apollo", "datapetclick", 0, bool ^ true, new String[] { paramQQAppInterface, paramString1 });
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, ApolloActionData paramApolloActionData, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(QQAppInterface paramQQAppInterface, ApolloManagerServiceImpl paramApolloManagerServiceImpl, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ApolloManagerServiceImpl paramApolloManagerServiceImpl, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(QQAppInterface paramQQAppInterface, QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo, ApolloManagerServiceImpl paramApolloManagerServiceImpl, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(String paramString)
  {
    QLog.d("[cmshow]FriendCardApolloViewController", 1, "removeFeelingBubble");
    SpriteDrawerInfoManager localSpriteDrawerInfoManager = this.v;
    if (localSpriteDrawerInfoManager == null)
    {
      QLog.e("[cmshow]FriendCardApolloViewController", 1, "mSpriteDrawerInfoManager is null");
      return;
    }
    SpriteUtil.a(paramString, localSpriteDrawerInfoManager.e());
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]FriendCardApolloViewController", 1, "showFeelingBubble");
    SpriteUtil.a(this.v.a(), this.v.e(), paramString, 9, paramInt1, paramInt2);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i1;
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(c().getAccount()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    ApolloDtReportUtil.a("friend_card", "sprite", paramString2, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(c())).d(i1).c(paramString1).a());
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject = localIApolloDaoManagerService.getApolloBaseInfo(paramString);
    if (localObject != null)
    {
      if (((ApolloBaseInfo)localObject).apolloCmQQStatusData == null) {
        return false;
      }
      ApolloCmQQStatusData localApolloCmQQStatusData = ((ApolloBaseInfo)localObject).apolloCmQQStatusData;
      ApolloActionData localApolloActionData = localIApolloDaoManagerService.findActionInCache(localApolloCmQQStatusData.apolloQQAct);
      localObject = localApolloActionData;
      if (localApolloActionData == null) {
        localObject = localIApolloDaoManagerService.findActionById(localApolloCmQQStatusData.apolloQQAct);
      }
      if (localObject == null)
      {
        QLog.e("[cmshow]FriendCardApolloViewController", 1, "actionData is empty!");
        return false;
      }
      if (!localApolloCmQQStatusData.shouldShowQQCmshowStatusAction(ApolloCmQQStatusData.From.CARD))
      {
        QLog.i("[cmshow]FriendCardApolloViewController", 1, "action show data/ts/freq is invalid");
        return false;
      }
      long l1 = System.currentTimeMillis();
      SpriteUtil.a(this.v, 12, (ApolloActionData)localObject);
      localApolloCmQQStatusData.showUpFreqDecrement(ApolloCmQQStatusData.From.CARD);
      localApolloCmQQStatusData.printFreqRemaining();
      a(paramQQAppInterface, l1, (ApolloActionData)localObject, paramString);
      return true;
    }
    return false;
  }
  
  private ApolloCmQQStatusData b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.v.a();
    if (localQQAppInterface == null) {
      return null;
    }
    paramString = ((IApolloDaoManagerService)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.apolloCmQQStatusData;
  }
  
  private IApolloResManager h()
  {
    return this.B;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QQAppInterface localQQAppInterface = c();
    QBaseActivity localQBaseActivity = (QBaseActivity)this.l.get();
    Object localObject = this.o;
    if ((localQBaseActivity != null) && (localQQAppInterface != null))
    {
      if (localObject == null) {
        return;
      }
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      String str = a((ProfileCardInfo)localObject);
      a(paramInt1, paramString, localQQAppInterface, localApolloManagerServiceImpl, str);
      if (paramInt1 == 0)
      {
        b(true);
        a(localQQAppInterface, localApolloManagerServiceImpl, str);
        if (b(str) != null) {
          a(str);
        }
        paramString = (String)localObject;
      }
      else
      {
        if (paramInt2 == 1) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", str });
        }
        paramString = localApolloManagerServiceImpl;
        boolean bool;
        if ((((ProfileCardInfo)localObject).card != null) && (localQQAppInterface.getCurrentUin().equals(((ProfileCardInfo)localObject).card.uin))) {
          bool = true;
        } else {
          bool = false;
        }
        if ((!this.g) && ((((ProfileCardInfo)localObject).allInOne == null) || (((ProfileCardInfo)localObject).allInOne.pa != 0)) && (!bool)) {
          a(localQQAppInterface, localQBaseActivity, (ProfileCardInfo)localObject, paramString, str);
        } else {
          a(localQQAppInterface, localQBaseActivity, paramString, str, bool);
        }
        paramString = (String)localObject;
        a(str, "sprite_open");
      }
      localObject = this.b;
      if ((localObject != null) && (((ApolloBoxEnterView)localObject).getVisibility() == 0) && (paramInt1 == 1)) {
        this.b.setVisibility(8);
      }
      localObject = this.c;
      if ((localObject != null) && (((FrameGifView)localObject).getVisibility() == 0) && (paramInt1 == 1)) {
        this.c.setVisibility(8);
      }
      a(paramInt1, localQQAppInterface, paramString);
    }
  }
  
  void a(CheckApolloInfoResult paramCheckApolloInfoResult)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public boolean a()
  {
    return this.A;
  }
  
  public void b()
  {
    Object localObject = this.o;
    TroopManager localTroopManager = (TroopManager)c().getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localObject != null) && (((ProfileCardInfo)localObject).isTroopMemberCard) && (localTroopManager.Z(((ProfileCardInfo)localObject).troopUin))) {
      return;
    }
    if ((localObject != null) && (((ProfileCardInfo)localObject).allInOne != null) && (((ProfileCardInfo)localObject).allInOne.pa == 53)) {
      return;
    }
    localObject = this.l;
    if (localObject != null) {
      localObject = (QBaseActivity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((this.a != null) && (c() != null) && (localObject != null) && ((this.m.get() instanceof FrameLayout)) && (((IApolloManagerService)c().getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport((Context)localObject, Boolean.valueOf(false))) && (!this.z))
    {
      if (!this.p.isSwitchEnable(1)) {
        return;
      }
      this.z = true;
      int i1 = TraceReportUtil.c(2);
      TraceReportUtil.a(i1);
      TraceReportUtil.a(i1, 1);
      TraceReportUtil.a(i1, 10);
      ThreadManager.removeJobFromThreadPool(this.q, 16);
      ThreadManager.excute(this.q, 16, null, true);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject2 = null;
    Object localObject3 = this.o;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((ProfileCardInfo)localObject3).allInOne != null) {
        localObject1 = ((ProfileCardInfo)localObject3).allInOne.uin;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((ProfileCardInfo)localObject3).card != null) {
          localObject2 = ((ProfileCardInfo)localObject3).card.uin;
        }
      }
    }
    localObject1 = c();
    localObject3 = this.b;
    if ((localObject3 != null) && (localObject1 != null)) {
      ((ApolloBoxEnterView)localObject3).a((QQAppInterface)localObject1, "friendcard", (String)localObject2, -1);
    }
  }
  
  public QQAppInterface c()
  {
    WeakReference localWeakReference = this.n;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (QQAppInterface)this.n.get();
    }
    return null;
  }
  
  public void d()
  {
    Object localObject = this.v;
    if (localObject != null) {
      ((SpriteDrawerInfoManager)localObject).d();
    }
    localObject = this.b;
    if (localObject != null) {
      ((ApolloBoxEnterView)localObject).setVisibility(8);
    }
    localObject = this.r;
    if (localObject != null) {
      ((ICMShowEngine)localObject).k();
    }
    localObject = this.s;
    if (localObject != null) {
      ((ICMShowView)localObject).resume();
    }
  }
  
  public void e()
  {
    Object localObject = this.v;
    if (localObject != null) {
      ((SpriteDrawerInfoManager)localObject).c();
    }
    localObject = this.s;
    if (localObject != null) {
      ((ICMShowView)localObject).pause();
    }
    localObject = this.r;
    if (localObject != null) {
      ((ICMShowEngine)localObject).l();
    }
    this.z = false;
  }
  
  public void f()
  {
    ApolloBoxEnterView localApolloBoxEnterView = this.b;
    if (localApolloBoxEnterView != null) {
      localApolloBoxEnterView.d();
    }
  }
  
  public void g()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      ((WeakReferenceHandler)localObject1).removeCallbacksAndMessages(null);
      this.a.removeMessages(0);
    }
    localObject1 = c();
    if (localObject1 != null)
    {
      Object localObject2 = this.u;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.u = null;
      }
      localObject2 = this.w;
      if (localObject2 != null) {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
      }
    }
    localObject1 = this.v;
    if (localObject1 != null) {
      ((SpriteDrawerInfoManager)localObject1).h();
    }
    localObject1 = this.s;
    if (localObject1 != null)
    {
      BKUtils.a(((ICMShowView)localObject1).getView());
      this.s = null;
    }
    localObject1 = this.r;
    if (localObject1 != null)
    {
      ((ICMShowEngine)localObject1).m();
      this.r = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && ((paramMessage.obj instanceof CheckApolloInfoResult))) {
      a((CheckApolloInfoResult)paramMessage.obj);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */