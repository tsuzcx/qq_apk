package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import sto;
import stw;
import suc;
import sul;
import sum;
import svb;
import svc;
import tdc;
import veg;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(svb paramsvb, String paramString, int paramInt, svc paramsvc, boolean paramBoolean) {}
  
  public void run()
  {
    String str = sul.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (svb.a(this.this$0).containsKey(str))
    {
      veg.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = sum.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      veg.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      svb.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Svc);
      return;
    }
    veg.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = svb.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (sul)((Iterator)localObject1).next();
        svb.a(this.this$0).a((sul)localObject2);
        Object localObject3 = ((sul)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof svc)))
        {
          svb.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (svc)localObject3);
          veg.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((sul)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      svb.a(this.this$0).clear();
    }
    localObject1 = sul.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((sto)tdc.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((sul)localObject1).d = ((stw)localObject2).b;
    ((sul)localObject1).jdField_a_of_type_Boolean = ((stw)localObject2).jdField_a_of_type_Boolean;
    ((sul)localObject1).jdField_f_of_type_Int = ((stw)localObject2).c;
    ((sul)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Svc);
    if (((sul)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((sul)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        veg.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((sul)localObject1).b, Integer.valueOf(((sul)localObject1).jdField_a_of_type_Int) });
      }
    }
    svb.a(this.this$0).a((sul)localObject1, this.this$0);
    svb.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */