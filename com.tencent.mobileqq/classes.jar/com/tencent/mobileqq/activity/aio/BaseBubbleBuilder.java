package com.tencent.mobileqq.activity.aio;

import aabc;
import aara;
import abwz;
import acvv;
import aexh;
import aeyp;
import aeyt;
import aeyu;
import aeyv;
import aeyw;
import aeyx;
import aeyy;
import aeyz;
import aeza;
import aezb;
import aezc;
import aezd;
import aeze;
import aezf;
import aezp;
import aezw;
import aezx;
import aezy;
import aezz;
import afaz;
import afbb;
import afbd;
import afcd;
import afce;
import afdd;
import afdg;
import afdi;
import afhx;
import afpd;
import agjt;
import agmk;
import agqd;
import agqn;
import ahcd;
import ahfp;
import ahkz;
import ahrg;
import ahrr;
import amat;
import amoo;
import amsw;
import amtj;
import anaj;
import anca;
import ancx;
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
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apdy;
import apeb;
import apee;
import apef;
import apeg;
import apfe;
import aprv;
import apsa;
import apse;
import apsz;
import apxz;
import aqdi;
import arib;
import athq;
import atyf;
import atyg;
import auyo;
import avsq;
import awcm;
import awct;
import awkh;
import aynd;
import azye;
import bahm;
import bbko;
import bblk;
import bbyp;
import bcef;
import bcek;
import bcji;
import bczs;
import beda;
import bedw;
import bedz;
import beeg;
import bepr;
import bepv;
import bewy;
import bezm;
import bezr;
import bezs;
import bezt;
import bfas;
import bfat;
import bfau;
import bfbz;
import bfcf;
import bfcx;
import bfcy;
import bfdm;
import bfol;
import bfsu;
import bfsx;
import bftf;
import bfua;
import bfvo;
import bfwg;
import bfwo;
import bfzg;
import bfzl;
import bgaz;
import bgbb;
import bgdk;
import bghu;
import bhab;
import bhar;
import bily;
import bint;
import bjmr;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDrawable;
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
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
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
import gb;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import lae;
import lah;
import lai;
import lam;
import nmy;
import nmz;
import npt;
import org.jetbrains.annotations.Nullable;
import uex;
import ugf;
import xwa;

