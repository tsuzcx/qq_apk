package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class ArkDebugChatPie$1$1$3
  implements Runnable
{
  ArkDebugChatPie$1$1$3(ArkDebugChatPie.1.1 param1, String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().setDebugAppPathCache(this.a, this.b);
    QQToast.makeText(this.c.a.this$0.e, HardCodeUtil.a(2131898918), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3
 * JD-Core Version:    0.7.0.1
 */