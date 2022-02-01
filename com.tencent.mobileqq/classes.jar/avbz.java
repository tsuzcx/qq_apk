import com.tencent.open.base.MD5Utils;

class avbz
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public avbz(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = MD5Utils.toMD5(paramString2);
    this.d = avbv.a(paramString1);
  }
  
  public String toString()
  {
    return "MusicReqInfo{id='" + this.jdField_a_of_type_JavaLangString + '\'' + ", url='" + this.b + '\'' + ", md5='" + this.c + '\'' + ", status=" + this.jdField_a_of_type_Int + ", cachePath='" + this.d + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbz
 * JD-Core Version:    0.7.0.1
 */