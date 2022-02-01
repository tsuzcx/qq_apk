package com.tencent.mobileqq.app.readinjoy;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoyManager$3
  implements Runnable
{
  public void run()
  {
    if (ReadInJoyManager.a(this.this$0) == null) {
      return;
    }
    SharedPreferences.Editor localEditor = ReadInJoyManager.a(this.this$0).edit();
    localEditor.putString("config_notify_guide_wording", this.a);
    localEditor.putInt("config_notify_guide_flag", 1);
    localEditor.putLong("config_notify_guide_updated_time", NetConnInfoCenter.getServerTime());
    ReadInJoyHelper.a(localEditor, true);
    ReadInJoyManager.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.readinjoy.ReadInJoyManager.3
 * JD-Core Version:    0.7.0.1
 */