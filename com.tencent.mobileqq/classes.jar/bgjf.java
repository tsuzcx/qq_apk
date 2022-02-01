import android.text.TextUtils;
import androidx.annotation.Nullable;

public class bgjf
{
  String a;
  String b;
  String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof bgjf))
    {
      paramObject = (bgjf)paramObject;
      return (TextUtils.equals(paramObject.a, this.a)) && (TextUtils.equals(paramObject.b, this.b)) && (TextUtils.equals(paramObject.c, this.c));
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjf
 * JD-Core Version:    0.7.0.1
 */