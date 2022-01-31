package com.tencent.biz.publicAccountImageCollection;

import java.util.Iterator;
import java.util.List;

class PublicAccountImageCollectionPreloadManager$PreloadProtoThread
  implements Runnable
{
  PublicAccountImageCollectionPreloadManager$PreloadProtoThread(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager) {}
  
  public void run()
  {
    ??? = PublicAccountImageCollectionPreloadManager.a(this.this$0).iterator();
    while (((Iterator)???).hasNext())
    {
      String str = (String)((Iterator)???).next();
      PublicAccountImageCollectionPreloadManager.a(this.this$0, str);
    }
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      PublicAccountImageCollectionPreloadManager.a(this.this$0).clear();
      if (PublicAccountImageCollectionPreloadManager.b(this.this$0).size() > 0)
      {
        PublicAccountImageCollectionPreloadManager.a(this.this$0);
        return;
      }
      this.this$0.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager.PreloadProtoThread
 * JD-Core Version:    0.7.0.1
 */