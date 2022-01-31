import android.text.TextUtils;

public class bjmm
{
  public final int a;
  public long a;
  public bjmm a;
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  
  public bjmm(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, long paramLong, bjmm parambjmm)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.g = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.jdField_a_of_type_Bjmm = parambjmm;
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
  
  public bjmm a()
  {
    bjmm localbjmm = this;
    if (this.jdField_a_of_type_Bjmm != null) {
      localbjmm = this.jdField_a_of_type_Bjmm;
    }
    return localbjmm;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bjmm != null) && ((!a(this.b, this.jdField_a_of_type_Bjmm.b)) || (!a(this.c, this.jdField_a_of_type_Bjmm.c)) || (!a(this.d, this.jdField_a_of_type_Bjmm.d)) || (!a(this.e, this.jdField_a_of_type_Bjmm.e)) || (!a(this.f, this.jdField_a_of_type_Bjmm.f)) || (!a(this.g, this.jdField_a_of_type_Bjmm.g)) || (!a(this.h, this.jdField_a_of_type_Bjmm.h)) || (this.jdField_a_of_type_Int != this.jdField_a_of_type_Bjmm.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjmm
 * JD-Core Version:    0.7.0.1
 */