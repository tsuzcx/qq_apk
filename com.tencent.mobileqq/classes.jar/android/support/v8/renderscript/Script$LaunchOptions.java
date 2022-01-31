package android.support.v8.renderscript;

public final class Script$LaunchOptions
{
  private int strategy;
  private int xend = 0;
  private int xstart = 0;
  private int yend = 0;
  private int ystart = 0;
  private int zend = 0;
  private int zstart = 0;
  
  public int getXEnd()
  {
    return this.xend;
  }
  
  public int getXStart()
  {
    return this.xstart;
  }
  
  public int getYEnd()
  {
    return this.yend;
  }
  
  public int getYStart()
  {
    return this.ystart;
  }
  
  public int getZEnd()
  {
    return this.zend;
  }
  
  public int getZStart()
  {
    return this.zstart;
  }
  
  public LaunchOptions setX(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 <= paramInt1)) {
      throw new RSIllegalArgumentException("Invalid dimensions");
    }
    this.xstart = paramInt1;
    this.xend = paramInt2;
    return this;
  }
  
  public LaunchOptions setY(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 <= paramInt1)) {
      throw new RSIllegalArgumentException("Invalid dimensions");
    }
    this.ystart = paramInt1;
    this.yend = paramInt2;
    return this;
  }
  
  public LaunchOptions setZ(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 <= paramInt1)) {
      throw new RSIllegalArgumentException("Invalid dimensions");
    }
    this.zstart = paramInt1;
    this.zend = paramInt2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.Script.LaunchOptions
 * JD-Core Version:    0.7.0.1
 */