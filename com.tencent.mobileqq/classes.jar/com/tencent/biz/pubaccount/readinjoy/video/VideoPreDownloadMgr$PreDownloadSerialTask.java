package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import quh;
import qui;

class VideoPreDownloadMgr$PreDownloadSerialTask
  implements Runnable
{
  private List<qui> a;
  
  public VideoPreDownloadMgr$PreDownloadSerialTask(List<qui> paramList)
  {
    Object localObject;
    this.a = localObject;
  }
  
  public void run()
  {
    if ((VideoPreDownloadMgr.a(this.this$0) == null) || (this.a == null) || (this.a.size() == 0) || (VideoPreDownloadMgr.a(this.this$0) == null)) {}
    do
    {
      return;
      int j;
      for (int i = 0; i < this.a.size(); i = j + 1)
      {
        localObject1 = (qui)this.a.get(i);
        j = i;
        if (VideoPreDownloadMgr.a(this.this$0).contains(((qui)localObject1).jdField_a_of_type_JavaLangString))
        {
          this.a.remove(i);
          j = i - 1;
        }
      }
      if (!VideoPreDownloadMgr.a(this.this$0).a()) {
        for (i = 0; i < this.a.size(); i = j + 1)
        {
          j = i;
          if (!((qui)this.a.get(i)).jdField_a_of_type_Boolean)
          {
            this.a.remove(i);
            j = i - 1;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = this.a.iterator();
        qui localqui;
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + localqui.jdField_a_of_type_JavaLangString + " | ") {
          localqui = (qui)((Iterator)localObject2).next();
        }
        QLog.i(VideoPreDownloadMgr.a(), 2, "当前预下载列表: " + (String)localObject1);
      }
    } while (this.a.size() == 0);
    Object localObject1 = (qui)this.a.get(0);
    Object localObject2 = VideoPreDownloadMgr.a(this.this$0);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(VideoPreDownloadMgr.a(), 2, "当前没有做预下载，启动预下载");
      }
      VideoPreDownloadMgr.a(this.this$0, this.a);
      VideoPreDownloadMgr.b(this.this$0);
      return;
    }
    if (((String)localObject2).equals(((qui)localObject1).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(VideoPreDownloadMgr.a(), 2, "当前预下载与list第一项一致");
      }
      this.a.remove(0);
      VideoPreDownloadMgr.a(this.this$0, this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(VideoPreDownloadMgr.a(), 2, "当前预下载与list第一项不一致，暂停预下载任务，重新启动预下载");
    }
    VideoPreDownloadMgr.a(this.this$0, this.a);
    this.this$0.e();
    VideoPreDownloadMgr.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadSerialTask
 * JD-Core Version:    0.7.0.1
 */