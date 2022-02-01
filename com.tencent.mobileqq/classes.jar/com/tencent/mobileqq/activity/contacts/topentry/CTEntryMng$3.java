package com.tencent.mobileqq.activity.contacts.topentry;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ConfigUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

class CTEntryMng$3
  implements Runnable
{
  CTEntryMng$3(CTEntryMng paramCTEntryMng) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(CTEntryMng.b(this.this$0));
    String str2 = "";
    Object localObject1 = str2;
    for (;;)
    {
      int i;
      String str1;
      try
      {
        if (localArrayList.size() > 0)
        {
          localObject1 = new JSONArray();
          i = 0;
          if (i < localArrayList.size())
          {
            Object localObject2 = (CTEntryMng.EntryUserSetting)localArrayList.get(i);
            if ((((CTEntryMng.EntryUserSetting)localObject2).a > 4) && (!CTEntryMng.c(this.this$0).contains(Integer.valueOf(((CTEntryMng.EntryUserSetting)localObject2).a))))
            {
              if (!QLog.isColorLevel()) {
                break label237;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("saveUserSetting not save id: ");
              localStringBuilder.append(((CTEntryMng.EntryUserSetting)localObject2).a);
              QLog.i("CTEntryMng", 2, localStringBuilder.toString());
              break label237;
            }
            localObject2 = ((CTEntryMng.EntryUserSetting)localObject2).a();
            if (localObject2 == null) {
              break label237;
            }
            ((JSONArray)localObject1).put(localObject2);
            break label237;
          }
          localObject1 = ((JSONArray)localObject1).toString();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str1 = str2;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveUserSetting value: %s", new Object[] { str1 }));
      }
      ConfigUtil.a(CTEntryMng.a(this.this$0).getApp(), CTEntryMng.a(this.this$0).getCurrentUin(), "ct_entry_user_setting", str1);
      return;
      label237:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3
 * JD-Core Version:    0.7.0.1
 */