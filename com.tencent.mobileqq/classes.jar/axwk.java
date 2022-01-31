public class axwk
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoSliceInfo\n");
    localStringBuilder.append("mIndex=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",mVideoDuration=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",mEncodeFinish=").append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",mVideoPath(").append(this.jdField_c_of_type_Int + "*" + this.d).append(")=").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mVideoMd5=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",mSendClicked=").append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(",mVideoSyncStory=").append(this.jdField_c_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwk
 * JD-Core Version:    0.7.0.1
 */