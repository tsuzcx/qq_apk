import android.support.annotation.NonNull;
import cooperation.qzone.thread.QzoneThreadMonitor;

public class amkg
  implements Comparable
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  
  public amkg(QzoneThreadMonitor paramQzoneThreadMonitor, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public int a(@NonNull amkg paramamkg)
  {
    return (int)(this.jdField_a_of_type_Long - paramamkg.jdField_a_of_type_Long);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof amkg)) && (this.jdField_a_of_type_JavaLangString.equals(((amkg)paramObject).jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkg
 * JD-Core Version:    0.7.0.1
 */