package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoCompositeManager.OnVideoCompositeListener;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ReadInJoyDeliverVideoActivity$2
  implements ReadInJoyVideoCompositeManager.OnVideoCompositeListener
{
  ReadInJoyDeliverVideoActivity$2(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onError: code - " + paramInt + " msg - " + paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new ReadInJoyDeliverVideoActivity.2.2(this));
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "onSuccess: outputPath - " + paramString);
    ReadInJoyDeliverVideoActivity.b(this.a, paramString);
    ReadInJoyDeliverVideoActivity.a(this.a).post(new ReadInJoyDeliverVideoActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.2
 * JD-Core Version:    0.7.0.1
 */