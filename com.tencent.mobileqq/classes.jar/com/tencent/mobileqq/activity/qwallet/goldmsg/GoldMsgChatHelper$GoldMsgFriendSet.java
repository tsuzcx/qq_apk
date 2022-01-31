package com.tencent.mobileqq.activity.qwallet.goldmsg;

import Wallet.GoldMsgFriendStatus;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import xep;
import xeq;

public class GoldMsgChatHelper$GoldMsgFriendSet
{
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  public long a;
  public String a;
  
  public GoldMsgChatHelper$GoldMsgFriendSet(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static GoldMsgFriendSet a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 0;
    while (i < jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((GoldMsgFriendSet)jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramString)) {
        return (GoldMsgFriendSet)jdField_a_of_type_JavaUtilArrayList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static void a()
  {
    ThreadManager.post(new xep(), 5, null, false);
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString)) || ((paramBoolean) && (paramLong <= 0L))) {}
    for (;;)
    {
      return;
      GoldMsgFriendSet localGoldMsgFriendSet = a(paramString);
      if (paramBoolean) {
        if (localGoldMsgFriendSet == null)
        {
          paramString = new GoldMsgFriendSet(paramString, paramLong);
          jdField_a_of_type_JavaUtilArrayList.add(paramString);
        }
      }
      while (i != 0)
      {
        a();
        return;
        if (localGoldMsgFriendSet.jdField_a_of_type_Long != paramLong)
        {
          localGoldMsgFriendSet.jdField_a_of_type_Long = paramLong;
          continue;
          if (localGoldMsgFriendSet != null)
          {
            jdField_a_of_type_JavaUtilArrayList.remove(localGoldMsgFriendSet);
            continue;
          }
        }
        i = 0;
      }
    }
  }
  
  public static void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    jdField_a_of_type_JavaUtilArrayList.clear();
    int i = 0;
    while (i < paramList.size())
    {
      if ((paramList.get(i) != null) && (((GoldMsgFriendStatus)paramList.get(i)).goldMsgSwitch == 1))
      {
        GoldMsgFriendSet localGoldMsgFriendSet = new GoldMsgFriendSet(String.valueOf(((GoldMsgFriendStatus)paramList.get(i)).uin), ((GoldMsgFriendStatus)paramList.get(i)).goldMsgPrice);
        jdField_a_of_type_JavaUtilArrayList.add(localGoldMsgFriendSet);
      }
      i += 1;
    }
    a();
  }
  
  public static GoldMsgFriendSet b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (jdField_a_of_type_Boolean) {
      return a(paramString);
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.post(new xeq(paramString), 1, null, false);
    return null;
  }
  
  private static String b()
  {
    if (jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        GoldMsgFriendSet localGoldMsgFriendSet = (GoldMsgFriendSet)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", localGoldMsgFriendSet.jdField_a_of_type_JavaLangString);
        localJSONObject.put("minMoney", localGoldMsgFriendSet.jdField_a_of_type_Long);
        localJSONArray.put(localJSONObject);
      }
      str = localException.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    String str;
    return str;
  }
  
  private static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new JSONArray(paramString);
        jdField_a_of_type_JavaUtilArrayList.clear();
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = paramString.getJSONObject(i);
          if (localObject != null)
          {
            String str = ((JSONObject)localObject).optString("uin");
            long l = ((JSONObject)localObject).optLong("minMoney");
            if ((!TextUtils.isEmpty(str)) && (l > 0L))
            {
              localObject = new GoldMsgFriendSet(str, l);
              jdField_a_of_type_JavaUtilArrayList.add(localObject);
            }
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgFriendSet
 * JD-Core Version:    0.7.0.1
 */