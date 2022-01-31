package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;

class AllocationThunker
  extends Allocation
{
  static BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
  android.renderscript.Allocation mN;
  
  static
  {
    mBitmapOptions.inScaled = false;
  }
  
  AllocationThunker(RenderScript paramRenderScript, Type paramType, int paramInt, android.renderscript.Allocation paramAllocation)
  {
    super(0, paramRenderScript, paramType, paramInt);
    this.mType = paramType;
    this.mUsage = paramInt;
    this.mN = paramAllocation;
  }
  
  static android.renderscript.Allocation.MipmapControl convertMipmapControl(Allocation.MipmapControl paramMipmapControl)
  {
    switch (AllocationThunker.1.$SwitchMap$android$support$v8$renderscript$Allocation$MipmapControl[paramMipmapControl.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return android.renderscript.Allocation.MipmapControl.MIPMAP_NONE;
    case 2: 
      return android.renderscript.Allocation.MipmapControl.MIPMAP_FULL;
    }
    return android.renderscript.Allocation.MipmapControl.MIPMAP_ON_SYNC_TO_TEXTURE;
  }
  
  public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    paramBitmap = android.renderscript.Allocation.createCubemapFromBitmap(((RenderScriptThunker)paramRenderScript).mN, paramBitmap, convertMipmapControl(paramMipmapControl), paramInt);
    return new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramBitmap.getType()), paramInt, paramBitmap);
  }
  
  public static Allocation createCubemapFromCubeFaces(RenderScript paramRenderScript, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    paramBitmap1 = android.renderscript.Allocation.createCubemapFromCubeFaces(((RenderScriptThunker)paramRenderScript).mN, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, paramBitmap5, paramBitmap6, convertMipmapControl(paramMipmapControl), paramInt);
    return new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramBitmap1.getType()), paramInt, paramBitmap1);
  }
  
  public static Allocation createFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    paramBitmap = android.renderscript.Allocation.createFromBitmap(((RenderScriptThunker)paramRenderScript).mN, paramBitmap, convertMipmapControl(paramMipmapControl), paramInt);
    return new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramBitmap.getType()), paramInt, paramBitmap);
  }
  
  public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt1, Allocation.MipmapControl paramMipmapControl, int paramInt2)
  {
    paramResources = android.renderscript.Allocation.createFromBitmapResource(((RenderScriptThunker)paramRenderScript).mN, paramResources, paramInt1, convertMipmapControl(paramMipmapControl), paramInt2);
    return new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramResources.getType()), paramInt2, paramResources);
  }
  
  public static Allocation createFromString(RenderScript paramRenderScript, String paramString, int paramInt)
  {
    paramString = android.renderscript.Allocation.createFromString(((RenderScriptThunker)paramRenderScript).mN, paramString, paramInt);
    return new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramString.getType()), paramInt, paramString);
  }
  
  public static Allocation createSized(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    ElementThunker localElementThunker = (ElementThunker)paramElement;
    paramElement = android.renderscript.Allocation.createSized(localRenderScriptThunker.mN, (android.renderscript.Element)paramElement.getNObj(), paramInt1, paramInt2);
    return new AllocationThunker(paramRenderScript, new TypeThunker(paramRenderScript, paramElement.getType()), paramInt2, paramElement);
  }
  
  public static Allocation createTyped(RenderScript paramRenderScript, Type paramType, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    TypeThunker localTypeThunker = (TypeThunker)paramType;
    return new AllocationThunker(paramRenderScript, paramType, paramInt, android.renderscript.Allocation.createTyped(localRenderScriptThunker.mN, localTypeThunker.mN, convertMipmapControl(paramMipmapControl), paramInt));
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, Allocation paramAllocation, int paramInt3)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramAllocation.mN, paramInt3);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    this.mN.copy1DRangeFrom(paramInt1, paramInt2, paramArrayOfShort);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    this.mN.copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfShort);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Allocation paramAllocation, int paramInt5, int paramInt6)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramAllocation.mN, paramInt5, paramInt6);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort)
  {
    this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfShort);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this.mN.copy2DRangeFrom(paramInt1, paramInt2, paramBitmap);
  }
  
  public void copyFrom(Bitmap paramBitmap)
  {
    this.mN.copyFrom(paramBitmap);
  }
  
  public void copyFrom(Allocation paramAllocation)
  {
    paramAllocation = (AllocationThunker)paramAllocation;
    this.mN.copyFrom(paramAllocation.mN);
  }
  
  public void copyFrom(byte[] paramArrayOfByte)
  {
    this.mN.copyFrom(paramArrayOfByte);
  }
  
  public void copyFrom(float[] paramArrayOfFloat)
  {
    this.mN.copyFrom(paramArrayOfFloat);
  }
  
  public void copyFrom(int[] paramArrayOfInt)
  {
    this.mN.copyFrom(paramArrayOfInt);
  }
  
  public void copyFrom(BaseObj[] paramArrayOfBaseObj)
  {
    if (paramArrayOfBaseObj == null) {
      return;
    }
    android.renderscript.BaseObj[] arrayOfBaseObj = new android.renderscript.BaseObj[paramArrayOfBaseObj.length];
    int i = 0;
    while (i < paramArrayOfBaseObj.length)
    {
      arrayOfBaseObj[i] = paramArrayOfBaseObj[i].getNObj();
      i += 1;
    }
    this.mN.copyFrom(arrayOfBaseObj);
  }
  
  public void copyFrom(short[] paramArrayOfShort)
  {
    this.mN.copyFrom(paramArrayOfShort);
  }
  
  public void copyFromUnchecked(byte[] paramArrayOfByte)
  {
    this.mN.copyFromUnchecked(paramArrayOfByte);
  }
  
  public void copyFromUnchecked(float[] paramArrayOfFloat)
  {
    this.mN.copyFromUnchecked(paramArrayOfFloat);
  }
  
  public void copyFromUnchecked(int[] paramArrayOfInt)
  {
    this.mN.copyFromUnchecked(paramArrayOfInt);
  }
  
  public void copyFromUnchecked(short[] paramArrayOfShort)
  {
    this.mN.copyFromUnchecked(paramArrayOfShort);
  }
  
  public void copyTo(Bitmap paramBitmap)
  {
    this.mN.copyTo(paramBitmap);
  }
  
  public void copyTo(byte[] paramArrayOfByte)
  {
    this.mN.copyTo(paramArrayOfByte);
  }
  
  public void copyTo(float[] paramArrayOfFloat)
  {
    this.mN.copyTo(paramArrayOfFloat);
  }
  
  public void copyTo(int[] paramArrayOfInt)
  {
    this.mN.copyTo(paramArrayOfInt);
  }
  
  public void copyTo(short[] paramArrayOfShort)
  {
    this.mN.copyTo(paramArrayOfShort);
  }
  
  public void generateMipmaps()
  {
    this.mN.generateMipmaps();
  }
  
  public int getBytesSize()
  {
    return this.mN.getBytesSize();
  }
  
  public Element getElement()
  {
    return getType().getElement();
  }
  
  android.renderscript.Allocation getNObj()
  {
    return this.mN;
  }
  
  public Type getType()
  {
    return TypeThunker.find(this.mN.getType());
  }
  
  public int getUsage()
  {
    return this.mN.getUsage();
  }
  
  public void ioReceive()
  {
    this.mN.ioReceive();
  }
  
  public void ioSend()
  {
    this.mN.ioSend();
  }
  
  public void setFromFieldPacker(int paramInt1, int paramInt2, FieldPacker paramFieldPacker)
  {
    paramFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
    this.mN.setFromFieldPacker(paramInt1, paramInt2, paramFieldPacker);
  }
  
  public void setFromFieldPacker(int paramInt, FieldPacker paramFieldPacker)
  {
    paramFieldPacker = new android.renderscript.FieldPacker(paramFieldPacker.getData());
    this.mN.setFromFieldPacker(paramInt, paramFieldPacker);
  }
  
  public void syncAll(int paramInt)
  {
    this.mN.syncAll(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.AllocationThunker
 * JD-Core Version:    0.7.0.1
 */