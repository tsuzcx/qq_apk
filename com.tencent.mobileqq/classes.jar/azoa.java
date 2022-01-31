import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class azoa
{
  public static final int[] a;
  public static final int[] b = { 2130839216, 2130839216, 2130839215 };
  public static final int[] c = { 2131312105, 2131312106, 2131312104 };
  protected bens a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131632064, 2131632065, 2131632063 };
  }
  
  public final View a(Context paramContext, int paramInt, bent parambent)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Bens == null) {
      this.jdField_a_of_type_Bens = a(paramContext);
    }
    return this.jdField_a_of_type_Bens.a(paramContext, localView, parambent, -1);
  }
  
  public bens a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131167510);
    int j = paramContext.getResources().getDimensionPixelSize(2131167511);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new azob(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, bent parambent, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bens != null) {
      this.jdField_a_of_type_Bens.a(paramContext, paramView, 0, paramObject, parambent, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azoa
 * JD-Core Version:    0.7.0.1
 */