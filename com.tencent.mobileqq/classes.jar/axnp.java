public class axnp
{
  public amph[] a = new amph[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      amph[] arrayOfamph = this.a;
      int j = arrayOfamph.length;
      int i = 0;
      while (i < j)
      {
        amph localamph = arrayOfamph[i];
        if (localamph != null) {
          localStringBuilder.append("confItem ").append(localamph.jdField_a_of_type_Int).append(":").append(localamph.jdField_a_of_type_JavaLangString).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnp
 * JD-Core Version:    0.7.0.1
 */