import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult.SearchResultItem;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

public class anie
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
  
  public static FullMessageSearchResult.SearchResultItem a(QQAppInterface paramQQAppInterface, EntityManager paramEntityManager, Cursor paramCursor, String paramString1, int paramInt, String paramString2, anic paramanic)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramEntityManager = null;
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return paramEntityManager;
      String str = paramString2.toLowerCase(Locale.US);
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if (paramCursor.isBeforeFirst()) {
        paramCursor.moveToFirst();
      }
      if (!paramCursor.isAfterLast())
      {
        if ((paramanic.c == 3) || (paramanic.c == 2)) {
          return null;
        }
        paramInt = 0;
        byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
        int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
        paramString2 = "";
        paramQQAppInterface = paramString2;
        if (arrayOfByte != null)
        {
          paramQQAppInterface = paramString2;
          paramString1 = paramString2;
        }
        for (;;)
        {
          try
          {
            if (arrayOfByte.length > 0)
            {
              if (i != -1000) {
                continue;
              }
              paramString1 = paramString2;
              paramQQAppInterface = new String(arrayOfByte, "utf-8");
            }
            paramString2 = paramQQAppInterface;
            if (paramQQAppInterface == null)
            {
              paramString1 = paramQQAppInterface;
              paramString2 = new String("");
            }
            paramString1 = paramString2;
            paramQQAppInterface = paramString2.toLowerCase(Locale.US);
            paramString1 = paramQQAppInterface;
            boolean bool = paramQQAppInterface.contains(str);
            paramString1 = paramQQAppInterface;
            if (bool)
            {
              paramInt = 1;
              paramString1 = paramQQAppInterface;
            }
          }
          catch (Exception paramQQAppInterface)
          {
            paramQQAppInterface.printStackTrace();
            paramInt = 0;
            continue;
          }
          if (paramInt != 0)
          {
            if (localArrayList1.size() < 1)
            {
              paramQQAppInterface = (MessageRecord)paramEntityManager.cursor2Entity(MessageRecord.class, null, paramCursor);
              if (paramQQAppInterface != null)
              {
                paramQQAppInterface.msg = paramString1;
                localArrayList1.add(paramQQAppInterface);
              }
            }
            localArrayList2.add(Long.valueOf(paramCursor.getLong(paramCursor.getColumnIndex("uniseq"))));
          }
          paramCursor.moveToNext();
          break;
          if (i == -1035)
          {
            paramString1 = paramString2;
            paramQQAppInterface = new MessageForMixedMsg();
            paramString1 = paramString2;
            paramQQAppInterface.msgData = arrayOfByte;
            paramString1 = paramString2;
            paramQQAppInterface.doParse();
            paramString1 = paramString2;
            paramQQAppInterface = paramQQAppInterface.msg;
          }
          else
          {
            paramQQAppInterface = paramString2;
            if (i == -2011)
            {
              paramString1 = paramString2;
              paramQQAppInterface = a(arrayOfByte);
            }
          }
        }
      }
      paramQQAppInterface = null;
      if (localArrayList1.size() > 0)
      {
        paramQQAppInterface = new FullMessageSearchResult.SearchResultItem();
        paramQQAppInterface.secondPageList = localArrayList1;
        paramQQAppInterface.secondPageMessageUniseq = localArrayList2;
      }
      paramString1 = paramanic.a;
      paramEntityManager = paramQQAppInterface;
    } while (paramString1 == null);
    paramString1.a += paramCursor.getCount();
    paramString1.c += localArrayList1.size();
    paramString1.c += localArrayList2.size();
    return paramQQAppInterface;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    Object localObject = str;
    if (paramArrayOfByte != null)
    {
      localObject = str;
      if (paramArrayOfByte.length > 0)
      {
        AbsStructMsg localAbsStructMsg = bchh.a(paramArrayOfByte);
        localObject = str;
        if (localAbsStructMsg != null)
        {
          boolean bool = a(String.valueOf(localAbsStructMsg.mMsgServiceID));
          localObject = str;
          if ((localAbsStructMsg instanceof AbsShareMsg))
          {
            localObject = str;
            if (bool)
            {
              paramArrayOfByte = ((AbsShareMsg)localAbsStructMsg).mContentTitle;
              localObject = paramArrayOfByte;
              if (TextUtils.isEmpty(paramArrayOfByte))
              {
                localObject = paramArrayOfByte;
                if ((localAbsStructMsg instanceof AbsStructMsg)) {
                  localObject = ((AbsShareMsg)localAbsStructMsg).mMsgBrief;
                }
              }
            }
          }
        }
      }
    }
    return localObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anie
 * JD-Core Version:    0.7.0.1
 */