package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import suc;
import sul;
import svb;
import svc;
import veg;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(svb paramsvb) {}
  
  public void run()
  {
    Iterator localIterator = svb.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      sul localsul = (sul)localIterator.next();
      svb.a(this.this$0).a(localsul);
      Object localObject = localsul.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof svc)))
      {
        svb.a(this.this$0, localsul.b, localsul.jdField_a_of_type_Int, (svc)localObject);
        veg.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localsul.jdField_a_of_type_JavaLangString });
      }
    }
    svb.a(this.this$0).clear();
    veg.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */