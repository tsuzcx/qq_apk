import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bhgi
  extends QQCustomDialog
{
  private int jdField_a_of_type_Int = 2131559031;
  bhjq jdField_a_of_type_Bhjq;
  
  public bhgi(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bhjq parambhjq, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambhjq == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bhjq = parambhjq;
      String[] arrayOfString = new String[parambhjq.a()];
      int i = 0;
      while (i < parambhjq.a())
      {
        arrayOfString[i] = parambhjq.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambhjq = parambhjq.a();
    } while (parambhjq == null);
    setTitle(parambhjq);
  }
  
  public int customWhichToCallBack(int paramInt)
  {
    bhjs localbhjs = this.jdField_a_of_type_Bhjq.a(paramInt);
    if (localbhjs != null) {
      return localbhjs.a();
    }
    return -1;
  }
  
  public int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhgi
 * JD-Core Version:    0.7.0.1
 */