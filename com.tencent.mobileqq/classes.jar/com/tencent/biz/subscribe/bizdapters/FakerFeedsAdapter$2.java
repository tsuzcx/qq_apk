package com.tencent.biz.subscribe.bizdapters;

import bcql;
import wld;

public class FakerFeedsAdapter$2
  implements Runnable
{
  public FakerFeedsAdapter$2(wld paramwld) {}
  
  public void run()
  {
    this.this$0.notifyDataSetChanged();
    if (wld.a(this.this$0) != null) {
      bcql.a(wld.b(this.this$0), 0, 2131695624, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */