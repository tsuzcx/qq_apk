package com.tencent.mobileqq.Doraemon;

import aabi;
import aabl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class DoraemonAPIManager$2
  implements Runnable
{
  public DoraemonAPIManager$2(aabl paramaabl, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      aabl.a(this.this$0, (String)arrayOfObject[0], (JSONObject)arrayOfObject[1], (aabi)arrayOfObject[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIManager.2
 * JD-Core Version:    0.7.0.1
 */