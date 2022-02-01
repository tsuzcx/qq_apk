package com.tencent.biz.qqcircle.list.bizblocks;

import aacw;
import android.os.Handler;
import antf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import vjo;

class QCircleChatListBlock$3
  implements Runnable
{
  QCircleChatListBlock$3(QCircleChatListBlock paramQCircleChatListBlock, aacw paramaacw) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.mApp.a().a(antf.aU, 10008, null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    QCircleChatListBlock.access$102(this.this$0, new LinkedList());
    QCircleChatListBlock.access$100(this.this$0).addAll((Collection)localObject1);
    Collections.reverse(QCircleChatListBlock.access$100(this.this$0));
    localObject1 = this.this$0.makeRecentBaseDataList(QCircleChatListBlock.access$100(this.this$0));
    localObject2 = vjo.a(this.this$0.mApp, QCircleChatListBlock.access$100(this.this$0));
    ThreadManager.getUIHandlerV2().post(new QCircleChatListBlock.3.1(this, (Pair)localObject2));
    this.val$callBack.a((List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.3
 * JD-Core Version:    0.7.0.1
 */