package com.tencent.biz.webviewplugin;

import android.app.Activity;
import java.util.HashMap;
import naj;
import xmq;

public class Share$6
  extends Thread
{
  public Share$6(xmq paramxmq, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    if (this.jdField_a_of_type_Boolean) {
      ((HashMap)localObject).put("url", this.jdField_a_of_type_JavaLangString);
    }
    localObject = naj.a((HashMap)localObject);
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = (String)((HashMap)localObject).get("url");; localObject = this.jdField_a_of_type_JavaLangString)
    {
      this.this$0.a.runOnUiThread(new Share.6.1(this, (String)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.6
 * JD-Core Version:    0.7.0.1
 */