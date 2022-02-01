public class athq
  implements Cloneable
{
  public long a;
  public String a;
  public short a;
  public boolean a;
  public byte[] a = new byte[16];
  public long b;
  public short b;
  public boolean b;
  public long c = -1L;
  
  public athq a()
  {
    try
    {
      athq localathq = (athq)super.clone();
      return localathq;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     athq
 * JD-Core Version:    0.7.0.1
 */