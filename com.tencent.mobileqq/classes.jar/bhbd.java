import java.util.Comparator;

final class bhbd
  implements Comparator<byte[]>
{
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return paramArrayOfByte1.length - paramArrayOfByte2.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbd
 * JD-Core Version:    0.7.0.1
 */