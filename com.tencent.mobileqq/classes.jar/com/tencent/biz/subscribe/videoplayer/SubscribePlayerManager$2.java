package com.tencent.biz.subscribe.videoplayer;

import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.AutoVideoItemBuilder.AutoVideoMsgViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class SubscribePlayerManager$2
  implements Runnable
{
  SubscribePlayerManager$2(SubscribePlayerManager paramSubscribePlayerManager) {}
  
  public void run()
  {
    if (NetworkUtil.a(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    while ((SubscribePlayerManager.a(this.this$0)) || (SubscribePlayerManager.a(this.this$0).size() <= 0)) {
      return;
    }
    SubscribePlayerManager.a(this.this$0, true);
    Object localObject = SubscribePlayerManager.a(this.this$0).keySet().iterator();
    int i = 0;
    label73:
    if (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if (localInteger.intValue() <= i) {
        break label145;
      }
      i = localInteger.intValue();
    }
    label145:
    for (;;)
    {
      break label73;
      localObject = (AutoVideoItemBuilder.AutoVideoMsgViewHolder)SubscribePlayerManager.a(this.this$0).get(Integer.valueOf(i));
      if (localObject == null) {
        break;
      }
      SubscribePlayerManager.a(this.this$0, (AutoVideoItemBuilder.AutoVideoMsgViewHolder)localObject, ((AutoVideoItemBuilder.AutoVideoMsgViewHolder)localObject).b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2
 * JD-Core Version:    0.7.0.1
 */