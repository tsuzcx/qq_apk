public class anpf
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public anpf()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{SenderUin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    localStringBuilder.append("{SenderNickName: ").append(this.jdField_b_of_type_JavaLangString).append("}");
    localStringBuilder.append("{bEnter: ").append(this.jdField_a_of_type_Boolean).append("}");
    localStringBuilder.append("{leaveChatType: ").append(this.jdField_a_of_type_Int).append("}");
    localStringBuilder.append("{leftChatTime: ").append(this.jdField_b_of_type_Int).append("}");
    localStringBuilder.append("{timeStamp: ").append(this.jdField_a_of_type_Long).append("}");
    localStringBuilder.append("{matchExpired: ").append(this.jdField_c_of_type_Int).append("}");
    localStringBuilder.append("{c2cExpiredTime: ").append(this.d).append("}");
    localStringBuilder.append("{tipsWording: ").append(this.jdField_c_of_type_JavaLangString).append("}");
    localStringBuilder.append("{readyTs: ").append(this.jdField_b_of_type_Long).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anpf
 * JD-Core Version:    0.7.0.1
 */