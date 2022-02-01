package com.tencent.mobileqq.apollo.api.player.action;

import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/player/action/CMSAIOAction;", "Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction;", "messageForApollo", "Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;", "aioType", "", "(Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;I)V", "needRecord", "", "priority", "playAmountTimes", "(Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;IZII)V", "getAioType", "()I", "id", "", "getId$AQQLiteApp_release", "()Ljava/lang/String;", "getMessageForApollo", "()Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;", "name", "getName$AQQLiteApp_release", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPlayAmountTimes", "setPlayAmountTimes", "(I)V", "getPriority", "spriteTask", "Lcom/tencent/mobileqq/apollo/api/script/SpriteTaskParam;", "getSpriteTask$AQQLiteApp_release", "()Lcom/tencent/mobileqq/apollo/api/script/SpriteTaskParam;", "spriteTask$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSAIOAction
  extends CMSAction
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final MessageForApollo jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private int c;
  
  public CMSAIOAction(@NotNull MessageForApollo paramMessageForApollo, int paramInt)
  {
    this(paramMessageForApollo, paramInt, true, 0, -1);
  }
  
  public CMSAIOAction(@NotNull MessageForApollo paramMessageForApollo, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    super(false, 0, 0, 7, null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo = paramMessageForApollo;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt2;
    this.c = paramInt3;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.is3dAction()) {}
    for (paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApollo3DMessage.actionID_3D;; paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage.id)
    {
      this.jdField_a_of_type_JavaLangString = String.valueOf(paramInt1);
      paramMessageForApollo = this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo.mApolloMessage.name;
      Intrinsics.checkExpressionValueIsNotNull(paramMessageForApollo, "messageForApollo.mApolloMessage.name");
      this.jdField_b_of_type_JavaLangString = new String(paramMessageForApollo, Charsets.UTF_8);
      this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSAIOAction.spriteTask.2(this));
      return;
    }
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final MessageForApollo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo;
  }
  
  @NotNull
  public SpriteTaskParam a()
  {
    return (SpriteTaskParam)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof CMSAIOAction))
      {
        paramObject = (CMSAIOAction)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo, paramObject.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (a() != paramObject.a()) || (b() != paramObject.b()) || (c() != paramObject.c())) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    return "CMSAIOAction(messageForApollo=" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelMessageForApollo + ", aioType=" + this.jdField_a_of_type_Int + ", needRecord=" + a() + ", priority=" + b() + ", playAmountTimes=" + c() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.action.CMSAIOAction
 * JD-Core Version:    0.7.0.1
 */