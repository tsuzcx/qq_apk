package com.tencent.hippy.qq.preload;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.statemachine.api.StateObserver;

class TabPreloadManager$3
  implements StateObserver
{
  TabPreloadManager$3(TabPreloadManager paramTabPreloadManager) {}
  
  public void onStateChanged(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (TabPreloadManager.access$300(this.this$0) == null) {
        return;
      }
      String str = TabPreloadManager.access$400(this.this$0, paramString1);
      if (TextUtils.isEmpty(str)) {
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 1;
      localMessage.obj = str;
      int j = 1000;
      int i = j;
      if (paramString2 == null)
      {
        i = j;
        if (paramString1.equals("main_message_tab_show")) {
          i = 5000;
        }
      }
      TabPreloadManager.access$300(this.this$0).removeMessages(1);
      TabPreloadManager.access$300(this.this$0).sendMessageDelayed(localMessage, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.preload.TabPreloadManager.3
 * JD-Core Version:    0.7.0.1
 */