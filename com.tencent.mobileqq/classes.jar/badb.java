import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "", "mCurUseStyleId", "", "mCurUseTemplateVersion", "currentTemplate", "Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "cardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "diyData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "diyTextData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "(JJLcom/tencent/mobileqq/profile/ProfileCardTemplate;Lcom/tencent/mobileqq/profilecard/vas/VasCardData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;)V", "getCardData", "()Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "getCurrentTemplate", "()Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "getDiyData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "getDiyTextData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "getMCurUseStyleId", "()J", "getMCurUseTemplateVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class badb
{
  private final long jdField_a_of_type_Long;
  @Nullable
  private final azri jdField_a_of_type_Azri;
  @NotNull
  private final bacy jdField_a_of_type_Bacy;
  @Nullable
  private final bacz jdField_a_of_type_Bacz;
  @NotNull
  private final bada jdField_a_of_type_Bada;
  private final long b;
  
  public badb()
  {
    this(0L, 0L, null, null, null, null, 63, null);
  }
  
  public badb(long paramLong1, long paramLong2, @Nullable azri paramazri, @NotNull bacy parambacy, @Nullable bacz parambacz, @NotNull bada parambada)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Azri = paramazri;
    this.jdField_a_of_type_Bacy = parambacy;
    this.jdField_a_of_type_Bacz = parambacz;
    this.jdField_a_of_type_Bada = parambada;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final azri a()
  {
    return this.jdField_a_of_type_Azri;
  }
  
  @NotNull
  public final bacy a()
  {
    return this.jdField_a_of_type_Bacy;
  }
  
  @Nullable
  public final bacz a()
  {
    return this.jdField_a_of_type_Bacz;
  }
  
  @NotNull
  public final bada a()
  {
    return this.jdField_a_of_type_Bada;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof badb))
      {
        paramObject = (badb)paramObject;
        if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.b != paramObject.b) || (!Intrinsics.areEqual(this.jdField_a_of_type_Azri, paramObject.jdField_a_of_type_Azri)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Bacy, paramObject.jdField_a_of_type_Bacy)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Bacz, paramObject.jdField_a_of_type_Bacz)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Bada, paramObject.jdField_a_of_type_Bada))) {}
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
    Object localObject = this.jdField_a_of_type_Azri;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_Bacy;
      if (localObject == null) {
        break label141;
      }
      j = localObject.hashCode();
      label71:
      localObject = this.jdField_a_of_type_Bacz;
      if (localObject == null) {
        break label146;
      }
    }
    label141:
    label146:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_Bada;
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
    return "VasProfileData(mCurUseStyleId=" + this.jdField_a_of_type_Long + ", mCurUseTemplateVersion=" + this.b + ", currentTemplate=" + this.jdField_a_of_type_Azri + ", cardData=" + this.jdField_a_of_type_Bacy + ", diyData=" + this.jdField_a_of_type_Bacz + ", diyTextData=" + this.jdField_a_of_type_Bada + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badb
 * JD-Core Version:    0.7.0.1
 */