package c.t.m.g;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public final class dd
{
  public byte[] a = new byte[0];
  public StringBuilder b;
  public int c = 0;
  private File d;
  private FileOutputStream e;
  private BufferedOutputStream f;
  private du.a g;
  private String h = "";
  private boolean i = false;
  private long j = 9223372036854775807L;
  private String k = "";
  private boolean l = false;
  private boolean m = false;
  private int n = 1;
  private int o = 0;
  
  public dd(File paramFile)
  {
    this(paramFile, (byte)0);
  }
  
  private dd(File paramFile, byte paramByte)
  {
    this.d = paramFile;
    Object localObject;
    if (paramFile == null) {
      localObject = null;
    } else {
      localObject = paramFile.getParentFile();
    }
    if (((localObject != null) && (((File)localObject).exists())) || (((File)localObject).mkdirs()))
    {
      this.h = paramFile.getAbsolutePath();
      this.c = 5120;
      if (co.e())
      {
        localObject = new StringBuilder("create file:");
        ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
        ((StringBuilder)localObject).append(",bufSize:5120");
        co.a(((StringBuilder)localObject).toString());
      }
      this.b = new StringBuilder(5120);
      this.e = new FileOutputStream(paramFile, true);
      this.f = new BufferedOutputStream(this.e, 5120);
    }
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      if (this.f == null) {
        return;
      }
      a(this.b.toString().getBytes("UTF-8"));
      this.b.setLength(0);
      if (co.e())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d.getAbsolutePath());
        localStringBuilder.append(" close(). length=");
        localStringBuilder.append(this.d.length());
        co.a(localStringBuilder.toString());
      }
      this.f.close();
      this.e.close();
      this.n = 1;
      this.f = null;
      this.e = null;
      return;
    }
  }
  
  public final void a(du.a parama)
  {
    synchronized (this.a)
    {
      this.g = parama;
      return;
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    synchronized (this.a)
    {
      if (this.f == null) {
        return;
      }
      if (this.g != null) {
        paramArrayOfByte = this.g.a(paramArrayOfByte);
      }
      this.f.write(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dd
 * JD-Core Version:    0.7.0.1
 */