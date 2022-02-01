import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "", "diyText", "", "diyTextFontId", "", "diyTextWidth", "", "diyTextHeight", "diyTextLocX", "diyTextLocY", "diyTextDegree", "diyTextScale", "diyTextTransparency", "diyDefaultText", "(Ljava/lang/String;IFFFFFFFLjava/lang/String;)V", "getDiyDefaultText", "()Ljava/lang/String;", "getDiyText", "getDiyTextDegree", "()F", "getDiyTextFontId", "()I", "getDiyTextHeight", "getDiyTextLocX", "getDiyTextLocY", "getDiyTextScale", "getDiyTextTransparency", "getDiyTextWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bada
{
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  private final float jdField_b_of_type_Float;
  @Nullable
  private final String jdField_b_of_type_JavaLangString;
  private final float c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  
  public bada()
  {
    this(null, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, null, 1023, null);
  }
  
  public bada(@Nullable String paramString1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, @Nullable String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.c = paramFloat3;
    this.d = paramFloat4;
    this.e = paramFloat5;
    this.f = paramFloat6;
    this.g = paramFloat7;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public final float a()
  {
    return this.c;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final float b()
  {
    return this.d;
  }
  
  public final float c()
  {
    return this.e;
  }
  
  public final float d()
  {
    return this.f;
  }
  
  public final float e()
  {
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof bada))
      {
        paramObject = (bada)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (Float.compare(this.jdField_a_of_type_Float, paramObject.jdField_a_of_type_Float) != 0) || (Float.compare(this.jdField_b_of_type_Float, paramObject.jdField_b_of_type_Float) != 0) || (Float.compare(this.c, paramObject.c) != 0) || (Float.compare(this.d, paramObject.d) != 0) || (Float.compare(this.e, paramObject.e) != 0) || (Float.compare(this.f, paramObject.f) != 0) || (Float.compare(this.g, paramObject.g) != 0) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      int k = this.jdField_a_of_type_Int;
      int m = Float.floatToIntBits(this.jdField_a_of_type_Float);
      int n = Float.floatToIntBits(this.jdField_b_of_type_Float);
      int i1 = Float.floatToIntBits(this.c);
      int i2 = Float.floatToIntBits(this.d);
      int i3 = Float.floatToIntBits(this.e);
      int i4 = Float.floatToIntBits(this.f);
      int i5 = Float.floatToIntBits(this.g);
      str = this.jdField_b_of_type_JavaLangString;
      if (str != null) {
        j = str.hashCode();
      }
      return ((((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "VasDiyTextData(diyText=" + this.jdField_a_of_type_JavaLangString + ", diyTextFontId=" + this.jdField_a_of_type_Int + ", diyTextWidth=" + this.jdField_a_of_type_Float + ", diyTextHeight=" + this.jdField_b_of_type_Float + ", diyTextLocX=" + this.c + ", diyTextLocY=" + this.d + ", diyTextDegree=" + this.e + ", diyTextScale=" + this.f + ", diyTextTransparency=" + this.g + ", diyDefaultText=" + this.jdField_b_of_type_JavaLangString + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bada
 * JD-Core Version:    0.7.0.1
 */