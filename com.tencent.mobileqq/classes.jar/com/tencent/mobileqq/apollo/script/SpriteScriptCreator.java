package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpriteScriptCreator
{
  private CopyOnWriteArrayList<SpriteAioScript> a = new CopyOnWriteArrayList();
  private ISpriteActionCallback b;
  private SpriteContext c;
  private AtomicBoolean d = new AtomicBoolean(true);
  
  public SpriteScriptCreator(SpriteContext paramSpriteContext, ISpriteActionCallback paramISpriteActionCallback)
  {
    this.b = paramISpriteActionCallback;
    this.c = paramSpriteContext;
  }
  
  public SpriteAioScript a(int paramInt)
  {
    if (this.c == null) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = b(paramInt);
    boolean bool = this.d.get();
    if (localObject != null) {
      if (bool)
      {
        QLog.w("[cmshow][scripted]SpriteCreator", 1, "createScript init load but has last script");
        this.a.clear();
      }
      else
      {
        return localObject;
      }
    }
    if (paramInt != 0) {
      localObject = new SpriteBusinessScript(paramInt, this.c);
    } else {
      localObject = new SpriteActionScript(paramInt, this.c);
    }
    if (((SpriteAioScript)localObject).f())
    {
      ((SpriteAioScript)localObject).a(this.b);
      ((SpriteAioScript)localObject).e();
      ((SpriteAioScript)localObject).d();
      this.a.add(localObject);
      long l2 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create script, bid:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",cost:");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(",threadId:");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(",init:");
      localStringBuilder.append(bool);
      QLog.i("[cmshow][scripted]SpriteCreator", 1, localStringBuilder.toString());
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    if (this.c == null) {
      return;
    }
    a(0);
    this.d.set(false);
  }
  
  public SpriteAioScript b(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      SpriteAioScript localSpriteAioScript = (SpriteAioScript)localIterator.next();
      if (localSpriteAioScript.c() == paramInt) {
        return localSpriteAioScript;
      }
    }
    return null;
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((CopyOnWriteArrayList)localObject).size() == 0) {
        return;
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SpriteAioScript)((Iterator)localObject).next()).i();
      }
      this.a.clear();
      this.d.set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteScriptCreator
 * JD-Core Version:    0.7.0.1
 */