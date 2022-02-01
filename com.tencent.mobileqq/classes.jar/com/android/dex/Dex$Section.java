package com.android.dex;

import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;

public final class Dex$Section
  implements ByteInput, ByteOutput
{
  private final ByteBuffer data;
  private final int initialPosition;
  private final String name;
  
  private Dex$Section(Dex paramDex, String paramString, ByteBuffer paramByteBuffer)
  {
    this.name = paramString;
    this.data = paramByteBuffer;
    this.initialPosition = paramByteBuffer.position();
  }
  
  private int findCatchHandlerIndex(Code.CatchHandler[] paramArrayOfCatchHandler, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfCatchHandler.length)
    {
      if (paramArrayOfCatchHandler[i].getOffset() == paramInt) {
        return i;
      }
      i += 1;
    }
    throw new IllegalArgumentException();
  }
  
  private byte[] getBytesFrom(int paramInt)
  {
    byte[] arrayOfByte = new byte[this.data.position() - paramInt];
    this.data.position(paramInt);
    this.data.get(arrayOfByte);
    return arrayOfByte;
  }
  
  private Code.CatchHandler readCatchHandler(int paramInt)
  {
    int j = readSleb128();
    int k = Math.abs(j);
    int[] arrayOfInt1 = new int[k];
    int[] arrayOfInt2 = new int[k];
    int i = 0;
    while (i < k)
    {
      arrayOfInt1[i] = readUleb128();
      arrayOfInt2[i] = readUleb128();
      i += 1;
    }
    if (j <= 0) {}
    for (i = readUleb128();; i = -1) {
      return new Code.CatchHandler(arrayOfInt1, arrayOfInt2, i, paramInt);
    }
  }
  
  private Code.CatchHandler[] readCatchHandlers()
  {
    int j = this.data.position();
    int k = readUleb128();
    Code.CatchHandler[] arrayOfCatchHandler = new Code.CatchHandler[k];
    int i = 0;
    while (i < k)
    {
      arrayOfCatchHandler[i] = readCatchHandler(this.data.position() - j);
      i += 1;
    }
    return arrayOfCatchHandler;
  }
  
  private ClassData readClassData()
  {
    int i = readUleb128();
    int j = readUleb128();
    int k = readUleb128();
    int m = readUleb128();
    return new ClassData(readFields(i), readFields(j), readMethods(k), readMethods(m));
  }
  
  private Code readCode()
  {
    int i = readUnsignedShort();
    int j = readUnsignedShort();
    int k = readUnsignedShort();
    int m = readUnsignedShort();
    int n = readInt();
    short[] arrayOfShort = readShortArray(readInt());
    Object localObject;
    Code.CatchHandler[] arrayOfCatchHandler;
    if (m > 0)
    {
      if (arrayOfShort.length % 2 == 1) {
        readShort();
      }
      localObject = this.this$0.open(this.data.position());
      skip(m * 8);
      arrayOfCatchHandler = readCatchHandlers();
      localObject = ((Section)localObject).readTries(m, arrayOfCatchHandler);
    }
    for (;;)
    {
      return new Code(i, j, k, n, arrayOfShort, (Code.Try[])localObject, arrayOfCatchHandler);
      localObject = new Code.Try[0];
      arrayOfCatchHandler = new Code.CatchHandler[0];
    }
  }
  
  private ClassData.Field[] readFields(int paramInt)
  {
    int i = 0;
    ClassData.Field[] arrayOfField = new ClassData.Field[paramInt];
    int j = 0;
    while (i < paramInt)
    {
      j += readUleb128();
      arrayOfField[i] = new ClassData.Field(j, readUleb128());
      i += 1;
    }
    return arrayOfField;
  }
  
  private ClassData.Method[] readMethods(int paramInt)
  {
    int i = 0;
    ClassData.Method[] arrayOfMethod = new ClassData.Method[paramInt];
    int j = 0;
    while (i < paramInt)
    {
      j += readUleb128();
      arrayOfMethod[i] = new ClassData.Method(j, readUleb128(), readUleb128());
      i += 1;
    }
    return arrayOfMethod;
  }
  
  private Code.Try[] readTries(int paramInt, Code.CatchHandler[] paramArrayOfCatchHandler)
  {
    Code.Try[] arrayOfTry = new Code.Try[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfTry[i] = new Code.Try(readInt(), readUnsignedShort(), findCatchHandlerIndex(paramArrayOfCatchHandler, readUnsignedShort()));
      i += 1;
    }
    return arrayOfTry;
  }
  
  public void alignToFourBytes()
  {
    this.data.position(this.data.position() + 3 & 0xFFFFFFFC);
  }
  
  public void alignToFourBytesWithZeroFill()
  {
    while ((this.data.position() & 0x3) != 0) {
      this.data.put((byte)0);
    }
  }
  
  public void assertFourByteAligned()
  {
    if ((this.data.position() & 0x3) != 0) {
      throw new IllegalStateException("Not four byte aligned!");
    }
  }
  
  public int getPosition()
  {
    return this.data.position();
  }
  
  public Annotation readAnnotation()
  {
    byte b = readByte();
    int i = this.data.position();
    new EncodedValueReader(this, 29).skipValue();
    return new Annotation(this.this$0, b, new EncodedValue(getBytesFrom(i)));
  }
  
  public byte readByte()
  {
    return this.data.get();
  }
  
  public byte[] readByteArray(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.data.get(arrayOfByte);
    return arrayOfByte;
  }
  
  public ClassDef readClassDef()
  {
    int i = getPosition();
    int j = readInt();
    int k = readInt();
    int m = readInt();
    int n = readInt();
    int i1 = readInt();
    int i2 = readInt();
    int i3 = readInt();
    int i4 = readInt();
    return new ClassDef(this.this$0, i, j, k, m, n, i1, i2, i3, i4);
  }
  
  public EncodedValue readEncodedArray()
  {
    int i = this.data.position();
    new EncodedValueReader(this, 28).skipValue();
    return new EncodedValue(getBytesFrom(i));
  }
  
  public FieldId readFieldId()
  {
    int i = readUnsignedShort();
    int j = readUnsignedShort();
    int k = readInt();
    return new FieldId(this.this$0, i, j, k);
  }
  
  public int readInt()
  {
    return this.data.getInt();
  }
  
  public MethodId readMethodId()
  {
    int i = readUnsignedShort();
    int j = readUnsignedShort();
    int k = readInt();
    return new MethodId(this.this$0, i, j, k);
  }
  
  public ProtoId readProtoId()
  {
    int i = readInt();
    int j = readInt();
    int k = readInt();
    return new ProtoId(this.this$0, i, j, k);
  }
  
  public short readShort()
  {
    return this.data.getShort();
  }
  
  public short[] readShortArray(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = Dex.EMPTY_SHORT_ARRAY;
      return localObject;
    }
    short[] arrayOfShort = new short[paramInt];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfShort;
      if (i >= paramInt) {
        break;
      }
      arrayOfShort[i] = readShort();
      i += 1;
    }
  }
  
  public int readSleb128()
  {
    return Leb128.readSignedLeb128(this);
  }
  
  public String readString()
  {
    int k = readInt();
    int i = this.data.position();
    int j = this.data.limit();
    this.data.position(k);
    this.data.limit(this.data.capacity());
    try
    {
      k = readUleb128();
      String str1 = Mutf8.decode(this, new char[k]);
      if (str1.length() != k) {
        throw new DexException("Declared length " + k + " doesn't match decoded length of " + str1.length());
      }
    }
    catch (UTFDataFormatException localUTFDataFormatException)
    {
      throw new DexException(localUTFDataFormatException);
    }
    finally
    {
      this.data.position(i);
      this.data.limit(j);
    }
    this.data.position(i);
    this.data.limit(j);
    return str2;
  }
  
  public TypeList readTypeList()
  {
    short[] arrayOfShort = readShortArray(readInt());
    alignToFourBytes();
    return new TypeList(this.this$0, arrayOfShort);
  }
  
  public int readUleb128()
  {
    return Leb128.readUnsignedLeb128(this);
  }
  
  public int readUleb128p1()
  {
    return Leb128.readUnsignedLeb128(this) - 1;
  }
  
  public int readUnsignedShort()
  {
    return readShort() & 0xFFFF;
  }
  
  public int remaining()
  {
    return this.data.remaining();
  }
  
  public void skip(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    this.data.position(this.data.position() + paramInt);
  }
  
  public int used()
  {
    return this.data.position() - this.initialPosition;
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    this.data.put(paramArrayOfByte);
  }
  
  public void write(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      writeShort(paramArrayOfShort[i]);
      i += 1;
    }
  }
  
  public void writeByte(int paramInt)
  {
    this.data.put((byte)paramInt);
  }
  
  public void writeInt(int paramInt)
  {
    this.data.putInt(paramInt);
  }
  
  public void writeShort(short paramShort)
  {
    this.data.putShort(paramShort);
  }
  
  public void writeSleb128(int paramInt)
  {
    try
    {
      Leb128.writeSignedLeb128(this, paramInt);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new DexException("Section limit " + this.data.limit() + " exceeded by " + this.name);
    }
  }
  
  public void writeStringData(String paramString)
  {
    try
    {
      writeUleb128(paramString.length());
      write(Mutf8.encode(paramString));
      writeByte(0);
      return;
    }
    catch (UTFDataFormatException paramString)
    {
      throw new AssertionError();
    }
  }
  
  public void writeTypeList(TypeList paramTypeList)
  {
    paramTypeList = paramTypeList.getTypes();
    writeInt(paramTypeList.length);
    int j = paramTypeList.length;
    int i = 0;
    while (i < j)
    {
      writeShort(paramTypeList[i]);
      i += 1;
    }
    alignToFourBytesWithZeroFill();
  }
  
  public void writeUleb128(int paramInt)
  {
    try
    {
      Leb128.writeUnsignedLeb128(this, paramInt);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new DexException("Section limit " + this.data.limit() + " exceeded by " + this.name);
    }
  }
  
  public void writeUleb128p1(int paramInt)
  {
    writeUleb128(paramInt + 1);
  }
  
  public void writeUnsignedShort(int paramInt)
  {
    int i = (short)paramInt;
    if (paramInt != (0xFFFF & i)) {
      throw new IllegalArgumentException("Expected an unsigned short: " + paramInt);
    }
    writeShort(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.Section
 * JD-Core Version:    0.7.0.1
 */