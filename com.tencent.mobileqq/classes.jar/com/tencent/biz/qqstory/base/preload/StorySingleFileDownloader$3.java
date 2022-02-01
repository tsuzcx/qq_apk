package com.tencent.biz.qqstory.base.preload;

import java.util.Map;
import wbk;
import wca;

public class StorySingleFileDownloader$3
  implements Runnable
{
  public StorySingleFileDownloader$3(wca paramwca, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = wbk.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    localObject = (wbk)wca.a(this.this$0).get(localObject);
    if (localObject != null) {
      ((wbk)localObject).a.remove("DOWNLOAD_TASK_KEY_LISTENER");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */