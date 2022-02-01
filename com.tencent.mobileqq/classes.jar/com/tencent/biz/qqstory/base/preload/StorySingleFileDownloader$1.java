package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import wkh;
import wkq;
import wlg;
import wlh;
import yuk;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(wlg paramwlg) {}
  
  public void run()
  {
    Iterator localIterator = wlg.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      wkq localwkq = (wkq)localIterator.next();
      wlg.a(this.this$0).a(localwkq);
      Object localObject = localwkq.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof wlh)))
      {
        wlg.a(this.this$0, localwkq.b, localwkq.jdField_a_of_type_Int, (wlh)localObject);
        yuk.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localwkq.jdField_a_of_type_JavaLangString });
      }
    }
    wlg.a(this.this$0).clear();
    yuk.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */