package com.tencent.mobileqq.activity.aio;

import aaod;
import actn;
import acue;
import acuf;
import acug;
import acuh;
import acui;
import acuj;
import acuk;
import acul;
import acum;
import acun;
import acuv;
import acvc;
import acvd;
import acve;
import acwd;
import acwf;
import acxn;
import adha;
import advu;
import adyh;
import aebz;
import aeci;
import aekr;
import aets;
import ajfa;
import ajsz;
import ajxn;
import ajyc;
import akfw;
import akhq;
import akig;
import akpy;
import ambb;
import ambe;
import ambh;
import ambi;
import ambj;
import amch;
import amnj;
import amno;
import amns;
import amon;
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
import aobk;
import aocb;
import aocp;
import apyq;
import arqn;
import askd;
import asty;
import asuf;
import atbn;
import auvw;
import avqs;
import awan;
import awzw;
import axmt;
import axqw;
import axra;
import axwz;
import ayju;
import ayla;
import azrd;
import bacv;
import bacy;
import bahx;
import baic;
import baid;
import baie;
import baja;
import bajb;
import bajc;
import bakk;
import bakq;
import bali;
import balj;
import balw;
import bamn;
import bavi;
import bawz;
import baxk;
import baxt;
import bbas;
import bbav;
import bbbd;
import bbby;
import bbcl;
import bbdj;
import bbdr;
import bbej;
import bbeq;
import bbjv;
import bbkb;
import bblr;
import bboe;
import bbsi;
import bcic;
import bcis;
import bcpw;
import bdto;
import bdvj;
import bfmv;
import bfni;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.confess.ConfessInfo;
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
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.Pair;
import ho;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import lbk;
import lbn;
import lbo;
import lbs;
import mye;
import myf;
import nbc;
import sfh;
import sgj;
import vel;
import xkq;
import yak;

