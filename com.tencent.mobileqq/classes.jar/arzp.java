import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;

class arzp
  implements DialogInterface.OnClickListener
{
  arzp(arzk paramarzk, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      arzk.a(arzk.a(this.jdField_a_of_type_Arzk), "shareToQQ", arzk.a(this.jdField_a_of_type_Arzk), this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      ndq.a(arzk.a(this.jdField_a_of_type_Arzk), 0, "", "");
      if (arzk.a(this.jdField_a_of_type_Arzk) != null) {
        arzk.a(this.jdField_a_of_type_Arzk).b(1);
      }
      arzk.a(this.jdField_a_of_type_Arzk).moveTaskToBack(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzp
 * JD-Core Version:    0.7.0.1
 */