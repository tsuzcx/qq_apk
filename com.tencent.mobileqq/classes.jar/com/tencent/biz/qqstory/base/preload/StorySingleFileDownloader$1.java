package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import vmg;
import vmp;
import vnf;
import vng;
import xvv;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(vnf paramvnf) {}
  
  public void run()
  {
    Iterator localIterator = vnf.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      vmp localvmp = (vmp)localIterator.next();
      vnf.a(this.this$0).a(localvmp);
      Object localObject = localvmp.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof vng)))
      {
        vnf.a(this.this$0, localvmp.b, localvmp.jdField_a_of_type_Int, (vng)localObject);
        xvv.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localvmp.jdField_a_of_type_JavaLangString });
      }
    }
    vnf.a(this.this$0).clear();
    xvv.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */