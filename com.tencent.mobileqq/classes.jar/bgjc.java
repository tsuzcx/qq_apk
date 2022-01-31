import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class bgjc
  extends ByteArrayOutputStream
{
  bgjc(bgjb parambgjb, int paramInt)
  {
    super(paramInt);
  }
  
  public String toString()
  {
    if ((this.count > 0) && (this.buf[(this.count - 1)] == 13)) {}
    for (int i = this.count - 1;; i = this.count) {
      try
      {
        String str = new String(this.buf, 0, i, bgjb.a(this.a).name());
        return str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgjc
 * JD-Core Version:    0.7.0.1
 */