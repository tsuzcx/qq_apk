package com.tencent.biz.qqstory.base.preload;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import stz;
import sui;
import suy;
import suz;
import ved;

public class StorySingleFileDownloader$1
  implements Runnable
{
  public StorySingleFileDownloader$1(suy paramsuy) {}
  
  public void run()
  {
    Iterator localIterator = suy.a(this.this$0).values().iterator();
    while (localIterator.hasNext())
    {
      sui localsui = (sui)localIterator.next();
      suy.a(this.this$0).a(localsui);
      Object localObject = localsui.jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof suz)))
      {
        suy.a(this.this$0, localsui.b, localsui.jdField_a_of_type_Int, (suz)localObject);
        ved.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!  because stop", new Object[] { localsui.jdField_a_of_type_JavaLangString });
      }
    }
    suy.a(this.this$0).clear();
    ved.d("Q.qqstory.download:StorySingleFileDownloader", "stop!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */