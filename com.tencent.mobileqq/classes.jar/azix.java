public class azix
{
  public aogf[] a = new aogf[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      aogf[] arrayOfaogf = this.a;
      int j = arrayOfaogf.length;
      int i = 0;
      while (i < j)
      {
        aogf localaogf = arrayOfaogf[i];
        if (localaogf != null) {
          localStringBuilder.append("confItem ").append(localaogf.jdField_a_of_type_Int).append(":").append(localaogf.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azix
 * JD-Core Version:    0.7.0.1
 */