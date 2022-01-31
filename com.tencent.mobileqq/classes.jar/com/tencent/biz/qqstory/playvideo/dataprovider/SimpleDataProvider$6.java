package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import twm;
import twn;
import txh;

public class SimpleDataProvider$6
  implements Runnable
{
  public SimpleDataProvider$6(txh paramtxh, twm paramtwm, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = txh.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((twn)localIterator.next()).a(this.jdField_a_of_type_Twm.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.6
 * JD-Core Version:    0.7.0.1
 */