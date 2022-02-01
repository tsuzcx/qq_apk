import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bgoz
  extends bgpa
{
  private int jdField_a_of_type_Int = 2131558997;
  bguh jdField_a_of_type_Bguh;
  
  public bgoz(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bguh parambguh, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambguh == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bguh = parambguh;
      String[] arrayOfString = new String[parambguh.a()];
      int i = 0;
      while (i < parambguh.a())
      {
        arrayOfString[i] = parambguh.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambguh = parambguh.a();
    } while (parambguh == null);
    setTitle(parambguh);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    bguj localbguj = this.jdField_a_of_type_Bguh.a(paramInt);
    if (localbguj != null) {
      return localbguj.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgoz
 * JD-Core Version:    0.7.0.1
 */