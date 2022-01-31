package com.tencent.biz.subscribe.videoplayer;

import adng;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import nao;
import wtl;

public class SubscribePlayerManager$2
  implements Runnable
{
  public SubscribePlayerManager$2(wtl paramwtl) {}
  
  public void run()
  {
    if (nao.a(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    while ((wtl.a(this.this$0)) || (wtl.a(this.this$0).size() <= 0)) {
      return;
    }
    wtl.a(this.this$0, true);
    Object localObject = wtl.a(this.this$0).keySet().iterator();
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
      localObject = (adng)wtl.a(this.this$0).get(Integer.valueOf(i));
      if (localObject == null) {
        break;
      }
      wtl.a(this.this$0, (adng)localObject, ((adng)localObject).b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2
 * JD-Core Version:    0.7.0.1
 */