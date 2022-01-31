final class axiw
  extends axiz
{
  public double a(int paramInt1, int paramInt2)
  {
    double d2 = paramInt1 / (paramInt1 + paramInt2);
    double d3 = paramInt2 / (paramInt1 + paramInt2);
    double d1 = 0.0D;
    if (paramInt1 > 0)
    {
      d1 = -d2;
      d1 = 0.0D + Math.log(d2) * d1;
    }
    d2 = d1;
    if (paramInt2 > 0) {
      d2 = d1 + -d3 * Math.log(d3);
    }
    return d2 / Math.log(2.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axiw
 * JD-Core Version:    0.7.0.1
 */