import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class bkkv
{
  protected final int a;
  protected Context a;
  protected bkkw a;
  protected final String a;
  protected boolean a;
  protected final String b;
  protected boolean b;
  protected boolean c = true;
  
  public bkkv(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public abstract int a();
  
  public abstract int a(int paramInt);
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, View paramView);
  
  public void a(bkkw parambkkw)
  {
    this.jdField_a_of_type_Bkkw = parambkkw;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkkv
 * JD-Core Version:    0.7.0.1
 */