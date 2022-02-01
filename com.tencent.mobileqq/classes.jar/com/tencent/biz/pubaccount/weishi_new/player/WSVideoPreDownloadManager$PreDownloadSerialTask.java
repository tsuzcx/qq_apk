package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.util.WeakReference;

class WSVideoPreDownloadManager$PreDownloadSerialTask
  implements Runnable
{
  private List<WSVideoPreDownloadManager.VideoPreDownloadParam> jdField_a_of_type_JavaUtilList;
  private WeakReference<WSVideoPreDownloadManager> jdField_a_of_type_MqqUtilWeakReference;
  
  WSVideoPreDownloadManager$PreDownloadSerialTask(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, List<WSVideoPreDownloadManager.VideoPreDownloadParam> paramList)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramWSVideoPreDownloadManager);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        WSVideoPreDownloadManager.VideoPreDownloadParam localVideoPreDownloadParam = (WSVideoPreDownloadManager.VideoPreDownloadParam)((Iterator)localObject).next();
        localStringBuilder2.append(localVideoPreDownloadParam.c);
        localStringBuilder2.append(" | ");
        localStringBuilder1.append(localVideoPreDownloadParam.b);
        localStringBuilder1.append(" | ");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload listSize:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      ((StringBuilder)localObject).append(", listStr:");
      ((StringBuilder)localObject).append(localStringBuilder2);
      WSLog.e("WS_VIDEO_PRE_DL", ((StringBuilder)localObject).toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload urlList:");
      localStringBuilder2.append(localStringBuilder1);
      WSLog.e("WS_VIDEO_PRE_DL", localStringBuilder2.toString());
    }
  }
  
  private void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      WSVideoPreDownloadManager.VideoPreDownloadParam localVideoPreDownloadParam = (WSVideoPreDownloadManager.VideoPreDownloadParam)this.jdField_a_of_type_JavaUtilList.get(0);
      String str = WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager);
      if (TextUtils.isEmpty(str))
      {
        WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] curPreDownloadUrl is empty，restart preDownload!");
        WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
        WSVideoPreDownloadManager.b(paramWSVideoPreDownloadManager);
        return;
      }
      if (TextUtils.equals(str, localVideoPreDownloadParam.b))
      {
        WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl == PreList[0]");
        this.jdField_a_of_type_JavaUtilList.remove(0);
        WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      WSLog.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl != PreList[0], stop download! restart preDownload!!");
      WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
      paramWSVideoPreDownloadManager.b();
      WSVideoPreDownloadManager.b(paramWSVideoPreDownloadManager);
    }
  }
  
  private void b(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    int k = 0;
    int j;
    for (int i = 0; i < this.jdField_a_of_type_JavaUtilList.size(); i = j + 1)
    {
      WSVideoPreDownloadManager.VideoPreDownloadParam localVideoPreDownloadParam = (WSVideoPreDownloadManager.VideoPreDownloadParam)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager).contains(localVideoPreDownloadParam.b))
      {
        this.jdField_a_of_type_JavaUtilList.remove(i);
        j = i - 1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] hadPreDownload!! removeFromPreList:");
        localStringBuilder.append(localVideoPreDownloadParam.b);
        WSLog.e("WS_VIDEO_PRE_DL", localStringBuilder.toString());
      }
    }
    if ((WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager) != null) && (!WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager).a())) {
      for (i = k; i < this.jdField_a_of_type_JavaUtilList.size(); i = j + 1)
      {
        j = i;
        if (!((WSVideoPreDownloadManager.VideoPreDownloadParam)this.jdField_a_of_type_JavaUtilList.get(i)).a)
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          j = i - 1;
        }
      }
    }
  }
  
  public void run()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = (WSVideoPreDownloadManager)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localWSVideoPreDownloadManager != null) && (WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager) != null) && (WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager) != null))
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null)
      {
        if (localList.size() == 0) {
          return;
        }
        b(localWSVideoPreDownloadManager);
        a();
        a(localWSVideoPreDownloadManager);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadSerialTask
 * JD-Core Version:    0.7.0.1
 */