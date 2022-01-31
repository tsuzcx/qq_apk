package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import stl;
import stt;
import stz;
import sui;
import suj;
import suy;
import suz;
import tcz;
import ved;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(suy paramsuy, String paramString, int paramInt, suz paramsuz, boolean paramBoolean) {}
  
  public void run()
  {
    String str = sui.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (suy.a(this.this$0).containsKey(str))
    {
      ved.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = suj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      ved.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      suy.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Suz);
      return;
    }
    ved.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = suy.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (sui)((Iterator)localObject1).next();
        suy.a(this.this$0).a((sui)localObject2);
        Object localObject3 = ((sui)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof suz)))
        {
          suy.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (suz)localObject3);
          ved.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((sui)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      suy.a(this.this$0).clear();
    }
    localObject1 = sui.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((stl)tcz.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((sui)localObject1).d = ((stt)localObject2).b;
    ((sui)localObject1).jdField_a_of_type_Boolean = ((stt)localObject2).jdField_a_of_type_Boolean;
    ((sui)localObject1).jdField_f_of_type_Int = ((stt)localObject2).c;
    ((sui)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Suz);
    if (((sui)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((sui)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        ved.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((sui)localObject1).b, Integer.valueOf(((sui)localObject1).jdField_a_of_type_Int) });
      }
    }
    suy.a(this.this$0).a((sui)localObject1, this.this$0);
    suy.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */