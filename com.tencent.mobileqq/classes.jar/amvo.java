import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.action.CMSCommonAction.spriteTask.2;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/action/CMSCommonAction;", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "actionId", "", "actionType", "senderUin", "", "receiverUin", "extendJson", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "needRecord", "", "priority", "playAmountTimes", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZII)V", "id", "getId$AQQLiteApp_release", "()Ljava/lang/String;", "name", "getName$AQQLiteApp_release", "getNeedRecord", "()Z", "setNeedRecord", "(Z)V", "getPlayAmountTimes", "()I", "setPlayAmountTimes", "(I)V", "getPriority", "spriteTask", "Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "getSpriteTask$AQQLiteApp_release", "()Lcom/tencent/mobileqq/apollo/script/SpriteTaskParam;", "spriteTask$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amvo
  extends CMSAction
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Lazy jdField_a_of_type_KotlinLazy;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int;
  private final String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private final String jdField_d_of_type_JavaLangString;
  private final String e;
  
  public amvo(int paramInt1, int paramInt2, @NotNull String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    this(paramInt1, paramInt2, paramString1, paramString2, paramString3, true, 0, -1);
  }
  
  public amvo(int paramInt1, int paramInt2, @NotNull String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    super(false, 0, 0, 7, null);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.e = paramString3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new CMSCommonAction.spriteTask.2(this));
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
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
    return this.jdField_d_of_type_Int;
  }
  
  @NotNull
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof amvo))
      {
        paramObject = (amvo)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (!Intrinsics.areEqual(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.e, paramObject.e)) || (a() != paramObject.a()) || (a() != paramObject.a()) || (b() != paramObject.b())) {}
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
    return "CMSCommonAction(actionId=" + this.jdField_a_of_type_Int + ", actionType=" + this.jdField_b_of_type_Int + ", senderUin='" + this.jdField_c_of_type_JavaLangString + "', " + "receiverUin=" + this.jdField_d_of_type_JavaLangString + ", extendJson=" + this.e + ", needRecord=" + a() + ", " + "priority=" + a() + ", playAmountTimes=" + b() + ", id='" + a() + "', name='" + b() + "')";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvo
 * JD-Core Version:    0.7.0.1
 */