package c.t.m.g;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public final class dc
{
  public byte[] a = new byte[0];
  public BufferedOutputStream b;
  public ds.a c;
  private File d;
  private String e = "";
  private int f = 0;
  private boolean g = false;
  private long h = 0L;
  private String i = "";
  private boolean j = false;
  private int k = 1;
  private int l = 0;
  
  public dc(File paramFile)
  {
    this(paramFile, (byte)0);
  }
  
  private dc(File paramFile, byte paramByte)
  {
    this.d = paramFile;
    if (paramFile == null) {}
    for (File localFile = null;; localFile = paramFile.getParentFile())
    {
      if (((localFile != null) && (localFile.exists())) || (localFile.mkdirs()))
      {
        this.e = paramFile.getAbsolutePath();
        this.f = 5120;
        if (co.e()) {
          co.a("create file:" + paramFile.getAbsolutePath() + ",bufSize:5120");
        }
        this.b = new BufferedOutputStream(new FileOutputStream(paramFile, true), 5120);
      }
      return;
    }
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      if (this.b == null) {
        return;
      }
      if (co.e()) {
        co.a(this.d.getAbsolutePath() + " close(). length=" + this.d.length());
      }
      this.b.flush();
      this.b.close();
      this.k = 1;
      this.b = null;
      return;
    }
  }
  
  public final void a(ds.a parama)
  {
    synchronized (this.a)
    {
      this.c = parama;
      return;
    }
  }
  
  public final File b()
  {
    synchronized (this.a)
    {
      File localFile = this.d;
      return localFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dc
 * JD-Core Version:    0.7.0.1
 */