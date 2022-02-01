package com.tencent.mobileqq.activity.aio;

import abao;
import acwh;
import adrm;
import afur;
import afuw;
import afwh;
import afwi;
import afwj;
import afwk;
import afwl;
import afwm;
import afwn;
import afwo;
import afwp;
import afwq;
import afwr;
import afxa;
import afxh;
import afxi;
import afxj;
import afyj;
import afyl;
import afzq;
import agki;
import ahdu;
import ahgl;
import ahkf;
import ahkp;
import ahvz;
import aift;
import aimx;
import aini;
import amuf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anie;
import anmw;
import anni;
import anuk;
import anwd;
import anwz;
import aobu;
import apwn;
import apwq;
import apwt;
import apwu;
import apwv;
import apxt;
import aqjq;
import aqkl;
import aqpb;
import aqud;
import asbq;
import asch;
import ascv;
import audn;
import avsr;
import awmr;
import awwm;
import awwt;
import axeg;
import azgc;
import bakq;
import bauy;
import bbyp;
import bcnj;
import bcst;
import bcsy;
import bcye;
import bdnf;
import bdol;
import beui;
import bfgp;
import bfgt;
import bfnl;
import bfpx;
import bfqc;
import bfqd;
import bfqe;
import bfrd;
import bfre;
import bfrf;
import bfsk;
import bfsq;
import bfti;
import bftj;
import bftx;
import bfup;
import bgjk;
import bgjn;
import bgjw;
import bgks;
import bglf;
import bgmg;
import bgmo;
import bgng;
import bgno;
import bgso;
import bgsu;
import bguh;
import bguj;
import bgwv;
import bhte;
import bhtu;
import bjft;
import bjho;
import bkfx;
import bmxq;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import gc;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import lag;
import laj;
import lak;
import lao;
import njo;
import njp;
import nmp;
import tyg;
import tzo;
import yqu;

