import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class bfgt
{
  public static final int[] a;
  public static final int[] b = { 2130839550, 2130839550, 2130839549 };
  public static final int[] c = { 2131379333, 2131379334, 2131379332 };
  protected bjty a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131697009, 2131697010, 2131697008 };
  }
  
  public final View a(Context paramContext, int paramInt, bjtz parambjtz)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Bjty == null) {
      this.jdField_a_of_type_Bjty = a(paramContext);
    }
    return this.jdField_a_of_type_Bjty.a(paramContext, localView, parambjtz, -1);
  }
  
  public bjty a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298791);
    int j = paramContext.getResources().getDimensionPixelSize(2131298792);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = b;
    return new bfgu(this, 3, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  public void a(Context paramContext, View paramView, Object paramObject, bjtz parambjtz, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bjty != null) {
      this.jdField_a_of_type_Bjty.a(paramContext, paramView, 0, paramObject, parambjtz, paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfgt
 * JD-Core Version:    0.7.0.1
 */