import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSPanelAction.spriteTask.2;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.data.ApolloActionData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/action/CMSPanelAction;", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "apolloActionData", "Lcom/tencent/mobileqq/data/ApolloActionData;", "selfUin", "", "(Lcom/tencent/mobileqq/data/ApolloActionData;Ljava/lang/String;)V", "peerUin", "(Lcom/tencent/mobileqq/data/ApolloActionData;Ljava/lang/String;Ljava/lang/String;)V", "actionData", "needRecord", "", "priority", "", "playAmountTimes", "(Lcom/tencent/mobileqq/data/ApolloActionData;Ljava/lang/String;Ljava/lang/String;ZII)V", "getActionData", "()Lcom/tencent/mobileqq/data/ApolloActionData;", "id", "getId$AQQLiteApp_release", "()Ljava/lang/String;", "name", "getName$AQQLiteApp_release", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPeerUin", "getPlayAmountTimes", "()I", "setPlayAmountTimes", "(I)V", "getPriority", "getSelfUin", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask$AQQLiteApp_release", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "spriteTask$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvp
  extends CMSAction
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final ApolloActionData jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  @NotNull
  private final String c;
  @Nullable
  private final String d;
  
  public amvp(@NotNull ApolloActionData paramApolloActionData, @NotNull String paramString)
  {
    this(paramApolloActionData, paramString, null, true, 0, -1);
  }
  
  public amvp(@NotNull ApolloActionData paramApolloActionData, @NotNull String paramString1, @Nullable String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(false, 0, 0, 7, null);
    this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData = paramApolloActionData;
    this.c = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId);
    paramApolloActionData = this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionName;
    Intrinsics.checkExpressionValueIsNotNull(paramApolloActionData, "actionData.actionName");
    this.jdField_b_of_type_JavaLangString = paramApolloActionData;
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSPanelAction.spriteTask.2(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public SpriteTaskParam a()
  {
    return (SpriteTaskParam)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  @NotNull
  public final ApolloActionData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
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
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @NotNull
  public final String e()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof amvp))
      {
        paramObject = (amvp)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, paramObject.jdField_a_of_type_ComTencentMobileqqDataApolloActionData)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (!Intrinsics.areEqual(this.d, paramObject.d)) || (a() != paramObject.a()) || (a() != paramObject.a()) || (b() != paramObject.b())) {}
      }
    }
    else {
      return true;
    }
    return false;
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
    return "CMSPanelAction(actionData=" + this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData + ", selfUin=" + this.c + ", peerUin=" + this.d + ", needRecord=" + a() + ", priority=" + a() + ", playAmountTimes=" + b() + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvp
 * JD-Core Version:    0.7.0.1
 */