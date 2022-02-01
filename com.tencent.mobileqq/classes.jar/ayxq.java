import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "", "mCurUseStyleId", "", "mCurUseTemplateVersion", "currentTemplate", "Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "cardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "diyData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "diyTextData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "(JJLcom/tencent/mobileqq/profile/ProfileCardTemplate;Lcom/tencent/mobileqq/profilecard/vas/VasCardData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;)V", "getCardData", "()Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "getCurrentTemplate", "()Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "getDiyData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "getDiyTextData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "getMCurUseStyleId", "()J", "getMCurUseTemplateVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayxq
{
  private final long jdField_a_of_type_Long;
  @Nullable
  private final aymn jdField_a_of_type_Aymn;
  @NotNull
  private final ayxn jdField_a_of_type_Ayxn;
  @Nullable
  private final ayxo jdField_a_of_type_Ayxo;
  @NotNull
  private final ayxp jdField_a_of_type_Ayxp;
  private final long b;
  
  public ayxq()
  {
    this(0L, 0L, null, null, null, null, 63, null);
  }
  
  public ayxq(long paramLong1, long paramLong2, @Nullable aymn paramaymn, @NotNull ayxn paramayxn, @Nullable ayxo paramayxo, @NotNull ayxp paramayxp)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Aymn = paramaymn;
    this.jdField_a_of_type_Ayxn = paramayxn;
    this.jdField_a_of_type_Ayxo = paramayxo;
    this.jdField_a_of_type_Ayxp = paramayxp;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final aymn a()
  {
    return this.jdField_a_of_type_Aymn;
  }
  
  @NotNull
  public final ayxn a()
  {
    return this.jdField_a_of_type_Ayxn;
  }
  
  @Nullable
  public final ayxo a()
  {
    return this.jdField_a_of_type_Ayxo;
  }
  
  @NotNull
  public final ayxp a()
  {
    return this.jdField_a_of_type_Ayxp;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ayxq))
      {
        paramObject = (ayxq)paramObject;
        if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.b != paramObject.b) || (!Intrinsics.areEqual(this.jdField_a_of_type_Aymn, paramObject.jdField_a_of_type_Aymn)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Ayxn, paramObject.jdField_a_of_type_Ayxn)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Ayxo, paramObject.jdField_a_of_type_Ayxo)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Ayxp, paramObject.jdField_a_of_type_Ayxp))) {}
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
    Object localObject = this.jdField_a_of_type_Aymn;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_Ayxn;
      if (localObject == null) {
        break label141;
      }
      j = localObject.hashCode();
      label71:
      localObject = this.jdField_a_of_type_Ayxo;
      if (localObject == null) {
        break label146;
      }
    }
    label141:
    label146:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_Ayxp;
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
    return "VasProfileData(mCurUseStyleId=" + this.jdField_a_of_type_Long + ", mCurUseTemplateVersion=" + this.b + ", currentTemplate=" + this.jdField_a_of_type_Aymn + ", cardData=" + this.jdField_a_of_type_Ayxn + ", diyData=" + this.jdField_a_of_type_Ayxo + ", diyTextData=" + this.jdField_a_of_type_Ayxp + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxq
 * JD-Core Version:    0.7.0.1
 */