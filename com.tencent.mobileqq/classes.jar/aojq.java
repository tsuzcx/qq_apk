import com.tencent.mobileqq.app.TroopManager;

public class aojq
{
  public int a;
  public String a;
  
  public aojq(TroopManager paramTroopManager) {}
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof aojq))
    {
      paramObject = (aojq)paramObject;
      if ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojq
 * JD-Core Version:    0.7.0.1
 */