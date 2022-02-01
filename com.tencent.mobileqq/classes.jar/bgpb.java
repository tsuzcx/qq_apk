import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class bgpb
{
  public static final int[] a;
  public static final int[] b = { 2130839571, 2130839571, 2130839570 };
  public static final int[] c = { 2131379637, 2131379638, 2131379636 };
  protected blfk a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131697283, 2131697284, 2131697282 };
  }
  
  public final View a(Context paramContext, int paramInt, blfl paramblfl)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Blfk == null) {
      this.jdField_a_of_type_Blfk = a(paramContext);
    }
    return this.jdField_a_of_type_Blfk.a(paramContext, localView, paramblfl, -1);
  }
  
  public blfk a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298795);
    int j = paramContext.getResources().getDimensionPixelSize(2131298796);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new bgpc(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, blfl paramblfl, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Blfk != null) {
      this.jdField_a_of_type_Blfk.a(paramContext, paramView, 0, paramObject, paramblfl, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpb
 * JD-Core Version:    0.7.0.1
 */