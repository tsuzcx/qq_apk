package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import ocd;
import paa;

public final class ReadinjoyReportUtils$4
  implements Runnable
{
  public ReadinjoyReportUtils$4(RecentItemChatMsgData paramRecentItemChatMsgData) {}
  
  public void run()
  {
    paa localpaa = new paa();
    if (this.a.mUnreadNum > 0) {}
    for (int i = 1;; i = 0)
    {
      localpaa.b("reddot_position", "" + (this.a.mPosition + 1));
      if (i != 0) {}
      for (String str = "1";; str = "0")
      {
        localpaa.b("reddot_state", str);
        ocd.a(null, null, "0X800978E", "0X800978E", 0, 0, "", "", "", localpaa.a(), false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadinjoyReportUtils.4
 * JD-Core Version:    0.7.0.1
 */