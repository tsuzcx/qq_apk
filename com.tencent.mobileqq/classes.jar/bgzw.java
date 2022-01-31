import android.support.annotation.NonNull;

public class bgzw
{
  private float jdField_a_of_type_Float = 0.0F;
  private String jdField_a_of_type_JavaLangString = "";
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public String a()
  {
    return (int)(this.jdField_a_of_type_Float * 100.0F) + "%";
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Float > 0.0F) && (this.jdField_a_of_type_Float < 1.0F);
  }
  
  @NonNull
  public String toString()
  {
    return "LoadingStatus {progress=" + this.jdField_a_of_type_Float + "} ";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgzw
 * JD-Core Version:    0.7.0.1
 */