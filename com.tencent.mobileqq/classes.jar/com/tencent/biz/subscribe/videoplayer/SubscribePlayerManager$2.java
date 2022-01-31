package com.tencent.biz.subscribe.videoplayer;

import adni;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import nar;
import wto;

public class SubscribePlayerManager$2
  implements Runnable
{
  public SubscribePlayerManager$2(wto paramwto) {}
  
  public void run()
  {
    if (nar.a(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    while ((wto.a(this.this$0)) || (wto.a(this.this$0).size() <= 0)) {
      return;
    }
    wto.a(this.this$0, true);
    Object localObject = wto.a(this.this$0).keySet().iterator();
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
      localObject = (adni)wto.a(this.this$0).get(Integer.valueOf(i));
      if (localObject == null) {
        break;
      }
      wto.a(this.this$0, (adni)localObject, ((adni)localObject).b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2
 * JD-Core Version:    0.7.0.1
 */