package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import una;
import unj;
import unz;
import uoa;
import wxe;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(unz paramunz) {}
  
  public void run()
  {
    Iterator localIterator = unz.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      unj localunj = (unj)localIterator.next();
      unz.a(this.this$0).a(localunj);
      Object localObject = localunj.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof uoa)))
      {
        unz.a(this.this$0, localunj.b, localunj.jdField_a_of_type_Int, (uoa)localObject);
        wxe.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localunj.jdField_a_of_type_JavaLangString });
      }
    }
    unz.a(this.this$0).clear();
    wxe.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */