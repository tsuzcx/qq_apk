package com.example.tissue;

import android.content.Context;
import android.util.Log;
import com.tencent.tissue.v8rt.engine.AssetUtil;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import java.lang.ref.WeakReference;

class MenuActivity$EventListener$2
  implements Runnable
{
  MenuActivity$EventListener$2(MenuActivity.EventListener paramEventListener, V8JsRuntime paramV8JsRuntime) {}
  
  public void run()
  {
    Object localObject = AssetUtil.loadAssetTextAsString(((Context)this.this$0.ctxRef.get()).getApplicationContext(), "v8test/test.js");
    String str = AssetUtil.loadAssetTextAsString(((Context)this.this$0.ctxRef.get()).getApplicationContext(), "v8test/test_eval_return.js");
    this.val$runtime.getDefaultContext().injectAll();
    this.val$runtime.getDefaultContext().evaluateJsSync((String)localObject);
    long l = this.val$runtime.getDefaultContext().evaluateJsWithReturnPtrSync(str);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ret is ");
    ((StringBuilder)localObject).append(Long.valueOf(l));
    Log.d("MenuActivity", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MenuActivity.EventListener.2
 * JD-Core Version:    0.7.0.1
 */