public abstract class BaseBubbleBuilder
  extends afxi
  implements afxh, View.OnClickListener
{
  public static int a;
  public static ColorFilter a;
  public static final Handler a;
  protected static final ConcurrentHashMap<Long, String> a;
  public static boolean a;
  protected float a;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new afwk(this);
  protected ViewGroup a;
  @Deprecated
  public BaseAdapter a;
  public aobu a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  public QQAppInterface a;
  protected HashSet<Long> a;
  long b;
  public boolean b;
  private int c;
  public boolean c;
  protected boolean d;
  private boolean f;
  
  static
  {
    jdField_a_of_type_Int = 255;
    jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(100);
      return;
    }
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int a(TroopInfo paramTroopInfo)
  {
    int j = 0;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i = j;
    if (paramTroopInfo != null)
    {
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        if ((paramTroopInfo.Administrator == null) || (!paramTroopInfo.Administrator.contains(str))) {
          break label50;
        }
        i = 3;
      }
    }
    return i;
    label50:
    if (str.equals(paramTroopInfo.troopowneruin)) {
      return 2;
    }
    return 1;
  }
  
  private String a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    bfti localbfti = bfti.a();
    if (paramInt == 2) {}
    for (Object localObject = "troop_unique_title";; localObject = "troop_rank")
    {
      localObject = localbfti.a((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      ((StringBuilder)localObject).append("gc=").append(paramMessageRecord.frienduin).append("&");
      ((StringBuilder)localObject).append("uin=").append(paramMessageRecord.senderuin).append("&");
      ((StringBuilder)localObject).append("nick=").append(paramString).append("&");
      ((StringBuilder)localObject).append("type=").append(paramInt).append("&");
      ((StringBuilder)localObject).append("from=").append("aio").append("&");
      return ((StringBuilder)localObject).toString();
    }
    bftj localbftj = new bftj();
    localbftj.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    localbftj.jdField_b_of_type_JavaLangString = paramMessageRecord.senderuin;
    localbftj.jdField_e_of_type_JavaLangString = paramString;
    localbftj.jdField_d_of_type_JavaLangString = ("" + paramInt);
    localbftj.jdField_c_of_type_JavaLangString = "aio";
    return localbfti.a((String)localObject, localbftj);
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr)
  {
    int i;
    List localList;
    RelativeLayout.LayoutParams localLayoutParams6;
    if ((paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 1;
      if ((paramView == null) || (paramView.getId() != 2131364379) || (i != 0) || (!EmojiStickerManager.d(paramChatMessage)) || (paramChatMessage.fakeSenderType != 0)) {
        break label1462;
      }
      localList = EmojiStickerManager.a().a(paramChatMessage);
      localLayoutParams6 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null) {
        break label1577;
      }
    }
    label661:
    label921:
    label1057:
    label1064:
    label1577:
    for (RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();; localLayoutParams1 = null)
    {
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {}
      for (RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();; localLayoutParams2 = null)
      {
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {}
        for (RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();; localLayoutParams3 = null)
        {
          if ((paramBaseChatItemLayout.c != null) && (paramBaseChatItemLayout.c.getVisibility() == 0)) {}
          for (RelativeLayout.LayoutParams localLayoutParams4 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.c.getLayoutParams();; localLayoutParams4 = null)
          {
            if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
            for (RelativeLayout.LayoutParams localLayoutParams5 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();; localLayoutParams5 = null)
            {
              int j = paramContext.getResources().getDisplayMetrics().widthPixels;
              float f2 = paramContext.getResources().getDisplayMetrics().density;
              int i1;
              int n;
              boolean bool1;
              if (localLayoutParams5 != null)
              {
                i1 = localLayoutParams5.topMargin;
                n = localLayoutParams5.bottomMargin;
                bool1 = true;
              }
              for (;;)
              {
                int i3;
                int i2;
                if (localLayoutParams6 != null)
                {
                  i3 = localLayoutParams6.topMargin;
                  i2 = localLayoutParams6.bottomMargin;
                }
                for (;;)
                {
                  int i5;
                  int i4;
                  boolean bool2;
                  if (localLayoutParams3 != null)
                  {
                    i5 = localLayoutParams3.topMargin;
                    i4 = localLayoutParams3.bottomMargin;
                    bool2 = true;
                  }
                  for (;;)
                  {
                    int i7;
                    int i6;
                    if (localLayoutParams1 != null)
                    {
                      i7 = localLayoutParams1.topMargin;
                      i6 = localLayoutParams1.bottomMargin;
                    }
                    for (;;)
                    {
                      int i9;
                      int i8;
                      boolean bool3;
                      if (localLayoutParams2 != null)
                      {
                        i9 = localLayoutParams2.topMargin;
                        i8 = localLayoutParams2.bottomMargin;
                        bool3 = true;
                      }
                      for (;;)
                      {
                        int i11;
                        int i10;
                        boolean bool4;
                        if (localLayoutParams4 != null)
                        {
                          i11 = localLayoutParams4.topMargin;
                          i10 = localLayoutParams4.bottomMargin;
                          bool4 = true;
                        }
                        for (;;)
                        {
                          awmr localawmr;
                          int k;
                          int i12;
                          if ((localList != null) && (localList.size() > 0) && (EmojiStickerManager.b(paramChatMessage)))
                          {
                            localawmr = (awmr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
                            localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localList);
                            k = 0;
                            i = 0;
                            i12 = localList.size() - 1;
                            label452:
                            if (i12 >= 0)
                            {
                              paramChatMessage = (MessageRecord)localList.get(i12);
                              if (paramChatMessage.extraflag == 32768) {
                                i += 1;
                              }
                            }
                          }
                          for (;;)
                          {
                            i12 -= 1;
                            break label452;
                            i = 0;
                            break;
                            EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a(paramChatMessage);
                            if ((localStickerInfo != null) && (EmojiStickerManager.c(paramChatMessage)))
                            {
                              int i13 = k + 1;
                              if (i13 > EmojiStickerManager.jdField_f_of_type_Int)
                              {
                                paramChatMessage.msgtype = -2006;
                                i += 1;
                                k = i13;
                              }
                              else
                              {
                                if ((paramChatMessage instanceof MessageForMarketFace)) {
                                  paramView = localawmr.a(((MessageForMarketFace)paramChatMessage).mMarkFaceMessage);
                                }
                                for (;;)
                                {
                                  label573:
                                  int i14;
                                  label595:
                                  label617:
                                  int i15;
                                  label639:
                                  int i16;
                                  int i17;
                                  int m;
                                  int i18;
                                  if (localStickerInfo.x <= 1.0F)
                                  {
                                    i14 = (int)(localStickerInfo.x * j);
                                    if (localStickerInfo.y > 1.0F) {
                                      break label1057;
                                    }
                                    k = (int)(localStickerInfo.y * j);
                                    if (localStickerInfo.width > 1.0F) {
                                      break label1064;
                                    }
                                    i15 = (int)(localStickerInfo.width * j);
                                    if (localStickerInfo.height > 1.0F) {
                                      break label1071;
                                    }
                                    i16 = (int)(localStickerInfo.height * j);
                                    i17 = localStickerInfo.rotate;
                                    m = k + localLayoutParams6.topMargin;
                                    k = m;
                                    if (localLayoutParams5 != null) {
                                      k = m + (afur.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams5.topMargin + localLayoutParams5.bottomMargin));
                                    }
                                    m = k;
                                    if (localLayoutParams3 != null) {
                                      m = k + (afur.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams3.topMargin + localLayoutParams3.bottomMargin));
                                    }
                                    k = m;
                                    if (m < 0)
                                    {
                                      i18 = -m;
                                      if (localLayoutParams1 != null) {
                                        localLayoutParams1.topMargin += i18;
                                      }
                                      if (localLayoutParams3 == null) {
                                        break label1078;
                                      }
                                      localLayoutParams3.topMargin += i18;
                                      label812:
                                      if (localLayoutParams4 != null) {
                                        localLayoutParams4.topMargin += i18;
                                      }
                                      if (localLayoutParams2 != null) {
                                        localLayoutParams2.topMargin += i18;
                                      }
                                      m = 0;
                                      k = m;
                                      if (i12 != localList.size() - 1)
                                      {
                                        paramafwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c(i18);
                                        k = m;
                                      }
                                    }
                                    if (!(paramView instanceof asbq)) {
                                      break label1111;
                                    }
                                    paramChatMessage = (asbq)paramView;
                                    if (paramChatMessage.a == null) {
                                      break label1471;
                                    }
                                    if ((EmojiStickerManager.jdField_f_of_type_Boolean) || (bgmg.a() <= 1.048576E+008F)) {
                                      break label1094;
                                    }
                                    m = 1;
                                    if (m == 0) {
                                      break label1100;
                                    }
                                    paramView = paramChatMessage.a("fromAIO", true, false, null, i15, i15);
                                    label941:
                                    paramChatMessage = paramChatMessage.a.epId;
                                  }
                                  for (;;)
                                  {
                                    label949:
                                    BaseChatItemLayout localBaseChatItemLayout;
                                    double d1;
                                    boolean bool5;
                                    if (paramView != null)
                                    {
                                      localBaseChatItemLayout = paramafwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
                                      d1 = i17;
                                      bool5 = localStickerInfo.isShown;
                                      if (!localStickerInfo.isShown) {
                                        break label1196;
                                      }
                                    }
                                    label1196:
                                    for (float f1 = 1.0F;; f1 = 1.1F)
                                    {
                                      localBaseChatItemLayout.a(paramView, i14, k, i15, i16, d1, paramChatMessage, bool5, f1, localStickerInfo);
                                      k = i13;
                                      break;
                                      if (!(paramChatMessage instanceof MessageForText)) {
                                        break label1479;
                                      }
                                      paramView = (MessageForText)paramChatMessage;
                                      if (TextUtils.isEmpty(paramView.msg)) {
                                        break label1479;
                                      }
                                      paramView = EmojiStickerManager.a().a(paramView.msg);
                                      break label573;
                                      i14 = j;
                                      break label595;
                                      k = j;
                                      break label617;
                                      i15 = j;
                                      break label639;
                                      label1071:
                                      i16 = j;
                                      break label661;
                                      label1078:
                                      localLayoutParams6.topMargin += i18;
                                      break label812;
                                      label1094:
                                      m = 0;
                                      break label921;
                                      label1100:
                                      paramView = paramChatMessage.a(paramContext, f2);
                                      break label941;
                                      label1111:
                                      if ((paramView instanceof ascv))
                                      {
                                        paramView = ((ascv)paramView).b(paramContext, f2);
                                        paramChatMessage = "";
                                        break label949;
                                      }
                                      if ((paramView instanceof asch))
                                      {
                                        paramView = ((asch)paramView).b(paramContext, f2);
                                        paramChatMessage = "";
                                        break label949;
                                      }
                                      if (!(paramChatMessage instanceof MessageForPic)) {
                                        break label1463;
                                      }
                                      paramView = ahdu.a(paramContext, (MessageForPic)paramChatMessage);
                                      ThreadManager.post(new BaseBubbleBuilder.1(this, paramChatMessage), 5, null, true);
                                      paramChatMessage = "";
                                      break label949;
                                    }
                                    if (i != localList.size())
                                    {
                                      paramView = new Bundle();
                                      paramView.putBoolean("haveTimeStamp", bool1);
                                      paramView.putBoolean("haveNickName", bool2);
                                      paramView.putBoolean("havePendant", bool3);
                                      paramView.putBoolean("haveTroopMemberLevel", bool4);
                                      if (localLayoutParams5 != null)
                                      {
                                        paramView.putInt("timeStampTop", i1);
                                        paramView.putInt("timeStampBottom", n);
                                      }
                                      if (localLayoutParams6 != null)
                                      {
                                        paramView.putInt("textViewTop", i3);
                                        paramView.putInt("textViewBottom", i2);
                                      }
                                      if (localLayoutParams3 != null)
                                      {
                                        paramView.putInt("nickNameViewTop", i5);
                                        paramView.putInt("nickNameViewBottom", i4);
                                      }
                                      if (localLayoutParams1 != null)
                                      {
                                        paramView.putInt("headViewTop", i7);
                                        paramView.putInt("headViewBottom", i6);
                                      }
                                      if (localLayoutParams2 != null)
                                      {
                                        paramView.putInt("pendantViewTop", i9);
                                        paramView.putInt("pendantViewBottom", i8);
                                      }
                                      if (localLayoutParams4 != null)
                                      {
                                        paramView.putInt("troopMemberLevelTop", i11);
                                        paramView.putInt("troopMemberLevelBottom", i10);
                                      }
                                      paramBaseChatItemLayout.setTag(2131374138, paramView);
                                    }
                                    paramBaseChatItemLayout.jdField_a_of_type_Aruz = new afwh(this);
                                    if (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null)
                                    {
                                      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
                                      paramView.addRule(6, 2131364388);
                                      paramView.topMargin = (-afur.a(1.0F, paramContext.getResources()));
                                    }
                                    label1462:
                                    return;
                                    label1463:
                                    paramChatMessage = "";
                                    paramView = null;
                                    continue;
                                    label1471:
                                    paramChatMessage = "";
                                    paramView = null;
                                  }
                                  label1479:
                                  paramView = null;
                                }
                              }
                            }
                          }
                          bool4 = false;
                          i10 = 0;
                          i11 = 0;
                        }
                        bool3 = false;
                        i8 = 0;
                        i9 = 0;
                      }
                      i6 = 0;
                      i7 = 0;
                    }
                    bool2 = false;
                    i4 = 0;
                    i5 = 0;
                  }
                  i2 = 0;
                  i3 = 0;
                }
                bool1 = false;
                n = 0;
                i1 = 0;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramView != null) && (paramView.getId() == 2131364379))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131374138);
      if ((localObject instanceof Bundle))
      {
        localObject = (Bundle)localObject;
        boolean bool1 = ((Bundle)localObject).getBoolean("haveTimeStamp");
        boolean bool2 = ((Bundle)localObject).getBoolean("haveNickName");
        boolean bool3 = ((Bundle)localObject).getBoolean("havePendant");
        boolean bool4 = ((Bundle)localObject).getBoolean("haveTroopMemberLevel");
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, "restoreLayoutParams params = " + ((Bundle)localObject).toString());
        }
        paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
        paramView.topMargin = ((Bundle)localObject).getInt("textViewTop", 0);
        paramView.bottomMargin = ((Bundle)localObject).getInt("textViewBotttom", 0);
        localLayoutParams.topMargin = ((Bundle)localObject).getInt("headViewTop", 0);
        localLayoutParams.bottomMargin = ((Bundle)localObject).getInt("headViewBottom", 0);
        if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (bool3))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("pendantViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("pendantViewBottom", 0);
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (bool2))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("nickNameViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("nickNameViewBottom", 0);
        }
        if ((paramBaseChatItemLayout.c != null) && (paramBaseChatItemLayout.c.getVisibility() == 0) && (bool4))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.c.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("troopMemberLevelTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("troopMemberLevelBottom", 0);
        }
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (bool1))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("timeStampTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("timeStampBottom", 0);
        }
        paramBaseChatItemLayout.setTag(2131374138, null);
      }
    }
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, anmw paramanmw, boolean paramBoolean1, boolean paramBoolean2, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 10002))
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      if (paramMessageRecord.istroop == 1001)
      {
        paramAllInOne.jdField_h_of_type_Int = 10;
        paramView.putExtra("frome_where", 21);
        paramAllInOne.a = abao.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramView.putExtra("AllInOne", paramAllInOne);
        if (!bgjw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString)) {
          break label189;
        }
        paramView.putExtra("param_mode", 2);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break label201;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 9009);
        return;
        if (paramMessageRecord.istroop == 1010)
        {
          paramAllInOne.jdField_h_of_type_Int = 11;
          break;
        }
        if (paramMessageRecord.istroop != 10002) {
          break;
        }
        paramView.putExtra("frome_where", 22);
        break;
        label189:
        paramView.putExtra("param_mode", 3);
      }
      label201:
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    if ((!paramBoolean2) && (!paramanmw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramanmw = aift.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
      if (paramanmw == null) {
        break label305;
      }
      paramAllInOne.b.putSerializable("param_wzry_data", paramanmw);
    }
    while (avsr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int == 20) {
        i = 1;
      }
      ProfileActivity.a(paramView.getContext(), paramAllInOne, i, 2);
      return;
      label305:
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key")))
      {
        paramMessageRecord = paramMessageRecord.senderuin;
        paramMessageRecord = KplRoleInfo.WZRYUIinfo.createInfo(paramMessageRecord, KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)), KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0);
        paramAllInOne.b.putSerializable("param_wzry_data", paramMessageRecord);
      }
    }
    ProfileActivity.b(paramView.getContext(), paramAllInOne);
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, njp paramnjp, int paramInt)
  {
    Object localObject1 = paramnjp.a();
    if ((localObject1 != null) && (paramnjp.jdField_a_of_type_Int != 2))
    {
      njo.jdField_a_of_type_Long = paramMessageRecord.shmsgseq;
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject1, 2));
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localStringBuilder = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject1).append("&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(njo.a(paramnjp.jdField_b_of_type_Int)).append("&nick=");
      if (TextUtils.isEmpty(paramnjp.jdField_b_of_type_JavaLangString))
      {
        paramnjp = "";
        ((Intent)localObject2).putExtra("url", paramnjp + "&role=" + String.valueOf(paramInt) + "&self=0");
        ((Activity)paramView.getContext()).startActivity((Intent)localObject2);
        if (paramMessageRecord.msgData != null)
        {
          njo.a().a(paramMessageRecord.frienduin, (String)localObject1, paramMessageRecord);
          if (QLog.isDevelopLevel()) {
            QLog.i("ChatItemBuilder", 4, "report:" + paramMessageRecord.msgData.toString());
          }
        }
      }
    }
    while (paramnjp.jdField_a_of_type_Int != 2) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        paramnjp = URLEncoder.encode(paramnjp.jdField_b_of_type_JavaLangString);
      }
    }
    localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    Object localObject2 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(njo.a(paramnjp.jdField_b_of_type_Int)).append("&nick=");
    if (TextUtils.isEmpty(paramnjp.jdField_b_of_type_JavaLangString)) {}
    for (paramMessageRecord = "";; paramMessageRecord = URLEncoder.encode(paramnjp.jdField_b_of_type_JavaLangString))
    {
      ((Intent)localObject1).putExtra("url", paramMessageRecord + "&role=" + String.valueOf(paramInt) + "&self=1");
      ((Activity)paramView.getContext()).startActivity((Intent)localObject1);
      return;
    }
  }
  
  public static void a(bguh parambguh, Context paramContext)
  {
    parambguh.a(2131365308, paramContext.getString(2131690641), 2130838924);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    String str = paramSessionInfo.jdField_d_of_type_JavaLangString;
    if (paramChatMessage.isSend()) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.a(bool, str, paramSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
      return;
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!aqjq.a(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
    {
      localObject = lao.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      paramContext = null;
      lag locallag = lak.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallag != null) {
        paramContext = locallag.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
      }
      if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
      {
        paramafwr.jdField_a_of_type_Apwt = apxt.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBoolean);
        if (paramafwr.jdField_a_of_type_Apwt != null) {
          paramafwr.jdField_a_of_type_Apwt.a(paramafwr.jdField_a_of_type_AndroidViewView, null);
        }
        if (paramafwr.jdField_a_of_type_AndroidViewView != null)
        {
          paramafwr.jdField_a_of_type_AndroidViewView.setMinimumWidth(afur.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramafwr.jdField_a_of_type_AndroidViewView.setMinimumHeight(afur.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        if (paramafwr.jdField_a_of_type_Apwt != null)
        {
          int j = paramChatMessage.vipBubbleDiyTextId;
          i = j;
          if (j <= 0) {
            i = anuk.b(paramChatMessage.vipBubbleID);
          }
          if (paramChatMessage.fakeSenderType != 1) {
            break label529;
          }
          paramContext = paramafwr.jdField_a_of_type_Apwt;
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          bool1 = paramChatMessage.isSend();
          bool2 = paramChatMessage.needVipBubble();
          if (paramInt3 != 2) {
            break label523;
          }
        }
      }
    }
    label523:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramContext.a((QQAppInterface)localObject, bool1, bool2, paramBoolean, paramafwr.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i);
      if (paramafwr.jdField_a_of_type_AndroidViewView != null)
      {
        paramContext = paramafwr.jdField_a_of_type_AndroidViewView.getBackground();
        if (paramContext != null) {
          paramContext.setAlpha(jdField_a_of_type_Int);
        }
      }
      a(paramafwr, paramBaseChatItemLayout, paramChatMessage, paramafwr.jdField_a_of_type_Apwt);
      a(paramafwr, paramChatMessage);
      b(paramafwr, paramChatMessage);
      if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
        jdField_a_of_type_AndroidOsHandler.post(new BaseBubbleBuilder.5(this, paramafwr, paramChatMessage));
      }
      paramChatMessage.mAnimFlag = false;
      return;
      paramafwr.jdField_a_of_type_Apwt = apxt.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBoolean);
      break;
      if ((paramInt3 == 3) || (!paramChatMessage.needVipBubble()) || (aqjq.a(paramChatMessage))) {
        i = 0;
      }
      for (;;)
      {
        paramafwr.jdField_a_of_type_Apwt = apxt.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBoolean);
        break;
        localObject = (anuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
        if (paramChatMessage.fakeSenderType == 1) {
          i = ((anuk)localObject).b();
        } else {
          i = ((anuk)localObject).a(paramChatMessage);
        }
      }
    }
    label529:
    paramContext = paramafwr.jdField_a_of_type_Apwt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool1 = paramChatMessage.isSend();
    boolean bool2 = paramChatMessage.needVipBubble();
    if (paramInt3 == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramContext.a((QQAppInterface)localObject, bool1, bool2, paramBoolean, paramafwr.jdField_a_of_type_AndroidViewView, gc.a(paramChatMessage), i);
      break;
    }
  }
  
  @TargetApi(14)
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramChatMessage.istroop == 3000) {
      if (bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
      {
        localObject1 = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = paramChatMessage.senderuin;
        }
        if (((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) != 1) {
          break label270;
        }
        i = 1;
        label97:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
        if (i == 0) {
          break label276;
        }
        localObject1 = ((audn)localObject1).jdField_d_of_type_JavaLangString;
        label127:
        if (localObject2 == null) {
          break label282;
        }
        label132:
        paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
        localObject1 = localObject2;
        if (paramBaseChatItemLayout.f != null)
        {
          paramBaseChatItemLayout.f.setOnClickListener(this);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if ((paramBaseChatItemLayout.e != null) && (AppSetting.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT >= 14)) {
        paramBaseChatItemLayout.e.setAccessibilityDelegate(new afwi(this));
      }
      a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, paramafwr);
      return;
      if (paramChatMessage.isSend()) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();; localObject1 = bglf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin)) {
        break;
      }
      label270:
      i = 0;
      break label97;
      label276:
      localObject1 = null;
      break label127;
      label282:
      bool1 = false;
      break label132;
      if (paramChatMessage.istroop == 9501)
      {
        if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
        {
          localObject1 = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
          if (paramChatMessage.senderuin.equals(paramChatMessage.frienduin)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          }
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() != 0) {}
          }
          else
          {
            localObject2 = paramChatMessage.senderuin;
          }
          paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidContentResColorStateList, false, false, false, false, "", null, null);
        }
        for (;;)
        {
          localObject1 = null;
          break;
          paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
        }
      }
      if (bjft.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin))
      {
        localObject2 = bjho.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n)
      {
        a(paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
        localObject1 = null;
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, String paramString, anmw paramanmw)
  {
    ExtensionInfo localExtensionInfo = paramanmw.a(paramString, false);
    AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    String str;
    if ((localExtensionInfo != null) && (localExtensionInfo.lastUpdateTime < paramChatMessage.time))
    {
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_id");
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message id = " + str);
      }
      if ((!TextUtils.isEmpty(str)) && (Long.parseLong(str) != localExtensionInfo.pendantId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message id not equals local");
        }
        bgks.a(paramString);
        bgks.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_diy_id");
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message pendantDiyId = " + str);
      }
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      if (Integer.parseInt(str) != localExtensionInfo.pendantDiyId)
      {
        bgks.a(paramString);
        bgks.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
      {
        AvatarPendantManager.jdField_b_of_type_Boolean = true;
        if (bgks.a(localExtensionInfo.pendantId))
        {
          localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq, paramString, localExtensionInfo.pendantDiyId);
          if ((!paramanmw.b(paramString)) && (localExtensionInfo.isPendantExpired())) {
            bgks.a(paramString);
          }
          if ((!localAvatarPendantManager.a(paramChatMessage.uniseq)) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)) {
            paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
          }
          return;
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("ChatItemBuilder", 1, "parse vip_pendant_diy_id field failed, value=" + str);
          continue;
          localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 1, paramChatMessage.uniseq, paramString, localExtensionInfo.pendantDiyId);
        }
        if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
      } while (localExtensionInfo != null);
      bgks.a(paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, bfrf parambfrf)
  {
    bfre.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, parambfrf);
    bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, paramMessageRecord.frienduin, "", parambfrf.jdField_c_of_type_JavaLangString, "");
    if (paramMessageRecord.msgtype == -2051) {}
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_head", paramMessageRecord, false);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramString.equals(paramAllInOne.jdField_h_of_type_JavaLangString)) {
      paramAllInOne.jdField_h_of_type_JavaLangString = null;
    }
    paramAllInOne.a = abao.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020)) {
      paramAllInOne.jdField_d_of_type_JavaLangString = paramMessageRecord.senderuin;
    }
    for (;;)
    {
      paramAllInOne.g = 2;
      if (paramMessageRecord.istroop != 0) {
        break;
      }
      paramAllInOne.jdField_h_of_type_Int = 1;
      return;
      if (paramMessageRecord.istroop == 1)
      {
        paramAllInOne.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        paramAllInOne.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
      }
      else if (3000 == paramMessageRecord.istroop)
      {
        paramAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      }
    }
    if (paramMessageRecord.istroop == 3000)
    {
      paramAllInOne.jdField_h_of_type_Int = 107;
      return;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramAllInOne.jdField_h_of_type_Int = 108;
      return;
    }
    paramAllInOne.jdField_h_of_type_Int = 106;
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        bcst.b(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin()), paramString2, null);
      }
      return;
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr)
  {
    int i;
    int j;
    label30:
    int k;
    label65:
    int m;
    label92:
    String str;
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      if (paramChatMessage.istroop != 1) {
        break label185;
      }
      i = 1;
      if (paramChatMessage.istroop != 3000) {
        break label191;
      }
      j = 1;
      if ((paramChatMessage.fakeSenderType != 2) && (((paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 3000)) || (!paramChatMessage.isMultiMsg))) {
        break label197;
      }
      k = 1;
      if ((!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
        break label203;
      }
      m = 1;
      if ((i != 0) || (j != 0) || (k != 0))
      {
        if (i == 0) {
          break label306;
        }
        if (m == 0) {
          break label209;
        }
        str = anni.a(2131699753);
      }
    }
    label306:
    label439:
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setContentDescription(str);
      if ((AppSetting.jdField_c_of_type_Boolean) && (paramafwr.jdField_b_of_type_JavaLangStringBuilder != null))
      {
        if ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramChatMessage.senderuin)) || (paramChatMessage.isSend())) {
          paramafwr.jdField_b_of_type_JavaLangStringBuilder.append("我");
        }
      }
      else
      {
        return;
        label185:
        i = 0;
        break;
        label191:
        j = 0;
        break label30;
        label197:
        k = 0;
        break label65;
        label203:
        m = 0;
        break label92;
        label209:
        if ("1000000".equals(paramChatMessage.senderuin))
        {
          if (paramChatMessage.msgtype == -3006)
          {
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131696951), new Object[] { tyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = anni.a(2131699754);
          continue;
        }
        str = paramString + anni.a(2131699746);
        continue;
        if (j != 0)
        {
          if (m != 0)
          {
            str = anni.a(2131699757);
            continue;
          }
          str = paramString + anni.a(2131699747);
          continue;
        }
        if (m != 0) {}
        for (str = anni.a(2131699757);; str = paramString + anni.a(2131699747))
        {
          if (paramChatMessage.msgtype != -3006) {
            break label439;
          }
          str = String.format(paramBaseChatItemLayout.getResources().getString(2131696951), new Object[] { tyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          break;
        }
      }
    }
    paramBaseChatItemLayout = paramString;
    if (paramString == null) {
      paramBaseChatItemLayout = "";
    }
    paramString = paramBaseChatItemLayout;
    if (njo.a(paramChatMessage)) {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689992) + paramBaseChatItemLayout;
    }
    paramafwr.jdField_b_of_type_JavaLangStringBuilder.insert(0, paramString);
  }
  
  public static boolean a(View paramView)
  {
    Object localObject = afur.a(paramView);
    if (localObject == null) {}
    while (!(localObject instanceof afwr)) {
      return false;
    }
    paramView = (afwr)afur.a(paramView);
    if ((paramView.jdField_a_of_type_Apwt == null) || (paramView.jdField_a_of_type_Apwt.jdField_a_of_type_Int <= 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord)
  {
    if (d(paramMessageRecord)) {}
    while ((c(paramView, paramMessageRecord)) || (b(paramView, paramMessageRecord))) {
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    bftx localbftx;
    if (!paramBoolean)
    {
      bool1 = bool2;
      if (paramMessageRecord.istroop == 1) {
        localbftx = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      }
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord.senderuin);
      paramBoolean = localbftx.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, l);
      if (paramBoolean)
      {
        bool1 = true;
        return bool1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("ChatItemBuilder", 2, "parseLong error: messageRecord.senderuin = " + paramMessageRecord.senderuin);
      }
      azgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), paramMessageRecord.frienduin, paramMessageRecord.senderuin, 0, 2000);
    }
    return true;
  }
  
  private boolean a(ChatMessage paramChatMessage, afwr paramafwr, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (bcnj.b())
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
      Drawable localDrawable;
      if (bool)
      {
        i = 2130849990;
        localDrawable = ((Resources)localObject).getDrawable(i);
        if (!bool) {
          break label157;
        }
      }
      label157:
      for (int i = 2130849989;; i = 2130849813)
      {
        localObject = ((Resources)localObject).getDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
        paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramafwr.jdField_a_of_type_Apwt = new apwt(0);
        a(paramafwr, paramBaseChatItemLayout, paramChatMessage, paramafwr.jdField_a_of_type_Apwt);
        a(paramafwr, paramChatMessage);
        b(paramafwr, paramChatMessage);
        return true;
        i = 2130849814;
        break;
      }
    }
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return (paramBoolean) && (((bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    String str = null;
    if (paramHotChatInfo != null)
    {
      str = paramHotChatInfo.troopCode;
      if (paramHotChatInfo.isGameRoom)
      {
        localObject = (bhte)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107);
        if ((((bhte)localObject).jdField_a_of_type_JavaLangString != null) && (((bhte)localObject).jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin))) {
          return true;
        }
      }
    }
    bkfx.a();
    Object localObject = paramMessageRecord.senderuin;
    label130:
    boolean bool;
    if ((paramHotChatInfo != null) && (paramHotChatInfo.isBuLuoHotChat()))
    {
      i = 86;
      localObject = new ProfileActivity.AllInOne((String)localObject, i);
      ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_JavaLangString = str;
      ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = paramMessageRecord.frienduin;
      if ((paramHotChatInfo == null) || (!paramHotChatInfo.isGameRoom)) {
        break label265;
      }
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 113;
      ((ProfileActivity.AllInOne)localObject).a = abao.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      HotChatManager.jdField_a_of_type_Boolean = false;
      paramMessageRecord = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      paramMessageRecord.putExtra("AllInOne", (Parcelable)localObject);
      if (paramHotChatInfo == null) {
        break label275;
      }
      bool = paramHotChatInfo.isGameRoom;
      label205:
      paramMessageRecord.putExtra("is_from_werewolves", bool);
      if (!paramBoolean) {
        break label281;
      }
    }
    label265:
    label275:
    label281:
    for (int i = 2;; i = 3)
    {
      paramMessageRecord.putExtra("param_mode", i);
      if ((!paramBoolean) || (paramHotChatInfo == null) || (!paramHotChatInfo.isGameRoom)) {
        break label287;
      }
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
      return true;
      i = 42;
      break;
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 31;
      break label130;
      bool = false;
      break label205;
    }
    label287:
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramMessageRecord);
    return true;
  }
  
  private void b(bguh parambguh, MessageRecord paramMessageRecord)
  {
    parambguh.a(2131371380, this.jdField_a_of_type_AndroidContentContext.getString(2131693848), 2130838935);
    this.d = true;
    bcsy localbcsy;
    String str;
    if (bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      localbcsy = new bcsy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
      str = paramMessageRecord.frienduin;
      if (!bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label131;
      }
    }
    label131:
    for (parambguh = "1";; parambguh = "2")
    {
      localbcsy.a(new String[] { str, parambguh }).a();
      return;
    }
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr)
  {
    Object localObject1 = null;
    if (njo.a(paramChatMessage)) {
      localObject1 = njo.a(paramChatMessage).jdField_b_of_type_JavaLangString;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidContentResColorStateList;
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!paramChatMessage.isMultiMsg) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        localObject2 = ColorStateList.valueOf(njo.jdField_d_of_type_Int);
      }
      for (;;)
      {
        boolean bool3 = false;
        boolean bool1 = bool3;
        if (paramChatMessage.istroop == 1)
        {
          bool1 = bool3;
          if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramChatMessage.frienduin) != null) {
            bool1 = HotChatManager.a(paramChatMessage);
          }
        }
        Object localObject3 = localObject1;
        if (paramChatMessage.msgtype == -3006) {
          localObject3 = tyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        }
        localObject1 = localObject3;
        if ((paramChatMessage instanceof MessageForStructing))
        {
          localObject1 = localObject3;
          if (bfrd.a(paramChatMessage)) {
            localObject1 = tyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          }
        }
        Object localObject5 = bfre.a(paramChatMessage);
        localObject3 = localObject2;
        Object localObject4;
        if (localObject5 != null)
        {
          localObject4 = ((bfrf)localObject5).jdField_c_of_type_JavaLangString;
          localObject1 = localObject4;
          localObject3 = localObject2;
          if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
          {
            localObject1 = localObject4;
            localObject3 = localObject2;
            if (!aqkl.a(paramChatMessage))
            {
              localObject3 = ColorStateList.valueOf(((bfrf)localObject5).jdField_b_of_type_Int);
              localObject1 = localObject4;
            }
          }
        }
        int i;
        if ((paramChatMessage.istroop == 1) && (!njo.a(paramChatMessage)))
        {
          localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          bool3 = ((HotChatManager)localObject2).b(paramChatMessage.frienduin);
          if (bool3)
          {
            localObject2 = ((HotChatManager)localObject2).a(paramChatMessage.frienduin);
            if ((!bool3) || (localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
              break label857;
            }
            i = 1;
            label345:
            if (i == 0) {
              break label1023;
            }
            localObject2 = ColorStateList.valueOf(-1);
            if (paramChatMessage.isSend()) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            }
          }
        }
        for (;;)
        {
          if (((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) == 1)
          {
            i = 1;
            label398:
            localObject3 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
            if (i == 0) {
              break label869;
            }
            localObject3 = ((audn)localObject3).jdField_d_of_type_JavaLangString;
            label428:
            if ((!paramChatMessage.isMultiMsg) || (njo.a(paramChatMessage))) {
              break label1020;
            }
            localObject4 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = awwm.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (TextUtils.getTrimmedLength((CharSequence)localObject1) != 0) {}
            }
            else
            {
              localObject4 = awwt.a(paramChatMessage.senderuin);
            }
            localObject1 = new bdnf((CharSequence)localObject4, 13).a();
          }
          label560:
          label582:
          label857:
          label869:
          label881:
          label1020:
          for (;;)
          {
            boolean bool4;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              if (paramChatMessage.istroop == 1)
              {
                localObject1 = paramChatMessage.senderuin;
                if ((localObject1 != null) || (bool2))
                {
                  bool3 = true;
                  if (((!bool2) || (!njo.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                    break label881;
                  }
                  bool4 = true;
                  paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool4, bool1, false, false, "", null, (String)localObject3);
                  localObject5 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                  localObject4 = (afwn)paramBaseChatItemLayout.getTag(2131364397);
                  localObject1 = localObject4;
                  if (localObject4 == null)
                  {
                    localObject1 = new afwn(this, null);
                    paramBaseChatItemLayout.setTag(2131364397, localObject1);
                  }
                  ((afwn)localObject1).jdField_a_of_type_Boolean = bool2;
                  ((afwn)localObject1).jdField_a_of_type_AndroidContentResColorStateList = ((ColorStateList)localObject2);
                  ((afwn)localObject1).jdField_b_of_type_Boolean = bool1;
                  ((afwn)localObject1).jdField_c_of_type_Boolean = false;
                  ((afwn)localObject1).jdField_a_of_type_JavaLangCharSequence = "";
                  ((afwn)localObject1).jdField_b_of_type_AndroidContentResColorStateList = null;
                  ((afwn)localObject1).d = false;
                  ((afwn)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
                  ((afwn)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
                  ((afwn)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                  ((afwn)localObject1).jdField_a_of_type_Afwr = paramafwr;
                  ((TroopManager)localObject5).a(paramChatMessage.frienduin, paramChatMessage.senderuin, (anwz)localObject1);
                }
              }
              else
              {
                bool1 = bfpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin);
                paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1, paramChatMessage.isSend());
                if (paramBaseChatItemLayout.f != null) {
                  paramBaseChatItemLayout.f.setOnClickListener(this);
                }
                if (paramBaseChatItemLayout.e != null)
                {
                  if (njo.a(paramChatMessage)) {
                    break label1009;
                  }
                  paramBaseChatItemLayout.e.setOnClickListener(this);
                  paramBaseChatItemLayout.e.setTag(Integer.valueOf(2131364396));
                }
              }
            }
            for (;;)
            {
              if ((AppSetting.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT >= 14)) {
                paramBaseChatItemLayout.e.setAccessibilityDelegate(new afwj(this));
              }
              return;
              localObject2 = null;
              break;
              i = 0;
              break label345;
              i = 0;
              break label398;
              localObject3 = null;
              break label428;
              bool3 = false;
              break label560;
              bool4 = false;
              break label582;
              if ((localObject1 != null) || (bool2))
              {
                bool3 = true;
                if (((!bool2) || (!njo.b(paramChatMessage))) && (!aqkl.c(paramChatMessage)) && (!paramChatMessage.isSend())) {
                  break label1003;
                }
              }
              for (bool2 = true;; bool2 = false)
              {
                paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool2, bool1, false, false, "", null, (String)localObject3);
                a(((CharSequence)localObject1).toString(), paramChatMessage, paramBaseChatItemLayout, paramafwr);
                if ((!paramChatMessage.isMultiMsg) || (njo.a(paramChatMessage))) {
                  break;
                }
                bgwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout.e, (Spannable)localObject1);
                break;
                bool3 = false;
                break label900;
              }
              paramBaseChatItemLayout.e.setOnClickListener(null);
            }
          }
          label900:
          label1003:
          label1009:
          label1023:
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private boolean b(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramMessageRecord.frienduin))) {}
    for (boolean bool = true; a(paramView, paramMessageRecord, bool); bool = false) {
      return true;
    }
    if (bool)
    {
      paramView = localHotChatManager.a(paramMessageRecord.frienduin);
      if ((paramView != null) && (paramView.isRobotHotChat))
      {
        bool = true;
        label96:
        if (a(paramMessageRecord, bool)) {
          break label153;
        }
        bool = paramMessageRecord.isSelf();
        if ((!bool) && ((localObject == null) || (((anmw)localObject).b(paramMessageRecord.senderuin)))) {
          break label155;
        }
      }
      label153:
      label155:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label160;
        }
        return a(paramMessageRecord, bool, paramView);
        bool = false;
        break label96;
        break;
      }
      label160:
      if ((paramView != null) && (paramView.isGameRoom))
      {
        localObject = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 42);
        ((ProfileActivity.AllInOne)localObject).jdField_c_of_type_JavaLangString = paramView.troopCode;
        ((ProfileActivity.AllInOne)localObject).jdField_d_of_type_JavaLangString = paramMessageRecord.frienduin;
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 113;
        ((ProfileActivity.AllInOne)localObject).a = abao.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
        HotChatManager.jdField_a_of_type_Boolean = false;
        return true;
      }
    }
    return false;
  }
  
  private final boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPoke)) {}
    while ((paramChatMessage instanceof MessageForPokeEmo)) {
      return true;
    }
    return false;
  }
  
  private boolean b(ChatMessage paramChatMessage, afwr paramafwr, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (aqjq.a(paramChatMessage))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849990;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label156;
        }
      }
      label156:
      for (int i = 2130849989;; i = 2130849813)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramafwr.jdField_a_of_type_Apwt = new apwt(0);
        a(paramafwr, paramBaseChatItemLayout, paramChatMessage, paramafwr.jdField_a_of_type_Apwt);
        a(paramafwr, paramChatMessage);
        b(paramafwr, paramChatMessage);
        return true;
        i = 2130849814;
        break;
      }
    }
    return false;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004);
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = awwm.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() != 0) {}
    }
    else
    {
      localObject2 = awwt.a(paramChatMessage.senderuin);
    }
    paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
    a((String)localObject2, paramChatMessage, paramBaseChatItemLayout, paramafwr);
  }
  
  private boolean c(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = bfre.a(paramMessageRecord);
    if (localObject != null)
    {
      a(paramMessageRecord, (bfrf)localObject);
      return true;
    }
    if (c(paramMessageRecord))
    {
      e(paramView);
      return true;
    }
    if (njo.a(paramMessageRecord))
    {
      localObject = njo.a(paramMessageRecord);
      if ((paramView == null) || ((((njp)localObject).jdField_a_of_type_JavaLangString == null) && (((njp)localObject).jdField_a_of_type_Int != 2))) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, "onHeadIconClick : an_id is null");
        }
        return true;
      }
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramMessageRecord.frienduin);
      anwd localanwd = (anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localTroopInfo != null)
      {
        localanwd.j(localTroopInfo.troopuin);
        localanwd.a(1, anie.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
      }
      a(paramView, paramMessageRecord, (njp)localObject, a(localTroopInfo));
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, paramMessageRecord.frienduin, "", "", "");
      return true;
    }
    if ("1000000".equals(paramMessageRecord.senderuin))
    {
      bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1");
      return true;
    }
    return false;
  }
  
  private boolean c(ChatMessage paramChatMessage, afwr paramafwr, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramChatMessage.istroop == 10007))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849990;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label169;
        }
      }
      label169:
      for (int i = 2130849989;; i = 2130849813)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramafwr.jdField_a_of_type_Apwt = new apwt(0);
        a(paramafwr, paramBaseChatItemLayout, paramChatMessage, paramafwr.jdField_a_of_type_Apwt);
        a(paramafwr, paramChatMessage);
        b(paramafwr, paramChatMessage);
        return true;
        i = 2130849814;
        break;
      }
    }
    return false;
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForStructing)) && (bfrd.a(paramMessageRecord));
  }
  
  private boolean d(ChatMessage paramChatMessage, afwr paramafwr, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (avsr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849990;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label159;
        }
      }
      label159:
      for (int i = 2130849989;; i = 2130849813)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramafwr.jdField_a_of_type_Apwt = new apwt(0);
        a(paramafwr, paramBaseChatItemLayout, paramChatMessage, paramafwr.jdField_a_of_type_Apwt);
        a(paramafwr, paramChatMessage);
        b(paramafwr, paramChatMessage);
        return true;
        i = 2130849814;
        break;
      }
    }
    return false;
  }
  
  private boolean d(MessageRecord paramMessageRecord)
  {
    if ((bgjw.b(paramMessageRecord.senderuin)) && (bgjw.a(this.jdField_a_of_type_AndroidContentContext))) {
      return true;
    }
    if (bfpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        bfpx.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "openRobotProfileCard, robotuin:" + paramMessageRecord.senderuin + " frienduin:" + paramMessageRecord.frienduin);
        }
        return true;
        bfpx.a(this.jdField_a_of_type_AndroidContentContext, null, paramMessageRecord.senderuin);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString))) {
      return true;
    }
    if ("10000".equals(paramMessageRecord.senderuin)) {
      return true;
    }
    if ((paramMessageRecord.istroop == 3000) && (bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForTroopConfess);
  }
  
  private void e(View paramView)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.associatePubAccount != 0L))
    {
      Intent localIntent = new Intent(paramView.getContext(), AccountDetailActivity.class);
      localIntent.putExtra("uin", localTroopInfo.associatePubAccount + "");
      paramView.getContext().startActivity(localIntent);
    }
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localHotChatInfo == null) || (localHotChatInfo.isGameRoom)) {
      return;
    }
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin)) {
      if (paramChatMessage.senderuin.equals(localHotChatInfo.ownerUin))
      {
        paramChatMessage = anni.a(2131699748);
        i = 0;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a(paramChatMessage, i);
      return;
      if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
      {
        paramChatMessage = anni.a(2131699750);
        i = 1;
      }
      else if ((localHotChatInfo.isRobotHotChat) && (((bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).b(paramChatMessage.senderuin)))
      {
        paramChatMessage = anni.a(2131699756);
        i = 0;
      }
      else
      {
        i = 0;
        paramChatMessage = null;
      }
    }
  }
  
  private boolean e(ChatMessage paramChatMessage, afwr paramafwr, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      if (paramChatMessage.istroop == 1) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject = paramafwr.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838207);
        paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
        paramafwr.jdField_a_of_type_Apwt = new apwt(0);
        a(paramafwr, paramBaseChatItemLayout, paramChatMessage, paramafwr.jdField_a_of_type_Apwt);
        a(paramafwr, paramChatMessage);
        b(paramafwr, paramChatMessage);
        return true;
        if (paramChatMessage.istroop == 3000) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 2, 0, "", "", "", "");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramChatMessage.isShowQIMStyleGroup = ahvz.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (paramChatMessage.isShowQIMStyleGroup)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 3, 0, "", "", "", "");
        boolean bool;
        int i;
        Drawable localDrawable1;
        label306:
        Drawable localDrawable2;
        if ((!(this instanceof ahkf)) || ((this instanceof ahkp)))
        {
          bool = paramChatMessage.isSend();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)
          {
            localObject = paramafwr.jdField_a_of_type_AndroidViewView.getResources();
            if (bool)
            {
              i = 2130849990;
              localDrawable1 = ((Resources)localObject).getDrawable(i);
              localObject = paramafwr.jdField_a_of_type_AndroidViewView.getResources();
              if (!bool) {
                break label410;
              }
              i = 2130849989;
              localDrawable2 = ((Resources)localObject).getDrawable(i);
              localObject = new StateListDrawable();
              ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
              ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            }
          }
        }
        for (;;)
        {
          paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          paramafwr.jdField_a_of_type_Apwt = new apwt(0);
          a(paramafwr, paramBaseChatItemLayout, paramChatMessage, paramafwr.jdField_a_of_type_Apwt);
          a(paramafwr, paramChatMessage);
          b(paramafwr, paramChatMessage);
          return true;
          i = 2130849814;
          break;
          label410:
          i = 2130849813;
          break label306;
          localObject = SkinEngine.getInstances();
          if (bool)
          {
            i = 2130849990;
            label433:
            localDrawable1 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = SkinEngine.getInstances();
            if (!bool) {
              break label518;
            }
          }
          label518:
          for (i = 2130849989;; i = 2130849813)
          {
            localDrawable2 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = new StateListDrawable();
            ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
            ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            break;
            i = 2130849814;
            break label433;
          }
          if (!paramChatMessage.isSend()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label565;
            }
            localObject = paramafwr.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838206);
            break;
          }
          label565:
          localObject = paramafwr.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838207);
        }
      }
    }
    return false;
  }
  
  private boolean e(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if (localObject != null) {}
    for (localObject = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if (localObject != null)
      {
        if (!((HotChatInfo)localObject).isGameRoom) {
          break;
        }
        bool = true;
      }
      return bool;
    }
    if (a(paramMessageRecord, ((HotChatInfo)localObject).isRobotHotChat)) {
      return true;
    }
    localObject = paramMessageRecord.senderuin;
    paramMessageRecord = axeg.a((String)localObject);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject)) {}
    for (paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramMessageRecord;; paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747")
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject)) {}
      for (localObject = "2";; localObject = "1")
      {
        bcst.b(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject, "", "", "");
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramMessageRecord);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
    }
  }
  
  private void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool2 = false;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      bool1 = true;
      if (!bool1) {
        break label535;
      }
    }
    label523:
    label529:
    label535:
    for (int j = njo.jdField_e_of_type_Int;; j = -1)
    {
      int k;
      njp localnjp;
      int i;
      if (njo.a(paramChatMessage))
      {
        k = beui.a().jdField_a_of_type_Int;
        localnjp = njo.a(paramChatMessage);
        i = k;
      }
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(localnjp.jdField_c_of_type_JavaLangString)) {
            i = Color.parseColor(localnjp.jdField_c_of_type_JavaLangString);
          }
          if ((!bfnl.a(paramChatMessage.frienduin)) || (njo.b(paramChatMessage))) {
            break label529;
          }
          bool1 = bool2;
          paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689986), njo.b(paramChatMessage), i, j);
          if (paramBaseChatItemLayout.c != null) {
            paramBaseChatItemLayout.c.setOnClickListener(null);
          }
          return;
          bool1 = false;
        }
        catch (Exception localException)
        {
          i = k;
          continue;
        }
        if ("1000000".equals(paramChatMessage.senderuin))
        {
          this.jdField_f_of_type_Boolean = false;
          paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
          return;
        }
        if ((paramChatMessage instanceof MessageForTroopConfess))
        {
          paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
          return;
        }
        Object localObject = bfre.a(paramChatMessage);
        if (localObject != null)
        {
          j = ((bfrf)localObject).jdField_c_of_type_Int;
          i = ((bfrf)localObject).jdField_d_of_type_Int;
          if (bool1)
          {
            j = njo.jdField_e_of_type_Int;
            i = beui.a().jdField_a_of_type_Int;
          }
          if (!bfnl.a(paramChatMessage.frienduin)) {
            break label523;
          }
        }
        for (bool1 = false;; bool1 = true)
        {
          paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1, ((bfrf)localObject).jdField_d_of_type_JavaLangString, false, i, j);
          if (paramBaseChatItemLayout.c == null) {
            break;
          }
          paramBaseChatItemLayout.c.setOnClickListener(this);
          paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131364417));
          return;
          if (paramChatMessage.istroop != 1) {
            break;
          }
          paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
          this.jdField_f_of_type_Boolean = false;
          if (localTroopManager == null) {
            break;
          }
          TroopInfo localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
          localObject = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
          if ((localTroopInfo == null) || ((localTroopInfo.cGroupRankSysFlag != 1) && (!((bftx)localObject).b(paramChatMessage.senderuin)) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop()))) {
            break;
          }
          afwm localafwm = (afwm)paramBaseChatItemLayout.getTag(2131364417);
          localObject = localafwm;
          if (localafwm == null)
          {
            localObject = new afwm(this, null);
            paramBaseChatItemLayout.setTag(2131364417, localObject);
          }
          ((afwm)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
          ((afwm)localObject).jdField_a_of_type_Boolean = bool1;
          ((afwm)localObject).jdField_a_of_type_Int = j;
          ((afwm)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
          localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (anwz)localObject);
          return;
        }
        bool1 = true;
      }
    }
  }
  
  private boolean f(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = bfre.a(paramMessageRecord);
    if (localObject != null)
    {
      bfre.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bfrf)localObject);
      localObject = ((bfrf)localObject).jdField_c_of_type_JavaLangString;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, paramMessageRecord.frienduin, "", (String)localObject, "");
      if (paramMessageRecord.msgtype != -2051) {}
    }
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_name", paramMessageRecord, false);
      bool = true;
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
        }
      }
    }
  }
  
  private void g(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((njo.a(paramChatMessage)) || ("1000000".equals(paramChatMessage.senderuin)) || ((paramChatMessage instanceof MessageForTroopConfess))) {
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setOnClickListener(null);
      }
    }
    label336:
    label340:
    for (;;)
    {
      return;
      if (bfre.a(paramChatMessage) != null)
      {
        if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView != null)
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setOnClickListener(null);
        }
      }
      else if (paramChatMessage.istroop == 1)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localTroopManager != null)
        {
          TroopInfo localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
          Object localObject = (bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
          if ((localTroopInfo != null) && (!((bftx)localObject).b(paramChatMessage.senderuin)))
          {
            boolean bool = bfnl.a(paramChatMessage.frienduin);
            int i;
            if ((localTroopInfo.cGroupRankUserFlag == 1) || (localTroopInfo.cNewGroupRankUserFlag == 0))
            {
              i = 1;
              if ((i != 0) || ((!localTroopInfo.isTroopOwner(paramChatMessage.senderuin)) && (!localTroopInfo.isTroopAdmin(paramChatMessage.senderuin)))) {
                break label336;
              }
            }
            for (int j = 1;; j = 0)
            {
              if ((!bool) || ((i == 0) && (j == 0) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop()))) {
                break label340;
              }
              afwp localafwp = (afwp)paramBaseChatItemLayout.getTag(2131364418);
              localObject = localafwp;
              if (localafwp == null)
              {
                localObject = new afwp(this, null);
                paramBaseChatItemLayout.setTag(2131364418, localObject);
              }
              ((afwp)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
              ((afwp)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
              ((afwp)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
              localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (anwz)localObject);
              return;
              i = 0;
              break;
            }
          }
        }
      }
    }
  }
  
  private boolean g(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1))
    {
      paramMessageRecord = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      TroopInfo localTroopInfo = paramMessageRecord.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localTroopInfo != null) && (localTroopInfo.isQidianPrivateTroop())) {
        return true;
      }
      if (paramMessageRecord.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  private void h(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramChatMessage.frienduin);
    if (localObject != null)
    {
      bool = ((HotChatInfo)localObject).isGameRoom;
      if (!bool) {
        break label104;
      }
      localObject = ((bhte)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((bhtu)localObject).a(paramChatMessage.senderuin);
        if (TextUtils.isEmpty(paramChatMessage)) {
          break label93;
        }
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramChatMessage);
      }
    }
    label93:
    label104:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, paramChatMessage);
        return;
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      } while (localObject == null);
      paramChatMessage = ((TroopManager)localObject).b(paramChatMessage.frienduin, paramChatMessage.senderuin);
    } while (paramChatMessage == null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramChatMessage.hotChatGlamourLevel >= 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.a((QQAppInterface)localObject, bool, paramChatMessage.hotChatGlamourLevel, false);
      if (paramBaseChatItemLayout.d == null) {
        break;
      }
      paramBaseChatItemLayout.d.setOnClickListener(this);
      paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131364415));
      return;
    }
  }
  
  private boolean h(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    return (i == 0) || (i == 1) || (i == 3000) || (i == 1000) || (i == 1004);
  }
  
  public int a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null)
          {
            int i = ((BaseChatPie)localObject).h();
            return i;
          }
        }
      }
    }
    catch (Exception localException)
    {
      return -1;
    }
    return -1;
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public afwq a(View paramView)
  {
    return null;
  }
  
  protected abstract afwr a();
  
  protected Drawable a(BaseChatItemLayout paramBaseChatItemLayout, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Aobu == null) {
      return null;
    }
    afwr localafwr = (afwr)paramBaseChatItemLayout.getTag();
    if (localafwr != null)
    {
      localafwr.jdField_a_of_type_JavaLangString = paramString;
      localafwr.jdField_d_of_type_Int = paramInt;
      paramBaseChatItemLayout.setTag(localafwr);
    }
    paramBaseChatItemLayout = this.jdField_a_of_type_Aobu.b(paramInt, paramString, 6);
    if (paramBaseChatItemLayout == null)
    {
      if (!this.jdField_a_of_type_Aobu.a()) {
        this.jdField_a_of_type_Aobu.a(paramString, paramInt, true);
      }
      return bgmo.b();
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBaseChatItemLayout);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1 + ", msgseq = " + paramChatMessage.msgseq + ", shmsgseq = " + paramChatMessage.shmsgseq);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramView = (BaseChatItemLayout)paramView;
      bool = AppSetting.jdField_c_of_type_Boolean;
      if (paramView == null)
      {
        paramView = new BaseChatItemLayout(localContext);
        paramView.setId(2131363300);
        paramView.setFocusableInTouchMode(true);
        localObject1 = a();
        paramView.setTag(localObject1);
        ((afwr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
        if (!bool) {
          break label1350;
        }
        ((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, BaseChatItemLayout.w);
        if ((bool) && (((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder == null)) {
          ((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        ((afwr)localObject1).jdField_b_of_type_Int = paramInt1;
        ((afwr)localObject1).jdField_c_of_type_Int = paramInt2;
        localObject2 = null;
        localObject3 = localObject2;
        if (bool)
        {
          paramView.setContentDescription(null);
          if (!TextUtils.isEmpty(((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder)) {
            ((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder.replace(0, ((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder.length(), "");
          }
          localObject3 = localObject2;
          if (paramChatMessage.mNeedTimeStamp)
          {
            localObject3 = localObject2;
            if (paramChatMessage.time <= 0L) {}
          }
        }
      }
    }
    catch (Exception paramView)
    {
      label1350:
      for (;;)
      {
        try
        {
          boolean bool;
          Object localObject2 = bgsu.a(localContext, 3, paramChatMessage.time * 1000L);
          ((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder.append(" ").append((CharSequence)localObject2).append(" ");
          Object localObject3 = localObject2;
          ((afwr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          if (paramChatMessage.isSend())
          {
            i = 1;
            paramView.setHearIconPosition(i);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa != null)
            {
              ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Afxa.jdField_a_of_type_AndroidContentResColorStateList;
              localObject2 = localColorStateList;
              if (!this.jdField_c_of_type_Boolean)
              {
                localObject2 = localColorStateList;
                if (!this.jdField_b_of_type_Boolean)
                {
                  localObject2 = localColorStateList;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
                  {
                    localObject2 = localColorStateList;
                    if (njo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                      localObject2 = ColorStateList.valueOf(njo.jdField_d_of_type_Int);
                    }
                  }
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
                localObject2 = ColorStateList.valueOf(njo.jdField_d_of_type_Int);
              }
              paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage, (ColorStateList)localObject2, localObject3);
            }
            if (!bfrd.a(paramChatMessage)) {
              continue;
            }
            paramView.setGrayTipsText(true, paramChatMessage, localContext.getString(2131695725), this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165430), 0);
            a(paramInt1, paramChatMessage, paramView, paramViewGroup);
            a(paramChatMessage, paramView);
            paramView.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            a(paramChatMessage, paramView, paramInt1, paramInt2);
            if (paramChatMessage.fakeSenderType != 1) {
              continue;
            }
            paramView.a(false, null, null, false, false, false, false, "", null, null);
            if (paramView.jdField_b_of_type_ComTencentImageURLImageView != null) {
              paramView.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
            }
            if (!b(paramChatMessage, paramView)) {
              continue;
            }
            paramView.setProgressVisable(false);
            paramView.setNetIconVisible(false);
            ((afwr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(null);
            paramViewGroup = a(paramChatMessage, (afwr)localObject1, ((afwr)localObject1).jdField_a_of_type_AndroidViewView, paramView, paramafzq);
            ((afwr)localObject1).jdField_a_of_type_AndroidViewView = paramViewGroup;
            a(paramViewGroup, paramView);
            a(paramChatMessage, localContext, paramView, (afwr)localObject1, paramInt1, paramInt2);
            if (bool)
            {
              ((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
              paramafzq = Spannable.Factory.getInstance().newSpannable(((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder.toString());
              if (!Linkify.addLinks(paramafzq, 15)) {
                continue;
              }
              paramView.setContentDescription(paramafzq);
              paramView.setFocusable(true);
            }
            ((afwr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b();
            bgso.a(null, "AIO_Handle_Sticker_Cost");
            long l = System.currentTimeMillis();
            a(localContext, paramViewGroup, paramChatMessage, paramView, (afwr)localObject1);
            bgso.a("AIO_Handle_Sticker_Cost", null);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleStickers time cost : " + (System.currentTimeMillis() - l) + " ms");
            }
            if ((!paramChatMessage.mMsgAnimFlag) || (paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null) || (b(paramChatMessage))) {
              continue;
            }
            paramChatMessage.mMsgAnimFlag = false;
            paramInt2 = afur.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramInt1 = paramInt2;
            if (!paramChatMessage.isSend()) {
              paramInt1 = paramInt2 * -1;
            }
            paramView.a(paramChatMessage, paramInt1, 0.0F, 0.0F, 1.0F, this);
            paramView.a(localContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter);
            paramView.requestLayout();
            return paramView;
            paramView = paramView;
            localObject1 = "";
            paramView = (View)localObject1;
            if (localContext != null)
            {
              paramView = (View)localObject1;
              if ((localContext instanceof Activity)) {
                paramView = localContext.getClass().getName();
              }
            }
            QLog.e("BaseBubbleBuilder", 1, paramView + " baseBubbleBuilderCatchedException " + paramChatMessage.msgtype);
            paramView = null;
            continue;
            localObject2 = (afwr)paramView.getTag();
            localObject1 = localObject2;
            if (!a((afwr)localObject2))
            {
              QLog.e("BubbleView", 1, "getView checkHolderTypeOk failed holder :" + localObject2 + "  this:" + this);
              localObject2 = a();
              paramView.setTag(localObject2);
              ((afwr)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
              localObject1 = localObject2;
              if (bool)
              {
                ((afwr)localObject2).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
                localObject1 = localObject2;
              }
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          String str = "";
          continue;
          int i = 0;
          continue;
          paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165430), 235);
          continue;
          if (paramChatMessage.fakeSenderType == 2)
          {
            if (njo.a(paramChatMessage)) {
              b(paramChatMessage, paramView, (afwr)localObject1);
            } else {
              c(paramChatMessage, paramView, (afwr)localObject1);
            }
          }
          else if (((paramChatMessage.istroop == 0) || (paramChatMessage.istroop == 3000)) && (paramChatMessage.isMultiMsg))
          {
            c(paramChatMessage, paramView, (afwr)localObject1);
          }
          else if (paramChatMessage.istroop == 1)
          {
            paramViewGroup = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
            if ((paramViewGroup != null) && (paramViewGroup.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              e(paramChatMessage, paramView);
              h(paramChatMessage, paramView);
              b(paramChatMessage, paramView, (afwr)localObject1);
              b(paramChatMessage, paramView);
            }
            else
            {
              f(paramChatMessage, paramView);
              b(paramChatMessage, paramView, (afwr)localObject1);
              b(paramChatMessage, paramView);
              g(paramChatMessage, paramView);
            }
          }
          else
          {
            a(paramChatMessage, paramView, (afwr)localObject1);
            continue;
            c(paramChatMessage, paramView);
            continue;
            paramView.setContentDescription(((afwr)localObject1).jdField_b_of_type_JavaLangStringBuilder.toString());
            continue;
            paramView.a(paramChatMessage);
          }
        }
      }
    }
  }
  
  protected abstract View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq);
  
  protected abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    bgno.a().a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131376379: 
      b(paramChatMessage);
      return;
    case 2131362462: 
      f(paramChatMessage);
      return;
    case 2131376394: 
      c(paramChatMessage);
      return;
    }
    e(paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    if (!awwt.a(paramChatMessage)) {}
    for (int i = 1;; i = 0)
    {
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      int j = i;
      if (localAIOLongShotHelper != null)
      {
        j = i;
        if (localAIOLongShotHelper.a()) {
          j = 1;
        }
      }
      if (j != 0) {
        paramBaseChatItemLayout.setCheckBox(paramInt, paramChatMessage, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramViewGroup);
      }
      return;
    }
  }
  
  protected void a(afwr paramafwr, View paramView, ChatMessage paramChatMessage, apwt paramapwt) {}
  
  protected void a(afwr paramafwr, ChatMessage paramChatMessage) {}
  
  protected void a(View paramView) {}
  
  public void a(View paramView, afzq paramafzq)
  {
    if (bgjk.a(false))
    {
      bgjn localbgjn = new bgjn();
      bgjk.a(this.jdField_a_of_type_AndroidContentContext, localbgjn, paramafzq);
      paramView.setOnTouchListener(localbgjn);
      paramView.setOnLongClickListener(localbgjn);
      return;
    }
    paramView.setOnTouchListener(paramafzq);
    paramView.setOnLongClickListener(paramafzq);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.jdField_h_of_type_Int;
    int i = j;
    if (bcye.a(paramChatMessage)) {
      i = j - afur.a(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, i, BaseChatItemLayout.j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.j, i, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    c(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, apwt paramapwt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) || (paramapwt == null)) {
      return;
    }
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject3 = null;
    apwq localapwq = null;
    Pair localPair = null;
    BubbleManager localBubbleManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    Object localObject2;
    label63:
    Object localObject1;
    if (bdol.a(paramChatMessage.msg))
    {
      localObject2 = bdol.b(paramChatMessage.msg);
      if ((localBubbleManager == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label886;
      }
      localObject1 = localBubbleManager.a(paramapwt.jdField_a_of_type_Int, false);
      if ((localObject1 == null) || (((apwq)localObject1).b == null) || (!((apwq)localObject1).a((String)localObject2))) {
        break label886;
      }
    }
    label384:
    label856:
    label862:
    label868:
    label875:
    label886:
    for (int i = 1;; i = 0)
    {
      localObject1 = localapwq;
      int j = k;
      Object localObject4;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject4 = paramapwt.a((String)localObject2);
        localObject1 = localapwq;
        localObject3 = localObject4;
        j = k;
        if (localObject4 != null)
        {
          localObject1 = paramapwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          if ((localObject1 == null) || (((Pair)localObject1).first == null)) {
            break label875;
          }
          j = 1;
          localObject3 = localObject4;
        }
      }
      for (;;)
      {
        k = m;
        if ((paramChatMessage instanceof MessageForText))
        {
          localPair = paramapwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
          if ((localPair == null) || (localPair.first == null)) {
            break label868;
          }
        }
        for (k = 1;; k = m)
        {
          m = n;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            m = n;
            if ((paramChatMessage instanceof MessageForText))
            {
              m = n;
              if (VersionUtils.isHoneycomb())
              {
                localObject2 = paramapwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
                m = n;
                if (localObject2 != null)
                {
                  m = n;
                  if (((Pair)localObject2).first != null)
                  {
                    m = n;
                    if (paramView.getWidth() > ((apwu)((Pair)localObject2).first).a.j) {
                      m = 1;
                    }
                  }
                }
              }
            }
          }
          if ((localBubbleManager != null) && ((paramChatMessage instanceof MessageForText)))
          {
            localapwq = localBubbleManager.a(paramapwt.jdField_a_of_type_Int, false);
            if ((localapwq != null) && (localapwq.f != null) && (localapwq.f.k != 0) && (VersionUtils.isHoneycomb())) {
              if (paramChatMessage.isSend())
              {
                localObject2 = paramChatMessage.selfuin;
                localObject4 = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (localObject4 == null) {
                  break label862;
                }
                localObject2 = ((anmw)localObject4).a((String)localObject2);
                if ((localObject2 == null) || ((localapwq.f.k != -1) && (((ExtensionInfo)localObject2).pendantId != localapwq.f.k))) {
                  break label862;
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (i != 0)
            {
              long l = apwv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              if (l != -1L) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
              }
            }
            if ((j != 0) || (m != 0) || (n != 0) || (k != 0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
            }
            if (j != 0)
            {
              a("keyword_trigger", paramapwt.jdField_a_of_type_Int, localObject3);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject1 });
            }
            if (k != 0) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(6), Long.valueOf(paramChatMessage.uniseq), localPair });
            }
            if ((m != 0) || (n != 0)) {
              if (m == 0) {
                break label856;
              }
            }
            for (i = 3;; i = 5)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramapwt.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
              if (!paramapwt.a(paramView.getHeight())) {
                break;
              }
              paramView = paramapwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
              if ((paramView == null) || (paramView.first == null)) {
                break;
              }
              a("wordnum_trigger", paramapwt.jdField_a_of_type_Int, null);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
              return;
              localObject2 = paramChatMessage.msg;
              break label63;
              if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
              {
                localObject2 = paramChatMessage.frienduin;
                break label384;
              }
              localObject2 = paramChatMessage.senderuin;
              break label384;
            }
          }
        }
        localObject3 = localObject4;
        j = k;
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, apwt paramapwt, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {}
    do
    {
      return;
      paramView = paramapwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    } while ((paramView == null) || (paramView.first == null));
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  protected void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (!bfqc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramMessageRecord = ((bfqc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord);
      if ((paramMessageRecord != null) && (paramMessageRecord.jdField_b_of_type_Int != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new bfqe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), paramMessageRecord.jdField_c_of_type_Int, paramMessageRecord.jdField_d_of_type_Int, 17);
        paramTextView.setTag(2131366734, "school_troop_span");
      }
    } while (!QLog.isColorLevel());
    QLog.i("school_troop.BaseBubbleBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
  }
  
  public void a(aobu paramaobu)
  {
    this.jdField_a_of_type_Aobu = paramaobu;
  }
  
  protected void a(bguh parambguh, int paramInt, MessageRecord paramMessageRecord)
  {
    if (!a(paramMessageRecord)) {}
    do
    {
      return;
      if ((!paramMessageRecord.isSend()) && (!bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        this.d = false;
        return;
      }
      if ((njo.a(paramMessageRecord)) && (!aqud.a().jdField_a_of_type_Boolean))
      {
        this.d = false;
        return;
      }
      if (acwh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1032)
      {
        this.d = false;
        return;
      }
      Object localObject = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!((anmw)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        this.d = false;
        return;
      }
      if (paramInt == 1)
      {
        localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localObject != null) && (((HotChatManager)localObject).b(paramMessageRecord.frienduin)))
        {
          this.d = false;
          return;
        }
      }
      if ((paramMessageRecord.msgtype == -5008) && ((paramMessageRecord instanceof MessageForArkApp)))
      {
        localObject = (MessageForArkApp)paramMessageRecord;
        if ((((MessageForArkApp)localObject).ark_app_message != null) && (((MessageForArkApp)localObject).ark_app_message.appName.equals("com.tencent.mannounce")))
        {
          this.d = false;
          return;
        }
      }
    } while (!h(paramMessageRecord));
    b(parambguh, paramMessageRecord);
  }
  
  protected void a(bguh parambguh, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (parambguh != null) && (paramContext != null) && (aini.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
      a(parambguh, paramContext, paramChatMessage, false);
    }
  }
  
  protected void a(bguh parambguh, Context paramContext, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    int j;
    int i;
    if ((paramChatMessage != null) && (parambguh != null) && (paramContext != null) && (aini.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
    {
      j = parambguh.a();
      if (!paramBoolean) {
        break label97;
      }
      paramChatMessage = parambguh.a();
      i = 0;
      if (i >= paramChatMessage.length) {
        break label97;
      }
      if (paramChatMessage[i].a() != 2131366271) {
        break label88;
      }
      i += 1;
    }
    for (;;)
    {
      parambguh.a(2131380261, paramContext.getString(2131690775), 0, i);
      return;
      label88:
      i += 1;
      break;
      label97:
      i = j;
    }
  }
  
  public void a(bguh parambguh, MessageRecord paramMessageRecord)
  {
    if ((!this.d) || ((paramMessageRecord != null) && (!paramMessageRecord.isSend()))) {
      adrm.a(parambguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    this.d = false;
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    int j;
    int i;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      BaseChatPie localBaseChatPie = null;
      if (localChatFragment != null) {
        localBaseChatPie = localChatFragment.a();
      }
      if (localBaseChatPie != null) {
        ((agki)localBaseChatPie.a(46)).a(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label170;
      }
      j = 6;
      i = 4;
    }
    for (;;)
    {
      if (njo.a(paramChatMessage)) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ADF4", "0X800ADF4", 0, 1, "" + i, "", "", "");
      }
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + j, "", "", "");
      return;
      label170:
      if ((paramChatMessage instanceof MessageForText))
      {
        j = 1;
        i = 1;
      }
      else if ((paramChatMessage instanceof MessageForPic))
      {
        j = 3;
        i = 2;
      }
      else if ((paramChatMessage instanceof MessageForMarketFace))
      {
        j = 4;
        i = 5;
      }
      else if ((paramChatMessage instanceof MessageForApollo))
      {
        j = 5;
        i = 5;
      }
      else if ((paramChatMessage instanceof MessageForVideo))
      {
        j = 0;
        i = 4;
      }
      else
      {
        j = 0;
        i = 5;
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) || ((paramContext instanceof MultiForwardActivity))) {}
    for (boolean bool = false;; bool = true) {
      try
      {
        i = a(paramChatMessage);
        paramafwr.jdField_a_of_type_Int = i;
        if (i != 0) {
          if (a(paramChatMessage, paramafwr, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setSimpleUIMsgBubble " + paramChatMessage.getLogColorContent());
            }
            if (paramafwr.jdField_a_of_type_AndroidViewView != null)
            {
              paramBaseChatItemLayout.setBubbleView(paramafwr.jdField_a_of_type_AndroidViewView);
              a(paramafwr.jdField_a_of_type_AndroidViewView, paramChatMessage);
              paramafwr.jdField_a_of_type_AndroidViewView.setTag(2131363971, paramafwr.jdField_a_of_type_Apwt);
              paramafwr.jdField_a_of_type_AndroidViewView.setTag(2131364423, paramChatMessage);
            }
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ChatItemBuilder", 1, "getBubbleType error : " + localException);
          int i = 0;
          continue;
          if (b(paramChatMessage, paramafwr, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setConfessMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (e(paramChatMessage, paramafwr, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setQimMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (d(paramChatMessage, paramafwr, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setLimitChatMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (c(paramChatMessage, paramafwr, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setGameMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else
          {
            a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafwr, paramInt1, paramInt2, bool, i);
            continue;
            if (paramafwr.jdField_a_of_type_AndroidViewView == null)
            {
              QLog.e("ChatItemBuilder", 1, "handleBubbleBg mContent is null type = " + paramChatMessage.istroop);
              return;
            }
            paramafwr.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, bguh parambguh)
  {
    if ((paramChatMessage == null) || (paramChatMessage.shmsgseq == 0L)) {}
    do
    {
      do
      {
        return;
      } while ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0));
      if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) && (paramChatMessage.isSupportReply()))
      {
        parambguh.a(2131376379, this.jdField_a_of_type_AndroidContentContext.getString(2131696967), 2130838933);
        MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
    parambguh.a(2131376379, this.jdField_a_of_type_AndroidContentContext.getString(2131696967), 2130838933);
    MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
  }
  
  /* Error */
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 789	aqjq:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   4: ifeq +52 -> 56
    //   7: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +46 -> 56
    //   13: ldc_w 542
    //   16: iconst_2
    //   17: new 176	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   24: ldc_w 2285
    //   27: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   34: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: ldc_w 2287
    //   40: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 764	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   47: invokevirtual 2290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 1004	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_1
    //   57: getfield 260	com/tencent/mobileqq/data/ChatMessage:fakeSenderType	I
    //   60: iconst_1
    //   61: if_icmpne +51 -> 112
    //   64: aload_0
    //   65: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: astore 6
    //   73: aload_2
    //   74: aload_0
    //   75: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: iconst_1
    //   79: aload 6
    //   81: invokestatic 2295	aoch:a	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;)Laoch;
    //   84: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   87: aload_2
    //   88: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   91: aload_1
    //   92: invokevirtual 2299	com/tencent/mobileqq/vas/avatar/VasAvatar:setTag	(Ljava/lang/Object;)V
    //   95: aload_2
    //   96: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   99: aconst_null
    //   100: invokevirtual 2300	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   103: aload_2
    //   104: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   107: aconst_null
    //   108: invokevirtual 2301	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   111: return
    //   112: aload_1
    //   113: invokestatic 2302	aqjq:a	(Lcom/tencent/mobileqq/data/ChatMessage;)Z
    //   116: ifeq +92 -> 208
    //   119: aload_0
    //   120: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   123: sipush 269
    //   126: invokevirtual 317	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   129: checkcast 2304	aqjm
    //   132: invokevirtual 2307	aqjm:a	()Laqjh;
    //   135: aload_1
    //   136: getfield 910	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   139: aload_1
    //   140: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   143: aload_1
    //   144: invokevirtual 2310	com/tencent/mobileqq/data/ChatMessage:getConfessTopicId	()I
    //   147: invokevirtual 2315	aqjh:a	(Ljava/lang/String;II)Lcom/tencent/mobileqq/confess/ConfessInfo;
    //   150: getfield 2320	com/tencent/mobileqq/confess/ConfessInfo:confessorSex	I
    //   153: iconst_1
    //   154: if_icmpne +47 -> 201
    //   157: ldc_w 2321
    //   160: istore_3
    //   161: aload_2
    //   162: aload_0
    //   163: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   166: invokevirtual 126	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   169: iload_3
    //   170: invokevirtual 1223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   173: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   176: aload_2
    //   177: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   180: aload_1
    //   181: invokevirtual 2299	com/tencent/mobileqq/vas/avatar/VasAvatar:setTag	(Ljava/lang/Object;)V
    //   184: aload_2
    //   185: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   188: aconst_null
    //   189: invokevirtual 2300	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   192: aload_2
    //   193: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   196: aconst_null
    //   197: invokevirtual 2301	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   200: return
    //   201: ldc_w 2322
    //   204: istore_3
    //   205: goto -44 -> 161
    //   208: aload_1
    //   209: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   212: sipush 10007
    //   215: if_icmpne +170 -> 385
    //   218: aload_1
    //   219: invokevirtual 764	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   222: ifeq +135 -> 357
    //   225: aload_1
    //   226: invokestatic 2325	autg:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   229: astore 6
    //   231: aload_0
    //   232: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   235: aload_0
    //   236: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   239: aload 6
    //   241: invokestatic 2330	autf:a	(Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lcom/tencent/image/URLDrawable;
    //   244: astore 6
    //   246: aload 6
    //   248: ifnonnull +118 -> 366
    //   251: aload_2
    //   252: aload_0
    //   253: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   256: invokevirtual 126	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   259: ldc_w 2331
    //   262: invokevirtual 1223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   265: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   268: aload_0
    //   269: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   272: instanceof 1686
    //   275: ifeq +1605 -> 1880
    //   278: aload_0
    //   279: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   282: checkcast 1686	android/support/v4/app/FragmentActivity
    //   285: invokevirtual 1690	android/support/v4/app/FragmentActivity:getChatFragment	()Lcom/tencent/mobileqq/activity/ChatFragment;
    //   288: astore 6
    //   290: aload 6
    //   292: ifnull +1588 -> 1880
    //   295: aload 6
    //   297: invokevirtual 1695	com/tencent/mobileqq/activity/ChatFragment:a	()Lcom/tencent/mobileqq/activity/BaseChatPie;
    //   300: astore 6
    //   302: aload 6
    //   304: instanceof 2333
    //   307: ifeq +1573 -> 1880
    //   310: aload 6
    //   312: checkcast 2333	aias
    //   315: astore 6
    //   317: aload_1
    //   318: invokevirtual 764	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   321: ifeq +54 -> 375
    //   324: aload 6
    //   326: invokevirtual 2336	aias:a	()Laiax;
    //   329: astore 6
    //   331: aload_2
    //   332: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   335: aload 6
    //   337: invokevirtual 2300	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   340: aload_2
    //   341: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   344: aconst_null
    //   345: invokevirtual 2301	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   348: aload_2
    //   349: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   352: aload_1
    //   353: invokevirtual 2299	com/tencent/mobileqq/vas/avatar/VasAvatar:setTag	(Ljava/lang/Object;)V
    //   356: return
    //   357: aload_1
    //   358: invokestatic 2338	autg:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   361: astore 6
    //   363: goto -132 -> 231
    //   366: aload_2
    //   367: aload 6
    //   369: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   372: goto -104 -> 268
    //   375: aload 6
    //   377: invokevirtual 2340	aias:b	()Laiax;
    //   380: astore 6
    //   382: goto -51 -> 331
    //   385: aload_1
    //   386: invokestatic 1182	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   389: ifeq +112 -> 501
    //   392: aload_0
    //   393: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   396: invokevirtual 126	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   399: ldc_w 2341
    //   402: invokevirtual 1223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   405: astore 6
    //   407: aload_1
    //   408: invokestatic 1320	njo:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lnjp;
    //   411: astore 7
    //   413: aload 7
    //   415: getfield 703	njp:jdField_b_of_type_Int	I
    //   418: invokestatic 706	njo:a	(I)Ljava/lang/String;
    //   421: aload 6
    //   423: aload 6
    //   425: invokestatic 2346	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   428: astore_1
    //   429: aload 7
    //   431: getfield 1602	njp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   434: astore 6
    //   436: aload 6
    //   438: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   441: ifne +38 -> 479
    //   444: aload_0
    //   445: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   448: fconst_1
    //   449: invokestatic 2351	bggq:a	(Landroid/content/Context;F)I
    //   452: istore_3
    //   453: aload_1
    //   454: iconst_2
    //   455: newarray int
    //   457: dup
    //   458: iconst_0
    //   459: aload 6
    //   461: invokestatic 1607	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   464: iastore
    //   465: dup
    //   466: iconst_1
    //   467: iload_3
    //   468: iastore
    //   469: invokevirtual 2352	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   472: aload_1
    //   473: getstatic 2358	bgey:r	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   476: invokevirtual 2362	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   479: aload_2
    //   480: aload_1
    //   481: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   484: aload_2
    //   485: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   488: aload_0
    //   489: invokevirtual 2300	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   492: aload_2
    //   493: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   496: aconst_null
    //   497: invokevirtual 2301	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   500: return
    //   501: aload_1
    //   502: instanceof 1337
    //   505: ifeq +44 -> 549
    //   508: aload_1
    //   509: invokestatic 1340	bfrd:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   512: ifeq +37 -> 549
    //   515: aload_2
    //   516: aload_0
    //   517: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   520: invokevirtual 126	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   523: ldc_w 2363
    //   526: invokevirtual 1223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   529: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   532: aload_2
    //   533: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   536: aload_0
    //   537: invokevirtual 2300	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   540: aload_2
    //   541: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   544: aconst_null
    //   545: invokevirtual 2301	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   548: return
    //   549: aload_1
    //   550: invokestatic 1343	bfre:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lbfrf;
    //   553: astore 6
    //   555: aload 6
    //   557: ifnull +123 -> 680
    //   560: aload_0
    //   561: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   564: invokevirtual 126	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   567: ldc_w 2331
    //   570: invokevirtual 1223	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   573: astore 7
    //   575: invokestatic 2369	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   578: astore_1
    //   579: aload_1
    //   580: aload 7
    //   582: putfield 2373	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   585: aload_1
    //   586: aload 7
    //   588: putfield 2376	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   591: new 2378	java/net/URL
    //   594: dup
    //   595: aload 6
    //   597: getfield 2379	bfrf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   600: invokespecial 2381	java/net/URL:<init>	(Ljava/lang/String;)V
    //   603: aload_1
    //   604: invokestatic 2384	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   607: astore_1
    //   608: aload_1
    //   609: bipush 100
    //   611: bipush 100
    //   613: bipush 6
    //   615: invokestatic 2387	bgey:b	(III)[I
    //   618: invokevirtual 2352	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   621: aload_1
    //   622: getstatic 2389	bgey:a	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   625: invokevirtual 2362	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   628: aload_2
    //   629: aload_1
    //   630: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   633: aload_1
    //   634: ifnull +37 -> 671
    //   637: aload_2
    //   638: aload_1
    //   639: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   642: aload_2
    //   643: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   646: aload_0
    //   647: invokevirtual 2300	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   650: aload_2
    //   651: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   654: aconst_null
    //   655: invokevirtual 2301	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   658: return
    //   659: astore 6
    //   661: aconst_null
    //   662: astore_1
    //   663: aload 6
    //   665: invokevirtual 2392	java/net/MalformedURLException:printStackTrace	()V
    //   668: goto -35 -> 633
    //   671: aload_2
    //   672: aload 7
    //   674: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   677: goto -35 -> 642
    //   680: aload_1
    //   681: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   684: istore 5
    //   686: aload_1
    //   687: invokevirtual 764	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   690: ifeq +846 -> 1536
    //   693: aload_1
    //   694: getfield 2073	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   697: astore 8
    //   699: aload_0
    //   700: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   703: aload 8
    //   705: iconst_0
    //   706: invokevirtual 2393	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Z)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   709: astore 6
    //   711: aload 6
    //   713: ifnull +110 -> 823
    //   716: aload 6
    //   718: getfield 2396	com/tencent/mobileqq/data/ExtensionInfo:faceIdUpdateTime	J
    //   721: aload_1
    //   722: getfield 997	com/tencent/mobileqq/data/ChatMessage:time	J
    //   725: lcmp
    //   726: ifge +97 -> 823
    //   729: aload_1
    //   730: ldc_w 2398
    //   733: invokevirtual 1000	com/tencent/mobileqq/data/ChatMessage:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   736: astore 7
    //   738: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   741: ifeq +31 -> 772
    //   744: ldc_w 542
    //   747: iconst_2
    //   748: new 176	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   755: ldc_w 2400
    //   758: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 7
    //   763: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 1004	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: aload 7
    //   774: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   777: ifne +46 -> 823
    //   780: aload 7
    //   782: invokestatic 1010	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   785: aload 6
    //   787: getfield 2403	com/tencent/mobileqq/data/ExtensionInfo:faceId	I
    //   790: i2l
    //   791: lcmp
    //   792: ifeq +31 -> 823
    //   795: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   798: ifeq +13 -> 811
    //   801: ldc_w 542
    //   804: iconst_2
    //   805: ldc_w 2405
    //   808: invokestatic 1004	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   811: aload 8
    //   813: invokestatic 1020	bgks:a	(Ljava/lang/String;)V
    //   816: aload_0
    //   817: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   820: invokestatic 1023	bgks:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   823: aload_0
    //   824: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   827: bipush 51
    //   829: invokevirtual 317	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   832: checkcast 609	anmw
    //   835: astore 6
    //   837: aload_0
    //   838: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   841: bipush 60
    //   843: invokevirtual 317	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   846: checkcast 1268	com/tencent/mobileqq/app/HotChatManager
    //   849: astore 7
    //   851: aload 7
    //   853: ifnull +731 -> 1584
    //   856: aload 7
    //   858: aload_1
    //   859: getfield 910	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   862: invokevirtual 1354	com/tencent/mobileqq/app/HotChatManager:b	(Ljava/lang/String;)Z
    //   865: ifeq +719 -> 1584
    //   868: iconst_1
    //   869: istore_3
    //   870: aload 6
    //   872: ifnull +717 -> 1589
    //   875: aload 6
    //   877: aload 8
    //   879: invokevirtual 611	anmw:b	(Ljava/lang/String;)Z
    //   882: ifeq +707 -> 1589
    //   885: iconst_1
    //   886: istore 4
    //   888: iload 5
    //   890: sipush 1010
    //   893: if_icmpeq +116 -> 1009
    //   896: iload 5
    //   898: sipush 1001
    //   901: if_icmpeq +108 -> 1009
    //   904: iload 5
    //   906: sipush 10002
    //   909: if_icmpeq +100 -> 1009
    //   912: iload_3
    //   913: ifeq +23 -> 936
    //   916: iload 4
    //   918: ifeq +91 -> 1009
    //   921: aload 8
    //   923: aload_0
    //   924: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   927: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   930: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   933: ifne +76 -> 1009
    //   936: iload 5
    //   938: sipush 1022
    //   941: if_icmpne +690 -> 1631
    //   944: aload_0
    //   945: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   948: getfield 2406	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_Int	I
    //   951: sipush 3007
    //   954: if_icmpeq +55 -> 1009
    //   957: aload_0
    //   958: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   961: getfield 2406	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_Int	I
    //   964: sipush 2007
    //   967: if_icmpeq +42 -> 1009
    //   970: aload_0
    //   971: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   974: getfield 2406	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_Int	I
    //   977: sipush 4007
    //   980: if_icmpeq +29 -> 1009
    //   983: aload_0
    //   984: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   987: getfield 2406	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_Int	I
    //   990: sipush 3019
    //   993: if_icmpeq +16 -> 1009
    //   996: aload_0
    //   997: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1000: getfield 2406	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_Int	I
    //   1003: sipush 2019
    //   1006: if_icmpne +625 -> 1631
    //   1009: aload 6
    //   1011: ifnull +620 -> 1631
    //   1014: aload 6
    //   1016: aload_0
    //   1017: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1020: getfield 325	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1023: invokevirtual 611	anmw:b	(Ljava/lang/String;)Z
    //   1026: ifne +605 -> 1631
    //   1029: aload 7
    //   1031: aload_1
    //   1032: getfield 910	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   1035: invokevirtual 1334	com/tencent/mobileqq/app/HotChatManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   1038: astore 7
    //   1040: aload 7
    //   1042: ifnull +571 -> 1613
    //   1045: aload 7
    //   1047: getfield 1249	com/tencent/mobileqq/data/HotChatInfo:isGameRoom	Z
    //   1050: ifeq +563 -> 1613
    //   1053: aload 6
    //   1055: aload 8
    //   1057: invokevirtual 611	anmw:b	(Ljava/lang/String;)Z
    //   1060: ifne +18 -> 1078
    //   1063: aload 8
    //   1065: aload_0
    //   1066: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1069: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1072: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1075: ifeq +520 -> 1595
    //   1078: aload_0
    //   1079: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1082: iconst_1
    //   1083: aload 8
    //   1085: invokestatic 2295	aoch:a	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;)Laoch;
    //   1088: astore 7
    //   1090: aload 7
    //   1092: astore 6
    //   1094: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1097: ifeq +35 -> 1132
    //   1100: ldc_w 1917
    //   1103: iconst_2
    //   1104: new 176	java/lang/StringBuilder
    //   1107: dup
    //   1108: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1111: ldc_w 2408
    //   1114: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload 8
    //   1119: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1125: invokestatic 1004	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1128: aload 7
    //   1130: astore 6
    //   1132: aload_2
    //   1133: aload 6
    //   1135: invokevirtual 2298	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   1138: aload_1
    //   1139: invokevirtual 2411	com/tencent/mobileqq/data/ChatMessage:isSendFromLocal	()Z
    //   1142: ifne +166 -> 1308
    //   1145: iload 5
    //   1147: iconst_1
    //   1148: if_icmpeq +176 -> 1324
    //   1151: iload 5
    //   1153: sipush 3000
    //   1156: if_icmpeq +168 -> 1324
    //   1159: iload 5
    //   1161: ifeq +163 -> 1324
    //   1164: iload 5
    //   1166: sipush 1005
    //   1169: if_icmpeq +155 -> 1324
    //   1172: iload 5
    //   1174: sipush 1001
    //   1177: if_icmpeq +147 -> 1324
    //   1180: iload 5
    //   1182: sipush 1006
    //   1185: if_icmpeq +139 -> 1324
    //   1188: iload 5
    //   1190: sipush 1000
    //   1193: if_icmpeq +131 -> 1324
    //   1196: iload 5
    //   1198: sipush 10004
    //   1201: if_icmpeq +123 -> 1324
    //   1204: iload 5
    //   1206: sipush 1004
    //   1209: if_icmpeq +115 -> 1324
    //   1212: iload 5
    //   1214: sipush 1008
    //   1217: if_icmpeq +107 -> 1324
    //   1220: iload 5
    //   1222: sipush 1009
    //   1225: if_icmpeq +99 -> 1324
    //   1228: iload 5
    //   1230: sipush 1010
    //   1233: if_icmpeq +91 -> 1324
    //   1236: iload 5
    //   1238: sipush 1011
    //   1241: if_icmpeq +83 -> 1324
    //   1244: iload 5
    //   1246: sipush 1020
    //   1249: if_icmpeq +75 -> 1324
    //   1252: iload 5
    //   1254: sipush 1021
    //   1257: if_icmpeq +67 -> 1324
    //   1260: iload 5
    //   1262: sipush 1023
    //   1265: if_icmpeq +59 -> 1324
    //   1268: iload 5
    //   1270: sipush 1024
    //   1273: if_icmpeq +51 -> 1324
    //   1276: iload 5
    //   1278: sipush 1036
    //   1281: if_icmpeq +43 -> 1324
    //   1284: iload 5
    //   1286: sipush 1025
    //   1289: if_icmpeq +35 -> 1324
    //   1292: iload 5
    //   1294: sipush 10002
    //   1297: if_icmpeq +27 -> 1324
    //   1300: iload 5
    //   1302: sipush 1022
    //   1305: if_icmpeq +19 -> 1324
    //   1308: iload 5
    //   1310: sipush 10008
    //   1313: if_icmpeq +11 -> 1324
    //   1316: iload 5
    //   1318: sipush 10009
    //   1321: if_icmpne +499 -> 1820
    //   1324: aload_0
    //   1325: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1328: invokevirtual 146	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1331: aload_1
    //   1332: getfield 916	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1335: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1338: ifne +44 -> 1382
    //   1341: aload_1
    //   1342: getfield 910	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   1345: astore 6
    //   1347: aload_1
    //   1348: getfield 916	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1351: astore 7
    //   1353: new 2413	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder$ProcessMemberNickTask
    //   1356: dup
    //   1357: aload_0
    //   1358: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1361: aload_0
    //   1362: getfield 116	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1365: aload_2
    //   1366: aload 6
    //   1368: aload 7
    //   1370: iload 5
    //   1372: aload_0
    //   1373: getfield 110	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   1376: invokespecial 2416	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder$ProcessMemberNickTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;Ljava/lang/String;Ljava/lang/String;ILandroid/view/View$OnLongClickListener;)V
    //   1379: invokestatic 2420	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   1382: aload_2
    //   1383: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   1386: aload_0
    //   1387: invokevirtual 2300	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1390: aload_2
    //   1391: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   1394: aload_1
    //   1395: invokevirtual 2299	com/tencent/mobileqq/vas/avatar/VasAvatar:setTag	(Ljava/lang/Object;)V
    //   1398: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1401: ifeq +32 -> 1433
    //   1404: ldc_w 1917
    //   1407: iconst_2
    //   1408: new 176	java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1415: ldc_w 2422
    //   1418: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: getstatic 945	com/tencent/common/config/AppSetting:jdField_c_of_type_Boolean	Z
    //   1424: invokevirtual 2290	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1427: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1430: invokestatic 1004	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1433: getstatic 945	com/tencent/common/config/AppSetting:jdField_c_of_type_Boolean	Z
    //   1436: ifeq -1325 -> 111
    //   1439: ldc 225
    //   1441: astore 7
    //   1443: aload 7
    //   1445: astore 6
    //   1447: aload_1
    //   1448: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   1451: iconst_1
    //   1452: if_icmpeq +32 -> 1484
    //   1455: aload 7
    //   1457: astore 6
    //   1459: aload_1
    //   1460: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   1463: sipush 3000
    //   1466: if_icmpeq +18 -> 1484
    //   1469: aload_1
    //   1470: invokevirtual 764	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   1473: ifeq +358 -> 1831
    //   1476: ldc_w 2423
    //   1479: invokestatic 1150	anni:a	(I)Ljava/lang/String;
    //   1482: astore 6
    //   1484: aload_1
    //   1485: getfield 785	com/tencent/mobileqq/data/ChatMessage:msgtype	I
    //   1488: sipush -3006
    //   1491: if_icmpne +35 -> 1526
    //   1494: aload_2
    //   1495: invokevirtual 1162	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:getResources	()Landroid/content/res/Resources;
    //   1498: ldc_w 1163
    //   1501: invokevirtual 1164	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1504: iconst_1
    //   1505: anewarray 739	java/lang/Object
    //   1508: dup
    //   1509: iconst_0
    //   1510: aload_0
    //   1511: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1514: invokestatic 1168	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1517: invokestatic 1173	tyg:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)Ljava/lang/String;
    //   1520: aastore
    //   1521: invokestatic 1177	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1524: astore 6
    //   1526: aload_2
    //   1527: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   1530: aload 6
    //   1532: invokevirtual 1154	com/tencent/mobileqq/vas/avatar/VasAvatar:setContentDescription	(Ljava/lang/CharSequence;)V
    //   1535: return
    //   1536: aload_1
    //   1537: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   1540: sipush 1000
    //   1543: if_icmpeq +23 -> 1566
    //   1546: aload_1
    //   1547: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   1550: sipush 1020
    //   1553: if_icmpeq +13 -> 1566
    //   1556: aload_1
    //   1557: getfield 909	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   1560: sipush 1004
    //   1563: if_icmpne +12 -> 1575
    //   1566: aload_1
    //   1567: getfield 910	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   1570: astore 8
    //   1572: goto -873 -> 699
    //   1575: aload_1
    //   1576: getfield 916	com/tencent/mobileqq/data/ChatMessage:senderuin	Ljava/lang/String;
    //   1579: astore 8
    //   1581: goto -882 -> 699
    //   1584: iconst_0
    //   1585: istore_3
    //   1586: goto -716 -> 870
    //   1589: iconst_0
    //   1590: istore 4
    //   1592: goto -704 -> 888
    //   1595: aload_0
    //   1596: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1599: sipush 200
    //   1602: aload 8
    //   1604: iconst_1
    //   1605: invokestatic 2426	aoch:a	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;Z)Laoch;
    //   1608: astore 7
    //   1610: goto -520 -> 1090
    //   1613: aload_0
    //   1614: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1617: sipush 200
    //   1620: aload 8
    //   1622: iconst_1
    //   1623: invokestatic 2426	aoch:a	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;Z)Laoch;
    //   1626: astore 7
    //   1628: goto -538 -> 1090
    //   1631: iload 5
    //   1633: sipush 9501
    //   1636: if_icmpne +92 -> 1728
    //   1639: aload_1
    //   1640: invokevirtual 764	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   1643: ifne +85 -> 1728
    //   1646: aload_0
    //   1647: getfield 112	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1650: bipush 51
    //   1652: invokevirtual 894	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lanii;
    //   1655: checkcast 2428	abqn
    //   1658: aload 8
    //   1660: invokestatic 1010	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1663: invokevirtual 2431	abqn:a	(J)Lcom/tencent/device/datadef/DeviceInfo;
    //   1666: astore 6
    //   1668: aload 6
    //   1670: ifnull +45 -> 1715
    //   1673: aload 8
    //   1675: aload 6
    //   1677: getfield 2436	com/tencent/device/datadef/DeviceInfo:din	J
    //   1680: invokestatic 2439	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1683: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1686: ifeq +29 -> 1715
    //   1689: new 1727	android/graphics/drawable/BitmapDrawable
    //   1692: dup
    //   1693: invokestatic 2440	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1696: invokevirtual 383	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1699: invokestatic 2445	com/tencent/device/DeviceHeadMgr:getInstance	()Lcom/tencent/device/DeviceHeadMgr;
    //   1702: aload 8
    //   1704: invokevirtual 2449	com/tencent/device/DeviceHeadMgr:getDeviceHeadByDin	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1707: invokespecial 1730	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   1710: astore 6
    //   1712: goto -580 -> 1132
    //   1715: aload_0
    //   1716: aload_2
    //   1717: iconst_1
    //   1718: aload 8
    //   1720: invokevirtual 2451	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:a	(Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;ILjava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1723: astore 6
    //   1725: goto -593 -> 1132
    //   1728: iload 5
    //   1730: sipush 1006
    //   1733: if_icmpne +142 -> 1875
    //   1736: bipush 11
    //   1738: istore_3
    //   1739: aload_0
    //   1740: aload_2
    //   1741: iload_3
    //   1742: aload 8
    //   1744: invokevirtual 2451	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:a	(Lcom/tencent/mobileqq/activity/aio/BaseChatItemLayout;ILjava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1747: astore 6
    //   1749: new 2453	bhbe
    //   1752: dup
    //   1753: aload 8
    //   1755: iconst_m1
    //   1756: ldc_w 2455
    //   1759: aload_1
    //   1760: getfield 806	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   1763: invokespecial 2458	bhbe:<init>	(Ljava/lang/String;ILjava/lang/String;J)V
    //   1766: astore 7
    //   1768: aload 7
    //   1770: aload 6
    //   1772: putfield 2460	bhbe:a	Landroid/graphics/drawable/Drawable;
    //   1775: aload 7
    //   1777: astore 6
    //   1779: invokestatic 540	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1782: ifeq -650 -> 1132
    //   1785: ldc_w 1917
    //   1788: iconst_2
    //   1789: new 176	java/lang/StringBuilder
    //   1792: dup
    //   1793: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1796: ldc_w 2462
    //   1799: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1802: aload 8
    //   1804: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1810: invokestatic 1004	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1813: aload 7
    //   1815: astore 6
    //   1817: goto -685 -> 1132
    //   1820: aload_2
    //   1821: getfield 275	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   1824: aconst_null
    //   1825: invokevirtual 2301	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   1828: goto -446 -> 1382
    //   1831: new 176	java/lang/StringBuilder
    //   1834: dup
    //   1835: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   1838: aload_0
    //   1839: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo	Lcom/tencent/mobileqq/activity/aio/SessionInfo;
    //   1842: getfield 646	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1845: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: ldc_w 2463
    //   1851: invokestatic 1150	anni:a	(I)Ljava/lang/String;
    //   1854: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1857: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1860: astore 6
    //   1862: goto -378 -> 1484
    //   1865: astore 6
    //   1867: goto -1204 -> 663
    //   1870: astore 6
    //   1872: goto -1393 -> 479
    //   1875: iconst_1
    //   1876: istore_3
    //   1877: goto -138 -> 1739
    //   1880: aconst_null
    //   1881: astore 6
    //   1883: goto -1552 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1886	0	this	BaseBubbleBuilder
    //   0	1886	1	paramChatMessage	ChatMessage
    //   0	1886	2	paramBaseChatItemLayout	BaseChatItemLayout
    //   160	1717	3	i	int
    //   886	705	4	j	int
    //   684	1050	5	k	int
    //   71	525	6	localObject1	Object
    //   659	5	6	localMalformedURLException1	java.net.MalformedURLException
    //   709	1152	6	localObject2	Object
    //   1865	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   1870	1	6	localException	Exception
    //   1881	1	6	localObject3	Object
    //   411	1403	7	localObject4	Object
    //   697	1106	8	str	String
    // Exception table:
    //   from	to	target	type
    //   591	608	659	java/net/MalformedURLException
    //   608	633	1865	java/net/MalformedURLException
    //   444	479	1870	java/lang/Exception
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (bcnj.b()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10007);
        if ((paramChatMessage == null) || (paramChatMessage.isShowQimStyleAvater) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) || (aqjq.a(paramChatMessage)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1037) || (acwh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1044) || (paramChatMessage.fakeSenderType != 0))
        {
          paramBaseChatItemLayout.setPendantImageVisible(false);
          return;
        }
      } while (afur.h);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject != null) && (((TroopInfo)localObject).hasOrgs()));
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (njo.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    if (paramChatMessage.isSend())
    {
      localObject = paramChatMessage.selfuin;
      anmw localanmw = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localanmw == null) {
        break label294;
      }
      a(paramChatMessage, paramBaseChatItemLayout, (String)localObject, localanmw);
    }
    for (;;)
    {
      paramChatMessage.mPendantAnimatable = false;
      return;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
      {
        localObject = paramChatMessage.frienduin;
        break;
      }
      localObject = paramChatMessage.senderuin;
      break;
      label294:
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, afyl paramafyl)
  {
    bauy localbauy = (bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    if ((paramMessageRecord.extraflag != 32772) || (!localbauy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.uniseq, paramView, paramafyl)))
    {
      paramMessageRecord = afyj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramafyl);
      }
    }
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.jdField_a_of_type_Boolean;
  }
  
  public boolean a(afwr paramafwr)
  {
    return true;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = bfup.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (bfup.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    for (this.d = true;; this.d = false) {
      return this.d;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected void b(afwr paramafwr, ChatMessage paramChatMessage) {}
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = afur.a(paramView);
    if (localChatMessage == null) {
      break label11;
    }
    label11:
    while (a(paramView, localChatMessage)) {
      return;
    }
    anmw localanmw = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    boolean bool2 = localChatMessage.isSelf();
    boolean bool1;
    String str;
    if (b(localChatMessage))
    {
      bool1 = localanmw.b(localChatMessage.senderuin);
      str = localChatMessage.senderuin;
      label69:
      if (str == null) {
        break label214;
      }
      if (!localanmw.b(str)) {
        break label553;
      }
      bool1 = true;
    }
    label553:
    for (;;)
    {
      Object localObject;
      if (localChatMessage.istroop == 10009)
      {
        bmxq localbmxq = bmxq.a();
        if (bool2)
        {
          localObject = "0";
          label111:
          localbmxq.a("0", "1", "176", "969", "96902", "206995", (String)localObject, "0", "20", "0");
        }
      }
      else
      {
        if (!bool2) {
          break label224;
        }
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      }
      for (;;)
      {
        a(localChatMessage, str, (ProfileActivity.AllInOne)localObject);
        a(paramView, localChatMessage, localanmw, bool1, bool2, str, (ProfileActivity.AllInOne)localObject);
        return;
        str = localChatMessage.frienduin;
        bool1 = false;
        break label69;
        label214:
        break label11;
        localObject = "1";
        break label111;
        label224:
        if (localChatMessage.istroop == 1008)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("need_finish", true);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          tzo.a((Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 2, tzo.jdField_a_of_type_Boolean);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          nmp.a(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
          return;
        }
        if (bool1)
        {
          localObject = afuw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, str);
        }
        else
        {
          if (localChatMessage.istroop == 1025)
          {
            if (this.jdField_a_of_type_AndroidContentContext == null) {
              break;
            }
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
            paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
            paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            return;
          }
          if ((localChatMessage.istroop == 1037) || (acwh.a(localChatMessage.istroop) == 1044))
          {
            localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
            ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          }
          else
          {
            localObject = afuw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localChatMessage);
          }
        }
      }
    }
  }
  
  protected void b(bguh parambguh, Context paramContext)
  {
    parambguh.a(2131371486, anni.a(2131699751), 2130838937);
  }
  
  protected void b(ChatMessage paramChatMessage)
  {
    if (!c())
    {
      Object localObject;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
      {
        localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null) {
          ((ChatFragment)localObject).a().d(paramChatMessage);
        }
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)paramChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          yqu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (MessageForStructing)localObject, "reply");
        }
      }
      ahgl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, "0X800A368");
    }
  }
  
  protected void b(ChatMessage paramChatMessage, bguh parambguh)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if ((!bfpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)) && (!njo.a(paramChatMessage)) && (!aqjq.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
        break label152;
      }
      if (QLog.isColorLevel())
      {
        parambguh = new StringBuilder("addReplyOnlyMenu isRobot=").append(bfpx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(njo.a(paramChatMessage)).append(" isConfessMsg=").append(aqjq.a(paramChatMessage)).append(" isNotSupport=");
        if (paramChatMessage.isSupportReply()) {
          break label147;
        }
        QLog.d("ChatItemBuilder", 2, bool);
      }
    }
    label147:
    label152:
    do
    {
      return;
      bool = false;
      break;
      if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())))
      {
        parambguh.a(2131376394, this.jdField_a_of_type_AndroidContentContext.getString(2131696973), 2130838933);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    parambguh.a(2131376394, this.jdField_a_of_type_AndroidContentContext.getString(2131696973), 2130838933);
  }
  
  public void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!bfgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
    }
    TroopManager localTroopManager;
    do
    {
      do
      {
        return;
        if (!bfgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          return;
        }
      } while (paramChatMessage.istroop != 1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    } while (!((bfgp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(paramChatMessage.frienduin));
    afwo localafwo2 = (afwo)paramBaseChatItemLayout.getTag(2131364416);
    afwo localafwo1 = localafwo2;
    if (localafwo2 == null)
    {
      localafwo1 = new afwo(this, null);
      paramBaseChatItemLayout.setTag(2131364416, localafwo1);
    }
    localafwo1.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    localafwo1.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, localafwo1);
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected boolean b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramBaseChatItemLayout))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return true;
    }
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    return false;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = afur.a(paramView);
    if (g(localChatMessage)) {}
    while ((f(localChatMessage)) || (localChatMessage == null) || (localChatMessage.istroop != 1) || (!bgjw.d(localChatMessage.senderuin)) || (e(localChatMessage)) || (((bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin)))) {
      return;
    }
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int i;
    Object localObject1;
    label153:
    Object localObject3;
    if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
    {
      i = paramView.getId();
      if (i == 2131364417)
      {
        localObject1 = "clk_title";
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
        localObject3 = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
        if (i != 2131364417) {
          break label436;
        }
        i = 2;
        localObject1 = "Clk_label";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = Base64.encodeToString(((String)localObject3).getBytes("UTF-8"), 0);
        localObject2 = a(localChatMessage, i, (String)localObject2);
        paramView = paramView.getContext();
        localObject3 = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        ((Intent)localObject3).putExtra("selfSet_leftViewText", anni.a(2131699749));
        paramView.startActivity((Intent)localObject3);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = localChatMessage.frienduin;
        if (localChatMessage.isSend())
        {
          paramView = "1";
          bcst.b((QQAppInterface)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, str, paramView, "", "");
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
          }
          if (this.jdField_c_of_type_Int < 2) {
            break;
          }
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_c_of_type_Int), "", "");
          return;
          localObject1 = "clk_nickname";
          break label153;
          label436:
          i = 1;
          localObject1 = "Clk_name";
          continue;
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:", localException);
        localObject2 = localObject3;
        continue;
        paramView = "0";
        continue;
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick, openLevelPKPage");
        }
        localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=" + localChatMessage.frienduin + "&target=" + localChatMessage.senderuin);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        paramView.getContext().startActivity((Intent)localObject1);
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
      }
    }
  }
  
  protected void c(bguh parambguh, Context paramContext)
  {
    if ((b()) && (awwm.a().a())) {
      parambguh.a(2131371422, paramContext.getString(2131693880), 2130838937);
    }
  }
  
  protected void c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "chatMessage is null");
      }
      return;
    }
    ((bakq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(paramChatMessage);
    Intent localIntent = afur.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 1 });
    localIntent.putExtra("uin", paramChatMessage.senderuin);
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_reply_only_uniseq", paramChatMessage.uniseq);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int i;
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      localIntent.putExtra("uintype", 0);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      i = 1;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramChatMessage.senderuin)) {
        break label312;
      }
      i = 3;
    }
    label312:
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4F5", "0X800A4F5", i, 0, "", "", "", "");
      return;
      localIntent.putExtra("uintype", 1000);
      localIntent.putExtra("uinname", bglf.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage.senderuin));
      localIntent = new Intent(localIntent);
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject != null) {
        ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new afwl(this, localIntent));
      }
      i = 2;
      break;
    }
  }
  
  protected void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage);
    paramBaseChatItemLayout.setProgressVisable(bool);
    if (!bool) {
      d(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  protected boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bfsk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131696676, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      return true;
    }
    return false;
  }
  
  public void d() {}
  
  protected void d(View paramView)
  {
    int i = 1;
    Object localObject2 = afur.a(paramView);
    if (g((MessageRecord)localObject2)) {}
    while ((bfre.a((MessageRecord)localObject2) != null) || (localObject2 == null) || (((MessageRecord)localObject2).istroop != 1) || (!bgjw.d(((MessageRecord)localObject2).senderuin))) {
      return;
    }
    Object localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if (localObject1 != null)
    {
      localObject1 = ((HotChatManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      label80:
      if ((localObject1 != null) || (((bftx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, ((MessageRecord)localObject2).frienduin, Long.parseLong(((MessageRecord)localObject2).senderuin)))) {
        break label274;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://qun.qq.com/interactive/userhonor?gc=").append(((MessageRecord)localObject2).frienduin);
      ((StringBuilder)localObject1).append("&uin=").append(((MessageRecord)localObject2).senderuin);
      ((StringBuilder)localObject1).append("&_wv=3&&_wwv=128");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.getContext().startActivity((Intent)localObject2);
      if (!(paramView instanceof TroopMemberNewLevelView)) {
        break label300;
      }
    }
    label274:
    label300:
    for (paramView = (TroopMemberNewLevelView)paramView;; paramView = null)
    {
      if (paramView != null) {
        if ((paramView.a()) && (paramView.b())) {
          i = 3;
        }
      }
      for (;;)
      {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B200", "0X800B200", i, 0, "", "", "", "");
        return;
        localObject1 = null;
        break label80;
        break;
        if (!paramView.a()) {
          if (paramView.b()) {
            i = 2;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  protected void d(bguh parambguh, Context paramContext)
  {
    parambguh.a(2131366271, paramContext.getString(2131691986), 2130838928);
  }
  
  protected void d(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
    Object localObject;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      localObject = new StringBuilder().append("onClickSelectMore Error:");
      if (localFragmentActivity != null)
      {
        paramChatMessage = localFragmentActivity.toString();
        QLog.e("BaseBubbleBuilder", 1, paramChatMessage);
      }
    }
    do
    {
      return;
      paramChatMessage = "ca is null ";
      break;
      localObject = AIOLongShotHelper.a();
      if (localObject != null) {
        ((AIOLongShotHelper)localObject).c();
      }
      localObject = localFragmentActivity.getChatFragment().a();
      ((BaseChatPie)localObject).c(paramChatMessage);
      ((BaseChatPie)localObject).j(true);
      amuf.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
    } while (paramChatMessage == null);
    int j;
    int i;
    if (paramChatMessage.istroop == 0)
    {
      j = 1;
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label272;
      }
      i = 6;
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, "" + i, "", "", "");
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + j, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000)
      {
        j = 2;
        break;
      }
      if (paramChatMessage.istroop == 1)
      {
        j = 3;
        break;
      }
      j = 4;
      break;
      label272:
      if ((paramChatMessage instanceof MessageForText)) {
        i = 1;
      } else if ((paramChatMessage instanceof MessageForPic)) {
        i = 3;
      } else if ((paramChatMessage instanceof MessageForMarketFace)) {
        i = 4;
      } else {
        i = 0;
      }
    }
  }
  
  protected void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setNetIconVisible(paramChatMessage.isSentByXG());
  }
  
  protected void e(bguh parambguh, Context paramContext)
  {
    parambguh.a(2131362462, paramContext.getString(2131689929), 2130838937);
  }
  
  protected void e(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onClickScreenShot Error:");
      if (localFragmentActivity != null) {}
      for (paramChatMessage = localFragmentActivity.toString();; paramChatMessage = "ca is null ")
      {
        QLog.e("BaseBubbleBuilder", 1, paramChatMessage);
        return;
      }
    }
    ((aimx)localFragmentActivity.getChatFragment().a().a(59)).a(paramChatMessage);
  }
  
  protected void f(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      localObject = new StringBuilder().append("onClickScreenShot Error:");
      if (localFragmentActivity != null) {}
      for (paramChatMessage = localFragmentActivity.toString();; paramChatMessage = "ca is null ")
      {
        QLog.e("BaseBubbleBuilder", 1, paramChatMessage);
        return;
      }
    }
    Object localObject = localFragmentActivity.getChatFragment().a();
    ((AIOLongShotHelper)((BaseChatPie)localObject).a(15)).a(paramChatMessage);
    ((BaseChatPie)localObject).j(true);
    amuf.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
    localObject = "0";
    if (paramChatMessage.istroop == 1) {
      localObject = "2";
    }
    for (;;)
    {
      bcst.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 1, 0, (String)localObject, "", "", "");
      return;
      if (paramChatMessage.istroop == 0) {
        localObject = "1";
      }
    }
  }
  
  public void g(ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    if (a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n) || (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
      {
        afur.n = true;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131364370: 
        case 2131364415: 
        case 2131364388: 
        case 2131364386: 
        case 2131364396: 
          do
          {
            c(paramView);
            break;
            b(paramView);
            break;
            a(paramView);
            break;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
          b(paramView);
          break;
        case 2131364401: 
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), null);
          break;
        case 2131364416: 
        case 2131364417: 
          Object localObject = (afxj)afur.a(paramView);
          String str = ((afxj)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
          localObject = ((afxj)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
          if (((bfgp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(str))
          {
            str = bfti.a().a(str, (String)localObject);
            localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", str);
            paramView.getContext().startActivity((Intent)localObject);
            if (paramView.getId() == 2131364416) {
              bcst.b(null, "dc00898", "", "", "0X800A705", "0X800A705", 0, 0, "", "", "", "");
            }
          }
          else if (paramView.getId() == 2131364417)
          {
            c(paramView);
          }
          break;
        case 2131364418: 
          d(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */