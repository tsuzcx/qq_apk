package com.tencent.biz.pubaccount.readinjoy.common;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import lli;
import llj;
import llk;
import lll;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class WeishiReportUtil
{
  private static long jdField_a_of_type_Long = -1L;
  private static MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  public static MessageForStructing a()
  {
    return ((WeishiManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(274)).a();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Other";
    }
    return "MsgTab";
  }
  
  public static String a(long paramLong)
  {
    return String.valueOf((paramLong - a()) / 1000L);
  }
  
  public static String a(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mArticleIds)))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg.mArticleIds.split("\\|");
      if (paramMessageForStructing.length > 0) {
        return paramMessageForStructing[0];
      }
    }
    return "";
  }
  
  public static void a()
  {
    String str = d(a());
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(str);
    localArrayList.add(localAttributeList);
    PublicAccountUtil.a(27, "DeleteWS", localArrayList);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ThreadManager.executeOnSubThread(new lli(paramInt, paramString1, paramString2, paramString3, paramString4));
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ThreadManager.executeOnSubThread(new llj(paramInt, paramString1, paramString5, paramString2, paramString3, paramString4));
  }
  
  public static void a(RecentBaseData paramRecentBaseData)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageForStructing localMessageForStructing = ((WeishiManager)localQQAppInterface.getManager(274)).a();
    if ((localMessageForStructing != null) && (!localMessageForStructing.isread) && (localMessageForStructing.extLong == 1))
    {
      localMessageForStructing.extLong = 0;
      jdField_a_of_type_Long = System.currentTimeMillis();
      ThreadManager.post(new llk(paramRecentBaseData, localQQAppInterface, localMessageForStructing), 5, null, false);
    }
  }
  
  public static void a(RecentBaseData paramRecentBaseData, int paramInt)
  {
    ThreadManager.post(new lll(((WeishiManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(274)).a(), paramRecentBaseData, b(paramInt)), 5, null, false);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeishiReportUtil", 2, " " + paramString3 + "|" + paramString1 + "|" + paramString2 + "|" + paramString4);
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", paramString3, paramString3, 0, 0, "", paramString1, paramString2, paramString4, false);
  }
  
  public static MessageForStructing b()
  {
    MessageForStructing localMessageForStructing = jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = null;
    return localMessageForStructing;
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "1";
    }
    return "0";
  }
  
  public static String b(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))) {
      return paramMessageForStructing.structingMsg.mStrategyIds;
    }
    return "";
  }
  
  public static void b()
  {
    jdField_a_of_type_ComTencentMobileqqDataMessageForStructing = a();
  }
  
  private static boolean b(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null);
  }
  
  public static String c(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))) {
      return paramMessageForStructing.structingMsg.mAlgorithmIds;
    }
    return "";
  }
  
  public static String d(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.reportEventFolderStatusValue)) {
        return paramMessageForStructing.structingMsg.reportEventFolderStatusValue;
      }
      return "2";
    }
    return "1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil
 * JD-Core Version:    0.7.0.1
 */