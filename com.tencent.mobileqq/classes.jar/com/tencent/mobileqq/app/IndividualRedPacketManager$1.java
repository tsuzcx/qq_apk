package com.tencent.mobileqq.app;

import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.qphone.base.util.QLog;

class IndividualRedPacketManager$1
  implements Runnable
{
  IndividualRedPacketManager$1(IndividualRedPacketManager paramIndividualRedPacketManager) {}
  
  public void run()
  {
    this.this$0.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(IndividualRedPacketManager.b(), 2, "AIO_BG_WIDTH:" + this.this$0.b);
    }
    this.this$0.a().d();
    this.this$0.a().c();
    this.this$0.a();
    if (this.this$0.j > 0)
    {
      IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = this.this$0.a().a(String.valueOf(this.this$0.j), true);
      if ((localRedPacketTemplateInfo == null) || (localRedPacketTemplateInfo.a == null) || (localRedPacketTemplateInfo.b == null) || (localRedPacketTemplateInfo.c == null)) {
        this.this$0.a().a(16L, String.valueOf(this.this$0.j), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.1
 * JD-Core Version:    0.7.0.1
 */