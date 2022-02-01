import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "", "mCurUseStyleId", "", "mCurUseTemplateVersion", "currentTemplate", "Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "cardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "diyData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "diyTextData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "(JJLcom/tencent/mobileqq/profile/ProfileCardTemplate;Lcom/tencent/mobileqq/profilecard/vas/VasCardData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;)V", "getCardData", "()Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "getCurrentTemplate", "()Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "getDiyData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "getDiyTextData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "getMCurUseStyleId", "()J", "getMCurUseTemplateVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azpj
{
  private final long jdField_a_of_type_Long;
  @Nullable
  private final azfl jdField_a_of_type_Azfl;
  @NotNull
  private final azpg jdField_a_of_type_Azpg;
  @Nullable
  private final azph jdField_a_of_type_Azph;
  @NotNull
  private final azpi jdField_a_of_type_Azpi;
  private final long b;
  
  public azpj()
  {
    this(0L, 0L, null, null, null, null, 63, null);
  }
  
  public azpj(long paramLong1, long paramLong2, @Nullable azfl paramazfl, @NotNull azpg paramazpg, @Nullable azph paramazph, @NotNull azpi paramazpi)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Azfl = paramazfl;
    this.jdField_a_of_type_Azpg = paramazpg;
    this.jdField_a_of_type_Azph = paramazph;
    this.jdField_a_of_type_Azpi = paramazpi;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final azfl a()
  {
    return this.jdField_a_of_type_Azfl;
  }
  
  @NotNull
  public final azpg a()
  {
    return this.jdField_a_of_type_Azpg;
  }
  
  @Nullable
  public final azph a()
  {
    return this.jdField_a_of_type_Azph;
  }
  
  @NotNull
  public final azpi a()
  {
    return this.jdField_a_of_type_Azpi;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof azpj))
      {
        paramObject = (azpj)paramObject;
        if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.b != paramObject.b) || (!Intrinsics.areEqual(this.jdField_a_of_type_Azfl, paramObject.jdField_a_of_type_Azfl)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Azpg, paramObject.jdField_a_of_type_Azpg)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Azph, paramObject.jdField_a_of_type_Azph)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Azpi, paramObject.jdField_a_of_type_Azpi))) {}
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
    long l = this.jdField_a_of_type_Long;
    int n = (int)(l ^ l >>> 32);
    l = this.b;
    int i1 = (int)(l ^ l >>> 32);
    Object localObject = this.jdField_a_of_type_Azfl;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_Azpg;
      if (localObject == null) {
        break label141;
      }
      j = localObject.hashCode();
      label71:
      localObject = this.jdField_a_of_type_Azph;
      if (localObject == null) {
        break label146;
      }
    }
    label141:
    label146:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_Azpi;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + (i + (n * 31 + i1) * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label71;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "VasProfileData(mCurUseStyleId=" + this.jdField_a_of_type_Long + ", mCurUseTemplateVersion=" + this.b + ", currentTemplate=" + this.jdField_a_of_type_Azfl + ", cardData=" + this.jdField_a_of_type_Azpg + ", diyData=" + this.jdField_a_of_type_Azph + ", diyTextData=" + this.jdField_a_of_type_Azpi + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpj
 * JD-Core Version:    0.7.0.1
 */