import org.jetbrains.annotations.NotNull;

public class aysc
{
  public double a;
  public int a;
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public aysc() {}
  
  public aysc(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, int paramInt7, int paramInt8)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.b = paramInt3;
    this.c = paramInt4;
    this.d = paramInt5;
    this.e = paramInt6;
    this.jdField_a_of_type_Double = paramDouble;
    this.g = paramInt7;
    this.h = paramInt8;
  }
  
  @NotNull
  public String toString()
  {
    return "Category{level=" + this.jdField_a_of_type_Int + ", name=" + this.jdField_a_of_type_JavaLangString + ", internal=" + this.f + ", poiCount=" + this.b + ", poiDistance=" + this.c + ", locDistance=" + this.d + ", locAccuracy=" + this.e + ", validRate=" + this.jdField_a_of_type_Double + ", poiCacheSize=" + this.g + "poiCacheValidDistance" + this.h + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysc
 * JD-Core Version:    0.7.0.1
 */