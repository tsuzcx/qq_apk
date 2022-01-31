import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bbgf
  extends bbgg
{
  private int jdField_a_of_type_Int = 2131558894;
  bblr jdField_a_of_type_Bblr;
  
  public bbgf(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bblr parambblr, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambblr == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bblr = parambblr;
      String[] arrayOfString = new String[parambblr.a()];
      int i = 0;
      while (i < parambblr.a())
      {
        arrayOfString[i] = parambblr.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambblr = parambblr.a();
    } while (parambblr == null);
    setTitle(parambblr);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    bblt localbblt = this.jdField_a_of_type_Bblr.a(paramInt);
    if (localbblt != null) {
      return localbblt.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgf
 * JD-Core Version:    0.7.0.1
 */