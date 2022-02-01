package android.support.v8.renderscript;

public class Type
  extends BaseObj
{
  boolean mDimFaces;
  boolean mDimMipmaps;
  int mDimX;
  int mDimY;
  int mDimYuv;
  int mDimZ;
  Element mElement;
  int mElementCount;
  
  Type(int paramInt, RenderScript paramRenderScript)
  {
    super(paramInt, paramRenderScript);
  }
  
  void calcElementCount()
  {
    boolean bool = hasMipmaps();
    int j = getX();
    int k = getY();
    int n = getZ();
    int m;
    if (hasFaces()) {
      m = 6;
    } else {
      m = 1;
    }
    int i = j;
    if (j == 0) {
      i = 1;
    }
    j = k;
    if (k == 0) {
      j = 1;
    }
    k = n;
    if (n == 0) {
      k = 1;
    }
    n = i * j * k * m;
    int i2 = i;
    while ((bool) && ((i2 > 1) || (j > 1) || (k > 1)))
    {
      i = i2;
      if (i2 > 1) {
        i = i2 >> 1;
      }
      int i1 = j;
      if (j > 1) {
        i1 = j >> 1;
      }
      int i3 = k;
      if (k > 1) {
        i3 = k >> 1;
      }
      n += i * i1 * i3 * m;
      i2 = i;
      j = i1;
      k = i3;
    }
    this.mElementCount = n;
  }
  
  public int getCount()
  {
    return this.mElementCount;
  }
  
  public Element getElement()
  {
    return this.mElement;
  }
  
  public int getX()
  {
    return this.mDimX;
  }
  
  public int getY()
  {
    return this.mDimY;
  }
  
  public int getYuv()
  {
    return this.mDimYuv;
  }
  
  public int getZ()
  {
    return this.mDimZ;
  }
  
  public boolean hasFaces()
  {
    return this.mDimFaces;
  }
  
  public boolean hasMipmaps()
  {
    return this.mDimMipmaps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Type
 * JD-Core Version:    0.7.0.1
 */