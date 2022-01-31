package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import uid;
import uil;
import uir;
import uja;
import ujb;
import ujq;
import ujr;
import urr;
import wsv;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(ujq paramujq, String paramString, int paramInt, ujr paramujr, boolean paramBoolean) {}
  
  public void run()
  {
    String str = uja.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (ujq.a(this.this$0).containsKey(str))
    {
      wsv.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = ujb.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      wsv.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      ujq.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Ujr);
      return;
    }
    wsv.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = ujq.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (uja)((Iterator)localObject1).next();
        ujq.a(this.this$0).a((uja)localObject2);
        Object localObject3 = ((uja)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof ujr)))
        {
          ujq.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (ujr)localObject3);
          wsv.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((uja)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      ujq.a(this.this$0).clear();
    }
    localObject1 = uja.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((uid)urr.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((uja)localObject1).d = ((uil)localObject2).b;
    ((uja)localObject1).jdField_a_of_type_Boolean = ((uil)localObject2).jdField_a_of_type_Boolean;
    ((uja)localObject1).jdField_f_of_type_Int = ((uil)localObject2).c;
    ((uja)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Ujr);
    if (((uja)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((uja)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        wsv.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((uja)localObject1).b, Integer.valueOf(((uja)localObject1).jdField_a_of_type_Int) });
      }
    }
    ujq.a(this.this$0).a((uja)localObject1, this.this$0);
    ujq.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */