import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

public abstract class bkiq<T extends bkip>
{
  protected int a;
  public final View a;
  public T a;
  
  protected bkiq(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = a(paramContext, paramViewGroup);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      throw new NullPointerException("onCreateView can not return null");
    }
  }
  
  protected abstract View a(@NonNull Context paramContext, ViewGroup paramViewGroup);
  
  public void a()
  {
    this.jdField_a_of_type_Bkip = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(T paramT, int paramInt)
  {
    this.jdField_a_of_type_Bkip = paramT;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bkip != null) && (this.jdField_a_of_type_Bkip.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkiq
 * JD-Core Version:    0.7.0.1
 */