package com.tencent.mobileqq.activity.aio;

import afsv;
import auzd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class IntimateInfoView$4
  implements Runnable
{
  public IntimateInfoView$4(afsv paramafsv) {}
  
  public void run()
  {
    if ((afsv.a(this.this$0) != null) && (this.this$0.a != null)) {
      ((auzd)this.this$0.a.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(afsv.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.4
 * JD-Core Version:    0.7.0.1
 */