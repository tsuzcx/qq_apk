package com.tencent.mobileqq.app.readinjoy;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bnrf;
import java.util.List;

class ReadInJoyManager$2
  implements Runnable
{
  public void run()
  {
    String str = "";
    int i = 0;
    int j;
    if (i < this.a.size())
    {
      j = ((Integer)this.a.get(i)).intValue();
      if (i <= 0) {
        break label180;
      }
      str = str + ",";
    }
    label180:
    for (;;)
    {
      str = str + j;
      i += 1;
      break;
      if (ReadInJoyManager.a(this.this$0) == null) {}
      do
      {
        return;
        localObject = ReadInJoyManager.a(this.this$0).getString("config_new_channel_id_list", "");
      } while ((TextUtils.isEmpty(str)) || (((String)localObject).equals(str)));
      Object localObject = ReadInJoyManager.a(this.this$0).edit();
      ((SharedPreferences.Editor)localObject).putString("config_new_channel_id_list", str);
      ((SharedPreferences.Editor)localObject).putInt("config_new_channel_notify_flag", 1);
      bnrf.a((SharedPreferences.Editor)localObject, true);
      ReadInJoyManager.b(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.2
 * JD-Core Version:    0.7.0.1
 */