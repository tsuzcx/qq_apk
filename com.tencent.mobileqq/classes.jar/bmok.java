import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/reward/VasRewardAdParams;", "", "advPos", "", "rewardType", "rewardItem", "", "rewardText", "uin", "", "gdtBizId", "bizSrcId", "(IILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAdvPos", "()I", "getBizSrcId", "()Ljava/lang/String;", "getGdtBizId", "getRewardItem", "getRewardText", "getRewardType", "getUin", "()J", "Builder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmok
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int jdField_b_of_type_Int;
  @Nullable
  private final String jdField_b_of_type_JavaLangString;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  
  private bmok(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
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
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public final String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmok
 * JD-Core Version:    0.7.0.1
 */