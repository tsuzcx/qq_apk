package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "", "()V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "downloadUrl", "getDownloadUrl", "setDownloadUrl", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMsg", "getErrorMsg", "setErrorMsg", "filePath", "getFilePath", "setFilePath", "packageName", "getPackageName", "setPackageName", "pkgSize", "", "getPkgSize", "()J", "setPkgSize", "(J)V", "progress", "getProgress", "setProgress", "state", "getState", "setState", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public final class AdDownloadInfo
{
  @Nullable
  private String a;
  private int b;
  private int c;
  private int d = -1;
  @Nullable
  private String e;
  @Nullable
  private String f;
  @Nullable
  private String g;
  @Nullable
  private String h;
  private long i;
  
  @Nullable
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.e = paramString;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.f = paramString;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.g = paramString;
  }
  
  @Nullable
  public final String e()
  {
    return this.e;
  }
  
  public final void e(@Nullable String paramString)
  {
    this.h = paramString;
  }
  
  @Nullable
  public final String f()
  {
    return this.f;
  }
  
  @Nullable
  public final String g()
  {
    return this.g;
  }
  
  @Nullable
  public final String h()
  {
    return this.h;
  }
  
  public final long i()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo
 * JD-Core Version:    0.7.0.1
 */