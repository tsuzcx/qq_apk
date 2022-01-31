package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import shg;
import shp;
import sif;
import sig;
import urk;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(sif paramsif) {}
  
  public void run()
  {
    Iterator localIterator = sif.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      shp localshp = (shp)localIterator.next();
      sif.a(this.this$0).a(localshp);
      Object localObject = localshp.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof sig)))
      {
        sif.a(this.this$0, localshp.b, localshp.jdField_a_of_type_Int, (sig)localObject);
        urk.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localshp.jdField_a_of_type_JavaLangString });
      }
    }
    sif.a(this.this$0).clear();
    urk.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */