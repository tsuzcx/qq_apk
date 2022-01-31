package com.tencent.mobileqq.ar.model;

import amxd;
import anbo;

public class QQARSession$9
  implements Runnable
{
  public QQARSession$9(anbo paramanbo, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    if (anbo.c(this.this$0)) {
      if (anbo.a(this.this$0) != null) {
        anbo.b(this.this$0, false);
      }
    }
    int i;
    do
    {
      return;
      i = j;
      if (anbo.a(this.this$0) != null)
      {
        i = j;
        if (anbo.a(this.this$0).a != null)
        {
          i = j;
          if (anbo.b(this.this$0))
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
        anbo.a(this.this$0, anbo.a(this.this$0).a);
        return;
      }
    } while (i == 0);
    if (anbo.a(this.this$0) != null) {
      anbo.b(this.this$0, true);
    }
    this.this$0.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.9
 * JD-Core Version:    0.7.0.1
 */