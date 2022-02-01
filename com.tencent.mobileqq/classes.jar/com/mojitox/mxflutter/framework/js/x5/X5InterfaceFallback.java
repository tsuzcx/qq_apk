package com.mojitox.mxflutter.framework.js.x5;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.mojitox.mxflutter.framework.executor.UiThread;
import com.mojitox.mxflutter.framework.utils.FileUtils;
import com.mojitox.mxflutter.framework.utils.MxLog;

public class X5InterfaceFallback
  extends X5BaseInterface
{
  public X5InterfaceFallback(@NonNull X5Executor paramX5Executor)
  {
    super(paramX5Executor);
  }
  
  @JavascriptInterface
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("#require: filePath=");
    ((StringBuilder)localObject).append(paramString);
    MxLog.a("X5InterfaceFallback", ((StringBuilder)localObject).toString());
    localObject = FileUtils.a(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      UiThread.c(new X5InterfaceFallback.5(this, paramString, (String)localObject).a("require#"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.js.x5.X5InterfaceFallback
 * JD-Core Version:    0.7.0.1
 */