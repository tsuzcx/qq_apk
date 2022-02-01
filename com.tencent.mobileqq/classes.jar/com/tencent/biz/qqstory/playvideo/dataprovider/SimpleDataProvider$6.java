package com.tencent.biz.qqstory.playvideo.dataprovider;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class SimpleDataProvider$6
  implements Runnable
{
  SimpleDataProvider$6(SimpleDataProvider paramSimpleDataProvider, IDataProvider.GroupInfo paramGroupInfo, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    Iterator localIterator = SimpleDataProvider.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IDataProvider.ICallBack)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupInfo.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.6
 * JD-Core Version:    0.7.0.1
 */