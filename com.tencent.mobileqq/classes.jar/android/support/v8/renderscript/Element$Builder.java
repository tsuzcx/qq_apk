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
    Object localObject = this.mT;
    if (localObject != null)
    {
      ((ElementThunker.BuilderThunker)localObject).add(paramElement, paramString, paramInt);
      return this;
    }
    if (paramInt >= 1)
    {
      if ((this.mSkipPadding != 0) && (paramString.startsWith("#padding_")))
      {
        this.mSkipPadding = 0;
        return this;
      }
      if (paramElement.mVectorSize == 3) {
        this.mSkipPadding = 1;
      } else {
        this.mSkipPadding = 0;
      }
      int i = this.mCount;
      localObject = this.mElements;
      if (i == localObject.length)
      {
        Element[] arrayOfElement = new Element[i + 8];
        String[] arrayOfString = new String[i + 8];
        int[] arrayOfInt = new int[i + 8];
        System.arraycopy(localObject, 0, arrayOfElement, 0, i);
        System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
        System.arraycopy(this.mArraySizes, 0, arrayOfInt, 0, this.mCount);
        this.mElements = arrayOfElement;
        this.mElementNames = arrayOfString;
        this.mArraySizes = arrayOfInt;
      }
      localObject = this.mElements;
      i = this.mCount;
      localObject[i] = paramElement;
      this.mElementNames[i] = paramString;
      this.mArraySizes[i] = paramInt;
      this.mCount = (i + 1);
      return this;
    }
    throw new RSIllegalArgumentException("Array size cannot be less than 1.");
  }
  
  public Element create()
  {
    Object localObject1 = this.mT;
    if (localObject1 != null) {
      return ((ElementThunker.BuilderThunker)localObject1).create(this.mRS);
    }
    this.mRS.validate();
    int j = this.mCount;
    localObject1 = new Element[j];
    String[] arrayOfString = new String[j];
    int[] arrayOfInt = new int[j];
    Object localObject2 = this.mElements;
    int i = 0;
    System.arraycopy(localObject2, 0, localObject1, 0, j);
    System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
    System.arraycopy(this.mArraySizes, 0, arrayOfInt, 0, this.mCount);
    localObject2 = new int[localObject1.length];
    while (i < localObject1.length)
    {
      localObject2[i] = localObject1[i].getID(this.mRS);
      i += 1;
    }
    return new Element(this.mRS.nElementCreate2((int[])localObject2, arrayOfString, arrayOfInt), this.mRS, (Element[])localObject1, arrayOfString, arrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Element.Builder
 * JD-Core Version:    0.7.0.1
 */