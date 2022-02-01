package com.tencent.mobileqq.apollo;

import alnr;
import alog;
import alqf;
import alqg;
import altd;
import ambc;
import ambl;
import amhk;
import amky;
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
import aymg;
import bcef;
import bhha;
import bjng;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private alqf jdField_a_of_type_Alqf;
  private alqg jdField_a_of_type_Alqg;
  private ambl jdField_a_of_type_Ambl;
  private amky jdField_a_of_type_Amky;
  public bjng a;
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
    this.jdField_a_of_type_Bjng = new bjng(paramFriendProfileCardActivity.getMainLooper(), this);
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
    for (Object localObject = ((FriendProfileCardActivity)localObject).jdField_a_of_type_Aymg;; localObject = null)
    {
      if ((localObject != null) && (((aymg)localObject).jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(a(), ((aymg)localObject).jdField_a_of_type_JavaLangString))) {}
      for (;;)
      {
        return;
        if ((localObject == null) || (((aymg)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (((aymg)localObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 53))
        {
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
          for (localObject = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(); (this.jdField_a_of_type_Bjng != null) && (a() != null) && (localObject != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FrameLayout)) && (alnr.a((Context)localObject, Boolean.valueOf(false))) && (!this.d) && (((FriendProfileCardActivity)localObject).jdField_a_of_type_Bhha.a(1)); localObject = null)
          {
            this.d = true;
            int i = ambc.b(2);
            amhk.a(i);
            amhk.a(i, 1);
            amhk.a(i, 10);
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
    if ((localFriendProfileCardActivity == null) || (localQQAppInterface == null) || (localFriendProfileCardActivity.jdField_a_of_type_Aymg == null)) {
      return;
    }
    aymg localaymg = localFriendProfileCardActivity.jdField_a_of_type_Aymg;
    Object localObject1 = (alnr)localQQAppInterface.getManager(153);
    if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
    for (String str1 = localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; str1 = null)
    {
      if ((TextUtils.isEmpty(str1)) && (localaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        str1 = localaymg.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        Object localObject2;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (paramString.contains("pet")))
        {
          paramString = (alnr)localQQAppInterface.getManager(153);
          if (str1.equals(localQQAppInterface.getCurrentUin()))
          {
            i = 0;
            localObject2 = paramString.a(str1);
            if (paramInt1 != 0) {
              break label434;
            }
            paramString = "0";
            label168:
            VipUtils.a(null, "cmshow", "Apollo", "datapetclick", 0, i, new String[] { localObject2, paramString });
          }
        }
        else
        {
          if (paramInt1 != 0) {
            break label529;
          }
          b(true);
          if ((TextUtils.isEmpty(str1)) || (!str1.equals(localQQAppInterface.getCurrentUin()))) {
            break label446;
          }
          if (!this.jdField_c_of_type_Boolean) {
            break label441;
          }
        }
        label402:
        label434:
        label441:
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_jump", 0, paramInt2, new String[0]);
          paramString = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView;
          if ((this.jdField_a_of_type_Bjng != null) && (paramString != null) && (((paramString instanceof VasProfileTagView)) || ((paramString instanceof VasProfileSimpleView)))) {
            this.jdField_a_of_type_Bjng.postDelayed(new FriendCardApolloViewController.2(this, paramString), 500L);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
          }
          i = 5;
          paramInt2 = i;
          if (localaymg != null)
          {
            paramInt2 = i;
            if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
            {
              if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break label1451;
              }
              if (paramInt1 != 0) {
                break label1446;
              }
              paramInt2 = 1;
            }
          }
          bcef.b(localQQAppInterface, "dc00898", "", "", "0X800999C", "0X800999C", paramInt2, 0, "", "", "", "");
          return;
          i = 1;
          break;
          paramString = "1";
          break label168;
        }
        label446:
        int i = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_jump", i, paramInt2, new String[] { "" + alnr.a(localQQAppInterface), "0", "0", str1 });
          break;
        }
        label529:
        if (paramInt2 == 1) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", str1 });
        }
        if ((localaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localQQAppInterface.getCurrentUin().equals(localaymg.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
        {
          paramInt2 = 1;
          label601:
          if ((!this.jdField_a_of_type_Boolean) && ((localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) && (paramInt2 == 0)) {
            break label1029;
          }
          if (paramInt2 == 0) {
            break label888;
          }
          paramString = ((alnr)localObject1).a(2, ((alnr)localObject1).k);
          label647:
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
            break label908;
          }
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "mineprofile", paramString, null);
          if (!this.jdField_c_of_type_Boolean) {
            break label903;
          }
          paramInt2 = 1;
          label812:
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_clk", 0, paramInt2, new String[0]);
          label830:
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0)) {
            break label1009;
          }
          if (!this.jdField_b_of_type_Boolean) {
            break label1023;
          }
        }
        label888:
        label1016:
        label1023:
        for (paramString = "1";; paramString = "0")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 1, 0, new String[] { paramString });
          break;
          paramInt2 = 0;
          break label601;
          paramString = ((alnr)localObject1).a(str1, this.jdField_c_of_type_Boolean);
          break label647;
          paramInt2 = 0;
          break label812;
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            localObject1 = "" + alnr.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1016;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break label830;
            break;
            paramInt2 = 0;
            break label935;
          }
        }
        label903:
        label908:
        label935:
        label1009:
        if (!this.jdField_c_of_type_Boolean)
        {
          localObject2 = new Intent(localFriendProfileCardActivity, ApolloGuestsStateActivity.class);
          localObject1 = null;
          paramString = (String)localObject1;
          if (localaymg != null)
          {
            paramString = (String)localObject1;
            if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
              paramString = localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            }
          }
          if ((!TextUtils.isEmpty(paramString)) || (localaymg == null) || (localaymg.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
            break label1465;
          }
          paramString = localaymg.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
        }
        label1029:
        label1439:
        label1446:
        label1451:
        label1465:
        for (;;)
        {
          label1144:
          String str2;
          if (!TextUtils.isEmpty(str1))
          {
            ((Intent)localObject2).putExtra("extra_guest_uin", str1);
            i = this.jdField_c_of_type_Int;
            if (!this.jdField_c_of_type_Boolean) {
              break label1265;
            }
            paramInt2 = 1;
            str2 = "" + alnr.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1270;
            }
          }
          label1265:
          label1270:
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
            break label1144;
          }
          paramString = ((alnr)localObject1).a(str1, true);
          this.e = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            label1358:
            localObject1 = "" + alnr.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1439;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break;
            paramInt2 = 0;
            break label1358;
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
  
  void a(alog paramalog)
  {
    View localView = (View)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramalog == null) || (localQQAppInterface == null) || (localView == null) || (localFriendProfileCardActivity == null) || (!(localView instanceof FrameLayout))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendCardApolloViewController", 2, "roleId->" + paramalog.jdField_a_of_type_Int + " apolloStatus->" + this.jdField_b_of_type_Int + " needStatic->" + paramalog.jdField_a_of_type_Boolean);
      }
    } while (paramalog.jdField_a_of_type_Boolean);
    Object localObject2 = null;
    aymg localaymg = localFriendProfileCardActivity.jdField_a_of_type_Aymg;
    Object localObject1 = localObject2;
    if (localaymg != null)
    {
      localObject1 = localObject2;
      if (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localaymg != null) && (localaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject1 = localaymg.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      boolean bool;
      label210:
      int i;
      int j;
      if (paramalog.d == 2)
      {
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        long l = Math.max(DeviceInfoUtil.getDispalyHeight(), DeviceInfoUtil.getDispalyWidth());
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          break label1005;
        }
        amhk.a(paramalog.e, 10, 0, new Object[] { "switch done" });
        amhk.a(paramalog.e, 100);
        float f = (float)DeviceInfoUtil.getPortraitWidth() / DeviceInfoUtil.getDesity();
        i = (int)(0.4D * l);
        j = altd.a(i, DeviceInfoUtil.getPortraitWidth());
        this.jdField_a_of_type_Float = (j / DeviceInfoUtil.getDesity() - f * 204.0F / 1080.0F);
        f = FontSettingManager.getFontLevel() / 16.0F;
        if (f != 0.0F) {
          this.jdField_a_of_type_Float = (f * this.jdField_a_of_type_Float);
        }
        f = (float)l * 0.2F / 368.0F;
        this.jdField_a_of_type_Ambl = new ambl(localQQAppInterface);
        this.jdField_a_of_type_Ambl.a(f, this.jdField_a_of_type_Float, 0.0F);
        this.jdField_a_of_type_Amky = new amky(this.jdField_a_of_type_Ambl, 2);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localFriendProfileCardActivity, null);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Amky);
          this.jdField_a_of_type_Ambl.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
          this.jdField_a_of_type_Ambl.a((String)localObject1);
          ThreadManager.post(new FriendCardApolloViewController.1(this), 10, null, true);
          this.jdField_a_of_type_Int = paramalog.jdField_a_of_type_Int;
          this.jdField_a_of_type_ArrayOfInt = paramalog.jdField_a_of_type_ArrayOfInt;
          paramalog = (RelativeLayout)localView.getParent().getParent();
          localQQAppInterface.addObserver(this.jdField_a_of_type_Amky);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localQQAppInterface.getCurrentUin())))
          {
            if (this.jdField_a_of_type_Alqg == null) {
              this.jdField_a_of_type_Alqg = new alqg(this);
            }
            localQQAppInterface.addObserver(this.jdField_a_of_type_Alqg);
            ((VasExtensionHandler)localQQAppInterface.getBusinessHandler(71)).b(2);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
          this.jdField_a_of_type_Alqf = new alqf(this, null);
          this.jdField_a_of_type_Ambl.a(this.jdField_a_of_type_Alqf);
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(56.0F, localFriendProfileCardActivity.getResources());
          paramalog.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject2);
          if (localObject1 != null)
          {
            if (!((String)localObject1).equals(localQQAppInterface.getCurrentUin())) {
              break label887;
            }
            if (!this.jdField_c_of_type_Boolean) {
              break label882;
            }
            i = 1;
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_show", 0, i, new String[0]);
          }
          if ((this.jdField_a_of_type_Boolean) && (alnr.a(localQQAppInterface, (String)localObject1) == 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(localFriendProfileCardActivity, null);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(45.0F, localFriendProfileCardActivity.getResources()), AIOUtils.dp2px(45.0F, localFriendProfileCardActivity.getResources()));
            ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.dp2px(45.0F, localFriendProfileCardActivity.getResources());
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = AIOUtils.dp2px(75.0F, localFriendProfileCardActivity.getResources());
            paramalog.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject1);
            b(false);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this.jdField_a_of_type_Alqf);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          return;
        }
        catch (Throwable paramalog)
        {
          QLog.e("FriendCardApolloViewController", 1, paramalog, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
          return;
        }
        bool = false;
        break label210;
        label882:
        i = 0;
        continue;
        label887:
        localObject2 = ((alnr)localQQAppInterface.getManager(153)).b(localQQAppInterface.getCurrentUin());
        if (localObject2 != null) {
          this.jdField_c_of_type_Int = ((ApolloBaseInfo)localObject2).apolloStatus;
        }
        j = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (i = 1;; i = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_show", j, i, new String[] { "" + alnr.a(localQQAppInterface), "0", "0", localObject1 });
          break;
        }
        label1005:
        amhk.a(paramalog.e, 10, 107, new Object[0]);
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
    if (this.jdField_a_of_type_Ambl != null) {
      this.jdField_a_of_type_Ambl.c();
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
    aymg localaymg = ((FriendProfileCardActivity)localObject1).jdField_a_of_type_Aymg;
    if ((localaymg != null) && (localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject1 = localaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (localaymg != null)
        {
          localObject2 = localObject1;
          if (localaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            localObject2 = localaymg.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
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
    if (this.jdField_a_of_type_Ambl != null) {
      this.jdField_a_of_type_Ambl.b();
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
    if (this.jdField_a_of_type_Bjng != null)
    {
      this.jdField_a_of_type_Bjng.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bjng.removeMessages(0);
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Alqg != null)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Alqg);
        this.jdField_a_of_type_Alqg = null;
      }
      if (this.jdField_a_of_type_Amky != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Amky);
      }
    }
    amge.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ambl != null) {
      this.jdField_a_of_type_Ambl.d();
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
      if ((paramMessage.obj instanceof alog)) {
        a((alog)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */