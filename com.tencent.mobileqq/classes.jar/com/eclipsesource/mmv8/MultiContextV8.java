package com.eclipsesource.mmv8;

import androidx.annotation.NonNull;
import com.eclipsesource.mmv8.utils.MemoryManager;

public final class MultiContextV8
{
  @NonNull
  private final V8ContextSessionMgr contextSessionMgr;
  @NonNull
  private final V8 v8;
  
  private MultiContextV8()
  {
    this(null);
  }
  
  private MultiContextV8(String paramString)
  {
    this(paramString, null, null);
  }
  
  private MultiContextV8(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.v8 = V8.createV8Runtime(paramString1, null, false, paramString2, paramArrayOfByte);
    this.contextSessionMgr = new V8ContextSessionMgr(getV8());
  }
  
  public static MultiContextV8 createMultiContextV8()
  {
    return new MultiContextV8();
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString)
  {
    return new MultiContextV8(paramString);
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return new MultiContextV8(paramString1, paramString2, paramArrayOfByte);
  }
  
  public static MultiContextV8 createMultiContextV8(String paramString, byte[] paramArrayOfByte)
  {
    return new MultiContextV8(null, paramString, paramArrayOfByte);
  }
  
  public V8Context createContext(int paramInt)
  {
    return new V8ContextWrapper(this, this.v8.createV8Context(paramInt)).context();
  }
  
  public MemoryManager createMemoryManager()
  {
    return new MemoryManager(this.v8);
  }
  
  public void debuggerMessageLoop()
  {
    this.v8.debuggerMessageLoop();
  }
  
  protected void enterContext(V8ContextWrapper paramV8ContextWrapper)
  {
    this.contextSessionMgr.enterContext(paramV8ContextWrapper);
  }
  
  public long getIsolatePtr()
  {
    return this.v8.getIsolatePtr();
  }
  
  public long getUVLoopPtr()
  {
    return this.v8.getUVLoopPtr();
  }
  
  public V8 getV8()
  {
    return this.v8;
  }
  
  public V8Locker getV8Locker()
  {
    return this.v8.getLocker();
  }
  
  public void memoryPressureNotification(int paramInt)
  {
    this.v8.memoryPressureNotification(paramInt);
  }
  
  public void release()
  {
    this.v8.release();
  }
  
  protected void releaseContext(V8ContextWrapper paramV8ContextWrapper)
  {
    this.contextSessionMgr.releaseContext(paramV8ContextWrapper);
  }
  
  public void waitForDebugger(String paramString)
  {
    this.v8.waitForDebugger(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.MultiContextV8
 * JD-Core Version:    0.7.0.1
 */