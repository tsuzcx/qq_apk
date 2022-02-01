package com.tencent.component.animation.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class BaseSpringSystem
{
  private final Set<Spring> mActiveSprings = new CopyOnWriteArraySet();
  private boolean mIdle = true;
  private final CopyOnWriteArraySet<SpringSystemListener> mListeners = new CopyOnWriteArraySet();
  private final SpringLooper mSpringLooper;
  private final Map<String, Spring> mSpringRegistry = new HashMap();
  
  public BaseSpringSystem(SpringLooper paramSpringLooper)
  {
    if (paramSpringLooper != null)
    {
      this.mSpringLooper = paramSpringLooper;
      this.mSpringLooper.setSpringSystem(this);
      return;
    }
    throw new IllegalArgumentException("springLooper is required");
  }
  
  void activateSpring(String paramString)
  {
    Object localObject = (Spring)this.mSpringRegistry.get(paramString);
    if (localObject != null)
    {
      this.mActiveSprings.add(localObject);
      if (getIsIdle())
      {
        this.mIdle = false;
        this.mSpringLooper.start();
      }
      return;
    }
    localObject = new StringBuilder("springId ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" does not reference a registered spring");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void addListener(SpringSystemListener paramSpringSystemListener)
  {
    if (paramSpringSystemListener != null)
    {
      this.mListeners.add(paramSpringSystemListener);
      return;
    }
    throw new IllegalArgumentException("newListener is required");
  }
  
  void advance(double paramDouble)
  {
    Iterator localIterator = this.mActiveSprings.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      Spring localSpring = (Spring)localIterator.next();
      if (localSpring.systemShouldAdvance()) {
        localSpring.advance(paramDouble / 1000.0D);
      } else {
        this.mActiveSprings.remove(localSpring);
      }
    }
  }
  
  public Spring createSpring()
  {
    Spring localSpring = new Spring(this);
    registerSpring(localSpring);
    return localSpring;
  }
  
  void deregisterSpring(Spring paramSpring)
  {
    if (paramSpring != null)
    {
      this.mActiveSprings.remove(paramSpring);
      this.mSpringRegistry.remove(paramSpring.getId());
      return;
    }
    throw new IllegalArgumentException("spring is required");
  }
  
  public List<Spring> getAllSprings()
  {
    Object localObject = this.mSpringRegistry.values();
    if ((localObject instanceof List)) {
      localObject = (List)localObject;
    } else {
      localObject = new ArrayList((Collection)localObject);
    }
    return Collections.unmodifiableList((List)localObject);
  }
  
  public boolean getIsIdle()
  {
    return this.mIdle;
  }
  
  public Spring getSpringById(String paramString)
  {
    if (paramString != null) {
      return (Spring)this.mSpringRegistry.get(paramString);
    }
    throw new IllegalArgumentException("id is required");
  }
  
  public void loop(double paramDouble)
  {
    Iterator localIterator = this.mListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        advance(paramDouble);
        if (this.mActiveSprings.isEmpty()) {
          this.mIdle = true;
        }
        localIterator = this.mListeners.iterator();
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            if (this.mIdle) {
              this.mSpringLooper.stop();
            }
            return;
          }
          ((SpringSystemListener)localIterator.next()).onAfterIntegrate(this);
        }
      }
      ((SpringSystemListener)localIterator.next()).onBeforeIntegrate(this);
    }
  }
  
  void registerSpring(Spring paramSpring)
  {
    if (paramSpring != null)
    {
      if (!this.mSpringRegistry.containsKey(paramSpring.getId()))
      {
        this.mSpringRegistry.put(paramSpring.getId(), paramSpring);
        return;
      }
      throw new IllegalArgumentException("spring is already registered");
    }
    throw new IllegalArgumentException("spring is required");
  }
  
  public void removeAllListeners()
  {
    this.mListeners.clear();
  }
  
  public void removeListener(SpringSystemListener paramSpringSystemListener)
  {
    if (paramSpringSystemListener != null)
    {
      this.mListeners.remove(paramSpringSystemListener);
      return;
    }
    throw new IllegalArgumentException("listenerToRemove is required");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.animation.rebound.BaseSpringSystem
 * JD-Core Version:    0.7.0.1
 */