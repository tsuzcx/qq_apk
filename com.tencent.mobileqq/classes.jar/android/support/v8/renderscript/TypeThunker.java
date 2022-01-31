package android.support.v8.renderscript;

import android.renderscript.Type.Builder;
import java.util.HashMap;

class TypeThunker
  extends Type
{
  static HashMap<android.renderscript.Type, Type> mMap = new HashMap();
  android.renderscript.Type mN;
  
  TypeThunker(RenderScript arg1, android.renderscript.Type paramType)
  {
    super(0, ???);
    this.mN = paramType;
    internalCalc();
    this.mElement = new ElementThunker(???, paramType.getElement());
    synchronized (mMap)
    {
      mMap.put(this.mN, this);
      return;
    }
  }
  
  static Type create(RenderScript paramRenderScript, Element paramElement, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    paramElement = (ElementThunker)paramElement;
    paramElement = new Type.Builder(((RenderScriptThunker)paramRenderScript).mN, paramElement.mN);
    if (paramInt1 > 0) {
      paramElement.setX(paramInt1);
    }
    if (paramInt2 > 0) {
      paramElement.setY(paramInt2);
    }
    if (paramInt3 > 0) {
      paramElement.setZ(paramInt3);
    }
    if (paramBoolean1) {
      paramElement.setMipmaps(paramBoolean1);
    }
    if (paramBoolean2) {
      paramElement.setFaces(paramBoolean2);
    }
    if (paramInt4 > 0) {
      paramElement.setYuvFormat(paramInt4);
    }
    paramRenderScript = new TypeThunker(paramRenderScript, paramElement.create());
    paramRenderScript.internalCalc();
    return paramRenderScript;
  }
  
  static Type find(android.renderscript.Type paramType)
  {
    return (Type)mMap.get(paramType);
  }
  
  android.renderscript.Type getNObj()
  {
    return this.mN;
  }
  
  void internalCalc()
  {
    this.mDimX = this.mN.getX();
    this.mDimY = this.mN.getY();
    this.mDimZ = this.mN.getZ();
    this.mDimFaces = this.mN.hasFaces();
    this.mDimMipmaps = this.mN.hasMipmaps();
    this.mDimYuv = this.mN.getYuv();
    calcElementCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.TypeThunker
 * JD-Core Version:    0.7.0.1
 */