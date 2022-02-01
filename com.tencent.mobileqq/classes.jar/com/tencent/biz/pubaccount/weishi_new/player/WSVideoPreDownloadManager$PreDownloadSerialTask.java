package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.util.WeakReference;
import usd;
import use;
import uya;

class WSVideoPreDownloadManager$PreDownloadSerialTask
  implements Runnable
{
  private List<use> jdField_a_of_type_JavaUtilList;
  private WeakReference<WSVideoPreDownloadManager> jdField_a_of_type_MqqUtilWeakReference;
  
  WSVideoPreDownloadManager$PreDownloadSerialTask(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, List<use> paramList)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramWSVideoPreDownloadManager);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        use localuse = (use)localIterator.next();
        localStringBuilder1.append(localuse.c).append(" | ");
        localStringBuilder2.append(localuse.b).append(" | ");
      }
      uya.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload listSize:" + this.jdField_a_of_type_JavaUtilList.size() + ", listStr:" + localStringBuilder1);
      uya.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload urlList:" + localStringBuilder2);
    }
  }
  
  private void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    use localuse;
    String str;
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      localuse = (use)this.jdField_a_of_type_JavaUtilList.get(0);
      str = WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager);
      if (TextUtils.isEmpty(str))
      {
        uya.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] curPreDownloadUrl is empty，restart preDownload!");
        WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
        WSVideoPreDownloadManager.b(paramWSVideoPreDownloadManager);
      }
    }
    else
    {
      return;
    }
    if (TextUtils.equals(str, localuse.b))
    {
      uya.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl == PreList[0]");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    uya.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl != PreList[0], stop download! restart preDownload!!");
    WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
    paramWSVideoPreDownloadManager.b();
    WSVideoPreDownloadManager.b(paramWSVideoPreDownloadManager);
  }
  
  private void b(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    int k = 0;
    int j;
    for (int i = 0; i < this.jdField_a_of_type_JavaUtilList.size(); i = j + 1)
    {
      use localuse = (use)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager).contains(localuse.b))
      {
        this.jdField_a_of_type_JavaUtilList.remove(i);
        j = i - 1;
        uya.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] hadPreDownload!! removeFromPreList:" + localuse.b);
      }
    }
    if ((WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager) != null) && (!WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager).a())) {
      for (i = k; i < this.jdField_a_of_type_JavaUtilList.size(); i = j + 1)
      {
        j = i;
        if (!((use)this.jdField_a_of_type_JavaUtilList.get(i)).a)
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
    if ((localWSVideoPreDownloadManager == null) || (WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager) == null) || (WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager) == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    b(localWSVideoPreDownloadManager);
    a();
    a(localWSVideoPreDownloadManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadSerialTask
 * JD-Core Version:    0.7.0.1
 */