package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import wbb;
import wbk;
import wca;
import wcb;
import ykq;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(wca paramwca) {}
  
  public void run()
  {
    Iterator localIterator = wca.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      wbk localwbk = (wbk)localIterator.next();
      wca.a(this.this$0).a(localwbk);
      Object localObject = localwbk.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof wcb)))
      {
        wca.a(this.this$0, localwbk.b, localwbk.jdField_a_of_type_Int, (wcb)localObject);
        ykq.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localwbk.jdField_a_of_type_JavaLangString });
      }
    }
    wca.a(this.this$0).clear();
    ykq.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */