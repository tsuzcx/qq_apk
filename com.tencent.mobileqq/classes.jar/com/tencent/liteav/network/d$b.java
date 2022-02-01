package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class d$b
  implements b, f
{
  private final int a = 2;
  private long b = 0L;
  private long c = 0L;
  private int d = 0;
  private boolean e = false;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  private ArrayList<TXSNALPacket> i = new ArrayList();
  private ArrayList<a> j = new ArrayList();
  private TXIStreamDownloader k = null;
  private WeakReference<d> l;
  private f m;
  
  public d$b(TXIStreamDownloader paramTXIStreamDownloader, d paramd)
  {
    this.l = new WeakReference(paramd);
    this.k = paramTXIStreamDownloader;
    this.k.setListener(this);
  }
  
  private void a(TXSNALPacket paramTXSNALPacket)
  {
    Object localObject1 = (d)this.l.get();
    Object localObject2;
    if ((paramTXSNALPacket.nalType == 0) && (!this.e))
    {
      this.d += 1;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[SwitchStream] processing... current video ts:");
      ((StringBuilder)localObject2).append(paramTXSNALPacket.pts);
      ((StringBuilder)localObject2).append(" target video ts:");
      ((StringBuilder)localObject2).append(paramTXSNALPacket.pts);
      ((StringBuilder)localObject2).append(" check times:");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append(" maxTimes:");
      ((StringBuilder)localObject2).append(2);
      TXCLog.i("TXCMultiStreamDownloader", ((StringBuilder)localObject2).toString());
      if ((localObject1 != null) && ((d.a((d)localObject1) <= paramTXSNALPacket.pts) || (this.d == 2)))
      {
        if (d.a((d)localObject1) <= paramTXSNALPacket.pts) {
          TXCLog.i("TXCMultiStreamDownloader", "[SwitchStream] switch video success, video data is ready.");
        } else if (this.d == 2) {
          TXCLog.e("TXCMultiStreamDownloader", "[SwitchStream] switch video failed. all times retried. max times:2");
        }
        this.b = ((d)localObject1).c();
        this.e = true;
      }
    }
    if (!this.e) {
      return;
    }
    if (localObject1 != null) {
      ((d)localObject1).a(paramTXSNALPacket.pts);
    }
    if (paramTXSNALPacket.pts >= this.b)
    {
      if ((paramTXSNALPacket.nalType == 0) && (this.c == 0L))
      {
        this.c = paramTXSNALPacket.pts;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[SwitchStream] pre start end ");
        ((StringBuilder)localObject2).append(paramTXSNALPacket.pts);
        ((StringBuilder)localObject2).append(" from ");
        ((StringBuilder)localObject2).append(this.b);
        ((StringBuilder)localObject2).append(" type ");
        ((StringBuilder)localObject2).append(paramTXSNALPacket.nalType);
        TXCLog.w("TXCMultiStreamDownloader", ((StringBuilder)localObject2).toString());
      }
      if (this.c > 0L)
      {
        if (this.m != null)
        {
          if (localObject1 != null) {
            ((d)localObject1).a(this.k, true);
          }
          if (!this.j.isEmpty())
          {
            localObject1 = this.j.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (a)((Iterator)localObject1).next();
              if (((a)localObject2).e >= this.c)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[SwitchStream] pre start cache audio pts ");
                localStringBuilder.append(((a)localObject2).e);
                localStringBuilder.append(" from ");
                localStringBuilder.append(this.c);
                TXCLog.i("TXCMultiStreamDownloader", localStringBuilder.toString());
                this.m.onPullAudio((a)localObject2);
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[SwitchStream] pre start end audio cache  ");
            ((StringBuilder)localObject1).append(this.j.size());
            TXCLog.w("TXCMultiStreamDownloader", ((StringBuilder)localObject1).toString());
            this.j.clear();
          }
          if (!this.i.isEmpty())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[SwitchStream] pre start end video cache  ");
            ((StringBuilder)localObject1).append(this.i.size());
            TXCLog.w("TXCMultiStreamDownloader", ((StringBuilder)localObject1).toString());
            localObject1 = this.i.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (TXSNALPacket)((Iterator)localObject1).next();
              this.m.onPullNAL((TXSNALPacket)localObject2);
            }
            this.i.clear();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[SwitchStream] pre start first pull nal ");
          ((StringBuilder)localObject1).append(paramTXSNALPacket.pts);
          ((StringBuilder)localObject1).append(" from ");
          ((StringBuilder)localObject1).append(this.c);
          ((StringBuilder)localObject1).append(" type ");
          ((StringBuilder)localObject1).append(paramTXSNALPacket.nalType);
          TXCLog.w("TXCMultiStreamDownloader", ((StringBuilder)localObject1).toString());
          this.m.onPullNAL(paramTXSNALPacket);
          this.m = null;
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[SwitchStream] pre start cache video pts ");
        ((StringBuilder)localObject1).append(paramTXSNALPacket.pts);
        ((StringBuilder)localObject1).append(" from ");
        ((StringBuilder)localObject1).append(this.c);
        ((StringBuilder)localObject1).append(" type ");
        ((StringBuilder)localObject1).append(paramTXSNALPacket.nalType);
        TXCLog.i("TXCMultiStreamDownloader", ((StringBuilder)localObject1).toString());
        this.i.add(paramTXSNALPacket);
      }
    }
  }
  
  private void a(a parama)
  {
    if (parama == null) {
      return;
    }
    if (parama.e >= this.c)
    {
      if (parama.e < this.b) {
        return;
      }
      if ((this.m != null) && (this.c > 0L) && (parama.e >= this.c))
      {
        this.m.onPullAudio(parama);
        return;
      }
      this.j.add(parama);
    }
  }
  
  private void b(TXSNALPacket paramTXSNALPacket)
  {
    Object localObject = (d)this.l.get();
    if (localObject != null) {
      ((d)localObject).b(paramTXSNALPacket.pts);
    }
    if (paramTXSNALPacket.pts >= this.f)
    {
      if (paramTXSNALPacket.nalType == 0) {
        this.g = paramTXSNALPacket.pts;
      }
      if (this.g > 0L)
      {
        if (this.h > 0L)
        {
          paramTXSNALPacket = new StringBuilder();
          paramTXSNALPacket.append("[SwitchStream] switch finish and stop old downloader. video ts:");
          paramTXSNALPacket.append(this.g);
          paramTXSNALPacket.append(" audio ts:");
          paramTXSNALPacket.append(this.h);
          paramTXSNALPacket.append(" stop ts:");
          paramTXSNALPacket.append(this.f);
          TXCLog.i("TXCMultiStreamDownloader", paramTXSNALPacket.toString());
          if (localObject != null) {
            ((d)localObject).b();
          }
          this.m = null;
          this.k.setListener(null);
          this.k.stopDownload();
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[SwitchStream] delay stop video end wait audio end video pts ");
        ((StringBuilder)localObject).append(paramTXSNALPacket.pts);
        ((StringBuilder)localObject).append(" from ");
        ((StringBuilder)localObject).append(this.f);
        ((StringBuilder)localObject).append(" type ");
        ((StringBuilder)localObject).append(paramTXSNALPacket.nalType);
        TXCLog.w("TXCMultiStreamDownloader", ((StringBuilder)localObject).toString());
        return;
      }
      localObject = this.m;
      if (localObject != null) {
        ((f)localObject).onPullNAL(paramTXSNALPacket);
      }
    }
    else
    {
      localObject = this.m;
      if (localObject != null) {
        ((f)localObject).onPullNAL(paramTXSNALPacket);
      }
    }
  }
  
  private void b(a parama)
  {
    if (this.h > 0L) {
      return;
    }
    if ((this.g > 0L) && (parama != null) && (parama.e >= this.g))
    {
      this.h = parama.e;
      return;
    }
    f localf = this.m;
    if (localf != null) {
      localf.onPullAudio(parama);
    }
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[SwitchStream] start switch. current video pts:");
    localStringBuilder.append(paramLong);
    TXCLog.i("TXCMultiStreamDownloader", localStringBuilder.toString());
    this.d = 0;
    this.b = paramLong;
    this.k.setListener(this);
    this.k.setNotifyListener(this);
  }
  
  public void a(f paramf)
  {
    this.m = paramf;
  }
  
  public void b(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[SwitchStream] stop switch. pts:");
    ((StringBuilder)localObject).append(paramLong);
    TXCLog.i("TXCMultiStreamDownloader", ((StringBuilder)localObject).toString());
    this.b = 0L;
    this.f = paramLong;
    this.h = 0L;
    this.g = 0L;
    localObject = this.k;
    if ((localObject != null) && (this.f == 0L))
    {
      ((TXIStreamDownloader)localObject).stopDownload();
      this.k = null;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == -2301) || (paramInt == 3010))
    {
      paramBundle = (d)this.l.get();
      if (paramBundle != null) {
        paramBundle.a(this.k, false);
      }
      this.k.setNotifyListener(null);
    }
  }
  
  public void onPullAudio(a parama)
  {
    if (this.b > 0L)
    {
      a(parama);
      return;
    }
    if (this.f > 0L)
    {
      b(parama);
      return;
    }
    f localf = this.m;
    if (localf != null) {
      localf.onPullAudio(parama);
    }
  }
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    if (paramTXSNALPacket == null) {
      return;
    }
    if (this.b > 0L)
    {
      a(paramTXSNALPacket);
      return;
    }
    if (this.f > 0L)
    {
      b(paramTXSNALPacket);
      return;
    }
    f localf = this.m;
    if (localf != null) {
      localf.onPullNAL(paramTXSNALPacket);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.d.b
 * JD-Core Version:    0.7.0.1
 */