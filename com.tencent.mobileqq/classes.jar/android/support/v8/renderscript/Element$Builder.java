package android.support.v8.renderscript;

public class Element$Builder
{
  int[] mArraySizes;
  int mCount;
  String[] mElementNames;
  Element[] mElements;
  RenderScript mRS;
  int mSkipPadding;
  ElementThunker.BuilderThunker mT;
  
  public Element$Builder(RenderScript paramRenderScript)
  {
    if (RenderScript.isNative)
    {
      RenderScriptThunker localRenderScriptThunker = (RenderScriptThunker)paramRenderScript;
      this.mT = new ElementThunker.BuilderThunker(paramRenderScript);
    }
    this.mRS = paramRenderScript;
    this.mCount = 0;
    this.mElements = new Element[8];
    this.mElementNames = new String[8];
    this.mArraySizes = new int[8];
  }
  
  public Builder add(Element paramElement, String paramString)
  {
    return add(paramElement, paramString, 1);
  }
  
  public Builder add(Element paramElement, String paramString, int paramInt)
  {
    if (this.mT != null)
    {
      this.mT.add(paramElement, paramString, paramInt);
      return this;
    }
    if (paramInt < 1) {
      throw new RSIllegalArgumentException("Array size cannot be less than 1.");
    }
    if ((this.mSkipPadding != 0) && (paramString.startsWith("#padding_")))
    {
      this.mSkipPadding = 0;
      return this;
    }
    if (paramElement.mVectorSize == 3) {}
    for (this.mSkipPadding = 1;; this.mSkipPadding = 0)
    {
      if (this.mCount == this.mElements.length)
      {
        Element[] arrayOfElement = new Element[this.mCount + 8];
        String[] arrayOfString = new String[this.mCount + 8];
        int[] arrayOfInt = new int[this.mCount + 8];
        System.arraycopy(this.mElements, 0, arrayOfElement, 0, this.mCount);
        System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
        System.arraycopy(this.mArraySizes, 0, arrayOfInt, 0, this.mCount);
        this.mElements = arrayOfElement;
        this.mElementNames = arrayOfString;
        this.mArraySizes = arrayOfInt;
      }
      this.mElements[this.mCount] = paramElement;
      this.mElementNames[this.mCount] = paramString;
      this.mArraySizes[this.mCount] = paramInt;
      this.mCount += 1;
      return this;
    }
  }
  
  public Element create()
  {
    int i = 0;
    if (this.mT != null) {
      return this.mT.create(this.mRS);
    }
    this.mRS.validate();
    Element[] arrayOfElement = new Element[this.mCount];
    String[] arrayOfString = new String[this.mCount];
    int[] arrayOfInt1 = new int[this.mCount];
    System.arraycopy(this.mElements, 0, arrayOfElement, 0, this.mCount);
    System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
    System.arraycopy(this.mArraySizes, 0, arrayOfInt1, 0, this.mCount);
    int[] arrayOfInt2 = new int[arrayOfElement.length];
    while (i < arrayOfElement.length)
    {
      arrayOfInt2[i] = arrayOfElement[i].getID(this.mRS);
      i += 1;
    }
    return new Element(this.mRS.nElementCreate2(arrayOfInt2, arrayOfString, arrayOfInt1), this.mRS, arrayOfElement, arrayOfString, arrayOfInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.Element.Builder
 * JD-Core Version:    0.7.0.1
 */