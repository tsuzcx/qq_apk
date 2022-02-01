package com.tencent.luggage.wxa.jp;

import android.util.Log;
import com.tencent.luggage.wxa.jm.a;
import com.tencent.luggage.wxa.jr.b;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static final String g = "e";
  protected f a;
  protected h b;
  protected List<NetworkInterface> c;
  protected InetSocketAddress d;
  protected MulticastSocket e;
  protected MulticastSocket f;
  private boolean h = false;
  private int i;
  
  public e(f paramf, List<NetworkInterface> paramList, h paramh, int paramInt)
  {
    this.a = paramf;
    this.i = paramInt;
    a(paramList, paramh);
  }
  
  private void e()
  {
    Object localObject1 = g;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Entering blocking search receiving loop, listening for UDP datagrams on port: ");
    ((StringBuilder)localObject2).append(this.e.getLocalPort());
    a.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = j.a();
    while (this.h) {
      try
      {
        localObject2 = new byte[a().c()];
        localObject2 = new DatagramPacket((byte[])localObject2, localObject2.length);
        this.e.receive((DatagramPacket)localObject2);
        localObject2 = new String(((DatagramPacket)localObject2).getData(), 0, ((DatagramPacket)localObject2).getLength(), "utf-8");
        localObject3 = g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loopSearch: content = ");
        localStringBuilder.append((String)localObject2);
        a.a((String)localObject3, localStringBuilder.toString());
        localObject2 = ((j)localObject1).a((String)localObject2);
        if (localObject2 != null) {
          this.b.a((b)localObject2);
        } else {
          a.b(g, "discard this message");
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = g;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("search fail: ");
        ((StringBuilder)localObject3).append(Log.getStackTraceString(localIOException));
        a.b((String)localObject2, ((StringBuilder)localObject3).toString());
        this.h = false;
        throw localIOException;
      }
    }
    a.b(g, "loop end");
  }
  
  private void f()
  {
    Object localObject1 = g;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Entering blocking notify receiving loop, listening for UDP datagrams on port: ");
    ((StringBuilder)localObject2).append(this.f.getLocalPort());
    a.a((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = j.a();
    while (this.h) {
      try
      {
        localObject2 = new byte[a().c()];
        localObject2 = new DatagramPacket((byte[])localObject2, localObject2.length);
        this.f.receive((DatagramPacket)localObject2);
        localObject2 = new String(((DatagramPacket)localObject2).getData(), 0, ((DatagramPacket)localObject2).getLength(), "utf-8");
        a.a(g, (String)localObject2);
        localObject2 = ((j)localObject1).a((String)localObject2);
        if (localObject2 != null) {
          this.b.a((b)localObject2);
        } else {
          a.a(g, "receive a not care notify message");
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notify fail: ");
        localStringBuilder.append(Log.getStackTraceString(localIOException));
        a.b((String)localObject2, localStringBuilder.toString());
        this.h = false;
        throw localIOException;
      }
    }
    a.b(g, "loop end");
  }
  
  public f a()
  {
    return this.a;
  }
  
  protected void a(List<NetworkInterface> paramList, h paramh)
  {
    this.b = paramh;
    this.c = paramList;
    try
    {
      this.e = new MulticastSocket(this.i);
      this.e.setReuseAddress(true);
      this.e.setReceiveBufferSize(32768);
      paramList = g;
      paramh = new StringBuilder();
      paramh.append("Creating wildcard socketNotify (for receiving multicast datagrams) on port: ");
      paramh.append(this.a.b());
      a.a(paramList, paramh.toString());
      this.d = new InetSocketAddress(this.a.a(), this.a.b());
      this.f = new MulticastSocket(this.a.b());
      this.f.setReuseAddress(true);
      this.f.setReceiveBufferSize(32768);
      paramList = this.c.iterator();
      while (paramList.hasNext())
      {
        paramh = (NetworkInterface)paramList.next();
        String str = g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Joining multicast group: ");
        localStringBuilder.append(this.d);
        localStringBuilder.append(" on network interface: ");
        localStringBuilder.append(paramh.getDisplayName());
        a.a(str, localStringBuilder.toString());
        this.f.joinGroup(this.d, paramh);
      }
      return;
    }
    catch (Exception paramList)
    {
      paramh = new StringBuilder();
      paramh.append("Could not initialize ");
      paramh.append(g);
      paramh.append(": ");
      paramh.append(paramList);
      paramList = new Exception(paramh.toString());
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.h;
      if (bool) {
        return;
      }
      this.h = true;
      new Thread(new e.b(this, null)).start();
      new Thread(new e.a(this, null)).start();
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      this.h = false;
      if ((this.e != null) && (!this.e.isClosed())) {
        this.e.close();
      }
      if (this.f != null)
      {
        boolean bool = this.f.isClosed();
        if (!bool) {
          try
          {
            a.a(g, "Leaving multicast group");
            Iterator localIterator = this.c.iterator();
            while (localIterator.hasNext())
            {
              localObject2 = (NetworkInterface)localIterator.next();
              this.f.leaveGroup(this.d, (NetworkInterface)localObject2);
            }
          }
          catch (Exception localException)
          {
            Object localObject2 = g;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Could not leave multicast group: ");
            localStringBuilder.append(localException);
            a.a((String)localObject2, localStringBuilder.toString());
            this.f.close();
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.e
 * JD-Core Version:    0.7.0.1
 */