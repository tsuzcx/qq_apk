package com.mojitox.mxflutter.framework.js;

import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.js.x5.X5Engine;
import java.io.PrintWriter;
import java.io.StringWriter;

public class JsEngineProvider
{
  @NonNull
  public static BaseJsEngine a()
  {
    return new X5Engine();
  }
  
  public static String a(@NonNull Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.JsEngineProvider
 * JD-Core Version:    0.7.0.1
 */