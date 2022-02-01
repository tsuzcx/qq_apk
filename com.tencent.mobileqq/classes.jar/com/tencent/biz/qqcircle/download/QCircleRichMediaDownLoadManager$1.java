package com.tencent.biz.qqcircle.download;

import bgmg;
import com.tencent.qphone.base.util.QLog;
import vit;
import viw;
import vix;

public class QCircleRichMediaDownLoadManager$1
  implements Runnable
{
  public QCircleRichMediaDownLoadManager$1(vit paramvit, viw paramviw) {}
  
  public void run()
  {
    bgmg.c(vit.a() + ".nomedia");
    if (bgmg.a(this.a.b()))
    {
      if (viw.a(this.a) != null) {
        viw.a(this.a).a(true);
      }
      QLog.d(vit.b(), 1, this.a.a() + ",download file is existed ");
    }
    do
    {
      return;
      if (!bgmg.a(this.a.c())) {
        break;
      }
    } while (vit.a(this.this$0, this.a));
    vit.a(this.this$0, this.a);
    return;
    vit.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.1
 * JD-Core Version:    0.7.0.1
 */