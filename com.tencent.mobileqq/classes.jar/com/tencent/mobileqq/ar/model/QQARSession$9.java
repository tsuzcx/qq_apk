package com.tencent.mobileqq.ar.model;

import aohg;
import aolr;

public class QQARSession$9
  implements Runnable
{
  public QQARSession$9(aolr paramaolr, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    if (aolr.c(this.this$0)) {
      if (aolr.a(this.this$0) != null) {
        aolr.b(this.this$0, false);
      }
    }
    int i;
    do
    {
      return;
      i = j;
      if (aolr.a(this.this$0) != null)
      {
        i = j;
        if (aolr.a(this.this$0).a != null)
        {
          i = j;
          if (aolr.b(this.this$0))
          {
            i = j;
            if (this.this$0.a == 2) {
              i = 1;
            }
          }
        }
      }
      if ((this.a) && (i != 0))
      {
        aolr.a(this.this$0, aolr.a(this.this$0).a);
        return;
      }
    } while (i == 0);
    if (aolr.a(this.this$0) != null) {
      aolr.b(this.this$0, true);
    }
    this.this$0.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.9
 * JD-Core Version:    0.7.0.1
 */