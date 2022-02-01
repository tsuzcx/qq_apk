import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "", "event", "", "jsFunction", "", "jsParams", "bgUrl", "arkLoadState", "arkHeight", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getArkHeight", "()I", "getArkLoadState", "getBgUrl", "()Ljava/lang/String;", "getEvent", "getJsFunction", "getJsParams", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class amfe
{
  public static final amff a;
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int;
  @NotNull
  private final String jdField_c_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Amff = new amff(null);
  }
  
  public amfe(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @NotNull
  public final String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof amfe))
      {
        paramObject = (amfe)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (this.jdField_c_of_type_Int != paramObject.jdField_c_of_type_Int)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = this.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.jdField_b_of_type_JavaLangString;
      if (str == null) {
        break label98;
      }
    }
    label98:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.jdField_c_of_type_JavaLangString;
      if (str != null) {
        k = str.hashCode();
      }
      return (((j + (i + m * 31) * 31) * 31 + k) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_c_of_type_Int;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "WebPageData(event=" + this.jdField_a_of_type_Int + ", jsFunction=" + this.jdField_a_of_type_JavaLangString + ", jsParams=" + this.jdField_b_of_type_JavaLangString + ", bgUrl=" + this.jdField_c_of_type_JavaLangString + ", arkLoadState=" + this.jdField_b_of_type_Int + ", arkHeight=" + this.jdField_c_of_type_Int + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfe
 * JD-Core Version:    0.7.0.1
 */