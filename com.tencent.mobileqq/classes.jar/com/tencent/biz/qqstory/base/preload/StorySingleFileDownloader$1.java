package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import wgm;
import wgv;
import whl;
import whm;
import yqp;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(whl paramwhl) {}
  
  public void run()
  {
    Iterator localIterator = whl.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      wgv localwgv = (wgv)localIterator.next();
      whl.a(this.this$0).a(localwgv);
      Object localObject = localwgv.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof whm)))
      {
        whl.a(this.this$0, localwgv.b, localwgv.jdField_a_of_type_Int, (whm)localObject);
        yqp.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localwgv.jdField_a_of_type_JavaLangString });
      }
    }
    whl.a(this.this$0).clear();
    yqp.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */