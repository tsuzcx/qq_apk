package com.qq.ac.sdk.e.a;

import android.util.Log;
import com.b.a.o.a;
import com.b.a.t;
import com.qq.ac.sdk.e.b;
import com.qq.ac.sdk.listener.BaseInfoListener;

final class a$2
  implements o.a
{
  a$2(a parama, b paramb) {}
  
  public final void a(t paramt)
  {
    StringBuilder localStringBuilder = new StringBuilder("onErrorResponse ");
    localStringBuilder.append(paramt.getMessage());
    Log.d("VolleyEngine", localStringBuilder.toString());
    paramt = this.a.d();
    if (paramt != null) {
      paramt.onFailure(-60001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.ac.sdk.e.a.a.2
 * JD-Core Version:    0.7.0.1
 */