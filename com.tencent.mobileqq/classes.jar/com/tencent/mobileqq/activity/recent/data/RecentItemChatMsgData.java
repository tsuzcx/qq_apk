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
import xij;
import xik;
import xil;

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
  private boolean e;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  public RecentItemChatMsgData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_e_of_type_Boolean = android.text.TextUtils.equals(paramRecentUser.uin, AppConstants.ar);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_b_of_type_Int = 2;
    }
  }
  
  private void a(Context paramContext, QQMessageFacade.Message paramMessage, MessageForStructing paramMessageForStructing)
  {
    String str1 = paramMessageForStructing.structingMsg.mMsgBrief;
    String str2 = paramContext.getString(2131438949);
    if ((!paramMessageForStructing.isread) && (!android.text.TextUtils.isEmpty(str1))) {}
    for (this.jdField_d_of_type_JavaLangCharSequence = str2;; this.jdField_d_of_type_JavaLangCharSequence = "")
    {
      paramMessage.msg = str1;
      this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494311);
      return;
    }
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
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    this.jdField_d_of_type_Boolean = false;
    Object localObject5 = paramQQAppInterface.a();
    if (localObject5 != null) {}
    for (Object localObject2 = ((QQMessageFacade)localObject5).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);; localObject2 = null)
    {
      Object localObject1 = paramQQAppInterface.a();
      MsgSummary localMsgSummary;
      int i1;
      if ((localObject1 != null) && (localObject2 != null))
      {
        this.jdField_c_of_type_Int = ((ConversationFacade)localObject1).a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
        if (localObject2 != null)
        {
          localObject1 = QCallFacade.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop, this.jdField_c_of_type_Int, (QQMessageFacade.Message)localObject2);
          this.jdField_c_of_type_Int += ((QCallFacade.CallUnreadCountInfo)localObject1).a();
          if (((QCallFacade.CallUnreadCountInfo)localObject1).a() > 0)
          {
            this.jdField_d_of_type_JavaLangCharSequence = ((QCallFacade.CallUnreadCountInfo)localObject1).a();
            this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494281);
          }
        }
        if (("2909288299".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) && (this.jdField_c_of_type_Int > 0))
        {
          localObject1 = ((QQMessageFacade.Message)localObject2).getExtInfoFromExtStr("news_has_report");
          if ((android.text.TextUtils.isEmpty((CharSequence)localObject1)) || (!"1".equals(localObject1)))
          {
            ((QQMessageFacade.Message)localObject2).saveExtInfoToExtStr("news_has_report", "1");
            ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007054", "0X8007054", 0, 0, "", "", "", "");
          }
        }
        localMsgSummary = a();
        i1 = 0;
      }
      label513:
      label610:
      label622:
      int i;
      label646:
      label670:
      label695:
      label976:
      Object localObject3;
      label905:
      label923:
      label1060:
      label1202:
      label1208:
      label1341:
      long l1;
      label1165:
      label1336:
      label2281:
      Object localObject4;
      switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type)
      {
      default: 
      case 9501: 
        for (;;)
        {
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          if ((localMsgSummary.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
          {
            localMsgSummary.b = "";
            this.jdField_d_of_type_JavaLangCharSequence = "";
          }
          a(paramQQAppInterface, paramContext, localMsgSummary);
          if (AppSetting.b)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString).append(",");
            if (this.jdField_c_of_type_Int != 0) {
              break label4728;
            }
            if (this.jdField_d_of_type_JavaLangCharSequence != null) {
              ((StringBuilder)localObject1).append(this.jdField_d_of_type_JavaLangCharSequence + ",");
            }
            ((StringBuilder)localObject1).append(com.tencent.mobileqq.text.TextUtils.d(this.jdField_c_of_type_JavaLangCharSequence.toString())).append(",").append(this.jdField_c_of_type_JavaLangString);
            if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 0)
            {
              if (this.m != 1) {
                break label4809;
              }
              if (!this.jdField_c_of_type_Boolean) {
                break label4800;
              }
              paramQQAppInterface = HotReactiveHelper.a(paramContext, 59);
              ((StringBuilder)localObject1).append(paramQQAppInterface).append(",");
              if (this.l != 1) {
                break label4856;
              }
              ((StringBuilder)localObject1).append(HotReactiveHelper.a(paramContext, 3)).append(",");
              if (this.k != 1) {
                break label4883;
              }
              ((StringBuilder)localObject1).append(HotReactiveHelper.a(paramContext, 1)).append(",");
              if (this.n != 1) {
                break label4910;
              }
              ((StringBuilder)localObject1).append(HotReactiveHelper.a(paramContext, 36)).append(",");
            }
            this.jdField_d_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
          }
          e();
          return;
          this.jdField_c_of_type_Int = 0;
          break;
          if (localObject2 != null)
          {
            localMsgSummary.b = ((QQMessageFacade.Message)localObject2).msg;
            this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
            this.jdField_d_of_type_Int = 0;
            if ((((QQMessageFacade.Message)localObject2).msgtype == -4502) && (((QQMessageFacade.Message)localObject2).frienduin.equals(AppConstants.x))) {
              this.jdField_b_of_type_JavaLangString = "QQ物联";
            }
            for (;;)
            {
              if ((localMsgSummary.b == null) || (localMsgSummary.b.length() == 0)) {
                localMsgSummary.b = this.jdField_b_of_type_JavaLangString;
              }
              this.f = 1;
              if (((QQMessageFacade.Message)localObject2).msgtype != -4500) {
                break label923;
              }
              localObject1 = new MessageForDeviceFile();
              ((MessageForDeviceFile)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
              ((MessageForDeviceFile)localObject1).parse();
              if (((MessageForDeviceFile)localObject1).msgStatus != 1) {
                break label905;
              }
              localMsgSummary.jdField_a_of_type_Int = 2;
              break;
              localObject1 = ((SmartDeviceProxyMgr)paramQQAppInterface.a(51)).a(Long.parseLong(((QQMessageFacade.Message)localObject2).frienduin));
              if (localObject1 != null) {
                this.jdField_b_of_type_JavaLangString = SmartDeviceUtil.a((DeviceInfo)localObject1);
              }
            }
            if (((MessageForDeviceFile)localObject1).msgStatus == 2)
            {
              localMsgSummary.jdField_a_of_type_Int = 1;
              continue;
              if (((QQMessageFacade.Message)localObject2).msgtype == -4501)
              {
                localObject1 = new MessageForDevPtt();
                ((MessageForDevPtt)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
                ((MessageForDevPtt)localObject1).parse();
                if (((MessageForDevPtt)localObject1).fileSize == -1L)
                {
                  localMsgSummary.jdField_a_of_type_Int = 2;
                  if (!"device_groupchat".equals(((QQMessageFacade.Message)localObject2).extStr)) {
                    continue;
                  }
                  if (!((QQMessageFacade.Message)localObject2).isSend()) {
                    break label1060;
                  }
                }
                for (((QQMessageFacade.Message)localObject2).nickName = paramQQAppInterface.getApp().getString(2131433099);; ((QQMessageFacade.Message)localObject2).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, true))
                {
                  MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, ((QQMessageFacade.Message)localObject2).nickName, true, false);
                  break;
                  if (((MessageForDevPtt)localObject1).fileSize != -3L) {
                    break label976;
                  }
                  localMsgSummary.jdField_a_of_type_Int = 1;
                  break label976;
                }
              }
              else if (((QQMessageFacade.Message)localObject2).msgtype == -4503)
              {
                localObject1 = new MessageForDevShortVideo();
                ((MessageForDevShortVideo)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
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
                    if (((DeviceAVFileMsgObserver)localObject1).a(((QQMessageFacade.Message)localObject2).uniseq)) {
                      break label1202;
                    }
                  }
                  for (i1 = 1;; i1 = 0)
                  {
                    if ((i & i1) == 0) {
                      break label1208;
                    }
                    localMsgSummary.jdField_a_of_type_Int = 2;
                    break;
                    i = 0;
                    break label1165;
                  }
                  localMsgSummary.jdField_a_of_type_Int = 1;
                }
              }
              else if (((QQMessageFacade.Message)localObject2).msgtype == -4509)
              {
                localObject1 = new MessageForDevLittleVideo();
                ((MessageForDevLittleVideo)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
                ((MessageForDevLittleVideo)localObject1).parse();
                if (((MessageForDevLittleVideo)localObject1).videoFileStatus == 1005)
                {
                  localMsgSummary.jdField_a_of_type_Int = 2;
                }
                else if (((MessageForDevLittleVideo)localObject1).videoFileStatus == 1002)
                {
                  localObject3 = ((DeviceMsgHandle)paramQQAppInterface.a(49)).a();
                  if (!DeviceMsgChatPie.b((MessageRecord)localObject1)) {
                    if (localObject3 == null) {
                      break label1336;
                    }
                  }
                  for (i = 1;; i = 0)
                  {
                    if ((i & ((DeviceAVFileMsgObserver)localObject3).a(((QQMessageFacade.Message)localObject2).uniseq)) == 0) {
                      break label1341;
                    }
                    localMsgSummary.jdField_a_of_type_Int = 1;
                    break;
                  }
                  localMsgSummary.jdField_a_of_type_Int = 2;
                }
              }
              else if (((QQMessageFacade.Message)localObject2).msgtype == -4508)
              {
                if ("device_groupchat".equals(((QQMessageFacade.Message)localObject2).extStr))
                {
                  if (((QQMessageFacade.Message)localObject2).isSend()) {}
                  for (((QQMessageFacade.Message)localObject2).nickName = paramQQAppInterface.getApp().getString(2131433099);; ((QQMessageFacade.Message)localObject2).nickName = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject2).senderuin, true))
                  {
                    MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, ((QQMessageFacade.Message)localObject2).nickName, true, false);
                    break;
                  }
                }
                MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, null, true, false);
              }
            }
          }
        }
      case 1008: 
        if (localObject2 != null)
        {
          i = ((QQMessageFacade.Message)localObject2).msgtype;
          if ((i == -3006) || (i == -5004)) {
            break label2281;
          }
          a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((i == -2025) && (this.jdField_c_of_type_Int > 0) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
          {
            this.jdField_e_of_type_Int = -881592;
            this.jdField_d_of_type_JavaLangCharSequence = ((QQMessageFacade.Message)localObject2).msg;
            localMsgSummary.b = "";
          }
        }
        else
        {
          localObject1 = null;
          localObject3 = (PublicAccountDataManager)paramQQAppInterface.getManager(55);
          if (localObject3 != null) {
            localObject1 = ((PublicAccountDataManager)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
          }
          if ((localObject1 == null) && (localObject3 != null))
          {
            localObject3 = ((PublicAccountDataManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
            if (localObject3 != null) {
              this.jdField_b_of_type_JavaLangString = ((AccountDetail)localObject3).name;
            }
            if (this.jdField_e_of_type_Boolean) {
              this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.b(paramQQAppInterface, paramQQAppInterface.getApp());
            }
          }
          if (localObject1 == null) {
            break label2463;
          }
          this.jdField_b_of_type_JavaLangString = ((PublicAccountInfo)localObject1).name;
          if (((PublicAccountInfo)localObject1).certifiedGrade <= 0L) {
            break label2455;
          }
          this.jdField_d_of_type_Int = 2130839745;
          if ((localObject2 == null) || (((QQMessageFacade.Message)localObject2).getMessageText() == null)) {
            break label2471;
          }
          this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
          if ((!this.jdField_e_of_type_Boolean) && (ServiceAccountFolderManager.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
          {
            i = paramQQAppInterface.a().f(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
            if (this.jdField_c_of_type_Int > 0)
            {
              if ((this.jdField_c_of_type_Int != 1) || (i <= 0)) {
                break label2485;
              }
              this.jdField_b_of_type_Int = 2;
            }
          }
        }
        while (AppConstants.aH.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
        {
          for (;;)
          {
            WeishiReportUtil.a(this);
            break;
            this.jdField_d_of_type_JavaLangCharSequence = "";
            this.jdField_e_of_type_Int = 0;
            if (this.jdField_e_of_type_Boolean)
            {
              localObject1 = ((QQMessageFacade)localObject5).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              if ((localObject1 == null) || (!(localObject1 instanceof MessageForStructing))) {
                break label1557;
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
                  this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494281);
                }
              }
              else
              {
                if ((((MessageForStructing)localObject1).extInt != 1) || (((MessageForStructing)localObject1).extLong != 1)) {
                  break label1557;
                }
                ((MessageForStructing)localObject1).extLong = 0;
                ThreadManager.post(new xij(this, paramQQAppInterface, (MessageForStructing)localObject1), 8, null, false);
                l2 = -1L;
                l1 = l2;
                if (((MessageForStructing)localObject1).structingMsg != null)
                {
                  l1 = l2;
                  if (!android.text.TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mMsgActionData))
                  {
                    localObject3 = PublicAccountUtil.a(((MessageForStructing)localObject1).structingMsg.mMsgActionData);
                    l1 = l2;
                    if (localObject3 == null) {}
                  }
                }
              }
              try
              {
                l1 = Long.parseLong(((JSONObject)localObject3).getString("id"));
                if (l1 != -1L)
                {
                  PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F3", "0X80066F3", 0, 0, String.valueOf(this.i + 1), "", String.valueOf(l1), "", false);
                  PublicAccountReportUtils.a("0X80066F3", "", String.valueOf(this.i + 1), "", String.valueOf(l1), "");
                }
                if (((MessageForStructing)localObject1).structingMsg == null) {
                  break label1557;
                }
                PublicAccountUtil.a(paramQQAppInterface, (MessageForStructing)localObject1, 7);
                break label1557;
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
          if ((localObject1 == null) || (((PubAccountTips.PubAccountTipsMsg)localObject1).jdField_d_of_type_Long != ((QQMessageFacade.Message)localObject2).uniseq) || (!((PubAccountTips.PubAccountTipsMsg)localObject1).b())) {
            break label1557;
          }
          ThreadManager.post(new xik(this, paramQQAppInterface, (PubAccountTips.PubAccountTipsMsg)localObject1), 2, null, false);
          break label1557;
          localMsgSummary.b = "";
          localObject4 = XMLMessageUtils.a((MessageRecord)localObject2);
          if ((localObject4 == null) || (((PAMessage)localObject4).items == null) || (((PAMessage)localObject4).items.size() == 0))
          {
            a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            break label1557;
          }
          localObject1 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList != null)) {
            localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
          }
          for (;;)
          {
            localMsgSummary.b = ((CharSequence)localObject1);
            break;
          }
          this.jdField_d_of_type_Int = 0;
          break label1678;
          this.jdField_d_of_type_Int = 0;
          break label1678;
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
          break label1700;
          if (i > 0)
          {
            this.jdField_c_of_type_Int -= 1;
            this.jdField_b_of_type_Int = 1;
          }
        }
      case 1006: 
        label1557:
        label1700:
        label2471:
        label2485:
        localObject4 = ContactUtils.g(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        label1678:
        label2455:
        label2463:
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
          a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
          if ((localObject2 == null) || ((((QQMessageFacade.Message)localObject2).getMessageText() == null) && ((((QQMessageFacade.Message)localObject2).msgtype != -2011) || (((QQMessageFacade.Message)localObject2).msgData == null)))) {
            break label2660;
          }
          this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
          break;
          if (localObject4 != null) {
            this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, (String)localObject4, true);
          } else {
            this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
          }
        }
        label2660:
        this.jdField_a_of_type_Long = 0L;
        break;
        this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
        a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
        if ((localObject2 != null) && ((((QQMessageFacade.Message)localObject2).getMessageText() != null) || ((((QQMessageFacade.Message)localObject2).msgtype == -2011) && (((QQMessageFacade.Message)localObject2).msgData != null))))
        {
          this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
          break;
        }
        this.jdField_a_of_type_Long = 0L;
        break;
        boolean bool1 = QvipSpecialCareManager.a(paramQQAppInterface.getCurrentAccountUin() + this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if ((this.jdField_c_of_type_Int > 0) && (bool1))
        {
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131436863);
          this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494281);
        }
        if (0 == 0) {}
        for (localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);; localObject1 = null)
        {
          this.k = 0;
          this.l = 0;
          this.m = 0;
          this.n = 0;
          if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 0) && (((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)))
          {
            if (QIMUserManager.a().a(paramQQAppInterface) != 1) {
              break label3736;
            }
            i = 1;
            label2894:
            this.j = 0;
            if ((i != 0) && (QIMUserManager.a().a()))
            {
              localObject4 = ((FriendsManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              if ((localObject4 != null) && (((Friends)localObject4).netTypeIconId == 11))
              {
                this.j = 1;
                ThreadManager.post(new xil(this, paramQQAppInterface), 5, null, true);
              }
            }
            boolean bool2 = ((FriendsManager)localObject1).c();
            if (!bool2)
            {
              localObject4 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              this.k = ((FriendsManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject4, bool2);
              this.l = ((FriendsManager)localObject1).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject4, bool2);
              this.m = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject4, bool2);
              this.n = ((FriendsManager)localObject1).d(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject4, bool2);
              this.jdField_c_of_type_Boolean = ((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (ExtensionInfo)localObject4, bool2);
              if (localObject4 != null)
              {
                this.jdField_b_of_type_Long = ((ExtensionInfo)localObject4).lastpraiseTime;
                this.jdField_c_of_type_Long = ((ExtensionInfo)localObject4).lastChatTime;
                this.jdField_d_of_type_Long = ((ExtensionInfo)localObject4).lastQzoneVisitTime;
              }
            }
          }
          if (a((FriendsManager)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
          {
            this.jdField_b_of_type_Int = 4;
            label3140:
            if ((localObject2 == null) || ((((QQMessageFacade.Message)localObject2).getMessageText() == null) && (((QQMessageFacade.Message)localObject2).msgData == null) && ((((QQMessageFacade.Message)localObject2).msgtype != -2011) || (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0)))) {
              break label3809;
            }
            this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
            i = i1;
            if (((QQMessageFacade.Message)localObject2).msgtype == -2011)
            {
              l1 = paramQQAppInterface.getApplication().getSharedPreferences("now_msg_sp" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("uid" + ((QQMessageFacade.Message)localObject2).frienduin, 0L);
              localObject4 = ((QQMessageFacade)localObject5).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
              if ((localObject4 == null) || (!(localObject4 instanceof MessageForStructing))) {
                break label4952;
              }
              localObject5 = (MessageForStructing)localObject4;
              if (((MessageForStructing)localObject5).structingMsg == null) {
                ((MessageForStructing)localObject5).parse();
              }
              if (((MessageForStructing)localObject5).structingMsg == null) {
                break label4952;
              }
              if ((l1 != ((QQMessageFacade.Message)localObject2).msgUid) || (((MessageForStructing)localObject5).structingMsg.mMsgServiceID != 76)) {
                break label3765;
              }
              localObject5 = ((MessageForStructing)localObject5).structingMsg.mMsgBrief;
              String str = paramContext.getString(2131430812);
              if ((((MessageRecord)localObject4).isread) || (android.text.TextUtils.isEmpty((CharSequence)localObject5)) || (!((String)localObject5).startsWith(str))) {
                break label3749;
              }
              this.jdField_d_of_type_JavaLangCharSequence = str;
              ((QQMessageFacade.Message)localObject2).msg = ((String)localObject5).substring(str.length());
              label3420:
              this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494311);
              i = 0;
            }
          }
          for (;;)
          {
            label3435:
            a((QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
            if ((i != 0) && (this.jdField_c_of_type_Int > 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg instanceof MessageRecord)) && (!((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg).isread)) {
              localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
            }
            if ((i == 0) && ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg instanceof MessageForStructing)))
            {
              localObject4 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg;
              if ((!((MessageForStructing)localObject4).isread) && (((MessageForStructing)localObject4).structingMsg.mMsgServiceID == 107)) {
                a(paramContext, (QQMessageFacade.Message)localObject2, (MessageForStructing)localObject4);
              }
            }
            if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msgtype == -1034))
            {
              if (jdField_a_of_type_ComTencentMobileqqDataMessageForRichState == null) {
                jdField_a_of_type_ComTencentMobileqqDataMessageForRichState = new MessageForRichState();
              }
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.msg = ((QQMessageFacade.Message)localObject2).msg;
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.mIsParsed = false;
              jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.parse();
              if (paramQQAppInterface.a().e(((QQMessageFacade.Message)localObject2).frienduin) < jdField_a_of_type_ComTencentMobileqqDataMessageForRichState.time)
              {
                this.jdField_d_of_type_JavaLangCharSequence = "[新签名]";
                this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494281);
                label3656:
                this.jdField_d_of_type_Boolean = true;
              }
            }
            else
            {
              if (!AppConstants.H.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                break label3844;
              }
              this.jdField_b_of_type_JavaLangString = paramContext.getString(2131434924);
            }
            for (;;)
            {
              if ((localObject2 == null) || (((QQMessageFacade.Message)localObject2).msgtype != -2040)) {
                break label4097;
              }
              localObject1 = new MessageForApproval();
              ((MessageForApproval)localObject1).msgData = ((QQMessageFacade.Message)localObject2).msgData;
              localMsgSummary.b = ((MessageForApproval)localObject1).getFullTitle();
              break;
              label3736:
              i = 0;
              break label2894;
              this.jdField_b_of_type_Int = 1;
              break label3140;
              label3749:
              this.jdField_d_of_type_JavaLangCharSequence = "";
              ((QQMessageFacade.Message)localObject2).msg = ((String)localObject5);
              break label3420;
              label3765:
              if ((((MessageForStructing)localObject5).structingMsg.mMsgServiceID != 107) || (bool1)) {
                break label4952;
              }
              a(paramContext, (QQMessageFacade.Message)localObject2, (MessageForStructing)localObject4);
              this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.msg = localObject5;
              i = 1;
              break label3435;
              label3809:
              this.jdField_a_of_type_Long = 0L;
              i = i1;
              break label3435;
              this.jdField_d_of_type_JavaLangCharSequence = "[签名]";
              this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494257);
              break label3656;
              label3844:
              if (AppConstants.D.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))
              {
                this.jdField_b_of_type_JavaLangString = paramContext.getString(2131434965);
                if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msg != null)) {
                  localMsgSummary.b = ((QQMessageFacade.Message)localObject2).msg;
                }
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1000)
              {
                localObject4 = (TroopManager)paramQQAppInterface.getManager(51);
                if (localObject4 != null)
                {
                  localObject4 = ((TroopManager)localObject4).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
                  this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, (String)localObject4, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, true, null);
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
            label4097:
            if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msgtype == -2041))
            {
              localObject1 = paramContext.getString(2131438313);
              localObject2 = paramContext.getString(2131438314);
              localMsgSummary.b = ((String)localObject1 + " " + (String)localObject2);
              break;
            }
            if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msgtype == -2025))
            {
              if (this.jdField_c_of_type_Int <= 0) {
                break label4382;
              }
              this.jdField_e_of_type_Int = -881592;
              if (!bool1) {
                break label4370;
              }
              this.jdField_d_of_type_JavaLangCharSequence += ((QQMessageFacade.Message)localObject2).msg;
              label4229:
              localMsgSummary.b = "";
            }
            for (;;)
            {
              if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).msgtype == -2061)) {
                localMsgSummary.b = "";
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type == 1024) && (!QidianManager.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin))) {
                this.jdField_d_of_type_Int = CrmUtils.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
              }
              if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
                this.jdField_d_of_type_Int = 2130839745;
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type != 0) || (((FriendsManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin) != 1)) {
                break;
              }
              this.jdField_a_of_type_JavaLangString = ((FlashChatManager)paramQQAppInterface.getManager(216)).a.jdField_d_of_type_JavaLangString;
              break;
              label4370:
              this.jdField_d_of_type_JavaLangCharSequence = ((QQMessageFacade.Message)localObject2).msg;
              break label4229;
              label4382:
              this.jdField_d_of_type_JavaLangCharSequence = "";
            }
            this.jdField_b_of_type_JavaLangString = paramContext.getString(2131430160);
            localObject4 = "";
            localObject1 = null;
            if (localObject5 != null) {
              localObject1 = ((QQMessageFacade)localObject5).b(AppConstants.C, 4000);
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
              if ((localObject2 != null) && (((QQMessageFacade.Message)localObject2).getMessageText() != null))
              {
                this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
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
                    break label4945;
                  }
                  localObject1 = paramContext.getResources().getString(2131430162) + ((RecommendTroopManagerImp)localObject1).a();
                  continue;
                }
                if (((MessageRecord)localObject1).msgtype != -1040) {
                  break label4938;
                }
                localObject5 = (RecommendTroopManagerImp)paramQQAppInterface.getManager(21);
                localObject1 = localObject4;
                if (localObject5 != null) {
                  localObject1 = ((RecommendTroopManagerImp)localObject5).a();
                }
                continue;
              }
              this.jdField_a_of_type_Long = 0L;
              break;
              this.jdField_b_of_type_JavaLangString = "轻应用调试";
              localMsgSummary.b = "可连接ArkIDE进行真机调试";
              this.jdField_c_of_type_Int = 0;
              break;
              label4728:
              if (this.jdField_c_of_type_Int == 1)
              {
                ((StringBuilder)localObject1).append("有一条未读");
                break label513;
              }
              if (this.jdField_c_of_type_Int == 2)
              {
                ((StringBuilder)localObject1).append("有两条未读");
                break label513;
              }
              if (this.jdField_c_of_type_Int <= 0) {
                break label513;
              }
              ((StringBuilder)localObject1).append("有").append(this.jdField_c_of_type_Int).append("条未读,");
              break label513;
              label4800:
              paramQQAppInterface = HotReactiveHelper.a(paramContext, 5);
              break label610;
              label4809:
              if (this.m != 2) {
                break label622;
              }
              if (this.jdField_c_of_type_Boolean) {}
              for (paramQQAppInterface = HotReactiveHelper.a(paramContext, 60);; paramQQAppInterface = HotReactiveHelper.a(paramContext, 6))
              {
                ((StringBuilder)localObject1).append(paramQQAppInterface).append(",");
                break;
              }
              label4856:
              if (this.l != 2) {
                break label646;
              }
              ((StringBuilder)localObject1).append(HotReactiveHelper.a(paramContext, 4)).append(",");
              break label646;
              label4883:
              if (this.k != 2) {
                break label670;
              }
              ((StringBuilder)localObject1).append(HotReactiveHelper.a(paramContext, 2)).append(",");
              break label670;
              label4910:
              if (this.n != 2) {
                break label695;
              }
              ((StringBuilder)localObject1).append(HotReactiveHelper.a(paramContext, 37)).append(",");
              break label695;
              label4938:
              localObject1 = "";
              continue;
              label4945:
              localObject1 = "";
            }
            label4952:
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