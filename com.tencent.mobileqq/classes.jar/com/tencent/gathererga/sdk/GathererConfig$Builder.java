package com.tencent.gathererga.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import java.util.HashMap;
import java.util.Map;

public final class GathererConfig$Builder
{
  private Context a;
  private String b = "";
  private int c;
  private String d;
  private String e = "Gatherer";
  private GathererHTTP f;
  private boolean g = false;
  private IExecutor h;
  private ProviderResultCache i;
  private ILog j;
  private Map<Integer, Boolean> k = new HashMap();
  
  private GathererConfig$Builder(Context paramContext, int paramInt)
  {
    this.a = paramContext.getApplicationContext();
    this.c = paramInt;
  }
  
  public final Builder a(IExecutor paramIExecutor)
  {
    this.h = paramIExecutor;
    return this;
  }
  
  public final Builder a(ILog paramILog)
  {
    this.j = paramILog;
    return this;
  }
  
  public final Builder a(GathererHTTP paramGathererHTTP)
  {
    this.f = paramGathererHTTP;
    return this;
  }
  
  public final Builder a(ProviderResultCache paramProviderResultCache)
  {
    this.i = paramProviderResultCache;
    return this;
  }
  
  public final Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public final Builder a(Map<Integer, Boolean> paramMap)
  {
    this.k = paramMap;
    return this;
  }
  
  public final Builder a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public final GathererConfig a()
  {
    return new GathererConfig(this, null);
  }
  
  public final Builder b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public final Builder c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.e = paramString;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.sdk.GathererConfig.Builder
 * JD-Core Version:    0.7.0.1
 */