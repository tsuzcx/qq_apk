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
      byte[] arrayOfByte = co.a(this.a);
      if (co.b(arrayOfByte))
      {
        this.a.delete();
        co.a("file " + this.a.getName() + " is empty, then delete.");
        return;
      }
      ct.i.a(this.b, arrayOfByte, new cq.2.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      co.a("upload error,url=" + this.b, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cq.2
 * JD-Core Version:    0.7.0.1
 */