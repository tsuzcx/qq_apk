import android.support.annotation.NonNull;

public class bmrv
  implements Comparable
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public bmrv(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
  }
  
  public int compareTo(@NonNull Object paramObject)
  {
    if ((paramObject instanceof bmrv)) {
      return this.b.compareTo(((bmrv)paramObject).b);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmrv
 * JD-Core Version:    0.7.0.1
 */