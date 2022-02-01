package com.eclipsesource.mmv8;

final class MultiContextNodeJS$1
  implements JavaVoidCallback
{
  MultiContextNodeJS$1(MultiContextNodeJS paramMultiContextNodeJS) {}
  
  public void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    paramV8Object = (V8Function)paramV8Array.get(0);
    try
    {
      MultiContextNodeJS.access$000(this.val$node, paramV8Object.twin());
      return;
    }
    finally
    {
      paramV8Object.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.MultiContextNodeJS.1
 * JD-Core Version:    0.7.0.1
 */