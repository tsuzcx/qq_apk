public class ausg
{
  public int a;
  public long a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mTinyID:").append(this.jdField_a_of_type_Long).append(",mPosition:").append(this.jdField_a_of_type_Int).append(",mAlgotithmID:").append(this.b).append(",mEnterCount:").append(this.c).append(",mProfileCardDuration:").append(this.d).append(",mVisitPhotoCount:").append(this.e).append(",mOpflag:").append(this.f).append("|").append(Integer.toBinaryString(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausg
 * JD-Core Version:    0.7.0.1
 */