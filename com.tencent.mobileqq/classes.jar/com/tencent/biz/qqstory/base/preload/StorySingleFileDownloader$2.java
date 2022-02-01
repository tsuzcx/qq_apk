package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import wfy;
import wgg;
import wgm;
import wgv;
import wgw;
import whl;
import whm;
import wpm;
import yqp;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(whl paramwhl, String paramString, int paramInt, whm paramwhm, boolean paramBoolean) {}
  
  public void run()
  {
    String str = wgv.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (whl.a(this.this$0).containsKey(str))
    {
      yqp.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = wgw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      yqp.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      whl.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Whm);
      return;
    }
    yqp.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = whl.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (wgv)((Iterator)localObject1).next();
        whl.a(this.this$0).a((wgv)localObject2);
        Object localObject3 = ((wgv)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof whm)))
        {
          whl.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (whm)localObject3);
          yqp.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((wgv)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      whl.a(this.this$0).clear();
    }
    localObject1 = wgv.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((wfy)wpm.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((wgv)localObject1).d = ((wgg)localObject2).b;
    ((wgv)localObject1).jdField_a_of_type_Boolean = ((wgg)localObject2).jdField_a_of_type_Boolean;
    ((wgv)localObject1).jdField_f_of_type_Int = ((wgg)localObject2).c;
    ((wgv)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Whm);
    if (((wgv)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((wgv)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        yqp.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((wgv)localObject1).b, Integer.valueOf(((wgv)localObject1).jdField_a_of_type_Int) });
      }
    }
    whl.a(this.this$0).a((wgv)localObject1, this.this$0);
    whl.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */