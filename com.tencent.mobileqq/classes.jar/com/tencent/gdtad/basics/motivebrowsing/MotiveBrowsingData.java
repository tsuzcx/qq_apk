package com.tencent.gdtad.basics.motivebrowsing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;", "", "event", "", "script", "", "leftSecond", "(ILjava/lang/String;I)V", "getEvent", "()I", "getLeftSecond", "getScript", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class MotiveBrowsingData
{
  public static final MotiveBrowsingData.Companion a;
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int b;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingMotiveBrowsingData$Companion = new MotiveBrowsingData.Companion(null);
  }
  
  public MotiveBrowsingData(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
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
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof MotiveBrowsingData))
      {
        paramObject = (MotiveBrowsingData)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (this.b == paramObject.b)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + i) * 31 + this.b;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MotiveBrowsingData(event=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", script=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", leftSecond=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.MotiveBrowsingData
 * JD-Core Version:    0.7.0.1
 */