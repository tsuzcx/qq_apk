package com.tencent.mobileqq.activity.contacts.mayknow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactReportUtils
{
  private static ContactReportUtils.ReportExposeInterval a = new ContactReportUtils.ReportExposeInterval();
  
  public static String a(List<MayKnowRecommend.MayKnowRecommendLabel> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuilder.append(((MayKnowRecommend.MayKnowRecommendLabel)paramList.get(i)).bytes_name);
        if (i < paramList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    boolean bool;
    if ((a.b()) && (a.c() > 0L) && (a.d() > 0L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      a.a(true);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("flushReportRecommendExposeInterval ");
      localStringBuilder.append(bool);
      QLog.d("ContactReportUtils", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(ContactReportUtils.ReportExposeIntervalConfig paramReportExposeIntervalConfig)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setReportExposeIntervalConfig: ");
      ((StringBuilder)localObject).append(paramReportExposeIntervalConfig);
      QLog.d("ContactReportUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramReportExposeIntervalConfig != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null)
      {
        BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("com.tencent.mobileqq.ReportExposeInterval_");
        localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
        localObject = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("ReportExposeInterval_enable", paramReportExposeIntervalConfig.a);
        ((SharedPreferences.Editor)localObject).putLong("ReportExposeInterval_interval", paramReportExposeIntervalConfig.b);
        ((SharedPreferences.Editor)localObject).apply();
        a.b(paramReportExposeIntervalConfig.a);
        a.a(paramReportExposeIntervalConfig.b);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<String> paramArrayList)
  {
    a(paramQQAppInterface, paramInt, paramArrayList, String.valueOf(23), "3");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportRecommendList: op_via = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramArrayList);
      QLog.d("ContactReportUtils", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramQQAppInterface != null) && (paramArrayList != null))
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      localObject1 = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      Object localObject2;
      while (paramArrayList.hasNext())
      {
        localObject2 = (String)paramArrayList.next();
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(",");
        }
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      paramArrayList = (ArrayList<String>)localObject1;
      if (((String)localObject1).length() > 0)
      {
        paramArrayList = (ArrayList<String>)localObject1;
        if (((String)localObject1).endsWith(",")) {
          paramArrayList = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
      }
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("exp_uin", paramArrayList);
      }
      catch (JSONException paramArrayList)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("reportRecommendList error: ");
          ((StringBuilder)localObject2).append(paramArrayList.getMessage());
          QLog.i("ContactReportUtils", 2, ((StringBuilder)localObject2).toString());
        }
      }
      if (paramString1 == null) {
        paramArrayList = "";
      } else {
        paramArrayList = paramString1;
      }
      if (paramString2 == null) {
        paramString2 = "";
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_update", paramInt, 0, paramArrayList, paramString2, ((JSONObject)localObject1).toString(), "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString)
  {
    a(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    StringBuilder localStringBuilder3;
    StringBuilder localStringBuilder4;
    int i;
    if ((paramArrayList1 != null) && (paramArrayList2 != null) && (paramArrayList != null) && (paramArrayList3 != null) && (!paramArrayList1.isEmpty()) && (paramArrayList1.size() == paramArrayList2.size()) && (paramArrayList1.size() == paramArrayList.size()))
    {
      if (paramArrayList1.size() != paramArrayList3.size()) {
        return;
      }
      if (paramString == null) {
        paramString = "";
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder3 = new StringBuilder();
      localStringBuilder4 = new StringBuilder();
      i = 0;
    }
    for (;;)
    {
      if (i < paramArrayList1.size())
      {
        if (i > 0)
        {
          localStringBuilder1.append(",");
          localStringBuilder2.append(",");
          localStringBuilder3.append(",");
          localStringBuilder4.append(",");
        }
        localStringBuilder1.append((String)paramArrayList1.get(i));
        localStringBuilder2.append((String)paramArrayList2.get(i));
        localStringBuilder3.append(paramArrayList.get(i));
        if ((paramArrayList3.get(i) == null) || (((byte[])paramArrayList3.get(i)).length <= 0)) {}
      }
      try
      {
        localStringBuilder4.append(new String((byte[])paramArrayList3.get(i)));
        label248:
        i += 1;
        continue;
        paramArrayList1 = new JSONObject();
        try
        {
          paramArrayList1.put("exp_uin", localStringBuilder1.toString());
          paramArrayList1.put("exp_reason", localStringBuilder2.toString());
          paramArrayList1.put("exp_position", localStringBuilder3.toString());
          paramArrayList1.put("algh_id", localStringBuilder4.toString());
        }
        catch (JSONException paramArrayList2)
        {
          if (QLog.isColorLevel())
          {
            paramArrayList = new StringBuilder();
            paramArrayList.append("reportRecommend error: ");
            paramArrayList.append(paramArrayList2.getMessage());
            QLog.i("ContactReportUtils", 2, paramArrayList.toString());
          }
        }
        if (paramBoolean)
        {
          ReportController.a(paramQQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_exp", paramInt1, 0, String.valueOf(paramInt2), paramString, paramArrayList1.toString(), "");
          return;
        }
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "frd_recom", "frd_list_exp", paramInt1, 0, String.valueOf(paramInt2), paramString, paramArrayList1.toString(), "");
        return;
      }
      catch (Throwable localThrowable)
      {
        break label248;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "frd_recom", paramString, 0, 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "frd_recom", paramString, 0, paramInt1, String.valueOf(paramInt2), "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "frd_recom", paramString2, 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramArrayOfByte, paramInt4, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, int paramInt4, String paramString4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exp_reason", paramString3);
      localJSONObject.put("exp_position", paramInt3);
      if (paramArrayOfByte != null)
      {
        paramInt3 = paramArrayOfByte.length;
        if (paramInt3 <= 0) {}
      }
    }
    catch (JSONException paramString3)
    {
      label58:
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("reportRecommend error: ");
        paramArrayOfByte.append(paramString3.getMessage());
        QLog.i("", 2, paramArrayOfByte.toString());
      }
    }
    try
    {
      paramString3 = new String(paramArrayOfByte);
    }
    catch (Throwable paramString3)
    {
      break label58;
    }
    paramString3 = "";
    localJSONObject.put("algh_id", paramString3);
    if (paramString4 == null) {
      paramString4 = "";
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "frd_recom", paramString2, paramInt1, paramInt2, String.valueOf(paramInt4), paramString4, localJSONObject.toString(), "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4, String paramString5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exp_reason", paramString3);
      localJSONObject.put("exp_position", paramInt3);
      if (paramArrayOfByte != null)
      {
        paramInt3 = paramArrayOfByte.length;
        if (paramInt3 <= 0) {}
      }
    }
    catch (JSONException paramString3)
    {
      label58:
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("reportRecommend error: ");
        paramArrayOfByte.append(paramString3.getMessage());
        QLog.i("", 2, paramArrayOfByte.toString());
      }
    }
    try
    {
      paramString3 = new String(paramArrayOfByte);
    }
    catch (Throwable paramString3)
    {
      break label58;
    }
    paramString3 = "";
    localJSONObject.put("algh_id", paramString3);
    localJSONObject.put("item_tag", paramString4);
    if (paramString5 == null) {
      paramString5 = "";
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", paramString1, "frd_recom", paramString2, paramInt1, paramInt2, String.valueOf(paramInt4), paramString5, localJSONObject.toString(), "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactReportUtils", 2, "reportRecommendExposeInterval");
    }
    if (a.b())
    {
      if (a.c() > 0L)
      {
        a.a(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString);
        a.a(false);
        return;
      }
      a(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString, true);
      return;
    }
    a(paramQQAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils
 * JD-Core Version:    0.7.0.1
 */