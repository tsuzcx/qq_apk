import android.text.TextUtils;

public class bflj
{
  protected int a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected String k;
  protected String l;
  protected String m;
  
  public static bflj a()
  {
    return new bflj();
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("|", "");
  }
  
  public final bflj a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public final bflj a(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public String a()
  {
    return "";
  }
  
  public final bflj b(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(this.jdField_a_of_type_JavaLangString));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.b));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.c));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.d));
    localStringBuilder.append("|");
    localStringBuilder.append(bfbm.a().a());
    localStringBuilder.append("|");
    localStringBuilder.append(bfbm.a().c());
    localStringBuilder.append("|");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.e));
    return localStringBuilder.toString();
  }
  
  public final bflj c(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public final String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(this.f));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.g));
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.h));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.i));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.j));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.k));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.l));
    localStringBuilder.append("|");
    localStringBuilder.append(a(this.m));
    return localStringBuilder.toString();
  }
  
  public final bflj d(String paramString)
  {
    this.i = paramString;
    return this;
  }
  
  public final String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    localStringBuilder.append("|");
    localStringBuilder.append(" ");
    return localStringBuilder.toString();
  }
  
  public final bflj e(String paramString)
  {
    this.j = paramString;
    return this;
  }
  
  public final bflj f(String paramString)
  {
    this.k = paramString;
    return this;
  }
  
  public final bflj g(String paramString)
  {
    this.l = paramString;
    return this;
  }
  
  public final bflj h(String paramString)
  {
    this.m = paramString;
    return this;
  }
  
  public final bflj i(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public final bflj j(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public final bflj k(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public final bflj l(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public final bflj m(String paramString)
  {
    this.d = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bflj
 * JD-Core Version:    0.7.0.1
 */