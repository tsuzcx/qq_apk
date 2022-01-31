import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bgmj
  implements DialogInterface.OnClickListener
{
  private String jdField_a_of_type_JavaLangString;
  
  private bgmj(bgmh parambgmh, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Bgmh.cancelInstall(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgmj
 * JD-Core Version:    0.7.0.1
 */