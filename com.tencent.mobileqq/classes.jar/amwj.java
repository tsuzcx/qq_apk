public class amwj
  extends amvl
{
  public amzd a;
  public anff a;
  public boolean a;
  public long b;
  public String b;
  public int d;
  public int e = 1;
  
  public amwj(String paramString1, int paramInt1, int paramInt2, int paramInt3, anff paramanff, amzd paramamzd, String paramString2, long paramLong, boolean paramBoolean, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt5, paramFloat1, paramFloat2, paramFloat3);
    this.d = paramInt3;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.e = paramInt4;
    this.jdField_a_of_type_Anff = paramanff;
    this.jdField_a_of_type_Amzd = paramamzd;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("OnlineVideoARRenderableInfo{");
    localStringBuilder.append("key=").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", arType=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", trackMode=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mRealRenderType=").append(this.d);
    localStringBuilder.append(", mKeyingParams='").append(this.jdField_a_of_type_Anff).append('\'');
    localStringBuilder.append(", mVideoUrl='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", mVideoSize='").append(this.jdField_b_of_type_Long).append('\'');
    localStringBuilder.append(", mLayout='").append(this.jdField_a_of_type_Amzd).append('\'');
    localStringBuilder.append(", isSoftPlay='").append(this.jdField_a_of_type_Boolean).append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwj
 * JD-Core Version:    0.7.0.1
 */