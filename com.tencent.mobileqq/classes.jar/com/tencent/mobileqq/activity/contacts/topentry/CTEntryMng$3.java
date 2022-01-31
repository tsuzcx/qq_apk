package com.tencent.mobileqq.activity.contacts.topentry;

import ahpq;
import ahpx;
import bdbr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

public class CTEntryMng$3
  implements Runnable
{
  public CTEntryMng$3(ahpq paramahpq) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(ahpq.a(this.this$0));
    for (;;)
    {
      JSONArray localJSONArray;
      int i;
      String str;
      try
      {
        if (localArrayList.size() > 0)
        {
          localJSONArray = new JSONArray();
          i = 0;
          if (i >= localArrayList.size()) {
            break label211;
          }
          Object localObject = (ahpx)localArrayList.get(i);
          if ((((ahpx)localObject).a > 4) && (!ahpq.b(this.this$0).contains(Integer.valueOf(((ahpx)localObject).a))))
          {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "saveUserSetting not save id: " + ((ahpx)localObject).a);
            }
          }
          else
          {
            localObject = ((ahpx)localObject).a();
            if (localObject != null) {
              localJSONArray.put(localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str = "";
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "saveUserSetting value: %s", new Object[] { str }));
        }
        bdbr.a(ahpq.a(this.this$0).getApp(), ahpq.a(this.this$0).c(), "ct_entry_user_setting", str);
        return;
        label211:
        str = localJSONArray.toString();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3
 * JD-Core Version:    0.7.0.1
 */