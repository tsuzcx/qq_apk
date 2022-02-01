final class bgcg
  implements bgci
{
  private boolean a(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] <= 0.05F;
  }
  
  private boolean b(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] >= 0.95F;
  }
  
  private boolean c(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat[0] >= 10.0F) && (paramArrayOfFloat[0] <= 37.0F) && (paramArrayOfFloat[1] <= 0.82F);
  }
  
  public boolean a(int paramInt, float[] paramArrayOfFloat)
  {
    return (!b(paramArrayOfFloat)) && (!a(paramArrayOfFloat)) && (!c(paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcg
 * JD-Core Version:    0.7.0.1
 */