package com.tencent.biz.qqstory.model;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import uwi;

public class TroopNickNameManager$4
  implements Runnable
{
  public TroopNickNameManager$4(uwi paramuwi) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.this$0.a.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (l - ((Long)((Map.Entry)localIterator.next()).getValue()).longValue() < 30000L) {
        break label115;
      }
      localIterator.remove();
      i += 1;
    }
    label115:
    for (;;)
    {
      break;
      if ((i > 0) && (QLog.isColorLevel())) {
        QLog.d("TroopNickNameManager", 2, "timeout count=" + i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.4
 * JD-Core Version:    0.7.0.1
 */