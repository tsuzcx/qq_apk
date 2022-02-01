package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.biz.common.util.HttpUtil;
import java.util.HashMap;

class Share$6
  extends Thread
{
  Share$6(Share paramShare, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    if (this.a) {
      ((HashMap)localObject).put("url", this.b);
    }
    localObject = HttpUtil.shortenUrlBatch((HashMap)localObject);
    if (this.a) {
      localObject = (String)((HashMap)localObject).get("url");
    } else {
      localObject = this.b;
    }
    this.this$0.y.runOnUiThread(new Share.6.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.6
 * JD-Core Version:    0.7.0.1
 */