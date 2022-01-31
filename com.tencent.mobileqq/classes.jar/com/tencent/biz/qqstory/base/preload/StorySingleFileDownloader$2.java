package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import sgs;
import sha;
import shg;
import shp;
import shq;
import sif;
import sig;
import sqg;
import urk;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(sif paramsif, String paramString, int paramInt, sig paramsig, boolean paramBoolean) {}
  
  public void run()
  {
    String str = shp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (sif.a(this.this$0).containsKey(str))
    {
      urk.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = shq.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      urk.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      sif.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Sig);
      return;
    }
    urk.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = sif.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (shp)((Iterator)localObject1).next();
        sif.a(this.this$0).a((shp)localObject2);
        Object localObject3 = ((shp)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof sig)))
        {
          sif.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (sig)localObject3);
          urk.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((shp)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      sif.a(this.this$0).clear();
    }
    localObject1 = shp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((sgs)sqg.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((shp)localObject1).d = ((sha)localObject2).b;
    ((shp)localObject1).jdField_a_of_type_Boolean = ((sha)localObject2).jdField_a_of_type_Boolean;
    ((shp)localObject1).jdField_f_of_type_Int = ((sha)localObject2).c;
    ((shp)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Sig);
    if (((shp)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((shp)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        urk.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((shp)localObject1).b, Integer.valueOf(((shp)localObject1).jdField_a_of_type_Int) });
      }
    }
    sif.a(this.this$0).a((shp)localObject1, this.this$0);
    sif.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */