package com.example.tissue;

import android.os.Looper;
import android.util.Log;
import com.tencent.tissue.miniapp.IJsService;
import com.tencent.tissue.miniapp.hdasync.HdAsyncAction;
import com.tencent.tissue.miniapp.hdasync.HdAsyncResult;
import com.tencent.tissue.v8rt.engine.AssetUtil;

class ApiBridge$1$2
  extends HdAsyncAction
{
  ApiBridge$1$2(ApiBridge.1 param1, Looper paramLooper, String paramString1, String paramString2)
  {
    super(paramLooper);
  }
  
  public HdAsyncResult call(Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("const ");
    paramObject.append(this.val$module);
    paramObject.append(" = {} \nmodule = ");
    paramObject.append(this.val$module);
    paramObject.append("\n");
    paramObject = paramObject.toString();
    ApiBridge.access$000(this.this$1.this$0).loadScript(this.val$wxsPath, paramObject);
    ApiBridge.access$102(this.this$1.this$0, this.val$wxsPath);
    paramObject = AssetUtil.loadFileAsString(ApiBridge.normalizePath(this.val$wxsPath));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wxsPath content: ");
    localStringBuilder.append(paramObject);
    Log.w("ApiBridge3", localStringBuilder.toString());
    paramObject = ApiBridge.access$000(this.this$1.this$0).executeScriptWithReturn(this.val$wxsPath, paramObject);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("__tissue_load_wxs_: ");
    localStringBuilder.append(paramObject);
    Log.w("ApiBridge3", localStringBuilder.toString());
    return doNext(true, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.ApiBridge.1.2
 * JD-Core Version:    0.7.0.1
 */