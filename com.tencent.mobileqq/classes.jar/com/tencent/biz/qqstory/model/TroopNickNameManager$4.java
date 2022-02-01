package com.tencent.biz.qqstory.model;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TroopNickNameManager$4
  implements Runnable
{
  TroopNickNameManager$4(TroopNickNameManager paramTroopNickNameManager) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.this$0.a.entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      if (l - ((Long)((Map.Entry)((Iterator)localObject).next()).getValue()).longValue() >= 30000L)
      {
        ((Iterator)localObject).remove();
        i += 1;
      }
    }
    if ((i > 0) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("timeout count=");
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopNickNameManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.4
 * JD-Core Version:    0.7.0.1
 */