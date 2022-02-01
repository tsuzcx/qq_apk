package android.support.v8.renderscript;

import android.util.Log;

public class FieldPacker
{
  private final byte[] mData;
  private int mLen;
  private android.renderscript.FieldPacker mN;
  private int mPos = 0;
  
  public FieldPacker(int paramInt)
  {
    this.mLen = paramInt;
    this.mData = new byte[paramInt];
    if (RenderScript.shouldThunk()) {
      this.mN = new android.renderscript.FieldPacker(paramInt);
    }
  }
  
  public void addBoolean(boolean paramBoolean)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addBoolean(paramBoolean);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      addI8((byte)i);
      return;
    }
  }
  
  public void addF32(float paramFloat)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF32(paramFloat);
      return;
    }
    addI32(Float.floatToRawIntBits(paramFloat));
  }
  
  public void addF32(Float2 paramFloat2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF32(new android.renderscript.Float2(paramFloat2.x, paramFloat2.y));
      return;
    }
    addF32(paramFloat2.x);
    addF32(paramFloat2.y);
  }
  
  public void addF32(Float3 paramFloat3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF32(new android.renderscript.Float3(paramFloat3.x, paramFloat3.y, paramFloat3.z));
      return;
    }
    addF32(paramFloat3.x);
    addF32(paramFloat3.y);
    addF32(paramFloat3.z);
  }
  
  public void addF32(Float4 paramFloat4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF32(new android.renderscript.Float4(paramFloat4.x, paramFloat4.y, paramFloat4.z, paramFloat4.w));
      return;
    }
    addF32(paramFloat4.x);
    addF32(paramFloat4.y);
    addF32(paramFloat4.z);
    addF32(paramFloat4.w);
  }
  
  public void addF64(double paramDouble)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF64(paramDouble);
      return;
    }
    addI64(Double.doubleToRawLongBits(paramDouble));
  }
  
  public void addF64(Double2 paramDouble2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF64(new android.renderscript.Double2(paramDouble2.x, paramDouble2.y));
      return;
    }
    addF64(paramDouble2.x);
    addF64(paramDouble2.y);
  }
  
  public void addF64(Double3 paramDouble3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF64(new android.renderscript.Double3(paramDouble3.x, paramDouble3.y, paramDouble3.z));
      return;
    }
    addF64(paramDouble3.x);
    addF64(paramDouble3.y);
    addF64(paramDouble3.z);
  }
  
  public void addF64(Double4 paramDouble4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addF64(new android.renderscript.Double4(paramDouble4.x, paramDouble4.y, paramDouble4.z, paramDouble4.w));
      return;
    }
    addF64(paramDouble4.x);
    addF64(paramDouble4.y);
    addF64(paramDouble4.z);
    addF64(paramDouble4.w);
  }
  
  public void addI16(Short2 paramShort2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI16(new android.renderscript.Short2(paramShort2.x, paramShort2.y));
      return;
    }
    addI16(paramShort2.x);
    addI16(paramShort2.y);
  }
  
  public void addI16(Short3 paramShort3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI16(new android.renderscript.Short3(paramShort3.x, paramShort3.y, paramShort3.z));
      return;
    }
    addI16(paramShort3.x);
    addI16(paramShort3.y);
    addI16(paramShort3.z);
  }
  
  public void addI16(Short4 paramShort4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI16(new android.renderscript.Short4(paramShort4.x, paramShort4.y, paramShort4.z, paramShort4.w));
      return;
    }
    addI16(paramShort4.x);
    addI16(paramShort4.y);
    addI16(paramShort4.z);
    addI16(paramShort4.w);
  }
  
  public void addI16(short paramShort)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI16(paramShort);
      return;
    }
    align(2);
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramShort & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramShort >> 8));
  }
  
  public void addI32(int paramInt)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI32(paramInt);
      return;
    }
    align(4);
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
  }
  
  public void addI32(Int2 paramInt2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI32(new android.renderscript.Int2(paramInt2.x, paramInt2.y));
      return;
    }
    addI32(paramInt2.x);
    addI32(paramInt2.y);
  }
  
  public void addI32(Int3 paramInt3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI32(new android.renderscript.Int3(paramInt3.x, paramInt3.y, paramInt3.z));
      return;
    }
    addI32(paramInt3.x);
    addI32(paramInt3.y);
    addI32(paramInt3.z);
  }
  
  public void addI32(Int4 paramInt4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI32(new android.renderscript.Int4(paramInt4.x, paramInt4.y, paramInt4.z, paramInt4.w));
      return;
    }
    addI32(paramInt4.x);
    addI32(paramInt4.y);
    addI32(paramInt4.z);
    addI32(paramInt4.w);
  }
  
  public void addI64(long paramLong)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI64(paramLong);
      return;
    }
    align(8);
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 16 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 24 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 32 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 40 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 48 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 56 & 0xFF));
  }
  
  public void addI64(Long2 paramLong2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI64(new android.renderscript.Long2(paramLong2.x, paramLong2.y));
      return;
    }
    addI64(paramLong2.x);
    addI64(paramLong2.y);
  }
  
  public void addI64(Long3 paramLong3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI64(new android.renderscript.Long3(paramLong3.x, paramLong3.y, paramLong3.z));
      return;
    }
    addI64(paramLong3.x);
    addI64(paramLong3.y);
    addI64(paramLong3.z);
  }
  
  public void addI64(Long4 paramLong4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI64(new android.renderscript.Long4(paramLong4.x, paramLong4.y, paramLong4.z, paramLong4.w));
      return;
    }
    addI64(paramLong4.x);
    addI64(paramLong4.y);
    addI64(paramLong4.z);
    addI64(paramLong4.w);
  }
  
  public void addI8(byte paramByte)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI8(paramByte);
      return;
    }
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void addI8(Byte2 paramByte2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI8(new android.renderscript.Byte2(paramByte2.x, paramByte2.y));
      return;
    }
    addI8(paramByte2.x);
    addI8(paramByte2.y);
  }
  
  public void addI8(Byte3 paramByte3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI8(new android.renderscript.Byte3(paramByte3.x, paramByte3.y, paramByte3.z));
      return;
    }
    addI8(paramByte3.x);
    addI8(paramByte3.y);
    addI8(paramByte3.z);
  }
  
  public void addI8(Byte4 paramByte4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addI8(new android.renderscript.Byte4(paramByte4.x, paramByte4.y, paramByte4.z, paramByte4.w));
      return;
    }
    addI8(paramByte4.x);
    addI8(paramByte4.y);
    addI8(paramByte4.z);
    addI8(paramByte4.w);
  }
  
  public void addMatrix(Matrix2f paramMatrix2f)
  {
    if (RenderScript.shouldThunk()) {
      this.mN.addMatrix(new android.renderscript.Matrix2f(paramMatrix2f.getArray()));
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramMatrix2f.mMat.length)
      {
        addF32(paramMatrix2f.mMat[i]);
        i += 1;
      }
    }
  }
  
  public void addMatrix(Matrix3f paramMatrix3f)
  {
    if (RenderScript.shouldThunk()) {
      this.mN.addMatrix(new android.renderscript.Matrix3f(paramMatrix3f.getArray()));
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramMatrix3f.mMat.length)
      {
        addF32(paramMatrix3f.mMat[i]);
        i += 1;
      }
    }
  }
  
  public void addMatrix(Matrix4f paramMatrix4f)
  {
    if (RenderScript.shouldThunk()) {
      this.mN.addMatrix(new android.renderscript.Matrix4f(paramMatrix4f.getArray()));
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramMatrix4f.mMat.length)
      {
        addF32(paramMatrix4f.mMat[i]);
        i += 1;
      }
    }
  }
  
  public void addObj(BaseObj paramBaseObj)
  {
    if (RenderScript.shouldThunk())
    {
      if (paramBaseObj != null)
      {
        this.mN.addObj(paramBaseObj.getNObj());
        return;
      }
      this.mN.addObj(null);
      return;
    }
    if (paramBaseObj != null)
    {
      addI32(paramBaseObj.getID(null));
      return;
    }
    addI32(0);
  }
  
  public void addU16(int paramInt)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU16(paramInt);
      return;
    }
    if ((paramInt < 0) || (paramInt > 65535))
    {
      Log.e("rs", "FieldPacker.addU16( " + paramInt + " )");
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    align(2);
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt >> 8));
  }
  
  public void addU16(Int2 paramInt2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU16(new android.renderscript.Int2(paramInt2.x, paramInt2.y));
      return;
    }
    addU16(paramInt2.x);
    addU16(paramInt2.y);
  }
  
  public void addU16(Int3 paramInt3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU16(new android.renderscript.Int3(paramInt3.x, paramInt3.y, paramInt3.z));
      return;
    }
    addU16(paramInt3.x);
    addU16(paramInt3.y);
    addU16(paramInt3.z);
  }
  
  public void addU16(Int4 paramInt4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU16(new android.renderscript.Int4(paramInt4.x, paramInt4.y, paramInt4.z, paramInt4.w));
      return;
    }
    addU16(paramInt4.x);
    addU16(paramInt4.y);
    addU16(paramInt4.z);
    addU16(paramInt4.w);
  }
  
  public void addU32(long paramLong)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU32(paramLong);
      return;
    }
    if ((paramLong < 0L) || (paramLong > 4294967295L))
    {
      Log.e("rs", "FieldPacker.addU32( " + paramLong + " )");
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    align(4);
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 16 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 24 & 0xFF));
  }
  
  public void addU32(Long2 paramLong2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU32(new android.renderscript.Long2(paramLong2.x, paramLong2.y));
      return;
    }
    addU32(paramLong2.x);
    addU32(paramLong2.y);
  }
  
  public void addU32(Long3 paramLong3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU32(new android.renderscript.Long3(paramLong3.x, paramLong3.y, paramLong3.z));
      return;
    }
    addU32(paramLong3.x);
    addU32(paramLong3.y);
    addU32(paramLong3.z);
  }
  
  public void addU32(Long4 paramLong4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU32(new android.renderscript.Long4(paramLong4.x, paramLong4.y, paramLong4.z, paramLong4.w));
      return;
    }
    addU32(paramLong4.x);
    addU32(paramLong4.y);
    addU32(paramLong4.z);
    addU32(paramLong4.w);
  }
  
  public void addU64(long paramLong)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU64(paramLong);
      return;
    }
    if (paramLong < 0L)
    {
      Log.e("rs", "FieldPacker.addU64( " + paramLong + " )");
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    align(8);
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 8 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 16 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 24 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 32 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 40 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 48 & 0xFF));
    arrayOfByte = this.mData;
    i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)(int)(paramLong >> 56 & 0xFF));
  }
  
  public void addU64(Long2 paramLong2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU64(new android.renderscript.Long2(paramLong2.x, paramLong2.y));
      return;
    }
    addU64(paramLong2.x);
    addU64(paramLong2.y);
  }
  
  public void addU64(Long3 paramLong3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU64(new android.renderscript.Long3(paramLong3.x, paramLong3.y, paramLong3.z));
      return;
    }
    addU64(paramLong3.x);
    addU64(paramLong3.y);
    addU64(paramLong3.z);
  }
  
  public void addU64(Long4 paramLong4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU64(new android.renderscript.Long4(paramLong4.x, paramLong4.y, paramLong4.z, paramLong4.w));
      return;
    }
    addU64(paramLong4.x);
    addU64(paramLong4.y);
    addU64(paramLong4.z);
    addU64(paramLong4.w);
  }
  
  public void addU8(Short2 paramShort2)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU8(new android.renderscript.Short2(paramShort2.x, paramShort2.y));
      return;
    }
    addU8(paramShort2.x);
    addU8(paramShort2.y);
  }
  
  public void addU8(Short3 paramShort3)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU8(new android.renderscript.Short3(paramShort3.x, paramShort3.y, paramShort3.z));
      return;
    }
    addU8(paramShort3.x);
    addU8(paramShort3.y);
    addU8(paramShort3.z);
  }
  
  public void addU8(Short4 paramShort4)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU8(new android.renderscript.Short4(paramShort4.x, paramShort4.y, paramShort4.z, paramShort4.w));
      return;
    }
    addU8(paramShort4.x);
    addU8(paramShort4.y);
    addU8(paramShort4.z);
    addU8(paramShort4.w);
  }
  
  public void addU8(short paramShort)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.addU8(paramShort);
      return;
    }
    if ((paramShort < 0) || (paramShort > 255)) {
      throw new IllegalArgumentException("Saving value out of range for type");
    }
    byte[] arrayOfByte = this.mData;
    int i = this.mPos;
    this.mPos = (i + 1);
    arrayOfByte[i] = ((byte)paramShort);
  }
  
  public void align(int paramInt)
  {
    if (RenderScript.shouldThunk()) {
      this.mN.align(paramInt);
    }
    for (;;)
    {
      return;
      if ((paramInt <= 0) || ((paramInt - 1 & paramInt) != 0)) {
        throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + paramInt);
      }
      while ((this.mPos & paramInt - 1) != 0)
      {
        byte[] arrayOfByte = this.mData;
        int i = this.mPos;
        this.mPos = (i + 1);
        arrayOfByte[i] = 0;
      }
    }
  }
  
  public final byte[] getData()
  {
    if (RenderScript.shouldThunk()) {
      return this.mN.getData();
    }
    return this.mData;
  }
  
  public void reset()
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.reset();
      return;
    }
    this.mPos = 0;
  }
  
  public void reset(int paramInt)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.reset(paramInt);
      return;
    }
    if ((paramInt < 0) || (paramInt >= this.mLen)) {
      throw new RSIllegalArgumentException("out of range argument: " + paramInt);
    }
    this.mPos = paramInt;
  }
  
  public void skip(int paramInt)
  {
    if (RenderScript.shouldThunk())
    {
      this.mN.skip(paramInt);
      return;
    }
    int i = this.mPos + paramInt;
    if ((i < 0) || (i > this.mLen)) {
      throw new RSIllegalArgumentException("out of range argument: " + paramInt);
    }
    this.mPos = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.FieldPacker
 * JD-Core Version:    0.7.0.1
 */