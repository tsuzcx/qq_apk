package com.tencent.mobileqq.apollo.meme.action;

import com.tencent.mobileqq.apollo.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/action/MemeAIOAction;", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "messageForApollo", "Lcom/tencent/mobileqq/apollo/model/MessageForApollo;", "aioType", "", "(Lcom/tencent/mobileqq/apollo/model/MessageForApollo;I)V", "needRecord", "", "(Lcom/tencent/mobileqq/apollo/model/MessageForApollo;IZ)V", "getAioType", "()I", "id", "", "getId", "()Ljava/lang/String;", "getMessageForApollo", "()Lcom/tencent/mobileqq/apollo/model/MessageForApollo;", "name", "getName", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "spriteTask$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeAIOAction
  extends MemeAction
{
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final Lazy e;
  @NotNull
  private final MessageForApollo f;
  private final int g;
  private boolean h;
  
  public MemeAIOAction(@NotNull MessageForApollo paramMessageForApollo, int paramInt)
  {
    this(paramMessageForApollo, paramInt, true);
  }
  
  public MemeAIOAction(@NotNull MessageForApollo paramMessageForApollo, int paramInt, boolean paramBoolean)
  {
    super(false, 1, null);
    this.f = paramMessageForApollo;
    this.g = paramInt;
    this.h = paramBoolean;
    if (this.f.is3dAction()) {
      paramInt = this.f.mApollo3DMessage.actionID3D;
    } else {
      paramInt = this.f.mApolloMessage.id;
    }
    this.c = String.valueOf(paramInt);
    paramMessageForApollo = this.f.mApolloMessage.name;
    Intrinsics.checkExpressionValueIsNotNull(paramMessageForApollo, "messageForApollo.mApolloMessage.name");
    this.d = new String(paramMessageForApollo, Charsets.UTF_8);
    this.e = LazyKt.lazy((Function0)new MemeAIOAction.spriteTask.2(this));
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
  public final MessageForApollo d()
  {
    return this.f;
  }
  
  public final int e()
  {
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MemeAIOAction))
      {
        paramObject = (MemeAIOAction)paramObject;
        if ((Intrinsics.areEqual(this.f, paramObject.f)) && (this.g == paramObject.g) && (f() == paramObject.f())) {}
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
    return this.h;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MemeAIOAction(messageForApollo=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", aioType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", needRecord=");
    localStringBuilder.append(f());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemeAIOAction
 * JD-Core Version:    0.7.0.1
 */