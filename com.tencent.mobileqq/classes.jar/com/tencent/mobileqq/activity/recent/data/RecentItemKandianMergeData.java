package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
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
import xin;

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
    if (ReadInJoyHelper.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
    for (this.jdField_b_of_type_Int = 1;; this.jdField_b_of_type_Int = 2)
    {
      this.e = BaseApplicationImpl.getApplication().getResources().getColor(2131494281);
      return;
    }
  }
  
  private void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (!ReadInJoyHelper.t(paramQQAppInterface)) {}
    while ((paramMessageRecord.isread) || ((paramMessageRecord.extLong & 0x2) == 0)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime = l;
    ThreadManager.executeOnSubThread(new xin(this, paramQQAppInterface, paramMessageRecord, l));
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
      this.jdField_d_of_type_Int = 2130839745;
      MsgSummary localMsgSummary;
      if (ReadInJoyHelper.I(BaseApplicationImpl.getApplication().getRuntime()) == 1)
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
        if ((ReadInJoyHelper.I(BaseApplicationImpl.getApplication().getRuntime()) == 1) && (this.jdField_c_of_type_Int == 1))
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
          localMsgSummary.b = paramQQAppInterface.getApp().getResources().getString(2131428458);
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
        if ((localMessageRecord.extInt == 5) || (localMessageRecord.extInt == 6) || ((localMessageRecord.extInt == 2) && (TextUtils.equals(localMessageRecord.senderuin, AppConstants.ar))))
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
        if ((localMessageRecord.extInt == 2) && (!TextUtils.equals(localMessageRecord.senderuin, AppConstants.ar)))
        {
          if (!PublicAccountUtil.a(paramQQAppInterface, localMessage.senderuin, localMessage.msgtype))
          {
            this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131430058);
            break label307;
          }
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getString(2131430057);
          break label307;
        }
        if ((localMessageRecord.extInt != 5) && (localMessageRecord.extInt != 6) && ((localMessageRecord.extInt != 2) || (!TextUtils.equals(localMessageRecord.senderuin, AppConstants.ar)) || (TextUtils.isEmpty(localMessageRecord.extStr)))) {
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
  
  /* Error */
  public void a(MessageRecord paramMessageRecord, MessageForStructing paramMessageForStructing, QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   4: iconst_1
    //   5: if_icmpeq +28 -> 33
    //   8: aload_1
    //   9: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   12: iconst_2
    //   13: if_icmpeq +20 -> 33
    //   16: aload_1
    //   17: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   20: iconst_5
    //   21: if_icmpeq +12 -> 33
    //   24: aload_1
    //   25: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   28: bipush 6
    //   30: if_icmpne +423 -> 453
    //   33: aload_1
    //   34: getfield 64	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   37: iconst_1
    //   38: iand
    //   39: ifne +12 -> 51
    //   42: aload_1
    //   43: getfield 64	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   46: iconst_2
    //   47: iand
    //   48: ifeq +405 -> 453
    //   51: aload_1
    //   52: getfield 64	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   55: iconst_1
    //   56: iand
    //   57: iconst_1
    //   58: if_icmpeq +396 -> 454
    //   61: iconst_1
    //   62: istore 7
    //   64: iload 7
    //   66: ifne +394 -> 460
    //   69: aload_1
    //   70: aload_1
    //   71: getfield 64	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   74: iconst_1
    //   75: ixor
    //   76: putfield 64	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   79: new 456	xim
    //   82: dup
    //   83: aload_0
    //   84: aload_3
    //   85: aload_1
    //   86: invokespecial 459	xim:<init>	(Lcom/tencent/mobileqq/activity/recent/data/RecentItemKandianMergeData;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   89: bipush 8
    //   91: aconst_null
    //   92: iconst_0
    //   93: invokestatic 463	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   96: iconst_1
    //   97: istore 4
    //   99: ldc_w 465
    //   102: astore 8
    //   104: ldc 94
    //   106: astore 12
    //   108: ldc 94
    //   110: astore 13
    //   112: ldc 94
    //   114: astore 14
    //   116: ldc 94
    //   118: astore 9
    //   120: aload_1
    //   121: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   124: iconst_1
    //   125: if_icmpne +364 -> 489
    //   128: aload_2
    //   129: ifnull +360 -> 489
    //   132: aload_3
    //   133: sipush 161
    //   136: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   139: checkcast 441	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   142: astore_3
    //   143: aload_3
    //   144: ifnull +329 -> 473
    //   147: aload_3
    //   148: aload_1
    //   149: invokevirtual 468	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:a	(Lcom/tencent/mobileqq/data/MessageRecord;)I
    //   152: iconst_1
    //   153: if_icmpne +320 -> 473
    //   156: iconst_5
    //   157: istore 4
    //   159: aload 9
    //   161: astore_3
    //   162: aload_2
    //   163: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   166: ifnull +52 -> 218
    //   169: aload 9
    //   171: astore_3
    //   172: aload_2
    //   173: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   176: getfield 471	com/tencent/mobileqq/structmsg/AbsStructMsg:mArticleIds	Ljava/lang/String;
    //   179: invokestatic 208	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +36 -> 218
    //   185: aload_2
    //   186: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   189: getfield 471	com/tencent/mobileqq/structmsg/AbsStructMsg:mArticleIds	Ljava/lang/String;
    //   192: ldc_w 473
    //   195: invokevirtual 477	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   198: astore 10
    //   200: aload 9
    //   202: astore_3
    //   203: aload 10
    //   205: iconst_0
    //   206: aaload
    //   207: invokestatic 480	android/text/TextUtils:isDigitsOnly	(Ljava/lang/CharSequence;)Z
    //   210: ifeq +8 -> 218
    //   213: aload 10
    //   215: iconst_0
    //   216: aaload
    //   217: astore_3
    //   218: aload_2
    //   219: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   222: ifnull +45 -> 267
    //   225: aload_2
    //   226: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   229: getfield 483	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgActionData	Ljava/lang/String;
    //   232: invokestatic 208	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   235: ifne +32 -> 267
    //   238: aload_2
    //   239: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   242: getfield 483	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgActionData	Ljava/lang/String;
    //   245: invokestatic 486	com/tencent/biz/pubaccount/util/PublicAccountUtil:a	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   248: astore 9
    //   250: aload 9
    //   252: ifnull +15 -> 267
    //   255: aload 9
    //   257: ldc_w 488
    //   260: invokevirtual 449	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   263: invokestatic 494	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   266: pop2
    //   267: aload 8
    //   269: astore 9
    //   271: aload_2
    //   272: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   275: ifnull +979 -> 1254
    //   278: aload_2
    //   279: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   282: getfield 497	com/tencent/mobileqq/structmsg/AbsStructMsg:mStrategyIds	Ljava/lang/String;
    //   285: ifnull +20 -> 305
    //   288: aload_2
    //   289: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   292: getfield 497	com/tencent/mobileqq/structmsg/AbsStructMsg:mStrategyIds	Ljava/lang/String;
    //   295: ldc_w 473
    //   298: invokevirtual 477	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   301: iconst_0
    //   302: aaload
    //   303: astore 8
    //   305: aload 8
    //   307: astore 9
    //   309: aload_2
    //   310: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   313: getfield 500	com/tencent/mobileqq/structmsg/AbsStructMsg:mAlgorithmIds	Ljava/lang/String;
    //   316: ifnull +938 -> 1254
    //   319: aload_2
    //   320: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   323: getfield 500	com/tencent/mobileqq/structmsg/AbsStructMsg:mAlgorithmIds	Ljava/lang/String;
    //   326: ldc_w 473
    //   329: invokevirtual 477	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   332: iconst_0
    //   333: aaload
    //   334: astore 9
    //   336: aload 13
    //   338: astore 12
    //   340: aload 14
    //   342: astore 11
    //   344: iconst_0
    //   345: istore 5
    //   347: aload_1
    //   348: getfield 320	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   351: astore 13
    //   353: iload 5
    //   355: istore 6
    //   357: new 435	org/json/JSONObject
    //   360: dup
    //   361: aload_1
    //   362: getfield 433	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   365: invokespecial 439	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   368: astore 14
    //   370: iload 5
    //   372: istore 6
    //   374: aload 14
    //   376: ldc_w 502
    //   379: invokevirtual 446	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   382: ifeq +445 -> 827
    //   385: iload 5
    //   387: istore 6
    //   389: aload 14
    //   391: ldc_w 502
    //   394: invokevirtual 505	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   397: ifeq +430 -> 827
    //   400: iload 5
    //   402: istore 6
    //   404: aload_1
    //   405: getfield 61	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   408: ifne +419 -> 827
    //   411: iconst_1
    //   412: istore 5
    //   414: aload 13
    //   416: astore 10
    //   418: iload 5
    //   420: istore 6
    //   422: aload 14
    //   424: ldc_w 507
    //   427: invokevirtual 446	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   430: ifeq +17 -> 447
    //   433: iload 5
    //   435: istore 6
    //   437: aload 14
    //   439: ldc_w 507
    //   442: invokevirtual 449	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: astore 10
    //   447: iload 4
    //   449: iconst_1
    //   450: if_icmpne +401 -> 851
    //   453: return
    //   454: iconst_0
    //   455: istore 7
    //   457: goto -393 -> 64
    //   460: aload_1
    //   461: aload_1
    //   462: getfield 64	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   465: iconst_2
    //   466: ixor
    //   467: putfield 64	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   470: goto -391 -> 79
    //   473: iconst_3
    //   474: istore 4
    //   476: goto -317 -> 159
    //   479: astore 9
    //   481: aload 9
    //   483: invokevirtual 454	java/lang/Exception:printStackTrace	()V
    //   486: goto -219 -> 267
    //   489: aload_1
    //   490: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   493: iconst_2
    //   494: if_icmpne +76 -> 570
    //   497: aload_1
    //   498: getfield 320	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   501: invokestatic 208	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   504: ifne +40 -> 544
    //   507: aload_3
    //   508: aload_1
    //   509: getfield 320	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   512: invokestatic 510	com/tencent/biz/pubaccount/util/PublicAccountUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   515: ifeq +29 -> 544
    //   518: iconst_4
    //   519: istore 4
    //   521: ldc 94
    //   523: astore_3
    //   524: ldc 94
    //   526: astore 9
    //   528: ldc_w 465
    //   531: astore 8
    //   533: aload 14
    //   535: astore 11
    //   537: aload 13
    //   539: astore 12
    //   541: goto -197 -> 344
    //   544: iconst_2
    //   545: istore 4
    //   547: ldc 94
    //   549: astore_3
    //   550: ldc 94
    //   552: astore 9
    //   554: ldc_w 465
    //   557: astore 8
    //   559: aload 14
    //   561: astore 11
    //   563: aload 13
    //   565: astore 12
    //   567: goto -223 -> 344
    //   570: aload_1
    //   571: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   574: iconst_5
    //   575: if_icmpne +72 -> 647
    //   578: aload_3
    //   579: sipush 161
    //   582: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   585: checkcast 441	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   588: invokevirtual 513	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/struct/KandianOx210MsgInfo;
    //   591: astore_3
    //   592: aload_3
    //   593: ifnull +651 -> 1244
    //   596: aload_3
    //   597: getfield 516	com/tencent/biz/pubaccount/readinjoy/struct/KandianOx210MsgInfo:jdField_b_of_type_Int	I
    //   600: invokestatic 105	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   603: astore 8
    //   605: aload_3
    //   606: getfield 518	com/tencent/biz/pubaccount/readinjoy/struct/KandianOx210MsgInfo:e	J
    //   609: invokestatic 521	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   612: astore_3
    //   613: ldc 94
    //   615: astore 10
    //   617: ldc 94
    //   619: astore 9
    //   621: ldc_w 465
    //   624: astore 13
    //   626: bipush 6
    //   628: istore 4
    //   630: aload_3
    //   631: astore 11
    //   633: aload 8
    //   635: astore 12
    //   637: aload 10
    //   639: astore_3
    //   640: aload 13
    //   642: astore 8
    //   644: goto -300 -> 344
    //   647: aload 9
    //   649: astore_3
    //   650: aload 8
    //   652: astore 10
    //   654: aload 12
    //   656: astore 11
    //   658: aload_1
    //   659: getfield 190	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   662: bipush 6
    //   664: if_icmpne +144 -> 808
    //   667: bipush 10
    //   669: istore 4
    //   671: aload 9
    //   673: astore_3
    //   674: aload 8
    //   676: astore 10
    //   678: aload 12
    //   680: astore 11
    //   682: new 435	org/json/JSONObject
    //   685: dup
    //   686: aload_1
    //   687: getfield 433	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   690: invokespecial 439	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   693: astore 15
    //   695: aload 9
    //   697: astore_3
    //   698: aload 8
    //   700: astore 10
    //   702: aload 12
    //   704: astore 11
    //   706: aload 15
    //   708: ldc_w 523
    //   711: invokevirtual 449	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   714: astore 8
    //   716: aload 9
    //   718: astore_3
    //   719: aload 8
    //   721: astore 10
    //   723: aload 12
    //   725: astore 11
    //   727: aload 15
    //   729: ldc_w 525
    //   732: invokevirtual 449	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   735: astore 12
    //   737: aload 9
    //   739: astore_3
    //   740: aload 8
    //   742: astore 10
    //   744: aload 12
    //   746: astore 11
    //   748: aload 15
    //   750: ldc_w 527
    //   753: invokevirtual 449	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: astore 9
    //   758: aload 9
    //   760: astore_3
    //   761: aload 8
    //   763: astore 10
    //   765: aload 12
    //   767: astore 11
    //   769: aload 15
    //   771: ldc_w 529
    //   774: invokevirtual 533	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   777: istore 5
    //   779: iload 5
    //   781: istore 4
    //   783: aload 9
    //   785: astore_3
    //   786: aload 12
    //   788: astore 9
    //   790: aload 14
    //   792: astore 11
    //   794: aload 13
    //   796: astore 12
    //   798: goto -454 -> 344
    //   801: astore 8
    //   803: aload 8
    //   805: invokevirtual 454	java/lang/Exception:printStackTrace	()V
    //   808: aload 11
    //   810: astore 9
    //   812: aload 10
    //   814: astore 8
    //   816: aload 14
    //   818: astore 11
    //   820: aload 13
    //   822: astore 12
    //   824: goto -480 -> 344
    //   827: iconst_0
    //   828: istore 5
    //   830: goto -416 -> 414
    //   833: astore 10
    //   835: aload 10
    //   837: invokevirtual 454	java/lang/Exception:printStackTrace	()V
    //   840: iload 6
    //   842: istore 5
    //   844: aload 13
    //   846: astore 10
    //   848: goto -401 -> 447
    //   851: aload_2
    //   852: ifnull +350 -> 1202
    //   855: aload_2
    //   856: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   859: ifnull +343 -> 1202
    //   862: aload_2
    //   863: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   866: getfield 536	com/tencent/mobileqq/structmsg/AbsStructMsg:reportEventFolderStatusValue	Ljava/lang/String;
    //   869: ifnull +333 -> 1202
    //   872: aload_2
    //   873: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   876: getfield 536	com/tencent/mobileqq/structmsg/AbsStructMsg:reportEventFolderStatusValue	Ljava/lang/String;
    //   879: invokestatic 208	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   882: ifne +320 -> 1202
    //   885: aload_2
    //   886: getfield 166	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   889: getfield 536	com/tencent/mobileqq/structmsg/AbsStructMsg:reportEventFolderStatusValue	Ljava/lang/String;
    //   892: invokestatic 541	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   895: istore 6
    //   897: iload 6
    //   899: istore 4
    //   901: invokestatic 546	java/lang/System:currentTimeMillis	()J
    //   904: invokestatic 521	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   907: invokestatic 550	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:b	(Ljava/lang/String;)V
    //   910: new 435	org/json/JSONObject
    //   913: dup
    //   914: invokespecial 551	org/json/JSONObject:<init>	()V
    //   917: astore 13
    //   919: aload 13
    //   921: ldc_w 529
    //   924: iload 4
    //   926: invokevirtual 555	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   929: pop
    //   930: aload 13
    //   932: ldc_w 525
    //   935: aload 9
    //   937: invokevirtual 558	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   940: pop
    //   941: aload 13
    //   943: ldc_w 560
    //   946: invokestatic 546	java/lang/System:currentTimeMillis	()J
    //   949: invokevirtual 563	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   952: pop
    //   953: iload 4
    //   955: bipush 6
    //   957: if_icmpne +25 -> 982
    //   960: aload 13
    //   962: ldc_w 488
    //   965: aload 12
    //   967: invokevirtual 558	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   970: pop
    //   971: aload 13
    //   973: ldc_w 565
    //   976: aload 11
    //   978: invokevirtual 558	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   981: pop
    //   982: invokestatic 567	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:c	()Z
    //   985: ifeq +220 -> 1205
    //   988: iconst_1
    //   989: istore 6
    //   991: aload 13
    //   993: ldc_w 569
    //   996: iload 6
    //   998: invokevirtual 555	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1001: pop
    //   1002: invokestatic 23	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1005: invokevirtual 27	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1008: invokestatic 33	cooperation/readinjoy/ReadInJoyHelper:I	(Lmqq/app/AppRuntime;)I
    //   1011: iconst_1
    //   1012: if_icmpne +199 -> 1211
    //   1015: iconst_1
    //   1016: istore 6
    //   1018: aload 13
    //   1020: ldc_w 571
    //   1023: iload 6
    //   1025: invokevirtual 555	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1028: pop
    //   1029: aload 13
    //   1031: ldc_w 573
    //   1034: invokestatic 575	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()I
    //   1037: invokevirtual 555	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1040: pop
    //   1041: iload 5
    //   1043: ifeq +174 -> 1217
    //   1046: iconst_1
    //   1047: istore 5
    //   1049: aload 13
    //   1051: ldc_w 577
    //   1054: iload 5
    //   1056: invokevirtual 555	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1059: pop
    //   1060: invokestatic 579	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	()Lmqq/app/AppRuntime;
    //   1063: invokestatic 582	cooperation/readinjoy/ReadInJoyHelper:q	(Lmqq/app/AppRuntime;)Z
    //   1066: ifeq +157 -> 1223
    //   1069: iconst_1
    //   1070: istore 5
    //   1072: aload 13
    //   1074: ldc_w 584
    //   1077: iload 5
    //   1079: invokevirtual 555	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1082: pop
    //   1083: aload 13
    //   1085: ldc_w 586
    //   1088: invokestatic 589	com/tencent/biz/pubaccount/VideoReporter:a	()I
    //   1091: invokevirtual 555	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1094: pop
    //   1095: iload 7
    //   1097: ifeq +132 -> 1229
    //   1100: ldc_w 591
    //   1103: astore_2
    //   1104: aconst_null
    //   1105: ldc 92
    //   1107: ldc 94
    //   1109: aload 10
    //   1111: aload_2
    //   1112: aload_2
    //   1113: iconst_0
    //   1114: iconst_0
    //   1115: aload_0
    //   1116: getfield 99	com/tencent/mobileqq/activity/recent/data/RecentItemKandianMergeData:i	I
    //   1119: iconst_1
    //   1120: iadd
    //   1121: invokestatic 105	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1124: aload_3
    //   1125: aload 8
    //   1127: aload 13
    //   1129: invokevirtual 592	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1132: iconst_0
    //   1133: invokestatic 110	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1136: aload_2
    //   1137: aload 10
    //   1139: aload_0
    //   1140: getfield 99	com/tencent/mobileqq/activity/recent/data/RecentItemKandianMergeData:i	I
    //   1143: iconst_1
    //   1144: iadd
    //   1145: invokestatic 105	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1148: ldc 94
    //   1150: aload 8
    //   1152: aload 13
    //   1154: invokevirtual 592	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1157: invokestatic 595	com/tencent/biz/pubaccount/PublicAccountReportUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1160: iload 7
    //   1162: ifne +17 -> 1179
    //   1165: bipush 20
    //   1167: aload_3
    //   1168: aload 8
    //   1170: aload 9
    //   1172: aload 10
    //   1174: iload 4
    //   1176: invokestatic 598	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   1179: aload_1
    //   1180: getfield 61	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   1183: ifne -730 -> 453
    //   1186: invokestatic 546	java/lang/System:currentTimeMillis	()J
    //   1189: ldc2_w 599
    //   1192: ldiv
    //   1193: putstatic 601	com/tencent/biz/pubaccount/readinjoy/common/ReadInJoyUtils:jdField_a_of_type_Long	J
    //   1196: return
    //   1197: astore_2
    //   1198: aload_2
    //   1199: invokevirtual 454	java/lang/Exception:printStackTrace	()V
    //   1202: goto -301 -> 901
    //   1205: iconst_0
    //   1206: istore 6
    //   1208: goto -217 -> 991
    //   1211: iconst_0
    //   1212: istore 6
    //   1214: goto -196 -> 1018
    //   1217: iconst_0
    //   1218: istore 5
    //   1220: goto -171 -> 1049
    //   1223: iconst_0
    //   1224: istore 5
    //   1226: goto -154 -> 1072
    //   1229: ldc_w 603
    //   1232: astore_2
    //   1233: goto -129 -> 1104
    //   1236: astore_2
    //   1237: aload_2
    //   1238: invokevirtual 454	java/lang/Exception:printStackTrace	()V
    //   1241: goto -62 -> 1179
    //   1244: ldc 94
    //   1246: astore_3
    //   1247: ldc 94
    //   1249: astore 8
    //   1251: goto -638 -> 613
    //   1254: aload 9
    //   1256: astore 8
    //   1258: ldc 94
    //   1260: astore 9
    //   1262: goto -926 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1265	0	this	RecentItemKandianMergeData
    //   0	1265	1	paramMessageRecord	MessageRecord
    //   0	1265	2	paramMessageForStructing	MessageForStructing
    //   0	1265	3	paramQQAppInterface	QQAppInterface
    //   97	1078	4	i	int
    //   345	880	5	j	int
    //   355	858	6	k	int
    //   62	1099	7	m	int
    //   102	660	8	localObject1	Object
    //   801	3	8	localException1	Exception
    //   814	443	8	localObject2	Object
    //   118	217	9	localObject3	Object
    //   479	3	9	localException2	Exception
    //   526	735	9	localObject4	Object
    //   198	615	10	localObject5	Object
    //   833	3	10	localException3	Exception
    //   846	327	10	localObject6	Object
    //   342	635	11	localObject7	Object
    //   106	860	12	localObject8	Object
    //   110	1043	13	localObject9	Object
    //   114	703	14	localObject10	Object
    //   693	77	15	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   255	267	479	java/lang/Exception
    //   682	695	801	java/lang/Exception
    //   706	716	801	java/lang/Exception
    //   727	737	801	java/lang/Exception
    //   748	758	801	java/lang/Exception
    //   769	779	801	java/lang/Exception
    //   357	370	833	java/lang/Exception
    //   374	385	833	java/lang/Exception
    //   389	400	833	java/lang/Exception
    //   404	411	833	java/lang/Exception
    //   422	433	833	java/lang/Exception
    //   437	447	833	java/lang/Exception
    //   885	897	1197	java/lang/Exception
    //   910	953	1236	java/lang/Exception
    //   960	982	1236	java/lang/Exception
    //   982	988	1236	java/lang/Exception
    //   991	1015	1236	java/lang/Exception
    //   1018	1041	1236	java/lang/Exception
    //   1049	1069	1236	java/lang/Exception
    //   1072	1095	1236	java/lang/Exception
    //   1104	1160	1236	java/lang/Exception
    //   1165	1179	1236	java/lang/Exception
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