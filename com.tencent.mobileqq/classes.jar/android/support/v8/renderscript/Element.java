package android.support.v8.renderscript;

public class Element
  extends BaseObj
{
  int[] mArraySizes;
  String[] mElementNames;
  Element[] mElements;
  Element.DataKind mKind;
  boolean mNormalized;
  int[] mOffsetInBytes;
  int mSize;
  Element.DataType mType;
  int mVectorSize;
  int[] mVisibleElementMap;
  
  Element(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  Element(int paramInt1, RenderScript paramRenderScript, Element.DataType paramDataType, Element.DataKind paramDataKind, boolean paramBoolean, int paramInt2)
  {
    super(paramInt1, paramRenderScript);
    if ((paramDataType != Element.DataType.UNSIGNED_5_6_5) && (paramDataType != Element.DataType.UNSIGNED_4_4_4_4) && (paramDataType != Element.DataType.UNSIGNED_5_5_5_1))
    {
      if (paramInt2 == 3) {
        this.mSize = (paramDataType.mSize * 4);
      } else {
        this.mSize = (paramDataType.mSize * paramInt2);
      }
    }
    else {
      this.mSize = paramDataType.mSize;
    }
    this.mType = paramDataType;
    this.mKind = paramDataKind;
    this.mNormalized = paramBoolean;
    this.mVectorSize = paramInt2;
  }
  
  Element(int paramInt, RenderScript paramRenderScript, Element[] paramArrayOfElement, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramInt, paramRenderScript);
    paramInt = 0;
    this.mSize = 0;
    this.mVectorSize = 1;
    this.mElements = paramArrayOfElement;
    this.mElementNames = paramArrayOfString;
    this.mArraySizes = paramArrayOfInt;
    this.mType = Element.DataType.NONE;
    this.mKind = Element.DataKind.USER;
    this.mOffsetInBytes = new int[this.mElements.length];
    for (;;)
    {
      paramRenderScript = this.mElements;
      if (paramInt >= paramRenderScript.length) {
        break;
      }
      paramArrayOfElement = this.mOffsetInBytes;
      int i = this.mSize;
      paramArrayOfElement[paramInt] = i;
      this.mSize = (i + paramRenderScript[paramInt].mSize * this.mArraySizes[paramInt]);
      paramInt += 1;
    }
    updateVisibleSubElements();
  }
  
  public static Element ALLOCATION(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ALLOCATION == null) {
      paramRenderScript.mElement_ALLOCATION = createUser(paramRenderScript, Element.DataType.RS_ALLOCATION);
    }
    return paramRenderScript.mElement_ALLOCATION;
  }
  
  public static Element A_8(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_A_8 == null) {
      paramRenderScript.mElement_A_8 = createPixel(paramRenderScript, Element.DataType.UNSIGNED_8, Element.DataKind.PIXEL_A);
    }
    return paramRenderScript.mElement_A_8;
  }
  
  public static Element BOOLEAN(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_BOOLEAN == null) {
      paramRenderScript.mElement_BOOLEAN = createUser(paramRenderScript, Element.DataType.BOOLEAN);
    }
    return paramRenderScript.mElement_BOOLEAN;
  }
  
  public static Element ELEMENT(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ELEMENT == null) {
      paramRenderScript.mElement_ELEMENT = createUser(paramRenderScript, Element.DataType.RS_ELEMENT);
    }
    return paramRenderScript.mElement_ELEMENT;
  }
  
  public static Element F32(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_F32 == null) {
      paramRenderScript.mElement_F32 = createUser(paramRenderScript, Element.DataType.FLOAT_32);
    }
    return paramRenderScript.mElement_F32;
  }
  
  public static Element F32_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_FLOAT_2 == null) {
      paramRenderScript.mElement_FLOAT_2 = createVector(paramRenderScript, Element.DataType.FLOAT_32, 2);
    }
    return paramRenderScript.mElement_FLOAT_2;
  }
  
  public static Element F32_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_FLOAT_3 == null) {
      paramRenderScript.mElement_FLOAT_3 = createVector(paramRenderScript, Element.DataType.FLOAT_32, 3);
    }
    return paramRenderScript.mElement_FLOAT_3;
  }
  
  public static Element F32_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_FLOAT_4 == null) {
      paramRenderScript.mElement_FLOAT_4 = createVector(paramRenderScript, Element.DataType.FLOAT_32, 4);
    }
    return paramRenderScript.mElement_FLOAT_4;
  }
  
  public static Element F64(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_F64 == null) {
      paramRenderScript.mElement_F64 = createUser(paramRenderScript, Element.DataType.FLOAT_64);
    }
    return paramRenderScript.mElement_F64;
  }
  
  public static Element F64_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_DOUBLE_2 == null) {
      paramRenderScript.mElement_DOUBLE_2 = createVector(paramRenderScript, Element.DataType.FLOAT_64, 2);
    }
    return paramRenderScript.mElement_DOUBLE_2;
  }
  
  public static Element F64_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_DOUBLE_3 == null) {
      paramRenderScript.mElement_DOUBLE_3 = createVector(paramRenderScript, Element.DataType.FLOAT_64, 3);
    }
    return paramRenderScript.mElement_DOUBLE_3;
  }
  
  public static Element F64_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_DOUBLE_4 == null) {
      paramRenderScript.mElement_DOUBLE_4 = createVector(paramRenderScript, Element.DataType.FLOAT_64, 4);
    }
    return paramRenderScript.mElement_DOUBLE_4;
  }
  
  public static Element I16(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I16 == null) {
      paramRenderScript.mElement_I16 = createUser(paramRenderScript, Element.DataType.SIGNED_16);
    }
    return paramRenderScript.mElement_I16;
  }
  
  public static Element I16_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SHORT_2 == null) {
      paramRenderScript.mElement_SHORT_2 = createVector(paramRenderScript, Element.DataType.SIGNED_16, 2);
    }
    return paramRenderScript.mElement_SHORT_2;
  }
  
  public static Element I16_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SHORT_3 == null) {
      paramRenderScript.mElement_SHORT_3 = createVector(paramRenderScript, Element.DataType.SIGNED_16, 3);
    }
    return paramRenderScript.mElement_SHORT_3;
  }
  
  public static Element I16_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SHORT_4 == null) {
      paramRenderScript.mElement_SHORT_4 = createVector(paramRenderScript, Element.DataType.SIGNED_16, 4);
    }
    return paramRenderScript.mElement_SHORT_4;
  }
  
  public static Element I32(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I32 == null) {
      paramRenderScript.mElement_I32 = createUser(paramRenderScript, Element.DataType.SIGNED_32);
    }
    return paramRenderScript.mElement_I32;
  }
  
  public static Element I32_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_INT_2 == null) {
      paramRenderScript.mElement_INT_2 = createVector(paramRenderScript, Element.DataType.SIGNED_32, 2);
    }
    return paramRenderScript.mElement_INT_2;
  }
  
  public static Element I32_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_INT_3 == null) {
      paramRenderScript.mElement_INT_3 = createVector(paramRenderScript, Element.DataType.SIGNED_32, 3);
    }
    return paramRenderScript.mElement_INT_3;
  }
  
  public static Element I32_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_INT_4 == null) {
      paramRenderScript.mElement_INT_4 = createVector(paramRenderScript, Element.DataType.SIGNED_32, 4);
    }
    return paramRenderScript.mElement_INT_4;
  }
  
  public static Element I64(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I64 == null) {
      paramRenderScript.mElement_I64 = createUser(paramRenderScript, Element.DataType.SIGNED_64);
    }
    return paramRenderScript.mElement_I64;
  }
  
  public static Element I64_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_LONG_2 == null) {
      paramRenderScript.mElement_LONG_2 = createVector(paramRenderScript, Element.DataType.SIGNED_64, 2);
    }
    return paramRenderScript.mElement_LONG_2;
  }
  
  public static Element I64_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_LONG_3 == null) {
      paramRenderScript.mElement_LONG_3 = createVector(paramRenderScript, Element.DataType.SIGNED_64, 3);
    }
    return paramRenderScript.mElement_LONG_3;
  }
  
  public static Element I64_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_LONG_4 == null) {
      paramRenderScript.mElement_LONG_4 = createVector(paramRenderScript, Element.DataType.SIGNED_64, 4);
    }
    return paramRenderScript.mElement_LONG_4;
  }
  
  public static Element I8(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_I8 == null) {
      paramRenderScript.mElement_I8 = createUser(paramRenderScript, Element.DataType.SIGNED_8);
    }
    return paramRenderScript.mElement_I8;
  }
  
  public static Element I8_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_CHAR_2 == null) {
      paramRenderScript.mElement_CHAR_2 = createVector(paramRenderScript, Element.DataType.SIGNED_8, 2);
    }
    return paramRenderScript.mElement_CHAR_2;
  }
  
  public static Element I8_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_CHAR_3 == null) {
      paramRenderScript.mElement_CHAR_3 = createVector(paramRenderScript, Element.DataType.SIGNED_8, 3);
    }
    return paramRenderScript.mElement_CHAR_3;
  }
  
  public static Element I8_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_CHAR_4 == null) {
      paramRenderScript.mElement_CHAR_4 = createVector(paramRenderScript, Element.DataType.SIGNED_8, 4);
    }
    return paramRenderScript.mElement_CHAR_4;
  }
  
  public static Element MATRIX_2X2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_MATRIX_2X2 == null) {
      paramRenderScript.mElement_MATRIX_2X2 = createUser(paramRenderScript, Element.DataType.MATRIX_2X2);
    }
    return paramRenderScript.mElement_MATRIX_2X2;
  }
  
  public static Element MATRIX_3X3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_MATRIX_3X3 == null) {
      paramRenderScript.mElement_MATRIX_3X3 = createUser(paramRenderScript, Element.DataType.MATRIX_3X3);
    }
    return paramRenderScript.mElement_MATRIX_3X3;
  }
  
  public static Element MATRIX_4X4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_MATRIX_4X4 == null) {
      paramRenderScript.mElement_MATRIX_4X4 = createUser(paramRenderScript, Element.DataType.MATRIX_4X4);
    }
    return paramRenderScript.mElement_MATRIX_4X4;
  }
  
  public static Element RGBA_4444(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGBA_4444 == null) {
      paramRenderScript.mElement_RGBA_4444 = createPixel(paramRenderScript, Element.DataType.UNSIGNED_4_4_4_4, Element.DataKind.PIXEL_RGBA);
    }
    return paramRenderScript.mElement_RGBA_4444;
  }
  
  public static Element RGBA_5551(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGBA_5551 == null) {
      paramRenderScript.mElement_RGBA_5551 = createPixel(paramRenderScript, Element.DataType.UNSIGNED_5_5_5_1, Element.DataKind.PIXEL_RGBA);
    }
    return paramRenderScript.mElement_RGBA_5551;
  }
  
  public static Element RGBA_8888(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGBA_8888 == null) {
      paramRenderScript.mElement_RGBA_8888 = createPixel(paramRenderScript, Element.DataType.UNSIGNED_8, Element.DataKind.PIXEL_RGBA);
    }
    return paramRenderScript.mElement_RGBA_8888;
  }
  
  public static Element RGB_565(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGB_565 == null) {
      paramRenderScript.mElement_RGB_565 = createPixel(paramRenderScript, Element.DataType.UNSIGNED_5_6_5, Element.DataKind.PIXEL_RGB);
    }
    return paramRenderScript.mElement_RGB_565;
  }
  
  public static Element RGB_888(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_RGB_888 == null) {
      paramRenderScript.mElement_RGB_888 = createPixel(paramRenderScript, Element.DataType.UNSIGNED_8, Element.DataKind.PIXEL_RGB);
    }
    return paramRenderScript.mElement_RGB_888;
  }
  
  public static Element SAMPLER(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SAMPLER == null) {
      paramRenderScript.mElement_SAMPLER = createUser(paramRenderScript, Element.DataType.RS_SAMPLER);
    }
    return paramRenderScript.mElement_SAMPLER;
  }
  
  public static Element SCRIPT(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_SCRIPT == null) {
      paramRenderScript.mElement_SCRIPT = createUser(paramRenderScript, Element.DataType.RS_SCRIPT);
    }
    return paramRenderScript.mElement_SCRIPT;
  }
  
  public static Element TYPE(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_TYPE == null) {
      paramRenderScript.mElement_TYPE = createUser(paramRenderScript, Element.DataType.RS_TYPE);
    }
    return paramRenderScript.mElement_TYPE;
  }
  
  public static Element U16(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U16 == null) {
      paramRenderScript.mElement_U16 = createUser(paramRenderScript, Element.DataType.UNSIGNED_16);
    }
    return paramRenderScript.mElement_U16;
  }
  
  public static Element U16_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_USHORT_2 == null) {
      paramRenderScript.mElement_USHORT_2 = createVector(paramRenderScript, Element.DataType.UNSIGNED_16, 2);
    }
    return paramRenderScript.mElement_USHORT_2;
  }
  
  public static Element U16_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_USHORT_3 == null) {
      paramRenderScript.mElement_USHORT_3 = createVector(paramRenderScript, Element.DataType.UNSIGNED_16, 3);
    }
    return paramRenderScript.mElement_USHORT_3;
  }
  
  public static Element U16_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_USHORT_4 == null) {
      paramRenderScript.mElement_USHORT_4 = createVector(paramRenderScript, Element.DataType.UNSIGNED_16, 4);
    }
    return paramRenderScript.mElement_USHORT_4;
  }
  
  public static Element U32(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U32 == null) {
      paramRenderScript.mElement_U32 = createUser(paramRenderScript, Element.DataType.UNSIGNED_32);
    }
    return paramRenderScript.mElement_U32;
  }
  
  public static Element U32_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UINT_2 == null) {
      paramRenderScript.mElement_UINT_2 = createVector(paramRenderScript, Element.DataType.UNSIGNED_32, 2);
    }
    return paramRenderScript.mElement_UINT_2;
  }
  
  public static Element U32_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UINT_3 == null) {
      paramRenderScript.mElement_UINT_3 = createVector(paramRenderScript, Element.DataType.UNSIGNED_32, 3);
    }
    return paramRenderScript.mElement_UINT_3;
  }
  
  public static Element U32_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UINT_4 == null) {
      paramRenderScript.mElement_UINT_4 = createVector(paramRenderScript, Element.DataType.UNSIGNED_32, 4);
    }
    return paramRenderScript.mElement_UINT_4;
  }
  
  public static Element U64(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U64 == null) {
      paramRenderScript.mElement_U64 = createUser(paramRenderScript, Element.DataType.UNSIGNED_64);
    }
    return paramRenderScript.mElement_U64;
  }
  
  public static Element U64_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ULONG_2 == null) {
      paramRenderScript.mElement_ULONG_2 = createVector(paramRenderScript, Element.DataType.UNSIGNED_64, 2);
    }
    return paramRenderScript.mElement_ULONG_2;
  }
  
  public static Element U64_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ULONG_3 == null) {
      paramRenderScript.mElement_ULONG_3 = createVector(paramRenderScript, Element.DataType.UNSIGNED_64, 3);
    }
    return paramRenderScript.mElement_ULONG_3;
  }
  
  public static Element U64_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_ULONG_4 == null) {
      paramRenderScript.mElement_ULONG_4 = createVector(paramRenderScript, Element.DataType.UNSIGNED_64, 4);
    }
    return paramRenderScript.mElement_ULONG_4;
  }
  
  public static Element U8(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_U8 == null) {
      paramRenderScript.mElement_U8 = createUser(paramRenderScript, Element.DataType.UNSIGNED_8);
    }
    return paramRenderScript.mElement_U8;
  }
  
  public static Element U8_2(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UCHAR_2 == null) {
      paramRenderScript.mElement_UCHAR_2 = createVector(paramRenderScript, Element.DataType.UNSIGNED_8, 2);
    }
    return paramRenderScript.mElement_UCHAR_2;
  }
  
  public static Element U8_3(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UCHAR_3 == null) {
      paramRenderScript.mElement_UCHAR_3 = createVector(paramRenderScript, Element.DataType.UNSIGNED_8, 3);
    }
    return paramRenderScript.mElement_UCHAR_3;
  }
  
  public static Element U8_4(RenderScript paramRenderScript)
  {
    if (paramRenderScript.mElement_UCHAR_4 == null) {
      paramRenderScript.mElement_UCHAR_4 = createVector(paramRenderScript, Element.DataType.UNSIGNED_8, 4);
    }
    return paramRenderScript.mElement_UCHAR_4;
  }
  
  public static Element createPixel(RenderScript paramRenderScript, Element.DataType paramDataType, Element.DataKind paramDataKind)
  {
    if (RenderScript.isNative) {
      return ElementThunker.createPixel((RenderScriptThunker)paramRenderScript, paramDataType, paramDataKind);
    }
    if ((paramDataKind != Element.DataKind.PIXEL_L) && (paramDataKind != Element.DataKind.PIXEL_A) && (paramDataKind != Element.DataKind.PIXEL_LA) && (paramDataKind != Element.DataKind.PIXEL_RGB) && (paramDataKind != Element.DataKind.PIXEL_RGBA) && (paramDataKind != Element.DataKind.PIXEL_DEPTH) && (paramDataKind != Element.DataKind.PIXEL_YUV)) {
      throw new RSIllegalArgumentException("Unsupported DataKind");
    }
    if ((paramDataType != Element.DataType.UNSIGNED_8) && (paramDataType != Element.DataType.UNSIGNED_16) && (paramDataType != Element.DataType.UNSIGNED_5_6_5) && (paramDataType != Element.DataType.UNSIGNED_4_4_4_4) && (paramDataType != Element.DataType.UNSIGNED_5_5_5_1)) {
      throw new RSIllegalArgumentException("Unsupported DataType");
    }
    if ((paramDataType == Element.DataType.UNSIGNED_5_6_5) && (paramDataKind != Element.DataKind.PIXEL_RGB)) {
      throw new RSIllegalArgumentException("Bad kind and type combo");
    }
    if ((paramDataType == Element.DataType.UNSIGNED_5_5_5_1) && (paramDataKind != Element.DataKind.PIXEL_RGBA)) {
      throw new RSIllegalArgumentException("Bad kind and type combo");
    }
    if ((paramDataType == Element.DataType.UNSIGNED_4_4_4_4) && (paramDataKind != Element.DataKind.PIXEL_RGBA)) {
      throw new RSIllegalArgumentException("Bad kind and type combo");
    }
    if ((paramDataType == Element.DataType.UNSIGNED_16) && (paramDataKind != Element.DataKind.PIXEL_DEPTH)) {
      throw new RSIllegalArgumentException("Bad kind and type combo");
    }
    int i = Element.1.$SwitchMap$android$support$v8$renderscript$Element$DataKind[paramDataKind.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          i = 1;
        } else {
          i = 4;
        }
      }
      else {
        i = 3;
      }
    }
    else {
      i = 2;
    }
    return new Element(paramRenderScript.nElementCreate(paramDataType.mID, paramDataKind.mID, true, i), paramRenderScript, paramDataType, paramDataKind, true, i);
  }
  
  static Element createUser(RenderScript paramRenderScript, Element.DataType paramDataType)
  {
    if (RenderScript.isNative) {
      return ElementThunker.create((RenderScriptThunker)paramRenderScript, paramDataType);
    }
    Element.DataKind localDataKind = Element.DataKind.USER;
    return new Element(paramRenderScript.nElementCreate(paramDataType.mID, localDataKind.mID, false, 1), paramRenderScript, paramDataType, localDataKind, false, 1);
  }
  
  public static Element createVector(RenderScript paramRenderScript, Element.DataType paramDataType, int paramInt)
  {
    if (RenderScript.isNative) {
      return ElementThunker.createVector((RenderScriptThunker)paramRenderScript, paramDataType, paramInt);
    }
    if ((paramInt >= 2) && (paramInt <= 4))
    {
      switch (Element.1.$SwitchMap$android$support$v8$renderscript$Element$DataType[paramDataType.ordinal()])
      {
      default: 
        throw new RSIllegalArgumentException("Cannot create vector of non-primitive type.");
      }
      Element.DataKind localDataKind = Element.DataKind.USER;
      return new Element(paramRenderScript.nElementCreate(paramDataType.mID, localDataKind.mID, false, paramInt), paramRenderScript, paramDataType, localDataKind, false, paramInt);
    }
    throw new RSIllegalArgumentException("Vector size out of range 2-4.");
  }
  
  private void updateVisibleSubElements()
  {
    if (this.mElements == null) {
      return;
    }
    int m = this.mElementNames.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (this.mElementNames[i].charAt(0) != '#') {
        k = j + 1;
      }
      i += 1;
    }
    this.mVisibleElementMap = new int[j];
    i = 0;
    for (j = 0; i < m; j = k)
    {
      k = j;
      if (this.mElementNames[i].charAt(0) != '#')
      {
        this.mVisibleElementMap[j] = i;
        k = j + 1;
      }
      i += 1;
    }
  }
  
  public int getBytesSize()
  {
    return this.mSize;
  }
  
  public Element.DataKind getDataKind()
  {
    return this.mKind;
  }
  
  public Element.DataType getDataType()
  {
    return this.mType;
  }
  
  public Element getSubElement(int paramInt)
  {
    int[] arrayOfInt = this.mVisibleElementMap;
    if (arrayOfInt != null)
    {
      if ((paramInt >= 0) && (paramInt < arrayOfInt.length)) {
        return this.mElements[arrayOfInt[paramInt]];
      }
      throw new RSIllegalArgumentException("Illegal sub-element index");
    }
    throw new RSIllegalArgumentException("Element contains no sub-elements");
  }
  
  public int getSubElementArraySize(int paramInt)
  {
    int[] arrayOfInt = this.mVisibleElementMap;
    if (arrayOfInt != null)
    {
      if ((paramInt >= 0) && (paramInt < arrayOfInt.length)) {
        return this.mArraySizes[arrayOfInt[paramInt]];
      }
      throw new RSIllegalArgumentException("Illegal sub-element index");
    }
    throw new RSIllegalArgumentException("Element contains no sub-elements");
  }
  
  public int getSubElementCount()
  {
    int[] arrayOfInt = this.mVisibleElementMap;
    if (arrayOfInt == null) {
      return 0;
    }
    return arrayOfInt.length;
  }
  
  public String getSubElementName(int paramInt)
  {
    int[] arrayOfInt = this.mVisibleElementMap;
    if (arrayOfInt != null)
    {
      if ((paramInt >= 0) && (paramInt < arrayOfInt.length)) {
        return this.mElementNames[arrayOfInt[paramInt]];
      }
      throw new RSIllegalArgumentException("Illegal sub-element index");
    }
    throw new RSIllegalArgumentException("Element contains no sub-elements");
  }
  
  public int getSubElementOffsetBytes(int paramInt)
  {
    int[] arrayOfInt = this.mVisibleElementMap;
    if (arrayOfInt != null)
    {
      if ((paramInt >= 0) && (paramInt < arrayOfInt.length)) {
        return this.mOffsetInBytes[arrayOfInt[paramInt]];
      }
      throw new RSIllegalArgumentException("Illegal sub-element index");
    }
    throw new RSIllegalArgumentException("Element contains no sub-elements");
  }
  
  public int getVectorSize()
  {
    return this.mVectorSize;
  }
  
  public boolean isCompatible(Element paramElement)
  {
    if (equals(paramElement)) {
      return true;
    }
    return (this.mSize == paramElement.mSize) && (this.mType != Element.DataType.NONE) && (this.mType == paramElement.mType) && (this.mVectorSize == paramElement.mVectorSize);
  }
  
  public boolean isComplex()
  {
    if (this.mElements == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      Element[] arrayOfElement = this.mElements;
      if (i >= arrayOfElement.length) {
        break;
      }
      if (arrayOfElement[i].mElements != null) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Element
 * JD-Core Version:    0.7.0.1
 */