import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bdfp
  extends bdfq
{
  private int jdField_a_of_type_Int = 2131558931;
  bdkz jdField_a_of_type_Bdkz;
  
  public bdfp(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bdkz parambdkz, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambdkz == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bdkz = parambdkz;
      String[] arrayOfString = new String[parambdkz.a()];
      int i = 0;
      while (i < parambdkz.a())
      {
        arrayOfString[i] = parambdkz.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambdkz = parambdkz.a();
    } while (parambdkz == null);
    setTitle(parambdkz);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    bdlb localbdlb = this.jdField_a_of_type_Bdkz.a(paramInt);
    if (localbdlb != null) {
      return localbdlb.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfp
 * JD-Core Version:    0.7.0.1
 */