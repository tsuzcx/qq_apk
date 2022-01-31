import android.graphics.PointF;
import android.support.annotation.NonNull;

public class bmqo
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
  
  public bmqo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2)
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
  
  public bmqo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
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
  
  public static bmqo a(@NonNull bmqo parambmqo)
  {
    return new bmqo(parambmqo.jdField_a_of_type_AndroidGraphicsPointF.x, parambmqo.jdField_a_of_type_AndroidGraphicsPointF.y, parambmqo.jdField_a_of_type_Float, parambmqo.jdField_b_of_type_Float, parambmqo.jdField_c_of_type_Float, parambmqo.jdField_d_of_type_Float, parambmqo.jdField_a_of_type_Int, parambmqo.jdField_b_of_type_Int, parambmqo.jdField_a_of_type_JavaLangString, parambmqo.jdField_c_of_type_Int, parambmqo.jdField_d_of_type_Int);
  }
  
  public static bmqo a(@NonNull bmyj parambmyj, @NonNull bmqo parambmqo)
  {
    return new bmqo(parambmyj.b.x, parambmyj.b.y, parambmqo.jdField_a_of_type_Float, parambmyj.r, parambmyj.s, parambmyj.t, parambmqo.jdField_a_of_type_Int, parambmqo.jdField_b_of_type_Int, parambmqo.jdField_a_of_type_JavaLangString, parambmqo.jdField_c_of_type_Int, parambmqo.jdField_d_of_type_Int);
  }
  
  public String toString()
  {
    return "LayerParams{centerP=" + this.jdField_a_of_type_AndroidGraphicsPointF + ", scale=" + this.jdField_a_of_type_Float + ", rotate=" + this.jdField_b_of_type_Float + ", translateXValue=" + this.jdField_c_of_type_Float + ", translateYValue=" + this.jdField_d_of_type_Float + ", width=" + this.jdField_a_of_type_Int + ", height=" + this.jdField_b_of_type_Int + ", text='" + this.jdField_a_of_type_JavaLangString + '\'' + ", textColor=" + this.jdField_c_of_type_Int + ", textSize=" + this.jdField_d_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqo
 * JD-Core Version:    0.7.0.1
 */