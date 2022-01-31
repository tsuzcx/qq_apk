package com.tencent.mobileqq.activity;

import ajvg;
import ajvh;
import ajvi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class DiscussionInfoCardActivity$5
  implements Runnable
{
  DiscussionInfoCardActivity$5(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = DiscussionInfoCardActivity.a(this.this$0).a(DiscussionInfoCardActivity.a(this.this$0));
    this.this$0.a(localArrayList);
    if (this.a) {}
    try
    {
      ajvh localajvh = new ajvh();
      localajvh.a = String.valueOf(DiscussionInfoCardActivity.a(this.this$0));
      localajvh.b = localArrayList.size();
      DiscussionInfoCardActivity.a(this.this$0).a(localajvh);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DiscussionInfoCardActivity", 2, "initDiscussionView getDiscussInfo error disUin=" + DiscussionInfoCardActivity.a(this.this$0), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.5
 * JD-Core Version:    0.7.0.1
 */