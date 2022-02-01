public class bfts
{
  public int a;
  public boolean a;
  public int b;
  
  public bfts(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof bfts)) {
        break;
      }
      paramObject = (bfts)paramObject;
    } while ((paramObject.b == this.b) && (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramObject.jdField_a_of_type_Boolean == this.jdField_a_of_type_Boolean));
    return false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfts
 * JD-Core Version:    0.7.0.1
 */