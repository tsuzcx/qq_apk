package com.tencent.biz.qqstory.base.preload;

import java.util.Map;
import vmp;
import vnf;

public class StorySingleFileDownloader$3
  implements Runnable
{
  public StorySingleFileDownloader$3(vnf paramvnf, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = vmp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    localObject = (vmp)vnf.a(this.this$0).get(localObject);
    if (localObject != null) {
      ((vmp)localObject).a.remove("DOWNLOAD_TASK_KEY_LISTENER");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.3
 * JD-Core Version:    0.7.0.1
 */