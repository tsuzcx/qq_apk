package com.tencent.mobileqq.activity.aio;

import abot;
import acex;
import aekt;
import aelk;
import aell;
import aelm;
import aeln;
import aelo;
import aelp;
import aelq;
import aelr;
import aels;
import aelt;
import aemb;
import aemi;
import aemj;
import aemk;
import aenj;
import aenl;
import aeov;
import aezb;
import afsf;
import afus;
import afyl;
import afyu;
import aghg;
import aglv;
import agqq;
import akwk;
import alkk;
import aloz;
import alpo;
import alxl;
import alzf;
import alzv;
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
import anrz;
import ansc;
import ansf;
import ansg;
import ansh;
import antf;
import aoeg;
import aoel;
import aoep;
import aofk;
import aptm;
import apud;
import apur;
import arru;
import asin;
import asio;
import athk;
import aube;
import aukx;
import aule;
import auso;
import awnk;
import axis;
import axso;
import ayvc;
import azib;
import azmj;
import azmo;
import azsv;
import bahs;
import baiy;
import bbpo;
import bcbt;
import bcbx;
import bcgx;
import bchc;
import bchd;
import bche;
import bcic;
import bcid;
import bcie;
import bcjl;
import bcjr;
import bckj;
import bckk;
import bckx;
import bclo;
import bcuq;
import bcwh;
import bcws;
import bcxb;
import bdaa;
import bdad;
import bdal;
import bdbg;
import bdbt;
import bdcs;
import bdda;
import bdds;
import bddz;
import bdjd;
import bdjj;
import bdkz;
import bdnm;
import bdrt;
import behr;
import beih;
import bfua;
import bfvv;
import bhoh;
import bhou;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.Pair;
import fx;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ldj;
import ldm;
import ldn;
import ldr;
import nav;
import naw;
import ndv;
import swy;
import syb;
import wta;
import yzg;
import zpa;

