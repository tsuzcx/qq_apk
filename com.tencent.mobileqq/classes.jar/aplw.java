public class aplw
{
  public double a;
  public int a;
  public String a;
  public aplx[] a;
  public int b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i;
    if ((this.jdField_a_of_type_ArrayOfAplx != null) && (this.jdField_a_of_type_ArrayOfAplx.length > 0)) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_ArrayOfAplx.length)
    {
      localStringBuilder.append("\n index:").append(i).append(this.jdField_a_of_type_ArrayOfAplx[i].toString()).append('\n');
      i += 1;
      continue;
      localStringBuilder.append("\n only have one itemContent:" + this.jdField_a_of_type_JavaLangString + ",prob:" + this.jdField_a_of_type_Double).append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aplw
 * JD-Core Version:    0.7.0.1
 */