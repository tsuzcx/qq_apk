package com.tencent.ilivesdk.audiomediaservice.player;

import com.tencent.falco.utils.ThreadCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class VoiceWaveScheduled
{
  private boolean a = false;
  private VoiceWaveScheduled.IVoiceWaveScheduleAdapter b;
  private ScheduledFuture<?> c;
  private ScheduledExecutorService d;
  private final List<Long> e = new ArrayList();
  private final List<Long> f = new ArrayList();
  private final List<String> g = new ArrayList();
  private final List<String> h = new ArrayList();
  
  public VoiceWaveScheduled(VoiceWaveScheduled.IVoiceWaveScheduleAdapter paramIVoiceWaveScheduleAdapter, boolean paramBoolean)
  {
    this.b = paramIVoiceWaveScheduleAdapter;
    this.a = paramBoolean;
  }
  
  private void a(VoiceWaveScheduled.IVoiceWaveScheduleAdapter paramIVoiceWaveScheduleAdapter)
  {
    ThreadCenter.postDefaultUITask(new VoiceWaveScheduled.1(this, paramIVoiceWaveScheduleAdapter));
  }
  
  private void b(VoiceWaveScheduled.IVoiceWaveScheduleAdapter paramIVoiceWaveScheduleAdapter)
  {
    this.f.clear();
    synchronized (this.e)
    {
      this.f.addAll(this.e);
      ??? = paramIVoiceWaveScheduleAdapter.a(this.f);
      if (??? == null) {
        return;
      }
      this.g.clear();
      this.h.clear();
      int i = 0;
      while (i < this.f.size())
      {
        if (c(((Long)???.get(i)).longValue())) {
          this.g.add(String.valueOf(this.f.get(i)));
        } else {
          this.h.add(String.valueOf(this.f.get(i)));
        }
        i += 1;
      }
      if (this.g.size() > 0) {
        paramIVoiceWaveScheduleAdapter.b(this.g);
      }
      if (this.h.size() > 0) {
        paramIVoiceWaveScheduleAdapter.c(this.h);
      }
      return;
    }
    for (;;)
    {
      throw paramIVoiceWaveScheduleAdapter;
    }
  }
  
  private boolean c(long paramLong)
  {
    return paramLong > 1L;
  }
  
  public void a()
  {
    if (this.c != null) {
      return;
    }
    if (this.d == null) {
      this.d = Executors.newSingleThreadScheduledExecutor();
    }
    this.c = this.d.scheduleAtFixedRate(new VoiceWaveScheduled.RefreshTask(this, null), 0L, 500L, TimeUnit.MILLISECONDS);
  }
  
  public void a(long paramLong)
  {
    synchronized (this.e)
    {
      if (!this.e.contains(Long.valueOf(paramLong))) {
        this.e.add(Long.valueOf(paramLong));
      }
      return;
    }
  }
  
  public void b()
  {
    ScheduledExecutorService localScheduledExecutorService = this.d;
    if (localScheduledExecutorService != null) {
      localScheduledExecutorService.shutdownNow();
    }
    this.c = null;
  }
  
  public void b(long paramLong)
  {
    synchronized (this.e)
    {
      Object localObject1 = this.e.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((Long)((Iterator)localObject1).next()).longValue() == paramLong)
        {
          this.e.remove(Long.valueOf(paramLong));
          if (this.b != null)
          {
            localObject1 = new ArrayList();
            ((List)localObject1).add(String.valueOf(paramLong));
            this.b.c((List)localObject1);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.VoiceWaveScheduled
 * JD-Core Version:    0.7.0.1
 */