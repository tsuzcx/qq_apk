package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class ComponentHeaderTopicRecommend$1
  implements PublicAccountImageDownListener
{
  ComponentHeaderTopicRecommend$1(ComponentHeaderTopicRecommend paramComponentHeaderTopicRecommend) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderTopicRecommend", 2, "topic image view download success");
    }
    ComponentHeaderTopicRecommend.a(this.a, paramCloseableBitmap.a());
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend.1
 * JD-Core Version:    0.7.0.1
 */