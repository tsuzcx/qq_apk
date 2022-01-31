import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class bcso
{
  public static final int[] a;
  public static final int[] b = { 2130839330, 2130839330, 2130839329 };
  public static final int[] c = { 2131378532, 2131378533, 2131378531 };
  protected bibh a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131697973, 2131697974, 2131697972 };
  }
  
  public final View a(Context paramContext, int paramInt, bibi parambibi)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Bibh == null) {
      this.jdField_a_of_type_Bibh = a(paramContext);
    }
    return this.jdField_a_of_type_Bibh.a(paramContext, localView, parambibi, -1);
  }
  
  public bibh a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298631);
    int j = paramContext.getResources().getDimensionPixelSize(2131298632);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new bcsp(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, bibi parambibi, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bibh != null) {
      this.jdField_a_of_type_Bibh.a(paramContext, paramView, 0, paramObject, parambibi, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcso
 * JD-Core Version:    0.7.0.1
 */