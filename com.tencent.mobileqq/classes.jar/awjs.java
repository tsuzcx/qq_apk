public class awjs
{
  static int jdField_a_of_type_Int = 3;
  int[] jdField_a_of_type_ArrayOfInt;
  int b;
  int c;
  
  public awjs(String paramString, int paramInt)
  {
    this.c = paramInt;
    paramString = paramString.split(" ");
    if (paramString.length != 2) {
      throw new Exception("data illegal");
    }
    if (paramString[1].equals("1")) {}
    for (this.b = 1;; this.b = 0)
    {
      paramString = paramString[0].toCharArray();
      this.jdField_a_of_type_ArrayOfInt = new int[paramString.length];
      paramInt = i;
      while (paramInt < paramString.length)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = (Integer.valueOf(paramString[paramInt]).intValue() - Integer.valueOf(48).intValue());
        paramInt += 1;
      }
      if (!paramString[1].equals("0")) {
        break;
      }
    }
    throw new Exception("data illegal");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awjs
 * JD-Core Version:    0.7.0.1
 */