package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.widget.XEditTextEx;

class AIODraftHelper$1
  implements Runnable
{
  AIODraftHelper$1(AIODraftHelper paramAIODraftHelper, XEditTextEx paramXEditTextEx) {}
  
  public void run()
  {
    if (ZhituManager.a(AIODraftHelper.a(this.this$0)).a(this.a.getText())) {
      this.this$0.a();
    }
    ((FullScreenInputHelper)AIODraftHelper.a(this.this$0).a(24)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIODraftHelper.1
 * JD-Core Version:    0.7.0.1
 */