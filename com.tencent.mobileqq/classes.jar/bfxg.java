import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class bfxg
{
  public static final int[] a;
  public static final int[] b = { 2130839507, 2130839507, 2130839506 };
  public static final int[] c = { 2131379384, 2131379385, 2131379383 };
  protected bkos a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131696819, 2131696820, 2131696818 };
  }
  
  public final View a(Context paramContext, int paramInt, bkot parambkot)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Bkos == null) {
      this.jdField_a_of_type_Bkos = a(paramContext);
    }
    return this.jdField_a_of_type_Bkos.a(paramContext, localView, parambkot, -1);
  }
  
  public bkos a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298713);
    int j = paramContext.getResources().getDimensionPixelSize(2131298714);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new bfxh(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, bkot parambkot, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bkos != null) {
      this.jdField_a_of_type_Bkos.a(paramContext, paramView, 0, paramObject, parambkot, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxg
 * JD-Core Version:    0.7.0.1
 */