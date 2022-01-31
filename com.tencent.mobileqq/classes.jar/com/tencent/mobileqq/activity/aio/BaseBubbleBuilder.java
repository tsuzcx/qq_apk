package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.Trans_entity;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.util.LocaleUtil;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleInfo.CommonAttrs;
import com.tencent.mobileqq.bubble.BubbleInterActiveAnim;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.confess.ConfessCache;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.KeywordResult;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.MessageProgressController;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.Pair;
import com.tencent.util.ProfilePerformanceReport;
import com.tencent.util.VersionUtils;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ugx;
import ugy;
import ugz;
import uha;
import uhb;
import uhc;
import uhd;
import uhe;
import uhg;
import uhh;
import uhi;

public abstract class BaseBubbleBuilder
  implements View.OnClickListener, ChatItemAnimLayout.OnItemAnimEndListener, ChatItemBuilder
{
  public static int a;
  public static ColorFilter a;
  public static final Handler a;
  protected static final ConcurrentHashMap a;
  public static boolean a;
  public float a;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new uhc(this);
  @Deprecated
  public BaseAdapter a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  public QQAppInterface a;
  public FaceDecoder a;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = 0L;
  private boolean c;
  
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int i;
    List localList;
    RelativeLayout.LayoutParams localLayoutParams5;
    RelativeLayout.LayoutParams localLayoutParams6;
    if ((paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      i = 1;
      if ((paramView == null) || (paramView.getId() != 2131361877) || (i != 0) || (!EmojiStickerManager.d(paramChatMessage))) {
        break label1444;
      }
      localList = EmojiStickerManager.a().a(paramChatMessage);
      localLayoutParams5 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams6 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView == null) || (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 0)) {
        break label1555;
      }
    }
    label645:
    label1036:
    label1555:
    for (RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();; localLayoutParams1 = null)
    {
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {}
      for (RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();; localLayoutParams2 = null)
      {
        if ((paramBaseChatItemLayout.c != null) && (paramBaseChatItemLayout.c.getVisibility() == 0)) {}
        for (RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.c.getLayoutParams();; localLayoutParams3 = null)
        {
          if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {}
          for (RelativeLayout.LayoutParams localLayoutParams4 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();; localLayoutParams4 = null)
          {
            int j = paramContext.getResources().getDisplayMetrics().widthPixels;
            float f2 = paramContext.getResources().getDisplayMetrics().density;
            int i1;
            int n;
            boolean bool1;
            if (localLayoutParams4 != null)
            {
              i1 = localLayoutParams4.topMargin;
              n = localLayoutParams4.bottomMargin;
              bool1 = true;
            }
            for (;;)
            {
              int i3;
              int i2;
              if (localLayoutParams5 != null)
              {
                i3 = localLayoutParams5.topMargin;
                i2 = localLayoutParams5.bottomMargin;
              }
              for (;;)
              {
                int i5;
                int i4;
                boolean bool2;
                if (localLayoutParams2 != null)
                {
                  i5 = localLayoutParams2.topMargin;
                  i4 = localLayoutParams2.bottomMargin;
                  bool2 = true;
                }
                for (;;)
                {
                  int i7;
                  int i6;
                  if (localLayoutParams6 != null)
                  {
                    i7 = localLayoutParams6.topMargin;
                    i6 = localLayoutParams6.bottomMargin;
                  }
                  for (;;)
                  {
                    int i9;
                    int i8;
                    boolean bool3;
                    if (localLayoutParams1 != null)
                    {
                      i9 = localLayoutParams1.topMargin;
                      i8 = localLayoutParams1.bottomMargin;
                      bool3 = true;
                    }
                    for (;;)
                    {
                      int i11;
                      int i10;
                      boolean bool4;
                      if (localLayoutParams3 != null)
                      {
                        i11 = localLayoutParams3.topMargin;
                        i10 = localLayoutParams3.bottomMargin;
                        bool4 = true;
                      }
                      for (;;)
                      {
                        EmoticonManager localEmoticonManager;
                        int k;
                        int i12;
                        if ((localList != null) && (localList.size() > 0) && (EmojiStickerManager.b(paramChatMessage)))
                        {
                          localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
                          localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localList);
                          k = 0;
                          i = 0;
                          i12 = localList.size() - 1;
                          label437:
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
                          break label437;
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
                                paramView = localEmoticonManager.a(((MessageForMarketFace)paramChatMessage).mMarkFaceMessage);
                              }
                              for (;;)
                              {
                                label557:
                                int i14;
                                label579:
                                label601:
                                int i15;
                                label623:
                                int i16;
                                int i17;
                                int m;
                                int i18;
                                if (localStickerInfo.x <= 1.0F)
                                {
                                  i14 = (int)(localStickerInfo.x * j);
                                  if (localStickerInfo.y > 1.0F) {
                                    break label1036;
                                  }
                                  k = (int)(localStickerInfo.y * j);
                                  if (localStickerInfo.width > 1.0F) {
                                    break label1043;
                                  }
                                  i15 = (int)(localStickerInfo.width * j);
                                  if (localStickerInfo.height > 1.0F) {
                                    break label1050;
                                  }
                                  i16 = (int)(localStickerInfo.height * j);
                                  i17 = localStickerInfo.rotate;
                                  m = k + localLayoutParams5.topMargin;
                                  k = m;
                                  if (localLayoutParams4 != null) {
                                    k = m + (AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams4.topMargin + localLayoutParams4.bottomMargin));
                                  }
                                  m = k;
                                  if (localLayoutParams2 != null) {
                                    m = k + (AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (localLayoutParams2.topMargin + localLayoutParams2.bottomMargin));
                                  }
                                  k = m;
                                  if (m < 0)
                                  {
                                    i18 = -m;
                                    localLayoutParams6.topMargin += i18;
                                    if (localLayoutParams2 == null) {
                                      break label1057;
                                    }
                                    localLayoutParams2.topMargin += i18;
                                    label791:
                                    if (localLayoutParams3 != null) {
                                      localLayoutParams3.topMargin += i18;
                                    }
                                    if (localLayoutParams1 != null) {
                                      localLayoutParams1.topMargin += i18;
                                    }
                                    m = 0;
                                    k = m;
                                    if (i12 != localList.size() - 1)
                                    {
                                      paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(i18);
                                      k = m;
                                    }
                                  }
                                  if (!(paramView instanceof PicEmoticonInfo)) {
                                    break label1090;
                                  }
                                  paramChatMessage = (PicEmoticonInfo)paramView;
                                  if (paramChatMessage.a == null) {
                                    break label1454;
                                  }
                                  if ((EmojiStickerManager.jdField_f_of_type_Boolean) || (FileUtils.a() <= 1.048576E+008F)) {
                                    break label1073;
                                  }
                                  m = 1;
                                  if (m == 0) {
                                    break label1079;
                                  }
                                  paramView = paramChatMessage.a("fromAIO", true, false, null, i15, i15);
                                  label920:
                                  paramChatMessage = paramChatMessage.a.epId;
                                }
                                for (;;)
                                {
                                  label928:
                                  BaseChatItemLayout localBaseChatItemLayout;
                                  double d;
                                  boolean bool5;
                                  if (paramView != null)
                                  {
                                    localBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
                                    d = i17;
                                    bool5 = localStickerInfo.isShown;
                                    if (!localStickerInfo.isShown) {
                                      break label1178;
                                    }
                                  }
                                  label1043:
                                  label1050:
                                  label1178:
                                  for (float f1 = 1.0F;; f1 = 1.1F)
                                  {
                                    localBaseChatItemLayout.a(paramView, i14, k, i15, i16, d, paramChatMessage, bool5, f1, localStickerInfo);
                                    k = i13;
                                    break;
                                    if (!(paramChatMessage instanceof MessageForText)) {
                                      break label1463;
                                    }
                                    paramView = (MessageForText)paramChatMessage;
                                    if (android.text.TextUtils.isEmpty(paramView.msg)) {
                                      break label1463;
                                    }
                                    paramView = EmojiStickerManager.a().a(paramView.msg);
                                    break label557;
                                    i14 = j;
                                    break label579;
                                    k = j;
                                    break label601;
                                    i15 = j;
                                    break label623;
                                    i16 = j;
                                    break label645;
                                    label1057:
                                    localLayoutParams5.topMargin += i18;
                                    break label791;
                                    label1073:
                                    m = 0;
                                    break label900;
                                    label1079:
                                    paramView = paramChatMessage.a(paramContext, f2);
                                    break label920;
                                    label1090:
                                    if ((paramView instanceof SystemAndEmojiEmoticonInfo))
                                    {
                                      paramView = ((SystemAndEmojiEmoticonInfo)paramView).b(paramContext, f2);
                                      paramChatMessage = "";
                                      break label928;
                                    }
                                    if ((paramView instanceof SmallEmoticonInfo))
                                    {
                                      paramView = ((SmallEmoticonInfo)paramView).b(paramContext, f2);
                                      paramChatMessage = "";
                                      break label928;
                                    }
                                    if (!(paramChatMessage instanceof MessageForPic)) {
                                      break label1445;
                                    }
                                    paramView = PicItemBuilder.a(paramContext, (MessageForPic)paramChatMessage);
                                    ThreadManager.post(new ugx(this, paramChatMessage), 5, null, true);
                                    paramChatMessage = "";
                                    break label928;
                                  }
                                  if (i != localList.size())
                                  {
                                    paramView = new Bundle();
                                    paramView.putBoolean("haveTimeStamp", bool1);
                                    paramView.putBoolean("haveNickName", bool2);
                                    paramView.putBoolean("havePendant", bool3);
                                    paramView.putBoolean("haveTroopMemberLevel", bool4);
                                    if (localLayoutParams4 != null)
                                    {
                                      paramView.putInt("timeStampTop", i1);
                                      paramView.putInt("timeStampBottom", n);
                                    }
                                    if (localLayoutParams5 != null)
                                    {
                                      paramView.putInt("textViewTop", i3);
                                      paramView.putInt("textViewBottom", i2);
                                    }
                                    if (localLayoutParams2 != null)
                                    {
                                      paramView.putInt("nickNameViewTop", i5);
                                      paramView.putInt("nickNameViewBottom", i4);
                                    }
                                    if (localLayoutParams6 != null)
                                    {
                                      paramView.putInt("headViewTop", i7);
                                      paramView.putInt("headViewBottom", i6);
                                    }
                                    if (localLayoutParams1 != null)
                                    {
                                      paramView.putInt("pendantViewTop", i9);
                                      paramView.putInt("pendantViewBottom", i8);
                                    }
                                    if (localLayoutParams3 != null)
                                    {
                                      paramView.putInt("troopMemberLevelTop", i11);
                                      paramView.putInt("troopMemberLevelBottom", i10);
                                    }
                                    paramBaseChatItemLayout.setTag(2131362322, paramView);
                                  }
                                  paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerDoubleClickListener = new ugy(this);
                                  if (paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView != null)
                                  {
                                    paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
                                    paramView.addRule(6, 2131361863);
                                    paramView.topMargin = (-AIOUtils.a(1.0F, paramContext.getResources()));
                                  }
                                  label1444:
                                  return;
                                  label1445:
                                  paramChatMessage = "";
                                  paramView = null;
                                  continue;
                                  label1454:
                                  paramChatMessage = "";
                                  paramView = null;
                                }
                                label1463:
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
  
  private void a(View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramView != null) && (paramView.getId() == 2131361877))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131362322);
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
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
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
        paramBaseChatItemLayout.setTag(2131362322, null);
      }
    }
  }
  
  @TargetApi(14)
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool = true;
    Object localObject1;
    if (paramChatMessage.istroop == 3000) {
      if (paramChatMessage.isMultiMsg) {
        localObject1 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else
      {
        localObject2 = paramChatMessage.senderuin;
      }
      int i;
      if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramChatMessage.senderuin) == 1)
      {
        i = 1;
        label89:
        localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a;
        if (i == 0) {
          break label314;
        }
        localObject1 = ((FlashChatManager.GlobalConfig)localObject1).jdField_d_of_type_JavaLangString;
        label119:
        if (localObject2 == null) {
          break label320;
        }
        label124:
        paramBaseChatItemLayout.a(bool, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
        localObject1 = localObject2;
        if (paramBaseChatItemLayout.jdField_g_of_type_AndroidWidgetTextView != null)
        {
          paramBaseChatItemLayout.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if ((paramBaseChatItemLayout.f != null) && (AppSetting.jdField_b_of_type_Boolean) && (Build.VERSION.SDK_INT >= 14)) {
          paramBaseChatItemLayout.f.setAccessibilityDelegate(new ugz(this));
        }
        a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
        return;
        if (3000 != paramChatMessage.istroop) {
          break label495;
        }
        if (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin))
        {
          localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
          break;
        }
        if (paramChatMessage.isSend()) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();; localObject1 = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin)) {
          break;
        }
        i = 0;
        break label89;
        label314:
        localObject1 = null;
        break label119;
        label320:
        bool = false;
        break label124;
        if (paramChatMessage.istroop == 9501)
        {
          if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
          {
            localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin, true);
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
            paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList, false, false, false, false, "", null, null);
          }
          for (;;)
          {
            localObject1 = null;
            break;
            paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
          }
        }
        paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
      }
      label495:
      localObject1 = null;
    }
  }
  
  public static void a(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    paramQQCustomMenu.a(2131375336, paramContext.getString(2131433621), 2130838305);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin()), paramString2, null);
      }
      return;
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int i;
    int j;
    label30:
    boolean bool;
    String str;
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      if (paramChatMessage.istroop != 1) {
        break label104;
      }
      i = 1;
      if (paramChatMessage.istroop != 3000) {
        break label110;
      }
      j = 1;
      bool = paramChatMessage.isSend();
      if ((i != 0) || (j != 0))
      {
        if (i == 0) {
          break label207;
        }
        if (!bool) {
          break label116;
        }
        str = "我的群名片";
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setContentDescription(str);
      if ((AppSetting.jdField_b_of_type_Boolean) && (paramViewHolder.jdField_b_of_type_JavaLangStringBuilder != null))
      {
        if (paramChatMessage.isSend()) {
          paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.append("我");
        }
      }
      else
      {
        return;
        label104:
        i = 0;
        break;
        label110:
        j = 0;
        break label30;
        label116:
        if ("1000000".equals(paramChatMessage.senderuin))
        {
          if (paramChatMessage.msgtype == -3006)
          {
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131430763), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = "进入群应用";
          continue;
        }
        str = paramString + "群名片";
        continue;
        label207:
        if (j == 0) {
          break label312;
        }
        if (bool)
        {
          str = "我的资料卡";
          continue;
        }
        str = paramString + "资料卡";
        continue;
      }
      paramBaseChatItemLayout = paramString;
      if (paramString == null) {
        paramBaseChatItemLayout = "";
      }
      paramString = paramBaseChatItemLayout;
      if (AnonymousChatHelper.a(paramChatMessage)) {
        paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430434) + paramBaseChatItemLayout;
      }
      paramViewHolder.jdField_b_of_type_JavaLangStringBuilder.insert(0, paramString);
      return;
      label312:
      str = "";
    }
  }
  
  public static boolean a(View paramView)
  {
    Object localObject = AIOUtils.a(paramView);
    if (localObject == null) {}
    while (!(localObject instanceof BaseBubbleBuilder.ViewHolder)) {
      return false;
    }
    paramView = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView);
    if ((paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo == null) || (paramView.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.jdField_a_of_type_Int <= 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (ConfessMsgUtil.a(paramChatMessage))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130845658;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label150;
        }
      }
      label150:
      for (int i = 2130845657;; i = 2130845493)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = new BubbleInfo(0);
        a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
        a(paramViewHolder, paramChatMessage);
        return true;
        i = 2130845494;
        break;
      }
    }
    return false;
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject1 = null;
    if (AnonymousChatHelper.a(paramChatMessage)) {
      localObject1 = AnonymousChatHelper.a(paramChatMessage).jdField_b_of_type_JavaLangString;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        localObject2 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
      }
      for (;;)
      {
        boolean bool3 = false;
        boolean bool1 = bool3;
        if (paramChatMessage.istroop == 1)
        {
          bool1 = bool3;
          if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramChatMessage.frienduin) != null) {
            bool1 = HotChatManager.a(paramChatMessage);
          }
        }
        Object localObject3 = localObject1;
        if (paramChatMessage.msgtype == -3006) {
          localObject3 = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        }
        localObject1 = localObject3;
        if ((paramChatMessage instanceof MessageForStructing))
        {
          localObject1 = localObject3;
          if (TroopBindPublicAccountMgr.a(paramChatMessage)) {
            localObject1 = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
          }
        }
        Object localObject4 = TroopBusinessUtil.a(paramChatMessage);
        if (localObject4 != null)
        {
          localObject3 = ((TroopBusinessUtil.TroopBusinessMessage)localObject4).jdField_c_of_type_JavaLangString;
          localObject1 = localObject3;
          if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
          {
            localObject2 = ColorStateList.valueOf(((TroopBusinessUtil.TroopBusinessMessage)localObject4).jdField_b_of_type_Int);
            localObject1 = localObject3;
          }
        }
        for (;;)
        {
          Object localObject5;
          int i;
          if ((paramChatMessage.istroop == 1) && (!AnonymousChatHelper.a(paramChatMessage)))
          {
            localObject3 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            bool3 = ((HotChatManager)localObject3).b(paramChatMessage.frienduin);
            if (bool3)
            {
              localObject3 = ((HotChatManager)localObject3).a(paramChatMessage.frienduin);
              if ((bool3) || (TroopMemberLbsHelper.a(paramChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue()))
              {
                TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                localObject5 = (uhi)paramBaseChatItemLayout.getTag(2131361869);
                localObject4 = localObject5;
                if (localObject5 == null)
                {
                  localObject4 = new uhi(this, null);
                  paramBaseChatItemLayout.setTag(2131361869, localObject4);
                }
                ((uhi)localObject4).jdField_a_of_type_Int = 2;
                ((uhi)localObject4).jdField_a_of_type_Boolean = bool2;
                ((uhi)localObject4).jdField_a_of_type_AndroidContentResColorStateList = ((ColorStateList)localObject2);
                ((uhi)localObject4).jdField_b_of_type_Boolean = bool1;
                ((uhi)localObject4).c = false;
                ((uhi)localObject4).jdField_a_of_type_JavaLangCharSequence = "";
                ((uhi)localObject4).jdField_b_of_type_AndroidContentResColorStateList = null;
                ((uhi)localObject4).d = false;
                ((uhi)localObject4).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
                ((uhi)localObject4).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                ((uhi)localObject4).jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = paramViewHolder;
                localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject4);
              }
              if ((!bool3) || (localObject3 == null) || (!((HotChatInfo)localObject3).isGameRoom)) {
                break label761;
              }
              i = 1;
              label464:
              if (i == 0) {
                break label1137;
              }
              localObject2 = ColorStateList.valueOf(-1);
              if (paramChatMessage.isSend()) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
              }
              localObject3 = localObject1;
            }
          }
          for (localObject1 = localObject2;; localObject1 = localObject2)
          {
            if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramChatMessage.senderuin) == 1)
            {
              i = 1;
              label525:
              localObject2 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a;
              if (i == 0) {
                break label773;
              }
              localObject2 = ((FlashChatManager.GlobalConfig)localObject2).jdField_d_of_type_JavaLangString;
              label555:
              if (!android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
                break label1045;
              }
              if (!paramChatMessage.isMultiMsg) {
                break label817;
              }
              localObject3 = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
                break label779;
              }
              localObject3 = paramChatMessage.senderuin;
              label609:
              if ((localObject3 == null) && (!bool2)) {
                break label805;
              }
              bool3 = true;
              label622:
              if (((!bool2) || (!AnonymousChatHelper.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                break label811;
              }
              bool2 = true;
              label644:
              paramBaseChatItemLayout.a(bool3, (CharSequence)localObject3, (ColorStateList)localObject1, bool2, bool1, false, false, "", null, (String)localObject2);
              a((String)localObject3, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
              label675:
              if (paramBaseChatItemLayout.jdField_g_of_type_AndroidWidgetTextView != null) {
                paramBaseChatItemLayout.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
              }
              if (paramBaseChatItemLayout.f != null)
              {
                if (AnonymousChatHelper.a(paramChatMessage)) {
                  break label1126;
                }
                paramBaseChatItemLayout.f.setOnClickListener(this);
                paramBaseChatItemLayout.f.setTag(Integer.valueOf(2131361871));
              }
            }
            for (;;)
            {
              if ((AppSetting.jdField_b_of_type_Boolean) && (Build.VERSION.SDK_INT >= 14)) {
                paramBaseChatItemLayout.f.setAccessibilityDelegate(new uha(this));
              }
              return;
              localObject3 = null;
              break;
              label761:
              i = 0;
              break label464;
              i = 0;
              break label525;
              label773:
              localObject2 = null;
              break label555;
              label779:
              localObject3 = (String)localObject3 + ":";
              break label609;
              label805:
              bool3 = false;
              break label622;
              label811:
              bool2 = false;
              break label644;
              label817:
              if (paramChatMessage.istroop != 1) {
                break label675;
              }
              localObject3 = paramChatMessage.senderuin;
              if ((localObject3 != null) || (bool2))
              {
                bool3 = true;
                label844:
                if (((!bool2) || (!AnonymousChatHelper.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                  break label1039;
                }
              }
              label1039:
              for (boolean bool4 = true;; bool4 = false)
              {
                paramBaseChatItemLayout.a(bool3, (CharSequence)localObject3, (ColorStateList)localObject1, bool4, bool1, false, false, "", null, (String)localObject2);
                localObject5 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                localObject4 = (uhi)paramBaseChatItemLayout.getTag(2131361870);
                localObject3 = localObject4;
                if (localObject4 == null)
                {
                  localObject3 = new uhi(this, null);
                  paramBaseChatItemLayout.setTag(2131361870, localObject3);
                }
                ((uhi)localObject3).jdField_a_of_type_Boolean = bool2;
                ((uhi)localObject3).jdField_a_of_type_AndroidContentResColorStateList = ((ColorStateList)localObject1);
                ((uhi)localObject3).jdField_b_of_type_Boolean = bool1;
                ((uhi)localObject3).c = false;
                ((uhi)localObject3).jdField_a_of_type_JavaLangCharSequence = "";
                ((uhi)localObject3).jdField_b_of_type_AndroidContentResColorStateList = null;
                ((uhi)localObject3).d = false;
                ((uhi)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
                ((uhi)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
                ((uhi)localObject3).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
                ((uhi)localObject3).jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = paramViewHolder;
                ((TroopManager)localObject5).a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject3);
                break;
                bool3 = false;
                break label844;
              }
              label1045:
              if ((localObject3 != null) || (bool2))
              {
                bool3 = true;
                label1058:
                if (((!bool2) || (!AnonymousChatHelper.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                  break label1120;
                }
              }
              label1120:
              for (bool2 = true;; bool2 = false)
              {
                paramBaseChatItemLayout.a(bool3, (CharSequence)localObject3, (ColorStateList)localObject1, bool2, bool1, false, false, "", null, (String)localObject2);
                a((String)localObject3, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
                break;
                bool3 = false;
                break label1058;
              }
              label1126:
              paramBaseChatItemLayout.f.setOnClickListener(null);
            }
            label1137:
            localObject3 = localObject1;
          }
        }
      }
    }
  }
  
  private final boolean b(ChatMessage paramChatMessage)
  {
    return (paramChatMessage instanceof MessageForPoke);
  }
  
  private boolean b(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      if (paramChatMessage.istroop == 1) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130837712);
        paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = new BubbleInfo(0);
        a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
        a(paramViewHolder, paramChatMessage);
        return true;
        if (paramChatMessage.istroop == 3000) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 2, 0, "", "", "", "");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramChatMessage.isShowQIMStyleGroup = QIMUserManager.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (paramChatMessage.isShowQIMStyleGroup)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085A4", "0X80085A4", 3, 0, "", "", "", "");
        boolean bool;
        int i;
        Drawable localDrawable1;
        label318:
        Drawable localDrawable2;
        if ((!(this instanceof TextItemBuilder)) || ((this instanceof TextTranslationItemBuilder)))
        {
          bool = paramChatMessage.isSend();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c)
          {
            localObject = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources();
            if (bool)
            {
              i = 2130845658;
              localDrawable1 = ((Resources)localObject).getDrawable(i);
              localObject = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources();
              if (!bool) {
                break label416;
              }
              i = 2130845657;
              localDrawable2 = ((Resources)localObject).getDrawable(i);
              localObject = new StateListDrawable();
              ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
              ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            }
          }
        }
        for (;;)
        {
          paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = new BubbleInfo(0);
          a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
          a(paramViewHolder, paramChatMessage);
          return true;
          i = 2130845494;
          break;
          label416:
          i = 2130845493;
          break label318;
          localObject = SkinEngine.getInstances();
          if (bool)
          {
            i = 2130845658;
            label439:
            localDrawable1 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = SkinEngine.getInstances();
            if (!bool) {
              break label524;
            }
          }
          label524:
          for (i = 2130845657;; i = 2130845493)
          {
            localDrawable2 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = new StateListDrawable();
            ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
            ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            break;
            i = 2130845494;
            break label439;
          }
          if (!paramChatMessage.isSend()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label571;
            }
            localObject = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130837711);
            break;
          }
          label571:
          localObject = paramViewHolder.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130837712);
        }
      }
    }
    return false;
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localHotChatInfo == null) || (localHotChatInfo.isGameRoom)) {
      return;
    }
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin)) {
      if (paramChatMessage.senderuin.equals(localHotChatInfo.ownerUin))
      {
        paramChatMessage = "房主";
        i = 0;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.a(paramChatMessage, i);
      return;
      if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
      {
        paramChatMessage = "管理员";
        i = 1;
      }
      else if ((localHotChatInfo.isRobotHotChat) && (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).b(paramChatMessage.senderuin)))
      {
        paramChatMessage = "群机器人";
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
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    boolean bool;
    int j;
    int k;
    AnonymousChatHelper.AnonymousExtInfo localAnonymousExtInfo;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      bool = true;
      j = -1;
      if (bool) {
        j = AnonymousChatHelper.jdField_e_of_type_Int;
      }
      if (!AnonymousChatHelper.a(paramChatMessage)) {
        break label153;
      }
      k = TroopRankConfig.a().jdField_a_of_type_Int;
      localAnonymousExtInfo = AnonymousChatHelper.a(paramChatMessage);
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
            if (!android.text.TextUtils.isEmpty(localAnonymousExtInfo.jdField_c_of_type_JavaLangString)) {
              i = Color.parseColor(localAnonymousExtInfo.jdField_c_of_type_JavaLangString);
            }
            paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131430436), AnonymousChatHelper.b(paramChatMessage), i, j);
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
            this.c = false;
            paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
            return;
          }
          if ((paramChatMessage instanceof MessageForTroopTopic))
          {
            paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
            return;
          }
          localObject = TroopBusinessUtil.a(paramChatMessage);
          if (localObject != null)
          {
            j = ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_c_of_type_Int;
            i = ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_d_of_type_Int;
            if (bool)
            {
              j = AnonymousChatHelper.jdField_e_of_type_Int;
              i = TroopRankConfig.a().jdField_a_of_type_Int;
            }
            paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_d_of_type_JavaLangString, false, i, j);
            paramBaseChatItemLayout.c.setOnClickListener(this);
            paramBaseChatItemLayout.c.setTag(Integer.valueOf(2131361867));
            return;
          }
        } while (paramChatMessage.istroop != 1);
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, j);
        this.c = false;
      } while (localTroopManager == null);
      localTroopInfo = localTroopManager.a(paramChatMessage.frienduin);
      localObject = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
    } while ((localTroopInfo == null) || (((localTroopInfo.cGroupRankSysFlag != 1) || (localTroopInfo.cGroupRankUserFlag != 1)) && (!((TroopRobotManager)localObject).b(paramChatMessage.senderuin)) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop())));
    uhh localuhh = (uhh)paramBaseChatItemLayout.getTag(2131361867);
    Object localObject = localuhh;
    if (localuhh == null)
    {
      localObject = new uhh(this, null);
      paramBaseChatItemLayout.setTag(2131361867, localObject);
    }
    ((uhh)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    ((uhh)localObject).jdField_a_of_type_Boolean = bool;
    ((uhh)localObject).jdField_a_of_type_Int = j;
    ((uhh)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject);
  }
  
  private void g(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localObject != null) && (((TroopInfo)localObject).isHomeworkTroop())) {}
    do
    {
      do
      {
        return;
        if (!AnonymousChatHelper.a(paramChatMessage)) {
          break;
        }
        this.jdField_b_of_type_Int = 0;
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_b_of_type_Int, AnonymousChatHelper.b(paramChatMessage));
      } while (paramBaseChatItemLayout.d == null);
      paramBaseChatItemLayout.d.setOnClickListener(null);
      return;
      if ("1000000".equals(paramChatMessage.senderuin))
      {
        this.jdField_b_of_type_Int = 0;
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_b_of_type_Int, false);
        return;
      }
      if ((paramChatMessage instanceof MessageForTroopTopic))
      {
        this.jdField_b_of_type_Int = 0;
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_b_of_type_Int, false);
        return;
      }
      if (MessageUtils.a(paramChatMessage.msgtype))
      {
        this.jdField_b_of_type_Int = 0;
        paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_b_of_type_Int, false);
        return;
      }
      if (TroopBusinessUtil.a(paramChatMessage) == null) {
        break;
      }
      this.jdField_b_of_type_Int = 0;
      paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_b_of_type_Int, false);
    } while (paramBaseChatItemLayout.d == null);
    paramBaseChatItemLayout.d.setOnClickListener(this);
    paramBaseChatItemLayout.d.setTag(Integer.valueOf(2131361868));
    return;
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    localObject = localTroopManager.a(paramChatMessage.frienduin);
    if ((localObject != null) && (((TroopInfo)localObject).isQidianPrivateTroop()))
    {
      this.jdField_b_of_type_Int = 0;
      paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_b_of_type_Int, false);
      return;
    }
    paramBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, this.jdField_b_of_type_Int, false);
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    uhg localuhg = (uhg)paramBaseChatItemLayout.getTag(2131361868);
    localObject = localuhg;
    if (localuhg == null)
    {
      localObject = new uhg(this, null);
      paramBaseChatItemLayout.setTag(2131361868, localObject);
    }
    ((uhg)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject);
  }
  
  private void h(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramChatMessage.frienduin);
    if (localObject != null)
    {
      bool = ((HotChatInfo)localObject).isGameRoom;
      if (!bool) {
        break label105;
      }
      localObject = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((WerewolvesPluginManager)localObject).a(paramChatMessage.senderuin);
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
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      } while (localObject == null);
      paramChatMessage = ((TroopManager)localObject).b(paramChatMessage.frienduin, paramChatMessage.senderuin);
    } while (paramChatMessage == null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramChatMessage.hotChatGlamourLevel >= 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.b((QQAppInterface)localObject, bool, paramChatMessage.hotChatGlamourLevel, false);
      if (paramBaseChatItemLayout.e == null) {
        break;
      }
      paramBaseChatItemLayout.e.setOnClickListener(this);
      paramBaseChatItemLayout.e.setTag(Integer.valueOf(2131361868));
      return;
    }
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  public Drawable a(BaseChatItemLayout paramBaseChatItemLayout, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null) {
      return null;
    }
    BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)paramBaseChatItemLayout.getTag();
    if (localViewHolder != null)
    {
      localViewHolder.jdField_a_of_type_JavaLangString = paramString;
      localViewHolder.jdField_d_of_type_Int = paramInt;
      paramBaseChatItemLayout.setTag(localViewHolder);
    }
    paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b(paramInt, paramString, 6);
    if (paramBaseChatItemLayout == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true);
      }
      return ImageUtil.b();
    }
    return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBaseChatItemLayout);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1 + ", msgseq = " + paramChatMessage.msgseq + ", shmsgseq = " + paramChatMessage.shmsgseq);
    }
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramView = (BaseChatItemLayout)paramView;
      bool = AppSetting.jdField_b_of_type_Boolean;
      if (paramView == null)
      {
        paramView = new BaseChatItemLayout(localContext);
        paramView.setId(2131361996);
        paramView.setFocusableInTouchMode(true);
        paramViewGroup = a();
        paramView.setTag(paramViewGroup);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
        if (!bool) {
          break label1160;
        }
        paramViewGroup.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
        if ((bool) && (paramViewGroup.jdField_b_of_type_JavaLangStringBuilder == null)) {
          paramViewGroup.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        paramViewGroup.jdField_b_of_type_Int = paramInt1;
        paramViewGroup.jdField_c_of_type_Int = paramInt2;
        localObject1 = null;
        localObject2 = localObject1;
        if (bool)
        {
          paramView.setContentDescription(null);
          if (!android.text.TextUtils.isEmpty(paramViewGroup.jdField_b_of_type_JavaLangStringBuilder)) {
            paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.length(), "");
          }
          localObject2 = localObject1;
          if (paramChatMessage.mNeedTimeStamp)
          {
            localObject2 = localObject1;
            if (paramChatMessage.time <= 0L) {}
          }
        }
      }
    }
    catch (Exception paramView)
    {
      label1160:
      for (;;)
      {
        try
        {
          boolean bool;
          Object localObject1 = TimeFormatterUtils.a(localContext, 3, paramChatMessage.time * 1000L);
          paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append((CharSequence)localObject1).append(" ");
          Object localObject2 = localObject1;
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          if (paramChatMessage.isSend())
          {
            i = 1;
            paramView.setHearIconPosition(i);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null)
            {
              ColorStateList localColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList;
              localObject1 = localColorStateList;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
              {
                localObject1 = localColorStateList;
                if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  localObject1 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
                }
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1033) {
                continue;
              }
              localObject1 = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
              paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage.time, (ColorStateList)localObject1, localObject2);
            }
            if (!TroopBindPublicAccountMgr.a(paramChatMessage)) {
              continue;
            }
            paramView.setGrayTipsText(true, localContext.getString(2131430063), this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131492894), 0);
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
            a(paramChatMessage, paramView);
            b(paramChatMessage, paramView);
            paramView.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
            a(paramChatMessage, paramView, paramInt1, paramInt2);
            if (paramChatMessage.istroop != 1) {
              continue;
            }
            localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
            if ((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
              continue;
            }
            e(paramChatMessage, paramView);
            h(paramChatMessage, paramView);
            b(paramChatMessage, paramView, paramViewGroup);
            if (paramView.jdField_b_of_type_ComTencentImageURLImageView != null) {
              paramView.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
            }
            if (!b(paramChatMessage, paramView)) {
              continue;
            }
            paramView.setProgressVisable(false);
            paramView.setNetIconVisible(false);
            paramOnLongClickAndTouchListener = a(paramChatMessage, paramViewGroup, paramViewGroup.jdField_a_of_type_AndroidViewView, paramView, paramOnLongClickAndTouchListener);
            paramViewGroup.jdField_a_of_type_AndroidViewView = paramOnLongClickAndTouchListener;
            a(paramOnLongClickAndTouchListener, paramView);
            a(paramChatMessage, localContext, paramView, paramViewGroup, paramInt1, paramInt2);
            if (bool)
            {
              paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.append(a(paramChatMessage));
              localObject1 = Spannable.Factory.getInstance().newSpannable(paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.toString());
              if (!Linkify.addLinks((Spannable)localObject1, 15)) {
                continue;
              }
              paramView.setContentDescription((CharSequence)localObject1);
              paramView.setFocusable(true);
            }
            if ((paramChatMessage instanceof MessageForTroopTopic))
            {
              paramInt1 = AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
              paramInt2 = AIOUtils.a(7.5F, localContext.getResources());
              paramView.setPadding(0, 0, 0, 0);
              paramViewGroup.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
              ((RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidViewView.getLayoutParams()).setMargins(paramInt1, paramInt2, paramInt1, paramInt2);
            }
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a();
            StartupTracker.a(null, "AIO_Handle_Sticker_Cost");
            long l = System.currentTimeMillis();
            a(localContext, paramOnLongClickAndTouchListener, paramChatMessage, paramView, paramViewGroup);
            StartupTracker.a("AIO_Handle_Sticker_Cost", null);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleStickers time cost : " + (System.currentTimeMillis() - l) + " ms");
            }
            if ((!paramChatMessage.mMsgAnimFlag) || (paramView.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView == null) || (b(paramChatMessage))) {
              continue;
            }
            paramChatMessage.mMsgAnimFlag = false;
            paramInt2 = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            paramInt1 = paramInt2;
            if (!paramChatMessage.isSend()) {
              paramInt1 = paramInt2 * -1;
            }
            paramView.a(paramChatMessage, paramInt1, 0.0F, 0.0F, 1.0F, this);
            paramView.requestLayout();
            return paramView;
            paramView = paramView;
            paramViewGroup = "";
            paramView = paramViewGroup;
            if (localContext != null)
            {
              paramView = paramViewGroup;
              if ((localContext instanceof Activity)) {
                paramView = localContext.getClass().getName();
              }
            }
            QLog.e("BaseBubbleBuilder", 1, paramView + " baseBubbleBuilderCatchedException " + paramChatMessage.msgtype);
            paramView = null;
            continue;
            paramViewGroup = (BaseBubbleBuilder.ViewHolder)paramView.getTag();
          }
        }
        catch (Exception localException)
        {
          String str = "";
          continue;
          int i = 0;
          continue;
          paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131492894), 235);
          continue;
          f(paramChatMessage, paramView);
          g(paramChatMessage, paramView);
          continue;
          a(paramChatMessage, paramView, paramViewGroup);
          continue;
          c(paramChatMessage, paramView);
          continue;
          paramView.setContentDescription(paramViewGroup.jdField_b_of_type_JavaLangStringBuilder.toString());
          continue;
          paramView.a(paramChatMessage);
          continue;
        }
      }
    }
  }
  
  public abstract View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return null;
  }
  
  public abstract BaseBubbleBuilder.ViewHolder a();
  
  public abstract String a(ChatMessage paramChatMessage);
  
  public void a()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    MessageProgressController.a().a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        b(paramChatMessage);
        return;
      } while ((paramChatMessage.istroop != 1) || ((!(paramChatMessage instanceof MessageForLongMsg)) && (!(paramChatMessage instanceof MessageForText)) && (!(paramChatMessage instanceof MessageForReplyText))));
      if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_AndroidContentContext.getString(2131430721), null, this.jdField_a_of_type_AndroidContentContext.getString(2131430186), new uhd(this), null).show();
        return;
      }
      paramContext = (TroopTopicMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(97);
    } while ((paramContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)));
    TroopBarUtils.a.clear();
    paramContext.a(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage, null, 4);
    paramContext = "";
    if (paramChatMessage.msgtype == -1000) {
      paramContext = "1";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "pub_talk", "Clk_bubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramContext, "", "");
      return;
      if (paramChatMessage.msgtype == -2000) {
        paramContext = "2";
      }
    }
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.jdField_g_of_type_Int;
    int i = j;
    if (StructMsgItemLayout12.a(paramChatMessage)) {
      i = j - AIOUtils.a(10.0F, paramView.getResources());
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
    if (paramInt == 890)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof BaseBubbleBuilder.ViewHolder))
      {
        paramView = (BaseBubbleBuilder.ViewHolder)paramView;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
      }
      return;
    }
    c(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) || (paramBubbleInfo == null)) {
      return;
    }
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject3 = null;
    BubbleConfig localBubbleConfig = null;
    Pair localPair = null;
    BubbleManager localBubbleManager = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);
    Object localObject2;
    label63:
    Object localObject1;
    if (com.tencent.mobileqq.text.TextUtils.a(paramChatMessage.msg))
    {
      localObject2 = com.tencent.mobileqq.text.TextUtils.a(paramChatMessage.msg);
      if ((localBubbleManager == null) || (android.text.TextUtils.isEmpty((CharSequence)localObject2))) {
        break label881;
      }
      localObject1 = localBubbleManager.a(paramBubbleInfo.jdField_a_of_type_Int, false);
      if ((localObject1 == null) || (((BubbleConfig)localObject1).b == null) || (!((BubbleConfig)localObject1).a((String)localObject2))) {
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
      localObject1 = localBubbleConfig;
      int j = k;
      Object localObject4;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject4 = paramBubbleInfo.a((String)localObject2);
        localObject1 = localBubbleConfig;
        localObject3 = localObject4;
        j = k;
        if (localObject4 != null)
        {
          localObject1 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
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
          localPair = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6);
          if ((localPair == null) || (localPair.first == null)) {
            break label863;
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
              if (VersionUtils.e())
              {
                localObject2 = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
                m = n;
                if (localObject2 != null)
                {
                  m = n;
                  if (((Pair)localObject2).first != null)
                  {
                    m = n;
                    if (paramView.getWidth() > ((BubbleInfo.CommonAttrs)((Pair)localObject2).first).a.j) {
                      m = 1;
                    }
                  }
                }
              }
            }
          }
          if ((localBubbleManager != null) && ((paramChatMessage instanceof MessageForText)))
          {
            localBubbleConfig = localBubbleManager.a(paramBubbleInfo.jdField_a_of_type_Int, false);
            if ((localBubbleConfig != null) && (localBubbleConfig.f != null) && (localBubbleConfig.f.k != 0) && (VersionUtils.e())) {
              if (paramChatMessage.isSend())
              {
                localObject2 = paramChatMessage.selfuin;
                localObject4 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
                if (localObject4 == null) {
                  break label857;
                }
                localObject2 = ((FriendsManager)localObject4).a((String)localObject2);
                if ((localObject2 == null) || ((localBubbleConfig.f.k != -1) && (((ExtensionInfo)localObject2).pendantId != localBubbleConfig.f.k))) {
                  break label857;
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (i != 0)
            {
              long l = BubbleInterActiveAnim.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
              if (l != -1L) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
              }
            }
            if ((j != 0) || (m != 0) || (n != 0) || (k != 0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
            }
            if (j != 0)
            {
              a("keyword_trigger", paramBubbleInfo.jdField_a_of_type_Int, localObject3);
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
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramBubbleInfo.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface });
              if (!paramBubbleInfo.a(paramView.getHeight())) {
                break;
              }
              paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
              if ((paramView == null) || (paramView.first == null)) {
                break;
              }
              a("wordnum_trigger", paramBubbleInfo.jdField_a_of_type_Int, null);
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
  
  public void a(View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) {}
    do
    {
      return;
      paramView = paramBubbleInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    } while ((paramView == null) || (paramView.first == null));
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  public void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (!SchoolTroopKeywordManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramMessageRecord = ((SchoolTroopKeywordManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(261)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord);
      if ((paramMessageRecord != null) && (paramMessageRecord.jdField_b_of_type_Int != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord), paramMessageRecord.jdField_c_of_type_Int, paramMessageRecord.jdField_d_of_type_Int, 17);
        paramTextView.setTag(2131363679, "school_troop_span");
      }
    } while (!QLog.isColorLevel());
    QLog.i("school_troop.BaseBubbleBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo) {}
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage) {}
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = false;
    if (GoldMsgChatHelper.c(paramChatMessage)) {
      bool = true;
    }
    paramBaseChatItemLayout.a(paramQQAppInterface, bool, this, paramChatMessage);
    if (bool) {
      GoldMsgChatHelper.a().a(paramChatMessage);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
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
        localBaseChatPie.d(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label108;
      }
      i = 6;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + i, "", "", "");
      return;
      label108:
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {}
    for (boolean bool1 = false;; bool1 = true) {
      try
      {
        i = a(paramChatMessage);
        paramViewHolder.jdField_a_of_type_Int = i;
        if (i != 0) {
          if (a(paramChatMessage, paramViewHolder, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setConfessMsgBubble " + paramChatMessage.getLogColorContent());
            }
            if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
            {
              paramBaseChatItemLayout.setBubbleView(paramViewHolder.jdField_a_of_type_AndroidViewView);
              a(paramViewHolder.jdField_a_of_type_AndroidViewView, paramChatMessage);
              paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362293, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
              paramViewHolder.jdField_a_of_type_AndroidViewView.setTag(2131362294, paramChatMessage);
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
          if (b(paramChatMessage, paramViewHolder, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setQimMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else
          {
            Object localObject;
            label345:
            int j;
            boolean bool2;
            boolean bool3;
            if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!ConfessMsgUtil.a(paramChatMessage)))
            {
              localObject = LocaleUtil.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
              paramContext = null;
              TransDiskCache localTransDiskCache = TranslateCache.b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
              if (localTransDiskCache != null) {
                paramContext = localTransDiskCache.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
              }
              if ((paramContext != null) && (paramContext.a().booleanValue()) && (!paramChatMessage.isSend()))
              {
                paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100001, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
                if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) {
                  paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a(paramViewHolder.jdField_a_of_type_AndroidViewView, null);
                }
                if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
                {
                  paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumWidth(AIOUtils.a(65.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                  paramViewHolder.jdField_a_of_type_AndroidViewView.setMinimumHeight(AIOUtils.a(57.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
                }
                if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null)
                {
                  int k = paramChatMessage.vipBubbleDiyTextId;
                  j = k;
                  if (k <= 0) {
                    j = SVIPHandler.b(paramChatMessage.vipBubbleID);
                  }
                  paramContext = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  bool2 = paramChatMessage.isSend();
                  bool3 = paramChatMessage.needVipBubble();
                  if (i != 2) {
                    break label698;
                  }
                }
              }
            }
            label698:
            for (bool1 = true;; bool1 = false)
            {
              paramContext.a((QQAppInterface)localObject, bool2, bool3, bool1, paramViewHolder.jdField_a_of_type_AndroidViewView, FontManager.a(paramChatMessage), j);
              if (paramViewHolder.jdField_a_of_type_AndroidViewView != null)
              {
                paramContext = paramViewHolder.jdField_a_of_type_AndroidViewView.getBackground();
                if (paramContext != null) {
                  paramContext.setAlpha(jdField_a_of_type_Int);
                }
              }
              a(paramViewHolder, paramBaseChatItemLayout, paramChatMessage, paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo);
              a(paramViewHolder, paramChatMessage);
              if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
                jdField_a_of_type_AndroidOsHandler.post(new uhb(this, paramViewHolder, paramChatMessage));
              }
              paramChatMessage.mAnimFlag = false;
              break;
              paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(100000, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
              break label345;
              if ((i == 3) || (!paramChatMessage.needVipBubble()) || (ConfessMsgUtil.a(paramChatMessage))) {}
              for (j = 0;; j = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage))
              {
                paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = BubbleUtils.a(j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext.getResources(), this.jdField_a_of_type_AndroidWidgetBaseAdapter, bool1);
                break;
              }
            }
            if (paramViewHolder.jdField_a_of_type_AndroidViewView == null)
            {
              QLog.e("ChatItemBuilder", 1, "handleBubbleBg mContent is null type = " + paramChatMessage.istroop);
              return;
            }
            paramViewHolder.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setCheckBox(paramChatMessage, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2)
  {
    if ((paramChatMessage == null) || (paramChatMessage.isShowQimStyleAvater) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.h)) || (ConfessMsgUtil.a(paramChatMessage))) {
      paramBaseChatItemLayout.setPendantImageVisible(false);
    }
    Object localObject;
    do
    {
      do
      {
        return;
      } while (AIOUtils.h);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    } while ((localObject != null) && (((TroopInfo)localObject).hasOrgs()));
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null) || (AnonymousChatHelper.a(paramChatMessage)) || ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)))
    {
      paramBaseChatItemLayout.setPendantImageVisible(false);
      return;
    }
    FriendsManager localFriendsManager;
    ExtensionInfo localExtensionInfo;
    AvatarPendantManager localAvatarPendantManager;
    String str;
    if (paramChatMessage.isSend())
    {
      localObject = paramChatMessage.selfuin;
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (localFriendsManager == null) {
        break label632;
      }
      localExtensionInfo = localFriendsManager.a((String)localObject, false);
      localAvatarPendantManager = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
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
          AvatarPendantUtil.a((String)localObject);
          AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        str = paramChatMessage.getExtInfoFromExtStr("vip_pendant_diy_id");
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "handleAvatarPendant: message pendantDiyId = " + str);
        }
        if (android.text.TextUtils.isEmpty(str)) {}
      }
    }
    for (;;)
    {
      try
      {
        if (Integer.parseInt(str) != localExtensionInfo.pendantDiyId)
        {
          AvatarPendantUtil.a((String)localObject);
          AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if ((localExtensionInfo != null) && (localExtensionInfo.isPendantValid()))
        {
          AvatarPendantManager.jdField_b_of_type_Boolean = true;
          if (AvatarPendantUtil.a(localExtensionInfo.pendantId))
          {
            localAvatarPendantManager.a(localExtensionInfo.pendantId).a(paramBaseChatItemLayout, 2, paramChatMessage.uniseq, (String)localObject, localExtensionInfo.pendantDiyId);
            if ((!localFriendsManager.b((String)localObject)) && (localExtensionInfo.isPendantExpired())) {
              AvatarPendantUtil.a((String)localObject);
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
        AvatarPendantUtil.a((String)localObject);
        continue;
      }
      label632:
      if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, QQCustomMenu paramQQCustomMenu)
  {
    if (paramChatMessage == null) {}
    while (((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000)) || (paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (!paramChatMessage.isSupportReply())) {
      return;
    }
    paramQQCustomMenu.a(2131375353, this.jdField_a_of_type_AndroidContentContext.getString(2131430723), 2130838312);
    MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
  }
  
  public void a(FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
  }
  
  public void a(QQCustomMenu paramQQCustomMenu, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isSend()) && (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    label25:
    do
    {
      boolean bool;
      do
      {
        do
        {
          do
          {
            do
            {
              break label25;
              break label25;
              break label25;
              do
              {
                return;
              } while ((AnonymousChatHelper.a(paramMessageRecord)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9) || (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) == 1032));
              localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (!((FriendsManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
            if (paramInt != 1) {
              break;
            }
            localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          } while ((localObject != null) && (((HotChatManager)localObject).b(paramMessageRecord.frienduin)));
          paramInt = paramMessageRecord.istroop;
        } while ((paramInt != 0) && (paramInt != 1) && (paramInt != 3000) && (paramInt != 1000) && (paramInt != 1004));
        bool = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("msgrevoke_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
        if (QLog.isColorLevel()) {
          QLog.i("msgrevoke", 2, "menuitem msgRevokeFlag=" + bool);
        }
      } while (!bool);
      paramQQCustomMenu.a(2131361906, this.jdField_a_of_type_AndroidContentContext.getString(2131433737), 2130838314);
    } while (!TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    Object localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
    String str = paramMessageRecord.frienduin;
    if (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
    for (paramQQCustomMenu = "1";; paramQQCustomMenu = "2")
    {
      ((ReportTask)localObject).a(new String[] { str, paramQQCustomMenu }).a();
      return;
    }
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.jdField_a_of_type_Boolean;
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {}
    label11:
    Object localObject4;
    boolean bool2;
    label249:
    label251:
    boolean bool1;
    label800:
    label989:
    Object localObject2;
    label1213:
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
            for (;;)
            {
              return;
              if ((!Utils.b(localChatMessage.senderuin)) || (!Utils.a(this.jdField_a_of_type_AndroidContentContext)))
              {
                localObject4 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
                if ((localChatMessage.issend == 1) || (localChatMessage.issend == 2)) {}
                for (bool2 = true;; bool2 = false)
                {
                  if (("10000".equals(localChatMessage.senderuin)) || ((localChatMessage.istroop == 3000) && (ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.frienduin)))) {
                    break label249;
                  }
                  localObject1 = TroopBusinessUtil.a(localChatMessage);
                  if (localObject1 == null) {
                    break label251;
                  }
                  TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TroopBusinessUtil.TroopBusinessMessage)localObject1);
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, localChatMessage.frienduin, "", ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_c_of_type_JavaLangString, "");
                  if (localChatMessage.msgtype != -2051) {
                    break;
                  }
                  try
                  {
                    paramView = (MessageForQQStory)localChatMessage;
                    paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
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
            if ((!(localChatMessage instanceof MessageForStructing)) || (!TroopBindPublicAccountMgr.a(localChatMessage))) {
              break;
            }
            localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          } while ((localObject1 == null) || (((TroopInfo)localObject1).associatePubAccount == 0L));
          localObject3 = new Intent(paramView.getContext(), AccountDetailActivity.class);
          ((Intent)localObject3).putExtra("uin", ((TroopInfo)localObject1).associatePubAccount + "");
          paramView.getContext().startActivity((Intent)localObject3);
          return;
          if (!AnonymousChatHelper.a(localChatMessage)) {
            break label989;
          }
          localObject1 = AnonymousChatHelper.a(localChatMessage);
          if ((paramView != null) && ((((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_JavaLangString != null) || (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int == 2))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("ChatItemBuilder", 2, "onHeadIconClick : an_id is null");
        return;
        localObject3 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(localChatMessage.frienduin);
        localObject4 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
        if (localObject3 != null) {
          ((TroopHandler)localObject4).a(((TroopInfo)localObject3).troopuin, (byte)0, ((TroopInfo)localObject3).dwTimeStamp, 0);
        }
        int j = 0;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        i = j;
        if (localObject3 != null)
        {
          i = j;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject4))
          {
            if ((((TroopInfo)localObject3).Administrator == null) || (!((TroopInfo)localObject3).Administrator.contains((CharSequence)localObject4))) {
              break label800;
            }
            i = 3;
          }
        }
        localObject3 = ((AnonymousChatHelper.AnonymousExtInfo)localObject1).a();
        if ((localObject3 != null) && (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int != 2))
        {
          localObject3 = URLEncoder.encode(Base64.a((byte[])localObject3, 2));
          localObject4 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          localStringBuilder = new StringBuilder().append("http://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject3).append("&gcode=").append(localChatMessage.frienduin).append("&avatar=").append(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_Int)).append("&nick=");
          if (android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString))
          {
            localObject1 = "";
            ((Intent)localObject4).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=0");
            ((Activity)paramView.getContext()).startActivity((Intent)localObject4);
            if (localChatMessage.msgData != null)
            {
              AnonymousChatHelper.a().a(localChatMessage.frienduin, (String)localObject3, localChatMessage);
              if (QLog.isDevelopLevel()) {
                QLog.i("ChatItemBuilder", 4, "report:" + localChatMessage.msgData.toString());
              }
            }
          }
        }
        while (((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_a_of_type_Int != 2) {
          for (;;)
          {
            StringBuilder localStringBuilder;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, localChatMessage.frienduin, "", "", "");
            return;
            if (((String)localObject4).equals(((TroopInfo)localObject3).troopowneruin))
            {
              i = 2;
              break;
            }
            i = 1;
            break;
            localObject1 = URLEncoder.encode(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString);
          }
        }
        localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        localObject4 = new StringBuilder().append("http://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(localChatMessage.frienduin).append("&avatar=").append(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_Int)).append("&nick=");
        if (android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString)) {}
        for (Object localObject1 = "";; localObject1 = URLEncoder.encode(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString))
        {
          ((Intent)localObject3).putExtra("url", (String)localObject1 + "&role=" + String.valueOf(i) + "&self=1");
          ((Activity)paramView.getContext()).startActivity((Intent)localObject3);
          break;
        }
        if ("1000000".equals(localChatMessage.senderuin))
        {
          TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1");
          return;
        }
        localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
        if ((localObject1 != null) && (((HotChatManager)localObject1).b(localChatMessage.frienduin))) {}
        for (i = 1;; i = 0)
        {
          for (;;)
          {
            if ((i != 0) || (localChatMessage.istroop != 1)) {
              break label1213;
            }
            localObject1 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
            try
            {
              long l = Long.parseLong(localChatMessage.senderuin);
              bool1 = ((TroopRobotManager)localObject1).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, l);
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
          TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), localChatMessage.frienduin, localChatMessage.senderuin, 0, 2000);
          return;
        }
        if (i == 0) {
          break;
        }
        localObject2 = localException.a(localChatMessage.frienduin);
      } while ((localObject2 != null) && (((HotChatInfo)localObject2).isRobotHotChat) && (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin))));
      if ((!bool2) && ((localObject3 == null) || (((FriendsManager)localObject3).b(localChatMessage.senderuin)))) {
        break label1656;
      }
      paramView = null;
      if (localObject2 == null) {
        break;
      }
      paramView = ((HotChatInfo)localObject2).troopCode;
      if (!((HotChatInfo)localObject2).isGameRoom) {
        break;
      }
      localObject3 = (WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(107);
    } while ((((WerewolvesHandler)localObject3).jdField_a_of_type_JavaLangString != null) && (((WerewolvesHandler)localObject3).jdField_a_of_type_JavaLangString.equals(localChatMessage.senderuin)));
    ProfilePerformanceReport.a();
    Object localObject3 = localChatMessage.senderuin;
    if ((localObject2 != null) && (((HotChatInfo)localObject2).isBuLuoHotChat()))
    {
      i = 86;
      localObject3 = new ProfileActivity.AllInOne((String)localObject3, i);
      ((ProfileActivity.AllInOne)localObject3).jdField_c_of_type_JavaLangString = paramView;
      ((ProfileActivity.AllInOne)localObject3).jdField_d_of_type_JavaLangString = localChatMessage.frienduin;
      if ((localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
        break label1626;
      }
      ((ProfileActivity.AllInOne)localObject3).jdField_h_of_type_Int = 113;
      label1434:
      paramView = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(localChatMessage.frienduin, localChatMessage.senderuin);
      if (paramView != null)
      {
        ((ProfileActivity.AllInOne)localObject3).q = TroopMemberLbsHelper.a(paramView.distanceToSelf);
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopMemberDistance", 2, "onHeadIconClick, distanceTime=" + paramView.distanceToSelfUpdateTimeStamp + ", aioDistance=" + paramView.distanceToSelf);
        }
      }
      HotChatManager.jdField_a_of_type_Boolean = false;
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
      paramView.putExtra("AllInOne", (Parcelable)localObject3);
      if (localObject2 == null) {
        break label1636;
      }
      bool1 = ((HotChatInfo)localObject2).isGameRoom;
      label1566:
      paramView.putExtra("is_from_werewolves", bool1);
      if (!bool2) {
        break label1642;
      }
    }
    label1626:
    label1636:
    label1642:
    for (int i = 2;; i = 3)
    {
      paramView.putExtra("param_mode", i);
      if ((!bool2) || (localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
        break label1647;
      }
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject3);
      return;
      i = 42;
      break;
      ((ProfileActivity.AllInOne)localObject3).jdField_h_of_type_Int = 31;
      break label1434;
      bool1 = false;
      break label1566;
    }
    label1647:
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    return;
    label1656:
    if ((localObject2 != null) && (((HotChatInfo)localObject2).isGameRoom))
    {
      paramView = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
      paramView.jdField_c_of_type_JavaLangString = ((HotChatInfo)localObject2).troopCode;
      paramView.jdField_d_of_type_JavaLangString = localChatMessage.frienduin;
      paramView.jdField_h_of_type_Int = 113;
      ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, paramView);
      HotChatManager.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004))
    {
      bool1 = ((FriendsManager)localObject4).b(localChatMessage.senderuin);
      localObject3 = localChatMessage.senderuin;
      label1773:
      if (localObject3 == null) {
        break label2066;
      }
      if (!((FriendsManager)localObject4).b((String)localObject3)) {
        break label3620;
      }
      bool1 = true;
    }
    label1825:
    label3620:
    for (;;)
    {
      if (bool2)
      {
        localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
        if (((String)localObject3).equals(((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString)) {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = null;
        }
        ((ProfileActivity.AllInOne)localObject2).f = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        ((ProfileActivity.AllInOne)localObject2).jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020)) {
          break label3281;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_d_of_type_JavaLangString = localChatMessage.senderuin;
        label1900:
        ((ProfileActivity.AllInOne)localObject2).jdField_g_of_type_Int = 2;
        if (localChatMessage.istroop != 0) {
          break label3341;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 1;
        if ((localChatMessage.istroop != 1001) && (localChatMessage.istroop != 1010) && (localChatMessage.istroop != 10002)) {
          break label3457;
        }
        paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, NearbyPeopleProfileActivity.class);
        if (localChatMessage.istroop != 1001) {
          break label3391;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 10;
        paramView.putExtra("frome_where", 21);
        label1996:
        paramView.putExtra("AllInOne", (Parcelable)localObject2);
        if (!Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localObject3)) {
          break label3436;
        }
        paramView.putExtra("param_mode", 2);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          break label3448;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 9009);
        return;
        localObject3 = localChatMessage.frienduin;
        bool1 = false;
        break label1773;
        break label11;
        if (localChatMessage.istroop == 1008)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("need_finish", true);
          ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          PublicAccountUtil.a((Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 2000, 2, PublicAccountUtil.jdField_a_of_type_Boolean);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          CrmUtils.a(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, -1, true, 2000);
          return;
        }
        if (bool1)
        {
          if (localChatMessage.istroop == 1) {
            localObject2 = new ProfileActivity.AllInOne((String)localObject3, 20);
          }
          for (;;)
          {
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3);
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
          break label1825;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 42);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 10002)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 86);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 10004)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 94);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
        {
          localObject2 = new ProfileActivity.AllInOne((String)localObject3, 70);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3);
          break label1825;
        }
        if (localChatMessage.istroop == 1000)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 22);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1020)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 58);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 21);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, localChatMessage.senderuin);
          break label1825;
        }
        if (3000 == localChatMessage.istroop)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 46);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.frienduin, localChatMessage.senderuin);
          break label1825;
        }
        if (localChatMessage.istroop == 1001)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 42);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 10002)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 86);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1004)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 47);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1005)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 2);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1023)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 74);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 57);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1006)
        {
          localObject2 = new ProfileActivity.AllInOne(localChatMessage.frienduin, 34);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1009)
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 57);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1021)
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 72);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1029)
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 93);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
        }
        if (localChatMessage.istroop == 1022)
        {
          localObject2 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 27);
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
          break label1825;
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
        localObject2 = new ProfileActivity.AllInOne(localChatMessage.senderuin, 19);
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
        break label1825;
        label3281:
        if (localChatMessage.istroop == 1)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
          ((ProfileActivity.AllInOne)localObject2).jdField_c_of_type_JavaLangString = localChatMessage.frienduin;
          break label1900;
        }
        if (3000 != localChatMessage.istroop) {
          break label1900;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        break label1900;
        if (localChatMessage.istroop == 3000)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 107;
          break label1920;
        }
        if (localChatMessage.istroop == 1)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 108;
          break label1920;
        }
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 106;
        break label1920;
        label3391:
        if (localChatMessage.istroop == 1010)
        {
          ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 11;
          break label1996;
        }
        if (localChatMessage.istroop != 10002) {
          break label1996;
        }
        paramView.putExtra("frome_where", 22);
        break label1996;
        label3436:
        paramView.putExtra("param_mode", 3);
      }
      label3448:
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      if ((bool2) && (localChatMessage.istroop == 1029)) {
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 111;
      }
      if ((!bool2) && (!((FriendsManager)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        localObject3 = StrangerChatPie.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, bool1, bool2);
        if (localObject3 == null) {
          break label3548;
        }
        ((ProfileActivity.AllInOne)localObject2).a.putSerializable("param_wzry_data", (Serializable)localObject3);
      }
      for (;;)
      {
        ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
        return;
        label3548:
        if (!android.text.TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("msg_ext_key")))
        {
          localObject3 = localChatMessage.senderuin;
          localObject3 = KplRoleInfo.WZRYUIinfo.createInfo((String)localObject3, KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, KplRoleInfo.getGameNickByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3)), KplRoleInfo.getKplVerifyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0, 0);
          ((ProfileActivity.AllInOne)localObject2).a.putSerializable("param_wzry_data", (Serializable)localObject3);
        }
      }
    }
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (!c())
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
        ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().h(paramChatMessage);
      }
      if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
      {
        paramChatMessage = (MessageForStructing)paramChatMessage;
        if ((paramChatMessage.structingMsg != null) && (paramChatMessage.structingMsg.mMsgServiceID == 81)) {
          StoryReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, "reply");
        }
      }
    }
  }
  
  protected void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((ConfessMsgUtil.a(paramChatMessage)) && (QLog.isColorLevel())) {
      QLog.d("ChatItemBuilder", 2, "confessType =  " + paramChatMessage.istroop + " isSend = " + paramChatMessage.isSend());
    }
    int i;
    if (ConfessMsgUtil.a(paramChatMessage)) {
      if (((ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268)).a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.getConfessTopicId()).confessorSex == 1)
      {
        i = 2130842339;
        paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setTag(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnClickListener(null);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnLongClickListener(null);
      }
    }
    for (;;)
    {
      return;
      i = 2130842338;
      break;
      Object localObject1;
      Object localObject2;
      if (AnonymousChatHelper.a(paramChatMessage))
      {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841215);
        localObject2 = AnonymousChatHelper.a(paramChatMessage);
        paramChatMessage = URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject2).jdField_b_of_type_Int), (Drawable)localObject1, (Drawable)localObject1);
        localObject1 = ((AnonymousChatHelper.AnonymousExtInfo)localObject2).jdField_c_of_type_JavaLangString;
        if (android.text.TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
      try
      {
        i = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        paramChatMessage.setTag(new int[] { Color.parseColor((String)localObject1), i });
        paramChatMessage.setDecodeHandler(URLDrawableDecodeHandler.l);
        label246:
        paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnClickListener(this);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnLongClickListener(null);
        return;
        if (((paramChatMessage instanceof MessageForStructing)) && (TroopBindPublicAccountMgr.a(paramChatMessage)))
        {
          paramBaseChatItemLayout.setHeaderIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839200));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnClickListener(this);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnLongClickListener(null);
          return;
        }
        localObject1 = TroopBusinessUtil.a(paramChatMessage);
        if (localObject1 != null)
        {
          paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839128);
          paramChatMessage = URLDrawable.getDrawable(((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_a_of_type_JavaLangString, paramChatMessage, paramChatMessage);
          paramChatMessage.setTag(URLDrawableDecodeHandler.a(100, 100, 6));
          paramChatMessage.setDecodeHandler(URLDrawableDecodeHandler.a);
          paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnClickListener(this);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnLongClickListener(null);
          return;
        }
        int k = paramChatMessage.istroop;
        String str;
        label584:
        int j;
        if (paramChatMessage.isSend())
        {
          str = paramChatMessage.selfuin;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, false);
          if ((localObject1 != null) && (((ExtensionInfo)localObject1).faceIdUpdateTime < paramChatMessage.time))
          {
            localObject2 = paramChatMessage.getExtInfoFromExtStr("vip_face_id");
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id = " + (String)localObject2);
            }
            if ((!android.text.TextUtils.isEmpty((CharSequence)localObject2)) && (Long.parseLong((String)localObject2) != ((ExtensionInfo)localObject1).faceId))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id not equals local");
              }
              AvatarPendantUtil.a(str);
              AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
          if ((localObject2 == null) || (!((HotChatManager)localObject2).b(paramChatMessage.frienduin))) {
            break label1131;
          }
          i = 1;
          if ((localObject1 == null) || (!((FriendsManager)localObject1).b(str))) {
            break label1136;
          }
          j = 1;
          label602:
          if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) && ((k != 1022) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 4007) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 3019) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int != 2019)))) || (localObject1 == null) || (((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label1178;
          }
          localObject2 = ((HotChatManager)localObject2).a(paramChatMessage.frienduin);
          if ((localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
            break label1160;
          }
          if ((!((FriendsManager)localObject1).b(str)) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            break label1142;
          }
          localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
          label804:
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + str);
            localObject1 = localObject2;
          }
          label846:
          paramBaseChatItemLayout.setHeaderIcon(localObject1);
          if ((paramChatMessage.isSendFromLocal()) || ((k != 1) && (k != 3000))) {
            break label1387;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin))
          {
            localObject1 = paramChatMessage.frienduin;
            localObject2 = paramChatMessage.senderuin;
            ThreadManager.executeOnSubThread(new uhe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, (String)localObject1, (String)localObject2, k, this.jdField_a_of_type_AndroidViewView$OnLongClickListener));
          }
          label931:
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnClickListener(this);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setTag(paramChatMessage);
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "AppSetting.enableTalkBack = " + AppSetting.jdField_b_of_type_Boolean);
          }
          if (!AppSetting.jdField_b_of_type_Boolean) {
            continue;
          }
          localObject2 = "";
          localObject1 = localObject2;
          if (paramChatMessage.istroop != 1)
          {
            localObject1 = localObject2;
            if (paramChatMessage.istroop != 3000) {
              if (!paramChatMessage.isSend()) {
                break label1398;
              }
            }
          }
        }
        label1131:
        label1136:
        label1142:
        label1398:
        for (localObject1 = "我的资料卡";; localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString + "资料卡")
        {
          if (paramChatMessage.msgtype == -3006) {
            localObject1 = String.format(paramBaseChatItemLayout.getResources().getString(2131430763), new Object[] { PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setContentDescription((CharSequence)localObject1);
          return;
          if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
          {
            str = paramChatMessage.frienduin;
            break;
          }
          str = paramChatMessage.senderuin;
          break;
          i = 0;
          break label584;
          j = 0;
          break label602;
          localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, str, true);
          break label804;
          localObject2 = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, str, true);
          break label804;
          if ((k == 9501) && (!paramChatMessage.isSend()))
          {
            localObject1 = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(str));
            if ((localObject1 != null) && (str.equals(String.valueOf(((DeviceInfo)localObject1).din))))
            {
              localObject1 = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.getInstance().getDeviceHeadByDin(str));
              break label846;
            }
            localObject1 = a(paramBaseChatItemLayout, 1, str);
            break label846;
          }
          i = 1;
          if (k == 1006) {
            i = 11;
          }
          localObject1 = a(paramBaseChatItemLayout, i, str);
          localObject2 = new DynamicFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Drawable)localObject1, i, 200, str, 100, false, null, true, true, false, false, 8, paramChatMessage.uniseq);
          ((DynamicFaceDrawable)localObject2).jdField_e_of_type_JavaLangString = paramChatMessage.getSummaryMsg();
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label846;
          }
          QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + str);
          localObject1 = localObject2;
          break label846;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnLongClickListener(null);
          break label931;
        }
      }
      catch (Exception localException)
      {
        label1160:
        label1178:
        label1387:
        break label246;
      }
    }
  }
  
  public void b(QQCustomMenu paramQQCustomMenu, Context paramContext)
  {
    if ((b()) && (MultiMsgManager.a().a())) {
      paramQQCustomMenu.a(2131375346, paramContext.getString(2131433744), 2130838316);
    }
  }
  
  protected boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
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
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
  }
  
  public void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localChatMessage != null) && (localChatMessage.istroop == 1))
    {
      localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localObject1 == null) || (!((TroopInfo)localObject1).isQidianPrivateTroop())) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = TroopBusinessUtil.a(localChatMessage);
            if (localObject1 == null) {
              break;
            }
            TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TroopBusinessUtil.TroopBusinessMessage)localObject1);
            paramView = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_c_of_type_JavaLangString;
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, localChatMessage.frienduin, "", paramView, "");
          } while (localChatMessage.msgtype != -2051);
          try
          {
            paramView = (MessageForQQStory)localChatMessage;
            paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView.msgAction);
            QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_name", paramView, false);
            return;
          }
          catch (Exception paramView) {}
        } while (!QLog.isColorLevel());
        QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramView);
        return;
      } while ((localChatMessage == null) || (localChatMessage.istroop != 1) || (!Utils.d(localChatMessage.senderuin)));
      localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((HotChatManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (localObject1 == null) {
        break label444;
      }
    } while ((((HotChatInfo)localObject1).isGameRoom) || ((((HotChatInfo)localObject1).isRobotHotChat) && (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin)))));
    Object localObject1 = localChatMessage.senderuin;
    paramView = NearbyURLSafeUtil.a((String)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)) {}
    for (paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramView;; paramView = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747")
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject1)) {}
      for (localObject1 = "2";; localObject1 = "1")
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject1, "", "", "");
        localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        return;
        localObject1 = null;
        break;
      }
      label444:
      if (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin))) {
        break;
      }
      Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int i;
      label538:
      Object localObject3;
      if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
      {
        i = paramView.getId();
        if (i == 2131361867)
        {
          localObject1 = "clk_title";
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
          localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
          if (i != 2131361867) {
            break label980;
          }
          i = 2;
          localObject1 = "Clk_label";
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = Base64.a(((String)localObject3).getBytes("UTF-8"), 0);
          Object localObject4 = TroopLinkManager.a();
          if (i == 2)
          {
            localObject3 = "troop_unique_title";
            localObject3 = ((TroopLinkManager)localObject4).a((String)localObject3);
            if (!android.text.TextUtils.isEmpty((CharSequence)localObject3)) {
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
            ((Intent)localObject3).putExtra("selfSet_leftViewText", "返回");
            paramView.startActivity((Intent)localObject3);
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            localObject4 = localChatMessage.frienduin;
            if (!localChatMessage.isSend()) {
              continue;
            }
            paramView = "1";
            ReportController.b((QQAppInterface)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, (String)localObject4, paramView, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
            }
            if (this.jdField_b_of_type_Int < 2) {
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_b_of_type_Int), "", "");
            return;
            localObject1 = "clk_nickname";
            break label538;
            label980:
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
          TroopLinkManager.LinkParams localLinkParams = new TroopLinkManager.LinkParams();
          localLinkParams.jdField_a_of_type_JavaLangString = localChatMessage.frienduin;
          localLinkParams.jdField_b_of_type_JavaLangString = localChatMessage.senderuin;
          localLinkParams.jdField_e_of_type_JavaLangString = ((String)localObject2);
          localLinkParams.jdField_d_of_type_JavaLangString = ("" + i);
          localLinkParams.jdField_c_of_type_JavaLangString = "aio";
          localObject2 = localException.a((String)localObject3, localLinkParams);
          continue;
          paramView = "0";
          continue;
        }
        if (this.c)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick, openLevelPKPage");
          }
          localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", "http://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=" + localChatMessage.frienduin + "&target=" + localChatMessage.senderuin);
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("hide_more_button", true);
          paramView.getContext().startActivity((Intent)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
        }
      }
    }
  }
  
  public void c(ChatMessage paramChatMessage)
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
      localObject = localFragmentActivity.getChatFragment().a();
      ((BaseChatPie)localObject).g(paramChatMessage);
      ((BaseChatPie)localObject).g(true);
      SpriteCommFunc.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", true);
    } while (paramChatMessage == null);
    int j;
    int i;
    if (paramChatMessage.istroop == 0)
    {
      j = 1;
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label269;
      }
      i = 6;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, "" + i, "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + j, "", "", "");
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
      label269:
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
  
  public void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramChatMessage);
    paramBaseChatItemLayout.setProgressVisable(bool);
    if (!bool) {
      d(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  public boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).jdField_a_of_type_Boolean))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131430256, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return true;
    }
    return false;
  }
  
  public void d() {}
  
  public void d(ChatMessage paramChatMessage) {}
  
  protected void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setNetIconVisible(paramChatMessage.isSentByXG());
  }
  
  public void onClick(View paramView)
  {
    if (a()) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity));
      AIOUtils.m = true;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131361863: 
        b(paramView);
        return;
      case 2131361876: 
        a(paramView);
        return;
      case 2131361867: 
      case 2131361868: 
      case 2131361871: 
      case 2131361872: 
      case 2131361874: 
        c(paramView);
        return;
      case 2131362398: 
      case 2131362400: 
        localChatMessage = (ChatMessage)paramView.getTag();
      }
    } while (localChatMessage == null);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      localObject = GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramView = (View)localObject;
      if (!localChatMessage.isSend())
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.singleaio.showdetail", 0, 0, "", "", "", "");
        paramView = (View)localObject;
      }
    }
    while (!android.text.TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
      {
        if (!a(localChatMessage, null)) {}
        for (localObject = GoldMsgChatHelper.a().a(localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
        {
          paramView = (View)localObject;
          if (localChatMessage.isSend()) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "goldmsg.groupaio.showdetail", 0, 0, "", "", "", "");
          paramView = (View)localObject;
          break;
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a(paramView.getContext(), null);
          return;
        }
      }
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */