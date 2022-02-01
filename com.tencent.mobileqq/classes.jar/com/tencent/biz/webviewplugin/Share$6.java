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
    if (this.jdField_a_of_type_Boolean) {
      ((HashMap)localObject).put("url", this.jdField_a_of_type_JavaLangString);
    }
    localObject = HttpUtil.shortenUrlBatch((HashMap)localObject);
    if (this.jdField_a_of_type_Boolean) {
      localObject = (String)((HashMap)localObject).get("url");
    } else {
      localObject = this.jdField_a_of_type_JavaLangString;
    }
    this.this$0.a.runOnUiThread(new Share.6.1(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.6
 * JD-Core Version:    0.7.0.1
 */