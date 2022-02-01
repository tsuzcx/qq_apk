package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import woe;
import wof;
import woz;

public class SimpleDataProvider$6
  implements Runnable
{
  public SimpleDataProvider$6(woz paramwoz, woe paramwoe, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = woz.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((wof)localIterator.next()).a(this.jdField_a_of_type_Woe.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.6
 * JD-Core Version:    0.7.0.1
 */