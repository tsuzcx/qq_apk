import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bafa
  extends bafb
{
  private int jdField_a_of_type_Int = 2131493333;
  bakh jdField_a_of_type_Bakh;
  
  public bafa(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bakh parambakh, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambakh == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bakh = parambakh;
      String[] arrayOfString = new String[parambakh.a()];
      int i = 0;
      while (i < parambakh.a())
      {
        arrayOfString[i] = parambakh.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambakh = parambakh.a();
    } while (parambakh == null);
    setTitle(parambakh);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    bakj localbakj = this.jdField_a_of_type_Bakh.a(paramInt);
    if (localbakj != null) {
      return localbakj.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafa
 * JD-Core Version:    0.7.0.1
 */