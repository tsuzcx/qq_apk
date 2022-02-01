import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "", "urlPrefix", "", "titleStyle", "", "mainColor", "headerJson", "bodyJson", "Lorg/json/JSONObject;", "bgJson", "(Ljava/lang/String;IILjava/lang/Object;Lorg/json/JSONObject;Ljava/lang/Object;)V", "getBgJson", "()Ljava/lang/Object;", "getBodyJson", "()Lorg/json/JSONObject;", "getHeaderJson", "getMainColor", "()I", "getTitleStyle", "getUrlPrefix", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azph
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final Object jdField_a_of_type_JavaLangObject;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final Object jdField_b_of_type_JavaLangObject;
  
  public azph(@NotNull String paramString, int paramInt1, int paramInt2, @NotNull Object paramObject1, @NotNull JSONObject paramJSONObject, @NotNull Object paramObject2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramObject1;
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_b_of_type_JavaLangObject = paramObject2;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final Object b()
  {
    return this.jdField_b_of_type_JavaLangObject;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof azph))
      {
        paramObject = (azph)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangObject, paramObject.jdField_a_of_type_JavaLangObject)) || (!Intrinsics.areEqual(this.jdField_a_of_type_OrgJsonJSONObject, paramObject.jdField_a_of_type_OrgJsonJSONObject)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangObject, paramObject.jdField_b_of_type_JavaLangObject))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    int n;
    int i1;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      n = this.jdField_a_of_type_Int;
      i1 = this.jdField_b_of_type_Int;
      localObject = this.jdField_a_of_type_JavaLangObject;
      if (localObject == null) {
        break label119;
      }
      j = localObject.hashCode();
      label49:
      localObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localObject == null) {
        break label124;
      }
    }
    label119:
    label124:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_b_of_type_JavaLangObject;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + ((i * 31 + n) * 31 + i1) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label49;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "VasDiyData(urlPrefix=" + this.jdField_a_of_type_JavaLangString + ", titleStyle=" + this.jdField_a_of_type_Int + ", mainColor=" + this.jdField_b_of_type_Int + ", headerJson=" + this.jdField_a_of_type_JavaLangObject + ", bodyJson=" + this.jdField_a_of_type_OrgJsonJSONObject + ", bgJson=" + this.jdField_b_of_type_JavaLangObject + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azph
 * JD-Core Version:    0.7.0.1
 */