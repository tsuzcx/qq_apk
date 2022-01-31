import com.tencent.mobileqq.data.LebaPluginInfo;

public class amnq
{
  public byte a;
  public int a;
  public long a;
  public LebaPluginInfo a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  
  public amnq()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (this.jdField_a_of_type_Long == 0L)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      if (!(paramObject instanceof amnq)) {
        break;
      }
      paramObject = (amnq)paramObject;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long);
    return false;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amnq
 * JD-Core Version:    0.7.0.1
 */