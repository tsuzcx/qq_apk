package com.tencent.mobileqq.apollo.view.pannel;

import anph;
import anpk;
import anqh;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ApolloPanel$FrameCallback$1
  implements Runnable
{
  public ApolloPanel$FrameCallback$1(anph paramanph) {}
  
  public void run()
  {
    if ((anph.a(this.this$0) != null) && (anph.a(this.this$0).size() > 0))
    {
      Iterator localIterator = anph.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        anqh localanqh = (anqh)localIterator.next();
        if ((localanqh != null) && ((localanqh.d == 9) || (localanqh.d == 8)) && (localanqh.a() != null))
        {
          QLog.d("ApolloPanel", 1, "ApolloPanel handleCMSPlayerGetFrame notifyDataSetChanged");
          localanqh.a().notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.FrameCallback.1
 * JD-Core Version:    0.7.0.1
 */