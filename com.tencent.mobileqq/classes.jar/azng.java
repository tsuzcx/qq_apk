public class azng
{
  public aoko[] a = new aoko[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      aoko[] arrayOfaoko = this.a;
      int j = arrayOfaoko.length;
      int i = 0;
      while (i < j)
      {
        aoko localaoko = arrayOfaoko[i];
        if (localaoko != null) {
          localStringBuilder.append("confItem ").append(localaoko.jdField_a_of_type_Int).append(":").append(localaoko.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azng
 * JD-Core Version:    0.7.0.1
 */