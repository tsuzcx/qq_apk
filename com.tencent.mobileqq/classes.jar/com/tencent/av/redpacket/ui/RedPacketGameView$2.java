package com.tencent.av.redpacket.ui;

import android.graphics.Bitmap;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.app.ThreadManager;
import luk;

class RedPacketGameView$2
  implements Runnable
{
  RedPacketGameView$2(RedPacketGameView paramRedPacketGameView, AVRedPacketManager paramAVRedPacketManager) {}
  
  public void run()
  {
    Object localObject = (AVActivity)this.this$0.getContext();
    if ((localObject != null) && (this.this$0.a != null))
    {
      localObject = ((AVActivity)localObject).a;
      this.this$0.a.b(true);
      this.this$0.setDrawingCacheEnabled(true);
      Bitmap localBitmap = this.this$0.getDrawingCache();
      this.this$0.a.b(false);
      ThreadManager.postImmediately(new RedPacketGameView.2.1(this, (VideoLayerUI)localObject, localBitmap), null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameView.2
 * JD-Core Version:    0.7.0.1
 */