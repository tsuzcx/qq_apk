import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class atlh
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public atlh(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return (this.jdField_a_of_type_Int == paramInt) && (this.jdField_a_of_type_JavaLangString.equals(paramString));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof atlh)) {}
    do
    {
      return false;
      paramObject = (atlh)paramObject;
    } while ((this.jdField_a_of_type_Int != paramObject.a()) || (!this.jdField_a_of_type_JavaLangString.equals(paramObject.a())));
    return true;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  @NonNull
  public String toString()
  {
    return "RoomKey{mHashCode='" + hashCode() + ", mSessionType=" + this.jdField_a_of_type_Int + ", mSessionUin=" + this.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atlh
 * JD-Core Version:    0.7.0.1
 */