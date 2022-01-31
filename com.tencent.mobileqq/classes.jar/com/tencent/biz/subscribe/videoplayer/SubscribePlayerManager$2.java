package com.tencent.biz.subscribe.videoplayer;

import adcg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mpq;
import wet;

public class SubscribePlayerManager$2
  implements Runnable
{
  public SubscribePlayerManager$2(wet paramwet) {}
  
  public void run()
  {
    if (mpq.a(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    while ((wet.a(this.this$0)) || (wet.a(this.this$0).size() <= 0)) {
      return;
    }
    wet.a(this.this$0, true);
    Object localObject = wet.a(this.this$0).keySet().iterator();
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
      localObject = (adcg)wet.a(this.this$0).get(Integer.valueOf(i));
      if (localObject == null) {
        break;
      }
      wet.a(this.this$0, (adcg)localObject, ((adcg)localObject).b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2
 * JD-Core Version:    0.7.0.1
 */