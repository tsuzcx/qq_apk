public class apbr
{
  public double a;
  public int a;
  public String a;
  public apbs[] a;
  public int b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i;
    if ((this.jdField_a_of_type_ArrayOfApbs != null) && (this.jdField_a_of_type_ArrayOfApbs.length > 0)) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_ArrayOfApbs.length)
    {
      localStringBuilder.append("\n index:").append(i).append(this.jdField_a_of_type_ArrayOfApbs[i].toString()).append('\n');
      i += 1;
      continue;
      localStringBuilder.append("\n only have one itemContent:" + this.jdField_a_of_type_JavaLangString + ",prob:" + this.jdField_a_of_type_Double).append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbr
 * JD-Core Version:    0.7.0.1
 */