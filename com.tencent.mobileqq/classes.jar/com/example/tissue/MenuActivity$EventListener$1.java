package com.example.tissue;

import android.content.Context;
import com.tencent.tissue.v8rt.engine.AssetUtil;
import com.tencent.tissue.v8rt.engine.Engine;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.lang.ref.WeakReference;

class MenuActivity$EventListener$1
  implements Runnable
{
  MenuActivity$EventListener$1(MenuActivity.EventListener paramEventListener, Engine paramEngine) {}
  
  public void run()
  {
    V8JsRuntime localV8JsRuntime = this.val$engine.createJsRuntime();
    String str = AssetUtil.loadAssetTextAsString(((Context)this.this$0.ctxRef.get()).getApplicationContext(), "v8test/test_eval_return.js");
    localV8JsRuntime.getDefaultContext().evaluateJsSync(str);
    localV8JsRuntime.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MenuActivity.EventListener.1
 * JD-Core Version:    0.7.0.1
 */