public abstract class BaseBubbleBuilder
  extends aezx
  implements aezw, View.OnClickListener
{
  public static int a;
  public static ColorFilter a;
  public static final Handler a;
  protected static final ConcurrentHashMap<Long, String> a;
  public static boolean a;
  protected float a;
  long jdField_a_of_type_Long = 0L;
  private aezz jdField_a_of_type_Aezz;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new aeyw(this);
  protected ViewGroup a;
  @Deprecated
  public BaseAdapter a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  public QQAppInterface a;
  public FaceDecoder a;
  protected HashSet<Long> a;
  long jdField_b_of_type_Long = 0L;
  private aezz jdField_b_of_type_Aezz;
  public boolean b;
  private int jdField_c_of_type_Int;
  private aezz jdField_c_of_type_Aezz;
  public boolean c;
  private aezz d;
  protected boolean d;
  private aezz e;
  private aezz jdField_f_of_type_Aezz;
  private boolean jdField_f_of_type_Boolean;
  
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
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Aezz = a();
    this.jdField_b_of_type_Aezz = b();
    this.jdField_c_of_type_Aezz = c();
    this.jdField_d_of_type_Aezz = d();
    this.e = e();
    this.jdField_f_of_type_Aezz = f();
  }
  
  private int a(aezf paramaezf, aeyz paramaeyz, List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    int i = paramaeyz.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramInt2;
    paramInt2 = i;
    if (paramaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
      paramInt2 = i + (AIOUtils.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (paramaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin));
    }
    i = paramInt2;
    if (paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
      i = paramInt2 + (AIOUtils.dp2px(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin));
    }
    paramInt2 = i;
    int j;
    if (i < 0)
    {
      j = -i;
      if (paramaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      if (paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams == null) {
        break label252;
      }
    }
    label252:
    for (paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;; paramaeyz.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j)
    {
      if (paramaeyz.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramaeyz.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      if (paramaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      i = 0;
      paramInt2 = i;
      if (paramInt1 != paramList.size() - 1)
      {
        paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c(j);
        paramInt2 = i;
      }
      return paramInt2;
    }
  }
  
  private int a(Context paramContext, aezf paramaezf, aeyz paramaeyz, List<MessageRecord> paramList, int paramInt)
  {
    avsq localavsq = (avsq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    int k = 0;
    int j = paramList.size() - 1;
    int i = paramInt;
    paramInt = k;
    Object localObject2;
    if (j >= 0)
    {
      localObject2 = (MessageRecord)paramList.get(j);
      if (((MessageRecord)localObject2).extraflag == 32768) {
        paramInt += 1;
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a((MessageRecord)localObject2);
      if ((localStickerInfo != null) && (EmojiStickerManager.c((MessageRecord)localObject2)))
      {
        i += 1;
        if (i > EmojiStickerManager.jdField_f_of_type_Int)
        {
          ((MessageRecord)localObject2).msgtype = -2006;
          paramInt += 1;
        }
        else
        {
          Object localObject1 = a(localavsq, (MessageRecord)localObject2, null);
          label166:
          int n;
          label190:
          int m;
          label214:
          int i1;
          label238:
          int i2;
          int i3;
          if (localStickerInfo.x <= 1.0F)
          {
            k = (int)(localStickerInfo.x * paramaeyz.jdField_a_of_type_Int);
            if (localStickerInfo.y > 1.0F) {
              break label405;
            }
            n = (int)(localStickerInfo.y * paramaeyz.jdField_a_of_type_Int);
            if (localStickerInfo.width > 1.0F) {
              break label414;
            }
            m = (int)(localStickerInfo.width * paramaeyz.jdField_a_of_type_Int);
            if (localStickerInfo.height > 1.0F) {
              break label423;
            }
            i1 = (int)(localStickerInfo.height * paramaeyz.jdField_a_of_type_Int);
            i2 = localStickerInfo.rotate;
            i3 = a(paramaezf, paramaeyz, paramList, j, n);
            if (!(localObject1 instanceof PicEmoticonInfo)) {
              break label453;
            }
            localObject2 = (PicEmoticonInfo)localObject1;
            if (((PicEmoticonInfo)localObject2).emoticon == null) {
              break label580;
            }
            if ((EmojiStickerManager.jdField_f_of_type_Boolean) || (FileUtils.getAvailableInnernalMemorySize() <= 1.048576E+008F)) {
              break label432;
            }
            n = 1;
            label301:
            if (n == 0) {
              break label438;
            }
            localObject1 = ((PicEmoticonInfo)localObject2).getLoadingDrawable("fromAIO", true, false, null, m, m);
            label323:
            localObject2 = ((PicEmoticonInfo)localObject2).emoticon.epId;
          }
          for (;;)
          {
            label333:
            BaseChatItemLayout localBaseChatItemLayout;
            double d1;
            boolean bool;
            if (localObject1 != null)
            {
              localBaseChatItemLayout = paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
              d1 = i2;
              bool = localStickerInfo.isShown;
              if (!localStickerInfo.isShown) {
                break label558;
              }
            }
            label405:
            label414:
            label423:
            label558:
            for (float f1 = 1.0F;; f1 = 1.1F)
            {
              localBaseChatItemLayout.a((Drawable)localObject1, k, i3, m, i1, d1, (String)localObject2, bool, f1, localStickerInfo);
              break;
              k = paramaeyz.jdField_a_of_type_Int;
              break label166;
              n = paramaeyz.jdField_a_of_type_Int;
              break label190;
              m = paramaeyz.jdField_a_of_type_Int;
              break label214;
              i1 = paramaeyz.jdField_a_of_type_Int;
              break label238;
              label432:
              n = 0;
              break label301;
              label438:
              localObject1 = ((PicEmoticonInfo)localObject2).getDrawable(paramContext, paramaeyz.jdField_a_of_type_Float);
              break label323;
              label453:
              if ((localObject1 instanceof SystemAndEmojiEmoticonInfo))
              {
                localObject1 = ((SystemAndEmojiEmoticonInfo)localObject1).getBigDrawable(paramContext, paramaeyz.jdField_a_of_type_Float);
                localObject2 = "";
                break label333;
              }
              if ((localObject1 instanceof SmallEmoticonInfo))
              {
                localObject1 = ((SmallEmoticonInfo)localObject1).getBigDrawable(paramContext, paramaeyz.jdField_a_of_type_Float);
                localObject2 = "";
                break label333;
              }
              if (!(localObject2 instanceof MessageForPic)) {
                break label569;
              }
              localObject1 = agjt.a(paramContext, (MessageForPic)localObject2);
              ThreadManager.post(new BaseBubbleBuilder.2(this, (MessageRecord)localObject2), 5, null, true);
              localObject2 = "";
              break label333;
            }
            return paramInt;
            label569:
            localObject2 = "";
            localObject1 = null;
            continue;
            label580:
            localObject1 = null;
            localObject2 = "";
          }
        }
      }
    }
  }
  
  private int a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 0;
    if (arib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      return arib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this, paramChatMessage, paramBaseChatItemLayout);
    }
    int m = paramChatMessage.istroop;
    String str = c(paramChatMessage);
    Object localObject1 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if ((localObject2 != null) && (((HotChatManager)localObject2).b(paramChatMessage.frienduin)))
    {
      i = 1;
      int j = k;
      if (localObject1 != null)
      {
        j = k;
        if (((amsw)localObject1).b(str)) {
          j = 1;
        }
      }
      if (((m != 1010) && (m != 1001) && (m != 10002) && ((i == 0) || ((j != 0) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) && ((m != 1022) || (!d()))) || (localObject1 == null) || (((amsw)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
        break label234;
      }
      paramChatMessage = a(paramChatMessage, str, (amsw)localObject1, (HotChatManager)localObject2);
    }
    for (;;)
    {
      paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
      return m;
      i = 0;
      break;
      label234:
      if ((m != 9501) || (paramChatMessage.isSend())) {
        break label326;
      }
      paramChatMessage = ((aara)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(51)).a(Long.parseLong(str));
      if ((paramChatMessage != null) && (str.equals(String.valueOf(paramChatMessage.din)))) {
        paramChatMessage = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.getInstance().getDeviceHeadByDin(str));
      } else {
        paramChatMessage = a(paramBaseChatItemLayout, 1, str);
      }
    }
    label326:
    if (m == 1006) {}
    for (int i = 11;; i = 1)
    {
      localObject2 = a(paramBaseChatItemLayout, i, str);
      localObject1 = new bghu(str, -1, "small", paramChatMessage.uniseq);
      ((bghu)localObject1).a = ((Drawable)localObject2);
      paramChatMessage = (ChatMessage)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + str);
      paramChatMessage = (ChatMessage)localObject1;
      break;
    }
  }
  
  private int a(TroopInfo paramTroopInfo)
  {
    int j = 0;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    int i = j;
    if (paramTroopInfo != null)
    {
      i = j;
      if (!android.text.TextUtils.isEmpty(str))
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
  
  private ColorStateList a(ChatMessage paramChatMessage, ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (!this.jdField_c_of_type_Boolean)
    {
      localColorStateList = paramColorStateList;
      if (!this.jdField_b_of_type_Boolean)
      {
        localColorStateList = paramColorStateList;
        if (!paramChatMessage.isMultiMsg)
        {
          localColorStateList = paramColorStateList;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
          {
            localColorStateList = paramColorStateList;
            if (nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
              localColorStateList = ColorStateList.valueOf(nmy.jdField_d_of_type_Int);
            }
          }
        }
      }
    }
    return localColorStateList;
  }
  
  private ColorStateList a(ChatMessage paramChatMessage, ColorStateList paramColorStateList, bfau parambfau)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      localColorStateList = paramColorStateList;
      if (!apsz.a(paramChatMessage)) {
        localColorStateList = ColorStateList.valueOf(parambfau.jdField_b_of_type_Int);
      }
    }
    return localColorStateList;
  }
  
  @Nullable
  private HotChatInfo a(ChatMessage paramChatMessage, HotChatManager paramHotChatManager, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramHotChatManager.a(paramChatMessage.frienduin);
    }
    return null;
  }
  
  private EmoticonInfo a(avsq paramavsq, MessageRecord paramMessageRecord, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      paramavsq = paramavsq.a(((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage);
    }
    do
    {
      do
      {
        return paramavsq;
        paramavsq = paramEmoticonInfo;
      } while (!(paramMessageRecord instanceof MessageForText));
      paramMessageRecord = (MessageForText)paramMessageRecord;
      paramavsq = paramEmoticonInfo;
    } while (android.text.TextUtils.isEmpty(paramMessageRecord.msg));
    return EmojiStickerManager.a().a(paramMessageRecord.msg);
  }
  
  private CharSequence a(ChatMessage paramChatMessage, CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramChatMessage.isMultiMsg)
    {
      localObject = paramCharSequence;
      if (!nmy.a(paramChatMessage))
      {
        localObject = paramChatMessage.getExtInfoFromExtStr("self_nickname");
        paramCharSequence = (CharSequence)localObject;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
          paramCharSequence = awcm.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if (paramCharSequence != null)
        {
          localObject = paramCharSequence;
          if (android.text.TextUtils.getTrimmedLength(paramCharSequence) != 0) {}
        }
        else
        {
          localObject = awct.a(paramChatMessage.senderuin);
        }
        localObject = new bczs((CharSequence)localObject, 13).a();
      }
    }
    return localObject;
  }
  
  private Object a(ChatMessage paramChatMessage, String paramString, amsw paramamsw, HotChatManager paramHotChatManager)
  {
    paramChatMessage = paramHotChatManager.a(paramChatMessage.frienduin);
    if ((paramChatMessage != null) && (paramChatMessage.isGameRoom)) {
      if ((paramamsw.b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        paramChatMessage = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + paramString);
      }
      return paramChatMessage;
      paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true);
      continue;
      paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true);
    }
  }
  
  private String a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    bfcx localbfcx = bfcx.a();
    if (paramInt == 2) {}
    for (Object localObject = "troop_unique_title";; localObject = "troop_rank")
    {
      localObject = localbfcx.a((String)localObject);
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
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
    bfcy localbfcy = new bfcy();
    localbfcy.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    localbfcy.jdField_b_of_type_JavaLangString = paramMessageRecord.senderuin;
    localbfcy.jdField_e_of_type_JavaLangString = paramString;
    localbfcy.jdField_d_of_type_JavaLangString = ("" + paramInt);
    localbfcy.jdField_c_of_type_JavaLangString = "aio";
    return localbfcx.a((String)localObject, localbfcy);
  }
  
  private void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf, CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg != null)
    {
      ColorStateList localColorStateList2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList;
      ColorStateList localColorStateList1 = localColorStateList2;
      if (!this.jdField_c_of_type_Boolean)
      {
        localColorStateList1 = localColorStateList2;
        if (!this.jdField_b_of_type_Boolean)
        {
          localColorStateList1 = localColorStateList2;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
          {
            localColorStateList1 = localColorStateList2;
            if (nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
              localColorStateList1 = ColorStateList.valueOf(nmy.jdField_d_of_type_Int);
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1033) {
        localColorStateList1 = ColorStateList.valueOf(nmy.jdField_d_of_type_Int);
      }
      paramBaseChatItemLayout.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage, localColorStateList1, paramCharSequence);
    }
    if (bfas.a(paramChatMessage))
    {
      paramBaseChatItemLayout.setGrayTipsText(true, paramChatMessage, paramContext.getString(2131695908), this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165436), 0);
      a(paramInt1, paramChatMessage, paramBaseChatItemLayout, paramViewGroup);
      this.jdField_a_of_type_Aezz.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramaezf);
      a(paramChatMessage, paramBaseChatItemLayout);
      paramBaseChatItemLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      this.jdField_b_of_type_Aezz.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramaezf);
      a(paramChatMessage, paramBaseChatItemLayout, paramInt1, paramInt2);
      this.jdField_c_of_type_Aezz.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramaezf);
      if (paramChatMessage.fakeSenderType == 1) {
        paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
      }
      if ((paramChatMessage.fakeSenderType == 2) && (!nmy.a(paramChatMessage))) {
        d(paramChatMessage, paramBaseChatItemLayout, paramaezf);
      }
      if (paramChatMessage.fakeSenderType == 0)
      {
        if (((paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 3000)) || (!paramChatMessage.isMultiMsg)) {
          break label511;
        }
        d(paramChatMessage, paramBaseChatItemLayout, paramaezf);
      }
      label338:
      this.jdField_d_of_type_Aezz.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramaezf);
      if ((paramChatMessage.fakeSenderType == 2) && (nmy.a(paramChatMessage))) {
        c(paramChatMessage, paramBaseChatItemLayout, paramaezf);
      }
      if ((paramChatMessage.fakeSenderType == 0) && (paramChatMessage.istroop == 1))
      {
        paramCharSequence = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((paramCharSequence == null) || (!paramCharSequence.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
          break label531;
        }
        f(paramChatMessage, paramBaseChatItemLayout);
        i(paramChatMessage, paramBaseChatItemLayout);
        c(paramChatMessage, paramBaseChatItemLayout, paramaezf);
        b(paramChatMessage, paramBaseChatItemLayout);
      }
    }
    for (;;)
    {
      this.e.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, paramContext, paramBaseChatItemLayout, paramaezf);
      return;
      paramBaseChatItemLayout.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165436), 235);
      break;
      label511:
      if (paramChatMessage.istroop == 1) {
        break label338;
      }
      b(paramChatMessage, paramBaseChatItemLayout, paramaezf);
      break label338;
      label531:
      c(paramChatMessage, paramBaseChatItemLayout, paramaezf);
      g(paramChatMessage, paramBaseChatItemLayout);
      b(paramChatMessage, paramBaseChatItemLayout);
      h(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aeyz paramaeyz)
  {
    paramaeyz.jdField_a_of_type_JavaUtilList = EmojiStickerManager.a().a(paramChatMessage);
    paramaeyz.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    paramaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    paramaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) {
      paramaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams());
    }
    if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {
      paramaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
    }
    if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams());
    }
    if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      paramaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
    }
    paramaeyz.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    paramaeyz.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    if (paramaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramaeyz.jdField_a_of_type_Boolean = true;
      paramaeyz.jdField_b_of_type_Int = paramaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramaeyz.jdField_c_of_type_Int = paramaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramaeyz.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramaeyz.jdField_d_of_type_Int = paramaeyz.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramaeyz.jdField_e_of_type_Int = paramaeyz.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramaeyz.jdField_b_of_type_Boolean = true;
      paramaeyz.jdField_f_of_type_Int = paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramaeyz.g = paramaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramaeyz.jdField_h_of_type_Int = paramaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramaeyz.i = paramaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramaeyz.jdField_c_of_type_Boolean = true;
      paramaeyz.j = paramaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramaeyz.k = paramaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramaeyz.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramaeyz.jdField_d_of_type_Boolean = true;
      paramaeyz.l = paramaeyz.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramaeyz.m = paramaeyz.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf)
  {
    if ((paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if ((paramView != null) && (paramView.getId() == 2131364441) && (i == 0) && (EmojiStickerManager.d(paramChatMessage)) && (paramChatMessage.fakeSenderType == 0))
      {
        aeyz localaeyz = new aeyz(this);
        a(paramContext, paramView, paramChatMessage, paramBaseChatItemLayout, localaeyz);
        if ((localaeyz.jdField_a_of_type_JavaUtilList != null) && (localaeyz.jdField_a_of_type_JavaUtilList.size() > 0) && (EmojiStickerManager.b(paramChatMessage)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localaeyz.jdField_a_of_type_JavaUtilList);
          if (a(paramContext, paramaezf, localaeyz, paramView, 0) != paramView.size())
          {
            paramView = new Bundle();
            paramView.putBoolean("haveTimeStamp", localaeyz.jdField_a_of_type_Boolean);
            paramView.putBoolean("haveNickName", localaeyz.jdField_b_of_type_Boolean);
            paramView.putBoolean("havePendant", localaeyz.jdField_c_of_type_Boolean);
            paramView.putBoolean("haveTroopMemberLevel", localaeyz.jdField_d_of_type_Boolean);
            if (localaeyz.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
            {
              paramView.putInt("timeStampTop", localaeyz.jdField_b_of_type_Int);
              paramView.putInt("timeStampBottom", localaeyz.jdField_c_of_type_Int);
            }
            if (localaeyz.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
            {
              paramView.putInt("textViewTop", localaeyz.jdField_d_of_type_Int);
              paramView.putInt("textViewBottom", localaeyz.jdField_e_of_type_Int);
            }
            if (localaeyz.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
            {
              paramView.putInt("nickNameViewTop", localaeyz.jdField_f_of_type_Int);
              paramView.putInt("nickNameViewBottom", localaeyz.g);
            }
            if (localaeyz.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
            {
              paramView.putInt("headViewTop", localaeyz.jdField_h_of_type_Int);
              paramView.putInt("headViewBottom", localaeyz.i);
            }
            if (localaeyz.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
            {
              paramView.putInt("pendantViewTop", localaeyz.j);
              paramView.putInt("pendantViewBottom", localaeyz.k);
            }
            if (localaeyz.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
            {
              paramView.putInt("troopMemberLevelTop", localaeyz.l);
              paramView.putInt("troopMemberLevelBottom", localaeyz.m);
            }
            paramBaseChatItemLayout.setTag(2131374022, paramView);
          }
          paramBaseChatItemLayout.jdField_a_of_type_Arel = new aeyt(this);
        }
        if (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null)
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          paramView.addRule(6, 2131364450);
          paramView.topMargin = (-AIOUtils.dp2px(1.0F, paramContext.getResources()));
        }
      }
      return;
    }
  }
  
  private void a(View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramView != null) && (paramView.getId() == 2131364441))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131374022);
      if ((localObject instanceof Bundle))
      {
        localObject = (Bundle)localObject;
        boolean bool1 = ((Bundle)localObject).getBoolean("haveTimeStamp");
        boolean bool2 = ((Bundle)localObject).getBoolean("haveNickName");
        boolean bool3 = ((Bundle)localObject).getBoolean("havePendant");
        ((Bundle)localObject).getBoolean("haveTroopMemberLevel");
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
        if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (bool1))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("timeStampTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("timeStampBottom", 0);
        }
        paramBaseChatItemLayout.setTag(2131374022, null);
      }
    }
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, amsw paramamsw, boolean paramBoolean1, boolean paramBoolean2, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 10002))
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      if (paramMessageRecord.istroop == 1001)
      {
        paramAllInOne.jdField_h_of_type_Int = 10;
        paramView.putExtra("frome_where", 21);
        paramAllInOne.a = aabc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        paramView.putExtra("AllInOne", paramAllInOne);
        if (!bftf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString)) {
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
    if ((!paramBoolean2) && (!paramamsw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
    {
      paramamsw = ahkz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramBoolean1, paramBoolean2);
      if (paramamsw == null) {
        break label305;
      }
      paramAllInOne.b.putSerializable("param_wzry_data", paramamsw);
    }
    while (auyo.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.entrance == 20) {
        i = 1;
      }
      ProfileActivity.a(paramView.getContext(), paramAllInOne, i, 2);
      return;
      label305:
      if (!android.text.TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key")))
      {
        paramMessageRecord = paramMessageRecord.senderuin;
        paramMessageRecord = KplRoleInfo.WZRYUIinfo.createInfo(paramMessageRecord, KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)), KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0);
        paramAllInOne.b.putSerializable("param_wzry_data", paramMessageRecord);
      }
    }
    ProfileActivity.b(paramView.getContext(), paramAllInOne);
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, nmz paramnmz, int paramInt)
  {
    Object localObject1 = paramnmz.a();
    if ((localObject1 != null) && (paramnmz.jdField_a_of_type_Int != 2))
    {
      nmy.jdField_a_of_type_Long = paramMessageRecord.shmsgseq;
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject1, 2));
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localStringBuilder = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject1).append("&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(nmy.a(paramnmz.jdField_b_of_type_Int)).append("&nick=");
      if (android.text.TextUtils.isEmpty(paramnmz.jdField_b_of_type_JavaLangString))
      {
        paramnmz = "";
        ((Intent)localObject2).putExtra("url", paramnmz + "&role=" + String.valueOf(paramInt) + "&self=0");
        ((Activity)paramView.getContext()).startActivity((Intent)localObject2);
        if (paramMessageRecord.msgData != null)
        {
          nmy.a().a(paramMessageRecord.frienduin, (String)localObject1, paramMessageRecord);
          if (QLog.isDevelopLevel()) {
            QLog.i("ChatItemBuilder", 4, "report:" + paramMessageRecord.msgData.toString());
          }
        }
      }
    }
    while (paramnmz.jdField_a_of_type_Int != 2) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        paramnmz = URLEncoder.encode(paramnmz.jdField_b_of_type_JavaLangString);
      }
    }
    localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    Object localObject2 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(nmy.a(paramnmz.jdField_b_of_type_Int)).append("&nick=");
    if (android.text.TextUtils.isEmpty(paramnmz.jdField_b_of_type_JavaLangString)) {}
    for (paramMessageRecord = "";; paramMessageRecord = URLEncoder.encode(paramnmz.jdField_b_of_type_JavaLangString))
    {
      ((Intent)localObject1).putExtra("url", paramMessageRecord + "&role=" + String.valueOf(paramInt) + "&self=1");
      ((Activity)paramView.getContext()).startActivity((Intent)localObject1);
      return;
    }
  }
  
  public static void a(bgaz parambgaz, Context paramContext)
  {
    parambgaz.a(2131365382, paramContext.getString(2131690679), 2130838966);
  }
  
  private void a(bgaz parambgaz, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Object localObject = new bgbb(2131371455, this.jdField_a_of_type_AndroidContentContext.getString(2131693964));
    ((bgbb)localObject).a(2130838979);
    ((bgbb)localObject).a(paramBoolean);
    parambgaz.a((bgbb)localObject);
    this.jdField_d_of_type_Boolean = true;
    String str;
    if (TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      localObject = new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
      str = paramMessageRecord.frienduin;
      if (!TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label155;
      }
    }
    label155:
    for (parambgaz = "1";; parambgaz = "2")
    {
      ((bcek)localObject).a(new String[] { str, parambgaz }).a();
      return;
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    String str = paramSessionInfo.curFriendNick;
    if (paramChatMessage.isSend()) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    if (!android.text.TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.a(bool, str, paramSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
      return;
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!apse.a(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
    {
      localObject = lam.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      paramContext = null;
      lae locallae = lai.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (locallae != null) {
        paramContext = locallae.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
      }
      if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
      {
        paramaezf.jdField_a_of_type_Apee = apfe.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBoolean);
        paramaezf.jdField_a_of_type_Apee.a(paramaezf.jdField_a_of_type_AndroidViewView, null);
        if (paramaezf.jdField_a_of_type_AndroidViewView != null)
        {
          paramaezf.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.dp2px(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramaezf.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.dp2px(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        int j = paramChatMessage.vipBubbleDiyTextId;
        i = j;
        if (j <= 0) {
          i = anaj.b(paramChatMessage.vipBubbleID);
        }
        if (paramChatMessage.fakeSenderType != 1) {
          break label513;
        }
        paramContext = paramaezf.jdField_a_of_type_Apee;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        bool1 = paramChatMessage.isSend();
        bool2 = paramChatMessage.needVipBubble();
        if (paramInt3 != 2) {
          break label507;
        }
      }
    }
    label507:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramContext.a((QQAppInterface)localObject, bool1, bool2, paramBoolean, paramaezf.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), i);
      if (paramaezf.jdField_a_of_type_AndroidViewView != null)
      {
        paramContext = paramaezf.jdField_a_of_type_AndroidViewView.getBackground();
        if (paramContext != null) {
          paramContext.setAlpha(jdField_a_of_type_Int);
        }
      }
      a(paramaezf, paramBaseChatItemLayout, paramChatMessage, paramaezf.jdField_a_of_type_Apee);
      a(paramaezf, paramChatMessage);
      b(paramaezf, paramChatMessage);
      if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
        jdField_a_of_type_AndroidOsHandler.post(new BaseBubbleBuilder.5(this, paramaezf, paramChatMessage));
      }
      paramChatMessage.mAnimFlag = false;
      return;
      paramaezf.jdField_a_of_type_Apee = apfe.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBoolean);
      break;
      if ((paramInt3 == 3) || (!paramChatMessage.needVipBubble()) || (apse.a(paramChatMessage))) {
        i = 0;
      }
      for (;;)
      {
        paramaezf.jdField_a_of_type_Apee = apfe.a(i, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramBoolean);
        break;
        localObject = (anaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(13);
        if (paramChatMessage.fakeSenderType == 1) {
          i = ((anaj)localObject).b();
        } else {
          i = ((anaj)localObject).a(paramChatMessage);
        }
      }
    }
    label513:
    paramContext = paramaezf.jdField_a_of_type_Apee;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool1 = paramChatMessage.isSend();
    boolean bool2 = paramChatMessage.needVipBubble();
    if (paramInt3 == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramContext.a((QQAppInterface)localObject, bool1, bool2, paramBoolean, paramaezf.jdField_a_of_type_AndroidViewView, gb.a(paramChatMessage), i);
      break;
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, Exception paramException)
  {
    String str = "";
    paramException = str;
    if (paramContext != null)
    {
      paramException = str;
      if ((paramContext instanceof Activity)) {
        paramException = paramContext.getClass().getName();
      }
    }
    QLog.e("BaseBubbleBuilder", 1, paramException + " baseBubbleBuilderCatchedException " + paramChatMessage.msgtype);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt)
  {
    new afhx().a(paramChatMessage, paramBaseChatItemLayout, paramInt);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf)
  {
    if (AppSetting.jdField_c_of_type_Boolean)
    {
      paramaezf.jdField_b_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
      paramChatMessage = Spannable.Factory.getInstance().newSpannable(paramaezf.jdField_b_of_type_JavaLangStringBuilder.toString());
      if (!Linkify.addLinks(paramChatMessage, 15)) {
        break label53;
      }
      paramBaseChatItemLayout.setContentDescription(paramChatMessage);
    }
    for (;;)
    {
      paramBaseChatItemLayout.setFocusable(true);
      return;
      label53:
      paramBaseChatItemLayout.setContentDescription(paramaezf.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, String paramString, amsw paramamsw)
  {
    ExtensionInfo localExtensionInfo = paramamsw.a(paramString, false);
    AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
    String str;
    if ((localExtensionInfo != null) && (localExtensionInfo.lastUpdateTime < paramChatMessage.time))
    {
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_id");
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message id = " + str);
      }
      if ((!android.text.TextUtils.isEmpty(str)) && (Long.parseLong(str) != localExtensionInfo.pendantId))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message id not equals local");
        }
        bfua.a(paramString);
        bfua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_diy_id");
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message pendantDiyId = " + str);
      }
      if (android.text.TextUtils.isEmpty(str)) {}
    }
    try
    {
      if (Integer.parseInt(str) != localExtensionInfo.pendantDiyId)
      {
        bfua.a(paramString);
        bfua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
      {
        AvatarPendantManager.jdField_b_of_type_Boolean = true;
        if (bfua.a(localExtensionInfo.pendantId))
        {
          localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq, paramString, localExtensionInfo.pendantDiyId);
          if ((!paramamsw.b(paramString)) && (localExtensionInfo.isPendantExpired())) {
            bfua.a(paramString);
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
      bfua.a(paramString);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, bfau parambfau)
  {
    bfat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, parambfau);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, paramMessageRecord.frienduin, "", parambfau.jdField_c_of_type_JavaLangString, "");
    if (paramMessageRecord.msgtype == -2051) {}
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "clk_head", paramMessageRecord, false);
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
    paramAllInOne.a = aabc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    paramAllInOne.f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    paramAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
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
        paramAllInOne.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;
        paramAllInOne.jdField_c_of_type_JavaLangString = paramMessageRecord.frienduin;
      }
      else if (3000 == paramMessageRecord.istroop)
      {
        paramAllInOne.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
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
        bcef.b(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin()), paramString2, null);
      }
      return;
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf)
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
      if ((!android.text.TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
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
        str = amtj.a(2131700095);
      }
    }
    label306:
    label439:
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setContentDescription(str);
      if ((AppSetting.jdField_c_of_type_Boolean) && (paramaezf.jdField_b_of_type_JavaLangStringBuilder != null))
      {
        if ((android.text.TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) || (paramChatMessage.isSend())) {
          paramaezf.jdField_b_of_type_JavaLangStringBuilder.append("我");
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
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131697142), new Object[] { uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = amtj.a(2131700096);
          continue;
        }
        str = paramString + amtj.a(2131700088);
        continue;
        if (j != 0)
        {
          if (m != 0)
          {
            str = amtj.a(2131700099);
            continue;
          }
          str = paramString + amtj.a(2131700089);
          continue;
        }
        if (m != 0) {}
        for (str = amtj.a(2131700099);; str = paramString + amtj.a(2131700089))
        {
          if (paramChatMessage.msgtype != -3006) {
            break label439;
          }
          str = String.format(paramBaseChatItemLayout.getResources().getString(2131697142), new Object[] { uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          break;
        }
      }
    }
    paramBaseChatItemLayout = paramString;
    if (paramString == null) {
      paramBaseChatItemLayout = "";
    }
    paramString = paramBaseChatItemLayout;
    if (nmy.a(paramChatMessage)) {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690019) + paramBaseChatItemLayout;
    }
    paramaezf.jdField_b_of_type_JavaLangStringBuilder.insert(0, paramString);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000) || (paramInt == 0) || (paramInt == 1005) || (paramInt == 1001) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 10004) || (paramInt == 1004) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1020) || (paramInt == 1021) || (paramInt == 1023) || (paramInt == 1024) || (paramInt == 1036) || (paramInt == 1025) || (paramInt == 10002) || (paramInt == 1022);
  }
  
  public static boolean a(View paramView)
  {
    Object localObject = AIOUtils.getHolder(paramView);
    if (localObject == null) {}
    while (!(localObject instanceof aezf)) {
      return false;
    }
    paramView = (aezf)AIOUtils.getHolder(paramView);
    if ((paramView.jdField_a_of_type_Apee == null) || (paramView.jdField_a_of_type_Apee.jdField_a_of_type_Int <= 0)) {}
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
    bfdm localbfdm;
    if (!paramBoolean)
    {
      bool1 = bool2;
      if (paramMessageRecord.istroop == 1) {
        localbfdm = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      }
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord.senderuin);
      paramBoolean = localbfdm.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, l);
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
      aynd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), paramMessageRecord.frienduin, paramMessageRecord.senderuin, 0, 2000);
    }
    return true;
  }
  
  private boolean a(ChatMessage paramChatMessage, aezf paramaezf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (bbyp.b())
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources();
      Drawable localDrawable;
      if (bool)
      {
        i = 2130849918;
        localDrawable = ((Resources)localObject).getDrawable(i);
        if (!bool) {
          break label157;
        }
      }
      label157:
      for (int i = 2130849917;; i = 2130849741)
      {
        localObject = ((Resources)localObject).getDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
        paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaezf.jdField_a_of_type_Apee = new apee(0);
        a(paramaezf, paramBaseChatItemLayout, paramChatMessage, paramaezf.jdField_a_of_type_Apee);
        a(paramaezf, paramChatMessage);
        b(paramaezf, paramChatMessage);
        return true;
        i = 2130849742;
        break;
      }
    }
    return false;
  }
  
  private boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramChatMessage.istroop == 1)
    {
      bool = paramBoolean;
      if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramChatMessage.frienduin) != null) {
        bool = HotChatManager.a(paramChatMessage);
      }
    }
    return bool;
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return (paramBoolean) && (((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    String str = null;
    if (paramHotChatInfo != null)
    {
      str = paramHotChatInfo.troopCode;
      if (paramHotChatInfo.isGameRoom)
      {
        localObject = (bhab)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(107);
        if ((((bhab)localObject).jdField_a_of_type_JavaLangString != null) && (((bhab)localObject).jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin))) {
          return true;
        }
      }
    }
    bjmr.a();
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
      ((ProfileActivity.AllInOne)localObject).a = aabc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
  
  private boolean a(boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    return (paramBoolean) && (paramHotChatInfo != null) && (paramHotChatInfo.isGameRoom);
  }
  
  private CharSequence b(ChatMessage paramChatMessage, CharSequence paramCharSequence)
  {
    if (paramChatMessage.msgtype == -3006) {
      paramCharSequence = uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    }
    Object localObject = paramCharSequence;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localObject = paramCharSequence;
      if (bfas.a(paramChatMessage)) {
        localObject = uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
      }
    }
    return localObject;
  }
  
  private String b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004)) {
      return paramChatMessage.frienduin;
    }
    return paramChatMessage.senderuin;
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt)
  {
    if (((!paramChatMessage.isSendFromLocal()) && (a(paramInt))) || (paramInt == 10008) || (paramInt == 10009)) {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin))
      {
        String str1 = paramChatMessage.frienduin;
        String str2 = paramChatMessage.senderuin;
        ThreadManager.executeOnSubThread(new BaseBubbleBuilder.ProcessMemberNickTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, str1, str2, paramInt, this.jdField_a_of_type_AndroidViewView$OnLongClickListener));
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
      return;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
    }
  }
  
  @TargetApi(14)
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramChatMessage.istroop == 3000) {
      if (ContactUtils.isDiscussionMeeting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
      {
        localObject1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = paramChatMessage.senderuin;
        }
        if (((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) != 1) {
          break label271;
        }
        i = 1;
        label97:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
        if (i == 0) {
          break label277;
        }
        localObject1 = ((athq)localObject1).jdField_d_of_type_JavaLangString;
        label127:
        if (localObject2 == null) {
          break label283;
        }
        label132:
        paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
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
        paramBaseChatItemLayout.e.setAccessibilityDelegate(new aeyu(this));
      }
      a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, paramaezf);
      return;
      if (paramChatMessage.isSend()) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();; localObject1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin)) {
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
          localObject1 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
          if (paramChatMessage.senderuin.equals(paramChatMessage.frienduin)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick;
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
          paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList, false, false, false, false, "", null, null);
        }
        for (;;)
        {
          localObject1 = null;
          break;
          paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
        }
      }
      if (bily.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin))
      {
        localObject2 = bint.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
          localObject1 = localObject2;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick;
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious)
      {
        a(paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
        localObject1 = null;
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick;
        paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
      }
    }
  }
  
  private boolean b(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
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
        if ((!bool) && ((localObject == null) || (((amsw)localObject).b(paramMessageRecord.senderuin)))) {
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
        ((ProfileActivity.AllInOne)localObject).a = aabc.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
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
  
  private boolean b(ChatMessage paramChatMessage, aezf paramaezf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (apse.a(paramChatMessage))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849918;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label156;
        }
      }
      label156:
      for (int i = 2130849917;; i = 2130849741)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaezf.jdField_a_of_type_Apee = new apee(0);
        a(paramaezf, paramBaseChatItemLayout, paramChatMessage, paramaezf.jdField_a_of_type_Apee);
        a(paramaezf, paramChatMessage);
        b(paramaezf, paramChatMessage);
        return true;
        i = 2130849742;
        break;
      }
    }
    return false;
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004);
  }
  
  private String c(ChatMessage paramChatMessage)
  {
    String str;
    if (paramChatMessage.isSend()) {
      str = paramChatMessage.selfuin;
    }
    for (;;)
    {
      ExtensionInfo localExtensionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtensionInfo(str, false);
      if ((localExtensionInfo != null) && (localExtensionInfo.faceIdUpdateTime < paramChatMessage.time))
      {
        paramChatMessage = paramChatMessage.getExtInfoFromExtStr("vip_face_id");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id = " + paramChatMessage);
        }
        if ((!android.text.TextUtils.isEmpty(paramChatMessage)) && (Long.parseLong(paramChatMessage) != localExtensionInfo.faceId))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id not equals local");
          }
          bfua.a(str);
          bfua.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      return str;
      if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004)) {
        str = paramChatMessage.frienduin;
      } else {
        str = paramChatMessage.senderuin;
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf)
  {
    Object localObject1;
    boolean bool1;
    if (nmy.a(paramChatMessage))
    {
      localObject1 = nmy.a(paramChatMessage).jdField_b_of_type_JavaLangString;
      bool1 = true;
    }
    for (;;)
    {
      ColorStateList localColorStateList = a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList);
      boolean bool4 = a(paramChatMessage, false);
      localObject1 = b(paramChatMessage, (CharSequence)localObject1);
      Object localObject2 = bfat.a(paramChatMessage);
      if (localObject2 != null)
      {
        localObject1 = ((bfau)localObject2).jdField_c_of_type_JavaLangString;
        localColorStateList = a(paramChatMessage, localColorStateList, (bfau)localObject2);
      }
      for (;;)
      {
        boolean bool2;
        if (c(paramChatMessage))
        {
          localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
          bool2 = ((HotChatManager)localObject2).b(paramChatMessage.frienduin);
          if (a(bool2, a(paramChatMessage, (HotChatManager)localObject2, bool2)))
          {
            localColorStateList = ColorStateList.valueOf(-1);
            if (paramChatMessage.isSend()) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            }
          }
        }
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          int i;
          if (((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin) == 1)
          {
            i = 1;
            localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
            if (i == 0) {
              break label458;
            }
            localObject1 = ((athq)localObject1).jdField_d_of_type_JavaLangString;
            label215:
            localObject2 = a(paramChatMessage, (CharSequence)localObject2);
            if (!android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
              break label476;
            }
            if (paramChatMessage.istroop == 1)
            {
              localObject2 = paramChatMessage.senderuin;
              if ((localObject2 == null) && (!bool1)) {
                break label464;
              }
              bool2 = true;
              label259:
              if (((!bool1) || (!nmy.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                break label470;
              }
            }
          }
          label458:
          label464:
          label470:
          for (boolean bool3 = true;; bool3 = false)
          {
            paramBaseChatItemLayout.a(bool2, (CharSequence)localObject2, localColorStateList, bool3, bool4, false, false, "", null, (String)localObject1);
            TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            aezb localaezb = (aezb)paramBaseChatItemLayout.getTag(2131364459);
            localObject2 = localaezb;
            if (localaezb == null)
            {
              localObject2 = new aezb(this, null);
              paramBaseChatItemLayout.setTag(2131364459, localObject2);
            }
            ((aezb)localObject2).jdField_a_of_type_Boolean = bool1;
            ((aezb)localObject2).jdField_a_of_type_AndroidContentResColorStateList = localColorStateList;
            ((aezb)localObject2).jdField_b_of_type_Boolean = bool4;
            ((aezb)localObject2).jdField_c_of_type_Boolean = false;
            ((aezb)localObject2).jdField_a_of_type_JavaLangCharSequence = "";
            ((aezb)localObject2).jdField_b_of_type_AndroidContentResColorStateList = null;
            ((aezb)localObject2).jdField_d_of_type_Boolean = false;
            ((aezb)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((aezb)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
            ((aezb)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
            ((aezb)localObject2).jdField_a_of_type_Aezf = paramaezf;
            localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (ancx)localObject2);
            j(paramChatMessage, paramBaseChatItemLayout);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label215;
            bool2 = false;
            break label259;
          }
          label476:
          if ((localObject2 != null) || (bool1))
          {
            bool2 = true;
            label489:
            if (((!bool1) || (!nmy.b(paramChatMessage))) && (!apsz.c(paramChatMessage)) && (!paramChatMessage.isSend())) {
              break label593;
            }
          }
          label593:
          for (bool1 = true;; bool1 = false)
          {
            paramBaseChatItemLayout.a(bool2, (CharSequence)localObject2, localColorStateList, bool1, bool4, false, false, "", null, (String)localObject1);
            a(((CharSequence)localObject2).toString(), paramChatMessage, paramBaseChatItemLayout, paramaezf);
            if ((!paramChatMessage.isMultiMsg) || (nmy.a(paramChatMessage))) {
              break;
            }
            bgdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout.e, (Spannable)localObject2);
            break;
            bool2 = false;
            break label489;
          }
        }
      }
      bool1 = false;
      localObject1 = null;
    }
  }
  
  private boolean c(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = bfat.a(paramMessageRecord);
    if (localObject != null)
    {
      a(paramMessageRecord, (bfau)localObject);
      return true;
    }
    if (c(paramMessageRecord))
    {
      e(paramView);
      return true;
    }
    if (nmy.a(paramMessageRecord))
    {
      localObject = nmy.a(paramMessageRecord);
      if ((paramView == null) || ((((nmz)localObject).jdField_a_of_type_JavaLangString == null) && (((nmz)localObject).jdField_a_of_type_Int != 2))) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, "onHeadIconClick : an_id is null");
        }
        return true;
      }
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramMessageRecord.frienduin);
      anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
      if (localTroopInfo != null)
      {
        localanca.j(localTroopInfo.troopuin);
        localanca.a(1, amoo.a(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
      }
      a(paramView, paramMessageRecord, (nmz)localObject, a(localTroopInfo));
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, paramMessageRecord.frienduin, "", "", "");
      return true;
    }
    if ("1000000".equals(paramMessageRecord.senderuin))
    {
      TroopUtils.startTroopAppActivity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "1");
      return true;
    }
    return false;
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.istroop == 1) && (!nmy.a(paramChatMessage));
  }
  
  private boolean c(ChatMessage paramChatMessage, aezf paramaezf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramChatMessage.istroop == 10007))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849918;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label169;
        }
      }
      label169:
      for (int i = 2130849917;; i = 2130849741)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaezf.jdField_a_of_type_Apee = new apee(0);
        a(paramaezf, paramBaseChatItemLayout, paramChatMessage, paramaezf.jdField_a_of_type_Apee);
        a(paramaezf, paramChatMessage);
        b(paramaezf, paramChatMessage);
        return true;
        i = 2130849742;
        break;
      }
    }
    return false;
  }
  
  /* Error */
  private boolean c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 1759	bfat:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lbfau;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +121 -> 127
    //   9: aload_0
    //   10: getfield 118	com/tencent/mobileqq/activity/aio/BaseBubbleBuilder:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   13: invokevirtual 128	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   16: ldc_w 1855
    //   19: invokevirtual 1564	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   22: astore 4
    //   24: invokestatic 1861	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   27: astore_3
    //   28: aload_3
    //   29: aload 4
    //   31: putfield 1864	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   34: aload_3
    //   35: aload 4
    //   37: putfield 1867	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   40: new 1869	java/net/URL
    //   43: dup
    //   44: aload_1
    //   45: getfield 1870	bfau:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokespecial 1872	java/net/URL:<init>	(Ljava/lang/String;)V
    //   51: aload_3
    //   52: invokestatic 1877	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   55: astore_1
    //   56: aload_1
    //   57: bipush 100
    //   59: bipush 100
    //   61: bipush 6
    //   63: invokestatic 1882	bfol:b	(III)[I
    //   66: invokevirtual 1883	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   69: aload_1
    //   70: getstatic 1886	bfol:a	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   73: invokevirtual 1890	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 390	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   81: aload_1
    //   82: ifnull +36 -> 118
    //   85: aload_2
    //   86: aload_1
    //   87: invokevirtual 390	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   90: aload_2
    //   91: getfield 759	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   94: aload_0
    //   95: invokevirtual 1633	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   98: aload_2
    //   99: getfield 759	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   102: aconst_null
    //   103: invokevirtual 1639	com/tencent/mobileqq/vas/avatar/VasAvatar:setOnLongClickListener	(Landroid/view/View$OnLongClickListener;)V
    //   106: iconst_1
    //   107: ireturn
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_1
    //   111: aload_3
    //   112: invokevirtual 1893	java/net/MalformedURLException:printStackTrace	()V
    //   115: goto -34 -> 81
    //   118: aload_2
    //   119: aload 4
    //   121: invokevirtual 390	com/tencent/mobileqq/activity/aio/BaseChatItemLayout:setHeaderIcon	(Ljava/lang/Object;)V
    //   124: goto -34 -> 90
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_3
    //   130: goto -19 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	BaseBubbleBuilder
    //   0	133	1	paramChatMessage	ChatMessage
    //   0	133	2	paramBaseChatItemLayout	BaseChatItemLayout
    //   27	25	3	localURLDrawableOptions	com.tencent.image.URLDrawable.URLDrawableOptions
    //   108	4	3	localMalformedURLException1	java.net.MalformedURLException
    //   129	1	3	localMalformedURLException2	java.net.MalformedURLException
    //   22	98	4	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   40	56	108	java/net/MalformedURLException
    //   56	81	129	java/net/MalformedURLException
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForStructing)) && (bfas.a(paramMessageRecord));
  }
  
  private void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
    Object localObject1 = localObject2;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = awcm.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() != 0) {}
    }
    else
    {
      localObject2 = awct.a(paramChatMessage.senderuin);
    }
    paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, "");
    a((String)localObject2, paramChatMessage, paramBaseChatItemLayout, paramaezf);
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.addFriendSourceId == 3007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.addFriendSourceId == 2007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.addFriendSourceId == 4007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.addFriendSourceId == 3019) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.addFriendSourceId == 2019);
  }
  
  private boolean d(ChatMessage paramChatMessage, aezf paramaezf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (auyo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130849918;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label159;
        }
      }
      label159:
      for (int i = 2130849917;; i = 2130849741)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramaezf.jdField_a_of_type_Apee = new apee(0);
        a(paramaezf, paramBaseChatItemLayout, paramChatMessage, paramaezf.jdField_a_of_type_Apee);
        a(paramaezf, paramChatMessage);
        b(paramaezf, paramChatMessage);
        return true;
        i = 2130849742;
        break;
      }
    }
    return false;
  }
  
  private boolean d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForStructing)) && (bfas.a(paramChatMessage)))
    {
      paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840404));
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
      return true;
    }
    return false;
  }
  
  private boolean d(MessageRecord paramMessageRecord)
  {
    if ((bftf.b(paramMessageRecord.senderuin)) && (bftf.a(this.jdField_a_of_type_AndroidContentContext))) {
      return true;
    }
    if (bezm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.senderuin))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
        bezm.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "openRobotProfileCard, robotuin:" + paramMessageRecord.senderuin + " frienduin:" + paramMessageRecord.frienduin);
        }
        return true;
        bezm.a(this.jdField_a_of_type_AndroidContentContext, null, paramMessageRecord.senderuin);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin))) {
      return true;
    }
    if ("10000".equals(paramMessageRecord.senderuin)) {
      return true;
    }
    if ((paramMessageRecord.istroop == 3000) && (ContactUtils.isDiscussionMeeting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin))) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForTroopConfess);
  }
  
  private void e(View paramView)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    if ((localTroopInfo != null) && (localTroopInfo.associatePubAccount != 0L))
    {
      Intent localIntent = new Intent(paramView.getContext(), AccountDetailActivity.class);
      localIntent.putExtra("uin", localTroopInfo.associatePubAccount + "");
      paramView.getContext().startActivity(localIntent);
    }
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (nmy.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    String str = b(paramChatMessage);
    amsw localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localamsw != null) {
      a(paramChatMessage, paramBaseChatItemLayout, str, localamsw);
    }
    for (;;)
    {
      paramChatMessage.mPendantAnimatable = false;
      return;
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  private boolean e(ChatMessage paramChatMessage, aezf paramaezf, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      if (paramChatMessage.istroop == 1) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject = paramaezf.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838248);
        paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
        paramaezf.jdField_a_of_type_Apee = new apee(0);
        a(paramaezf, paramBaseChatItemLayout, paramChatMessage, paramaezf.jdField_a_of_type_Apee);
        a(paramaezf, paramChatMessage);
        b(paramaezf, paramChatMessage);
        return true;
        if (paramChatMessage.istroop == 3000) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 2, 0, "", "", "", "");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0)
    {
      paramChatMessage.isShowQIMStyleGroup = ahcd.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (paramChatMessage.isShowQIMStyleGroup)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 3, 0, "", "", "", "");
        boolean bool;
        int i;
        Drawable localDrawable1;
        label324:
        Drawable localDrawable2;
        if ((!(this instanceof agqd)) || ((this instanceof agqn)))
        {
          bool = paramChatMessage.isSend();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isNightMode)
          {
            localObject = paramaezf.jdField_a_of_type_AndroidViewView.getResources();
            if (bool)
            {
              i = 2130849918;
              localDrawable1 = ((Resources)localObject).getDrawable(i);
              localObject = paramaezf.jdField_a_of_type_AndroidViewView.getResources();
              if (!bool) {
                break label428;
              }
              i = 2130849917;
              localDrawable2 = ((Resources)localObject).getDrawable(i);
              localObject = new StateListDrawable();
              ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
              ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            }
          }
        }
        for (;;)
        {
          paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          paramaezf.jdField_a_of_type_Apee = new apee(0);
          a(paramaezf, paramBaseChatItemLayout, paramChatMessage, paramaezf.jdField_a_of_type_Apee);
          a(paramaezf, paramChatMessage);
          b(paramaezf, paramChatMessage);
          return true;
          i = 2130849742;
          break;
          label428:
          i = 2130849741;
          break label324;
          localObject = SkinEngine.getInstances();
          if (bool)
          {
            i = 2130849918;
            label451:
            localDrawable1 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = SkinEngine.getInstances();
            if (!bool) {
              break label536;
            }
          }
          label536:
          for (i = 2130849917;; i = 2130849741)
          {
            localDrawable2 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = new StateListDrawable();
            ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
            ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            break;
            i = 2130849742;
            break label451;
          }
          if (!paramChatMessage.isSend()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label583;
            }
            localObject = paramaezf.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838247);
            break;
          }
          label583:
          localObject = paramaezf.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130838248);
        }
      }
    }
    return false;
  }
  
  private boolean e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (nmy.a(paramChatMessage))
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843682);
      nmz localnmz = nmy.a(paramChatMessage);
      paramChatMessage = URLDrawable.getDrawable(nmy.a(localnmz.jdField_b_of_type_Int), (Drawable)localObject, (Drawable)localObject);
      localObject = localnmz.jdField_c_of_type_JavaLangString;
      if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      int i = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 1.0F);
      paramChatMessage.setTag(new int[] { Color.parseColor((String)localObject), i });
      paramChatMessage.setDecodeHandler(bfol.r);
      label94:
      paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(this);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
      return true;
      return false;
    }
    catch (Exception localException)
    {
      break label94;
    }
  }
  
  private boolean e(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if (localObject != null) {}
    for (localObject = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);; localObject = null)
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
    paramMessageRecord = awkh.a((String)localObject);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject)) {}
    for (paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramMessageRecord;; paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747")
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject)) {}
      for (localObject = "2";; localObject = "1")
      {
        bcef.b(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject, "", "", "");
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramMessageRecord);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
    }
  }
  
  private void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    if ((localHotChatInfo == null) || (localHotChatInfo.isGameRoom)) {
      return;
    }
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin)) {
      if (paramChatMessage.senderuin.equals(localHotChatInfo.ownerUin))
      {
        paramChatMessage = amtj.a(2131700090);
        i = 0;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a(paramChatMessage, i);
      return;
      if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
      {
        paramChatMessage = amtj.a(2131700092);
        i = 1;
      }
      else if ((localHotChatInfo.isRobotHotChat) && (((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).b(paramChatMessage.senderuin)))
      {
        paramChatMessage = amtj.a(2131700098);
        i = 0;
      }
      else
      {
        i = 0;
        paramChatMessage = null;
      }
    }
  }
  
  private boolean f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (paramChatMessage.istroop == 10007) {
      if (paramChatMessage.isSend())
      {
        localObject = atyg.a(paramChatMessage);
        localObject = atyf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
        if (localObject != null) {
          break label144;
        }
        paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840312));
        label56:
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
          break label162;
        }
        localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject == null) {
          break label162;
        }
        localObject = ((ChatFragment)localObject).a();
        if (!(localObject instanceof ahfp)) {
          break label162;
        }
        localObject = (ahfp)localObject;
        if (!paramChatMessage.isSend()) {
          break label152;
        }
        localObject = ((ahfp)localObject).a();
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener((View.OnClickListener)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
      return true;
      localObject = atyg.b(paramChatMessage);
      break;
      label144:
      paramBaseChatItemLayout.setHeaderIcon(localObject);
      break label56;
      label152:
      localObject = ((ahfp)localObject).b();
      continue;
      return false;
      label162:
      localObject = null;
    }
  }
  
  private boolean f(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = bfat.a(paramMessageRecord);
    if (localObject != null)
    {
      bfat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (bfau)localObject);
      localObject = ((bfau)localObject).jdField_c_of_type_JavaLangString;
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, paramMessageRecord.frienduin, "", (String)localObject, "");
      if (paramMessageRecord.msgtype != -2051) {}
    }
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = bfwg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, "clk_name", paramMessageRecord, false);
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
    boolean bool2 = false;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
    {
      bool1 = true;
      if (!bool1) {
        break label556;
      }
    }
    label544:
    label548:
    label550:
    label556:
    for (int j = nmy.jdField_e_of_type_Int;; j = -1)
    {
      int k;
      nmz localnmz;
      int i;
      if (nmy.a(paramChatMessage))
      {
        k = beda.a().jdField_a_of_type_Int;
        localnmz = nmy.a(paramChatMessage);
        i = k;
      }
      for (;;)
      {
        try
        {
          if (!android.text.TextUtils.isEmpty(localnmz.jdField_c_of_type_JavaLangString)) {
            i = Color.parseColor(localnmz.jdField_c_of_type_JavaLangString);
          }
          if ((!bewy.a(paramChatMessage.frienduin)) || (nmy.b(paramChatMessage))) {
            break label550;
          }
          bool1 = bool2;
          if (paramBaseChatItemLayout.c != null)
          {
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690013), nmy.b(paramChatMessage), i, j);
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
          if (paramBaseChatItemLayout.c != null) {
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
          }
        }
        else if ((paramChatMessage instanceof MessageForTroopConfess))
        {
          if (paramBaseChatItemLayout.c != null) {
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
          }
        }
        else
        {
          Object localObject = bfat.a(paramChatMessage);
          if (localObject != null)
          {
            j = ((bfau)localObject).jdField_c_of_type_Int;
            i = ((bfau)localObject).jdField_d_of_type_Int;
            if (bool1)
            {
              j = nmy.jdField_e_of_type_Int;
              i = beda.a().jdField_a_of_type_Int;
            }
            if (!bewy.a(paramChatMessage.frienduin)) {
              break label544;
            }
          }
          for (bool1 = false;; bool1 = true)
          {
            if (paramBaseChatItemLayout.c == null) {
              break label548;
            }
            paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1, ((bfau)localObject).jdField_d_of_type_JavaLangString, false, i, j);
            paramBaseChatItemLayout.c.setOnClickListener(this);
            paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131364479));
            return;
            if (paramChatMessage.istroop != 1) {
              break;
            }
            if (paramBaseChatItemLayout.c != null) {
              paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
            }
            this.jdField_f_of_type_Boolean = false;
            if (localTroopManager == null) {
              break;
            }
            TroopInfo localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
            localObject = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
            if ((localTroopInfo == null) || ((localTroopInfo.cGroupRankSysFlag != 1) && (!((bfdm)localObject).b(paramChatMessage.senderuin)) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop()))) {
              break;
            }
            aeza localaeza = (aeza)paramBaseChatItemLayout.getTag(2131364479);
            localObject = localaeza;
            if (localaeza == null)
            {
              localObject = new aeza(this, null);
              paramBaseChatItemLayout.setTag(2131364479, localObject);
            }
            ((aeza)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
            ((aeza)localObject).jdField_a_of_type_Boolean = bool1;
            ((aeza)localObject).jdField_a_of_type_Int = j;
            ((aeza)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
            localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (ancx)localObject);
            return;
          }
          continue;
          bool1 = true;
        }
      }
    }
  }
  
  private boolean g(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (apse.a(paramChatMessage))
    {
      if (((apsa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.getConfessTopicId()).confessorSex == 1) {}
      for (int i = 2130844866;; i = 2130844865)
      {
        paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
        return true;
      }
    }
    return false;
  }
  
  private boolean g(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1))
    {
      paramMessageRecord = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      TroopInfo localTroopInfo = paramMessageRecord.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      if ((localTroopInfo != null) && (localTroopInfo.isQidianPrivateTroop())) {
        return true;
      }
      if (paramMessageRecord.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
        return true;
      }
    }
    return false;
  }
  
  private void h(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((nmy.a(paramChatMessage)) || ("1000000".equals(paramChatMessage.senderuin)) || ((paramChatMessage instanceof MessageForTroopConfess))) {
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
      if (bfat.a(paramChatMessage) != null)
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
          Object localObject = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
          if ((localTroopInfo != null) && (!((bfdm)localObject).b(paramChatMessage.senderuin)))
          {
            boolean bool = bewy.a(paramChatMessage.frienduin);
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
              aezd localaezd = (aezd)paramBaseChatItemLayout.getTag(2131364480);
              localObject = localaezd;
              if (localaezd == null)
              {
                localObject = new aezd(this, null);
                paramBaseChatItemLayout.setTag(2131364480, localObject);
              }
              ((aezd)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
              ((aezd)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
              ((aezd)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
              localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (ancx)localObject);
              return;
              i = 0;
              break;
            }
          }
        }
      }
    }
  }
  
  private boolean h(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.fakeSenderType == 1)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramBaseChatItemLayout.setHeaderIcon(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str));
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(paramChatMessage);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
      return true;
    }
    return false;
  }
  
  private boolean h(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    return (i == 0) || (i == 1) || (i == 3000) || (i == 1000) || (i == 1004);
  }
  
  private void i(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramChatMessage.frienduin);
    if (localObject != null)
    {
      bool = ((HotChatInfo)localObject).isGameRoom;
      if (!bool) {
        break label105;
      }
      localObject = ((bhab)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(107)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((bhar)localObject).a(paramChatMessage.senderuin);
        if (android.text.TextUtils.isEmpty(paramChatMessage)) {
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
      paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131364477));
      return;
    }
  }
  
  private void j(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = bezm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin);
    paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool, paramChatMessage.isSend());
    if (paramBaseChatItemLayout.f != null) {
      paramBaseChatItemLayout.f.setOnClickListener(this);
    }
    if (paramBaseChatItemLayout.e != null)
    {
      if (nmy.a(paramChatMessage)) {
        break label105;
      }
      paramBaseChatItemLayout.e.setOnClickListener(this);
      paramBaseChatItemLayout.e.setTag(Integer.valueOf(2131364458));
    }
    for (;;)
    {
      if ((AppSetting.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT >= 14)) {
        paramBaseChatItemLayout.e.setAccessibilityDelegate(new aeyv(this));
      }
      return;
      label105:
      paramBaseChatItemLayout.e.setOnClickListener(null);
    }
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
            int i = ((BaseChatPie)localObject).getCurrentAIOState();
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
  
  public aeze a(View paramView)
  {
    return null;
  }
  
  protected abstract aezf a();
  
  protected aezz a()
  {
    return new afbd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  protected Drawable a(BaseChatItemLayout paramBaseChatItemLayout, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder == null) {
      return null;
    }
    aezf localaezf = (aezf)paramBaseChatItemLayout.getTag();
    if (localaezf != null)
    {
      localaezf.jdField_a_of_type_JavaLangString = paramString;
      localaezf.jdField_d_of_type_Int = paramInt;
      paramBaseChatItemLayout.setTag(localaezf);
    }
    paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCacheFrom(paramInt, paramString, 6);
    if (paramBaseChatItemLayout == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, paramInt, true);
      }
      return bfvo.b();
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBaseChatItemLayout);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1 + ", msgseq = " + paramChatMessage.msgseq + ", shmsgseq = " + paramChatMessage.shmsgseq);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramView = (BaseChatItemLayout)paramView;
      boolean bool = AppSetting.jdField_c_of_type_Boolean;
      if (paramView == null)
      {
        paramView = new BaseChatItemLayout(localContext);
        paramView.setId(2131363354);
        paramView.setFocusableInTouchMode(true);
        localaezf = a();
        paramView.setTag(localaezf);
        localaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
        paramView.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, BaseChatItemLayout.w);
        localaezf.jdField_b_of_type_Int = paramInt1;
        localaezf.jdField_c_of_type_Int = paramInt2;
        Object localObject2 = null;
        localObject1 = localObject2;
        if (bool)
        {
          paramView.setContentDescription(null);
          localaezf.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
          localObject1 = localObject2;
          if (paramChatMessage.mNeedTimeStamp)
          {
            localObject1 = localObject2;
            if (paramChatMessage.time <= 0L) {}
          }
        }
      }
    }
    catch (Exception paramView)
    {
      label702:
      for (;;)
      {
        try
        {
          aezf localaezf;
          Object localObject1 = bfzl.a(localContext, 3, paramChatMessage.time * 1000L);
          localaezf.jdField_b_of_type_JavaLangStringBuilder.append(" ").append((CharSequence)localObject1).append(" ");
          localaezf.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          if (paramChatMessage.isSend())
          {
            i = 1;
            paramView.setHearIconPosition(i);
            a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, localContext, paramView, localaezf, (CharSequence)localObject1);
            if (!b(paramChatMessage, paramView)) {
              continue;
            }
            paramView.setProgressVisable(false);
            paramView.setNetIconVisible(false);
            localaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(null);
            paramafce = a(paramChatMessage, localaezf, localaezf.jdField_a_of_type_AndroidViewView, paramView, paramafce);
            localaezf.jdField_a_of_type_AndroidViewView = paramafce;
            a(paramafce, paramView);
            a(paramChatMessage, localContext, paramView, localaezf, paramInt1, paramInt2);
            a(paramChatMessage, paramView, localaezf);
            localaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b();
            bfzg.a(null, "AIO_Handle_Sticker_Cost");
            long l = System.currentTimeMillis();
            this.jdField_f_of_type_Aezz.a(paramInt1, paramInt2, paramChatMessage, paramViewGroup, localContext, paramView, localaezf);
            a(localContext, paramafce, paramChatMessage, paramView, localaezf);
            bfzg.a("AIO_Handle_Sticker_Cost", null);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleStickers time cost : " + (System.currentTimeMillis() - l) + " ms");
            }
            if ((!paramChatMessage.mMsgAnimFlag) || (paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null) || (b(paramChatMessage))) {
              continue;
            }
            paramChatMessage.mMsgAnimFlag = false;
            paramInt2 = AIOUtils.dp2px(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramInt1 = paramInt2;
            if (!paramChatMessage.isSend()) {
              paramInt1 = paramInt2 * -1;
            }
            paramView.a(paramChatMessage, paramInt1, 0.0F, 0.0F, 1.0F, this);
            paramView.a(localContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter);
            paramView.requestLayout();
            return paramView;
            paramView = paramView;
            a(paramChatMessage, localContext, paramView);
            paramView = null;
            continue;
            localaezf = (aezf)paramView.getTag();
            if (a(localaezf)) {
              break label702;
            }
            QLog.e("BubbleView", 1, "getView checkHolderTypeOk failed holder :" + localaezf + "  this:" + this);
            localaezf = a();
            paramView.setTag(localaezf);
            localaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
          }
        }
        catch (Exception localException)
        {
          String str = "";
          continue;
          int i = 0;
          continue;
          c(paramChatMessage, paramView);
          continue;
          paramView.a(paramChatMessage);
        }
      }
    }
  }
  
  public View a(View paramView, aezf paramaezf, ViewGroup paramViewGroup, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) || (paramChatMessage == null))
    {
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramaezf = null;
    }
    long l2;
    int i;
    do
    {
      for (;;)
      {
        return paramaezf;
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
          l2 = paramChatMessage.shmsgseq;
          i = bblk.b(paramChatMessage.msgUid);
          if ((!beeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2, i)) || (paramViewGroup == null) || (paramaezf == null) || (paramChatMessage.isMultiMsg))
          {
            paramaezf = paramView;
            if (paramView == null) {
              continue;
            }
            paramView.setVisibility(8);
            return paramView;
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return null;
        }
      }
      paramaezf = paramView;
    } while (paramView != null);
    try
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562908, null);
      paramView.setOnClickListener(new aeyy(this, l2, i));
      paramViewGroup.addView(paramView, new RelativeLayout.LayoutParams(paramInt1, paramInt2));
      return paramView;
    }
    catch (OutOfMemoryError paramView)
    {
      QLog.e("ChatItemBuilder", 2, "getEssenceView got OOM, e:" + paramView.getMessage());
      System.gc();
      return null;
    }
    catch (InflateException paramView)
    {
      QLog.e("ChatItemBuilder", 2, "getEssenceView got InflateException, e:" + paramView.getMessage());
      System.gc();
    }
    return null;
  }
  
  protected abstract View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce);
  
  protected abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    bfwo.a().a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131376279: 
      b(paramChatMessage);
      return;
    case 2131362481: 
      f(paramChatMessage);
      return;
    case 2131376292: 
      c(paramChatMessage);
      return;
    case 2131380171: 
      e(paramChatMessage);
      return;
    case 2131366153: 
      a(paramChatMessage, 1);
      return;
    }
    a(paramChatMessage, 2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    if (!awct.a(paramChatMessage)) {}
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
  
  protected void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee) {}
  
  protected void a(aezf paramaezf, ChatMessage paramChatMessage) {}
  
  protected void a(View paramView) {}
  
  public void a(View paramView, afce paramafce)
  {
    if (bfsu.a(false))
    {
      bfsx localbfsx = new bfsx();
      bfsu.a(this.jdField_a_of_type_AndroidContentContext, localbfsx, paramafce);
      paramView.setOnTouchListener(localbfsx);
      paramView.setOnLongClickListener(localbfsx);
      return;
    }
    paramView.setOnTouchListener(paramafce);
    paramView.setOnLongClickListener(paramafce);
  }
  
  public void a(View paramView, ViewGroup paramViewGroup, Integer paramInteger, ChatMessage paramChatMessage, int paramInt, Boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if ((paramViewGroup == null) || (paramChatMessage == null))
    {
      paramView.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin != null)) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin; !beeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, (String)localObject); localObject = "")
    {
      paramView.setVisibility(8);
      return;
    }
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localObject == null)
    {
      paramView.setVisibility(8);
      return;
    }
    a((RelativeLayout.LayoutParams)localObject);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364441);
    ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
    if (paramInteger != null)
    {
      View localView = paramViewGroup.findViewById(paramInteger.intValue());
      if ((localView == null) || (localView.getVisibility() != 0)) {}
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        a(paramInteger, paramChatMessage, paramBoolean, (RelativeLayout.LayoutParams)localObject, paramViewGroup);
      }
      for (;;)
      {
        paramView.setVisibility(0);
        return;
        a(paramView, (RelativeLayout.LayoutParams)localObject);
      }
    }
  }
  
  protected void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.addRule(5, 2131364441);
    paramLayoutParams.addRule(7, 0);
    paramLayoutParams.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296388) + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramLayoutParams.rightMargin = 0;
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.jdField_h_of_type_Int;
    int i = j;
    if (bcji.a(paramChatMessage)) {
      i = j - AIOUtils.dp2px(10.0F, paramView.getResources());
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
  
  protected void a(View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) || (paramapee == null)) {
      return;
    }
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject3 = null;
    apeb localapeb = null;
    Pair localPair = null;
    BubbleManager localBubbleManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44);
    Object localObject2;
    label63:
    Object localObject1;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramChatMessage.msg))
    {
      localObject2 = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramChatMessage.msg);
      if ((localBubbleManager == null) || (android.text.TextUtils.isEmpty((CharSequence)localObject2))) {
        break label886;
      }
      localObject1 = localBubbleManager.a(paramapee.jdField_a_of_type_Int, false);
      if ((localObject1 == null) || (((apeb)localObject1).b == null) || (!((apeb)localObject1).a((String)localObject2))) {
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
      localObject1 = localapeb;
      int j = k;
      Object localObject4;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject4 = paramapee.a((String)localObject2);
        localObject1 = localapeb;
        localObject3 = localObject4;
        j = k;
        if (localObject4 != null)
        {
          localObject1 = paramapee.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
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
          localPair = paramapee.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
          if ((localPair == null) || (localPair.first == null)) {
            break label868;
          }
        }
        for (k = 1;; k = m)
        {
          m = n;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
          {
            m = n;
            if ((paramChatMessage instanceof MessageForText))
            {
              m = n;
              if (VersionUtils.isHoneycomb())
              {
                localObject2 = paramapee.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
                m = n;
                if (localObject2 != null)
                {
                  m = n;
                  if (((Pair)localObject2).first != null)
                  {
                    m = n;
                    if (paramView.getWidth() > ((apef)((Pair)localObject2).first).a.j) {
                      m = 1;
                    }
                  }
                }
              }
            }
          }
          if ((localBubbleManager != null) && ((paramChatMessage instanceof MessageForText)))
          {
            localapeb = localBubbleManager.a(paramapee.jdField_a_of_type_Int, false);
            if ((localapeb != null) && (localapeb.f != null) && (localapeb.f.k != 0) && (VersionUtils.isHoneycomb())) {
              if (paramChatMessage.isSend())
              {
                localObject2 = paramChatMessage.selfuin;
                localObject4 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (localObject4 == null) {
                  break label862;
                }
                localObject2 = ((amsw)localObject4).a((String)localObject2);
                if ((localObject2 == null) || ((localapeb.f.k != -1) && (((ExtensionInfo)localObject2).pendantId != localapeb.f.k))) {
                  break label862;
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (i != 0)
            {
              long l = apeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              if (l != -1L) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
              }
            }
            if ((j != 0) || (m != 0) || (n != 0) || (k != 0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(0);
            }
            if (j != 0)
            {
              a("keyword_trigger", paramapee.jdField_a_of_type_Int, localObject3);
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
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramapee.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
              if (!paramapee.a(paramView.getHeight())) {
                break;
              }
              paramView = paramapee.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
              if ((paramView == null) || (paramView.first == null)) {
                break;
              }
              a("wordnum_trigger", paramapee.jdField_a_of_type_Int, null);
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
  
  protected void a(View paramView, ChatMessage paramChatMessage, apee paramapee, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {}
    do
    {
      return;
      paramView = paramapee.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    } while ((paramView == null) || (paramView.first == null));
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  protected void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      return;
    }
    paramLayoutParams.addRule(5, 0);
    paramLayoutParams.addRule(7, 0);
    paramLayoutParams.addRule(0, 0);
    paramLayoutParams.addRule(1, 0);
    paramLayoutParams.rightMargin = 0;
    paramLayoutParams.leftMargin = 0;
  }
  
  protected void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (!bezr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramMessageRecord = ((bezr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(262)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord);
      if ((paramMessageRecord != null) && (paramMessageRecord.jdField_b_of_type_Int != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new bezt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), paramMessageRecord.jdField_c_of_type_Int, paramMessageRecord.jdField_d_of_type_Int, 17);
        paramTextView.setTag(2131366809, "school_troop_span");
      }
    } while (!QLog.isColorLevel());
    QLog.i("school_troop.BaseBubbleBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
  }
  
  protected void a(bgaz parambgaz, int paramInt, MessageRecord paramMessageRecord)
  {
    if (!a(paramMessageRecord)) {}
    boolean bool;
    do
    {
      return;
      bool = TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((!paramMessageRecord.isSend()) && (!bool))
      {
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if ((nmy.a(paramMessageRecord)) && (!aqdi.a().jdField_a_of_type_Boolean))
      {
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if (abwz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType) == 1032)
      {
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      Object localObject = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) && (!((amsw)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
      {
        this.jdField_d_of_type_Boolean = false;
        return;
      }
      if (paramInt == 1)
      {
        localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localObject != null) && (((HotChatManager)localObject).b(paramMessageRecord.frienduin)))
        {
          this.jdField_d_of_type_Boolean = false;
          return;
        }
      }
      if ((paramMessageRecord.msgtype == -5008) && ((paramMessageRecord instanceof MessageForArkApp)))
      {
        localObject = (MessageForArkApp)paramMessageRecord;
        if ((((MessageForArkApp)localObject).ark_app_message != null) && (((MessageForArkApp)localObject).ark_app_message.appName.equals("com.tencent.mannounce")))
        {
          this.jdField_d_of_type_Boolean = false;
          return;
        }
      }
    } while (!h(paramMessageRecord));
    a(parambgaz, paramMessageRecord, bool);
  }
  
  protected void a(bgaz parambgaz, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (parambgaz != null) && (paramContext != null) && (ahrr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType))) {
      a(parambgaz, paramContext, paramChatMessage, false);
    }
  }
  
  protected void a(bgaz parambgaz, Context paramContext, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    int j;
    int i;
    if ((paramChatMessage != null) && (parambgaz != null) && (paramContext != null) && (ahrr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType)))
    {
      j = parambgaz.a();
      if (!paramBoolean) {
        break label97;
      }
      paramChatMessage = parambgaz.a();
      i = 0;
      if (i >= paramChatMessage.length) {
        break label97;
      }
      if (paramChatMessage[i].a() != 2131366347) {
        break label88;
      }
      i += 1;
    }
    for (;;)
    {
      parambgaz.a(2131380171, paramContext.getString(2131690815), 0, i);
      return;
      label88:
      i += 1;
      break;
      label97:
      i = j;
    }
  }
  
  public void a(bgaz parambgaz, MessageRecord paramMessageRecord)
  {
    if ((!this.jdField_d_of_type_Boolean) || ((paramMessageRecord != null) && (!paramMessageRecord.isSend()))) {
      acvv.a(parambgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void a(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
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
        ((afpd)localBaseChatPie.getHelper(46)).a(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label182;
      }
      j = 6;
      i = 4;
    }
    for (;;)
    {
      if (nmy.a(paramChatMessage)) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800ADF4", "0X800ADF4", 0, 1, "" + i, "", "", "");
      }
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + j, "", "", "");
      return;
      label182:
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
  
  protected void a(ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "chatMessage is null");
      }
      return;
    }
    TroopEssenceMsgItem localTroopEssenceMsgItem = new TroopEssenceMsgItem();
    try
    {
      localTroopEssenceMsgItem.troopUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      localTroopEssenceMsgItem.msgSeq = paramChatMessage.shmsgseq;
      localTroopEssenceMsgItem.msgRandom = bblk.b(paramChatMessage.msgUid);
      localTroopEssenceMsgItem.opUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localTroopEssenceMsgItem.msgSenderUin = paramChatMessage.senderuin;
      localTroopEssenceMsgItem.opType = paramInt;
      ((bedz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(381)).a(localTroopEssenceMsgItem);
      beeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, localTroopEssenceMsgItem, this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious) || ((paramContext instanceof MultiForwardActivity))) {}
    for (boolean bool = false;; bool = true) {
      try
      {
        i = a(paramChatMessage);
        paramaezf.jdField_a_of_type_Int = i;
        if (i != 0) {
          if (a(paramChatMessage, paramaezf, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setSimpleUIMsgBubble " + paramChatMessage.getLogColorContent());
            }
            if (paramaezf.jdField_a_of_type_AndroidViewView != null)
            {
              paramBaseChatItemLayout.setBubbleView(paramaezf.jdField_a_of_type_AndroidViewView);
              a(paramaezf.jdField_a_of_type_AndroidViewView, paramChatMessage);
              paramaezf.jdField_a_of_type_AndroidViewView.setTag(2131364021, paramaezf.jdField_a_of_type_Apee);
              paramaezf.jdField_a_of_type_AndroidViewView.setTag(2131364486, paramChatMessage);
              if (arib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                arib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this, paramBaseChatItemLayout, paramaezf.jdField_a_of_type_AndroidViewView);
              }
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
          if (b(paramChatMessage, paramaezf, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setConfessMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (e(paramChatMessage, paramaezf, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setQimMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (d(paramChatMessage, paramaezf, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setLimitChatMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (c(paramChatMessage, paramaezf, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setGameMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else
          {
            a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaezf, paramInt1, paramInt2, bool, i);
            continue;
            if (paramaezf.jdField_a_of_type_AndroidViewView == null)
            {
              QLog.e("ChatItemBuilder", 1, "handleBubbleBg mContent is null type = " + paramChatMessage.istroop);
              return;
            }
            paramaezf.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, bgaz parambgaz)
  {
    if ((paramChatMessage == null) || (paramChatMessage.shmsgseq == 0L)) {}
    do
    {
      do
      {
        return;
      } while ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0));
      if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (paramChatMessage.isSupportReply()))
      {
        parambgaz.a(2131376279, this.jdField_a_of_type_AndroidContentContext.getString(2131697158), 2130838977);
        MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
    parambgaz.a(2131376279, this.jdField_a_of_type_AndroidContentContext.getString(2131697158), 2130838977);
    MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((apse.a(paramChatMessage)) && (QLog.isColorLevel())) {
      QLog.d("ChatItemBuilder", 2, "confessType =  " + paramChatMessage.istroop + " isSend = " + paramChatMessage.isSend());
    }
    if (h(paramChatMessage, paramBaseChatItemLayout)) {}
    do
    {
      do
      {
        return;
      } while ((g(paramChatMessage, paramBaseChatItemLayout)) || (f(paramChatMessage, paramBaseChatItemLayout)) || (e(paramChatMessage, paramBaseChatItemLayout)) || (d(paramChatMessage, paramBaseChatItemLayout)) || (c(paramChatMessage, paramBaseChatItemLayout)));
      int i = a(paramChatMessage, paramBaseChatItemLayout);
      b(paramChatMessage, paramBaseChatItemLayout, i);
      a(paramChatMessage, paramBaseChatItemLayout, i);
      if (QLog.isColorLevel()) {
        QLog.d("BaseBubbleBuilder", 2, "AppSetting.enableTalkBack = " + AppSetting.jdField_c_of_type_Boolean);
      }
    } while (!AppSetting.jdField_c_of_type_Boolean);
    String str2 = "";
    String str1 = str2;
    if (paramChatMessage.istroop != 1)
    {
      str1 = str2;
      if (paramChatMessage.istroop != 3000) {
        if (!paramChatMessage.isSend()) {
          break label271;
        }
      }
    }
    label271:
    for (str1 = amtj.a(2131700094);; str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick + amtj.a(2131700097))
    {
      if (paramChatMessage.msgtype == -3006) {
        str1 = String.format(paramBaseChatItemLayout.getResources().getString(2131697142), new Object[] { uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
      }
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setContentDescription(str1);
      return;
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if (bbyp.b()) {}
    label6:
    do
    {
      TroopInfo localTroopInfo;
      do
      {
        do
        {
          break label6;
          do
          {
            return;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 10007);
          if ((paramChatMessage == null) || (paramChatMessage.isShowQimStyleAvater) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserOnline) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isQimUserBubbleForm)) || (apse.a(paramChatMessage)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1037) || (abwz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType) == 1044) || (paramChatMessage.fakeSenderType != 0))
          {
            paramBaseChatItemLayout.setPendantImageVisible(false);
            return;
          }
        } while (AIOUtils.isForbidHeadPendantFunForAIOOpen);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
          break;
        }
        localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      } while ((localTroopInfo != null) && (localTroopInfo.hasOrgs()));
    } while (arib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo));
    e(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, afbb paramafbb)
  {
    bahm localbahm = (bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    if ((paramMessageRecord.extraflag != 32772) || (!localbahm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageRecord.uniseq, paramView, paramafbb)))
    {
      paramMessageRecord = afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramafbb);
      }
    }
  }
  
  protected void a(Integer paramInteger, MessageRecord paramMessageRecord, Boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, ViewGroup paramViewGroup)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      paramLayoutParams.addRule(1, paramInteger.intValue());
      paramLayoutParams.leftMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      return;
    }
    if (paramMessageRecord.isSend())
    {
      paramLayoutParams.addRule(0, paramInteger.intValue());
      paramLayoutParams.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
      return;
    }
    paramLayoutParams.addRule(1, paramInteger.intValue());
    paramLayoutParams.leftMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.jdField_a_of_type_Boolean;
  }
  
  public boolean a(aezf paramaezf)
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
    boolean bool = TroopUtils.isTroopOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (((l - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (TroopUtils.isSupportRevokeMsgByTroopOwnerOrMgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false) {
      return this.jdField_d_of_type_Boolean;
    }
  }
  
  protected aezz b()
  {
    return new aeyp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  protected void b(aezf paramaezf, ChatMessage paramChatMessage) {}
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
    if (localChatMessage == null) {
      break label11;
    }
    label11:
    while (a(paramView, localChatMessage)) {
      return;
    }
    amsw localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    boolean bool2 = localChatMessage.isSelf();
    boolean bool1;
    String str;
    if (b(localChatMessage))
    {
      bool1 = localamsw.b(localChatMessage.senderuin);
      str = localChatMessage.senderuin;
      label69:
      if (str == null) {
        break label207;
      }
      if (!localamsw.b(str)) {
        break label546;
      }
      bool1 = true;
    }
    label546:
    for (;;)
    {
      Object localObject;
      if (localChatMessage.istroop == 10009)
      {
        if (bool2)
        {
          localObject = "0";
          label106:
          atyf.a("0", "1", "176", "969", "96902", "206995", (String)localObject, "0", "20", "0");
        }
      }
      else
      {
        if (!bool2) {
          break label217;
        }
        localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
      }
      for (;;)
      {
        a(localChatMessage, str, (ProfileActivity.AllInOne)localObject);
        a(paramView, localChatMessage, localamsw, bool1, bool2, str, (ProfileActivity.AllInOne)localObject);
        return;
        str = localChatMessage.frienduin;
        bool1 = false;
        break label69;
        label207:
        break label11;
        localObject = "1";
        break label106;
        label217:
        if (localChatMessage.istroop == 1008)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("need_finish", true);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
          ((Intent)localObject).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
          ((Intent)localObject).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
          ugf.a((Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, -1, 2000, 2, ugf.jdField_a_of_type_Boolean);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          npt.a(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true, -1, true, 2000);
          return;
        }
        if (bool1)
        {
          localObject = aexh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, str);
        }
        else
        {
          if (localChatMessage.istroop == 1025)
          {
            if (this.jdField_a_of_type_AndroidContentContext == null) {
              break;
            }
            paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
            paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
            paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
            paramView.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
            return;
          }
          if ((localChatMessage.istroop == 1037) || (abwz.a(localChatMessage.istroop) == 1044))
          {
            localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 96);
            ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick;
          }
          else
          {
            localObject = aexh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localChatMessage);
          }
        }
      }
    }
  }
  
  protected void b(bgaz parambgaz, Context paramContext)
  {
    parambgaz.a(2131371562, amtj.a(2131700093), 2130838981);
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
          ((ChatFragment)localObject).a().replyMessageAtInput(paramChatMessage);
        }
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)paramChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          xwa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (MessageForStructing)localObject, "reply");
        }
      }
      agmk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, "0X800A368");
    }
  }
  
  protected void b(ChatMessage paramChatMessage, bgaz parambgaz)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) || (paramChatMessage == null)) {}
    do
    {
      do
      {
        return;
        if ((!bezm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)) && (!nmy.a(paramChatMessage)) && (!apse.a(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
          break;
        }
      } while (!QLog.isColorLevel());
      parambgaz = new StringBuilder("addReplyOnlyMenu isRobot=").append(bezm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(nmy.a(paramChatMessage)).append(" isConfessMsg=").append(apse.a(paramChatMessage)).append(" isNotSupport=");
      if (!paramChatMessage.isSupportReply()) {}
      for (;;)
      {
        QLog.d("ChatItemBuilder", 2, bool);
        return;
        bool = false;
      }
      if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())))
      {
        parambgaz.a(2131376292, this.jdField_a_of_type_AndroidContentContext.getString(2131697164), 2130838977);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    parambgaz.a(2131376292, this.jdField_a_of_type_AndroidContentContext.getString(2131697164), 2130838977);
  }
  
  public void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!bepv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
    }
    TroopManager localTroopManager;
    do
    {
      do
      {
        return;
        if (!bepv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
        {
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
          return;
        }
      } while (paramChatMessage.istroop != 1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqTroopHonorWidgetTroopHonorView.setHonorList(null);
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    } while (!((bepr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(paramChatMessage.frienduin));
    aezc localaezc2 = (aezc)paramBaseChatItemLayout.getTag(2131364478);
    aezc localaezc1 = localaezc2;
    if (localaezc2 == null)
    {
      localaezc1 = new aezc(this, null);
      paramBaseChatItemLayout.setTag(2131364478, localaezc1);
    }
    localaezc1.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    localaezc1.jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, localaezc1);
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1008))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin))) {
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
  
  protected aezz c()
  {
    return new afcd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(0);
    }
  }
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
    if (g(localChatMessage)) {}
    while ((f(localChatMessage)) || (localChatMessage == null) || (localChatMessage.istroop != 1) || (!bftf.d(localChatMessage.senderuin)) || (e(localChatMessage)) || (((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin)))) {
      return;
    }
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    int i;
    Object localObject1;
    label153:
    Object localObject3;
    if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
    {
      i = paramView.getId();
      if (i == 2131364479)
      {
        localObject1 = "clk_title";
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
        localObject3 = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
        if (i != 2131364479) {
          break label446;
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
        ((Intent)localObject3).putExtra("selfSet_leftViewText", amtj.a(2131700091));
        paramView.startActivity((Intent)localObject3);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = localChatMessage.frienduin;
        if (localChatMessage.isSend())
        {
          paramView = "1";
          bcef.b((QQAppInterface)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, str, paramView, "", "");
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
          }
          if (this.jdField_c_of_type_Int < 2) {
            break;
          }
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, String.valueOf(this.jdField_c_of_type_Int), "", "");
          return;
          localObject1 = "clk_nickname";
          break label153;
          label446:
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
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
      }
    }
  }
  
  protected void c(bgaz parambgaz, Context paramContext)
  {
    if ((b()) && (awcm.a().a())) {
      parambgaz.a(2131371498, paramContext.getString(2131693996), 2130838981);
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
    ((azye)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(340)).a(paramChatMessage);
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 1 });
    localIntent.putExtra("uin", paramChatMessage.senderuin);
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_reply_only_uniseq", paramChatMessage.uniseq);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramChatMessage.senderuin);
    localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    int i;
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      localIntent.putExtra("uintype", 0);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      i = 1;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramChatMessage.senderuin)) {
        break label318;
      }
      i = 3;
    }
    label318:
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4F5", "0X800A4F5", i, 0, "", "", "", "");
      return;
      localIntent.putExtra("uintype", 1000);
      localIntent.putExtra("uinname", ContactUtils.getTroopMemberNameRemarkFirst(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramChatMessage.senderuin));
      localIntent = new Intent(localIntent);
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject != null) {
        ((TroopManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, new aeyx(this, localIntent));
      }
      i = 2;
      break;
    }
  }
  
  protected void c(ChatMessage paramChatMessage, bgaz parambgaz)
  {
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      int i;
      do
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      } while (i != 1);
      parambgaz.a(2131366153, this.jdField_a_of_type_AndroidContentContext.getString(2131719142), 0);
    }
    i = beeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new bedw(l1, paramChatMessage.shmsgseq, bblk.b(paramChatMessage.msgUid)), paramChatMessage);
    if (i == 2)
    {
      parambgaz.a(2131366154, this.jdField_a_of_type_AndroidContentContext.getString(2131719143), 0);
      return;
    }
  }
  
  protected void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(paramChatMessage);
    paramBaseChatItemLayout.setProgressVisable(bool);
    if (!bool) {
      d(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  protected boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 1) && (((bfbz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true).jdField_a_of_type_Boolean))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131696866, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return true;
    }
    return false;
  }
  
  protected aezz d()
  {
    return new afdi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  public void d() {}
  
  protected void d(View paramView)
  {
    int i = 1;
    Object localObject2 = AIOUtils.getMessage(paramView);
    if (g((MessageRecord)localObject2)) {}
    while ((bfat.a((MessageRecord)localObject2) != null) || (localObject2 == null) || (((MessageRecord)localObject2).istroop != 1) || (!bftf.d(((MessageRecord)localObject2).senderuin))) {
      return;
    }
    Object localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
    if (localObject1 != null)
    {
      localObject1 = ((HotChatManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      label80:
      if ((localObject1 != null) || (((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_AndroidContentContext, ((MessageRecord)localObject2).frienduin, Long.parseLong(((MessageRecord)localObject2).senderuin)))) {
        break label280;
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
        break label306;
      }
    }
    label280:
    label306:
    for (paramView = (TroopMemberNewLevelView)paramView;; paramView = null)
    {
      if (paramView != null) {
        if ((paramView.a()) && (paramView.b())) {
          i = 3;
        }
      }
      for (;;)
      {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B200", "0X800B200", i, 0, "", "", "", "");
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
  
  protected void d(bgaz parambgaz, Context paramContext)
  {
    parambgaz.a(2131366347, paramContext.getString(2131692036), 2130838970);
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
      ((BaseChatPie)localObject).setLeftTitleToCancle(paramChatMessage);
      ((BaseChatPie)localObject).hideTroopFCView(true);
      amat.a(((BaseChatPie)localObject).app, "select_more_msg", true);
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
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, "" + i, "", "", "");
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + j, "", "", "");
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
  
  protected aezz e()
  {
    return new afdd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this);
  }
  
  protected void e(bgaz parambgaz, Context paramContext)
  {
    parambgaz.a(2131362481, paramContext.getString(2131689950), 2130838981);
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
    ((ahrg)localFragmentActivity.getChatFragment().a().getHelper(59)).a(paramChatMessage);
  }
  
  protected aezz f()
  {
    return new afdg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidContentContext, this);
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
    ((AIOLongShotHelper)((BaseChatPie)localObject).getHelper(15)).a(paramChatMessage);
    ((BaseChatPie)localObject).hideTroopFCView(true);
    amat.a(((BaseChatPie)localObject).app, "select_more_msg", true);
    localObject = "0";
    if (paramChatMessage.istroop == 1) {
      localObject = "2";
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 1, 0, (String)localObject, "", "", "");
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.isUpComingPrevious) || (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
      {
        AIOUtils.isUserOperatedInAIO = true;
        this.jdField_a_of_type_Aezz.b(paramView);
        this.jdField_d_of_type_Aezz.b(paramView);
        this.e.b(paramView);
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131364432: 
        case 2131364477: 
        case 2131364450: 
        case 2131364448: 
        case 2131364458: 
          do
          {
            c(paramView);
            break;
            b(paramView);
            break;
            a(paramView);
            break;
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1);
          b(paramView);
          break;
        case 2131364463: 
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), null);
          break;
        case 2131364478: 
        case 2131364479: 
          Object localObject = (aezy)AIOUtils.getHolder(paramView);
          String str = ((aezy)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
          localObject = ((aezy)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
          if (((bepr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(346)).b(str))
          {
            str = bfcx.a().a(str, (String)localObject);
            localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", str);
            paramView.getContext().startActivity((Intent)localObject);
            if (paramView.getId() == 2131364478) {
              bcef.b(null, "dc00898", "", "", "0X800A705", "0X800A705", 0, 0, "", "", "", "");
            }
          }
          else if (paramView.getId() == 2131364479)
          {
            c(paramView);
          }
          break;
        case 2131364480: 
          d(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */