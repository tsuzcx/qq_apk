package com.huawei.hms.common.internal;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import java.lang.ref.WeakReference;

public class ConnectionManagerKey<TOption extends Api.ApiOptions>
{
  private final Api<TOption> mApi;
  private final WeakReference<Context> mContextRef;
  private final int mHashKey;
  private final boolean mHaveOption;
  private final TOption mOption;
  private final String subAppId;
  
  private ConnectionManagerKey(Context paramContext, Api<TOption> paramApi, TOption paramTOption, String paramString)
  {
    this.mHaveOption = false;
    this.mContextRef = new WeakReference(paramContext);
    this.mApi = paramApi;
    this.mOption = paramTOption;
    this.mHashKey = Objects.hashCode(new Object[] { this.mContextRef.get(), this.mApi, this.mOption });
    this.subAppId = paramString;
  }
  
  private ConnectionManagerKey(Api<TOption> paramApi, String paramString)
  {
    this.mHaveOption = true;
    this.mApi = paramApi;
    this.mOption = null;
    this.mHashKey = System.identityHashCode(this);
    this.subAppId = paramString;
    this.mContextRef = null;
  }
  
  public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Context paramContext, Api<TOption> paramApi, TOption paramTOption, String paramString)
  {
    return new ConnectionManagerKey(paramContext, paramApi, paramTOption, paramString);
  }
  
  public static <TOption extends Api.ApiOptions> ConnectionManagerKey<TOption> createConnectionManagerKey(Api<TOption> paramApi, String paramString)
  {
    return new ConnectionManagerKey(paramApi, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ConnectionManagerKey)) {
      return false;
    }
    paramObject = (ConnectionManagerKey)paramObject;
    if ((this.mContextRef != null) && (paramObject.mContextRef != null)) {
      return (this.mHaveOption == paramObject.mHaveOption) && (Objects.equal(this.mApi, paramObject.mApi)) && (Objects.equal(this.mOption, paramObject.mOption)) && (Objects.equal(this.subAppId, paramObject.subAppId)) && (Objects.equal(this.mContextRef.get(), paramObject.mContextRef.get()));
    }
    if ((this.mContextRef == null) && (paramObject.mContextRef == null)) {
      return (this.mHaveOption == paramObject.mHaveOption) && (Objects.equal(this.mApi, paramObject.mApi)) && (Objects.equal(this.mOption, paramObject.mOption)) && (Objects.equal(this.subAppId, paramObject.subAppId));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.mHashKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.ConnectionManagerKey
 * JD-Core Version:    0.7.0.1
 */