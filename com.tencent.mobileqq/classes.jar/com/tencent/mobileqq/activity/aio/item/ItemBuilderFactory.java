package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder;
import com.tencent.device.msg.activities.DevShortVideoItemBuilder;
import com.tencent.device.msg.activities.DevicePttItemBuilder;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.TroopConfessItemBuilder;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForDingdongSchedule;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageForVideoVip;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ItemBuilderFactory
{
  private Context jdField_a_of_type_AndroidContentContext;
  DevLittleVideoItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder;
  DevShortVideoItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder;
  DevicePttItemBuilder jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  ActivityChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder;
  ApolloGameItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloGameItemBuilder;
  ApolloItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder;
  AppSharePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder;
  ApprovalMsgBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder;
  ArkAppBabyQItemBubbleBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder;
  ArkAppBabyQNoResultBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder;
  ArkAppItemBubbleBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder;
  ArkAppItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder;
  ArkAppShareMultiItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder;
  ArkFlashChatItemBubbleBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkFlashChatItemBubbleBuilder;
  CommonHobbyForAIOShowItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder;
  ConfessNewsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemConfessNewsItemBuilder;
  DeviceFileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder;
  DevicePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder;
  DeviceSingleStructBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder;
  DeviceTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder;
  DingdongScheduleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder;
  EnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder;
  FileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder;
  FilePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder;
  FileTimDocGrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFileTimDocGrayTipsItemBuilder;
  FileVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder;
  FlashPicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder;
  FoldMsgGrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder;
  GivingHeartItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder;
  GoldMsgPttItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgPttItemBuilder;
  GoldMsgTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgTextItemBuilder;
  GrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder;
  HiBoomItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemHiBoomItemBuilder;
  LocationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder;
  LongMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder;
  LongTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder;
  MarketFaceItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder;
  MedalNewsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMedalNewsItemBuilder;
  MixedMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder;
  MyEnterTroopChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder;
  PAMultiItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder;
  PASingleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder;
  PATextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder;
  PLNewsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPLNewsItemBuilder;
  PicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder;
  PokeEmoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder;
  PttItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder;
  QQStoryCommentItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder;
  private QQStoryFeedItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder;
  QQStoryItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder;
  QQWalletMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder;
  QQWalletTransMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTransMsgItemBuilder;
  QzoneFeedItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder;
  ReplyTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder;
  RichStatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder;
  ScribbleItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder;
  ShakeItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder;
  ShortVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder;
  ShortVideoPTVItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder;
  ShortVideoRealItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder;
  StructTroopNotificationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder;
  StructingMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder;
  TextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder;
  TextTranslationItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder;
  ThumbItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder;
  TimDouFuGuideItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTimDouFuGuideItemBuilder;
  TribeShortVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder;
  TroopEffectPicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopEffectPicItemBuilder;
  TroopFeeMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder;
  TroopFileItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder;
  TroopFilePicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFilePicItemBuilder;
  TroopFileVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileVideoItemBuilder;
  TroopGiftMsgItemBuilder.TroopGiftMsgItemRecieverBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder;
  TroopGiftMsgItemBuilder.TroopGiftMsgItemSenderBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder;
  TroopLineTipsChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopLineTipsChatItemBuilder;
  TroopPobingItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder;
  TroopSignItemBuilder.TroopSignPicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignPicItemBuilder;
  TroopSignItemBuilder.TroopSignVideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder;
  TroopStoryItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopStoryItemBuilder;
  TroopUnreadTipsChatItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder;
  TroopWantGiftItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder;
  VIPDonateMsgItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder;
  VideoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder;
  VideoVipItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopConfessItemBuilder jdField_a_of_type_ComTencentMobileqqConfessTroopConfessItemBuilder;
  UniteGrayTipItemBuilder jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder;
  private Set jdField_a_of_type_JavaUtilSet;
  ConfessNewsItemBuilder b;
  
  public ItemBuilderFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  private ChatItemBuilder a(ChatItemBuilder paramChatItemBuilder, BaseAdapter paramBaseAdapter)
  {
    if (((paramChatItemBuilder instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof ChatAdapter1)))
    {
      paramBaseAdapter = (ChatAdapter1)paramBaseAdapter;
      ((BaseBubbleBuilder)paramChatItemBuilder).a(paramBaseAdapter.a);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramChatItemBuilder);
    return paramChatItemBuilder;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    int j = 15;
    int i;
    if ((paramChatMessage instanceof MessageForText)) {
      if (GoldMsgChatHelper.c(paramChatMessage)) {
        i = 91;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return i;
                    if ((paramChatMessage instanceof MessageForLongTextMsg)) {
                      return 63;
                    }
                    if ((paramChatMessage instanceof MessageForWantGiftMsg)) {
                      return 72;
                    }
                    if (((MessageForText)paramChatMessage).locationUrl != null) {
                      return 10;
                    }
                    if ((paramChatMessage.vipBubbleID != 100000L) || (paramChatMessage.isSend())) {
                      break label1315;
                    }
                    return 9;
                    if ((paramChatMessage instanceof MessageForTroopGift))
                    {
                      if (((MessageForTroopGift)paramChatMessage).senderUin == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
                        return 48;
                      }
                      return 49;
                    }
                    if ((paramChatMessage instanceof MessageForWantGiftMsg)) {
                      return 72;
                    }
                    if (!(paramChatMessage instanceof MessageForGrayTips)) {
                      break;
                    }
                    i = j;
                  } while (paramChatMessage.msgtype != -3016);
                  return 95;
                  i = j;
                } while ((paramChatMessage instanceof MessageForNewGrayTips));
                i = j;
              } while ((paramChatMessage instanceof MessageForSafeGrayTips));
              i = j;
            } while ((paramChatMessage instanceof MessageForIncompatibleGrayTips));
            i = j;
          } while ((paramChatMessage instanceof MessageForNearbyMarketGrayTips));
          if ((paramChatMessage instanceof MessageForTroopEffectPic)) {
            return 80;
          }
          if ((paramChatMessage instanceof MessageForPic))
          {
            if (((MessageForPic)paramChatMessage).isMixed) {
              return 24;
            }
            if (HotChatHelper.a(paramChatMessage)) {
              return 42;
            }
            if (FlashPicHelper.a(paramChatMessage)) {
              return 66;
            }
            return 1;
          }
          if ((paramChatMessage instanceof MessageForDevPtt)) {
            return 33;
          }
          if ((paramChatMessage instanceof MessageForPtt))
          {
            if (GoldMsgChatHelper.c(paramChatMessage)) {
              return 92;
            }
            return 2;
          }
          if ((paramChatMessage instanceof MessageForFile))
          {
            paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
            if ((paramChatMessage != null) && (paramChatMessage.cloudType != 0))
            {
              i = FileManagerUtil.a(paramChatMessage.fileName);
              if (i == 0) {
                return 61;
              }
              if (i == 2) {
                return 65;
              }
            }
            return 3;
          }
          if ((paramChatMessage instanceof MessageForVideo)) {
            return 11;
          }
          if ((paramChatMessage instanceof MessageForMarketFace)) {
            return 12;
          }
          if ((paramChatMessage instanceof MessageForRichState)) {
            return 13;
          }
          if ((paramChatMessage instanceof MessageForPubAccount))
          {
            paramChatMessage = ((MessageForPubAccount)paramChatMessage).mPAMessage;
            if ((paramChatMessage != null) && (paramChatMessage.items != null) && (paramChatMessage.items.size() != 0))
            {
              if (((PAMessage.Item)paramChatMessage.items.get(0)).cover != null)
              {
                if (paramChatMessage.items.size() == 1) {
                  return 6;
                }
                if (paramChatMessage.items.size() < 2) {
                  break;
                }
                return 7;
              }
              return 8;
            }
            return 0;
          }
          if ((paramChatMessage instanceof MessageForQQStory)) {
            return 67;
          }
          if ((paramChatMessage instanceof MessageForTribeShortVideo)) {
            return 89;
          }
          if ((paramChatMessage instanceof MessageForTroopPobing)) {
            return 77;
          }
          if ((paramChatMessage instanceof MessageForTroopSign))
          {
            if (TextUtils.isEmpty(((MessageForTroopSign)paramChatMessage).dynamicSource)) {
              return 71;
            }
            return 84;
          }
          if ((paramChatMessage instanceof MessageForTroopNotification)) {
            return 28;
          }
          if ((paramChatMessage instanceof MessageForTroopTopic)) {
            return 53;
          }
          if ((paramChatMessage instanceof MessageForStructing)) {
            return 5;
          }
          if ((paramChatMessage instanceof MessageForFunnyFace)) {
            return 19;
          }
          if (((paramChatMessage instanceof MessageForLongMsg)) && (paramChatMessage.msgtype != -1036)) {
            return 17;
          }
          if (((paramChatMessage instanceof MessageForMixedMsg)) || ((paramChatMessage != null) && (paramChatMessage.msgtype == -1036))) {
            return 18;
          }
          if ((paramChatMessage instanceof MessageForQzoneFeed)) {
            return 21;
          }
          if ((paramChatMessage instanceof MessageForPLNews)) {
            return 79;
          }
          if ((paramChatMessage instanceof MessageForMedalNews)) {
            return 86;
          }
          if ((paramChatMessage instanceof MessageForConfessCard)) {
            return 94;
          }
          if ((paramChatMessage instanceof MessageForConfessNews)) {
            return 93;
          }
          if ((paramChatMessage instanceof MessageForTroopConfess)) {
            return 99;
          }
          if ((paramChatMessage instanceof MessageForActivity)) {
            return 16;
          }
          if ((paramChatMessage instanceof MessageForEnterTroop)) {
            return 22;
          }
          if ((paramChatMessage instanceof MessageForMyEnterTroop)) {
            return 23;
          }
          if ((paramChatMessage instanceof MessageForTroopFile))
          {
            if (TroopFileItemBuilder.d(paramChatMessage)) {
              return 69;
            }
            if (TroopFileItemBuilder.b(paramChatMessage)) {
              return 97;
            }
            return 25;
          }
          if ((paramChatMessage instanceof MessageForShakeWindow)) {
            return 26;
          }
          if ((paramChatMessage instanceof MessageForTroopUnreadTips)) {
            return 27;
          }
          if ((paramChatMessage instanceof MessageForSplitLineTips)) {
            return 70;
          }
          if ((paramChatMessage instanceof MessageForDevShortVideo)) {
            return 35;
          }
          if ((paramChatMessage instanceof MessageForDevLittleVideo)) {
            return 45;
          }
          if ((paramChatMessage instanceof MessageForShortVideo))
          {
            switch (((MessageForShortVideo)paramChatMessage).busiType)
            {
            default: 
              return 29;
            case 0: 
              return 29;
            case 1: 
              return 38;
            case 2: 
              return 46;
            case 1007: 
              return 40;
            }
            return 41;
          }
          if ((paramChatMessage instanceof MessageForColorRing)) {
            return 31;
          }
          if ((paramChatMessage instanceof MessageForQQWalletMsg))
          {
            if (QWalletRedPkgUtils.a((MessageForQQWalletMsg)paramChatMessage)) {
              return 32;
            }
            return 90;
          }
          if ((paramChatMessage instanceof MessageForTroopFee)) {
            return 44;
          }
          if ((paramChatMessage instanceof MessageForDeviceFile))
          {
            paramChatMessage = (MessageForDeviceFile)paramChatMessage;
            if (paramChatMessage.nFileMsgType == 2) {
              return 36;
            }
            if (paramChatMessage.nFileMsgType != 1) {
              break;
            }
            return 37;
          }
          if ((paramChatMessage instanceof MessageForDeviceSingleStruct)) {
            return 34;
          }
          i = j;
        } while ((paramChatMessage instanceof MessageForQQWalletTips));
        if ((paramChatMessage instanceof MessageForDeviceText)) {
          return 39;
        }
        i = j;
      } while ((paramChatMessage instanceof ShareHotChatGrayTips));
      i = j;
    } while ((paramChatMessage instanceof MessageForDeliverGiftTips));
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
      localConfig.fromString(paramChatMessage.ark_app_message.config);
      if ((localConfig.type != null) && (localConfig.type.equals("card"))) {
        return 81;
      }
      return 47;
    }
    if ((paramChatMessage instanceof MessageForArkBabyqReply))
    {
      paramChatMessage = (MessageForArkBabyqReply)paramChatMessage;
      if ((paramChatMessage.mArkBabyqReplyCardList == null) || (paramChatMessage.mArkBabyqReplyCardList.size() <= 0)) {
        return 83;
      }
      return 82;
    }
    if ((paramChatMessage instanceof MessageForArkFlashChat)) {
      return 76;
    }
    if ((paramChatMessage instanceof MessageForApollo))
    {
      if (ApolloGameUtil.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == ApolloGameUtil.c) {
        return 88;
      }
      return 56;
    }
    if ((paramChatMessage instanceof MessageForReplyText)) {
      return 50;
    }
    if ((paramChatMessage instanceof MessageForApproval)) {
      return 52;
    }
    if ((paramChatMessage instanceof MessageForTroopReward))
    {
      if (paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        return 59;
      }
      return 60;
    }
    if ((paramChatMessage instanceof MessageForDingdongSchedule)) {
      return 55;
    }
    if ((paramChatMessage instanceof MessageForVideoVip)) {
      return 54;
    }
    if ((paramChatMessage instanceof MessageForVIPDonate)) {
      return 58;
    }
    if ((paramChatMessage instanceof MessageForFoldMsgGrayTips)) {
      return 57;
    }
    if ((paramChatMessage instanceof MessageForPoke))
    {
      paramChatMessage = (MessageForPoke)paramChatMessage;
      if ((paramChatMessage.interactType == 126) && (!PokeItemHelper.a(paramChatMessage.minVersion))) {
        return 0;
      }
      return 62;
    }
    if ((paramChatMessage instanceof MessageForPokeEmo)) {
      return 98;
    }
    if ((paramChatMessage instanceof MessageForUniteGrayTip)) {
      return 64;
    }
    if ((paramChatMessage instanceof MessageForQQStoryComment)) {
      return 68;
    }
    if ((paramChatMessage instanceof MessageForTroopStory)) {
      return 73;
    }
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      if (HiBoomFont.a().a()) {
        return 78;
      }
      return 0;
    }
    if ((paramChatMessage instanceof MessageForScribble)) {
      return 75;
    }
    if ((paramChatMessage instanceof MessageForQQStoryFeed)) {
      return 87;
    }
    if ((paramChatMessage instanceof MessageForTimDouFuGuide)) {
      return 85;
    }
    if ((paramChatMessage instanceof MessageForCommonHobbyForAIOShow)) {
      return 96;
    }
    label1315:
    return 0;
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: message = " + paramChatMessage);
    }
    switch (a(paramChatMessage))
    {
    case 4: 
    case 14: 
    case 19: 
    case 20: 
    case 30: 
    case 43: 
    case 51: 
    case 59: 
    case 60: 
    case 74: 
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder = new TextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder, paramBaseAdapter);
    case 61: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder = new FilePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFilePicItemBuilder, paramBaseAdapter);
    case 65: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder = new FileVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileVideoItemBuilder, paramBaseAdapter);
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder = new FileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileItemBuilder, paramBaseAdapter);
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder = new PicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPicItemBuilder, paramBaseAdapter);
    case 24: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder = new AppSharePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemAppSharePicItemBuilder, paramBaseAdapter);
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder = new PttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPttItemBuilder, paramBaseAdapter);
    case 33: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder = new DevicePttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePttItemBuilder");
      }
      return a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevicePttItemBuilder, paramBaseAdapter);
    case 15: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder = new GrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder, paramBaseAdapter);
    case 72: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder = new TroopWantGiftItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopWantGiftItemBuilder, paramBaseAdapter);
    case 6: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder = new PASingleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPASingleItemBuilder, paramBaseAdapter);
    case 7: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder = new PAMultiItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPAMultiItemBuilder, paramBaseAdapter);
    case 8: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder = new PATextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPATextItemBuilder, paramBaseAdapter);
    case 5: 
    case 53: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder = new StructingMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder, paramBaseAdapter);
    case 10: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder = new LocationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLocationItemBuilder, paramBaseAdapter);
    case 11: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder = new VideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoItemBuilder, paramBaseAdapter);
    case 13: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder = new RichStatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        paramChatMessage = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
        if (paramChatMessage != null) {
          paramChatMessage.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder);
        }
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemRichStatItemBuilder, paramBaseAdapter);
    case 9: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder = new TextTranslationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextTranslationItemBuilder, paramBaseAdapter);
    case 12: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder = new MarketFaceItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder, paramBaseAdapter);
    case 16: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder = new ActivityChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemActivityChatItemBuilder, paramBaseAdapter);
    case 22: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder = new EnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemEnterTroopChatItemBuilder, paramBaseAdapter);
    case 23: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder = new MyEnterTroopChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMyEnterTroopChatItemBuilder, paramBaseAdapter);
    case 17: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder = new LongMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongMsgItemBuilder, paramBaseAdapter);
    case 18: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder = new MixedMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMixedMsgItemBuilder, paramBaseAdapter);
    case 21: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder = new QzoneFeedItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: qzoneFeedItemBuilder = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder, paramBaseAdapter);
    case 79: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPLNewsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPLNewsItemBuilder = new PLNewsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPLNewsItemBuilder, paramBaseAdapter);
    case 86: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMedalNewsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMedalNewsItemBuilder = new MedalNewsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMedalNewsItemBuilder, paramBaseAdapter);
    case 96: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder = new CommonHobbyForAIOShowItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCommonHobbyForAIOShowItemBuilder, paramBaseAdapter);
    case 93: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemConfessNewsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemConfessNewsItemBuilder = new ConfessNewsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemConfessNewsItemBuilder, paramBaseAdapter);
    case 94: 
      if (this.b == null) {
        this.b = new ConfessNewsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.b, paramBaseAdapter);
    case 99: 
      if (this.jdField_a_of_type_ComTencentMobileqqConfessTroopConfessItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqConfessTroopConfessItemBuilder = new TroopConfessItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqConfessTroopConfessItemBuilder, paramBaseAdapter);
    case 25: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder = new TroopFileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileItemBuilder, paramBaseAdapter);
    case 69: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileVideoItemBuilder = new TroopFileVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFileVideoItemBuilder, paramBaseAdapter);
    case 97: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFilePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFilePicItemBuilder = new TroopFilePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFilePicItemBuilder, paramBaseAdapter);
    case 26: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder = new ShakeItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShakeItemBuilder, paramBaseAdapter);
    case 62: 
      paramChatMessage = (MessageForPoke)paramChatMessage;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder = new GivingHeartItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGivingHeartItemBuilder, paramBaseAdapter);
    case 98: 
      paramChatMessage = (MessageForPokeEmo)paramChatMessage;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder = new PokeEmoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPokeEmoItemBuilder, paramBaseAdapter);
    case 27: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder = new TroopUnreadTipsChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopUnreadTipsChatItemBuilder, paramBaseAdapter);
    case 70: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopLineTipsChatItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopLineTipsChatItemBuilder = new TroopLineTipsChatItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopLineTipsChatItemBuilder, paramBaseAdapter);
    case 28: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder = new StructTroopNotificationItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructTroopNotificationItemBuilder, paramBaseAdapter);
    case 29: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder = new ShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder, paramBaseAdapter);
    case 38: 
    case 40: 
    case 41: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder = new ShortVideoRealItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder, paramBaseAdapter);
    case 46: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder = new ShortVideoPTVItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoPTVItemBuilder, paramBaseAdapter);
    case 31: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder = new ThumbItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemThumbItemBuilder, paramBaseAdapter);
    case 32: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder = new QQWalletMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletMsgItemBuilder, paramBaseAdapter);
    case 90: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTransMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTransMsgItemBuilder = new QQWalletTransMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQWalletTransMsgItemBuilder, paramBaseAdapter);
    case 44: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder = new TroopFeeMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopFeeMsgItemBuilder, paramBaseAdapter);
    case 48: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder = new TroopGiftMsgItemBuilder.TroopGiftMsgItemSenderBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder, paramBaseAdapter);
    case 49: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder = new TroopGiftMsgItemBuilder.TroopGiftMsgItemRecieverBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder$TroopGiftMsgItemRecieverBuilder, paramBaseAdapter);
    case 35: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder = new DevShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder, paramBaseAdapter);
    case 45: 
      if (this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder = new DevLittleVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder, paramBaseAdapter);
    case 34: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder = new DeviceSingleStructBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceSingleItemBuilder");
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceSingleStructBuilder, paramBaseAdapter);
    case 36: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder = new DevicePicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DevicePicItemBuilder");
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder, paramBaseAdapter);
    case 37: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder = new DeviceFileItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ItemBuilder is: DeviceFileItemBuilder");
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceFileItemBuilder, paramBaseAdapter);
    case 39: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder = new DeviceTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder, paramBaseAdapter);
    case 42: 
    case 66: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder = new FlashPicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFlashPicItemBuilder, paramBaseAdapter);
    case 56: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder = new ApolloItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloItemBuilder, paramBaseAdapter);
    case 88: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloGameItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloGameItemBuilder = new ApolloGameItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApolloGameItemBuilder, paramBaseAdapter);
    case 47: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 9501))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder = new ArkAppItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
        return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder, paramBaseAdapter);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder = new ArkAppItemBubbleBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder, paramBaseAdapter);
    case 81: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder = new ArkAppShareMultiItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder, paramBaseAdapter);
    case 82: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder = new ArkAppBabyQItemBubbleBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQItemBubbleBuilder, paramBaseAdapter);
    case 83: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder = new ArkAppBabyQNoResultBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppBabyQNoResultBuilder, paramBaseAdapter);
    case 76: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkFlashChatItemBubbleBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkFlashChatItemBubbleBuilder = new ArkFlashChatItemBubbleBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkFlashChatItemBubbleBuilder, paramBaseAdapter);
    case 50: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder = new ReplyTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemReplyTextItemBuilder, paramBaseAdapter);
    case 52: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder = new ApprovalMsgBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemApprovalMsgBuilder, paramBaseAdapter);
    case 54: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder = new VideoVipItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVideoVipItemBuilder, paramBaseAdapter);
    case 55: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder = new DingdongScheduleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDingdongScheduleItemBuilder, paramBaseAdapter);
    case 58: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder = new VIPDonateMsgItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemVIPDonateMsgItemBuilder, paramBaseAdapter);
    case 57: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder = new FoldMsgGrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFoldMsgGrayTipsItemBuilder, paramBaseAdapter);
    case 63: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder = new LongTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLongTextItemBuilder, paramBaseAdapter);
    case 64: 
      if (this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder = new UniteGrayTipItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqGraytipUniteGrayTipItemBuilder, paramBaseAdapter);
    case 67: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder = new QQStoryItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder, paramBaseAdapter);
    case 89: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder = new TribeShortVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder, paramBaseAdapter);
    case 77: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder = new TroopPobingItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder, paramBaseAdapter);
    case 68: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder = new QQStoryCommentItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder, paramBaseAdapter);
    case 71: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignPicItemBuilder = new TroopSignItemBuilder.TroopSignPicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignPicItemBuilder, paramBaseAdapter);
    case 84: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder = new TroopSignItemBuilder.TroopSignVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopSignItemBuilder$TroopSignVideoItemBuilder, paramBaseAdapter);
    case 73: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopStoryItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopStoryItemBuilder = new TroopStoryItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopStoryItemBuilder, paramBaseAdapter);
    case 78: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHiBoomItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHiBoomItemBuilder = new HiBoomItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHiBoomItemBuilder, paramBaseAdapter);
    case 75: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder = new ScribbleItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemScribbleItemBuilder, paramBaseAdapter);
    case 80: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopEffectPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopEffectPicItemBuilder = new TroopEffectPicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopEffectPicItemBuilder, paramBaseAdapter);
    case 87: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder = new QQStoryFeedItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryFeedItemBuilder, paramBaseAdapter);
    case 85: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTimDouFuGuideItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTimDouFuGuideItemBuilder = new TimDouFuGuideItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTimDouFuGuideItemBuilder, paramBaseAdapter);
    case 91: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgTextItemBuilder = new GoldMsgTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgTextItemBuilder, paramBaseAdapter);
    case 92: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgPttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgPttItemBuilder = new GoldMsgPttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      return a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGoldMsgPttItemBuilder, paramBaseAdapter);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileTimDocGrayTipsItemBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileTimDocGrayTipsItemBuilder = new FileTimDocGrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemFileTimDocGrayTipsItemBuilder;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ChatItemBuilder)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */