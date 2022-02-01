package com.tencent.mobileqq.activity.aio;

import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;

public class AllInOneFactory
{
  private static ArrayMap<Integer, AllInOneFactory.AllInOneSupplier> a = new ArrayMap();
  
  static
  {
    a.put(Integer.valueOf(1010), new AllInOneFactory.1());
    a.put(Integer.valueOf(1001), new AllInOneFactory.2());
    a.put(Integer.valueOf(10002), new AllInOneFactory.3());
    a.put(Integer.valueOf(10004), new AllInOneFactory.4());
    a.put(Integer.valueOf(0), new AllInOneFactory.5());
    a.put(Integer.valueOf(1000), new AllInOneFactory.6());
    a.put(Integer.valueOf(1020), new AllInOneFactory.7());
    a.put(Integer.valueOf(1), new AllInOneFactory.8());
    a.put(Integer.valueOf(3000), new AllInOneFactory.9());
    a.put(Integer.valueOf(1004), new AllInOneFactory.10());
    a.put(Integer.valueOf(1005), new AllInOneFactory.11());
    a.put(Integer.valueOf(1023), new AllInOneFactory.12());
    a.put(Integer.valueOf(1009), new AllInOneFactory.13());
    a.put(Integer.valueOf(1006), new AllInOneFactory.14());
    a.put(Integer.valueOf(1021), new AllInOneFactory.15());
    a.put(Integer.valueOf(1022), new AllInOneFactory.16());
    a.put(Integer.valueOf(10008), new AllInOneFactory.17());
    a.put(Integer.valueOf(10010), new AllInOneFactory.18());
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (paramMessageRecord.istroop == 1) {
      paramMessageRecord = new ProfileActivity.AllInOne(paramString, 20);
    }
    for (;;)
    {
      paramMessageRecord.h = ContactUtils.i(paramQQAppInterface, paramString);
      return paramMessageRecord;
      if (paramMessageRecord.istroop == 3000) {
        paramMessageRecord = new ProfileActivity.AllInOne(paramString, 45);
      } else {
        paramMessageRecord = new ProfileActivity.AllInOne(paramString, 1);
      }
    }
  }
  
  public static ProfileActivity.AllInOne a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    if (a.containsKey(Integer.valueOf(paramMessageRecord.istroop))) {
      return ((AllInOneFactory.AllInOneSupplier)a.get(Integer.valueOf(paramMessageRecord.istroop))).a(paramQQAppInterface, paramString, paramSessionInfo, paramMessageRecord);
    }
    paramQQAppInterface = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 19);
    paramQQAppInterface.h = paramSessionInfo.d;
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AllInOneFactory
 * JD-Core Version:    0.7.0.1
 */