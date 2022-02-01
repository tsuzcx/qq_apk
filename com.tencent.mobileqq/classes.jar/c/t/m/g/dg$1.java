package c.t.m.g;

import android.os.Bundle;

final class dg$1
  implements du.b
{
  dg$1(dg paramdg, Bundle paramBundle, de paramde) {}
  
  public final void a(String paramString)
  {
    this.a.putString("msg_suc", paramString);
    de localde = this.b;
    if (localde != null) {
      localde.a(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.a.putString("msg_fail", paramString);
    de localde = this.b;
    if (localde != null) {
      localde.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dg.1
 * JD-Core Version:    0.7.0.1
 */