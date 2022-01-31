package com.tencent.biz.subscribe.bizdapters;

import com.tencent.mobileqq.widget.QQToast;
import yef;

public class FakerFeedsAdapter$2
  implements Runnable
{
  public FakerFeedsAdapter$2(yef paramyef) {}
  
  public void run()
  {
    this.this$0.notifyDataSetChanged();
    if (yef.a(this.this$0) != null) {
      QQToast.a(yef.b(this.this$0), 0, 2131695784, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */