package android.content.res;

public class XResForwarder
{
  private final int id;
  private final Resources res;
  
  public XResForwarder(Resources paramResources, int paramInt)
  {
    this.res = paramResources;
    this.id = paramInt;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Resources getResources()
  {
    return this.res;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.content.res.XResForwarder
 * JD-Core Version:    0.7.0.1
 */