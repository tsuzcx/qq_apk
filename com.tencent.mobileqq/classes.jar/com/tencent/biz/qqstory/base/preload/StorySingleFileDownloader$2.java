package com.tencent.biz.qqstory.base.preload;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import wjt;
import wkb;
import wkh;
import wkq;
import wkr;
import wlg;
import wlh;
import wth;
import yuk;

public class StorySingleFileDownloader$2
  implements Runnable
{
  public StorySingleFileDownloader$2(wlg paramwlg, String paramString, int paramInt, wlh paramwlh, boolean paramBoolean) {}
  
  public void run()
  {
    String str = wkq.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (wlg.a(this.this$0).containsKey(str))
    {
      yuk.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = wkr.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      yuk.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      wlg.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_Wlh);
      return;
    }
    yuk.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = wlg.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (wkq)((Iterator)localObject1).next();
        wlg.a(this.this$0).a((wkq)localObject2);
        Object localObject3 = ((wkq)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof wlh)))
        {
          wlg.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (wlh)localObject3);
          yuk.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((wkq)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      wlg.a(this.this$0).clear();
    }
    localObject1 = wkq.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((wjt)wth.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((wkq)localObject1).d = ((wkb)localObject2).b;
    ((wkq)localObject1).jdField_a_of_type_Boolean = ((wkb)localObject2).jdField_a_of_type_Boolean;
    ((wkq)localObject1).jdField_f_of_type_Int = ((wkb)localObject2).c;
    ((wkq)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_Wlh);
    if (((wkq)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((wkq)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        yuk.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((wkq)localObject1).b, Integer.valueOf(((wkq)localObject1).jdField_a_of_type_Int) });
      }
    }
    wlg.a(this.this$0).a((wkq)localObject1, this.this$0);
    wlg.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */