import android.content.Context;
import android.content.DialogInterface.OnClickListener;

public class bbgt
  extends bbgu
{
  private int jdField_a_of_type_Int = 2131558894;
  bbmf jdField_a_of_type_Bbmf;
  
  public bbgt(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(bbmf parambbmf, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (parambbmf == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bbmf = parambbmf;
      String[] arrayOfString = new String[parambbmf.a()];
      int i = 0;
      while (i < parambbmf.a())
      {
        arrayOfString[i] = parambbmf.a(i).a();
        i += 1;
      }
      setItems(arrayOfString, paramOnClickListener);
      parambbmf = parambbmf.a();
    } while (parambbmf == null);
    setTitle(parambbmf);
  }
  
  protected int customWhichToCallBack(int paramInt)
  {
    bbmh localbbmh = this.jdField_a_of_type_Bbmf.a(paramInt);
    if (localbbmh != null) {
      return localbbmh.a();
    }
    return -1;
  }
  
  protected int getDialogListItemLayout()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgt
 * JD-Core Version:    0.7.0.1
 */