package com.tencent.mobileqq.activity;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import bdbk;
import bdhj;
import java.util.List;

class ChatSettingForTroop$21
  implements Runnable
{
  ChatSettingForTroop$21(ChatSettingForTroop paramChatSettingForTroop, long paramLong) {}
  
  public void run()
  {
    int j = this.this$0.b.size();
    int i = 0;
    ImageView localImageView;
    Object localObject;
    if (i < j)
    {
      localImageView = (ImageView)this.this$0.b.get(i);
      localObject = (String)localImageView.getTag();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      try
      {
        long l = Long.valueOf((String)localObject).longValue();
        if (l == this.a)
        {
          localObject = bdhj.a();
          localObject = bdbk.a(this.this$0.app, 1, Long.toString(this.a), 3, (Drawable)localObject, (Drawable)localObject, 4);
          this.this$0.runOnUiThread(new ChatSettingForTroop.21.1(this, localImageView, (bdbk)localObject));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.21
 * JD-Core Version:    0.7.0.1
 */