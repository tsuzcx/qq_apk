package c.t.m.g;

import java.io.File;

final class cq$2
  implements Runnable
{
  cq$2(cq paramcq, File paramFile, String paramString) {}
  
  public final void run()
  {
    try
    {
      Object localObject = co.a(this.a);
      if (co.b((byte[])localObject))
      {
        this.a.delete();
        localObject = new StringBuilder("file ");
        ((StringBuilder)localObject).append(this.a.getName());
        ((StringBuilder)localObject).append(" is empty, then delete.");
        co.a(((StringBuilder)localObject).toString());
        return;
      }
      cu.j.a(this.b, (byte[])localObject, new cq.2.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder("upload error,url=");
      localStringBuilder.append(this.b);
      co.a(localStringBuilder.toString(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cq.2
 * JD-Core Version:    0.7.0.1
 */