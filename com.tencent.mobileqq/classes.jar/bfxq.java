import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bfxq
  extends QQCustomDialog
{
  private int jdField_a_of_type_Int = 2131559004;
  bgaz jdField_a_of_type_Bgaz;
  
  public bfxq(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bgaz parambgaz, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambgaz == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bgaz = parambgaz;
      String[] arrayOfString = new String[parambgaz.a()];
      int i = 0;
      while (i < parambgaz.a())
      {
        arrayOfString[i] = parambgaz.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambgaz = parambgaz.a();
    } while (parambgaz == null);
    setTitle(parambgaz);
  }
  
  public int customWhichToCallBack(int paramInt)
  {
    bgbb localbgbb = this.jdField_a_of_type_Bgaz.a(paramInt);
    if (localbgbb != null) {
      return localbgbb.a();
    }
    return -1;
  }
  
  public int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxq
 * JD-Core Version:    0.7.0.1
 */