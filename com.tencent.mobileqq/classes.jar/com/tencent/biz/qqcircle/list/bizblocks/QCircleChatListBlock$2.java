package com.tencent.biz.qqcircle.list.bizblocks;

import com.tencent.mobileqq.app.QQAppInterface;
import uzg;

class QCircleChatListBlock$2
  implements Runnable
{
  QCircleChatListBlock$2(QCircleChatListBlock paramQCircleChatListBlock) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = uzg.a(QCircleChatListBlock.access$000(this.this$0));
    if (localQQAppInterface != null) {
      ((QCircleHandler)localQQAppInterface.a(183)).clearPedPoint();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.2
 * JD-Core Version:    0.7.0.1
 */