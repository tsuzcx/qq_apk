import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class bejb
  extends ByteArrayOutputStream
{
  bejb(beja parambeja, int paramInt)
  {
    super(paramInt);
  }
  
  public String toString()
  {
    if ((this.count > 0) && (this.buf[(this.count - 1)] == 13)) {}
    for (int i = this.count - 1;; i = this.count) {
      try
      {
        String str = new String(this.buf, 0, i, beja.a(this.a).name());
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejb
 * JD-Core Version:    0.7.0.1
 */