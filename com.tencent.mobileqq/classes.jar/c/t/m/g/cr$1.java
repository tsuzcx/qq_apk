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
    Object localObject = new StringBuilder("utr_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    if (co.e())
    {
      StringBuilder localStringBuilder = new StringBuilder("upload failed:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",save to file=");
      localStringBuilder.append((String)localObject);
      co.b(localStringBuilder.toString());
    }
    if ((cr.a(this.b) != null) && (cr.a(this.b).exists())) {
      co.a(new File(cr.a(this.b), (String)localObject), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cr.1
 * JD-Core Version:    0.7.0.1
 */