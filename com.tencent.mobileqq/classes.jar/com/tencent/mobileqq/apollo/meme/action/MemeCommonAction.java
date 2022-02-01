package com.tencent.mobileqq.apollo.meme.action;

import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/action/MemeCommonAction;", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "actionId", "", "actionType", "senderUin", "", "receiverUin", "extendJson", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "needRecord", "", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "id", "getId", "()Ljava/lang/String;", "name", "getName", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "spriteTask$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public final class MemeCommonAction
  extends MemeAction
{
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final Lazy e;
  private final int f;
  private final int g;
  private final String h;
  private final String i;
  private final String j;
  private boolean k;
  
  public MemeCommonAction(int paramInt1, int paramInt2, @NotNull String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, true);
  }
  
  public MemeCommonAction(int paramInt1, int paramInt2, @NotNull String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean)
  {
    super(false, 1, null);
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramBoolean;
    this.c = String.valueOf(this.f);
    this.d = "";
    this.e = LazyKt.lazy((Function0)new MemeCommonAction.spriteTask.2(this));
  }
  
  @NotNull
  public String a()
  {
    return this.c;
  }
  
  @NotNull
  public String b()
  {
    return this.d;
  }
  
  @NotNull
  public SpriteTaskParam c()
  {
    return (SpriteTaskParam)this.e.getValue();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MemeCommonAction))
      {
        paramObject = (MemeCommonAction)paramObject;
        if ((this.f == paramObject.f) && (this.g == paramObject.g) && (Intrinsics.areEqual(this.h, paramObject.h)) && (Intrinsics.areEqual(this.i, paramObject.i)) && (Intrinsics.areEqual(this.j, paramObject.j)) && (f() == paramObject.f())) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MemeCommonAction(actionId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", senderUin='");
    localStringBuilder.append(this.h);
    localStringBuilder.append("', ");
    localStringBuilder.append("receiverUin=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", extendJson=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", needRecord=");
    localStringBuilder.append(f());
    localStringBuilder.append(", ");
    localStringBuilder.append("id='");
    localStringBuilder.append(a());
    localStringBuilder.append("', name='");
    localStringBuilder.append(b());
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemeCommonAction
 * JD-Core Version:    0.7.0.1
 */