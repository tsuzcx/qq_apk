package android.support.v8.renderscript;

public class Type$Builder
{
  boolean mDimFaces;
  boolean mDimMipmaps;
  int mDimX = 1;
  int mDimY;
  int mDimZ;
  Element mElement;
  RenderScript mRS;
  int mYuv;
  
  public Type$Builder(RenderScript paramRenderScript, Element paramElement)
  {
    paramElement.checkValid();
    this.mRS = paramRenderScript;
    this.mElement = paramElement;
  }
  
  public Type create()
  {
    if (this.mDimZ > 0) {
      if ((this.mDimX >= 1) && (this.mDimY >= 1))
      {
        if (this.mDimFaces) {
          throw new RSInvalidStateException("Cube maps not supported with 3D types.");
        }
      }
      else {
        throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
      }
    }
    if ((this.mDimY > 0) && (this.mDimX < 1)) {
      throw new RSInvalidStateException("X dimension required when Y is present.");
    }
    if ((this.mDimFaces) && (this.mDimY < 1)) {
      throw new RSInvalidStateException("Cube maps require 2D Types.");
    }
    if ((this.mYuv != 0) && ((this.mDimZ != 0) || (this.mDimFaces) || (this.mDimMipmaps))) {
      throw new RSInvalidStateException("YUV only supports basic 2D.");
    }
    Object localObject = this.mRS;
    if (RenderScript.isNative)
    {
      localObject = TypeThunker.create((RenderScriptThunker)this.mRS, this.mElement, this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv);
    }
    else
    {
      localObject = this.mRS;
      localObject = new Type(((RenderScript)localObject).nTypeCreate(this.mElement.getID((RenderScript)localObject), this.mDimX, this.mDimY, this.mDimZ, this.mDimMipmaps, this.mDimFaces, this.mYuv), this.mRS);
    }
    ((Type)localObject).mElement = this.mElement;
    ((Type)localObject).mDimX = this.mDimX;
    ((Type)localObject).mDimY = this.mDimY;
    ((Type)localObject).mDimZ = this.mDimZ;
    ((Type)localObject).mDimMipmaps = this.mDimMipmaps;
    ((Type)localObject).mDimFaces = this.mDimFaces;
    ((Type)localObject).mDimYuv = this.mYuv;
    ((Type)localObject).calcElementCount();
    return localObject;
  }
  
  public Builder setFaces(boolean paramBoolean)
  {
    this.mDimFaces = paramBoolean;
    return this;
  }
  
  public Builder setMipmaps(boolean paramBoolean)
  {
    this.mDimMipmaps = paramBoolean;
    return this;
  }
  
  public Builder setX(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.mDimX = paramInt;
      return this;
    }
    throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
  }
  
  public Builder setY(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.mDimY = paramInt;
      return this;
    }
    throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
  }
  
  public Builder setYuvFormat(int paramInt)
  {
    if ((paramInt != 17) && (paramInt != 842094169)) {
      throw new RSIllegalArgumentException("Only NV21 and YV12 are supported..");
    }
    this.mYuv = paramInt;
    return this;
  }
  
  public Builder setZ(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.mDimZ = paramInt;
      return this;
    }
    throw new RSIllegalArgumentException("Values of less than 1 for Dimension Z are not valid.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Type.Builder
 * JD-Core Version:    0.7.0.1
 */