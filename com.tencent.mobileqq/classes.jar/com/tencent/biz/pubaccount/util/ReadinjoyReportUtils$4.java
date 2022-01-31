package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import ndn;
import ocg;

public final class ReadinjoyReportUtils$4
  implements Runnable
{
  public ReadinjoyReportUtils$4(RecentItemChatMsgData paramRecentItemChatMsgData) {}
  
  public void run()
  {
    ocg localocg = new ocg();
    if (this.a.mUnreadNum > 0) {}
    for (int i = 1;; i = 0)
    {
      localocg.b("reddot_position", "" + (this.a.mPosition + 1));
      if (i != 0) {}
      for (String str = "1";; str = "0")
      {
        localocg.b("reddot_state", str);
        ndn.a(null, null, "0X800978E", "0X800978E", 0, 0, "", "", "", localocg.a(), false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.4
 * JD-Core Version:    0.7.0.1
 */