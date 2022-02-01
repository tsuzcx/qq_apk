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
  private VoiceWaveScheduled.IVoiceWaveScheduleAdapter jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerVoiceWaveScheduled$IVoiceWaveScheduleAdapter;
  private final List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ScheduledExecutorService jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService;
  private ScheduledFuture<?> jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  private boolean jdField_a_of_type_Boolean = false;
  private final List<Long> b = new ArrayList();
  private final List<String> c = new ArrayList();
  private final List<String> d = new ArrayList();
  
  public VoiceWaveScheduled(VoiceWaveScheduled.IVoiceWaveScheduleAdapter paramIVoiceWaveScheduleAdapter, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerVoiceWaveScheduled$IVoiceWaveScheduleAdapter = paramIVoiceWaveScheduleAdapter;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(VoiceWaveScheduled.IVoiceWaveScheduleAdapter paramIVoiceWaveScheduleAdapter)
  {
    ThreadCenter.postDefaultUITask(new VoiceWaveScheduled.1(this, paramIVoiceWaveScheduleAdapter));
  }
  
  private boolean a(long paramLong)
  {
    return paramLong > 1L;
  }
  
  private void b(VoiceWaveScheduled.IVoiceWaveScheduleAdapter paramIVoiceWaveScheduleAdapter)
  {
    this.b.clear();
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        this.b.addAll(this.jdField_a_of_type_JavaUtilList);
        ??? = paramIVoiceWaveScheduleAdapter.a(this.b);
        if (??? == null) {
          return;
        }
      }
      this.c.clear();
      this.d.clear();
      int i = 0;
      if (i < this.b.size())
      {
        if (a(((Long)???.get(i)).longValue())) {
          this.c.add(String.valueOf(this.b.get(i)));
        }
        for (;;)
        {
          i += 1;
          break;
          this.d.add(String.valueOf(this.b.get(i)));
        }
      }
      if (this.c.size() > 0) {
        paramIVoiceWaveScheduleAdapter.a(this.c);
      }
    } while (this.d.size() <= 0);
    paramIVoiceWaveScheduleAdapter.b(this.d);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService == null) {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }
    this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService.scheduleAtFixedRate(new VoiceWaveScheduled.RefreshTask(this, null), 0L, 500L, TimeUnit.MILLISECONDS);
  }
  
  public void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramLong))) {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramLong));
      }
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService.shutdownNow();
    }
    this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = null;
  }
  
  public void b(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((Long)((Iterator)localObject1).next()).longValue() == paramLong)
        {
          this.jdField_a_of_type_JavaUtilList.remove(Long.valueOf(paramLong));
          if (this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerVoiceWaveScheduled$IVoiceWaveScheduleAdapter != null)
          {
            localObject1 = new ArrayList();
            ((List)localObject1).add(String.valueOf(paramLong));
            this.jdField_a_of_type_ComTencentIlivesdkAudiomediaservicePlayerVoiceWaveScheduled$IVoiceWaveScheduleAdapter.b((List)localObject1);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.player.VoiceWaveScheduled
 * JD-Core Version:    0.7.0.1
 */