package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import vls;
import vma;
import vmg;
import vmp;
import vmq;
import vnf;
import vng;
import vux;
import xvv;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(vnf paramvnf, String paramString, int paramInt, vng paramvng, boolean paramBoolean) {}
  
  public void run()
  {
    String str = vmp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (vnf.a(this.this$0).containsKey(str))
    {
      xvv.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = vmq.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      xvv.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      vnf.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Vng);
      return;
    }
    xvv.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = vnf.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (vmp)((Iterator)localObject1).next();
        vnf.a(this.this$0).a((vmp)localObject2);
        Object localObject3 = ((vmp)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof vng)))
        {
          vnf.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (vng)localObject3);
          xvv.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((vmp)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      vnf.a(this.this$0).clear();
    }
    localObject1 = vmp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((vls)vux.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((vmp)localObject1).d = ((vma)localObject2).b;
    ((vmp)localObject1).jdField_a_of_type_Boolean = ((vma)localObject2).jdField_a_of_type_Boolean;
    ((vmp)localObject1).jdField_f_of_type_Int = ((vma)localObject2).c;
    ((vmp)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Vng);
    if (((vmp)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((vmp)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        xvv.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((vmp)localObject1).b, Integer.valueOf(((vmp)localObject1).jdField_a_of_type_Int) });
      }
    }
    vnf.a(this.this$0).a((vmp)localObject1, this.this$0);
    vnf.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */