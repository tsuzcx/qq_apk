package com.mojitox.mxflutter.framework.js.x5;

import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.utils.MxLog;

public abstract class X5BaseInterface
  extends X5CallbackInterface
  implements IX5Interface
{
  private final String b;
  
  public X5BaseInterface(@NonNull X5Executor paramX5Executor)
  {
    super(paramX5Executor);
    if (a()) {
      paramX5Executor = "X5InterfaceFallback";
    } else {
      paramX5Executor = "X5Interface";
    }
    this.b = paramX5Executor;
    MxLog.a(this.b, "call constructor");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5BaseInterface
 * JD-Core Version:    0.7.0.1
 */