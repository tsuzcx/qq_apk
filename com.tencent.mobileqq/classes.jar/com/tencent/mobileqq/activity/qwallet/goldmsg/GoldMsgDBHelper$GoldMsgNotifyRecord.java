package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GoldMsgDBHelper$GoldMsgNotifyRecord
{
  public int a;
  public String a;
  public ArrayList a;
  public int b;
  public int c;
  public int d;
  
  protected GoldMsgDBHelper$GoldMsgNotifyRecord(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(this.jdField_a_of_type_JavaUtilArrayList, paramString2);
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public GoldMsgDBHelper$GoldMsgNotifyRecord(String paramString, int paramInt1, ArrayList paramArrayList, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  protected static GoldMsgNotifyRecord a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      paramCursor = null;
    }
    GoldMsgNotifyRecord localGoldMsgNotifyRecord;
    do
    {
      return paramCursor;
      int i = paramCursor.getColumnIndexOrThrow("listid");
      int j = paramCursor.getColumnIndexOrThrow("state");
      int k = paramCursor.getColumnIndexOrThrow("uins");
      int m = paramCursor.getColumnIndexOrThrow("grap_state");
      int n = paramCursor.getColumnIndexOrThrow("grap_money");
      int i1 = paramCursor.getColumnIndexOrThrow("grap_user_count");
      localGoldMsgNotifyRecord = new GoldMsgNotifyRecord(paramCursor.getString(i), paramCursor.getInt(j), paramCursor.getString(k), paramCursor.getInt(m), paramCursor.getInt(n), paramCursor.getInt(i1));
      paramCursor = localGoldMsgNotifyRecord;
    } while (!QLog.isColorLevel());
    QLog.i("GoldMsgDBHelper", 2, "GoldMsgDBHelper.fromCursorOrThrow record=" + localGoldMsgNotifyRecord);
    return localGoldMsgNotifyRecord;
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      paramArrayList.clear();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.split("\\|");
        int i = 0;
        while (i < paramString.length)
        {
          if (!TextUtils.isEmpty(paramString[i])) {
            paramArrayList.add(paramString[i]);
          }
          i += 1;
        }
      }
    }
  }
  
  public int a(ArrayList arg1)
  {
    int j = 0;
    if ((??? == null) || (???.size() <= 0)) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      int k;
      for (i = 0; j < ???.size(); i = k)
      {
        k = i;
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(???.get(j)))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(???.get(j));
          k = i + 1;
        }
        j += 1;
      }
      j = i;
    } while (i <= 0);
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 5) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    return i;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          localStringBuilder.append('|');
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public String toString()
  {
    return "listId:" + this.jdField_a_of_type_JavaLangString + ",state:" + this.jdField_a_of_type_Int + ",mGrapState:" + this.b + ",mGrapMoney:" + this.c + ",mGrapUserCount:" + this.d + ",uins:" + a() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDBHelper.GoldMsgNotifyRecord
 * JD-Core Version:    0.7.0.1
 */