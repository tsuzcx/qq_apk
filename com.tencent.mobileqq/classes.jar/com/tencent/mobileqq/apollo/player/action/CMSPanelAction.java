package com.tencent.mobileqq.apollo.player.action;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/action/CMSPanelAction;", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "apolloActionData", "Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "selfUin", "", "(Lcom/tencent/mobileqq/apollo/model/ApolloActionData;Ljava/lang/String;)V", "actionData", "peerUin", "needRecord", "", "playAmountTimes", "", "(Lcom/tencent/mobileqq/apollo/model/ApolloActionData;Ljava/lang/String;Ljava/lang/String;ZI)V", "getActionData", "()Lcom/tencent/mobileqq/apollo/model/ApolloActionData;", "id", "getId", "()Ljava/lang/String;", "name", "getName", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPeerUin", "getPlayAmountTimes", "()I", "setPlayAmountTimes", "(I)V", "getSelfUin", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "spriteTask$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public final class CMSPanelAction
  extends CMSAction
{
  private int jdField_a_of_type_Int;
  @NotNull
  private final ApolloActionData jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @Nullable
  private final String d;
  
  public CMSPanelAction(@NotNull ApolloActionData paramApolloActionData, @NotNull String paramString)
  {
    this(paramApolloActionData, paramString, null, true, -1);
  }
  
  public CMSPanelAction(@NotNull ApolloActionData paramApolloActionData, @NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean, int paramInt)
  {
    super(false, 0, 3, null);
    this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData = paramApolloActionData;
    this.c = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.actionId);
    paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData.actionName;
    Intrinsics.checkExpressionValueIsNotNull(paramApolloActionData, "actionData.actionName");
    this.b = paramApolloActionData;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSPanelAction.spriteTask.2(this));
  }
  
  @NotNull
  public final ApolloActionData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData;
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
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String e()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CMSPanelAction))
      {
        paramObject = (CMSPanelAction)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData, paramObject.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (a() == paramObject.a()) && (b() == paramObject.b())) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final String f()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CMSPanelAction(actionData=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloActionData);
    localStringBuilder.append(", selfUin=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", peerUin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", needRecord=");
    localStringBuilder.append(a());
    localStringBuilder.append(", playAmountTimes=");
    localStringBuilder.append(b());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.action.CMSPanelAction
 * JD-Core Version:    0.7.0.1
 */