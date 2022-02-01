package com.tencent.mars.xlog;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mars/xlog/Xlog$XLogConfig;", "", "()V", "cachedays", "", "getCachedays", "()I", "setCachedays", "(I)V", "cachedir", "", "getCachedir", "()Ljava/lang/String;", "setCachedir", "(Ljava/lang/String;)V", "compresslevel", "getCompresslevel", "setCompresslevel", "compressmode", "getCompressmode", "setCompressmode", "level", "getLevel", "setLevel", "logdir", "getLogdir", "setLogdir", "mode", "getMode", "setMode", "nameprefix", "getNameprefix", "setNameprefix", "pubkey", "getPubkey", "setPubkey", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Xlog$XLogConfig
{
  private int cachedays;
  @Nullable
  private String cachedir;
  private int compresslevel;
  private int compressmode;
  private int level = 2;
  @Nullable
  private String logdir;
  private int mode;
  @Nullable
  private String nameprefix;
  @NotNull
  private String pubkey = "";
  
  public final int getCachedays()
  {
    return this.cachedays;
  }
  
  @Nullable
  public final String getCachedir()
  {
    return this.cachedir;
  }
  
  public final int getCompresslevel()
  {
    return this.compresslevel;
  }
  
  public final int getCompressmode()
  {
    return this.compressmode;
  }
  
  public final int getLevel()
  {
    return this.level;
  }
  
  @Nullable
  public final String getLogdir()
  {
    return this.logdir;
  }
  
  public final int getMode()
  {
    return this.mode;
  }
  
  @Nullable
  public final String getNameprefix()
  {
    return this.nameprefix;
  }
  
  @NotNull
  public final String getPubkey()
  {
    return this.pubkey;
  }
  
  public final void setCachedays(int paramInt)
  {
    this.cachedays = paramInt;
  }
  
  public final void setCachedir(@Nullable String paramString)
  {
    this.cachedir = paramString;
  }
  
  public final void setCompresslevel(int paramInt)
  {
    this.compresslevel = paramInt;
  }
  
  public final void setCompressmode(int paramInt)
  {
    this.compressmode = paramInt;
  }
  
  public final void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public final void setLogdir(@Nullable String paramString)
  {
    this.logdir = paramString;
  }
  
  public final void setMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public final void setNameprefix(@Nullable String paramString)
  {
    this.nameprefix = paramString;
  }
  
  public final void setPubkey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.pubkey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.xlog.Xlog.XLogConfig
 * JD-Core Version:    0.7.0.1
 */