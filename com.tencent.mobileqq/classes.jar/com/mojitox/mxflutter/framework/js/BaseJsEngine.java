package com.mojitox.mxflutter.framework.js;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.callback.ExecuteScriptCallback;
import java.util.HashMap;

public abstract class BaseJsEngine<T extends BaseJsExecutor>
  implements IJsEngine<T>
{
  @NonNull
  private final HashMap<String, Object> a = new HashMap();
  private long b = 0L;
  private T c;
  
  public BaseJsEngine()
  {
    c();
  }
  
  @NonNull
  protected abstract T a();
  
  protected Object a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return this.a.get(paramString);
  }
  
  protected void a(@NonNull ExecuteScriptCallback paramExecuteScriptCallback)
  {
    b().a(true, new BaseJsEngine.1(this, paramExecuteScriptCallback));
  }
  
  @NonNull
  public T b()
  {
    if (this.c == null) {
      this.c = a();
    }
    return this.c;
  }
  
  protected abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.BaseJsEngine
 * JD-Core Version:    0.7.0.1
 */