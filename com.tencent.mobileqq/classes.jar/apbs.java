public class apbs
{
  public double a;
  public int a;
  public apbo a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = "";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("result:{sclass:");
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = localStringBuilder.append(str).append(",").append("sItemId:");
      if (this.jdField_a_of_type_Apbo == null) {
        break label230;
      }
      str = this.jdField_a_of_type_Apbo.jdField_a_of_type_JavaLangString;
      label56:
      localStringBuilder = localStringBuilder.append(str).append(",").append("dProb:").append(this.jdField_a_of_type_Double).append(",").append("sTitle:").append(this.d).append(",").append("sWiki:").append(this.e).append(",").append("sJumpUrl:").append(this.f).append(",").append("sCdbRes:");
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label236;
      }
    }
    label230:
    label236:
    for (String str = new String(this.jdField_a_of_type_ArrayOfByte);; str = "")
    {
      return str + "," + "isAutoJump:" + this.jdField_a_of_type_Boolean + "," + "iNeedCheckLBS:" + this.c + "," + "imageId:" + this.g + "}";
      str = "";
      break;
      str = "";
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbs
 * JD-Core Version:    0.7.0.1
 */