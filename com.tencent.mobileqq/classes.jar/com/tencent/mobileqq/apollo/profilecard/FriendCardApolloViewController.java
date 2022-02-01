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
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener;
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
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class FriendCardApolloViewController
  implements Handler.Callback
{
  protected float a;
  protected int a;
  public ApolloBaseInfo a;
  private FriendCardApolloViewController.DrawerInfoCallback jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback;
  private FriendCardApolloViewController.ExploreInfoObserver jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$ExploreInfoObserver;
  private FriendCardApolloViewController.RefreshApolloTask jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$RefreshApolloTask;
  private SpriteDrawerInfoManager jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoManager;
  protected ApolloBoxEnterView a;
  private ApolloDrawerInfoViewListener jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener;
  protected FrameGifView a;
  private ICMShowEngine jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
  private ICMShowView jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
  private IProfileConfig jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigIProfileConfig;
  private ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo;
  public WeakReferenceHandler a;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<QBaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  protected int[] a;
  public int b;
  private WeakReference<View> b;
  public boolean b;
  protected int c;
  private WeakReference<QQAppInterface> jdField_c_of_type_JavaLangRefWeakReference;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  private boolean e;
  
  public FriendCardApolloViewController(QBaseActivity paramQBaseActivity, View paramView, ProfileCardInfo paramProfileCardInfo, IProfileConfig paramIProfileConfig)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQBaseActivity);
    this.b = new WeakReference(paramView);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference((QQAppInterface)paramQBaseActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigIProfileConfig = paramIProfileConfig;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(paramQBaseActivity.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$RefreshApolloTask = new FriendCardApolloViewController.RefreshApolloTask(paramQBaseActivity, this, paramProfileCardInfo);
    if (paramView.getParent() != null) {
      paramQBaseActivity = paramView.getParent().getParent();
    } else {
      paramQBaseActivity = null;
    }
    if ((paramQBaseActivity != null) && ((paramQBaseActivity instanceof ViewGroup))) {
      CEEngineHelper.a.a(Scene.FRIEND_CARD, (ViewGroup)paramQBaseActivity);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i;
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(a().getAccount()))) {
      i = 1;
    } else {
      i = 0;
    }
    ApolloDtReportUtil.a("friend_card", "sprite", paramString2, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(a())).d(i).b(paramString1).a());
  }
  
  public QQAppInterface a()
  {
    WeakReference localWeakReference = this.jdField_c_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (QQAppInterface)this.jdField_c_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo;
    TroopManager localTroopManager = (TroopManager)a().getManager(QQManagerFactory.TROOP_MANAGER);
    if ((localObject != null) && (((ProfileCardInfo)localObject).isTroopMemberCard) && (localTroopManager.m(((ProfileCardInfo)localObject).troopUin))) {
      return;
    }
    if ((localObject != null) && (((ProfileCardInfo)localObject).allInOne != null) && (((ProfileCardInfo)localObject).allInOne.pa == 53)) {
      return;
    }
    localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (QBaseActivity)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (a() != null) && (localObject != null) && ((this.b.get() instanceof FrameLayout)) && (((IApolloManagerService)a().getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport((Context)localObject, Boolean.valueOf(false))) && (!this.d))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseConfigIProfileConfig.isSwitchEnable(1)) {
        return;
      }
      this.d = true;
      int i = TraceReportUtil.a(2);
      TraceReportUtil.a(i);
      TraceReportUtil.a(i, 1);
      TraceReportUtil.a(i, 10);
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$RefreshApolloTask, 16);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$RefreshApolloTask, 16, null, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  void a(CheckApolloInfoResult paramCheckApolloInfoResult)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoManager;
    if (localObject != null) {
      ((SpriteDrawerInfoManager)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView;
    if (localObject != null) {
      ((ApolloBoxEnterView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (localObject != null) {
      ((ICMShowEngine)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localObject != null) {
      ((ICMShowView)localObject).resume();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Object localObject2 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo;
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
    localObject1 = a();
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView;
    if ((localObject3 != null) && (localObject1 != null)) {
      ((ApolloBoxEnterView)localObject3).a((QQAppInterface)localObject1, "friendcard", (String)localObject2, -1);
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoManager;
    if (localObject != null) {
      ((SpriteDrawerInfoManager)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localObject != null) {
      ((ICMShowView)localObject).pause();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (localObject != null) {
      ((ICMShowEngine)localObject).b();
    }
    this.d = false;
  }
  
  public void d()
  {
    ApolloBoxEnterView localApolloBoxEnterView = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView;
    if (localApolloBoxEnterView != null) {
      localApolloBoxEnterView.c();
    }
  }
  
  public void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
    if (localObject1 != null)
    {
      ((WeakReferenceHandler)localObject1).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    }
    localObject1 = a();
    if (localObject1 != null)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$ExploreInfoObserver;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$ExploreInfoObserver = null;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener;
      if (localObject2 != null) {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerinfoSpriteDrawerInfoManager;
    if (localObject1 != null) {
      ((SpriteDrawerInfoManager)localObject1).d();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView;
    if (localObject1 != null)
    {
      BKUtils.a(((ICMShowView)localObject1).getView());
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderICMShowView = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine;
    if (localObject1 != null)
    {
      ((ICMShowEngine)localObject1).c();
      this.jdField_a_of_type_ComTencentMobileqqCmshowEngineICMShowEngine = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */