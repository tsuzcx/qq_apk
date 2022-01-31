package c.t.m.g;

import android.os.Bundle;

final class df$1
  implements ds.b
{
  df$1(df paramdf, Bundle paramBundle, dd paramdd) {}
  
  public final void a(String paramString)
  {
    this.a.putString("msg_suc", paramString);
    if (this.b != null) {
      this.b.a(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.a.putString("msg_fail", paramString);
    if (this.b != null) {
      this.b.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.df.1
 * JD-Core Version:    0.7.0.1
 */