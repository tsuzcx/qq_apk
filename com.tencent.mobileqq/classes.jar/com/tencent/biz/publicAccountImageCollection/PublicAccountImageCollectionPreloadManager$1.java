package com.tencent.biz.publicAccountImageCollection;

import com.tencent.qphone.base.util.QLog;
import npu;
import tpr;

class PublicAccountImageCollectionPreloadManager$1
  implements Runnable
{
  PublicAccountImageCollectionPreloadManager$1(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, tpr paramtpr) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "notifyUIToRefresh articleId=" + this.a.a);
    }
    if (PublicAccountImageCollectionPreloadManager.a(this.this$0) != null) {
      PublicAccountImageCollectionPreloadManager.a(this.this$0).a(this.a);
    }
    PublicAccountImageCollectionPreloadManager.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */