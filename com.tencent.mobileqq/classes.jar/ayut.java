import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "", "()V", "mainBusinessId", "", "subBusinessId", "pushId", "notifyId", "title", "", "iconUrl", "contentText", "jumpScheme", "isUrlJump", "", "isRevokePush", "needForegroundPush", "needBackgroundPush", "bytesExtData", "", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ[B)V", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "notifyIdValid", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayut
{
  @JvmField
  public int a;
  @JvmField
  @NotNull
  public String a;
  @JvmField
  public boolean a;
  @JvmField
  @NotNull
  public byte[] a;
  @JvmField
  public int b;
  @JvmField
  @NotNull
  public String b;
  @JvmField
  public boolean b;
  @JvmField
  public int c;
  @JvmField
  @NotNull
  public String c;
  @JvmField
  public boolean c;
  @JvmField
  public int d;
  @JvmField
  @NotNull
  public String d;
  @JvmField
  public boolean d;
  
  public ayut()
  {
    this(0, 0, 0, 0, null, null, null, null, false, false, false, false, null, 8190, null);
  }
  
  public ayut(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @NotNull byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_d_of_type_Boolean = paramBoolean4;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public final boolean a()
  {
    int i = this.jdField_d_of_type_Int;
    if (528 > i) {}
    while (3000528 < i) {
      return false;
    }
    return true;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ayut))
      {
        paramObject = (ayut)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (this.jdField_c_of_type_Int != paramObject.jdField_c_of_type_Int) || (this.jdField_d_of_type_Int != paramObject.jdField_d_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_d_of_type_JavaLangString, paramObject.jdField_d_of_type_JavaLangString)) || (this.jdField_a_of_type_Boolean != paramObject.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean != paramObject.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean != paramObject.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean != paramObject.jdField_d_of_type_Boolean) || (!Intrinsics.areEqual(this.jdField_a_of_type_ArrayOfByte, paramObject.jdField_a_of_type_ArrayOfByte))) {}
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
    return "PushComponent(mainBusinessId=" + this.jdField_a_of_type_Int + ", subBusinessId=" + this.jdField_b_of_type_Int + ", pushId=" + this.jdField_c_of_type_Int + ", notifyId=" + this.jdField_d_of_type_Int + ", title=" + this.jdField_a_of_type_JavaLangString + ", iconUrl=" + this.jdField_b_of_type_JavaLangString + ", contentText=" + this.jdField_c_of_type_JavaLangString + ", jumpScheme=" + this.jdField_d_of_type_JavaLangString + ", isUrlJump=" + this.jdField_a_of_type_Boolean + ", isRevokePush=" + this.jdField_b_of_type_Boolean + ", needForegroundPush=" + this.jdField_c_of_type_Boolean + ", needBackgroundPush=" + this.jdField_d_of_type_Boolean + ", bytesExtData=" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte) + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayut
 * JD-Core Version:    0.7.0.1
 */