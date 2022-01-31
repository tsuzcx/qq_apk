package com.tencent.biz.pubaccount.util;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadinjoyReportUtils
{
  public static long a;
  public static String a;
  public static Map a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static int a()
  {
    switch ()
    {
    default: 
      return 1;
    case 1: 
      return 4;
    }
    return 3;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = 0;
    int i = j;
    if ((paramBaseArticleInfo instanceof ArticleInfo))
    {
      i = j;
      if (!ReadInJoyBaseAdapter.o((ArticleInfo)paramBaseArticleInfo)) {
        i = 1;
      }
    }
    return i;
  }
  
  public static Pair a(long paramLong)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return (Pair)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    }
    return null;
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Other";
    case 2: 
      return "KDTAB";
    case 4: 
      return "MsgTab";
    }
    return "FromDTTab";
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network ", GalleryReportedUtils.a(paramContext));
      localJSONObject.put("version ", "7.6.3");
      localJSONObject.put("os", "1");
      localJSONObject.put("ads_source ", paramInt1);
      localJSONObject.put("card_pos ", paramInt2);
      localJSONObject.put("os", "1");
      localJSONObject.put("rowkey", paramString);
      localJSONObject.put("feeds_type", paramInt3);
      localJSONObject.put("is_ugc_as_pgc", paramInt4);
      paramContext = localJSONObject.toString();
      return paramContext;
    }
    catch (Exception paramString)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("ReadinjoyReportUtils", 2, "getSmallVideoPolymericR5Str:" + paramString.toString());
    }
    return "";
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    String str = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("network ", GalleryReportedUtils.a(paramContext));
      localJSONObject.put("channel_id", paramInt2);
      localJSONObject.put("version ", "7.6.3");
      localJSONObject.put("os", "1");
      localJSONObject.put("vid", paramString2);
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("algorithm_id", paramLong2);
      localJSONObject.put("feeds_type", paramInt1);
      localJSONObject.put("star_logo", "0");
      localJSONObject.put("is_ugc_as_pgc", paramInt3);
      localJSONObject.put("r_session_id", jdField_a_of_type_JavaLangString);
      paramContext = a(paramLong1);
      if (paramContext != null)
      {
        localJSONObject.put("r_session_position", paramContext.first);
        localJSONObject.put("r_session_ispush", paramContext.second);
      }
      paramContext = localJSONObject.toString();
    }
    catch (Exception paramString1)
    {
      do
      {
        paramContext = str;
      } while (!QLog.isColorLevel());
      QLog.d("ReadinjoyReportUtils", 2, "getSmallVideoWrapperPolymericR5Str:" + paramString1.toString());
    }
    return paramContext;
    return "";
  }
  
  public static void a()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(ReadInJoyUtils.d + "");
    localArrayList.add(localAttributeList);
    PublicAccountUtil.a(10, "DeleteKD", localArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyReportUtils", 2, "reportKandianDelete  , foldStatus :  " + ReadInJoyUtils.d);
    }
  }
  
  public static void a(int paramInt1, boolean paramBoolean, long paramLong, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    long l;
    if (paramBoolean)
    {
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("EnterType");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(a(paramInt1));
      localArrayList.add(localObject1);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FolderStatus");
      PBStringField localPBStringField = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if (paramInt1 == 0)
      {
        localObject1 = "1024";
        localPBStringField.set((String)localObject1);
        localArrayList.add(localObject2);
        if (ReadInJoyUtils.d != 1)
        {
          localObject1 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
          ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("StrategyID");
          ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(ReadInJoyUtils.a.b);
          localArrayList.add(localObject1);
          localObject1 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
          ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("AlgorithmID");
          ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(ReadInJoyUtils.a.jdField_a_of_type_JavaLangString);
          localArrayList.add(localObject1);
          paramLong = NetConnInfoCenter.getServerTime();
          l = ReadInJoyUtils.a.jdField_a_of_type_Long;
          localObject1 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
          ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("costtime");
          ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set("" + (paramLong - l));
          localArrayList.add(localObject1);
        }
        paramInt2 = 4;
        localObject1 = "EnterKD";
      }
    }
    for (;;)
    {
      PublicAccountUtil.a(paramInt2, (String)localObject1, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "report kandian exit or enter ! from : " + paramInt1 + " , eventName :  " + (String)localObject1);
      }
      return;
      localObject1 = ReadInJoyUtils.d + "";
      break;
      localObject2 = "ExitKD";
      int i = 5;
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("ExitType");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(a(paramInt1));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FolderStatus");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramInt2));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(ReadinjoySPEventReport.a(paramLong)));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(4);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("OperationBitmap");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(paramInt3 + "");
      localArrayList.add(localObject1);
      paramInt2 = i;
      localObject1 = localObject2;
      if (ReadInJoyUtils.a.jdField_a_of_type_Int != 1)
      {
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("StrategyID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(ReadInJoyUtils.a.b);
        localArrayList.add(localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(6);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("AlgorithmID");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(ReadInJoyUtils.a.jdField_a_of_type_JavaLangString);
        localArrayList.add(localObject1);
        paramLong = NetConnInfoCenter.getServerTime();
        l = ReadInJoyUtils.a.jdField_a_of_type_Long;
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(7);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("costtime");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set("" + (paramLong - l));
        localArrayList.add(localObject1);
        paramInt2 = i;
        localObject1 = localObject2;
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    int i = 1;
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("BusiType");
    localAttributeList1.att_value.set(paramString);
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("HasRedPnt");
    Object localObject = localAttributeList2.att_value;
    if (paramBoolean) {}
    for (;;)
    {
      ((PBStringField)localObject).set(String.valueOf(i));
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(3);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Time");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(ReadinjoySPEventReport.a(paramLong)));
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localAttributeList1);
      localArrayList.add(localAttributeList2);
      localArrayList.add(localObject);
      PublicAccountUtil.a(2, "EnterDTBusi", localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyReportUtils", 2, "report dt entry ! busiName : " + paramString + " , redDot : " + paramBoolean);
      }
      return;
      i = 0;
    }
  }
  
  public static void a(List paramList1, List paramList2, boolean paramBoolean)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return;
    }
    paramList1 = paramList1.iterator();
    label16:
    Map localMap;
    long l2;
    long l3;
    while (paramList1.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList1.next();
      if (paramList2.contains(Long.valueOf(localArticleInfo.mRecommendSeq)))
      {
        localMap = jdField_a_of_type_JavaUtilMap;
        l2 = localArticleInfo.mArticleID;
        l3 = jdField_a_of_type_Long;
        jdField_a_of_type_Long = l3 + 1L;
        if (!paramBoolean) {
          break label115;
        }
      }
    }
    label115:
    for (long l1 = 1L;; l1 = 0L)
    {
      localMap.put(Long.valueOf(l2), new Pair(Long.valueOf(l3), Long.valueOf(l1)));
      break label16;
      break;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    long l1 = 0L;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaUtilMap.clear();
    if (paramAppRuntime == null) {}
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      jdField_a_of_type_JavaLangString = String.valueOf(l1) + "_" + String.valueOf(l2);
      return;
      l1 = paramAppRuntime.getLongAccountUin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils
 * JD-Core Version:    0.7.0.1
 */