public class aybo
  extends aybi
{
  private int f;
  private int g;
  
  public aybo(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, 4, 0);
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public aybo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, 4, paramInt4);
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    this.a = ((int)(this.f + (this.g - this.f) * paramFloat));
    if (this.g - this.f > 0) {
      if (this.a >= this.g) {
        this.a = this.g;
      }
    }
    for (;;)
    {
      super.a(paramInt, paramFloat);
      return;
      if (this.a <= this.g) {
        this.a = this.g;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybo
 * JD-Core Version:    0.7.0.1
 */