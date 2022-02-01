import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

public class bmcd
{
  public static final bmcd a;
  public static final bmcd[] a;
  public static final bmcd b;
  public static final bmcd c;
  public static final bmcd d;
  public static final bmcd e;
  public static final bmcd f;
  @DrawableRes
  public final int a;
  @NonNull
  public final String a;
  public final boolean a;
  @NonNull
  public final float[] a;
  @DrawableRes
  public final int b;
  @DrawableRes
  public final int c;
  @DrawableRes
  public final int d;
  @DrawableRes
  public final int e;
  @DrawableRes
  public final int f;
  @ColorInt
  public final int g;
  @DrawableRes
  public final int h;
  @ColorInt
  public final int i;
  @DrawableRes
  public final int j;
  @DrawableRes
  public final int k;
  @DrawableRes
  public final int l;
  @DrawableRes
  public final int m;
  @DrawableRes
  public final int n;
  @DrawableRes
  public final int o;
  @DrawableRes
  public final int p;
  @DrawableRes
  public final int q;
  @ColorInt
  public final int r;
  @ColorInt
  public final int s;
  
  static
  {
    int i1 = Color.parseColor("#9095A8");
    int i2 = Color.parseColor("#7A7A8D");
    jdField_a_of_type_Bmcd = new bmcd("1to1_light", 2130837625, 2130837624, 2130837626, 2130837623, 2130837665, 2130837644, new float[] { 0.0F, 1.0F }, i1, 2130837630, -16777216, false, 2130837652, 2130837632, 2130837636, 2130837639, 2130837613, 2130837656, 2130837616, 2130837657, -16777216, i2);
    i1 = Color.parseColor("#E6FFFFFF");
    jdField_b_of_type_Bmcd = new bmcd("full_light", 2130837628, 2130837629, 2130837626, 2130837627, 2130837666, 2130837645, new float[] { 0.0F, 1.0F }, -1, 2130837631, -1, true, 2130837653, 2130837632, 2130837636, 2130837639, 2130837613, 2130837656, 2130837617, 2130837657, -1, i1);
    i1 = Color.parseColor("#9095A8");
    i2 = Color.parseColor("#7A7A8D");
    jdField_c_of_type_Bmcd = new bmcd("4to3_no_top_margin_light", 2130837625, 2130837624, 2130837626, 2130837623, 2130837665, 2130837644, new float[] { 0.0F, 1.0F }, i1, 2130837630, -16777216, false, 2130837653, 2130837632, 2130837636, 2130837639, 2130837613, 2130837656, 2130837617, 2130837657, -16777216, i2);
    i1 = Color.parseColor("#9095A8");
    i2 = Color.parseColor("#7A7A8D");
    jdField_d_of_type_Bmcd = new bmcd("4to3_with_top_margin_light", 2130837625, 2130837624, 2130837626, 2130837623, 2130837665, 2130837644, new float[] { 0.0F, 1.0F }, i1, 2130837630, -16777216, false, 2130837652, 2130837632, 2130837636, 2130837639, 2130837613, 2130837656, 2130837617, 2130837657, -16777216, i2);
    jdField_e_of_type_Bmcd = jdField_a_of_type_Bmcd;
    jdField_f_of_type_Bmcd = jdField_b_of_type_Bmcd;
    jdField_a_of_type_ArrayOfBmcd = new bmcd[] { jdField_a_of_type_Bmcd, jdField_b_of_type_Bmcd, jdField_e_of_type_Bmcd, jdField_f_of_type_Bmcd };
  }
  
  private bmcd(@NonNull String paramString, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4, @DrawableRes int paramInt5, @DrawableRes int paramInt6, @NonNull float[] paramArrayOfFloat, @ColorInt int paramInt7, @DrawableRes int paramInt8, @ColorInt int paramInt9, boolean paramBoolean, @DrawableRes int paramInt10, @DrawableRes int paramInt11, @DrawableRes int paramInt12, @DrawableRes int paramInt13, @DrawableRes int paramInt14, @DrawableRes int paramInt15, @DrawableRes int paramInt16, @DrawableRes int paramInt17, @ColorInt int paramInt18, @ColorInt int paramInt19)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_c_of_type_Int = paramInt4;
    this.jdField_e_of_type_Int = paramInt5;
    this.jdField_f_of_type_Int = paramInt6;
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.g = paramInt7;
    this.h = paramInt8;
    this.i = paramInt9;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.j = paramInt10;
    this.k = paramInt11;
    this.l = paramInt12;
    this.m = paramInt13;
    this.n = paramInt14;
    this.o = paramInt15;
    this.p = paramInt16;
    this.q = paramInt17;
    this.r = paramInt18;
    this.s = paramInt19;
  }
  
  public static float a(float paramFloat)
  {
    paramFloat = (paramFloat - 1.0F) / 0.1734999F;
    if (paramFloat < 0.0F) {
      return 0.0F;
    }
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return paramFloat;
  }
  
  public static float b(float paramFloat)
  {
    paramFloat = (paramFloat - 0.6F) / 0.4F;
    if (paramFloat < 0.0F) {
      return 0.0F;
    }
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmcd
 * JD-Core Version:    0.7.0.1
 */