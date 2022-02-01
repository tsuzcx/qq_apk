package com.tencent.biz.qqcircle.download;

import bhmi;
import com.tencent.qphone.base.util.QLog;
import vkx;
import vla;
import vlb;

public class QCircleRichMediaDownLoadManager$1
  implements Runnable
{
  public QCircleRichMediaDownLoadManager$1(vkx paramvkx, vla paramvla) {}
  
  public void run()
  {
    bhmi.c(vkx.a() + ".nomedia");
    if (bhmi.a(this.a.b()))
    {
      if (vla.a(this.a) != null) {
        vla.a(this.a).a(true);
      }
      QLog.d(vkx.b(), 1, this.a.a() + ",download file is existed ");
    }
    do
    {
      return;
      if (!bhmi.a(this.a.c())) {
        break;
      }
    } while (vkx.a(this.this$0, this.a));
    vkx.a(this.this$0, this.a);
    return;
    vkx.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.1
 * JD-Core Version:    0.7.0.1
 */