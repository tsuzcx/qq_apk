package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;

class ReadInJoyArticleDetailActivity$5
  implements MessageQueue.IdleHandler
{
  ReadInJoyArticleDetailActivity$5(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!WebIPCOperator.a().a())
    {
      WebIPCOperator.a().a().doBindService(BaseApplicationImpl.getApplication());
      WebIPCOperator.a().a(new ReadInJoyArticleDetailActivity.5.1(this));
      return false;
    }
    Bundle localBundle = DataFactory.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    WebIPCOperator.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity.5
 * JD-Core Version:    0.7.0.1
 */