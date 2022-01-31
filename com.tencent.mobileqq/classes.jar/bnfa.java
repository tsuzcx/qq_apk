import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker;

public class bnfa
{
  public static final int[] a;
  public static final int[] b;
  public int a;
  public Drawable a;
  public String a;
  public int b;
  public String b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, -2148308, -1009097, -8136876, -13338378 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130846327, 2130846330, 2130846328, 2130846333, 2130846332 };
  }
  
  public bnfa(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 == 0) {
      this.jdField_b_of_type_JavaLangString = ColorPicker.a(paramInt2);
    }
  }
  
  public bnfa(Drawable paramDrawable, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = Color.parseColor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfa
 * JD-Core Version:    0.7.0.1
 */