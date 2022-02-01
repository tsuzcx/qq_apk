package c.t.m.g;

import java.io.File;

final class cr$1
  implements de
{
  cr$1(cr paramcr, byte[] paramArrayOfByte) {}
  
  public final void a(String paramString)
  {
    if (co.e()) {
      co.a("upload succeed:".concat(String.valueOf(paramString)));
    }
  }
  
  public final void b(String paramString)
  {
    String str = "utr_" + System.currentTimeMillis();
    if (co.e()) {
      co.b("upload failed:" + paramString + ",save to file=" + str);
    }
    if ((cr.a(this.b) != null) && (cr.a(this.b).exists())) {
      co.a(new File(cr.a(this.b), str), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.cr.1
 * JD-Core Version:    0.7.0.1
 */