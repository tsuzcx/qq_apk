package com.tencent.luggage.wxa.dd;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/LoginErr;", "", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "equals", "", "other", "", "toString", "CANCEL", "Companion", "INVALID_ARGS", "INVALID_SESSION", "OK", "SYS", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public class d
  extends Throwable
{
  public static final d.a a = new d.a(null);
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private static final int h = -1;
  private final int b;
  private final int c;
  @Nullable
  private final String d;
  
  public d(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  @Nullable
  public final String c()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof d)))
    {
      int i = this.c;
      paramObject = (d)paramObject;
      return (i == paramObject.c) && (this.b == paramObject.b);
    }
    return super.equals(paramObject);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" (errType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.d
 * JD-Core Version:    0.7.0.1
 */