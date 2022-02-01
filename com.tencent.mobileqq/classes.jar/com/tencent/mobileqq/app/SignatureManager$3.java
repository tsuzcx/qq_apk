package com.tencent.mobileqq.app;

import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class SignatureManager$3
  implements Runnable
{
  public void run()
  {
    this.this$0.r.set(this.a);
    SignatureTemplateInfo localSignatureTemplateInfo = SignatureTemplateConfig.a(this.this$0.j, this.a);
    if (localSignatureTemplateInfo != null) {
      SignatureManager.n.put(Integer.valueOf(this.a), localSignatureTemplateInfo);
    }
    this.this$0.r.set(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.3
 * JD-Core Version:    0.7.0.1
 */