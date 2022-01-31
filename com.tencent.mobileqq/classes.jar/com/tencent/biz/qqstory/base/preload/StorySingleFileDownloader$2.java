package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import umm;
import umu;
import una;
import unj;
import unk;
import unz;
import uoa;
import uwa;
import wxe;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(unz paramunz, String paramString, int paramInt, uoa paramuoa, boolean paramBoolean) {}
  
  public void run()
  {
    String str = unj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (unz.a(this.this$0).containsKey(str))
    {
      wxe.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = unk.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      wxe.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      unz.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Uoa);
      return;
    }
    wxe.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = unz.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (unj)((Iterator)localObject1).next();
        unz.a(this.this$0).a((unj)localObject2);
        Object localObject3 = ((unj)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof uoa)))
        {
          unz.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (uoa)localObject3);
          wxe.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((unj)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      unz.a(this.this$0).clear();
    }
    localObject1 = unj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((umm)uwa.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((unj)localObject1).d = ((umu)localObject2).b;
    ((unj)localObject1).jdField_a_of_type_Boolean = ((umu)localObject2).jdField_a_of_type_Boolean;
    ((unj)localObject1).jdField_f_of_type_Int = ((umu)localObject2).c;
    ((unj)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Uoa);
    if (((unj)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((unj)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        wxe.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((unj)localObject1).b, Integer.valueOf(((unj)localObject1).jdField_a_of_type_Int) });
      }
    }
    unz.a(this.this$0).a((unj)localObject1, this.this$0);
    unz.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */