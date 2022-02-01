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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = IndividualRedPacketManager.i();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIO_BG_WIDTH:");
      localStringBuilder.append(this.this$0.d);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.this$0.a().d();
    this.this$0.a().c();
    this.this$0.e();
    if (this.this$0.E > 0)
    {
      localObject = this.this$0.a().a(String.valueOf(this.this$0.E), true);
      if ((localObject == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).b == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).c == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).d == null)) {
        this.this$0.a().a(16L, String.valueOf(this.this$0.E), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.1
 * JD-Core Version:    0.7.0.1
 */