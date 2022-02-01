package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class FacePanelBaseAdapter
  implements FacePanelAdapter
{
  private List<AdapterObserver> a = new ArrayList();
  
  public void a(AdapterObserver paramAdapterObserver)
  {
    if (paramAdapterObserver != null)
    {
      if (!this.a.contains(paramAdapterObserver))
      {
        this.a.add(paramAdapterObserver);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Observer ");
      localStringBuilder.append(paramAdapterObserver);
      localStringBuilder.append(" is already registered.");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("the observer is null.");
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AdapterObserver)localIterator.next()).h();
    }
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AdapterObserver)localIterator.next()).c(paramInt);
    }
  }
  
  public void b(AdapterObserver paramAdapterObserver)
  {
    if (paramAdapterObserver != null) {
      synchronized (this.a)
      {
        int i = this.a.indexOf(paramAdapterObserver);
        if (i != -1) {
          this.a.remove(i);
        }
        return;
      }
    }
    throw new IllegalArgumentException("The observer is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter
 * JD-Core Version:    0.7.0.1
 */