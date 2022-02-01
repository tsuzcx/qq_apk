package com.sina.weibo.sdk.web.b;

import com.sina.weibo.sdk.net.c;

final class d$1
  implements c<String>
{
  d$1(d paramd, b.a parama) {}
  
  public final void onError(Throwable paramThrowable)
  {
    if (this.aN != null) {
      this.aN.onError(paramThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.web.b.d.1
 * JD-Core Version:    0.7.0.1
 */