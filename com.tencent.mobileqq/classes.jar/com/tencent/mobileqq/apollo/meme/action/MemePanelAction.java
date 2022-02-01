package com.tencent.mobileqq.apollo.meme.action;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/action/MemePanelAction;", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "apolloActionData", "Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "selfUin", "", "(Lcom/tencent/mobileqq/apollo/model/ApolloActionData;Ljava/lang/String;)V", "actionData", "peerUin", "needRecord", "", "(Lcom/tencent/mobileqq/apollo/model/ApolloActionData;Ljava/lang/String;Ljava/lang/String;Z)V", "getActionData", "()Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "id", "getId", "()Ljava/lang/String;", "name", "getName", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPeerUin", "getSelfUin", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "spriteTask$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public final class MemePanelAction
  extends MemeAction
{
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final Lazy e;
  @NotNull
  private final ApolloActionData f;
  @NotNull
  private final String g;
  @Nullable
  private final String h;
  private boolean i;
  
  public MemePanelAction(@NotNull ApolloActionData paramApolloActionData, @NotNull String paramString)
  {
    this(paramApolloActionData, paramString, null, true);
  }
  
  public MemePanelAction(@NotNull ApolloActionData paramApolloActionData, @NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    super(false, 1, null);
    this.f = paramApolloActionData;
    this.g = paramString1;
    this.h = paramString2;
    this.i = paramBoolean;
    this.c = String.valueOf(this.f.actionId);
    paramApolloActionData = this.f.actionName;
    Intrinsics.checkExpressionValueIsNotNull(paramApolloActionData, "actionData.actionName");
    this.d = paramApolloActionData;
    this.e = LazyKt.lazy((Function0)new MemePanelAction.spriteTask.2(this));
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
  
  @NotNull
  public final ApolloActionData d()
  {
    return this.f;
  }
  
  @NotNull
  public final String e()
  {
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MemePanelAction))
      {
        paramObject = (MemePanelAction)paramObject;
        if ((Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h)) && (f() == paramObject.f())) {}
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
    return this.i;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Nullable
  public final String n()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MemePanelAction(actionData=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", selfUin=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", peerUin=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", needRecord=");
    localStringBuilder.append(f());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemePanelAction
 * JD-Core Version:    0.7.0.1
 */