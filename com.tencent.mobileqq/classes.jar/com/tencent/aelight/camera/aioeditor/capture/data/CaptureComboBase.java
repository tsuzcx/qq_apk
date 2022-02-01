package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class CaptureComboBase
{
  public ArrayList<CaptureComboDownloadListener> a = new ArrayList();
  public int b = 2;
  public int c;
  protected SegmentKeeper d;
  public Object e;
  
  public CaptureComboBase(Object paramObject)
  {
    this.e = paramObject;
  }
  
  public abstract int a(Activity paramActivity, int paramInt);
  
  public void a()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CaptureComboDownloadListener)localIterator.next()).a(this);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CaptureComboDownloadListener)localIterator.next()).a(this, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(CaptureComboDownloadListener paramCaptureComboDownloadListener)
  {
    synchronized (this.a)
    {
      if (!this.a.contains(paramCaptureComboDownloadListener)) {
        this.a.add(paramCaptureComboDownloadListener);
      }
      return;
    }
  }
  
  public void a(SegmentKeeper paramSegmentKeeper)
  {
    this.d = paramSegmentKeeper;
  }
  
  public void b()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((CaptureComboDownloadListener)localIterator.next()).b(this);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public abstract void b(Activity paramActivity, int paramInt);
  
  public abstract int c();
  
  public void c(Activity paramActivity, int paramInt) {}
  
  public int d()
  {
    return 1;
  }
  
  public abstract float e();
  
  public String f()
  {
    return String.valueOf(this.e.hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboBase
 * JD-Core Version:    0.7.0.1
 */