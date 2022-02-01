import android.text.TextUtils;

public class bnbx
{
  public final int a;
  public long a;
  public bnbx a;
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  
  public bnbx(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong, bnbx parambnbx)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.g = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.jdField_a_of_type_Bnbx = parambnbx;
    this.h = paramString7;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 != null)
    {
      if ((paramObject2 == null) && ((paramObject1 instanceof String)) && (TextUtils.isEmpty((String)paramObject1))) {
        return true;
      }
      return paramObject1.equals(paramObject2);
    }
    return ((paramObject2 instanceof String)) && (TextUtils.isEmpty((String)paramObject2));
  }
  
  public bnbx a()
  {
    bnbx localbnbx = this;
    if (this.jdField_a_of_type_Bnbx != null) {
      localbnbx = this.jdField_a_of_type_Bnbx;
    }
    return localbnbx;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bnbx != null) && ((!a(this.b, this.jdField_a_of_type_Bnbx.b)) || (!a(this.c, this.jdField_a_of_type_Bnbx.c)) || (!a(this.d, this.jdField_a_of_type_Bnbx.d)) || (!a(this.e, this.jdField_a_of_type_Bnbx.e)) || (!a(this.f, this.jdField_a_of_type_Bnbx.f)) || (!a(this.g, this.jdField_a_of_type_Bnbx.g)) || (!a(this.h, this.jdField_a_of_type_Bnbx.h)) || (this.jdField_a_of_type_Int != this.jdField_a_of_type_Bnbx.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bnbx
 * JD-Core Version:    0.7.0.1
 */