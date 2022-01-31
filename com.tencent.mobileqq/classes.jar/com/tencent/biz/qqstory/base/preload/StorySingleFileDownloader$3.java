package com.tencent.biz.qqstory.base.preload;

import java.util.Map;
import sui;
import suy;

public class StorySingleFileDownloader$3
  implements Runnable
{
  public StorySingleFileDownloader$3(suy paramsuy, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = sui.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    localObject = (sui)suy.a(this.this$0).get(localObject);
    if (localObject != null) {
      ((sui)localObject).a.remove("DOWNLOAD_TASK_KEY_LISTENER");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */