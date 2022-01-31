import android.graphics.PointF;
import android.support.annotation.NonNull;

public class bkab
{
  public float a;
  public final int a;
  public final PointF a;
  public final String a;
  public final float b;
  public final int b;
  public final float c;
  public final int c;
  public final float d;
  public final int d;
  
  public bkab(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_c_of_type_Float = paramFloat5;
    this.jdField_d_of_type_Float = paramFloat6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = 0;
  }
  
  public bkab(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramFloat1, paramFloat2);
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_b_of_type_Float = paramFloat4;
    this.jdField_c_of_type_Float = paramFloat5;
    this.jdField_d_of_type_Float = paramFloat6;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_d_of_type_Int = paramInt4;
  }
  
  public static bkab a(@NonNull bkab parambkab)
  {
    return new bkab(parambkab.jdField_a_of_type_AndroidGraphicsPointF.x, parambkab.jdField_a_of_type_AndroidGraphicsPointF.y, parambkab.jdField_a_of_type_Float, parambkab.jdField_b_of_type_Float, parambkab.jdField_c_of_type_Float, parambkab.jdField_d_of_type_Float, parambkab.jdField_a_of_type_Int, parambkab.jdField_b_of_type_Int, parambkab.jdField_a_of_type_JavaLangString, parambkab.jdField_c_of_type_Int, parambkab.jdField_d_of_type_Int);
  }
  
  public static bkab a(@NonNull bkhw parambkhw, @NonNull bkab parambkab)
  {
    return new bkab(parambkhw.b.x, parambkhw.b.y, parambkab.jdField_a_of_type_Float, parambkhw.r, parambkhw.s, parambkhw.t, parambkab.jdField_a_of_type_Int, parambkab.jdField_b_of_type_Int, parambkab.jdField_a_of_type_JavaLangString, parambkab.jdField_c_of_type_Int, parambkab.jdField_d_of_type_Int);
  }
  
  public String toString()
  {
    return "LayerParams{centerP=" + this.jdField_a_of_type_AndroidGraphicsPointF + ", scale=" + this.jdField_a_of_type_Float + ", rotate=" + this.jdField_b_of_type_Float + ", translateXValue=" + this.jdField_c_of_type_Float + ", translateYValue=" + this.jdField_d_of_type_Float + ", width=" + this.jdField_a_of_type_Int + ", height=" + this.jdField_b_of_type_Int + ", text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", textColor=" + this.jdField_c_of_type_Int + ", textSize=" + this.jdField_d_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkab
 * JD-Core Version:    0.7.0.1
 */