public abstract class BaseBubbleBuilder
  extends acvd
  implements acvc, View.OnClickListener
{
  public static int a;
  public static ColorFilter a;
  public static final Handler a;
  protected static final ConcurrentHashMap<Long, String> a;
  public static boolean a;
  protected float a;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new acuh(this);
  @Deprecated
  public BaseAdapter a;
  public baxk a;
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
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun)
  {
    int i;
    List localList;
    RelativeLayout.LayoutParams localLayoutParams6;
    if ((paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 1;
      if ((paramView == null) || (paramView.getId() != 2131364110) || (i != 0) || (!EmojiStickerManager.d(paramChatMessage)) || (paramChatMessage.fakeSenderType != 0)) {
        break label1464;
      }
      localList = EmojiStickerManager.a().a(paramChatMessage);
      localLayoutParams6 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null) {
        break label1581;
      }
    }
    label660:
    label811:
    label940:
    label1581:
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
                          askd localaskd;
                          int k;
                          int i12;
                          if ((localList != null) && (localList.size() > 0) && (EmojiStickerManager.b(paramChatMessage)))
                          {
                            localaskd = (askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
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
                                  paramView = localaskd.a(((MessageForMarketFace)paramChatMessage).mMarkFaceMessage);
                                }
                                for (;;)
                                {
                                  label572:
                                  int i14;
                                  label594:
                                  label616:
                                  int i15;
                                  label638:
                                  int i16;
                                  int i17;
                                  int m;
                                  int i18;
                                  if (localStickerInfo.x <= 1.0F)
                                  {
                                    i14 = (int)(localStickerInfo.x * j);
                                    if (localStickerInfo.y > 1.0F) {
                                      break label1056;
                                    }
                                    k = (int)(localStickerInfo.y * j);
                                    if (localStickerInfo.width > 1.0F) {
                                      break label1063;
                                    }
                                    i15 = (int)(localStickerInfo.width * j);
                                    if (localStickerInfo.height > 1.0F) {
                                      break label1070;
                                    }
                                    i16 = (int)(localStickerInfo.height * j);
                                    i17 = localStickerInfo.rotate;
                                    m = k + localLayoutParams6.topMargin;
                                    k = m;
                                    if (localLayoutParams5 != null) {
                                      k = m + (actn.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams5.topMargin + localLayoutParams5.bottomMargin));
                                    }
                                    m = k;
                                    if (localLayoutParams3 != null) {
                                      m = k + (actn.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams3.topMargin + localLayoutParams3.bottomMargin));
                                    }
                                    k = m;
                                    if (m < 0)
                                    {
                                      i18 = -m;
                                      if (localLayoutParams1 != null) {
                                        localLayoutParams1.topMargin += i18;
                                      }
                                      if (localLayoutParams3 == null) {
                                        break label1077;
                                      }
                                      localLayoutParams3.topMargin += i18;
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
                                        paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c(i18);
                                        k = m;
                                      }
                                    }
                                    if (!(paramView instanceof aobk)) {
                                      break label1110;
                                    }
                                    paramChatMessage = (aobk)paramView;
                                    if (paramChatMessage.a == null) {
                                      break label1474;
                                    }
                                    if ((EmojiStickerManager.jdField_f_of_type_Boolean) || (bbdj.a() <= 1.048576E+008F)) {
                                      break label1093;
                                    }
                                    m = 1;
                                    if (m == 0) {
                                      break label1099;
                                    }
                                    paramView = paramChatMessage.a("fromAIO", true, false, null, i15, i15);
                                    paramChatMessage = paramChatMessage.a.epId;
                                  }
                                  for (;;)
                                  {
                                    label948:
                                    BaseChatItemLayout localBaseChatItemLayout;
                                    double d1;
                                    boolean bool5;
                                    if (paramView != null)
                                    {
                                      localBaseChatItemLayout = paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
                                      d1 = i17;
                                      bool5 = localStickerInfo.isShown;
                                      if (!localStickerInfo.isShown) {
                                        break label1198;
                                      }
                                    }
                                    label1070:
                                    label1198:
                                    for (float f1 = 1.0F;; f1 = 1.1F)
                                    {
                                      localBaseChatItemLayout.a(paramView, i14, k, i15, i16, d1, paramChatMessage, bool5, f1, localStickerInfo);
                                      k = i13;
                                      break;
                                      if (!(paramChatMessage instanceof MessageForText)) {
                                        break label1483;
                                      }
                                      paramView = (MessageForText)paramChatMessage;
                                      if (TextUtils.isEmpty(paramView.msg)) {
                                        break label1483;
                                      }
                                      paramView = EmojiStickerManager.a().a(paramView.msg);
                                      break label572;
                                      i14 = j;
                                      break label594;
                                      k = j;
                                      break label616;
                                      i15 = j;
                                      break label638;
                                      i16 = j;
                                      break label660;
                                      label1077:
                                      localLayoutParams6.topMargin += i18;
                                      break label811;
                                      label1093:
                                      m = 0;
                                      break label920;
                                      label1099:
                                      paramView = paramChatMessage.a(paramContext, f2);
                                      break label940;
                                      label1110:
                                      if ((paramView instanceof aocp))
                                      {
                                        paramView = ((aocp)paramView).b(paramContext, f2);
                                        paramChatMessage = "";
                                        break label948;
                                      }
                                      if ((paramView instanceof aocb))
                                      {
                                        paramView = ((aocb)paramView).b(paramContext, f2);
                                        paramChatMessage = "";
                                        break label948;
                                      }
                                      if (!(paramChatMessage instanceof MessageForPic)) {
                                        break label1465;
                                      }
                                      paramView = advu.a(paramContext, (MessageForPic)paramChatMessage);
                                      ThreadManager.post(new BaseBubbleBuilder.1(this, paramChatMessage), 5, null, true);
                                      paramChatMessage = "";
                                      break label948;
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
                                      paramBaseChatItemLayout.setTag(2131372943, paramView);
                                    }
                                    paramBaseChatItemLayout.jdField_a_of_type_Anwc = new acue(this);
                                    if (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null)
                                    {
                                      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
                                      paramView.addRule(6, 2131364119);
                                      paramView.topMargin = (-actn.a(1.0F, paramContext.getResources()));
                                    }
                                    label1464:
                                    return;
                                    label1465:
                                    paramChatMessage = "";
                                    paramView = null;
                                    continue;
                                    label1474:
                                    paramChatMessage = "";
                                    paramView = null;
                                  }
                                  label1483:
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
    if ((paramView != null) && (paramView.getId() == 2131364110))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131372943);
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
        paramBaseChatItemLayout.setTag(2131372943, null);
      }
    }
  }
  
  public static void a(bblr parambblr, Context paramContext)
  {
    parambblr.a(2131364985, paramContext.getString(2131690708), 2130838601);
  }
  
  @TargetApi(14)
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramChatMessage.istroop == 3000) {
      if (bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
      {
        localObject1 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = paramChatMessage.senderuin;
        }
        if (((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) != 1) {
          break label271;
        }
        i = 1;
        label97:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
        if (i == 0) {
          break label277;
        }
        localObject1 = ((apyq)localObject1).jdField_d_of_type_JavaLangString;
        label127:
        if (localObject2 == null) {
          break label283;
        }
        label132:
        paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
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
      if ((paramBaseChatItemLayout.e != null) && (AppSetting.d) && (Build.VERSION.SDK_INT >= 14)) {
        paramBaseChatItemLayout.e.setAccessibilityDelegate(new acuf(this));
      }
      a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, paramacun);
      return;
      if (paramChatMessage.isSend()) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();; localObject1 = bbcl.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin)) {
        break;
      }
      label271:
      i = 0;
      break label97;
      label277:
      localObject1 = null;
      break label127;
      label283:
      bool1 = false;
      break label132;
      if (paramChatMessage.istroop == 9501)
      {
        if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
        {
          localObject1 = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
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
          paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.jdField_a_of_type_AndroidContentResColorStateList, false, false, false, false, "", null, null);
        }
        for (;;)
        {
          localObject1 = null;
          break;
          paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
        }
      }
      if (bdto.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin))
      {
        localObject2 = bdvj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break;
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
      paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        axqw.b(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin()), paramString2, null);
      }
      return;
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun)
  {
    int i;
    int j;
    label30:
    int k;
    label65:
    int m;
    label92:
    String str;
    if (AppSetting.d)
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
        str = ajyc.a(2131700937);
      }
    }
    label306:
    label439:
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setContentDescription(str);
      if ((AppSetting.d) && (paramacun.jdField_b_of_type_JavaLangStringBuilder != null))
      {
        if ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramChatMessage.senderuin)) || (paramChatMessage.isSend())) {
          paramacun.jdField_b_of_type_JavaLangStringBuilder.append("我");
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
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131697915), new Object[] { sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = ajyc.a(2131700938);
          continue;
        }
        str = paramString + ajyc.a(2131700930);
        continue;
        if (j != 0)
        {
          if (m != 0)
          {
            str = ajyc.a(2131700941);
            continue;
          }
          str = paramString + ajyc.a(2131700931);
          continue;
        }
        if (m != 0) {}
        for (str = ajyc.a(2131700941);; str = paramString + ajyc.a(2131700931))
        {
          if (paramChatMessage.msgtype != -3006) {
            break label439;
          }
          str = String.format(paramBaseChatItemLayout.getResources().getString(2131697915), new Object[] { sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          break;
        }
      }
    }
    paramBaseChatItemLayout = paramString;
    if (paramString == null) {
      paramBaseChatItemLayout = "";
    }
    paramString = paramBaseChatItemLayout;
    if (mye.a(paramChatMessage)) {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690055) + paramBaseChatItemLayout;
    }
    paramacun.jdField_b_of_type_JavaLangStringBuilder.insert(0, paramString);
  }
  
  public static boolean a(View paramView)
  {
    Object localObject = actn.a(paramView);
    if (localObject == null) {}
    while (!(localObject instanceof acun)) {
      return false;
    }
    paramView = (acun)actn.a(paramView);
    if ((paramView.jdField_a_of_type_Ambh == null) || (paramView.jdField_a_of_type_Ambh.jdField_a_of_type_Int <= 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(ChatMessage paramChatMessage, acun paramacun, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (axmt.b())
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
      Drawable localDrawable;
      if (bool)
      {
        i = 2130848929;
        localDrawable = ((Resources)localObject).getDrawable(i);
        if (!bool) {
          break label157;
        }
      }
      label157:
      for (int i = 2130848928;; i = 2130848752)
      {
        localObject = ((Resources)localObject).getDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
        paramacun.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramacun.jdField_a_of_type_Ambh = new ambh(0);
        a(paramacun, paramBaseChatItemLayout, paramChatMessage, paramacun.jdField_a_of_type_Ambh);
        a(paramacun, paramChatMessage);
        b(paramacun, paramChatMessage);
        return true;
        i = 2130848753;
        break;
      }
    }
    return false;
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun)
  {
    Object localObject1 = null;
    if (mye.a(paramChatMessage)) {
      localObject1 = mye.a(paramChatMessage).jdField_b_of_type_JavaLangString;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.jdField_a_of_type_AndroidContentResColorStateList;
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!paramChatMessage.isMultiMsg) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (mye.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        localObject2 = ColorStateList.valueOf(mye.jdField_d_of_type_Int);
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
          localObject3 = sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        }
        localObject1 = localObject3;
        if ((paramChatMessage instanceof MessageForStructing))
        {
          localObject1 = localObject3;
          if (baja.a(paramChatMessage)) {
            localObject1 = sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          }
        }
        Object localObject5 = bajb.a(paramChatMessage);
        localObject3 = localObject2;
        Object localObject4;
        if (localObject5 != null)
        {
          localObject4 = ((bajc)localObject5).jdField_c_of_type_JavaLangString;
          localObject1 = localObject4;
          localObject3 = localObject2;
          if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
          {
            localObject1 = localObject4;
            localObject3 = localObject2;
            if (!amon.a(paramChatMessage))
            {
              localObject3 = ColorStateList.valueOf(((bajc)localObject5).jdField_b_of_type_Int);
              localObject1 = localObject4;
            }
          }
        }
        int i;
        if ((paramChatMessage.istroop == 1) && (!mye.a(paramChatMessage)))
        {
          localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          bool3 = ((HotChatManager)localObject2).b(paramChatMessage.frienduin);
          if (bool3)
          {
            localObject2 = ((HotChatManager)localObject2).a(paramChatMessage.frienduin);
            if ((!bool3) || (localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
              break label859;
            }
            i = 1;
            label345:
            if (i == 0) {
              break label1026;
            }
            localObject2 = ColorStateList.valueOf(-1);
            if (paramChatMessage.isSend()) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            }
          }
        }
        label1026:
        for (;;)
        {
          if (((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) == 1)
          {
            i = 1;
            label398:
            localObject3 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
            if (i == 0) {
              break label871;
            }
            localObject3 = ((apyq)localObject3).jdField_d_of_type_JavaLangString;
            label428:
            if ((!paramChatMessage.isMultiMsg) || (mye.a(paramChatMessage))) {
              break label1023;
            }
            localObject4 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = asty.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (TextUtils.getTrimmedLength((CharSequence)localObject1) != 0) {}
            }
            else
            {
              localObject4 = asuf.a(paramChatMessage.senderuin);
            }
            localObject1 = new ayju((CharSequence)localObject4, 13).a();
          }
          label560:
          label582:
          label859:
          label871:
          label883:
          label1012:
          label1023:
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
                  if (((!bool2) || (!mye.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                    break label883;
                  }
                  bool4 = true;
                  paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool4, bool1, false, false, "", null, (String)localObject3);
                  localObject5 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                  localObject4 = (acuk)paramBaseChatItemLayout.getTag(2131364128);
                  localObject1 = localObject4;
                  if (localObject4 == null)
                  {
                    localObject1 = new acuk(this, null);
                    paramBaseChatItemLayout.setTag(2131364128, localObject1);
                  }
                  ((acuk)localObject1).jdField_a_of_type_Boolean = bool2;
                  ((acuk)localObject1).jdField_a_of_type_AndroidContentResColorStateList = ((ColorStateList)localObject2);
                  ((acuk)localObject1).jdField_b_of_type_Boolean = bool1;
                  ((acuk)localObject1).jdField_c_of_type_Boolean = false;
                  ((acuk)localObject1).jdField_a_of_type_JavaLangCharSequence = "";
                  ((acuk)localObject1).jdField_b_of_type_AndroidContentResColorStateList = null;
                  ((acuk)localObject1).d = false;
                  ((acuk)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
                  ((acuk)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
                  ((acuk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                  ((acuk)localObject1).jdField_a_of_type_Acun = paramacun;
                  ((TroopManager)localObject5).a(paramChatMessage.frienduin, paramChatMessage.senderuin, (akig)localObject1);
                }
              }
              else
              {
                bool1 = bahx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin);
                paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1, paramChatMessage.isSend());
                if (paramBaseChatItemLayout.f != null) {
                  paramBaseChatItemLayout.f.setOnClickListener(this);
                }
                if (paramBaseChatItemLayout.e != null)
                {
                  if (mye.a(paramChatMessage)) {
                    break label1012;
                  }
                  paramBaseChatItemLayout.e.setOnClickListener(this);
                  paramBaseChatItemLayout.e.setTag(Integer.valueOf(2131364127));
                }
              }
            }
            for (;;)
            {
              if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 14)) {
                paramBaseChatItemLayout.e.setAccessibilityDelegate(new acug(this));
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
                if (((!bool2) || (!mye.b(paramChatMessage))) && (!amon.c(paramChatMessage)) && (!paramChatMessage.isSend())) {
                  break label1006;
                }
              }
              for (bool2 = true;; bool2 = false)
              {
                paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool2, bool1, false, false, "", null, (String)localObject3);
                a(((CharSequence)localObject1).toString(), paramChatMessage, paramBaseChatItemLayout, paramacun);
                if ((!paramChatMessage.isMultiMsg) || (mye.a(paramChatMessage))) {
                  break;
                }
                bboe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout.e, (Spannable)localObject1);
                break;
                bool3 = false;
                break label902;
              }
              paramBaseChatItemLayout.e.setOnClickListener(null);
            }
          }
          label902:
          label1006:
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private final boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPoke)) {}
    while ((paramChatMessage instanceof MessageForPokeEmo)) {
      return true;
    }
    return false;
  }
  
  private boolean b(ChatMessage paramChatMessage, acun paramacun, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (amns.a(paramChatMessage))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130848929;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label156;
        }
      }
      label156:
      for (int i = 2130848928;; i = 2130848752)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramacun.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramacun.jdField_a_of_type_Ambh = new ambh(0);
        a(paramacun, paramBaseChatItemLayout, paramChatMessage, paramacun.jdField_a_of_type_Ambh);
        a(paramacun, paramChatMessage);
        b(paramacun, paramChatMessage);
        return true;
        i = 2130848753;
        break;
      }
    }
    return false;
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = asty.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() != 0) {}
    }
    else
    {
      localObject2 = asuf.a(paramChatMessage.senderuin);
    }
    paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
    a((String)localObject2, paramChatMessage, paramBaseChatItemLayout, paramacun);
  }
  
  private boolean c(ChatMessage paramChatMessage, acun paramacun, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (arqn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130848929;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label159;
        }
      }
      label159:
      for (int i = 2130848928;; i = 2130848752)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramacun.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramacun.jdField_a_of_type_Ambh = new ambh(0);
        a(paramacun, paramBaseChatItemLayout, paramChatMessage, paramacun.jdField_a_of_type_Ambh);
        a(paramacun, paramChatMessage);
        b(paramacun, paramChatMessage);
        return true;
        i = 2130848753;
        break;
      }
    }
    return false;
  }
  
  private boolean d(ChatMessage paramChatMessage, acun paramacun, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      if (paramChatMessage.istroop == 1) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject = paramacun.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838054);
        paramacun.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
        paramacun.jdField_a_of_type_Ambh = new ambh(0);
        a(paramacun, paramBaseChatItemLayout, paramChatMessage, paramacun.jdField_a_of_type_Ambh);
        a(paramacun, paramChatMessage);
        b(paramacun, paramChatMessage);
        return true;
        if (paramChatMessage.istroop == 3000) {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 2, 0, "", "", "", "");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramChatMessage.isShowQIMStyleGroup = aekr.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (paramChatMessage.isShowQIMStyleGroup)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 3, 0, "", "", "", "");
        boolean bool;
        int i;
        Drawable localDrawable1;
        label324:
        Drawable localDrawable2;
        if ((!(this instanceof aebz)) || ((this instanceof aeci)))
        {
          bool = paramChatMessage.isSend();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)
          {
            localObject = paramacun.jdField_a_of_type_AndroidViewView.getResources();
            if (bool)
            {
              i = 2130848929;
              localDrawable1 = ((Resources)localObject).getDrawable(i);
              localObject = paramacun.jdField_a_of_type_AndroidViewView.getResources();
              if (!bool) {
                break label428;
              }
              i = 2130848928;
              localDrawable2 = ((Resources)localObject).getDrawable(i);
              localObject = new StateListDrawable();
              ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
              ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            }
          }
        }
        for (;;)
        {
          paramacun.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          paramacun.jdField_a_of_type_Ambh = new ambh(0);
          a(paramacun, paramBaseChatItemLayout, paramChatMessage, paramacun.jdField_a_of_type_Ambh);
          a(paramacun, paramChatMessage);
          b(paramacun, paramChatMessage);
          return true;
          i = 2130848753;
          break;
          label428:
          i = 2130848752;
          break label324;
          localObject = SkinEngine.getInstances();
          if (bool)
          {
            i = 2130848929;
            label451:
            localDrawable1 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = SkinEngine.getInstances();
            if (!bool) {
              break label536;
            }
          }
          label536:
          for (i = 2130848928;; i = 2130848752)
          {
            localDrawable2 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = new StateListDrawable();
            ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
            ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            break;
            i = 2130848753;
            break label451;
          }
          if (!paramChatMessage.isSend()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label583;
            }
            localObject = paramacun.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838053);
            break;
          }
          label583:
          localObject = paramacun.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838054);
        }
      }
    }
    return false;
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
        paramChatMessage = ajyc.a(2131700932);
        i = 0;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a(paramChatMessage, i);
      return;
      if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
      {
        paramChatMessage = ajyc.a(2131700934);
        i = 1;
      }
      else if ((localHotChatInfo.isRobotHotChat) && (((balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).b(paramChatMessage.senderuin)))
      {
        paramChatMessage = ajyc.a(2131700940);
        i = 0;
      }
      else
      {
        i = 0;
        paramChatMessage = null;
      }
    }
  }
  
  private void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    int j;
    int k;
    myf localmyf;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (mye.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      bool = true;
      j = -1;
      if (bool) {
        j = mye.jdField_e_of_type_Int;
      }
      if (!mye.a(paramChatMessage)) {
        break label153;
      }
      k = azrd.a().jdField_a_of_type_Int;
      localmyf = mye.a(paramChatMessage);
      i = k;
    }
    label153:
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          try
          {
            if (!TextUtils.isEmpty(localmyf.jdField_c_of_type_JavaLangString)) {
              i = Color.parseColor(localmyf.jdField_c_of_type_JavaLangString);
            }
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690048), mye.b(paramChatMessage), i, j);
            paramBaseChatItemLayout.c.setOnClickListener(null);
            return;
            bool = false;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              i = k;
            }
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
          localObject = bajb.a(paramChatMessage);
          if (localObject != null)
          {
            j = ((bajc)localObject).jdField_c_of_type_Int;
            i = ((bajc)localObject).jdField_d_of_type_Int;
            if (bool)
            {
              j = mye.jdField_e_of_type_Int;
              i = azrd.a().jdField_a_of_type_Int;
            }
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((bajc)localObject).jdField_d_of_type_JavaLangString, false, i, j);
            paramBaseChatItemLayout.c.setOnClickListener(this);
            paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131364148));
            return;
          }
        } while (paramChatMessage.istroop != 1);
        paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
        this.jdField_f_of_type_Boolean = false;
      } while (localTroopManager == null);
      localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
      localObject = (balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    } while ((localTroopInfo == null) || ((localTroopInfo.cGroupRankSysFlag != 1) && (!((balw)localObject).b(paramChatMessage.senderuin)) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop())));
    acuj localacuj = (acuj)paramBaseChatItemLayout.getTag(2131364148);
    Object localObject = localacuj;
    if (localacuj == null)
    {
      localObject = new acuj(this, null);
      paramBaseChatItemLayout.setTag(2131364148, localObject);
    }
    ((acuj)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    ((acuj)localObject).jdField_a_of_type_Boolean = bool;
    ((acuj)localObject).jdField_a_of_type_Int = j;
    ((acuj)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (akig)localObject);
  }
  
  private void g(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramChatMessage.frienduin);
    if (localObject != null)
    {
      bool = ((HotChatInfo)localObject).isGameRoom;
      if (!bool) {
        break label105;
      }
      localObject = ((bcic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((bcis)localObject).a(paramChatMessage.senderuin);
        if (TextUtils.isEmpty(paramChatMessage)) {
          break label94;
        }
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, paramChatMessage);
      }
    }
    label94:
    label105:
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
      paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131364146));
      return;
    }
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public acum a(View paramView)
  {
    return null;
  }
  
  protected abstract acun a();
  
  protected Drawable a(BaseChatItemLayout paramBaseChatItemLayout, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Baxk == null) {
      return null;
    }
    acun localacun = (acun)paramBaseChatItemLayout.getTag();
    if (localacun != null)
    {
      localacun.jdField_a_of_type_JavaLangString = paramString;
      localacun.jdField_d_of_type_Int = paramInt;
      paramBaseChatItemLayout.setTag(localacun);
    }
    paramBaseChatItemLayout = this.jdField_a_of_type_Baxk.b(paramInt, paramString, 6);
    if (paramBaseChatItemLayout == null)
    {
      if (!this.jdField_a_of_type_Baxk.a()) {
        this.jdField_a_of_type_Baxk.a(paramString, paramInt, true);
      }
      return bbdr.b();
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBaseChatItemLayout);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1 + ", msgseq = " + paramChatMessage.msgseq + ", shmsgseq = " + paramChatMessage.shmsgseq);
    }
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramView = (BaseChatItemLayout)paramView;
      bool = AppSetting.d;
      if (paramView == null)
      {
        paramView = new BaseChatItemLayout(localContext);
        paramView.setId(2131363077);
        paramView.setFocusableInTouchMode(true);
        localObject1 = a();
        paramView.setTag(localObject1);
        ((acun)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
        if (!bool) {
          break label1325;
        }
        ((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, BaseChatItemLayout.v);
        if ((bool) && (((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder == null)) {
          ((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        ((acun)localObject1).jdField_b_of_type_Int = paramInt1;
        ((acun)localObject1).jdField_c_of_type_Int = paramInt2;
        localObject2 = null;
        localObject3 = localObject2;
        if (bool)
        {
          paramView.setContentDescription(null);
          if (!TextUtils.isEmpty(((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder)) {
            ((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder.replace(0, ((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
      label1325:
      for (;;)
      {
        try
        {
          boolean bool;
          Object localObject2 = bbkb.a(localContext, 3, paramChatMessage.time * 1000L);
          ((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder.append(" ").append((CharSequence)localObject2).append(" ");
          Object localObject3 = localObject2;
          ((acun)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          if (paramChatMessage.isSend())
          {
            i = 1;
            paramView.setHearIconPosition(i);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv != null)
            {
              ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Acuv.jdField_a_of_type_AndroidContentResColorStateList;
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
                    if (mye.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                      localObject2 = ColorStateList.valueOf(mye.jdField_d_of_type_Int);
                    }
                  }
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
                localObject2 = ColorStateList.valueOf(mye.jdField_d_of_type_Int);
              }
              paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage, (ColorStateList)localObject2, localObject3);
            }
            if (!baja.a(paramChatMessage)) {
              continue;
            }
            paramView.setGrayTipsText(true, paramChatMessage, localContext.getString(2131696725), this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165359), 0);
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
            ((acun)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(null);
            paramViewGroup = a(paramChatMessage, (acun)localObject1, ((acun)localObject1).jdField_a_of_type_AndroidViewView, paramView, paramacxn);
            ((acun)localObject1).jdField_a_of_type_AndroidViewView = paramViewGroup;
            a(paramViewGroup, paramView);
            a(paramChatMessage, localContext, paramView, (acun)localObject1, paramInt1, paramInt2);
            if (bool)
            {
              ((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
              paramacxn = Spannable.Factory.getInstance().newSpannable(((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder.toString());
              if (!Linkify.addLinks(paramacxn, 15)) {
                continue;
              }
              paramView.setContentDescription(paramacxn);
              paramView.setFocusable(true);
            }
            ((acun)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a();
            bbjv.a(null, "AIO_Handle_Sticker_Cost");
            long l = System.currentTimeMillis();
            a(localContext, paramViewGroup, paramChatMessage, paramView, (acun)localObject1);
            bbjv.a("AIO_Handle_Sticker_Cost", null);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleStickers time cost : " + (System.currentTimeMillis() - l) + " ms");
            }
            if ((!paramChatMessage.mMsgAnimFlag) || (paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null) || (b(paramChatMessage))) {
              continue;
            }
            paramChatMessage.mMsgAnimFlag = false;
            paramInt2 = actn.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
            localObject2 = (acun)paramView.getTag();
            localObject1 = localObject2;
            if (!a((acun)localObject2))
            {
              QLog.e("BubbleView", 1, "getView checkHolderTypeOk failed holder :" + localObject2 + "  this:" + this);
              localObject2 = a();
              paramView.setTag(localObject2);
              ((acun)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
              localObject1 = localObject2;
              if (bool)
              {
                ((acun)localObject2).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
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
          paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165359), 235);
          continue;
          if (paramChatMessage.fakeSenderType == 2)
          {
            if (mye.a(paramChatMessage)) {
              b(paramChatMessage, paramView, (acun)localObject1);
            } else {
              c(paramChatMessage, paramView, (acun)localObject1);
            }
          }
          else if (((paramChatMessage.istroop == 0) || (paramChatMessage.istroop == 3000)) && (paramChatMessage.isMultiMsg))
          {
            c(paramChatMessage, paramView, (acun)localObject1);
          }
          else if (paramChatMessage.istroop == 1)
          {
            paramViewGroup = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
            if ((paramViewGroup != null) && (paramViewGroup.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              e(paramChatMessage, paramView);
              g(paramChatMessage, paramView);
              b(paramChatMessage, paramView, (acun)localObject1);
              b(paramChatMessage, paramView);
            }
            else
            {
              f(paramChatMessage, paramView);
            }
          }
          else
          {
            a(paramChatMessage, paramView, (acun)localObject1);
            continue;
            c(paramChatMessage, paramView);
            continue;
            paramView.setContentDescription(((acun)localObject1).jdField_b_of_type_JavaLangStringBuilder.toString());
            continue;
            paramView.a(paramChatMessage);
          }
        }
      }
    }
  }
  
  protected abstract View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn);
  
  protected abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    bbeq.a().a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131375123: 
      b(paramChatMessage);
      return;
    case 2131362357: 
      e(paramChatMessage);
      return;
    }
    c(paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    if (!asuf.a(paramChatMessage)) {}
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
  
  protected void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh) {}
  
  protected void a(acun paramacun, ChatMessage paramChatMessage) {}
  
  protected void a(View paramView) {}
  
  public void a(View paramView, acxn paramacxn)
  {
    if (bbas.a(false))
    {
      bbav localbbav = new bbav();
      bbas.a(this.jdField_a_of_type_AndroidContentContext, localbbav, paramacxn);
      paramView.setOnTouchListener(localbbav);
      paramView.setOnLongClickListener(localbbav);
      return;
    }
    paramView.setOnTouchListener(paramacxn);
    paramView.setOnLongClickListener(paramacxn);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.g;
    int i = j;
    if (axwz.a(paramChatMessage)) {
      i = j - actn.a(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, i, BaseChatItemLayout.i, BaseChatItemLayout.jdField_h_of_type_Int);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, i, BaseChatItemLayout.j, BaseChatItemLayout.jdField_h_of_type_Int);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    c(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) || (paramambh == null)) {
      return;
    }
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject3 = null;
    ambe localambe = null;
    Pair localPair = null;
    BubbleManager localBubbleManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    Object localObject2;
    label63:
    Object localObject1;
    if (ayla.a(paramChatMessage.msg))
    {
      localObject2 = ayla.b(paramChatMessage.msg);
      if ((localBubbleManager == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label881;
      }
      localObject1 = localBubbleManager.a(paramambh.jdField_a_of_type_Int, false);
      if ((localObject1 == null) || (((ambe)localObject1).b == null) || (!((ambe)localObject1).a((String)localObject2))) {
        break label881;
      }
    }
    label384:
    label851:
    label857:
    label863:
    label870:
    label881:
    for (int i = 1;; i = 0)
    {
      localObject1 = localambe;
      int j = k;
      Object localObject4;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject4 = paramambh.a((String)localObject2);
        localObject1 = localambe;
        localObject3 = localObject4;
        j = k;
        if (localObject4 != null)
        {
          localObject1 = paramambh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          if ((localObject1 == null) || (((Pair)localObject1).first == null)) {
            break label870;
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
          localPair = paramambh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
          if ((localPair == null) || (localPair.first == null)) {
            break label863;
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
              if (bfni.e())
              {
                localObject2 = paramambh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
                m = n;
                if (localObject2 != null)
                {
                  m = n;
                  if (((Pair)localObject2).first != null)
                  {
                    m = n;
                    if (paramView.getWidth() > ((ambi)((Pair)localObject2).first).a.j) {
                      m = 1;
                    }
                  }
                }
              }
            }
          }
          if ((localBubbleManager != null) && ((paramChatMessage instanceof MessageForText)))
          {
            localambe = localBubbleManager.a(paramambh.jdField_a_of_type_Int, false);
            if ((localambe != null) && (localambe.f != null) && (localambe.f.k != 0) && (bfni.e())) {
              if (paramChatMessage.isSend())
              {
                localObject2 = paramChatMessage.selfuin;
                localObject4 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (localObject4 == null) {
                  break label857;
                }
                localObject2 = ((ajxn)localObject4).a((String)localObject2);
                if ((localObject2 == null) || ((localambe.f.k != -1) && (((ExtensionInfo)localObject2).pendantId != localambe.f.k))) {
                  break label857;
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (i != 0)
            {
              long l = ambj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              if (l != -1L) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
              }
            }
            if ((j != 0) || (m != 0) || (n != 0) || (k != 0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
            }
            if (j != 0)
            {
              a("keyword_trigger", paramambh.jdField_a_of_type_Int, localObject3);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject1 });
            }
            if (k != 0) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(6), Long.valueOf(paramChatMessage.uniseq), localPair });
            }
            if ((m != 0) || (n != 0)) {
              if (m == 0) {
                break label851;
              }
            }
            for (i = 3;; i = 5)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramambh.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
              if (!paramambh.a(paramView.getHeight())) {
                break;
              }
              paramView = paramambh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
              if ((paramView == null) || (paramView.first == null)) {
                break;
              }
              a("wordnum_trigger", paramambh.jdField_a_of_type_Int, null);
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
  
  protected void a(View paramView, ChatMessage paramChatMessage, ambh paramambh, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {}
    do
    {
      return;
      paramView = paramambh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    } while ((paramView == null) || (paramView.first == null));
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  protected void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (!baic.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramMessageRecord = ((baic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord);
      if ((paramMessageRecord != null) && (paramMessageRecord.jdField_b_of_type_Int != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new baie(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), paramMessageRecord.jdField_c_of_type_Int, paramMessageRecord.jdField_d_of_type_Int, 17);
        paramTextView.setTag(2131366359, "school_troop_span");
      }
    } while (!QLog.isColorLevel());
    QLog.i("school_troop.BaseBubbleBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
  }
  
  public void a(baxk parambaxk)
  {
    this.jdField_a_of_type_Baxk = parambaxk;
  }
  
  protected void a(bblr parambblr, int paramInt, MessageRecord paramMessageRecord)
  {
    if (!a(paramMessageRecord)) {}
    do
    {
      do
      {
        return;
        if ((!paramMessageRecord.isSend()) && (!bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          this.d = false;
          return;
        }
        if (mye.a(paramMessageRecord))
        {
          this.d = false;
          return;
        }
        if (akpy.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1032)
        {
          this.d = false;
          return;
        }
        localObject = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!((ajxn)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
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
        paramInt = paramMessageRecord.istroop;
      } while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000) && (paramInt != 1000) && (paramInt != 1004));
      parambblr.a(2131370494, this.jdField_a_of_type_AndroidContentContext.getString(2131694425), 2130838612);
      this.d = true;
    } while (!bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject = new axra(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
    String str = paramMessageRecord.frienduin;
    if (bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
    for (parambblr = "1";; parambblr = "2")
    {
      ((axra)localObject).a(new String[] { str, parambblr }).a();
      return;
    }
  }
  
  public void a(bblr parambblr, MessageRecord paramMessageRecord)
  {
    if ((!this.d) || ((paramMessageRecord != null) && (!paramMessageRecord.isSend()))) {
      aaod.a(parambblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    this.d = false;
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    int i;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      BaseChatPie localBaseChatPie = null;
      if (localChatFragment != null) {
        localBaseChatPie = localChatFragment.a();
      }
      if (localBaseChatPie != null) {
        ((adha)localBaseChatPie.a(46)).a(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label116;
      }
      i = 6;
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + i, "", "", "");
      return;
      label116:
      if ((paramChatMessage instanceof MessageForText)) {
        i = 1;
      } else if ((paramChatMessage instanceof MessageForPic)) {
        i = 3;
      } else if ((paramChatMessage instanceof MessageForMarketFace)) {
        i = 4;
      } else if ((paramChatMessage instanceof MessageForApollo)) {
        i = 5;
      } else {
        i = 0;
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool1 = false;; bool1 = true) {
      try
      {
        j = a(paramChatMessage);
        paramacun.jdField_a_of_type_Int = j;
        if (j != 0) {
          if (a(paramChatMessage, paramacun, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setSimpleUIMsgBubble " + paramChatMessage.getLogColorContent());
            }
            if (paramacun.jdField_a_of_type_AndroidViewView != null)
            {
              paramBaseChatItemLayout.setBubbleView(paramacun.jdField_a_of_type_AndroidViewView);
              a(paramacun.jdField_a_of_type_AndroidViewView, paramChatMessage);
              paramacun.jdField_a_of_type_AndroidViewView.setTag(2131363708, paramacun.jdField_a_of_type_Ambh);
              paramacun.jdField_a_of_type_AndroidViewView.setTag(2131364153, paramChatMessage);
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
          int j = 0;
          continue;
          if (b(paramChatMessage, paramacun, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setConfessMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (d(paramChatMessage, paramacun, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setQimMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (c(paramChatMessage, paramacun, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setLimitChatMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else
          {
            label453:
            int i;
            if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!amns.a(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
            {
              localObject = lbs.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
              paramContext = null;
              lbk locallbk = lbo.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
              if (locallbk != null) {
                paramContext = locallbk.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
              }
              if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
              {
                paramacun.jdField_a_of_type_Ambh = amch.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
                if (paramacun.jdField_a_of_type_Ambh != null) {
                  paramacun.jdField_a_of_type_Ambh.a(paramacun.jdField_a_of_type_AndroidViewView, null);
                }
                if (paramacun.jdField_a_of_type_AndroidViewView != null)
                {
                  paramacun.jdField_a_of_type_AndroidViewView.setMinimumWidth(actn.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                  paramacun.jdField_a_of_type_AndroidViewView.setMinimumHeight(actn.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                }
                if (paramacun.jdField_a_of_type_Ambh != null)
                {
                  int k = paramChatMessage.vipBubbleDiyTextId;
                  i = k;
                  if (k <= 0) {
                    i = akfw.b(paramChatMessage.vipBubbleID);
                  }
                  if (paramChatMessage.fakeSenderType != 1) {
                    break label852;
                  }
                  paramContext = paramacun.jdField_a_of_type_Ambh;
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  bool2 = paramChatMessage.isSend();
                  bool3 = paramChatMessage.needVipBubble();
                  if (j != 2) {
                    break label846;
                  }
                }
              }
            }
            label846:
            for (bool1 = true;; bool1 = false)
            {
              paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramacun.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i);
              if (paramacun.jdField_a_of_type_AndroidViewView != null)
              {
                paramContext = paramacun.jdField_a_of_type_AndroidViewView.getBackground();
                if (paramContext != null) {
                  paramContext.setAlpha(jdField_a_of_type_Int);
                }
              }
              a(paramacun, paramBaseChatItemLayout, paramChatMessage, paramacun.jdField_a_of_type_Ambh);
              a(paramacun, paramChatMessage);
              b(paramacun, paramChatMessage);
              if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
                jdField_a_of_type_AndroidOsHandler.post(new BaseBubbleBuilder.5(this, paramacun, paramChatMessage));
              }
              paramChatMessage.mAnimFlag = false;
              break;
              paramacun.jdField_a_of_type_Ambh = amch.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
              break label453;
              if ((j == 3) || (!paramChatMessage.needVipBubble()) || (amns.a(paramChatMessage))) {
                i = 0;
              }
              for (;;)
              {
                paramacun.jdField_a_of_type_Ambh = amch.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
                break;
                localObject = (akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
                if (paramChatMessage.fakeSenderType == 1) {
                  i = ((akfw)localObject).b();
                } else {
                  i = ((akfw)localObject).a(paramChatMessage);
                }
              }
            }
            label852:
            paramContext = paramacun.jdField_a_of_type_Ambh;
            Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            boolean bool2 = paramChatMessage.isSend();
            boolean bool3 = paramChatMessage.needVipBubble();
            if (j == 2) {}
            for (bool1 = true;; bool1 = false)
            {
              paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramacun.jdField_a_of_type_AndroidViewView, ho.a(paramChatMessage), i);
              break;
            }
            if (paramacun.jdField_a_of_type_AndroidViewView == null)
            {
              QLog.e("ChatItemBuilder", 1, "handleBubbleBg mContent is null type = " + paramChatMessage.istroop);
              return;
            }
            paramacun.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, bblr parambblr)
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
        parambblr.a(2131375123, this.jdField_a_of_type_AndroidContentContext.getString(2131697931), 2130838610);
        MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
    parambblr.a(2131375123, this.jdField_a_of_type_AndroidContentContext.getString(2131697931), 2130838610);
    MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((amns.a(paramChatMessage)) && (QLog.isColorLevel())) {
      QLog.d("ChatItemBuilder", 2, "confessType =  " + paramChatMessage.istroop + " isSend = " + paramChatMessage.isSend());
    }
    Object localObject1;
    if (paramChatMessage.fakeSenderType == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramBaseChatItemLayout.setHeaderIcon(baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject1));
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
    }
    for (;;)
    {
      return;
      int i;
      if (amns.a(paramChatMessage))
      {
        if (((amno)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.getConfessTopicId()).confessorSex == 1) {}
        for (i = 2130844160;; i = 2130844159)
        {
          paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
          return;
        }
      }
      Object localObject3;
      if (mye.a(paramChatMessage))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843043);
        localObject3 = mye.a(paramChatMessage);
        paramChatMessage = URLDrawable.getDrawable(mye.a(((myf)localObject3).jdField_b_of_type_Int), (Drawable)localObject1, (Drawable)localObject1);
        localObject1 = ((myf)localObject3).jdField_c_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      try
      {
        i = bawz.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        paramChatMessage.setTag(new int[] { Color.parseColor((String)localObject1), i });
        paramChatMessage.setDecodeHandler(bavi.q);
        paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
        return;
        if (((paramChatMessage instanceof MessageForStructing)) && (baja.a(paramChatMessage)))
        {
          paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840076));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
          return;
        }
        localObject1 = bajb.a(paramChatMessage);
        if (localObject1 != null)
        {
          localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839736);
          paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
          paramChatMessage.mFailedDrawable = ((Drawable)localObject3);
          paramChatMessage.mLoadingDrawable = ((Drawable)localObject3);
          for (;;)
          {
            try
            {
              paramChatMessage = URLDrawable.getDrawable(new URL(((bajc)localObject1).jdField_a_of_type_JavaLangString), paramChatMessage);
              localMalformedURLException1.printStackTrace();
            }
            catch (MalformedURLException localMalformedURLException1)
            {
              try
              {
                paramChatMessage.setTag(bavi.b(100, 100, 6));
                paramChatMessage.setDecodeHandler(bavi.a);
                paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
                if (paramChatMessage == null) {
                  break label494;
                }
                paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
                paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
                paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
                return;
              }
              catch (MalformedURLException localMalformedURLException2)
              {
                int k;
                String str;
                Object localObject2;
                int j;
                break label486;
              }
              localMalformedURLException1 = localMalformedURLException1;
              paramChatMessage = null;
            }
            label486:
            continue;
            label494:
            paramBaseChatItemLayout.setHeaderIcon(localObject3);
          }
        }
        k = paramChatMessage.istroop;
        if (paramChatMessage.isSend())
        {
          str = paramChatMessage.selfuin;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, false);
          if ((localObject2 != null) && (((ExtensionInfo)localObject2).faceIdUpdateTime < paramChatMessage.time))
          {
            localObject3 = paramChatMessage.getExtInfoFromExtStr("vip_face_id");
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id = " + (String)localObject3);
            }
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (Long.parseLong((String)localObject3) != ((ExtensionInfo)localObject2).faceId))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id not equals local");
              }
              bbby.a(str);
              bbby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          localObject2 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          localObject3 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          if ((localObject3 == null) || (!((HotChatManager)localObject3).b(paramChatMessage.frienduin))) {
            break label1392;
          }
          i = 1;
          label693:
          if ((localObject2 == null) || (!((ajxn)localObject2).b(str))) {
            break label1397;
          }
          j = 1;
          label711:
          if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) && ((k != 1022) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 4007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3019) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2019)))) || (localObject2 == null) || (((ajxn)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label1439;
          }
          localObject3 = ((HotChatManager)localObject3).a(paramChatMessage.frienduin);
          if ((localObject3 == null) || (!((HotChatInfo)localObject3).isGameRoom)) {
            break label1421;
          }
          if ((!((ajxn)localObject2).b(str)) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            break label1403;
          }
          localObject3 = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
          label913:
          localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + str);
            localObject2 = localObject3;
          }
          label955:
          paramBaseChatItemLayout.setHeaderIcon(localObject2);
          if ((paramChatMessage.isSendFromLocal()) || ((k != 1) && (k != 3000) && (k != 0) && (k != 1005) && (k != 1001) && (k != 1006) && (k != 1000) && (k != 10004) && (k != 1004) && (k != 1008) && (k != 1009) && (k != 1010) && (k != 1011) && (k != 1020) && (k != 1021) && (k != 1023) && (k != 1024) && (k != 1036) && (k != 1025) && (k != 10002) && (k != 1022))) {
            break label1628;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin))
          {
            localObject2 = paramChatMessage.frienduin;
            localObject3 = paramChatMessage.senderuin;
            ThreadManager.executeOnSubThread(new BaseBubbleBuilder.ProcessMemberNickTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, (String)localObject2, (String)localObject3, k, this.jdField_a_of_type_AndroidViewView$OnLongClickListener));
          }
          label1189:
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "AppSetting.enableTalkBack = " + AppSetting.d);
          }
          if (!AppSetting.d) {
            continue;
          }
          localObject3 = "";
          localObject2 = localObject3;
          if (paramChatMessage.istroop != 1)
          {
            localObject2 = localObject3;
            if (paramChatMessage.istroop != 3000) {
              if (!paramChatMessage.isSend()) {
                break label1639;
              }
            }
          }
        }
        label1421:
        label1439:
        label1628:
        label1639:
        for (localObject2 = ajyc.a(2131700936);; localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString + ajyc.a(2131700939))
        {
          if (paramChatMessage.msgtype == -3006) {
            localObject2 = String.format(paramBaseChatItemLayout.getResources().getString(2131697915), new Object[] { sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setContentDescription((CharSequence)localObject2);
          return;
          if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
          {
            str = paramChatMessage.frienduin;
            break;
          }
          str = paramChatMessage.senderuin;
          break;
          label1392:
          i = 0;
          break label693;
          label1397:
          j = 0;
          break label711;
          label1403:
          localObject3 = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, str, true);
          break label913;
          localObject3 = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, str, true);
          break label913;
          if ((k == 9501) && (!paramChatMessage.isSend()))
          {
            localObject2 = ((yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(str));
            if ((localObject2 != null) && (str.equals(String.valueOf(((DeviceInfo)localObject2).din))))
            {
              localObject2 = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.getInstance().getDeviceHeadByDin(str));
              break label955;
            }
            localObject2 = a(paramBaseChatItemLayout, 1, str);
            break label955;
          }
          if (k != 1006) {
            break label1683;
          }
          i = 11;
          localObject2 = a(paramBaseChatItemLayout, i, str);
          localObject3 = new bbsi(str, -1, "small", paramChatMessage.uniseq);
          ((bbsi)localObject3).a = ((Drawable)localObject2);
          localObject2 = localObject3;
          if (!QLog.isColorLevel()) {
            break label955;
          }
          QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + str);
          localObject2 = localObject3;
          break label955;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
          break label1189;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label1683:
          i = 1;
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (axmt.b()) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if ((paramChatMessage == null) || (paramChatMessage.isShowQimStyleAvater) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) || (amns.a(paramChatMessage)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1044) || (paramChatMessage.fakeSenderType != 0))
        {
          paramBaseChatItemLayout.setPendantImageVisible(false);
          return;
        }
      } while (actn.h);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject != null) && (((TroopInfo)localObject).hasOrgs()));
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (mye.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    ajxn localajxn;
    ExtensionInfo localExtensionInfo;
    AvatarPendantManager localAvatarPendantManager;
    String str;
    if (paramChatMessage.isSend())
    {
      localObject = paramChatMessage.selfuin;
      localajxn = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localajxn == null) {
        break label672;
      }
      localExtensionInfo = localajxn.a((String)localObject, false);
      localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
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
          bbby.a((String)localObject);
          bbby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_diy_id");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message pendantDiyId = " + str);
        }
        if (TextUtils.isEmpty(str)) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(str) != localExtensionInfo.pendantDiyId)
        {
          bbby.a((String)localObject);
          bbby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
        {
          AvatarPendantManager.jdField_b_of_type_Boolean = true;
          if (bbby.a(localExtensionInfo.pendantId))
          {
            localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq, (String)localObject, localExtensionInfo.pendantDiyId);
            if ((!localajxn.b((String)localObject)) && (localExtensionInfo.isPendantExpired())) {
              bbby.a((String)localObject);
            }
            if ((!localAvatarPendantManager.a(paramChatMessage.uniseq)) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)) {
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
            }
            paramChatMessage.mPendantAnimatable = false;
            return;
            if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
            {
              localObject = paramChatMessage.frienduin;
              break;
            }
            localObject = paramChatMessage.senderuin;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ChatItemBuilder", 1, "parse vip_pendant_diy_id field failed, value=" + str);
        continue;
        localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 1, paramChatMessage.uniseq, (String)localObject, localExtensionInfo.pendantDiyId);
        continue;
        if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        }
        if (localExtensionInfo != null) {
          continue;
        }
        bbby.a((String)localObject);
        continue;
      }
      label672:
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, acwf paramacwf)
  {
    awan localawan = (awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    if ((paramMessageRecord.extraflag != 32772) || (!localawan.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.uniseq, paramView, paramacwf)))
    {
      paramMessageRecord = acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramacwf);
      }
    }
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.jdField_a_of_type_Boolean;
  }
  
  public boolean a(acun paramacun)
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
    boolean bool = bamn.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    for (this.d = true;; this.d = false) {
      return this.d;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected void b(acun paramacun, ChatMessage paramChatMessage) {}
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = actn.a(paramView);
    if (localChatMessage == null) {}
    label11:
    Object localObject4;
    boolean bool2;
    label404:
    label406:
    label967:
    boolean bool1;
    label1156:
    label1380:
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            break label11;
            break label11;
            break label11;
            break label11;
            break label11;
            break label11;
            for (;;)
            {
              return;
              if ((!bbbd.b(localChatMessage.senderuin)) || (!bbbd.a(this.jdField_a_of_type_AndroidContentContext))) {
                if (bahx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin))
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
                    bahx.a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, localChatMessage.senderuin);
                  }
                  while (QLog.isColorLevel())
                  {
                    QLog.d("ChatItemBuilder", 2, "openRobotProfileCard, robotuin:" + localChatMessage.senderuin + " frienduin:" + localChatMessage.frienduin);
                    return;
                    bahx.a(this.jdField_a_of_type_AndroidContentContext, null, localChatMessage.senderuin);
                  }
                }
                else
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString))) {
                    break;
                  }
                  localObject4 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                  if ((localChatMessage.issend == 1) || (localChatMessage.issend == 2)) {}
                  for (bool2 = true;; bool2 = false)
                  {
                    if (("10000".equals(localChatMessage.senderuin)) || ((localChatMessage.istroop == 3000) && (bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.frienduin))) || ((localChatMessage instanceof MessageForTroopConfess))) {
                      break label404;
                    }
                    localObject1 = bajb.a(localChatMessage);
                    if (localObject1 == null) {
                      break label406;
                    }
                    bajb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bajc)localObject1);
                    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, localChatMessage.frienduin, "", ((bajc)localObject1).jdField_c_of_type_JavaLangString, "");
                    if (localChatMessage.msgtype != -2051) {
                      break;
                    }
                    try
                    {
                      paramView = (MessageForQQStory)localChatMessage;
                      paramView = bbej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
                      QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_head", paramView, false);
                      return;
                    }
                    catch (Exception paramView) {}
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramView);
                    return;
                  }
                }
              }
            }
            if ((!(localChatMessage instanceof MessageForStructing)) || (!baja.a(localChatMessage))) {
              break;
            }
            localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          } while ((localObject1 == null) || (((TroopInfo)localObject1).associatePubAccount == 0L));
          localObject3 = new Intent(paramView.getContext(), AccountDetailActivity.class);
          ((Intent)localObject3).putExtra("uin", ((TroopInfo)localObject1).associatePubAccount + "");
          paramView.getContext().startActivity((Intent)localObject3);
          return;
          if (!mye.a(localChatMessage)) {
            break label1156;
          }
          localObject1 = mye.a(localChatMessage);
          if ((paramView != null) && ((((myf)localObject1).jdField_a_of_type_JavaLangString != null) || (((myf)localObject1).jdField_a_of_type_Int == 2))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("ChatItemBuilder", 2, "onHeadIconClick : an_id is null");
        return;
        localObject3 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(localChatMessage.frienduin);
        localObject4 = (akhq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        if (localObject3 != null)
        {
          ((akhq)localObject4).j(((TroopInfo)localObject3).troopuin);
          ((akhq)localObject4).a(1, ajsz.a(((TroopInfo)localObject3).troopuin), 0L, 2, 0, 0, true);
        }
        int j = 0;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        i = j;
        if (localObject3 != null)
        {
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            if ((((TroopInfo)localObject3).Administrator == null) || (!((TroopInfo)localObject3).Administrator.contains((CharSequence)localObject4))) {
              break label967;
            }
            i = 3;
          }
        }
        localObject3 = ((myf)localObject1).a();
        if ((localObject3 != null) && (((myf)localObject1).jdField_a_of_type_Int != 2))
        {
          localObject3 = URLEncoder.encode(Base64.encodeToString((byte[])localObject3, 2));
          localObject4 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          localStringBuilder = new StringBuilder().append("http://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject3).append("&gcode=").append(localChatMessage.frienduin).append("&avatar=").append(mye.a(((myf)localObject1).jdField_b_of_type_Int)).append("&nick=");
          if (TextUtils.isEmpty(((myf)localObject1).jdField_b_of_type_JavaLangString))
          {
            localObject1 = "";
            ((Intent)localObject4).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=0");
            ((Activity)paramView.getContext()).startActivity((Intent)localObject4);
            if (localChatMessage.msgData != null)
            {
              mye.a().a(localChatMessage.frienduin, (String)localObject3, localChatMessage);
              if (QLog.isDevelopLevel()) {
                QLog.i("ChatItemBuilder", 4, "report:" + localChatMessage.msgData.toString());
              }
            }
          }
        }
        while (((myf)localObject1).jdField_a_of_type_Int != 2) {
          for (;;)
          {
            StringBuilder localStringBuilder;
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, localChatMessage.frienduin, "", "", "");
            return;
            if (((String)localObject4).equals(((TroopInfo)localObject3).troopowneruin))
            {
              i = 2;
              break;
            }
            i = 1;
            break;
            localObject1 = URLEncoder.encode(((myf)localObject1).jdField_b_of_type_JavaLangString);
          }
        }
        localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        localObject4 = new StringBuilder().append("http://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(localChatMessage.frienduin).append("&avatar=").append(mye.a(((myf)localObject1).jdField_b_of_type_Int)).append("&nick=");
        if (TextUtils.isEmpty(((myf)localObject1).jdField_b_of_type_JavaLangString)) {}
        for (Object localObject1 = "";; localObject1 = URLEncoder.encode(((myf)localObject1).jdField_b_of_type_JavaLangString))
        {
          ((Intent)localObject3).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=1");
          ((Activity)paramView.getContext()).startActivity((Intent)localObject3);
          break;
        }
        if ("1000000".equals(localChatMessage.senderuin))
        {
          bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1");
          return;
        }
        localObject3 = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localObject1 != null) && (((HotChatManager)localObject1).b(localChatMessage.frienduin))) {}
        for (i = 1;; i = 0)
        {
          for (;;)
          {
            if ((i != 0) || (localChatMessage.istroop != 1)) {
              break label1380;
            }
            localObject1 = (balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
            try
            {
              long l = Long.parseLong(localChatMessage.senderuin);
              bool1 = ((balw)localObject1).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, l);
              if (bool1) {
                break;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.e("ChatItemBuilder", 2, "parseLong error: messageRecord.senderuin = " + localChatMessage.senderuin);
                }
              }
            }
          }
          auvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), localChatMessage.frienduin, localChatMessage.senderuin, 0, 2000);
          return;
        }
        if (i == 0) {
          break;
        }
        localObject2 = localException.a(localChatMessage.frienduin);
      } while ((localObject2 != null) && (((HotChatInfo)localObject2).isRobotHotChat) && (((balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin))));
      if ((!bool2) && ((localObject3 == null) || (((ajxn)localObject3).b(localChatMessage.senderuin)))) {
        break label1770;
      }
      paramView = null;
      if (localObject2 == null) {
        break;
      }
      paramView = ((HotChatInfo)localObject2).troopCode;
      if (!((HotChatInfo)localObject2).isGameRoom) {
        break;
      }
      localObject3 = (bcic)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107);
    } while ((((bcic)localObject3).jdField_a_of_type_JavaLangString != null) && (((bcic)localObject3).jdField_a_of_type_JavaLangString.equals(localChatMessage.senderuin)));
    bfmv.a();
    Object localObject3 = localChatMessage.senderuin;
    if ((localObject2 != null) && (((HotChatInfo)localObject2).isBuLuoHotChat()))
    {
      i = 86;
      localObject3 = new ProfileActivity.AllInOne((String)localObject3, i);
      ((ProfileActivity.AllInOne)localObject3).jdField_c_of_type_JavaLangString = paramView;
      ((ProfileActivity.AllInOne)localObject3).jdField_d_of_type_JavaLangString = localChatMessage.frienduin;
      if ((localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
        break label1740;
      }
      ((ProfileActivity.AllInOne)localObject3).jdField_h_of_type_Int = 113;
      label1601:
      ((ProfileActivity.AllInOne)localObject3).a = xkq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(localChatMessage.frienduin, localChatMessage.senderuin);
      HotChatManager.jdField_a_of_type_Boolean = false;
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      paramView.putExtra("AllInOne", (Parcelable)localObject3);
      if (localObject2 == null) {
        break label1750;
      }
      bool1 = ((HotChatInfo)localObject2).isGameRoom;
      label1680:
      paramView.putExtra("is_from_werewolves", bool1);
      if (!bool2) {
        break label1756;
      }
    }
    label1740:
    label1750:
    label1756:
    for (int i = 2;; i = 3)
    {
      paramView.putExtra("param_mode", i);
      if ((!bool2) || (localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
        break label1761;
      }
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject3);
      return;
      i = 42;
      break;
      ((ProfileActivity.AllInOne)localObject3).jdField_h_of_type_Int = 31;
      break label1601;
      bool1 = false;
      break label1680;
    }
    label1761:
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    return;
    label1770:
    if ((localObject2 != null) && (((HotChatInfo)localObject2).isGameRoom))
    {
      paramView = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
      paramView.jdField_c_of_type_JavaLangString = ((HotChatInfo)localObject2).troopCode;
      paramView.jdField_d_of_type_JavaLangString = localChatMessage.frienduin;
      paramView.jdField_h_of_type_Int = 113;
      paramView.a = xkq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, paramView);
      HotChatManager.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004))
    {
      bool1 = ((ajxn)localObject4).b(localChatMessage.senderuin);
      localObject3 = localChatMessage.senderuin;
      label1898:
      if (localObject3 == null) {
        break label2215;
      }
      if (!((ajxn)localObject4).b((String)localObject3)) {
        break label3805;
      }
      bool1 = true;
    }
    label1950:
    label2133:
    label3805:
    for (;;)
    {
      if (bool2)
      {
        localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        if (((String)localObject3).equals(((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString)) {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = null;
        }
        ((ProfileActivity.AllInOne)localObject2).a = xkq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ((ProfileActivity.AllInOne)localObject2).f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject2).jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020)) {
          break label3448;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_d_of_type_JavaLangString = localChatMessage.senderuin;
        label2037:
        ((ProfileActivity.AllInOne)localObject2).g = 2;
        if (localChatMessage.istroop != 0) {
          break label3508;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 1;
        if ((localChatMessage.istroop != 1001) && (localChatMessage.istroop != 1010) && (localChatMessage.istroop != 10002)) {
          break label3624;
        }
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
        if (localChatMessage.istroop != 1001) {
          break label3558;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 10;
        paramView.putExtra("frome_where", 21);
        ((ProfileActivity.AllInOne)localObject2).a = xkq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramView.putExtra("AllInOne", (Parcelable)localObject2);
        if (!bbbd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localObject3)) {
          break label3603;
        }
        paramView.putExtra("param_mode", 2);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break label3615;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 9009);
        return;
        localObject3 = localChatMessage.frienduin;
        bool1 = false;
        break label1898;
        break label11;
        if (localChatMessage.istroop == 1008)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("need_finish", true);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          sgj.a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 2, sgj.jdField_a_of_type_Boolean);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          nbc.a(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
          return;
        }
        if (bool1)
        {
          if (localChatMessage.istroop == 1) {
            localObject2 = new ProfileActivity.AllInOne((String)localObject3, 20);
          }
          for (;;)
          {
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3);
            break;
            if (localChatMessage.istroop == 3000) {
              localObject2 = new ProfileActivity.AllInOne((String)localObject3, 45);
            } else {
              localObject2 = new ProfileActivity.AllInOne((String)localObject3, 1);
            }
          }
        }
        if (localChatMessage.istroop == 1010)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 76);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 42);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 10002)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 86);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 10004)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 94);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 70);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3);
          break label1950;
        }
        if (localChatMessage.istroop == 1000)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 22);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1020)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 58);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 21);
          ((ProfileActivity.AllInOne)localObject2).l = 11;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, localChatMessage.senderuin);
          break label1950;
        }
        if (3000 == localChatMessage.istroop)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 46);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = bbcl.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.frienduin, localChatMessage.senderuin);
          break label1950;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 10002)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 86);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1004)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 47);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1005)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 2);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1023)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 74);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 57);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1006)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 34);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 57);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1021)
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 72);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        if (localChatMessage.istroop == 1022)
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 27);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
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
        if ((localChatMessage.istroop == 1037) || (localChatMessage.istroop == 1044))
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1950;
        }
        localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 19);
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1950;
        label3448:
        if (localChatMessage.istroop == 1)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject2).jdField_c_of_type_JavaLangString = localChatMessage.frienduin;
          break label2037;
        }
        if (3000 != localChatMessage.istroop) {
          break label2037;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break label2037;
        if (localChatMessage.istroop == 3000)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 107;
          break label2057;
        }
        if (localChatMessage.istroop == 1)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 108;
          break label2057;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 106;
        break label2057;
        label3558:
        if (localChatMessage.istroop == 1010)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 11;
          break label2133;
        }
        if (localChatMessage.istroop != 10002) {
          break label2133;
        }
        paramView.putExtra("frome_where", 22);
        break label2133;
        paramView.putExtra("param_mode", 3);
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      if ((!bool2) && (!((ajxn)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        localObject3 = aets.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, bool1, bool2);
        if (localObject3 == null) {
          break label3723;
        }
        ((ProfileActivity.AllInOne)localObject2).b.putSerializable("param_wzry_data", (Serializable)localObject3);
      }
      while (arqn.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
      {
        i = 0;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int == 20) {
          i = 1;
        }
        ProfileActivity.a(paramView.getContext(), (ProfileActivity.AllInOne)localObject2, i, 2);
        return;
        if (!TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("msg_ext_key")))
        {
          localObject3 = localChatMessage.senderuin;
          localObject3 = KplRoleInfo.WZRYUIinfo.createInfo((String)localObject3, KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3)), KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0);
          ((ProfileActivity.AllInOne)localObject2).b.putSerializable("param_wzry_data", (Serializable)localObject3);
        }
      }
      ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
      return;
    }
  }
  
  protected void b(bblr parambblr, Context paramContext)
  {
    parambblr.a(2131370598, ajyc.a(2131700935), 2130838614);
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
          vel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (MessageForStructing)localObject, "reply");
        }
      }
      adyh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, "0X800A368");
    }
  }
  
  protected void b(ChatMessage paramChatMessage, bblr parambblr)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if ((!bahx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)) && (!mye.a(paramChatMessage)) && (!amns.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
        break label152;
      }
      if (QLog.isColorLevel())
      {
        parambblr = new StringBuilder("addReplyOnlyMenu isRobot=").append(bahx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(mye.a(paramChatMessage)).append(" isConfessMsg=").append(amns.a(paramChatMessage)).append(" isNotSupport=");
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
        parambblr.a(2131375136, this.jdField_a_of_type_AndroidContentContext.getString(2131697937), 2130838610);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    parambblr.a(2131375136, this.jdField_a_of_type_AndroidContentContext.getString(2131697937), 2130838610);
  }
  
  public void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!bacy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
    }
    TroopManager localTroopManager;
    do
    {
      do
      {
        return;
        if (!bacy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          return;
        }
      } while (paramChatMessage.istroop != 1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    } while (!((bacv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(paramChatMessage.frienduin));
    acul localacul2 = (acul)paramBaseChatItemLayout.getTag(2131364147);
    acul localacul1 = localacul2;
    if (localacul2 == null)
    {
      localacul1 = new acul(this, null);
      paramBaseChatItemLayout.setTag(2131364147, localacul1);
    }
    localacul1.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    localacul1.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, localacul1);
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
    ChatMessage localChatMessage = actn.a(paramView);
    Object localObject2;
    if ((localChatMessage != null) && (localChatMessage.istroop == 1))
    {
      localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localObject2 = ((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject2 == null) || (!((TroopInfo)localObject2).isQidianPrivateTroop())) {}
    }
    label59:
    do
    {
      do
      {
        do
        {
          do
          {
            break label59;
            break label59;
            break label59;
            do
            {
              return;
            } while (((TroopManager)localObject1).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
            localObject1 = bajb.a(localChatMessage);
            if (localObject1 == null) {
              break;
            }
            bajb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bajc)localObject1);
            paramView = ((bajc)localObject1).jdField_c_of_type_JavaLangString;
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, localChatMessage.frienduin, "", paramView, "");
          } while (localChatMessage.msgtype != -2051);
          try
          {
            paramView = (MessageForQQStory)localChatMessage;
            paramView = bbej.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
            QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_name", paramView, false);
            return;
          }
          catch (Exception paramView) {}
        } while (!QLog.isColorLevel());
        QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramView);
        return;
      } while ((localChatMessage == null) || (localChatMessage.istroop != 1) || (!bbbd.d(localChatMessage.senderuin)));
      localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((HotChatManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label463;
      }
    } while ((((HotChatInfo)localObject1).isGameRoom) || ((((HotChatInfo)localObject1).isRobotHotChat) && (((balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin)))));
    Object localObject1 = localChatMessage.senderuin;
    paramView = atbn.a((String)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)) {}
    for (paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramView;; paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747")
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        axqw.b(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject1, "", "", "");
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return;
        localObject1 = null;
        break;
      }
      label463:
      if (((balw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin))) {
        break;
      }
      localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int i;
      label557:
      Object localObject3;
      if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
      {
        i = paramView.getId();
        if (i == 2131364148)
        {
          localObject1 = "clk_title";
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
          localObject3 = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
          if (i != 2131364148) {
            break label1002;
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
          Object localObject4 = bali.a();
          if (i == 2)
          {
            localObject3 = "troop_unique_title";
            localObject3 = ((bali)localObject4).a((String)localObject3);
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              continue;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
            ((StringBuilder)localObject3).append("gc=").append(localChatMessage.frienduin).append("&");
            ((StringBuilder)localObject3).append("uin=").append(localChatMessage.senderuin).append("&");
            ((StringBuilder)localObject3).append("nick=").append((String)localObject2).append("&");
            ((StringBuilder)localObject3).append("type=").append(i).append("&");
            ((StringBuilder)localObject3).append("from=").append("aio").append("&");
            localObject2 = ((StringBuilder)localObject3).toString();
            paramView = paramView.getContext();
            localObject3 = new Intent(paramView, QQBrowserActivity.class);
            ((Intent)localObject3).putExtra("url", (String)localObject2);
            ((Intent)localObject3).putExtra("selfSet_leftViewText", ajyc.a(2131700933));
            paramView.startActivity((Intent)localObject3);
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject4 = localChatMessage.frienduin;
            if (!localChatMessage.isSend()) {
              continue;
            }
            paramView = "1";
            axqw.b((QQAppInterface)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, (String)localObject4, paramView, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
            }
            if (this.jdField_c_of_type_Int < 2) {
              break;
            }
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_c_of_type_Int), "", "");
            return;
            localObject1 = "clk_nickname";
            break label557;
            label1002:
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
          localObject3 = "troop_rank";
          continue;
          balj localbalj = new balj();
          localbalj.jdField_a_of_type_JavaLangString = localChatMessage.frienduin;
          localbalj.jdField_b_of_type_JavaLangString = localChatMessage.senderuin;
          localbalj.jdField_e_of_type_JavaLangString = ((String)localObject2);
          localbalj.jdField_d_of_type_JavaLangString = ("" + i);
          localbalj.jdField_c_of_type_JavaLangString = "aio";
          localObject2 = localException.a((String)localObject3, localbalj);
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
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
        }
      }
    }
  }
  
  protected void c(bblr parambblr, Context paramContext)
  {
    if ((b()) && (asty.a().a())) {
      parambblr.a(2131370537, paramContext.getString(2131694467), 2130838614);
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
    ((avqs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(paramChatMessage);
    Intent localIntent = actn.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 1 });
    localIntent.putExtra("uin", paramChatMessage.senderuin);
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_reply_only_uniseq", paramChatMessage.uniseq);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int i;
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      localIntent.putExtra("uintype", 0);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      i = 1;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramChatMessage.senderuin)) {
        break label318;
      }
      i = 3;
    }
    label318:
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4F5", "0X800A4F5", i, 0, "", "", "", "");
      return;
      localIntent.putExtra("uintype", 1000);
      localIntent.putExtra("uinname", bbcl.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage.senderuin));
      localIntent = new Intent(localIntent);
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject != null) {
        ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new acui(this, localIntent));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bakk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
    {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697656, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return true;
    }
    return false;
  }
  
  public void d() {}
  
  protected void d(bblr parambblr, Context paramContext)
  {
    parambblr.a(2131365928, paramContext.getString(2131692324), 2130838605);
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
      ajfa.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
    } while (paramChatMessage == null);
    int j;
    int i;
    if (paramChatMessage.istroop == 0)
    {
      j = 1;
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label284;
      }
      i = 6;
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, "" + i, "", "", "");
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + j, "", "", "");
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
      label284:
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
  
  protected void e(bblr parambblr, Context paramContext)
  {
    parambblr.a(2131362357, paramContext.getString(2131689999), 2130838614);
  }
  
  protected void e(ChatMessage paramChatMessage)
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
    ajfa.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
    localObject = "0";
    if (paramChatMessage.istroop == 1) {
      localObject = "2";
    }
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 1, 0, (String)localObject, "", "", "");
      return;
      if (paramChatMessage.istroop == 0) {
        localObject = "1";
      }
    }
  }
  
  public void f(ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    if (a()) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity));
        actn.n = true;
        switch (paramView.getId())
        {
        default: 
          return;
        case 2131364101: 
        case 2131364146: 
        case 2131364119: 
        case 2131364117: 
        case 2131364127: 
          do
          {
            c(paramView);
            return;
            b(paramView);
            return;
            a(paramView);
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
          b(paramView);
          return;
        case 2131364132: 
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), null);
          return;
        }
        Object localObject = (acve)actn.a(paramView);
        String str = ((acve)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
        localObject = ((acve)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
        if (!((bacv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(str)) {
          break;
        }
        str = bali.a().a(str, (String)localObject);
        localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", str);
        paramView.getContext().startActivity((Intent)localObject);
      } while (paramView.getId() != 2131364147);
      axqw.b(null, "dc00898", "", "", "0X800A705", "0X800A705", 0, 0, "", "", "", "");
      return;
    } while (paramView.getId() != 2131364148);
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */