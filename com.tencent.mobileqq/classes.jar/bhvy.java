import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Arrays;

public final class bhvy
{
  private final int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  @Nullable
  private float[] jdField_a_of_type_ArrayOfFloat;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private int f;
  private int g;
  
  public bhvy(@ColorInt int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = Color.red(paramInt1);
    this.b = Color.green(paramInt1);
    this.c = Color.blue(paramInt1);
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a()
  {
    int j;
    if (!this.jdField_a_of_type_Boolean)
    {
      i = bhvs.a(-1, this.d, 4.5F);
      j = bhvs.a(-1, this.d, 3.0F);
      if ((i != -1) && (j != -1))
      {
        this.g = bhvs.b(-1, i);
        this.f = bhvs.b(-1, j);
        this.jdField_a_of_type_Boolean = true;
      }
    }
    else
    {
      return;
    }
    int m = bhvs.a(-16777216, this.d, 4.5F);
    int k = bhvs.a(-16777216, this.d, 3.0F);
    if ((m != -1) && (k != -1))
    {
      this.g = bhvs.b(-16777216, m);
      this.f = bhvs.b(-16777216, k);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (i != -1)
    {
      i = bhvs.b(-1, i);
      this.g = i;
      if (j == -1) {
        break label175;
      }
    }
    label175:
    for (int i = bhvs.b(-1, j);; i = bhvs.b(-16777216, k))
    {
      this.f = i;
      this.jdField_a_of_type_Boolean = true;
      return;
      i = bhvs.b(-16777216, m);
      break;
    }
  }
  
  @ColorInt
  public int a()
  {
    return this.d;
  }
  
  @NonNull
  public float[] a()
  {
    if (this.jdField_a_of_type_ArrayOfFloat == null) {
      this.jdField_a_of_type_ArrayOfFloat = new float[3];
    }
    bhvs.a(this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat;
  }
  
  public int b()
  {
    return this.e;
  }
  
  @ColorInt
  public int c()
  {
    a();
    return this.f;
  }
  
  @ColorInt
  public int d()
  {
    a();
    return this.g;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (bhvy)paramObject;
    } while ((this.e == paramObject.e) && (this.d == paramObject.d));
    return false;
  }
  
  public int hashCode()
  {
    return this.d * 31 + this.e;
  }
  
  @NonNull
  public String toString()
  {
    return getClass().getSimpleName() + " [RGB: #" + Integer.toHexString(a()) + ']' + " [HSL: " + Arrays.toString(a()) + ']' + " [Population: " + this.e + ']' + " [Title Text: #" + Integer.toHexString(c()) + ']' + " [Body Text: #" + Integer.toHexString(d()) + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvy
 * JD-Core Version:    0.7.0.1
 */