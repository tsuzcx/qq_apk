import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class bmwe
{
  public final int a;
  public final long a;
  public final short a;
  public final byte[] a;
  public final int b;
  public final long b;
  public final short b;
  public final long c;
  public final short c;
  public final short d;
  public final short e;
  public final short f;
  public final short g;
  public final short h;
  
  private bmwe(FileChannel paramFileChannel)
  {
    this.jdField_a_of_type_ArrayOfByte = new byte[16];
    paramFileChannel.position(0L);
    paramFileChannel.read(ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte));
    if ((this.jdField_a_of_type_ArrayOfByte[0] != 127) || (this.jdField_a_of_type_ArrayOfByte[1] != 69) || (this.jdField_a_of_type_ArrayOfByte[2] != 76) || (this.jdField_a_of_type_ArrayOfByte[3] != 70)) {
      throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.jdField_a_of_type_ArrayOfByte[0]), Byte.valueOf(this.jdField_a_of_type_ArrayOfByte[1]), Byte.valueOf(this.jdField_a_of_type_ArrayOfByte[2]), Byte.valueOf(this.jdField_a_of_type_ArrayOfByte[3]) }));
    }
    bmwc.a(this.jdField_a_of_type_ArrayOfByte[4], 1, 2, "bad elf class: " + this.jdField_a_of_type_ArrayOfByte[4]);
    bmwc.a(this.jdField_a_of_type_ArrayOfByte[5], 1, 2, "bad elf data encoding: " + this.jdField_a_of_type_ArrayOfByte[5]);
    int i;
    label222:
    ByteBuffer localByteBuffer;
    if (this.jdField_a_of_type_ArrayOfByte[4] == 1)
    {
      i = 36;
      localByteBuffer = ByteBuffer.allocate(i);
      if (this.jdField_a_of_type_ArrayOfByte[5] != 1) {
        break label382;
      }
    }
    label382:
    for (ByteOrder localByteOrder = ByteOrder.LITTLE_ENDIAN;; localByteOrder = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(localByteOrder);
      bmwc.a(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
      this.jdField_a_of_type_Short = localByteBuffer.getShort();
      this.jdField_b_of_type_Short = localByteBuffer.getShort();
      this.jdField_a_of_type_Int = localByteBuffer.getInt();
      bmwc.a(this.jdField_a_of_type_Int, 1, 1, "bad elf version: " + this.jdField_a_of_type_Int);
      switch (this.jdField_a_of_type_ArrayOfByte[4])
      {
      default: 
        throw new IOException("Unexpected elf class: " + this.jdField_a_of_type_ArrayOfByte[4]);
        i = 48;
        break label222;
      }
    }
    this.jdField_a_of_type_Long = localByteBuffer.getInt();
    this.jdField_b_of_type_Long = localByteBuffer.getInt();
    for (this.jdField_c_of_type_Long = localByteBuffer.getInt();; this.jdField_c_of_type_Long = localByteBuffer.getLong())
    {
      this.jdField_b_of_type_Int = localByteBuffer.getInt();
      this.jdField_c_of_type_Short = localByteBuffer.getShort();
      this.d = localByteBuffer.getShort();
      this.e = localByteBuffer.getShort();
      this.f = localByteBuffer.getShort();
      this.g = localByteBuffer.getShort();
      this.h = localByteBuffer.getShort();
      return;
      this.jdField_a_of_type_Long = localByteBuffer.getLong();
      this.jdField_b_of_type_Long = localByteBuffer.getLong();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwe
 * JD-Core Version:    0.7.0.1
 */