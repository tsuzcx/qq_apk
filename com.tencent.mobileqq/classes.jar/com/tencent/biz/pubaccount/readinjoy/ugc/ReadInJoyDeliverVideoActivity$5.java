package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageDownListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class ReadInJoyDeliverVideoActivity$5
  implements PublicAccountImageDownListener
{
  ReadInJoyDeliverVideoActivity$5(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, CloseableBitmap paramCloseableBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover download success");
    }
    ReadInJoyDeliverVideoActivity.c(this.a, ShortVideoPreviewActivity.a(paramCloseableBitmap.a()));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment local cover is " + ReadInJoyDeliverVideoActivity.a(this.a));
    }
    this.a.setRightViewTextDisable(1);
  }
  
  public void a(URL paramURL, Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.5
 * JD-Core Version:    0.7.0.1
 */