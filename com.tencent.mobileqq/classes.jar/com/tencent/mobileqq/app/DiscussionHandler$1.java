package com.tencent.mobileqq.app;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class DiscussionHandler$1
  implements Runnable
{
  DiscussionHandler$1(DiscussionHandler paramDiscussionHandler, String paramString) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getApplication().getApplicationContext(), 1, this.a, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler.1
 * JD-Core Version:    0.7.0.1
 */