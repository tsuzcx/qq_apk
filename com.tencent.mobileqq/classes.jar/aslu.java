public class aslu
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
  
  public aslu a()
  {
    try
    {
      aslu localaslu = (aslu)super.clone();
      return localaslu;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aslu
 * JD-Core Version:    0.7.0.1
 */