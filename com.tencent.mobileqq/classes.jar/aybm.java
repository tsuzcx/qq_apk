public class aybm
  extends aybi
{
  private float d;
  private float e;
  private float f;
  private float g;
  
  public aybm(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramInt, 1, 0);
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.g = paramFloat4;
  }
  
  protected void a(int paramInt, float paramFloat)
  {
    this.a = (this.d + (this.f - this.d) * paramFloat);
    this.b = (this.e + (this.g - this.e) * paramFloat);
    if (this.f - this.d > 0.0F)
    {
      if (this.a >= this.f) {
        this.a = this.f;
      }
      if (this.g - this.e <= 0.0F) {
        break label162;
      }
      if (this.b >= this.g) {
        this.b = this.g;
      }
    }
    for (;;)
    {
      if (paramInt >= this.c)
      {
        this.a = this.f;
        this.b = this.g;
      }
      super.a(paramInt, paramFloat);
      return;
      if (this.a > this.f) {
        break;
      }
      this.a = this.f;
      break;
      label162:
      if (this.b <= this.g) {
        this.b = this.g;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybm
 * JD-Core Version:    0.7.0.1
 */