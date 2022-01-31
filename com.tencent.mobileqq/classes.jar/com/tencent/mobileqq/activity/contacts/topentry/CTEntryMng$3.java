package com.tencent.mobileqq.activity.contacts.topentry;

import afgd;
import afgk;
import babf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

public class CTEntryMng$3
  implements Runnable
{
  public CTEntryMng$3(afgd paramafgd) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(afgd.a(this.this$0));
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
          Object localObject = (afgk)localArrayList.get(i);
          if ((((afgk)localObject).a > 4) && (!afgd.b(this.this$0).contains(Integer.valueOf(((afgk)localObject).a))))
          {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "saveUserSetting not save id: " + ((afgk)localObject).a);
            }
          }
          else
          {
            localObject = ((afgk)localObject).a();
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
        babf.a(afgd.a(this.this$0).getApp(), afgd.a(this.this$0).c(), "ct_entry_user_setting", str);
        return;
        label211:
        str = localJSONArray.toString();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3
 * JD-Core Version:    0.7.0.1
 */