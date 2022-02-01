package com.tencent.biz.pubaccount.weishi_new.player;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.util.WeakReference;
import vgo;
import vgp;
import vmp;

class WSVideoPreDownloadManager$PreDownloadSerialTask
  implements Runnable
{
  private List<vgp> jdField_a_of_type_JavaUtilList;
  private WeakReference<WSVideoPreDownloadManager> jdField_a_of_type_MqqUtilWeakReference;
  
  WSVideoPreDownloadManager$PreDownloadSerialTask(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, List<vgp> paramList)
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
        vgp localvgp = (vgp)localIterator.next();
        localStringBuilder1.append(localvgp.c).append(" | ");
        localStringBuilder2.append(localvgp.b).append(" | ");
      }
      vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload listSize:" + this.jdField_a_of_type_JavaUtilList.size() + ", listStr:" + localStringBuilder1);
      vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload urlList:" + localStringBuilder2);
    }
  }
  
  private void a(WSVideoPreDownloadManager paramWSVideoPreDownloadManager)
  {
    vgp localvgp;
    String str;
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      localvgp = (vgp)this.jdField_a_of_type_JavaUtilList.get(0);
      str = WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager);
      if (TextUtils.isEmpty(str))
      {
        vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] curPreDownloadUrl is empty，restart preDownload!");
        WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
        WSVideoPreDownloadManager.b(paramWSVideoPreDownloadManager);
      }
    }
    else
    {
      return;
    }
    if (TextUtils.equals(str, localvgp.b))
    {
      vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl == PreList[0]");
      this.jdField_a_of_type_JavaUtilList.remove(0);
      WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl != PreList[0], stop download! restart preDownload!!");
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
      vgp localvgp = (vgp)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager).contains(localvgp.b))
      {
        this.jdField_a_of_type_JavaUtilList.remove(i);
        j = i - 1;
        vmp.e("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] hadPreDownload!! removeFromPreList:" + localvgp.b);
      }
    }
    if ((WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager) != null) && (!WSVideoPreDownloadManager.a(paramWSVideoPreDownloadManager).a())) {
      for (i = k; i < this.jdField_a_of_type_JavaUtilList.size(); i = j + 1)
      {
        j = i;
        if (!((vgp)this.jdField_a_of_type_JavaUtilList.get(i)).a)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadSerialTask
 * JD-Core Version:    0.7.0.1
 */