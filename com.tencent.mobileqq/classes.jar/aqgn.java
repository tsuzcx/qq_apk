public abstract class aqgn
{
  public int a = 1;
  public String e;
  
  public aqgn(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof aqgn))
    {
      paramObject = (aqgn)paramObject;
      if (this.e == null) {
        if ((this.a != paramObject.a) || (paramObject.e != null)) {}
      }
      while ((this.a == paramObject.a) && (this.e.equals(paramObject.e)))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgn
 * JD-Core Version:    0.7.0.1
 */