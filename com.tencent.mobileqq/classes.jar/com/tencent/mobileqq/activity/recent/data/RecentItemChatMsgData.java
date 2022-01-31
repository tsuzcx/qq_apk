package com.tencent.mobileqq.activity.recent.data;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips;
import com.tencent.mobileqq.activity.aio.tips.PubAccountTips.PubAccountTipsMsg;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import xrx;
import xry;
import xrz;

public class RecentItemChatMsgData
  extends RecentUserBaseData
{
  private static MessageForRichState a;
  public String a;
  public long b;
  public long c;
  public boolean c;
  public long d;
  private boolean d;
  public long e;
  private boolean e;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public int p;
  public int q;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_e_of_type_Boolean = android.text.TextUtils.equals(paramRecentUser.uin, AppConstants.as);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_b_of_type_Int = 2;
    }
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131439001);
    if ((!paramMessageForStructing.isread) && (!android.text.TextUtils.isEmpty(str1))) {}
    for (this.jdField_d_of_type_JavaLangCharSequence = str2;; this.jdField_d_of_type_JavaLangCharSequence = "")
    {
      paramMessage.msg = str1;
      this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494324);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, QQMessageFacade.Message paramMessage)
  {
    if (a(paramMessage))
    {
      paramQQAppInterface = (FeedsManager)paramQQAppInterface.getManager(275);
      paramMessage = paramQQAppInterface.getSummary(a());
      if (!android.text.TextUtils.isEmpty(paramMessage))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.b = paramMessage;
        this.jdField_d_of_type_JavaLangCharSequence = "[新动态]";
        this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494324);
        if (!FeedsManager.isShowStatus(a())) {
          FeedsManager.showStatus(a());
        }
        paramQQAppInterface.reportExposeStatus(a());
      }
    }
    else
    {
      return;
    }
    FeedsManager.hideStatus(a());
  }
  
  private boolean a(FriendsManager paramFriendsManager, String paramString)
  {
    if ((paramFriendsManager == null) || (android.text.TextUtils.isEmpty(paramString))) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        return false;
        paramFriendsManager = paramFriendsManager.a(paramString);
      } while ((paramFriendsManager == null) || (!paramFriendsManager.isFriend()));
      bool1 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramFriendsManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  private boolean a(QQMessageFacade.Message paramMessage)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 0) && (android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) && (b() <= 0) && (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.jdField_a_of_type_Int == 0) && ((paramMessage == null) || (paramMessage.msgtype != -5040)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.jdField_c_of_type_JavaLangCharSequence == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentMsgSummary.jdField_a_of_type_JavaLangCharSequence == null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.jdField_d_of_type_Boolean = false;
    Object localObject4 = paramQQAppInterface.a();
    if (localObject4 != null) {}
    for (QQMessageFacade.Message localMessage = ((QQMessageFacade)localObject4).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localMessage = null)
    {
      Object localObject1 = paramQQAppInterface.a();
      MsgSummary localMsgSummary;
      int i1;
      if ((localObject1 != null) && (localMessage != null))
      {
        this.jdField_c_of_type_Int = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
        if (localMessage != null)
        {
          localObject1 = QCallFacade.a(paramQQAppInterface, localMessage.frienduin, localMessage.istroop, this.jdField_c_of_type_Int, localMessage);
          this.jdField_c_of_type_Int += ((QCallFacade.CallUnreadCountInfo)localObject1).a();
          if (((QCallFacade.CallUnreadCountInfo)localObject1).a() > 0)
          {
            this.jdField_d_of_type_JavaLangCharSequence = ((QCallFacade.CallUnreadCountInfo)localObject1).a();
            this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494294);
          }
        }
        FeedsManager.hideStatus(a());
        if (("2909288299".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (this.jdField_c_of_type_Int > 0))
        {
          localObject1 = localMessage.getExtInfoFromExtStr("news_has_report");
          if ((android.text.TextUtils.isEmpty((CharSequence)localObject1)) || (!"1".equals(localObject1)))
          {
            localMessage.saveExtInfoToExtStr("news_has_report", "1");
            ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007054", "0X8007054", 0, 0, "", "", "", "");
          }
        }
        localMsgSummary = a();
        i1 = 0;
      }
      label472:
      label616:
      int i;
      label516:
      label664:
      label688:
      label713:
      label993:
      Object localObject2;
      label640:
      label922:
      label940:
      label1077:
      label1219:
      label1225:
      label1358:
      long l1;
      label1182:
      label1353:
      label2298:
      Object localObject3;
      switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
      {
      default: 
      case 9501: 
        for (;;)
        {
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          if ((!localMsgSummary.jdField_a_of_type_Boolean) || (!this.jdField_d_of_type_Boolean)) {
            break label4777;
          }
          localMsgSummary.b = "";
          this.jdField_d_of_type_JavaLangCharSequence = "";
          a(paramQQAppInterface, paramContext, localMsgSummary);
          if (AppSetting.b)
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
            if (this.jdField_c_of_type_Int != 0) {
              break label4788;
            }
            if (this.jdField_d_of_type_JavaLangCharSequence != null) {
              paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
            }
            paramQQAppInterface.append(com.tencent.mobileqq.text.TextUtils.d(this.jdField_c_of_type_JavaLangCharSequence.toString())).append(",").append(this.jdField_c_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 0)
            {
              if (this.l != 1) {
                break label4857;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 59)).append(",");
              if (this.n != 1) {
                break label4885;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 5)).append(",");
              if (this.m != 1) {
                break label4913;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 3)).append(",");
              if (this.k != 1) {
                break label4940;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 1)).append(",");
              if (this.p != 1) {
                break label4967;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 36)).append(",");
            }
            this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
          }
          e();
          return;
          this.jdField_c_of_type_Int = 0;
          break;
          if (localMessage != null)
          {
            localMsgSummary.b = localMessage.msg;
            this.jdField_a_of_type_Long = localMessage.time;
            this.jdField_d_of_type_Int = 0;
            if ((localMessage.msgtype == -4502) && (localMessage.frienduin.equals(AppConstants.x))) {
              this.jdField_b_of_type_JavaLangString = "QQ物联";
            }
            for (;;)
            {
              if ((localMsgSummary.b == null) || (localMsgSummary.b.length() == 0)) {
                localMsgSummary.b = this.jdField_b_of_type_JavaLangString;
              }
              this.f = 1;
              if (localMessage.msgtype != -4500) {
                break label940;
              }
              localObject1 = new MessageForDeviceFile();
              ((MessageForDeviceFile)localObject1).msgData = localMessage.msgData;
              ((MessageForDeviceFile)localObject1).parse();
              if (((MessageForDeviceFile)localObject1).msgStatus != 1) {
                break label922;
              }
              localMsgSummary.jdField_a_of_type_Int = 2;
              break;
              localObject1 = ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(Long.parseLong(localMessage.frienduin));
              if (localObject1 != null) {
                this.jdField_b_of_type_JavaLangString = SmartDeviceUtil.a((DeviceInfo)localObject1);
              }
            }
            if (((MessageForDeviceFile)localObject1).msgStatus == 2)
            {
              localMsgSummary.jdField_a_of_type_Int = 1;
              continue;
              if (localMessage.msgtype == -4501)
              {
                localObject1 = new MessageForDevPtt();
                ((MessageForDevPtt)localObject1).msgData = localMessage.msgData;
                ((MessageForDevPtt)localObject1).parse();
                if (((MessageForDevPtt)localObject1).fileSize == -1L)
                {
                  localMsgSummary.jdField_a_of_type_Int = 2;
                  if (!"device_groupchat".equals(localMessage.extStr)) {
                    continue;
                  }
                  if (!localMessage.isSend()) {
                    break label1077;
                  }
                }
                for (localMessage.nickName = paramQQAppInterface.getApp().getString(2131433130);; localMessage.nickName = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, true))
                {
                  MsgUtils.a(paramContext, paramQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, localMessage.nickName, true, false);
                  break;
                  if (((MessageForDevPtt)localObject1).fileSize != -3L) {
                    break label993;
                  }
                  localMsgSummary.jdField_a_of_type_Int = 1;
                  break label993;
                }
              }
              else if (localMessage.msgtype == -4503)
              {
                localObject1 = new MessageForDevShortVideo();
                ((MessageForDevShortVideo)localObject1).msgData = localMessage.msgData;
                ((MessageForDevShortVideo)localObject1).parse();
                if (((MessageForDevShortVideo)localObject1).videoFileStatus == 1005)
                {
                  localMsgSummary.jdField_a_of_type_Int = 2;
                }
                else if (((MessageForDevShortVideo)localObject1).videoFileStatus == 1002)
                {
                  localObject1 = ((DeviceMsgHandle)paramQQAppInterface.a(49)).a();
                  if (localObject1 != null)
                  {
                    i = 1;
                    if (((DeviceAVFileMsgObserver)localObject1).a(localMessage.uniseq)) {
                      break label1219;
                    }
                  }
                  for (i1 = 1;; i1 = 0)
                  {
                    if ((i & i1) == 0) {
                      break label1225;
                    }
                    localMsgSummary.jdField_a_of_type_Int = 2;
                    break;
                    i = 0;
                    break label1182;
                  }
                  localMsgSummary.jdField_a_of_type_Int = 1;
                }
              }
              else if (localMessage.msgtype == -4509)
              {
                localObject1 = new MessageForDevLittleVideo();
                ((MessageForDevLittleVideo)localObject1).msgData = localMessage.msgData;
                ((MessageForDevLittleVideo)localObject1).parse();
                if (((MessageForDevLittleVideo)localObject1).videoFileStatus == 1005)
                {
                  localMsgSummary.jdField_a_of_type_Int = 2;
                }
                else if (((MessageForDevLittleVideo)localObject1).videoFileStatus == 1002)
                {
                  localObject2 = ((DeviceMsgHandle)paramQQAppInterface.a(49)).a();
                  if (!DeviceMsgChatPie.b((MessageRecord)localObject1)) {
                    if (localObject2 == null) {
                      break label1353;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if ((i & ((DeviceAVFileMsgObserver)localObject2).a(localMessage.uniseq)) == 0) {
                      break label1358;
                    }
                    localMsgSummary.jdField_a_of_type_Int = 1;
                    break;
                  }
                  localMsgSummary.jdField_a_of_type_Int = 2;
                }
              }
              else if (localMessage.msgtype == -4508)
              {
                if ("device_groupchat".equals(localMessage.extStr))
                {
                  if (localMessage.isSend()) {}
                  for (localMessage.nickName = paramQQAppInterface.getApp().getString(2131433130);; localMessage.nickName = ContactUtils.b(paramQQAppInterface, localMessage.senderuin, true))
                  {
                    MsgUtils.a(paramContext, paramQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, localMessage.nickName, true, false);
                    break;
                  }
                }
                MsgUtils.a(paramContext, paramQQAppInterface, localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, null, true, false);
              }
            }
          }
        }
      case 1008: 
        if (localMessage != null)
        {
          i = localMessage.msgtype;
          if ((i == -3006) || (i == -5004)) {
            break label2298;
          }
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((i == -2025) && (this.jdField_c_of_type_Int > 0) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
          {
            this.jdField_e_of_type_Int = -881592;
            this.jdField_d_of_type_JavaLangCharSequence = localMessage.msg;
            localMsgSummary.b = "";
          }
        }
        else
        {
          localObject1 = null;
          localObject2 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
          if (localObject2 != null) {
            localObject1 = ((PublicAccountDataManager)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          }
          if ((localObject1 == null) && (localObject2 != null))
          {
            localObject2 = ((PublicAccountDataManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            if (localObject2 != null) {
              this.jdField_b_of_type_JavaLangString = ((AccountDetail)localObject2).name;
            }
            if (this.jdField_e_of_type_Boolean) {
              this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.b(paramQQAppInterface, paramQQAppInterface.getApp());
            }
          }
          if (localObject1 == null) {
            break label2480;
          }
          this.jdField_b_of_type_JavaLangString = ((PublicAccountInfo)localObject1).name;
          if (((PublicAccountInfo)localObject1).certifiedGrade <= 0L) {
            break label2472;
          }
          this.jdField_d_of_type_Int = 2130839766;
          if ((localMessage == null) || (localMessage.getMessageText() == null)) {
            break label2488;
          }
          this.jdField_a_of_type_Long = localMessage.time;
          if ((!this.jdField_e_of_type_Boolean) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
          {
            i = paramQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
            if (this.jdField_c_of_type_Int > 0)
            {
              if ((this.jdField_c_of_type_Int != 1) || (i <= 0)) {
                break label2502;
              }
              this.jdField_b_of_type_Int = 2;
            }
          }
        }
        while (AppConstants.aI.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          for (;;)
          {
            WeishiReportUtil.a(this);
            break;
            this.jdField_d_of_type_JavaLangCharSequence = "";
            this.jdField_e_of_type_Int = 0;
            if (this.jdField_e_of_type_Boolean)
            {
              localObject1 = ((QQMessageFacade)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              if ((localObject1 == null) || (!(localObject1 instanceof MessageForStructing))) {
                break label1574;
              }
              localObject1 = (MessageForStructing)localObject1;
              if (((MessageForStructing)localObject1).structingMsg == null) {
                ((MessageForStructing)localObject1).parse();
              }
              long l2;
              if ((this.jdField_c_of_type_Int > 0) && (((MessageForStructing)localObject1).structingMsg != null) && (!android.text.TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mOrangeWord)))
              {
                if (((MessageForStructing)localObject1).structingMsg.mOrangeWord.length() >= 8)
                {
                  this.jdField_d_of_type_JavaLangCharSequence = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord.substring(0, 8) + "]");
                  this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494294);
                }
              }
              else
              {
                if ((((MessageForStructing)localObject1).extInt != 1) || (((MessageForStructing)localObject1).extLong != 1)) {
                  break label1574;
                }
                ((MessageForStructing)localObject1).extLong = 0;
                ThreadManager.post(new xrx(this, paramQQAppInterface, (MessageForStructing)localObject1), 8, null, false);
                l2 = -1L;
                l1 = l2;
                if (((MessageForStructing)localObject1).structingMsg != null)
                {
                  l1 = l2;
                  if (!android.text.TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgActionData))
                  {
                    localObject2 = PublicAccountUtil.a(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
                    l1 = l2;
                    if (localObject2 == null) {}
                  }
                }
              }
              try
              {
                l1 = Long.parseLong(((JSONObject)localObject2).getString("id"));
                if (l1 != -1L)
                {
                  PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F3", "0X80066F3", 0, 0, String.valueOf(this.i + 1), "", String.valueOf(l1), "", false);
                  PublicAccountReportUtils.a("0X80066F3", "", String.valueOf(this.i + 1), "", String.valueOf(l1), "");
                }
                if (((MessageForStructing)localObject1).structingMsg == null) {
                  break label1574;
                }
                PublicAccountUtil.a(paramQQAppInterface, (MessageForStructing)localObject1, 7);
                break label1574;
                this.jdField_d_of_type_JavaLangCharSequence = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord + "]");
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                  l1 = l2;
                }
              }
            }
          }
          localObject1 = PubAccountTips.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          if ((localObject1 == null) || (((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_d_of_type_Long != localMessage.uniseq) || (!((PubAccountTips.PubAccountTipsMsg)localObject1).b())) {
            break label1574;
          }
          ThreadManager.post(new xry(this, paramQQAppInterface, (PubAccountTips.PubAccountTipsMsg)localObject1), 2, null, false);
          break label1574;
          localMsgSummary.b = "";
          localObject3 = XMLMessageUtils.a(localMessage);
          if ((localObject3 == null) || (((PAMessage)localObject3).items == null) || (((PAMessage)localObject3).items.size() == 0))
          {
            a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            break label1574;
          }
          localObject1 = ((PAMessage.Item)((PAMessage)localObject3).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject3).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList != null)) {
            localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject3).items.get(0)).digestList.get(0);
          }
          for (;;)
          {
            localMsgSummary.b = ((CharSequence)localObject1);
            break;
          }
          this.jdField_d_of_type_Int = 0;
          break label1695;
          this.jdField_d_of_type_Int = 0;
          break label1695;
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
          break label1717;
          if (i > 0)
          {
            this.jdField_c_of_type_Int -= 1;
            this.jdField_b_of_type_Int = 1;
          }
        }
      case 1006: 
        label1574:
        label1717:
        label2488:
        label2502:
        localObject3 = ContactUtils.g(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        label1695:
        label2472:
        label2480:
        localObject1 = (PhoneContactManager)paramQQAppInterface.getManager(10);
        if (localObject1 == null) {
          break;
        }
      }
      for (localObject1 = ((PhoneContactManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);; localObject1 = null)
      {
        if (localObject1 != null) {
          this.jdField_b_of_type_JavaLangString = ((PhoneContact)localObject1).name;
        }
        for (;;)
        {
          a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localMessage == null) || ((localMessage.getMessageText() == null) && ((localMessage.msgtype != -2011) || (localMessage.msgData == null)))) {
            break label2677;
          }
          this.jdField_a_of_type_Long = localMessage.time;
          break;
          if (localObject3 != null) {
            this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, (String)localObject3, true);
          } else {
            this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
          }
        }
        label2677:
        this.jdField_a_of_type_Long = 0L;
        break;
        this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((localMessage != null) && ((localMessage.getMessageText() != null) || ((localMessage.msgtype == -2011) && (localMessage.msgData != null))))
        {
          this.jdField_a_of_type_Long = localMessage.time;
          break;
        }
        this.jdField_a_of_type_Long = 0L;
        break;
        boolean bool1 = QvipSpecialCareManager.a(paramQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((this.jdField_c_of_type_Int > 0) && (bool1))
        {
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131436900);
          this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494294);
        }
        if (0 == 0) {}
        for (localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);; localObject1 = null)
        {
          this.k = 0;
          this.l = 0;
          this.m = 0;
          this.n = 0;
          this.p = 0;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 0) && (((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
          {
            if (QIMUserManager.a().a(paramQQAppInterface) != 1) {
              break label3785;
            }
            i = 1;
            label2916:
            this.j = 0;
            if ((i != 0) && (QIMUserManager.a().a()))
            {
              localObject3 = ((FriendsManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              if ((localObject3 != null) && (((Friends)localObject3).netTypeIconId == 11))
              {
                this.j = 1;
                ThreadManager.post(new xrz(this, paramQQAppInterface), 5, null, true);
              }
            }
            boolean bool2 = ((FriendsManager)localObject1).c();
            if (!bool2)
            {
              localObject3 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              this.k = ((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject3, bool2);
              this.l = ((FriendsManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject3, bool2);
              this.m = ((FriendsManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject3, bool2);
              this.n = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject3, bool2);
              this.p = ((FriendsManager)localObject1).e(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject3, bool2);
              if (localObject3 != null)
              {
                this.jdField_b_of_type_Long = ((ExtensionInfo)localObject3).lastpraiseTime;
                this.jdField_c_of_type_Long = ((ExtensionInfo)localObject3).lastChatTime;
                this.jdField_d_of_type_Long = ((ExtensionInfo)localObject3).loverLastChatTime;
                this.jdField_e_of_type_Long = ((ExtensionInfo)localObject3).lastQzoneVisitTime;
                this.o = ((ExtensionInfo)localObject3).loverFlag;
                this.jdField_c_of_type_Boolean = ((ExtensionInfo)localObject3).loverTransFlag;
              }
            }
          }
          if (a((FriendsManager)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_b_of_type_Int = 4;
            label3189:
            if ((localMessage == null) || ((localMessage.getMessageText() == null) && (localMessage.msgData == null) && ((localMessage.msgtype != -2011) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)))) {
              break label3858;
            }
            this.jdField_a_of_type_Long = localMessage.time;
            i = i1;
            if (localMessage.msgtype == -2011)
            {
              l1 = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("uid" + localMessage.frienduin, 0L);
              localObject3 = ((QQMessageFacade)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              if ((localObject3 == null) || (!(localObject3 instanceof MessageForStructing))) {
                break label5009;
              }
              localObject4 = (MessageForStructing)localObject3;
              if (((MessageForStructing)localObject4).structingMsg == null) {
                ((MessageForStructing)localObject4).parse();
              }
              if (((MessageForStructing)localObject4).structingMsg == null) {
                break label5009;
              }
              if ((l1 != localMessage.msgUid) || (((MessageForStructing)localObject4).structingMsg.mMsgServiceID != 76)) {
                break label3814;
              }
              localObject4 = ((MessageForStructing)localObject4).structingMsg.mMsgBrief;
              String str = paramContext.getString(2131430832);
              if ((((MessageRecord)localObject3).isread) || (android.text.TextUtils.isEmpty((CharSequence)localObject4)) || (!((String)localObject4).startsWith(str))) {
                break label3798;
              }
              this.jdField_d_of_type_JavaLangCharSequence = str;
              localMessage.msg = ((String)localObject4).substring(str.length());
              label3469:
              this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494324);
              i = 0;
            }
          }
          for (;;)
          {
            label3484:
            a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            if ((i != 0) && (this.jdField_c_of_type_Int > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg instanceof MessageRecord)) && (!((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg).isread)) {
              localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
            }
            if ((i == 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg instanceof MessageForStructing)))
            {
              localObject3 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg;
              if ((!((MessageForStructing)localObject3).isread) && (((MessageForStructing)localObject3).structingMsg.mMsgServiceID == 107)) {
                a(paramContext, localMessage, (MessageForStructing)localObject3);
              }
            }
            if ((localMessage != null) && (localMessage.msgtype == -1034))
            {
              if (jdField_a_of_type_ComTencentMobileqqDataMessageForRichState == null) {
                jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = new MessageForRichState();
              }
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.msg = localMessage.msg;
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.mIsParsed = false;
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.parse();
              if (paramQQAppInterface.a().e(localMessage.frienduin) < jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time)
              {
                this.jdField_d_of_type_JavaLangCharSequence = "[新签名]";
                this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494294);
                label3705:
                this.jdField_d_of_type_Boolean = true;
              }
            }
            else
            {
              if (!AppConstants.H.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                break label3893;
              }
              this.jdField_b_of_type_JavaLangString = paramContext.getString(2131434957);
            }
            for (;;)
            {
              if ((localMessage == null) || (localMessage.msgtype != -2040)) {
                break label4146;
              }
              localObject1 = new MessageForApproval();
              ((MessageForApproval)localObject1).msgData = localMessage.msgData;
              localMsgSummary.b = ((MessageForApproval)localObject1).getFullTitle();
              break;
              label3785:
              i = 0;
              break label2916;
              this.jdField_b_of_type_Int = 1;
              break label3189;
              label3798:
              this.jdField_d_of_type_JavaLangCharSequence = "";
              localMessage.msg = ((String)localObject4);
              break label3469;
              label3814:
              if ((((MessageForStructing)localObject4).structingMsg.mMsgServiceID != 107) || (bool1)) {
                break label5009;
              }
              a(paramContext, localMessage, (MessageForStructing)localObject3);
              this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg = localObject4;
              i = 1;
              break label3484;
              label3858:
              this.jdField_a_of_type_Long = 0L;
              i = i1;
              break label3484;
              this.jdField_d_of_type_JavaLangCharSequence = "[签名]";
              this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494270);
              break label3705;
              label3893:
              if (AppConstants.D.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
              {
                this.jdField_b_of_type_JavaLangString = paramContext.getString(2131434998);
                if ((localMessage != null) && (localMessage.msg != null)) {
                  localMsgSummary.b = localMessage.msg;
                }
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1000)
              {
                localObject3 = (TroopManager)paramQQAppInterface.getManager(51);
                if (localObject3 != null)
                {
                  localObject3 = ((TroopManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
                  this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (String)localObject3, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, true, null);
                }
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1004)
              {
                this.jdField_b_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
                if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
                  this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
                }
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1029)
              {
                this.jdField_b_of_type_JavaLangString = ContactUtils.f(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              }
              else
              {
                this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
              }
            }
            label4146:
            if ((localMessage != null) && (localMessage.msgtype == -2041))
            {
              localObject1 = paramContext.getString(2131438351);
              localObject3 = paramContext.getString(2131438352);
              localMsgSummary.b = ((String)localObject1 + " " + (String)localObject3);
              break;
            }
            if ((localMessage != null) && (localMessage.msgtype == -2025))
            {
              if (this.jdField_c_of_type_Int <= 0) {
                break label4431;
              }
              this.jdField_e_of_type_Int = -881592;
              if (!bool1) {
                break label4419;
              }
              this.jdField_d_of_type_JavaLangCharSequence += localMessage.msg;
              label4278:
              localMsgSummary.b = "";
            }
            for (;;)
            {
              if ((localMessage != null) && (localMessage.msgtype == -2061)) {
                localMsgSummary.b = "";
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1024) && (!QidianManager.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
                this.jdField_d_of_type_Int = CrmUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              }
              if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                this.jdField_d_of_type_Int = 2130839766;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0) || (((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin) != 1)) {
                break;
              }
              this.jdField_a_of_type_JavaLangString = ((FlashChatManager)paramQQAppInterface.getManager(216)).a.jdField_d_of_type_JavaLangString;
              break;
              label4419:
              this.jdField_d_of_type_JavaLangCharSequence = localMessage.msg;
              break label4278;
              label4431:
              this.jdField_d_of_type_JavaLangCharSequence = "";
            }
            this.jdField_b_of_type_JavaLangString = paramContext.getString(2131430180);
            localObject3 = "";
            localObject1 = null;
            if (localObject4 != null) {
              localObject1 = ((QQMessageFacade)localObject4).b(AppConstants.C, 4000);
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
              if (((MessageRecord)localObject1).msg != null) {
                if (((MessageRecord)localObject1).msgtype == -1033)
                {
                  localObject1 = ((MessageRecord)localObject1).msg;
                  localObject1 = "好友推荐，" + (String)localObject1;
                }
              }
            }
            for (;;)
            {
              localMsgSummary.b = ((CharSequence)localObject1);
              if ((localMessage != null) && (localMessage.getMessageText() != null))
              {
                this.jdField_a_of_type_Long = localMessage.time;
                break;
                if (((MessageRecord)localObject1).msgtype == -1030)
                {
                  if ((PhoneContactManager)paramQQAppInterface.getManager(10) != null) {}
                  localObject1 = "好友推荐，" + "";
                  continue;
                }
                if (((MessageRecord)localObject1).msgtype == -1039)
                {
                  localObject1 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
                  if (localObject1 == null) {
                    break label5002;
                  }
                  localObject1 = paramContext.getResources().getString(2131430182) + ((RecommendTroopManagerImp)localObject1).a();
                  continue;
                }
                if (((MessageRecord)localObject1).msgtype != -1040) {
                  break label4995;
                }
                localObject4 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
                localObject1 = localObject3;
                if (localObject4 != null) {
                  localObject1 = ((RecommendTroopManagerImp)localObject4).a();
                }
                continue;
              }
              this.jdField_a_of_type_Long = 0L;
              break;
              this.jdField_b_of_type_JavaLangString = "轻应用调试";
              localMsgSummary.b = "可连接ArkIDE进行真机调试";
              this.jdField_c_of_type_Int = 0;
              break;
              label4777:
              a(paramQQAppInterface, paramContext, localMessage);
              break label472;
              label4788:
              if (this.jdField_c_of_type_Int == 1)
              {
                paramQQAppInterface.append("有一条未读");
                break label516;
              }
              if (this.jdField_c_of_type_Int == 2)
              {
                paramQQAppInterface.append("有两条未读");
                break label516;
              }
              if (this.jdField_c_of_type_Int <= 0) {
                break label516;
              }
              paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读,");
              break label516;
              label4857:
              if (this.l != 2) {
                break label616;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 60)).append(",");
              break label616;
              label4885:
              if (this.n != 2) {
                break label640;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 6)).append(",");
              break label640;
              label4913:
              if (this.m != 2) {
                break label664;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 4)).append(",");
              break label664;
              label4940:
              if (this.k != 2) {
                break label688;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 2)).append(",");
              break label688;
              label4967:
              if (this.p != 2) {
                break label713;
              }
              paramQQAppInterface.append(HotReactiveHelper.a(paramContext, 37)).append(",");
              break label713;
              label4995:
              localObject1 = "";
              continue;
              label5002:
              localObject1 = "";
            }
            label5009:
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData
 * JD-Core Version:    0.7.0.1
 */