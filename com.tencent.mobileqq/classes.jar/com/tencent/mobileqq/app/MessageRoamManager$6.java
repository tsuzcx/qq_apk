package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import mqq.app.MobileQQ;

class MessageRoamManager$6
  implements Runnable
{
  MessageRoamManager$6(MessageRoamManager paramMessageRoamManager) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      Object localObject = this.this$0.b.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
      String str = Base64.encodeToString(this.this$0.k, 0);
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vip_message_roam_passwordmd5");
      localStringBuilder.append(this.this$0.b.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), str).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.6
 * JD-Core Version:    0.7.0.1
 */