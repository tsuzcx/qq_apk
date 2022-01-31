import android.graphics.Rect;
import java.util.ArrayList;

public class aoji
{
  public int a;
  public Rect a;
  public aojp a;
  public ArrayList<aojj> a;
  public boolean a;
  public int b;
  public boolean b;
  public int c = 0;
  public int d = 0;
  public int e = 1;
  
  public aoji(aojp paramaojp, int paramInt1, Rect paramRect, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 24;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Aojp = paramaojp;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    this.e = paramInt3;
    if (paramaojp.jdField_a_of_type_Int > 0) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      paramaojp.jdField_a_of_type_Int += 1;
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("text: ").append(this.jdField_a_of_type_Aojp.jdField_a_of_type_JavaLangString).append("; size: ").append(this.jdField_b_of_type_Int).append("; line_count: ").append(this.e).append("; container: ").append(this.jdField_a_of_type_AndroidGraphicsRect).append("; algin: ").append(this.c).append("; v_algin: ").append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoji
 * JD-Core Version:    0.7.0.1
 */