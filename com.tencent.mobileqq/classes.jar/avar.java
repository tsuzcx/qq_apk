import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;

public class avar
{
  public static float b;
  public float a;
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public float c;
  public int c;
  public int d = 10;
  public int e = 8;
  public int f = 150;
  public int g = 300;
  public int h = 32;
  public int i = 27;
  public int j = 3000;
  public int k;
  public int l;
  
  static
  {
    jdField_b_of_type_Float = 1.0F;
  }
  
  private avar()
  {
    this.jdField_a_of_type_Int = 250;
    this.jdField_c_of_type_Int = 20;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_b_of_type_Boolean = true;
  }
  
  public avar(HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_Int = 250;
    this.jdField_c_of_type_Int = 20;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramHeartLayout.getContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)((paramHeartLayout.getWidth() - this.jdField_a_of_type_Float * 32.0F) / 2.0F));
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 27.0F));
    this.h = ((int)(this.jdField_a_of_type_Float * 32.0F));
    this.i = ((int)(this.jdField_a_of_type_Float * 27.0F));
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Float * 20.0F));
    this.d = ((int)(this.jdField_a_of_type_Float * 10.0F));
    this.f = ((int)(this.jdField_a_of_type_Float * 150.0F));
    this.g = ((int)(this.jdField_a_of_type_Float * 300.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avar
 * JD-Core Version:    0.7.0.1
 */