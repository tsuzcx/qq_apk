package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import wan;
import wav;
import wbb;
import wbk;
import wbl;
import wca;
import wcb;
import wjs;
import ykq;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(wca paramwca, String paramString, int paramInt, wcb paramwcb, boolean paramBoolean) {}
  
  public void run()
  {
    String str = wbk.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (wca.a(this.this$0).containsKey(str))
    {
      ykq.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = wbl.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      ykq.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      wca.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Wcb);
      return;
    }
    ykq.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = wca.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (wbk)((Iterator)localObject1).next();
        wca.a(this.this$0).a((wbk)localObject2);
        Object localObject3 = ((wbk)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof wcb)))
        {
          wca.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (wcb)localObject3);
          ykq.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((wbk)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      wca.a(this.this$0).clear();
    }
    localObject1 = wbk.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((wan)wjs.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((wbk)localObject1).d = ((wav)localObject2).b;
    ((wbk)localObject1).jdField_a_of_type_Boolean = ((wav)localObject2).jdField_a_of_type_Boolean;
    ((wbk)localObject1).jdField_f_of_type_Int = ((wav)localObject2).c;
    ((wbk)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Wcb);
    if (((wbk)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((wbk)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        ykq.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((wbk)localObject1).b, Integer.valueOf(((wbk)localObject1).jdField_a_of_type_Int) });
      }
    }
    wca.a(this.this$0).a((wbk)localObject1, this.this$0);
    wca.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */