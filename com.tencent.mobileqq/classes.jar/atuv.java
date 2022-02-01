import android.content.Intent;

public class atuv
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  public atuv a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("targetUin");
    this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("srcDiscGroup");
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("peerType", 0);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("rootEntrace", true);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("busiType", 0);
    this.c = paramIntent.getIntExtra("enterfrom", 0);
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuv
 * JD-Core Version:    0.7.0.1
 */