package com.tencent.mobileqq.app.fms;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
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
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.struct_msg_global_search.name(), "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|32|35|38|40|41|44|53|54|60");
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MsgSearch", 2, str);
    }
    a = str.split("\\|");
  }
  
  public static FullMessageSearchResult.SearchResultItem a(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, Cursor paramCursor, String paramString1, int paramInt, String paramString2, FullMessageSearchTask paramFullMessageSearchTask)
  {
    paramQQAppInterface = null;
    Object localObject2 = null;
    Object localObject1 = paramQQAppInterface;
    if (paramCursor != null)
    {
      localObject1 = paramQQAppInterface;
      if (paramCursor.getCount() != 0)
      {
        localObject1 = paramQQAppInterface;
        if (!TextUtils.isEmpty(paramString1))
        {
          if (TextUtils.isEmpty(paramString2)) {
            return null;
          }
          localObject1 = paramString2.toLowerCase(Locale.US);
          paramString2 = new ArrayList();
          ArrayList localArrayList = new ArrayList();
          if (paramCursor.isBeforeFirst()) {
            paramCursor.moveToFirst();
          }
          while (!paramCursor.isAfterLast()) {
            if (paramFullMessageSearchTask.h != 3)
            {
              if (paramFullMessageSearchTask.h == 2) {
                return null;
              }
              byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
              paramInt = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
              paramString1 = "";
              if (arrayOfByte != null)
              {
                paramQQAppInterface = paramString1;
                try
                {
                  if (arrayOfByte.length > 0) {
                    if (paramInt == -1000)
                    {
                      paramQQAppInterface = paramString1;
                      paramString1 = new String(arrayOfByte, "utf-8");
                      paramQQAppInterface = paramString1;
                    }
                    else if (paramInt == -1035)
                    {
                      paramQQAppInterface = paramString1;
                      MessageForMixedMsg localMessageForMixedMsg = new MessageForMixedMsg();
                      paramQQAppInterface = paramString1;
                      localMessageForMixedMsg.msgData = arrayOfByte;
                      paramQQAppInterface = paramString1;
                      localMessageForMixedMsg.doParse();
                      paramQQAppInterface = paramString1;
                      paramString1 = localMessageForMixedMsg.msg;
                      paramQQAppInterface = paramString1;
                    }
                    else if (paramInt == -2011)
                    {
                      paramQQAppInterface = paramString1;
                      paramString1 = a(arrayOfByte);
                      paramQQAppInterface = paramString1;
                    }
                  }
                }
                catch (Exception paramString1)
                {
                  break label316;
                }
              }
              paramQQAppInterface = "";
              if (paramQQAppInterface == null) {
                try
                {
                  paramString1 = new String("");
                }
                catch (Exception paramString1)
                {
                  break label316;
                }
              } else {
                paramString1 = paramQQAppInterface;
              }
              paramQQAppInterface = paramString1;
              paramString1 = paramString1.toLowerCase(Locale.US);
              paramQQAppInterface = paramString1;
              boolean bool = paramString1.contains((CharSequence)localObject1);
              paramQQAppInterface = paramString1;
              break label323;
              label316:
              paramString1.printStackTrace();
              bool = false;
              label323:
              if (bool)
              {
                if (paramString2.size() < 1)
                {
                  paramString1 = (MessageRecord)paramEntityManager.cursor2Entity(MessageRecord.class, null, paramCursor);
                  if (paramString1 != null)
                  {
                    paramString1.msg = paramQQAppInterface;
                    paramString2.add(paramString1);
                  }
                }
                localArrayList.add(Long.valueOf(paramCursor.getLong(paramCursor.getColumnIndex("uniseq"))));
              }
              paramCursor.moveToNext();
            }
            else
            {
              return null;
            }
          }
          paramQQAppInterface = localObject2;
          if (paramString2.size() > 0)
          {
            paramQQAppInterface = new FullMessageSearchResult.SearchResultItem();
            paramQQAppInterface.secondPageList = paramString2;
            paramQQAppInterface.secondPageMessageUniseq = localArrayList;
          }
          paramEntityManager = paramFullMessageSearchTask.i;
          localObject1 = paramQQAppInterface;
          if (paramEntityManager != null)
          {
            paramEntityManager.a += paramCursor.getCount();
            paramEntityManager.c += paramString2.size();
            paramEntityManager.c += localArrayList.size();
            localObject1 = paramQQAppInterface;
          }
        }
      }
    }
    return localObject1;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      AbsStructMsg localAbsStructMsg = StructMsgFactory.a(paramArrayOfByte);
      if (localAbsStructMsg != null)
      {
        boolean bool = a(String.valueOf(localAbsStructMsg.mMsgServiceID));
        if (((localAbsStructMsg instanceof AbsShareMsg)) && (bool))
        {
          AbsShareMsg localAbsShareMsg = (AbsShareMsg)localAbsStructMsg;
          String str = localAbsShareMsg.mContentTitle;
          paramArrayOfByte = str;
          if (!TextUtils.isEmpty(str)) {
            return paramArrayOfByte;
          }
          paramArrayOfByte = str;
          if (!(localAbsStructMsg instanceof AbsStructMsg)) {
            return paramArrayOfByte;
          }
          return localAbsShareMsg.mMsgBrief;
        }
      }
    }
    paramArrayOfByte = "";
    return paramArrayOfByte;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        return false;
      }
      String[] arrayOfString = a;
      if (arrayOfString == null) {
        return false;
      }
      int i = arrayOfString.length;
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
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.MessageSearchUtils
 * JD-Core Version:    0.7.0.1
 */