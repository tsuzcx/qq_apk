package com.tencent.mobileqq.apollo;

import actj;
import airx;
import aisl;
import aiuk;
import aiul;
import aixi;
import ajfh;
import ajfq;
import ajlo;
import ajoz;
import ajwc;
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
import auuy;
import axqy;
import bbdh;
import bbrd;
import bcpn;
import bfob;
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
  private aiuk jdField_a_of_type_Aiuk;
  private aiul jdField_a_of_type_Aiul;
  private ajfq jdField_a_of_type_Ajfq;
  private ajoz jdField_a_of_type_Ajoz;
  public bfob a;
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
    this.jdField_a_of_type_Bfob = new bfob(paramFriendProfileCardActivity.getMainLooper(), this);
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
    if (this.jdField_a_of_type_Ajfq != null) {
      this.jdField_a_of_type_Ajfq.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localFriendProfileCardActivity == null) || (localQQAppInterface == null) || (localFriendProfileCardActivity.jdField_a_of_type_Auuy == null)) {
      return;
    }
    auuy localauuy = localFriendProfileCardActivity.jdField_a_of_type_Auuy;
    Object localObject1 = (airx)localQQAppInterface.getManager(153);
    if (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
    for (String str1 = localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; str1 = null)
    {
      if ((TextUtils.isEmpty(str1)) && (localauuy.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
        str1 = localauuy.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
      }
      for (;;)
      {
        Object localObject2;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str1)) && (paramString.contains("pet")))
        {
          paramString = (airx)localQQAppInterface.getManager(153);
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
          if ((this.jdField_a_of_type_Bfob != null) && (paramString != null) && (((paramString instanceof ProfileTagView)) || ((paramString instanceof VipProfileSimpleView)))) {
            this.jdField_a_of_type_Bfob.postDelayed(new FriendCardApolloViewController.2(this, paramString), 500L);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getVisibility() == 0) && (paramInt1 == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
          }
          i = 5;
          paramInt2 = i;
          if (localauuy != null)
          {
            paramInt2 = i;
            if (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
            {
              if (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break label1445;
              }
              if (paramInt1 != 0) {
                break label1440;
              }
              paramInt2 = 1;
            }
          }
          axqy.b(localQQAppInterface, "dc00898", "", "", "0X800999C", "0X800999C", paramInt2, 0, "", "", "", "");
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
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_jump", i, paramInt2, new String[] { "" + airx.a(localQQAppInterface), "0", "0", str1 });
          break;
        }
        label527:
        if (paramInt2 == 1) {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "Guide_bubbles_clk", 0, 0, new String[] { "", "", "", str1 });
        }
        if ((localauuy.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (localQQAppInterface.c().equals(localauuy.jdField_a_of_type_ComTencentMobileqqDataCard.uin)))
        {
          paramInt2 = 1;
          label598:
          if ((!this.jdField_a_of_type_Boolean) && ((localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) && (paramInt2 == 0)) {
            break label1024;
          }
          if (paramInt2 == 0) {
            break label884;
          }
          paramString = ((airx)localObject1).a(2, ((airx)localObject1).k);
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
          paramString = ((airx)localObject1).a(str1, this.jdField_c_of_type_Boolean);
          break label644;
          paramInt2 = 0;
          break label809;
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            localObject1 = "" + airx.a(localQQAppInterface);
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
          if (localauuy != null)
          {
            paramString = (String)localObject1;
            if (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
              paramString = localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
            }
          }
          if ((!TextUtils.isEmpty(paramString)) || (localauuy == null) || (localauuy.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
            break label1459;
          }
          paramString = localauuy.jdField_a_of_type_ComTencentMobileqqDataCard.strNick;
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
            str2 = "" + airx.a(localQQAppInterface);
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
          paramString = ((airx)localObject1).a(str1, true);
          localFriendProfileCardActivity.o = true;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("extra_key_url_append", "&tab=interactive&suin=" + str1);
          ApolloUtil.a(localFriendProfileCardActivity, (Intent)localObject1, "guestprofile", paramString, null);
          i = this.jdField_c_of_type_Int;
          if (this.jdField_c_of_type_Boolean)
          {
            paramInt2 = 1;
            label1353:
            localObject1 = "" + airx.a(localQQAppInterface);
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
  
  void a(aisl paramaisl)
  {
    View localView = (View)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    QQAppInterface localQQAppInterface = a();
    FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((paramaisl == null) || (localQQAppInterface == null) || (localView == null) || (localFriendProfileCardActivity == null) || (!(localView instanceof RelativeLayout))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FriendCardApolloViewController", 2, "roleId->" + paramaisl.jdField_a_of_type_Int + " apolloStatus->" + this.jdField_b_of_type_Int + " needStatic->" + paramaisl.jdField_a_of_type_Boolean);
      }
    } while (paramaisl.jdField_a_of_type_Boolean);
    Object localObject2 = null;
    auuy localauuy = localFriendProfileCardActivity.jdField_a_of_type_Auuy;
    Object localObject1 = localObject2;
    if (localauuy != null)
    {
      localObject1 = localObject2;
      if (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {
        localObject1 = localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (localauuy != null) && (localauuy.jdField_a_of_type_ComTencentMobileqqDataCard != null)) {
      localObject1 = localauuy.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
    }
    for (;;)
    {
      boolean bool;
      label210:
      int i;
      int j;
      if (paramaisl.d == 2)
      {
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        long l = Math.max(bbdh.h(), bbdh.g());
        if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
          break label1000;
        }
        ajlo.a(paramaisl.e, 10, 0, new Object[] { "switch done" });
        ajlo.a(paramaisl.e, 100);
        float f = (float)bbdh.i() / bbdh.a();
        i = (int)(0.4D * l);
        j = aixi.a(i, bbdh.i());
        this.jdField_a_of_type_Float = (j / bbdh.a() - f * 204.0F / 1080.0F);
        f = ajwc.a() / 16.0F;
        if (f != 0.0F) {
          this.jdField_a_of_type_Float = (f * this.jdField_a_of_type_Float);
        }
        f = (float)l * 0.2F / 368.0F;
        this.jdField_a_of_type_Ajfq = new ajfq(localQQAppInterface);
        this.jdField_a_of_type_Ajfq.a(f, this.jdField_a_of_type_Float, 0.0F);
        this.jdField_a_of_type_Ajoz = new ajoz(this.jdField_a_of_type_Ajfq, 2);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localFriendProfileCardActivity, null);
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Ajoz);
          this.jdField_a_of_type_Ajfq.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
          this.jdField_a_of_type_Ajfq.a((String)localObject1);
          ThreadManager.post(new FriendCardApolloViewController.1(this), 10, null, true);
          this.jdField_a_of_type_Int = paramaisl.jdField_a_of_type_Int;
          this.jdField_a_of_type_ArrayOfInt = paramaisl.jdField_a_of_type_ArrayOfInt;
          paramaisl = (RelativeLayout)localView.getParent();
          localQQAppInterface.addObserver(this.jdField_a_of_type_Ajoz);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localQQAppInterface.c())))
          {
            if (this.jdField_a_of_type_Aiul == null) {
              this.jdField_a_of_type_Aiul = new aiul(this);
            }
            localQQAppInterface.addObserver(this.jdField_a_of_type_Aiul);
            ((bbrd)localQQAppInterface.a(71)).b(2);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
          this.jdField_a_of_type_Aiuk = new aiuk(this, null);
          this.jdField_a_of_type_Ajfq.a(this.jdField_a_of_type_Aiuk);
          localObject2 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = actj.a(56.0F, localFriendProfileCardActivity.getResources());
          paramaisl.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject2);
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
          if ((this.jdField_a_of_type_Boolean) && (airx.a(localQQAppInterface, (String)localObject1) == 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = new ApolloBoxEnterView(localFriendProfileCardActivity, null);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = new RelativeLayout.LayoutParams(actj.a(45.0F, localFriendProfileCardActivity.getResources()), actj.a(45.0F, localFriendProfileCardActivity.getResources()));
            ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = actj.a(45.0F, localFriendProfileCardActivity.getResources());
            ((RelativeLayout.LayoutParams)localObject1).rightMargin = actj.a(75.0F, localFriendProfileCardActivity.getResources());
            paramaisl.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, (ViewGroup.LayoutParams)localObject1);
            a(false);
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this.jdField_a_of_type_Aiuk);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          return;
        }
        catch (Throwable paramaisl)
        {
          QLog.e("FriendCardApolloViewController", 1, paramaisl, new Object[0]);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
          return;
        }
        bool = false;
        break label210;
        label877:
        i = 0;
        continue;
        label882:
        localObject2 = ((airx)localQQAppInterface.getManager(153)).b(localQQAppInterface.c());
        if (localObject2 != null) {
          this.jdField_c_of_type_Int = ((ApolloBaseInfo)localObject2).apolloStatus;
        }
        j = this.jdField_c_of_type_Int;
        if (this.jdField_c_of_type_Boolean) {}
        for (i = 1;; i = 0)
        {
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "guest_file_show", j, i, new String[] { "" + airx.a(localQQAppInterface), "0", "0", localObject1 });
          break;
        }
        label1000:
        ajlo.a(paramaisl.e, 10, 107, new Object[0]);
      }
    }
  }
  
  public void a(auuy paramauuy)
  {
    if ((paramauuy != null) && (paramauuy.jdField_b_of_type_Boolean) && (TroopInfo.isQidianPrivateTroop(a(), paramauuy.jdField_a_of_type_JavaLangString))) {}
    do
    {
      do
      {
        return;
      } while ((paramauuy != null) && (paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53));
      paramauuy = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((this.jdField_a_of_type_Bfob == null) || (a() == null) || (paramauuy == null) || (!(this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof RelativeLayout)) || (!airx.a(paramauuy, Boolean.valueOf(false))) || (this.d) || (!paramauuy.jdField_a_of_type_Bcpn.a(1)));
    this.d = true;
    int i = ajfh.b(2);
    ajlo.a(i);
    ajlo.a(i, 1);
    ajlo.a(i, 10);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16);
    ThreadManager.excute(this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController$RefreshApolloTask, 16, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      return;
    }
    auuy localauuy = ((FriendProfileCardActivity)localObject1).jdField_a_of_type_Auuy;
    if ((localauuy != null) && (localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)) {}
    for (localObject1 = localauuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = localObject1;
        if (localauuy != null)
        {
          localObject2 = localObject1;
          if (localauuy.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
            localObject2 = localauuy.jdField_a_of_type_ComTencentMobileqqDataCard.uin;
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
    if (this.jdField_a_of_type_Ajfq != null) {
      this.jdField_a_of_type_Ajfq.b();
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
    if (this.jdField_a_of_type_Bfob != null)
    {
      this.jdField_a_of_type_Bfob.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Bfob.removeMessages(0);
    }
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      if (this.jdField_a_of_type_Aiul != null)
      {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Aiul);
        this.jdField_a_of_type_Aiul = null;
      }
      if (this.jdField_a_of_type_Ajoz != null) {
        localQQAppInterface.removeObserver(this.jdField_a_of_type_Ajoz);
      }
    }
    ajki.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Ajfq != null) {
      this.jdField_a_of_type_Ajfq.d();
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
      if ((paramMessage.obj instanceof aisl)) {
        a((aisl)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController
 * JD-Core Version:    0.7.0.1
 */