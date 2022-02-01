import com.tencent.mobileqq.data.Card;

class anrr
{
  String jdField_a_of_type_JavaLangString = "0";
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString = "0";
  boolean jdField_b_of_type_Boolean = false;
  String c = "0";
  String d = "0";
  String e = "0";
  String f = "0";
  String g = "0";
  String h = "0";
  
  public void a(Card paramCard)
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString).append("-");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString).append("-");
      localStringBuilder.append(this.c).append("-");
      localStringBuilder.append(this.d);
      paramCard.strLocationCodes = localStringBuilder.toString();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e).append("-");
      localStringBuilder.append(this.f).append("-");
      localStringBuilder.append(this.g).append("-");
      localStringBuilder.append(this.h);
      paramCard.strHometownCodes = localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrr
 * JD-Core Version:    0.7.0.1
 */