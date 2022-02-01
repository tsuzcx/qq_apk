package com.eclipsesource.mmv8;

final class V8ContextSessionMgr
{
  private V8ContextWrapper currentContext;
  private final V8 v8;
  
  V8ContextSessionMgr(V8 paramV8)
  {
    this.v8 = paramV8;
  }
  
  public void enterContext(V8ContextWrapper paramV8ContextWrapper)
  {
    if (paramV8ContextWrapper == null) {
      return;
    }
    if (paramV8ContextWrapper.equals(this.currentContext)) {
      return;
    }
    this.v8.switchV8Context(paramV8ContextWrapper.getPtr());
    this.currentContext = paramV8ContextWrapper;
  }
  
  public void releaseContext(V8ContextWrapper paramV8ContextWrapper)
  {
    if (paramV8ContextWrapper == null) {
      return;
    }
    this.v8.releaseV8Context(paramV8ContextWrapper.getPtr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8ContextSessionMgr
 * JD-Core Version:    0.7.0.1
 */