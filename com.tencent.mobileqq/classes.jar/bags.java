import android.media.MediaCodec.BufferInfo;

class bags
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final int b;
  private final int c;
  
  private bags(int paramInt1, int paramInt2, MediaCodec.BufferInfo paramBufferInfo)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Long = paramBufferInfo.presentationTimeUs;
    this.c = paramBufferInfo.flags;
  }
  
  private void a(MediaCodec.BufferInfo paramBufferInfo, int paramInt)
  {
    paramBufferInfo.set(paramInt, this.b, this.jdField_a_of_type_Long, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bags
 * JD-Core Version:    0.7.0.1
 */