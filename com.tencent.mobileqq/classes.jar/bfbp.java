import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.agent.AgentActivity;

class bfbp
  implements DialogInterface.OnClickListener
{
  bfbp(bfbo parambfbo, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AgentActivity.a(this.jdField_a_of_type_Bfbo.a.a, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfbp
 * JD-Core Version:    0.7.0.1
 */