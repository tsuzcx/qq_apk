package com.tencent.biz.pubaccount.weishi_new.miniaio;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;

public class MiniMsgCallbackImpl
  implements IMiniMsgUnreadCallback
{
  public void destroy()
  {
    WSLog.a("AIOLog", 1, "MiniMsgUser destroy");
  }
  
  public void hide()
  {
    WSLog.a("AIOLog", 1, "MiniMsgUser hide");
  }
  
  public void hideUnread()
  {
    WSLog.a("AIOLog", 1, "MiniMsgUser hideUnread");
  }
  
  public boolean show(int paramInt)
  {
    WSLog.a("AIOLog", 1, "MiniMsgUser show = " + paramInt);
    return false;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle)
  {
    WSLog.a("AIOLog", 1, "MiniMsgUser updateOnBackFromMiniAIO");
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    WSLog.a("AIOLog", 1, "MiniMsgUser updateUnreadCount i = " + paramInt + ", b = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.miniaio.MiniMsgCallbackImpl
 * JD-Core Version:    0.7.0.1
 */