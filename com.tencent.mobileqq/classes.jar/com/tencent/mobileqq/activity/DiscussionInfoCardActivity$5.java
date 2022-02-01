package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionHandler.ReqDiscussInfo;
import com.tencent.mobileqq.app.DiscussionManager;
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
    if (this.a) {
      try
      {
        localObject = new DiscussionHandler.ReqDiscussInfo();
        ((DiscussionHandler.ReqDiscussInfo)localObject).a = String.valueOf(DiscussionInfoCardActivity.a(this.this$0));
        ((DiscussionHandler.ReqDiscussInfo)localObject).b = localArrayList.size();
        DiscussionInfoCardActivity.a(this.this$0).a((DiscussionHandler.ReqDiscussInfo)localObject);
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initDiscussionView getDiscussInfo error disUin=");
          ((StringBuilder)localObject).append(DiscussionInfoCardActivity.a(this.this$0));
          QLog.d("DiscussionInfoCardActivity", 2, ((StringBuilder)localObject).toString(), localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.5
 * JD-Core Version:    0.7.0.1
 */