package com.tencent.mobileqq.apollo;

import aepi;
import aknx;
import akom;
import akql;
import akqm;
import aktj;
import albi;
import albr;
import alhp;
import allb;
import alsf;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import awqt;
import azqs;
import bdgk;
import bdug;
import betg;
import bhtd;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class FriendCardApolloViewController
  implements Handler.Callback
{
  protected float a;
  protected int a;
  private akql jdField_a_of_type_Akql;
  private akqm jdField_a_of_type_Akqm;
  private albr jdField_a_of_type_Albr;
  private allb jdField_a_of_type_Allb;
  public bhtd a;
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
  
  public FriendCardApolloViewController(FriendProfileCardActivity paramFriendProfileCardActivity, View paramView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity.app);
    this.jdField_a_of_type_Bhtd = new bhtd(paramFriendProfileCardActivity.getMainLooper(), this);
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
    if (this.jdField_a_of_type_Albr != null) {
      this.jdField_a_of_type_Albr.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localFriendProfileCardActivity == null) || (localQQAppInterface == null) || (localFriendProfileCardActivity.jdField_a_of_type_Awqt == null)) {
      return;
    }
    awqt localawqt = localFriendProfileCardActivity.jdField_a_of_type_Awqt;
    Object localObject1 = (aknx)localQQAppInterface.getManager(153);
    if (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
    for (String str1 = localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; str1 = null)
    {
      if ((TextUtils.isEmpty(str1)) && (localawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        str1 = localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        Object localObject2;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (paramString.contains("pet")))
        {
          paramString = (aknx)localQQAppInterface.getManager(153);
          if (str1.equals(localQQAppInterface.c()))
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
            break label527;
          }
          a(true);
          if ((TextUtils.isEmpty(str1)) || (!str1.equals(localQQAppInterface.c()))) {
            break label445;
          }
          if (!this.jdField_c_of_type_Boolean) {
            break label440;
          }
        }
        label402:
        label434:
        label440:
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_jump", 0, paramInt2, new String[0]);
          paramString = localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
          if ((this.jdField_a_of_type_Bhtd != null) && (paramString != null) && (((paramString instanceof ProfileTagView)) || ((paramString instanceof VipProfileSimpleView)))) {
            this.jdField_a_of_type_Bhtd.postDelayed(new FriendCardApolloViewController.2(this, paramString), 500L);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
          }
          i = 5;
          paramInt2 = i;
          if (localawqt != null)
          {
            paramInt2 = i;
            if (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
            {
              if (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break label1445;
              }
              if (paramInt1 != 0) {
                break label1440;
              }
              paramInt2 = 1;
            }
          }
          azqs.b(localQQAppInterface, "dc00898", "", "", "0X800999C", "0X800999C", paramInt2, 0, "", "", "", "");
          return;
          i = 1;
          break;
          paramString = "1";
          break label168;
        }
        label445:
        int i = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (paramInt2 = 1;; paramInt2 = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_jump", i, paramInt2, new String[] { "" + aknx.a(localQQAppInterface), "0", "0", str1 });
          break;
        }
        label527:
        if (paramInt2 == 1) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", str1 });
        }
        if ((localawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localQQAppInterface.c().equals(localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
        {
          paramInt2 = 1;
          label598:
          if ((!this.jdField_a_of_type_Boolean) && ((localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) && (paramInt2 == 0)) {
            break label1024;
          }
          if (paramInt2 == 0) {
            break label884;
          }
          paramString = ((aknx)localObject1).a(2, ((aknx)localObject1).k);
          label644:
          localFriendProfileCardActivity.o = true;
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
          if ((TextUtils.isEmpty(str1)) || (!str1.equals(localQQAppInterface.c()))) {
            break label904;
          }
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "mineprofile", paramString, null);
          if (!this.jdField_c_of_type_Boolean) {
            break label899;
          }
          paramInt2 = 1;
          label809:
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_clk", 0, paramInt2, new String[0]);
          label827:
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0)) {
            break label1005;
          }
          if (!this.jdField_b_of_type_Boolean) {
            break label1018;
          }
        }
        label884:
        label1012:
        label1018:
        for (paramString = "1";; paramString = "0")
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 1, 0, new String[] { paramString });
          break;
          paramInt2 = 0;
          break label598;
          paramString = ((aknx)localObject1).a(str1, this.jdField_c_of_type_Boolean);
          break label644;
          paramInt2 = 0;
          break label809;
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            localObject1 = "" + aknx.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1012;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break label827;
            break;
            paramInt2 = 0;
            break label931;
          }
        }
        label899:
        label904:
        label931:
        label1005:
        if (!this.jdField_c_of_type_Boolean)
        {
          localObject2 = new Intent(localFriendProfileCardActivity, ApolloGuestsStateActivity.class);
          localObject1 = null;
          paramString = (String)localObject1;
          if (localawqt != null)
          {
            paramString = (String)localObject1;
            if (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
              paramString = localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            }
          }
          if ((!TextUtils.isEmpty(paramString)) || (localawqt == null) || (localawqt.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
            break label1459;
          }
          paramString = localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
        }
        label1024:
        label1434:
        label1440:
        label1445:
        label1459:
        for (;;)
        {
          label1139:
          String str2;
          if (!TextUtils.isEmpty(str1))
          {
            ((Intent)localObject2).putExtra("extra_guest_uin", str1);
            i = this.jdField_c_of_type_Int;
            if (!this.jdField_c_of_type_Boolean) {
              break label1260;
            }
            paramInt2 = 1;
            str2 = "" + aknx.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1265;
            }
          }
          label1260:
          label1265:
          for (localObject1 = "0";; localObject1 = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { str2, localObject1, "0", str1 });
            if (!TextUtils.isEmpty(paramString)) {
              ((Intent)localObject2).putExtra("extra_guest_nick", paramString);
            }
            ((Intent)localObject2).putExtra("extra_guest_from", 3);
            localFriendProfileCardActivity.startActivity((Intent)localObject2);
            localFriendProfileCardActivity.overridePendingTransition(2130772036, 0);
            break;
            paramInt2 = 0;
            break label1139;
          }
          paramString = ((aknx)localObject1).a(str1, true);
          localFriendProfileCardActivity.o = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            label1353:
            localObject1 = "" + aknx.a(localQQAppInterface);
            if (!this.jdField_b_of_type_Boolean) {
              break label1434;
            }
          }
          for (paramString = "0";; paramString = "1")
          {
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_clk", i, paramInt2, new String[] { localObject1, paramString, "0", str1 });
            break;
            paramInt2 = 0;
            break label1353;
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
  
  void a(akom paramakom)
  {
    View localView = (View)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramakom == null) || (localQQAppInterface == null) || (localView == null) || (localFriendProfileCardActivity == null) || (!(localView instanceof RelativeLayout))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendCardApolloViewController", 2, "roleId->" + paramakom.jdField_a_of_type_Int + " apolloStatus->" + this.jdField_b_of_type_Int + " needStatic->" + paramakom.jdField_a_of_type_Boolean);
      }
    } while (paramakom.jdField_a_of_type_Boolean);
    Object localObject2 = null;
    awqt localawqt = localFriendProfileCardActivity.jdField_a_of_type_Awqt;
    Object localObject1 = localObject2;
    if (localawqt != null)
    {
      localObject1 = localObject2;
      if (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localawqt != null) && (localawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject1 = localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      boolean bool;
      label210:
      int i;
      int j;
      if (paramakom.d == 2)
      {
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        long l = Math.max(bdgk.h(), bdgk.g());
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          break label1000;
        }
        alhp.a(paramakom.e, 10, 0, new Object[] { "switch done" });
        alhp.a(paramakom.e, 100);
        float f = (float)bdgk.i() / bdgk.a();
        i = (int)(0.4D * l);
        j = aktj.a(i, bdgk.i());
        this.jdField_a_of_type_Float = (j / bdgk.a() - f * 204.0F / 1080.0F);
        f = alsf.a() / 16.0F;
        if (f != 0.0F) {
          this.jdField_a_of_type_Float = (f * this.jdField_a_of_type_Float);
        }
        f = (float)l * 0.2F / 368.0F;
        this.jdField_a_of_type_Albr = new albr(localQQAppInterface);
        this.jdField_a_of_type_Albr.a(f, this.jdField_a_of_type_Float, 0.0F);
        this.jdField_a_of_type_Allb = new allb(this.jdField_a_of_type_Albr, 2);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localFriendProfileCardActivity, null);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Allb);
          this.jdField_a_of_type_Albr.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
          this.jdField_a_of_type_Albr.a((String)localObject1);
          ThreadManager.post(new FriendCardApolloViewController.1(this), 10, null, true);
          this.jdField_a_of_type_Int = paramakom.jdField_a_of_type_Int;
          this.jdField_a_of_type_ArrayOfInt = paramakom.jdField_a_of_type_ArrayOfInt;
          paramakom = (RelativeLayout)localView.getParent();
          localQQAppInterface.addObserver(this.jdField_a_of_type_Allb);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localQQAppInterface.c())))
          {
            if (this.jdField_a_of_type_Akqm == null) {
              this.jdField_a_of_type_Akqm = new akqm(this);
            }
            localQQAppInterface.addObserver(this.jdField_a_of_type_Akqm);
            ((bdug)localQQAppInterface.a(71)).b(2);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
          this.jdField_a_of_type_Akql = new akql(this, null);
          this.jdField_a_of_type_Albr.a(this.jdField_a_of_type_Akql);
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aepi.a(56.0F, localFriendProfileCardActivity.getResources());
          paramakom.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject2);
          if (localObject1 != null)
          {
            if (!((String)localObject1).equals(localQQAppInterface.c())) {
              break label882;
            }
            if (!this.jdField_c_of_type_Boolean) {
              break label877;
            }
            i = 1;
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "file_show", 0, i, new String[0]);
          }
          if ((this.jdField_a_of_type_Boolean) && (aknx.a(localQQAppInterface, (String)localObject1) == 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(localFriendProfileCardActivity, null);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = new RelativeLayout.LayoutParams(aepi.a(45.0F, localFriendProfileCardActivity.getResources()), aepi.a(45.0F, localFriendProfileCardActivity.getResources()));
            ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = aepi.a(45.0F, localFriendProfileCardActivity.getResources());
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = aepi.a(75.0F, localFriendProfileCardActivity.getResources());
            paramakom.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject1);
            a(false);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this.jdField_a_of_type_Akql);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          return;
        }
        catch (Throwable paramakom)
        {
          QLog.e("FriendCardApolloViewController", 1, paramakom, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
          return;
        }
        bool = false;
        break label210;
        label877:
        i = 0;
        continue;
        label882:
        localObject2 = ((aknx)localQQAppInterface.getManager(153)).b(localQQAppInterface.c());
        if (localObject2 != null) {
          this.jdField_c_of_type_Int = ((ApolloBaseInfo)localObject2).apolloStatus;
        }
        j = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (i = 1;; i = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_show", j, i, new String[] { "" + aknx.a(localQQAppInterface), "0", "0", localObject1 });
          break;
        }
        label1000:
        alhp.a(paramakom.e, 10, 107, new Object[0]);
      }
    }
  }
  
  public void a(awqt paramawqt)
  {
    if ((paramawqt != null) && (paramawqt.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(a(), paramawqt.jdField_a_of_type_JavaLangString))) {}
    do
    {
      do
      {
        return;
      } while ((paramawqt != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53));
      paramawqt = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((this.jdField_a_of_type_Bhtd == null) || (a() == null) || (paramawqt == null) || (!(this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof RelativeLayout)) || (!aknx.a(paramawqt, Boolean.valueOf(false))) || (this.d) || (!paramawqt.jdField_a_of_type_Betg.a(1)));
    this.d = true;
    int i = albi.b(2);
    alhp.a(i);
    alhp.a(i, 1);
    alhp.a(i, 10);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16);
    ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    awqt localawqt = ((FriendProfileCardActivity)localObject1).jdField_a_of_type_Awqt;
    if ((localawqt != null) && (localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject1 = localawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (localawqt != null)
        {
          localObject2 = localObject1;
          if (localawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            localObject2 = localawqt.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
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
  
  public void b()
  {
    if (this.jdField_a_of_type_Albr != null) {
      this.jdField_a_of_type_Albr.b();
    }
    this.d = false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.c();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bhtd != null)
    {
      this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bhtd.removeMessages(0);
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Akqm != null)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Akqm);
        this.jdField_a_of_type_Akqm = null;
      }
      if (this.jdField_a_of_type_Allb != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Allb);
      }
    }
    algj.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Albr != null) {
      this.jdField_a_of_type_Albr.d();
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
      if ((paramMessage.obj instanceof akom)) {
        a((akom)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */