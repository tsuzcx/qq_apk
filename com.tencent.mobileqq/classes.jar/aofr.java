public class aofr
{
  private String a;
  
  public aofr(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof aofr))) {}
    while (!toString().equals(paramObject.toString())) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aofr
 * JD-Core Version:    0.7.0.1
 */