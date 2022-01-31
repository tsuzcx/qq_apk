package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import uir;
import uja;
import ujq;
import ujr;
import wsv;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(ujq paramujq) {}
  
  public void run()
  {
    Iterator localIterator = ujq.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      uja localuja = (uja)localIterator.next();
      ujq.a(this.this$0).a(localuja);
      Object localObject = localuja.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof ujr)))
      {
        ujq.a(this.this$0, localuja.b, localuja.jdField_a_of_type_Int, (ujr)localObject);
        wsv.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localuja.jdField_a_of_type_JavaLangString });
      }
    }
    ujq.a(this.this$0).clear();
    wsv.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */