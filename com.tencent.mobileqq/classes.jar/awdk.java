public class awdk
{
  public String a;
  public String b;
  public String c;
  
  public awdk(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String toString()
  {
    return "PhoneInfo{countryCode='" + this.a + '\'' + ", areaCode='" + this.b + '\'' + ", rawPhoneNum='" + this.c + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdk
 * JD-Core Version:    0.7.0.1
 */