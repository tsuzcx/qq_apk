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
    if ((paramInt2 & 0xFFFFFF1C) == 0)
    {
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
      if (RenderScript.sUseGCHooks == true) {
        try
        {
          RenderScript.registerNativeAllocation.invoke(RenderScript.sRuntime, new Object[] { Integer.valueOf(this.mSize) });
          return;
        }
        catch (Exception paramRenderScript)
        {
          paramType = new StringBuilder();
          paramType.append("Couldn't invoke registerNativeAllocation:");
          paramType.append(paramRenderScript);
          Log.e("RenderScript_jni", paramType.toString());
          paramType = new StringBuilder();
          paramType.append("Couldn't invoke registerNativeAllocation:");
          paramType.append(paramRenderScript);
          throw new RSRuntimeException(paramType.toString());
        }
      }
      return;
    }
    throw new RSIllegalArgumentException("Unknown usage specified.");
  }
  
  public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap)
  {
    return createCubemapFromBitmap(paramRenderScript, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 2);
  }
  
  public static Allocation createCubemapFromBitmap(RenderScript paramRenderScript, Bitmap paramBitmap, Allocation.MipmapControl paramMipmapControl, int paramInt)
  {
    paramRenderScript.validate();
    int j = paramBitmap.getHeight();
    int i = paramBitmap.getWidth();
    if (i % 6 == 0)
    {
      if (i / 6 == j)
      {
        boolean bool = false;
        if ((j - 1 & j) == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          Element localElement = elementFromBitmap(paramRenderScript, paramBitmap);
          Object localObject = new Type.Builder(paramRenderScript, localElement);
          ((Type.Builder)localObject).setX(j);
          ((Type.Builder)localObject).setY(j);
          ((Type.Builder)localObject).setFaces(true);
          if (paramMipmapControl == Allocation.MipmapControl.MIPMAP_FULL) {
            bool = true;
          }
          ((Type.Builder)localObject).setMipmaps(bool);
          localObject = ((Type.Builder)localObject).create();
          i = paramRenderScript.nAllocationCubeCreateFromBitmap(((Type)localObject).getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
          if (i != 0) {
            return new Allocation(i, paramRenderScript, (Type)localObject, paramInt);
          }
          paramRenderScript = new StringBuilder();
          paramRenderScript.append("Load failed for bitmap ");
          paramRenderScript.append(paramBitmap);
          paramRenderScript.append(" element ");
          paramRenderScript.append(localElement);
          throw new RSRuntimeException(paramRenderScript.toString());
        }
        throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
      }
      throw new RSIllegalArgumentException("Only square cube map faces supported");
    }
    throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
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
      if ((paramInt & 0x80) == 0)
      {
        localObject = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
        return createFromBitmap(paramRenderScript, (Bitmap)localObject, paramMipmapControl, paramInt);
      }
      throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
    }
    Object localObject = typeFromBitmap(paramRenderScript, paramBitmap, paramMipmapControl);
    if ((paramMipmapControl == Allocation.MipmapControl.MIPMAP_NONE) && (((Type)localObject).getElement().isCompatible(Element.RGBA_8888(paramRenderScript))) && (paramInt == 131))
    {
      i = paramRenderScript.nAllocationCreateBitmapBackedAllocation(((Type)localObject).getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
      if (i != 0)
      {
        paramRenderScript = new Allocation(i, paramRenderScript, (Type)localObject, paramInt);
        paramRenderScript.setBitmap(paramBitmap);
        return paramRenderScript;
      }
      throw new RSRuntimeException("Load failed.");
    }
    int i = paramRenderScript.nAllocationCreateFromBitmap(((Type)localObject).getID(paramRenderScript), paramMipmapControl.mID, paramBitmap, paramInt);
    if (i != 0) {
      return new Allocation(i, paramRenderScript, (Type)localObject, paramInt);
    }
    throw new RSRuntimeException("Load failed.");
  }
  
  public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt)
  {
    return createFromBitmapResource(paramRenderScript, paramResources, paramInt, Allocation.MipmapControl.MIPMAP_NONE, 3);
  }
  
  public static Allocation createFromBitmapResource(RenderScript paramRenderScript, Resources paramResources, int paramInt1, Allocation.MipmapControl paramMipmapControl, int paramInt2)
  {
    paramRenderScript.validate();
    if ((paramInt2 & 0xE0) == 0)
    {
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt1);
      paramRenderScript = createFromBitmap(paramRenderScript, paramResources, paramMipmapControl, paramInt2);
      paramResources.recycle();
      return paramRenderScript;
    }
    throw new RSIllegalArgumentException("Unsupported usage specified.");
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
      label31:
      break label31;
    }
    throw new RSRuntimeException("Could not convert string to utf-8.");
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
    if (paramInt1 != 0) {
      return new Allocation(paramInt1, paramRenderScript, paramElement, paramInt2);
    }
    throw new RSRuntimeException("Allocation creation failed.");
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
    if (paramType.getID(paramRenderScript) != 0)
    {
      int i = paramRenderScript.nAllocationCreateTyped(paramType.getID(paramRenderScript), paramMipmapControl.mID, paramInt, 0);
      if (i != 0) {
        return new Allocation(i, paramRenderScript, paramType, paramInt);
      }
      throw new RSRuntimeException("Allocation creation failed.");
    }
    throw new RSInvalidStateException("Bad Type");
  }
  
  private void data1DChecks(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRS.validate();
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 1)
      {
        if (paramInt1 + paramInt2 <= this.mCurrentCount)
        {
          if (paramInt3 >= paramInt4) {
            return;
          }
          throw new RSIllegalArgumentException("Array too small for allocation type.");
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Overflow, Available count ");
        localStringBuilder.append(this.mCurrentCount);
        localStringBuilder.append(", got ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" at offset ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(".");
        throw new RSIllegalArgumentException(localStringBuilder.toString());
      }
      throw new RSIllegalArgumentException("Count must be >= 1.");
    }
    throw new RSIllegalArgumentException("Offset must be >= 0.");
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
    paramRenderScript = new StringBuilder();
    paramRenderScript.append("Bad bitmap type: ");
    paramRenderScript.append(paramBitmap);
    throw new RSInvalidStateException(paramRenderScript.toString());
  }
  
  private int getIDSafe()
  {
    Allocation localAllocation = this.mAdaptedAllocation;
    if (localAllocation != null) {
      return localAllocation.getID(this.mRS);
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
    boolean bool;
    if (paramMipmapControl == Allocation.MipmapControl.MIPMAP_FULL) {
      bool = true;
    } else {
      bool = false;
    }
    paramRenderScript.setMipmaps(bool);
    return paramRenderScript.create();
  }
  
  private void updateCacheInfo(Type paramType)
  {
    this.mCurrentDimX = paramType.getX();
    this.mCurrentDimY = paramType.getY();
    this.mCurrentDimZ = paramType.getZ();
    this.mCurrentCount = this.mCurrentDimX;
    int i = this.mCurrentDimY;
    if (i > 1) {
      this.mCurrentCount *= i;
    }
    i = this.mCurrentDimZ;
    if (i > 1) {
      this.mCurrentCount *= i;
    }
  }
  
  private void validate2DRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mAdaptedAllocation != null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if ((paramInt4 >= 0) && (paramInt3 >= 0))
      {
        if ((paramInt1 + paramInt3 <= this.mCurrentDimX) && (paramInt2 + paramInt4 <= this.mCurrentDimY)) {
          return;
        }
        throw new RSIllegalArgumentException("Updated region larger than allocation.");
      }
      throw new RSIllegalArgumentException("Height or width cannot be negative.");
    }
    throw new RSIllegalArgumentException("Offset cannot be negative.");
  }
  
  private void validate3DRange(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.mAdaptedAllocation != null) {
      return;
    }
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0))
    {
      if ((paramInt5 >= 0) && (paramInt4 >= 0) && (paramInt6 >= 0))
      {
        if ((paramInt1 + paramInt4 <= this.mCurrentDimX) && (paramInt2 + paramInt5 <= this.mCurrentDimY) && (paramInt3 + paramInt6 <= this.mCurrentDimZ)) {
          return;
        }
        throw new RSIllegalArgumentException("Updated region larger than allocation.");
      }
      throw new RSIllegalArgumentException("Height or width cannot be negative.");
    }
    throw new RSIllegalArgumentException("Offset cannot be negative.");
  }
  
  private void validateBitmapFormat(Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.getConfig();
    if (paramBitmap != null)
    {
      int i = Allocation.1.$SwitchMap$android$graphics$Bitmap$Config[paramBitmap.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            if ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA) && (this.mType.getElement().getBytesSize() == 2)) {
              return;
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Allocation kind is ");
            localStringBuilder.append(this.mType.getElement().mKind);
            localStringBuilder.append(", type ");
            localStringBuilder.append(this.mType.getElement().mType);
            localStringBuilder.append(" of ");
            localStringBuilder.append(this.mType.getElement().getBytesSize());
            localStringBuilder.append(" bytes, passed bitmap was ");
            localStringBuilder.append(paramBitmap);
            throw new RSIllegalArgumentException(localStringBuilder.toString());
          }
          if ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGB) && (this.mType.getElement().getBytesSize() == 2)) {
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Allocation kind is ");
          localStringBuilder.append(this.mType.getElement().mKind);
          localStringBuilder.append(", type ");
          localStringBuilder.append(this.mType.getElement().mType);
          localStringBuilder.append(" of ");
          localStringBuilder.append(this.mType.getElement().getBytesSize());
          localStringBuilder.append(" bytes, passed bitmap was ");
          localStringBuilder.append(paramBitmap);
          throw new RSIllegalArgumentException(localStringBuilder.toString());
        }
        if ((this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA) && (this.mType.getElement().getBytesSize() == 4)) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Allocation kind is ");
        localStringBuilder.append(this.mType.getElement().mKind);
        localStringBuilder.append(", type ");
        localStringBuilder.append(this.mType.getElement().mType);
        localStringBuilder.append(" of ");
        localStringBuilder.append(this.mType.getElement().getBytesSize());
        localStringBuilder.append(" bytes, passed bitmap was ");
        localStringBuilder.append(paramBitmap);
        throw new RSIllegalArgumentException(localStringBuilder.toString());
      }
      if (this.mType.getElement().mKind == Element.DataKind.PIXEL_A) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Allocation kind is ");
      localStringBuilder.append(this.mType.getElement().mKind);
      localStringBuilder.append(", type ");
      localStringBuilder.append(this.mType.getElement().mType);
      localStringBuilder.append(" of ");
      localStringBuilder.append(this.mType.getElement().getBytesSize());
      localStringBuilder.append(" bytes, passed bitmap was ");
      localStringBuilder.append(paramBitmap);
      throw new RSIllegalArgumentException(localStringBuilder.toString());
    }
    throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
  }
  
  private void validateBitmapSize(Bitmap paramBitmap)
  {
    if ((this.mCurrentDimX == paramBitmap.getWidth()) && (this.mCurrentDimY == paramBitmap.getHeight())) {
      return;
    }
    throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
  }
  
  private void validateIsFloat32()
  {
    if (this.mType.mElement.mType == Element.DataType.FLOAT_32) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("32 bit float source does not match allocation type ");
    localStringBuilder.append(this.mType.mElement.mType);
    throw new RSIllegalArgumentException(localStringBuilder.toString());
  }
  
  private void validateIsInt16()
  {
    if (this.mType.mElement.mType != Element.DataType.SIGNED_16)
    {
      if (this.mType.mElement.mType == Element.DataType.UNSIGNED_16) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("16 bit integer source does not match allocation type ");
      localStringBuilder.append(this.mType.mElement.mType);
      throw new RSIllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  private void validateIsInt32()
  {
    if (this.mType.mElement.mType != Element.DataType.SIGNED_32)
    {
      if (this.mType.mElement.mType == Element.DataType.UNSIGNED_32) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("32 bit integer source does not match allocation type ");
      localStringBuilder.append(this.mType.mElement.mType);
      throw new RSIllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  private void validateIsInt8()
  {
    if (this.mType.mElement.mType != Element.DataType.SIGNED_8)
    {
      if (this.mType.mElement.mType == Element.DataType.UNSIGNED_8) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("8 bit integer source does not match allocation type ");
      localStringBuilder.append(this.mType.mElement.mType);
      throw new RSIllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  private void validateIsObject()
  {
    if ((this.mType.mElement.mType != Element.DataType.RS_ELEMENT) && (this.mType.mElement.mType != Element.DataType.RS_TYPE) && (this.mType.mElement.mType != Element.DataType.RS_ALLOCATION) && (this.mType.mElement.mType != Element.DataType.RS_SAMPLER))
    {
      if (this.mType.mElement.mType == Element.DataType.RS_SCRIPT) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Object source does not match allocation type ");
      localStringBuilder.append(this.mType.mElement.mType);
      throw new RSIllegalArgumentException(localStringBuilder.toString());
    }
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
    if (this.mType.equals(paramAllocation.getType()))
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, paramAllocation, 0, 0);
      return;
    }
    throw new RSIllegalArgumentException("Types of allocations must match.");
  }
  
  public void copyFrom(byte[] paramArrayOfByte)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfByte);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, i, paramArrayOfByte);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfByte);
  }
  
  public void copyFrom(float[] paramArrayOfFloat)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfFloat);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, i, paramArrayOfFloat);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfFloat);
  }
  
  public void copyFrom(int[] paramArrayOfInt)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfInt);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, i, paramArrayOfInt);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfInt);
  }
  
  public void copyFrom(BaseObj[] paramArrayOfBaseObj)
  {
    this.mRS.validate();
    validateIsObject();
    if (paramArrayOfBaseObj.length == this.mCurrentCount)
    {
      localObject = new int[paramArrayOfBaseObj.length];
      int i = 0;
      while (i < paramArrayOfBaseObj.length)
      {
        localObject[i] = paramArrayOfBaseObj[i].getID(this.mRS);
        i += 1;
      }
      copy1DRangeFromUnchecked(0, this.mCurrentCount, (int[])localObject);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Array size mismatch, allocation sizeX = ");
    ((StringBuilder)localObject).append(this.mCurrentCount);
    ((StringBuilder)localObject).append(", array length = ");
    ((StringBuilder)localObject).append(paramArrayOfBaseObj.length);
    paramArrayOfBaseObj = new RSIllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramArrayOfBaseObj;
    }
  }
  
  public void copyFrom(short[] paramArrayOfShort)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFrom(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfShort);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFrom(0, 0, this.mCurrentDimX, i, paramArrayOfShort);
      return;
    }
    copy1DRangeFrom(0, this.mCurrentCount, paramArrayOfShort);
  }
  
  public void copyFromUnchecked(byte[] paramArrayOfByte)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfByte);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i, paramArrayOfByte);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramArrayOfByte);
  }
  
  public void copyFromUnchecked(float[] paramArrayOfFloat)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfFloat);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i, paramArrayOfFloat);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramArrayOfFloat);
  }
  
  public void copyFromUnchecked(int[] paramArrayOfInt)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfInt);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i, paramArrayOfInt);
      return;
    }
    copy1DRangeFromUnchecked(0, this.mCurrentCount, paramArrayOfInt);
  }
  
  public void copyFromUnchecked(short[] paramArrayOfShort)
  {
    this.mRS.validate();
    int i = this.mCurrentDimZ;
    if (i > 0)
    {
      copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i, paramArrayOfShort);
      return;
    }
    i = this.mCurrentDimY;
    if (i > 0)
    {
      copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i, paramArrayOfShort);
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
    if ((this.mUsage & 0x20) != 0)
    {
      this.mRS.validate();
      this.mRS.nAllocationIoReceive(getID(this.mRS));
      return;
    }
    throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
  }
  
  public void ioSend()
  {
    if ((this.mUsage & 0x40) != 0)
    {
      this.mRS.validate();
      this.mRS.nAllocationIoSend(getID(this.mRS));
      return;
    }
    throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
  }
  
  public void ioSendOutput()
  {
    ioSend();
  }
  
  public void setFromFieldPacker(int paramInt1, int paramInt2, FieldPacker paramFieldPacker)
  {
    this.mRS.validate();
    if (paramInt2 < this.mType.mElement.mElements.length)
    {
      if (paramInt1 >= 0)
      {
        paramFieldPacker = paramFieldPacker.getData();
        int i = this.mType.mElement.mElements[paramInt2].getBytesSize() * this.mType.mElement.mArraySizes[paramInt2];
        if (paramFieldPacker.length == i)
        {
          this.mRS.nAllocationElementData1D(getIDSafe(), paramInt1, this.mSelectedLOD, paramInt2, paramFieldPacker, paramFieldPacker.length);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Field packer sizelength ");
        localStringBuilder.append(paramFieldPacker.length);
        localStringBuilder.append(" does not match component size ");
        localStringBuilder.append(i);
        localStringBuilder.append(".");
        throw new RSIllegalArgumentException(localStringBuilder.toString());
      }
      throw new RSIllegalArgumentException("Offset must be >= 0.");
    }
    paramFieldPacker = new StringBuilder();
    paramFieldPacker.append("Component_number ");
    paramFieldPacker.append(paramInt2);
    paramFieldPacker.append(" out of range.");
    throw new RSIllegalArgumentException(paramFieldPacker.toString());
  }
  
  public void setFromFieldPacker(int paramInt, FieldPacker paramFieldPacker)
  {
    this.mRS.validate();
    int i = this.mType.mElement.getBytesSize();
    paramFieldPacker = paramFieldPacker.getData();
    int j = paramFieldPacker.length / i;
    if (i * j == paramFieldPacker.length)
    {
      copy1DRangeFromUnchecked(paramInt, j, paramFieldPacker);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Field packer length ");
    localStringBuilder.append(paramFieldPacker.length);
    localStringBuilder.append(" not divisible by element size ");
    localStringBuilder.append(i);
    localStringBuilder.append(".");
    throw new RSIllegalArgumentException(localStringBuilder.toString());
  }
  
  public void syncAll(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      throw new RSIllegalArgumentException("Source must be exactly one usage type.");
    }
    this.mRS.validate();
    this.mRS.nAllocationSyncAll(getIDSafe(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Allocation
 * JD-Core Version:    0.7.0.1
 */