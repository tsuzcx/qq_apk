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
    case 6: 
      return android.renderscript.Element.DataKind.PIXEL_RGBA;
    case 5: 
      return android.renderscript.Element.DataKind.PIXEL_RGB;
    case 4: 
      return android.renderscript.Element.DataKind.PIXEL_LA;
    case 3: 
      return android.renderscript.Element.DataKind.PIXEL_A;
    case 2: 
      return android.renderscript.Element.DataKind.PIXEL_L;
    }
    return android.renderscript.Element.DataKind.USER;
  }
  
  static android.renderscript.Element.DataType convertType(Element.DataType paramDataType)
  {
    switch (ElementThunker.1.$SwitchMap$android$support$v8$renderscript$Element$DataType[paramDataType.ordinal()])
    {
    default: 
      return null;
    case 20: 
      return android.renderscript.Element.DataType.RS_SCRIPT;
    case 19: 
      return android.renderscript.Element.DataType.RS_SAMPLER;
    case 18: 
      return android.renderscript.Element.DataType.RS_ALLOCATION;
    case 17: 
      return android.renderscript.Element.DataType.RS_TYPE;
    case 16: 
      return android.renderscript.Element.DataType.RS_ELEMENT;
    case 15: 
      return android.renderscript.Element.DataType.MATRIX_2X2;
    case 14: 
      return android.renderscript.Element.DataType.MATRIX_3X3;
    case 13: 
      return android.renderscript.Element.DataType.MATRIX_4X4;
    case 12: 
      return android.renderscript.Element.DataType.BOOLEAN;
    case 11: 
      return android.renderscript.Element.DataType.UNSIGNED_64;
    case 10: 
      return android.renderscript.Element.DataType.UNSIGNED_32;
    case 9: 
      return android.renderscript.Element.DataType.UNSIGNED_16;
    case 8: 
      return android.renderscript.Element.DataType.UNSIGNED_8;
    case 7: 
      return android.renderscript.Element.DataType.SIGNED_64;
    case 6: 
      return android.renderscript.Element.DataType.SIGNED_32;
    case 5: 
      return android.renderscript.Element.DataType.SIGNED_16;
    case 4: 
      return android.renderscript.Element.DataType.SIGNED_8;
    case 3: 
      return android.renderscript.Element.DataType.FLOAT_64;
    case 2: 
      return android.renderscript.Element.DataType.FLOAT_32;
    }
    return android.renderscript.Element.DataType.NONE;
  }
  
  static Element create(RenderScript paramRenderScript, Element.DataType paramDataType)
  {
    RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
    switch (ElementThunker.1.$SwitchMap$android$support$v8$renderscript$Element$DataType[paramDataType.ordinal()])
    {
    default: 
      paramDataType = null;
      break;
    case 20: 
      paramDataType = android.renderscript.Element.SCRIPT(localRenderScriptThunker.mN);
      break;
    case 19: 
      paramDataType = android.renderscript.Element.SAMPLER(localRenderScriptThunker.mN);
      break;
    case 18: 
      paramDataType = android.renderscript.Element.ALLOCATION(localRenderScriptThunker.mN);
      break;
    case 17: 
      paramDataType = android.renderscript.Element.TYPE(localRenderScriptThunker.mN);
      break;
    case 16: 
      paramDataType = android.renderscript.Element.ELEMENT(localRenderScriptThunker.mN);
      break;
    case 15: 
      paramDataType = android.renderscript.Element.MATRIX_2X2(localRenderScriptThunker.mN);
      break;
    case 14: 
      paramDataType = android.renderscript.Element.MATRIX_3X3(localRenderScriptThunker.mN);
      break;
    case 13: 
      paramDataType = android.renderscript.Element.MATRIX_4X4(localRenderScriptThunker.mN);
      break;
    case 12: 
      paramDataType = android.renderscript.Element.BOOLEAN(localRenderScriptThunker.mN);
      break;
    case 11: 
      paramDataType = android.renderscript.Element.U64(localRenderScriptThunker.mN);
      break;
    case 10: 
      paramDataType = android.renderscript.Element.U32(localRenderScriptThunker.mN);
      break;
    case 9: 
      paramDataType = android.renderscript.Element.U16(localRenderScriptThunker.mN);
      break;
    case 8: 
      paramDataType = android.renderscript.Element.U8(localRenderScriptThunker.mN);
      break;
    case 7: 
      paramDataType = android.renderscript.Element.I64(localRenderScriptThunker.mN);
      break;
    case 6: 
      paramDataType = android.renderscript.Element.I32(localRenderScriptThunker.mN);
      break;
    case 5: 
      paramDataType = android.renderscript.Element.I16(localRenderScriptThunker.mN);
      break;
    case 4: 
      paramDataType = android.renderscript.Element.I8(localRenderScriptThunker.mN);
      break;
    case 3: 
      paramDataType = android.renderscript.Element.F64(localRenderScriptThunker.mN);
      break;
    case 2: 
      paramDataType = android.renderscript.Element.F32(localRenderScriptThunker.mN);
    }
    return new ElementThunker(paramRenderScript, paramDataType);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.ElementThunker
 * JD-Core Version:    0.7.0.1
 */