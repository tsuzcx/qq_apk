package com.tencent.biz.pubaccount.ecshopassit;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ABTestUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.activateFriend.DateUtil;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp;
import tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo;
import tencent.im.oidb.qqshop.qq_ad.QQAdReport;
import tencent.im.oidb.qqshop.qq_ad.QQAdReportRsp;

public class EcshopAdHandler
  extends BusinessHandler
{
  public static int a;
  long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  public boolean a;
  public long b;
  
  static
  {
    jdField_a_of_type_Int = 300000;
  }
  
  public EcshopAdHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    }
    ThreadManagerV2.excute(new EcshopAdHandler.1(this), 16, null, false);
  }
  
  /* Error */
  public static EcshopAdHandler.ReportInfo a(EcshopAdHandler.ReportInfo paramReportInfo, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aload_0
    //   5: areturn
    //   6: aload_1
    //   7: ldc 49
    //   9: invokevirtual 55	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   12: astore 5
    //   14: aload_1
    //   15: ldc 57
    //   17: invokevirtual 55	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 4
    //   22: ldc 59
    //   24: astore_3
    //   25: aload_1
    //   26: ldc 61
    //   28: invokevirtual 55	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 6
    //   33: aload_3
    //   34: astore_2
    //   35: new 63	org/json/JSONObject
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 66	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload_3
    //   47: astore_2
    //   48: aload 4
    //   50: ldc 68
    //   52: invokevirtual 71	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload 4
    //   60: ldc 73
    //   62: invokevirtual 71	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: astore_2
    //   70: aload_0
    //   71: aload_1
    //   72: getfield 76	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   75: invokevirtual 82	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokestatic 88	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   81: putfield 92	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:jdField_a_of_type_Long	J
    //   84: aload_0
    //   85: aload_3
    //   86: putfield 95	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:k	Ljava/lang/String;
    //   89: aload_0
    //   90: aload 6
    //   92: putfield 97	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: aload_0
    //   96: aload 5
    //   98: putfield 100	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:l	Ljava/lang/String;
    //   101: aload_0
    //   102: aload_2
    //   103: putfield 102	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 105	com/tencent/biz/pubaccount/ecshopassit/EcshopAdHandler$ReportInfo:jdField_g_of_type_Int	I
    //   111: aload_0
    //   112: areturn
    //   113: astore_3
    //   114: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +12 -> 129
    //   120: ldc 113
    //   122: iconst_2
    //   123: ldc 115
    //   125: aload_3
    //   126: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: astore_3
    //   131: ldc 121
    //   133: astore_2
    //   134: goto -64 -> 70
    //   137: astore_1
    //   138: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -57 -> 84
    //   144: ldc 113
    //   146: iconst_2
    //   147: ldc 123
    //   149: aload_1
    //   150: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: goto -69 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramReportInfo	EcshopAdHandler.ReportInfo
    //   0	156	1	paramMessageRecord	MessageRecord
    //   34	100	2	localObject1	Object
    //   24	62	3	str1	String
    //   113	13	3	localException	Exception
    //   130	1	3	localObject2	Object
    //   20	48	4	localObject3	Object
    //   12	85	5	str2	String
    //   31	60	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   35	46	113	java/lang/Exception
    //   48	56	113	java/lang/Exception
    //   58	67	113	java/lang/Exception
    //   70	84	137	java/lang/Exception
  }
  
  private List<ChatMessage> a(List<ChatMessage> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
      Object localObject;
      if ((localChatMessage instanceof MessageForArkApp))
      {
        localObject = ((MessageForArkApp)localChatMessage).ark_app_message;
        if (localObject != null)
        {
          localObject = ((ArkAppMessage)localObject).metaList;
          if (StringUtil.a((String)localObject)) {}
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject((String)localObject).optJSONObject("gdt");
          if ((QLog.isColorLevel()) && (localObject != null)) {
            QLog.i("Ecshop_EcshopAdHandler", 2, "---aid---" + paramLong + "gdtJson: " + ((JSONObject)localObject).optString("aid"));
          }
          if ((localObject != null) && (paramLong == ((JSONObject)localObject).optLong("aid"))) {
            localArrayList.add(localChatMessage);
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          continue;
        }
        i += 1;
        break;
        long l1;
        if ((localException1 instanceof MessageForStructing))
        {
          localObject = ((MessageForStructing)localException1).structingMsg;
          if ((localObject instanceof StructMsgForGeneralShare))
          {
            localObject = (StructMsgForGeneralShare)localObject;
            if ((((StructMsgForGeneralShare)localObject).mStructMsgItemLists != null) && (((StructMsgForGeneralShare)localObject).mStructMsgItemLists.size() > 0))
            {
              localObject = (AbsStructMsgElement)((StructMsgForGeneralShare)localObject).mStructMsgItemLists.get(0);
              if (localObject != null) {
                l1 = 0L;
              }
            }
          }
        }
        try
        {
          long l2 = Long.parseLong(((AbsStructMsgElement)localObject).s);
          l1 = l2;
        }
        catch (Exception localException2)
        {
          label294:
          break label294;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopAdHandler", 2, "---aid---" + l1);
        }
        if (paramLong == l1) {
          localArrayList.add(localException1);
        }
      }
    }
    return localArrayList;
  }
  
  private Set<Long> a()
  {
    HashSet localHashSet = new HashSet();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    String str;
    do
    {
      return localHashSet;
      str = QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "risk_ids", "");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "---getRiskAids---" + str);
      }
    } while (StringUtil.a(str));
    return (Set)new Gson().fromJson(str, new EcshopAdHandler.2(this).getType());
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "---saveRiskAids---");
    }
    Object localObject = new Gson();
    Set localSet = a();
    localSet.add(Long.valueOf(paramLong));
    localObject = ((Gson)localObject).toJson(localSet);
    QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "risk_ids", (String)localObject);
  }
  
  public static void a(AppInterface paramAppInterface, ChatMessage paramChatMessage, View paramView)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Ecshop_EcshopAdHandler", 1, "--> bindViewForGdtReport,uin:" + paramChatMessage.senderuin);
      }
      if (!((EcShopAssistantManager)paramAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(paramChatMessage.senderuin)) {
        return;
      }
      paramChatMessage = EcShopAssistantManager.a(paramChatMessage);
      if (paramChatMessage != null)
      {
        paramView.setTag(2131381649, new GdtAd(paramChatMessage));
        paramView.setTag(2131381648, new EcshopAdHandler.3(paramAppInterface));
        return;
      }
    }
    catch (Throwable paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      QLog.d("Ecshop_EcshopAdHandler", 1, "bindViewForGdtReport:" + paramAppInterface.getStackTrace().toString());
    }
  }
  
  private void a(ArrayList<RedPointInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
        localObject = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      } while ((localObject == null) || (((ChatFragment)localObject).a == null) || (((ChatFragment)localObject).a.c == null) || (((ChatFragment)localObject).a.c.findViewById(2131364598) == null));
      localObject = ((ChatFragment)localObject).a.c.findViewById(2131364598).findViewWithTag("echopCustomTabView");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "[onResponseRedpoint]" + localObject);
      }
      if ((localObject instanceof CustomTabView))
      {
        RedPointUtil.a(paramArrayList);
        ((CustomTabView)localObject).a(paramArrayList);
        return;
      }
    } while (!(localObject instanceof CustomTitleView));
    RedPointUtil.a(paramArrayList);
    ((CustomTitleView)localObject).a(paramArrayList);
  }
  
  private void a(List<qq_ad.QQAdGetRsp.RedPointInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "[onResponseRedpoint]");
    }
    a(EcshopUtils.a(paramList));
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString != null)) {
      return a(paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return ("3046055438".equals(paramString)) || ("2711679534".equals(paramString));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "On Running Foreground,login?" + this.jdField_a_of_type_Boolean + ",current interval:" + jdField_a_of_type_Int);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while (l - this.jdField_b_of_type_Long <= jdField_a_of_type_Int);
    this.jdField_b_of_type_Long = l;
    a(null, null, false, null, 3);
  }
  
  public void a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    EcshopAdHandler.ReportInfo localReportInfo = new EcshopAdHandler.ReportInfo();
    localReportInfo.jdField_a_of_type_Int = paramInt;
    a(localReportInfo, paramMessageRecord);
    a(localReportInfo, null);
  }
  
  public void a(EcshopAdHandler.ReportInfo paramReportInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "do ad report info:" + paramReportInfo.toString());
    }
    qq_ad.QQAdReport localQQAdReport;
    Object localObject2;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "trpc.qqshop.adreport.ReportService.AdReport";
      localQQAdReport = new qq_ad.QQAdReport();
      localQQAdReport.type.set(paramReportInfo.jdField_a_of_type_Int);
      localObject2 = localQQAdReport.view_id;
      if (paramReportInfo.jdField_a_of_type_JavaLangString != null) {
        break label628;
      }
      localObject1 = "";
      label84:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.trace_id;
      if (paramReportInfo.jdField_b_of_type_JavaLangString != null) {
        break label636;
      }
      localObject1 = "";
      label107:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.act_time.set((int)(System.currentTimeMillis() / 1000L));
      localObject2 = localQQAdReport.sns_uid;
      if (paramReportInfo.jdField_c_of_type_JavaLangString != null) {
        break label644;
      }
      localObject1 = "";
      label146:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.resolution;
      if (paramReportInfo.jdField_d_of_type_JavaLangString != null) {
        break label652;
      }
      localObject1 = "";
      label169:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.referer;
      if (paramReportInfo.jdField_e_of_type_JavaLangString != null) {
        break label660;
      }
      localObject1 = "";
      label192:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.user_agent;
      if (paramReportInfo.jdField_f_of_type_JavaLangString != null) {
        break label668;
      }
      localObject1 = "";
      label215:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.q_user_agent;
      if (paramReportInfo.jdField_g_of_type_JavaLangString != null) {
        break label676;
      }
      localObject1 = "";
      label238:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.feeds_index.set(paramReportInfo.jdField_b_of_type_Int);
      localQQAdReport.is_impression.set(paramReportInfo.jdField_a_of_type_Boolean);
      localQQAdReport.is_installed.set(paramReportInfo.jdField_b_of_type_Boolean);
      localObject2 = localQQAdReport.feeds_video_attachment;
      if (paramReportInfo.h != null) {
        break label684;
      }
      localObject1 = "";
      label297:
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.platform_id.set(109);
      localObject2 = localQQAdReport.imei;
      if (MobileInfoUtil.c() != null) {
        break label692;
      }
      localObject1 = "";
      label329:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.click_source;
      if (paramReportInfo.i != null) {
        break label699;
      }
      localObject1 = "";
      label352:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.antispam_info;
      if (paramReportInfo.j != null) {
        break label707;
      }
      localObject1 = "";
      label375:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = DeviceInfoUtil.c(BaseApplicationImpl.getApplication().getApplicationContext());
      PBStringField localPBStringField = localQQAdReport.hardware_addr;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localPBStringField.set((String)localObject1);
      localQQAdReport.stay_time.set(paramReportInfo.jdField_c_of_type_Int);
      localQQAdReport.net_type.set(HttpUtil.getNetWorkType());
      localQQAdReport.client_id.set(paramReportInfo.jdField_d_of_type_Int);
      localQQAdReport.action_id.set(paramReportInfo.jdField_e_of_type_Int);
      localQQAdReport.msg_floor.set(paramReportInfo.jdField_f_of_type_Int);
      localQQAdReport.puin.set(paramReportInfo.jdField_a_of_type_Long);
      localQQAdReport.ad_puin.set(paramReportInfo.jdField_b_of_type_Long);
      localQQAdReport.version.set("8.5.5");
      localObject2 = localQQAdReport.ad_id;
      if (paramReportInfo.k != null) {
        break label715;
      }
      localObject1 = "";
      label527:
      ((PBStringField)localObject2).set((String)localObject1);
      localObject2 = localQQAdReport.msgid;
      if (paramReportInfo.l != null) {
        break label723;
      }
    }
    label644:
    label652:
    label660:
    label668:
    label676:
    label684:
    label692:
    label699:
    label707:
    label715:
    label723:
    for (Object localObject1 = "";; localObject1 = paramReportInfo.l)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localQQAdReport.get_back.set(false);
      localQQAdReport.source.set(paramReportInfo.jdField_g_of_type_Int);
      paramReportInfo = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramString);
      paramReportInfo.putWupBuffer(localQQAdReport.toByteArray());
      super.sendPbReq(paramReportInfo);
      return;
      Cmd2HandlerMapHelper.a(paramString, new String[] { BusinessHandlerFactory.ESHOP_AD_HANDLER });
      break;
      label628:
      localObject1 = paramReportInfo.jdField_a_of_type_JavaLangString;
      break label84;
      label636:
      localObject1 = paramReportInfo.jdField_b_of_type_JavaLangString;
      break label107;
      localObject1 = paramReportInfo.jdField_c_of_type_JavaLangString;
      break label146;
      localObject1 = paramReportInfo.jdField_d_of_type_JavaLangString;
      break label169;
      localObject1 = paramReportInfo.jdField_e_of_type_JavaLangString;
      break label192;
      localObject1 = paramReportInfo.jdField_f_of_type_JavaLangString;
      break label215;
      localObject1 = paramReportInfo.jdField_g_of_type_JavaLangString;
      break label238;
      localObject1 = paramReportInfo.h;
      break label297;
      localObject1 = MobileInfoUtil.c();
      break label329;
      localObject1 = paramReportInfo.i;
      break label352;
      localObject1 = paramReportInfo.j;
      break label375;
      localObject1 = paramReportInfo.k;
      break label527;
    }
  }
  
  public void a(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopAdHandler", 2, "pull ad pos:" + paramList + ",count:" + paramList1 + ",syn:" + paramBoolean);
    }
    try
    {
      String str1 = DateUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "currentTs:" + str1);
      }
      String str2 = QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "risk_ad_del_time", str1);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopAdHandler", 2, "cacheTs:" + str2);
      }
      if (!str1.equals(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop_EcshopAdHandler", 2, "---removeRiskAids---");
        }
        QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "risk_ids");
      }
      if (TextUtils.isEmpty(paramString)) {
        paramString = "trpc.qqshop.adpush.PushService.GetAd";
      }
      for (;;)
      {
        ThreadManagerV2.excute(new EcshopAdHandler.4(this, paramInt, paramList, paramList1, paramBoolean, paramString), 16, null, false);
        return;
        this.jdField_a_of_type_JavaLangString = paramString;
      }
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("Ecshop_EcshopAdHandler", 1, "pullAd failed err msg: " + paramList.getMessage());
    }
  }
  
  public void a(qq_ad.QQAdGetRsp paramQQAdGetRsp)
  {
    if ((paramQQAdGetRsp.del_aid.has()) && ((BaseActivity.sTopActivity instanceof FragmentActivity)))
    {
      ChatFragment localChatFragment = ((FragmentActivity)BaseActivity.sTopActivity).getChatFragment();
      Object localObject1 = paramQQAdGetRsp.del_aid.get();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramQQAdGetRsp = a();
        if (QLog.isColorLevel()) {
          QLog.d("Ecshop_EcshopAdHandler", 2, "---cacheRiskAids---" + paramQQAdGetRsp);
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject1).next();
          if (paramQQAdGetRsp.contains(localLong))
          {
            if (QLog.isColorLevel()) {
              QLog.i("Ecshop_EcshopAdHandler", 2, "already deleted!!!");
            }
          }
          else if ((localChatFragment != null) && (localChatFragment.a != null))
          {
            Object localObject2 = a(localChatFragment.a.a.a(), localLong.longValue());
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject2).next();
                localChatFragment.a.a(localChatMessage);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
                QWalletSetting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "risk_ad_del_time", DateUtil.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd"));
              }
              a(localLong.longValue());
            }
          }
        }
      }
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return EcshopAdObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      if (("trpc.qqshop.adpush.PushService.GetAd".equals(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(paramToServiceMsg.getServiceCmd()))))
      {
        paramToServiceMsg = new qq_ad.QQAdGetRsp();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramFromServiceMsg = paramToServiceMsg.tab_policy.get();
          if (!TextUtils.isEmpty(paramFromServiceMsg)) {
            ABTestUtil.a(paramFromServiceMsg);
          }
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop_EcshopAdHandler", 2, "redpoint info: " + paramToServiceMsg.red_point.toString());
          }
          paramFromServiceMsg = RedPointUtil.a();
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
            a(paramToServiceMsg.red_point.get());
          }
          a(paramToServiceMsg);
          notifyUI(1, true, paramToServiceMsg);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyUI(2, false, paramToServiceMsg);
          QLog.e("Ecshop_EcshopAdHandler", 2, "Get ad error:", paramFromServiceMsg);
          return;
        }
      }
      paramToServiceMsg = new qq_ad.QQAdReportRsp();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel())
        {
          QLog.i("Ecshop_EcshopAdHandler", 2, "rsp:" + JSONUtils.a(paramToServiceMsg));
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("Ecshop_EcshopAdHandler", 2, "Report error:", paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler
 * JD-Core Version:    0.7.0.1
 */