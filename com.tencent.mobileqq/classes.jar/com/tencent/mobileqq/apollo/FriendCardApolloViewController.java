package com.tencent.mobileqq.apollo;

import amme;
import ammu;
import ampf;
import ampg;
import amse;
import anck;
import anct;
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
import anis;
import anmz;
import azrb;
import bdla;
import birs;
import bkys;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FriendCardApolloViewController
  implements Handler.Callback
{
  protected float a;
  protected int a;
  private ampf jdField_a_of_type_Ampf;
  private ampg jdField_a_of_type_Ampg;
  private anct jdField_a_of_type_Anct;
  private anmz jdField_a_of_type_Anmz;
  public bkys a;
  protected ApolloTextureView a;
  private FriendCardApolloViewController.RefreshApolloTask jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask;
  public ApolloBoxEnterView a;
  protected FrameGifView a;
  public ApolloBaseInfo a;
  private String jdField_a_of_type_JavaLangString = "";
  private WeakReference<FriendProfileCardActivity> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean;
  protected int[] a;
  public int b;
  private WeakReference<View> b;
  public boolean b;
  protected int c;
  private WeakReference<QQAppInterface> jdField_c_of_type_JavaLangRefWeakReference;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public FriendCardApolloViewController(FriendProfileCardActivity paramFriendProfileCardActivity, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity.app);
    this.jdField_a_of_type_Bkys = new bkys(paramFriendProfileCardActivity.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask = new FriendCardApolloViewController.RefreshApolloTask(paramFriendProfileCardActivity, this);
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
    for (Object localObject = ((FriendProfileCardActivity)localObject).jdField_a_of_type_Azrb;; localObject = null)
    {
      if ((localObject != null) && (((azrb)localObject).jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(a(), ((azrb)localObject).jdField_a_of_type_JavaLangString))) {}
      for (;;)
      {
        return;
        if ((localObject == null) || (((azrb)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (((azrb)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53))
        {
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
          for (localObject = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(); (this.jdField_a_of_type_Bkys != null) && (a() != null) && (localObject != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FrameLayout)) && (amme.a((Context)localObject, Boolean.valueOf(false))) && (!this.d) && (((FriendProfileCardActivity)localObject).jdField_a_of_type_Birs.a(1)); localObject = null)
          {
            this.d = true;
            int i = anck.b(2);
            anis.a(i);
            anis.a(i, 1);
            anis.a(i, 10);
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
    if ((localFriendProfileCardActivity == null) || (localQQAppInterface == null) || (localFriendProfileCardActivity.jdField_a_of_type_Azrb == null)) {
      return;
    }
    azrb localazrb = localFriendProfileCardActivity.jdField_a_of_type_Azrb;
    Object localObject1 = (amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
    for (String str1 = localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; str1 = null)
    {
      if ((TextUtils.isEmpty(str1)) && (localazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        str1 = localazrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        Object localObject2;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (paramString.contains("pet")))
        {
          paramString = (amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER);
          if (str1.equals(localQQAppInterface.getCurrentUin()))
          {
            i = 0;
            localObject2 = paramString.a(str1);
            if (paramInt1 != 0) {
              break label437;
            }
            paramString = "0";
            label168:
            VipUtils.a(null, "cmshow", "Apollo", "datapetclick", 0, i, new String[] { localObject2, paramString });
          }
        }
        else
        {
          if (paramInt1 != 0) {
            break label532;
          }
          b(true);
          if ((TextUtils.isEmpty(str1)) || (!str1.equals(localQQAppInterface.getCurrentUin()))) {
            break label449;
          }
          if (!this.jdField_c_of_type_Boolean) {
            break label444;
          }
        }
        label402:
        label437:
        label444:
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_jump", 0, paramInt2, new String[0]);
          paramString = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView;
          if ((this.jdField_a_of_type_Bkys != null) && (paramString != null) && (((paramString instanceof VasProfileTagView)) || ((paramString instanceof VasProfileSimpleView)))) {
            this.jdField_a_of_type_Bkys.postDelayed(new FriendCardApolloViewController.2(this, paramString), 500L);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
          }
          i = 5;
          paramInt2 = i;
          if (localazrb != null)
          {
            paramInt2 = i;
            if (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
            {
              if (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break label1454;
              }
              if (paramInt1 != 0) {
                break label1449;
              }
              paramInt2 = 1;
            }
          }
          bdla.b(localQQAppInterface, "dc00898", "", "", "0X800999C", "0X800999C", paramInt2, 0, "", "", "", "");
          return;
          i = 1;
          break;
          paramString = "1";
          break label168;
        }
        label449:
        int i = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_jump", i, paramInt2, new String[] { "" + amme.a(localQQAppInterface), "0", "0", str1 });
          break;
        }
        label532:
        if (paramInt2 == 1) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", str1 });
        }
        if ((localazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localQQAppInterface.getCurrentUin().equals(localazrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
        {
          paramInt2 = 1;
          label604:
          if ((!this.jdField_a_of_type_Boolean) && ((localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) && (paramInt2 == 0)) {
            break label1032;
          }
          if (paramInt2 == 0) {
            break label891;
          }
          paramString = ((amme)localObject1).a(2, ((amme)localObject1).g);
          label650:
          this.e = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_box_uin", str1);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null)
          {
            ((Intent)localObject1).putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
              ((Intent)localObject1).putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
            }
          }
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
          ((Intent)localObject1).putExtra("extra_key_box_from", "friendcard");
          if ((TextUtils.isEmpty(str1)) || (!str1.equals(localQQAppInterface.getCurrentUin()))) {
            break label911;
          }
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "mineprofile", paramString, null);
          if (!this.jdField_c_of_type_Boolean) {
            break label906;
          }
          paramInt2 = 1;
          label815:
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_clk", 0, paramInt2, new String[0]);
          label833:
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0)) {
            break label1012;
          }
          if (!this.jdField_b_of_type_Boolean) {
            break label1026;
          }
        }
        label1026:
        for (paramString = "1";; paramString = "0")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 1, 0, new String[] { paramString });
          break;
          paramInt2 = 0;
          break label604;
          label891:
          paramString = ((amme)localObject1).a(str1, this.jdField_c_of_type_Boolean);
          break label650;
          label906:
          paramInt2 = 0;
          break label815;
          label911:
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            label938:
            localObject1 = "" + amme.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1019;
            }
          }
          label1012:
          label1019:
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break label833;
            break;
            paramInt2 = 0;
            break label938;
          }
        }
        label1032:
        if (!this.jdField_c_of_type_Boolean)
        {
          localObject2 = new Intent(localFriendProfileCardActivity, ApolloGuestsStateActivity.class);
          localObject1 = null;
          paramString = (String)localObject1;
          if (localazrb != null)
          {
            paramString = (String)localObject1;
            if (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
              paramString = localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            }
          }
          if ((!TextUtils.isEmpty(paramString)) || (localazrb == null) || (localazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
            break label1468;
          }
          paramString = localazrb.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
        }
        label1442:
        label1449:
        label1454:
        label1468:
        for (;;)
        {
          label1147:
          String str2;
          if (!TextUtils.isEmpty(str1))
          {
            ((Intent)localObject2).putExtra("extra_guest_uin", str1);
            i = this.jdField_c_of_type_Int;
            if (!this.jdField_c_of_type_Boolean) {
              break label1268;
            }
            paramInt2 = 1;
            str2 = "" + amme.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1273;
            }
          }
          label1268:
          label1273:
          for (localObject1 = "0";; localObject1 = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { str2, localObject1, "0", str1 });
            if (!TextUtils.isEmpty(paramString)) {
              ((Intent)localObject2).putExtra("extra_guest_nick", paramString);
            }
            ((Intent)localObject2).putExtra("extra_guest_from", 3);
            localFriendProfileCardActivity.startActivity((Intent)localObject2);
            localFriendProfileCardActivity.overridePendingTransition(2130772039, 0);
            break;
            paramInt2 = 0;
            break label1147;
          }
          paramString = ((amme)localObject1).a(str1, true);
          this.e = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            label1361:
            localObject1 = "" + amme.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1442;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break;
            paramInt2 = 0;
            break label1361;
          }
          paramInt2 = 2;
          break label402;
          if (paramInt1 == 0)
          {
            paramInt2 = 3;
            break label402;
          }
          paramInt2 = 4;
          break label402;
        }
      }
    }
  }
  
  void a(ammu paramammu)
  {
    View localView = (View)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramammu == null) || (localQQAppInterface == null) || (localView == null) || (localFriendProfileCardActivity == null) || (!(localView instanceof FrameLayout))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendCardApolloViewController", 2, "roleId->" + paramammu.jdField_a_of_type_Int + " apolloStatus->" + this.jdField_b_of_type_Int + " needStatic->" + paramammu.jdField_a_of_type_Boolean);
      }
    } while (paramammu.jdField_a_of_type_Boolean);
    Object localObject2 = null;
    azrb localazrb = localFriendProfileCardActivity.jdField_a_of_type_Azrb;
    Object localObject1 = localObject2;
    if (localazrb != null)
    {
      localObject1 = localObject2;
      if (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localazrb != null) && (localazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject1 = localazrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      boolean bool;
      label210:
      int i;
      int j;
      if (paramammu.d == 2)
      {
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        long l = Math.max(DeviceInfoUtil.getDispalyHeight(), DeviceInfoUtil.getDispalyWidth());
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          break label1006;
        }
        anis.a(paramammu.e, 10, 0, new Object[] { "switch done" });
        anis.a(paramammu.e, 100);
        float f = (float)DeviceInfoUtil.getPortraitWidth() / DeviceInfoUtil.getDesity();
        i = (int)(0.4D * l);
        j = amse.a(i, DeviceInfoUtil.getPortraitWidth());
        this.jdField_a_of_type_Float = (j / DeviceInfoUtil.getDesity() - f * 204.0F / 1080.0F);
        f = FontSettingManager.getFontLevel() / 16.0F;
        if (f != 0.0F) {
          this.jdField_a_of_type_Float = (f * this.jdField_a_of_type_Float);
        }
        f = (float)l * 0.2F / 368.0F;
        this.jdField_a_of_type_Anct = new anct(localQQAppInterface);
        this.jdField_a_of_type_Anct.a(f, this.jdField_a_of_type_Float, 0.0F);
        this.jdField_a_of_type_Anmz = new anmz(this.jdField_a_of_type_Anct, 2);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localFriendProfileCardActivity, null);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Anmz);
          this.jdField_a_of_type_Anct.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
          this.jdField_a_of_type_Anct.a((String)localObject1);
          ThreadManager.post(new FriendCardApolloViewController.1(this), 10, null, true);
          this.jdField_a_of_type_Int = paramammu.jdField_a_of_type_Int;
          this.jdField_a_of_type_ArrayOfInt = paramammu.jdField_a_of_type_ArrayOfInt;
          paramammu = (RelativeLayout)localView.getParent().getParent();
          localQQAppInterface.addObserver(this.jdField_a_of_type_Anmz);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localQQAppInterface.getCurrentUin())))
          {
            if (this.jdField_a_of_type_Ampg == null) {
              this.jdField_a_of_type_Ampg = new ampg(this);
            }
            localQQAppInterface.addObserver(this.jdField_a_of_type_Ampg);
            ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).b(2);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
          this.jdField_a_of_type_Ampf = new ampf(this, null);
          this.jdField_a_of_type_Anct.a(this.jdField_a_of_type_Ampf);
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(56.0F, localFriendProfileCardActivity.getResources());
          paramammu.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject2);
          if (localObject1 != null)
          {
            if (!((String)localObject1).equals(localQQAppInterface.getCurrentUin())) {
              break label888;
            }
            if (!this.jdField_c_of_type_Boolean) {
              break label883;
            }
            i = 1;
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_show", 0, i, new String[0]);
          }
          if ((this.jdField_a_of_type_Boolean) && (amme.a(localQQAppInterface, (String)localObject1) == 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(localFriendProfileCardActivity, null);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(45.0F, localFriendProfileCardActivity.getResources()), AIOUtils.dp2px(45.0F, localFriendProfileCardActivity.getResources()));
            ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(45.0F, localFriendProfileCardActivity.getResources());
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(75.0F, localFriendProfileCardActivity.getResources());
            paramammu.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject1);
            b(false);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this.jdField_a_of_type_Ampf);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          return;
        }
        catch (Throwable paramammu)
        {
          QLog.e("FriendCardApolloViewController", 1, paramammu, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
          return;
        }
        bool = false;
        break label210;
        label883:
        i = 0;
        continue;
        label888:
        localObject2 = ((amme)localQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).b(localQQAppInterface.getCurrentUin());
        if (localObject2 != null) {
          this.jdField_c_of_type_Int = ((ApolloBaseInfo)localObject2).apolloStatus;
        }
        j = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (i = 1;; i = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_show", j, i, new String[] { "" + amme.a(localQQAppInterface), "0", "0", localObject1 });
          break;
        }
        label1006:
        anis.a(paramammu.e, 10, 107, new Object[0]);
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
    if (this.jdField_a_of_type_Anct != null) {
      this.jdField_a_of_type_Anct.c();
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
    azrb localazrb = ((FriendProfileCardActivity)localObject1).jdField_a_of_type_Azrb;
    if ((localazrb != null) && (localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject1 = localazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (localazrb != null)
        {
          localObject2 = localObject1;
          if (localazrb.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            localObject2 = localazrb.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
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
    if (this.jdField_a_of_type_Anct != null) {
      this.jdField_a_of_type_Anct.b();
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
    if (this.jdField_a_of_type_Bkys != null)
    {
      this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bkys.removeMessages(0);
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Ampg != null)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Ampg);
        this.jdField_a_of_type_Ampg = null;
      }
      if (this.jdField_a_of_type_Anmz != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Anmz);
      }
    }
    anhm.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Anct != null) {
      this.jdField_a_of_type_Anct.d();
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
      if ((paramMessage.obj instanceof ammu)) {
        a((ammu)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */