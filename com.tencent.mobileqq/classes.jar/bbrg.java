public class bbrg
{
  public static String a(int paramInt)
  {
    long l1 = 0x7FFFFFFF & paramInt;
    long l2 = paramInt >> 31 & 0x1;
    return (l2 << 31 | l1) + "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrg
 * JD-Core Version:    0.7.0.1
 */