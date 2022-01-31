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
    int k = getX();
    int j = getY();
    int n = getZ();
    if (hasFaces()) {}
    for (int m = 6;; m = 1)
    {
      int i = k;
      if (k == 0) {
        i = 1;
      }
      k = j;
      if (j == 0) {
        k = 1;
      }
      j = n;
      if (n == 0) {
        j = 1;
      }
      n = k;
      int i1 = i;
      i = i * k * j * m;
      while ((bool) && ((i1 > 1) || (n > 1) || (j > 1)))
      {
        k = i1;
        if (i1 > 1) {
          k = i1 >> 1;
        }
        i1 = n;
        if (n > 1) {
          i1 = n >> 1;
        }
        n = j;
        if (j > 1) {
          n = j >> 1;
        }
        i += k * i1 * n * m;
        j = n;
        n = i1;
        i1 = k;
      }
      this.mElementCount = i;
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.Type
 * JD-Core Version:    0.7.0.1
 */