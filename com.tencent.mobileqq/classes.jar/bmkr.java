import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasGdtService$GdtParams;", "", "uin", "", "posIdList", "", "", "count", "", "deepLinkVersion", "publicId", "articleId", "tribeTag", "tribeIdTag", "sourceFrom", "shareRate", "cookie", "(JLjava/util/Set;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getArticleId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCookie", "()Ljava/lang/String;", "getCount", "()I", "getDeepLinkVersion", "getPosIdList", "()Ljava/util/Set;", "getPublicId", "getShareRate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSourceFrom", "getTribeIdTag", "getTribeTag", "getUin", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/util/Set;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcooperation/vip/VasGdtService$GdtParams;", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmkr
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @Nullable
  private final Integer jdField_a_of_type_JavaLangInteger;
  @Nullable
  private final Long jdField_a_of_type_JavaLangLong;
  @Nullable
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final Set<String> jdField_a_of_type_JavaUtilSet;
  private final int jdField_b_of_type_Int;
  @Nullable
  private final Integer jdField_b_of_type_JavaLangInteger;
  @Nullable
  private final Long jdField_b_of_type_JavaLangLong;
  @Nullable
  private final Integer c;
  @Nullable
  private final Integer d;
  
  public bmkr(long paramLong, @NotNull Set<String> paramSet, int paramInt1, int paramInt2, @Nullable Long paramLong1, @Nullable Long paramLong2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2, @Nullable Integer paramInteger3, @Nullable Integer paramInteger4, @Nullable String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangLong = paramLong1;
    this.jdField_b_of_type_JavaLangLong = paramLong2;
    this.jdField_a_of_type_JavaLangInteger = paramInteger1;
    this.jdField_b_of_type_JavaLangInteger = paramInteger2;
    this.c = paramInteger3;
    this.d = paramInteger4;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final Integer a()
  {
    return this.jdField_b_of_type_JavaLangInteger;
  }
  
  @Nullable
  public final Long a()
  {
    return this.jdField_a_of_type_JavaLangLong;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final Set<String> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public final Integer b()
  {
    return this.c;
  }
  
  @Nullable
  public final Long b()
  {
    return this.jdField_b_of_type_JavaLangLong;
  }
  
  @Nullable
  public final Integer c()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof bmkr))
      {
        paramObject = (bmkr)paramObject;
        if ((this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaUtilSet, paramObject.jdField_a_of_type_JavaUtilSet)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangLong, paramObject.jdField_a_of_type_JavaLangLong)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangLong, paramObject.jdField_b_of_type_JavaLangLong)) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangInteger, paramObject.jdField_a_of_type_JavaLangInteger)) || (!Intrinsics.areEqual(this.jdField_b_of_type_JavaLangInteger, paramObject.jdField_b_of_type_JavaLangInteger)) || (!Intrinsics.areEqual(this.c, paramObject.c)) || (!Intrinsics.areEqual(this.d, paramObject.d)) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString))) {}
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
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    int i;
    int i5;
    int i6;
    int j;
    label66:
    int k;
    label83:
    int m;
    label101:
    int n;
    label119:
    int i1;
    if (localObject != null)
    {
      i = localObject.hashCode();
      i5 = this.jdField_a_of_type_Int;
      i6 = this.jdField_b_of_type_Int;
      localObject = this.jdField_a_of_type_JavaLangLong;
      if (localObject == null) {
        break label238;
      }
      j = localObject.hashCode();
      localObject = this.jdField_b_of_type_JavaLangLong;
      if (localObject == null) {
        break label243;
      }
      k = localObject.hashCode();
      localObject = this.jdField_a_of_type_JavaLangInteger;
      if (localObject == null) {
        break label248;
      }
      m = localObject.hashCode();
      localObject = this.jdField_b_of_type_JavaLangInteger;
      if (localObject == null) {
        break label254;
      }
      n = localObject.hashCode();
      localObject = this.c;
      if (localObject == null) {
        break label260;
      }
      i1 = localObject.hashCode();
      label137:
      localObject = this.d;
      if (localObject == null) {
        break label266;
      }
    }
    label260:
    label266:
    for (int i2 = localObject.hashCode();; i2 = 0)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null) {
        i3 = localObject.hashCode();
      }
      return (i2 + (i1 + (n + (m + (k + (j + (((i + i4 * 31) * 31 + i5) * 31 + i6) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i3;
      i = 0;
      break;
      label238:
      j = 0;
      break label66;
      label243:
      k = 0;
      break label83;
      label248:
      m = 0;
      break label101;
      label254:
      n = 0;
      break label119;
      i1 = 0;
      break label137;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "GdtParams(uin=" + this.jdField_a_of_type_Long + ", posIdList=" + this.jdField_a_of_type_JavaUtilSet + ", count=" + this.jdField_a_of_type_Int + ", deepLinkVersion=" + this.jdField_b_of_type_Int + ", publicId=" + this.jdField_a_of_type_JavaLangLong + ", articleId=" + this.jdField_b_of_type_JavaLangLong + ", tribeTag=" + this.jdField_a_of_type_JavaLangInteger + ", tribeIdTag=" + this.jdField_b_of_type_JavaLangInteger + ", sourceFrom=" + this.c + ", shareRate=" + this.d + ", cookie=" + this.jdField_a_of_type_JavaLangString + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkr
 * JD-Core Version:    0.7.0.1
 */