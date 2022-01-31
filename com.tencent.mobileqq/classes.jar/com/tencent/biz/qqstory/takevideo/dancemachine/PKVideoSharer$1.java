package com.tencent.biz.qqstory.takevideo.dancemachine;

import ajya;
import bcql;
import vke;

public class PKVideoSharer$1
  implements Runnable
{
  public void run()
  {
    String str = "";
    if (this.a == -1) {
      str = ajya.a(2131708196);
    }
    for (;;)
    {
      bcql.a(this.this$0.a, 1, str, 0).a();
      return;
      if (this.a == -2) {
        str = ajya.a(2131708192);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.dancemachine.PKVideoSharer.1
 * JD-Core Version:    0.7.0.1
 */