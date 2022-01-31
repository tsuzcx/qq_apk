package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import agrn;
import android.widget.TextView;

class DrawRedpacketPannelPreviewFragment$5
  implements Runnable
{
  DrawRedpacketPannelPreviewFragment$5(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (this.this$0.a.getVisibility() != 0) {
        this.this$0.a.setVisibility(0);
      }
      this.this$0.a.setText("当前识别结果：---- 当前识别成功阈值：" + agrn.a().a + "\n" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */