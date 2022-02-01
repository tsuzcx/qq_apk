package com.huawei.agconnect.config.a;

import android.content.Context;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;

final class b
  extends LazyInputStream
{
  b(Context paramContext, InputStream paramInputStream)
  {
    super(paramContext);
  }
  
  public InputStream get(Context paramContext)
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.b
 * JD-Core Version:    0.7.0.1
 */