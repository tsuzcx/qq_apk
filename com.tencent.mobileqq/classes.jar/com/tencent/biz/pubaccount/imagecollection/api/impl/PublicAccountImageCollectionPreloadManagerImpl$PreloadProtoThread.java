package com.tencent.biz.pubaccount.imagecollection.api.impl;

import java.util.Iterator;
import java.util.List;

class PublicAccountImageCollectionPreloadManagerImpl$PreloadProtoThread
  implements Runnable
{
  PublicAccountImageCollectionPreloadManagerImpl$PreloadProtoThread(PublicAccountImageCollectionPreloadManagerImpl paramPublicAccountImageCollectionPreloadManagerImpl) {}
  
  public void run()
  {
    ??? = PublicAccountImageCollectionPreloadManagerImpl.access$000(this.this$0).iterator();
    while (((Iterator)???).hasNext())
    {
      String str = (String)((Iterator)???).next();
      PublicAccountImageCollectionPreloadManagerImpl.access$100(this.this$0, str);
    }
    synchronized (this.this$0.lock)
    {
      PublicAccountImageCollectionPreloadManagerImpl.access$000(this.this$0).clear();
      if (PublicAccountImageCollectionPreloadManagerImpl.access$200(this.this$0).size() > 0) {
        PublicAccountImageCollectionPreloadManagerImpl.access$300(this.this$0);
      } else {
        this.this$0.isProtoDoingWork = false;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionPreloadManagerImpl.PreloadProtoThread
 * JD-Core Version:    0.7.0.1
 */