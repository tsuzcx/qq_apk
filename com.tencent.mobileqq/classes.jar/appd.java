import android.graphics.RectF;

public class appd
{
  public int a;
  public RectF a;
  public String a;
  appc[] a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  
  public appd()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoErrCode:").append(this.jdField_a_of_type_Int).append(",ssoErrMsg:").append(this.jdField_a_of_type_JavaLangString).append(",errCode:").append(this.jdField_b_of_type_Int).append(",errMsg:").append(this.jdField_b_of_type_JavaLangString).append(",sessionId:").append(this.jdField_c_of_type_JavaLangString).append(",moreUrl:").append(this.d);
    int i = 0;
    while ((this.jdField_a_of_type_ArrayOfAppc != null) && (i < this.jdField_a_of_type_ArrayOfAppc.length))
    {
      localStringBuilder.append("\n{index=").append(i).append(":").append(this.jdField_a_of_type_ArrayOfAppc[i].toString()).append("}\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appd
 * JD-Core Version:    0.7.0.1
 */