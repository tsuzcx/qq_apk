package com.tencent.biz.pubaccount.readinjoy.logic;

import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SMRMH
{
  static long a;
  
  static
  {
    jdField_a_of_type_Long = 2147483647L;
  }
  
  static int a()
  {
    if (SMRM.a().a()) {
      return 5;
    }
    return 20;
  }
  
  static String a(long paramLong)
  {
    if (!SMRM.a().a()) {
      return MD5Utils.b(String.valueOf(paramLong) + jdField_a_of_type_Long);
    }
    return String.valueOf(paramLong);
  }
  
  static List a(List paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.size() == 0)) {
      localArrayList.add(new ArrayList());
    }
    for (;;)
    {
      return localArrayList;
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        int k = Math.min(paramInt, j - i);
        localArrayList.add(new ArrayList(paramList.subList(i, i + k)));
        i += k;
      }
    }
  }
  
  public static void a(int paramInt, long paramLong1, long paramLong2, List paramList)
  {
    label5:
    String str1;
    String str2;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (paramList == null)
    {
      return;
    }
    else
    {
      lon locallon;
      JSONObject localJSONObject;
      for (;;)
      {
        try
        {
          str1 = String.valueOf(paramLong1);
          str2 = String.valueOf(paramLong2);
          if (paramInt != 1) {
            break;
          }
          paramList = a(paramList, a()).iterator();
          if (!paramList.hasNext()) {
            continue;
          }
          localObject3 = (List)paramList.next();
          localObject1 = new JSONObject();
          localObject2 = new JSONArray();
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            locallon = (lon)((Iterator)localObject3).next();
            localJSONObject = new JSONObject();
            localJSONObject.put("u", a(locallon.jdField_a_of_type_Long));
            localJSONObject.put("cn", locallon.jdField_a_of_type_Int);
            localJSONObject.put("ic", locallon.jdField_b_of_type_Int);
            ((JSONArray)localObject2).put(localJSONObject);
            continue;
          }
          ((JSONObject)localObject1).put("rc", localObject2);
        }
        catch (JSONException paramList)
        {
          QLog.e("SMRM", 2, "tr", paramList);
          return;
        }
        if (SMRM.a().a()) {
          QLog.d("SMRM", 2, "c2c " + ((JSONObject)localObject1).toString());
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007F06", "0X8007F06", 0, 0, "", str1, str2, ((JSONObject)localObject1).toString(), false);
      }
      label263:
      localObject1 = a(paramList, a()).iterator();
      label278:
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (List)((Iterator)localObject1).next();
        localObject2 = new JSONObject();
        paramList = new JSONArray();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          locallon = (lon)((Iterator)localObject3).next();
          localJSONObject = new JSONObject();
          localJSONObject.put("u", a(locallon.jdField_a_of_type_Long));
          localJSONObject.put("cn", locallon.jdField_a_of_type_Int);
          localJSONObject.put("ic", locallon.jdField_b_of_type_Int);
          localJSONObject.put("seg", locallon.d);
          localJSONObject.put("mi", locallon.c);
          localJSONObject.put("gu", locallon.jdField_b_of_type_Long);
          paramList.put(localJSONObject);
        }
        ((JSONObject)localObject2).put("rc", paramList);
        if (SMRM.a().a())
        {
          if (paramInt != 2) {
            break label746;
          }
          paramList = "group ";
          label478:
          QLog.d("SMRM", 2, paramList + ((JSONObject)localObject2).toString());
        }
        localObject2 = ((JSONObject)localObject2).toString();
        if (paramInt != 2) {
          break label753;
        }
      }
    }
    label746:
    label753:
    for (paramList = "0X8007F08";; paramList = "0X8007F09")
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", paramList, paramList, 0, 0, "", str1, str2, (String)localObject2, false);
      break label278;
      break label5;
      if (paramInt != 4) {
        break label5;
      }
      paramList = a(paramList, 30).iterator();
      while (paramList.hasNext())
      {
        localObject3 = (List)paramList.next();
        localObject1 = new JSONObject();
        localObject2 = new JSONArray();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((JSONArray)localObject2).put(a(((lon)((Iterator)localObject3).next()).jdField_a_of_type_Long));
        }
        ((JSONObject)localObject1).put("us", localObject2);
        if (SMRM.a().a()) {
          QLog.d("SMRM", 2, "sp " + ((JSONObject)localObject1).toString());
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007F07", "0X8007F07", 0, 0, "", str1, str2, ((JSONObject)localObject1).toString(), false);
      }
      break label5;
      if (paramInt == 2) {
        break label263;
      }
      if (paramInt != 3) {
        break;
      }
      break label263;
      paramList = "discuss ";
      break label478;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.SMRMH
 * JD-Core Version:    0.7.0.1
 */