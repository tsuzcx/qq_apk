package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.util.Log;
import java.lang.reflect.Method;

public class Allocation
  extends BaseObj
{
  public static final int USAGE_GRAPHICS_TEXTURE = 2;
  public static final int USAGE_IO_INPUT = 32;
  public static final int USAGE_IO_OUTPUT = 64;
  public static final int USAGE_SCRIPT = 1;
  public static final int USAGE_SHARED = 128;
  static BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
  Allocation mAdaptedAllocation;
  Bitmap mBitmap;
  boolean mConstrainedFace;
  boolean mConstrainedLOD;
  boolean mConstrainedY;
  boolean mConstrainedZ;
  int mCurrentCount;
  int mCurrentDimX;
  int mCurrentDimY;
  int mCurrentDimZ;
  boolean mReadAllowed = true;
  Type.CubemapFace mSelectedFace = Type.CubemapFace.POSITIVE_X;
  int mSelectedLOD;
  int mSelectedY;
  int mSelectedZ;
  int mSize;
  Type mType;
  int mUsage;
  boolean mWriteAllowed = true;
  
  static
  {
    mBitmapOptions.inScaled = false;
  }
  
  Allocation(int paramInt1, RenderScript paramRenderScript, Type paramType, int paramInt2)
  {
    super(paramInt1, paramRenderScript);
    if ((paramInt2 & 0xFFFFFF1C) != 0) {
      throw new RSIllegalArgumentException("Unknown usage specified.");
    }
    if ((paramInt2 & 0x20) != 0)
    {
      this.mWriteAllowed = false;
      if ((paramInt2 & 0xFFFFFFDC) != 0) {
        throw new RSIllegalArgumentException("Invalid usage combination.");
      }
    }
    this.mType = paramType;
    this.mUsage = paramInt2;
    this.mSize = (this.mType.getCount() * this.mType.getElement().getBytesSize());
    if (paramType != null) {
      updateCacheInfo(paramType);
    }
    if (RenderScript.sUseGCHooks == true) {}
    try
    {
      RenderScript.registerNativeAllocation.invoke(RenderScript.sRuntime, new Object[] { Integer.valueOf(this.mSize) });
      return;
    }
    catch (Exception paramRenderScript)
    {
      Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:" + paramRenderScript);
      throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:" + paramRenderScript);
    }
  }
  
  public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap)
  {
    return createCubemapFromBitmap(paramRenderScript, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 2);
  }
  
  public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    boolean bool = true;
    paramRenderScript.validate();
    int j = paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    if (i % 6 != 0) {
      throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
    }
    if (i / 6 != j) {
      throw new RSIllegalArgumentException("Only square cube map faces supported");
    }
    if ((j - 1 & j) == 0) {}
    for (i = 1; i == 0; i = 0) {
      throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
    }
    Element localElement = elementFromBitmap(paramRenderScript, paramBitmap);
    Object localObject = new Type.Builder(paramRenderScript, localElement);
    ((Type.Builder)localObject).setX(j);
    ((Type.Builder)localObject).setY(j);
    ((Type.Builder)localObject).setFaces(true);
    if (paramMipmapControl == Allocation.MipmapControl.MIPMAP_FULL) {}
    for (;;)
    {
      ((Type.Builder)localObject).setMipmaps(bool);
      localObject = ((Type.Builder)localObject).create();
      i = paramRenderScript.nAllocationCubeCreateFromBitmap(((Type)localObject).getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
      if (i != 0) {
        break;
      }
      throw new RSRuntimeException("Load failed for bitmap " + paramBitmap + " element " + localElement);
      bool = false;
    }
    return new Allocation(i, paramRenderScript, (Type)localObject, paramInt);
  }
  
  public static Allocation createCubemapFromCubeFaces(RenderScript paramRenderScript, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6)
  {
    return createCubemapFromCubeFaces(paramRenderScript, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, paramBitmap5, paramBitmap6, Allocation.MipmapControl.MIPMAP_NONE, 2);
  }
  
  public static Allocation createCubemapFromCubeFaces(RenderScript paramRenderScript, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    return null;
  }
  
  public static Allocation createFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap)
  {
    return createFromBitmap(paramRenderScript, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 131);
  }
  
  public static Allocation createFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    if (RenderScript.isNative) {
      return AllocationThunker.createFromBitmap((RenderScriptThunker)paramRenderScript, paramBitmap, paramMipmapControl, paramInt);
    }
    paramRenderScript.validate();
    if (paramBitmap.getConfig() == null)
    {
      if ((paramInt & 0x80) != 0) {
        throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
      }
      localObject = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      return createFromBitmap(paramRenderScript, (Bitmap)localObject, paramMipmapControl, paramInt);
    }
    Object localObject = typeFromBitmap(paramRenderScript, paramBitmap, paramMipmapControl);
    if ((paramMipmapControl == Allocation.MipmapControl.MIPMAP_NONE) && (((Type)localObject).getElement().isCompatible(Element.RGBA_8888(paramRenderScript))) && (paramInt == 131))
    {
      i = paramRenderScript.nAllocationCreateBitmapBackedAllocation(((Type)localObject).getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
      if (i == 0) {
        throw new RSRuntimeException("Load failed.");
      }
      paramRenderScript = new Allocation(i, paramRenderScript, (Type)localObject, paramInt);
      paramRenderScript.setBitmap(paramBitmap);
      return paramRenderScript;
    }
    int i = paramRenderScript.nAllocationCreateFromBitmap(((Type)localObject).getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
    if (i == 0) {
      throw new RSRuntimeException("Load failed.");
    }
    return new Allocation(i, paramRenderScript, (Type)localObject, paramInt);
  }
  
  public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    return createFromBitmapResource(paramRenderScript, paramResources, paramInt, Allocation.MipmapControl.MIPMAP_NONE, 3);
  }
  
  public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt1, Allocation.MipmapControl paramMipmapControl, int paramInt2)
  {
    paramRenderScript.validate();
    if ((paramInt2 & 0xE0) != 0) {
      throw new RSIllegalArgumentException("Unsupported usage specified.");
    }
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1);
    paramRenderScript = createFromBitmap(paramRenderScript, paramResources, paramMipmapControl, paramInt2);
    paramResources.recycle();
    return paramRenderScript;
  }
  
  public static Allocation createFromString(RenderScript paramRenderScript, String paramString, int paramInt)
  {
    paramRenderScript.validate();
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramRenderScript = createSized(paramRenderScript, Element.U8(paramRenderScript), paramString.length, paramInt);
      paramRenderScript.copyFrom(paramString);
      return paramRenderScript;
    }
    catch (Exception paramRenderScript)
    {
      throw new RSRuntimeException("Could not convert string to utf-8.");
    }
  }
  
  public static Allocation createSized(RenderScript paramRenderScript, Element paramElement, int paramInt)
  {
    return createSized(paramRenderScript, paramElement, paramInt, 1);
  }
  
  public static Allocation createSized(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2)
  {
    if (RenderScript.isNative)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      return AllocationThunker.createSized(paramRenderScript, paramElement, paramInt1, paramInt2);
    }
    paramRenderScript.validate();
    paramElement = new Type.Builder(paramRenderScript, paramElement);
    paramElement.setX(paramInt1);
    paramElement = paramElement.create();
    paramInt1 = paramRenderScript.nAllocationCreateTyped(paramElement.getID(paramRenderScript), Allocation.MipmapControl.MIPMAP_NONE.mID, paramInt2, 0);
    if (paramInt1 == 0) {
      throw new RSRuntimeException("Allocation creation failed.");
    }
    return new Allocation(paramInt1, paramRenderScript, paramElement, paramInt2);
  }
  
  public static Allocation createTyped(RenderScript paramRenderScript, Type paramType)
  {
    return createTyped(paramRenderScript, paramType, Allocation.MipmapControl.MIPMAP_NONE, 1);
  }
  
  public static Allocation createTyped(RenderScript paramRenderScript, Type paramType, int paramInt)
  {
    return createTyped(paramRenderScript, paramType, Allocation.MipmapControl.MIPMAP_NONE, paramInt);
  }
  
  public static Allocation createTyped(RenderScript paramRenderScript, Type paramType, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    if (RenderScript.isNative) {
      return AllocationThunker.createTyped((RenderScriptThunker)paramRenderScript, paramType, paramMipmapControl, paramInt);
    }
    paramRenderScript.validate();
    if (paramType.getID(paramRenderScript) == 0) {
      throw new RSInvalidStateException("Bad Type");
    }
    int i = paramRenderScript.nAllocationCreateTyped(paramType.getID(paramRenderScript), paramMipmapControl.mID, paramInt, 0);
    if (i == 0) {
      throw new RSRuntimeException("Allocation creation failed.");
    }
    return new Allocation(i, paramRenderScript, paramType, paramInt);
  }
  
  private void data1DChecks(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRS.validate();
    if (paramInt1 < 0) {
      throw new RSIllegalArgumentException("Offset must be >= 0.");
    }
    if (paramInt2 < 1) {
      throw new RSIllegalArgumentException("Count must be >= 1.");
    }
    if (paramInt1 + paramInt2 > this.mCurrentCount) {
      throw new RSIllegalArgumentException("Overflow, Available count " + this.mCurrentCount + ", got " + paramInt2 + " at offset " + paramInt1 + ".");
    }
    if (paramInt3 < paramInt4) {
      throw new RSIllegalArgumentException("Array too small for allocation type.");
    }
  }
  
  static Element elementFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.getConfig();
    if (paramBitmap == Bitmap.Config.ALPHA_8) {
      return Element.A_8(paramRenderScript);
    }
    if (paramBitmap == Bitmap.Config.ARGB_4444) {
      return Element.RGBA_4444(paramRenderScript);
    }
    if (paramBitmap == Bitmap.Config.ARGB_8888) {
      return Element.RGBA_8888(paramRenderScript);
    }
    if (paramBitmap == Bitmap.Config.RGB_565) {
      return Element.RGB_565(paramRenderScript);
    }
    throw new RSInvalidStateException("Bad bitmap type: " + paramBitmap);
  }
  
  private int getIDSafe()
  {
    if (this.mAdaptedAllocation != null) {
      return this.mAdaptedAllocation.getID(this.mRS);
    }
    return getID(this.mRS);
  }
  
  private void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  static Type typeFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl)
  {
    paramRenderScript = new Type.Builder(paramRenderScript, elementFromBitmap(paramRenderScript, paramBitmap));
    paramRenderScript.setX(paramBitmap.getWidth());
    paramRenderScript.setY(paramBitmap.getHeight());
    if (paramMipmapControl == Allocation.MipmapControl.MIPMAP_FULL) {}
    for (boolean bool = true;; bool = false)
    {
      paramRenderScript.setMipmaps(bool);
      return paramRenderScript.create();
    }
  }
  
  private void updateCacheInfo(Type paramType)
  {
    this.mCurrentDimX = paramType.getX();
    this.mCurrentDimY = paramType.getY();
    this.mCurrentDimZ = paramType.getZ();
    this.mCurrentCount = this.mCurrentDimX;
    if (this.mCurrentDimY > 1) {
      this.mCurrentCount *= this.mCurrentDimY;
    }
    if (this.mCurrentDimZ > 1) {
      this.mCurrentCount *= this.mCurrentDimZ;
    }
  }
  
  private void validate2DRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAdaptedAllocation != null) {}
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt2 < 0)) {
        throw new RSIllegalArgumentException("Offset cannot be negative.");
      }
      if ((paramInt4 < 0) || (paramInt3 < 0)) {
        throw new RSIllegalArgumentException("Height or width cannot be negative.");
      }
    } while ((paramInt1 + paramInt3 <= this.mCurrentDimX) && (paramInt2 + paramInt4 <= this.mCurrentDimY));
    throw new RSIllegalArgumentException("Updated region larger than allocation.");
  }
  
  private void validate3DRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.mAdaptedAllocation != null) {}
    do
    {
      return;
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0)) {
        throw new RSIllegalArgumentException("Offset cannot be negative.");
      }
      if ((paramInt5 < 0) || (paramInt4 < 0) || (paramInt6 < 0)) {
        throw new RSIllegalArgumentException("Height or width cannot be negative.");
      }
    } while ((paramInt1 + paramInt4 <= this.mCurrentDimX) && (paramInt2 + paramInt5 <= this.mCurrentDimY) && (paramInt3 + paramInt6 <= this.mCurrentDimZ));
    throw new RSIllegalArgumentException("Updated region larger than allocation.");
  }
  
  private void validateBitmapFormat(Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.getConfig();
    if (paramBitmap == null) {
      throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
    }
    switch (Allocation.1.$SwitchMap$android$graphics$Bitmap$Config[paramBitmap.ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.mType.getElement().mKind == Element.DataKind.PIXEL_A);
          throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + paramBitmap);
        } while ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA) && (this.mType.getElement().getBytesSize() == 4));
        throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + paramBitmap);
      } while ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGB) && (this.mType.getElement().getBytesSize() == 2));
      throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + paramBitmap);
    } while ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA) && (this.mType.getElement().getBytesSize() == 2));
    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + paramBitmap);
  }
  
  private void validateBitmapSize(Bitmap paramBitmap)
  {
    if ((this.mCurrentDimX != paramBitmap.getWidth()) || (this.mCurrentDimY != paramBitmap.getHeight())) {
      throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
    }
  }
  
  private void validateIsFloat32()
  {
    if (this.mType.mElement.mType == Element.DataType.FLOAT_32) {
      return;
    }
    throw new RSIllegalArgumentException("32 bit float source does not match allocation type " + this.mType.mElement.mType);
  }
  
  private void validateIsInt16()
  {
    if ((this.mType.mElement.mType == Element.DataType.SIGNED_16) || (this.mType.mElement.mType == Element.DataType.UNSIGNED_16)) {
      return;
    }
    throw new RSIllegalArgumentException("16 bit integer source does not match allocation type " + this.mType.mElement.mType);
  }
  
  private void validateIsInt32()
  {
    if ((this.mType.mElement.mType == Element.DataType.SIGNED_32) || (this.mType.mElement.mType == Element.DataType.UNSIGNED_32)) {
      return;
    }
    throw new RSIllegalArgumentException("32 bit integer source does not match allocation type " + this.mType.mElement.mType);
  }
  
  private void validateIsInt8()
  {
    if ((this.mType.mElement.mType == Element.DataType.SIGNED_8) || (this.mType.mElement.mType == Element.DataType.UNSIGNED_8)) {
      return;
    }
    throw new RSIllegalArgumentException("8 bit integer source does not match allocation type " + this.mType.mElement.mType);
  }
  
  private void validateIsObject()
  {
    if ((this.mType.mElement.mType == Element.DataType.RS_ELEMENT) || (this.mType.mElement.mType == Element.DataType.RS_TYPE) || (this.mType.mElement.mType == Element.DataType.RS_ALLOCATION) || (this.mType.mElement.mType == Element.DataType.RS_SAMPLER) || (this.mType.mElement.mType == Element.DataType.RS_SCRIPT)) {
      return;
    }
    throw new RSIllegalArgumentException("Object source does not match allocation type " + this.mType.mElement.mType);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, Allocation paramAllocation, int paramInt3)
  {
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, 0, this.mSelectedLOD, this.mSelectedFace.mID, paramInt2, 1, paramAllocation.getID(this.mRS), paramInt3, 0, paramAllocation.mSelectedLOD, paramAllocation.mSelectedFace.mID);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfFloat);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    validateIsInt32();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public void copy1DRangeFrom(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    validateIsInt16();
    copy1DRangeFromUnchecked(paramInt1, paramInt2, paramArrayOfShort);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int i = this.mType.mElement.getBytesSize() * paramInt2;
    data1DChecks(paramInt1, paramInt2, paramArrayOfByte.length, i);
    this.mRS.nAllocationData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramArrayOfByte, i);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    int i = this.mType.mElement.getBytesSize() * paramInt2;
    data1DChecks(paramInt1, paramInt2, paramArrayOfFloat.length * 4, i);
    this.mRS.nAllocationData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramArrayOfFloat, i);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = this.mType.mElement.getBytesSize() * paramInt2;
    data1DChecks(paramInt1, paramInt2, paramArrayOfInt.length * 4, i);
    this.mRS.nAllocationData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramArrayOfInt, i);
  }
  
  public void copy1DRangeFromUnchecked(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    int i = this.mType.mElement.getBytesSize() * paramInt2;
    data1DChecks(paramInt1, paramInt2, paramArrayOfShort.length * 2, i);
    this.mRS.nAllocationData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramArrayOfShort, i);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Allocation paramAllocation, int paramInt5, int paramInt6)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramAllocation.getID(this.mRS), paramInt5, paramInt6, paramAllocation.mSelectedLOD, paramAllocation.mSelectedFace.mID);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfFloat);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    validateIsInt32();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort)
  {
    validateIsInt16();
    copy2DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfShort);
  }
  
  public void copy2DRangeFrom(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this.mRS.validate();
    if (paramBitmap.getConfig() == null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      copy2DRangeFrom(paramInt1, paramInt2, localBitmap);
      return;
    }
    validateBitmapFormat(paramBitmap);
    validate2DRange(paramInt1, paramInt2, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramBitmap);
  }
  
  void copy2DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  void copy2DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramArrayOfFloat, paramArrayOfFloat.length * 4);
  }
  
  void copy2DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramArrayOfInt, paramArrayOfInt.length * 4);
  }
  
  void copy2DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfShort)
  {
    this.mRS.validate();
    validate2DRange(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mRS.nAllocationData2D(getIDSafe(), paramInt1, paramInt2, this.mSelectedLOD, this.mSelectedFace.mID, paramInt3, paramInt4, paramArrayOfShort, paramArrayOfShort.length * 2);
  }
  
  public void copy3DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Allocation paramAllocation, int paramInt7, int paramInt8, int paramInt9)
  {
    this.mRS.validate();
    validate3DRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.mRS.nAllocationData3D(getIDSafe(), paramInt1, paramInt2, paramInt3, this.mSelectedLOD, paramInt4, paramInt5, paramInt6, paramAllocation.getID(this.mRS), paramInt7, paramInt8, paramInt9, paramAllocation.mSelectedLOD);
  }
  
  public void copy3DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    validateIsInt8();
    copy3DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfByte);
  }
  
  public void copy3DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    copy3DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfFloat);
  }
  
  public void copy3DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt)
  {
    validateIsInt32();
    copy3DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfInt);
  }
  
  public void copy3DRangeFrom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short[] paramArrayOfShort)
  {
    validateIsInt16();
    copy3DRangeFromUnchecked(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfShort);
  }
  
  void copy3DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    this.mRS.validate();
    validate3DRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.mRS.nAllocationData3D(getIDSafe(), paramInt1, paramInt2, paramInt3, this.mSelectedLOD, paramInt4, paramInt5, paramInt6, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  void copy3DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOfFloat)
  {
    this.mRS.validate();
    validate3DRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.mRS.nAllocationData3D(getIDSafe(), paramInt1, paramInt2, paramInt3, this.mSelectedLOD, paramInt4, paramInt5, paramInt6, paramArrayOfFloat, paramArrayOfFloat.length * 4);
  }
  
  void copy3DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfInt)
  {
    this.mRS.validate();
    validate3DRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.mRS.nAllocationData3D(getIDSafe(), paramInt1, paramInt2, paramInt3, this.mSelectedLOD, paramInt4, paramInt5, paramInt6, paramArrayOfInt, paramArrayOfInt.length * 4);
  }
  
  void copy3DRangeFromUnchecked(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short[] paramArrayOfShort)
  {
    this.mRS.validate();
    validate3DRange(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    this.mRS.nAllocationData3D(getIDSafe(), paramInt1, paramInt2, paramInt3, this.mSelectedLOD, paramInt4, paramInt5, paramInt6, paramArrayOfShort, paramArrayOfShort.length * 2);
  }
  
  public void copyFrom(Bitmap paramBitmap)
  {
    this.mRS.validate();
    if (paramBitmap.getConfig() == null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      copyFrom(localBitmap);
      return;
    }
    validateBitmapSize(paramBitmap);
    validateBitmapFormat(paramBitmap);
    this.mRS.nAllocationCopyFromBitmap(getID(this.mRS), paramBitmap);
  }
  
  public void copyFrom(Allocation paramAllocation)
  {
    this.mRS.validate();
    if (!this.mType.equals(paramAllocation.getType())) {
      throw new RSIllegalArgumentException("Types of allocations must match.");
    }
    copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramAllocation, 0, 0);
  }
  
  public void copyFrom(byte[] paramArrayOfByte)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfByte);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfByte);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfByte);
  }
  
  public void copyFrom(float[] paramArrayOfFloat)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfFloat);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfFloat);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfFloat);
  }
  
  public void copyFrom(int[] paramArrayOfInt)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfInt);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfInt);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfInt);
  }
  
  public void copyFrom(BaseObj[] paramArrayOfBaseObj)
  {
    this.mRS.validate();
    validateIsObject();
    if (paramArrayOfBaseObj.length != this.mCurrentCount) {
      throw new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " + this.mCurrentCount + ", array length = " + paramArrayOfBaseObj.length);
    }
    int[] arrayOfInt = new int[paramArrayOfBaseObj.length];
    int i = 0;
    while (i < paramArrayOfBaseObj.length)
    {
      arrayOfInt[i] = paramArrayOfBaseObj[i].getID(this.mRS);
      i += 1;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, arrayOfInt);
  }
  
  public void copyFrom(short[] paramArrayOfShort)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfShort);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfShort);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfShort);
  }
  
  public void copyFromUnchecked(byte[] paramArrayOfByte)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfByte);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfByte);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramArrayOfByte);
  }
  
  public void copyFromUnchecked(float[] paramArrayOfFloat)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfFloat);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfFloat);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramArrayOfFloat);
  }
  
  public void copyFromUnchecked(int[] paramArrayOfInt)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfInt);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfInt);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramArrayOfInt);
  }
  
  public void copyFromUnchecked(short[] paramArrayOfShort)
  {
    this.mRS.validate();
    if (this.mCurrentDimZ > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, paramArrayOfShort);
      return;
    }
    if (this.mCurrentDimY > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramArrayOfShort);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramArrayOfShort);
  }
  
  public void copyTo(Bitmap paramBitmap)
  {
    this.mRS.validate();
    validateBitmapFormat(paramBitmap);
    validateBitmapSize(paramBitmap);
    this.mRS.nAllocationCopyToBitmap(getID(this.mRS), paramBitmap);
  }
  
  public void copyTo(byte[] paramArrayOfByte)
  {
    validateIsInt8();
    this.mRS.validate();
    this.mRS.nAllocationRead(getID(this.mRS), paramArrayOfByte);
  }
  
  public void copyTo(float[] paramArrayOfFloat)
  {
    validateIsFloat32();
    this.mRS.validate();
    this.mRS.nAllocationRead(getID(this.mRS), paramArrayOfFloat);
  }
  
  public void copyTo(int[] paramArrayOfInt)
  {
    validateIsInt32();
    this.mRS.validate();
    this.mRS.nAllocationRead(getID(this.mRS), paramArrayOfInt);
  }
  
  public void copyTo(short[] paramArrayOfShort)
  {
    validateIsInt16();
    this.mRS.validate();
    this.mRS.nAllocationRead(getID(this.mRS), paramArrayOfShort);
  }
  
  protected void finalize()
  {
    if (RenderScript.sUseGCHooks == true) {
      RenderScript.registerNativeFree.invoke(RenderScript.sRuntime, new Object[] { Integer.valueOf(this.mSize) });
    }
    super.finalize();
  }
  
  public void generateMipmaps()
  {
    this.mRS.nAllocationGenerateMipmaps(getID(this.mRS));
  }
  
  public int getBytesSize()
  {
    return this.mType.getCount() * this.mType.getElement().getBytesSize();
  }
  
  public Element getElement()
  {
    return this.mType.getElement();
  }
  
  public Type getType()
  {
    return this.mType;
  }
  
  public int getUsage()
  {
    return this.mUsage;
  }
  
  public void ioReceive()
  {
    if ((this.mUsage & 0x20) == 0) {
      throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
    }
    this.mRS.validate();
    this.mRS.nAllocationIoReceive(getID(this.mRS));
  }
  
  public void ioSend()
  {
    if ((this.mUsage & 0x40) == 0) {
      throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
    }
    this.mRS.validate();
    this.mRS.nAllocationIoSend(getID(this.mRS));
  }
  
  public void ioSendOutput()
  {
    ioSend();
  }
  
  public void setFromFieldPacker(int paramInt1, int paramInt2, FieldPacker paramFieldPacker)
  {
    this.mRS.validate();
    if (paramInt2 >= this.mType.mElement.mElements.length) {
      throw new RSIllegalArgumentException("Component_number " + paramInt2 + " out of range.");
    }
    if (paramInt1 < 0) {
      throw new RSIllegalArgumentException("Offset must be >= 0.");
    }
    paramFieldPacker = paramFieldPacker.getData();
    int i = this.mType.mElement.mElements[paramInt2].getBytesSize() * this.mType.mElement.mArraySizes[paramInt2];
    if (paramFieldPacker.length != i) {
      throw new RSIllegalArgumentException("Field packer sizelength " + paramFieldPacker.length + " does not match component size " + i + ".");
    }
    this.mRS.nAllocationElementData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramFieldPacker, paramFieldPacker.length);
  }
  
  public void setFromFieldPacker(int paramInt, FieldPacker paramFieldPacker)
  {
    this.mRS.validate();
    int i = this.mType.mElement.getBytesSize();
    paramFieldPacker = paramFieldPacker.getData();
    int j = paramFieldPacker.length / i;
    if (i * j != paramFieldPacker.length) {
      throw new RSIllegalArgumentException("Field packer length " + paramFieldPacker.length + " not divisible by element size " + i + ".");
    }
    copy1DRangeFromUnchecked(paramInt, j, paramFieldPacker);
  }
  
  public void syncAll(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new RSIllegalArgumentException("Source must be exactly one usage type.");
    }
    this.mRS.validate();
    this.mRS.nAllocationSyncAll(getIDSafe(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.Allocation
 * JD-Core Version:    0.7.0.1
 */