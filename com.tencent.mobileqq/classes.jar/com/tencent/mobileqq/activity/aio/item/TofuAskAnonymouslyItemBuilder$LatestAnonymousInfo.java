package com.tencent.mobileqq.activity.aio.item;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$LatestAnonymousInfo;", "", "hasGetLatestInfo", "", "questId", "", "praiseNum", "", "beenPraised", "commentNum", "showTimes", "(ZLjava/lang/String;JZJJ)V", "getBeenPraised", "()Z", "setBeenPraised", "(Z)V", "getCommentNum", "()J", "setCommentNum", "(J)V", "getHasGetLatestInfo", "setHasGetLatestInfo", "getPraiseNum", "setPraiseNum", "getQuestId", "()Ljava/lang/String;", "setQuestId", "(Ljava/lang/String;)V", "getShowTimes", "setShowTimes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TofuAskAnonymouslyItemBuilder$LatestAnonymousInfo
{
  private boolean a;
  @NotNull
  private String b;
  private long c;
  private boolean d;
  private long e;
  private long f;
  
  public TofuAskAnonymouslyItemBuilder$LatestAnonymousInfo()
  {
    this(false, null, 0L, false, 0L, 0L, 63, null);
  }
  
  public TofuAskAnonymouslyItemBuilder$LatestAnonymousInfo(boolean paramBoolean1, @NotNull String paramString, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3)
  {
    this.a = paramBoolean1;
    this.b = paramString;
    this.c = paramLong1;
    this.d = paramBoolean2;
    this.e = paramLong2;
    this.f = paramLong3;
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(long paramLong)
  {
    this.e = paramLong;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final void c(long paramLong)
  {
    this.f = paramLong;
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final long e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LatestAnonymousInfo))
      {
        paramObject = (LatestAnonymousInfo)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final long f()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LatestAnonymousInfo(hasGetLatestInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", questId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", praiseNum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", beenPraised=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", commentNum=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", showTimes=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.LatestAnonymousInfo
 * JD-Core Version:    0.7.0.1
 */