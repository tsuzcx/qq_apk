import androidx.annotation.Nullable;

public class aqyc
{
  public double a;
  public int a;
  public boolean a = true;
  public double b;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof aqyc))) {}
    do
    {
      return false;
      paramObject = (aqyc)paramObject;
    } while ((this.a != paramObject.a) || (this.c != paramObject.c) || (this.d != paramObject.d) || (this.e != paramObject.e) || (this.f != paramObject.f) || (this.g != paramObject.g) || (this.h != paramObject.h) || (this.b != paramObject.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyc
 * JD-Core Version:    0.7.0.1
 */