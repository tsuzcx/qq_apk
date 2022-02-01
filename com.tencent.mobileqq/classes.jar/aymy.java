import android.text.TextUtils;

public class aymy
{
  public String a;
  public String b;
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(" ");
    if ((paramString != null) && (paramString.length == 2))
    {
      this.b = paramString[0];
      this.a = paramString[1];
      return;
    }
    this.b = "";
    this.a = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymy
 * JD-Core Version:    0.7.0.1
 */