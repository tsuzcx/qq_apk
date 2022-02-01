import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "", "mCurUseStyleId", "", "mCurUseTemplateVersion", "currentTemplate", "Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "cardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "diyData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "diyTextData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "(JJLcom/tencent/mobileqq/profile/ProfileCardTemplate;Lcom/tencent/mobileqq/profilecard/vas/VasCardData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;)V", "getCardData", "()Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "getCurrentTemplate", "()Lcom/tencent/mobileqq/profile/ProfileCardTemplate;", "getDiyData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "getDiyTextData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "getMCurUseStyleId", "()J", "getMCurUseTemplateVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bahz
{
  private final long jdField_a_of_type_Long;
  @Nullable
  private final azxy jdField_a_of_type_Azxy;
  @NotNull
  private final bahw jdField_a_of_type_Bahw;
  @Nullable
  private final bahx jdField_a_of_type_Bahx;
  @NotNull
  private final bahy jdField_a_of_type_Bahy;
  private final long b;
  
  public bahz()
  {
    this(0L, 0L, null, null, null, null, 63, null);
  }
  
  public bahz(long paramLong1, long paramLong2, @Nullable azxy paramazxy, @NotNull bahw parambahw, @Nullable bahx parambahx, @NotNull bahy parambahy)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Azxy = paramazxy;
    this.jdField_a_of_type_Bahw = parambahw;
    this.jdField_a_of_type_Bahx = parambahx;
    this.jdField_a_of_type_Bahy = parambahy;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final azxy a()
  {
    return this.jdField_a_of_type_Azxy;
  }
  
  @NotNull
  public final bahw a()
  {
    return this.jdField_a_of_type_Bahw;
  }
  
  @Nullable
  public final bahx a()
  {
    return this.jdField_a_of_type_Bahx;
  }
  
  @NotNull
  public final bahy a()
  {
    return this.jdField_a_of_type_Bahy;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof bahz))
      {
        paramObject = (bahz)paramObject;
        if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.b != paramObject.b) || (!Intrinsics.areEqual(this.jdField_a_of_type_Azxy, paramObject.jdField_a_of_type_Azxy)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Bahw, paramObject.jdField_a_of_type_Bahw)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Bahx, paramObject.jdField_a_of_type_Bahx)) || (!Intrinsics.areEqual(this.jdField_a_of_type_Bahy, paramObject.jdField_a_of_type_Bahy))) {}
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
    Object localObject = this.jdField_a_of_type_Azxy;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_Bahw;
      if (localObject == null) {
        break label141;
      }
      j = localObject.hashCode();
      label71:
      localObject = this.jdField_a_of_type_Bahx;
      if (localObject == null) {
        break label146;
      }
    }
    label141:
    label146:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_Bahy;
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
    return "VasProfileData(mCurUseStyleId=" + this.jdField_a_of_type_Long + ", mCurUseTemplateVersion=" + this.b + ", currentTemplate=" + this.jdField_a_of_type_Azxy + ", cardData=" + this.jdField_a_of_type_Bahw + ", diyData=" + this.jdField_a_of_type_Bahx + ", diyTextData=" + this.jdField_a_of_type_Bahy + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahz
 * JD-Core Version:    0.7.0.1
 */