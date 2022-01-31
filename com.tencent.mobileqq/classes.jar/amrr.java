public class amrr
  extends amqw
{
  public amuo a;
  public anaw a;
  public String b;
  public int d;
  public int e = 1;
  
  public amrr(String paramString1, int paramInt1, int paramInt2, int paramInt3, anaw paramanaw, amuo paramamuo, String paramString2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt5, paramFloat1, paramFloat2, paramFloat3);
    this.d = paramInt3;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.e = paramInt4;
    this.jdField_a_of_type_Anaw = paramanaw;
    this.jdField_a_of_type_Amuo = paramamuo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("NormalVideoARResourceInfo{");
    localStringBuilder.append("key=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", arType=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mRealRenderType=").append(this.d);
    localStringBuilder.append(", mKeyingParams='").append(this.jdField_a_of_type_Anaw).append('\'');
    localStringBuilder.append(", mVideoPath='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", mLayout='").append(this.jdField_a_of_type_Amuo).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrr
 * JD-Core Version:    0.7.0.1
 */