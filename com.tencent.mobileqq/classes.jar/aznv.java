import java.nio.ByteBuffer;

class aznv
{
  public final long a;
  public final long b;
  public final long c;
  public final long d;
  
  public aznv(long paramLong)
  {
    this.a = 2882377846L;
    this.b = 1007L;
    this.c = 0L;
    this.d = paramLong;
  }
  
  public aznv(ByteBuffer paramByteBuffer)
  {
    this.a = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.b = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.c = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.d = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.putInt((int)(this.a & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.b & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.c & 0xFFFFFFFF));
    paramByteBuffer.putInt((int)(this.d & 0xFFFFFFFF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aznv
 * JD-Core Version:    0.7.0.1
 */