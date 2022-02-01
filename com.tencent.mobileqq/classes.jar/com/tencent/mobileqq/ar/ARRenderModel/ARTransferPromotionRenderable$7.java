package com.tencent.mobileqq.ar.ARRenderModel;

import aoru;
import aosa;
import aoua;
import aouh;
import aouj;
import aoyx;
import aptf;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(aouh paramaouh) {}
  
  public void run()
  {
    if (aouh.a(this.this$0) == 6)
    {
      if ((aouh.a(this.this$0) != null) && (aouh.a(this.this$0)))
      {
        aouh.a(this.this$0).b(1, 0);
        aouh.a(this.this$0, false);
      }
      if ((aouh.a(this.this$0) != null) && (aouh.b(this.this$0))) {
        aouh.a(this.this$0).a();
      }
      if ((aouh.b(this.this$0) != -1) && (aouh.a(this.this$0) != null))
      {
        aouh.a(this.this$0).stopPreDownload(aouh.b(this.this$0));
        aouh.a(this.this$0, -1);
      }
      if (aouh.a(this.this$0) != null) {
        aouh.a(this.this$0).destory();
      }
      if (aouh.a(this.this$0) != null) {
        aouh.a(this.this$0).a(aouh.a(this.this$0).a);
      }
      if (aouh.a(this.this$0) == 6) {
        aouh.a(this.this$0, 7);
      }
      aouh.a(this.this$0).a();
      if (aouh.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (aouh.a(this.this$0))
    {
      aouh.a(this.this$0).clear();
      aouh.a(this.this$0).c();
      aouh.a(this.this$0);
      if (aouh.a(this.this$0) != null)
      {
        aouh.a(this.this$0).b();
        aouh.a(this.this$0).a();
        aouh.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */