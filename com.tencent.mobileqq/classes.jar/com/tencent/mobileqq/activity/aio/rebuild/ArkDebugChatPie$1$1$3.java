package com.tencent.mobileqq.activity.aio.rebuild;

import ahyj;
import ahyk;
import anvx;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.widget.QQToast;

public class ArkDebugChatPie$1$1$3
  implements Runnable
{
  public ArkDebugChatPie$1$1$3(ahyk paramahyk, String paramString1, String paramString2) {}
  
  public void run()
  {
    ArkAppMgr.getInstance().setDebugAppPathCache(this.jdField_a_of_type_JavaLangString, this.b);
    QQToast.a(this.jdField_a_of_type_Ahyk.a.this$0.mContext, anvx.a(2131700172), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3
 * JD-Core Version:    0.7.0.1
 */