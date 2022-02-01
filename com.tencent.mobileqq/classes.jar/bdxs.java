public class bdxs
  extends bdxn
{
  private int f;
  private int g;
  
  public bdxs(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 16, 0);
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    this.b = ((int)(this.f + (this.g - this.f) * paramFloat));
    if (this.g - this.f > 0) {
      if (this.b >= this.g) {
        this.b = this.g;
      }
    }
    for (;;)
    {
      super.a(paramInt, paramFloat);
      return;
      if (this.b <= this.g) {
        this.b = this.g;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxs
 * JD-Core Version:    0.7.0.1
 */