import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class bdjp
  extends PipedInputStream
{
  private int a = 1024;
  
  public bdjp(PipedOutputStream paramPipedOutputStream, int paramInt)
  {
    super(paramPipedOutputStream);
    this.a = paramInt;
  }
  
  protected void receive(int paramInt)
  {
    try
    {
      if (this.buffer.length != this.a) {
        this.buffer = new byte[this.a];
      }
      super.receive(paramInt);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjp
 * JD-Core Version:    0.7.0.1
 */