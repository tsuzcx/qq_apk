package com.tencent.mobileqq.apollo;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class FriendCardApolloViewController
  implements Handler.Callback
{
  protected float a;
  protected int a;
  protected ApolloTextureView a;
  private FriendCardApolloViewController.DrawerInfoCallback jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$DrawerInfoCallback;
  private FriendCardApolloViewController.ExploreInfoObserver jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$ExploreInfoObserver;
  private FriendCardApolloViewController.RefreshApolloTask jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask;
  public ApolloBaseInfo a;
  private SpriteDrawerInfoManager jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager;
  protected ApolloBoxEnterView a;
  private ApolloDrawerInfoViewListener jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener;
  protected FrameGifView a;
  public WeakReferenceHandler a;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<FriendProfileCardActivity> jdField_a_of_type_JavaLangRefWeakReference;
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
  
  public FriendCardApolloViewController(FriendProfileCardActivity paramFriendProfileCardActivity, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity.app);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(paramFriendProfileCardActivity.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask = new FriendCardApolloViewController.RefreshApolloTask(paramFriendProfileCardActivity, this);
  }
  
  private void a(String paramString1, String paramString2)
  {
    int j = 1;
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(a().getAccount()))) {}
    for (int i = 1;; i = 0)
    {
      ApolloDtReportUtil.DtReportParamsBuilder localDtReportParamsBuilder = new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(a()));
      if (i != 0) {}
      for (i = j;; i = 0)
      {
        ApolloDtReportUtil.a("friend_card", "sprite", paramString2, localDtReportParamsBuilder.d(i).b(paramString1).a());
        return;
      }
    }
  }
  
  public QQAppInterface a()
  {
    if ((this.jdField_c_of_type_JavaLangRefWeakReference == null) || (this.jdField_c_of_type_JavaLangRefWeakReference.get() == null)) {
      return null;
    }
    return (QQAppInterface)this.jdField_c_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {}
    }
    for (Object localObject = ((FriendProfileCardActivity)localObject).jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;; localObject = null)
    {
      TroopManager localTroopManager = (TroopManager)a().getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject != null) && (((ProfileCardInfo)localObject).jdField_b_of_type_Boolean) && (localTroopManager.n(((ProfileCardInfo)localObject).jdField_a_of_type_JavaLangString))) {}
      for (;;)
      {
        return;
        if ((localObject == null) || (((ProfileCardInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (((ProfileCardInfo)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53))
        {
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
          for (localObject = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(); (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (a() != null) && (localObject != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FrameLayout)) && (((IApolloManagerService)a().getRuntimeService(IApolloManagerService.class, "all")).isApolloFuncOpen((Context)localObject, Boolean.valueOf(false))) && (!this.d) && (((FriendProfileCardActivity)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProfileConfigHelper.a(1)); localObject = null)
          {
            this.d = true;
            int i = SpriteUtil.b(2);
            TraceReportUtil.a(i);
            TraceReportUtil.a(i, 1);
            TraceReportUtil.a(i, 10);
            ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16);
            ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16, null, true);
            return;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localFriendProfileCardActivity == null) || (localQQAppInterface == null) || (localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null)) {
      return;
    }
    ProfileCardInfo localProfileCardInfo = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
    Object localObject2 = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
    label534:
    label1305:
    for (String str = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; str = null)
    {
      if ((TextUtils.isEmpty(str)) && (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        str = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      label158:
      label1054:
      label1310:
      for (;;)
      {
        Object localObject1;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)) && (paramString.contains("pet")))
        {
          if (str.equals(localQQAppInterface.getCurrentUin()))
          {
            i = 0;
            localObject1 = ((ApolloManagerServiceImpl)localObject2).getPetId(str);
            if (paramInt1 != 0) {
              break label437;
            }
            paramString = "0";
            VipUtils.a(null, "cmshow", "Apollo", "datapetclick", 0, i, new String[] { localObject1, paramString });
          }
        }
        else
        {
          if (paramInt1 != 0) {
            break label534;
          }
          b(true);
          if ((TextUtils.isEmpty(str)) || (!str.equals(localQQAppInterface.getCurrentUin()))) {
            break label449;
          }
          if (!this.jdField_c_of_type_Boolean) {
            break label444;
          }
        }
        label437:
        label444:
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_jump", 0, paramInt2, new String[0]);
          a(str, "sprite_jump");
          paramString = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView;
          if ((this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (paramString != null) && (((paramString instanceof VasProfileTagView)) || ((paramString instanceof VasProfileSimpleView)))) {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new FriendCardApolloViewController.2(this, paramString), 500L);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
          }
          i = 5;
          paramInt2 = i;
          if (localProfileCardInfo != null)
          {
            paramInt2 = i;
            if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
            {
              if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break label1504;
              }
              if (paramInt1 != 0) {
                break label1499;
              }
              paramInt2 = 1;
            }
          }
          ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800999C", "0X800999C", paramInt2, 0, "", "", "", "");
          return;
          i = 1;
          break;
          paramString = "1";
          break label158;
        }
        label449:
        int i = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_jump", i, paramInt2, new String[] { "" + ((ApolloManagerServiceImpl)localObject2).getWhiteListStatus(localQQAppInterface), "0", "0", str });
          break;
        }
        if (paramInt2 == 1) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", str });
        }
        if ((localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localQQAppInterface.getCurrentUin().equals(localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
        {
          paramInt2 = 1;
          label606:
          if ((!this.jdField_a_of_type_Boolean) && ((localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) && (paramInt2 == 0)) {
            break label1067;
          }
          if (paramInt2 == 0) {
            break label913;
          }
          paramString = ((ApolloManagerServiceImpl)localObject2).getLastTabUrl(2, ((ApolloManagerServiceImpl)localObject2).mLastShopTab);
          this.e = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_box_uin", str);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)
          {
            ((Intent)localObject1).putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
              ((Intent)localObject1).putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
            }
          }
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str);
          ((Intent)localObject1).putExtra("extra_key_box_from", "friendcard");
          if ((TextUtils.isEmpty(str)) || (!str.equals(localQQAppInterface.getCurrentUin()))) {
            break label933;
          }
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(localFriendProfileCardActivity, (Intent)localObject1, "mineprofile", paramString, null);
          if (!this.jdField_c_of_type_Boolean) {
            break label928;
          }
          paramInt2 = 1;
          label828:
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_clk", 0, paramInt2, new String[0]);
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)) {
            if (!this.jdField_b_of_type_Boolean) {
              break label1061;
            }
          }
        }
        label928:
        label933:
        label1061:
        for (paramString = "1";; paramString = "0")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 1, 0, new String[] { paramString });
          a(str, "sprite_open");
          break;
          paramInt2 = 0;
          break label606;
          paramString = ((ApolloManagerServiceImpl)localObject2).getGuestUrl(str, this.jdField_c_of_type_Boolean);
          break label652;
          paramInt2 = 0;
          break label828;
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            label971:
            localObject1 = "" + ((ApolloManagerServiceImpl)localObject2).getWhiteListStatus(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1054;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str });
            break;
            paramInt2 = 0;
            break label971;
          }
        }
        label1067:
        Intent localIntent;
        if (!this.jdField_c_of_type_Boolean)
        {
          localIntent = new Intent(localFriendProfileCardActivity, ApolloGuestsStateActivity.class);
          localObject1 = null;
          paramString = (String)localObject1;
          if (localProfileCardInfo != null)
          {
            paramString = (String)localObject1;
            if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
              paramString = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            }
          }
          if ((!TextUtils.isEmpty(paramString)) || (localProfileCardInfo == null) || (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
            break label1518;
          }
          paramString = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
        }
        label1182:
        label1492:
        label1499:
        label1504:
        label1518:
        for (;;)
        {
          if (!TextUtils.isEmpty(str))
          {
            localIntent.putExtra("extra_guest_uin", str);
            i = this.jdField_c_of_type_Int;
            if (!this.jdField_c_of_type_Boolean) {
              break label1305;
            }
            paramInt2 = 1;
            localObject2 = "" + ((ApolloManagerServiceImpl)localObject2).getWhiteListStatus(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1310;
            }
          }
          for (localObject1 = "0";; localObject1 = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject2, localObject1, "0", str });
            if (!TextUtils.isEmpty(paramString)) {
              localIntent.putExtra("extra_guest_nick", paramString);
            }
            localIntent.putExtra("extra_guest_from", 3);
            localFriendProfileCardActivity.startActivity(localIntent);
            localFriendProfileCardActivity.overridePendingTransition(2130772043, 0);
            break;
            paramInt2 = 0;
            break label1182;
          }
          paramString = ((ApolloManagerServiceImpl)localObject2).getGuestUrl(str, true);
          this.e = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str);
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            localObject1 = "" + ((ApolloManagerServiceImpl)localObject2).getWhiteListStatus(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1492;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str });
            break;
            paramInt2 = 0;
            break label1409;
          }
          paramInt2 = 2;
          break;
          if (paramInt1 == 0)
          {
            paramInt2 = 3;
            break;
          }
          paramInt2 = 4;
          break;
        }
      }
    }
  }
  
  void a(CheckApolloInfoResult paramCheckApolloInfoResult)
  {
    Object localObject3 = (View)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramCheckApolloInfoResult == null) || (localQQAppInterface == null) || (localObject3 == null) || (localFriendProfileCardActivity == null) || (!(localObject3 instanceof FrameLayout))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendCardApolloViewController", 2, "roleId->" + paramCheckApolloInfoResult.jdField_a_of_type_Int + " apolloStatus->" + this.jdField_b_of_type_Int + " needStatic->" + paramCheckApolloInfoResult.jdField_a_of_type_Boolean);
      }
    } while (paramCheckApolloInfoResult.jdField_a_of_type_Boolean);
    Object localObject2 = null;
    ProfileCardInfo localProfileCardInfo = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
    Object localObject1 = localObject2;
    if (localProfileCardInfo != null)
    {
      localObject1 = localObject2;
      if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localProfileCardInfo != null) && (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject1 = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      boolean bool;
      label210:
      int i;
      int j;
      if (paramCheckApolloInfoResult.d == 2)
      {
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        long l = Math.max(DeviceInfoUtil.h(), DeviceInfoUtil.g());
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          break label1021;
        }
        TraceReportUtil.a(paramCheckApolloInfoResult.e, 10, 0, new Object[] { "switch done" });
        TraceReportUtil.a(paramCheckApolloInfoResult.e, 100);
        float f = (float)DeviceInfoUtil.i() / DeviceInfoUtil.a();
        i = (int)(0.4D * l);
        j = ApolloDrawerInfoManager.a(i, DeviceInfoUtil.i());
        this.jdField_a_of_type_Float = (j / DeviceInfoUtil.a() - f * 204.0F / 1080.0F);
        f = FontSettingManager.getFontLevel() / 16.0F;
        if (f != 0.0F) {
          this.jdField_a_of_type_Float = (f * this.jdField_a_of_type_Float);
        }
        f = (float)l * 0.2F / 368.0F;
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager = new SpriteDrawerInfoManager(localQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(f, this.jdField_a_of_type_Float, 0.0F);
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener = new ApolloDrawerInfoViewListener(this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager, 2);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localFriendProfileCardActivity, null);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a((String)localObject1);
          ThreadManager.post(new FriendCardApolloViewController.1(this), 10, null, true);
          this.jdField_a_of_type_Int = paramCheckApolloInfoResult.jdField_a_of_type_Int;
          this.jdField_a_of_type_ArrayOfInt = paramCheckApolloInfoResult.jdField_a_of_type_ArrayOfInt;
          paramCheckApolloInfoResult = (RelativeLayout)((View)localObject3).getParent().getParent();
          localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localQQAppInterface.getCurrentUin())))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$ExploreInfoObserver == null) {
              this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$ExploreInfoObserver = new FriendCardApolloViewController.ExploreInfoObserver(this);
            }
            localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$ExploreInfoObserver);
            ((ApolloExtensionHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).c(2);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
          this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$DrawerInfoCallback = new FriendCardApolloViewController.DrawerInfoCallback(this, null);
          this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.a(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$DrawerInfoCallback);
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(56.0F, localFriendProfileCardActivity.getResources());
          paramCheckApolloInfoResult.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject2);
          localObject2 = (IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          if (localObject1 != null)
          {
            if (!((String)localObject1).equals(localQQAppInterface.getCurrentUin())) {
              break label906;
            }
            if (!this.jdField_c_of_type_Boolean) {
              break label901;
            }
            i = 1;
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_show", 0, i, new String[0]);
          }
          if ((this.jdField_a_of_type_Boolean) && (((IApolloManagerService)localObject2).getCmShowStatus(localQQAppInterface, (String)localObject1) == 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(localFriendProfileCardActivity, null);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(45.0F, localFriendProfileCardActivity.getResources()), AIOUtils.a(45.0F, localFriendProfileCardActivity.getResources()));
            ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(45.0F, localFriendProfileCardActivity.getResources());
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.a(75.0F, localFriendProfileCardActivity.getResources());
            paramCheckApolloInfoResult.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject1);
            b(false);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$DrawerInfoCallback);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          return;
        }
        catch (Throwable paramCheckApolloInfoResult)
        {
          QLog.e("FriendCardApolloViewController", 1, paramCheckApolloInfoResult, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
          return;
        }
        bool = false;
        break label210;
        label901:
        i = 0;
        continue;
        label906:
        localObject3 = ((IApolloManagerService)localObject2).getApolloBaseInfo(localQQAppInterface.getCurrentUin());
        if (localObject3 != null) {
          this.jdField_c_of_type_Int = ((ApolloBaseInfo)localObject3).apolloStatus;
        }
        j = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (i = 1;; i = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_show", j, i, new String[] { "" + ((IApolloManagerService)localObject2).getWhiteListStatus(localQQAppInterface), "0", "0", localObject1 });
          break;
        }
        label1021:
        TraceReportUtil.a(paramCheckApolloInfoResult.e, 10, 107, new Object[0]);
      }
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1 = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    ProfileCardInfo localProfileCardInfo = ((FriendProfileCardActivity)localObject1).jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
    if ((localProfileCardInfo != null) && (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject1 = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (localProfileCardInfo != null)
        {
          localObject2 = localObject1;
          if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            localObject2 = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
          }
        }
      }
      localObject1 = a();
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (localObject1 == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a((QQAppInterface)localObject1, "friendcard", (String)localObject2, -1);
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.b();
    }
    this.d = false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.c();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$ExploreInfoObserver != null)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$ExploreInfoObserver);
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$ExploreInfoObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloDrawerInfoViewListener);
      }
    }
    com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl.isCardPetLoaded = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptDrawerInfoSpriteDrawerInfoManager.d();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj instanceof CheckApolloInfoResult)) {
        a((CheckApolloInfoResult)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */