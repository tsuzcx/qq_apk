package com.tencent.luggage.wxa.jp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class d
{
  private boolean a = false;
  private String b;
  private int c = -1;
  private ServerSocket d;
  private c.a e;
  
  public static d a()
  {
    return d.c.a();
  }
  
  public void a(c.a parama)
  {
    this.e = parama;
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.a;
      if (bool) {
        return;
      }
      this.a = true;
      try
      {
        this.b = g.b();
        this.d = new ServerSocket(0, 32, InetAddress.getByName(this.b));
        this.c = this.d.getLocalPort();
        new Thread(new d.b(this)).start();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.a;
      if (!bool) {
        return;
      }
      this.a = false;
      if (this.d != null)
      {
        bool = this.d.isClosed();
        if (bool) {
          try
          {
            this.d.close();
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public String d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.d
 * JD-Core Version:    0.7.0.1
 */