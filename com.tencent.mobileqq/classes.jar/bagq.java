import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class bagq
{
  private int jdField_a_of_type_Int = 1;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  public final MediaMuxer a;
  private final bagj jdField_a_of_type_Bagj;
  private final bnzy jdField_a_of_type_Bnzy;
  private final String jdField_a_of_type_JavaLangString;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final List<bags> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat;
  private int jdField_c_of_type_Int;
  private MediaFormat jdField_c_of_type_AndroidMediaMediaFormat;
  private int d;
  
  public bagq(bnzy parambnzy, String paramString, bagj parambagj)
  {
    this.jdField_a_of_type_Bnzy = parambnzy;
    this.jdField_a_of_type_Bagj = parambagj;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AssertionError();
    case 0: 
      return this.jdField_b_of_type_Int;
    case 1: 
      return this.jdField_c_of_type_Int;
    }
    return this.d;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaFormat == null) {}
    while (((this.jdField_b_of_type_AndroidMediaMediaFormat == null) && (this.jdField_a_of_type_Int > 0)) || ((this.jdField_a_of_type_Int == 2) && (this.jdField_c_of_type_AndroidMediaMediaFormat == null))) {
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
    QLog.d("MediaMuxerWrapper", 1, "Added track #" + this.jdField_b_of_type_Int + " with " + this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime") + " to muxer");
    if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
    {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_b_of_type_AndroidMediaMediaFormat);
      QLog.d("MediaMuxerWrapper", 1, "Added track #" + this.jdField_c_of_type_Int + " with " + this.jdField_b_of_type_AndroidMediaMediaFormat.getString("mime") + " to muxer");
    }
    if (this.jdField_c_of_type_AndroidMediaMediaFormat != null)
    {
      this.d = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_b_of_type_AndroidMediaMediaFormat);
      QLog.d("MediaMuxerWrapper", 1, new Object[] { "Added second audiotrack #", Integer.valueOf(this.jdField_c_of_type_Int), " with ", this.jdField_c_of_type_AndroidMediaMediaFormat.getString("mime"), " to muxer" });
    }
    this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(0);
    }
    this.jdField_a_of_type_JavaNioByteBuffer.flip();
    QLog.d("MediaMuxerWrapper", 1, "Output format determined, writing " + this.jdField_a_of_type_JavaUtilList.size() + " samples / " + this.jdField_a_of_type_JavaNioByteBuffer.limit() + " bytes to muxer.");
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    bags localbags;
    for (int i = 0; localIterator.hasNext(); i = bags.b(localbags) + i)
    {
      localbags = (bags)localIterator.next();
      bags.a(localbags, localBufferInfo, i);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(a(bags.a(localbags)), this.jdField_a_of_type_JavaNioByteBuffer, localBufferInfo);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaNioByteBuffer = null;
  }
  
  public void a()
  {
    try
    {
      QLog.d("MediaMuxerWrapper", 1, "release");
      if (this.jdField_a_of_type_Bnzy.a())
      {
        QLog.d("MediaMuxerWrapper", 1, "release indeed");
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
        if (this.jdField_a_of_type_Bagj != null) {
          this.jdField_a_of_type_Bagj.onEncodeFinish(this.jdField_a_of_type_JavaLangString);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, MediaFormat paramMediaFormat)
  {
    QLog.d("MediaMuxerWrapper", 1, "setOutputFormat " + paramInt);
    switch (paramInt)
    {
    default: 
      throw new AssertionError();
    case 0: 
      this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    }
    for (;;)
    {
      b();
      return;
      this.jdField_b_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      continue;
      this.jdField_c_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    }
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(a(paramInt), paramByteBuffer, paramBufferInfo);
        return;
      }
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      paramByteBuffer.position(paramBufferInfo.offset);
      if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
        this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
      }
      this.jdField_a_of_type_JavaNioByteBuffer.put(paramByteBuffer);
      this.jdField_a_of_type_JavaUtilList.add(new bags(paramInt, paramBufferInfo.size, paramBufferInfo, null));
      return;
    }
    catch (Exception paramByteBuffer)
    {
      QLog.e("MediaMuxerWrapper", 1, "writeSampleData error, ", paramByteBuffer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagq
 * JD-Core Version:    0.7.0.1
 */