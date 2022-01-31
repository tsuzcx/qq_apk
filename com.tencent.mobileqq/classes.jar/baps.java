import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class baps
{
  public static final int[] a;
  public static final int[] b = { 2130839240, 2130839240, 2130839239 };
  public static final int[] c = { 2131377932, 2131377933, 2131377931 };
  protected bfwd a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131697794, 2131697795, 2131697793 };
  }
  
  public final View a(Context paramContext, int paramInt, bfwe parambfwe)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Bfwd == null) {
      this.jdField_a_of_type_Bfwd = a(paramContext);
    }
    return this.jdField_a_of_type_Bfwd.a(paramContext, localView, parambfwe, -1);
  }
  
  public bfwd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298603);
    int j = paramContext.getResources().getDimensionPixelSize(2131298604);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new bapt(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, bfwe parambfwe, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bfwd != null) {
      this.jdField_a_of_type_Bfwd.a(paramContext, paramView, 0, paramObject, parambfwe, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baps
 * JD-Core Version:    0.7.0.1
 */