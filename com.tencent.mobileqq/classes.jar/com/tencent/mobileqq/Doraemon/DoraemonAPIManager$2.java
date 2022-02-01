package com.tencent.mobileqq.Doraemon;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class DoraemonAPIManager$2
  implements Runnable
{
  DoraemonAPIManager$2(DoraemonAPIManager paramDoraemonAPIManager, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      DoraemonAPIManager.a(this.this$0, (String)arrayOfObject[0], (JSONObject)arrayOfObject[1], (APICallback)arrayOfObject[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIManager.2
 * JD-Core Version:    0.7.0.1
 */