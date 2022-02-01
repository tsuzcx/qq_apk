package com.tencent.biz.pubaccount.ecshopassit.utils;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.biz.pubaccount.ecshopassit.ABTestInfo;
import com.tencent.biz.pubaccount.ecshopassit.conf.QQShopFakeUrlHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.qwallet.utils.ReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportUtil
{
  private static volatile ReportUtil jdField_a_of_type_ComTencentBizPubaccountEcshopassitUtilsReportUtil;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public ConcurrentHashMap<Long, ChatMessage> a;
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("000004B5DU3Q3LD1"));
  }
  
  private ReportUtil()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private double a(View paramView)
  {
    if (paramView == null) {}
    Rect localRect;
    do
    {
      return 0.0D;
      localRect = new Rect();
    } while ((!paramView.getGlobalVisibleRect(localRect)) || (localRect.left >= com.tencent.biz.qqstory.utils.UIUtils.b(paramView.getContext())) || (localRect.top >= com.tencent.biz.qqstory.utils.UIUtils.c(paramView.getContext())) || (localRect.right <= 0) || (localRect.bottom <= 0));
    return 1.0D * localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight());
  }
  
  public static ReportUtil a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountEcshopassitUtilsReportUtil == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentBizPubaccountEcshopassitUtilsReportUtil == null) {
        jdField_a_of_type_ComTencentBizPubaccountEcshopassitUtilsReportUtil = new ReportUtil();
      }
      return jdField_a_of_type_ComTencentBizPubaccountEcshopassitUtilsReportUtil;
    }
  }
  
  private static String a()
  {
    ABTestInfo localABTestInfo = ABTestUtil.a("exp_qqshop_tabbar");
    StringBuilder localStringBuilder = new StringBuilder();
    if (localABTestInfo != null)
    {
      if (!TextUtils.isEmpty(localABTestInfo.b)) {
        localStringBuilder.append(localABTestInfo.b);
      }
      localStringBuilder.append(">");
      if (!TextUtils.isEmpty(localABTestInfo.d)) {
        localStringBuilder.append(localABTestInfo.d);
      }
      localStringBuilder.append(">");
      if (!TextUtils.isEmpty(localABTestInfo.a())) {
        localStringBuilder.append(localABTestInfo.a());
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str1 = "";
    String str2 = QQShopFakeUrlHelper.a(paramQQAppInterface, EcshopUtils.b(paramMessageRecord));
    paramQQAppInterface = str1;
    if (!StringUtil.a(str2)) {
      paramQQAppInterface = EcshopUtils.a(str2, EcshopUtils.a(EcshopUtils.c(paramMessageRecord)), false);
    }
    QLog.i("ReportUtil", 2, "wrapPushReport: " + paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (StringUtil.a(paramString1)) {
      return paramString1;
    }
    String str = paramString2;
    if (StringUtil.a(paramString2)) {
      str = "tab";
    }
    paramString2 = new HashMap(1);
    paramString2.put("_source", str);
    return EcshopUtils.a(paramString1, paramString2, false);
  }
  
  private Map<String, String> a(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    HashMap localHashMap = new HashMap();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramJSONObject.optString(str));
    }
    return localHashMap;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      localObject1 = paramQQAppInterface.getMessageFacade().a("3046055438", 1008);
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        return;
      }
      localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
      i = 0;
    }
    catch (Throwable paramQQAppInterface)
    {
      Object localObject1;
      int i;
      int j;
      label63:
      Object localObject2;
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
      return;
    }
    try
    {
      j = Integer.parseInt(EcshopUtils.a((MessageRecord)localObject1));
      i = j;
    }
    catch (Exception localException)
    {
      break label63;
    }
    localObject2 = EcshopUtils.a((MessageRecord)localObject1);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtil", 2, "mGdtActionType " + ((AbsStructMsgElement)localObject2).c);
      }
      if ((((AbsStructMsgElement)localObject2).a instanceof StructMsgForGeneralShare))
      {
        a(paramQQAppInterface, paramString, ((StructMsgForGeneralShare)((AbsStructMsgElement)localObject2).a).mContentTitle, NetConnInfoCenter.getServerTimeMillis() + "", "", i);
        paramString = a(paramQQAppInterface, (MessageRecord)localObject1);
        b(paramQQAppInterface, "qgg_push_click", ((StructMsgForGeneralShare)((AbsStructMsgElement)localObject2).a).mContentTitle, NetConnInfoCenter.getServerTimeMillis() + "", paramString, i);
      }
    }
    else
    {
      localObject2 = EcshopUtils.a((MessageRecord)localObject1);
      if (localObject2 != null)
      {
        a(paramQQAppInterface, paramString, ((JSONObject)localObject2).optString("aio_desc_name"), NetConnInfoCenter.getServerTimeMillis() + "", "", i);
        paramString = a(paramQQAppInterface, (MessageRecord)localObject1);
        b(paramQQAppInterface, "qgg_push_click", ((JSONObject)localObject2).optString("aio_desc_name"), NetConnInfoCenter.getServerTimeMillis() + "", paramString, i);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s__fromType: %s", new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(paramInt) }));
      }
      try
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", paramString2, paramString1, paramInt, 0, paramString4, paramString3, "android", "8.5.5");
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("department", paramString1);
    localHashMap.put("op_type", paramString3);
    localHashMap.put("op_in", paramInt + "");
    localHashMap.put("ext1", paramString5);
    localHashMap.put("ext15", paramString6);
    localHashMap.put("pvid", paramString4);
    localHashMap.put("plat", "android");
    localHashMap.put("version", "8.5.5");
    localHashMap.put("A8", EcshopUtils.a(BaseApplicationImpl.getApplication().getRuntime()));
    a(paramString2, localHashMap);
  }
  
  public static void a(String paramString, HashMap<String, String> paramHashMap)
  {
    try
    {
      if ((BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface))
      {
        UserAction.onUserActionToTunnel("000004B5DU3Q3LD1", paramString, true, -1L, -1L, paramHashMap, true, true);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("key_report_event", paramString);
      localBundle.putSerializable("key_report_params", paramHashMap);
      QIPCClientHelper.getInstance().callServer("EcshopIPCModule", "reportToBeacon", localBundle, null);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("ReportUtil", 1, paramString, new Object[0]);
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("item_list");
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Map localMap = a(paramJSONObject.optJSONObject(i).optJSONObject("report_data"));
          if ((localMap != null) && (!localMap.isEmpty())) {
            localMap.put("ext3", NetConnInfoCenter.getServerTimeMillis() + "");
          }
          if (QLog.isColorLevel()) {
            QLog.i("ReportUtil", 2, "params: " + localMap);
          }
          ReportUtils.a("000004B5DU3Q3LD1", "qgg_floor_show", localMap);
          i += 1;
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    b(paramQQAppInterface, paramString1, paramString2, paramString3, paramString4, 0);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    try
    {
      paramQQAppInterface = a();
      if (QLog.isColorLevel()) {
        QLog.i("ReportUtil", 2, String.format("opName: %s__opType: %s__d2: %s__d1: %s__abTestInfo: %s__fromType: %s", new Object[] { paramString1, paramString2, paramString3, paramString4, paramQQAppInterface, Integer.valueOf(paramInt) }));
      }
      a("Vip_pay_mywallet", paramString1, paramString2, paramString3, paramString4, paramQQAppInterface, paramInt);
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("ReportUtil", 1, QLog.getStackTraceString(paramQQAppInterface));
    }
  }
  
  public void a(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    if ((paramChatAdapter1 != null) && (!paramChatAdapter1.a().isEmpty()))
    {
      int i = 0;
      if (i < paramChatAdapter1.a().size())
      {
        ChatMessage localChatMessage = (ChatMessage)paramChatAdapter1.a().get(i);
        Object localObject1;
        if ((localChatMessage instanceof MessageForArkApp))
        {
          localObject1 = (MessageForArkApp)localChatMessage;
          if (((MessageForArkApp)localObject1).ark_app_message != null) {
            break label76;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label76:
          localObject1 = ((MessageForArkApp)localObject1).ark_app_message.metaList;
          if (!StringUtil.a((String)localObject1)) {
            try
            {
              Object localObject2 = com.tencent.mobileqq.activity.qwallet.utils.UIUtils.a(localChatMessage, paramChatXListView);
              if (localObject2 != null)
              {
                localObject2 = (ArkAppView)((View)localObject2).findViewById(2131362998);
                if ((localObject2 != null) && (a((View)localObject2) >= 0.8D) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(localChatMessage.uniseq))))
                {
                  a(new JSONObject((String)localObject1).optJSONObject("floorData"));
                  this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localChatMessage.uniseq));
                }
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil
 * JD-Core Version:    0.7.0.1
 */