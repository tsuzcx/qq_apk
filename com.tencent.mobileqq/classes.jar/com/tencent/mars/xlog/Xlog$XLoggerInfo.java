package com.tencent.mars.xlog;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mars/xlog/Xlog$XLoggerInfo;", "", "()V", "filename", "", "getFilename", "()Ljava/lang/String;", "setFilename", "(Ljava/lang/String;)V", "funcname", "getFuncname", "setFuncname", "level", "", "getLevel", "()I", "setLevel", "(I)V", "line", "getLine", "setLine", "maintid", "", "getMaintid", "()J", "setMaintid", "(J)V", "pid", "getPid", "setPid", "tag", "getTag", "setTag", "tid", "getTid", "setTid", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
@Keep
public final class Xlog$XLoggerInfo
{
  @Nullable
  private String filename;
  @Nullable
  private String funcname;
  private int level;
  private int line;
  private long maintid;
  private long pid;
  @Nullable
  private String tag;
  private long tid;
  
  @Nullable
  public final String getFilename()
  {
    return this.filename;
  }
  
  @Nullable
  public final String getFuncname()
  {
    return this.funcname;
  }
  
  public final int getLevel()
  {
    return this.level;
  }
  
  public final int getLine()
  {
    return this.line;
  }
  
  public final long getMaintid()
  {
    return this.maintid;
  }
  
  public final long getPid()
  {
    return this.pid;
  }
  
  @Nullable
  public final String getTag()
  {
    return this.tag;
  }
  
  public final long getTid()
  {
    return this.tid;
  }
  
  public final void setFilename(@Nullable String paramString)
  {
    this.filename = paramString;
  }
  
  public final void setFuncname(@Nullable String paramString)
  {
    this.funcname = paramString;
  }
  
  public final void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public final void setLine(int paramInt)
  {
    this.line = paramInt;
  }
  
  public final void setMaintid(long paramLong)
  {
    this.maintid = paramLong;
  }
  
  public final void setPid(long paramLong)
  {
    this.pid = paramLong;
  }
  
  public final void setTag(@Nullable String paramString)
  {
    this.tag = paramString;
  }
  
  public final void setTid(long paramLong)
  {
    this.tid = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.xlog.Xlog.XLoggerInfo
 * JD-Core Version:    0.7.0.1
 */