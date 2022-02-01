package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJLockScreenPushReport;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.UserOptInfo;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager;
import com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.math.BigInteger;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJKanDianTabReport
{
  public static int a;
  public static long a;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Int = 0;
  }
  
  private static int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo == null) {
      return 1;
    }
    if (paramRedTypeInfo.red_type.get() == 5) {
      return 3;
    }
    return 2;
  }
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("jumpType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("RIJKanDianTabReport", 1, "getReportLoadModeFromLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        paramString = new BigInteger(paramString);
        QLog.d("RIJKanDianTabReport", 2, new Object[] { "convertArticleID bigInteger long value = ", Long.valueOf(paramString.longValue()) });
        return "" + paramString.longValue();
        paramString = "0";
      }
      return "0";
    }
    catch (Exception paramString)
    {
      QLog.d("RIJKanDianTabReport", 1, new Object[] { "convertArticleID e = ", paramString.toString() });
    }
  }
  
  private static Pair<Integer, Long> a(int paramInt)
  {
    if (paramInt == 1) {
      return new Pair(Integer.valueOf(0), Long.valueOf(0L));
    }
    if (RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Long == 0L) {
      return new Pair(Integer.valueOf(1), Long.valueOf(NetConnInfoCenter.getServerTime() - RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_Long));
    }
    return new Pair(Integer.valueOf(0), Long.valueOf(NetConnInfoCenter.getServerTime() - RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Long));
  }
  
  public static void a()
  {
    if (!RIJXTabFrameUtils.a.a()) {
      a(false);
    }
  }
  
  public static void a(int paramInt1, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    int j = 6;
    int i;
    if (RIJXTabConfigHandler.b().a())
    {
      i = 7;
      if ((paramInt1 != 9) && (paramInt1 != 6)) {
        break label57;
      }
      j = 5;
    }
    for (;;)
    {
      ReadinjoyReportUtils.a(j, paramBoolean, paramLong, RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int, paramInt2, true, paramInt3);
      return;
      i = 2;
      break;
      label57:
      if (paramInt1 != 13) {
        j = i;
      }
    }
  }
  
  public static void a(long paramLong)
  {
    if (paramLong > 0L) {
      ThreadManager.executeOnSubThread(new RIJKanDianTabReport.5(paramLong));
    }
  }
  
  public static void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    localReportR5Builder.a(paramTabChannelCoverInfo.mChannelCoverId).f().b();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate((QQAppInterface)ReadInJoyUtils.a(), "dc01160", "", "", "0X800B7A1", "0X800B7A1", 1, 1, "", "", "", localReportR5Builder.a(), false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.2(paramQQAppInterface));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Intent paramIntent)
  {
    RIJKanDianFolderStatus.a(paramQQAppInterface);
    if (paramInt == 5) {}
    for (;;)
    {
      try
      {
        a(paramQQAppInterface, false);
        paramIntent = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        if (paramIntent != null)
        {
          paramIntent.d(false);
          paramIntent.h();
          QLog.d("RIJKanDianTabReport", 1, "[doReportForEnterTab] KandianMergeManager#setReaded");
        }
        ReadinjoyReportUtils.a(paramQQAppInterface, false);
        ReadinjoySPEventReport.a().a.a(true);
        paramIntent = RIJKanDianFolderStatus.a(0);
        if ((!TextUtils.equals("1", paramIntent)) && (!TextUtils.equals("0", paramIntent))) {
          break label211;
        }
        paramInt = UserActionCollector.d;
        UserActionCollector.a().a(paramInt, 1);
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramInt = RIJAppSetting.a();
        int i = RIJKanDianFolderStatus.jdField_a_of_type_Int;
        ReadInJoyGlobalReporter.a().a(paramQQAppInterface, l, paramInt, i);
        ThreadManager.executeOnSubThread(new RIJKanDianTabReport.3(paramQQAppInterface, l, paramInt, i));
        return;
      }
      catch (JSONException paramIntent)
      {
        QLog.e("RIJKanDianTabReport", 1, paramIntent, new Object[0]);
        continue;
      }
      if (paramInt == 6)
      {
        RIJLockScreenPushReport.a();
      }
      else if (paramInt == 13)
      {
        if (paramIntent != null) {}
        for (paramIntent = paramIntent.getStringExtra("folder_status");; paramIntent = null)
        {
          if (TextUtils.isEmpty(paramIntent)) {
            break label204;
          }
          RIJKanDianFolderStatus.a(Integer.parseInt(paramIntent));
          break;
        }
        label204:
        RIJKanDianFolderStatus.a(-1);
        continue;
        label211:
        if (paramInt == 13) {
          paramInt = UserActionCollector.f;
        } else {
          paramInt = UserActionCollector.e;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ReadInJoyBaseFragment paramReadInJoyBaseFragment)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ReadinjoyReportUtils.a(false);
    Object localObject = (ReadInJoySkinManager)paramQQAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    RefreshData localRefreshData;
    int i;
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder;
    if ((((ReadInJoySkinManager)localObject).a() == 1) && (!TextUtils.isEmpty(((ReadInJoySkinManager)localObject).a())))
    {
      localObject = ((ReadInJoySkinManager)localObject).a();
      localRefreshData = ReadInJoyRefreshManager.b(BaseApplicationImpl.getContext(), 0);
      i = a(((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a());
      localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    }
    for (;;)
    {
      try
      {
        localObject = localReportR5Builder.e().f().a((String)localObject);
        if (i == 1) {
          continue;
        }
        bool = true;
        localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a(bool);
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        bool = true;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b(bool);
        if (paramReadInJoyBaseFragment != null)
        {
          i = paramReadInJoyBaseFragment.a();
          localReportR5Builder.a(i);
          if (i == 0)
          {
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              continue;
            }
            i = 1;
            localReportR5Builder.a("ad_page", i);
          }
        }
      }
      catch (JSONException paramReadInJoyBaseFragment)
      {
        boolean bool;
        QLog.e("RIJKanDianTabReport", 1, paramReadInJoyBaseFragment, new Object[0]);
        continue;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "CliOper", "", "", "0X80081C5", "0X80081C5", 0, 1, "1", null, null, localReportR5Builder.a(), false);
      return;
      localObject = "0";
      break;
      bool = false;
      continue;
      bool = false;
      continue;
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (!ReadInJoyHelper.m()) {
      return;
    }
    a(paramQQAppInterface);
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.1(paramRedTypeInfo, paramQQAppInterface));
  }
  
  public static void a(@Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null)
    {
      QLog.d("RIJKanDianTabReport", 1, "do81C4ReportForTabClick app is null");
      return;
    }
    Object localObject1 = (KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    label34:
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1;
    String str1;
    String str2;
    String str3;
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      int j = a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
      localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
      str1 = RIJKanDianFolderStatus.a(null);
      str2 = RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString;
      str3 = a(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.c);
      localObject2 = a(j);
      localReportR5Builder2 = localReportR5Builder1.l().h().b().i().m().c(str2).d(str1).f().a("tab_status", j);
      if (!paramBoolean) {
        break label322;
      }
      i = 1;
      label125:
      localObject2 = localReportR5Builder2.a("current_page", i).a("costtime_type", ((Integer)((Pair)localObject2).getFirst()).intValue()).a("costtime", ((Long)((Pair)localObject2).getSecond()).intValue());
      if (jdField_a_of_type_Int != 0) {
        break label327;
      }
      i = 0;
      label178:
      localReportR5Builder2 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject2).a("button_state", i);
      if ((j == 3) && (localObject1 != null)) {
        break label332;
      }
    }
    label322:
    label327:
    label332:
    for (Object localObject2 = "0";; localObject2 = ((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get())
    {
      localReportR5Builder2.a("reddot_num", (String)localObject2);
      if (ReadInJoyChannelViewPagerController.a != null) {
        localReportR5Builder1.a(ReadInJoyChannelViewPagerController.a.mChannelCoverId);
      }
      a(true, localReportR5Builder1.a());
      RIJMsgReport.a.a(localReportR5Builder1.a());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "CliOper", "", "", "0X80081C4", "0X80081C4", 0, 1, null, str3, str1, localReportR5Builder1.a(), false);
      if (localObject1 == null) {
        break;
      }
      RIJFrameworkReportManager.a(21, str3, str1, str2, "", -1);
      return;
      localObject1 = ((KandianMergeManager)localObject1).a();
      break label34;
      i = 0;
      break label125;
      i = 1;
      break label178;
    }
  }
  
  public static void a(@Nullable QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, @Nullable Intent paramIntent)
  {
    if (paramQQAppInterface == null)
    {
      QLog.d("RIJKanDianTabReport", 1, "[doReportForTabChangeBeforeUI] app is null ");
      return;
    }
    if (paramBoolean)
    {
      a(paramQQAppInterface, paramInt, paramIntent);
      return;
    }
    UserActionCollector.a().c();
    ReadInJoyGlobalReporter.a().a();
    ThreadManager.executeOnSubThread(new RIJKanDianTabReport.4(paramQQAppInterface));
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      try
      {
        if (RIJQQAppInterfaceUtil.a() == null) {
          break label281;
        }
        if (!ReadInJoyHelper.m()) {
          return;
        }
        Object localObject = (KandianMergeManager)RIJQQAppInterfaceUtil.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        JSONObject localJSONObject = RIJTransMergeKanDianReport.a();
        if ((!((KandianMergeManager)localObject).a()) && (!((KandianMergeManager)localObject).i()))
        {
          i = 1;
          if (i != 3) {
            break label265;
          }
          localObject = ((KandianMergeManager)localObject).e() + "";
          localJSONObject.put("tab_status", i);
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          if (i == 3) {
            localJSONObject.put("reddot_num", localObject);
          }
          a(true, localJSONObject);
          if (jdField_a_of_type_Int != 0) {
            break label271;
          }
          i = 0;
          localJSONObject.put("button_state", i);
          localJSONObject.put("os", 1);
          localJSONObject.put("version", VideoReporter.jdField_a_of_type_JavaLangString);
          if (!RIJXTabFrameUtils.a.a()) {
            break label276;
          }
          i = 1;
          localJSONObject.put("isInKandian", i);
          RIJMsgReport.a.a(localJSONObject);
          if (ReadInJoyChannelViewPagerController.a != null) {
            localJSONObject.put("channel_id", ReadInJoyChannelViewPagerController.a.mChannelCoverId);
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", null, "0X80081C3", "0X80081C3", 0, 1, null, a(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.c), RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_JavaLangString, localJSONObject.toString(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      if (localJSONException.e() > 0)
      {
        i = 3;
        continue;
        label265:
        String str = "0";
        continue;
        label271:
        i = 1;
        continue;
        label276:
        i = 0;
      }
      else
      {
        label281:
        i = 2;
      }
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int j = 1;
    Object localObject1 = (QQAppInterface)RIJQQAppInterfaceUtil.a();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = ((QQAppInterface)localObject1).getMessageFacade();
      } while (localObject1 == null);
      localObject2 = ((QQMessageFacade)localObject1).b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } while (localObject2 == null);
    if ((localObject2 instanceof MessageForStructing))
    {
      localObject1 = (MessageForStructing)localObject2;
      if (((MessageForStructing)localObject1).structingMsg == null) {
        ((MessageForStructing)localObject1).parse();
      }
    }
    for (;;)
    {
      int i;
      if (!paramBoolean)
      {
        i = 1;
        label80:
        if (((MessageRecord)localObject2).isread) {
          break label209;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if ((i | j) == 0) {
            break label212;
          }
          String str = ((MessageRecord)localObject2).senderuin;
          try
          {
            localObject2 = new JSONObject(((MessageRecord)localObject2).extStr);
            if (((JSONObject)localObject2).has("kdUin")) {
              str = ((JSONObject)localObject2).getString("kdUin");
            }
            paramJSONObject.put("feeds_source", str);
            if ((localObject1 == null) || (((MessageForStructing)localObject1).structingMsg == null)) {
              break;
            }
            paramJSONObject.put("load_mode", a(((MessageForStructing)localObject1).structingMsg.mExtraData));
            paramJSONObject.put("push_type", b(((MessageForStructing)localObject1).structingMsg.mExtraData));
            return;
          }
          catch (Exception paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            return;
          }
        }
        i = 0;
        break label80;
        label209:
        j = 0;
      }
      label212:
      break;
      localObject1 = null;
    }
  }
  
  public static int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("contentType", 0);
        return i;
      }
      catch (JSONException paramString)
      {
        QLog.e("RIJKanDianTabReport", 1, "getReportPushTypeFromeLockScreenMsg: ", paramString);
      }
    }
    return -1;
  }
  
  private static void b(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    if (paramRedTypeInfo != null) {}
    try
    {
      paramRedTypeInfo = RIJTransMergeKanDianReport.a();
      paramRedTypeInfo.put("kandian_mode", RIJAppSetting.a());
      paramRedTypeInfo.put("tab_source", RIJTransMergeKanDianReport.a());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", null, "0X80081C6", "0X80081C6", 0, 1, null, null, null, paramRedTypeInfo.toString(), false);
      return;
    }
    catch (Exception paramRedTypeInfo)
    {
      paramRedTypeInfo.printStackTrace();
    }
  }
  
  private static void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, QQAppInterface paramQQAppInterface)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int);
        localJSONObject.put("algorithm_id", RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString);
        localJSONObject.put("strategy_id", RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_JavaLangString);
        localJSONObject.put("time", System.currentTimeMillis());
        if (RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int == 6)
        {
          localJSONObject.put("id", paramString1);
          localJSONObject.put("social_uin", paramString2);
        }
        if (RIJTransMergeKanDianReport.a())
        {
          i = 1;
          localJSONObject.put("message_status", i);
          if (ReadInJoyHelper.z(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label343;
          }
          i = 1;
          localJSONObject.put("reddot_style", i);
          localJSONObject.put("tab_status", paramInt);
          localJSONObject.put("kandian_mode_new", VideoReporter.a());
          if (paramInt == 3) {
            localJSONObject.put("reddot_num", paramString3);
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramString4, "0X80091DC", "0X80091DC", 0, 0, "0", a(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.c), RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_JavaLangString, localJSONObject.toString(), false);
          if (ReadInJoyHelper.o()) {
            RIJFrameworkReportManager.a(20, a(RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.c), RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_b_of_type_JavaLangString, RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_JavaLangString, paramString4, RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int);
          }
          ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b();
          if (RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int == 6)
          {
            QLog.d("RIJKanDianTabReport", 1, "feedsPreload, social num red point, do not preload.");
            return;
          }
          QLog.d("RIJKanDianTabReport", 1, "feedsPreload, small red point exposed.");
          FeedsPreloadManager.a().a(true);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.d("RIJKanDianTabReport", 1, "red point expose, e = ", paramString1);
        return;
      }
      int i = 0;
      continue;
      label343:
      i = 0;
    }
  }
  
  private static boolean b()
  {
    if (RIJKanDianFolderStatus.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianRedDotInfo$RedPntInfoForReport.jdField_a_of_type_Int == 1) {
      return true;
    }
    RIJKanDianFolderStatus.a(String.valueOf(System.currentTimeMillis()));
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L;
    return false;
  }
  
  private static String d(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt == 5)
    {
      paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
      if (paramQQAppInterface != null) {
        return String.valueOf(paramQQAppInterface.mMsgType);
      }
    }
    return "";
  }
  
  private static String e(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.extInt == 5)
    {
      paramQQAppInterface = ((KandianMergeManager)paramQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
      if (paramQQAppInterface != null) {
        return String.valueOf(paramQQAppInterface.mUin);
      }
    }
    return "";
  }
  
  /* Error */
  private static String f(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_1
    //   2: getfield 699	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   5: iconst_1
    //   6: ixor
    //   7: putfield 699	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   10: aload_1
    //   11: getfield 573	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   14: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +136 -> 153
    //   20: new 41	org/json/JSONObject
    //   23: dup
    //   24: aload_1
    //   25: getfield 573	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   28: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   31: astore_2
    //   32: aload_2
    //   33: ldc_w 701
    //   36: invokestatic 131	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   39: invokevirtual 628	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 535	org/json/JSONObject:toString	()Ljava/lang/String;
    //   48: putfield 573	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   51: aload_1
    //   52: getfield 570	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   55: astore_3
    //   56: new 41	org/json/JSONObject
    //   59: dup
    //   60: aload_1
    //   61: getfield 573	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   64: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   67: astore 4
    //   69: aload_3
    //   70: astore_2
    //   71: aload 4
    //   73: ldc_w 575
    //   76: invokevirtual 579	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   79: ifeq +12 -> 91
    //   82: aload 4
    //   84: ldc_w 575
    //   87: invokevirtual 582	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   90: astore_2
    //   91: aload_0
    //   92: invokevirtual 543	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   95: aload_1
    //   96: getfield 704	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   99: aload_1
    //   100: getfield 707	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   103: aload_1
    //   104: getfield 710	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   107: ldc_w 711
    //   110: aload_1
    //   111: getfield 699	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   114: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: invokevirtual 714	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Object;)V
    //   120: aload_0
    //   121: invokevirtual 543	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   124: aload_1
    //   125: getfield 704	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   128: aload_1
    //   129: getfield 707	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   132: aload_1
    //   133: getfield 710	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   136: ldc_w 715
    //   139: aload_1
    //   140: getfield 573	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   143: invokevirtual 714	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/Object;)V
    //   146: aload_0
    //   147: aload_1
    //   148: invokestatic 718	com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/push/RIJKanDianFolderStatus:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   151: aload_2
    //   152: areturn
    //   153: new 41	org/json/JSONObject
    //   156: dup
    //   157: invokespecial 614	org/json/JSONObject:<init>	()V
    //   160: astore_2
    //   161: goto -129 -> 32
    //   164: astore_3
    //   165: ldc 91
    //   167: astore_2
    //   168: aload_3
    //   169: invokevirtual 598	java/lang/Exception:printStackTrace	()V
    //   172: goto -81 -> 91
    //   175: astore 4
    //   177: aload_3
    //   178: astore_2
    //   179: aload 4
    //   181: astore_3
    //   182: goto -14 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramQQAppInterface	QQAppInterface
    //   0	185	1	paramMessageRecord	MessageRecord
    //   31	148	2	localObject1	Object
    //   55	15	3	str	String
    //   164	14	3	localException1	Exception
    //   181	1	3	localObject2	Object
    //   67	16	4	localJSONObject	JSONObject
    //   175	5	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   10	32	164	java/lang/Exception
    //   32	56	164	java/lang/Exception
    //   153	161	164	java/lang/Exception
    //   56	69	175	java/lang/Exception
    //   71	91	175	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport
 * JD-Core Version:    0.7.0.1
 */