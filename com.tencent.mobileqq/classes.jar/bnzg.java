import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

public class bnzg
{
  public static final bnzg a;
  public static final bnzg[] a;
  public static final bnzg b;
  public static final bnzg c;
  public static final bnzg d;
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
  @ColorInt
  public final int d;
  @DrawableRes
  public final int e;
  @ColorInt
  public final int f;
  @DrawableRes
  public final int g;
  @DrawableRes
  public final int h;
  @DrawableRes
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
  @ColorInt
  public final int p;
  @ColorInt
  public final int q;
  
  static
  {
    int i1 = Color.parseColor("#9095A8");
    int i2 = Color.parseColor("#7A7A8D");
    jdField_a_of_type_Bnzg = new bnzg("1to1_light", 2130837625, 2130837626, 2130837624, new float[] { 0.0F, 1.0F }, i1, 2130837630, -16777216, false, 2130837650, 2130837632, 2130837636, 2130837623, 2130837639, 2130837613, 2130837654, 2130837616, 2130837655, -16777216, i2);
    i1 = Color.parseColor("#E6FFFFFF");
    jdField_b_of_type_Bnzg = new bnzg("full_light", 2130837628, 2130837629, 2130837627, new float[] { 1.0F, 1.0F }, -1, 2130837631, -1, true, 2130837651, 2130837632, 2130837636, 2130837623, 2130837639, 2130837613, 2130837654, 2130837617, 2130837655, -1, i1);
    jdField_c_of_type_Bnzg = jdField_a_of_type_Bnzg;
    jdField_d_of_type_Bnzg = jdField_b_of_type_Bnzg;
    jdField_a_of_type_ArrayOfBnzg = new bnzg[] { jdField_a_of_type_Bnzg, jdField_b_of_type_Bnzg, jdField_c_of_type_Bnzg, jdField_d_of_type_Bnzg };
  }
  
  private bnzg(@NonNull String paramString, @DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @NonNull float[] paramArrayOfFloat, @ColorInt int paramInt4, @DrawableRes int paramInt5, @ColorInt int paramInt6, boolean paramBoolean, @DrawableRes int paramInt7, @DrawableRes int paramInt8, @DrawableRes int paramInt9, @DrawableRes int paramInt10, @DrawableRes int paramInt11, @DrawableRes int paramInt12, @DrawableRes int paramInt13, @DrawableRes int paramInt14, @DrawableRes int paramInt15, @ColorInt int paramInt16, @ColorInt int paramInt17)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.jdField_d_of_type_Int = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.g = paramInt7;
    this.h = paramInt8;
    this.i = paramInt9;
    this.j = paramInt10;
    this.k = paramInt11;
    this.l = paramInt12;
    this.m = paramInt13;
    this.n = paramInt14;
    this.o = paramInt15;
    this.p = paramInt16;
    this.q = paramInt17;
  }
  
  public static float a(float paramFloat)
  {
    paramFloat = (paramFloat - 1.0F) / 0.3333334F;
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
 * Qualified Name:     bnzg
 * JD-Core Version:    0.7.0.1
 */