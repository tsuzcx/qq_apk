public class aqzv
{
  private String a;
  
  public aqzv(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof aqzv))) {}
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
 * Qualified Name:     aqzv
 * JD-Core Version:    0.7.0.1
 */