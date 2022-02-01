import androidx.annotation.Nullable;

public class arbj
{
  public double a;
  public int a;
  public boolean a = true;
  public double b;
  public int b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof arbj))) {}
    do
    {
      return false;
      paramObject = (arbj)paramObject;
    } while ((this.a != paramObject.a) || (this.b != paramObject.b) || (this.c != paramObject.c) || (this.d != paramObject.d) || (this.e != paramObject.e));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arbj
 * JD-Core Version:    0.7.0.1
 */