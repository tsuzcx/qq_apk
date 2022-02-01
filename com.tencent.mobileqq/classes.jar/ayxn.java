import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "", "lCurrentStyleId", "", "lCurrentBgId", "backgroundUrl", "", "backgroundColor", "dynamicCardFlag", "", "strZipUrl", "strActiveUrl", "strDrawerCardUrl", "strWzryHeroUrl", "wzryHonorInfo", "", "strExtInfo", "strCurrentBgUrl", "(JJLjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()J", "getBackgroundUrl", "()Ljava/lang/String;", "getDynamicCardFlag", "()I", "getLCurrentBgId", "getLCurrentStyleId", "getStrActiveUrl", "getStrCurrentBgUrl", "getStrDrawerCardUrl", "getStrExtInfo", "getStrWzryHeroUrl", "getStrZipUrl", "getWzryHonorInfo", "()[B", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayxn
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @Nullable
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final long jdField_b_of_type_Long;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private final long jdField_c_of_type_Long;
  @NotNull
  private final String jdField_c_of_type_JavaLangString;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @Nullable
  private final String f;
  @Nullable
  private final String g;
  
  public ayxn()
  {
    this(0L, 0L, null, 0L, 0, null, null, null, null, null, null, null, 4095, null);
  }
  
  public ayxn(long paramLong1, long paramLong2, @NotNull String paramString1, long paramLong3, int paramInt, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @Nullable byte[] paramArrayOfByte, @Nullable String paramString6, @Nullable String paramString7)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Long = paramLong3;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.f = paramString6;
    this.g = paramString7;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @NotNull
  public final String c()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ayxn))
      {
        paramObject = (ayxn)paramObject;
        if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (this.jdField_b_of_type_Long != paramObject.jdField_b_of_type_Long) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_c_of_type_Long != paramObject.jdField_c_of_type_Long) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.d, paramObject.d)) || (!Intrinsics.areEqual(this.e, paramObject.e)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ArrayOfByte, paramObject.jdField_a_of_type_ArrayOfByte)) || (!Intrinsics.areEqual(this.f, paramObject.f)) || (!Intrinsics.areEqual(this.g, paramObject.g))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i3 = 0;
    long l = this.jdField_a_of_type_Long;
    int i4 = (int)(l ^ l >>> 32);
    l = this.jdField_b_of_type_Long;
    int i5 = (int)(l ^ l >>> 32);
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    int i6;
    int i7;
    int j;
    label94:
    int k;
    label111:
    int m;
    label129:
    int n;
    label147:
    int i1;
    if (localObject != null)
    {
      i = localObject.hashCode();
      l = this.jdField_c_of_type_Long;
      i6 = (int)(l ^ l >>> 32);
      i7 = this.jdField_a_of_type_Int;
      localObject = this.jdField_b_of_type_JavaLangString;
      if (localObject == null) {
        break label272;
      }
      j = localObject.hashCode();
      localObject = this.jdField_c_of_type_JavaLangString;
      if (localObject == null) {
        break label277;
      }
      k = localObject.hashCode();
      localObject = this.d;
      if (localObject == null) {
        break label282;
      }
      m = localObject.hashCode();
      localObject = this.e;
      if (localObject == null) {
        break label288;
      }
      n = localObject.hashCode();
      localObject = this.jdField_a_of_type_ArrayOfByte;
      if (localObject == null) {
        break label294;
      }
      i1 = Arrays.hashCode((byte[])localObject);
      label165:
      localObject = this.f;
      if (localObject == null) {
        break label300;
      }
    }
    label272:
    label277:
    label282:
    label288:
    label294:
    label300:
    for (int i2 = localObject.hashCode();; i2 = 0)
    {
      localObject = this.g;
      if (localObject != null) {
        i3 = localObject.hashCode();
      }
      return (i2 + (i1 + (n + (m + (k + (j + (((i + (i4 * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      i = 0;
      break;
      j = 0;
      break label94;
      k = 0;
      break label111;
      m = 0;
      break label129;
      n = 0;
      break label147;
      i1 = 0;
      break label165;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "VasCardData(lCurrentStyleId=" + this.jdField_a_of_type_Long + ", lCurrentBgId=" + this.jdField_b_of_type_Long + ", backgroundUrl=" + this.jdField_a_of_type_JavaLangString + ", backgroundColor=" + this.jdField_c_of_type_Long + ", dynamicCardFlag=" + this.jdField_a_of_type_Int + ", strZipUrl=" + this.jdField_b_of_type_JavaLangString + ", strActiveUrl=" + this.jdField_c_of_type_JavaLangString + ", strDrawerCardUrl=" + this.d + ", strWzryHeroUrl=" + this.e + ", wzryHonorInfo=" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte) + ", strExtInfo=" + this.f + ", strCurrentBgUrl=" + this.g + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxn
 * JD-Core Version:    0.7.0.1
 */