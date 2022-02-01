import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

class bptg
{
  public int a;
  public MediaCodec.BufferInfo a;
  public ByteBuffer a;
  public int b;
  
  private bptg()
  {
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bptg
 * JD-Core Version:    0.7.0.1
 */