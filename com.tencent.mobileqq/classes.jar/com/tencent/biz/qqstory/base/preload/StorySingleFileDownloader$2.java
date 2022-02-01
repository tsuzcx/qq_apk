package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class StorySingleFileDownloader$2
  implements Runnable
{
  StorySingleFileDownloader$2(StorySingleFileDownloader paramStorySingleFileDownloader, String paramString, int paramInt, StorySingleFileDownloader.FileDownloadListener paramFileDownloadListener, boolean paramBoolean) {}
  
  public void run()
  {
    String str = DownloadTask.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (StorySingleFileDownloader.a(this.this$0).containsKey(str))
    {
      SLog.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s is running , wait", new Object[] { str });
      return;
    }
    Object localObject1 = FileCacheUtils.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false, false);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      SLog.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s before , no need to download again", new Object[] { str });
      StorySingleFileDownloader.b(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader$FileDownloadListener);
      return;
    }
    SLog.d("Q.qqstory.download:StorySingleFileDownloader", "download task :%s start now! cancelOtherTask :%s", new Object[] { str, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = StorySingleFileDownloader.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadTask)((Iterator)localObject1).next();
        StorySingleFileDownloader.a(this.this$0).a((DownloadTask)localObject2);
        Object localObject3 = ((DownloadTask)localObject2).jdField_a_of_type_JavaUtilMap.get("DOWNLOAD_TASK_KEY_LISTENER");
        if ((localObject3 != null) && ((localObject3 instanceof StorySingleFileDownloader.FileDownloadListener)))
        {
          StorySingleFileDownloader.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (StorySingleFileDownloader.FileDownloadListener)localObject3);
          SLog.d("Q.qqstory.download:StorySingleFileDownloader", "task :%s cancel!   because task :%s start", new Object[] { ((DownloadTask)localObject2).jdField_a_of_type_JavaLangString, str });
        }
      }
      StorySingleFileDownloader.a(this.this$0).clear();
    }
    localObject1 = DownloadTask.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject2 = ((DownloadUrlManager)SuperManager.a(28)).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    ((DownloadTask)localObject1).d = ((DownloadUrlManager.DownloadUrlQueryResult)localObject2).b;
    ((DownloadTask)localObject1).jdField_a_of_type_Boolean = ((DownloadUrlManager.DownloadUrlQueryResult)localObject2).jdField_a_of_type_Boolean;
    ((DownloadTask)localObject1).jdField_f_of_type_Int = ((DownloadUrlManager.DownloadUrlQueryResult)localObject2).c;
    ((DownloadTask)localObject1).jdField_a_of_type_JavaUtilMap.put("DOWNLOAD_TASK_KEY_LISTENER", this.jdField_a_of_type_ComTencentBizQqstoryBasePreloadStorySingleFileDownloader$FileDownloadListener);
    if (((DownloadTask)localObject1).jdField_a_of_type_Boolean)
    {
      localObject2 = new File(((DownloadTask)localObject1).jdField_f_of_type_JavaLangString);
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        SLog.d("Q.qqstory.download:StorySingleFileDownloader", "%s - %d found orphan tmp , delete it", new Object[] { ((DownloadTask)localObject1).b, Integer.valueOf(((DownloadTask)localObject1).jdField_a_of_type_Int) });
      }
    }
    StorySingleFileDownloader.a(this.this$0).a((DownloadTask)localObject1, this.this$0);
    StorySingleFileDownloader.a(this.this$0).put(str, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader.2
 * JD-Core Version:    0.7.0.1
 */