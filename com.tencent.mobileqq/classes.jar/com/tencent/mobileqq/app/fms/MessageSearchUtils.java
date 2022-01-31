package com.tencent.mobileqq.app.fms;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class MessageSearchUtils
{
  private static String[] a;
  
  static
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.struct_msg_global_search.name(), "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|32|35|38|40|41|44|53|54|60");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgSearch", 2, str);
    }
    a = str.split("\\|");
  }
  
  public static FullMessageSearchResult.SearchResultItem a(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, Cursor paramCursor, String paramString1, int paramInt, String paramString2, FullMessageSearchTask paramFullMessageSearchTask)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramEntityManager = null;
      return paramEntityManager;
    }
    String str = paramString2.toLowerCase(Locale.US);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    label76:
    Object localObject;
    if (!paramCursor.isAfterLast())
    {
      if ((paramFullMessageSearchTask.c == 3) || (paramFullMessageSearchTask.c == 2)) {
        return null;
      }
      localObject = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
      paramInt = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
      paramString2 = "";
      paramString1 = paramString2;
      if (localObject == null) {
        break label590;
      }
      paramQQAppInterface = paramString2;
      paramString1 = paramString2;
    }
    for (;;)
    {
      boolean bool;
      try
      {
        if (localObject.length <= 0) {
          break label590;
        }
        if (paramInt == -1000)
        {
          paramQQAppInterface = paramString2;
          paramString1 = new String((byte[])localObject, "utf-8");
          paramQQAppInterface = paramString1;
          paramString1 = paramQQAppInterface;
          if (paramQQAppInterface != null) {}
        }
      }
      catch (Exception paramString1) {}
      try
      {
        paramString1 = new String("");
        paramQQAppInterface = paramString1;
        paramString1 = paramString1.toLowerCase(Locale.US);
        paramQQAppInterface = paramString1;
        bool = paramString1.contains(str);
        if (!bool) {
          break label582;
        }
        paramInt = 1;
        paramQQAppInterface = paramString1;
      }
      catch (Exception paramString1)
      {
        break label481;
        paramInt = 0;
        paramQQAppInterface = paramString1;
        continue;
      }
      if (paramInt != 0)
      {
        if (localArrayList1.size() < 1)
        {
          paramString1 = (MessageRecord)paramEntityManager.a(MessageRecord.class, null, paramCursor);
          if (paramString1 != null)
          {
            paramString1.msg = paramQQAppInterface;
            localArrayList1.add(paramString1);
          }
        }
        localArrayList2.add(Long.valueOf(paramCursor.getLong(paramCursor.getColumnIndex("uniseq"))));
      }
      paramCursor.moveToNext();
      break label76;
      if (paramInt == -1035)
      {
        paramQQAppInterface = paramString2;
        paramString1 = new MessageForMixedMsg();
        paramQQAppInterface = paramString2;
        paramString1.msgData = ((byte[])localObject);
        paramQQAppInterface = paramString2;
        paramString1.doParse();
        paramQQAppInterface = paramString2;
        paramString1 = paramString1.msg;
        paramQQAppInterface = paramString1;
      }
      else
      {
        paramString1 = paramString2;
        if (paramInt == -2011)
        {
          paramQQAppInterface = paramString2;
          localObject = StructMsgFactory.a((byte[])localObject);
          paramString1 = paramString2;
          if (localObject != null)
          {
            paramQQAppInterface = paramString2;
            bool = a(String.valueOf(((AbsStructMsg)localObject).mMsgServiceID));
            paramQQAppInterface = paramString2;
            paramString1 = paramString2;
            if ((localObject instanceof AbsShareMsg))
            {
              paramString1 = paramString2;
              if (bool)
              {
                paramQQAppInterface = paramString2;
                paramString2 = ((AbsShareMsg)localObject).mContentTitle;
                paramQQAppInterface = paramString2;
                paramString1 = paramString2;
                if (TextUtils.isEmpty(paramString2))
                {
                  paramQQAppInterface = paramString2;
                  paramString1 = paramString2;
                  if ((localObject instanceof AbsStructMsg))
                  {
                    paramQQAppInterface = paramString2;
                    paramString1 = ((AbsShareMsg)localObject).mMsgBrief;
                    paramQQAppInterface = paramString1;
                    continue;
                    label481:
                    paramString1.printStackTrace();
                    paramInt = 0;
                    continue;
                    paramQQAppInterface = null;
                    if (localArrayList1.size() > 0)
                    {
                      paramQQAppInterface = new FullMessageSearchResult.SearchResultItem();
                      paramQQAppInterface.secondPageList = localArrayList1;
                      paramQQAppInterface.secondPageMessageUniseq = localArrayList2;
                    }
                    paramString1 = paramFullMessageSearchTask.a;
                    paramEntityManager = paramQQAppInterface;
                    if (paramString1 == null) {
                      break;
                    }
                    paramString1.a += paramCursor.getCount();
                    paramString1.c += localArrayList1.size();
                    paramString1.c += localArrayList2.size();
                    return paramQQAppInterface;
                  }
                }
              }
            }
          }
        }
        label582:
        label590:
        paramQQAppInterface = paramString1;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("0"))) {}
    for (;;)
    {
      return false;
      if (a != null)
      {
        int i = a.length;
        String[] arrayOfString = a;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (paramString.equals(arrayOfString[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.MessageSearchUtils
 * JD-Core Version:    0.7.0.1
 */