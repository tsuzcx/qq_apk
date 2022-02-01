import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class bgxh
{
  public static final int[] a;
  public static final int[] b = { 2130839515, 2130839515, 2130839514 };
  public static final int[] c = { 2131379551, 2131379552, 2131379550 };
  protected blpv a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131696868, 2131696869, 2131696867 };
  }
  
  public final View a(Context paramContext, int paramInt, blpw paramblpw)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Blpv == null) {
      this.jdField_a_of_type_Blpv = a(paramContext);
    }
    return this.jdField_a_of_type_Blpv.a(paramContext, localView, paramblpw, -1);
  }
  
  public blpv a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298726);
    int j = paramContext.getResources().getDimensionPixelSize(2131298727);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new bgxi(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, blpw paramblpw, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blpv != null) {
      this.jdField_a_of_type_Blpv.a(paramContext, paramView, 0, paramObject, paramblpw, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxh
 * JD-Core Version:    0.7.0.1
 */