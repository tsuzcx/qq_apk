public class bfbw
{
  public int c = -1;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public String g;
  public String h;
  
  public bfbw()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" errStr:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" reason:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" succCnt:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" failCnt");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" isSendByQuickHttp");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(" isAllowRetry");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbw
 * JD-Core Version:    0.7.0.1
 */