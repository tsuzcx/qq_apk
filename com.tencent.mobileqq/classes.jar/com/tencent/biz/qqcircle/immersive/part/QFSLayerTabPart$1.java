package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.qphone.base.util.QLog;

class QFSLayerTabPart$1
  implements Runnable
{
  QFSLayerTabPart$1(QFSLayerTabPart paramQFSLayerTabPart) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      boolean bool = this.this$0.b.d(QFSLayerTabPart.a(this.this$0));
      String str = this.this$0.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFSFeedEvent removeFeedByUin uin = ");
      localStringBuilder.append(QFSLayerTabPart.a(this.this$0));
      localStringBuilder.append(" | result = ");
      localStringBuilder.append(bool);
      QLog.i(str, 1, localStringBuilder.toString());
      if (bool)
      {
        QFSLayerTabPart.a(this.this$0, null);
        this.this$0.b.notifyDataSetChanged();
        this.this$0.b(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerTabPart.1
 * JD-Core Version:    0.7.0.1
 */