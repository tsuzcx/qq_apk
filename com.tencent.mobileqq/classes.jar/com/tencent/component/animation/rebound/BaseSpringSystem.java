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
    if (paramSpringLooper == null) {
      throw new IllegalArgumentException("springLooper is required");
    }
    this.mSpringLooper = paramSpringLooper;
    this.mSpringLooper.setSpringSystem(this);
  }
  
  void activateSpring(String paramString)
  {
    Spring localSpring = (Spring)this.mSpringRegistry.get(paramString);
    if (localSpring == null) {
      throw new IllegalArgumentException("springId " + paramString + " does not reference a registered spring");
    }
    this.mActiveSprings.add(localSpring);
    if (getIsIdle())
    {
      this.mIdle = false;
      this.mSpringLooper.start();
    }
  }
  
  public void addListener(SpringSystemListener paramSpringSystemListener)
  {
    if (paramSpringSystemListener == null) {
      throw new IllegalArgumentException("newListener is required");
    }
    this.mListeners.add(paramSpringSystemListener);
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
    if (paramSpring == null) {
      throw new IllegalArgumentException("spring is required");
    }
    this.mActiveSprings.remove(paramSpring);
    this.mSpringRegistry.remove(paramSpring.getId());
  }
  
  public List<Spring> getAllSprings()
  {
    Object localObject = this.mSpringRegistry.values();
    if ((localObject instanceof List)) {}
    for (localObject = (List)localObject;; localObject = new ArrayList((Collection)localObject)) {
      return Collections.unmodifiableList((List)localObject);
    }
  }
  
  public boolean getIsIdle()
  {
    return this.mIdle;
  }
  
  public Spring getSpringById(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("id is required");
    }
    return (Spring)this.mSpringRegistry.get(paramString);
  }
  
  public void loop(double paramDouble)
  {
    Iterator localIterator = this.mListeners.iterator();
    if (!localIterator.hasNext())
    {
      advance(paramDouble);
      if (this.mActiveSprings.isEmpty()) {
        this.mIdle = true;
      }
      localIterator = this.mListeners.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (this.mIdle) {
          this.mSpringLooper.stop();
        }
        return;
        ((SpringSystemListener)localIterator.next()).onBeforeIntegrate(this);
        break;
      }
      ((SpringSystemListener)localIterator.next()).onAfterIntegrate(this);
    }
  }
  
  void registerSpring(Spring paramSpring)
  {
    if (paramSpring == null) {
      throw new IllegalArgumentException("spring is required");
    }
    if (this.mSpringRegistry.containsKey(paramSpring.getId())) {
      throw new IllegalArgumentException("spring is already registered");
    }
    this.mSpringRegistry.put(paramSpring.getId(), paramSpring);
  }
  
  public void removeAllListeners()
  {
    this.mListeners.clear();
  }
  
  public void removeListener(SpringSystemListener paramSpringSystemListener)
  {
    if (paramSpringSystemListener == null) {
      throw new IllegalArgumentException("listenerToRemove is required");
    }
    this.mListeners.remove(paramSpringSystemListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.BaseSpringSystem
 * JD-Core Version:    0.7.0.1
 */