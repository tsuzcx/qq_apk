import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/reward/VasRewardAdParams$Builder;", "", "advPos", "", "rewardType", "rewardItem", "", "rewardText", "uin", "", "gdtBizId", "bizSrcId", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "build", "Lcooperation/vip/reward/VasRewardAdParams;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "()Ljava/lang/Long;", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcooperation/vip/reward/VasRewardAdParams$Builder;", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmol
{
  private Integer jdField_a_of_type_JavaLangInteger;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private Integer jdField_b_of_type_JavaLangInteger;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  public bmol()
  {
    this(null, null, null, null, null, null, null, 127, null);
  }
  
  public bmol(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable String paramString1, @Nullable String paramString2, @Nullable Long paramLong, @Nullable String paramString3, @Nullable String paramString4)
  {
    this.jdField_a_of_type_JavaLangInteger = paramInteger1;
    this.jdField_b_of_type_JavaLangInteger = paramInteger2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  @NotNull
  public final bmok a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangInteger;
    int i;
    int j;
    String str2;
    String str3;
    long l;
    label79:
    String str1;
    if (localObject != null)
    {
      i = ((Integer)localObject).intValue();
      localObject = this.jdField_b_of_type_JavaLangInteger;
      if (localObject == null) {
        break label123;
      }
      j = ((Integer)localObject).intValue();
      str2 = this.jdField_a_of_type_JavaLangString;
      if (str2 == null) {
        break label136;
      }
      str3 = this.jdField_b_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_JavaLangLong;
      if (localObject == null) {
        break label149;
      }
      l = ((Long)localObject).longValue();
      localObject = this.c;
      if (localObject == null) {
        break label162;
      }
      str1 = this.d;
      if (str1 == null) {
        break label176;
      }
    }
    for (;;)
    {
      return new bmok(i, j, str2, str3, l, (String)localObject, str1, null);
      throw ((Throwable)new IllegalArgumentException("advPos cant be null"));
      label123:
      throw ((Throwable)new IllegalArgumentException("rewardType cant be null"));
      label136:
      throw ((Throwable)new IllegalArgumentException("rewardItem cant be null"));
      label149:
      l = bmkk.a.a().a();
      break;
      label162:
      localObject = bmkk.a.a().a();
      break label79;
      label176:
      str1 = "biz_src_jc_vip";
    }
  }
  
  @NotNull
  public final bmol a(int paramInt)
  {
    ((bmol)this).jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (bmol)this;
  }
  
  @NotNull
  public final bmol a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rewardItem");
    ((bmol)this).jdField_a_of_type_JavaLangString = paramString;
    return (bmol)this;
  }
  
  @NotNull
  public final bmol b(int paramInt)
  {
    ((bmol)this).jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt);
    return (bmol)this;
  }
  
  @NotNull
  public final bmol b(@Nullable String paramString)
  {
    ((bmol)this).jdField_b_of_type_JavaLangString = paramString;
    return (bmol)this;
  }
  
  @NotNull
  public final bmol c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    ((bmol)this).c = paramString;
    return (bmol)this;
  }
  
  @NotNull
  public final bmol d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bizSrcId");
    ((bmol)this).d = paramString;
    return (bmol)this;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof bmol))
      {
        paramObject = (bmol)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangInteger, paramObject.jdField_a_of_type_JavaLangInteger)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangInteger, paramObject.jdField_b_of_type_JavaLangInteger)) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangLong, paramObject.jdField_a_of_type_JavaLangLong)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (!Intrinsics.areEqual(this.d, paramObject.d))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i2 = 0;
    Object localObject = this.jdField_a_of_type_JavaLangInteger;
    int i;
    int j;
    label37:
    int k;
    label54:
    int m;
    label72:
    int n;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_b_of_type_JavaLangInteger;
      if (localObject == null) {
        break label167;
      }
      j = localObject.hashCode();
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject == null) {
        break label172;
      }
      k = localObject.hashCode();
      localObject = this.jdField_b_of_type_JavaLangString;
      if (localObject == null) {
        break label177;
      }
      m = localObject.hashCode();
      localObject = this.jdField_a_of_type_JavaLangLong;
      if (localObject == null) {
        break label183;
      }
      n = localObject.hashCode();
      label90:
      localObject = this.c;
      if (localObject == null) {
        break label189;
      }
    }
    label167:
    label172:
    label177:
    label183:
    label189:
    for (int i1 = localObject.hashCode();; i1 = 0)
    {
      localObject = this.d;
      if (localObject != null) {
        i2 = localObject.hashCode();
      }
      return (i1 + (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label37;
      k = 0;
      break label54;
      m = 0;
      break label72;
      n = 0;
      break label90;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "Builder(advPos=" + this.jdField_a_of_type_JavaLangInteger + ", rewardType=" + this.jdField_b_of_type_JavaLangInteger + ", rewardItem=" + this.jdField_a_of_type_JavaLangString + ", rewardText=" + this.jdField_b_of_type_JavaLangString + ", uin=" + this.jdField_a_of_type_JavaLangLong + ", gdtBizId=" + this.c + ", bizSrcId=" + this.d + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmol
 * JD-Core Version:    0.7.0.1
 */