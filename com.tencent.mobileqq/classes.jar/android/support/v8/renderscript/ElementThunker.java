package android.support.v8.renderscript;

class ElementThunker
  extends Element
{
  android.renderscript.Element mN;
  
  ElementThunker(RenderScript paramRenderScript, android.renderscript.Element paramElement)
  {
    super(0, paramRenderScript);
    this.mN = paramElement;
  }
  
  static android.renderscript.Element.DataKind convertKind(Element.DataKind paramDataKind)
  {
    switch (ElementThunker.1.$SwitchMap$android$support$v8$renderscript$Element$DataKind[paramDataKind.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return android.renderscript.Element.DataKind.USER;
    case 2: 
      return android.renderscript.Element.DataKind.PIXEL_L;
    case 3: 
      return android.renderscript.Element.DataKind.PIXEL_A;
    case 4: 
      return android.renderscript.Element.DataKind.PIXEL_LA;
    case 5: 
      return android.renderscript.Element.DataKind.PIXEL_RGB;
    }
    return android.renderscript.Element.DataKind.PIXEL_RGBA;
  }
  
  static android.renderscript.Element.DataType convertType(Element.DataType paramDataType)
  {
    switch (ElementThunker.1.$SwitchMap$android$support$v8$renderscript$Element$DataType[paramDataType.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return android.renderscript.Element.DataType.NONE;
    case 2: 
      return android.renderscript.Element.DataType.FLOAT_32;
    case 3: 
      return android.renderscript.Element.DataType.FLOAT_64;
    case 4: 
      return android.renderscript.Element.DataType.SIGNED_8;
    case 5: 
      return android.renderscript.Element.DataType.SIGNED_16;
    case 6: 
      return android.renderscript.Element.DataType.SIGNED_32;
    case 7: 
      return android.renderscript.Element.DataType.SIGNED_64;
    case 8: 
      return android.renderscript.Element.DataType.UNSIGNED_8;
    case 9: 
      return android.renderscript.Element.DataType.UNSIGNED_16;
    case 10: 
      return android.renderscript.Element.DataType.UNSIGNED_32;
    case 11: 
      return android.renderscript.Element.DataType.UNSIGNED_64;
    case 12: 
      return android.renderscript.Element.DataType.BOOLEAN;
    case 13: 
      return android.renderscript.Element.DataType.MATRIX_4X4;
    case 14: 
      return android.renderscript.Element.DataType.MATRIX_3X3;
    case 15: 
      return android.renderscript.Element.DataType.MATRIX_2X2;
    case 16: 
      return android.renderscript.Element.DataType.RS_ELEMENT;
    case 17: 
      return android.renderscript.Element.DataType.RS_TYPE;
    case 18: 
      return android.renderscript.Element.DataType.RS_ALLOCATION;
    case 19: 
      return android.renderscript.Element.DataType.RS_SAMPLER;
    }
    return android.renderscript.Element.DataType.RS_SCRIPT;
  }
  
  static Element create(RenderScript paramRenderScript, Element.DataType paramDataType)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    switch (ElementThunker.1.$SwitchMap$android$support$v8$renderscript$Element$DataType[paramDataType.ordinal()])
    {
    default: 
      paramDataType = null;
    }
    for (;;)
    {
      return new ElementThunker(paramRenderScript, paramDataType);
      paramDataType = android.renderscript.Element.F32(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.F64(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.I8(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.I16(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.I32(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.I64(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.U8(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.U16(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.U32(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.U64(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.BOOLEAN(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.MATRIX_4X4(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.MATRIX_3X3(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.MATRIX_2X2(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.ELEMENT(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.TYPE(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.ALLOCATION(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.SAMPLER(localRenderScriptThunker.mN);
      continue;
      paramDataType = android.renderscript.Element.SCRIPT(localRenderScriptThunker.mN);
    }
  }
  
  public static Element createPixel(RenderScript paramRenderScript, Element.DataType paramDataType, Element.DataKind paramDataKind)
  {
    return new ElementThunker(paramRenderScript, android.renderscript.Element.createPixel(((RenderScriptThunker)paramRenderScript).mN, convertType(paramDataType), convertKind(paramDataKind)));
  }
  
  public static Element createVector(RenderScript paramRenderScript, Element.DataType paramDataType, int paramInt)
  {
    return new ElementThunker(paramRenderScript, android.renderscript.Element.createVector(((RenderScriptThunker)paramRenderScript).mN, convertType(paramDataType), paramInt));
  }
  
  public int getBytesSize()
  {
    return this.mN.getBytesSize();
  }
  
  public Element.DataKind getDataKind()
  {
    return this.mKind;
  }
  
  public Element.DataType getDataType()
  {
    return this.mType;
  }
  
  android.renderscript.Element getNObj()
  {
    return this.mN;
  }
  
  public Element getSubElement(int paramInt)
  {
    return new ElementThunker(this.mRS, this.mN.getSubElement(paramInt));
  }
  
  public int getSubElementArraySize(int paramInt)
  {
    return this.mN.getSubElementArraySize(paramInt);
  }
  
  public int getSubElementCount()
  {
    return this.mN.getSubElementCount();
  }
  
  public String getSubElementName(int paramInt)
  {
    return this.mN.getSubElementName(paramInt);
  }
  
  public int getSubElementOffsetBytes(int paramInt)
  {
    return this.mN.getSubElementOffsetBytes(paramInt);
  }
  
  public int getVectorSize()
  {
    return this.mN.getVectorSize();
  }
  
  public boolean isCompatible(Element paramElement)
  {
    return ((ElementThunker)paramElement).mN.isCompatible(this.mN);
  }
  
  public boolean isComplex()
  {
    return this.mN.isComplex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.ElementThunker
 * JD-Core Version:    0.7.0.1
 */