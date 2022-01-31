import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class bcof
{
  public static final int[] a;
  public static final int[] b = { 2130839329, 2130839329, 2130839328 };
  public static final int[] c = { 2131378478, 2131378479, 2131378477 };
  protected bhxa a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131697971, 2131697972, 2131697970 };
  }
  
  public final View a(Context paramContext, int paramInt, bhxb parambhxb)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Bhxa == null) {
      this.jdField_a_of_type_Bhxa = a(paramContext);
    }
    return this.jdField_a_of_type_Bhxa.a(paramContext, localView, parambhxb, -1);
  }
  
  public bhxa a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298631);
    int j = paramContext.getResources().getDimensionPixelSize(2131298632);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new bcog(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, bhxb parambhxb, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bhxa != null) {
      this.jdField_a_of_type_Bhxa.a(paramContext, paramView, 0, paramObject, parambhxb, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcof
 * JD-Core Version:    0.7.0.1
 */