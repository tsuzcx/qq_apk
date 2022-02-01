package com.mojitox.mxflutter.framework.js.x5;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.utils.FileUtils;
import com.mojitox.mxflutter.framework.utils.MxLog;

public class X5InterfaceFallback
  implements IX5Interface
{
  @NonNull
  private final X5Executor a;
  
  public X5InterfaceFallback(@NonNull X5Executor paramX5Executor)
  {
    this.a = paramX5Executor;
    MxLog.a("X5InterfaceFallback", "init X5InterfaceFallback");
  }
  
  @JavascriptInterface
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("require");
    ((StringBuilder)localObject).append(paramString);
    MxLog.a("X5InterfaceFallback", ((StringBuilder)localObject).toString());
    localObject = FileUtils.a(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (UiThread.a())
      {
        X5JsModule.a(paramString, (String)localObject, this.a.a());
        return;
      }
      this.a.a(new X5InterfaceFallback.5(this, paramString, (String)localObject).a("require#"));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("require js file fail, import js file name:");
    ((StringBuilder)localObject).append(paramString);
    MxLog.b("X5InterfaceFallback", ((StringBuilder)localObject).toString());
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5InterfaceFallback
 * JD-Core Version:    0.7.0.1
 */