package com.mojitox.mxflutter.framework.js.x5;

import com.mojitox.mxflutter.framework.executor.JsTask;
import com.tencent.smtt.sdk.JsContext;

class X5Engine$1
  extends JsTask
{
  X5Engine$1(X5Engine paramX5Engine) {}
  
  protected void a()
  {
    ((X5Executor)this.this$0.b()).e().addJavascriptInterface(((X5Executor)this.this$0.b()).f(), "MXJSAPI");
    ((X5Executor)this.this$0.b()).a("function require(path) {globalThis.MXJSAPI.require(path);}", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5Engine.1
 * JD-Core Version:    0.7.0.1
 */