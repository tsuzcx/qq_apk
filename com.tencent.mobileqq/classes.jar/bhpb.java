import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bhpb
  extends bhpc
{
  private int jdField_a_of_type_Int = 2131558996;
  bhuk jdField_a_of_type_Bhuk;
  
  public bhpb(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bhuk parambhuk, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambhuk == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bhuk = parambhuk;
      String[] arrayOfString = new String[parambhuk.a()];
      int i = 0;
      while (i < parambhuk.a())
      {
        arrayOfString[i] = parambhuk.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambhuk = parambhuk.a();
    } while (parambhuk == null);
    setTitle(parambhuk);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    bhum localbhum = this.jdField_a_of_type_Bhuk.a(paramInt);
    if (localbhum != null) {
      return localbhum.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpb
 * JD-Core Version:    0.7.0.1
 */