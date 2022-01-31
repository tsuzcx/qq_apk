package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import xsa;
import xsb;

public class RecentItemKandianMergeData
  extends RecentUserBaseData
{
  private static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RecentItemKandianMergeData";
  }
  
  public RecentItemKandianMergeData(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    if (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
    for (this.jdField_b_of_type_Int = 1;; this.jdField_b_of_type_Int = 2)
    {
      this.e = BaseApplicationImpl.getApplication().getResources().getColor(2131494294);
      return;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (!ReadInJoyHelper.u(paramQQAppInterface)) {}
    while ((paramMessageRecord.isread) || ((paramMessageRecord.extLong & 0x2) == 0)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime = l;
    ThreadManager.executeOnSubThread(new xsb(this, paramQQAppInterface, paramMessageRecord, l));
    PublicAccountReportUtils.a(null, "CliOper", "", "", "", "0X80089F5", 0, 0, String.valueOf(this.i + 1), "", "", "", false);
    QLog.d(jdField_a_of_type_JavaLangString, 2, "no real exposure, try to setTopForUnExposureRedPnt!");
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((ReadInJoyLogicManager)paramAppRuntime.getManager(162)).a();
    paramAppRuntime.c(0);
    paramAppRuntime.c(56);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject1;
    QQMessageFacade.Message localMessage;
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        do
        {
          return;
          super.a(paramQQAppInterface, paramContext);
          localObject1 = paramQQAppInterface.a();
        } while (localObject1 == null);
        localMessage = ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      } while (localMessage == null);
      localMessageRecord = ((QQMessageFacade)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
    } while (localMessageRecord == null);
    if ((localMessageRecord instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localMessageRecord;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = 2130839766;
      MsgSummary localMsgSummary;
      if (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        this.jdField_b_of_type_Int = 1;
        this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.c(paramQQAppInterface, paramContext);
        localMsgSummary = a();
        localMsgSummary.b = "";
        if ((localMessageRecord.extInt != 1) && (localMessageRecord.extInt != 3)) {
          break label806;
        }
        if (localObject1 == null) {
          break label793;
        }
        if (((MessageForStructing)localObject1).structingMsg == null) {
          break label780;
        }
        localMsgSummary.b = ((MessageForStructing)localObject1).structingMsg.mMsgBrief;
      }
      for (;;)
      {
        this.jdField_c_of_type_Int = 0;
        if ((localMessageRecord.extInt != 1) || (localMessageRecord.isread)) {
          break label1374;
        }
        this.jdField_c_of_type_Int = 1;
        label223:
        this.jdField_d_of_type_JavaLangCharSequence = "";
        if (this.jdField_c_of_type_Int <= 0) {
          break label1677;
        }
        if (localMessageRecord.extInt != 1) {
          break label1459;
        }
        if (localObject1 == null) {
          break label1450;
        }
        if ((((MessageForStructing)localObject1).structingMsg == null) || (TextUtils.isEmpty(((MessageForStructing)localObject1).structingMsg.mOrangeWord))) {
          break label1441;
        }
        this.jdField_d_of_type_JavaLangCharSequence = ("[" + ((MessageForStructing)localObject1).structingMsg.mOrangeWord + "] ");
        label307:
        if ((ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) == 1) && (this.jdField_c_of_type_Int == 1))
        {
          if (!TextUtils.isEmpty(localMsgSummary.a)) {
            break label1686;
          }
          localMsgSummary.b = TextUtils.concat(new CharSequence[] { this.jdField_d_of_type_JavaLangCharSequence, localMsgSummary.b });
          label366:
          this.jdField_d_of_type_JavaLangCharSequence = "";
        }
        a(localMessageRecord, paramQQAppInterface);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime;
        if (this.jdField_c_of_type_Int > 0) {
          a(localMessageRecord, (MessageForStructing)localObject1, paramQQAppInterface);
        }
        if ((TextUtils.isEmpty(localMsgSummary.b)) && (TextUtils.isEmpty(localMsgSummary.a)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)) && (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)))
        {
          if (QLog.isColorLevel())
          {
            QLog.i(jdField_a_of_type_JavaLangString, 2, localMessage.getBaseInfoString() + ",isread:" + localMessage.isread + ",issend:" + localMessage.issend + ",extInt:" + localMessage.extInt + ",extLong:" + localMessage.extLong);
            QLog.i(jdField_a_of_type_JavaLangString, 2, localMessageRecord.getBaseInfoString() + ",isread:" + localMessageRecord.isread + ",issend:" + localMessageRecord.issend + ",extInt:" + localMessageRecord.extInt + ",extLong:" + localMessageRecord.extLong);
          }
          localMsgSummary.b = paramQQAppInterface.getApp().getResources().getString(2131428464);
        }
        a(paramQQAppInterface, paramContext, localMsgSummary);
        if (AppSetting.b)
        {
          paramContext = new StringBuilder();
          paramContext.append(this.jdField_b_of_type_JavaLangString).append(",");
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) {
            paramContext.append(this.jdField_d_of_type_JavaLangCharSequence).append(",");
          }
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangCharSequence)) {
            paramContext.append(this.jdField_c_of_type_JavaLangCharSequence).append(",");
          }
          if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            paramContext.append(this.jdField_c_of_type_JavaLangString);
          }
          this.jdField_d_of_type_JavaLangString = paramContext.toString();
        }
        a(paramQQAppInterface);
        return;
        if (localMessageRecord.vipBubbleID == -1000L) {}
        for (i = 1;; i = 2)
        {
          this.jdField_b_of_type_Int = i;
          break;
        }
        label780:
        QLog.w(jdField_a_of_type_JavaLangString, 2, "KANDIAN_REAL_MSG or KANDIAN_FAKE_MSG, structing.structingMsg null");
        continue;
        label793:
        localMsgSummary.b = localMessageRecord.msg;
        continue;
        label806:
        if ((localMessageRecord.extInt == 5) || (localMessageRecord.extInt == 6) || ((localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, AppConstants.as))))
        {
          localMsgSummary.b = localMessageRecord.msg;
        }
        else
        {
          if (!PublicAccountUtil.a(paramQQAppInterface, localMessageRecord.senderuin, localMessage.msgtype)) {
            break label895;
          }
          localMsgSummary.b = "";
          localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
        }
      }
      label895:
      a(localMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, localMsgSummary);
      int i = localMessage.msgtype;
      Object localObject4;
      Object localObject2;
      if ((i == -3006) || (i == -5004))
      {
        localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
        localMsgSummary.b = "";
        localObject4 = XMLMessageUtils.a(localMessage);
        if ((localObject4 != null) && (((PAMessage)localObject4).items != null) && (((PAMessage)localObject4).items.size() != 0))
        {
          localObject2 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover != null) || (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList == null)) {
            break label1350;
          }
          localObject2 = (String)localObject2 + "：" + (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
          label1080:
          localMsgSummary.b = ((CharSequence)localObject2);
        }
      }
      label1126:
      Object localObject5;
      if (((TextUtils.isEmpty(localMsgSummary.b)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence))) || (TextUtils.equals(localMsgSummary.a(paramContext), "你有新消息")))
      {
        i = 1;
        if ((i != 0) && (localObject1 != null) && (((MessageForStructing)localObject1).structingMsg != null) && ((((MessageForStructing)localObject1).structingMsg instanceof AbsStructMsg)))
        {
          localObject2 = ((AbsShareMsg)((MessageForStructing)localObject1).structingMsg).getStructMsgItemLists();
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            label1183:
            if (((Iterator)localObject2).hasNext())
            {
              localObject4 = (AbsStructMsgElement)((Iterator)localObject2).next();
              if (!(localObject4 instanceof AbsStructMsgItem)) {
                break label1716;
              }
              localObject4 = ((AbsStructMsgItem)localObject4).a.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = (AbsStructMsgElement)((Iterator)localObject4).next();
                if ((localObject5 instanceof StructMsgItemTitle))
                {
                  localMsgSummary.b = ((StructMsgItemTitle)localObject5).b();
                  localMsgSummary.jdField_c_of_type_JavaLangCharSequence = "";
                  i = 1;
                }
              }
            }
          }
        }
      }
      label1441:
      label1450:
      label1459:
      label1716:
      for (;;)
      {
        if (i != 0)
        {
          if ((localMessageRecord.extInt != 2) || (TextUtils.isEmpty(localMessageRecord.senderuin))) {
            break;
          }
          localObject2 = ((PublicAccountDataManager)paramQQAppInterface.getManager(55)).b(localMessageRecord.senderuin);
          if ((localObject2 == null) || (TextUtils.isEmpty(((PublicAccountInfo)localObject2).name))) {
            break label1361;
          }
          localMsgSummary.a = ((PublicAccountInfo)localObject2).name;
          break;
          label1350:
          break label1080;
          i = 0;
          break label1126;
        }
        break label1183;
        label1361:
        localMsgSummary.a = localMessageRecord.senderuin;
        break;
        label1374:
        if (localMessageRecord.extInt == 2)
        {
          if (localMessageRecord.isread) {}
          for (i = 0;; i = 1)
          {
            this.jdField_c_of_type_Int = i;
            break;
          }
        }
        if (((localMessageRecord.extInt != 5) && (localMessageRecord.extInt != 6)) || (localMessageRecord.isread)) {
          break label223;
        }
        this.jdField_c_of_type_Int = 1;
        break label223;
        this.jdField_d_of_type_JavaLangCharSequence = "";
        break label307;
        this.jdField_d_of_type_JavaLangCharSequence = "";
        break label307;
        if ((localMessageRecord.extInt == 2) && (!TextUtils.equals(localMessageRecord.senderuin, AppConstants.as)))
        {
          if (!PublicAccountUtil.a(paramQQAppInterface, localMessage.senderuin, localMessage.msgtype))
          {
            this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131430077);
            break label307;
          }
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131430076);
          break label307;
        }
        if ((localMessageRecord.extInt != 5) && (localMessageRecord.extInt != 6) && ((localMessageRecord.extInt != 2) || (!TextUtils.equals(localMessageRecord.senderuin, AppConstants.as)) || (TextUtils.isEmpty(localMessageRecord.extStr)))) {
          break label307;
        }
        localObject4 = null;
        try
        {
          localObject5 = new JSONObject(localMessage.extStr);
          localObject2 = localObject4;
          if (((JSONObject)localObject5).has(KandianMergeManager.jdField_b_of_type_JavaLangString)) {
            localObject2 = ((JSONObject)localObject5).getString(KandianMergeManager.jdField_b_of_type_JavaLangString);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            Object localObject3 = localObject4;
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label307;
        }
        this.jdField_d_of_type_JavaLangCharSequence = ("[" + (String)localObject2 + "]");
        break label307;
        this.jdField_d_of_type_JavaLangCharSequence = "";
        break label307;
        localMsgSummary.a = TextUtils.concat(new CharSequence[] { this.jdField_d_of_type_JavaLangCharSequence, localMsgSummary.a });
        break label366;
      }
      label1677:
      label1686:
      continue;
      localObject1 = null;
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    if (ReadInJoyHelper.h()) {}
    while (((paramMessageRecord.extInt != 1) && (paramMessageRecord.extInt != 2) && (paramMessageRecord.extInt != 5) && (paramMessageRecord.extInt != 6)) || (((paramMessageRecord.extLong & 0x1) == 0) && ((paramMessageRecord.extLong & 0x2) == 0))) {
      return;
    }
    int m;
    label71:
    label86:
    int i;
    Object localObject1;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    Object localObject3;
    Object localObject5;
    if ((paramMessageRecord.extLong & 0x1) != 1)
    {
      m = 1;
      if (m != 0) {
        break label812;
      }
      paramMessageRecord.extLong ^= 0x1;
      ThreadManager.post(new xsa(this, paramQQAppInterface, paramMessageRecord), 8, null, false);
      i = 1;
      localObject1 = "0";
      localObject8 = "";
      localObject9 = "";
      localObject10 = "";
      localObject3 = "";
      if ((paramMessageRecord.extInt != 1) || (paramMessageForStructing == null)) {
        break label841;
      }
      paramQQAppInterface = (KandianMergeManager)paramQQAppInterface.getManager(161);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.a(paramMessageRecord) != 1)) {
        break label825;
      }
      i = 5;
      paramQQAppInterface = (QQAppInterface)localObject3;
      if (paramMessageForStructing.structingMsg != null)
      {
        paramQQAppInterface = (QQAppInterface)localObject3;
        if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mArticleIds))
        {
          localObject5 = paramMessageForStructing.structingMsg.mArticleIds.split("\\|");
          paramQQAppInterface = (QQAppInterface)localObject3;
          if (TextUtils.isDigitsOnly(localObject5[0])) {
            paramQQAppInterface = localObject5[0];
          }
        }
      }
      if ((paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData)))
      {
        localObject3 = PublicAccountUtil.a(paramMessageForStructing.structingMsg.mMsgActionData);
        if (localObject3 == null) {}
      }
    }
    for (;;)
    {
      Object localObject7;
      int j;
      int k;
      try
      {
        Long.parseLong(((JSONObject)localObject3).getString("id"));
        localObject3 = localObject1;
        if (paramMessageForStructing.structingMsg == null) {
          break label1260;
        }
        if (paramMessageForStructing.structingMsg.mStrategyIds != null) {
          localObject1 = paramMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
        }
        localObject3 = localObject1;
        if (paramMessageForStructing.structingMsg.mAlgorithmIds == null) {
          break label1260;
        }
        localObject3 = paramMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
        localObject8 = localObject9;
        localObject7 = localObject10;
        j = 0;
        localObject9 = paramMessageRecord.senderuin;
        k = j;
        try
        {
          localObject10 = new JSONObject(paramMessageRecord.extStr);
          k = j;
          if (!((JSONObject)localObject10).has("kdShouldShowMergedAvatar")) {
            break label1179;
          }
          k = j;
          if (!((JSONObject)localObject10).getBoolean("kdShouldShowMergedAvatar")) {
            break label1179;
          }
          k = j;
          if (paramMessageRecord.isread) {
            break label1179;
          }
          j = 1;
          localObject5 = localObject9;
          k = j;
          if (((JSONObject)localObject10).has("kdUin"))
          {
            k = j;
            localObject5 = ((JSONObject)localObject10).getString("kdUin");
          }
        }
        catch (Exception localException3)
        {
          label812:
          label825:
          localException3.printStackTrace();
          j = k;
          localObject6 = localObject9;
          continue;
          continue;
          k = 0;
          continue;
          k = 0;
          continue;
          j = 0;
          continue;
          j = 0;
          continue;
          paramMessageForStructing = "0X80066F3";
          continue;
        }
        if (i == 1) {
          break;
        }
        if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null) || (paramMessageForStructing.structingMsg.reportEventFolderStatusValue == null) || (TextUtils.isEmpty(paramMessageForStructing.structingMsg.reportEventFolderStatusValue))) {
          break label1208;
        }
        try
        {
          k = Integer.parseInt(paramMessageForStructing.structingMsg.reportEventFolderStatusValue);
          i = k;
          ReadInJoyUtils.b(String.valueOf(System.currentTimeMillis()));
        }
        catch (Exception paramMessageForStructing)
        {
          Object localObject6;
          paramMessageForStructing.printStackTrace();
        }
        try
        {
          localObject9 = new JSONObject();
          ((JSONObject)localObject9).put("folder_status", i);
          ((JSONObject)localObject9).put("algorithm_id", localObject3);
          ((JSONObject)localObject9).put("time", System.currentTimeMillis());
          if (i == 6)
          {
            ((JSONObject)localObject9).put("id", localObject8);
            ((JSONObject)localObject9).put("social_uin", localObject7);
          }
          if (!ReadInJoyUtils.c()) {
            break label1211;
          }
          k = 1;
          ((JSONObject)localObject9).put("message_status", k);
          if (ReadInJoyHelper.K(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label1217;
          }
          k = 1;
          ((JSONObject)localObject9).put("reddot_style", k);
          ((JSONObject)localObject9).put("kd_pos", ReadInJoyUtils.a());
          if (j == 0) {
            break label1223;
          }
          j = 1;
          ((JSONObject)localObject9).put("avatar", j);
          if (!ReadInJoyHelper.r(ReadInJoyUtils.a())) {
            break label1229;
          }
          j = 1;
          ((JSONObject)localObject9).put("hemera_switch", j);
          ((JSONObject)localObject9).put("kandian_mode_new", VideoReporter.a());
          if (m == 0) {
            break label1235;
          }
          paramMessageForStructing = "0X80089F1";
          PublicAccountReportUtils.a(null, "CliOper", "", (String)localObject5, paramMessageForStructing, paramMessageForStructing, 0, 0, String.valueOf(this.i + 1), paramQQAppInterface, (String)localObject1, ((JSONObject)localObject9).toString(), false);
          PublicAccountReportUtils.a(paramMessageForStructing, (String)localObject5, String.valueOf(this.i + 1), "", (String)localObject1, ((JSONObject)localObject9).toString());
          if (m == 0) {
            ReadInJoyUtils.a(20, paramQQAppInterface, (String)localObject1, (String)localObject3, (String)localObject5, i);
          }
        }
        catch (Exception paramMessageForStructing)
        {
          paramMessageForStructing.printStackTrace();
          continue;
          paramQQAppInterface = "";
          localObject2 = "";
          break label965;
        }
        if (paramMessageRecord.isread) {
          break;
        }
        ReadInJoyUtils.jdField_a_of_type_Long = System.currentTimeMillis() / 1000L;
        return;
        m = 0;
        break label71;
        paramMessageRecord.extLong ^= 0x2;
        break label86;
        i = 3;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        continue;
      }
      label841:
      Object localObject4;
      if (paramMessageRecord.extInt == 2)
      {
        if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (PublicAccountUtil.b(paramQQAppInterface, paramMessageRecord.senderuin)))
        {
          i = 4;
          paramQQAppInterface = "";
          localObject4 = "";
          localObject1 = "0";
          localObject7 = localObject10;
          localObject8 = localObject9;
        }
        else
        {
          i = 2;
          paramQQAppInterface = "";
          localObject4 = "";
          localObject1 = "0";
          localObject7 = localObject10;
          localObject8 = localObject9;
        }
      }
      else
      {
        if (paramMessageRecord.extInt == 5)
        {
          paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface.getManager(161)).a();
          if (paramQQAppInterface != null)
          {
            localObject1 = String.valueOf(paramQQAppInterface.jdField_b_of_type_Int);
            paramQQAppInterface = String.valueOf(paramQQAppInterface.e);
            label965:
            localObject5 = "";
            localObject4 = "";
            localObject9 = "0";
            i = 6;
            localObject7 = paramQQAppInterface;
            localObject8 = localObject1;
            paramQQAppInterface = (QQAppInterface)localObject5;
            localObject1 = localObject9;
          }
        }
        else
        {
          paramQQAppInterface = (QQAppInterface)localObject4;
          localObject5 = localObject1;
          localObject7 = localObject8;
          if (paramMessageRecord.extInt == 6)
          {
            i = 10;
            paramQQAppInterface = (QQAppInterface)localObject4;
            localObject5 = localObject1;
            localObject7 = localObject8;
            try
            {
              JSONObject localJSONObject = new JSONObject(paramMessageRecord.extStr);
              paramQQAppInterface = (QQAppInterface)localObject4;
              localObject5 = localObject1;
              localObject7 = localObject8;
              localObject1 = localJSONObject.getString("strategy_id");
              paramQQAppInterface = (QQAppInterface)localObject4;
              localObject5 = localObject1;
              localObject7 = localObject8;
              localObject8 = localJSONObject.getString("algorithm_id");
              paramQQAppInterface = (QQAppInterface)localObject4;
              localObject5 = localObject1;
              localObject7 = localObject8;
              localObject4 = localJSONObject.getString("article_id");
              paramQQAppInterface = (QQAppInterface)localObject4;
              localObject5 = localObject1;
              localObject7 = localObject8;
              j = localJSONObject.getInt("folder_status");
              i = j;
              paramQQAppInterface = (QQAppInterface)localObject4;
              localObject4 = localObject8;
              localObject7 = localObject10;
              localObject8 = localObject9;
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
            }
          }
          localObject4 = localObject7;
          localObject2 = localObject5;
          localObject7 = localObject10;
          localObject8 = localObject9;
          continue;
          label1179:
          j = 0;
          continue;
        }
        label1208:
        label1211:
        label1217:
        label1223:
        label1229:
        label1235:
        label1260:
        Object localObject2 = localObject4;
        localObject4 = "";
      }
    }
  }
  
  public long c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface == null) {
      return super.c();
    }
    Object localObject2 = localQQAppInterface.a();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      MessageRecord localMessageRecord = ((QQMessageFacade)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
      if (localMessageRecord == null) {
        return super.c();
      }
      if ((localMessageRecord instanceof MessageForStructing))
      {
        localObject2 = (MessageForStructing)localMessageRecord;
        localObject1 = localObject2;
        if (((MessageForStructing)localObject2).structingMsg == null)
        {
          ((MessageForStructing)localObject2).parse();
          localObject1 = localObject2;
        }
      }
      a(localMessageRecord, localObject1, localQQAppInterface);
      ReadInJoyUtils.e = ReadInJoyUtils.a();
    }
    return super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemKandianMergeData
 * JD-Core Version:    0.7.0.1
 */