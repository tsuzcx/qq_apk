import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bdjy
  extends bdjz
{
  private int jdField_a_of_type_Int = 2131558930;
  bdpi jdField_a_of_type_Bdpi;
  
  public bdjy(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bdpi parambdpi, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambdpi == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bdpi = parambdpi;
      String[] arrayOfString = new String[parambdpi.a()];
      int i = 0;
      while (i < parambdpi.a())
      {
        arrayOfString[i] = parambdpi.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambdpi = parambdpi.a();
    } while (parambdpi == null);
    setTitle(parambdpi);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    bdpk localbdpk = this.jdField_a_of_type_Bdpi.a(paramInt);
    if (localbdpk != null) {
      return localbdpk.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjy
 * JD-Core Version:    0.7.0.1
 */