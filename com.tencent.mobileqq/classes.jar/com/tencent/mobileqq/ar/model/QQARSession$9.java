package com.tencent.mobileqq.ar.model;

import apki;
import apos;

public class QQARSession$9
  implements Runnable
{
  public QQARSession$9(apos paramapos, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    if (apos.c(this.this$0)) {
      if (apos.a(this.this$0) != null) {
        apos.b(this.this$0, false);
      }
    }
    int i;
    do
    {
      return;
      i = j;
      if (apos.a(this.this$0) != null)
      {
        i = j;
        if (apos.a(this.this$0).a != null)
        {
          i = j;
          if (apos.b(this.this$0))
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
        apos.a(this.this$0, apos.a(this.this$0).a);
        return;
      }
    } while (i == 0);
    if (apos.a(this.this$0) != null) {
      apos.b(this.this$0, true);
    }
    this.this$0.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.9
 * JD-Core Version:    0.7.0.1
 */