package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.config.a.h;
import java.io.InputStream;

public abstract class LazyInputStream
{
  private final Context mContext;
  private InputStream mInput;
  
  public LazyInputStream(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void close()
  {
    h.a(this.mInput);
  }
  
  public abstract InputStream get(Context paramContext);
  
  public InputStream loadInputStream()
  {
    if (this.mInput == null) {
      this.mInput = get(this.mContext);
    }
    return this.mInput;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.LazyInputStream
 * JD-Core Version:    0.7.0.1
 */