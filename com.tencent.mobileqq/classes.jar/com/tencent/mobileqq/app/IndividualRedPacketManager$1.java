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
      localObject = IndividualRedPacketManager.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AIO_BG_WIDTH:");
      localStringBuilder.append(this.this$0.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.this$0.a().d();
    this.this$0.a().c();
    this.this$0.a();
    if (this.this$0.j > 0)
    {
      localObject = this.this$0.a().a(String.valueOf(this.this$0.j), true);
      if ((localObject == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).a == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).b == null) || (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).c == null)) {
        this.this$0.a().a(16L, String.valueOf(this.this$0.j), null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.IndividualRedPacketManager.1
 * JD-Core Version:    0.7.0.1
 */