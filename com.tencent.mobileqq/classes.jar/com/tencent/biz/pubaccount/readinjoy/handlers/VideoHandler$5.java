package com.tencent.biz.pubaccount.readinjoy.handlers;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import qdc;
import spg;
import spk;

public class VideoHandler$5
  implements Runnable
{
  public VideoHandler$5(qdc paramqdc, spk paramspk1, spg paramspg, spk paramspk2) {}
  
  public void run()
  {
    int i = qdc.a(this.this$0).getHeaderViewsCount() + this.jdField_a_of_type_Spk.a + 1;
    if (QLog.isColorLevel()) {
      QLog.i("VideoHandler", 2, "setSelectionFromTop selectIndex:" + i);
    }
    qdc.a(this.this$0).setSelectionFromTop(i, AIOUtils.dp2px(175.0F, qdc.a(this.this$0).getResources()));
    if (this.jdField_a_of_type_Spg.a() == 7)
    {
      this.this$0.a(this.b);
      return;
    }
    this.this$0.a = null;
    this.this$0.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler.5
 * JD-Core Version:    0.7.0.1
 */