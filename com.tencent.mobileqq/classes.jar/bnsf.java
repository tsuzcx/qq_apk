import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker;

public class bnsf
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c = { 2130846691, 2130846694, 2130846692, 2130846697, 2130846696 };
  public static final int[] d = { 2130846693, 2130846691, 2130846694, 2130846692, 2130846697, 2130846696 };
  public int a;
  public Drawable a;
  public String a;
  public int b;
  public String b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, -2148308, -1009097, -8136876, -13338378 };
    jdField_b_of_type_ArrayOfInt = new int[] { -16777216, -1, -2148308, -1009097, -8136876, -13338378 };
  }
  
  public bnsf(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 == 0) {
      this.jdField_b_of_type_JavaLangString = ColorPicker.a(paramInt2);
    }
  }
  
  public bnsf(Drawable paramDrawable, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = Color.parseColor(paramString);
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return jdField_b_of_type_ArrayOfInt[2];
    }
    return jdField_a_of_type_ArrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsf
 * JD-Core Version:    0.7.0.1
 */