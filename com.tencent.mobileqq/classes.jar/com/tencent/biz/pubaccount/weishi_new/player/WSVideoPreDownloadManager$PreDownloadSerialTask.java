package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import thw;
import thx;
import tlo;

class WSVideoPreDownloadManager$PreDownloadSerialTask
  implements Runnable
{
  private List<thx> a;
  
  WSVideoPreDownloadManager$PreDownloadSerialTask(List<thx> paramList)
  {
    Object localObject;
    this.a = localObject;
  }
  
  public void run()
  {
    if ((WSVideoPreDownloadManager.a(this.this$0) == null) || (this.a == null) || (this.a.size() == 0) || (WSVideoPreDownloadManager.a(this.this$0) == null)) {}
    do
    {
      return;
      int j;
      for (int i = 0; i < this.a.size(); i = j + 1)
      {
        localObject1 = (thx)this.a.get(i);
        j = i;
        if (WSVideoPreDownloadManager.a(this.this$0).contains(((thx)localObject1).b))
        {
          this.a.remove(i);
          j = i - 1;
        }
      }
      if (!WSVideoPreDownloadManager.a(this.this$0).a()) {
        for (i = 0; i < this.a.size(); i = j + 1)
        {
          j = i;
          if (!((thx)this.a.get(i)).a)
          {
            this.a.remove(i);
            j = i - 1;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = this.a.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          thx localthx = (thx)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("\n| ").append(localthx.b);
        }
        tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "当前预下载列表 mPreDownloadList: " + this.a.size() + ", listStr:" + localObject1);
      }
    } while (this.a.size() == 0);
    Object localObject1 = (thx)this.a.get(0);
    Object localObject2 = WSVideoPreDownloadManager.a(this.this$0);
    tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "curPreDownloadUrl:" + (String)localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "当前没有做预下载，启动预下载");
      }
      WSVideoPreDownloadManager.a(this.this$0, this.a);
      WSVideoPreDownloadManager.b(this.this$0);
      return;
    }
    if (TextUtils.equals((CharSequence)localObject2, ((thx)localObject1).b))
    {
      if (QLog.isColorLevel()) {
        tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "当前预下载与list第一项一致");
      }
      this.a.remove(0);
      WSVideoPreDownloadManager.a(this.this$0, this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      tlo.a("WS_VIDEO_WSVideoPreDownloadManager", 2, "当前预下载与list第一项不一致，暂停预下载任务，重新启动预下载");
    }
    WSVideoPreDownloadManager.a(this.this$0, this.a);
    this.this$0.b();
    WSVideoPreDownloadManager.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadSerialTask
 * JD-Core Version:    0.7.0.1
 */