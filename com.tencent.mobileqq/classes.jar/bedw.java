public class bedw
{
  public int a;
  public long a;
  public long b;
  
  public bedw(long paramLong1, long paramLong2, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.b = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof bedw));
      paramObject = (bedw)paramObject;
    } while ((paramObject.jdField_a_of_type_Long != this.jdField_a_of_type_Long) || (paramObject.b != this.b) || (paramObject.jdField_a_of_type_Int != this.jdField_a_of_type_Int));
    return true;
  }
  
  public int hashCode()
  {
    return (int)this.jdField_a_of_type_Long + (int)this.b + this.jdField_a_of_type_Int;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopUin:").append(this.jdField_a_of_type_Long).append(" ");
    localStringBuilder.append("msgSeq:").append(this.b).append(" ");
    localStringBuilder.append("msgRandom:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedw
 * JD-Core Version:    0.7.0.1
 */