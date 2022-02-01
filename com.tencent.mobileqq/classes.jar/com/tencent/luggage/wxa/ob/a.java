package com.tencent.luggage.wxa.ob;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Locale;

public class a
  extends IOException
{
  public final a.a b;
  public final int c;
  public final String d;
  
  public a(@NonNull a.a parama, int paramInt, @Nullable String paramString)
  {
    super(String.format(Locale.ENGLISH, "err:%s, errCode:%d, errMsg:%s", new Object[] { parama.name(), Integer.valueOf(paramInt), paramString }));
    this.b = parama;
    this.c = paramInt;
    this.d = paramString;
  }
  
  @NonNull
  public a.a b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  @Nullable
  public String d()
  {
    return this.d;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CgiException{err=[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], errCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", message='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ob.a
 * JD-Core Version:    0.7.0.1
 */