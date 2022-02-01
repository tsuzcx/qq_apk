package com.tencent.luggage.wxa.ro;

import java.util.Stack;

class g
{
  private static g a = new g();
  private ThreadLocal<Stack<d>> b = new ThreadLocal();
  
  public static g a()
  {
    return a;
  }
  
  public void a(d paramd)
  {
    Stack localStack2 = (Stack)this.b.get();
    Stack localStack1 = localStack2;
    if (localStack2 == null)
    {
      localStack1 = new Stack();
      this.b.set(localStack1);
    }
    localStack1.push(paramd);
  }
  
  public d b()
  {
    Stack localStack = (Stack)this.b.get();
    if (localStack == null) {
      return null;
    }
    if (localStack.size() == 0) {
      return null;
    }
    return (d)((Stack)this.b.get()).peek();
  }
  
  public void c()
  {
    ((Stack)this.b.get()).pop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ro.g
 * JD-Core Version:    0.7.0.1
 */