public abstract class BaseBubbleBuilder
  extends aemj
  implements aemi, View.OnClickListener
{
  public static int a;
  public static ColorFilter a;
  public static final Handler a;
  protected static final ConcurrentHashMap<Long, String> a;
  public static boolean a;
  protected float a;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new aeln(this);
  protected ViewGroup a;
  @Deprecated
  public BaseAdapter a;
  public bcws a;
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
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt)
  {
    int i;
    List localList;
    RelativeLayout.LayoutParams localLayoutParams6;
    if ((paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 1;
      if ((paramView == null) || (paramView.getId() != 2131364171) || (i != 0) || (!EmojiStickerManager.d(paramChatMessage)) || (paramChatMessage.fakeSenderType != 0)) {
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
                          aube localaube;
                          int k;
                          int i12;
                          if ((localList != null) && (localList.size() > 0) && (EmojiStickerManager.b(paramChatMessage)))
                          {
                            localaube = (aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
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
                                  paramView = localaube.a(((MessageForMarketFace)paramChatMessage).mMarkFaceMessage);
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
                                      k = m + (aekt.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams5.topMargin + localLayoutParams5.bottomMargin));
                                    }
                                    m = k;
                                    if (localLayoutParams3 != null) {
                                      m = k + (aekt.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams3.topMargin + localLayoutParams3.bottomMargin));
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
                                        paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c(i18);
                                        k = m;
                                      }
                                    }
                                    if (!(paramView instanceof aptm)) {
                                      break label1110;
                                    }
                                    paramChatMessage = (aptm)paramView;
                                    if (paramChatMessage.a == null) {
                                      break label1474;
                                    }
                                    if ((EmojiStickerManager.jdField_f_of_type_Boolean) || (bdcs.a() <= 1.048576E+008F)) {
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
                                      localBaseChatItemLayout = paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
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
                                      if ((paramView instanceof apur))
                                      {
                                        paramView = ((apur)paramView).b(paramContext, f2);
                                        paramChatMessage = "";
                                        break label948;
                                      }
                                      if ((paramView instanceof apud))
                                      {
                                        paramView = ((apud)paramView).b(paramContext, f2);
                                        paramChatMessage = "";
                                        break label948;
                                      }
                                      if (!(paramChatMessage instanceof MessageForPic)) {
                                        break label1465;
                                      }
                                      paramView = afsf.a(paramContext, (MessageForPic)paramChatMessage);
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
                                      paramBaseChatItemLayout.setTag(2131373383, paramView);
                                    }
                                    paramBaseChatItemLayout.jdField_a_of_type_Apnp = new aelk(this);
                                    if (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null)
                                    {
                                      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
                                      paramView.addRule(6, 2131364180);
                                      paramView.topMargin = (-aekt.a(1.0F, paramContext.getResources()));
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
    if ((paramView != null) && (paramView.getId() == 2131364171))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131373383);
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
        paramBaseChatItemLayout.setTag(2131373383, null);
      }
    }
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, aloz paramaloz, boolean paramBoolean1, boolean paramBoolean2, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 10002))
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      if (paramMessageRecord.istroop == 1001)
      {
        paramAllInOne.jdField_h_of_type_Int = 10;
        paramView.putExtra("frome_where", 21);
        paramAllInOne.a = yzg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramView.putExtra("AllInOne", paramAllInOne);
        if (!bdal.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString)) {
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
    if ((!paramBoolean2) && (!paramaloz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramaloz = agqq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramBoolean1, paramBoolean2);
      if (paramaloz == null) {
        break label305;
      }
      paramAllInOne.b.putSerializable("param_wzry_data", paramaloz);
    }
    while (athk.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
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
  
  public static void a(bdkz parambdkz, Context paramContext)
  {
    parambdkz.a(2131365069, paramContext.getString(2131690760), 2130838672);
  }
  
  @TargetApi(14)
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramChatMessage.istroop == 3000) {
      if (bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
      {
        localObject1 = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = paramChatMessage.senderuin;
        }
        if (((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) != 1) {
          break label271;
        }
        i = 1;
        label97:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
        if (i == 0) {
          break label277;
        }
        localObject1 = ((arru)localObject1).jdField_d_of_type_JavaLangString;
        label127:
        if (localObject2 == null) {
          break label283;
        }
        label132:
        paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
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
        paramBaseChatItemLayout.e.setAccessibilityDelegate(new aell(this));
      }
      a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, paramaelt);
      return;
      if (paramChatMessage.isSend()) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();; localObject1 = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin)) {
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
          localObject1 = bdbt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
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
          paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidContentResColorStateList, false, false, false, false, "", null, null);
        }
        for (;;)
        {
          localObject1 = null;
          break;
          paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
        }
      }
      if (bfua.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin))
      {
        localObject2 = bfvv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
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
  
  private void a(MessageRecord paramMessageRecord, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramString.equals(paramAllInOne.jdField_h_of_type_JavaLangString)) {
      paramAllInOne.jdField_h_of_type_JavaLangString = null;
    }
    paramAllInOne.a = yzg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
        azmj.b(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin()), paramString2, null);
      }
      return;
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt)
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
        str = alpo.a(2131701317);
      }
    }
    label306:
    label439:
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setContentDescription(str);
      if ((AppSetting.jdField_c_of_type_Boolean) && (paramaelt.jdField_b_of_type_JavaLangStringBuilder != null))
      {
        if ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramChatMessage.senderuin)) || (paramChatMessage.isSend())) {
          paramaelt.jdField_b_of_type_JavaLangStringBuilder.append("我");
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
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131698102), new Object[] { swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = alpo.a(2131701318);
          continue;
        }
        str = paramString + alpo.a(2131701310);
        continue;
        if (j != 0)
        {
          if (m != 0)
          {
            str = alpo.a(2131701321);
            continue;
          }
          str = paramString + alpo.a(2131701311);
          continue;
        }
        if (m != 0) {}
        for (str = alpo.a(2131701321);; str = paramString + alpo.a(2131701311))
        {
          if (paramChatMessage.msgtype != -3006) {
            break label439;
          }
          str = String.format(paramBaseChatItemLayout.getResources().getString(2131698102), new Object[] { swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          break;
        }
      }
    }
    paramBaseChatItemLayout = paramString;
    if (paramString == null) {
      paramBaseChatItemLayout = "";
    }
    paramString = paramBaseChatItemLayout;
    if (nav.a(paramChatMessage)) {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690102) + paramBaseChatItemLayout;
    }
    paramaelt.jdField_b_of_type_JavaLangStringBuilder.insert(0, paramString);
  }
  
  public static boolean a(View paramView)
  {
    Object localObject = aekt.a(paramView);
    if (localObject == null) {}
    while (!(localObject instanceof aelt)) {
      return false;
    }
    paramView = (aelt)aekt.a(paramView);
    if ((paramView.jdField_a_of_type_Ansf == null) || (paramView.jdField_a_of_type_Ansf.jdField_a_of_type_Int <= 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject1 = bcid.a(paramMessageRecord);
    if (localObject1 != null)
    {
      bcid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bcie)localObject1);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, paramMessageRecord.frienduin, "", ((bcie)localObject1).jdField_c_of_type_JavaLangString, "");
      if (paramMessageRecord.msgtype == -2051) {}
      try
      {
        paramView = (MessageForQQStory)paramMessageRecord;
        paramView = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
        QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_head", paramView, false);
        return true;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramView);
          }
        }
      }
    }
    if (((paramMessageRecord instanceof MessageForStructing)) && (bcic.a(paramMessageRecord)))
    {
      paramMessageRecord = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((paramMessageRecord != null) && (paramMessageRecord.associatePubAccount != 0L))
      {
        localObject1 = new Intent(paramView.getContext(), AccountDetailActivity.class);
        ((Intent)localObject1).putExtra("uin", paramMessageRecord.associatePubAccount + "");
        paramView.getContext().startActivity((Intent)localObject1);
      }
      return true;
    }
    if (nav.a(paramMessageRecord))
    {
      localObject1 = nav.a(paramMessageRecord);
      if ((paramView == null) || ((((naw)localObject1).jdField_a_of_type_JavaLangString == null) && (((naw)localObject1).jdField_a_of_type_Int != 2)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, "onHeadIconClick : an_id is null");
        }
        return true;
      }
      Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramMessageRecord.frienduin);
      Object localObject3 = (alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject2 != null)
      {
        ((alzf)localObject3).j(((TroopInfo)localObject2).troopuin);
        ((alzf)localObject3).a(1, alkk.a(((TroopInfo)localObject2).troopuin), 0L, 2, 0, 0, true);
      }
      int j = 0;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      int i = j;
      if (localObject2 != null)
      {
        i = j;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          if ((((TroopInfo)localObject2).Administrator == null) || (!((TroopInfo)localObject2).Administrator.contains((CharSequence)localObject3))) {
            break label688;
          }
          i = 3;
        }
      }
      localObject2 = ((naw)localObject1).a();
      if ((localObject2 != null) && (((naw)localObject1).jdField_a_of_type_Int != 2))
      {
        localObject2 = URLEncoder.encode(Base64.encodeToString((byte[])localObject2, 2));
        localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        localStringBuilder = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject2).append("&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(nav.a(((naw)localObject1).jdField_b_of_type_Int)).append("&nick=");
        if (TextUtils.isEmpty(((naw)localObject1).jdField_b_of_type_JavaLangString))
        {
          localObject1 = "";
          ((Intent)localObject3).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=0");
          ((Activity)paramView.getContext()).startActivity((Intent)localObject3);
          if (paramMessageRecord.msgData != null)
          {
            nav.a().a(paramMessageRecord.frienduin, (String)localObject2, paramMessageRecord);
            if (QLog.isDevelopLevel()) {
              QLog.i("ChatItemBuilder", 4, "report:" + paramMessageRecord.msgData.toString());
            }
          }
        }
      }
      label688:
      while (((naw)localObject1).jdField_a_of_type_Int != 2) {
        for (;;)
        {
          StringBuilder localStringBuilder;
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, paramMessageRecord.frienduin, "", "", "");
          return true;
          if (((String)localObject3).equals(((TroopInfo)localObject2).troopowneruin))
          {
            i = 2;
            break;
          }
          i = 1;
          break;
          localObject1 = URLEncoder.encode(((naw)localObject1).jdField_b_of_type_JavaLangString);
        }
      }
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localObject3 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(nav.a(((naw)localObject1).jdField_b_of_type_Int)).append("&nick=");
      if (TextUtils.isEmpty(((naw)localObject1).jdField_b_of_type_JavaLangString)) {}
      for (localObject1 = "";; localObject1 = URLEncoder.encode(((naw)localObject1).jdField_b_of_type_JavaLangString))
      {
        ((Intent)localObject2).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=1");
        ((Activity)paramView.getContext()).startActivity((Intent)localObject2);
        break;
      }
    }
    if ("1000000".equals(paramMessageRecord.senderuin))
    {
      bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1");
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject2 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((localObject1 != null) && (((HotChatManager)localObject1).b(paramMessageRecord.frienduin))) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (paramMessageRecord.istroop != 1)) {
        break label179;
      }
      localObject1 = (bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      try
      {
        long l = Long.parseLong(paramMessageRecord.senderuin);
        paramBoolean = ((bckx)localObject1).a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, l);
        if (!paramBoolean) {
          break;
        }
        return true;
      }
      catch (Exception localException)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.e("ChatItemBuilder", 2, "parseLong error: messageRecord.senderuin = " + paramMessageRecord.senderuin);
        awnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), paramMessageRecord.frienduin, paramMessageRecord.senderuin, 0, 2000);
        return true;
      }
    }
    label179:
    if (i != 0)
    {
      HotChatInfo localHotChatInfo = localException.a(paramMessageRecord.frienduin);
      if ((localHotChatInfo != null) && (localHotChatInfo.isRobotHotChat) && (((bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)))) {
        return true;
      }
      if ((paramBoolean) || ((localObject2 != null) && (!((aloz)localObject2).b(paramMessageRecord.senderuin))))
      {
        paramView = null;
        if (localHotChatInfo != null)
        {
          paramView = localHotChatInfo.troopCode;
          if (localHotChatInfo.isGameRoom)
          {
            localObject2 = (behr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107);
            if ((((behr)localObject2).jdField_a_of_type_JavaLangString != null) && (((behr)localObject2).jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin))) {
              return true;
            }
          }
        }
        bhoh.a();
        localObject2 = paramMessageRecord.senderuin;
        boolean bool;
        if ((localHotChatInfo != null) && (localHotChatInfo.isBuLuoHotChat()))
        {
          i = 86;
          localObject2 = new ProfileActivity.AllInOne((String)localObject2, i);
          ((ProfileActivity.AllInOne)localObject2).jdField_c_of_type_JavaLangString = paramView;
          ((ProfileActivity.AllInOne)localObject2).jdField_d_of_type_JavaLangString = paramMessageRecord.frienduin;
          if ((localHotChatInfo == null) || (!localHotChatInfo.isGameRoom)) {
            break label538;
          }
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 113;
          ((ProfileActivity.AllInOne)localObject2).a = yzg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramMessageRecord.frienduin, paramMessageRecord.senderuin);
          HotChatManager.jdField_a_of_type_Boolean = false;
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
          paramView.putExtra("AllInOne", (Parcelable)localObject2);
          if (localHotChatInfo == null) {
            break label548;
          }
          bool = localHotChatInfo.isGameRoom;
          label476:
          paramView.putExtra("is_from_werewolves", bool);
          if (!paramBoolean) {
            break label554;
          }
          i = 2;
          label493:
          paramView.putExtra("param_mode", i);
          if ((!paramBoolean) || (localHotChatInfo == null) || (!localHotChatInfo.isGameRoom)) {
            break label560;
          }
          ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2);
        }
        for (;;)
        {
          return true;
          i = 42;
          break;
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 31;
          break label399;
          bool = false;
          break label476;
          i = 3;
          break label493;
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
        }
      }
      if ((localHotChatInfo != null) && (localHotChatInfo.isGameRoom))
      {
        paramView = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 42);
        paramView.jdField_c_of_type_JavaLangString = localHotChatInfo.troopCode;
        paramView.jdField_d_of_type_JavaLangString = paramMessageRecord.frienduin;
        paramView.jdField_h_of_type_Int = 113;
        paramView.a = yzg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, paramView);
        HotChatManager.jdField_a_of_type_Boolean = false;
        return true;
      }
    }
    label399:
    label538:
    label548:
    label554:
    label560:
    return false;
  }
  
  private boolean a(ChatMessage paramChatMessage, aelt paramaelt, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (azib.b())
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
      Drawable localDrawable;
      if (bool)
      {
        i = 2130849366;
        localDrawable = ((Resources)localObject).getDrawable(i);
        if (!bool) {
          break label157;
        }
      }
      label157:
      for (int i = 2130849365;; i = 2130849189)
      {
        localObject = ((Resources)localObject).getDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
        paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaelt.jdField_a_of_type_Ansf = new ansf(0);
        a(paramaelt, paramBaseChatItemLayout, paramChatMessage, paramaelt.jdField_a_of_type_Ansf);
        a(paramaelt, paramChatMessage);
        b(paramaelt, paramChatMessage);
        return true;
        i = 2130849190;
        break;
      }
    }
    return false;
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt)
  {
    Object localObject1 = null;
    if (nav.a(paramChatMessage)) {
      localObject1 = nav.a(paramChatMessage).jdField_b_of_type_JavaLangString;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidContentResColorStateList;
      if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!paramChatMessage.isMultiMsg) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        localObject2 = ColorStateList.valueOf(nav.jdField_d_of_type_Int);
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
          localObject3 = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        }
        localObject1 = localObject3;
        if ((paramChatMessage instanceof MessageForStructing))
        {
          localObject1 = localObject3;
          if (bcic.a(paramChatMessage)) {
            localObject1 = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          }
        }
        Object localObject5 = bcid.a(paramChatMessage);
        localObject3 = localObject2;
        Object localObject4;
        if (localObject5 != null)
        {
          localObject4 = ((bcie)localObject5).jdField_c_of_type_JavaLangString;
          localObject1 = localObject4;
          localObject3 = localObject2;
          if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
          {
            localObject1 = localObject4;
            localObject3 = localObject2;
            if (!aofk.a(paramChatMessage))
            {
              localObject3 = ColorStateList.valueOf(((bcie)localObject5).jdField_b_of_type_Int);
              localObject1 = localObject4;
            }
          }
        }
        int i;
        if ((paramChatMessage.istroop == 1) && (!nav.a(paramChatMessage)))
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
          if (((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) == 1)
          {
            i = 1;
            label398:
            localObject3 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
            if (i == 0) {
              break label871;
            }
            localObject3 = ((arru)localObject3).jdField_d_of_type_JavaLangString;
            label428:
            if ((!paramChatMessage.isMultiMsg) || (nav.a(paramChatMessage))) {
              break label1023;
            }
            localObject4 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = aukx.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (TextUtils.getTrimmedLength((CharSequence)localObject1) != 0) {}
            }
            else
            {
              localObject4 = aule.a(paramChatMessage.senderuin);
            }
            localObject1 = new bahs((CharSequence)localObject4, 13).a();
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
                  if (((!bool2) || (!nav.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                    break label883;
                  }
                  bool4 = true;
                  paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool4, bool1, false, false, "", null, (String)localObject3);
                  localObject5 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                  localObject4 = (aelq)paramBaseChatItemLayout.getTag(2131364189);
                  localObject1 = localObject4;
                  if (localObject4 == null)
                  {
                    localObject1 = new aelq(this, null);
                    paramBaseChatItemLayout.setTag(2131364189, localObject1);
                  }
                  ((aelq)localObject1).jdField_a_of_type_Boolean = bool2;
                  ((aelq)localObject1).jdField_a_of_type_AndroidContentResColorStateList = ((ColorStateList)localObject2);
                  ((aelq)localObject1).jdField_b_of_type_Boolean = bool1;
                  ((aelq)localObject1).jdField_c_of_type_Boolean = false;
                  ((aelq)localObject1).jdField_a_of_type_JavaLangCharSequence = "";
                  ((aelq)localObject1).jdField_b_of_type_AndroidContentResColorStateList = null;
                  ((aelq)localObject1).d = false;
                  ((aelq)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
                  ((aelq)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
                  ((aelq)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                  ((aelq)localObject1).jdField_a_of_type_Aelt = paramaelt;
                  ((TroopManager)localObject5).a(paramChatMessage.frienduin, paramChatMessage.senderuin, (alzv)localObject1);
                }
              }
              else
              {
                bool1 = bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin);
                paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1, paramChatMessage.isSend());
                if (paramBaseChatItemLayout.f != null) {
                  paramBaseChatItemLayout.f.setOnClickListener(this);
                }
                if (paramBaseChatItemLayout.e != null)
                {
                  if (nav.a(paramChatMessage)) {
                    break label1012;
                  }
                  paramBaseChatItemLayout.e.setOnClickListener(this);
                  paramBaseChatItemLayout.e.setTag(Integer.valueOf(2131364188));
                }
              }
            }
            for (;;)
            {
              if ((AppSetting.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT >= 14)) {
                paramBaseChatItemLayout.e.setAccessibilityDelegate(new aelm(this));
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
                if (((!bool2) || (!nav.b(paramChatMessage))) && (!aofk.c(paramChatMessage)) && (!paramChatMessage.isSend())) {
                  break label1006;
                }
              }
              for (bool2 = true;; bool2 = false)
              {
                paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool2, bool1, false, false, "", null, (String)localObject3);
                a(((CharSequence)localObject1).toString(), paramChatMessage, paramBaseChatItemLayout, paramaelt);
                if ((!paramChatMessage.isMultiMsg) || (nav.a(paramChatMessage))) {
                  break;
                }
                bdnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout.e, (Spannable)localObject1);
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
  
  private boolean b(ChatMessage paramChatMessage, aelt paramaelt, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (aoep.a(paramChatMessage))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849366;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label156;
        }
      }
      label156:
      for (int i = 2130849365;; i = 2130849189)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaelt.jdField_a_of_type_Ansf = new ansf(0);
        a(paramaelt, paramBaseChatItemLayout, paramChatMessage, paramaelt.jdField_a_of_type_Ansf);
        a(paramaelt, paramChatMessage);
        b(paramaelt, paramChatMessage);
        return true;
        i = 2130849190;
        break;
      }
    }
    return false;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    if ((bdal.b(paramMessageRecord.senderuin)) && (bdal.a(this.jdField_a_of_type_AndroidContentContext))) {
      return true;
    }
    if (bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        bcgx.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "openRobotProfileCard, robotuin:" + paramMessageRecord.senderuin + " frienduin:" + paramMessageRecord.frienduin);
        }
        return true;
        bcgx.a(this.jdField_a_of_type_AndroidContentContext, null, paramMessageRecord.senderuin);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString))) {
      return true;
    }
    if ("10000".equals(paramMessageRecord.senderuin)) {
      return true;
    }
    if ((paramMessageRecord.istroop == 3000) && (bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForTroopConfess);
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = aukx.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() != 0) {}
    }
    else
    {
      localObject2 = aule.a(paramChatMessage.senderuin);
    }
    paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
    a((String)localObject2, paramChatMessage, paramBaseChatItemLayout, paramaelt);
  }
  
  private boolean c(ChatMessage paramChatMessage, aelt paramaelt, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramChatMessage.istroop == 10007))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849366;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label169;
        }
      }
      label169:
      for (int i = 2130849365;; i = 2130849189)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaelt.jdField_a_of_type_Ansf = new ansf(0);
        a(paramaelt, paramBaseChatItemLayout, paramChatMessage, paramaelt.jdField_a_of_type_Ansf);
        a(paramaelt, paramChatMessage);
        b(paramaelt, paramChatMessage);
        return true;
        i = 2130849190;
        break;
      }
    }
    return false;
  }
  
  private boolean d(ChatMessage paramChatMessage, aelt paramaelt, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (athk.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849366;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label159;
        }
      }
      label159:
      for (int i = 2130849365;; i = 2130849189)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaelt.jdField_a_of_type_Ansf = new ansf(0);
        a(paramaelt, paramBaseChatItemLayout, paramChatMessage, paramaelt.jdField_a_of_type_Ansf);
        a(paramaelt, paramChatMessage);
        b(paramaelt, paramChatMessage);
        return true;
        i = 2130849190;
        break;
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
        paramChatMessage = alpo.a(2131701312);
        i = 0;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a(paramChatMessage, i);
      return;
      if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
      {
        paramChatMessage = alpo.a(2131701314);
        i = 1;
      }
      else if ((localHotChatInfo.isRobotHotChat) && (((bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).b(paramChatMessage.senderuin)))
      {
        paramChatMessage = alpo.a(2131701320);
        i = 0;
      }
      else
      {
        i = 0;
        paramChatMessage = null;
      }
    }
  }
  
  private boolean e(ChatMessage paramChatMessage, aelt paramaelt, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      if (paramChatMessage.istroop == 1) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject = paramaelt.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838110);
        paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
        paramaelt.jdField_a_of_type_Ansf = new ansf(0);
        a(paramaelt, paramBaseChatItemLayout, paramChatMessage, paramaelt.jdField_a_of_type_Ansf);
        a(paramaelt, paramChatMessage);
        b(paramaelt, paramChatMessage);
        return true;
        if (paramChatMessage.istroop == 3000) {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 2, 0, "", "", "", "");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramChatMessage.isShowQIMStyleGroup = aghg.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (paramChatMessage.isShowQIMStyleGroup)
      {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 3, 0, "", "", "", "");
        boolean bool;
        int i;
        Drawable localDrawable1;
        label324:
        Drawable localDrawable2;
        if ((!(this instanceof afyl)) || ((this instanceof afyu)))
        {
          bool = paramChatMessage.isSend();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)
          {
            localObject = paramaelt.jdField_a_of_type_AndroidViewView.getResources();
            if (bool)
            {
              i = 2130849366;
              localDrawable1 = ((Resources)localObject).getDrawable(i);
              localObject = paramaelt.jdField_a_of_type_AndroidViewView.getResources();
              if (!bool) {
                break label428;
              }
              i = 2130849365;
              localDrawable2 = ((Resources)localObject).getDrawable(i);
              localObject = new StateListDrawable();
              ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
              ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            }
          }
        }
        for (;;)
        {
          paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          paramaelt.jdField_a_of_type_Ansf = new ansf(0);
          a(paramaelt, paramBaseChatItemLayout, paramChatMessage, paramaelt.jdField_a_of_type_Ansf);
          a(paramaelt, paramChatMessage);
          b(paramaelt, paramChatMessage);
          return true;
          i = 2130849190;
          break;
          label428:
          i = 2130849189;
          break label324;
          localObject = SkinEngine.getInstances();
          if (bool)
          {
            i = 2130849366;
            label451:
            localDrawable1 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = SkinEngine.getInstances();
            if (!bool) {
              break label536;
            }
          }
          label536:
          for (i = 2130849365;; i = 2130849189)
          {
            localDrawable2 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = new StateListDrawable();
            ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
            ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            break;
            i = 2130849190;
            break label451;
          }
          if (!paramChatMessage.isSend()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label583;
            }
            localObject = paramaelt.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838109);
            break;
          }
          label583:
          localObject = paramaelt.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838110);
        }
      }
    }
    return false;
  }
  
  private void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool;
    int j;
    int k;
    naw localnaw;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      bool = true;
      j = -1;
      if (bool) {
        j = nav.jdField_e_of_type_Int;
      }
      if (!nav.a(paramChatMessage)) {
        break label153;
      }
      k = bbpo.a().jdField_a_of_type_Int;
      localnaw = nav.a(paramChatMessage);
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
            if (!TextUtils.isEmpty(localnaw.jdField_c_of_type_JavaLangString)) {
              i = Color.parseColor(localnaw.jdField_c_of_type_JavaLangString);
            }
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690095), nav.b(paramChatMessage), i, j);
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
          localObject = bcid.a(paramChatMessage);
          if (localObject != null)
          {
            j = ((bcie)localObject).jdField_c_of_type_Int;
            i = ((bcie)localObject).jdField_d_of_type_Int;
            if (bool)
            {
              j = nav.jdField_e_of_type_Int;
              i = bbpo.a().jdField_a_of_type_Int;
            }
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((bcie)localObject).jdField_d_of_type_JavaLangString, false, i, j);
            paramBaseChatItemLayout.c.setOnClickListener(this);
            paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131364209));
            return;
          }
        } while (paramChatMessage.istroop != 1);
        paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
        this.jdField_f_of_type_Boolean = false;
      } while (localTroopManager == null);
      localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
      localObject = (bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    } while ((localTroopInfo == null) || ((localTroopInfo.cGroupRankSysFlag != 1) && (!((bckx)localObject).b(paramChatMessage.senderuin)) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop())));
    aelp localaelp = (aelp)paramBaseChatItemLayout.getTag(2131364209);
    Object localObject = localaelp;
    if (localaelp == null)
    {
      localObject = new aelp(this, null);
      paramBaseChatItemLayout.setTag(2131364209, localObject);
    }
    ((aelp)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    ((aelp)localObject).jdField_a_of_type_Boolean = bool;
    ((aelp)localObject).jdField_a_of_type_Int = j;
    ((aelp)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (alzv)localObject);
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
      localObject = ((behr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((beih)localObject).a(paramChatMessage.senderuin);
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
      paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131364207));
      return;
    }
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public aels a(View paramView)
  {
    return null;
  }
  
  protected abstract aelt a();
  
  protected Drawable a(BaseChatItemLayout paramBaseChatItemLayout, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Bcws == null) {
      return null;
    }
    aelt localaelt = (aelt)paramBaseChatItemLayout.getTag();
    if (localaelt != null)
    {
      localaelt.jdField_a_of_type_JavaLangString = paramString;
      localaelt.jdField_d_of_type_Int = paramInt;
      paramBaseChatItemLayout.setTag(localaelt);
    }
    paramBaseChatItemLayout = this.jdField_a_of_type_Bcws.b(paramInt, paramString, 6);
    if (paramBaseChatItemLayout == null)
    {
      if (!this.jdField_a_of_type_Bcws.a()) {
        this.jdField_a_of_type_Bcws.a(paramString, paramInt, true);
      }
      return bdda.b();
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBaseChatItemLayout);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
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
        paramView.setId(2131363112);
        paramView.setFocusableInTouchMode(true);
        localObject1 = a();
        paramView.setTag(localObject1);
        ((aelt)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
        if (!bool) {
          break label1331;
        }
        ((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, BaseChatItemLayout.v);
        if ((bool) && (((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder == null)) {
          ((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        ((aelt)localObject1).jdField_b_of_type_Int = paramInt1;
        ((aelt)localObject1).jdField_c_of_type_Int = paramInt2;
        localObject2 = null;
        localObject3 = localObject2;
        if (bool)
        {
          paramView.setContentDescription(null);
          if (!TextUtils.isEmpty(((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder)) {
            ((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder.replace(0, ((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
      label1331:
      for (;;)
      {
        try
        {
          boolean bool;
          Object localObject2 = bdjj.a(localContext, 3, paramChatMessage.time * 1000L);
          ((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder.append(" ").append((CharSequence)localObject2).append(" ");
          Object localObject3 = localObject2;
          ((aelt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          if (paramChatMessage.isSend())
          {
            i = 1;
            paramView.setHearIconPosition(i);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb != null)
            {
              ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aemb.jdField_a_of_type_AndroidContentResColorStateList;
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
                    if (nav.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                      localObject2 = ColorStateList.valueOf(nav.jdField_d_of_type_Int);
                    }
                  }
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) {
                localObject2 = ColorStateList.valueOf(nav.jdField_d_of_type_Int);
              }
              paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage, (ColorStateList)localObject2, localObject3);
            }
            if (!bcic.a(paramChatMessage)) {
              continue;
            }
            paramView.setGrayTipsText(true, paramChatMessage, localContext.getString(2131696901), this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165394), 0);
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
            ((aelt)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(null);
            paramViewGroup = a(paramChatMessage, (aelt)localObject1, ((aelt)localObject1).jdField_a_of_type_AndroidViewView, paramView, paramaeov);
            ((aelt)localObject1).jdField_a_of_type_AndroidViewView = paramViewGroup;
            a(paramViewGroup, paramView);
            a(paramChatMessage, localContext, paramView, (aelt)localObject1, paramInt1, paramInt2);
            if (bool)
            {
              ((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
              paramaeov = Spannable.Factory.getInstance().newSpannable(((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder.toString());
              if (!Linkify.addLinks(paramaeov, 15)) {
                continue;
              }
              paramView.setContentDescription(paramaeov);
              paramView.setFocusable(true);
            }
            ((aelt)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a();
            bdjd.a(null, "AIO_Handle_Sticker_Cost");
            long l = System.currentTimeMillis();
            a(localContext, paramViewGroup, paramChatMessage, paramView, (aelt)localObject1);
            bdjd.a("AIO_Handle_Sticker_Cost", null);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleStickers time cost : " + (System.currentTimeMillis() - l) + " ms");
            }
            if ((!paramChatMessage.mMsgAnimFlag) || (paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null) || (b(paramChatMessage))) {
              continue;
            }
            paramChatMessage.mMsgAnimFlag = false;
            paramInt2 = aekt.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
            localObject2 = (aelt)paramView.getTag();
            localObject1 = localObject2;
            if (!a((aelt)localObject2))
            {
              QLog.e("BubbleView", 1, "getView checkHolderTypeOk failed holder :" + localObject2 + "  this:" + this);
              localObject2 = a();
              paramView.setTag(localObject2);
              ((aelt)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
              localObject1 = localObject2;
              if (bool)
              {
                ((aelt)localObject2).jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
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
          paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165394), 235);
          continue;
          if (paramChatMessage.fakeSenderType == 2)
          {
            if (nav.a(paramChatMessage)) {
              b(paramChatMessage, paramView, (aelt)localObject1);
            } else {
              c(paramChatMessage, paramView, (aelt)localObject1);
            }
          }
          else if (((paramChatMessage.istroop == 0) || (paramChatMessage.istroop == 3000)) && (paramChatMessage.isMultiMsg))
          {
            c(paramChatMessage, paramView, (aelt)localObject1);
          }
          else if (paramChatMessage.istroop == 1)
          {
            paramViewGroup = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
            if ((paramViewGroup != null) && (paramViewGroup.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
            {
              e(paramChatMessage, paramView);
              g(paramChatMessage, paramView);
              b(paramChatMessage, paramView, (aelt)localObject1);
              b(paramChatMessage, paramView);
            }
            else
            {
              f(paramChatMessage, paramView);
            }
          }
          else
          {
            a(paramChatMessage, paramView, (aelt)localObject1);
            continue;
            c(paramChatMessage, paramView);
            continue;
            paramView.setContentDescription(((aelt)localObject1).jdField_b_of_type_JavaLangStringBuilder.toString());
            continue;
            paramView.a(paramChatMessage);
          }
        }
      }
    }
  }
  
  protected abstract View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov);
  
  protected abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    bddz.a().a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131375605: 
      b(paramChatMessage);
      return;
    case 2131362377: 
      e(paramChatMessage);
      return;
    }
    c(paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    if (!aule.a(paramChatMessage)) {}
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
  
  protected void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf) {}
  
  protected void a(aelt paramaelt, ChatMessage paramChatMessage) {}
  
  protected void a(View paramView) {}
  
  public void a(View paramView, aeov paramaeov)
  {
    if (bdaa.a(false))
    {
      bdad localbdad = new bdad();
      bdaa.a(this.jdField_a_of_type_AndroidContentContext, localbdad, paramaeov);
      paramView.setOnTouchListener(localbdad);
      paramView.setOnLongClickListener(localbdad);
      return;
    }
    paramView.setOnTouchListener(paramaeov);
    paramView.setOnLongClickListener(paramaeov);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.g;
    int i = j;
    if (azsv.a(paramChatMessage)) {
      i = j - aekt.a(10.0F, paramView.getResources());
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
  
  protected void a(View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) || (paramansf == null)) {
      return;
    }
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject3 = null;
    ansc localansc = null;
    Pair localPair = null;
    BubbleManager localBubbleManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    Object localObject2;
    label63:
    Object localObject1;
    if (baiy.a(paramChatMessage.msg))
    {
      localObject2 = baiy.b(paramChatMessage.msg);
      if ((localBubbleManager == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label881;
      }
      localObject1 = localBubbleManager.a(paramansf.jdField_a_of_type_Int, false);
      if ((localObject1 == null) || (((ansc)localObject1).b == null) || (!((ansc)localObject1).a((String)localObject2))) {
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
      localObject1 = localansc;
      int j = k;
      Object localObject4;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject4 = paramansf.a((String)localObject2);
        localObject1 = localansc;
        localObject3 = localObject4;
        j = k;
        if (localObject4 != null)
        {
          localObject1 = paramansf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
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
          localPair = paramansf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
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
              if (bhou.e())
              {
                localObject2 = paramansf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
                m = n;
                if (localObject2 != null)
                {
                  m = n;
                  if (((Pair)localObject2).first != null)
                  {
                    m = n;
                    if (paramView.getWidth() > ((ansg)((Pair)localObject2).first).a.j) {
                      m = 1;
                    }
                  }
                }
              }
            }
          }
          if ((localBubbleManager != null) && ((paramChatMessage instanceof MessageForText)))
          {
            localansc = localBubbleManager.a(paramansf.jdField_a_of_type_Int, false);
            if ((localansc != null) && (localansc.f != null) && (localansc.f.k != 0) && (bhou.e())) {
              if (paramChatMessage.isSend())
              {
                localObject2 = paramChatMessage.selfuin;
                localObject4 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (localObject4 == null) {
                  break label857;
                }
                localObject2 = ((aloz)localObject4).a((String)localObject2);
                if ((localObject2 == null) || ((localansc.f.k != -1) && (((ExtensionInfo)localObject2).pendantId != localansc.f.k))) {
                  break label857;
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (i != 0)
            {
              long l = ansh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              if (l != -1L) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
              }
            }
            if ((j != 0) || (m != 0) || (n != 0) || (k != 0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
            }
            if (j != 0)
            {
              a("keyword_trigger", paramansf.jdField_a_of_type_Int, localObject3);
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
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramansf.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
              if (!paramansf.a(paramView.getHeight())) {
                break;
              }
              paramView = paramansf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
              if ((paramView == null) || (paramView.first == null)) {
                break;
              }
              a("wordnum_trigger", paramansf.jdField_a_of_type_Int, null);
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
  
  protected void a(View paramView, ChatMessage paramChatMessage, ansf paramansf, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {}
    do
    {
      return;
      paramView = paramansf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    } while ((paramView == null) || (paramView.first == null));
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  protected void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (!bchc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramMessageRecord = ((bchc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord);
      if ((paramMessageRecord != null) && (paramMessageRecord.jdField_b_of_type_Int != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new bche(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), paramMessageRecord.jdField_c_of_type_Int, paramMessageRecord.jdField_d_of_type_Int, 17);
        paramTextView.setTag(2131366463, "school_troop_span");
      }
    } while (!QLog.isColorLevel());
    QLog.i("school_troop.BaseBubbleBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
  }
  
  public void a(bcws parambcws)
  {
    this.jdField_a_of_type_Bcws = parambcws;
  }
  
  protected void a(bdkz parambdkz, int paramInt, MessageRecord paramMessageRecord)
  {
    if (!a(paramMessageRecord)) {}
    do
    {
      do
      {
        return;
        if ((!paramMessageRecord.isSend()) && (!bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          this.d = false;
          return;
        }
        if (nav.a(paramMessageRecord))
        {
          this.d = false;
          return;
        }
        if (abot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1032)
        {
          this.d = false;
          return;
        }
        localObject = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!((aloz)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
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
      parambdkz.a(2131370799, this.jdField_a_of_type_AndroidContentContext.getString(2131694583), 2130838683);
      this.d = true;
    } while (!bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject = new azmo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
    String str = paramMessageRecord.frienduin;
    if (bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
    for (parambdkz = "1";; parambdkz = "2")
    {
      ((azmo)localObject).a(new String[] { str, parambdkz }).a();
      return;
    }
  }
  
  public void a(bdkz parambdkz, MessageRecord paramMessageRecord)
  {
    if ((!this.d) || ((paramMessageRecord != null) && (!paramMessageRecord.isSend()))) {
      acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
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
        ((aezb)localBaseChatPie.a(46)).a(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label116;
      }
      i = 6;
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + i, "", "", "");
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
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool1 = false;; bool1 = true) {
      try
      {
        j = a(paramChatMessage);
        paramaelt.jdField_a_of_type_Int = j;
        if (j != 0) {
          if (a(paramChatMessage, paramaelt, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setSimpleUIMsgBubble " + paramChatMessage.getLogColorContent());
            }
            if (paramaelt.jdField_a_of_type_AndroidViewView != null)
            {
              paramBaseChatItemLayout.setBubbleView(paramaelt.jdField_a_of_type_AndroidViewView);
              a(paramaelt.jdField_a_of_type_AndroidViewView, paramChatMessage);
              paramaelt.jdField_a_of_type_AndroidViewView.setTag(2131363763, paramaelt.jdField_a_of_type_Ansf);
              paramaelt.jdField_a_of_type_AndroidViewView.setTag(2131364214, paramChatMessage);
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
          if (b(paramChatMessage, paramaelt, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setConfessMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (e(paramChatMessage, paramaelt, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setQimMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (d(paramChatMessage, paramaelt, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setLimitChatMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (c(paramChatMessage, paramaelt, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setGameMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else
          {
            label503:
            int i;
            if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!aoep.a(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
            {
              localObject = ldr.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
              paramContext = null;
              ldj localldj = ldn.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
              if (localldj != null) {
                paramContext = localldj.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
              }
              if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
              {
                paramaelt.jdField_a_of_type_Ansf = antf.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
                if (paramaelt.jdField_a_of_type_Ansf != null) {
                  paramaelt.jdField_a_of_type_Ansf.a(paramaelt.jdField_a_of_type_AndroidViewView, null);
                }
                if (paramaelt.jdField_a_of_type_AndroidViewView != null)
                {
                  paramaelt.jdField_a_of_type_AndroidViewView.setMinimumWidth(aekt.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                  paramaelt.jdField_a_of_type_AndroidViewView.setMinimumHeight(aekt.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                }
                if (paramaelt.jdField_a_of_type_Ansf != null)
                {
                  int k = paramChatMessage.vipBubbleDiyTextId;
                  i = k;
                  if (k <= 0) {
                    i = alxl.b(paramChatMessage.vipBubbleID);
                  }
                  if (paramChatMessage.fakeSenderType != 1) {
                    break label902;
                  }
                  paramContext = paramaelt.jdField_a_of_type_Ansf;
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  bool2 = paramChatMessage.isSend();
                  bool3 = paramChatMessage.needVipBubble();
                  if (j != 2) {
                    break label896;
                  }
                }
              }
            }
            label896:
            for (bool1 = true;; bool1 = false)
            {
              paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramaelt.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), i);
              if (paramaelt.jdField_a_of_type_AndroidViewView != null)
              {
                paramContext = paramaelt.jdField_a_of_type_AndroidViewView.getBackground();
                if (paramContext != null) {
                  paramContext.setAlpha(jdField_a_of_type_Int);
                }
              }
              a(paramaelt, paramBaseChatItemLayout, paramChatMessage, paramaelt.jdField_a_of_type_Ansf);
              a(paramaelt, paramChatMessage);
              b(paramaelt, paramChatMessage);
              if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
                jdField_a_of_type_AndroidOsHandler.post(new BaseBubbleBuilder.5(this, paramaelt, paramChatMessage));
              }
              paramChatMessage.mAnimFlag = false;
              break;
              paramaelt.jdField_a_of_type_Ansf = antf.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
              break label503;
              if ((j == 3) || (!paramChatMessage.needVipBubble()) || (aoep.a(paramChatMessage))) {
                i = 0;
              }
              for (;;)
              {
                paramaelt.jdField_a_of_type_Ansf = antf.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
                break;
                localObject = (alxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13);
                if (paramChatMessage.fakeSenderType == 1) {
                  i = ((alxl)localObject).b();
                } else {
                  i = ((alxl)localObject).a(paramChatMessage);
                }
              }
            }
            label902:
            paramContext = paramaelt.jdField_a_of_type_Ansf;
            Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            boolean bool2 = paramChatMessage.isSend();
            boolean bool3 = paramChatMessage.needVipBubble();
            if (j == 2) {}
            for (bool1 = true;; bool1 = false)
            {
              paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramaelt.jdField_a_of_type_AndroidViewView, fx.a(paramChatMessage), i);
              break;
            }
            if (paramaelt.jdField_a_of_type_AndroidViewView == null)
            {
              QLog.e("ChatItemBuilder", 1, "handleBubbleBg mContent is null type = " + paramChatMessage.istroop);
              return;
            }
            paramaelt.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, bdkz parambdkz)
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
        parambdkz.a(2131375605, this.jdField_a_of_type_AndroidContentContext.getString(2131698118), 2130838681);
        MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
    parambdkz.a(2131375605, this.jdField_a_of_type_AndroidContentContext.getString(2131698118), 2130838681);
    MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((aoep.a(paramChatMessage)) && (QLog.isColorLevel())) {
      QLog.d("ChatItemBuilder", 2, "confessType =  " + paramChatMessage.istroop + " isSend = " + paramChatMessage.isSend());
    }
    Object localObject1;
    if (paramChatMessage.fakeSenderType == 1)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramBaseChatItemLayout.setHeaderIcon(bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject1));
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
      return;
    }
    int i;
    if (aoep.a(paramChatMessage))
    {
      if (((aoel)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.getConfessTopicId()).confessorSex == 1) {}
      for (i = 2130844504;; i = 2130844503)
      {
        paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
        return;
      }
    }
    if (paramChatMessage.istroop == 10007) {
      if (paramChatMessage.isSend())
      {
        localObject1 = asio.a(paramChatMessage);
        label231:
        localObject1 = asin.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
        if (localObject1 != null) {
          break label366;
        }
        paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840084));
        label268:
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
          break label1873;
        }
        localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject1 == null) {
          break label1873;
        }
        localObject1 = ((ChatFragment)localObject1).a();
        if (!(localObject1 instanceof aglv)) {
          break label1873;
        }
        localObject1 = (aglv)localObject1;
        if (!paramChatMessage.isSend()) {
          break label375;
        }
        localObject1 = ((aglv)localObject1).a();
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener((View.OnClickListener)localObject1);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
        return;
        localObject1 = asio.b(paramChatMessage);
        break label231;
        label366:
        paramBaseChatItemLayout.setHeaderIcon(localObject1);
        break label268;
        label375:
        localObject1 = ((aglv)localObject1).b();
        continue;
        Object localObject4;
        if (nav.a(paramChatMessage))
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843228);
          localObject4 = nav.a(paramChatMessage);
          paramChatMessage = URLDrawable.getDrawable(nav.a(((naw)localObject4).jdField_b_of_type_Int), (Drawable)localObject1, (Drawable)localObject1);
          localObject1 = ((naw)localObject4).jdField_c_of_type_JavaLangString;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
        try
        {
          i = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
          paramChatMessage.setTag(new int[] { Color.parseColor((String)localObject1), i });
          paramChatMessage.setDecodeHandler(bcuq.q);
          paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
          return;
          if (((paramChatMessage instanceof MessageForStructing)) && (bcic.a(paramChatMessage)))
          {
            paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840175));
            paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
            paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
            return;
          }
          localObject1 = bcid.a(paramChatMessage);
          if (localObject1 != null)
          {
            localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840084);
            paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
            paramChatMessage.mFailedDrawable = ((Drawable)localObject4);
            paramChatMessage.mLoadingDrawable = ((Drawable)localObject4);
            for (;;)
            {
              try
              {
                paramChatMessage = URLDrawable.getDrawable(new URL(((bcie)localObject1).jdField_a_of_type_JavaLangString), paramChatMessage);
                localMalformedURLException1.printStackTrace();
              }
              catch (MalformedURLException localMalformedURLException1)
              {
                try
                {
                  paramChatMessage.setTag(bcuq.b(100, 100, 6));
                  paramChatMessage.setDecodeHandler(bcuq.a);
                  paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
                  if (paramChatMessage == null) {
                    break label671;
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
                  break label663;
                }
                localMalformedURLException1 = localMalformedURLException1;
                paramChatMessage = null;
              }
              label663:
              continue;
              label671:
              paramBaseChatItemLayout.setHeaderIcon(localObject4);
            }
          }
          k = paramChatMessage.istroop;
          if (paramChatMessage.isSend())
          {
            str = paramChatMessage.selfuin;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, false);
            if ((localObject2 != null) && (((ExtensionInfo)localObject2).faceIdUpdateTime < paramChatMessage.time))
            {
              localObject4 = paramChatMessage.getExtInfoFromExtStr("vip_face_id");
              if (QLog.isColorLevel()) {
                QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id = " + (String)localObject4);
              }
              if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (Long.parseLong((String)localObject4) != ((ExtensionInfo)localObject2).faceId))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id not equals local");
                }
                bdbg.a(str);
                bdbg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              }
            }
            localObject2 = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            localObject4 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
            if ((localObject4 == null) || (!((HotChatManager)localObject4).b(paramChatMessage.frienduin))) {
              break label1577;
            }
            i = 1;
            label870:
            if ((localObject2 == null) || (!((aloz)localObject2).b(str))) {
              break label1582;
            }
            j = 1;
            label888:
            if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) && ((k != 1022) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 4007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3019) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2019)))) || (localObject2 == null) || (((aloz)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              break label1624;
            }
            localObject4 = ((HotChatManager)localObject4).a(paramChatMessage.frienduin);
            if ((localObject4 == null) || (!((HotChatInfo)localObject4).isGameRoom)) {
              break label1606;
            }
            if ((!((aloz)localObject2).b(str)) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              break label1588;
            }
            localObject4 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
            label1090:
            localObject2 = localObject4;
            if (QLog.isColorLevel())
            {
              QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + str);
              localObject2 = localObject4;
            }
            label1132:
            paramBaseChatItemLayout.setHeaderIcon(localObject2);
            if (((paramChatMessage.isSendFromLocal()) || ((k != 1) && (k != 3000) && (k != 0) && (k != 1005) && (k != 1001) && (k != 1006) && (k != 1000) && (k != 10004) && (k != 1004) && (k != 1008) && (k != 1009) && (k != 1010) && (k != 1011) && (k != 1020) && (k != 1021) && (k != 1023) && (k != 1024) && (k != 1036) && (k != 1025) && (k != 10002) && (k != 1022))) && (k != 10008)) {
              break label1813;
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin))
            {
              localObject2 = paramChatMessage.frienduin;
              localObject4 = paramChatMessage.senderuin;
              ThreadManager.executeOnSubThread(new BaseBubbleBuilder.ProcessMemberNickTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, (String)localObject2, (String)localObject4, k, this.jdField_a_of_type_AndroidViewView$OnLongClickListener));
            }
            label1374:
            paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
            paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
            if (QLog.isColorLevel()) {
              QLog.d("BaseBubbleBuilder", 2, "AppSetting.enableTalkBack = " + AppSetting.jdField_c_of_type_Boolean);
            }
            if (!AppSetting.jdField_c_of_type_Boolean) {
              break;
            }
            localObject4 = "";
            localObject2 = localObject4;
            if (paramChatMessage.istroop != 1)
            {
              localObject2 = localObject4;
              if (paramChatMessage.istroop != 3000) {
                if (!paramChatMessage.isSend()) {
                  break label1824;
                }
              }
            }
          }
          label1813:
          label1824:
          for (localObject2 = alpo.a(2131701316);; localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString + alpo.a(2131701319))
          {
            if (paramChatMessage.msgtype == -3006) {
              localObject2 = String.format(paramBaseChatItemLayout.getResources().getString(2131698102), new Object[] { swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
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
            label1577:
            i = 0;
            break label870;
            label1582:
            j = 0;
            break label888;
            label1588:
            localObject4 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, str, true);
            break label1090;
            label1606:
            localObject4 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, str, true);
            break label1090;
            label1624:
            if ((k == 9501) && (!paramChatMessage.isSend()))
            {
              localObject2 = ((zpa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(str));
              if ((localObject2 != null) && (str.equals(String.valueOf(((DeviceInfo)localObject2).din))))
              {
                localObject2 = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.getInstance().getDeviceHeadByDin(str));
                break label1132;
              }
              localObject2 = a(paramBaseChatItemLayout, 1, str);
              break label1132;
            }
            if (k != 1006) {
              break label1868;
            }
            i = 11;
            localObject2 = a(paramBaseChatItemLayout, i, str);
            localObject4 = new bdrt(str, -1, "small", paramChatMessage.uniseq);
            ((bdrt)localObject4).a = ((Drawable)localObject2);
            localObject2 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1132;
            }
            QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + str);
            localObject2 = localObject4;
            break label1132;
            paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
            break label1374;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            continue;
            label1868:
            i = 1;
          }
        }
      }
      label1873:
      Object localObject3 = null;
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (azib.b()) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10007);
        if ((paramChatMessage == null) || (paramChatMessage.isShowQimStyleAvater) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) || (aoep.a(paramChatMessage)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1037) || (abot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1044) || (paramChatMessage.fakeSenderType != 0))
        {
          paramBaseChatItemLayout.setPendantImageVisible(false);
          return;
        }
      } while (aekt.h);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject != null) && (((TroopInfo)localObject).hasOrgs()));
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (nav.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    aloz localaloz;
    ExtensionInfo localExtensionInfo;
    AvatarPendantManager localAvatarPendantManager;
    String str;
    if (paramChatMessage.isSend())
    {
      localObject = paramChatMessage.selfuin;
      localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localaloz == null) {
        break label688;
      }
      localExtensionInfo = localaloz.a((String)localObject, false);
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
          bdbg.a((String)localObject);
          bdbg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          bdbg.a((String)localObject);
          bdbg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
        {
          AvatarPendantManager.jdField_b_of_type_Boolean = true;
          if (bdbg.a(localExtensionInfo.pendantId))
          {
            localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq, (String)localObject, localExtensionInfo.pendantDiyId);
            if ((!localaloz.b((String)localObject)) && (localExtensionInfo.isPendantExpired())) {
              bdbg.a((String)localObject);
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
        bdbg.a((String)localObject);
        continue;
      }
      label688:
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, aenl paramaenl)
  {
    axso localaxso = (axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    if ((paramMessageRecord.extraflag != 32772) || (!localaxso.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.uniseq, paramView, paramaenl)))
    {
      paramMessageRecord = aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramaenl);
      }
    }
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.jdField_a_of_type_Boolean;
  }
  
  public boolean a(aelt paramaelt)
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
    boolean bool = bclo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (bclo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    for (this.d = true;; this.d = false) {
      return this.d;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected void b(aelt paramaelt, ChatMessage paramChatMessage) {}
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = aekt.a(paramView);
    if (localChatMessage == null) {
      break label11;
    }
    label11:
    while (b(localChatMessage)) {
      return;
    }
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    boolean bool2;
    label55:
    boolean bool1;
    String str;
    if ((localChatMessage.issend == 1) || (localChatMessage.issend == 2))
    {
      bool2 = true;
      if ((a(paramView, localChatMessage)) || (a(paramView, localChatMessage, bool2))) {
        break label206;
      }
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004)) {
        break label208;
      }
      bool1 = localaloz.b(localChatMessage.senderuin);
      str = localChatMessage.senderuin;
      label127:
      if (str == null) {
        break label218;
      }
      if (!localaloz.b(str)) {
        break label1497;
      }
      bool1 = true;
    }
    label206:
    label208:
    label1497:
    for (;;)
    {
      Object localObject;
      if (bool2)
      {
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      }
      for (;;)
      {
        a(localChatMessage, str, (ProfileActivity.AllInOne)localObject);
        a(paramView, localChatMessage, localaloz, bool1, bool2, str, (ProfileActivity.AllInOne)localObject);
        return;
        bool2 = false;
        break label55;
        break label11;
        str = localChatMessage.frienduin;
        bool1 = false;
        break label127;
        label218:
        break label11;
        if (localChatMessage.istroop == 1008)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("need_finish", true);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          syb.a((Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 2, syb.jdField_a_of_type_Boolean);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          ndv.a(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
          return;
        }
        if (bool1)
        {
          if (localChatMessage.istroop == 1) {
            localObject = new ProfileActivity.AllInOne(str, 20);
          }
          for (;;)
          {
            ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = bdbt.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
            break;
            if (localChatMessage.istroop == 3000) {
              localObject = new ProfileActivity.AllInOne(str, 45);
            } else {
              localObject = new ProfileActivity.AllInOne(str, 1);
            }
          }
        }
        if (localChatMessage.istroop == 1010)
        {
          localObject = new ProfileActivity.AllInOne(str, 76);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1001)
        {
          localObject = new ProfileActivity.AllInOne(str, 42);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 10002)
        {
          localObject = new ProfileActivity.AllInOne(str, 86);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 10004)
        {
          localObject = new ProfileActivity.AllInOne(str, 94);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
        {
          localObject = new ProfileActivity.AllInOne(str, 70);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = bdbt.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        }
        else if (localChatMessage.istroop == 1000)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 22);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1020)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 58);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 21);
          ((ProfileActivity.AllInOne)localObject).l = 11;
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = bdbt.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, localChatMessage.senderuin);
        }
        else if (3000 == localChatMessage.istroop)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 46);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = bdbt.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.frienduin, localChatMessage.senderuin);
        }
        else if (localChatMessage.istroop == 1001)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 10002)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 86);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1004)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 47);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1005)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 2);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1023)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 74);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1009)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 57);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1006)
        {
          localObject = new ProfileActivity.AllInOne(localChatMessage.frienduin, 34);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1009)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 57);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1021)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 72);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        }
        else if (localChatMessage.istroop == 1022)
        {
          localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 27);
          ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
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
          if ((localChatMessage.istroop == 1037) || (abot.a(localChatMessage.istroop) == 1044))
          {
            localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
            ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          }
          else if (localChatMessage.istroop == 10008)
          {
            localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 115);
            ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          }
          else
          {
            localObject = new ProfileActivity.AllInOne(localChatMessage.senderuin, 19);
            ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          }
        }
      }
    }
  }
  
  protected void b(bdkz parambdkz, Context paramContext)
  {
    parambdkz.a(2131370902, alpo.a(2131701315), 2130838685);
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
          wta.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (MessageForStructing)localObject, "reply");
        }
      }
      afus.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, "0X800A368");
    }
  }
  
  protected void b(ChatMessage paramChatMessage, bdkz parambdkz)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      if ((!bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)) && (!nav.a(paramChatMessage)) && (!aoep.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
        break label152;
      }
      if (QLog.isColorLevel())
      {
        parambdkz = new StringBuilder("addReplyOnlyMenu isRobot=").append(bcgx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(nav.a(paramChatMessage)).append(" isConfessMsg=").append(aoep.a(paramChatMessage)).append(" isNotSupport=");
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
        parambdkz.a(2131375619, this.jdField_a_of_type_AndroidContentContext.getString(2131698124), 2130838681);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    parambdkz.a(2131375619, this.jdField_a_of_type_AndroidContentContext.getString(2131698124), 2130838681);
  }
  
  public void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!bcbx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
    }
    TroopManager localTroopManager;
    do
    {
      do
      {
        return;
        if (!bcbx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          return;
        }
      } while (paramChatMessage.istroop != 1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    } while (!((bcbt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(paramChatMessage.frienduin));
    aelr localaelr2 = (aelr)paramBaseChatItemLayout.getTag(2131364208);
    aelr localaelr1 = localaelr2;
    if (localaelr2 == null)
    {
      localaelr1 = new aelr(this, null);
      paramBaseChatItemLayout.setTag(2131364208, localaelr1);
    }
    localaelr1.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    localaelr1.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, localaelr1);
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
    ChatMessage localChatMessage = aekt.a(paramView);
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
            localObject1 = bcid.a(localChatMessage);
            if (localObject1 == null) {
              break;
            }
            bcid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bcie)localObject1);
            paramView = ((bcie)localObject1).jdField_c_of_type_JavaLangString;
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, localChatMessage.frienduin, "", paramView, "");
          } while (localChatMessage.msgtype != -2051);
          try
          {
            paramView = (MessageForQQStory)localChatMessage;
            paramView = bdds.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
            QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_name", paramView, false);
            return;
          }
          catch (Exception paramView) {}
        } while (!QLog.isColorLevel());
        QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramView);
        return;
      } while ((localChatMessage == null) || (localChatMessage.istroop != 1) || (!bdal.d(localChatMessage.senderuin)));
      localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((HotChatManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label463;
      }
    } while ((((HotChatInfo)localObject1).isGameRoom) || ((((HotChatInfo)localObject1).isRobotHotChat) && (((bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin)))));
    Object localObject1 = localChatMessage.senderuin;
    paramView = auso.a((String)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)) {}
    for (paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramView;; paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747")
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        azmj.b(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject1, "", "", "");
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return;
        localObject1 = null;
        break;
      }
      label463:
      if (((bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin))) {
        break;
      }
      localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int i;
      label557:
      Object localObject3;
      if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
      {
        i = paramView.getId();
        if (i == 2131364209)
        {
          localObject1 = "clk_title";
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
          localObject3 = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
          if (i != 2131364209) {
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
          Object localObject4 = bckj.a();
          if (i == 2)
          {
            localObject3 = "troop_unique_title";
            localObject3 = ((bckj)localObject4).a((String)localObject3);
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
            ((Intent)localObject3).putExtra("selfSet_leftViewText", alpo.a(2131701313));
            paramView.startActivity((Intent)localObject3);
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject4 = localChatMessage.frienduin;
            if (!localChatMessage.isSend()) {
              continue;
            }
            paramView = "1";
            azmj.b((QQAppInterface)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, (String)localObject4, paramView, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
            }
            if (this.jdField_c_of_type_Int < 2) {
              break;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_c_of_type_Int), "", "");
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
          bckk localbckk = new bckk();
          localbckk.jdField_a_of_type_JavaLangString = localChatMessage.frienduin;
          localbckk.jdField_b_of_type_JavaLangString = localChatMessage.senderuin;
          localbckk.jdField_e_of_type_JavaLangString = ((String)localObject2);
          localbckk.jdField_d_of_type_JavaLangString = ("" + i);
          localbckk.jdField_c_of_type_JavaLangString = "aio";
          localObject2 = localException.a((String)localObject3, localbckk);
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
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
        }
      }
    }
  }
  
  protected void c(bdkz parambdkz, Context paramContext)
  {
    if ((b()) && (aukx.a().a())) {
      parambdkz.a(2131370842, paramContext.getString(2131694625), 2130838685);
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
    ((axis)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(paramChatMessage);
    Intent localIntent = aekt.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 1 });
    localIntent.putExtra("uin", paramChatMessage.senderuin);
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_reply_only_uniseq", paramChatMessage.uniseq);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin);
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4F5", "0X800A4F5", i, 0, "", "", "", "");
      return;
      localIntent.putExtra("uintype", 1000);
      localIntent.putExtra("uinname", bdbt.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage.senderuin));
      localIntent = new Intent(localIntent);
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject != null) {
        ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new aelo(this, localIntent));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bcjl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697832, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      return true;
    }
    return false;
  }
  
  public void d() {}
  
  protected void d(bdkz parambdkz, Context paramContext)
  {
    parambdkz.a(2131366015, paramContext.getString(2131692400), 2130838676);
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
      akwk.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
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
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, "" + i, "", "", "");
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + j, "", "", "");
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
  
  protected void e(bdkz parambdkz, Context paramContext)
  {
    parambdkz.a(2131362377, paramContext.getString(2131690046), 2130838685);
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
    akwk.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
    localObject = "0";
    if (paramChatMessage.istroop == 1) {
      localObject = "2";
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 1, 0, (String)localObject, "", "", "");
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
        aekt.n = true;
        switch (paramView.getId())
        {
        default: 
          return;
        case 2131364162: 
        case 2131364207: 
        case 2131364180: 
        case 2131364178: 
        case 2131364188: 
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
        case 2131364193: 
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), null);
          return;
        }
        Object localObject = (aemk)aekt.a(paramView);
        String str = ((aemk)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
        localObject = ((aemk)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
        if (!((bcbt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(str)) {
          break;
        }
        str = bckj.a().a(str, (String)localObject);
        localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", str);
        paramView.getContext().startActivity((Intent)localObject);
      } while (paramView.getId() != 2131364208);
      azmj.b(null, "dc00898", "", "", "0X800A705", "0X800A705", 0, 0, "", "", "", "");
      return;
    } while (paramView.getId() != 2131364209);
    c(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */